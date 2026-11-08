use base64::Engine as _;
use std::time::Duration;
use tauri::{Emitter, Manager};

const MAX_BODY: usize = 32 * 1024 * 1024;
/// 大多数 TVBox 源站按 OkHttp 客户端（TVBox/影视仓均为 OkHttp）返回内容，
/// 缺省 UA 与安卓端保持一致，避免源站返回导航页或拒绝响应。
pub(crate) const TVBOX_UA: &str = "okhttp/3.15";
const DESKTOP_BROWSER_UA: &str = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36";

// ---------- 安全 DNS（DoH，参考 Android TVBox 的安全 DNS） ----------
// 0=关闭 1=阿里 2=腾讯 3=Cloudflare；对所有 Rust 出站 HTTP 请求生效（JVM/JAR 内部 DNS 不受影响）
static DNS_MODE: std::sync::atomic::AtomicU8 = std::sync::atomic::AtomicU8::new(0);
pub(crate) fn current_dns_mode() -> u8 {
    DNS_MODE.load(std::sync::atomic::Ordering::Relaxed)
}

fn dns_endpoint(mode: u8) -> Option<&'static str> {
    match mode {
        1 => Some("https://dns.alidns.com/resolve"),
        2 => Some("https://doh.pub/dns-query"),
        3 => Some("https://cloudflare-dns.com/dns-query"),
        _ => None,
    }
}

struct DohResolver {
    endpoint: &'static str,
}

impl reqwest::dns::Resolve for DohResolver {
    fn resolve(&self, name: reqwest::dns::Name) -> reqwest::dns::Resolving {
        let host = name.as_str().to_string();
        let endpoint = self.endpoint;
        Box::pin(async move {
            let client = reqwest::Client::builder()
                .timeout(Duration::from_secs(6))
                .build()
                .map_err(|e| -> Box<dyn std::error::Error + Send + Sync> { e.into() })?;
            let url = format!("{endpoint}?name={host}&type=A");
            let json: serde_json::Value = client
                .get(&url)
                .header("Accept", "application/dns-json")
                .send()
                .await
                .map_err(|e| -> Box<dyn std::error::Error + Send + Sync> { e.into() })?
                .json()
                .await
                .map_err(|e| -> Box<dyn std::error::Error + Send + Sync> { e.into() })?;
            let mut addrs: Vec<std::net::SocketAddr> = Vec::new();
            if let Some(answers) = json["Answer"].as_array() {
                for answer in answers {
                    if answer["type"].as_u64() == Some(1) {
                        if let Some(ip) = answer["data"].as_str().and_then(|v| v.parse::<std::net::IpAddr>().ok()) {
                            addrs.push(std::net::SocketAddr::new(ip, 0));
                        }
                    }
                }
            }
            if addrs.is_empty() {
                return Err("DoH 无解析结果".into());
            }
            Ok(Box::new(addrs.into_iter()) as reqwest::dns::Addrs)
        })
    }
}

/// 给 reqwest 客户端注入安全 DNS（开启时）
pub(crate) fn apply_dns(builder: reqwest::ClientBuilder) -> reqwest::ClientBuilder {
    let mode = DNS_MODE.load(std::sync::atomic::Ordering::Relaxed);
    match dns_endpoint(mode) {
        Some(endpoint) => builder.dns_resolver(std::sync::Arc::new(DohResolver { endpoint })),
        None => builder,
    }
}

/// 同步客户端（内置适配器）也使用同一套安全 DNS：站点域名被污染时能明显加快响应
pub(crate) fn apply_dns_blocking(builder: reqwest::blocking::ClientBuilder) -> reqwest::blocking::ClientBuilder {
    let mode = DNS_MODE.load(std::sync::atomic::Ordering::Relaxed);
    match dns_endpoint(mode) {
        Some(endpoint) => builder.dns_resolver(std::sync::Arc::new(DohResolver { endpoint })),
        None => builder,
    }
}

/// 设置安全 DNS 模式（off/ali/tencent/cloudflare）
#[tauri::command]
pub fn tvbox_dns_set(mode: String) {
    let value = match mode.as_str() {
        "ali" => 1,
        "tencent" => 2,
        "cloudflare" => 3,
        _ => 0,
    };
    DNS_MODE.store(value, std::sync::atomic::Ordering::Relaxed);
}

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

/// Return at most `max_bytes` without ever splitting a UTF-8 code point.
/// Network responses often contain Chinese text, so byte-indexing a `str`
/// directly can panic and terminate the desktop process.
fn utf8_prefix(value: &str, max_bytes: usize) -> &str {
    if value.len() <= max_bytes {
        return value;
    }
    let mut end = max_bytes;
    while !value.is_char_boundary(end) {
        end -= 1;
    }
    &value[..end]
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
    // 全局复用连接池（对齐 Android OkHttp 长连接）：自定义 DNS + keep-alive，避免每次请求重建连接
    static CLIENT: std::sync::OnceLock<reqwest::Client> = std::sync::OnceLock::new();
    let client = CLIENT.get_or_init(|| {
        crate::tvbox::apply_dns(reqwest::Client::builder())
            .timeout(Duration::from_secs(25))
            .connect_timeout(Duration::from_secs(6))
            .pool_idle_timeout(Duration::from_secs(300))
            .pool_max_idle_per_host(16)
            .tcp_keepalive(Duration::from_secs(60))
            .build()
            .unwrap_or_else(|_| reqwest::Client::new())
    });
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

/// 内置默认仓库（饭太硬，已从加密配置解出并内置）：首次启动直接可用，用户可切换到其他仓库
const BUNDLED_WAREHOUSE: &str = include_str!("../resources/tvbox/default-warehouse.json");

/// 解析内置仓库配置；格式损坏时返回 None
pub(crate) fn bundled_warehouse() -> Option<serde_json::Value> {
    serde_json::from_str::<serde_json::Value>(BUNDLED_WAREHOUSE).ok()
}

#[tauri::command]
pub fn tvbox_load(app: tauri::AppHandle) -> Result<Option<serde_json::Value>, String> {
    let path = crate::datadir::data_dir(&app)?.join("tvbox.json");
    if !path.exists() {
        // 首次启动：直接返回内置饭太硬仓（不写入磁盘，用户修改/切换后才落盘）
        if let Some(config) = bundled_warehouse() {
            return Ok(Some(serde_json::json!({
                "profiles": [{
                    "id": "builtin-fantaiying",
                    "name": "👽饭太硬（内置）",
                    "base": "",
                    "collectionBase": "",
                    "builtin": true,
                    "config": config
                }],
                "profileId": "builtin-fantaiying"
            })));
        }
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
    // 防覆盖保护：profiles 从非空变空时拒绝写入（多半是前端加载失败后的空快照，之前曾把用户全部配置刷掉），
    // 同时每次保存前保留上一版 tvbox.json.bak 供恢复
    let new_profiles_empty = data
        .get("profiles")
        .and_then(|v| v.as_array())
        .map(|a| a.is_empty())
        .unwrap_or(true);
    if new_profiles_empty && path.exists() {
        if let Ok(prev) = std::fs::read(&path) {
            if let Ok(prev_value) = serde_json::from_slice::<serde_json::Value>(&prev) {
                let prev_profiles = prev_value
                    .get("profiles")
                    .and_then(|v| v.as_array())
                    .map(|a| a.len())
                    .unwrap_or(0);
                if prev_profiles > 0 {
                    let _ = std::fs::copy(&path, path.with_extension("json.rejected"));
                    return Err("拒绝覆盖：新数据没有任何 TVBOX 配置（疑似加载失败后的空快照），已保留原配置".into());
                }
            }
        }
    }
    if path.exists() {
        let _ = std::fs::copy(&path, path.with_extension("json.bak"));
    }
    let tmp = path.with_extension("json.tmp");
    std::fs::write(&tmp, bytes).map_err(|e| e.to_string())?;
    std::fs::rename(tmp, path).map_err(|e| e.to_string())
}

static IMAGE_CACHE: std::sync::OnceLock<
    std::sync::Mutex<std::collections::HashMap<String, (std::time::Instant, String)>>,
> = std::sync::OnceLock::new();

static IMAGE_CLIENT: std::sync::OnceLock<reqwest::Client> = std::sync::OnceLock::new();

static POSTER_SEARCH_CACHE: std::sync::OnceLock<
    std::sync::Mutex<std::collections::HashMap<String, (std::time::Instant, String)>>,
> = std::sync::OnceLock::new();

/// 图片代理专用 HTTP 客户端（连接池复用：封面大量并发加载时不再每张图新建 TCP/TLS）
fn image_client() -> Result<&'static reqwest::Client, String> {
    if let Some(client) = IMAGE_CLIENT.get() {
        return Ok(client);
    }
    let client = crate::tvbox::apply_dns(reqwest::Client::builder())
        .user_agent(TVBOX_UA)
        .timeout(Duration::from_secs(12))
        .pool_max_idle_per_host(16)
        .build()
        .map_err(|e| e.to_string())?;
    let _ = IMAGE_CLIENT.set(client);
    IMAGE_CLIENT.get().ok_or_else(|| "图片客户端初始化失败".to_string())
}

/// 图片代理：部分片源海报地址带防盗链（如豆瓣图床要求 Referer，无 Referer 直接返回 418），
/// 地址用 `@Referer=...` / `@User-Agent=...` 后缀描述（安卓端图片加载器会解析）。桌面 `<img>` 无法自定义请求头，
/// 这里由后台带 UA / Referer 拉取并返回 data URL（本地缓存 10 分钟）。
#[tauri::command]
pub async fn tvbox_image(url: String, referer: Option<String>, user_agent: Option<String>) -> Result<String, String> {
    let parsed = http_url(&url)?;
    let ua = user_agent.filter(|value| !value.trim().is_empty());
    // Douban's image CDN rejects Android/OkHttp UA with 403 even with a valid Referer.
    // Keep TVBox UA for source sites, but emulate a desktop browser only for this CDN.
    let effective_ua = ua.as_deref().unwrap_or_else(|| {
        if parsed.host_str().is_some_and(|host| host.ends_with("doubanio.com")) {
            DESKTOP_BROWSER_UA
        } else {
            TVBOX_UA
        }
    });
    let key = format!("{url}|{}|{}", referer.as_deref().unwrap_or(""), effective_ua);
    let cache = IMAGE_CACHE.get_or_init(Default::default);
    if let Some((when, data)) = cache.lock().map_err(|_| "缓存锁异常")?.get(&key) {
        if when.elapsed() < Duration::from_secs(600) {
            return Ok(data.clone());
        }
    }
    let mut request = image_client()?
        .get(parsed)
        .header(reqwest::header::USER_AGENT, effective_ua);
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

/// 清洗网盘/搜索结果标题：提取核心片名（去《》外标签、方括号块、常见技术词）
fn clean_movie_title(raw: &str) -> String {
    let mut title = raw.trim().to_string();
    // 优先取《》内的正式片名
    if let (Some(start), Some(end)) = (title.find('《'), title.find('》')) {
        if end > start {
            let inner = title[start + '《'.len_utf8()..end].trim().to_string();
            if !inner.is_empty() { title = inner; }
        }
    }
    // 去掉【】[]（）() 包裹的发布标签
    for (open, close) in [('【', '】'), ('[', ']'), ('（', '）'), ('(', ')')] {
        let mut guard = 0;
        while let Some(start) = title.find(open) {
            guard += 1;
            if guard > 8 { break; }
            match title[start..].find(close) {
                Some(offset) => title.replace_range(start..start + offset + close.len_utf8(), " "),
                None => { title.truncate(start); break; }
            }
        }
    }
    // 截断到第一个常见技术词（分辨率/编码/音轨/来源/合集标记）
    let stops = ["4K", "8K", "2160", "1080", "720", "HDR", "SDR", "DV", "杜比", "Dolby", "蓝光", "BluRay", "Blu-ray", "WEB-DL", "WEBRip", "HDTV", "H265", "H264", "HEVC", "x265", "x264", "10bit", "8bit", "60fps", "50fps", "DTS", "AC3", "AAC", "国语", "国英", "中英", "中字", "双语", "内封", "内嵌", "字幕", "合集", "全集", "系列", "连载", "更新至", "S01", "S02", "第一季", "第二季", "第1季", "第2季", "高码", "高帧"];
    let mut cut = title.len();
    for token in stops {
        if let Some(pos) = title.find(token) {
            if pos > 0 && pos < cut { cut = pos; }
        }
    }
    title.truncate(cut);
    title
        .trim_matches(|c: char| matches!(c, '·' | '-' | '_' | '|' | '—' | ' ' | '：' | ':'))
        .split_whitespace()
        .collect::<Vec<_>>()
        .join(" ")
}

/// Search one representative poster for cloud-search results. Cloud indexes generally only
/// return a share title/link, so use Douban's public suggestion endpoint once per keyword and
/// cache it. The front end only fills missing posters; source-provided artwork always wins.
#[tauri::command]
pub async fn tvbox_poster_search(title: String) -> Result<String, String> {
    let original = title.trim().to_string();
    if original.is_empty() {
        return Ok(String::new());
    }
    let cleaned = clean_movie_title(&original);
    let query = if cleaned.is_empty() { original.clone() } else { cleaned.clone() };
    let key = query.to_lowercase();
    let cache = POSTER_SEARCH_CACHE.get_or_init(Default::default);
    if let Some((when, url)) = cache.lock().map_err(|_| "缓存锁异常")?.get(&key) {
        if when.elapsed() < Duration::from_secs(24 * 3600) {
            return Ok(url.clone());
        }
    }
    let url = reqwest::Url::parse_with_params(
        "https://movie.douban.com/j/subject_suggest",
        &[("q", query.as_str())],
    )
    .map_err(|e| e.to_string())?;
    // subject_suggest is a legacy endpoint and may return 403/418 or malformed data.
    // It is only an optimisation: never let its failure skip the public web-search fallback.
    let rows: serde_json::Value = match image_client()?
        .get(url)
        .header(reqwest::header::USER_AGENT, DESKTOP_BROWSER_UA)
        .header(reqwest::header::REFERER, "https://movie.douban.com/")
        .send()
        .await
    {
        Ok(response) => match response.error_for_status() {
            Ok(response) => response.json().await.unwrap_or_else(|_| serde_json::json!([])),
            Err(_) => serde_json::json!([]),
        },
        Err(_) => serde_json::json!([]),
    };
    // 候选相似度：完全同名 > 互相包含 > 其余，取最高分而非盲目取第一个
    let query_l = query.to_lowercase();
    let mut poster = rows
        .as_array()
        .into_iter()
        .flatten()
        .filter_map(|row| {
            let img = row.get("img").and_then(serde_json::Value::as_str)?;
            if !img.starts_with("http") { return None; }
            let name = row.get("title").and_then(serde_json::Value::as_str).unwrap_or("").to_lowercase();
            let score = if name == query_l { 100 } else if !name.is_empty() && (name.contains(&query_l) || query_l.contains(&name)) { 60 } else { 10 };
            Some((score, img.to_string()))
        })
        .max_by_key(|(score, _)| *score)
        .map(|(_, img)| img)
        .unwrap_or_default();
    // 豆瓣的旧 subject_suggest 接口在 2026 年已可能对正常关键词直接返回 []。
    // 桌面端仍需要为只给分享链接的网盘索引补封面，因此退回豆瓣网页搜索的
    // 影视分类结果；结果块同时带 title 与 poster，取第一条即为网页端的最佳匹配。
    if poster.is_empty() {
        let search_url = reqwest::Url::parse_with_params(
            "https://www.douban.com/search",
            &[("cat", "1002"), ("q", query.as_str())],
        )
        .map_err(|e| e.to_string())?;
        if let Ok(response) = image_client()?
            .get(search_url)
            .header(reqwest::header::USER_AGENT, DESKTOP_BROWSER_UA)
            .header(reqwest::header::REFERER, "https://www.douban.com/")
            .send()
            .await
        {
            if let Ok(response) = response.error_for_status() {
              if let Ok(html) = response.text().await {
                if let Some(start) = html.find("<a class=\"nbg\"") {
                    let block = utf8_prefix(&html[start..], 1400);
                    if let Some(img_at) = block.find("<img src=\"") {
                        let value = &block[img_at + 10..];
                        if let Some(end) = value.find('"') {
                            let candidate = value[..end].replace("&amp;", "&");
                            if candidate.starts_with("http") { poster = candidate; }
                        }
                    }
                }
              }
            }
        }
    }
    let mut guard = cache.lock().map_err(|_| "缓存锁异常")?;
    if guard.len() >= 256 {
        guard.clear();
    }
    guard.insert(key, (std::time::Instant::now(), poster.clone()));
    Ok(poster)
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
    let client = crate::tvbox::apply_dns(reqwest::Client::builder())
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
    // 登录检测：扫码确认后（关键 Cookie 出现且真实有效）保存登录态并自动关闭窗口
    let handle = app.clone();
    let thread_label = label.clone();
    let site_key = site.clone();
    std::thread::spawn(move || {
        let opened = std::time::Instant::now();
        loop {
            std::thread::sleep(Duration::from_secs(1));
            let Some(win) = handle.get_webview_window(&thread_label) else { break };
            sync_cloud_cookies(&handle, &win);
            // 窗口至少停留 8 秒：给页面加载与自动点「登录」弹码的时间；
            // 否则旧会话残留的 __puus（已过期）会让窗口 1 秒内直接关闭，用户根本没机会扫码
            if opened.elapsed().as_secs() < 8 { continue; }
            if !cloud_logged_in(&win, &site_key) { continue; }
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
    let files = tvbox_subtitle_prepare(url).await?;
    files.first().and_then(|v|v["path"].as_str()).map(str::to_owned).ok_or("没有字幕文件".into())
}

#[tauri::command]
pub async fn tvbox_subtitle_prepare(url: String) -> Result<Vec<serde_json::Value>, String> {
    let parsed: tauri::Url = url.parse().map_err(|_| "字幕地址无效".to_string())?;
    if parsed.scheme() != "http" && parsed.scheme() != "https" {
        return Err("字幕地址需为 http(s)".into());
    }
    let client = crate::tvbox::apply_dns(reqwest::Client::builder())
        .timeout(Duration::from_secs(20))
        .build()
        .map_err(|e| e.to_string())?;
    let is_assrt = parsed.host_str().map(|h| h.ends_with("assrt.net")).unwrap_or(false);
    let is_media = ["srt", "ass", "ssa", "vtt", "sub"].iter().any(|e| parsed.path().to_lowercase().ends_with(&format!(".{e}")));
    let bytes = if parsed.host_str() == Some("api.assrt.net") && parsed.path().contains("/sub/detail") {
        // Assrt JSON API 详情：优先服务端已解压的字幕文件，其次下载 zip。
        let response = client.get(parsed.clone()).header("User-Agent", ASSRT_UA).send().await
            .map_err(|e| format!("字幕详情获取失败：{e}"))?;
        let value: serde_json::Value = response.json().await.map_err(|e| format!("字幕详情解析失败：{e}"))?;
        let sub = value.pointer("/sub/subs/0").ok_or("字幕详情为空或共享额度暂不可用")?;
        let choices = assrt_subtitle_files(sub);
        if choices.len()>1 { return Ok(choices); }
        let direct = choices.first().and_then(|f|f["url"].as_str()).map(str::to_owned)
            .or_else(|| sub.get("url").and_then(|v|v.as_str()).map(str::to_owned))
            .ok_or("字幕详情没有可下载文件")?;
        let response = client.get(&direct).header("User-Agent", ASSRT_UA).send().await
            .map_err(|e| format!("字幕下载失败：{e}"))?;
        if !response.status().is_success() { return Err(format!("字幕下载失败：HTTP {}", response.status())); }
        response.bytes().await.map_err(|e| e.to_string())?
    } else if is_assrt && !is_media {
        // Assrt 字幕详情页：解析下载地址 -> 不跟随重定向拿 location -> 下载（对齐 Android getSubtitleUrlFromAssrt）
        let page = client
            .get(parsed.clone())
            .header("User-Agent", ASSRT_UA)
            .header("Referer", ASSRT_REFERER)
            .send()
            .await
            .map_err(|e| format!("字幕页面获取失败：{e}"))?;
        let html = page.text().await.map_err(|e| e.to_string())?;
        let Some(download) = assrt_page_download_url(&html) else {
            return Err("未找到字幕下载地址（可能需登录或字幕已失效）".into());
        };
        let no_redirect = crate::tvbox::apply_dns(reqwest::Client::builder())
            .timeout(Duration::from_secs(20))
            .redirect(reqwest::redirect::Policy::none())
            .build()
            .map_err(|e| e.to_string())?;
        let resp = no_redirect
            .get(&download)
            .header("User-Agent", ASSRT_UA)
            .header("Referer", ASSRT_REFERER)
            .send()
            .await
            .map_err(|e| format!("字幕下载失败：{e}"))?;
        let status = resp.status();
        let target = if status.is_redirection() {
            resp.headers()
                .get("location")
                .and_then(|v| v.to_str().ok())
                .map(|v| v.to_string())
                .ok_or("字幕下载跳转地址缺失")?
        } else if status.is_success() {
            download.clone()
        } else {
            return Err(format!("字幕下载失败：HTTP {status}"));
        };
        let resp2 = client
            .get(&target)
            .header("User-Agent", ASSRT_UA)
            .header("Referer", ASSRT_REFERER)
            .send()
            .await
            .map_err(|e| format!("字幕下载失败：{e}"))?;
        if !resp2.status().is_success() {
            return Err(format!("字幕下载失败：HTTP {}", resp2.status()));
        }
        resp2.bytes().await.map_err(|e| e.to_string())?
    } else {
        let response = client
            .get(parsed.clone())
            .header("User-Agent", TVBOX_UA)
            .send()
            .await
            .map_err(|e| format!("字幕下载失败：{e}"))?;
        if !response.status().is_success() {
            return Err(format!("字幕下载失败：HTTP {}", response.status()));
        }
        response.bytes().await.map_err(|e| e.to_string())?
    };
    let files = if bytes.starts_with(b"PK") {
        unzip_subtitles(&bytes)?
    } else {
        let ext = ["srt", "ass", "ssa", "vtt", "sub"].iter()
            .find(|e|parsed.path().to_lowercase().ends_with(&format!(".{e}"))).copied().unwrap_or("srt");
        vec![("字幕".to_string(), bytes.to_vec(), ext.to_string())]
    };
    use std::hash::{Hash, Hasher};
    let mut hasher = std::collections::hash_map::DefaultHasher::new();
    url.hash(&mut hasher);
    let folder = std::env::temp_dir().join("simpletools-subs");
    std::fs::create_dir_all(&folder).map_err(|e| e.to_string())?;
    let mut choices=Vec::new();
    for (index,(name,data,ext)) in files.into_iter().enumerate() {
        if data.is_empty() || data.len()>8*1024*1024 { return Err("字幕内容为空或超过 8MB".into()); }
        let file=folder.join(format!("sub-{:x}-{index}.{ext}",hasher.finish()));
        std::fs::write(&file,&data).map_err(|e|e.to_string())?;
        choices.push(serde_json::json!({"name":name,"path":file.to_string_lossy()}));
    }
    Ok(choices)
}

/// 用配置里的字幕接口搜索在线字幕（宽松兼容标准数组 / subtitles / Subs 等返回格式）
#[tauri::command]
pub async fn tvbox_subtitle_search(apis: Vec<String>, name: String) -> Result<Vec<SubtitleItem>, String> {
    let name = name.trim().to_string();
    if name.is_empty() {
        return Err("缺少影片名".into());
    }
    let encoded = encode_component(&name);
    let client = crate::tvbox::apply_dns(reqwest::Client::builder())
        .timeout(Duration::from_secs(10))
        .build()
        .map_err(|e| e.to_string())?;
    // 配置没有字幕接口时使用 Assrt 官方 JSON API；网页搜索页已失效，不能再抓 HTML。
    if apis.iter().all(|a| a.trim().is_empty()) {
        return Ok(assrt_search(&client, &name).await);
    }
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


// ===== 内置 Assrt（字幕库）在线字幕 =====
const ASSRT_REFERER: &str = "https://secure.assrt.net";
const ASSRT_UA: &str = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.54 Safari/537.36";
// AssrtOSS/mpv-assrt 面向开源客户端公开的共享 token；个人配置接口仍优先于此兜底。
const ASSRT_OSS_TOKEN: &str = "tNjXZUnOJWcHznHDyalNMYqqP6IdDdpQ";

async fn assrt_search(client: &reqwest::Client, name: &str) -> Vec<SubtitleItem> {
    let url = format!("https://api.assrt.net/v1/sub/search?token={}&cnt=20&q={}", ASSRT_OSS_TOKEN, encode_component(name));
    let mut out = Vec::new();
    let Ok(response) = client.get(&url).header("User-Agent", ASSRT_UA).send().await else { return out };
    let Ok(value) = response.json::<serde_json::Value>().await else { return out };
    for sub in value.pointer("/sub/subs").and_then(|v| v.as_array()).into_iter().flatten() {
        let id = sub.get("id").and_then(|v| v.as_i64()).map(|v| v.to_string())
            .or_else(|| sub.get("id").and_then(|v| v.as_str()).map(str::to_owned)).unwrap_or_default();
        if id.is_empty() { continue; }
        let title = sub.get("native_name").or_else(|| sub.get("videoname")).and_then(|v| v.as_str()).unwrap_or("字幕");
        let lang = sub.pointer("/lang/desc").and_then(|v| v.as_str()).unwrap_or("");
        let detail = format!("https://api.assrt.net/v1/sub/detail?token={ASSRT_OSS_TOKEN}&id={id}");
        out.push(SubtitleItem { title: title.chars().take(100).collect(), lang: lang.to_string(), url: detail });
    }
    out
}

/// 从 Assrt 字幕详情页解析下载地址：压缩包 download('id','-','file') 优先，其次直链
fn assrt_page_download_url(html: &str) -> Option<String> {
    if let Some(pos) = html.find("download('") {
        let rest = &html[pos + "download('".len()..];
        let parts: Vec<&str> = rest.split('\'').collect();
        if parts.len() >= 5 {
            return Some(format!("https://secure.assrt.net/download/{}/-/{}/{}", parts[0], parts[2], parts[4]));
        }
    }
    let lower = html.to_lowercase();
    for ext in [".srt", ".ass", ".ssa", ".vtt", ".scc", ".ttml"] {
        let mut start = 0;
        while let Some(idx) = lower[start..].find(ext) {
            let end = start + idx + ext.len();
            if let Some(href_pos) = lower[..end].rfind("href=\"") {
                let value = &html[href_pos + 6..];
                if let Some(q) = value.find('"') {
                    let href = &value[..q];
                    let href = if href.starts_with("http") { href.to_string() } else { format!("https://assrt.net{href}") };
                    return Some(href);
                }
            }
            start = end;
        }
    }
    None
}

/// 解压 zip 中的第一个字幕文件，返回（内容，扩展名）
fn assrt_subtitle_files(sub: &serde_json::Value) -> Vec<serde_json::Value> {
    let mut files=Vec::new();
    for file in sub.get("filelist").and_then(|v|v.as_array()).into_iter().flatten() {
        let name=file.get("f").and_then(|v|v.as_str()).unwrap_or("");
        let Some(url)=file.get("url").and_then(|v|v.as_str()) else {continue};
        if ![".srt",".ass",".ssa",".vtt",".sub"].iter().any(|e|name.to_lowercase().ends_with(e)){continue;}
        if !tauri::Url::parse(url).map(|u|matches!(u.scheme(),"http"|"https")).unwrap_or(false){continue;}
        if !files.iter().any(|f:&serde_json::Value|f["url"].as_str()==Some(url)) {
            files.push(serde_json::json!({"name":name,"url":url}));
        }
    }
    files
}

fn unzip_subtitles(bytes: &[u8]) -> Result<Vec<(String,Vec<u8>,String)>, String> {
    let mut archive=zip::ZipArchive::new(std::io::Cursor::new(bytes)).map_err(|e|format!("字幕压缩包解析失败：{e}"))?;
    let mut files=Vec::new();let mut total=0usize;
    for i in 0..archive.len() {
        let mut entry=archive.by_index(i).map_err(|e|e.to_string())?;
        if entry.is_dir(){continue;}
        let name=entry.name().to_string();let lower=name.to_lowercase();
        let Some(ext)=["srt","ass","ssa","vtt","sub"].iter().find(|e|lower.ends_with(&format!(".{e}"))) else {continue};
        if files.len()>=100 || entry.size()>8*1024*1024{return Err("字幕包文件数量或单文件大小超限".into());}
        use std::io::Read;
        let mut data=Vec::new();entry.by_ref().take(8*1024*1024+1).read_to_end(&mut data).map_err(|e|e.to_string())?;
        total+=data.len();if data.len()>8*1024*1024 || total>64*1024*1024{return Err("字幕包解压大小超限".into());}
        if !data.is_empty(){files.push((name,data,ext.to_string()));}
    }
    if files.is_empty(){return Err("字幕压缩包里没有字幕文件".into());}
    Ok(files)
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

    #[test]
    fn subtitle_candidates_preserve_files_and_ignore_non_subtitles() {
        let files=assrt_subtitle_files(&serde_json::json!({"filelist":[
            {"f":"中文.srt","url":"https://example.test/a"},
            {"f":"English.ASS","url":"https://example.test/b"},
            {"f":"duplicate.srt","url":"https://example.test/a"},
            {"f":"readme.txt","url":"https://example.test/c"},
            {"f":"bad.srt","url":"file:///bad"}]}));
        assert_eq!(files.len(),2);assert_eq!(files[1]["name"],"English.ASS");
        use std::io::Write;
        let mut archive=zip::ZipWriter::new(std::io::Cursor::new(Vec::new()));
        for (name,data) in [("nested/中文.srt","first"),("English.ass","second"),("readme.txt","ignore")] {
            archive.start_file(name,zip::write::SimpleFileOptions::default()).unwrap();
            archive.write_all(data.as_bytes()).unwrap();
        }
        let bytes=archive.finish().unwrap().into_inner();let entries=unzip_subtitles(&bytes).unwrap();
        assert_eq!(entries.len(),2);assert_eq!(entries[0].0,"nested/中文.srt");
        assert_eq!(entries[1].1,b"second");assert_eq!(entries[1].2,"ass");
    }

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
        assert!(out.starts_with("{"), "输出应为 JSON，实际：{}", utf8_prefix(&out, 20));
        assert!(out.contains("sites"));
    }


    #[test]
    fn utf8_prefix_never_splits_chinese_text() {
        let value = "abc，中文内容";
        assert_eq!(utf8_prefix(value, 5), "abc");
        assert_eq!(utf8_prefix(value, 6), "abc，");
        assert_eq!(utf8_prefix(value, 999), value);
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
