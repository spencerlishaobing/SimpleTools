/* ===== 数据导入导出（v0.30.0）：一键备份 / 恢复全部用户数据与应用配置（ZIP / 文件夹） =====
 * - 导出：当前数据目录的 4 个数据文件 + 默认目录的 settings.json，输出为 ZIP 压缩包或文件夹
 *   （输出路径由前端生成——含时间戳的输出文件名 / 子文件夹名，Rust 侧不做时间处理）
 * - 导入：从 ZIP / 文件夹按白名单读取文件；导入前把将被覆盖的现有文件自动备份到
 *   「目标数据目录 / import-backup-时间戳 /」；导入包内 settings.json 的自定义数据目录
 *   不存在时回退默认目录（避免换机导入后数据"消失"），回退结果返回前端提示
 * - 合并导入（v0.32.0）：data_import_prepare 只读解析备份（notes / accounts 解密 / history）
 *   交给前端内存合并，data_merge_write 先备份当前数据再整体落盘（accounts 重新 DPAPI 加密）；
 *   合并目标固定为当前数据目录，备份中的 settings.json 不参与合并
 * - 数据恢复（v0.32.0）：data_backup_list 列出数据目录下的 import-backup-* 自动备份；
 *   data_restore 把所选备份按白名单覆盖回当前数据（不生成新备份——恢复本身即回退操作）
 * - 账号密码密文由 DPAPI 与当前 Windows 用户绑定：跨用户 / 跨机导入只能恢复其余数据
 *   （前端确认弹窗中说明；Rust 侧不阻断，照常导入文件）
 */
use crate::datadir::{self, AppSettings};
use serde::Serialize;
use serde_json::Value;
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

/// 自动备份条目（数据恢复列表项）：files = 备份内包含的白名单文件，size = 文件总字节数
#[derive(Debug, Clone, Serialize)]
pub struct BackupInfo {
    pub name: String,
    pub files: Vec<String>,
    pub size: u64,
}

/// 合并导入准备结果：备份中解析出的明文数据（None = 该文件缺失或无法解析）。
/// accounts 已在后端完成 DPAPI 解密，前端合并后由 data_merge_write 重新加密落盘
#[derive(Debug, Clone, Serialize)]
pub struct ImportPrepareResult {
    pub notes: Option<Value>,
    pub accounts: Option<Value>,
    pub history: Option<Value>,
    pub warnings: Vec<String>,
    pub data_dir: String,
}

/// 合并导入写入结果：written = 已写入文件名，backup = 自动备份文件夹（无可备份文件时为 null）
#[derive(Debug, Clone, Serialize)]
pub struct MergeWriteResult {
    pub written: Vec<String>,
    pub backup: Option<String>,
    pub data_dir: String,
}

/// 数据恢复结果：restored = 已恢复的文件名，data_dir = 数据目录
#[derive(Debug, Clone, Serialize)]
pub struct RestoreResult {
    pub restored: Vec<String>,
    pub data_dir: String,
}

/// 允许出现在备份中的文件名（4 个数据文件 + 应用配置）
fn allowed_names() -> Vec<&'static str> {
    let mut names = datadir::DATA_FILES.to_vec();
    names.push(SETTINGS_FILE);
    names
}

/// 校验备份文件夹名：仅允许纯文件名（防越权写入 / 遍历其他位置）
fn validate_backup_name(name: &str) -> Result<String, String> {
    let name = name.trim().to_string();
    if name.is_empty()
        || name.contains('/')
        || name.contains('\\')
        || name == "."
        || name == ".."
    {
        return Err("备份文件夹名非法".into());
    }
    Ok(name)
}

/// 备份「target 中将被覆盖的现有数据文件」+（可选）settings_src 中的 settings.json
/// 到「target / backup_name /」；返回备份文件夹展示路径（没有文件可备份时为 None）
fn backup_existing_files(
    target: &Path,
    settings_src: Option<&Path>,
    backup_name: &str,
) -> Result<Option<String>, String> {
    let mut to_backup: Vec<(PathBuf, String)> = Vec::new();
    for name in datadir::DATA_FILES {
        let p = target.join(name);
        if p.is_file() {
            to_backup.push((p, name.to_string()));
        }
    }
    if let Some(dir) = settings_src {
        let sp = dir.join(SETTINGS_FILE);
        if sp.is_file() {
            to_backup.push((sp, SETTINGS_FILE.to_string()));
        }
    }
    if to_backup.is_empty() {
        return Ok(None);
    }
    let backup_dir = target.join(backup_name);
    fs::create_dir_all(&backup_dir).map_err(|e| format!("创建备份文件夹失败: {e}"))?;
    for (src, name) in &to_backup {
        fs::copy(src, backup_dir.join(name)).map_err(|e| format!("备份 {name} 失败: {e}"))?;
    }
    Ok(Some(datadir::display_path(&backup_dir)))
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
    let backup_name = validate_backup_name(&backup_name)?;

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
    let settings_src = if settings_out.is_some() { Some(default.as_path()) } else { None };
    let backup = backup_existing_files(&target, settings_src, &backup_name)?;

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

/// 扫描数据目录下的自动备份文件夹（import-backup-*）：按名称倒序（名称含时间戳，新备份在前）；
/// 不含白名单文件的空目录不展示
fn scan_backups(dir: &Path) -> Result<Vec<BackupInfo>, String> {
    let mut list = Vec::new();
    let entries = fs::read_dir(dir).map_err(|e| format!("读取数据目录失败: {e}"))?;
    for entry in entries.flatten() {
        let name = entry.file_name().to_string_lossy().to_string();
        if !name.starts_with("import-backup-") || !entry.path().is_dir() {
            continue;
        }
        let mut files = Vec::new();
        let mut size = 0u64;
        for fname in allowed_names() {
            let p = entry.path().join(fname);
            if p.is_file() {
                size += fs::metadata(&p).map(|m| m.len()).unwrap_or(0);
                files.push(fname.to_string());
            }
        }
        if files.is_empty() {
            continue;
        }
        list.push(BackupInfo { name, files, size });
    }
    list.sort_by(|a, b| b.name.cmp(&a.name));
    Ok(list)
}

/// 数据恢复：列出数据目录下的自动备份（「导入数据」前自动生成）
#[tauri::command]
pub fn data_backup_list(app: AppHandle) -> Result<Vec<BackupInfo>, String> {
    let current = datadir::data_dir(&app)?;
    if !current.is_dir() {
        return Ok(Vec::new());
    }
    scan_backups(&current)
}

/// 解析备份文件为合并用明文数据（notes / history 直接解析；accounts 先 DPAPI 解密，
/// 兼容旧版明文）。单个文件解析失败时跳过并记入 warnings，不阻断其余文件的合并
fn parse_import_data(
    files: &[(String, Vec<u8>)],
) -> (Option<Value>, Option<Value>, Option<Value>, Vec<String>) {
    use crate::{accounts::AccountGroup, history::HistoryData, notes::Note};
    let mut warnings = Vec::new();
    let get = |n: &str| files.iter().find(|(name, _)| name == n).map(|(_, b)| b.as_slice());

    let notes = match get("notes.json") {
        Some(bytes) => match serde_json::from_slice::<Vec<Note>>(bytes) {
            Ok(v) => serde_json::to_value(v).ok(),
            Err(_) => {
                warnings.push("备份中的笔记数据无法解析，已跳过笔记合并".to_string());
                None
            }
        },
        None => None,
    };

    let accounts = match get("accounts.json") {
        Some(bytes) => {
            // 优先按 DPAPI 密文解密（同机备份）；失败时按旧版明文解析；再失败则跳过
            let text = match crate::winsec::dpapi_decrypt(bytes) {
                Ok(plain) => String::from_utf8(plain).ok(),
                Err(_) => String::from_utf8(bytes.to_vec()).ok(),
            };
            match text.and_then(|t| serde_json::from_str::<Vec<AccountGroup>>(&t).ok()) {
                Some(v) => serde_json::to_value(v).ok(),
                None => {
                    warnings.push(
                        "备份中的账号数据无法解密或解析（可能由其他 Windows 用户创建），已跳过账号合并"
                            .to_string(),
                    );
                    None
                }
            }
        }
        None => None,
    };

    let history = match get("history.json") {
        Some(bytes) => match serde_json::from_slice::<HistoryData>(bytes) {
            Ok(v) => serde_json::to_value(v).ok(),
            Err(_) => {
                warnings.push("备份中的历史记录无法解析，已跳过历史合并".to_string());
                None
            }
        },
        None => None,
    };

    (notes, accounts, history, warnings)
}

/// 合并导入第一步（v0.32.0）：只读解析备份为明文数据，交由前端与当前数据内存合并
#[tauri::command]
pub fn data_import_prepare(app: AppHandle, source: String) -> Result<ImportPrepareResult, String> {
    let source_trim = source.trim();
    if source_trim.is_empty() {
        return Err("导入来源为空".into());
    }
    let source_path = PathBuf::from(source_trim);
    if !source_path.exists() {
        return Err("导入来源不存在".into());
    }
    let files = collect_source_files(&source_path)?;
    if files.is_empty() {
        return Err("未找到可导入的数据文件（备份中应包含 notes / accounts / history 等已知文件）".into());
    }
    let (notes, accounts, history, warnings) = parse_import_data(&files);
    if notes.is_none() && accounts.is_none() && history.is_none() {
        let detail = if warnings.is_empty() {
            String::new()
        } else {
            format!("：{}", warnings.join("；"))
        };
        return Err(format!("备份中没有可合并的数据{detail}"));
    }
    let current = datadir::data_dir(&app)?;
    Ok(ImportPrepareResult {
        notes,
        accounts,
        history,
        warnings,
        data_dir: datadir::display_path(&current),
    })
}

/// 合并结果写盘：先全部校验 / 加密，再逐文件原子写入（任一项失败则整体不写，避免半写）。
/// accounts 校验后重新 DPAPI 加密（与 accounts_save 相同的落盘格式）
fn write_merged_files(
    current: &Path,
    notes: Option<&Value>,
    accounts: Option<&Value>,
    history: Option<&Value>,
) -> Result<Vec<String>, String> {
    use crate::{accounts::AccountGroup, history::HistoryData, notes::Note};
    let notes_data: Option<Vec<Note>> = match notes {
        Some(v) => Some(
            serde_json::from_value(v.clone())
                .map_err(|e| format!("合并后的笔记数据校验失败: {e}"))?,
        ),
        None => None,
    };
    let accounts_data: Option<Vec<AccountGroup>> = match accounts {
        Some(v) => Some(
            serde_json::from_value(v.clone())
                .map_err(|e| format!("合并后的账号数据校验失败: {e}"))?,
        ),
        None => None,
    };
    let history_data: Option<HistoryData> = match history {
        Some(v) => Some(
            serde_json::from_value(v.clone())
                .map_err(|e| format!("合并后的历史记录校验失败: {e}"))?,
        ),
        None => None,
    };
    let accounts_bytes: Option<Vec<u8>> = match &accounts_data {
        Some(v) => {
            let pretty =
                serde_json::to_string_pretty(v).map_err(|e| format!("序列化失败: {e}"))?;
            Some(crate::winsec::dpapi_encrypt(pretty.as_bytes())?)
        }
        None => None,
    };

    let mut written = Vec::new();
    if let Some(v) = &notes_data {
        let pretty = serde_json::to_string_pretty(v).map_err(|e| format!("序列化失败: {e}"))?;
        write_atomic(&current.join("notes.json"), pretty.as_bytes())?;
        written.push("notes.json".to_string());
    }
    if let Some(bytes) = &accounts_bytes {
        write_atomic(&current.join("accounts.json"), bytes)?;
        written.push("accounts.json".to_string());
    }
    if let Some(v) = &history_data {
        let pretty = serde_json::to_string_pretty(v).map_err(|e| format!("序列化失败: {e}"))?;
        write_atomic(&current.join("history.json"), pretty.as_bytes())?;
        written.push("history.json".to_string());
    }
    Ok(written)
}

/// 合并导入第二步（v0.32.0）：先自动备份当前数据，再把前端合并好的整体数据落盘。
/// 合并目标固定为「当前数据目录」——备份中的 settings.json 不参与合并（存储位置保持不变）
#[tauri::command]
pub fn data_merge_write(
    app: AppHandle,
    notes: Option<Value>,
    accounts: Option<Value>,
    history: Option<Value>,
    backup_name: String,
) -> Result<MergeWriteResult, String> {
    if notes.is_none() && accounts.is_none() && history.is_none() {
        return Err("没有可写入的合并数据".into());
    }
    let backup_name = validate_backup_name(&backup_name)?;
    let current = datadir::data_dir(&app)?;
    let backup = backup_existing_files(&current, None, &backup_name)?;
    let written = write_merged_files(&current, notes.as_ref(), accounts.as_ref(), history.as_ref())?;
    Ok(MergeWriteResult {
        written,
        backup,
        data_dir: datadir::display_path(&current),
    })
}

/// 从备份文件夹恢复：数据文件复制回数据目录、settings.json 复制回默认目录
/// （白名单，只复制存在的文件；恢复不生成新备份）
fn restore_from_backup(
    backup_dir: &Path,
    data_dir: &Path,
    default_dir: &Path,
) -> Result<Vec<String>, String> {
    let mut restored = Vec::new();
    for name in datadir::DATA_FILES {
        let src = backup_dir.join(name);
        if src.is_file() {
            fs::create_dir_all(data_dir).map_err(|e| format!("创建目录失败: {e}"))?;
            fs::copy(&src, data_dir.join(name)).map_err(|e| format!("恢复 {name} 失败: {e}"))?;
            restored.push(name.to_string());
        }
    }
    let sp = backup_dir.join(SETTINGS_FILE);
    if sp.is_file() {
        fs::create_dir_all(default_dir).map_err(|e| format!("创建目录失败: {e}"))?;
        fs::copy(&sp, default_dir.join(SETTINGS_FILE))
            .map_err(|e| format!("恢复应用设置失败: {e}"))?;
        restored.push(SETTINGS_FILE.to_string());
    }
    if restored.is_empty() {
        return Err("该备份中没有可恢复的数据文件".into());
    }
    Ok(restored)
}

/// 数据恢复（v0.32.0）：从自动备份覆盖当前数据。不生成新备份——恢复本身即回退操作
#[tauri::command]
pub fn data_restore(app: AppHandle, name: String) -> Result<RestoreResult, String> {
    let name = validate_backup_name(&name)?;
    if !name.starts_with("import-backup-") {
        return Err("仅支持恢复自动备份（import-backup-*）".into());
    }
    let current = datadir::data_dir(&app)?;
    let default = datadir::default_dir(&app)?;
    let backup_dir = current.join(&name);
    if !backup_dir.is_dir() {
        return Err("备份不存在或已被移除".into());
    }
    // 防御：备份目录必须位于当前数据目录内（canonicalize 后校验，杜绝符号链接等越权）
    let cur_canon = fs::canonicalize(&current).map_err(|e| format!("无法解析数据目录: {e}"))?;
    let bak_canon =
        fs::canonicalize(&backup_dir).map_err(|e| format!("无法解析备份目录: {e}"))?;
    if !bak_canon.starts_with(&cur_canon) {
        return Err("备份目录位置异常".into());
    }
    let restored = restore_from_backup(&backup_dir, &current, &default)?;
    Ok(RestoreResult {
        restored,
        data_dir: datadir::display_path(&current),
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

    /// 备份文件夹名校验：拒绝空 / 分隔符 / 上级目录引用（v0.32.0）
    #[test]
    fn backup_name_validation() {
        assert!(validate_backup_name("import-backup-20260101-000000").is_ok());
        for bad in ["", "  ", "a/b", "a\\b", ".", ".."] {
            assert!(validate_backup_name(bad).is_err(), "{bad:?} 应被拒绝");
        }
    }

    /// 备份列表：仅识别 import-backup-* 目录且含白名单文件，按名称倒序；含 settings.json 计入（v0.32.0）
    #[test]
    fn scan_backups_lists_sorted() {
        let dir = test_dir("scan_backups");
        fs::create_dir_all(dir.join("import-backup-20260101-000000")).unwrap();
        fs::write(dir.join("import-backup-20260101-000000/notes.json"), "abcde").unwrap();
        fs::create_dir_all(dir.join("import-backup-20260102-000000")).unwrap();
        fs::write(dir.join("import-backup-20260102-000000/history.json"), "{}").unwrap();
        fs::write(dir.join("import-backup-20260102-000000/settings.json"), "{\"a\":1}").unwrap();
        fs::create_dir_all(dir.join("import-backup-empty")).unwrap();
        fs::create_dir_all(dir.join("other-dir")).unwrap();
        fs::write(dir.join("random.txt"), "x").unwrap();
        let list = scan_backups(&dir).expect("扫描应成功");
        assert_eq!(list.len(), 2, "空备份 / 其他目录 / 普通文件不展示");
        assert_eq!(list[0].name, "import-backup-20260102-000000");
        assert_eq!(list[1].name, "import-backup-20260101-000000");
        assert_eq!(list[0].files.len(), 2);
        assert_eq!(list[0].size, 2 + 7);
        assert_eq!(list[1].size, 5);
        let _ = fs::remove_dir_all(&dir);
    }

    /// 恢复：白名单文件复制回数据目录 / settings.json 回默认目录；未知文件不动；空备份报错（v0.32.0）
    #[test]
    fn restore_copies_whitelist() {
        let data = test_dir("restore_data");
        let def = test_dir("restore_def");
        let bak = test_dir("restore_bak");
        fs::write(bak.join("notes.json"), "NEW-N").unwrap();
        fs::write(bak.join("accounts.json"), "NEW-A").unwrap();
        fs::write(bak.join("settings.json"), "{\"data_dir\":\"\"}").unwrap();
        fs::write(bak.join("unknown.txt"), "X").unwrap();
        let restored = restore_from_backup(&bak, &data, &def).expect("恢复应成功");
        assert_eq!(restored.len(), 3);
        assert_eq!(fs::read_to_string(data.join("notes.json")).unwrap(), "NEW-N");
        assert_eq!(fs::read_to_string(data.join("accounts.json")).unwrap(), "NEW-A");
        assert!(!data.join("unknown.txt").exists(), "未知文件不复制");
        assert!(!data.join("settings.json").exists(), "设置应写默认目录而非数据目录");
        assert_eq!(fs::read_to_string(def.join("settings.json")).unwrap(), "{\"data_dir\":\"\"}");
        // 空备份 → 报错（没有可恢复的文件）
        let empty = test_dir("restore_empty");
        assert!(restore_from_backup(&empty, &data, &def).is_err());
        let _ = fs::remove_dir_all(&data);
        let _ = fs::remove_dir_all(&def);
        let _ = fs::remove_dir_all(&bak);
        let _ = fs::remove_dir_all(&empty);
    }

    /// 合并准备解析：notes / history 直接解析；accounts 明文兼容；损坏文件跳过并警告（v0.32.0）
    #[test]
    fn parse_import_data_variants() {
        // 三个文件均可用（accounts 为旧版明文 JSON，DPAPI 解密失败后回退明文解析）
        let files = vec![
            (
                "notes.json".to_string(),
                br#"[{"id":"n1","title":"t","content":"c","updated_at":1}]"#.to_vec(),
            ),
            (
                "history.json".to_string(),
                br#"{"json":[{"id":"j1","input":"a","output":"b","time":1}],"diff":[],"md5":[],"str":[]}"#.to_vec(),
            ),
            (
                "accounts.json".to_string(),
                br#"[{"id":"g1","name":"G","items":[]}]"#.to_vec(),
            ),
        ];
        let (notes, accounts, history, warnings) = parse_import_data(&files);
        assert!(notes.is_some() && accounts.is_some() && history.is_some());
        assert!(warnings.is_empty(), "应无警告: {warnings:?}");
        // accounts 损坏（非法 UTF-8）→ 跳过 + 警告；其余仍解析
        let files2 = vec![
            (
                "notes.json".to_string(),
                br#"[{"id":"n1","title":"t","content":"c","updated_at":1}]"#.to_vec(),
            ),
            ("accounts.json".to_string(), vec![0xFF, 0xFE, 0xFD]),
        ];
        let (notes2, accounts2, history2, warnings2) = parse_import_data(&files2);
        assert!(notes2.is_some());
        assert!(accounts2.is_none() && history2.is_none());
        assert_eq!(warnings2.len(), 1);
        assert!(warnings2[0].contains("账号"));
        // notes 损坏 → 跳过 + 警告
        let files3 = vec![("notes.json".to_string(), b"not-json".to_vec())];
        let (notes3, _, _, warnings3) = parse_import_data(&files3);
        assert!(notes3.is_none() && warnings3.len() == 1);
    }

    /// 合并写盘：先校验后写入；accounts DPAPI 加密后可回读；校验失败整体不写（v0.32.0）
    #[test]
    fn write_merged_files_roundtrip() {
        let dir = test_dir("merge_write");
        let notes = serde_json::json!([{"id":"n1","title":"合并","content":"c","updated_at":1}]);
        let accounts = serde_json::json!([{"id":"g1","name":"G","items":[{"id":"i1","account":"a","password":"p","note":"","updated_at":1}]}]);
        let history = serde_json::json!({"json":[],"diff":[],"md5":[],"str":[]});
        let written =
            write_merged_files(&dir, Some(&notes), Some(&accounts), Some(&history)).expect("写盘");
        assert_eq!(written.len(), 3);
        // notes 明文回读
        let n: serde_json::Value =
            serde_json::from_str(&fs::read_to_string(dir.join("notes.json")).unwrap()).unwrap();
        assert_eq!(n[0]["title"], "合并");
        // accounts DPAPI 加密后可解密回读（与 accounts_load 相同路径）
        let raw = fs::read(dir.join("accounts.json")).unwrap();
        let plain = crate::winsec::dpapi_decrypt(&raw).expect("应能解密");
        let a: serde_json::Value = serde_json::from_slice(&plain).unwrap();
        assert_eq!(a[0]["name"], "G");
        // 结构错误（非数组）→ 报错且不写任何文件（字段缺省由 serde default 兼容，不再算错误）
        let bad = serde_json::json!({"not": "an-array"});
        assert!(write_merged_files(&dir, Some(&bad), None, None).is_err());
        let _ = fs::remove_dir_all(&dir);
    }

    /// 旧结构兼容（v0.32.0）：缺字段的旧版备份数据可合并写盘，写回后缺省字段按默认值补全
    /// （笔记缺 id / type / updated_at，账号缺 id / note，历史缺 id / time / kind）
    #[test]
    fn legacy_shapes_merge_and_write() {
        let dir = test_dir("legacy_merge");
        let notes = serde_json::json!([{"title":"旧笔记","content":"内容"}]);
        let accounts =
            serde_json::json!([{"name":"旧分组","items":[{"account":"a@b.c","password":"p"}]}]);
        let history = serde_json::json!({"json":[{"input":"a","output":"b"}]});
        let written = write_merged_files(&dir, Some(&notes), Some(&accounts), Some(&history))
            .expect("旧结构应能写盘");
        assert_eq!(written.len(), 3);
        // 笔记回读：缺省字段已按默认值补全
        let n: serde_json::Value =
            serde_json::from_str(&fs::read_to_string(dir.join("notes.json")).unwrap()).unwrap();
        assert_eq!(n[0]["title"], "旧笔记");
        assert_eq!(n[0]["id"], "");
        assert_eq!(n[0]["updated_at"], 0);
        assert_eq!(n[0]["type"], "text");
        // 账号解密回读：条目缺省字段补全
        let raw = fs::read(dir.join("accounts.json")).unwrap();
        let plain = crate::winsec::dpapi_decrypt(&raw).expect("应能解密");
        let a: serde_json::Value = serde_json::from_slice(&plain).unwrap();
        assert_eq!(a[0]["name"], "旧分组");
        assert_eq!(a[0]["items"][0]["note"], "");
        assert_eq!(a[0]["items"][0]["updated_at"], 0);
        // 历史回读：缺 time / id 补 0 / 空串
        let h: serde_json::Value =
            serde_json::from_str(&fs::read_to_string(dir.join("history.json")).unwrap()).unwrap();
        assert_eq!(h["json"][0]["input"], "a");
        assert_eq!(h["json"][0]["time"], 0);
        let _ = fs::remove_dir_all(&dir);
    }
}
