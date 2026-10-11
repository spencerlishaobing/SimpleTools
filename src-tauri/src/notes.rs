use serde::{Deserialize, Serialize};
use std::fs;
use std::path::PathBuf;
use tauri::{AppHandle, Manager};

/// 单条记事记录
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct Note {
    pub id: String,
    pub title: String,
    pub content: String,
    /// 最后更新时间（毫秒时间戳）
    pub updated_at: u64,
}

/// 记事本数据文件路径：{AppData}/com.simpletools.desktop/notes.json
fn notes_path(app: &AppHandle) -> Result<PathBuf, String> {
    let dir = app
        .path()
        .app_data_dir()
        .map_err(|e| format!("无法获取数据目录: {e}"))?;
    Ok(dir.join("notes.json"))
}

/// 读取全部记录（文件不存在时返回空列表）
#[tauri::command]
pub fn notes_load(app: AppHandle) -> Result<Vec<Note>, String> {
    let path = notes_path(&app)?;
    if !path.exists() {
        return Ok(Vec::new());
    }
    let data = fs::read_to_string(&path).map_err(|e| format!("读取失败: {e}"))?;
    if data.trim().is_empty() {
        return Ok(Vec::new());
    }
    serde_json::from_str(&data).map_err(|e| format!("解析失败: {e}"))
}

/// 全量保存记录（先写临时文件再重命名，避免写入中断损坏数据）
#[tauri::command]
pub fn notes_save(app: AppHandle, notes: Vec<Note>) -> Result<(), String> {
    let path = notes_path(&app)?;
    write_atomic(&path, &notes)
}

/// 手动备份：将当前数据复制一份到 notes.backup.json
#[tauri::command]
pub fn notes_backup(app: AppHandle) -> Result<String, String> {
    let path = notes_path(&app)?;
    if !path.exists() {
        return Err("暂无可备份的数据".into());
    }
    let backup = path.with_file_name("notes.backup.json");
    fs::copy(&path, &backup).map_err(|e| format!("备份失败: {e}"))?;
    Ok(backup.to_string_lossy().to_string())
}

fn write_atomic(path: &PathBuf, notes: &[Note]) -> Result<(), String> {
    if let Some(parent) = path.parent() {
        fs::create_dir_all(parent).map_err(|e| format!("创建目录失败: {e}"))?;
    }
    let data = serde_json::to_string_pretty(notes).map_err(|e| format!("序列化失败: {e}"))?;
    let tmp = path.with_extension("json.tmp");
    fs::write(&tmp, data).map_err(|e| format!("写入失败: {e}"))?;
    fs::rename(&tmp, path).map_err(|e| format!("保存失败: {e}"))?;
    Ok(())
}
