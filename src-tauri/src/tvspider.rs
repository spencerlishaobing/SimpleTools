//! Sandboxed QuickJS source adapter: no process APIs or native module loading.
use base64::{engine::general_purpose::STANDARD, Engine};
use rquickjs::{
    loader::{Loader, Resolver},
    module::Declared,
    Context, Ctx, Function, Module, Promise, Runtime,
};
use serde_json::{json, Value};
use std::{
    collections::HashMap,
    io::Read,
    sync::{Mutex, OnceLock},
    time::{Duration, Instant},
};

static CACHE: OnceLock<Mutex<HashMap<String, (Instant, String)>>> = OnceLock::new();
static LOCAL: Mutex<()> = Mutex::new(());
fn html_query(html: String, rule: String, many: bool) -> String {
    let doc = scraper::Html::parse_document(&html);
    let mut parts: Vec<_> = rule.split("&&").collect();
    let attribute = if many {
        "Html"
    } else {
        parts.pop().unwrap_or("Text")
    };
    let mut nodes = vec![doc.root_element()];
    for part in parts {
        if part.is_empty() {
            continue;
        }
        let (selector, index) = if let Some((selector, n)) = part.rsplit_once(":eq(") {
            (selector, n.trim_end_matches(')').parse::<usize>().ok())
        } else {
            (part, None)
        };
        let Ok(selector) = scraper::Selector::parse(selector) else {
            return if many { "[]".into() } else { String::new() };
        };
        let mut next = Vec::new();
        for node in nodes {
            let selected: Vec<_> = node.select(&selector).collect();
            if let Some(index) = index {
                if let Some(node) = selected.get(index) {
                    next.push(*node);
                }
            } else {
                next.extend(selected);
            }
        }
        nodes = next;
    }
    let values: Vec<String> = nodes
        .iter()
        .map(|node| match attribute {
            "Text" => node.text().collect::<String>().trim().to_string(),
            "Html" | "html" => node.inner_html(),
            attr => node.value().attr(attr).unwrap_or("").to_string(),
        })
        .collect();
    if many {
        serde_json::to_string(&values).unwrap_or("[]".into())
    } else {
        values.into_iter().next().unwrap_or_default()
    }
}
fn client() -> Result<reqwest::blocking::Client, String> {
    // 全局复用连接池（对齐 Android OkHttp 的长连接）：之前每次请求新建 Client，
    // 每次都要重新 DNS + TCP + TLS，首页/详情多请求串行时慢数倍。
    static CLIENT: std::sync::OnceLock<reqwest::blocking::Client> = std::sync::OnceLock::new();
    if let Some(cached) = CLIENT.get() {
        return Ok(cached.clone());
    }
    // 仅连接池复用；不注入 DoH（同步客户端每次请求都会走一次 DoH 查询，实测反而把首页拖慢到 27s）
    let built = reqwest::blocking::Client::builder()
        .user_agent(crate::tvbox::TVBOX_UA)
        .timeout(Duration::from_secs(15))
        .connect_timeout(Duration::from_secs(6))
        .pool_idle_timeout(Duration::from_secs(300))
        .pool_max_idle_per_host(16)
        .tcp_keepalive(Duration::from_secs(60))
        .build()
        .map_err(|e| e.to_string())?;
    let _ = CLIENT.set(built.clone());
    Ok(built)
}
fn source(name: &str) -> Result<String, String> {
    let url = reqwest::Url::parse(name).map_err(|e| e.to_string())?;
    if url.scheme() == "file" {
        let path = url.to_file_path().map_err(|_| "本地脚本路径无效")?;
        if path.extension().and_then(|s| s.to_str()) != Some("js") {
            return Err("脚本模块必须是 .js 文件".into());
        }
        let metadata = std::fs::metadata(&path).map_err(|e| e.to_string())?;
        if metadata.len() > 4 * 1024 * 1024 {
            return Err("脚本超过 4 MB".into());
        }
        return std::fs::read_to_string(path).map_err(|e| e.to_string());
    }
    if !matches!(url.scheme(), "http" | "https") {
        return Err("脚本仅支持 HTTP(S) 或本地 JS 文件".into());
    }
    let cache = CACHE.get_or_init(Default::default);
    if let Some((when, text)) = cache.lock().map_err(|_| "缓存锁异常")?.get(name) {
        if when.elapsed() < Duration::from_secs(300) {
            return Ok(text.clone());
        }
    }
    let mut bytes = Vec::new();
    client()?
        .get(url)
        .send()
        .and_then(|r| r.error_for_status())
        .map_err(|e| e.to_string())?
        .take(4 * 1024 * 1024 + 1)
        .read_to_end(&mut bytes)
        .map_err(|e| e.to_string())?;
    if bytes.len() > 4 * 1024 * 1024 {
        return Err("脚本超过 4 MB".into());
    }
    let text = String::from_utf8(bytes).map_err(|_| "脚本不是 UTF-8")?;
    let mut guard = cache.lock().map_err(|_| "缓存锁异常")?;
    if guard.len() > 64 {
        guard.clear();
    }
    guard.insert(name.into(), (Instant::now(), text.clone()));
    Ok(text)
}
struct UrlResolver;
impl Resolver for UrlResolver {
    fn resolve<'js>(
        &mut self,
        _ctx: &Ctx<'js>,
        base: &str,
        name: &str,
    ) -> rquickjs::Result<String> {
        reqwest::Url::parse(name)
            .or_else(|_| reqwest::Url::parse(base)?.join(name))
            .map(|u| u.to_string())
            .map_err(|e| rquickjs::Error::new_resolving_message(base, name, e.to_string()))
    }
}
struct HttpLoader;
impl Loader for HttpLoader {
    fn load<'js>(&mut self, ctx: &Ctx<'js>, name: &str) -> rquickjs::Result<Module<'js, Declared>> {
        let mut text = source(name).map_err(|e| rquickjs::Error::new_loading_message(name, e))?;
        if text.trim_start().starts_with("//bb") || text.trim_start().starts_with("//DRPY") {
            return Err(rquickjs::Error::new_loading_message(
                name,
                "Android QuickJS 字节码不兼容，请使用源码版脚本",
            ));
        }
        if !text.contains("export ") {
            if text.contains("__jsEvalReturn") {
                text.push_str("\nexport { __jsEvalReturn };\n");
            } else if text.contains("__JS_SPIDER__") {
                text.push_str("\nexport default __JS_SPIDER__;\n");
            }
        }
        Module::declare(ctx.clone(), name, text)
    }
}
fn request(address: String, options: String) -> Result<String, String> {
    let url = reqwest::Url::parse(&address).map_err(|e| e.to_string())?;
    if !matches!(url.scheme(), "http" | "https") {
        return Err("脚本网络请求仅支持 HTTP(S)".into());
    }
    let options: Value = serde_json::from_str(&options).unwrap_or(json!({}));
    let method = options["method"].as_str().unwrap_or("GET").to_uppercase();
    // GET 内容短时缓存（60s）：wogg 等站被 Cloudflare 限流时，重复的首页/分类/详情直接命中
    let cache_key = if method == "GET" {
        Some(format!("{address}|{}", options["headers"]))
    } else {
        None
    };
    if let Some(key) = &cache_key {
        let cache = content_cache().lock().map_err(|_| "缓存锁异常")?;
        if let Some((when, text)) = cache.get(key) {
            if when.elapsed() < Duration::from_secs(60) {
                return Ok(text.clone());
            }
        }
    }
    // 卡顿重试：CF 排队/单连接卡住时，换新连接重试一次往往立即成功
    let mut last_err = String::new();
    for attempt in 0..2 {
        match do_request(&address, &options, &method) {
            Ok(text) => {
                if let Some(key) = &cache_key {
                    if let Ok(mut cache) = content_cache().lock() {
                        if cache.len() >= 256 {
                            cache.clear();
                        }
                        cache.insert(key.clone(), (Instant::now(), text.clone()));
                    }
                }
                return Ok(text);
            }
            Err(error) => {
                last_err = error;
                if attempt == 0 {
                    continue;
                }
            }
        }
    }
    Err(last_err)
}

static CONTENT_CACHE: OnceLock<Mutex<HashMap<String, (Instant, String)>>> = OnceLock::new();

fn content_cache() -> &'static Mutex<HashMap<String, (Instant, String)>> {
    CONTENT_CACHE.get_or_init(Default::default)
}

fn do_request(address: &str, options: &Value, method: &str) -> Result<String, String> {
    let mut req = client()?.request(
        reqwest::Method::from_bytes(method.as_bytes()).map_err(|e| e.to_string())?,
        address,
    ).timeout(Duration::from_secs(8));
    if let Some(headers) = options["headers"].as_object() {
        for (k, v) in headers {
            req = req.header(k, v.as_str().unwrap_or(""));
        }
    }
    if let Some(body) = options.get("body").or_else(|| options.get("data")) {
        req = req.body(
            body.as_str()
                .map(str::to_owned)
                .unwrap_or_else(|| body.to_string()),
        );
    }
    let response = req.send().map_err(|e| e.to_string())?;
    let code = response.status().as_u16();
    let final_url = response.url().to_string();
    let headers: HashMap<String, String> = response
        .headers()
        .iter()
        .map(|(k, v)| (k.to_string(), v.to_str().unwrap_or("").to_string()))
        .collect();
    let mut bytes = Vec::new();
    response
        .take(8 * 1024 * 1024 + 1)
        .read_to_end(&mut bytes)
        .map_err(|e| e.to_string())?;
    if bytes.len() > 8 * 1024 * 1024 {
        return Err("脚本请求响应超过 8 MB".into());
    }
    let content = if options["buffer"].as_i64() == Some(2) {
        STANDARD.encode(bytes)
    } else {
        String::from_utf8_lossy(&bytes).into_owned()
    };
    Ok(json!({"code":code,"headers":headers,"content":content,"url":final_url}).to_string())
}

fn execute(
    api: String,
    key: String,
    ext: Value,
    action: String,
    args: Value,
    local_path: std::path::PathBuf,
) -> Result<Value, String> {
    let runtime = Runtime::new().map_err(|e| e.to_string())?;
    runtime.set_memory_limit(96 * 1024 * 1024);
    runtime.set_max_stack_size(1024 * 1024);
    let started = Instant::now();
    runtime.set_interrupt_handler(Some(Box::new(move || {
        started.elapsed() > Duration::from_secs(30)
    })));
    runtime.set_loader(UrlResolver, HttpLoader);
    let context = Context::full(&runtime).map_err(|e| e.to_string())?;
    context.with(|ctx| -> Result<Value,String> {
        let result=(|| -> rquickjs::Result<String> {
            ctx.globals().set("__http",Function::new(ctx.clone(),move |url:String,opts:String| request(url,opts).map_err(|e| rquickjs::Error::new_from_js_message("HTTP","response",e)))?)?;
            ctx.globals().set("__b64",Function::new(ctx.clone(),|value:String| STANDARD.encode(value.as_bytes()))?)?;
            ctx.globals().set("__unb64",Function::new(ctx.clone(),|value:String| String::from_utf8_lossy(&STANDARD.decode(value).unwrap_or_default()).into_owned())?)?;
            ctx.globals().set("__md5",Function::new(ctx.clone(),|value:String| { use md5::{Digest,Md5}; format!("{:x}",Md5::digest(value.as_bytes())) })?)?;
            // Bttwoo（比特兔）播放签名：QuickJS 无 WebAssembly，交 Rust wasmi 执行上游 nbmovie_wasm
            ctx.globals().set("__nbmovieSign",Function::new(ctx.clone(),|dataid:String,vid:String,quality:String,userlink:String| crate::nbmovie::build_play_url(&dataid,&vid,&quality,&userlink).map_err(|e| rquickjs::Error::new_from_js_message("wasm","build_play_url",e)))?)?;
            ctx.globals().set("joinUrl",Function::new(ctx.clone(),|base:String,child:String| reqwest::Url::parse(&base).and_then(|u|u.join(&child)).map(|u|u.to_string()).unwrap_or(child))?)?;
            ctx.globals().set("__html",Function::new(ctx.clone(),html_query)?)?;
            ctx.globals().set("__url",Function::new(ctx.clone(),|value:String,base:String| -> String {
                let parsed=reqwest::Url::parse(&value).or_else(|_|reqwest::Url::parse(&base)?.join(&value));
                match parsed {Ok(u)=>json!({"href":u.as_str(),"protocol":format!("{}:",u.scheme()),"hostname":u.host_str().unwrap_or(""),"host":format!("{}{}",u.host_str().unwrap_or(""),u.port().map(|p|format!(":{p}")).unwrap_or_default()),"origin":u.origin().ascii_serialization(),"pathname":u.path(),"search":u.query().map(|q|format!("?{q}")).unwrap_or_default(),"hash":u.fragment().map(|f|format!("#{f}")).unwrap_or_default()}).to_string(),Err(_)=>"null".into()}
            })?)?;
            ctx.globals().set("__random",Function::new(ctx.clone(),|n:usize| {let mut bytes=vec![0u8;n.min(65536)];let _=getrandom::fill(&mut bytes);serde_json::to_string(&bytes).unwrap_or("[]".into())})?)?;
            let script_scope=key.clone();
            ctx.globals().set("__local",Function::new(ctx.clone(),move |op:String,namespace:String,k:String,v:String| -> String {
                let Ok(_lock)=LOCAL.lock() else { return String::new() };
                let mut data:Value=std::fs::read(&local_path).ok().and_then(|b| serde_json::from_slice(&b).ok()).unwrap_or(json!({}));
                let path=format!("{script_scope}:{namespace}:{k}");
                if op=="get" { return data[&path].as_str().unwrap_or("").to_string(); }
                if op=="delete" { data.as_object_mut().map(|m| m.remove(&path)); } else { data[&path]=Value::String(v); }
                if let Ok(bytes)=serde_json::to_vec(&data) { if bytes.len()<4*1024*1024 { let temp=local_path.with_extension("tmp"); if std::fs::write(&temp,bytes).is_ok() { let _=std::fs::rename(temp,&local_path); } } }
                String::new()
            })?)?;
            ctx.eval::<(),_>(r#"
                globalThis.__JS_SPIDER__ = undefined;
                globalThis.console = {log(){},warn(){},error(){},info(){},debug(){}};
                globalThis.req = globalThis.http = (url,opts={}) => JSON.parse(__http(String(url),JSON.stringify(opts)));
                globalThis.request = (url,opts={}) => req(url,opts).content;
                globalThis._http = (url,opts={})=>{const result=req(url,opts);if(opts.complete)opts.complete(result);return result;};
                globalThis.fetch = async (url,opts={}) => { const r=req(url,opts); return {ok:r.code>=200&&r.code<300,status:r.code,headers:r.headers,url:r.url,text:async()=>r.content,json:async()=>JSON.parse(r.content)}; };
                globalThis.base64Encode = globalThis.btoa = __b64;
                globalThis.base64Decode = globalThis.atob = __unb64;
                globalThis.md5 = __md5;
                globalThis.local = {get:(n,k)=>__local('get',n,k,''),set:(n,k,v)=>__local('set',n,k,String(v)),delete:(n,k)=>__local('delete',n,k,'')};
                globalThis.log = ()=>{};
                globalThis.pdfh = (html,rule)=>__html(html,rule,false);
                globalThis.pdfa = (html,rule)=>JSON.parse(__html(html,rule,true));
                globalThis.pd = (html,rule,base='')=>{const value=pdfh(html,rule);return base&&value?joinUrl(base,value):value;};
                globalThis.URLSearchParams = class {
                  constructor(value=''){this.items=String(value).replace(/^\?/,'').split('&').filter(Boolean).map(pair=>{const i=pair.indexOf('=');return [decodeURIComponent((i<0?pair:pair.slice(0,i)).replace(/\+/g,' ')),decodeURIComponent((i<0?'':pair.slice(i+1)).replace(/\+/g,' '))]})}
                  get(key){return this.items.find(p=>p[0]===key)?.[1]??null} set(key,value){this.items=this.items.filter(p=>p[0]!==key);this.items.push([key,String(value)])} append(key,value){this.items.push([key,String(value)])} toString(){return this.items.map(p=>p.map(encodeURIComponent).join('=')).join('&')}
                };
                globalThis.URL = class {constructor(value,base=''){const parsed=JSON.parse(__url(String(value),String(base)));if(!parsed)throw Error('Invalid URL');Object.assign(this,parsed);this.searchParams=new URLSearchParams(this.search)}toString(){const query=this.searchParams.toString();return this.origin+this.pathname+(query?'?'+query:'')+this.hash}};
                globalThis.TextEncoder=class {encode(value){return Uint8Array.from(unescape(encodeURIComponent(String(value))),c=>c.charCodeAt(0))}};
                globalThis.TextDecoder=class {decode(value){return decodeURIComponent(escape(Array.from(value,b=>String.fromCharCode(b)).join('')))}};
                globalThis.crypto={getRandomValues(array){const bytes=JSON.parse(__random(array.byteLength));new Uint8Array(array.buffer,array.byteOffset,array.byteLength).set(bytes);return array}};
            "#)?;
            let bootstrap=format!(r#"
                import * as m from {api};
                const cat=typeof m.__jsEvalReturn==='function';
                const spider=cat ? m.__jsEvalReturn() : (typeof m.default==='function' ? m.default() : m.default || globalThis.__JS_SPIDER__);
                if (!spider) throw Error('脚本未导出 Spider');
                const ext={ext}, args={args}, action={action};
                if (spider.init) await spider.init(cat ? {{stype:3,skey:{key},ext}} : ext);
                let result;
                if (action==='home') result=await spider.home(true);
                else if (action==='category') result=await spider.category(String(args.t),String(args.page||1),true,args.filters||{{}});
                else if (action==='detail') result=await spider.detail(String(args.id));
                else if (action==='search') result=await spider.search(args.keyword,false,String(args.page||1));
                else if (action==='play') result=await spider.play(args.flag||'',args.id,args.flags||[]);
                else throw Error('不支持的脚本操作');
                if (action==='home' && spider.homeVod) {{ let data=typeof result==='string'?JSON.parse(result):result; if (!data.list?.length) {{ let home=await spider.homeVod(); home=typeof home==='string'?JSON.parse(home):home; data.list=home.list||[]; }} result=data; }}
                globalThis.__result=typeof result==='string'?result:JSON.stringify(result);
            "#,api=serde_json::to_string(&api).unwrap(),ext=ext,args=args,action=serde_json::to_string(&action).unwrap(),key=serde_json::to_string(&key).unwrap());
            let promise:Promise=Module::evaluate(ctx.clone(),"https://simpletools.invalid/bootstrap.js",bootstrap)?;
            promise.finish::<()>()?;
            ctx.globals().get("__result")
        })();
        let text=result.map_err(|e| { if e.is_exception() { format!("JS 爬虫执行失败：{:?}",ctx.catch()) } else { format!("JS 爬虫执行失败：{e}") } })?;
        serde_json::from_str(&text).map_err(|e| format!("JS 爬虫返回的不是 JSON：{e}"))
    })
}

#[tauri::command]
pub async fn tvbox_spider(
    app: tauri::AppHandle,
    api: String,
    key: String,
    ext: Value,
    action: String,
    args: Value,
) -> Result<Value, String> {
    let local_path = crate::datadir::data_dir(&app)?.join("tvbox-script-local.json");
    tauri::async_runtime::spawn_blocking(move || execute(api, key, ext, action, args, local_path))
        .await
        .map_err(|e| e.to_string())?
}

#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn js_spider_module_and_async_methods() {
        let path =
            std::env::temp_dir().join(format!("simpletools-spider-{}.js", std::process::id()));
        std::fs::write(&path,"export default {init(ext){this.ext=ext},async home(){return {class:[{type_id:'1',type_name:this.ext}]}}}").unwrap();
        let url = reqwest::Url::from_file_path(&path).unwrap().to_string();
        let result = execute(
            url,
            "test".into(),
            json!("电影"),
            "home".into(),
            json!({}),
            path.with_extension("json"),
        )
        .unwrap();
        assert_eq!(result["class"][0]["type_name"], "电影");
        let _ = std::fs::remove_file(path);
    }
    #[test]
    fn html_helpers_extract_links_and_text() {
        let html="<body><ul><li><a href='/one'>第一集</a></li><li><a href='/two'>第二集</a></li></ul></body>";
        assert_eq!(
            html_query(html.into(), "body&&li:eq(1)&&a&&href".into(), false),
            "/two"
        );
        assert_eq!(
            html_query(html.into(), "body&&a&&Text".into(), false),
            "第一集"
        );
        let list: Value =
            serde_json::from_str(&html_query(html.into(), "body&&li".into(), true)).unwrap();
        assert_eq!(list.as_array().unwrap().len(), 2);
    }
    #[test]
    fn cat_factory_and_host_helpers_work_without_external_runtime() {
        let path = std::env::temp_dir().join(format!("simpletools-cat-{}.js", std::process::id()));
        std::fs::write(&path,r#"export function __jsEvalReturn(){return {init(cfg){this.cfg=cfg},home(){const u=new URL('../a?name=%E4%B8%AD','https://host.test/dir/b');return JSON.stringify({list:[],class:[{type_id:u.searchParams.get('name'),type_name:pdfh('<b>电影</b>','b&&Text')+this.cfg.skey}]})}}}"#).unwrap();
        let result = execute(
            reqwest::Url::from_file_path(&path).unwrap().to_string(),
            "cat".into(),
            json!({}),
            "home".into(),
            json!({}),
            path.with_extension("json"),
        )
        .unwrap();
        assert_eq!(result["class"][0]["type_name"], "电影cat");
        assert_eq!(result["class"][0]["type_id"], "中");
        let _ = std::fs::remove_file(path);
    }
    #[test]
    fn js_http_bridge_fetches_real_local_endpoint() {
        use std::io::{Read, Write};
        let listener = std::net::TcpListener::bind("127.0.0.1:0").unwrap();
        let address = listener.local_addr().unwrap();
        let server = std::thread::spawn(move || {
            let (mut stream, _) = listener.accept().unwrap();
            stream
                .set_read_timeout(Some(Duration::from_secs(5)))
                .unwrap();
            let mut bytes = [0; 2048];
            let _ = stream.read(&mut bytes);
            let body = r#"{"class":[{"type_id":"1","type_name":"HTTP源"}],"list":[]}"#;
            write!(stream,"HTTP/1.1 200 OK\r\nContent-Length: {}\r\nContent-Type: application/json\r\nConnection: close\r\n\r\n{}",body.len(),body).unwrap();
        });
        let path =
            std::env::temp_dir().join(format!("simpletools-http-spider-{}.js", std::process::id()));
        std::fs::write(
            &path,
            format!("export default {{home(){{return req('http://{address}/api').content}}}}"),
        )
        .unwrap();
        let result = execute(
            reqwest::Url::from_file_path(&path).unwrap().to_string(),
            "http".into(),
            json!({}),
            "home".into(),
            json!({}),
            path.with_extension("json"),
        )
        .unwrap();
        assert_eq!(result["class"][0]["type_name"], "HTTP源");
        server.join().unwrap();
        let _ = std::fs::remove_file(path);
    }
    #[test]
    fn bundled_bili_adapter_loads_upstream_profile_without_jar() {
        use std::io::{Read, Write};
        let listener = std::net::TcpListener::bind("127.0.0.1:0").unwrap();
        let address = listener.local_addr().unwrap();
        let server = std::thread::spawn(move || {
            let (mut stream, _) = listener.accept().unwrap();
            let mut bytes = [0; 2048];
            let _ = stream.read(&mut bytes);
            let body = r#"{"class":[{"type_id":"4K","type_name":"四K"}],"filters":{"4K":[]}}"#;
            write!(stream,"HTTP/1.1 200 OK\r\nContent-Length: {}\r\nContent-Type: application/json\r\nConnection: close\r\n\r\n{}",body.len(),body).unwrap();
        });
        let path = std::env::temp_dir().join(format!(
            "simpletools-bili-spider-{}.js",
            std::process::id()
        ));
        std::fs::write(
            &path,
            include_str!("../resources/tvspiders/bili.js"),
        )
        .unwrap();
        let result = execute(
            reqwest::Url::from_file_path(&path).unwrap().to_string(),
            "bili".into(),
            json!({"json": format!("http://{address}/profile.json")}),
            "home".into(),
            json!({}),
            path.with_extension("json"),
        )
        .unwrap();
        assert_eq!(result["class"][0]["type_id"], "4K");
        assert_eq!(result["filters"]["4K"], json!([]));
        server.join().unwrap();
        let _ = std::fs::remove_file(path);
    }

    #[test]
    fn bundled_newcz_adapter_parses_detail_and_direct_stream_without_jar() {
        use std::io::{Read, Write};
        let listener = std::net::TcpListener::bind("127.0.0.1:0").unwrap();
        let address = listener.local_addr().unwrap();
        let server = std::thread::spawn(move || {
            for _ in 0..2 {
                let (mut stream, _) = listener.accept().unwrap();
                let mut bytes = [0; 4096];
                let size = stream.read(&mut bytes).unwrap();
                let request = String::from_utf8_lossy(&bytes[..size]);
                let body = if request.contains("/movie/42.html") {
                    r#"<html><head><meta property="og:image" content="/poster.jpg"></head><body><h1>测试影片</h1><div class="entry-content">这是简介</div><a href="/v_play/episode-1.html" title="第1集">播放</a></body></html>"#
                } else {
                    r#"<html><script>var player="https:\/\/media.test\/video.m3u8";</script></html>"#
                };
                write!(stream,"HTTP/1.1 200 OK\r\nContent-Length: {}\r\nContent-Type: text/html; charset=utf-8\r\nConnection: close\r\n\r\n{}",body.len(),body).unwrap();
            }
        });
        let path = std::env::temp_dir().join(format!(
            "simpletools-newcz-spider-{}.js",
            std::process::id()
        ));
        let script = include_str!("../resources/tvspiders/newcz.js")
            .replace("https://www.4kcz.com", &format!("http://{address}"));
        std::fs::write(&path, script).unwrap();
        let api = reqwest::Url::from_file_path(&path).unwrap().to_string();
        let state = path.with_extension("json");
        let detail = execute(
            api.clone(),
            "newcz".into(),
            json!(""),
            "detail".into(),
            json!({"id": format!("http://{address}/movie/42.html")}),
            state.clone(),
        )
        .unwrap();
        assert_eq!(detail["list"][0]["vod_name"], "测试影片");
        assert_eq!(detail["list"][0]["vod_play_url"], "第1集$v_play/episode-1.html");
        let play = execute(
            api,
            "newcz".into(),
            json!(""),
            "play".into(),
            json!({"flag":"专线","id":"v_play/episode-1.html"}),
            state,
        )
        .unwrap();
        assert_eq!(play["parse"], 0);
        assert_eq!(play["url"], "https://media.test/video.m3u8");
        server.join().unwrap();
        let _ = std::fs::remove_file(path);
    }

    #[test]
    fn bundled_jpys_adapter_resolves_episode_to_best_stream_without_jar() {
        use std::io::{Read, Write};
        let listener = std::net::TcpListener::bind("127.0.0.1:0").unwrap();
        let address = listener.local_addr().unwrap();
        let server = std::thread::spawn(move || {
            for _ in 0..2 {
                let (mut stream, _) = listener.accept().unwrap();
                let mut bytes = [0; 4096];
                let size = stream.read(&mut bytes).unwrap();
                let request = String::from_utf8_lossy(&bytes[..size]);
                let body = if request.contains("/video/detail") {
                    r#"{"code":200,"data":{"vodId":42,"vodName":"测试影片","vodPic":"p.jpg","episodeList":[{"nid":7,"name":"第1集"}]}}"#
                } else {
                    r#"{"code":200,"data":{"list":[{"resolution":720,"url":"https://media.test/720.m3u8"},{"resolution":2160,"url":"https://media.test/4k.m3u8"}]}}"#
                };
                write!(stream,"HTTP/1.1 200 OK\r\nContent-Length: {}\r\nContent-Type: application/json\r\nConnection: close\r\n\r\n{}",body.len(),body).unwrap();
            }
        });
        let path = std::env::temp_dir().join(format!(
            "simpletools-jpys-spider-{}.js",
            std::process::id()
        ));
        let script = include_str!("../resources/tvspiders/jpys.js")
            .replace("https://www.ghw9zwp5.com", &format!("http://{address}"));
        std::fs::write(&path, script).unwrap();
        let api = reqwest::Url::from_file_path(&path).unwrap().to_string();
        let state = path.with_extension("json");
        let detail = execute(
            api.clone(), "jpys".into(), json!(""), "detail".into(), json!({"id":"42"}), state.clone(),
        ).unwrap();
        assert_eq!(detail["list"][0]["vod_play_url"], "第1集$42@7");
        assert_eq!(detail["list"][0]["vod_pic"], format!("http://{address}/p.jpg"));
        let play = execute(
            api, "jpys".into(), json!(""), "play".into(), json!({"flag":"爱电影","id":"42@7"}), state,
        ).unwrap();
        assert_eq!(play["parse"], 0);
        assert_eq!(play["url"], "https://media.test/4k.m3u8");
        server.join().unwrap();
        let _ = std::fs::remove_file(path);
    }

    #[test]
    fn bundled_melost_adapters_search_cloud_links_without_jar() {
        use std::io::{Read, Write};
        let listener = std::net::TcpListener::bind("127.0.0.1:0").unwrap();
        let address = listener.local_addr().unwrap();
        let server = std::thread::spawn(move || {
            for expected_type in ["QUARK", "BDY"] {
                let (mut stream, _) = listener.accept().unwrap();
                let mut bytes = [0; 8192];
                let size = stream.read(&mut bytes).unwrap();
                let request = String::from_utf8_lossy(&bytes[..size]);
                assert!(request.starts_with("POST /v1/search/disk"));
                assert!(request.contains(&format!("\"type\":\"{expected_type}\"")));
                let link = if expected_type == "QUARK" {
                    "https://pan.quark.cn/s/test123"
                } else {
                    "https://pan.baidu.com/s/test456"
                };
                let body = format!(r#"{{"code":200,"data":{{"total":1,"per_size":15,"list":[{{"disk_name":"<em>测试</em> 4K","shared_time":"2026-01-01","size":1073741824,"link":"{link}"}}]}}}}"#);
                write!(stream,"HTTP/1.1 200 OK\r\nContent-Length: {}\r\nContent-Type: application/json\r\nConnection: close\r\n\r\n{}",body.len(),body).unwrap();
            }
        });
        for (file, key, expected) in [
            ("melost-quark.js", "YpanSo", "https://pan.quark.cn/s/test123"),
            ("melost-baidu.js", "BpanSo", "https://pan.baidu.com/s/test456"),
        ] {
            let path = std::env::temp_dir().join(format!("simpletools-{key}-{}.js", std::process::id()));
            let original = match file {
                "melost-quark.js" => include_str!("../resources/tvspiders/melost-quark.js"),
                _ => include_str!("../resources/tvspiders/melost-baidu.js"),
            };
            std::fs::write(&path, original.replace("https://www.melost.cn", &format!("http://{address}"))).unwrap();
            let api = reqwest::Url::from_file_path(&path).unwrap().to_string();
            let result = execute(api, key.into(), json!(""), "search".into(), json!({"keyword":"测试","page":1}), path.with_extension("json")).unwrap();
            assert_eq!(result["list"][0]["vod_id"], expected);
            assert_eq!(result["list"][0]["vod_name"], "测试 4K");
            let _ = std::fs::remove_file(path);
        }
        server.join().unwrap();
    }

    #[test]
    fn bundled_cloud_search_combines_quark_and_baidu_without_jar() {
        use std::io::{Read, Write};
        let listener = std::net::TcpListener::bind("127.0.0.1:0").unwrap();
        let address = listener.local_addr().unwrap();
        let server = std::thread::spawn(move || {
            for _ in 0..2 {
                let (mut stream, _) = listener.accept().unwrap();
                let mut bytes = [0; 8192];
                let size = stream.read(&mut bytes).unwrap();
                let request = String::from_utf8_lossy(&bytes[..size]);
                let (kind, link) = if request.contains("\"type\":\"QUARK\"") {
                    ("QUARK", "https://pan.quark.cn/s/q1")
                } else {
                    ("BDY", "https://pan.baidu.com/s/1b1")
                };
                let body = format!(r#"{{"code":200,"data":{{"total":1,"per_size":15,"list":[{{"disk_name":"{kind} 4K","disk_type":"{kind}","link":"{link}"}}]}}}}"#);
                write!(stream,"HTTP/1.1 200 OK\r\nContent-Length: {}\r\nContent-Type: application/json\r\nConnection: close\r\n\r\n{}",body.len(),body).unwrap();
            }
        });
        let path = std::env::temp_dir().join(format!("simpletools-cloud-search-{}.js", std::process::id()));
        let script = include_str!("../resources/tvspiders/cloud-search.js").replace("https://www.melost.cn", &format!("http://{address}"));
        std::fs::write(&path, script).unwrap();
        let api = reqwest::Url::from_file_path(&path).unwrap().to_string();
        let result = execute(api, "KkSs".into(), json!(""), "search".into(), json!({"keyword":"测试","page":1}), path.with_extension("json")).unwrap();
        assert_eq!(result["list"].as_array().unwrap().len(), 2);
        assert_eq!(result["total"], 2);
        server.join().unwrap();
        let _ = std::fs::remove_file(path);
    }

    #[test]
    fn bundled_wogg_adapter_keeps_filters_posters_and_cloud_routes() {
        use std::io::{Read, Write};
        let listener = std::net::TcpListener::bind("127.0.0.1:0").unwrap();
        let address = listener.local_addr().unwrap();
        let server = std::thread::spawn(move || {
            for _ in 0..3 {
                let (mut stream, _) = listener.accept().unwrap();
                let mut bytes = [0; 8192];
                let size = stream.read(&mut bytes).unwrap();
                let request = String::from_utf8_lossy(&bytes[..size]);
                let body = if request.contains("/voddetail/42.html") {
                    r#"<div class='video-cover'><img data-src='/poster-detail.jpg'></div><h1 class='page-title'>测试影片</h1><div class='video-info-items'><span class='video-info-itemtitle'>年代：</span><div>2026</div></div><p class='sqjj_a'>完整剧情</p><a href='https://pan.quark.cn/s/q1'>夸克</a><a data-clipboard-text='https://pan.baidu.com/s/b1?pwd=8888'>百度</a>"#
                } else {
                    r#"<div class='module-item'><a href='/voddetail/42.html' title='测试影片'></a><img data-src='/poster.jpg'><div class='module-item-caption'><span>2026</span></div><a class='module-item-title' title='测试影片'></a><div class='module-item-text'>4K</div></div>"#
                };
                write!(stream,"HTTP/1.1 200 OK\r\nContent-Length: {}\r\nContent-Type: text/html; charset=utf-8\r\nConnection: close\r\n\r\n{}",body.len(),body).unwrap();
            }
        });
        let path = std::env::temp_dir().join(format!("simpletools-wogg-{}.js", std::process::id()));
        let script = include_str!("../resources/tvspiders/wogg.js").replace("https://www.wogg.net", &format!("http://{address}"));
        std::fs::write(&path, script).unwrap();
        let api = reqwest::Url::from_file_path(&path).unwrap().to_string();
        let state = path.with_extension("json");
        let home = execute(api.clone(), "WoGG".into(), json!(""), "home".into(), json!({}), state.clone()).unwrap();
        assert_eq!(home["class"].as_array().unwrap().len(), 8);
        assert_eq!(home["filters"]["1"].as_array().unwrap().len(), 3);
        assert_eq!(home["list"][0]["vod_pic"], format!("http://{address}/poster.jpg"));
        let category = execute(api.clone(), "WoGG".into(), json!(""), "category".into(), json!({"t":"1","page":1,"filters":{"1":"美国","3":"动作","11":"2026"}}), state.clone()).unwrap();
        assert_eq!(category["list"][0]["vod_name"], "测试影片");
        let detail = execute(api, "WoGG".into(), json!(""), "detail".into(), json!({"id":"42"}), state).unwrap();
        assert_eq!(detail["list"][0]["vod_pic"], format!("http://{address}/poster-detail.jpg"));
        assert_eq!(detail["list"][0]["vod_year"], "2026");
        assert_eq!(detail["list"][0]["vod_play_from"], "夸克网盘$$$百度网盘");
        server.join().unwrap();
        let _ = std::fs::remove_file(path);
    }

    #[test]
    fn bundled_sixv_adapter_extracts_search_and_download_links_without_jar() {
        use std::io::{Read, Write};
        let listener = std::net::TcpListener::bind("127.0.0.1:0").unwrap();
        let address = listener.local_addr().unwrap();
        let server = std::thread::spawn(move || {
            for index in 0..2 {
                let (mut stream, _) = listener.accept().unwrap();
                let mut bytes = [0; 8192];
                let size = stream.read(&mut bytes).unwrap();
                let request = String::from_utf8_lossy(&bytes[..size]);
                let body = if index == 0 {
                    assert!(request.starts_with("POST /e/search/so.php"));
                    r#"<a href='/dianshiju/1.html' class='zoom' title='测试 4K'><img src='/cover.jpg'></a>"#
                } else {
                    r#"<title>测试影片-新版6v</title><div id='post_content'><img src='/p.jpg'><a href='https://pan.quark.cn/s/q1'>夸克4K</a><a href='magnet:?xt=urn:btih:abc&amp;dn=test'>2160P.mkv</a></div></div>"#
                };
                write!(stream,"HTTP/1.1 200 OK\r\nContent-Length: {}\r\nContent-Type: text/html; charset=utf-8\r\nConnection: close\r\n\r\n{}",body.len(),body).unwrap();
            }
        });
        let path = std::env::temp_dir().join(format!("simpletools-sixv-{}.js", std::process::id()));
        let script = include_str!("../resources/tvspiders/sixv.js").replace("https://www.xb6v.com", &format!("http://{address}"));
        std::fs::write(&path, script).unwrap();
        let api = reqwest::Url::from_file_path(&path).unwrap().to_string();
        let state = path.with_extension("json");
        let search = execute(api.clone(), "SixV".into(), json!(""), "search".into(), json!({"keyword":"测试","page":1}), state.clone()).unwrap();
        assert_eq!(search["list"][0]["vod_name"], "测试 4K");
        let detail = execute(api, "SixV".into(), json!(""), "detail".into(), json!({"id":format!("http://{address}/dianshiju/1.html")}), state).unwrap();
        assert!(detail["list"][0]["vod_play_url"].as_str().unwrap().starts_with("夸克4K$https://pan.quark.cn/s/q1"));
        assert!(detail["list"][0]["vod_play_url"].as_str().unwrap().contains("magnet:?xt=urn:btih:abc&dn=test"));
        server.join().unwrap();
        let _ = std::fs::remove_file(path);
    }

    #[test]
    fn bundled_push_adapter_accepts_named_cloud_and_magnet_links_without_jar() {
        let path = std::env::temp_dir().join(format!("simpletools-push-{}.js", std::process::id()));
        std::fs::write(&path, include_str!("../resources/tvspiders/push.js")).unwrap();
        let api = reqwest::Url::from_file_path(&path).unwrap().to_string();
        let state = path.with_extension("json");
        let detail = execute(
            api.clone(),
            "Push".into(),
            json!(""),
            "detail".into(),
            json!({"id":"庆余年$https://pan.quark.cn/s/test123"}),
            state.clone(),
        )
        .unwrap();
        assert_eq!(detail["list"][0]["vod_name"], "夸克网盘");
        assert_eq!(detail["list"][0]["vod_play_url"], "夸克网盘$https://pan.quark.cn/s/test123");
        let play = execute(
            api,
            "Push".into(),
            json!(""),
            "play".into(),
            json!({"flag":"磁力资源","id":"magnet:?xt=urn:btih:abc&dn=test"}),
            state,
        )
        .unwrap();
        assert_eq!(play["parse"], 0);
        assert_eq!(play["url"], "magnet:?xt=urn:btih:abc&dn=test");
        let _ = std::fs::remove_file(path);
    }

    #[test]
    fn bundled_ygp_adapter_searches_and_builds_trailer_pages_without_jar() {
        use std::io::{Read, Write};
        let listener = std::net::TcpListener::bind("127.0.0.1:0").unwrap();
        let address = listener.local_addr().unwrap();
        let server = std::thread::spawn(move || {
            for index in 0..2 {
                let (mut stream, _) = listener.accept().unwrap();
                let mut bytes = [0; 4096];
                let size = stream.read(&mut bytes).unwrap();
                let request = String::from_utf8_lossy(&bytes[..size]);
                let body = if index == 0 {
                    assert!(request.contains("keyword=%E5%BA%86%E4%BD%99%E5%B9%B4%20%E9%A2%84%E5%91%8A%E7%89%87"));
                    r#"{"code":0,"data":{"numPages":1,"numResults":1,"pagesize":20,"result":[{"bvid":"BV1test","title":"<em>庆余年</em>预告","pic":"//img.test/p.jpg","duration":"01:20"}]}}"#
                } else {
                    assert!(request.contains("bvid=BV1test"));
                    r#"{"code":0,"data":{"title":"庆余年预告","pic":"//img.test/p.jpg","desc":"简介","pages":[{"page":1,"part":"正式预告"},{"page":2,"part":"终极预告"}]}}"#
                };
                write!(stream, "HTTP/1.1 200 OK\r\nContent-Length: {}\r\nContent-Type: application/json\r\nConnection: close\r\n\r\n{}", body.len(), body).unwrap();
            }
        });
        let path = std::env::temp_dir().join(format!("simpletools-ygp-{}.js", std::process::id()));
        let script = include_str!("../resources/tvspiders/ygp.js").replace("https://api.bilibili.com", &format!("http://{address}"));
        std::fs::write(&path, script).unwrap();
        let api = reqwest::Url::from_file_path(&path).unwrap().to_string();
        let state = path.with_extension("json");
        let search = execute(api.clone(), "YGP".into(), json!(""), "search".into(), json!({"keyword":"庆余年","page":1}), state.clone()).unwrap();
        assert_eq!(search["list"][0]["vod_id"], "BV1test");
        let detail = execute(api, "YGP".into(), json!(""), "detail".into(), json!({"id":"BV1test"}), state).unwrap();
        assert!(detail["list"][0]["vod_play_url"].as_str().unwrap().contains("终极预告$https://www.bilibili.com/video/BV1test?p=2"));
        server.join().unwrap();
        let _ = std::fs::remove_file(path);
    }
}
