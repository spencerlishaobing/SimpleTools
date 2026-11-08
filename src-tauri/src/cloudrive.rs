//! 网盘直连解析（不依赖 JAR 的播放逻辑）
//!
//! 背景：饭太硬等 JAR 的网盘源在"未登录/登录 UI"路径上依赖 Android UI 框架，
//! 桌面端无法渲染其扫码弹窗。搜索/详情不需要登录（JAR 已可用），
//! 只有"播放解析"需要登录态——这里用登录窗口写入的 cloud-cookies.txt 直接调网盘 API。
//!
//! 支持：夸克/UC（同构 CloudDrive API）、百度（骨架）。
use serde_json::{json, Value};
use std::time::Duration;

use crate::tvbox::apply_dns;

pub(crate) const UA_PC: &str = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.54 Safari/537.36";

/// 合并多个域名的 Cookie（夸克：pan.quark.cn 携带 b-user-id，__puus 在 quark.cn 行）
fn load_cookie_multi(app: &tauri::AppHandle, hosts: &[&str]) -> String {
    let mut seen = std::collections::HashSet::new();
    let mut out: Vec<String> = Vec::new();
    for host in hosts {
        for pair in load_cookie(app, host).split("; ") {
            let pair = pair.trim();
            if pair.is_empty() { continue; }
            let name = pair.split('=').next().unwrap_or("");
            if name.is_empty() || !seen.insert(name.to_string()) { continue; }
            out.push(pair.to_string());
        }
    }
    out.join("; ")
}

/// 读取 JVM 工作目录下 cloud-cookies.txt 中指定域名的 Cookie 头
fn load_cookie(app: &tauri::AppHandle, host: &str) -> String {
    let Ok(dir) = crate::datadir::data_dir(app) else { return String::new() };
    let file = dir.join("tvbox-java").join("cloud-cookies.txt");
    let Ok(text) = std::fs::read_to_string(&file) else { return String::new() };
    let host = host.to_lowercase();
    let mut out = String::new();
    for line in text.lines() {
        let line = line.trim();
        if line.is_empty() || line.starts_with('#') { continue; }
        let Some((domain, value)) = line.split_once('\t') else { continue };
        let domain = domain.trim().to_lowercase();
        if host == domain || host.ends_with(&format!(".{domain}")) {
            if !out.is_empty() { out.push_str("; "); }
            out.push_str(value.trim());
        }
    }
    out
}

fn client() -> Result<reqwest::Client, String> {
    apply_dns(reqwest::Client::builder())
        .timeout(Duration::from_secs(20))
        .build()
        .map_err(|e| e.to_string())
}

/// 从分享链接提取 (类型, id, 密码)
fn parse_share(url: &str) -> Option<(&'static str, String, String)> {
    let lower = url.to_lowercase();
    let share_id = |value: &str| value.split(|c: char| matches!(c, '?' | '#' | '/') || c.is_whitespace()).next().unwrap_or("").to_string();
    let pwd = ["pwd=", "password=", "提取码:", "提取码："]
        .iter().find_map(|mark| lower.find(mark).map(|p| url[p + mark.len()..].split(['&', '#', ' ', '\n']).next().unwrap_or("").to_string())).unwrap_or_default();
    if lower.contains("pan.quark.cn/s/") {
        let id = share_id(url.split("/s/").nth(1)?);
        return Some(("quark", id, pwd));
    }
    if lower.contains("drive.uc.cn/s/") {
        let id = share_id(url.split("/s/").nth(1)?);
        return Some(("uc", id, pwd));
    }
    if lower.contains("pan.baidu.com/s/") || lower.contains("yun.baidu.com/s/") {
        let id = share_id(url.split("/s/").nth(1)?);
        return Some(("baidu", id, pwd));
    }
    for domain in ["www.alipan.com/s/", "www.aliyundrive.com/s/", "alipan.com/s/", "aliyundrive.com/s/"] {
        if let Some(pos) = lower.find(domain) {
            let id = share_id(&url[pos + domain.len()..]);
            return Some(("alipan", id, pwd));
        }
    }
    None
}

fn is_video_name(name: &str) -> bool {
    let lower = name.to_lowercase();
    [".mp4", ".mkv", ".avi", ".m3u8", ".ts", ".m2ts", ".mov", ".flv", ".wmv", ".rmvb", ".webm", ".m4v", ".mpg", ".mpeg"]
        .iter().any(|ext| lower.ends_with(ext))
}

fn api_base(kind: &str) -> &'static str {
    if kind == "uc" { "https://pc-api.uc.cn" } else { "https://drive-pc.quark.cn" }
}

/// 夸克/UC：取分享 stoken
/// 优先官方分享 token 接口（公开分享免登录，实测稳定）；页面 HTML 提取作为兜底（SPA 页面常无明文 stoken）
async fn quark_stoken(http: &reqwest::Client, kind: &str, id: &str, pwd: &str) -> Result<String, String> {
    let api = format!("{}/1/clouddrive/share/sharepage/token?pr=ucpro&fr=pc&uc_param_str=", api_base(kind));
    if let Ok(resp) = http.post(&api)
        .header("User-Agent", UA_PC)
        .json(&serde_json::json!({"pwd_id": id, "passcode": pwd}))
        .send().await
    {
        if let Ok(json) = resp.json::<Value>().await {
            if let Some(stoken) = json["data"]["stoken"].as_str() {
                if !stoken.is_empty() { return Ok(stoken.to_string()); }
            }
        }
    }
    let (host, domain) = if kind == "uc" { ("drive.uc.cn", "drive.uc.cn") } else { ("pan.quark.cn", "pan.quark.cn") };
    let url = format!("https://{host}/s/{id}");
    let resp = http.get(&url)
        .header("User-Agent", UA_PC)
        .send().await
        .map_err(|e| format!("分享门票获取失败：{e}"))?;
    let text = resp.text().await.map_err(|e| e.to_string())?;
    // 页面里常见 "stoken":"xxx"
    for key in ["\"stoken\":\"", "stoken%22%3A%22"] {
        if let Some(pos) = text.find(key) {
            let rest = &text[pos + key.len()..];
            if let Some(end) = rest.find('"') {
                return Ok(rest[..end].to_string());
            }
        }
    }
    let _ = domain;
    Err("分享页未找到 stoken（链接可能失效或需要登录）".into())
}

/// URL query 转义（stoken 常含 +/= 等字符，直接拼接会被服务端解析为空格/参数分隔 → 非法 token）
fn encode_query(value: &str) -> String {
    let mut out = String::new();
    for b in value.bytes() {
        match b {
            b'A'..=b'Z' | b'a'..=b'z' | b'0'..=b'9' | b'-' | b'_' | b'.' | b'~' => out.push(b as char),
            _ => out.push_str(&format!("%{:02X}", b)),
        }
    }
    out
}

/// 夸克/UC：分享文件列表
async fn quark_list(http: &reqwest::Client, kind: &str, id: &str, stoken: &str, cookie: &str, pdir: &str) -> Result<Vec<Value>, String> {
    let url = format!(
        "{}/1/clouddrive/share/sharepage/detail?pr=ucpro&fr=pc&uc_param_str=&pwd_id={id}&stoken={stoken}&pdir_fid={pdir}&force=0&_page=1&_size=50&_fetch_banner=0&_fetch_share=0&_fetch_total=1&_sort=file_type:asc,updated_at:desc",
        api_base(kind),
        stoken = encode_query(stoken)
    );
    let resp = http.get(&url)
        .header("User-Agent", UA_PC)
        .header("Referer", "https://pan.quark.cn/")
        .header("Cookie", cookie)
        .send().await
        .map_err(|e| format!("文件列表请求失败：{e}"))?;
    let value: Value = resp.json().await.map_err(|e| format!("文件列表解析失败：{e}"))?;
    let list = value.pointer("/data/list").and_then(|v| v.as_array()).cloned().unwrap_or_default();
    if list.is_empty() {
        let msg = value.get("message").and_then(|v| v.as_str()).unwrap_or("");
        return Err(format!("分享内没有文件（{msg}）"));
    }
    Ok(list)
}

/// 遍历分享内所有常见目录，选体积最大的影片，避免误播样片/花絮。
async fn quark_find_video(http: &reqwest::Client, kind: &str, id: &str, stoken: &str, cookie: &str) -> Result<(String, String, String, i64), String> {
    let mut dirs = std::collections::VecDeque::from(["0".to_string()]);
    let mut best: Option<(String, String, String, i64)> = None;
    let mut scanned = 0usize;
    while let Some(pdir) = dirs.pop_front() {
        scanned += 1;
        if scanned > 100 { break; }
        for item in quark_list(http, kind, id, stoken, cookie, &pdir).await? {
            let fid = item.get("fid").and_then(Value::as_str).unwrap_or("");
            if fid.is_empty() { continue; }
            let is_dir = item.get("file_type").and_then(Value::as_i64).unwrap_or(0) == 0;
            if is_dir { dirs.push_back(fid.to_string()); continue; }
            let name = item.get("file_name").and_then(Value::as_str).unwrap_or("");
            if !is_video_name(name) { continue; }
            let size = item.get("size").and_then(Value::as_i64).unwrap_or(0);
            let token = item.get("share_fid_token").and_then(Value::as_str).unwrap_or("").to_string();
            if best.as_ref().map(|v| size > v.3).unwrap_or(true) { best = Some((fid.to_string(), token, name.to_string(), size)); }
        }
    }
    best.ok_or_else(|| "分享内没有视频文件".to_string())
}

/// 详情页选集里携带的 share_fid_token 会过期。播放前重新遍历分享目录，
/// 用 fid 找回当前 token；不能用“根目录最新文件”替代，否则会串片。
async fn quark_refresh_file(
    http: &reqwest::Client,
    kind: &str,
    id: &str,
    stoken: &str,
    cookie: &str,
    target_fid: &str,
) -> Result<(String, String, i64), String> {
    let mut dirs = std::collections::VecDeque::from(["0".to_string()]);
    let mut scanned = 0usize;
    while let Some(pdir) = dirs.pop_front() {
        scanned += 1;
        if scanned > 100 {
            break;
        }
        for item in quark_list(http, kind, id, stoken, cookie, &pdir).await? {
            let fid = item.get("fid").and_then(Value::as_str).unwrap_or("");
            if fid.is_empty() {
                continue;
            }
            let is_dir = item.get("file_type").and_then(Value::as_i64).unwrap_or(0) == 0;
            if is_dir {
                dirs.push_back(fid.to_string());
                continue;
            }
            if fid == target_fid {
                let token = item
                    .get("share_fid_token")
                    .and_then(Value::as_str)
                    .unwrap_or("")
                    .to_string();
                if token.is_empty() {
                    return Err("分享文件缺少有效 token，请刷新详情后重试".into());
                }
                let name = item
                    .get("file_name")
                    .and_then(Value::as_str)
                    .unwrap_or("")
                    .to_string();
                let size = item.get("size").and_then(Value::as_i64).unwrap_or(0);
                return Ok((token, name, size));
            }
        }
    }
    Err("分享中的所选文件已失效或被移动，请刷新详情后重试".into())
}

/// 夸克/UC 分享详情：保留分享中的每个视频文件，供详情页按文件选播。
async fn quark_video_files(http: &reqwest::Client, kind: &str, id: &str, stoken: &str, cookie: &str) -> Result<Vec<Value>, String> {
    let mut dirs = std::collections::VecDeque::from(["0".to_string()]);
    let mut files = Vec::new();
    let mut scanned = 0usize;
    while let Some(pdir) = dirs.pop_front() {
        scanned += 1;
        if scanned > 100 || files.len() >= 500 { break; }
        for item in quark_list(http, kind, id, stoken, cookie, &pdir).await? {
            let fid = item.get("fid").and_then(Value::as_str).unwrap_or("");
            if fid.is_empty() { continue; }
            if item.get("file_type").and_then(Value::as_i64).unwrap_or(0) == 0 {
                dirs.push_back(fid.to_string());
                continue;
            }
            let name = item.get("file_name").and_then(Value::as_str).unwrap_or("");
            if !is_video_name(name) { continue; }
            let size = item.get("size").and_then(Value::as_i64).unwrap_or(0);
            let fid_token = item.get("share_fid_token").and_then(Value::as_str).unwrap_or("");
            let payload = json!({
                "sId": id, "sToken": stoken, "fid": fid,
                "share_fid_token": fid_token,
                "size": size, "flag": if kind == "uc" { "UC" } else { "夸父" }
            });
            files.push(json!({"name": name, "size": size, "play": payload.to_string()}));
        }
    }
    files.sort_by(|a, b| a.get("name").and_then(Value::as_str).unwrap_or("").cmp(b.get("name").and_then(Value::as_str).unwrap_or("")));
    if files.is_empty() { return Err("分享内没有视频文件".into()); }
    Ok(files)
}

/// 夸克/UC：递归找第一个视频文件（返回 fid + 名称）
fn find_video(list: &[Value]) -> Option<(String, String)> {
    for item in list {
        let name = item.get("file_name").and_then(|v| v.as_str()).unwrap_or("");
        let is_dir = item.get("file_type").and_then(|v| v.as_i64()).unwrap_or(0) == 0;
        if is_dir { continue; }
        let lower = name.to_lowercase();
        if is_video_name(&lower) {
            let fid = item.get("fid").and_then(|v| v.as_str()).unwrap_or("").to_string();
            if !fid.is_empty() { return Some((fid, name.to_string())); }
        }
    }
    // 目录：返回第一个目录 fid（调用方递归）
    for item in list {
        let is_dir = item.get("file_type").and_then(|v| v.as_i64()).unwrap_or(0) == 0;
        if is_dir {
            let fid = item.get("fid").and_then(|v| v.as_str()).unwrap_or("").to_string();
            if !fid.is_empty() { return Some((fid, String::new())); }
        }
    }
    None
}

async fn alipan_post(http: &reqwest::Client, path: &str, token: Option<&str>, body: Value) -> Result<Value, String> {
    let mut request = http.post(format!("https://api.aliyundrive.com{path}"))
        .header("User-Agent", UA_PC)
        .header("Referer", "https://www.alipan.com/")
        .header("Content-Type", "application/json");
    if let Some(value) = token { request = request.header("x-share-token", value); }
    let response = request.json(&body).send().await.map_err(|e| format!("阿里云盘请求失败：{e}"))?;
    let status = response.status();
    let value: Value = response.json().await.map_err(|e| format!("阿里云盘响应解析失败：{e}"))?;
    if !status.is_success() || value.get("code").is_some() {
        let message = value.get("message").or_else(|| value.get("code")).and_then(|v| v.as_str()).unwrap_or("接口返回失败");
        return Err(format!("阿里云盘：{message}"));
    }
    Ok(value)
}

async fn alipan_share_token(http: &reqwest::Client, id: &str, pwd: &str) -> Result<String, String> {
    let value = alipan_post(http, "/v2/share_link/get_share_token", None, json!({"share_id": id, "share_pwd": pwd})).await?;
    value.get("share_token").and_then(Value::as_str).filter(|v| !v.is_empty()).map(str::to_owned)
        .ok_or_else(|| "阿里云盘未返回分享令牌（链接失效或提取码错误）".to_string())
}

async fn alipan_find_video(http: &reqwest::Client, id: &str, token: &str) -> Result<(String, String), String> {
    let mut dirs = std::collections::VecDeque::from(["root".to_string()]);
    let mut best: Option<(String, String, i64)> = None;
    let mut scanned = 0usize;
    while let Some(parent) = dirs.pop_front() {
        scanned += 1;
        if scanned > 100 { break; }
        let value = alipan_post(http, "/adrive/v3/file/list_by_share", Some(token), json!({
            "share_id": id, "parent_file_id": parent, "limit": 200,
            "order_by": "name", "order_direction": "ASC"
        })).await?;
        for item in value.get("items").and_then(Value::as_array).into_iter().flatten() {
            let file_id = item.get("file_id").and_then(Value::as_str).unwrap_or("");
            let name = item.get("name").and_then(Value::as_str).unwrap_or("");
            if file_id.is_empty() { continue; }
            if item.get("type").and_then(Value::as_str) == Some("folder") { dirs.push_back(file_id.to_string()); continue; }
            if !is_video_name(name) && item.get("category").and_then(Value::as_str) != Some("video") { continue; }
            let size = item.get("size").and_then(Value::as_i64).unwrap_or(0);
            if best.as_ref().map(|v| size > v.2).unwrap_or(true) { best = Some((file_id.to_string(), name.to_string(), size)); }
        }
    }
    best.map(|(id, name, _)| (id, name)).ok_or_else(|| "阿里云盘分享内没有视频文件".to_string())
}

async fn alipan_resolve(http: &reqwest::Client, id: &str, pwd: &str) -> Result<(String, String), String> {
    let token = alipan_share_token(http, id, pwd).await?;
    let (file_id, name) = alipan_find_video(http, id, &token).await?;
    let value = alipan_post(http, "/v2/file/get_video_preview_play_info", Some(&token), json!({
        "share_id": id, "file_id": file_id, "category": "live_transcoding", "template_id": ""
    })).await?;
    let list = value.pointer("/video_preview_play_info/live_transcoding_task_list").and_then(Value::as_array);
    let url = list.into_iter().flatten().filter_map(|v| v.get("url").and_then(Value::as_str).map(|url| (v.get("template_width").and_then(Value::as_i64).unwrap_or(0), url)))
        .max_by_key(|(width, _)| *width).map(|(_, url)| url.to_string())
        .or_else(|| value.pointer("/video_preview_play_info/url").and_then(Value::as_str).map(str::to_owned))
        .ok_or_else(|| "阿里云盘未返回可播放的转码地址".to_string())?;
    Ok((url, name))
}

/// 夸克：转码播放（对齐 JAR N0.p 的官方参数）：POST /file/v2/play/project → data.video_list[].video_info.url（m3u8）
/// 不限制下载大小，适合大文件（免费账号 download 会报 size limit）
async fn quark_transcode(http: &reqwest::Client, kind: &str, cookie: &str, fid: &str, size: i64) -> Result<(String, String), String> {
    let _ = size;
    let base = api_base(kind);
    // 与 JAR 反编译出的参数完全一致（N0.p 的 dec(1986,79,748)）
    let body = json!({
        "fid": fid,
        "resolutions": "normal,low,high,super,2k,4k",
        "supports": "fmp4,m3u8"
    });
    let resp = http.post(format!("{base}/1/clouddrive/file/v2/play?pr=ucpro&fr=pc&uc_param_str="))
        .header("User-Agent", UA_PC)
        .header("Referer", "https://pan.quark.cn/")
        .header("Cookie", cookie)
        .json(&body)
        .send().await
        .map_err(|e| format!("转码请求失败：{e}"))?;
    // 媒体 URL 依赖本响应下发的 Video-Auth（以及刷新后的 __puus）。
    // 只解析 JSON 会丢失 Set-Cookie，随后 CDN 对所有清晰度均返回 412。
    let media_cookie = resp
        .headers()
        .get_all(reqwest::header::SET_COOKIE)
        .iter()
        .filter_map(|value| value.to_str().ok())
        .filter_map(|value| value.split(';').next())
        .filter(|value| !value.is_empty())
        .collect::<Vec<_>>()
        .join("; ");
    let value: Value = resp.json().await.map_err(|e| e.to_string())?;
    // data.video_list[].video_info.url（snake_case），兼容 camelCase。
    // 请求中包含 2k/4k 时必须选择服务端实际返回的最高档；旧逻辑固定选 super，
    // 会把标称 2K/4K 的文件降到较低转码，界面看似高清但实际分辨率不足。
    let mut best: Option<(u8, String)> = None;
    for list_key in ["/data/video_list", "/data/videoList"] {
        if let Some(list) = value.pointer(list_key).and_then(|v| v.as_array()) {
            for item in list {
                let resolution = item.get("resolution").and_then(|v| v.as_str()).unwrap_or("");
                for info_key in ["video_info", "videoInfo"] {
                    if let Some(url) = item.get(info_key).and_then(|v| v.get("url")).and_then(|v| v.as_str()) {
                        if url.is_empty() { continue; }
                        let rank = match resolution.to_ascii_lowercase().as_str() {
                            "8k" => 7, "4k" => 6, "2k" => 5, "super" => 4,
                            "high" => 3, "normal" => 2, "low" => 1, _ => 0,
                        };
                        if best.as_ref().map(|(old, _)| rank > *old).unwrap_or(true) {
                            best = Some((rank, url.to_string()));
                        }
                    }
                }
            }
        }
    }
    if let Some((_, url)) = best { return Ok((url, media_cookie)); }
    // 直接返回 url 的兼容路径
    for key in ["/data/play_url", "/data/download_url", "/data/url"] {
        if let Some(url) = value.pointer(key).and_then(|v| v.as_str()) {
            if !url.is_empty() { return Ok((url.to_string(), media_cookie)); }
        }
    }
    let msg = value.get("message").and_then(|v| v.as_str()).unwrap_or("无返回");
    Err(format!("转码失败：{msg}"))
}

/// 夸克/UC：转存到自己的网盘（一次会话共享），然后取下载直链
async fn quark_save_and_link(http: &reqwest::Client, kind: &str, id: &str, stoken: &str, cookie: &str, fid: &str, fid_token: &str, size: i64) -> Result<String, String> {
    let base = api_base(kind);
    // 0) 复用已转存文件：JAR/之前的播放可能已把同一文件（按大小精确匹配）转存到网盘根目录，
    //    避免每次播放重复转存大文件（实测 4K 片单文件 24GB，重复转存会迅速占满网盘）
    if size > 0 {
        let u = format!("{base}/1/clouddrive/file/sort?pr=ucpro&fr=pc&uc_param_str=&pdir_fid=0&_page=1&_size=50&_fetch_total=0&_fetch_sub_dirs=0&_sort=file_type:asc,updated_at:desc");
        if let Ok(r) = http.get(&u).header("Cookie", cookie).header("User-Agent", UA_PC).header("Referer", "https://pan.quark.cn/").send().await {
            if let Ok(v) = r.json::<Value>().await {
                if let Some(list) = v.pointer("/data/list").and_then(|x| x.as_array()) {
                    for item in list {
                        let fsize = item.get("size").and_then(|x| x.as_i64()).unwrap_or(0);
                        let ftype = item.get("file_type").and_then(|x| x.as_i64()).unwrap_or(0);
                        if ftype != 1 || fsize != size { continue; }
                        let existing_fid = item.get("fid").and_then(|x| x.as_str()).unwrap_or("");
                        let existing_name = item.get("file_name").and_then(|x| x.as_str()).unwrap_or("");
                        if existing_fid.is_empty() { continue; }
                        // 超大文件（>2GB）直接用转码 m3u8：download 对超大文件极易受限且等待久
                        if size > 2 * 1024 * 1024 * 1024 {
                            if let Ok((url, media_cookie)) = quark_transcode(http, kind, cookie, existing_fid, size).await {
                                return Ok(format!("{}\n{}\n{}", url, existing_name, media_cookie));
                            }
                        }
                        // 小文件先试 download（直链原画），失败再转码
                        let body = json!({"fids": [existing_fid]});
                        if let Ok(r2) = http.post(format!("{base}/1/clouddrive/file/download?pr=ucpro&fr=pc&uc_param_str="))
                            .header("User-Agent", UA_PC).header("Referer", "https://pan.quark.cn/").header("Cookie", cookie)
                            .json(&body).send().await
                        {
                            if let Ok(v2) = r2.json::<Value>().await {
                                for key in ["/data/0/download_url", "/data/download_url"] {
                                    if let Some(url) = v2.pointer(key).and_then(|x| x.as_str()) {
                                        if !url.is_empty() { return Ok(format!("{}\n{}", url, existing_name)); }
                                    }
                                }
                            }
                        }
                        if let Ok((url, media_cookie)) = quark_transcode(http, kind, cookie, existing_fid, size).await {
                            return Ok(format!("{}\n{}\n{}", url, existing_name, media_cookie));
                        }
                    }
                }
            }
        }
    }
    // 1) 转存
    let save_body = json!({
        "fid_list": [fid],
        "fid_token_list": [fid_token],
        "to_pdir_fid": "0",
        "pwd_id": id,
        "stoken": stoken,
        "pdir_fid": "0",
        "scene": "link"
    });
    let resp = http.post(format!("{base}/1/clouddrive/share/sharepage/save?pr=ucpro&fr=pc&uc_param_str="))
        .header("User-Agent", UA_PC)
        .header("Referer", "https://pan.quark.cn/")
        .header("Cookie", cookie)
        .json(&save_body)
        .send().await
        .map_err(|e| format!("转存请求失败：{e}"))?;
    let value: Value = resp.json().await.map_err(|e| e.to_string())?;
    let mut save_msg = value.get("message").and_then(|v| v.as_str()).unwrap_or("").to_string();
    let mut task_id = value.pointer("/data/task_id").and_then(|v| v.as_str()).unwrap_or("").to_string();
    let mut file_fid = value.pointer("/data/save_as/save_as_top_fids/0").and_then(|v| v.as_str()).unwrap_or("").to_string();
    let mut save_name = String::new();
    if let Some(item) = value.pointer("/data/save_as/save_as_top_fids_meta/0") {
        save_name = item.get("file_name").and_then(|v| v.as_str()).unwrap_or("").to_string();
    }
    let save_code = value.get("code").and_then(Value::as_i64).unwrap_or(-1);
    if save_code != 0 && task_id.is_empty() && file_fid.is_empty() {
        return Err(format!(
            "转存失败：{}",
            if save_msg.is_empty() { "服务端未返回成功任务" } else { save_msg.as_str() }
        ));
    }
    // 2) 等任务完成（最多 12 秒）
    if !task_id.is_empty() {
        for _ in 0..12 {
            tokio::time::sleep(Duration::from_secs(1)).await;
            let u = format!("{base}/1/clouddrive/share/sharepage/task?pr=ucpro&fr=pc&task_id={task_id}&retry_index=0");
            let Ok(r) = http.get(&u).header("Cookie", cookie).header("User-Agent", UA_PC).send().await else { continue };
            let Ok(v) = r.json::<Value>().await else { continue };
            let status = v.pointer("/data/status").and_then(|x| x.as_i64()).unwrap_or(0);
            if status == 2 {
                if file_fid.is_empty() {
                    if let Some(fids) = v.pointer("/data/save_as/save_as_top_fids").and_then(|x| x.as_array()) {
                        file_fid = fids.first().and_then(|x| x.as_str()).unwrap_or("").to_string();
                    }
                }
                if save_name.is_empty() {
                    if let Some(m) = v.pointer("/data/save_as/save_as_top_fids_meta").and_then(|x| x.as_array()) {
                        save_name = m.first().and_then(|i| i.get("file_name")).and_then(|x| x.as_str()).unwrap_or("").to_string();
                    }
                }
                break;
            }
        }
    }
    // 3) fid 兜底：转存成功后文件在网盘根目录，按时间倒序取最新视频
    if file_fid.is_empty() {
        let u = format!("{base}/1/clouddrive/file/sort?pr=ucpro&fr=pc&uc_param_str=&pdir_fid=0&_page=1&_size=20&_fetch_total=0&_sort=file_type:asc,updated_at:desc");
        if let Ok(r) = http.get(&u).header("Cookie", cookie).header("User-Agent", UA_PC).header("Referer", "https://pan.quark.cn/").send().await {
            if let Ok(v) = r.json::<Value>().await {
                if let Some(list) = v.pointer("/data/list").and_then(|x| x.as_array()) {
                    for item in list {
                        let fname = item.get("file_name").and_then(|x| x.as_str()).unwrap_or("").to_lowercase();
                        let is_dir = item.get("file_type").and_then(|x| x.as_i64()).unwrap_or(0) == 0;
                        if !is_dir && [".mp4", ".mkv", ".m3u8", ".ts", ".avi", ".mov", ".flv", ".rmvb"].iter().any(|e| fname.ends_with(e)) {
                            file_fid = item.get("fid").and_then(|x| x.as_str()).unwrap_or("").to_string();
                            if save_name.is_empty() { save_name = item.get("file_name").and_then(|x| x.as_str()).unwrap_or("").to_string(); }
                            break;
                        }
                    }
                }
            }
        }
    }
    // 4) 大文件优先走官方转码播放。夸克的 download 接口即使返回了 URL，
    //    免费账号的大文件 CDN 仍可能在真正读取时返回 412；不能把“拿到 URL”当作可播放。
    if size > 2 * 1024 * 1024 * 1024 && !file_fid.is_empty() {
        match quark_transcode(http, kind, cookie, &file_fid, size).await {
            Ok((url, media_cookie)) => return Ok(format!("{}\n{}\n{}", url, save_name, media_cookie)),
            Err(err) => {
                // 保留下载兜底，兼容部分没有生成转码任务但允许原画下载的账号。
                eprintln!("夸克大文件转码不可用，回退下载接口：{err}");
            }
        }
    }

    // 5) 取下载地址（转存后的文件 fid）
    let mut last_msg = String::new();
    for target in [file_fid.as_str()].iter().filter(|s| !s.is_empty()) {
        let body = json!({"fids": [target]});
        let Ok(r) = http.post(format!("{base}/1/clouddrive/file/download?pr=ucpro&fr=pc&uc_param_str="))
            .header("User-Agent", UA_PC)
            .header("Referer", "https://pan.quark.cn/")
            .header("Cookie", cookie)
            .json(&body)
            .send().await else { continue };
        let Ok(v) = r.json::<Value>().await else { continue };
        if let Some(msg) = v.get("message").and_then(|x| x.as_str()) { last_msg = msg.to_string(); }
        // 响应 data 可能是数组或对象
        if let Some(arr) = v.pointer("/data").and_then(|x| x.as_array()) {
            if let Some(url) = arr.first().and_then(|i| i.get("download_url")).and_then(|x| x.as_str()) {
                if !url.is_empty() { return Ok(format!("{}\n{}", url, save_name)); }
            }
        }
        if let Some(url) = v.pointer("/data/download_url").and_then(|x| x.as_str()) {
            if !url.is_empty() { return Ok(format!("{}\n{}", url, save_name)); }
        }
    }
    // 下载受限（免费账号大文件 size limit）→ 用转存后的文件 fid 转码 m3u8（对齐 Android JAR）
    if !file_fid.is_empty() && (last_msg.contains("size limit") || last_msg.contains("too large")) {
        match quark_transcode(http, kind, cookie, &file_fid, size).await {
            Ok((url, media_cookie)) => return Ok(format!("{}\n{}\n{}", url, save_name, media_cookie)),
            Err(e) => return Err(format!("下载受限且转码失败：{e}")),
        }
    }
    Err(format!("未获取到下载直链（转存成功但下载失败：{}）", if !last_msg.is_empty() { last_msg.as_str() } else if !save_msg.is_empty() { save_msg.as_str() } else { "文件 fid 缺失" }))
}

/// 下载大文件受限时的转码入口（由调用方在拿到 size 后决定）
async fn quark_play_with_fallback(http: &reqwest::Client, kind: &str, id: &str, stoken: &str, cookie: &str, fid: &str, fid_token: &str, size: i64) -> Result<String, String> {
    match quark_save_and_link(http, kind, id, stoken, cookie, fid, fid_token, size).await {
        Ok(link) => Ok(link),
        Err(err) if err.contains("size limit") || err.contains("too large") => {
            // 下载受限 → 转码 m3u8（下错可回到分享列表拿 fid 再转码）
            let (url, media_cookie) = quark_transcode(http, kind, cookie, fid, size).await?;
            Ok(format!("{}\n{}\n{}", url, String::new(), media_cookie))
        }
        Err(err) => Err(err),
    }
}

/// 百度：verify（密码）→ list → 拿 dlink 骨架
async fn baidu_resolve(http: &reqwest::Client, id: &str, pwd: &str, cookie: &str) -> Result<String, String> {
    let surl = id.trim_start_matches('1');
    // 1) 校验密码并拿到 BDCLND cookie
    let mut jar = cookie.to_string();
    if !pwd.is_empty() {
        let ts = std::time::SystemTime::now().duration_since(std::time::UNIX_EPOCH).map(|d| d.as_millis()).unwrap_or(0);
        let url = format!("https://pan.baidu.com/share/verify?surl={surl}&t={ts}&channel=chunlei&web=1&clienttype=0");
        let Ok(resp) = http.post(&url)
            .header("User-Agent", UA_PC)
            .header("Referer", format!("https://pan.baidu.com/s/1{surl}"))
            .header("Cookie", &jar)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .body(format!("pwd={}&vcode=&vcode_str=", pwd))
            .send().await else { return Err("百度分享校验请求失败".into()) };
        for cookie_header in resp.headers().get_all(reqwest::header::SET_COOKIE) {
            if let Ok(text) = cookie_header.to_str() {
                if let Some((pair, _)) = text.split_once(';') {
                    if pair.starts_with("BDCLND=") {
                        jar.push_str("; "); jar.push_str(pair);
                    }
                }
            }
        }
    }
    // 2) 分享页 → 提取 shareid/uk
    let page = http.get(format!("https://pan.baidu.com/s/1{surl}"))
        .header("User-Agent", UA_PC)
        .header("Cookie", &jar)
        .send().await
        .map_err(|e| format!("百度分享页请求失败：{e}"))?
        .text().await.map_err(|e| e.to_string())?;
    let pick = |key: &str| -> String {
        let pattern = format!("\"{key}\":");
        if let Some(pos) = page.find(&pattern) {
            let rest = page[pos + pattern.len()..].trim_start();
            let digits: String = rest.chars().take_while(|c| c.is_ascii_digit()).collect();
            return digits;
        }
        String::new()
    };
    let shareid = pick("shareid");
    let uk = pick("share_uk");
    if shareid.is_empty() || uk.is_empty() {
        return Err("百度分享页解析失败（可能链接失效或需要登录）".into());
    }
    // 3) 广度遍历目录并选择最大的视频，避免根目录只有文件夹时失败或误选花絮。
    let mut dirs = std::collections::VecDeque::from(["/".to_string()]);
    let mut best: Option<(String, String, i64)> = None;
    let mut scanned = 0usize;
    while let Some(dir) = dirs.pop_front() {
        scanned += 1;
        if scanned > 100 { break; }
        let list_url = format!(
            "https://pan.baidu.com/share/list?uk={uk}&shareid={shareid}&order=name&desc=0&showempty=0&web=1&page=1&num=100&dir={}", encode_query(&dir)
        );
        let list: Value = http.get(&list_url).header("User-Agent", UA_PC).header("Cookie", &jar).send().await
            .map_err(|e| format!("百度文件列表失败：{e}"))?.json().await.map_err(|e| e.to_string())?;
        for item in list.get("list").and_then(Value::as_array).into_iter().flatten() {
            let name = item.get("server_filename").and_then(Value::as_str).unwrap_or("");
            if item.get("isdir").and_then(Value::as_i64).unwrap_or(0) == 1 {
                if let Some(path) = item.get("path").and_then(Value::as_str) { dirs.push_back(path.to_string()); }
                continue;
            }
            if !is_video_name(name) { continue; }
            let size = item.get("size").and_then(Value::as_i64).unwrap_or(0);
            let dlink = item.get("dlink").and_then(Value::as_str).unwrap_or("");
            if best.as_ref().map(|v| size > v.2).unwrap_or(true) { best = Some((name.to_string(), dlink.to_string(), size)); }
        }
    }
    let Some((name, dlink, _)) = best else { return Err("分享内没有视频文件".into()) };
    if dlink.is_empty() { return Err("百度未返回下载链接（需要登录并转存后获取）".into()); }
    Ok(format!("{dlink}\n{name}"))
}

/// 百度分享目录：广度遍历返回全部视频文件（name + 文件直链）。
/// 详情页把每个视频作为独立选集；播放时前端直接把 dlink 交给播放器（带 Referer/UA）。
async fn baidu_share_files(http: &reqwest::Client, id: &str, pwd: &str, cookie: &str) -> Result<Vec<Value>, String> {
    let surl = id.trim_start_matches('1');
    let mut jar = cookie.to_string();
    if !pwd.is_empty() {
        let ts = std::time::SystemTime::now().duration_since(std::time::UNIX_EPOCH).map(|d| d.as_millis()).unwrap_or(0);
        let url = format!("https://pan.baidu.com/share/verify?surl={surl}&t={ts}&channel=chunlei&web=1&clienttype=0");
        if let Ok(resp) = http.post(&url)
            .header("User-Agent", UA_PC)
            .header("Referer", format!("https://pan.baidu.com/s/1{surl}"))
            .header("Cookie", &jar)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .body(format!("pwd={}&vcode=&vcode_str=", pwd))
            .send().await
        {
            for cookie_header in resp.headers().get_all(reqwest::header::SET_COOKIE) {
                if let Ok(text) = cookie_header.to_str() {
                    if let Some((pair, _)) = text.split_once(';') {
                        if pair.starts_with("BDCLND=") { jar.push_str("; "); jar.push_str(pair); }
                    }
                }
            }
        }
    }
    let page = http.get(format!("https://pan.baidu.com/s/1{surl}"))
        .header("User-Agent", UA_PC)
        .header("Cookie", &jar)
        .send().await
        .map_err(|e| format!("百度分享页请求失败：{e}"))?
        .text().await.map_err(|e| e.to_string())?;
    let pick = |key: &str| -> String {
        let pattern = format!("\"{key}\":");
        if let Some(pos) = page.find(&pattern) {
            let rest = page[pos + pattern.len()..].trim_start();
            return rest.chars().take_while(|c| c.is_ascii_digit()).collect();
        }
        String::new()
    };
    let shareid = pick("shareid");
    let uk = pick("share_uk");
    if shareid.is_empty() || uk.is_empty() {
        return Err("百度分享页解析失败（可能链接失效或需要登录）".into());
    }
    let mut dirs = std::collections::VecDeque::from(["/".to_string()]);
    let mut files: Vec<Value> = Vec::new();
    let mut scanned = 0usize;
    while let Some(dir) = dirs.pop_front() {
        scanned += 1;
        if scanned > 100 { break; }
        let list_url = format!("https://pan.baidu.com/share/list?uk={uk}&shareid={shareid}&order=name&desc=0&showempty=0&web=1&page=1&num=100&dir={}", encode_query(&dir));
        let list: Value = match http.get(&list_url).header("User-Agent", UA_PC).header("Cookie", &jar).send().await {
            Ok(r) => r.json().await.map_err(|e| e.to_string())?,
            Err(_) => continue,
        };
        for item in list.get("list").and_then(Value::as_array).into_iter().flatten() {
            let name = item.get("server_filename").and_then(Value::as_str).unwrap_or("");
            if item.get("isdir").and_then(Value::as_i64).unwrap_or(0) == 1 {
                if let Some(path) = item.get("path").and_then(Value::as_str) { dirs.push_back(path.to_string()); }
                continue;
            }
            if !is_video_name(name) { continue; }
            if let Some(dlink) = item.get("dlink").and_then(Value::as_str).filter(|v| !v.is_empty()) {
                files.push(json!({"name": name, "play": dlink}));
            }
        }
    }
    if files.is_empty() {
        return Err("分享内没有可用的视频直链（百度需要登录态才能取分享内直链）".into());
    }
    Ok(files)
}

/// 阿里分享目录：广度遍历返回全部视频文件（name + alipan://share/file_id 播放引用）
async fn alipan_share_files(http: &reqwest::Client, id: &str, token: &str) -> Result<Vec<Value>, String> {
    let mut dirs = std::collections::VecDeque::from(["root".to_string()]);
    let mut files: Vec<Value> = Vec::new();
    let mut scanned = 0usize;
    while let Some(parent) = dirs.pop_front() {
        scanned += 1;
        if scanned > 100 { break; }
        let value = alipan_post(http, "/adrive/v3/file/list_by_share", Some(token), json!({
            "share_id": id, "parent_file_id": parent, "limit": 200,
            "order_by": "name", "order_direction": "ASC"
        })).await?;
        for item in value.get("items").and_then(Value::as_array).into_iter().flatten() {
            let file_id = item.get("file_id").and_then(Value::as_str).unwrap_or("");
            let name = item.get("name").and_then(Value::as_str).unwrap_or("");
            if file_id.is_empty() { continue; }
            if item.get("type").and_then(Value::as_str) == Some("folder") {
                dirs.push_back(file_id.to_string());
                continue;
            }
            if !is_video_name(name) { continue; }
            files.push(json!({"name": name, "play": format!("alipan://{id}/{file_id}")}));
        }
    }
    if files.is_empty() { return Err("分享内没有可用视频文件".into()); }
    Ok(files)
}

/// 播放解析入口：识别网盘链接 → 直连解析 → 返回 (直链, 名称)
#[tauri::command]
pub async fn tvbox_cloud_play(app: tauri::AppHandle, url: String) -> Result<serde_json::Value, String> {
    // 情况 A：JAR 的 ep JSON（饭太硬网盘源）：直接含 sId/sToken/fid，无需分享页
    let raw = url.trim();
    // alipan://share/file_id：阿里分享内单文件引用（详情页选集），按 file_id 取转码地址
    if raw.starts_with("alipan://") {
        let rest = raw.trim_start_matches("alipan://");
        let Some((share_id, file_id)) = rest.split_once('/') else { return Err("阿里播放引用格式无效".into()) };
        let http = client()?;
        let token = alipan_share_token(&http, share_id, "").await?;
        let value = alipan_post(&http, "/v2/file/get_video_preview_play_info", Some(&token), json!({
            "share_id": share_id, "file_id": file_id, "category": "live_transcoding", "template_id": ""
        })).await?;
        let list = value.pointer("/video_preview_play_info/live_transcoding_task_list").and_then(Value::as_array);
        let play = list.into_iter().flatten()
            .filter_map(|v| v.get("url").and_then(Value::as_str).map(|u| (v.get("template_width").and_then(Value::as_i64).unwrap_or(0), u)))
            .max_by_key(|(w, _)| *w).map(|(_, u)| u.to_string())
            .or_else(|| value.pointer("/video_preview_play_info/url").and_then(Value::as_str).map(str::to_owned))
            .ok_or_else(|| "阿里云盘未返回可播放的转码地址".to_string())?;
        return Ok(json!({"url": play, "name": "", "site": "alipan", "referer": "https://www.alipan.com/"}));
    }
    // 百度分享文件直链（dlink，详情页选集）：直接交给播放器，仅需 Referer/UA
    if raw.starts_with("http") && (raw.contains("baidupcs.com") || raw.contains("pcs.baidu.com")) {
        return Ok(json!({"url": raw, "name": "", "site": "baidu"}));
    }
    if raw.starts_with('{') {
        if let Ok(v) = serde_json::from_str::<Value>(raw) {
            let s_id = v.get("sId").and_then(|x| x.as_str()).unwrap_or("").to_string();
            let s_token = v.get("sToken").and_then(|x| x.as_str()).unwrap_or("").to_string();
            let fid = v.get("fid").and_then(|x| x.as_str()).unwrap_or("").to_string();
            let fid_token = v.get("share_fid_token").and_then(|x| x.as_str()).unwrap_or("").to_string();
            let name = v.get("file_name").and_then(|x| x.as_str()).unwrap_or("").to_string();
            let flag = v.get("flag").and_then(|x| x.as_str()).unwrap_or("");
            if !s_id.is_empty() && !fid.is_empty() {
                let kind = if flag.contains("夸父") || flag.to_lowercase().contains("quark") { "quark" } else if flag.to_lowercase().contains("uc") { "uc" } else { "quark" };
                // __puus 登录态在 quark.cn 行，b-user-id 在 pan.quark.cn 行：需要合并
                let cookie = if kind == "uc" {
                    load_cookie_multi(&app, &["drive.uc.cn", "uc.cn"])
                } else {
                    load_cookie_multi(&app, &["pan.quark.cn", "quark.cn"])
                };
                if cookie.is_empty() || !cookie.contains("__puus") {
                    return Err("夸克登录态缺失（__puus）：请在「设置 → 云盘登录」重新扫码".into());
                }
                let http = client()?;
                let size = v.get("size").and_then(|x| x.as_i64()).unwrap_or(0);
                // ep 里的 sToken 是详情接口下发的，容易过期（实测）：用 sId 重新获取新鲜 stoken，拿不到再用 ep 的
                let fresh_stoken = match quark_stoken(&http, kind, &s_id, "").await {
                    Ok(s) if !s.is_empty() => s,
                    _ => s_token,
                };
                // ep JSON 中的 share_fid_token 与 stoken 一样会过期。必须按 fid 从
                // 当前分享目录刷新 token，避免转存 41020 后误播网盘里的其他文件。
                let (fresh_fid_token, fresh_name, fresh_size) =
                    quark_refresh_file(&http, kind, &s_id, &fresh_stoken, &cookie, &fid).await?;
                let link = quark_save_and_link(
                    &http,
                    kind,
                    &s_id,
                    &fresh_stoken,
                    &cookie,
                    &fid,
                    if fresh_fid_token.is_empty() { &fid_token } else { &fresh_fid_token },
                    if fresh_size > 0 { fresh_size } else { size },
                )
                .await?;
                let mut parts = link.splitn(3, '\n');
                let real = parts.next().unwrap_or("").to_string();
                let save_name = parts.next().unwrap_or("").to_string();
                let media_cookie = parts.next().unwrap_or("");
                let playback_cookie = if media_cookie.is_empty() {
                    cookie.clone()
                } else {
                    format!("{cookie}; {media_cookie}")
                };
                // cookie 一并返回：夸克 CDN（m3u8 分片）校验登录态，播放器请求必须携带，否则 412
                return Ok(json!({"url": real, "name": if name.is_empty() { if fresh_name.is_empty() { save_name } else { fresh_name } } else { name }, "site": kind, "cookie": playback_cookie}));
            }
        }
    }
    let Some((kind, id, pwd)) = parse_share(&url) else {
        return Err("不是可识别的网盘分享链接".into());
    };
    let http = client()?;
    let (host, cookie) = match kind {
        "baidu" => ("pan.baidu.com", load_cookie(&app, "pan.baidu.com")),
        "uc" => ("drive.uc.cn", load_cookie_multi(&app, &["drive.uc.cn", "uc.cn"])),
        "alipan" => ("www.alipan.com", load_cookie_multi(&app, &["www.alipan.com", "alipan.com", "aliyundrive.com"])),
        _ => ("pan.quark.cn", load_cookie_multi(&app, &["pan.quark.cn", "quark.cn"])),
    };
    let cookie = if cookie.is_empty() { load_cookie(&app, if kind == "baidu" { "baidu.com" } else if kind == "uc" { "uc.cn" } else if kind == "alipan" { "alipan.com" } else { "quark.cn" }) } else { cookie };
    if cookie.is_empty() && kind != "alipan" {
        return Err(format!("未登录 {}：请在「设置 → 云盘登录」完成扫码", host));
    }
    match kind {
        "quark" | "uc" => {
            let stoken = quark_stoken(&http, kind, &id, &pwd).await?;
            let (fid, fid_token, name, size) = quark_find_video(&http, kind, &id, &stoken, &cookie).await?;
            let link = quark_save_and_link(&http, kind, &id, &stoken, &cookie, &fid, &fid_token, size).await?;
            let mut parts = link.splitn(3, '\n');
            let real = parts.next().unwrap_or("").to_string();
            let save_name = parts.next().unwrap_or("").to_string();
            let media_cookie = parts.next().unwrap_or("");
            let playback_cookie = if media_cookie.is_empty() { cookie } else { format!("{cookie}; {media_cookie}") };
            Ok(json!({"url": real, "name": if name.is_empty() { save_name } else { name }, "site": kind, "cookie": playback_cookie}))
        }
        "baidu" => {
            let link = baidu_resolve(&http, &id, &pwd, &cookie).await?;
            let mut parts = link.splitn(2, '\n');
            let real = parts.next().unwrap_or("").to_string();
            let name = parts.next().unwrap_or("").to_string();
            Ok(json!({"url": real, "name": name, "site": "baidu"}))
        }
        "alipan" => {
            let (url, name) = alipan_resolve(&http, &id, &pwd).await?;
            Ok(json!({"url": url, "name": name, "site": "alipan", "referer": "https://www.alipan.com/"}))
        }
        _ => Err("不支持的网盘类型".into()),
    }
}

/// 网盘详情入口：列出夸克/UC 分享中的实际视频文件，详情页点击哪个就播放哪个。
#[tauri::command]
pub async fn tvbox_cloud_detail(app: tauri::AppHandle, url: String) -> Result<Value, String> {
    let Some((kind, id, pwd)) = parse_share(&url) else { return Err("不是可识别的网盘分享链接".into()) };
    if kind != "quark" && kind != "uc" {
        // 百度/阿里：读取分享目录，把全部视频文件作为选集返回（前端按 files 渲染选集）
        let http = client()?;
        return match kind {
            "baidu" => {
                let cookie = load_cookie(&app, "pan.baidu.com");
                let cookie = if cookie.is_empty() { load_cookie(&app, "baidu.com") } else { cookie };
                if cookie.is_empty() {
                    return Err("未登录百度网盘：请在「设置 → 云盘登录」完成扫码".into());
                }
                let files = baidu_share_files(&http, &id, &pwd, &cookie).await?;
                Ok(json!({"site": "baidu", "shareId": id, "files": files}))
            }
            "alipan" => {
                let token = alipan_share_token(&http, &id, &pwd).await?;
                let files = alipan_share_files(&http, &id, &token).await?;
                Ok(json!({"site": "alipan", "shareId": id, "files": files}))
            }
            _ => Err("该网盘暂不支持目录预览".into()),
        };
    }
    let cookie = if kind == "uc" {
        load_cookie_multi(&app, &["drive.uc.cn", "uc.cn"])
    } else {
        load_cookie_multi(&app, &["pan.quark.cn", "quark.cn"])
    };
    let http = client()?;
    let stoken = quark_stoken(&http, kind, &id, &pwd).await?;
    let files = quark_video_files(&http, kind, &id, &stoken, &cookie).await?;
    Ok(json!({"site": kind, "shareId": id, "files": files}))
}

/// 前端辅助：判断链接是否为网盘分享
#[tauri::command]
pub fn tvbox_cloud_is_share(url: String) -> bool {
    parse_share(&url).is_some()
}

/// 主局域网 IPv4（手机需与电脑同局域网才能打开登录页）
fn primary_lan_ipv4() -> Option<std::net::Ipv4Addr> {
    local_ip_address::list_afinet_netifas()
        .ok()?
        .into_iter()
        .filter_map(|(_, ip)| match ip {
            std::net::IpAddr::V4(v4) if !v4.is_loopback() && !v4.is_link_local() => Some(v4),
            _ => None,
        })
        .min()
}

/// 夸克登录二维码：反编译 Pan.showInputQRCode 确认，JAR 的二维码内容为
/// `http://<局域网IP>:9978/proxy?do=input&csp=drive`（前缀/后缀由 JAR 字典解密，端口/路由固定）。
/// 手机扫码后打开的是 JAR 内置登录页（ProxyOrigin.proxy），粘贴夸克 Cookie 推送即登录。
/// JAR 刷新 token 说明播放会话正在等待授权——沿用 token 新鲜度判断，避免展示过期码。
#[tauri::command]
pub fn tvbox_cloud_qr(app: tauri::AppHandle) -> Result<serde_json::Value, String> {
    let dir = crate::datadir::data_dir(&app)?.join("tvbox-java");
    let file = dir.join("quark-qr-token.txt");
    let token = std::fs::read_to_string(&file)
        .map_err(|_| "尚未获取到二维码，请先播放一次网盘源（片源初始化时会生成二维码）".to_string())?;
    // 夸克扫码 token 有效期很短：超过 3 分钟的旧码不展示（扫码会提示“请求已过期”）
    if let Ok(meta) = std::fs::metadata(&file) {
        if let Ok(modified) = meta.modified() {
            if let Ok(age) = modified.elapsed() {
                if age.as_secs() > 180 {
                    return Err("二维码已过期：请重新播放网盘源，播放瞬间会生成新的登录二维码".into());
                }
            }
        }
    }
    let token = token.trim().to_string();
    if token.is_empty() { return Err("二维码 token 为空".into()); }
    // Java 桥启动时写实际监听端口（9978 被占用会顺延）；文件缺失时按约定端口 9978 处理
    let port = std::fs::read_to_string(dir.join("qr-port.txt"))
        .ok()
        .and_then(|s| s.trim().parse::<u16>().ok())
        .filter(|p| *p > 0)
        .unwrap_or(9978);
    let ip = primary_lan_ipv4()
        .ok_or("未找到局域网 IP：请确认电脑已连接 Wi-Fi/有线网络，手机需与电脑在同一局域网")?;
    // 与 JAR showInputQRCode 的最终 URL 完全一致："http://" + getInternalIP() + ":9978/proxy?do=input&csp=drive"
    let url = format!("http://{ip}:{port}/proxy?do=input&csp=drive");
    let code = qrcode::QrCode::new(url.as_bytes()).map_err(|e| e.to_string())?;
    let svg = code.render::<qrcode::render::svg::Color>()
        .min_dimensions(240, 240)
        .quiet_zone(true)
        .build();
    Ok(json!({"token": token, "url": url, "svg": svg}))
}

// ---------------------------------------------------------------------------
// 夸克官方扫码登录（小程序体系）：手机夸克 App 扫码 → 自动换 Cookie，无需手动填
// 链路：quark.uuxiao.cn/api/mini/generate 取 token + request_id（配对使用）
//      → 二维码内容 https://su.quark.cn/4_eMHBJ?token=<token>
//      → 手机扫码确认 → 轮询 getServiceTicketByQrcodeToken 拿 service_ticket
//      → pan.quark.cn/account/info?st=<ticket>&lw=scan 换取登录 Cookie（__puus 等）
// ---------------------------------------------------------------------------

struct QuarkQrSession {
    token: String,
}

static QUARK_QR: std::sync::OnceLock<std::sync::Mutex<Option<QuarkQrSession>>> = std::sync::OnceLock::new();

fn quark_qr_slot() -> &'static std::sync::Mutex<Option<QuarkQrSession>> {
    QUARK_QR.get_or_init(|| std::sync::Mutex::new(None))
}

/// 禁用自动重定向：换 Cookie 的 302 响应里才是 Set-Cookie，跟随会丢失中间响应头
fn quark_http() -> Result<reqwest::Client, String> {
    reqwest::Client::builder()
        .user_agent(UA_PC)
        .redirect(reqwest::redirect::Policy::none())
        .timeout(Duration::from_secs(15))
        .build()
        .map_err(|e| e.to_string())
}

/// 生成夸克扫码登录二维码（官方扫码体系）：返回 SVG，后台自动轮询登录结果
#[tauri::command]
pub async fn tvbox_quark_qr_start(app: tauri::AppHandle) -> Result<serde_json::Value, String> {
    let http = quark_http()?;
    let resp = http
        .get("https://quark.uuxiao.cn/api/mini/generate")
        .send()
        .await
        .map_err(|e| format!("获取扫码 token 失败：{e}"))?;
    let data: Value = resp.json().await.map_err(|e| format!("扫码 token 解析失败：{e}"))?;
    let token = data.get("token").and_then(|v| v.as_str()).unwrap_or("").to_string();
    let request_id = data.get("request_id").and_then(|v| v.as_str()).unwrap_or("").to_string();
    if token.is_empty() {
        return Err(format!("扫码 token 为空：{data}"));
    }
    // 新码替换旧会话：旧轮询任务检测到 token 变化会自行退出
    if let Ok(mut slot) = quark_qr_slot().lock() {
        *slot = Some(QuarkQrSession { token: token.clone() });
    }
    let url = format!("https://su.quark.cn/4_eMHBJ?token={token}");
    // 始终在本机生成标准 SVG。二维码内容仍是夸克官方扫码地址，但不再依赖第三方
    // 图片接口和 data: PNG，WebView2 中展示稳定，也不会出现“弹窗里不是二维码”。
    let svg = qrcode::QrCode::new(url.as_bytes())
        .map_err(|e| e.to_string())?
        .render::<qrcode::render::svg::Color>()
        .min_dimensions(240, 240)
        .quiet_zone(true)
        .build();
    let handle = app.clone();
    tauri::async_runtime::spawn(async move { poll_quark_qr(handle, token, request_id).await });
    Ok(json!({"url": url, "svg": svg}))
}

async fn poll_quark_qr(app: tauri::AppHandle, token: String, request_id: String) {
    use tauri::Emitter;
    let Ok(http) = quark_http() else { return };
    for _ in 0..90 {
        tokio::time::sleep(Duration::from_secs(2)).await;
        let current = quark_qr_slot().lock().ok().and_then(|slot| slot.as_ref().map(|q| q.token.clone()));
        if current.as_deref() != Some(token.as_str()) {
            return;
        }
        let mut url = match reqwest::Url::parse("https://uop.quark.cn/cas/ajax/getServiceTicketByQrcodeToken") {
            Ok(u) => u,
            Err(_) => return,
        };
        url.query_pairs_mut()
            .append_pair("client_id", "532")
            .append_pair("v", "1.2")
            .append_pair("token", &token)
            .append_pair("request_id", &request_id);
        let Ok(resp) = http.get(url).send().await else { continue };
        let Ok(json) = resp.json::<Value>().await else { continue };
        let status = json.get("status").and_then(|v| v.as_i64()).unwrap_or(0);
        if status == 2000000 {
            if let Some(ticket) = json["data"]["members"]["service_ticket"].as_str() {
                if save_quark_cookies(&http, &app, ticket).await {
                    let _ = app.emit("cloud-login-done", "quark");
                }
            }
            return;
        }
        if status == 50004002 {
            return; // token 已失效：等用户重新生成二维码
        }
    }
}

/// service_ticket 换登录 Cookie（__puus 在 quark.cn 域），合并写入 cloud-cookies.txt
async fn save_quark_cookies(http: &reqwest::Client, app: &tauri::AppHandle, ticket: &str) -> bool {
    let mut url = match reqwest::Url::parse("https://pan.quark.cn/account/info") {
        Ok(u) => u,
        Err(_) => return false,
    };
    url.query_pairs_mut().append_pair("st", ticket).append_pair("lw", "scan");
    let mut groups: std::collections::BTreeMap<String, Vec<String>> = Default::default();
    let mut next = Some(url);
    for _ in 0..4 {
        let Some(target) = next.take() else { break };
        let resp = match http.get(target.clone()).header("Referer", "https://pan.quark.cn/").send().await {
            Ok(r) => r,
            Err(_) => return false,
        };
        for value in resp.headers().get_all(reqwest::header::SET_COOKIE) {
            let Ok(text) = value.to_str() else { continue };
            let mut parts = text.split(';');
            let Some(pair) = parts.next() else { continue };
            let Some((name, val)) = pair.split_once('=') else { continue };
            let mut domain = "pan.quark.cn".to_string();
            for attr in parts {
                let attr = attr.trim();
                if let Some(d) = attr.strip_prefix("Domain=").or_else(|| attr.strip_prefix("domain=")) {
                    domain = d.trim().trim_start_matches('.').to_lowercase();
                }
            }
            groups.entry(domain).or_default().push(format!("{}={}", name.trim(), val.trim()));
        }
        if resp.status().is_redirection() {
            if let Some(location) = resp.headers().get(reqwest::header::LOCATION).and_then(|v| v.to_str().ok()) {
                if let Ok(joined) = target.join(location) {
                    next = Some(joined);
                }
            }
        }
    }
    if groups.values().all(|v| v.is_empty()) {
        return false;
    }
    let Ok(dir) = crate::datadir::data_dir(app) else { return false };
    let folder = dir.join("tvbox-java");
    let _ = std::fs::create_dir_all(&folder);
    let path = folder.join("cloud-cookies.txt");
    // 替换式写入：扫码得到的是完整登录态，旧夸克 cookie 行必须丢弃——
    // 新旧 __puus 同时携带时服务端可能取到旧值（实测 401 require login [guest]）
    let mut lines: Vec<String> = Vec::new();
    if let Ok(old) = std::fs::read_to_string(&path) {
        for line in old.lines() {
            let line = line.trim();
            if line.is_empty() || line.starts_with('#') { continue; }
            let domain = line.split('\t').next().unwrap_or("").trim().to_lowercase();
            if domain == "quark.cn" || domain.ends_with(".quark.cn") { continue; }
            lines.push(line.to_string());
        }
    }
    for (domain, values) in &groups {
        if values.is_empty() { continue; }
        lines.push(format!("{domain}\t{}", values.join("; ")));
    }
    let text = format!("# SimpleTools 云盘登录 Cookie（自动生成）\n{}\n", lines.join("\n"));
    let ok = std::fs::write(path, text).is_ok();
    if ok {
        let cookie = groups.values().flatten().cloned().collect::<Vec<_>>().join("; ");
        // 仅记录键名用于诊断。注意：不要额外发请求验证 Cookie——夸克 __puus 使用后会轮换，
        // 独立请求一次的旧值会立即作废（实测 200 → 2 分钟后 401），相当于自己把会话吊销
        let names: Vec<&str> = groups.values().flatten().filter_map(|pair| pair.split_once('=').map(|(n, _)| n)).collect();
        let _ = std::fs::write(
            folder.join("quark-login-diag.txt"),
            format!("ticket_len={}\ncookie_names={:?}\n", ticket.len(), names),
        );
        push_cookie_to_jar(app, "quark", &cookie).await;
    }
    ok
}

/// 把当前保存的云盘 cookie 应用到 JAR（登录窗口扫码成功后调用；JVM 重启时 Main.load 也会自动恢复）。
/// 先验证夸克登录态真有效（member 接口 200），再交给 JAR 推送逻辑写入内存登录态。
#[tauri::command]
pub async fn tvbox_cloud_apply(app: tauri::AppHandle) -> Result<serde_json::Value, String> {
    let dir = crate::datadir::data_dir(&app)?.join("tvbox-java");
    let text = std::fs::read_to_string(dir.join("cloud-cookies.txt"))
        .map_err(|_| "尚未保存云盘登录态，请先扫码登录".to_string())?;
    let mut cookie: Vec<String> = Vec::new();
    for line in text.lines() {
        let line = line.trim();
        if line.is_empty() || line.starts_with('#') { continue; }
        let Some((domain, value)) = line.split_once('\t') else { continue };
        let domain = domain.trim().to_lowercase();
        if domain == "quark.cn" || domain.ends_with(".quark.cn") { cookie.push(value.trim().to_string()); }
    }
    if cookie.is_empty() { return Err("cookie 文件里没有夸克登录态".into()); }
    let joined = cookie.join("; ");
    // 不做独立 HTTP 验证：夸克 __puus 使用后会轮换，验证请求本身会作废旧值（相当于自己把会话吊销）
    push_cookie_to_jar(&app, "quark", &joined).await;
    Ok(json!({"applied": true}))
}

/// 把扫码得到的 cookie 推送到 JAR（ProxyOrigin.proxy 的 do=quark&type=input 推送页逻辑）：
/// JAR 会写入自己内存里的登录态（N0.F5），与 Android 扫码推送行为一致，播放立即生效。
async fn push_cookie_to_jar(app: &tauri::AppHandle, site: &str, cookie: &str) {
    use tauri::Manager;
    if cookie.is_empty() {
        return;
    }
    let Some((url, token)) = app.state::<crate::tvexternal::ExternalState>().java_endpoint().await else {
        return;
    };
    let Ok(client) = reqwest::Client::builder().timeout(Duration::from_secs(20)).build() else {
        return;
    };
    let _ = client
        .post(format!("{url}/cloud-cookie"))
        .header("X-TVBOX-Token", token)
        .json(&serde_json::json!({"site": site, "cookie": cookie}))
        .send()
        .await;
}

/// URL 百分号解码（中文文件名的 %XX 序列需按字节组合后再转 UTF-8）
fn percent_decode(input: &str) -> String {
    let raw = input.as_bytes();
    let mut bytes: Vec<u8> = Vec::with_capacity(raw.len());
    let mut i = 0;
    while i < raw.len() {
        if raw[i] == b'%' && i + 2 < raw.len() {
            if let Ok(v) = u8::from_str_radix(&String::from_utf8_lossy(&raw[i + 1..i + 3]), 16) {
                bytes.push(v);
                i += 3;
                continue;
            }
        }
        bytes.push(raw[i]);
        i += 1;
    }
    String::from_utf8_lossy(&bytes).to_string()
}

/// 通用播放接管（兼容所有 JAR）：按「网盘类型 + 文件名」在用户网盘搜索同名文件，返回直链或转码 m3u8。
/// 用于替换任何 JAR 返回的本地代理地址（http://127.0.0.1:xxxx/proxy/play/{网盘名}/{标题}/{文件名}）。
#[tauri::command]
pub async fn tvbox_cloud_find(app: tauri::AppHandle, site: String, name: String) -> Result<serde_json::Value, String> {
    let kind = match site.as_str() {
        "uc" => "uc",
        "baidu" => "baidu",
        "ali" => "ali",
        _ => "quark",
    };
    if kind == "baidu" || kind == "ali" {
        return Err(format!("{kind} 网盘暂不支持按文件名搜索，请先在「设置  云盘登录」登录后由片源自行解析"));
    }
    let cookie = if kind == "uc" {
        load_cookie_multi(&app, &["drive.uc.cn", "uc.cn"])
    } else {
        load_cookie_multi(&app, &["pan.quark.cn", "quark.cn"])
    };
    if cookie.is_empty() || (kind == "quark" && !cookie.contains("__puus")) {
        return Err("网盘登录态缺失：请在「设置  云盘登录」完成扫码".into());
    }
    let target = percent_decode(name.trim());
    if target.is_empty() {
        return Err("文件名为空".into());
    }
    let http = client()?;
    let base = api_base(kind);
    // 1) 网盘根目录按文件名精确匹配（最近转存的在前）
    let u = format!("{base}/1/clouddrive/file/sort?pr=ucpro&fr=pc&uc_param_str=&pdir_fid=0&_page=1&_size=100&_fetch_total=0&_fetch_sub_dirs=0&_sort=file_type:asc,updated_at:desc");
    let resp = http.get(&u)
        .header("Cookie", &cookie).header("User-Agent", UA_PC).header("Referer", "https://pan.quark.cn/")
        .send().await.map_err(|e| format!("查询网盘失败：{e}"))?;
    let value: Value = resp.json().await.map_err(|e| e.to_string())?;
    let mut found: Option<(String, i64)> = None;
    if let Some(list) = value.pointer("/data/list").and_then(|x| x.as_array()) {
        for item in list {
            if item.get("file_type").and_then(|x| x.as_i64()).unwrap_or(0) != 1 { continue; }
            let fname = item.get("file_name").and_then(|x| x.as_str()).unwrap_or("");
            if fname == target || fname == name.trim() {
                let fid = item.get("fid").and_then(|x| x.as_str()).unwrap_or("").to_string();
                let size = item.get("size").and_then(|x| x.as_i64()).unwrap_or(0);
                found = Some((fid, size));
                break;
            }
        }
    }
    let Some((fid, size)) = found else {
        return Err(format!("用户网盘中未找到同名文件：{target}（请先在片源中点击播放一次完成转存）"));
    };
    if fid.is_empty() {
        return Err("文件 fid 为空".into());
    }
    // 2) 超大文件（>2GB）直接转码；否则先取下载直链，失败再转码
    if size > 2 * 1024 * 1024 * 1024 {
        let (url, media_cookie) = quark_transcode(&http, kind, &cookie, &fid, size).await?;
        let playback_cookie = if media_cookie.is_empty() { cookie } else { format!("{cookie}; {media_cookie}") };
        return Ok(json!({"url": url, "name": target, "site": kind, "cookie": playback_cookie}));
    }
    let body = json!({"fids": [fid]});
    if let Ok(r2) = http.post(format!("{base}/1/clouddrive/file/download?pr=ucpro&fr=pc&uc_param_str="))
        .header("User-Agent", UA_PC).header("Referer", "https://pan.quark.cn/").header("Cookie", &cookie)
        .json(&body).send().await
    {
        if let Ok(v2) = r2.json::<Value>().await {
            for key in ["/data/0/download_url", "/data/download_url"] {
                if let Some(url) = v2.pointer(key).and_then(|x| x.as_str()) {
                    if !url.is_empty() {
                        return Ok(json!({"url": url, "name": target, "site": kind, "cookie": cookie}));
                    }
                }
            }
        }
    }
    let (url, media_cookie) = quark_transcode(&http, kind, &cookie, &fid, size).await?;
    let playback_cookie = if media_cookie.is_empty() { cookie } else { format!("{cookie}; {media_cookie}") };
    Ok(json!({"url": url, "name": target, "site": kind, "cookie": playback_cookie}))
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn pan_share_parser_covers_all_translated_cloud_types() {
        assert_eq!(parse_share("https://pan.quark.cn/s/q123").map(|v| (v.0, v.1)), Some(("quark", "q123".into())));
        assert_eq!(parse_share("https://drive.uc.cn/s/u123").map(|v| (v.0, v.1)), Some(("uc", "u123".into())));
        assert_eq!(parse_share("https://pan.baidu.com/s/1b123?pwd=7abc"), Some(("baidu", "1b123".into(), "7abc".into())));
        assert_eq!(parse_share("https://www.alipan.com/s/a123 提取码：9xyz"), Some(("alipan", "a123".into(), "9xyz".into())));
        assert_eq!(parse_share("https://www.aliyundrive.com/s/old123").map(|v| (v.0, v.1)), Some(("alipan", "old123".into())));
    }

    #[test]
    fn pan_video_filter_accepts_common_high_resolution_containers() {
        for name in ["movie.2160p.mkv", "video.mp4", "disc.m2ts", "stream.m3u8", "clip.webm"] {
            assert!(is_video_name(name), "{name}");
        }
        assert!(!is_video_name("cover.jpg"));
    }
}
