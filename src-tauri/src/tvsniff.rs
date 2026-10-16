use base64::{engine::general_purpose::STANDARD, Engine};
use tauri::{Emitter, Manager};

// Runs in a separate unprivileged WebView. Remote pages receive no Tauri commands.
const SCRIPT: &str = r#"(() => {
 const seen=new Set();
 const report=(value,details)=>{
   if(typeof value!=='string')return;
   try{value=new URL(value,location.href).href}catch(_){return}
   if(!/^https?:/i.test(value) || !/\.(m3u8|mp4|mpd|mkv|webm|flv)(?:[?#]|$)/i.test(value) || seen.has(value) || seen.size>=32) return;
   seen.add(value);
   const data=details||{url:value,referer:location.href,ua:navigator.userAgent};
   if(window.top===window) document.title='TVBOX_SNIFF:'+btoa(unescape(encodeURIComponent(JSON.stringify(data))));
   else window.parent.postMessage({tvboxSniff:data},'*');
 };
 window.addEventListener('message',e=>{const d=e.data?.tvboxSniff;if(d?.url)report(d.url,d)});
 const originalFetch=window.fetch;
 window.fetch=function(input,...rest){report(typeof input==='string'?input:input?.url);return originalFetch.call(this,input,...rest)};
 const open=XMLHttpRequest.prototype.open;
 XMLHttpRequest.prototype.open=function(method,url,...rest){report(String(url));return open.call(this,method,url,...rest)};
 try{new PerformanceObserver(list=>list.getEntries().forEach(e=>report(e.name))).observe({type:'resource',buffered:true})}catch(_){}
 const scan=()=>document.querySelectorAll('video,source').forEach(v=>report(v.currentSrc||v.src));
 window.addEventListener('DOMContentLoaded',()=>{scan();new MutationObserver(scan).observe(document.documentElement,{childList:true,subtree:true,attributes:true,attributeFilter:['src']})});
})();"#;

#[tauri::command]
pub async fn tvbox_sniff(
    app: tauri::AppHandle,
    url: String,
    session: String,
) -> Result<(), String> {
    let url = reqwest::Url::parse(&url).map_err(|e| e.to_string())?;
    if !matches!(url.scheme(), "http" | "https") {
        return Err("网页解析仅支持 HTTP(S)".into());
    }
    if session.len() > 80
        || !session
            .chars()
            .all(|c| c.is_ascii_alphanumeric() || c == '-' || c == '_')
    {
        return Err("解析会话无效".into());
    }
    for (label, window) in app.webview_windows() {
        if label.starts_with("tvbox-sniff-") {
            let _ = window.close();
        }
    }
    let handle = app.clone();
    tauri::WebviewWindowBuilder::new(
        &app,
        format!("tvbox-sniff-{session}"),
        tauri::WebviewUrl::External(url),
    )
    .title("TVBOX 网页解析 · 在网页中点击播放，识别结果显示在主窗口")
    .inner_size(960.0, 640.0)
    .initialization_script_for_all_frames(SCRIPT)
    .on_new_window(|_, _| tauri::webview::NewWindowResponse::Deny)
    .on_document_title_changed(move |_, title| {
        if let Some(data) = title.strip_prefix("TVBOX_SNIFF:") {
            if data.len() > 32768 {
                return;
            }
            if let Ok(bytes) = STANDARD.decode(data) {
                if let Ok(mut data) = serde_json::from_slice::<serde_json::Value>(&bytes) {
                    let valid = data["url"]
                        .as_str()
                        .and_then(|s| reqwest::Url::parse(s).ok())
                        .is_some_and(|u| matches!(u.scheme(), "http" | "https"));
                    if valid {
                        data["session"] = session.clone().into();
                        let _ = handle.emit_to("main", "tvbox-sniff-result", data);
                    }
                }
            }
        }
    })
    .build()
    .map_err(|e| e.to_string())?;
    Ok(())
}
