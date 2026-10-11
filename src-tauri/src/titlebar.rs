/* ===== 系统标题栏颜色与窗口图标（跟随应用主题切换，Windows 11 22H2+） ===== */
#[cfg(target_os = "windows")]
use std::ffi::c_void;

/// dwmapi.dll 的 DwmSetWindowAttribute（直接 FFI，避免引入额外依赖）
#[cfg(target_os = "windows")]
mod dwm {
    use std::ffi::c_void;
    #[link(name = "dwmapi")]
    extern "system" {
        pub fn DwmSetWindowAttribute(
            hwnd: *mut c_void,
            dw_attribute: u32,
            pv_attribute: *const c_void,
            cb_attribute: u32,
        ) -> i32;
    }
}

/// 十六进制颜色（#RRGGBB）转 COLORREF（0x00BBGGRR，Windows 的 BGR 序）
#[cfg(target_os = "windows")]
fn hex_to_colorref(hex: &str) -> Result<u32, String> {
    let s = hex.trim().trim_start_matches('#');
    if s.len() != 6 {
        return Err(format!("颜色格式错误: {hex}"));
    }
    let v = u32::from_str_radix(s, 16).map_err(|e| format!("颜色格式错误: {e}"))?;
    let r = (v >> 16) & 0xFF;
    let g = (v >> 8) & 0xFF;
    let b = v & 0xFF;
    Ok((b << 16) | (g << 8) | r)
}

/// 同步系统标题栏颜色（背景 / 标题文字 / 下边框），随主题切换调用。
/// 不支持的旧系统（HRESULT 失败）静默忽略，不影响功能。
#[tauri::command]
pub fn set_titlebar_color(
    window: tauri::WebviewWindow,
    bg: String,
    text: String,
    border: String,
) -> Result<(), String> {
    #[cfg(target_os = "windows")]
    {
        let caption = hex_to_colorref(&bg)?;
        let text_color = hex_to_colorref(&text)?;
        let border_color = hex_to_colorref(&border)?;
        let hwnd = window.hwnd().map_err(|e| format!("获取窗口句柄失败: {e}"))?;
        let raw = hwnd.0 as isize as *mut c_void;
        unsafe {
            // 35=CAPTION_COLOR / 36=TEXT_COLOR / 34=BORDER_COLOR
            let _ = dwm::DwmSetWindowAttribute(raw, 35, &caption as *const u32 as *const c_void, 4);
            let _ = dwm::DwmSetWindowAttribute(raw, 36, &text_color as *const u32 as *const c_void, 4);
            let _ = dwm::DwmSetWindowAttribute(raw, 34, &border_color as *const u32 as *const c_void, 4);
        }
    }
    #[cfg(not(target_os = "windows"))]
    {
        let _ = (window, bg, text, border);
    }
    Ok(())
}

/// 随主题切换窗口图标（标题栏左上角小图标 + 任务栏 + Alt+Tab，Windows 下同一 HWND 图标）。
/// 与侧边栏品牌图标同款样式：blue=蓝紫渐变（浅色 / 深色 / 深浅混搭共用），khaki=卡其金渐变。
#[tauri::command]
pub fn set_window_icon(window: tauri::WebviewWindow, theme: String) -> Result<(), String> {
    let bytes: &[u8] = if theme == "khaki" {
        include_bytes!("../icons/theme/icon-khaki.png")
    } else {
        include_bytes!("../icons/theme/icon-blue.png")
    };
    let icon = tauri::image::Image::from_bytes(bytes).map_err(|e| format!("图标解码失败: {e}"))?;
    window.set_icon(icon).map_err(|e| format!("设置窗口图标失败: {e}"))
}
