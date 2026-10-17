//! libmpv client API; the DLL remains loaded for the entire handle lifetime.
use libloading::Library;
use std::{
    ffi::{c_char, c_int, c_void, CStr, CString},
    sync::Mutex,
};
use tauri::{Emitter, Manager};

/// 主窗口内的视频表面子窗口句柄（mpv 渲染目标）。方案：在应用主窗口上创建 WS_CHILD 子窗口，
/// mpv 以该子窗口为 wid 渲染，把视频内嵌在应用界面中（而非弹出独立播放窗口）。
#[derive(Default)]
pub struct SurfaceState(Mutex<Option<isize>>);

type Handle = *mut c_void;
type Set = unsafe extern "C" fn(Handle, *const c_char, *const c_char) -> c_int;
type Cmd = unsafe extern "C" fn(Handle, *const *const c_char) -> c_int;
type Destroy = unsafe extern "C" fn(Handle);
type Wait = unsafe extern "C" fn(Handle, f64) -> *const Event;
type Get = unsafe extern "C" fn(Handle, *const c_char) -> *mut c_char;
type Free = unsafe extern "C" fn(*mut c_void);
#[repr(C)]
struct Event {
    id: c_int,
    error: c_int,
    userdata: u64,
    data: *mut c_void,
}
#[repr(C)]
struct EndFile {
    reason: c_int,
    error: c_int,
}
pub struct Player {
    handle: usize,
    wid: usize,
    session: String,
    set: Set,
    command: Cmd,
    destroy: Destroy,
    wait: Wait,
    get: Get,
    free: Free,
    _library: Library,
}
impl Drop for Player {
    fn drop(&mut self) {
        unsafe {
            (self.destroy)(self.handle as Handle);
        }
    }
}
#[derive(Default)]
pub struct PlayerState(Mutex<Option<Player>>);

#[cfg(windows)]
pub(crate) mod surface_win {
    use super::*;
    use std::ffi::c_void;
    use windows::core::w;
    use windows::Win32::Foundation::HWND;
    use windows::Win32::System::LibraryLoader::GetModuleHandleW;
    use windows::Win32::UI::WindowsAndMessaging::{
        CreateWindowExW, SetWindowPos, ShowWindow, HWND_TOP, SWP_NOACTIVATE, SWP_SHOWWINDOW,
        SW_HIDE, WINDOW_EX_STYLE, WS_CHILD, WS_CLIPCHILDREN, WS_CLIPSIBLINGS, WS_VISIBLE,
    };

    fn hwnd_of(app: &tauri::AppHandle) -> Result<HWND, String> {
        let w = app.get_window("main").ok_or("主窗口不存在")?;
        Ok(HWND(w.hwnd().map_err(|e| e.to_string())?.0 as *mut c_void))
    }
    #[allow(dead_code)]
    pub fn parent_hwnd(app: &tauri::AppHandle) -> Result<HWND, String> {
        hwnd_of(app)
    }

    pub fn ensure(app: &tauri::AppHandle, x: f64, y: f64, width: f64, height: f64) -> Result<HWND, String> {
        let state = app.state::<SurfaceState>();
        let existing = *state.0.lock().map_err(|_| "视频区域锁异常")?;
        let (xi, yi, wi, hi) = (
            x.round() as i32,
            y.round() as i32,
            width.round().max(2.0) as i32,
            height.round().max(2.0) as i32,
        );
        // 原生窗口创建/移动必须在主线程执行：跨线程创建 WebView2 主窗口的子窗口会死锁。
        let (tx, rx) = std::sync::mpsc::channel::<Result<isize, String>>();
        let app2 = app.clone();
        app.run_on_main_thread(move || {
            let result = (|| -> Result<isize, String> {
                let hwnd = match existing {
                    Some(raw) => HWND(raw as *mut c_void),
                    None => unsafe {
                        let parent = {
                            let w = app2.get_window("main").ok_or("主窗口不存在")?;
                            HWND(w.hwnd().map_err(|e| e.to_string())?.0 as *mut c_void)
                        };
                        let instance = GetModuleHandleW(None).map_err(|e| e.to_string())?;
                        CreateWindowExW(
                            WINDOW_EX_STYLE(0),
                            w!("static"),
                            w!(""),
                            WS_CHILD | WS_VISIBLE | WS_CLIPCHILDREN | WS_CLIPSIBLINGS,
                            xi,
                            yi,
                            wi,
                            hi,
                            Some(parent),
                            None,
                            Some(instance.into()),
                            None,
                        )
                        .map_err(|e| format!("视频区域创建失败：{e}"))?
                    }
                };
                unsafe {
                    let _ = SetWindowPos(hwnd, Some(HWND_TOP), xi, yi, wi, hi, SWP_NOACTIVATE | SWP_SHOWWINDOW);
                }
                Ok(hwnd.0 as isize)
            })();
            let _ = tx.send(result);
        })
        .map_err(|e| e.to_string())?;
        let raw = rx
            .recv()
            .map_err(|_| "视频区域创建失败（主线程未响应）".to_string())??;
        if existing.is_none() {
            let mut guard = state.0.lock().map_err(|_| "视频区域锁异常")?;
            *guard = Some(raw);
        }
        Ok(HWND(raw as *mut c_void))
    }

    pub fn hide(app: &tauri::AppHandle) {
        let state = app.state::<SurfaceState>();
        let Ok(guard) = state.0.lock() else { return };
        if let Some(raw) = *guard {
            unsafe {
                let _ = ShowWindow(HWND(raw as *mut c_void), SW_HIDE);
            }
        }
    }

    pub fn current(app: &tauri::AppHandle) -> Option<HWND> {
        let state = app.state::<SurfaceState>();
        let guard = state.0.lock().ok()?;
        guard.map(|raw| HWND(raw as *mut c_void))
    }
}

/// 设置播放视频区域的位置与尺寸（物理像素，相对主窗口客户区）。前端进入播放界面时调用。
#[tauri::command]
pub async fn tvplayer_surface(app: tauri::AppHandle, x: f64, y: f64, w: f64, h: f64) -> Result<(), String> {
    #[cfg(windows)]
    {
        surface_win::ensure(&app, x, y, w, h)?;
        Ok(())
    }
    #[cfg(not(windows))]
    {
        let _ = (app, x, y, w, h);
        Err("内嵌播放仅支持 Windows".into())
    }
}

/// 隐藏视频区域（退出播放界面或切换视图时调用，画面停止显示但播放会话保留）。
#[tauri::command]
pub async fn tvplayer_surface_hide(app: tauri::AppHandle) -> Result<(), String> {
    #[cfg(windows)]
    surface_win::hide(&app);
    #[cfg(not(windows))]
    let _ = app;
    Ok(())
}
fn c(value: &str) -> Result<CString, String> {
    CString::new(value).map_err(|_| "参数包含空字符".into())
}
fn check(code: c_int) -> Result<(), String> {
    if code < 0 {
        Err(format!("libmpv 返回错误 {code}"))
    } else {
        Ok(())
    }
}
impl Player {
    fn get(&self, key: &str) -> String {
        let Ok(key) = c(key) else {
            return String::new();
        };
        unsafe {
            let ptr = (self.get)(self.handle as Handle, key.as_ptr());
            if ptr.is_null() {
                return String::new();
            }
            let value = CStr::from_ptr(ptr).to_string_lossy().into_owned();
            (self.free)(ptr as *mut c_void);
            value
        }
    }
    fn snapshot(&self) -> serde_json::Value {
        let number = |key: &str| self.get(key).parse::<f64>().unwrap_or(0.0);
        serde_json::json!({"kind":"progress","session":self.session,"position":number("time-pos"),"duration":number("duration"),"width":number("width"),"height":number("height"),"fps":number("estimated-vf-fps"),"hwdec":self.get("hwdec-current"),"codec":self.get("video-codec"),"pause":self.get("pause")=="yes","volume":number("volume"),"speed":number("speed"),"buffer":number("demuxer-cache-duration"),"tracks":serde_json::from_str::<serde_json::Value>(&self.get("track-list")).unwrap_or(serde_json::json!([]))})
    }
    fn set(&self, key: &str, value: &str) -> Result<(), String> {
        unsafe {
            check((self.set)(
                self.handle as Handle,
                c(key)?.as_ptr(),
                c(value)?.as_ptr(),
            ))
        }
    }
    fn command(&self, args: &[&str]) -> Result<(), String> {
        let strings = args.iter().map(|s| c(s)).collect::<Result<Vec<_>, _>>()?;
        let pointers: Vec<_> = strings
            .iter()
            .map(|s| s.as_ptr())
            .chain(std::iter::once(std::ptr::null()))
            .collect();
        unsafe { check((self.command)(self.handle as Handle, pointers.as_ptr())) }
    }
}

#[tauri::command]
pub async fn tvplayer_play(
    app: tauri::AppHandle,
    target: String,
    title: String,
    headers: Option<serde_json::Value>,
    session: Option<String>,
    options: Option<serde_json::Value>,
) -> Result<(), String> {
    if [
        "http://", "https://", "rtsp://", "rtmp://", "udp://", "rtp://",
    ]
    .iter()
    .any(|p| target.starts_with(p))
    {
        reqwest::Url::parse(&target).map_err(|_| "无效视频地址")?;
    } else if !std::path::Path::new(&target).is_file() {
        return Err("请选择本地视频或 HTTP(S) 直链".into());
    }
    // 渲染目标：主窗口内的视频表面子窗口（前端进入播放界面时已通过 tvplayer_surface 定位；
    // 未准备时回退为覆盖主窗口中部的默认区域）。
    #[cfg(windows)]
    let wid = {
        let surface = match surface_win::current(&app) {
            Some(hwnd) => hwnd,
            None => {
                let size = app
                    .get_window("main")
                    .ok_or("主窗口不存在")?
                    .inner_size()
                    .map_err(|e| e.to_string())?;
                surface_win::ensure(
                    &app,
                    0.0,
                    88.0,
                    size.width as f64,
                    (size.height as f64 - 88.0).max(160.0),
                )?
            }
        };
        surface.0 as usize
    };
    #[cfg(not(windows))]
    let wid = 0usize;
    let state = app.state::<PlayerState>();
    let mut guard = state.0.lock().map_err(|_| "播放器锁异常")?;
    if guard.as_ref().is_some_and(|p| p.wid != wid) {
        guard.take();
    }
    if guard.is_none() {
        let dll = app
            .path()
            .resource_dir()
            .map_err(|e| e.to_string())?
            .join("resources/mpv/libmpv-2.dll");
        let dll = if dll.is_file() {
            dll
        } else {
            std::path::PathBuf::from(env!("CARGO_MANIFEST_DIR")).join("resources/mpv/libmpv-2.dll")
        };
        unsafe {
            let library = Library::new(&dll).map_err(|e| format!("内置播放内核加载失败：{e}"))?;
            let create = *library
                .get::<unsafe extern "C" fn() -> Handle>(b"mpv_create\0")
                .map_err(|e| e.to_string())?;
            let initialize = *library
                .get::<unsafe extern "C" fn(Handle) -> c_int>(b"mpv_initialize\0")
                .map_err(|e| e.to_string())?;
            let destroy = *library
                .get::<Destroy>(b"mpv_terminate_destroy\0")
                .map_err(|e| e.to_string())?;
            let set = *library
                .get::<Set>(b"mpv_set_option_string\0")
                .map_err(|e| e.to_string())?;
            let command = *library
                .get::<Cmd>(b"mpv_command\0")
                .map_err(|e| e.to_string())?;
            let wait = *library
                .get::<Wait>(b"mpv_wait_event\0")
                .map_err(|e| e.to_string())?;
            let get = *library
                .get::<Get>(b"mpv_get_property_string\0")
                .map_err(|e| e.to_string())?;
            let free = *library
                .get::<Free>(b"mpv_free\0")
                .map_err(|e| e.to_string())?;
            let handle = create();
            if handle.is_null() {
                return Err("无法创建播放内核".into());
            }
            let player = Player {
                handle: handle as usize,
                wid,
                session: String::new(),
                set,
                command,
                destroy,
                wait,
                get,
                free,
                _library: library,
            };
            for (key, value) in [
                ("wid", wid.to_string()),
                ("hwdec", "auto-safe".into()),
                ("vo", "gpu".into()),
                ("cache", "yes".into()),
                ("demuxer-max-bytes", "256MiB".into()),
                ("demuxer-max-back-bytes", "64MiB".into()),
                ("cache-pause", "yes".into()),
                ("cache-pause-wait", "3".into()),
                ("network-timeout", "20".into()),
                ("osc", "yes".into()),
                ("input-default-bindings", "yes".into()),
                ("input-vo-keyboard", "yes".into()),
                ("idle", "yes".into()),
                ("config", "no".into()),
            ] {
                player.set(key, &value)?;
            }
            check(initialize(handle))?;
            *guard = Some(player);
        }
        let pump_app = app.clone();
        // One pump per native window. Exit when this session is destroyed.
        std::thread::spawn(move || loop {
            std::thread::sleep(std::time::Duration::from_millis(100));
            let state = pump_app.state::<PlayerState>();
            let Ok(guard) = state.0.lock() else { break };
            let Some(player) = guard.as_ref() else { break };
            if player.wid != wid {
                break;
            }
            unsafe {
                for _ in 0..100 {
                    let event = (player.wait)(player.handle as Handle, 0.0);
                    if event.is_null() || (*event).id == 0 {
                        break;
                    }
                    let message = match (*event).id {
                        8 => Some(serde_json::json!({"kind":"loaded","session":player.session})),
                        7 if !(*event).data.is_null() => {
                            let end = &*((*event).data as *const EndFile);
                            Some(
                                serde_json::json!({"kind":"ended","session":player.session,"reason":end.reason,"error":end.error}),
                            )
                        }
                        _ => None,
                    };
                    if let Some(message) = message {
                        let _ = pump_app.emit("tvbox-player-event", message);
                    }
                }
            }
        });
    }
    let player = guard.as_mut().ok_or("播放器未初始化")?;
    // Discard completed events from the previous load before assigning a new session.
    unsafe {
        for _ in 0..100 {
            let event = (player.wait)(player.handle as Handle, 0.0);
            if event.is_null() || (*event).id == 0 {
                break;
            }
        }
    }
    player.session = session.unwrap_or_default();
    // Reset headers on each load to prevent credentials leaking across sites.
    player.set("user-agent", "SimpleTools-TVBOX")?;
    player.set("referrer", "")?;
    player.set("http-header-fields", "")?;
    if let Some(serde_json::Value::Object(map)) = headers {
        let mut fields = Vec::new();
        for (key, value) in map {
            let value = value.as_str().ok_or("请求头必须是字符串")?;
            if value.contains(['\r', '\n']) {
                return Err("非法请求头".into());
            }
            match key.to_ascii_lowercase().as_str() {
                "user-agent" => player.set("user-agent", value)?,
                "referer" => player.set("referrer", value)?,
                _ => {
                    reqwest::header::HeaderName::from_bytes(key.as_bytes())
                        .map_err(|_| "非法请求头名称")?;
                    let field = format!("{key}: {value}");
                    fields.push(format!("%{}%{field}", field.len()));
                }
            }
        }
        player.set("http-header-fields", &fields.join(","))?;
    }
    let options = options.unwrap_or(serde_json::json!({}));
    for (key, value, default, min, max) in [
        ("start", "start", 0.0, 0.0, 604800.0),
        ("speed", "speed", 1.0, 0.25, 4.0),
        ("volume", "volume", 100.0, 0.0, 150.0),
        ("sub-delay", "subDelay", 0.0, -60.0, 60.0),
    ] {
        let value = options[value].as_f64().unwrap_or(default);
        if !value.is_finite() || !(min..=max).contains(&value) {
            return Err(format!("播放设置超出范围：{key}"));
        }
        player.set(key, &value.to_string())?;
    }
    player.set(
        "hwdec",
        if options["hwdec"].as_str() == Some("no") {
            "no"
        } else {
            "auto-safe"
        },
    )?;
    player.set("pause", "no")?;
    player.set("force-media-title", &title)?;
    player.command(&["loadfile", &target, "replace"])?;
    drop(guard);
    Ok(())
}

#[tauri::command]
pub async fn tvplayer_control(
    app: tauri::AppHandle,
    action: String,
    value: Option<serde_json::Value>,
) -> Result<(), String> {
    if action == "fullscreen" {
        let w = app.get_window("main").ok_or("主窗口不存在")?;
        return w
            .set_fullscreen(!w.is_fullscreen().map_err(|e| e.to_string())?)
            .map_err(|e| e.to_string());
    }
    let state = app.state::<PlayerState>();
    let guard = state.0.lock().map_err(|_| "播放器锁异常")?;
    let player = guard.as_ref().ok_or("请先播放视频")?;
    match action.as_str() {
        "pause" => player.command(&["cycle", "pause"]),
        "stop" => player.command(&["stop"]),
        "forward" => player.command(&["seek", "10", "relative"]),
        "backward" => player.command(&["seek", "-10", "relative"]),
        "seek" | "speed" | "volume" | "sub-delay" => {
            let v = value
                .as_ref()
                .and_then(|v| v.as_f64())
                .ok_or("需要数字参数")?;
            let (min, max) = match action.as_str() {
                "speed" => (0.25, 4.0),
                "volume" => (0.0, 150.0),
                "sub-delay" => (-60.0, 60.0),
                _ => (0.0, 604800.0),
            };
            if !v.is_finite() || !(min..=max).contains(&v) {
                return Err("参数超出允许范围".into());
            }
            if action == "seek" {
                player.command(&["seek", &v.to_string(), "absolute"])
            } else {
                player.set(&action, &v.to_string())
            }
        }
        "aid" | "sid" => {
            let v = value
                .as_ref()
                .and_then(|v| v.as_str())
                .ok_or("需要音轨 / 字幕编号")?;
            if v != "no" && v != "auto" && v.parse::<u32>().is_err() {
                return Err("轨道编号无效".into());
            }
            player.set(&action, v)
        }
        "aspect" => {
            let v = value
                .as_ref()
                .and_then(|v| v.as_str())
                .ok_or("需要画面比例")?;
            if !["-1", "16:9", "4:3", "2.35:1"].contains(&v) {
                return Err("画面比例无效".into());
            }
            player.set("video-aspect-override", v)
        }
        "subtitle" => {
            let v = value
                .as_ref()
                .and_then(|v| v.as_str())
                .ok_or("需要字幕文件路径")?;
            if !std::path::Path::new(v).is_file() {
                return Err("字幕文件不存在".into());
            }
            player.command(&["sub-add", v, "select"])
        }
        _ => Err("不支持的播放操作".into()),
    }
}

#[tauri::command]
pub fn tvplayer_status(app: tauri::AppHandle) -> Result<Option<serde_json::Value>, String> {
    let state = app.state::<PlayerState>();
    let guard = state.0.lock().map_err(|_| "播放器锁异常")?;
    Ok(guard.as_ref().map(Player::snapshot))
}
