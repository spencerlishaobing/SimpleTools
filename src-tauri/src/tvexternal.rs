//! Out-of-process Python and built-in JVM/DEX adapters for TVBox type=3 sources.
use base64::{engine::general_purpose::STANDARD, Engine};
use md5::{Digest, Md5};
use serde_json::{json, Value};
use std::{path::PathBuf, process::Stdio, time::Duration};
use tauri::Manager;
use tokio::{
    io::{AsyncBufReadExt, BufReader},
    process::{Child, Command},
    sync::Mutex,
};

struct Worker {
    _child: Option<Child>,
    _job: Job,
    known: std::collections::HashSet<String>,
    url: String,
    token: String,
}
// Closing the app also terminates worker descendants, including an in-flight DEX converter.
struct Job(usize);
impl Job {
    #[cfg(windows)]
    fn attach(child: &Child) -> Result<Self, String> {
        use windows::{
            core::PCWSTR,
            Win32::{
                Foundation::CloseHandle,
                System::{JobObjects::*, Threading::*},
            },
        };
        unsafe {
            let handle = CreateJobObjectW(None, PCWSTR::null()).map_err(|e| e.to_string())?;
            let owned = Self(handle.0 as usize);
            let mut info = JOBOBJECT_EXTENDED_LIMIT_INFORMATION::default();
            info.BasicLimitInformation.LimitFlags = JOB_OBJECT_LIMIT_KILL_ON_JOB_CLOSE;
            SetInformationJobObject(
                handle,
                JobObjectExtendedLimitInformation,
                &info as *const _ as _,
                std::mem::size_of_val(&info) as u32,
            )
            .map_err(|e| e.to_string())?;
            let process = OpenProcess(
                PROCESS_SET_QUOTA | PROCESS_TERMINATE,
                false,
                child.id().ok_or("运行时已退出")?,
            )
            .map_err(|e| e.to_string())?;
            let result = AssignProcessToJobObject(handle, process);
            let _ = CloseHandle(process);
            result.map_err(|e| e.to_string())?;
            Ok(owned)
        }
    }
    #[cfg(not(windows))]
    fn attach(_: &Child) -> Result<Self, String> {
        Ok(Self(0))
    }
}
impl Drop for Job {
    fn drop(&mut self) {
        #[cfg(windows)]
        unsafe {
            let _ = windows::Win32::Foundation::CloseHandle(windows::Win32::Foundation::HANDLE(
                self.0 as *mut _,
            ));
        }
    }
}
#[derive(Default)]
pub struct ExternalState {
    python: Mutex<Option<Worker>>,
    java: Mutex<Option<Worker>>,
}
fn command(path: impl AsRef<std::ffi::OsStr>) -> Command {
    let mut cmd = Command::new(path);
    cmd.kill_on_drop(true);
    #[cfg(windows)]
    cmd.creation_flags(0x08000000);
    cmd
}
fn resource(app: &tauri::AppHandle, relative: &str) -> Result<PathBuf, String> {
    let installed = app
        .path()
        .resource_dir()
        .map_err(|e| e.to_string())?
        .join(relative);
    if installed.exists() {
        return Ok(installed);
    }
    let dev = PathBuf::from(env!("CARGO_MANIFEST_DIR")).join(relative);
    if dev.exists() {
        Ok(dev)
    } else {
        Err(format!("运行时文件缺失：{relative}，请重新安装完整安装包"))
    }
}
fn token() -> Result<String, String> {
    let mut bytes = [0u8; 24];
    getrandom::fill(&mut bytes).map_err(|e| e.to_string())?;
    Ok(bytes.iter().map(|b| format!("{b:02x}")).collect())
}
fn client() -> Result<reqwest::Client, String> {
    reqwest::Client::builder()
        .no_proxy()
        .timeout(Duration::from_secs(45))
        .build()
        .map_err(|e| e.to_string())
}
async fn python(app: &tauri::AppHandle) -> Result<Worker, String> {
    let executable = resource(app, "resources/python/python.exe")?;
    let script = resource(app, "resources/tvpython/worker.py")?;
    let cache = crate::datadir::data_dir(app)?.join("tvbox-python");
    tokio::fs::create_dir_all(&cache)
        .await
        .map_err(|e| e.to_string())?;
    let secret = token()?;
    let mut child = command(executable)
        .arg(script)
        .args(["--token", &secret])
        .current_dir(cache)
        .stdout(Stdio::piped())
        .stderr(Stdio::null())
        .spawn()
        .map_err(|e| e.to_string())?;
    let mut line = String::new();
    let job = Job::attach(&child)?;
    let mut reader = BufReader::new(child.stdout.take().ok_or("Python 输出通道缺失")?);
    tokio::time::timeout(Duration::from_secs(15), reader.read_line(&mut line))
        .await
        .map_err(|_| "Python 启动超时")?
        .map_err(|e| e.to_string())?;
    let data: Value =
        serde_json::from_str(&line).map_err(|_| "Python 启动失败，请检查内置运行时和依赖")?;
    // Drain plugin logging so a verbose source cannot fill the pipe and deadlock.
    tokio::spawn(async move {
        let _ = tokio::io::copy(&mut reader, &mut tokio::io::sink()).await;
    });
    let port = data["port"]
        .as_u64()
        .filter(|p| *p > 0 && *p < 65536)
        .ok_or("Python 端口无效")?;
    Ok(Worker {
        _child: Some(child),
        _job: job,
        known: Default::default(),
        url: format!("http://127.0.0.1:{port}"),
        token: secret,
    })
}
async fn java(app: &tauri::AppHandle) -> Result<Worker, String> {
    let executable = resource(app, "resources/java/jre/bin/java.exe")?;
    let host = resource(app, "resources/java/host.jar")?;
    let lib = resource(app, "resources/java/lib")?;
    let dex = resource(app, "resources/java/dex-runtime")?;
    let cache = crate::datadir::data_dir(app)?.join("tvbox-java");
    tokio::fs::create_dir_all(&cache)
        .await
        .map_err(|e| e.to_string())?;
    let secret = token()?;
    let classpath = std::env::join_paths([host, lib.join("*")]).map_err(|e| e.to_string())?;
    let mut child = command(executable)
        .args([
            "-Xmx384m",
            "-Dfile.encoding=UTF-8",
            "-Dsun.net.httpserver.maxReqTime=45",
            "-Dsun.net.httpserver.maxRspTime=120",
        ])
        .arg(format!("-Dtvbox.dex={}", dex.join("*").display()))
        .arg("-cp")
        .arg(classpath)
        .args(["com.simpletools.tvbridge.Main", &secret])
        .current_dir(cache)
        .stdout(Stdio::piped())
        .stderr(Stdio::null())
        .spawn()
        .map_err(|e| e.to_string())?;
    let job = Job::attach(&child)?;
    let mut line = String::new();
    let mut reader = BufReader::new(child.stdout.take().ok_or("JVM 输出通道缺失")?);
    tokio::time::timeout(Duration::from_secs(15), reader.read_line(&mut line))
        .await
        .map_err(|_| "内置 JVM 启动超时")?
        .map_err(|e| e.to_string())?;
    let data: Value =
        serde_json::from_str(&line).map_err(|_| "内置 JVM 启动失败，请检查运行时资源")?;
    tokio::spawn(async move {
        let _ = tokio::io::copy(&mut reader, &mut tokio::io::sink()).await;
    });
    let port = data["port"]
        .as_u64()
        .filter(|p| *p > 0 && *p < 65536)
        .ok_or("JVM 端口无效")?;
    Ok(Worker {
        _child: Some(child),
        _job: job,
        known: Default::default(),
        url: format!("http://127.0.0.1:{port}"),
        token: secret,
    })
}
static SOURCE_CACHE: std::sync::OnceLock<
    std::sync::Mutex<std::collections::HashMap<String, (std::time::Instant, Vec<u8>)>>,
> = std::sync::OnceLock::new();
async fn read_source(url: &str, max: usize) -> Result<Vec<u8>, String> {
    let cache = SOURCE_CACHE.get_or_init(Default::default);
    if !url.starts_with("file:") {
        if let Some((time, bytes)) = cache.lock().map_err(|_| "缓存锁异常")?.get(url) {
            if time.elapsed() < Duration::from_secs(300) && bytes.len() <= max {
                return Ok(bytes.clone());
            }
        }
    }
    let bytes = read_source_uncached(url, max).await?;
    if !url.starts_with("file:") {
        let mut map = cache.lock().map_err(|_| "缓存锁异常")?;
        if map.len() >= 4 {
            map.clear();
        }
        map.insert(url.into(), (std::time::Instant::now(), bytes.clone()));
    }
    Ok(bytes)
}
async fn read_source_uncached(url: &str, max: usize) -> Result<Vec<u8>, String> {
    let parsed = reqwest::Url::parse(url).map_err(|e| e.to_string())?;
    if parsed.scheme() == "file" {
        let path = parsed.to_file_path().map_err(|_| "本地片源路径无效")?;
        let size = tokio::fs::metadata(&path)
            .await
            .map_err(|e| e.to_string())?
            .len();
        if size > max as u64 {
            return Err("片源文件过大".into());
        }
        return tokio::fs::read(path).await.map_err(|e| e.to_string());
    }
    if !matches!(parsed.scheme(), "http" | "https") {
        return Err("片源只支持 HTTP(S) 或本地文件".into());
    }
    let mut response = reqwest::Client::builder()
        .timeout(Duration::from_secs(40))
        .build()
        .map_err(|e| e.to_string())?
        .get(parsed)
        .send()
        .await
        .map_err(|e| e.to_string())?
        .error_for_status()
        .map_err(|e| e.to_string())?;
    let mut bytes = Vec::new();
    while let Some(chunk) = response.chunk().await.map_err(|e| e.to_string())? {
        if bytes.len() + chunk.len() > max {
            return Err("片源文件过大".into());
        }
        bytes.extend_from_slice(&chunk);
    }
    Ok(bytes)
}
fn rewrite(value: &mut Value, worker: &Worker, identity: &str) {
    match value {
        Value::String(text) => {
            if let Ok(mut u) = reqwest::Url::parse(text) {
                if matches!(u.host_str(), Some("127.0.0.1" | "localhost" | "0.0.0.0"))
                    && u.port() == Some(9978)
                {
                    let local = reqwest::Url::parse(&worker.url).unwrap();
                    u.set_port(local.port()).ok();
                    u.set_host(Some("127.0.0.1")).ok();
                    u.set_path("/proxy");
                    u.query_pairs_mut()
                        .append_pair("token", &worker.token)
                        .append_pair("site", identity);
                    *text = u.to_string();
                }
            }
        }
        Value::Array(values) => {
            for v in values {
                rewrite(v, worker, identity)
            }
        }
        Value::Object(values) => {
            for v in values.values_mut() {
                rewrite(v, worker, identity)
            }
        }
        _ => {}
    }
}
#[tauri::command]
pub async fn tvbox_external(
    app: tauri::AppHandle,
    api: String,
    jar: Option<String>,
    key: String,
    ext: Value,
    action: String,
    args: Value,
) -> Result<Value, String> {
    let is_python = api
        .split(['?', '#'])
        .next()
        .unwrap_or("")
        .to_lowercase()
        .ends_with(".py");
    let mut data = json!({"api":api,"key":key,"ext":ext,"action":action,"args":args});
    let identity;
    if is_python {
        data["source"] = Value::String(
            String::from_utf8(read_source(&api, 4 * 1024 * 1024).await?)
                .map_err(|_| "Python 片源不是 UTF-8")?,
        );
        identity = String::new();
    } else {
        let jar = jar.ok_or("配置缺少全局 spider 或片源 jar 地址")?;
        let mut parts = jar.split(";md5;");
        let url = parts.next().unwrap_or("");
        let expected = parts.next();
        let bytes = read_source(url, 64 * 1024 * 1024).await?;
        let hash = format!("{:x}", Md5::digest(&bytes));
        if let Some(expected) = expected {
            let expected = if expected.starts_with("http") {
                String::from_utf8(read_source(expected, 1024).await?).map_err(|e| e.to_string())?
            } else {
                expected.into()
            };
            if !hash.eq_ignore_ascii_case(expected.trim()) {
                return Err("JAR 的 MD5 校验失败".into());
            }
        }
        identity = format!("{:x}", Md5::digest(format!("{hash}|{api}|{key}|{ext}")));
        data["identity"] = json!(identity);
        data["jarData"] = json!(STANDARD.encode(bytes));
        if !ext.is_string() {
            data["ext"] = json!(ext.to_string());
        }
    }
    let state = app.state::<ExternalState>();
    let mut slot = if is_python {
        state.python.lock().await
    } else {
        state.java.lock().await
    };
    if slot.is_none() {
        *slot = Some(if is_python {
            python(&app).await?
        } else {
            java(&app).await?
        });
    }
    let worker = slot.as_mut().unwrap();
    if !is_python {
        data["proxyOrigin"] = json!(worker.url);
        if worker.known.contains(&identity) {
            data["jarData"] = Value::Null;
        }
    }
    let response = client()?
        .post(format!("{}/call", worker.url))
        .header("X-TVBOX-Token", &worker.token)
        .json(&data)
        .send()
        .await;
    let response = match response {
        Ok(r) => r,
        Err(e) => {
            *slot = None;
            return Err(format!("片源运行超时或中断，运行环境已重置：{e}"));
        }
    };
    let status = response.status();
    let mut result: Value = response.json().await.map_err(|e| e.to_string())?;
    if !status.is_success() {
        return Err(format!(
            "片源执行失败：{}",
            result["error"].as_str().unwrap_or("未知错误")
        ));
    }
    if !is_python {
        worker.known.insert(identity.clone());
        rewrite(&mut result, worker, &identity);
    }
    Ok(result)
}

#[tauri::command]
pub async fn tvbox_external_stop(app: tauri::AppHandle) -> Result<(), String> {
    let state = app.state::<ExternalState>();
    state.python.lock().await.take();
    state.java.lock().await.take();
    Ok(())
}

#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn source_proxy_rewrites_only_local_android_endpoint() {
        let worker = Worker {
            _child: None,
            _job: Job(0),
            known: Default::default(),
            url: "http://127.0.0.1:54321".into(),
            token: "secret".into(),
        };
        let mut value = json!({"url":"http://127.0.0.1:9978/proxy?url=https%3A%2F%2Fvideo.test%2Fa%3Fx%3D1%26y%3D2","header":{"Referer":"https://example.test:9978/page"}});
        rewrite(&mut value, &worker, "source-id");
        let parsed = reqwest::Url::parse(value["url"].as_str().unwrap()).unwrap();
        let pairs: std::collections::HashMap<_, _> = parsed.query_pairs().collect();
        assert_eq!(parsed.port(), Some(54321));
        assert_eq!(pairs["url"], "https://video.test/a?x=1&y=2");
        assert_eq!(pairs["site"], "source-id");
        assert_eq!(pairs["token"], "secret");
        assert_eq!(value["header"]["Referer"], "https://example.test:9978/page");
    }
    #[cfg(windows)]
    #[tokio::test]
    #[ignore = "requires scripts/prepare-tvbox-runtimes.py"]
    async fn windows_job_terminates_packaged_worker() {
        let executable =
            PathBuf::from(env!("CARGO_MANIFEST_DIR")).join("resources/python/python.exe");
        let mut child = command(executable)
            .args(["-c", "import time; print('ready', flush=True); time.sleep(60)"])
            .stdout(Stdio::piped())
            .spawn()
            .unwrap();
        let mut line=String::new();
        BufReader::new(child.stdout.take().unwrap()).read_line(&mut line).await.unwrap();
        assert_eq!(line.trim(),"ready");
        assert!(child.try_wait().unwrap().is_none());
        let job = Job::attach(&child).unwrap();
        drop(job);
        tokio::time::timeout(Duration::from_secs(5), child.wait())
            .await
            .unwrap()
            .unwrap();
    }
}
