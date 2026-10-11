use crate::winsec;
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
/// v0.15.0 起数据文件为 DPAPI 密文；兼容读取旧版明文（下次保存自动转为密文）
#[tauri::command]
pub fn accounts_load(app: AppHandle) -> Result<Vec<AccountGroup>, String> {
    let path = accounts_path(&app)?;
    if !path.exists() {
        return Ok(Vec::new());
    }
    let raw = fs::read(&path).map_err(|e| format!("读取失败: {e}"))?;
    if raw.is_empty() {
        return Ok(Vec::new());
    }
    let data = match winsec::dpapi_decrypt(&raw) {
        Ok(plain) => String::from_utf8(plain).map_err(|e| format!("解码失败: {e}"))?,
        Err(_) => String::from_utf8(raw).map_err(|_| {
            "账号数据无法解密（可能由其他 Windows 用户创建或文件已损坏）".to_string()
        })?,
    };
    if data.trim().is_empty() {
        return Ok(Vec::new());
    }
    serde_json::from_str(&data).map_err(|e| format!("解析失败: {e}"))
}

/// 全量保存分组（v0.15.0 起 DPAPI 加密落盘；先写临时文件再重命名，避免写入中断损坏数据）
#[tauri::command]
pub fn accounts_save(app: AppHandle, groups: Vec<AccountGroup>) -> Result<(), String> {
    let path = accounts_path(&app)?;
    if let Some(parent) = path.parent() {
        fs::create_dir_all(parent).map_err(|e| format!("创建目录失败: {e}"))?;
    }
    let data = serde_json::to_string_pretty(&groups).map_err(|e| format!("序列化失败: {e}"))?;
    let encrypted = winsec::dpapi_encrypt(data.as_bytes())?;
    let tmp = path.with_extension("json.tmp");
    fs::write(&tmp, encrypted).map_err(|e| format!("写入失败: {e}"))?;
    fs::rename(&tmp, &path).map_err(|e| format!("保存失败: {e}"))?;
    Ok(())
}

/// 导出文件条目：文件名与内容由前端组装（TXT / CSV），后端只负责写入
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ExportFile {
    pub name: String,
    pub content: String,
}

/// 导出账号密码数据到用户选择的文件夹，返回写入的文件数
#[tauri::command]
pub fn accounts_export(dir: String, files: Vec<ExportFile>) -> Result<usize, String> {
    if files.is_empty() {
        return Err("没有可导出的内容".into());
    }
    let dir = PathBuf::from(&dir);
    if !dir.is_dir() {
        return Err("目标文件夹不存在".into());
    }
    for f in &files {
        // 仅允许纯文件名，禁止路径分隔符与上级目录跳转
        if f.name.is_empty()
            || f.name == "."
            || f.name == ".."
            || f.name.contains('/')
            || f.name.contains('\\')
        {
            return Err(format!("非法文件名: {}", f.name));
        }
        fs::write(dir.join(&f.name), &f.content)
            .map_err(|e| format!("写入 {} 失败: {e}", f.name))?;
    }
    Ok(files.len())
}
