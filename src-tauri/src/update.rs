//! 版本更新（v0.43.0）：检测 GitHub Releases 最新版本并一键更新
//!
//! 流程：
//! - 检查：GET https://api.github.com/repos/{REPO}/releases/latest，与当前版本做语义化比较
//! - 下载：拉取 Release 中的 NSIS 安装包到临时目录（进度事件 update-progress）
//! - 安装：启动安装程序（`/S` 静默 + `/R` 安装完成后自动重启应用）
//!   安装器的 RestartManager 会自动关闭运行中的旧实例，全程无需手动操作
//!
//! 说明：网络客户端直连（不读系统代理 / PAC，避免代理故障影响更新检查）

use serde::Serialize;
use std::{path::PathBuf, time::Duration};
use tauri::{AppHandle, Emitter};

/// GitHub 仓库（发布与检测的目标）
const REPO: &str = "spencerlishaobing/SimpleTools";
/// 下载大小上限（防异常超大文件，安装包 100MB 足够）
const MAX_DOWNLOAD: u64 = 100 * 1024 * 1024;

/// 更新检查结果
#[derive(Debug, Clone, Serialize)]
pub struct UpdateInfo {
    pub current: String,
    pub latest: String,
    pub has_update: bool,
    /// 更新说明（Release notes，截断）
    pub notes: String,
    pub published_at: String,
    pub asset_name: String,
    pub asset_url: String,
    pub asset_size: u64,
}

/// 解析语义化版本 "v1.2.3" → (1, 2, 3)（忽略预发布 / 构建后缀；非法返回 None）
fn parse_version(s: &str) -> Option<(u64, u64, u64)> {
    let t = s.trim().trim_start_matches(['v', 'V']);
    let core = t.split(['-', '+']).next().unwrap_or(t);
    let mut it = core.split('.');
    let a: u64 = it.next()?.parse().ok()?;
    let b: u64 = it.next().unwrap_or("0").parse().ok()?;
    let c: u64 = it.next().unwrap_or("0").parse().ok()?;
    Some((a, b, c))
}

/// latest 是否比 current 新（版本不可解析时视为无更新）
fn is_newer(latest: &str, current: &str) -> bool {
    match (parse_version(latest), parse_version(current)) {
        (Some(l), Some(c)) => l > c,
        _ => false,
    }
}

/// 从 Release JSON 中挑选安装包资产（*_x64-setup.exe）
fn pick_installer_asset(json: &serde_json::Value) -> Option<(String, String, u64)> {
    for a in json["assets"].as_array()? {
        let name = a["name"].as_str().unwrap_or("");
        if name.ends_with("-setup.exe") {
            let url = a["browser_download_url"].as_str().unwrap_or("");
            if !url.is_empty() {
                return Some((
                    name.to_string(),
                    url.to_string(),
                    a["size"].as_u64().unwrap_or(0),
                ));
            }
        }
    }
    None
}

/// 构建 HTTP 客户端（直连：不读系统代理 / PAC，避免本机代理故障影响更新）
fn http_client() -> Result<reqwest::Client, String> {
    reqwest::Client::builder()
        .user_agent(format!("SimpleTools-Updater/{}", env!("CARGO_PKG_VERSION")))
        .timeout(Duration::from_secs(30))
        .no_proxy()
        .build()
        .map_err(|e| format!("初始化网络客户端失败：{e}"))
}

/// 检查更新（对比当前版本与 GitHub 最新 Release）
#[tauri::command]
pub async fn update_check() -> Result<UpdateInfo, String> {
    let client = http_client()?;
    let url = format!("https://api.github.com/repos/{REPO}/releases/latest");
    let resp = client
        .get(&url)
        .header("Accept", "application/vnd.github+json")
        .send()
        .await
        .map_err(|e| format!("网络连接失败：{e}（请检查网络后重试）"))?;
    let status = resp.status();
    if !status.is_success() {
        if status.as_u16() == 404 {
            return Err("未找到发布信息".into());
        }
        return Err(format!("GitHub 返回错误（HTTP {}）", status.as_u16()));
    }
    let json: serde_json::Value = resp
        .json()
        .await
        .map_err(|e| format!("解析响应失败：{e}"))?;
    let tag = json["tag_name"].as_str().unwrap_or("").to_string();
    if tag.is_empty() {
        return Err("发布信息缺少版本号".into());
    }
    let notes: String = json["body"]
        .as_str()
        .unwrap_or("")
        .chars()
        .take(2000)
        .collect();
    let published_at = json["published_at"].as_str().unwrap_or("").to_string();
    let (asset_name, asset_url, asset_size) = pick_installer_asset(&json).unwrap_or_default();
    let current = env!("CARGO_PKG_VERSION").to_string();
    let has_update = is_newer(&tag, &current) && !asset_url.is_empty();
    Ok(UpdateInfo {
        current,
        latest: tag.trim_start_matches(['v', 'V']).to_string(),
        has_update,
        notes,
        published_at,
        asset_name,
        asset_url,
        asset_size,
    })
}

/// 下载安装包到临时目录（进度事件 update-progress：downloaded / total）
#[tauri::command]
pub async fn update_download(app: AppHandle, url: String, name: String) -> Result<String, String> {
    // 仅允许 GitHub 域名（防任意地址下载）
    let parsed = reqwest::Url::parse(&url).map_err(|_| "下载地址无效".to_string())?;
    let host = parsed.host_str().unwrap_or("").to_string();
    if !(host.ends_with("github.com") || host.ends_with("githubusercontent.com")) {
        return Err("下载地址不受信任".into());
    }
    let client = http_client()?;
    let mut resp = client.get(&url).send().await.map_err(|e| format!("下载失败：{e}"))?;
    if !resp.status().is_success() {
        return Err(format!("下载失败（HTTP {}）", resp.status().as_u16()));
    }
    let total = resp.content_length().unwrap_or(0);
    // 文件名安全化（仅保留字母数字与 .-_，固定前缀便于识别与清理）
    let safe: String = name
        .chars()
        .filter(|c| c.is_ascii_alphanumeric() || matches!(c, '.' | '-' | '_'))
        .collect();
    let file_name = format!(
        "SimpleTools-Update-{}",
        if safe.is_empty() { "setup.exe".to_string() } else { safe }
    );
    let path: PathBuf = std::env::temp_dir().join(file_name);
    use tokio::io::AsyncWriteExt;
    let mut file = tokio::fs::File::create(&path)
        .await
        .map_err(|e| format!("创建临时文件失败：{e}"))?;
    let mut downloaded: u64 = 0;
    while let Some(chunk) = resp.chunk().await.map_err(|e| format!("下载中断：{e}"))? {
        file.write_all(&chunk)
            .await
            .map_err(|e| format!("写入失败：{e}"))?;
        downloaded += chunk.len() as u64;
        if downloaded > MAX_DOWNLOAD {
            let _ = tokio::fs::remove_file(&path).await;
            return Err("安装包超过大小限制，已取消".into());
        }
        let _ = app.emit(
            "update-progress",
            serde_json::json!({ "downloaded": downloaded, "total": total }),
        );
    }
    file.flush().await.map_err(|e| format!("写入失败：{e}"))?;
    Ok(path.display().to_string())
}

/// 启动安装程序：`/S` 静默安装（自动关闭运行中的旧实例）+ `/R` 完成后自动重启应用
#[tauri::command]
pub async fn update_install(app: AppHandle, path: String) -> Result<(), String> {
    let p = PathBuf::from(path.trim());
    // 仅允许临时目录内的安装包（防任意程序执行）
    if !p.starts_with(std::env::temp_dir()) || !p.is_file() {
        return Err("安装包不存在或位置异常".into());
    }
    std::process::Command::new(&p)
        .arg("/S")
        .arg("/R")
        .spawn()
        .map_err(|e| format!("启动安装程序失败：{e}"))?;
    // 兜底：安装器会通过 RestartManager 关闭本应用；若 8 秒后仍存活则自行退出让安装继续
    let app2 = app.clone();
    tauri::async_runtime::spawn(async move {
        tokio::time::sleep(Duration::from_secs(8)).await;
        app2.exit(0);
    });
    Ok(())
}

// ---------------------------------------------------------------------------
// 单元测试
// ---------------------------------------------------------------------------

#[cfg(test)]
mod tests {
    use super::{is_newer, parse_version, pick_installer_asset};

    /// 版本解析与比较（v 前缀 / 预发布后缀 / 非法输入）
    #[test]
    fn version_parse_compare() {
        assert_eq!(parse_version("v0.42.0"), Some((0, 42, 0)));
        assert_eq!(parse_version("1.2"), Some((1, 2, 0)));
        assert_eq!(parse_version("v1.2.3-beta.1"), Some((1, 2, 3)));
        assert_eq!(parse_version("v1.2.3+build5"), Some((1, 2, 3)));
        assert_eq!(parse_version("bad"), None);
        assert!(is_newer("v0.43.0", "0.42.0"));
        assert!(is_newer("0.42.1", "0.42.0"));
        assert!(is_newer("v1.0.0", "0.99.9"));
        assert!(!is_newer("v0.42.0", "0.42.0"));
        assert!(!is_newer("v0.41.9", "0.42.0"));
        assert!(!is_newer("junk", "0.42.0"));
    }

    /// 安装包资产筛选（优先 *-setup.exe；无资产返回 None）
    #[test]
    fn pick_asset_prefers_setup() {
        let json = serde_json::json!({
            "tag_name": "v9.9.9",
            "assets": [
                { "name": "SimpleTools_9.9.9_x64-portable.exe", "browser_download_url": "https://github.com/x/portable", "size": 100 },
                { "name": "SimpleTools_9.9.9_x64-setup.exe", "browser_download_url": "https://github.com/x/setup", "size": 200 }
            ]
        });
        let (name, url, size) = pick_installer_asset(&json).expect("应找到安装包资产");
        assert_eq!(name, "SimpleTools_9.9.9_x64-setup.exe");
        assert_eq!(url, "https://github.com/x/setup");
        assert_eq!(size, 200);
        assert!(pick_installer_asset(&serde_json::json!({ "assets": [] })).is_none());
        assert!(pick_installer_asset(&serde_json::json!({})).is_none());
    }
}
