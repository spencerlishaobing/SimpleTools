use http_body_util::{BodyExt, Full, Limited};
use hyper::{
    body::{Bytes, Incoming},
    Request, Response, StatusCode,
};
use std::{
    convert::Infallible,
    sync::{
        atomic::{AtomicBool, Ordering},
        Arc, Mutex,
    },
    time::Duration,
};
use tauri::{Emitter, Manager};

#[derive(Default)]
pub struct RemoteState(Mutex<Option<RemoteSession>>);
struct RemoteSession {
    task: tokio::task::JoinHandle<()>,
    active: Arc<AtomicBool>,
}
impl Drop for RemoteSession {
    fn drop(&mut self) {
        self.active.store(false, Ordering::SeqCst);
        self.task.abort();
    }
}

fn response(status: StatusCode, body: String, html: bool) -> Response<Full<Bytes>> {
    Response::builder().status(status)
        .header("Content-Type", if html { "text/html; charset=utf-8" } else { "text/plain; charset=utf-8" })
        .header("Cache-Control", "no-store")
        .header("Referrer-Policy", "no-referrer")
        .header("X-Content-Type-Options", "nosniff")
        .header("Content-Security-Policy", "default-src 'none'; script-src 'unsafe-inline'; style-src 'unsafe-inline'; connect-src 'self'; frame-ancestors 'none'")
        .body(Full::new(Bytes::from(body))).unwrap()
}

async fn serve(
    req: Request<Incoming>,
    token: String,
    active: Arc<AtomicBool>,
    emit: impl Fn(&str) -> bool,
) -> Result<Response<Full<Bytes>>, Infallible> {
    if req.method() == hyper::Method::GET && req.uri().path() == "/" {
        return Ok(response(
            StatusCode::OK,
            include_str!("../../src/tvbox-phone.html").into(),
            true,
        ));
    }
    if req.method() != hyper::Method::POST || req.uri().path() != "/config" {
        return Ok(response(StatusCode::NOT_FOUND, "Not found".into(), false));
    }
    if !active.load(Ordering::SeqCst)
        || req
            .headers()
            .get("x-tvbox-token")
            .and_then(|v| v.to_str().ok())
            != Some(token.as_str())
    {
        return Ok(response(
            StatusCode::FORBIDDEN,
            "二维码已失效，请重新扫描电脑上的二维码".into(),
            false,
        ));
    }
    let body = match tokio::time::timeout(
        Duration::from_secs(10),
        Limited::new(req.into_body(), 1024 * 1024).collect(),
    )
    .await
    {
        Ok(Ok(body)) => body.to_bytes(),
        _ => {
            return Ok(response(
                StatusCode::BAD_REQUEST,
                "配置过大或上传超时".into(),
                false,
            ))
        }
    };
    let text = match std::str::from_utf8(&body) {
        Ok(text) if !text.trim().is_empty() => text.trim(),
        _ => {
            return Ok(response(
                StatusCode::BAD_REQUEST,
                "请输入配置网址或 JSON".into(),
                false,
            ))
        }
    };
    if !text.starts_with('{')
        && !reqwest::Url::parse(text).is_ok_and(|u| matches!(u.scheme(), "http" | "https"))
    {
        return Ok(response(
            StatusCode::BAD_REQUEST,
            "只支持 HTTP(S) 配置网址或 JSON".into(),
            false,
        ));
    }
    if !active.load(Ordering::SeqCst) {
        return Ok(response(
            StatusCode::FORBIDDEN,
            "二维码已关闭".into(),
            false,
        ));
    }
    let result = emit(text);
    Ok(response(
        if result {
            StatusCode::OK
        } else {
            StatusCode::SERVICE_UNAVAILABLE
        },
        if result {
            "已发送到电脑，请查看电脑上的加载结果"
        } else {
            "电脑暂时无法接收配置"
        }
        .into(),
        false,
    ))
}

#[tauri::command]
pub async fn tvbox_remote_start(app: tauri::AppHandle) -> Result<serde_json::Value, String> {
    let listener = match tokio::net::TcpListener::bind("0.0.0.0:9978").await {
        Ok(listener) => listener,
        Err(_) => tokio::net::TcpListener::bind("0.0.0.0:0")
            .await
            .map_err(|e| e.to_string())?,
    };
    let port = listener.local_addr().map_err(|e| e.to_string())?.port();
    let mut random = [0u8; 24];
    getrandom::fill(&mut random).map_err(|e| e.to_string())?;
    let token: String = random.iter().map(|b| format!("{b:02x}")).collect();
    let addresses: Vec<String> = local_ip_address::list_afinet_netifas()
        .map_err(|e| e.to_string())?
        .into_iter()
        .filter_map(|(_, ip)| match ip {
            std::net::IpAddr::V4(ip)
                if !ip.is_loopback() && !ip.is_link_local() && !ip.is_unspecified() =>
            {
                Some(format!("http://{ip}:{port}/#{token}"))
            }
            _ => None,
        })
        .collect();
    if addresses.is_empty() {
        return Err("没有可用的局域网 IPv4，请先连接 Wi-Fi 或有线网络".into());
    }
    let codes: Vec<_> = addresses.iter().map(|url| {
        let qr = qrcode::QrCode::new(url.as_bytes()).map_err(|e| e.to_string())?;
        let width = qr.width();
        let mut svg = format!("<svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 {0} {0}'><path fill='white' d='M0 0h{0}v{0}H0z'/><g fill='black'>", width+8);
        for y in 0..width { for x in 0..width { if qr[(x,y)] == qrcode::Color::Dark { svg.push_str(&format!("<path d='M{} {}h1v1h-1z'/>",x+4,y+4)); } } }
        svg.push_str("</g></svg>");
        Ok(serde_json::json!({"url":url,"svg":svg}))
    }).collect::<Result<_,String>>()?;
    let app_handle = app.clone();
    let active = Arc::new(AtomicBool::new(true));
    let session_active = active.clone();
    let task = tokio::spawn(async move {
        let permits = std::sync::Arc::new(tokio::sync::Semaphore::new(8));
        loop {
            let Ok((stream, _)) = listener.accept().await else {
                break;
            };
            let Ok(permit) = permits.clone().try_acquire_owned() else {
                continue;
            };
            let app = app_handle.clone();
            let token = token.clone();
            let active = active.clone();
            tokio::spawn(async move {
                let _permit = permit;
                let service = hyper::service::service_fn(move |req| {
                    let app = app.clone();
                    serve(req, token.clone(), active.clone(), move |text| {
                        app.emit_to("main", "tvbox-phone-config", text).is_ok()
                    })
                });
                let connection = hyper::server::conn::http1::Builder::new()
                    .keep_alive(false)
                    .serve_connection(hyper_util::rt::TokioIo::new(stream), service);
                let _ = tokio::time::timeout(Duration::from_secs(15), connection).await;
            });
        }
    });
    let state = app.state::<RemoteState>();
    let mut running = state.0.lock().map_err(|e| e.to_string())?;
    *running = Some(RemoteSession {
        task,
        active: session_active,
    });
    Ok(serde_json::json!({"codes":codes}))
}

#[tauri::command]
pub fn tvbox_remote_stop(app: tauri::AppHandle) -> Result<(), String> {
    app.state::<RemoteState>()
        .0
        .lock()
        .map_err(|e| e.to_string())?
        .take();
    Ok(())
}

#[cfg(test)]
mod tests {
    use super::*;
    #[tokio::test]
    async fn phone_http_auth_limits_and_revocation() {
        let listener = tokio::net::TcpListener::bind("127.0.0.1:0").await.unwrap();
        let url = format!("http://{}/config", listener.local_addr().unwrap());
        let active = Arc::new(AtomicBool::new(true));
        let received = Arc::new(Mutex::new(Vec::<String>::new()));
        let running = active.clone();
        let messages = received.clone();
        let server = tokio::spawn(async move {
            loop {
                let (stream, _) = listener.accept().await.unwrap();
                let active = running.clone();
                let messages = messages.clone();
                tokio::spawn(async move {
                    let service = hyper::service::service_fn(move |req| {
                        let messages = messages.clone();
                        serve(req, "secret".into(), active.clone(), move |text| {
                            messages.lock().unwrap().push(text.into());
                            true
                        })
                    });
                    let _ = hyper::server::conn::http1::Builder::new()
                        .keep_alive(false)
                        .serve_connection(hyper_util::rt::TokioIo::new(stream), service)
                        .await;
                });
            }
        });
        let client = reqwest::Client::new();
        let request =
            |body: String, token: &str| client.post(&url).header("x-tvbox-token", token).body(body);
        assert_eq!(
            request("https://example.com/config.json".into(), "wrong")
                .send()
                .await
                .unwrap()
                .status(),
            StatusCode::FORBIDDEN
        );
        assert_eq!(
            request("file:///C:/secret".into(), "secret")
                .send()
                .await
                .unwrap()
                .status(),
            StatusCode::BAD_REQUEST
        );
        assert_eq!(
            request("x".repeat(1024 * 1024 + 1), "secret")
                .send()
                .await
                .unwrap()
                .status(),
            StatusCode::BAD_REQUEST
        );
        assert_eq!(
            request("https://example.com/config.json".into(), "secret")
                .send()
                .await
                .unwrap()
                .status(),
            StatusCode::OK
        );
        assert_eq!(received.lock().unwrap().len(), 1);
        active.store(false, Ordering::SeqCst);
        assert_eq!(
            request("https://example.com/config.json".into(), "secret")
                .send()
                .await
                .unwrap()
                .status(),
            StatusCode::FORBIDDEN
        );
        assert_eq!(received.lock().unwrap().len(), 1);
        server.abort();
    }
}
