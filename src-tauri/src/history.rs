use serde::{Deserialize, Serialize};
use std::fs;
use std::path::PathBuf;
use tauri::{AppHandle, Manager};

/// 单条 JSON 格式化记录（input 为原始输入，output 为格式化/压缩结果）
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct JsonRecord {
    pub id: String,
    pub input: String,
    pub output: String,
    /// 记录时间（毫秒时间戳）
    pub time: u64,
}

/// 单条文本对比记录
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct DiffRecord {
    pub id: String,
    pub left: String,
    pub right: String,
    /// 记录时间（毫秒时间戳）
    pub time: u64,
}

/// 全部历史记录数据
#[derive(Debug, Clone, Default, Serialize, Deserialize)]
pub struct HistoryData {
    #[serde(default)]
    pub json: Vec<JsonRecord>,
    #[serde(default)]
    pub diff: Vec<DiffRecord>,
}

/// 历史数据文件路径：{AppData}/com.simpletools.desktop/history.json
fn history_path(app: &AppHandle) -> Result<PathBuf, String> {
    let dir = app
        .path()
        .app_data_dir()
        .map_err(|e| format!("无法获取数据目录: {e}"))?;
    Ok(dir.join("history.json"))
}

/// 读取全部历史记录（文件不存在时返回空数据）
#[tauri::command]
pub fn history_load(app: AppHandle) -> Result<HistoryData, String> {
    let path = history_path(&app)?;
    if !path.exists() {
        return Ok(HistoryData::default());
    }
    let data = fs::read_to_string(&path).map_err(|e| format!("读取失败: {e}"))?;
    if data.trim().is_empty() {
        return Ok(HistoryData::default());
    }
    serde_json::from_str(&data).map_err(|e| format!("解析失败: {e}"))
}

/// 全量保存历史记录（先写临时文件再重命名，避免写入中断损坏数据）
#[tauri::command]
pub fn history_save(app: AppHandle, data: HistoryData) -> Result<(), String> {
    let path = history_path(&app)?;
    write_atomic(&path, &data)
}

fn write_atomic(path: &PathBuf, data: &HistoryData) -> Result<(), String> {
    if let Some(parent) = path.parent() {
        fs::create_dir_all(parent).map_err(|e| format!("创建目录失败: {e}"))?;
    }
    let text = serde_json::to_string_pretty(data).map_err(|e| format!("序列化失败: {e}"))?;
    let tmp = path.with_extension("json.tmp");
    fs::write(&tmp, text).map_err(|e| format!("写入失败: {e}"))?;
    fs::rename(&tmp, path).map_err(|e| format!("保存失败: {e}"))?;
    Ok(())
}
