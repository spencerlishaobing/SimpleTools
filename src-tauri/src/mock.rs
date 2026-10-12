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
    net::{IpAddr, SocketAddr},
    path::PathBuf,
    sync::{Arc, Mutex},
    time::{Duration, SystemTime, UNIX_EPOCH},
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

/// 运行信息（面板展示）
#[derive(Debug, Clone, Serialize)]
pub struct MockInfo {
    pub running: bool,
    pub port: u16,
    /// 本机局域网 IPv4 列表（客户端接口地址填其一）
    pub addrs: Vec<String>,
    pub rule_count: usize,
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

fn build_info(app: &AppHandle, state: &MockState) -> MockInfo {
    let running = state.runtime.lock().unwrap().stop_tx.is_some();
    let rule_count = state.rules.lock().unwrap().len();
    let _ = app; // 预留：后续如需展示规则文件路径
    MockInfo {
        running,
        port: MOCK_PORT,
        addrs: local_ipv4s(),
        rule_count,
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
    Ok(())
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
