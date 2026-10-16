//! Desktop replacements for TVBox's Android torrent and Thunder URL helpers.
//! aria2 runs as a bundled, separate process; no Android native code is loaded.
use base64::{engine::general_purpose::STANDARD, Engine};
use md5::{Digest, Md5};
use std::{
    path::{Path, PathBuf},
    sync::atomic::{AtomicU64, Ordering},
    time::Duration,
};
use tauri::Manager;

#[derive(Default)]
pub struct P2pState(AtomicU64);

fn decode_thunder(raw: &str) -> Result<String, String> {
    let encoded = raw
        .get(10..)
        .filter(|_| raw.to_ascii_lowercase().starts_with("thunder://"))
        .ok_or("迅雷链接格式无效")?;
    let data = STANDARD.decode(encoded).map_err(|_| "迅雷链接编码无效")?;
    let value = String::from_utf8(data).map_err(|_| "迅雷链接文本无效")?;
    let value = value
        .strip_prefix("AA")
        .and_then(|s| s.strip_suffix("ZZ"))
        .ok_or("迅雷链接内容无效")?;
    if !matches!(
        reqwest::Url::parse(value).ok().map(|u| u.scheme().to_owned()),
        Some(s) if matches!(s.as_str(), "http" | "https" | "ftp")
    ) {
        return Err("迅雷链接解码后不是可播放的网络地址".into());
    }
    Ok(value.to_owned())
}

fn is_torrent(raw: &str) -> bool {
    if raw.to_ascii_lowercase().starts_with("magnet:?") {
        return true;
    }
    if Path::new(raw).extension().is_some_and(|e| e.eq_ignore_ascii_case("torrent")) {
        return true;
    }
    reqwest::Url::parse(raw).ok().is_some_and(|u| {
        matches!(u.scheme(), "http" | "https")
            && u.path().to_ascii_lowercase().ends_with(".torrent")
    })
}

fn largest_video(dir: &Path) -> std::io::Result<Option<PathBuf>> {
    let mut pending = vec![dir.to_path_buf()];
    let mut best: Option<(u64, PathBuf)> = None;
    let mut scanned = 0;
    while let Some(folder) = pending.pop() {
        for item in std::fs::read_dir(folder)? {
            scanned += 1;
            if scanned > 10000 {
                return Err(std::io::Error::other("种子包含过多文件"));
            }
            let item = item?;
            let ty = item.file_type()?;
            if ty.is_symlink() {
                continue;
            }
            if ty.is_dir() {
                pending.push(item.path());
            } else if ty.is_file()
                && item.path().extension().is_some_and(|ext| {
                    ["mp4", "mkv", "avi", "mov", "webm", "ts", "m2ts", "flv", "wmv"]
                        .iter()
                        .any(|v| ext.eq_ignore_ascii_case(v))
                })
            {
                let size = item.metadata()?.len();
                if best.as_ref().is_none_or(|(old, _)| size > *old) {
                    best = Some((size, item.path()));
                }
            }
        }
    }
    Ok(best.map(|(_, path)| path))
}

#[tauri::command]
pub fn tvbox_cancel_p2p(state: tauri::State<'_, P2pState>) {
    state.0.fetch_add(1, Ordering::SeqCst);
}

#[tauri::command]
pub async fn tvbox_prepare_media(
    app: tauri::AppHandle,
    state: tauri::State<'_, P2pState>,
    target: String,
) -> Result<String, String> {
    if target.to_ascii_lowercase().starts_with("thunder://") {
        return decode_thunder(&target);
    }
    if !is_torrent(&target) {
        return Err("此地址不是磁力链接或种子文件".into());
    }
    if !target.to_ascii_lowercase().starts_with("magnet:")
        && reqwest::Url::parse(&target).is_err()
        && !Path::new(&target).is_file()
    {
        return Err("种子文件不存在".into());
    }
    let ticket = state.0.fetch_add(1, Ordering::SeqCst) + 1;
    let cache = app
        .path()
        .app_cache_dir()
        .map_err(|e| e.to_string())?
        .join("tvbox-torrents")
        .join(format!("{:x}", Md5::digest(target.as_bytes())));
    tokio::fs::create_dir_all(&cache)
        .await
        .map_err(|e| e.to_string())?;
    let exe = app
        .path()
        .resource_dir()
        .map_err(|e| e.to_string())?
        .join("resources/aria2/aria2c.exe");
    let exe = if exe.is_file() {
        exe
    } else {
        PathBuf::from(env!("CARGO_MANIFEST_DIR"))
            .join("resources/aria2/aria2c.exe")
    };
    if !exe.is_file() {
        return Err("内置 BitTorrent 引擎缺失，请重新安装 SimpleTools".into());
    }
    let mut command = tokio::process::Command::new(exe);
    command
        .kill_on_drop(true)
        .arg("--dir")
        .arg(&cache)
        .args([
            "--file-allocation=none",
            "--seed-time=0",
            "--bt-prioritize-piece=head,tail",
            "--max-concurrent-downloads=1",
            "--console-log-level=warn",
            "--summary-interval=0",
        ])
        .arg(&target)
        .stdout(std::process::Stdio::null())
        .stderr(std::process::Stdio::null());
    #[cfg(windows)]
    {
        use std::os::windows::process::CommandExt;
        command.as_std_mut().creation_flags(0x08000000);
    }
    let mut child = command.spawn().map_err(|e| format!("启动 BT 下载失败：{e}"))?;
    loop {
        if state.0.load(Ordering::SeqCst) != ticket {
            let _ = child.kill().await;
            return Err("下载已取消".into());
        }
        match child.try_wait().map_err(|e| e.to_string())? {
            Some(status) if status.success() => break,
            Some(status) => return Err(format!("BT 下载失败，aria2 退出码：{status}")),
            None => tokio::time::sleep(Duration::from_millis(500)).await,
        }
    }
    largest_video(&cache)
        .map_err(|e| e.to_string())?
        .map(|p| p.to_string_lossy().into_owned())
        .ok_or("种子下载完成，但没有找到视频文件".into())
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn thunder_decodes_to_http() {
        let encoded = STANDARD.encode("AAhttps://example.org/movie.mp4ZZ");
        assert_eq!(
            decode_thunder(&format!("thunder://{encoded}")).unwrap(),
            "https://example.org/movie.mp4"
        );
        assert!(decode_thunder("thunder://bad").is_err());
    }

    #[test]
    fn torrent_types_are_detected() {
        assert!(is_torrent("magnet:?xt=urn:btih:abc"));
        assert!(is_torrent("https://example.org/a.torrent?token=1"));
        assert!(!is_torrent("https://example.org/video.mp4"));
    }
}
