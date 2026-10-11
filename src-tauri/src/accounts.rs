use serde::{Deserialize, Serialize};
use std::fs;
use std::path::PathBuf;
use tauri::{AppHandle, Manager};

/// 单条账号密码记录
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct AccountItem {
    pub id: String,
    pub account: String,
    pub password: String,
    /// 最后更新时间（毫秒时间戳）
    #[serde(default)]
    pub updated_at: u64,
}

/// 账号分组（标题）
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct AccountGroup {
    pub id: String,
    pub name: String,
    #[serde(default)]
    pub items: Vec<AccountItem>,
}

/// 账号密码数据文件路径：{AppData}/com.simpletools.desktop/accounts.json
fn accounts_path(app: &AppHandle) -> Result<PathBuf, String> {
    let dir = app
        .path()
        .app_data_dir()
        .map_err(|e| format!("无法获取数据目录: {e}"))?;
    Ok(dir.join("accounts.json"))
}

/// 读取全部分组（文件不存在时返回空列表）
#[tauri::command]
pub fn accounts_load(app: AppHandle) -> Result<Vec<AccountGroup>, String> {
    let path = accounts_path(&app)?;
    if !path.exists() {
        return Ok(Vec::new());
    }
    let data = fs::read_to_string(&path).map_err(|e| format!("读取失败: {e}"))?;
    if data.trim().is_empty() {
        return Ok(Vec::new());
    }
    serde_json::from_str(&data).map_err(|e| format!("解析失败: {e}"))
}

/// 全量保存分组（先写临时文件再重命名，避免写入中断损坏数据）
#[tauri::command]
pub fn accounts_save(app: AppHandle, groups: Vec<AccountGroup>) -> Result<(), String> {
    let path = accounts_path(&app)?;
    if let Some(parent) = path.parent() {
        fs::create_dir_all(parent).map_err(|e| format!("创建目录失败: {e}"))?;
    }
    let data = serde_json::to_string_pretty(&groups).map_err(|e| format!("序列化失败: {e}"))?;
    let tmp = path.with_extension("json.tmp");
    fs::write(&tmp, data).map_err(|e| format!("写入失败: {e}"))?;
    fs::rename(&tmp, &path).map_err(|e| format!("保存失败: {e}"))?;
    Ok(())
}
