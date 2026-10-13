//! 抓包（v0.35.0）：MITM HTTP/S 代理（手机设置代理指向本机后实时捕获请求 / 响应）
//!
//! 工作方式：
//! - 明文 HTTP：请求直接转发到目标服务器并记录
//! - HTTPS：客户端 CONNECT 隧道建立后，用动态签发的域名证书做中间人（MITM）解密流量，
//!   因此手机上必须先安装「导出证书」得到的根证书，否则 HTTPS 请求会因证书不受信任而失败
//! - 记录只保存在内存（上限 2000 条，超出淘汰最早），重启应用即清空
//!
//! 数据流：hyper 请求 → CaptureHandler 记录（hudsucker 对每个请求 clone 一个 handler
//!        实例，天然配对请求 / 响应）→ Store（Mutex 保护）→ 事件 capture-session
//!        （仅摘要，降低 IPC 压力）推送前端列表 → 前端点击条目用 capture_detail 拉完整详情

use crate::datadir;
use hudsucker::{
    certificate_authority::RcgenAuthority,
    hyper::{
        header::{HeaderMap, CONTENT_ENCODING, CONTENT_LENGTH, CONTENT_TYPE},
        Method, Request, Response, StatusCode, Uri,
    },
    hyper_util::client::legacy::Error as ClientError,
    rcgen::{
        BasicConstraints, CertificateParams, DistinguishedName, DnType, IsCa, KeyPair,
        KeyUsagePurpose,
    },
    Body, HttpContext, HttpHandler, Proxy, RequestOrResponse,
};
use http_body_util::{BodyExt, Full};
use serde::Serialize;
use std::{
    collections::VecDeque,
    fs,
    io::Read,
    net::{IpAddr, SocketAddr},
    path::PathBuf,
    sync::{Arc, Mutex},
    time::{Duration, Instant, SystemTime, UNIX_EPOCH},
};
use tauri::{AppHandle, Emitter, Manager, State};
use tracing::{field::Field, Level, Subscriber};
use tracing_subscriber::{
    layer::{Context as TraceContext, Layer, SubscriberExt},
    registry::LookupSpan,
    util::SubscriberInitExt,
};

/// 代理监听端口（手机代理设置里填写本机 IP + 此端口）
pub const PROXY_PORT: u16 = 8888;
/// 诊断信息环形缓冲上限（连接失败 / TLS 握手失败等，v0.50.0）
const DIAG_MAX: usize = 100;
/// 内存中最多保留的会话条数（超出淘汰最早的）
const MAX_SESSIONS: usize = 2000;
/// 请求 / 响应正文记录上限（单侧 256KB，超出截断）
const BODY_KEEP: usize = 256 * 1024;
/// 响应正文超过 1MB（Content-Length 已知）时不做收集（大文件下载不拦正文）
const RES_COLLECT_MAX: u64 = 1024 * 1024;
/// 解压记录的读取上限（防解压炸弹把内存撑爆）
const DECODE_MAX: u64 = (BODY_KEEP * 2) as u64;

// ---------------------------------------------------------------------------
// 数据模型
// ---------------------------------------------------------------------------

/// 会话摘要（推送给前端列表；不含 headers / 正文以降低 IPC 压力）
#[derive(Debug, Clone, Serialize)]
pub struct SessionBrief {
    pub id: u64,
    /// 请求开始时间（毫秒时间戳）
    pub at: u64,
    pub method: String,
    /// http / https
    pub scheme: String,
    pub host: String,
    pub port: u16,
    /// 路径 + 查询串
    pub path: String,
    /// 响应状态码（0 = 连接失败未取得响应）
    pub status: u16,
    /// done（正常完成）/ error（转发失败）
    pub state: String,
    /// 失败原因（state == error 时）
    pub error: String,
    /// 耗时（毫秒）
    pub duration: u64,
    /// 响应 Content-Type 主类型（不含 charset 等参数）
    pub content_type: String,
    pub req_size: u64,
    pub res_size: u64,
}

/// 会话完整记录（capture_detail 返回；正文为文本，超限截断，非文本标记为 [二进制]）
#[derive(Debug, Clone, Serialize)]
pub struct SessionFull {
    #[serde(flatten)]
    pub brief: SessionBrief,
    pub req_headers: Vec<(String, String)>,
    pub req_body: String,
    pub req_truncated: bool,
    pub res_headers: Vec<(String, String)>,
    pub res_body: String,
    pub res_truncated: bool,
    /// 响应正文过大 / 流式类型，未收集
    pub res_skipped: bool,
}

/// 抓包运行信息（前端面板展示：运行状态 / 手机代理设置指引 / 证书路径）
#[derive(Debug, Clone, Serialize)]
pub struct CaptureInfo {
    pub running: bool,
    pub port: u16,
    /// 本机局域网 IPv4 列表（手机代理主机名填其一）
    pub addrs: Vec<String>,
    /// 根证书文件路径（数据目录内，导出后给手机安装）
    pub ca_file: String,
}

/// 内存会话仓库
#[derive(Default)]
struct Store {
    next_id: u64,
    sessions: VecDeque<SessionFull>,
}

/// 代理运行句柄（停止信号 + 后台任务）
#[derive(Default)]
struct ProxyRuntime {
    stop_tx: Option<tokio::sync::oneshot::Sender<()>>,
    task: Option<tauri::async_runtime::JoinHandle<()>>,
}

/// 抓包诊断条目（v0.50.0）：捕获 hudsucker 内部警告 / 错误（上游连接失败 / TLS 握手失败 /
/// 转发失败等），帮助用户定位「部分 APP 抓不到包」的原因
#[derive(Debug, Clone, Serialize)]
pub struct DiagEntry {
    /// 时间（毫秒时间戳）
    pub at: u64,
    /// 级别：错误 / 警告
    pub level: String,
    pub message: String,
}

/// 抓包全局状态（tauri manage）
#[derive(Default)]
pub struct CaptureState {
    store: Arc<Mutex<Store>>,
    runtime: Mutex<ProxyRuntime>,
    /// 诊断环形缓冲（v0.50.0）
    diag: Arc<Mutex<VecDeque<DiagEntry>>>,
}

// ---------------------------------------------------------------------------
// 请求记录（handler）
// ---------------------------------------------------------------------------

/// 单个请求的暂存信息：hudsucker 对每个请求 clone 一个 handler 实例，
/// 同一实例先后收到 handle_request / handle_response，因此直接存字段即可安全配对
struct Pending {
    at: u64,
    start: Instant,
    method: String,
    scheme: String,
    host: String,
    port: u16,
    path: String,
    req_headers: Vec<(String, String)>,
    req_body: String,
    req_truncated: bool,
    req_size: u64,
}

/// MITM 代理的 HTTP 处理器：只做记录（不修改请求 / 响应），全量透传
struct CaptureHandler {
    store: Arc<Mutex<Store>>,
    app: AppHandle,
    pending: Option<Pending>,
}

impl Clone for CaptureHandler {
    /// hudsucker 对每个请求 clone 一个实例；clone 出的新实例从「无暂存信息」开始
    fn clone(&self) -> Self {
        Self {
            store: Arc::clone(&self.store),
            app: self.app.clone(),
            pending: None,
        }
    }
}

impl CaptureHandler {
    /// 会话入库并通过事件推送摘要给前端列表（此处统一分配自增 id）
    fn record(&self, mut session: SessionFull) {
        let brief = {
            let mut store = self.store.lock().unwrap();
            session.brief.id = store.next_id;
            store.next_id += 1;
            let brief = session.brief.clone();
            store.sessions.push_back(session);
            while store.sessions.len() > MAX_SESSIONS {
                store.sessions.pop_front();
            }
            brief
        };
        let _ = self.app.emit("capture-session", &brief);
    }

    /// 失败会话（连不上目标服务器等）
    fn record_error(&self, pending: Pending, error: String) {
        let brief = SessionBrief {
            id: 0,
            at: pending.at,
            method: pending.method,
            scheme: pending.scheme,
            host: pending.host,
            port: pending.port,
            path: pending.path,
            status: 0,
            state: "error".into(),
            error,
            duration: pending.start.elapsed().as_millis() as u64,
            content_type: String::new(),
            req_size: pending.req_size,
            res_size: 0,
        };
        let session = SessionFull {
            brief,
            req_headers: pending.req_headers,
            req_body: pending.req_body,
            req_truncated: pending.req_truncated,
            res_headers: Vec::new(),
            res_body: String::new(),
            res_truncated: false,
            res_skipped: false,
        };
        self.record(session);
    }
}

impl HttpHandler for CaptureHandler {
    async fn handle_request(&mut self, _ctx: &HttpContext, req: Request<Body>) -> RequestOrResponse {
        // CONNECT 请求本身不算业务请求（真正的内容在隧道内再进来），原样透传
        if req.method() == Method::CONNECT {
            return RequestOrResponse::Request(req);
        }

        let (parts, body) = req.into_parts();
        let at = now_ms();
        let start = Instant::now();
        let (scheme, host, port, path) = parse_uri(&parts.uri);

        // 读取请求体（转发使用完整 body，记录只保留前 256KB）
        let (req_body, req_truncated, req_size, forward_body) = match body.collect().await {
            Ok(collected) => {
                // to_bytes 会消费 Collected，转发的 Body 由 Bytes 重建（零额外拷贝）
                let bytes = collected.to_bytes();
                let decoded = decode_body(&parts.headers, &bytes);
                let (text, truncated) = body_to_text(&decoded, BODY_KEEP);
                let size = bytes.len() as u64;
                (text, truncated, size, Body::from(Full::new(bytes)))
            }
            Err(_) => (String::new(), false, 0, Body::empty()),
        };

        self.pending = Some(Pending {
            at,
            start,
            method: parts.method.as_str().to_string(),
            scheme,
            host,
            port,
            path,
            req_headers: headers_to_vec(&parts.headers),
            req_body,
            req_truncated,
            req_size,
        });

        RequestOrResponse::Request(Request::from_parts(parts, forward_body))
    }

    async fn handle_response(&mut self, _ctx: &HttpContext, res: Response<Body>) -> Response<Body> {
        let Some(pending) = self.pending.take() else {
            // 无法配对（理论不出现）：仅透传
            return res;
        };

        let (parts, body) = res.into_parts();
        let status = parts.status.as_u16();
        let res_headers = headers_to_vec(&parts.headers);
        let content_type = content_type_of(&parts.headers);
        let content_length = parts
            .headers
            .get(CONTENT_LENGTH)
            .and_then(|v| v.to_str().ok())
            .and_then(|v| v.trim().parse::<u64>().ok());

        let (res_body, res_truncated, res_skipped, res_size, forward_body) =
            if should_skip_res_body(content_length, &content_type) {
                // 大响应 / 流式类型：不收集正文，原样透传
                (String::new(), false, true, content_length.unwrap_or(0), body)
            } else {
                match body.collect().await {
                    Ok(collected) => {
                        let bytes = collected.to_bytes();
                        let size = bytes.len() as u64;
                        let decoded = decode_body(&parts.headers, &bytes);
                        let (text, truncated) = body_to_text(&decoded, BODY_KEEP);
                        (text, truncated, false, size, Body::from(Full::new(bytes)))
                    }
                    Err(_) => (String::new(), false, true, 0, Body::empty()),
                }
            };

        let session = SessionFull {
            brief: SessionBrief {
                id: 0,
                at: pending.at,
                method: pending.method,
                scheme: pending.scheme,
                host: pending.host,
                port: pending.port,
                path: pending.path,
                status,
                state: "done".into(),
                error: String::new(),
                duration: pending.start.elapsed().as_millis() as u64,
                content_type,
                req_size: pending.req_size,
                res_size,
            },
            req_headers: pending.req_headers,
            req_body: pending.req_body,
            req_truncated: pending.req_truncated,
            res_headers,
            res_body,
            res_truncated,
            res_skipped,
        };
        self.record(session);

        Response::from_parts(parts, forward_body)
    }

    async fn handle_error(&mut self, _ctx: &HttpContext, err: ClientError) -> Response<Body> {
        if let Some(pending) = self.pending.take() {
            let detail = error_chain(&err);
            // v0.50.0：本实现覆盖了 hudsucker 默认 handle_error（其内部会输出 error! 日志），
            // 此处主动上报诊断（连接失败 / TLS 报错等，帮助定位「部分 APP 抓不到」）
            tracing::error!(
                target: "hudsucker::capture",
                "上游转发失败（{}:{}）：{}",
                pending.host,
                pending.port,
                detail
            );
            self.record_error(pending, detail);
        }
        Response::builder()
            .status(StatusCode::BAD_GATEWAY)
            .header(CONTENT_TYPE, "text/plain; charset=utf-8")
            .body(Body::from("SimpleTools 代理：无法连接目标服务器"))
            .expect("构建 502 响应失败")
    }
}

// ---------------------------------------------------------------------------
// 工具函数
// ---------------------------------------------------------------------------

fn now_ms() -> u64 {
    SystemTime::now()
        .duration_since(UNIX_EPOCH)
        .map(|d| d.as_millis() as u64)
        .unwrap_or(0)
}

/// 从请求 URI 提取 scheme / host / port / path（h1 明文为完整绝对 URI；
/// HTTPS 隧道内由 hudsucker 补全 scheme 与 authority）
fn parse_uri(uri: &Uri) -> (String, String, u16, String) {
    let scheme = uri.scheme_str().unwrap_or("http").to_string();
    let host = uri.host().unwrap_or("").to_string();
    let port = uri
        .port_u16()
        .unwrap_or(if scheme == "https" { 443 } else { 80 });
    let path = uri
        .path_and_query()
        .map(|p| p.as_str().to_string())
        .unwrap_or_else(|| "/".to_string());
    (scheme, host, port, path)
}

fn headers_to_vec(headers: &HeaderMap) -> Vec<(String, String)> {
    headers
        .iter()
        .map(|(k, v)| {
            (
                k.as_str().to_string(),
                String::from_utf8_lossy(v.as_bytes()).into_owned(),
            )
        })
        .collect()
}

/// 响应 Content-Type 主类型（去掉 charset 等参数，供列表展示）
fn content_type_of(headers: &HeaderMap) -> String {
    headers
        .get(CONTENT_TYPE)
        .and_then(|v| v.to_str().ok())
        .map(|v| v.split(';').next().unwrap_or("").trim().to_string())
        .unwrap_or_default()
}

/// 大响应 / 流式类型不做正文收集（避免长连接卡住、下载占内存）
fn should_skip_res_body(content_length: Option<u64>, content_type: &str) -> bool {
    if let Some(len) = content_length {
        if len > RES_COLLECT_MAX {
            return true;
        }
    }
    const SKIP_PREFIX: [&str; 6] = [
        "text/event-stream",
        "application/octet-stream",
        "video/",
        "audio/",
        "image/",
        "font/",
    ];
    SKIP_PREFIX.iter().any(|p| content_type.starts_with(p))
}

/// 按 Content-Encoding 解压记录用副本（失败 / 不认识则原样返回；转发不受影响）
fn decode_body(headers: &HeaderMap, body: &[u8]) -> Vec<u8> {
    let Some(enc) = headers.get(CONTENT_ENCODING).and_then(|v| v.to_str().ok()) else {
        return body.to_vec();
    };
    match enc.trim().to_ascii_lowercase().as_str() {
        "gzip" | "x-gzip" => read_limited(flate2::read::GzDecoder::new(body))
            .unwrap_or_else(|| body.to_vec()),
        "deflate" => read_limited(flate2::read::ZlibDecoder::new(body))
            .or_else(|| read_limited(flate2::read::DeflateDecoder::new(body)))
            .unwrap_or_else(|| body.to_vec()),
        "br" => {
            read_limited(brotli::Decompressor::new(body, 4096)).unwrap_or_else(|| body.to_vec())
        }
        _ => body.to_vec(),
    }
}

/// 最多读取 DECODE_MAX 字节（防解压炸弹；够记录展示即可）
fn read_limited<R: Read>(reader: R) -> Option<Vec<u8>> {
    let mut out = Vec::new();
    reader.take(DECODE_MAX).read_to_end(&mut out).ok()?;
    Some(out)
}

/// 字节转可读文本：UTF-8 文本原样；截断打在多字节字符中间取有效前缀；真二进制给出提示
fn body_to_text(bytes: &[u8], keep: usize) -> (String, bool) {
    let truncated = bytes.len() > keep;
    let slice = &bytes[..bytes.len().min(keep)];
    match std::str::from_utf8(slice) {
        Ok(s) => (s.to_string(), truncated),
        Err(e) if e.error_len().is_none() => {
            // 仅因截断在多字节字符中间导致的失败：取有效前缀
            (
                String::from_utf8_lossy(&slice[..e.valid_up_to()]).into_owned(),
                truncated,
            )
        }
        Err(_) => (format!("[二进制内容 {} 字节]", bytes.len()), truncated),
    }
}

/// 错误链文本（如 "client error (Connect) -> tcp connect error -> ..."），便于定位失败原因
fn error_chain(err: &ClientError) -> String {
    let mut msg = err.to_string();
    let mut src = std::error::Error::source(err);
    while let Some(s) = src {
        msg.push_str(" -> ");
        msg.push_str(&s.to_string());
        src = s.source();
    }
    msg
}

/// 本机局域网 IPv4 列表（过滤回环与链路本地地址）
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
    ips.dedup();
    ips
}

/// CA 文件路径（key / cert 均在数据目录内，跟随「数据目录」设置迁移）
fn ca_files(app: &AppHandle) -> Result<(PathBuf, PathBuf), String> {
    let dir = datadir::data_dir(app)?;
    Ok((dir.join("capture-ca.key"), dir.join("capture-ca.pem")))
}

/// 确保根证书存在：首次使用时生成并落盘，之后复用（保证手机已安装的证书长期有效）
fn ensure_ca(app: &AppHandle) -> Result<RcgenAuthority, String> {
    let (key_path, cert_path) = ca_files(app)?;
    let (key_pem, cert_pem) = if key_path.exists() && cert_path.exists() {
        (
            fs::read_to_string(&key_path).map_err(|e| format!("读取证书私钥失败: {e}"))?,
            fs::read_to_string(&cert_path).map_err(|e| format!("读取证书失败: {e}"))?,
        )
    } else {
        let key_pair = KeyPair::generate().map_err(|e| format!("生成密钥失败: {e}"))?;
        let mut params = CertificateParams::new(Vec::<String>::new())
            .map_err(|e| format!("构造证书参数失败: {e}"))?;
        params.is_ca = IsCa::Ca(BasicConstraints::Unconstrained);
        params.key_usages = vec![
            KeyUsagePurpose::KeyCertSign,
            KeyUsagePurpose::CrlSign,
            KeyUsagePurpose::DigitalSignature,
        ];
        let mut dn = DistinguishedName::new();
        dn.push(DnType::OrganizationName, "SimpleTools");
        dn.push(DnType::CommonName, "SimpleTools Capture CA");
        params.distinguished_name = dn;
        let cert = params
            .self_signed(&key_pair)
            .map_err(|e| format!("签发证书失败: {e}"))?;

        let key_pem = key_pair.serialize_pem();
        let cert_pem = cert.pem();
        if let Some(parent) = key_path.parent() {
            fs::create_dir_all(parent).map_err(|e| format!("创建数据目录失败: {e}"))?;
        }
        fs::write(&key_path, &key_pem).map_err(|e| format!("保存证书私钥失败: {e}"))?;
        fs::write(&cert_path, &cert_pem).map_err(|e| format!("保存证书失败: {e}"))?;
        (key_pem, cert_pem)
    };

    let key_pair = KeyPair::from_pem(&key_pem).map_err(|e| format!("解析证书私钥失败: {e}"))?;
    let cert_params = CertificateParams::from_ca_cert_pem(&cert_pem)
        .map_err(|e| format!("解析证书失败: {e}"))?;
    let ca_cert = cert_params
        .self_signed(&key_pair)
        .map_err(|e| format!("恢复证书失败: {e}"))?;
    Ok(RcgenAuthority::new(key_pair, ca_cert, 1000))
}

fn build_info(app: &AppHandle, state: &CaptureState) -> CaptureInfo {
    let running = state.runtime.lock().unwrap().stop_tx.is_some();
    CaptureInfo {
        running,
        port: PROXY_PORT,
        addrs: local_ipv4s(),
        ca_file: ca_files(app)
            .map(|(_, cert)| datadir::display_path(&cert))
            .unwrap_or_default(),
    }
}

// ---------------------------------------------------------------------------
// Tauri 命令
// ---------------------------------------------------------------------------

/// 查询抓包运行信息（面板打开 / 状态刷新时调用）
#[tauri::command]
pub fn capture_info(app: AppHandle, state: State<'_, CaptureState>) -> CaptureInfo {
    build_info(&app, &state)
}

/// 启动代理（监听 0.0.0.0:8888；端口占用等失败直接返回原因）
#[tauri::command]
pub async fn capture_start(app: AppHandle, state: State<'_, CaptureState>) -> Result<CaptureInfo, String> {
    // 注意：所有锁都在独立语句块内获取并释放，避免在持锁状态下调用会再次加锁的
    // build_info（std::sync::Mutex 不可重入，否则死锁）
    let running = {
        let rt = state.runtime.lock().unwrap();
        rt.stop_tx.is_some()
    };
    if running {
        return Ok(build_info(&app, &state));
    }

    let ca = ensure_ca(&app)?;

    // 先绑定监听：端口被占用等错误在这里立即返回给前端提示
    let addr: SocketAddr = ([0, 0, 0, 0], PROXY_PORT).into();
    let listener = match tokio::net::TcpListener::bind(addr).await {
        Ok(l) => l,
        Err(_) => {
            // 快速「停止 → 启动」时旧连接可能还在优雅关闭，稍等重试一次
            tokio::time::sleep(Duration::from_millis(600)).await;
            tokio::net::TcpListener::bind(addr).await.map_err(|e| {
                format!("无法监听 {PROXY_PORT} 端口：{e}（请检查是否被其他程序占用）")
            })?
        }
    };

    let (stop_tx, stop_rx) = tokio::sync::oneshot::channel::<()>();
    let handler = CaptureHandler {
        store: state.store.clone(),
        app: app.clone(),
        pending: None,
    };
    let proxy = Proxy::builder()
        .with_listener(listener)
        // v0.50.0：上游 TLS 改用系统栈（Windows schannel）——信任系统根证书库：
        // 覆盖国内 CA / 用户手动信任的证书（此前 webpki-roots 内置列表不包含它们，
        // 导致部分 APP 的服务器握手失败抓不到），同时兼容更宽的 TLS 版本范围
        .with_native_tls_client()
        .with_ca(ca)
        .with_http_handler(handler)
        .with_graceful_shutdown(async move {
            let _ = stop_rx.await;
        })
        .build();
    let task = tauri::async_runtime::spawn(async move {
        let _ = proxy.start().await;
    });

    {
        let mut rt = state.runtime.lock().unwrap();
        rt.stop_tx = Some(stop_tx);
        rt.task = Some(task);
    }
    Ok(build_info(&app, &state))
}

/// 停止代理（最多等 2.5 秒优雅关闭；客户端长连接可能使端口稍后才释放）
#[tauri::command]
pub async fn capture_stop(state: State<'_, CaptureState>) -> Result<(), String> {
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

// ---------------------------------------------------------------------------
// 抓包诊断（v0.50.0）
// ---------------------------------------------------------------------------

/// 诊断捕获层：只处理 hudsucker 目标（含内部模块）的 WARN / ERROR 事件，
/// 写入环形缓冲并实时推送前端（事件 capture-diag）
struct DiagLayer {
    diag: Arc<Mutex<VecDeque<DiagEntry>>>,
    app: AppHandle,
}

impl<S> Layer<S> for DiagLayer
where
    S: Subscriber + for<'a> LookupSpan<'a>,
{
    fn on_event(&self, event: &tracing::Event<'_>, _ctx: TraceContext<'_, S>) {
        let meta = event.metadata();
        if !meta.target().starts_with("hudsucker") {
            return;
        }
        let level = *meta.level();
        if level != Level::WARN && level != Level::ERROR {
            return;
        }
        struct MsgVisitor {
            msg: String,
        }
        impl tracing::field::Visit for MsgVisitor {
            fn record_str(&mut self, field: &Field, value: &str) {
                if field.name() == "message" {
                    self.msg = value.to_string();
                }
            }
            fn record_debug(&mut self, field: &Field, value: &dyn std::fmt::Debug) {
                if field.name() == "message" && self.msg.is_empty() {
                    self.msg = format!("{value:?}").trim_matches('"').to_string();
                }
            }
        }
        let mut v = MsgVisitor {
            msg: String::new(),
        };
        event.record(&mut v);
        if v.msg.is_empty() {
            return;
        }
        let entry = DiagEntry {
            at: now_ms(),
            level: if level == Level::ERROR { "错误".to_string() } else { "警告".to_string() },
            message: v.msg,
        };
        {
            let mut d = self.diag.lock().unwrap();
            d.push_back(entry.clone());
            while d.len() > DIAG_MAX {
                d.pop_front();
            }
        }
        let _ = self.app.emit("capture-diag", &entry);
    }
}

/// 安装诊断捕获层（应用启动时调用一次；已有全局 subscriber 时静默跳过）
pub fn init_diag(app: AppHandle) {
    let diag = app.state::<CaptureState>().diag.clone();
    let layer = DiagLayer { diag, app };
    let _ = tracing_subscriber::registry().with(layer).try_init();
}

/// 诊断列表（最近 100 条，供前端诊断面板拉取）
#[tauri::command]
pub fn capture_diag_list(state: State<'_, CaptureState>) -> Vec<DiagEntry> {
    state.diag.lock().unwrap().iter().cloned().collect()
}

/// 清空诊断列表
#[tauri::command]
pub fn capture_diag_clear(state: State<'_, CaptureState>) {
    state.diag.lock().unwrap().clear();
}

/// 全量会话摘要（面板打开时拉取已有记录）
#[tauri::command]
pub fn capture_list(state: State<'_, CaptureState>) -> Vec<SessionBrief> {
    state
        .store
        .lock()
        .unwrap()
        .sessions
        .iter()
        .map(|s| s.brief.clone())
        .collect()
}

/// 会话详细内容（headers + 正文）
#[tauri::command]
pub fn capture_detail(state: State<'_, CaptureState>, id: u64) -> Option<SessionFull> {
    state
        .store
        .lock()
        .unwrap()
        .sessions
        .iter()
        .find(|s| s.brief.id == id)
        .cloned()
}

/// 清空全部会话记录
#[tauri::command]
pub fn capture_clear(state: State<'_, CaptureState>) {
    state.store.lock().unwrap().sessions.clear();
}

/// 导出根证书（PEM，供手机安装）；path 由前端通过保存对话框选择
#[tauri::command]
pub fn capture_export_ca(app: AppHandle, path: String) -> Result<(), String> {
    let (_, cert_path) = ca_files(&app)?;
    if !cert_path.exists() {
        let _ = ensure_ca(&app)?;
    }
    let pem = fs::read_to_string(&cert_path).map_err(|e| format!("读取证书失败: {e}"))?;
    fs::write(&path, pem).map_err(|e| format!("写入失败: {e}"))?;
    Ok(())
}

// ---------------------------------------------------------------------------
// 测试
// ---------------------------------------------------------------------------

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn parse_uri_fields() {
        let uri: Uri = "https://api.example.com:8443/v1/list?page=2".parse().unwrap();
        let (scheme, host, port, path) = parse_uri(&uri);
        assert_eq!(scheme, "https");
        assert_eq!(host, "api.example.com");
        assert_eq!(port, 8443);
        assert_eq!(path, "/v1/list?page=2");

        let uri: Uri = "http://1.2.3.4/x".parse().unwrap();
        let (scheme, _, port, path) = parse_uri(&uri);
        assert_eq!(scheme, "http");
        assert_eq!(port, 80);
        assert_eq!(path, "/x");
    }

    #[test]
    fn body_text_plain_and_truncated() {
        let (text, truncated) = body_to_text(b"hello", 10);
        assert_eq!(text, "hello");
        assert!(!truncated);

        let (text, truncated) = body_to_text(b"0123456789abc", 10);
        assert_eq!(text, "0123456789");
        assert!(truncated);
    }

    #[test]
    fn body_text_utf8_boundary() {
        // "中文" 3 字节/字：截断到 4 字节会切在第二个字中间，应取有效前缀
        let bytes = "中文".as_bytes();
        let (text, truncated) = body_to_text(bytes, 4);
        assert_eq!(text, "中");
        assert!(truncated);
    }

    #[test]
    fn body_text_binary_marked() {
        let bytes = [0u8, 159, 146, 150, 255];
        let (text, _) = body_to_text(&bytes, 100);
        assert!(text.starts_with("[二进制内容"));
    }

    #[test]
    fn decode_gzip_roundtrip() {
        use flate2::{write::GzEncoder, Compression};
        use std::io::Write;

        let raw = r#"{"ok":true,"msg":"你好"}"#;
        let mut enc = GzEncoder::new(Vec::new(), Compression::default());
        enc.write_all(raw.as_bytes()).unwrap();
        let gz = enc.finish().unwrap();

        let mut headers = HeaderMap::new();
        headers.insert(CONTENT_ENCODING, "gzip".parse().unwrap());
        let decoded = decode_body(&headers, &gz);
        assert_eq!(String::from_utf8(decoded).unwrap(), raw);

        // 无 Content-Encoding 时原样返回
        let plain = decode_body(&HeaderMap::new(), raw.as_bytes());
        assert_eq!(plain, raw.as_bytes());
    }

    #[test]
    fn skip_large_or_stream() {
        assert!(should_skip_res_body(Some(RES_COLLECT_MAX + 1), "application/json"));
        assert!(should_skip_res_body(None, "text/event-stream; charset=utf-8"));
        assert!(should_skip_res_body(Some(100), "image/png"));
        assert!(!should_skip_res_body(Some(100), "application/json"));
        assert!(!should_skip_res_body(None, "text/html; charset=utf-8"));
    }

    #[test]
    fn content_type_main_only() {
        let mut headers = HeaderMap::new();
        headers.insert(CONTENT_TYPE, "application/json; charset=utf-8".parse().unwrap());
        assert_eq!(content_type_of(&headers), "application/json");
        assert_eq!(content_type_of(&HeaderMap::new()), "");
    }
}
