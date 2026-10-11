/* ===== Windows 安全能力：电脑登录密码校验（LogonUser）+ DPAPI 数据加密（v0.15.0） =====
 * - 供「账号密码」安全增强使用：
 *   1) 校验电脑登录密码（LogonUserW，仅凭据校验、不缓存不落盘；Windows 11 / 10 通用）
 *   2) 本地数据 DPAPI 加密（CryptProtectData，与当前 Windows 用户绑定，防明文落盘）
 * - 与 titlebar.rs 相同：直接 FFI 调用系统 DLL，避免引入额外依赖。
 */
#[cfg(target_os = "windows")]
use std::ffi::c_void;

#[cfg(target_os = "windows")]
mod ffi {
    use std::ffi::c_void;

    #[link(name = "advapi32")]
    extern "system" {
        pub fn LogonUserW(
            lpsz_username: *const u16,
            lpsz_domain: *const u16,
            lpsz_password: *const u16,
            dw_logon_type: u32,
            dw_logon_provider: u32,
            ph_token: *mut *mut c_void,
        ) -> i32;
        pub fn GetUserNameW(lp_buffer: *mut u16, pcb_buffer: *mut u32) -> i32;
    }

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
        pub fn CloseHandle(h_object: *mut c_void) -> i32;
        pub fn GetLastError() -> u32;
        pub fn LocalFree(h_mem: *mut c_void) -> *mut c_void;
    }

    /// Win32 DATA_BLOB（CRYPTOAPI_BLOB，与系统布局一致）
    #[repr(C)]
    pub struct DataBlob {
        pub cb_data: u32,
        pub pb_data: *mut u8,
    }

    // --- LogonUser 相关常量 ---
    pub const LOGON32_LOGON_NETWORK: u32 = 3; // 快速校验凭据（不加载用户配置）
    pub const LOGON32_PROVIDER_DEFAULT: u32 = 0;
    pub const ERROR_LOGON_FAILURE: u32 = 1326; // 用户名或密码错误
    pub const ERROR_ACCOUNT_RESTRICTION: u32 = 1327; // 账户限制（空密码被策略拒登等）
}

/// 获取当前进程所属的 Windows 用户名
#[cfg(target_os = "windows")]
fn current_username() -> Result<String, String> {
    let mut buf = [0u16; 256];
    let mut len = buf.len() as u32;
    let ok = unsafe { ffi::GetUserNameW(buf.as_mut_ptr(), &mut len) };
    if ok == 0 || len == 0 {
        return Err(format!(
            "获取电脑用户名失败（错误码 {}）",
            unsafe { ffi::GetLastError() }
        ));
    }
    // len 含结尾 NUL
    String::from_utf16(&buf[..(len as usize - 1)]).map_err(|e| format!("用户名解码失败: {e}"))
}

/// 以空密码/给定密码校验本地账户。成功 Ok(())，失败返回 Win32 错误码
#[cfg(target_os = "windows")]
fn logon(user: &str, password: &str) -> Result<(), u32> {
    let u: Vec<u16> = user.encode_utf16().chain(std::iter::once(0)).collect();
    let p: Vec<u16> = password.encode_utf16().chain(std::iter::once(0)).collect();
    let mut token: *mut c_void = std::ptr::null_mut();
    let ok = unsafe {
        ffi::LogonUserW(
            u.as_ptr(),
            std::ptr::null(), // 本机账户：NULL 域
            p.as_ptr(),
            ffi::LOGON32_LOGON_NETWORK,
            ffi::LOGON32_PROVIDER_DEFAULT,
            &mut token,
        )
    };
    if ok != 0 {
        if !token.is_null() {
            unsafe { ffi::CloseHandle(token) };
        }
        Ok(())
    } else {
        Err(unsafe { ffi::GetLastError() })
    }
}

/// 当前电脑账户是否设置了登录密码（空密码探测）
/// - 空密码直接成功（策略允许）= 未设置密码
/// - 空密码被账户策略限制（1327，默认策略拒绝空密码网络登录）= 未设置密码
/// - 空密码校验失败（1326）= 已设置密码
#[tauri::command]
pub fn windows_password_set() -> Result<bool, String> {
    #[cfg(target_os = "windows")]
    {
        let user = current_username()?;
        match logon(&user, "") {
            Ok(()) => Ok(false),
            Err(ffi::ERROR_ACCOUNT_RESTRICTION) => Ok(false),
            Err(ffi::ERROR_LOGON_FAILURE) => Ok(true),
            Err(code) => Err(format!("无法检测电脑密码状态（错误码 {code}）")),
        }
    }
    #[cfg(not(target_os = "windows"))]
    {
        Err("仅支持 Windows".into())
    }
}

/// 校验电脑登录密码是否正确（正确 true / 错误 false；不缓存、不落盘）
#[tauri::command]
pub fn verify_windows_password(password: String) -> Result<bool, String> {
    #[cfg(target_os = "windows")]
    {
        if password.is_empty() {
            return Err("密码不能为空".into());
        }
        let user = current_username()?;
        match logon(&user, &password) {
            Ok(()) => Ok(true),
            Err(ffi::ERROR_LOGON_FAILURE) | Err(ffi::ERROR_ACCOUNT_RESTRICTION) => Ok(false),
            Err(code) => Err(format!("校验失败（错误码 {code}）")),
        }
    }
    #[cfg(not(target_os = "windows"))]
    {
        let _ = password;
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
