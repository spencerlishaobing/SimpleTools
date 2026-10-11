use serde::{Deserialize, Serialize};
use std::fs;
use std::path::{Path, PathBuf};
use tauri::{AppHandle, Manager};

/// 应用设置文件（v0.22.0）：固定存于默认数据目录下（settings.json），
/// 不随数据目录迁移，避免"配置保存位置又依赖配置"的循环依赖
#[derive(Debug, Clone, Default, Serialize, Deserialize)]
pub struct AppSettings {
    /// 自定义数据目录（空字符串 = 使用默认目录）
    #[serde(default)]
    pub data_dir: String,
}

/// 需要随数据目录迁移的数据文件（平铺在数据目录下）
const DATA_FILES: [&str; 4] = [
    "notes.json",
    "accounts.json",
    "history.json",
    "notes.backup.json",
];

/// 默认数据目录：{AppData}/com.simpletools.desktop
pub fn default_dir(app: &AppHandle) -> Result<PathBuf, String> {
    app.path()
        .app_data_dir()
        .map_err(|e| format!("无法获取数据目录: {e}"))
}

/// Windows canonicalize 会带 \\?\ 前缀，展示 / 存储时去掉
fn display_path(p: &Path) -> String {
    let s = p.to_string_lossy().to_string();
    s.strip_prefix(r"\\?\").map(|t| t.to_string()).unwrap_or(s)
}

fn settings_path(default_dir: &Path) -> PathBuf {
    default_dir.join("settings.json")
}

/// 读取应用设置（文件不存在 / 损坏时返回默认设置，不阻断应用运行）
fn read_settings(default_dir: &Path) -> AppSettings {
    let path = settings_path(default_dir);
    let Ok(data) = fs::read_to_string(&path) else {
        return AppSettings::default();
    };
    serde_json::from_str(&data).unwrap_or_default()
}

/// 写入应用设置（先写临时文件再重命名，避免写入中断损坏配置）
fn write_settings(default_dir: &Path, settings: &AppSettings) -> Result<(), String> {
    fs::create_dir_all(default_dir).map_err(|e| format!("创建目录失败: {e}"))?;
    let data = serde_json::to_string_pretty(settings).map_err(|e| format!("序列化失败: {e}"))?;
    let path = settings_path(default_dir);
    let tmp = path.with_extension("json.tmp");
    fs::write(&tmp, data).map_err(|e| format!("写入失败: {e}"))?;
    fs::rename(&tmp, &path).map_err(|e| format!("保存失败: {e}"))?;
    Ok(())
}

/// 当前生效的数据目录：settings.json 配置的自定义目录（有效时），否则默认目录
pub fn data_dir(app: &AppHandle) -> Result<PathBuf, String> {
    let default = default_dir(app)?;
    let settings = read_settings(&default);
    let custom = settings.data_dir.trim();
    if custom.is_empty() {
        return Ok(default);
    }
    let custom = PathBuf::from(custom);
    if custom.is_dir() {
        return Ok(custom);
    }
    // 目录被删除时尝试重建（盘符可用）；重建失败（如外接盘未接入）返回错误，
    // 避免静默回退默认目录造成"数据消失"的错觉
    match fs::create_dir_all(&custom) {
        Ok(_) => Ok(custom),
        Err(e) => Err(format!("数据目录不可用: {} ({e})", custom.display())),
    }
}

/// 数据目录信息（设置弹窗展示）
#[derive(Debug, Clone, Serialize)]
pub struct DataDirInfo {
    pub current: String,
    pub default: String,
    pub is_custom: bool,
}

/// 查询当前数据目录信息
#[tauri::command]
pub fn data_dir_info(app: AppHandle) -> Result<DataDirInfo, String> {
    let default = default_dir(&app)?;
    let is_custom = !read_settings(&default).data_dir.trim().is_empty();
    let current = data_dir(&app)?;
    Ok(DataDirInfo {
        current: display_path(&current),
        default: display_path(&default),
        is_custom,
    })
}

/// 迁移数据文件（逐个复制 + 逐文件大小校验；不删除源文件，原位置保留作为备份）
fn migrate_data_files(from: &Path, to: &Path) -> Result<usize, String> {
    let mut copied = 0usize;
    for name in DATA_FILES {
        let src = from.join(name);
        if !src.is_file() {
            continue;
        }
        let dst = to.join(name);
        fs::copy(&src, &dst).map_err(|e| format!("复制 {name} 失败: {e}"))?;
        let src_len = fs::metadata(&src)
            .map_err(|e| format!("读取 {name} 失败: {e}"))?
            .len();
        let dst_len = fs::metadata(&dst)
            .map_err(|e| format!("校验 {name} 失败: {e}"))?
            .len();
        if src_len != dst_len {
            return Err(format!("{name} 复制校验失败（大小不一致）"));
        }
        copied += 1;
    }
    Ok(copied)
}

/// 切换数据存储位置：把数据文件迁移到新目录并写入配置，返回新目录路径。
/// 迁移成功后才更新配置（失败时保持原位置不变）
#[tauri::command]
pub fn data_dir_set(app: AppHandle, dir: String) -> Result<String, String> {
    let default = default_dir(&app)?;
    let new_dir = PathBuf::from(dir.trim());
    if !new_dir.is_dir() {
        return Err("目标文件夹不存在".into());
    }
    let current = data_dir(&app)?;
    // 规范化比较（消除大小写 / 斜杠差异）；同一目录无需迁移
    let cur_canon = fs::canonicalize(&current).map_err(|e| format!("无法解析当前位置: {e}"))?;
    let new_canon = fs::canonicalize(&new_dir).map_err(|e| format!("无法解析新位置: {e}"))?;
    if cur_canon == new_canon {
        return Err("新位置与当前位置相同".into());
    }
    migrate_data_files(&current, &new_dir)?;
    // 新位置即默认目录时写空值（视为恢复默认）；否则记录自定义路径
    let def_canon = fs::canonicalize(&default).unwrap_or_else(|_| default.clone());
    let settings = if new_canon == def_canon {
        AppSettings::default()
    } else {
        AppSettings {
            data_dir: display_path(&new_canon),
        }
    };
    write_settings(&default, &settings)?;
    Ok(display_path(&new_canon))
}

#[cfg(test)]
mod tests {
    use super::{migrate_data_files, read_settings, write_settings, AppSettings};
    use std::fs;
    use std::path::PathBuf;

    /// 每个测试使用独立的临时目录，避免相互干扰
    fn test_dir(name: &str) -> PathBuf {
        let p = std::env::temp_dir().join(format!("simpletools_datadir_test_{name}"));
        let _ = fs::remove_dir_all(&p);
        fs::create_dir_all(&p).expect("创建测试目录");
        p
    }

    /// 迁移复制全部存在的数据文件，内容一致，且源文件保留（不删除）
    #[test]
    fn migrate_copies_files_and_keeps_source() {
        let from = test_dir("mig_from");
        let to = test_dir("mig_to");
        fs::write(from.join("notes.json"), r#"[{"id":"n1"}]"#).unwrap();
        fs::write(from.join("accounts.json"), "secret-bytes").unwrap();
        // history.json / notes.backup.json 不存在 → 跳过
        let copied = migrate_data_files(&from, &to).expect("迁移应成功");
        assert_eq!(copied, 2);
        assert_eq!(
            fs::read_to_string(to.join("notes.json")).unwrap(),
            r#"[{"id":"n1"}]"#
        );
        assert_eq!(
            fs::read_to_string(to.join("accounts.json")).unwrap(),
            "secret-bytes"
        );
        assert!(from.join("notes.json").exists(), "源文件应保留");
        assert!(from.join("accounts.json").exists(), "源文件应保留");
        let _ = fs::remove_dir_all(&from);
        let _ = fs::remove_dir_all(&to);
    }

    /// 源目录没有数据文件时迁移返回 0（仍然允许切换配置）
    #[test]
    fn migrate_with_no_files_returns_zero() {
        let from = test_dir("empty_from");
        let to = test_dir("empty_to");
        let copied = migrate_data_files(&from, &to).expect("空迁移应成功");
        assert_eq!(copied, 0);
        let _ = fs::remove_dir_all(&from);
        let _ = fs::remove_dir_all(&to);
    }

    /// 设置读写往返：自定义路径能正确保存与读回
    #[test]
    fn settings_roundtrip() {
        let dir = test_dir("settings");
        write_settings(
            &dir,
            &AppSettings {
                data_dir: r"D:\SimpleToolsData".into(),
            },
        )
        .expect("写入设置");
        let back = read_settings(&dir);
        assert_eq!(back.data_dir, r"D:\SimpleToolsData");
        let _ = fs::remove_dir_all(&dir);
    }

    /// settings.json 不存在 / 损坏时返回默认设置（空路径），不阻断应用
    #[test]
    fn settings_missing_or_broken_returns_default() {
        let dir = test_dir("settings_broken");
        assert_eq!(read_settings(&dir).data_dir, "");
        fs::write(dir.join("settings.json"), "{ not-valid-json").unwrap();
        assert_eq!(read_settings(&dir).data_dir, "");
        let _ = fs::remove_dir_all(&dir);
    }
}
