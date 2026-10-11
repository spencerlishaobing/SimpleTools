/* ===== 数据导入导出（v0.30.0）：一键备份 / 恢复全部用户数据与应用配置（ZIP / 文件夹） =====
 * - 导出：当前数据目录的 4 个数据文件 + 默认目录的 settings.json，输出为 ZIP 压缩包或文件夹
 *   （输出路径由前端生成——含时间戳的输出文件名 / 子文件夹名，Rust 侧不做时间处理）
 * - 导入：从 ZIP / 文件夹按白名单读取文件；导入前把将被覆盖的现有文件自动备份到
 *   「目标数据目录 / import-backup-时间戳 /」；导入包内 settings.json 的自定义数据目录
 *   不存在时回退默认目录（避免换机导入后数据"消失"），回退结果返回前端提示
 * - 账号密码密文由 DPAPI 与当前 Windows 用户绑定：跨用户 / 跨机导入只能恢复其余数据
 *   （前端确认弹窗中说明；Rust 侧不阻断，照常导入文件）
 */
use crate::datadir::{self, AppSettings};
use serde::Serialize;
use std::fs;
use std::io::{Read, Write};
use std::path::{Path, PathBuf};
use tauri::AppHandle;
use zip::write::SimpleFileOptions;
use zip::{CompressionMethod, ZipArchive, ZipWriter};

/// 应用配置文件（固定默认目录，与 datadir::settings_path 对应）
const SETTINGS_FILE: &str = "settings.json";

/// 导出结果：path = 实际输出位置（ZIP 文件或导出文件夹），files = 已导出文件名
#[derive(Debug, Clone, Serialize)]
pub struct ExportResult {
    pub path: String,
    pub files: Vec<String>,
}

/// 导入结果：imported = 已写入的文件名，backup = 自动备份文件夹（无被覆盖文件时为 null），
/// data_dir = 生效的数据目录，fallback = 备份中的存储位置不可用、已回退默认目录
#[derive(Debug, Clone, Serialize)]
pub struct ImportResult {
    pub imported: Vec<String>,
    pub backup: Option<String>,
    pub data_dir: String,
    pub fallback: bool,
}

/// 允许出现在备份中的文件名（4 个数据文件 + 应用配置）
fn allowed_names() -> Vec<&'static str> {
    let mut names = datadir::DATA_FILES.to_vec();
    names.push(SETTINGS_FILE);
    names
}

/// 收集来源（文件夹或 ZIP 文件）中的已知文件（文件名 → 内容），忽略无关条目
fn collect_source_files(source: &Path) -> Result<Vec<(String, Vec<u8>)>, String> {
    if source.is_dir() {
        collect_from_dir(source)
    } else if source.is_file() {
        collect_from_zip(source)
    } else {
        Err("导入来源不存在".into())
    }
}

/// 从文件夹收集白名单文件（不递归；仅平铺的已知文件名）
fn collect_from_dir(dir: &Path) -> Result<Vec<(String, Vec<u8>)>, String> {
    let mut files = Vec::new();
    for name in allowed_names() {
        let p = dir.join(name);
        if p.is_file() {
            let bytes = fs::read(&p).map_err(|e| format!("读取 {name} 失败: {e}"))?;
            files.push((name.to_string(), bytes));
        }
    }
    Ok(files)
}

/// 从 ZIP 收集白名单文件：仅接受平铺的纯文件名条目（拒绝含路径分隔符的条目，防 zip-slip）
fn collect_from_zip(path: &Path) -> Result<Vec<(String, Vec<u8>)>, String> {
    let file = fs::File::open(path).map_err(|e| format!("打开备份文件失败: {e}"))?;
    let mut archive = ZipArchive::new(file).map_err(|e| format!("读取压缩包失败: {e}"))?;
    let allowed = allowed_names();
    let mut files: Vec<(String, Vec<u8>)> = Vec::new();
    for i in 0..archive.len() {
        let mut entry = archive
            .by_index(i)
            .map_err(|e| format!("读取压缩包条目失败: {e}"))?;
        if entry.is_dir() {
            continue;
        }
        let name = entry.name().to_string();
        if name.contains('/') || name.contains('\\') || !allowed.contains(&name.as_str()) {
            continue;
        }
        if files.iter().any(|(n, _)| *n == name) {
            continue; // 重复条目只取第一个
        }
        let mut buf = Vec::new();
        entry
            .read_to_end(&mut buf)
            .map_err(|e| format!("读取 {name} 失败: {e}"))?;
        files.push((name, buf));
    }
    Ok(files)
}

/// 原子写文件（先写 .tmp 再重命名覆盖，避免写入中断损坏文件）
fn write_atomic(path: &Path, bytes: &[u8]) -> Result<(), String> {
    if let Some(parent) = path.parent() {
        fs::create_dir_all(parent).map_err(|e| format!("创建目录失败: {e}"))?;
    }
    let base = path.file_name().and_then(|s| s.to_str()).unwrap_or("data");
    let tmp = path.with_file_name(format!("{base}.tmp"));
    fs::write(&tmp, bytes).map_err(|e| format!("写入失败: {e}"))?;
    fs::rename(&tmp, path).map_err(|e| format!("保存失败: {e}"))
}

/// 写 ZIP 压缩包（同样先写临时文件再重命名，避免中断留下损坏文件）
fn write_zip(files: &[(String, Vec<u8>)], dest: &Path) -> Result<(), String> {
    if let Some(parent) = dest.parent() {
        if !parent.as_os_str().is_empty() {
            fs::create_dir_all(parent).map_err(|e| format!("创建目录失败: {e}"))?;
        }
    }
    let base = dest
        .file_name()
        .and_then(|s| s.to_str())
        .unwrap_or("backup.zip");
    let tmp = dest.with_file_name(format!("{base}.tmp"));
    {
        let file = fs::File::create(&tmp).map_err(|e| format!("创建文件失败: {e}"))?;
        let mut zip = ZipWriter::new(file);
        let options = SimpleFileOptions::default().compression_method(CompressionMethod::Deflated);
        for (name, bytes) in files {
            zip.start_file(name.as_str(), options)
                .map_err(|e| format!("写入压缩包失败: {e}"))?;
            zip.write_all(bytes)
                .map_err(|e| format!("写入 {name} 失败: {e}"))?;
        }
        zip.finish().map_err(|e| format!("完成压缩包失败: {e}"))?;
    }
    fs::rename(&tmp, dest).map_err(|e| format!("保存失败: {e}"))
}

/// 一键导出：dest 为 ZIP 文件路径（format="zip"）或导出文件夹路径（format="dir"）
#[tauri::command]
pub fn data_export(app: AppHandle, dest: String, format: String) -> Result<ExportResult, String> {
    if format != "zip" && format != "dir" {
        return Err("未知的导出格式".into());
    }
    let dest_trim = dest.trim();
    if dest_trim.is_empty() {
        return Err("导出位置为空".into());
    }
    let dest = PathBuf::from(dest_trim);
    let current = datadir::data_dir(&app)?;
    let default = datadir::default_dir(&app)?;

    // 收集现有文件：4 个数据文件（当前数据目录）+ settings.json（固定默认目录）
    let mut files: Vec<(String, Vec<u8>)> = Vec::new();
    for name in datadir::DATA_FILES {
        let p = current.join(name);
        if p.is_file() {
            files.push((
                name.to_string(),
                fs::read(&p).map_err(|e| format!("读取 {name} 失败: {e}"))?,
            ));
        }
    }
    let sp = default.join(SETTINGS_FILE);
    if sp.is_file() {
        files.push((
            SETTINGS_FILE.to_string(),
            fs::read(&sp).map_err(|e| format!("读取 {SETTINGS_FILE} 失败: {e}"))?,
        ));
    }
    if files.is_empty() {
        return Err("没有可导出的数据（尚未生成任何数据文件）".into());
    }

    if format == "zip" {
        write_zip(&files, &dest)?;
    } else {
        fs::create_dir_all(&dest).map_err(|e| format!("创建导出文件夹失败: {e}"))?;
        for (name, bytes) in &files {
            write_atomic(&dest.join(name), bytes)?;
        }
    }
    Ok(ExportResult {
        path: datadir::display_path(&dest),
        files: files.into_iter().map(|(n, _)| n).collect(),
    })
}

/// 解析导入包中的应用设置 →（目标数据目录, 要写入的 settings（None = 不写）, 是否回退默认）
/// - 无 settings.json：目标 = 当前数据目录，不写配置
/// - data_dir 为空：目标 = 默认目录
/// - data_dir 存在：目标 = 该目录（同机恢复）
/// - data_dir 不存在：回退默认目录（写回空 data_dir），避免换机导入后指向无效路径
fn resolve_import_target(
    settings_bytes: Option<&[u8]>,
    default_dir: &Path,
    current_dir: &Path,
) -> Result<(PathBuf, Option<AppSettings>, bool), String> {
    let Some(bytes) = settings_bytes else {
        return Ok((current_dir.to_path_buf(), None, false));
    };
    let parsed: AppSettings =
        serde_json::from_slice(bytes).map_err(|e| format!("备份中的应用设置解析失败: {e}"))?;
    let custom = parsed.data_dir.trim();
    if custom.is_empty() {
        return Ok((default_dir.to_path_buf(), Some(AppSettings::default()), false));
    }
    let custom_path = PathBuf::from(custom);
    if custom_path.is_dir() {
        Ok((
            custom_path,
            Some(AppSettings {
                data_dir: custom.to_string(),
            }),
            false,
        ))
    } else {
        Ok((default_dir.to_path_buf(), Some(AppSettings::default()), true))
    }
}

/// 一键导入：source 为 ZIP 文件或文件夹路径；backup_name 为自动备份文件夹名（前端带时间戳生成）
#[tauri::command]
pub fn data_import(
    app: AppHandle,
    source: String,
    backup_name: String,
) -> Result<ImportResult, String> {
    let source_trim = source.trim();
    if source_trim.is_empty() {
        return Err("导入来源为空".into());
    }
    let source_path = PathBuf::from(source_trim);
    if !source_path.exists() {
        return Err("导入来源不存在".into());
    }
    // 备份文件夹名仅允许纯文件名（防越权写入其他位置）
    let backup_name = backup_name.trim().to_string();
    if backup_name.is_empty()
        || backup_name.contains('/')
        || backup_name.contains('\\')
        || backup_name == "."
        || backup_name == ".."
    {
        return Err("备份文件夹名非法".into());
    }

    let default = datadir::default_dir(&app)?;
    let current = datadir::data_dir(&app)?;
    let files = collect_source_files(&source_path)?;
    if files.is_empty() {
        return Err("未找到可导入的数据文件（备份中应包含 notes / accounts / history 等已知文件）".into());
    }

    let settings_bytes = files
        .iter()
        .find(|(n, _)| n == SETTINGS_FILE)
        .map(|(_, b)| b.as_slice());
    let (target, settings_out, fallback) = resolve_import_target(settings_bytes, &default, &current)?;

    // 自动备份：目标目录中将被覆盖的现有数据文件 + 默认目录中的 settings.json（导入包含它时）
    let mut to_backup: Vec<(PathBuf, String)> = Vec::new();
    for name in datadir::DATA_FILES {
        let p = target.join(name);
        if p.is_file() {
            to_backup.push((p, name.to_string()));
        }
    }
    if settings_out.is_some() {
        let sp = default.join(SETTINGS_FILE);
        if sp.is_file() {
            to_backup.push((sp, SETTINGS_FILE.to_string()));
        }
    }
    let mut backup: Option<String> = None;
    if !to_backup.is_empty() {
        let backup_dir = target.join(&backup_name);
        fs::create_dir_all(&backup_dir).map_err(|e| format!("创建备份文件夹失败: {e}"))?;
        for (src, name) in &to_backup {
            fs::copy(src, backup_dir.join(name)).map_err(|e| format!("备份 {name} 失败: {e}"))?;
        }
        backup = Some(datadir::display_path(&backup_dir));
    }

    // 写入：数据文件落到目标数据目录（未包含的文件保留不动）；settings.json 写默认目录
    let mut imported: Vec<String> = Vec::new();
    for (name, bytes) in &files {
        if name == SETTINGS_FILE {
            continue;
        }
        write_atomic(&target.join(name), bytes)?;
        imported.push(name.clone());
    }
    if let Some(settings) = &settings_out {
        datadir::write_settings(&default, settings)?;
        imported.push(SETTINGS_FILE.to_string());
    }

    Ok(ImportResult {
        imported,
        backup,
        data_dir: datadir::display_path(&target),
        fallback,
    })
}

#[cfg(test)]
mod tests {
    use super::*;

    /// 每个测试使用独立的临时目录，避免相互干扰
    fn test_dir(name: &str) -> PathBuf {
        let p = std::env::temp_dir().join(format!("simpletools_backup_test_{name}"));
        let _ = fs::remove_dir_all(&p);
        fs::create_dir_all(&p).expect("创建测试目录");
        p
    }

    /// ZIP 往返：写出后能按白名单读回，内容一致
    #[test]
    fn zip_roundtrip() {
        let dir = test_dir("zip_roundtrip");
        let dest = dir.join("backup.zip");
        let files = vec![
            ("notes.json".to_string(), b"[{\"id\":\"n1\"}]".to_vec()),
            (
                "settings.json".to_string(),
                b"{\"data_dir\":\"\"}".to_vec(),
            ),
        ];
        write_zip(&files, &dest).expect("写 ZIP");
        let back = collect_from_zip(&dest).expect("读 ZIP");
        assert_eq!(back.len(), 2);
        assert_eq!(
            back.iter().find(|(n, _)| n == "notes.json").unwrap().1,
            b"[{\"id\":\"n1\"}]"
        );
        assert_eq!(
            back.iter().find(|(n, _)| n == "settings.json").unwrap().1,
            b"{\"data_dir\":\"\"}"
        );
        let _ = fs::remove_dir_all(&dir);
    }

    /// 读取 ZIP 时过滤：路径穿越条目 / 子目录条目 / 未知文件名一律忽略
    #[test]
    fn zip_skips_unsafe_and_unknown_entries() {
        let dir = test_dir("zip_filter");
        let dest = dir.join("evil.zip");
        {
            let f = fs::File::create(&dest).unwrap();
            let mut zip = ZipWriter::new(f);
            let opt = SimpleFileOptions::default();
            for name in ["../notes.json", "sub/notes.json", "unknown.txt", "notes.json"] {
                zip.start_file(name, opt).unwrap();
                zip.write_all(b"x").unwrap();
            }
            zip.finish().unwrap();
        }
        let back = collect_from_zip(&dest).expect("读 ZIP");
        assert_eq!(back.len(), 1);
        assert_eq!(back[0].0, "notes.json");
        let _ = fs::remove_dir_all(&dir);
    }

    /// 文件夹收集：仅白名单平铺文件，忽略其他文件与同名目录
    #[test]
    fn dir_collect_filters_unknown() {
        let dir = test_dir("dir_collect");
        fs::write(dir.join("notes.json"), "hello").unwrap();
        fs::write(dir.join("unknown.txt"), "x").unwrap();
        fs::create_dir_all(dir.join("history.json.d")).unwrap();
        let back = collect_from_dir(&dir).expect("读目录");
        assert_eq!(back.len(), 1);
        assert_eq!(back[0].0, "notes.json");
        let _ = fs::remove_dir_all(&dir);
    }

    /// 导入目标解析：无 settings → 当前目录；空 data_dir → 默认；存在 → 自定义；不存在 → 回退默认
    #[test]
    fn resolve_target_variants() {
        let default = test_dir("resolve_default");
        let current = test_dir("resolve_current");
        // 无 settings.json
        let (t, s, fb) = resolve_import_target(None, &default, &current).unwrap();
        assert_eq!(t, current);
        assert!(s.is_none() && !fb);
        // data_dir 为空
        let (t, s, fb) =
            resolve_import_target(Some(b"{\"data_dir\":\"\"}"), &default, &current).unwrap();
        assert_eq!(t, default);
        assert!(s.unwrap().data_dir.is_empty() && !fb);
        // data_dir 指向已存在目录（同机恢复）
        let custom = test_dir("resolve_exist");
        let json =
            serde_json::to_vec(&AppSettings { data_dir: custom.display().to_string() }).unwrap();
        let (t, s, fb) = resolve_import_target(Some(&json), &default, &current).unwrap();
        assert_eq!(t, custom);
        assert!(!fb && s.is_some());
        // data_dir 指向不存在目录（换机场景）→ 回退默认
        let missing = default.join("no_such_sub");
        let json2 =
            serde_json::to_vec(&AppSettings { data_dir: missing.display().to_string() }).unwrap();
        let (t, s, fb) = resolve_import_target(Some(&json2), &default, &current).unwrap();
        assert_eq!(t, default);
        assert!(fb && s.unwrap().data_dir.is_empty());
        // 损坏的 JSON → 报错（不盲目写入）
        assert!(resolve_import_target(Some(b"{ not-json"), &default, &current).is_err());
        let _ = fs::remove_dir_all(&default);
        let _ = fs::remove_dir_all(&current);
        let _ = fs::remove_dir_all(&custom);
    }

    /// 原子写入：覆盖已存在文件且无 .tmp 残留
    #[test]
    fn write_atomic_overwrites() {
        let dir = test_dir("atomic");
        let p = dir.join("notes.json");
        fs::write(&p, "old").unwrap();
        write_atomic(&p, b"new").unwrap();
        assert_eq!(fs::read_to_string(&p).unwrap(), "new");
        assert!(!dir.join("notes.json.tmp").exists());
        let _ = fs::remove_dir_all(&dir);
    }
}
