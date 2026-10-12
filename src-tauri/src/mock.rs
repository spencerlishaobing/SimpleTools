//! 模拟服务器（v0.36.0）：本地 HTTP 接口模拟 + 请求采集
//!
//! 用途：在电脑上启动一个 HTTP 服务端，客户端（App / 浏览器 / 其他设备）把接口地址指向
//! 本机后，请求会被完整记录（请求头 + 请求参数 / 正文）并返回预先配置的响应，便于在没有
//! 真实后端时联调、抓取客户端发出的请求内容。
//!
//! 工作方式：
//! - 监听 0.0.0.0:8899（所有网卡）：同网段设备直接访问；跨网段 / 外网配合内网穿透工具
//!   （frp / ngrok 等）把本端口映射出去即可访问
//! - 规则匹配：方法（ANY 或指定）+ 路径（精确匹配，忽略尾部斜杠；以 * 结尾时前缀通配，
//!   如 /api/*）→ 返回配置的状态码与响应体；未匹配的请求同样记录并返回 404
//! - OPTIONS 预检统一返回 204 + CORS 头（不记录），浏览器页面可直接跨域请求
//! - 请求记录保存在内存（上限 500 条，超出淘汰最早），接口规则持久化于数据目录 mock-rules.json

use crate::datadir;
use http_body_util::{BodyExt, Full};
use hyper::{
    body::{Bytes, Incoming},
    header::CONTENT_TYPE,
    server::conn::http1,
    service::service_fn,
    Method, Request, Response, StatusCode,
};
use hyper_util::rt::TokioIo;
use serde::{Deserialize, Serialize};
use std::{
    collections::VecDeque,
    fs,
    net::{IpAddr, Ipv4Addr, Ipv6Addr, SocketAddr},
    path::PathBuf,
    sync::{Arc, Mutex},
    time::{Duration, Instant, SystemTime, UNIX_EPOCH},
};
use tauri::{AppHandle, Emitter, Manager, State};

/// 服务监听端口（客户端接口地址填写 http://本机IP:此端口）
pub const MOCK_PORT: u16 = 8899;
/// 内存中最多保留的请求记录条数（超出淘汰最早的）
const MAX_REQUESTS: usize = 500;
/// 请求正文记录上限（单侧 256KB，超出截断）
const BODY_KEEP: usize = 256 * 1024;
/// 规则配置文件（数据目录内，随数据目录迁移）
const RULES_FILE: &str = "mock-rules.json";
/// 允许的请求方法（ANY = 匹配任意方法）
const ALLOWED_METHODS: [&str; 7] = ["ANY", "GET", "POST", "PUT", "DELETE", "PATCH", "HEAD"];

// ---------------------------------------------------------------------------
// 数据模型
// ---------------------------------------------------------------------------

/// 已配置的模拟接口（规则）
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct MockRule {
    pub id: u64,
    /// ANY / GET / POST / PUT / DELETE / PATCH / HEAD
    pub method: String,
    /// 请求路径：精确匹配（忽略尾部斜杠）；以 * 结尾时前缀通配（如 /api/*）
    pub path: String,
    /// 命中后返回的状态码
    pub status: u16,
    /// 命中后返回的响应体（JSON / 文本）
    pub body: String,
}

/// 规则输入（新增时前端提交；id 由后端分配）
#[derive(Debug, Clone, Deserialize)]
pub struct RuleInput {
    pub method: String,
    pub path: String,
    pub status: u16,
    pub body: String,
}

/// 请求记录摘要（事件推送 + 列表展示）
#[derive(Debug, Clone, Serialize)]
pub struct MockRequestBrief {
    pub id: u64,
    /// 请求时间（毫秒时间戳）
    pub at: u64,
    pub method: String,
    /// 路径 + 查询串
    pub path: String,
    /// 仅路径部分（用于展示）
    pub source: String,
    /// 是否命中已配置接口
    pub matched: bool,
    /// 返回给客户端的状态码
    pub status: u16,
    pub req_size: u64,
}

/// 请求完整记录（展开详情时按需拉取）
#[derive(Debug, Clone, Serialize)]
pub struct MockRequestFull {
    #[serde(flatten)]
    pub brief: MockRequestBrief,
    /// 原始查询串（无则空）
    pub query: String,
    pub headers: Vec<(String, String)>,
    /// 请求 Content-Type（无则空）
    pub content_type: String,
    /// 请求正文（文本化，超限截断）
    pub body: String,
    pub body_truncated: bool,
}

/// UPnP 自动穿透状态（v0.39.0：通过路由器 IGD 协议自动开放外网端口，无需第三方软件）
#[derive(Debug, Clone, Default, Serialize)]
pub struct UpnpStatus {
    /// idle（未检测）/ pending（检测中）/ mapped（已映射）/ cgnat（运营商共享公网，无法直连）/ unsupported（路由器不支持）/ failed（映射失败）
    pub state: String,
    /// 公网访问地址（mapped 时：http://公网IP:端口）
    pub public_url: String,
    /// 状态说明 / 失败原因
    pub message: String,
}

/// 运行信息（面板展示）
#[derive(Debug, Clone, Serialize)]
pub struct MockInfo {
    pub running: bool,
    pub port: u16,
    /// 本机局域网 IPv4 列表（客户端接口地址填其一）
    pub addrs: Vec<String>,
    pub rule_count: usize,
    /// 本机公网 IPv6 地址列表（运营商支持时外网（IPv6）可直接访问，无需穿透）
    pub ipv6: Vec<String>,
    /// UPnP 自动穿透状态
    pub upnp: UpnpStatus,
}

// ---------------------------------------------------------------------------
// 全局状态
// ---------------------------------------------------------------------------

/// 内存请求仓库
#[derive(Default)]
struct Store {
    next_id: u64,
    requests: VecDeque<MockRequestFull>,
}

/// 服务运行句柄（停止信号 + 后台任务）
#[derive(Default)]
struct Runtime {
    stop_tx: Option<tokio::sync::oneshot::Sender<()>>,
    task: Option<tauri::async_runtime::JoinHandle<()>>,
}

/// 模拟服务器状态（tauri manage）
#[derive(Default)]
pub struct MockState {
    store: Arc<Mutex<Store>>,
    /// 规则列表（Arc 共享：服务运行中新增 / 删除的规则即时生效）
    rules: Arc<Mutex<Vec<MockRule>>>,
    runtime: Mutex<Runtime>,
    /// UPnP 自动穿透状态（服务启动后异步更新，事件 mock-upnp 推送前端）
    upnp: Arc<Mutex<UpnpStatus>>,
}

/// 应用启动时载入已保存的规则（lib.rs setup 调用）
pub fn init_load(app: &AppHandle) {
    let state = app.state::<MockState>();
    let rules = load_rules(app);
    *state.rules.lock().unwrap() = rules;
}

// ---------------------------------------------------------------------------
// 规则持久化与匹配
// ---------------------------------------------------------------------------

fn rules_path(app: &AppHandle) -> Result<PathBuf, String> {
    Ok(datadir::data_dir(app)?.join(RULES_FILE))
}

/// 读取规则文件（不存在 / 损坏时返回空表，不阻断应用运行）
fn load_rules(app: &AppHandle) -> Vec<MockRule> {
    let Ok(path) = rules_path(app) else {
        return Vec::new();
    };
    let Ok(data) = fs::read_to_string(&path) else {
        return Vec::new();
    };
    serde_json::from_str(&data).unwrap_or_default()
}

/// 写入规则文件（先写临时文件再重命名，避免写入中断损坏配置）
fn save_rules(app: &AppHandle, rules: &[MockRule]) -> Result<(), String> {
    let path = rules_path(app)?;
    if let Some(dir) = path.parent() {
        let _ = fs::create_dir_all(dir);
    }
    let data = serde_json::to_string_pretty(rules).map_err(|e| format!("序列化失败: {e}"))?;
    let tmp = path.with_extension("json.tmp");
    fs::write(&tmp, data).map_err(|e| format!("写入失败: {e}"))?;
    fs::rename(&tmp, &path).map_err(|e| format!("保存失败: {e}"))?;
    Ok(())
}

/// 校验并规范化规则输入（方法白名单 / 路径补前导斜杠 / 状态码与正文大小限制）
fn normalize_rule(input: RuleInput) -> Result<RuleInput, String> {
    let method = input.method.trim().to_ascii_uppercase();
    if !ALLOWED_METHODS.contains(&method.as_str()) {
        return Err(format!("不支持的请求方法：{method}"));
    }
    let mut path = input.path.trim().to_string();
    if path.is_empty() {
        return Err("请填写接口路径".into());
    }
    if !path.starts_with('/') {
        path.insert(0, '/');
    }
    if path.len() > 512 {
        return Err("路径过长（最多 512 字符）".into());
    }
    if !(100..=599).contains(&input.status) {
        return Err("状态码需在 100 - 599 之间".into());
    }
    if input.body.len() > 1024 * 1024 {
        return Err("响应体过大（最多 1MB）".into());
    }
    Ok(RuleInput {
        method,
        path,
        status: input.status,
        body: input.body,
    })
}

/// 路径归一化：去掉尾部斜杠（根路径保留 "/"）
fn norm_path(p: &str) -> &str {
    let t = p.trim_end_matches('/');
    if t.is_empty() {
        "/"
    } else {
        t
    }
}

/// 规则是否命中：方法一致（ANY 匹配任意）+ 路径精确（忽略尾斜杠）或前缀通配（* 结尾）
fn rule_matches(rule: &MockRule, method: &Method, path: &str) -> bool {
    if rule.method != "ANY" && rule.method != method.as_str() {
        return false;
    }
    if let Some(prefix) = rule.path.strip_suffix('*') {
        return path.starts_with(prefix);
    }
    norm_path(path) == norm_path(&rule.path)
}

// ---------------------------------------------------------------------------
// HTTP 处理
// ---------------------------------------------------------------------------

fn now_ms() -> u64 {
    SystemTime::now()
        .duration_since(UNIX_EPOCH)
        .map(|d| d.as_millis() as u64)
        .unwrap_or(0)
}

/// 正文文本化：UTF-8 边界安全截断（超限时只保留前 BODY_KEEP 字节）
fn body_to_text(bytes: &[u8]) -> (String, bool) {
    let truncated = bytes.len() > BODY_KEEP;
    let slice = if truncated { &bytes[..BODY_KEEP] } else { bytes };
    // 截断点可能落在多字节字符中间：向前找到最近的合法 UTF-8 边界
    let end = (0..=slice.len())
        .rev()
        .find(|&i| std::str::from_utf8(&slice[..i]).is_ok())
        .unwrap_or(0);
    (
        String::from_utf8_lossy(&slice[..end]).to_string(),
        truncated,
    )
}

fn headers_to_vec(headers: &hyper::HeaderMap) -> Vec<(String, String)> {
    headers
        .iter()
        .map(|(k, v)| {
            (
                k.as_str().to_string(),
                v.to_str().unwrap_or("<非文本头>").to_string(),
            )
        })
        .collect()
}

/// 按正文内容猜测响应 Content-Type（JSON 结构返回 application/json，其余 text/plain）
fn guess_content_type(body: &str) -> &'static str {
    let t = body.trim_start();
    if t.starts_with('{') || t.starts_with('[') {
        "application/json"
    } else {
        "text/plain"
    }
}

/// 构造响应：统一附带 CORS 头（方便浏览器页面直接跨域请求）
fn build_response(status: u16, body: String) -> Response<Full<Bytes>> {
    let ctype = format!("{}; charset=utf-8", guess_content_type(&body));
    Response::builder()
        .status(StatusCode::from_u16(status).unwrap_or(StatusCode::OK))
        .header(CONTENT_TYPE, ctype)
        .header("Access-Control-Allow-Origin", "*")
        .header(
            "Access-Control-Allow-Methods",
            "GET, POST, PUT, DELETE, PATCH, HEAD, OPTIONS",
        )
        .header("Access-Control-Allow-Headers", "*")
        .body(Full::new(Bytes::from(body)))
        .unwrap_or_else(|_| Response::new(Full::new(Bytes::new())))
}

/// 单个请求处理：匹配规则 → 记录 → 返回响应
async fn handle(
    app: AppHandle,
    store: Arc<Mutex<Store>>,
    rules: Arc<Mutex<Vec<MockRule>>>,
    peer: SocketAddr,
    req: Request<Incoming>,
) -> Result<Response<Full<Bytes>>, hyper::Error> {
    let method = req.method().clone();
    let uri = req.uri().clone();
    let path = uri.path().to_string();
    let query = uri.query().unwrap_or("").to_string();
    let req_headers = headers_to_vec(req.headers());
    let content_type = req
        .headers()
        .get(CONTENT_TYPE)
        .and_then(|v| v.to_str().ok())
        .unwrap_or("")
        .to_string();

    // 浏览器预检请求：直接 204 + CORS，不记录（避免刷屏）
    if method == Method::OPTIONS {
        return Ok(build_response(StatusCode::NO_CONTENT.as_u16(), String::new()));
    }

    // 读取请求体（记录用；文本化超限截断）
    let (body, body_truncated, req_size) = match req.into_body().collect().await {
        Ok(collected) => {
            let bytes = collected.to_bytes();
            let size = bytes.len() as u64;
            let (text, truncated) = body_to_text(&bytes);
            (text, truncated, size)
        }
        Err(_) => (String::new(), false, 0),
    };

    // 匹配规则（锁内查找并克隆命中规则，尽快释放锁）
    let matched_rule = {
        let list = rules.lock().unwrap();
        list.iter()
            .find(|r| rule_matches(r, &method, &path))
            .cloned()
    };
    let (status, resp_body, matched) = match matched_rule {
        Some(r) => (r.status, r.body, true),
        None => (
            404,
            "{\"code\": 404, \"message\": \"未匹配到已配置的模拟接口\"}".to_string(),
            false,
        ),
    };

    // 记录请求并推送摘要给前端列表
    let brief = {
        let mut s = store.lock().unwrap();
        let id = s.next_id;
        s.next_id += 1;
        let brief = MockRequestBrief {
            id,
            at: now_ms(),
            method: method.as_str().to_string(),
            path: if query.is_empty() {
                path.clone()
            } else {
                format!("{path}?{query}")
            },
            source: peer.ip().to_string(),
            matched,
            status,
            req_size,
        };
        s.requests.push_back(MockRequestFull {
            brief: brief.clone(),
            query,
            headers: req_headers,
            content_type,
            body,
            body_truncated,
        });
        while s.requests.len() > MAX_REQUESTS {
            s.requests.pop_front();
        }
        brief
    };
    let _ = app.emit("mock-request", &brief);

    Ok(build_response(status, resp_body))
}

/// 本机局域网 IPv4 列表（过滤回环与链路本地地址；客户端接口地址填其一）
fn local_ipv4s() -> Vec<String> {
    let mut ips: Vec<String> = local_ip_address::list_afinet_netifas()
        .map(|list| {
            list.into_iter()
                .filter_map(|(_, ip)| match ip {
                    IpAddr::V4(v4) if !v4.is_loopback() && !v4.is_link_local() => {
                        Some(v4.to_string())
                    }
                    _ => None,
                })
                .collect()
        })
        .unwrap_or_default();
    ips.sort();
    ips
}

/// 是否为公网 IPv6 地址（2000::/3 全球单播，过滤回环 / 链路本地 / ULA）
fn is_global_ipv6(v6: &Ipv6Addr) -> bool {
    let seg = v6.segments()[0];
    !v6.is_loopback() && !v6.is_unicast_link_local() && (seg & 0xe000) == 0x2000
}

/// 本机公网 IPv6 地址列表（运营商支持时，外网（IPv6）设备可直接访问，无需穿透）
fn public_ipv6s() -> Vec<String> {
    let mut ips: Vec<String> = local_ip_address::list_afinet_netifas()
        .map(|list| {
            list.into_iter()
                .filter_map(|(_, ip)| match ip {
                    IpAddr::V6(v6) if is_global_ipv6(&v6) => Some(v6.to_string()),
                    _ => None,
                })
                .collect()
        })
        .unwrap_or_default();
    ips.sort();
    ips
}

/// 主局域网 IPv4（与 local_ipv4s 排序后第一个一致；UPnP 映射的目标地址）
fn primary_ipv4() -> Option<Ipv4Addr> {
    local_ip_address::list_afinet_netifas()
        .ok()?
        .into_iter()
        .filter_map(|(_, ip)| match ip {
            IpAddr::V4(v4) if !v4.is_loopback() && !v4.is_link_local() => Some(v4),
            _ => None,
        })
        .min()
}

// ---------------------------------------------------------------------------
// UPnP 穿透（v0.40.0：自实现 SSDP 发现 + SOAP 控制协议，不依赖任何第三方穿透库）
// 流程：SSDP（UDP 组播 239.255.255.250:1900）发现网关 → 拉取设备描述 XML 解析
//       WAN 连接服务（WANIPConnection / WANPPPConnection）控制地址 → SOAP 调用
//       GetExternalIPAddress / AddPortMapping / DeletePortMapping
// ---------------------------------------------------------------------------

/// SSDP 搜索目标（依次尝试：IGD v1 / IGD v2 / rootdevice）
const SSDP_TARGETS: [&str; 3] = [
    "urn:schemas-upnp-org:device:InternetGatewayDevice:1",
    "urn:schemas-upnp-org:device:InternetGatewayDevice:2",
    "upnp:rootdevice",
];

/// SSDP 批量搜索：在单一套接字上依次发送多个搜索目标（避免串行超时叠加），
/// 在统一超时窗口内收集响应中的设备描述 URL（LOCATION，去重）
fn ssdp_search_all(targets: &[&str], timeout: Duration) -> Vec<String> {
    use std::net::UdpSocket;
    let Ok(socket) = UdpSocket::bind("0.0.0.0:0") else {
        return Vec::new();
    };
    for target in targets {
        let search = format!(
            "M-SEARCH * HTTP/1.1\r\nHOST: 239.255.255.250:1900\r\nMAN: \"ssdp:discover\"\r\nMX: 2\r\nST: {target}\r\n\r\n"
        );
        let _ = socket.send_to(search.as_bytes(), "239.255.255.250:1900");
        std::thread::sleep(Duration::from_millis(60)); // 避免连续突发丢包
    }
    let deadline = Instant::now() + timeout;
    let mut buf = [0u8; 4096];
    let mut found: Vec<String> = Vec::new();
    loop {
        let remain = deadline.saturating_duration_since(Instant::now());
        if remain.is_zero() {
            break;
        }
        let _ = socket.set_read_timeout(Some(remain));
        match socket.recv_from(&mut buf) {
            Ok((n, _)) => {
                let text = String::from_utf8_lossy(&buf[..n]);
                if let Some(loc) = http_header_value(&text, "location") {
                    if !loc.is_empty() && !found.contains(&loc) {
                        found.push(loc);
                        if found.len() >= 4 {
                            break; // 足够尝试，无需等待更多设备响应
                        }
                    }
                }
            }
            Err(_) => break, // 超时 / 无更多响应
        }
    }
    found
}

/// 从 HTTP 报文头（含 SSDP 响应）取值：大小写不敏感，取首个匹配行
fn http_header_value(text: &str, name: &str) -> Option<String> {
    for line in text.lines() {
        let line = line.trim_end_matches('\r');
        if line.is_empty() {
            break; // 头部结束
        }
        if let Some((k, v)) = line.split_once(':') {
            if k.trim().eq_ignore_ascii_case(name) {
                return Some(v.trim().to_string());
            }
        }
    }
    None
}

/// 在 XML 中查找标签（宽松匹配命名空间前缀：<tag> 或 <ns:tag>），
/// 返回（匹配起点, 值起点即 '>' 之后）
fn xml_find_tag(xml: &str, tag: &str) -> Option<(usize, usize)> {
    let direct = format!("<{tag}>");
    if let Some(p) = xml.find(&direct) {
        return Some((p, p + direct.len()));
    }
    let with_prefix = format!(":{tag}>");
    xml.find(&with_prefix).map(|p| (p, p + with_prefix.len()))
}

/// 提取 XML 标签值（宽松匹配命名空间前缀；取 '>' 之后到下一个 '<' 之间的内容）
fn xml_tag_value(xml: &str, tag: &str) -> Option<String> {
    let (_, value_start) = xml_find_tag(xml, tag)?;
    let rest = &xml[value_start..];
    let end = rest.find('<').unwrap_or(rest.len());
    Some(rest[..end].trim().to_string())
}

/// 相对 controlURL 拼成绝对地址（基于设备描述 URL 的 scheme://host[:port]）
fn abs_url(base: &str, url: &str) -> String {
    if url.starts_with("http://") {
        return url.to_string();
    }
    let host_port = base
        .strip_prefix("http://")
        .and_then(|r| r.split('/').next())
        .unwrap_or(base);
    let path = if url.starts_with('/') {
        url.to_string()
    } else {
        format!("/{url}")
    };
    format!("http://{host_port}{path}")
}

/// 极简 chunked 解码（个别路由器返回分块编码）
fn dechunk(body: &str) -> String {
    let mut out = String::new();
    let mut rest = body;
    loop {
        let Some(nl) = rest.find("\r\n") else { break };
        let size_str = rest[..nl].split(';').next().unwrap_or("").trim();
        let Ok(size) = usize::from_str_radix(size_str, 16) else {
            break;
        };
        if size == 0 {
            break;
        }
        let start = nl + 2;
        if start + size > rest.len() {
            out.push_str(&rest[start..]);
            break;
        }
        out.push_str(&rest[start..start + size]);
        let next = &rest[start + size..];
        rest = next.strip_prefix("\r\n").unwrap_or(next);
    }
    out
}

/// 极简 HTTP/1.1 请求（仅用于局域网路由器交互：短报文，兼容 Content-Length / chunked / close）
fn http_request(
    url: &str,
    method: &str,
    headers: &[(&str, &str)],
    body: &[u8],
) -> Result<(u16, String), String> {
    use std::io::{Read, Write};
    use std::net::ToSocketAddrs;
    let rest = url
        .strip_prefix("http://")
        .ok_or_else(|| format!("不支持的地址协议：{url}"))?;
    let (host_port, path) = match rest.find('/') {
        Some(i) => (&rest[..i], &rest[i..]),
        None => (rest, "/"),
    };
    let (host, port) = match host_port.rsplit_once(':') {
        Some((h, p)) => (h, p.parse::<u16>().unwrap_or(80)),
        None => (host_port, 80u16),
    };
    let sock_addr = format!("{host}:{port}")
        .to_socket_addrs()
        .map_err(|e| format!("解析路由器地址失败：{e}"))?
        .next()
        .ok_or_else(|| "无法解析路由器地址".to_string())?;
    let mut stream = std::net::TcpStream::connect_timeout(&sock_addr, Duration::from_secs(4))
        .map_err(|e| format!("连接路由器失败：{e}"))?;
    let _ = stream.set_read_timeout(Some(Duration::from_secs(5)));
    let mut req = format!(
        "{method} {path} HTTP/1.1\r\nHost: {host_port}\r\nUser-Agent: SimpleTools\r\nConnection: close\r\n"
    );
    for (k, v) in headers {
        req.push_str(&format!("{k}: {v}\r\n"));
    }
    if !body.is_empty() {
        req.push_str(&format!("Content-Length: {}\r\n", body.len()));
    }
    req.push_str("\r\n");
    stream
        .write_all(req.as_bytes())
        .map_err(|e| format!("发送请求失败：{e}"))?;
    if !body.is_empty() {
        stream
            .write_all(body)
            .map_err(|e| format!("发送请求体失败：{e}"))?;
    }
    let mut raw = Vec::new();
    let _ = stream.read_to_end(&mut raw); // Connection: close：读到 EOF
    let text = String::from_utf8_lossy(&raw);
    let (head, body_text) = match text.find("\r\n\r\n") {
        Some(i) => (&text[..i], text[i + 4..].to_string()),
        None => (&text[..], String::new()),
    };
    let status: u16 = head
        .split_whitespace()
        .nth(1)
        .and_then(|c| c.parse().ok())
        .unwrap_or(0);
    let chunked = http_header_value(head, "transfer-encoding")
        .map(|v| v.to_ascii_lowercase().contains("chunked"))
        .unwrap_or(false);
    let body_out = if chunked { dechunk(&body_text) } else { body_text };
    Ok((status, body_out))
}

/// 从设备描述 XML 解析 WAN 连接服务（WANIPConnection / WANPPPConnection）的控制地址
fn parse_gateway_control(desc: &str, location: &str) -> Option<(String, String)> {
    let mut pos = 0usize;
    while let Some((_, value_start)) = xml_find_tag(&desc[pos..], "serviceType") {
        let abs = pos + value_start;
        let rest = &desc[abs..];
        let end = rest.find('<').unwrap_or(rest.len());
        let service = rest[..end].trim().to_string();
        pos = abs + end;
        if service.contains("WANIPConnection") || service.contains("WANPPPConnection") {
            if let Some((_, cu_start)) = xml_find_tag(&desc[pos..], "controlURL") {
                let cabs = pos + cu_start;
                let crest = &desc[cabs..];
                let cend = crest.find('<').unwrap_or(crest.len());
                let control = crest[..cend].trim().to_string();
                if !control.is_empty() {
                    return Some((abs_url(location, &control), service));
                }
            }
        }
    }
    None
}

/// 拉取设备描述并解析网关控制信息
fn fetch_gateway_control(location: &str) -> Result<(String, String), String> {
    let (status, body) = http_request(location, "GET", &[], &[])?;
    if status != 200 {
        return Err(format!("读取路由器设备描述失败（HTTP {status}）"));
    }
    parse_gateway_control(&body, location).ok_or_else(|| {
        "路由器描述中未找到 WAN 连接服务（WANIPConnection / WANPPPConnection）".to_string()
    })
}

/// 发现网关控制信息：批量 SSDP 搜索后逐个尝试解析，首个成功即返回（控制地址, 服务类型）
fn discover_gateway(timeout: Duration) -> Result<(String, String), String> {
    let mut last_err =
        String::from("未发现支持 UPnP 的路由器（SSDP 无响应）：可在路由器设置中开启 UPnP 后重试");
    for loc in ssdp_search_all(&SSDP_TARGETS, timeout) {
        match fetch_gateway_control(&loc) {
            Ok(info) => return Ok(info),
            Err(e) => last_err = e,
        }
    }
    Err(last_err)
}

/// SOAP 调用（UPnP 控制协议）
fn soap_call(control_url: &str, service: &str, action: &str, args: &str) -> Result<String, String> {
    let body = format!(
        "<?xml version=\"1.0\"?>\r\n<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"><s:Body><u:{action} xmlns:u=\"{service}\">{args}</u:{action}></s:Body></s:Envelope>"
    );
    let soap_action = format!("\"{service}#{action}\"");
    let (status, resp) = http_request(
        control_url,
        "POST",
        &[
            ("Content-Type", "text/xml; charset=\"utf-8\""),
            ("SOAPAction", soap_action.as_str()),
        ],
        body.as_bytes(),
    )?;
    if status != 200 {
        let code = xml_tag_value(&resp, "errorCode").unwrap_or_default();
        let desc = xml_tag_value(&resp, "errorDescription").unwrap_or_default();
        return Err(format!("路由器返回错误（HTTP {status} {code} {desc}）"));
    }
    Ok(resp)
}

/// 查询路由器外网地址（GetExternalIPAddress）
fn upnp_external_ip(control: &str, service: &str) -> Result<String, String> {
    let resp = soap_call(control, service, "GetExternalIPAddress", "")?;
    xml_tag_value(&resp, "NewExternalIPAddress").ok_or_else(|| "路由器未返回外网地址".to_string())
}

/// 添加端口映射（AddPortMapping；租约 0 = 永久）
fn upnp_add_port(control: &str, service: &str, port: u16, local_ip: Ipv4Addr) -> Result<(), String> {
    let args = format!(
        "<NewRemoteHost></NewRemoteHost><NewExternalPort>{port}</NewExternalPort><NewProtocol>TCP</NewProtocol><NewInternalPort>{port}</NewInternalPort><NewInternalClient>{local_ip}</NewInternalClient><NewEnabled>1</NewEnabled><NewPortMappingDescription>SimpleTools Mock Server</NewPortMappingDescription><NewLeaseDuration>0</NewLeaseDuration>"
    );
    soap_call(control, service, "AddPortMapping", &args).map(|_| ())
}

/// 删除端口映射（DeletePortMapping）
fn upnp_delete_port(control: &str, service: &str, port: u16) -> Result<(), String> {
    let args = format!(
        "<NewRemoteHost></NewRemoteHost><NewExternalPort>{port}</NewExternalPort><NewProtocol>TCP</NewProtocol>"
    );
    soap_call(control, service, "DeletePortMapping", &args).map(|_| ())
}

/// 尝试通过路由器 UPnP（自实现 SSDP + SOAP）自动开放外网端口（阻塞调用，在 blocking 线程中执行）
fn try_upnp_map(port: u16, local_ip: Ipv4Addr) -> UpnpStatus {
    let (control, service) = match discover_gateway(Duration::from_secs(2)) {
        Ok(v) => v,
        Err(e) => {
            return UpnpStatus {
                state: "unsupported".into(),
                public_url: String::new(),
                message: e,
            };
        }
    };
    let external = match upnp_external_ip(&control, &service) {
        Ok(ip) => ip,
        Err(e) => {
            return UpnpStatus {
                state: "failed".into(),
                public_url: String::new(),
                message: format!("获取路由器公网地址失败：{e}"),
            };
        }
    };
    let Ok(external_ip) = external.trim().parse::<Ipv4Addr>() else {
        return UpnpStatus {
            state: "failed".into(),
            public_url: String::new(),
            message: format!("路由器返回的公网地址无法解析：{external}"),
        };
    };
    // 运营商共享公网（CGNAT）：路由器 WAN 侧为内网地址 → 外网无法直连
    if external_ip.is_private()
        || external_ip.is_loopback()
        || external_ip.is_link_local()
        || external_ip.is_unspecified()
    {
        return UpnpStatus {
            state: "cgnat".into(),
            public_url: String::new(),
            message: format!(
                "路由器出口地址 {external_ip} 为内网地址（运营商共享公网 / CGNAT），外网无法直连"
            ),
        };
    }
    if let Err(e) = upnp_add_port(&control, &service, port, local_ip) {
        return UpnpStatus {
            state: "failed".into(),
            public_url: String::new(),
            message: format!("路由器端口映射失败：{e}"),
        };
    }
    UpnpStatus {
        state: "mapped".into(),
        public_url: format!("http://{external_ip}:{port}"),
        message: format!("已通过路由器 UPnP 自动开放外网端口（{local_ip}:{port}）"),
    }
}

/// 移除 UPnP 端口映射（自实现；重新发现网关后删除，尽力而为）
fn try_upnp_unmap(port: u16) {
    if let Ok((control, service)) = discover_gateway(Duration::from_secs(2)) {
        let _ = upnp_delete_port(&control, &service, port);
    }
}

fn build_info(app: &AppHandle, state: &MockState) -> MockInfo {
    let running = state.runtime.lock().unwrap().stop_tx.is_some();
    let rule_count = state.rules.lock().unwrap().len();
    let _ = app; // 预留：后续如需展示规则文件路径
    MockInfo {
        running,
        port: MOCK_PORT,
        addrs: local_ipv4s(),
        rule_count,
        ipv6: public_ipv6s(),
        upnp: state.upnp.lock().unwrap().clone(),
    }
}

// ---------------------------------------------------------------------------
// Tauri 命令
// ---------------------------------------------------------------------------

/// 查询运行信息（面板打开 / 状态刷新时调用）
#[tauri::command]
pub fn mock_info(app: AppHandle, state: State<'_, MockState>) -> MockInfo {
    build_info(&app, &state)
}

/// 启动服务（监听 0.0.0.0:8899；端口占用等失败直接返回原因）
#[tauri::command]
pub async fn mock_start(
    app: AppHandle,
    state: State<'_, MockState>,
) -> Result<MockInfo, String> {
    // 所有锁都在独立语句块内获取并释放，避免持锁状态下调用会再次加锁的 build_info（死锁）
    let running = {
        let rt = state.runtime.lock().unwrap();
        rt.stop_tx.is_some()
    };
    if running {
        return Ok(build_info(&app, &state));
    }

    // 先绑定监听：端口被占用等错误在这里立即返回给前端提示
    let addr: SocketAddr = ([0, 0, 0, 0], MOCK_PORT).into();
    let listener = match tokio::net::TcpListener::bind(addr).await {
        Ok(l) => l,
        Err(_) => {
            // 快速「停止 → 启动」时旧连接可能还在优雅关闭，稍等重试一次
            tokio::time::sleep(Duration::from_millis(600)).await;
            tokio::net::TcpListener::bind(addr)
                .await
                .map_err(|e| format!("无法监听 {MOCK_PORT} 端口：{e}（请检查是否被其他程序占用）"))?
        }
    };

    let (stop_tx, mut stop_rx) = tokio::sync::oneshot::channel::<()>();
    let store = state.store.clone();
    // 与命令共享同一份规则（Arc）：服务运行中增删规则即时生效
    let rules = state.rules.clone();
    let app_for_task = app.clone();
    let app_for_upnp = app.clone();

    let task = tauri::async_runtime::spawn(async move {
        loop {
            tokio::select! {
                _ = &mut stop_rx => break,
                accepted = listener.accept() => {
                    match accepted {
                        Ok((stream, peer)) => {
                            let app = app_for_task.clone();
                            let store = store.clone();
                            let rules = rules.clone();
                            tauri::async_runtime::spawn(async move {
                                let io = TokioIo::new(stream);
                                let service = service_fn(move |req| {
                                    handle(app.clone(), store.clone(), rules.clone(), peer, req)
                                });
                                // 请求处理错误（客户端断开等）忽略即可
                                let _ = http1::Builder::new()
                                    .keep_alive(true)
                                    .serve_connection(io, service)
                                    .await;
                            });
                        }
                        Err(_) => tokio::time::sleep(Duration::from_millis(50)).await,
                    }
                }
            }
        }
    });

    {
        let mut rt = state.runtime.lock().unwrap();
        rt.stop_tx = Some(stop_tx);
        rt.task = Some(task);
    }

    // UPnP 自动穿透（v0.39.0）：后台检测路由器并自动开放外网端口，完成后事件推送前端（不阻塞启动）
    {
        let mut st = state.upnp.lock().unwrap();
        *st = UpnpStatus {
            state: "pending".into(),
            public_url: String::new(),
            message: "正在检测路由器并尝试自动开放外网端口（UPnP）…".into(),
        };
    }
    let upnp_arc = state.upnp.clone();
    tauri::async_runtime::spawn_blocking(move || {
        let status = match primary_ipv4() {
            Some(ip) => try_upnp_map(MOCK_PORT, ip),
            None => UpnpStatus {
                state: "failed".into(),
                public_url: String::new(),
                message: "未找到局域网 IPv4 地址，无法自动穿透".into(),
            },
        };
        {
            let mut st = upnp_arc.lock().unwrap();
            *st = status.clone();
        }
        let _ = app_for_upnp.emit("mock-upnp", &status);
    });
    Ok(build_info(&app, &state))
}

/// 停止服务（最多等 2.5 秒优雅关闭；客户端长连接可能使端口稍后才释放）
#[tauri::command]
pub async fn mock_stop(state: State<'_, MockState>) -> Result<(), String> {
    let (tx, task) = {
        let mut rt = state.runtime.lock().unwrap();
        (rt.stop_tx.take(), rt.task.take())
    };
    if let Some(tx) = tx {
        let _ = tx.send(());
    }
    if let Some(task) = task {
        let _ = tokio::time::timeout(Duration::from_millis(2500), async move {
            let _ = task.await;
        })
        .await;
    }
    // UPnP 端口映射随服务停止一并移除（尽力而为，后台执行）；状态重置为未检测
    let was_mapped = {
        let mut st = state.upnp.lock().unwrap();
        let mapped = st.state == "mapped";
        *st = UpnpStatus::default();
        mapped
    };
    if was_mapped {
        tauri::async_runtime::spawn_blocking(move || try_upnp_unmap(MOCK_PORT));
    }
    Ok(())
}

/// 重新尝试 UPnP 自动穿透（路由器开启 UPnP 后手动重试；同步等待结果）
#[tauri::command]
pub async fn mock_public_retry(
    app: AppHandle,
    state: State<'_, MockState>,
) -> Result<UpnpStatus, String> {
    let running = {
        let rt = state.runtime.lock().unwrap();
        rt.stop_tx.is_some()
    };
    if !running {
        return Err("请先启动模拟服务".into());
    }
    // 立即进入检测中（面板同步展示），再后台阻塞检测
    {
        let mut st = state.upnp.lock().unwrap();
        *st = UpnpStatus {
            state: "pending".into(),
            public_url: String::new(),
            message: "正在重新检测路由器并尝试自动开放外网端口（UPnP）…".into(),
        };
    }
    let ip = primary_ipv4().ok_or("未找到局域网 IPv4 地址")?;
    let join = tauri::async_runtime::spawn_blocking(move || try_upnp_map(MOCK_PORT, ip));
    let status = match join.await {
        Ok(s) => s,
        Err(e) => {
            let s = UpnpStatus {
                state: "failed".into(),
                public_url: String::new(),
                message: format!("检测任务异常：{e}"),
            };
            {
                let mut st = state.upnp.lock().unwrap();
                *st = s.clone();
            }
            let _ = app.emit("mock-upnp", &s);
            return Ok(s);
        }
    };
    {
        let mut st = state.upnp.lock().unwrap();
        *st = status.clone();
    }
    let _ = app.emit("mock-upnp", &status);
    Ok(status)
}

/// 全部规则（面板打开 / 增删后刷新）
#[tauri::command]
pub fn mock_rules(state: State<'_, MockState>) -> Vec<MockRule> {
    state.rules.lock().unwrap().clone()
}

/// 新增规则（校验后持久化，返回全部规则）
#[tauri::command]
pub fn mock_rule_add(
    app: AppHandle,
    state: State<'_, MockState>,
    rule: RuleInput,
) -> Result<Vec<MockRule>, String> {
    let input = normalize_rule(rule)?;
    let all = {
        let mut list = state.rules.lock().unwrap();
        let next_id = list.iter().map(|r| r.id).max().unwrap_or(0) + 1;
        list.push(MockRule {
            id: next_id,
            method: input.method,
            path: input.path,
            status: input.status,
            body: input.body,
        });
        list.clone()
    };
    save_rules(&app, &all)?;
    Ok(all)
}

/// 删除规则（持久化，返回剩余规则）
#[tauri::command]
pub fn mock_rule_delete(
    app: AppHandle,
    state: State<'_, MockState>,
    id: u64,
) -> Result<Vec<MockRule>, String> {
    let all = {
        let mut list = state.rules.lock().unwrap();
        list.retain(|r| r.id != id);
        list.clone()
    };
    save_rules(&app, &all)?;
    Ok(all)
}

/// 全部请求记录摘要（面板打开时拉取已有记录）
#[tauri::command]
pub fn mock_requests(state: State<'_, MockState>) -> Vec<MockRequestBrief> {
    state
        .store
        .lock()
        .unwrap()
        .requests
        .iter()
        .map(|r| r.brief.clone())
        .collect()
}

/// 请求完整记录（展开详情时按需拉取）
#[tauri::command]
pub fn mock_request_detail(state: State<'_, MockState>, id: u64) -> Option<MockRequestFull> {
    state
        .store
        .lock()
        .unwrap()
        .requests
        .iter()
        .find(|r| r.brief.id == id)
        .cloned()
}

/// 清空全部请求记录
#[tauri::command]
pub fn mock_clear_requests(state: State<'_, MockState>) {
    state.store.lock().unwrap().requests.clear();
}

// ---------------------------------------------------------------------------
// 单元测试
// ---------------------------------------------------------------------------

#[cfg(test)]
mod tests {
    use super::{
        body_to_text, guess_content_type, normalize_rule, rule_matches, MockRule, RuleInput,
        BODY_KEEP,
    };
    use hyper::Method;

    fn rule(method: &str, path: &str) -> MockRule {
        MockRule {
            id: 1,
            method: method.into(),
            path: path.into(),
            status: 200,
            body: "{}".into(),
        }
    }

    /// 方法匹配：ANY 匹配任意方法，指定方法需一致
    #[test]
    fn rule_method_matching() {
        assert!(rule_matches(&rule("ANY", "/a"), &Method::GET, "/a"));
        assert!(rule_matches(&rule("GET", "/a"), &Method::GET, "/a"));
        assert!(!rule_matches(&rule("POST", "/a"), &Method::GET, "/a"));
    }

    /// 路径匹配：精确（忽略尾斜杠）/ 前缀通配 / 不误配
    #[test]
    fn rule_path_matching() {
        assert!(rule_matches(&rule("ANY", "/api/login"), &Method::GET, "/api/login"));
        assert!(rule_matches(&rule("ANY", "/api/login/"), &Method::GET, "/api/login"));
        assert!(!rule_matches(&rule("ANY", "/api/login"), &Method::GET, "/api/login2"));
        assert!(rule_matches(&rule("ANY", "/api/*"), &Method::GET, "/api/users/1"));
        assert!(!rule_matches(&rule("ANY", "/api/*"), &Method::GET, "/other/x"));
        assert!(rule_matches(&rule("ANY", "/"), &Method::GET, "/"));
    }

    /// 规则规范化：方法大写 / 路径补斜杠 / 非法输入拒绝
    #[test]
    fn normalize_rule_input() {
        let ok = normalize_rule(RuleInput {
            method: "post".into(),
            path: "api/x".into(),
            status: 200,
            body: "{}".into(),
        })
        .expect("应通过校验");
        assert_eq!(ok.method, "POST");
        assert_eq!(ok.path, "/api/x");
        assert!(normalize_rule(RuleInput {
            method: "FETCH".into(),
            path: "/a".into(),
            status: 200,
            body: String::new()
        })
        .is_err());
        assert!(normalize_rule(RuleInput {
            method: "GET".into(),
            path: "  ".into(),
            status: 200,
            body: String::new()
        })
        .is_err());
        assert!(normalize_rule(RuleInput {
            method: "GET".into(),
            path: "/a".into(),
            status: 99,
            body: String::new()
        })
        .is_err());
    }

    /// 公网 IPv6 判定：2000::/3 全球单播通过，回环 / 链路本地 / ULA 拒绝
    #[test]
    fn ipv6_global_filter() {
        use super::is_global_ipv6;
        use std::net::Ipv6Addr;
        assert!(is_global_ipv6(&"2409:8a00:1234::1".parse::<Ipv6Addr>().unwrap()));
        assert!(is_global_ipv6(&"2001:db8::1".parse::<Ipv6Addr>().unwrap()));
        assert!(!is_global_ipv6(&"::1".parse::<Ipv6Addr>().unwrap()));
        assert!(!is_global_ipv6(&"fe80::1".parse::<Ipv6Addr>().unwrap()));
        assert!(!is_global_ipv6(&"fd00::1".parse::<Ipv6Addr>().unwrap()));
        assert!(!is_global_ipv6(&"fc00::1".parse::<Ipv6Addr>().unwrap()));
        assert!(!is_global_ipv6(&"ff02::1".parse::<Ipv6Addr>().unwrap()));
    }

    /// XML 宽松解析（v0.40.0）：普通标签 / 命名空间前缀 / 缺失
    #[test]
    fn xml_parse_helpers() {
        use super::{xml_find_tag, xml_tag_value};
        assert_eq!(
            xml_tag_value("<a><Ip>1.2.3.4</Ip></a>", "Ip"),
            Some("1.2.3.4".into())
        );
        assert_eq!(
            xml_tag_value(
                "<u:Envelope><u:NewExternalIPAddress>5.6.7.8</u:NewExternalIPAddress></u:Envelope>",
                "NewExternalIPAddress"
            ),
            Some("5.6.7.8".into())
        );
        assert_eq!(xml_tag_value("<a></a>", "Ip"), None);
        assert!(xml_find_tag("<a><b>x</b>", "b").is_some());
        assert!(xml_find_tag("<a><ns:b>x</ns:b>", "b").is_some());
        assert!(xml_find_tag("<a><nb>x</nb>", "b").is_none());
    }

    /// HTTP 头解析（SSDP 响应 / SOAP 响应头）：大小写不敏感
    #[test]
    fn http_header_helpers() {
        use super::http_header_value;
        let resp = "HTTP/1.1 200 OK\r\nLOCATION: http://192.168.1.1:5000/rootDesc.xml\r\nServer: MiniUPnPd\r\n\r\n";
        assert_eq!(
            http_header_value(resp, "location").as_deref(),
            Some("http://192.168.1.1:5000/rootDesc.xml")
        );
        assert_eq!(
            http_header_value(resp, "LOCATION").as_deref(),
            Some("http://192.168.1.1:5000/rootDesc.xml")
        );
        assert_eq!(http_header_value(resp, "missing"), None);
    }

    /// controlURL 相对路径拼接成绝对地址
    #[test]
    fn abs_url_join() {
        use super::abs_url;
        assert_eq!(
            abs_url("http://192.168.1.1:5000/rootDesc.xml", "/ctl/IPConn"),
            "http://192.168.1.1:5000/ctl/IPConn"
        );
        assert_eq!(
            abs_url("http://192.168.1.1/rootDesc.xml", "upnp/control"),
            "http://192.168.1.1/upnp/control"
        );
        assert_eq!(
            abs_url("http://192.168.1.1/rootDesc.xml", "http://other/x"),
            "http://other/x"
        );
    }

    /// 设备描述解析：找到 WANIPConnection 的 controlURL（相对路径 + 服务类型）
    #[test]
    fn gateway_desc_parse() {
        use super::parse_gateway_control;
        let desc = r#"<?xml version="1.0"?>
<root xmlns="urn:schemas-upnp-org:device-1-0">
  <device>
    <deviceType>urn:schemas-upnp-org:device:InternetGatewayDevice:1</deviceType>
    <deviceList>
      <device>
        <deviceType>urn:schemas-upnp-org:device:WANDevice:1</deviceType>
        <deviceList>
          <device>
            <deviceType>urn:schemas-upnp-org:device:WANConnectionDevice:1</deviceType>
            <serviceList>
              <service>
                <serviceType>urn:schemas-upnp-org:service:WANIPConnection:1</serviceType>
                <serviceId>urn:upnp-org:serviceId:WANIPConn1</serviceId>
                <controlURL>/upnp/control/WANIPConn1</controlURL>
                <eventSubURL>/upnp/event/WANIPConn1</eventSubURL>
                <SCPDURL>/WANIPCn.xml</SCPDURL>
              </service>
            </serviceList>
          </device>
        </deviceList>
      </device>
    </deviceList>
  </device>
</root>"#;
        let (control, service) =
            parse_gateway_control(desc, "http://192.168.1.1:5000/rootDesc.xml")
                .expect("应解析出网关控制地址");
        assert_eq!(control, "http://192.168.1.1:5000/upnp/control/WANIPConn1");
        assert_eq!(service, "urn:schemas-upnp-org:service:WANIPConnection:1");
        assert!(parse_gateway_control("<root></root>", "http://x/").is_none());
    }

    /// chunked 解码
    #[test]
    fn dechunk_basic() {
        use super::dechunk;
        assert_eq!(dechunk("5\r\nhello\r\n0\r\n\r\n"), "hello");
        assert_eq!(dechunk("3\r\nabc\r\n4\r\ndefg\r\n0\r\n\r\n"), "abcdefg");
    }

    /// 正文文本化：超限截断且落在 UTF-8 边界（中文多字节安全）
    #[test]
    fn body_text_truncation() {
        let (t, trunc) = body_to_text("hello".as_bytes());
        assert_eq!(t, "hello");
        assert!(!trunc);
        // 构造超过上限的正文（ASCII 'a' 填充）
        let big = "a".repeat(BODY_KEEP + 10);
        let (t2, trunc2) = body_to_text(big.as_bytes());
        assert!(trunc2);
        assert_eq!(t2.len(), BODY_KEEP);
    }

    /// Content-Type 猜测：JSON 结构 → application/json
    #[test]
    fn content_type_guess() {
        assert_eq!(guess_content_type("{\"a\":1}"), "application/json");
        assert_eq!(guess_content_type("  [1,2]"), "application/json");
        assert_eq!(guess_content_type("ok"), "text/plain");
    }
}
