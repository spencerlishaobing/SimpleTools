//! Bttwoo（比特兔 bttwo.life）播放签名：本地执行站点上游的 wasm-bindgen 模块
//! `nbmovie_wasm_bg.wasm` 的 `build_play_url(dataid, vid, quality, userlink)`，
//! 产出带 `s/t/k` 的 `/video/play?...` 签名路径。
//!
//! QuickJS 沙箱不支持 WebAssembly，故把签名上移到 Rust：用纯 Rust 的 wasmi 解释器
//! 直接跑上游 wasm（无需浏览器 / Node）。该 wasm 的 DOM 相关 import（window/document/
//! getElementById/meta.content）在 build_play_url 里都不会被调用——已用无 DOM 桩环境
//! 端到端验证（API 200 拿到 m3u8），因此这里用常量桩即可满足链接期符号需求。
use std::time::{SystemTime, UNIX_EPOCH};

// 57 KB 上游 wasm，随二进制内嵌，避免运行时资源路径解析。
static WASM: &[u8] = include_bytes!("../resources/tvspiders/upstream/nbmovie_wasm_bg.wasm");
const IMP: &str = "./nbmovie_wasm_bg.js";

fn now_ms() -> f64 {
    SystemTime::now()
        .duration_since(UNIX_EPOCH)
        .map(|d| d.as_millis() as f64)
        .unwrap_or(0.0)
}

/// 生成 `/video/play?p=&v=&q=&s=&t=&k=` 签名路径；失败返回错误串。
pub fn build_play_url(dataid: &str, vid: &str, quality: &str, userlink: &str) -> Result<String, String> {
    use wasmi::{Caller, Engine, Error, Linker, Module, Store, Val};
    type Host = ();

    let engine = Engine::default();
    let module = Module::new(&engine, WASM).map_err(|e| format!("wasm 解析失败：{e}"))?;
    let mut store = Store::new(&engine, ());
    let mut linker = <Linker<Host>>::new(&engine);

    // —— 对象 / 环境桩（build_play_url 不会真正调用，仅需类型匹配以满足链接）——
    linker.func_wrap(IMP, "__wbg___wbindgen_is_undefined_52709e72fb9f179c", |_: Caller<'_, Host>, a: i32| -> i32 { (a == 1) as i32 }).map_err(|e| e.to_string())?;
    linker.func_wrap(IMP, "__wbindgen_object_drop_ref", |_: Caller<'_, Host>, _a: i32| {}).map_err(|e| e.to_string())?;
    linker.func_wrap(IMP, "__wbindgen_object_clone_ref", |_: Caller<'_, Host>, a: i32| -> i32 { a }).map_err(|e| e.to_string())?;
    for acc in [
        "__wbg_static_accessor_GLOBAL_8adb955bd33fac2f",
        "__wbg_static_accessor_GLOBAL_THIS_ad356e0db91c7913",
        "__wbg_static_accessor_WINDOW_bb9f1ba69d61b386",
        "__wbg_static_accessor_SELF_f207c857566db248",
    ] {
        linker.func_wrap(IMP, acc, |_: Caller<'_, Host>| -> i32 { 1 }).map_err(|e| e.to_string())?;
    }
    linker.func_wrap(IMP, "__wbg_instanceof_Window_23e677d2c6843922", |_: Caller<'_, Host>, _a: i32| -> i32 { 0 }).map_err(|e| e.to_string())?;
    linker.func_wrap(IMP, "__wbg_document_c0320cd4183c6d9b", |_: Caller<'_, Host>, _a: i32| -> i32 { 0 }).map_err(|e| e.to_string())?;
    linker.func_wrap(IMP, "__wbg_instanceof_HtmlMetaElement_07f78901e9785572", |_: Caller<'_, Host>, _a: i32| -> i32 { 0 }).map_err(|e| e.to_string())?;
    linker.func_wrap(IMP, "__wbg_getElementById_d1f25d287b19a833", |_: Caller<'_, Host>, _a: i32, _b: i32, _c: i32| -> i32 { 0 }).map_err(|e| e.to_string())?;
    linker.func_wrap(IMP, "__wbg_content_4373268a6f34e443", |_: Caller<'_, Host>, _a: i32, _b: i32| {}).map_err(|e| e.to_string())?;
    // Date.now() —— 返回 f64（wasm-bindgen 把 JS number 当 f64 传入）
    linker.func_wrap(IMP, "__wbg_now_16f0c993d5dd6c27", |_: Caller<'_, Host>| -> f64 { now_ms() }).map_err(|e| e.to_string())?;
    // throw：返回 trap Error（release 用 panic=abort，绝不能 panic）
    linker.func_wrap(IMP, "__wbg___wbindgen_throw_6ddd609b62940d55", |_: Caller<'_, Host>, _a: i32, _b: i32| -> Result<(), Error> {
        Err(Error::new("nbmovie wasm 主动抛错（userlink 可能无效）"))
    })
    .map_err(|e| e.to_string())?;

    let instance = linker.instantiate_and_start(&mut store, &module).map_err(|e| format!("wasm 实例化失败：{e}"))?;

    let memory = instance.get_memory(&store, "memory").ok_or("wasm 未导出 memory")?;
    let malloc = instance.get_typed_func::<(i32, i32), i32>(&store, "__wbindgen_export").map_err(|e| e.to_string())?;
    let free = instance.get_typed_func::<(i32, i32, i32), ()>(&store, "__wbindgen_export3").map_err(|e| e.to_string())?;
    let add_sp = instance.get_typed_func::<i32, i32>(&store, "__wbindgen_add_to_stack_pointer").map_err(|e| e.to_string())?;
    let build = instance.get_func(&store, "build_play_url").ok_or("wasm 未导出 build_play_url")?;

    // 入参均为 ASCII（vid/dataid/quality/userlink），UTF-8 字节数即长度。
    macro_rules! warg {
        ($s:expr) => {{
            let bytes = $s.as_bytes();
            let len = bytes.len() as i32;
            let ptr = malloc.call(&mut store, (len, 1)).map_err(|e| e.to_string())?;
            memory.write(&mut store, ptr as usize, bytes).map_err(|e| e.to_string())?;
            (ptr, len)
        }};
    }

    let retptr = add_sp.call(&mut store, -16).map_err(|e| e.to_string())?;
    let (p0, l0) = warg!(dataid);
    let (p1, l1) = warg!(vid);
    let (p2, l2) = warg!(quality);
    let (p3, l3) = warg!(userlink);

    let args = [
        Val::I32(retptr),
        Val::I32(p0), Val::I32(l0),
        Val::I32(p1), Val::I32(l1),
        Val::I32(p2), Val::I32(l2),
        Val::I32(p3), Val::I32(l3),
    ];
    let mut results: [Val; 0] = [];
    build.call(&mut store, &args, &mut results).map_err(|e| format!("build_play_url 调用失败：{e}"))?;

    let mut buf = [0u8; 4];
    memory.read(&store, retptr as usize, &mut buf).map_err(|e| e.to_string())?;
    let r0 = i32::from_le_bytes(buf);
    memory.read(&store, (retptr + 4) as usize, &mut buf).map_err(|e| e.to_string())?;
    let r1 = i32::from_le_bytes(buf);
    let mut out = vec![0u8; r1.max(0) as usize];
    memory.read(&store, r0 as usize, &mut out).map_err(|e| e.to_string())?;
    let result = String::from_utf8_lossy(&out).into_owned();

    let _ = free.call(&mut store, (r0, r1, 1));
    let _ = add_sp.call(&mut store, 16);
    Ok(result)
}
