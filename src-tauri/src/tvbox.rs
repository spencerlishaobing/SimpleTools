use base64::Engine as _;
use std::time::Duration;
use tauri::{Emitter, Manager};

const MAX_BODY: usize = 32 * 1024 * 1024;
/// 大多数 TVBox 源站按 OkHttp 客户端（TVBox/影视仓均为 OkHttp）返回内容，
/// 缺省 UA 与安卓端保持一致，避免源站返回导航页或拒绝响应。
pub(crate) const TVBOX_UA: &str = "okhttp/3.15";

fn http_url(value: &str) -> Result<reqwest::Url, String> {
    let url = reqwest::Url::parse(value).map_err(|_| "网址无效".to_string())?;
    if !matches!(url.scheme(), "http" | "https") {
        return Err("仅支持 HTTP / HTTPS".into());
    }
    Ok(url)
}

fn gunzip_limited(data: &[u8]) -> Result<Vec<u8>, String> {
    use std::io::Read;
    let mut out = Vec::new();
    flate2::read::GzDecoder::new(data)
        .take(MAX_BODY as u64 + 1)
        .read_to_end(&mut out)
        .map_err(|e| format!("GZIP 解压失败：{e}"))?;
    if out.len() > MAX_BODY {
        return Err("解压后的响应超过 32 MB".into());
    }
    Ok(out)
}

fn is_base64_byte(b: u8) -> bool {
    b.is_ascii_alphanumeric() || matches!(b, b'+' | b'/' | b'=' | b'-' | b'_')
}

/// 尝试把 `**` 之后的文本按 Base64 解出配置（影视仓“加密接口”载荷）。
fn decode_encrypted_tail(tail: &[u8]) -> Option<String> {
    let mut tail = tail;
    while let Some((first, rest)) = tail.split_first() {
        if first.is_ascii_whitespace() {
            tail = rest;
        } else {
            break;
        }
    }
    if tail.len() < 24 {
        return None;
    }
    let encoded: &[u8] = if tail.iter().all(|&b| is_base64_byte(b) || b.is_ascii_whitespace()) {
        tail
    } else {
        // 容忍载荷尾部存在少量杂质：取最长的 Base64 连续段
        let (mut best, mut start) = (&tail[..0], None);
        for (i, &b) in tail.iter().enumerate() {
            if is_base64_byte(b) {
                if start.is_none() {
                    start = Some(i);
                }
            } else if let Some(s) = start.take() {
                if i - s > best.len() {
                    best = &tail[s..i];
                }
            }
        }
        if let Some(s) = start {
            if tail.len() - s > best.len() {
                best = &tail[s..];
            }
        }
        if best.len() < 24 {
            return None;
        }
        best
    };
    let text = std::str::from_utf8(encoded).ok()?;
    let cleaned: String = text.chars().filter(|c| !c.is_ascii_whitespace()).collect();
    use base64::engine::general_purpose::{STANDARD, STANDARD_NO_PAD, URL_SAFE, URL_SAFE_NO_PAD};
    let decoded = STANDARD
        .decode(&cleaned)
        .or_else(|_| STANDARD_NO_PAD.decode(&cleaned))
        .or_else(|_| URL_SAFE.decode(&cleaned))
        .or_else(|_| URL_SAFE_NO_PAD.decode(&cleaned))
        .ok()?;
    let payload = if decoded.starts_with(&[0x1f, 0x8b]) {
        gunzip_limited(&decoded).ok()?
    } else {
        decoded
    };
    let text = String::from_utf8(payload).ok()?;
    let value = text.trim_start_matches('\u{feff}').trim_start();
    if value.starts_with('{') {
        Some(value.to_string())
    } else {
        None
    }
}

/// 加密配置提取（实测兼容影视仓 6.2.8 的“加密接口”行为）：
/// 响应 = 外壳（常为伪装成 image/* 的图片）+ 前缀 + `**` + Base64(JSONC 配置)；
/// Base64 内容可能再套一层 GZIP。检测完全基于内容，不依赖响应头。
pub(crate) fn extract_encrypted_config(data: &[u8]) -> Option<String> {
    let mut search = 0usize;
    let mut tries = 0;
    while tries < 16 && search + 24 < data.len() {
        let rel = data[search..].windows(2).position(|w| w == b"**")?;
        let pos = search + rel;
        if let Some(text) = decode_encrypted_tail(&data[pos + 2..]) {
            return Some(text);
        }
        search = pos + 2;
        tries += 1;
    }
    None
}

fn looks_like_image(data: &[u8]) -> bool {
    data.starts_with(&[0xff, 0xd8])
        || data.starts_with(b"\x89PNG")
        || data.starts_with(b"GIF8")
        || data.starts_with(b"BM")
        || data.starts_with(b"RIFF")
}

/// 识别另一种社区“加密接口”：全十六进制文本，解码后为 `$#标识#$` + 加密载荷
/// （如 `$#lintech#$`、`$#347#$`）。载荷需要发布方客户端内的密钥，本版本不破解，只给出明确提示。
fn hex_wrapped_marker(data: &[u8]) -> Option<String> {
    let head = &data[..data.len().min(4096)];
    let text = std::str::from_utf8(head).ok()?;
    let trimmed = text.trim_start();
    if trimmed.len() < 40
        || !trimmed
            .bytes()
            .all(|b| b.is_ascii_hexdigit() || b.is_ascii_whitespace())
    {
        return None;
    }
    let hex: String = trimmed
        .chars()
        .filter(|c| !c.is_ascii_whitespace())
        .take(32)
        .collect();
    let bytes: Vec<u8> = hex
        .as_bytes()
        .chunks_exact(2)
        .map(|pair| u8::from_str_radix(std::str::from_utf8(pair).ok()?, 16).ok())
        .collect::<Option<Vec<u8>>>()?;
    let decoded = String::from_utf8_lossy(&bytes);
    let rest = decoded.strip_prefix("$#")?;
    let marker = rest.split("#$").next()?;
    if marker.is_empty() {
        None
    } else {
        Some(marker.to_string())
    }
}

#[tauri::command]
pub async fn tvbox_fetch(
    url: String,
    headers: Option<serde_json::Value>,
) -> Result<String, String> {
    let url = http_url(&url)?;
    let client = reqwest::Client::builder()
        .timeout(Duration::from_secs(25))
        .build()
        .map_err(|e| e.to_string())?;
    let mut header_map = reqwest::header::HeaderMap::new();
    header_map.insert(
        reqwest::header::USER_AGENT,
        reqwest::header::HeaderValue::from_static(TVBOX_UA),
    );
    if let Some(serde_json::Value::Object(map)) = headers {
        for (key, value) in map {
            let name = reqwest::header::HeaderName::from_bytes(key.as_bytes())
                .map_err(|_| format!("请求头名称无效：{key}"))?;
            let value = value.as_str().ok_or("请求头必须是字符串")?;
            if value.is_empty() {
                header_map.remove(&name);
                continue;
            }
            header_map.insert(
                name,
                reqwest::header::HeaderValue::from_str(value)
                    .map_err(|_| format!("请求头内容无效：{key}"))?,
            );
        }
    }
    let mut response = client.get(url).headers(header_map)
        .send()
        .await
        .map_err(|e| format!("连接失败：{e}"))?
        .error_for_status()
        .map_err(|e| format!("接口错误：{e}"))?;
    let content_type = response
        .headers()
        .get(reqwest::header::CONTENT_TYPE)
        .and_then(|v| v.to_str().ok())
        .unwrap_or("")
        .to_lowercase();
    let mut data = Vec::new();
    while let Some(chunk) = response.chunk().await.map_err(|e| e.to_string())? {
        if data.len() + chunk.len() > MAX_BODY {
            return Err("配置或接口响应超过 32 MB".into());
        }
        data.extend_from_slice(&chunk);
    }
    if data.starts_with(&[0x1f, 0x8b]) {
        data = gunzip_limited(&data)?;
    }
    // 加密配置（饭太硬等“影视仓加密接口”）：先从原始字节提取，避免二进制内容进入字符集解码。
    if let Some(config) = extract_encrypted_config(&data) {
        return Ok(config);
    }
    if let Some(marker) = hex_wrapped_marker(&data) {
        return Err(format!(
            "此配置使用十六进制加密（$#{marker}#$），当前版本暂不支持解密，请换用其他配置地址"
        ));
    }
    if looks_like_image(&data) {
        return Err("此地址返回的是图片（加密配置外壳），但没有找到可解密的 Base64 配置数据".into());
    }
    let charset = content_type
        .split("charset=")
        .nth(1)
        .unwrap_or("utf-8")
        .trim_matches(['\"', '\'', ' '])
        .split(';')
        .next()
        .unwrap_or("utf-8");
    let encoding =
        encoding_rs::Encoding::for_label(charset.as_bytes()).unwrap_or(encoding_rs::UTF_8);
    let (text, _, errors) = encoding.decode(&data);
    if errors {
        return Err(format!("响应字符编码无法识别：{charset}"));
    }
    Ok(text.trim_start_matches('\u{feff}').to_string())
}

#[tauri::command]
pub fn tvbox_load(app: tauri::AppHandle) -> Result<Option<serde_json::Value>, String> {
    let path = crate::datadir::data_dir(&app)?.join("tvbox.json");
    if !path.exists() {
        return Ok(None);
    }
    let bytes = std::fs::read(path).map_err(|e| e.to_string())?;
    serde_json::from_slice(&bytes)
        .map(Some)
        .map_err(|e| format!("TVBOX 数据读取失败：{e}"))
}

#[tauri::command]
pub fn tvbox_save(app: tauri::AppHandle, data: serde_json::Value) -> Result<(), String> {
    if !data.is_object() {
        return Err("TVBOX 数据必须是对象".into());
    }
    let bytes = serde_json::to_vec_pretty(&data).map_err(|e| e.to_string())?;
    if bytes.len() > 16 * 1024 * 1024 {
        return Err("TVBOX 数据超过 16 MB".into());
    }
    let path = crate::datadir::data_dir(&app)?.join("tvbox.json");
    let tmp = path.with_extension("json.tmp");
    std::fs::write(&tmp, bytes).map_err(|e| e.to_string())?;
    std::fs::rename(tmp, path).map_err(|e| e.to_string())
}

static IMAGE_CACHE: std::sync::OnceLock<
    std::sync::Mutex<std::collections::HashMap<String, (std::time::Instant, String)>>,
> = std::sync::OnceLock::new();

/// 图片代理：部分片源海报地址带防盗链（如豆瓣图床要求 Referer，无 Referer 直接返回 418），
/// 地址用 `@Referer=...` / `@User-Agent=...` 后缀描述（安卓端图片加载器会解析）。桌面 `<img>` 无法自定义请求头，
/// 这里由后台带 UA / Referer 拉取并返回 data URL（本地缓存 10 分钟）。
#[tauri::command]
pub async fn tvbox_image(url: String, referer: Option<String>, user_agent: Option<String>) -> Result<String, String> {
    let parsed = http_url(&url)?;
    let ua = user_agent.filter(|value| !value.trim().is_empty());
    let key = format!("{url}|{}|{}", referer.as_deref().unwrap_or(""), ua.as_deref().unwrap_or(""));
    let cache = IMAGE_CACHE.get_or_init(Default::default);
    if let Some((when, data)) = cache.lock().map_err(|_| "缓存锁异常")?.get(&key) {
        if when.elapsed() < Duration::from_secs(600) {
            return Ok(data.clone());
        }
    }
    let mut request = reqwest::Client::builder()
        .user_agent(ua.as_deref().unwrap_or(TVBOX_UA))
        .timeout(Duration::from_secs(12))
        .build()
        .map_err(|e| e.to_string())?
        .get(parsed);
    if let Some(referer) = referer.filter(|r| !r.is_empty()) {
        request = request.header(reqwest::header::REFERER, referer);
    }
    let response = request
        .send()
        .await
        .map_err(|e| e.to_string())?
        .error_for_status()
        .map_err(|e| e.to_string())?;
    let content_type = response
        .headers()
        .get(reqwest::header::CONTENT_TYPE)
        .and_then(|v| v.to_str().ok())
        .unwrap_or("image/jpeg")
        .to_string();
    if !content_type.starts_with("image/") {
        return Err(format!("不是图片：{content_type}"));
    }
    let bytes = response.bytes().await.map_err(|e| e.to_string())?;
    if bytes.len() > 8 * 1024 * 1024 {
        return Err("图片超过 8 MB".into());
    }
    let data = format!(
        "data:{content_type};base64,{}",
        base64::engine::general_purpose::STANDARD.encode(&bytes)
    );
    let mut guard = cache.lock().map_err(|_| "缓存锁异常")?;
    if guard.len() >= 128 {
        guard.clear();
    }
    guard.insert(key, (std::time::Instant::now(), data.clone()));
    Ok(data)
}

/// 影视热榜（借鉴 LibreTV：经 60s 公共 API，免 key）：豆瓣周榜 / 百度热播剧。
/// 服务端转发，主实例失败自动回退官方实例；前端负责缓存与展示。
#[tauri::command]
pub async fn tvbox_hot_list(id: String) -> Result<serde_json::Value, String> {
    let category = match id.as_str() {
        "douban_movie_weekly" => "movie",
        "douban_tv_chinese" => "tv_chinese",
        "douban_tv_global" => "tv_global",
        "douban_show_chinese" => "show_chinese",
        "douban_show_global" => "show_global",
        "baidu_teleplay" => "baidu",
        _ => return Err("未知榜单".into()),
    };
    let bases = ["https://60s.crystelf.top", "https://60s.viki.moe"];
    let client = reqwest::Client::builder()
        .user_agent("SimpleTools-TVBox")
        .timeout(Duration::from_secs(8))
        .build()
        .map_err(|e| e.to_string())?;
    for base in bases {
        let url = if category == "baidu" {
            format!("{base}/v2/baidu/teleplay")
        } else {
            format!("{base}/v2/douban/weekly/{category}")
        };
        if let Ok(res) = client.get(url).send().await {
            if res.status().is_success() {
                if let Ok(json) = res.json::<serde_json::Value>().await {
                    return Ok(json);
                }
            }
        }
    }
    Err("热榜获取失败".into())
}

/// 云盘登录：打开登录窗口（夸克/UC/百度/阿里），登录后后台每秒把 cookies 同步到
/// JVM 工作目录 cloud-cookies.txt（android.webkit.CookieManager 兼容层从这里读取，供网盘 JAR 鉴权使用）
#[tauri::command]
pub async fn tvbox_cloud_login(app: tauri::AppHandle, site: String) -> Result<String, String> {
    let (url, title) = match site.as_str() {
        "quark" => ("https://pan.quark.cn/", "夸克网盘登录（扫码或账号登录，登录后关闭窗口即可保存）"),
        "uc" => ("https://drive.uc.cn/", "UC 网盘登录（扫码或账号登录，登录后关闭窗口即可保存）"),
        "baidu" => ("https://pan.baidu.com/", "百度网盘登录（扫码或账号登录，登录后关闭窗口即可保存）"),
        "alipan" => ("https://www.alipan.com/", "阿里云盘登录（扫码或账号登录，登录后关闭窗口即可保存）"),
        _ => return Err("未知网盘".into()),
    };
    let label = format!("cloud-login-{site}");
    let parsed: tauri::Url = url.parse().map_err(|_| "网址无效".to_string())?;
    if let Some(window) = app.get_webview_window(&label) {
        // 已存在：销毁后重建（登录页重新加载；WebView2 持久化登录态不丢），避免停留在已关闭的空白页
        let _ = window.destroy();
        std::thread::sleep(Duration::from_millis(300));
    }
    let window = tauri::WebviewWindowBuilder::new(&app, &label, tauri::WebviewUrl::External(parsed))
        .title(title)
        .inner_size(1000.0, 780.0)
        .build()
        .map_err(|e| e.to_string())?;
    let _ = window.set_focus();
    // 与安卓端一致：打开后自动点页面里的「登录」，让扫码二维码直接弹出（每个页面只尝试一次）
    let auto_handle = app.clone();
    let auto_label = label.clone();
    std::thread::spawn(move || {
        const SCRIPT: &str = r#"(() => {
            if (window.__stAutoLogin) return false;
            window.__stAutoLogin = true;
            const click = () => {
                const nodes = [...document.querySelectorAll('a,button,[role=button]')];
                const target = nodes.find(n => {
                    const text = (n.textContent || '').trim();
                    const rect = n.getBoundingClientRect();
                    return (text === '登录' || text === '立即登录' || text === '登录/注册' || text === '登录 / 注册') && rect.width > 0 && rect.width < 320 && rect.height > 0 && rect.height < 80;
                });
                if (target) { target.click(); return true; }
                return false;
            };
            if (!click()) { let tries = 0; const timer = setInterval(() => { tries++; if (click() || tries > 16) clearInterval(timer); }, 500); }
            return true;
        })()"#;
        for _ in 0..3 {
            std::thread::sleep(Duration::from_millis(1500));
            let Some(win) = auto_handle.get_webview_window(&auto_label) else { return };
            let _ = win.eval(SCRIPT);
        }
    });
    // 登录检测：扫码确认后（关键 Cookie 出现）保存登录态并自动关闭窗口（等同安卓端扫码成功弹窗消失）
    let handle = app.clone();
    let thread_label = label.clone();
    let site_key = site.clone();
    std::thread::spawn(move || loop {
        std::thread::sleep(Duration::from_secs(1));
        let Some(win) = handle.get_webview_window(&thread_label) else { break; };
        sync_cloud_cookies(&handle, &win);
        if cloud_logged_in(&win, &site_key) {
            sync_cloud_cookies(&handle, &win);
            let _ = win.close();
            let _ = handle.emit("cloud-login-done", thread_label.clone());
            break;
        }
    });
    Ok(label)
}

/// 登录成功判定：关键登录 Cookie 出现（百度 BDUSS / 夸克·UC __puus）
/// 注意：b-user-id 是匿名访客也有的 cookie，不能用作判定
fn cloud_logged_in(window: &tauri::WebviewWindow, site: &str) -> bool {
    let Ok(cookies) = window.cookies() else { return false; };
    let names: Vec<String> = cookies.iter().map(|c| c.name().to_string()).collect();
    match site {
        "baidu" => names.iter().any(|n| n == "BDUSS"),
        "quark" | "uc" => names.iter().any(|n| n == "__puus"),
        // 阿里云盘登录态主要在 localStorage，不做自动关闭，用户手动关闭窗口也会保存
        _ => false,
    }
}

/// 把登录窗口的 cookies 按域名聚合写入 JVM 工作目录（cloud-cookies.txt，每行 domain\tname=value; ...）
fn sync_cloud_cookies(app: &tauri::AppHandle, window: &tauri::WebviewWindow) {
    let Ok(cookies) = window.cookies() else { return; };
    let Ok(dir) = crate::datadir::data_dir(app) else { return; };
    let folder = dir.join("tvbox-java");
    let _ = std::fs::create_dir_all(&folder);
    let mut groups: std::collections::BTreeMap<String, Vec<String>> = Default::default();
    for cookie in cookies {
        let domain = cookie.domain().unwrap_or("").trim_start_matches('.').to_lowercase();
        if domain.is_empty() {
            continue;
        }
        groups
            .entry(domain)
            .or_default()
            .push(format!("{}={}", cookie.name(), cookie.value()));
    }
    const KEEP: [&str; 6] = ["quark.cn", "uc.cn", "baidu.com", "alipan.com", "aliyundrive.com", "douban.com"];
    let mut text = String::from("# SimpleTools 云盘登录 Cookie（自动生成，登录窗口打开期间每秒更新）\n");
    let mut count = 0;
    for (domain, values) in groups {
        if values.is_empty() {
            continue;
        }
        if !KEEP.iter().any(|k| domain == *k || domain.ends_with(&format!(".{k}"))) {
            continue;
        }
        text.push_str(&format!("{domain}\t{}\n", values.join("; ")));
        count += 1;
    }
    if count == 0 {
        return; // 还没登录：不覆盖已有文件
    }
    let _ = std::fs::write(folder.join("cloud-cookies.txt"), text);
}

/// 在线字幕条目
#[derive(serde::Serialize)]
pub struct SubtitleItem {
    title: String,
    lang: String,
    url: String,
}

/// 下载在线字幕到临时目录（mpv sub-add 加载），返回本地路径
#[tauri::command]
pub async fn tvbox_subtitle_load(url: String) -> Result<String, String> {
    let parsed: tauri::Url = url.parse().map_err(|_| "字幕地址无效".to_string())?;
    if parsed.scheme() != "http" && parsed.scheme() != "https" {
        return Err("字幕地址需为 http(s)".into());
    }
    let client = reqwest::Client::builder()
        .timeout(Duration::from_secs(20))
        .build()
        .map_err(|e| e.to_string())?;
    let response = client
        .get(parsed.clone())
        .header("User-Agent", TVBOX_UA)
        .send()
        .await
        .map_err(|e| format!("字幕下载失败：{e}"))?;
    if !response.status().is_success() {
        return Err(format!("字幕下载失败：HTTP {}", response.status()));
    }
    let bytes = response.bytes().await.map_err(|e| e.to_string())?;
    if bytes.len() > 8 * 1024 * 1024 {
        return Err("字幕文件过大".into());
    }
    if bytes.is_empty() {
        return Err("字幕内容为空".into());
    }
    let path = parsed.path().to_lowercase();
    let ext = ["srt", "ass", "ssa", "vtt", "sub"]
        .iter()
        .find(|e| path.ends_with(&format!(".{e}")))
        .copied()
        .unwrap_or("srt");
    use std::hash::{Hash, Hasher};
    let mut hasher = std::collections::hash_map::DefaultHasher::new();
    url.hash(&mut hasher);
    let folder = std::env::temp_dir().join("simpletools-subs");
    std::fs::create_dir_all(&folder).map_err(|e| e.to_string())?;
    let file = folder.join(format!("sub-{:x}.{}", hasher.finish(), ext));
    std::fs::write(&file, &bytes).map_err(|e| e.to_string())?;
    Ok(file.to_string_lossy().to_string())
}

/// 用配置里的字幕接口搜索在线字幕（宽松兼容标准数组 / subtitles / Subs 等返回格式）
#[tauri::command]
pub async fn tvbox_subtitle_search(apis: Vec<String>, name: String) -> Result<Vec<SubtitleItem>, String> {
    let name = name.trim().to_string();
    if name.is_empty() {
        return Err("缺少影片名".into());
    }
    let encoded = encode_component(&name);
    let client = reqwest::Client::builder()
        .timeout(Duration::from_secs(10))
        .build()
        .map_err(|e| e.to_string())?;
    let mut items: Vec<SubtitleItem> = Vec::new();
    for api in apis.iter().filter(|a| !a.trim().is_empty()).take(6) {
        let url = if api.contains("{name}") {
            api.replace("{name}", &encoded)
        } else {
            format!("{}{}name={}", api, if api.contains('?') { '&' } else { '?' }, encoded)
        };
        let Ok(response) = client.get(&url).header("User-Agent", TVBOX_UA).send().await else { continue };
        let Ok(bytes) = response.bytes().await else { continue };
        let Ok(text) = String::from_utf8(bytes.to_vec()) else { continue };
        if let Ok(value) = serde_json::from_str::<serde_json::Value>(&text) {
            collect_subtitles(&value, &mut items);
        }
        if items.len() >= 60 {
            break;
        }
    }
    Ok(items)
}

fn collect_subtitles(value: &serde_json::Value, out: &mut Vec<SubtitleItem>) {
    match value {
        serde_json::Value::Array(list) => {
            for item in list {
                collect_subtitles(item, out);
            }
        }
        serde_json::Value::Object(map) => {
            let url = ["url", "sub_url", "download_url", "download"].iter().find_map(|key| {
                map.get(*key).and_then(|v| v.as_str()).filter(|s| s.starts_with("http"))
            });
            if let Some(url) = url {
                let title = ["title", "native_name", "name", "filename", "sub_name"]
                    .iter()
                    .find_map(|key| map.get(*key).and_then(|v| v.as_str()))
                    .unwrap_or("字幕");
                let lang = map
                    .get("lang")
                    .map(|v| v.as_str().map(|s| s.to_string()).unwrap_or_else(|| v.to_string()))
                    .unwrap_or_default();
                if !out.iter().any(|item| item.url == url) {
                    out.push(SubtitleItem {
                        title: title.chars().take(80).collect(),
                        lang: lang.chars().take(20).collect(),
                        url: url.to_string(),
                    });
                }
                return;
            }
            for child in map.values() {
                collect_subtitles(child, out);
            }
        }
        _ => {}
    }
}

fn encode_component(value: &str) -> String {
    let mut out = String::new();
    for byte in value.as_bytes() {
        match *byte {
            b'A'..=b'Z' | b'a'..=b'z' | b'0'..=b'9' | b'-' | b'_' | b'.' | b'~' => out.push(*byte as char),
            _ => out.push_str(&format!("%{:02X}", byte)),
        }
    }
    out
}

#[cfg(test)]
mod tests {
    use super::*;
    use base64::Engine as _;

    fn encode(text: &str) -> String {
        base64::engine::general_purpose::STANDARD.encode(text.as_bytes())
    }

    #[test]
    fn extracts_config_from_image_with_marker() {
        // 模拟饭太硬响应：JPEG 外壳 + 随机前缀 + `**` + Base64(JSONC)
        let json = "{\r\n// comment\r\n\"sites\":[{\"key\":\"a\"}]}";
        let mut body = vec![0xff, 0xd8, 0xff, 0xe0, 0x00, 0x10];
        body.extend_from_slice(b"jpeg-bytes-here");
        body.extend_from_slice(&[0xff, 0xd9]);
        body.extend_from_slice(b"VjVsmoeD**");
        body.extend_from_slice(encode(json).as_bytes());
        let out = extract_encrypted_config(&body).expect("应提取配置");
        assert!(out.starts_with("{"), "输出应为 JSON，实际：{}", &out[..out.len().min(20)]);
        assert!(out.contains("sites"));
    }

    #[test]
    fn extracts_config_from_plain_text_payload() {
        let json = "{\"spider\":\"https://example.com/a.jar;md5;unused\",\"sites\":[],\"lives\":[]}";
        let mut body = b"abcd1234**".to_vec();
        body.extend_from_slice(encode(json).as_bytes());
        assert_eq!(extract_encrypted_config(&body).as_deref(), Some(json));
    }

    #[test]
    fn extracts_gzip_inside_base64() {
        use flate2::write::GzEncoder;
        use flate2::Compression;
        use std::io::Write;
        let json = "{\"spider\":\"https://example.com/gz.jar\",\"sites\":[{\"key\":\"gz\"}],\"lives\":[]}";
        let mut encoder = GzEncoder::new(Vec::new(), Compression::default());
        encoder.write_all(json.as_bytes()).unwrap();
        let gz = encoder.finish().unwrap();
        let mut body = b"SEED99**".to_vec();
        body.extend_from_slice(base64::engine::general_purpose::STANDARD.encode(&gz).as_bytes());
        assert_eq!(extract_encrypted_config(&body).as_deref(), Some(json));
    }

    #[test]
    fn ignores_plain_json_and_false_markers() {
        assert!(extract_encrypted_config(b"{\"sites\":[]}").is_none());
        // `**` 后紧跟普通文本（非 Base64 或解不出 JSON）——不得误提取
        assert!(extract_encrypted_config(b"name=a**b not a payload here").is_none());
        assert!(extract_encrypted_config(b"stars ** and more stars ** text").is_none());
    }

    #[test]
    fn ignores_base64_that_is_not_config() {
        // Base64 合法但不是 JSON 对象开头（例如普通文本）——不得误提取
        let mut body = b"x**".to_vec();
        body.extend_from_slice(encode("this is just a long plain text, not config").as_bytes());
        assert!(extract_encrypted_config(&body).is_none());
    }

    #[test]
    fn extracts_url_safe_base64() {
        use base64::engine::general_purpose::URL_SAFE_NO_PAD;
        let json = "{\"sites\":[{\"key\":\"url-safe>?\"}]}";
        let encoded = URL_SAFE_NO_PAD.encode(json.as_bytes().to_vec());
        let mut body = b"tag**".to_vec();
        body.extend_from_slice(encoded.as_bytes());
        assert_eq!(extract_encrypted_config(&body).as_deref(), Some(json));
    }

    #[test]
    fn image_without_payload_is_detected() {
        let body = vec![0xff, 0xd8, 0xff, 0xe0, 0, 16];
        assert!(looks_like_image(&body));
        assert!(!looks_like_image(b"{\"sites\":[]}"));
    }

    #[test]
    fn detects_hex_wrapped_encrypted_config() {
        // $#lintech#$ + 随机二进制的十六进制文本
        let mut bytes = b"$#lintech#$".to_vec();
        bytes.extend_from_slice(&[0xd3, 0x46, 0xff, 0x58, 0x11, 0xb7, 0x19, 0x3b]);
        bytes.extend_from_slice(&[0x42u8; 64]);
        let hex: String = bytes.iter().map(|b| format!("{b:02x}")).collect();
        assert_eq!(hex_wrapped_marker(hex.as_bytes()).as_deref(), Some("lintech"));
        // 普通 JSON 不应误判
        assert!(hex_wrapped_marker(b"{\"sites\":[]}").is_none());
        assert!(hex_wrapped_marker(b"1234567890").is_none());
    }
}
