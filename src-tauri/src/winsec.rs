/* ===== Windows 安全能力：Windows Hello 身份校验（UserConsentVerifier）+ DPAPI 数据加密（v0.19.0） =====
 * - 供「账号密码」安全增强使用：
 *   1) Windows Hello 身份校验（PIN / 指纹 / 面容，系统原生弹窗；IUserConsentVerifierInterop
 *      绑主窗口 HWND 弹窗，由系统接管验证过程，应用不接触任何凭据）
 *   2) 本地数据 DPAPI 加密（CryptProtectData，与当前 Windows 用户绑定，防明文落盘）
 * - DPAPI 与 titlebar.rs 相同：直接 FFI 调用系统 DLL；Hello 需 WinRT，经 windows crate 调用。
 * - 历史：v0.15.0 曾用 LogonUser 校验账户登录密码；因 PIN 码无法通过 LogonUser 验证，v0.19.0 改为 Windows Hello。
 */
#[cfg(target_os = "windows")]
use std::ffi::c_void;

#[cfg(target_os = "windows")]
mod ffi {
    use std::ffi::c_void;

    #[link(name = "crypt32")]
    extern "system" {
        pub fn CryptProtectData(
            p_data_in: *const DataBlob,
            sz_data_descr: *const u16,
            p_optional_entropy: *const DataBlob,
            pv_reserved: *mut c_void,
            p_prompt_struct: *mut c_void,
            dw_flags: u32,
            p_data_out: *mut DataBlob,
        ) -> i32;
        pub fn CryptUnprotectData(
            p_data_in: *const DataBlob,
            ppsz_data_descr: *mut *mut u16,
            p_optional_entropy: *const DataBlob,
            pv_reserved: *mut c_void,
            p_prompt_struct: *mut c_void,
            dw_flags: u32,
            p_data_out: *mut DataBlob,
        ) -> i32;
    }

    #[link(name = "kernel32")]
    extern "system" {
        pub fn GetLastError() -> u32;
        pub fn LocalFree(h_mem: *mut c_void) -> *mut c_void;
    }

    /// Win32 DATA_BLOB（CRYPTOAPI_BLOB，与系统布局一致）
    #[repr(C)]
    pub struct DataBlob {
        pub cb_data: u32,
        pub pb_data: *mut u8,
    }
}

// ===== Windows Hello 身份校验（v0.19.0） =====
#[cfg(target_os = "windows")]
mod hello {
    use windows::core::{factory, HSTRING};
    use windows::Security::Credentials::UI::{
        UserConsentVerificationResult, UserConsentVerifier, UserConsentVerifierAvailability,
    };
    use windows::Win32::Foundation::HWND;
    use windows::Win32::System::WinRT::{
        IUserConsentVerifierInterop, RoInitialize, RO_INIT_MULTITHREADED,
    };
    use windows_future::IAsyncOperation;

    /// 确保当前线程已初始化 WinRT（幂等；RPC_E_CHANGED_MODE 等"已初始化"类错误忽略）
    fn ensure_winrt() {
        unsafe {
            let _ = RoInitialize(RO_INIT_MULTITHREADED);
        }
    }

    /// 可用性 → 前端约定字符串
    fn availability_name(avail: UserConsentVerifierAvailability) -> &'static str {
        if avail == UserConsentVerifierAvailability::Available {
            "available"
        } else if avail == UserConsentVerifierAvailability::NotConfiguredForUser {
            "not_configured"
        } else if avail == UserConsentVerifierAvailability::DeviceNotPresent {
            "device_not_present"
        } else if avail == UserConsentVerifierAvailability::DisabledByPolicy {
            "disabled_by_policy"
        } else if avail == UserConsentVerifierAvailability::DeviceBusy {
            "device_busy"
        } else {
            "unknown"
        }
    }

    /// 验证结果 → 前端约定字符串
    fn result_name(result: UserConsentVerificationResult) -> &'static str {
        if result == UserConsentVerificationResult::Verified {
            "verified"
        } else if result == UserConsentVerificationResult::Canceled {
            "canceled"
        } else if result == UserConsentVerificationResult::RetriesExhausted {
            "retries_exhausted"
        } else if result == UserConsentVerificationResult::NotConfiguredForUser {
            "not_configured"
        } else if result == UserConsentVerificationResult::DeviceNotPresent {
            "device_not_present"
        } else if result == UserConsentVerificationResult::DisabledByPolicy {
            "disabled_by_policy"
        } else if result == UserConsentVerificationResult::DeviceBusy {
            "device_busy"
        } else {
            "unknown"
        }
    }

    /// 检测 Windows Hello 是否可用（未配置 PIN / 指纹时为 not_configured）
    pub async fn availability() -> Result<String, String> {
        ensure_winrt();
        let op = UserConsentVerifier::CheckAvailabilityAsync()
            .map_err(|e| format!("检测 Windows Hello 状态失败：{e}"))?;
        let avail = op
            .await
            .map_err(|e| format!("检测 Windows Hello 状态失败：{e}"))?;
        Ok(availability_name(avail).to_string())
    }

    /// 弹出系统 Windows Hello 验证窗口（PIN / 指纹 / 面容），等待用户完成
    /// 注：hwnd 以 isize 传递（HWND 内部为裸指针非 Send，不能跨 await 存活于 future 状态机）
    pub async fn verify(hwnd: isize, message: &str) -> Result<String, String> {
        ensure_winrt();
        // 非 UI 线程直接调 RequestVerificationAsync 会失败（E_ILLEGAL_METHOD_CALL），
        // 必须用 interop 版本并绑定主窗口 HWND（Windows 10 1809+）。
        // 注：interop / HWND 均为非 Send 类型，全部限制在同步块内，不跨 await 存活。
        let op: IAsyncOperation<UserConsentVerificationResult> = {
            let interop: IUserConsentVerifierInterop =
                factory::<UserConsentVerifier, IUserConsentVerifierInterop>()
                    .map_err(|e| format!("初始化 Windows Hello 失败：{e}"))?;
            unsafe {
                let hwnd = HWND(hwnd as *mut core::ffi::c_void);
                interop.RequestVerificationForWindowAsync(hwnd, &HSTRING::from(message))
            }
            .map_err(|e| format!("启动 Windows Hello 验证失败：{e}"))?
        };
        let result = op
            .await
            .map_err(|e| format!("Windows Hello 验证失败：{e}"))?;
        Ok(result_name(result).to_string())
    }
}

/// 检测 Windows Hello 可用性（available / not_configured / device_not_present / disabled_by_policy / device_busy）
#[tauri::command]
pub async fn hello_availability() -> Result<String, String> {
    #[cfg(target_os = "windows")]
    {
        hello::availability().await
    }
    #[cfg(not(target_os = "windows"))]
    {
        Err("仅支持 Windows".into())
    }
}

/// 弹出 Windows Hello 验证窗口（verified / canceled / retries_exhausted / not_configured / device_not_present / disabled_by_policy / device_busy）
#[tauri::command]
pub async fn hello_verify(window: tauri::WebviewWindow, message: String) -> Result<String, String> {
    #[cfg(target_os = "windows")]
    {
        // 先取出裸句柄数值（不跨 await 保存 HWND 类型）
        let hwnd = {
            let hwnd = window.hwnd().map_err(|e| format!("获取窗口句柄失败：{e}"))?;
            hwnd.0 as isize
        };
        hello::verify(hwnd, &message).await
    }
    #[cfg(not(target_os = "windows"))]
    {
        let _ = (window, message);
        Err("仅支持 Windows".into())
    }
}

/// DPAPI 加密（与当前 Windows 用户绑定；其他用户/其他电脑无法解密）
#[cfg(target_os = "windows")]
pub fn dpapi_encrypt(data: &[u8]) -> Result<Vec<u8>, String> {
    let input = ffi::DataBlob {
        cb_data: data.len() as u32,
        pb_data: data.as_ptr() as *mut u8,
    };
    let mut out = ffi::DataBlob {
        cb_data: 0,
        pb_data: std::ptr::null_mut(),
    };
    let ok = unsafe {
        ffi::CryptProtectData(
            &input,
            std::ptr::null(),
            std::ptr::null(),
            std::ptr::null_mut(),
            std::ptr::null_mut(),
            0,
            &mut out,
        )
    };
    if ok == 0 {
        return Err(format!(
            "加密失败（错误码 {}）",
            unsafe { ffi::GetLastError() }
        ));
    }
    let result = unsafe { std::slice::from_raw_parts(out.pb_data, out.cb_data as usize).to_vec() };
    unsafe { ffi::LocalFree(out.pb_data as *mut c_void) };
    Ok(result)
}

#[cfg(not(target_os = "windows"))]
pub fn dpapi_encrypt(_data: &[u8]) -> Result<Vec<u8>, String> {
    Err("仅支持 Windows".into())
}

/// DPAPI 解密（仅当前 Windows 用户可解）
#[cfg(target_os = "windows")]
pub fn dpapi_decrypt(data: &[u8]) -> Result<Vec<u8>, String> {
    let input = ffi::DataBlob {
        cb_data: data.len() as u32,
        pb_data: data.as_ptr() as *mut u8,
    };
    let mut out = ffi::DataBlob {
        cb_data: 0,
        pb_data: std::ptr::null_mut(),
    };
    let ok = unsafe {
        ffi::CryptUnprotectData(
            &input,
            std::ptr::null_mut(),
            std::ptr::null(),
            std::ptr::null_mut(),
            std::ptr::null_mut(),
            0,
            &mut out,
        )
    };
    if ok == 0 {
        return Err(format!(
            "解密失败（错误码 {}）",
            unsafe { ffi::GetLastError() }
        ));
    }
    let result = unsafe { std::slice::from_raw_parts(out.pb_data, out.cb_data as usize).to_vec() };
    unsafe { ffi::LocalFree(out.pb_data as *mut c_void) };
    Ok(result)
}

#[cfg(not(target_os = "windows"))]
pub fn dpapi_decrypt(_data: &[u8]) -> Result<Vec<u8>, String> {
    Err("仅支持 Windows".into())
}

#[cfg(all(test, target_os = "windows"))]
mod tests {
    use super::*;

    #[test]
    fn dpapi_roundtrip() {
        let data = r#"{"demo":"中文内容","n":42}"#.as_bytes();
        let enc = dpapi_encrypt(data).expect("加密应成功");
        assert_ne!(enc.as_slice(), data, "密文不应等于明文");
        let dec = dpapi_decrypt(&enc).expect("解密应成功");
        assert_eq!(dec.as_slice(), data, "解密结果应与原文一致");
    }

    #[test]
    fn dpapi_decrypt_garbage_should_fail() {
        // 明文 JSON 不是合法 DPAPI 密文，应解密失败（用于旧版明文文件的兼容判定）
        assert!(dpapi_decrypt(b"[{\"plain\":true}]").is_err());
    }
}
