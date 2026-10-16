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
    reqwest::blocking::Client::builder()
        .user_agent(crate::tvbox::TVBOX_UA)
        .timeout(Duration::from_secs(15))
        .build()
        .map_err(|e| e.to_string())
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
    let mut req = client()?.request(
        reqwest::Method::from_bytes(method.as_bytes()).map_err(|e| e.to_string())?,
        url,
    );
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
}
