package com.github.catvod.net;
import okhttp3.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class OkHttp {
    private static OkDns dns=new OkDns();
    private static OkHttpClient client;
    /** 桌面诊断用：全局请求/响应日志（只打印 URL/状态/JSON 前 300 字，不消费响应体） */
    /** 扫码登录轮询计数（桌面端没有扫码窗口，JAR 会无限轮询 getServiceTicketByQrcodeToken 占满线程） */
    private static final java.util.concurrent.ConcurrentHashMap<String,Integer> LOGIN_POLL=new java.util.concurrent.ConcurrentHashMap<>();
    /** JAR 的播放结果处理（N0.p 的 RQ）会先消费一次响应体（日志/状态检查），随后再次 body().string() →
     * okhttp 抛 IllegalStateException: closed，导致播放 URL 生成失败、转存无限重试。
     * 这里把 JSON/文本类小响应体缓存为可重复读：只要不与视频流式响应冲突，多次 string() 都返回相同内容。 */
    /** 通用云盘登录态注入（兼容所有 JAR）：任何 JAR 访问网盘域名时，自动把宿主保存的登录 Cookie 合并进请求头。
     *  不依赖 JAR 内部的混淆类名/字段名，换任何 JAR 都能生效；JAR 自己带的 Cookie 键优先，缺失的键补全。 */
    private static final Interceptor COOKIE=new Interceptor(){
        @Override public Response intercept(Chain chain)throws java.io.IOException{
            Request req=chain.request();
            try{
                String host=req.url().host().toLowerCase();
                String site=host.contains("quark.cn")?"quark"
                        :host.contains("uc.cn")?"uc"
                        :(host.contains("baidu.com")||host.contains("baidupcs.com"))?"baidu"
                        :(host.contains("aliyundrive.com")||host.contains("alipan.com"))?"ali":"";
                if(!site.isEmpty()){
                    String saved=CloudCookieStore.get(site);
                    if(!saved.isEmpty()){
                        String existing=req.header("Cookie");
                        String merged=mergeCookie(existing,saved);
                        if(existing==null||!merged.equals(existing))req=req.newBuilder().header("Cookie",merged).build();
                    }
                }
            }catch(Throwable ignored){}
            return chain.proceed(req);
        }
    };
    /** 读 cloud-cookies.txt（JVM 工作目录即应用数据目录），按文件 mtime 热更新缓存 */
    static final class CloudCookieStore{
        private static long mtime=-1;
        private static final Map<String,String> cache=new java.util.HashMap<>();
        static synchronized String get(String site){
            try{
                java.io.File f=new java.io.File("cloud-cookies.txt");
                if(!f.isFile())return "";
                long m=f.lastModified();
                if(m!=mtime){
                    mtime=m;cache.clear();
                    StringBuilder quark=new StringBuilder(),uc=new StringBuilder(),baidu=new StringBuilder(),ali=new StringBuilder();
                    for(String line:java.nio.file.Files.readAllLines(f.toPath(),java.nio.charset.StandardCharsets.UTF_8)){
                        line=line.trim();
                        if(line.isEmpty()||line.startsWith("#"))continue;
                        int tab=line.indexOf('\t');
                        if(tab<=0)continue;
                        String domain=line.substring(0,tab).trim().toLowerCase();
                        String value=line.substring(tab+1).trim();
                        if(domain.endsWith("quark.cn"))append(quark,value);
                        else if(domain.endsWith("uc.cn"))append(uc,value);
                        else if(domain.endsWith("baidu.com"))append(baidu,value);
                        else if(domain.endsWith("aliyundrive.com")||domain.endsWith("alipan.com"))append(ali,value);
                    }
                    cache.put("quark",quark.toString());cache.put("uc",uc.toString());cache.put("baidu",baidu.toString());cache.put("ali",ali.toString());
                }
                return cache.getOrDefault(site,"");
            }catch(Throwable ignored){return "";}
        }
        private static void append(StringBuilder sb,String value){if(sb.length()>0)sb.append("; ");sb.append(value);}
    }
    /** 合并两组 Cookie：existing（JAR 自带）的键优先，saved（宿主登录态）补齐缺失的键 */
    static String mergeCookie(String existing,String saved){
        if(existing==null||existing.trim().isEmpty())return saved;
        Map<String,String> map=new java.util.LinkedHashMap<>();
        for(String pair:saved.split(";\\s*")){int eq=pair.indexOf('=');if(eq>0)map.put(pair.substring(0,eq).trim(),pair.substring(eq+1));}
        for(String pair:existing.split(";\\s*")){int eq=pair.indexOf('=');if(eq>0)map.put(pair.substring(0,eq).trim(),pair.substring(eq+1));}
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<String,String> e:map.entrySet()){if(sb.length()>0)sb.append("; ");sb.append(e.getKey()).append('=').append(e.getValue());}
        return sb.toString();
    }
    private static final Interceptor REPEATABLE=new Interceptor(){
        @Override public Response intercept(Chain chain)throws java.io.IOException{
            Response resp=chain.proceed(chain.request());
            try{
                ResponseBody body=resp.body();
                if(body==null)return resp;
                MediaType type=body.contentType();
                String ts=type==null?"":type.toString();
                long len=body.contentLength();
                boolean wrap=(ts.contains("json")||ts.contains("text")||ts.contains("html")||ts.contains("javascript")||ts.contains("xml"))
                        &&(len<0||len<4*1024*1024);
                System.err.println("[REPEATABLE] "+chain.request().url()+" type="+ts+" len="+len+" wrap="+wrap);
                if(wrap){
                    byte[] bytes=body.bytes();
                    return resp.newBuilder().body(new RepeatableBody(bytes,type)).build();
                }
            }catch(Throwable ignored){}
            return resp;
        }
    };
    static final class RepeatableBody extends ResponseBody{
        private final byte[] bytes;private final MediaType type;
        RepeatableBody(byte[] bytes,MediaType type){this.bytes=bytes;this.type=type;}
        @Override public MediaType contentType(){return type;}
        @Override public long contentLength(){return bytes.length;}
        @Override public okio.BufferedSource source(){return new okio.Buffer().write(bytes);}
    }
    private static final Interceptor LOG=new Interceptor(){
        @Override public Response intercept(Chain chain)throws java.io.IOException{
            Request req=chain.request();
            // 夸克扫码登录轮询（uop.quark.cn/getServiceTicketByQrcodeToken）：桌面端无法扫码展示，
            // 轮询必然失败且无限循环占线程——同一 token 超过 5 次后直接返回 500，让 JAR 轮询快速退出
            String reqUrl=req.url().toString();
            if(reqUrl.contains("getServiceTicketByQrcodeToken")){
                String tok=req.url().queryParameter("token");
                int n=LOGIN_POLL.merge(tok==null?"-":tok,1,Integer::sum);
                // 夸克扫码：桌面端展示二维码供用户扫，轮询必须保留（约 5 分钟窗口）
                if(n>300){
                    throw new java.io.IOException("login required on desktop: qrcode poll timeout");
                }
            }
            Response resp=chain.proceed(req);
            try{
                MediaType ct=resp.body()!=null?resp.body().contentType():null;
                String cts=ct==null?"":ct.toString();
                if(cts.contains("json")){
                    String text=resp.peekBody(8192).string().replaceAll("\\s+"," ");
                    System.err.println("OkHttpNet: "+req.method()+" "+req.url()+" -> "+resp.code()+" body="+text.substring(0,Math.min(300,text.length())));
                    // 探测：网盘扫码登录二维码（百度 getqrcode 的 imgurl / 夸克 getTokenForQrcodeLogin 的 members）
                    if(reqUrl.contains("getqrcode")||reqUrl.contains("QrcodeLogin")){
                        int gi=text.indexOf("imgurl");
                        if(gi>=0)System.err.println("[CLOUD-QR] "+text.substring(Math.max(0,gi),Math.min(text.length(),gi+400)));
                        int mi=text.indexOf("\"members\"");
                        if(mi>=0)System.err.println("[CLOUD-QR] "+text.substring(Math.max(0,mi),Math.min(text.length(),mi+400)));
                        // 夸克扫码 token 落盘：前端据此生成二维码，用户用夸克 App 扫码完成 JAR 内置登录
                        if(reqUrl.contains("getTokenForQrcodeLogin")){
                            int ti=text.indexOf("\"token\":\"");
                            if(ti>=0){
                                int end=text.indexOf('\"',ti+9);
                                if(end>ti+9){
                                    String tk=text.substring(ti+9,end);
                                    try{java.nio.file.Files.write(java.nio.file.Paths.get(System.getProperty("user.dir"),"quark-qr-token.txt"),tk.getBytes(java.nio.charset.StandardCharsets.UTF_8),java.nio.file.StandardOpenOption.CREATE,java.nio.file.StandardOpenOption.TRUNCATE_EXISTING);}catch(Throwable ignored){}
                                    System.err.println("[CLOUD-QR-TOKEN] "+tk);
                                }
                            }
                        }
                    }
                }else{
                    System.err.println("OkHttpNet: "+req.method()+" "+req.url()+" -> "+resp.code()+" type="+cts);
                }
            }catch(Throwable ignored){}
            return resp;
        }
    };
    public static synchronized OkHttpClient client(){if(client==null)client=new OkHttpClient.Builder().dns(dns()).addInterceptor(COOKIE).addInterceptor(LOG).addInterceptor(REPEATABLE).connectTimeout(30,TimeUnit.SECONDS).readTimeout(30,TimeUnit.SECONDS).writeTimeout(30,TimeUnit.SECONDS).build();return client;}
    public static synchronized OkDns dns(){return dns;}
    public static OkHttpClient player(){return client();}
    public static OkHttpClient client(long timeout){return client().newBuilder().connectTimeout(timeout,TimeUnit.MILLISECONDS).readTimeout(timeout,TimeUnit.MILLISECONDS).writeTimeout(timeout,TimeUnit.MILLISECONDS).build();}
    public static OkHttpClient client(boolean redirect,long timeout){return client(timeout).newBuilder().followRedirects(redirect).followSslRedirects(redirect).build();}
    public static OkHttpClient noRedirect(){return noRedirect(30000);}public static OkHttpClient noRedirect(long timeout){return client(false,timeout);}
    public static synchronized void reset(){client=null;dns=new OkDns();}public static synchronized void resetClient(){client=null;}
    private static String read(Call call){try(Response response=call.execute()){String text=response.body()==null?"":response.body().string();android.util.Log.d("OkHttp",call.request().url()+" -> "+response.code()+" len="+text.length());return text;}catch(Exception e){android.util.Log.e("OkHttp","Request failed: "+call.request().url(),e);return "";}}
    public static String string(String url){return read(newCall(url));}public static String string(String url,long timeout){return read(newCall(client(timeout),url));}public static String string(String url,Map<String,String> headers){return read(newCall(url,headers));}
    private static Headers headers(Map<String,String> map){return map==null?new Headers.Builder().build():Headers.of(map);}
    public static Call newCall(String url){return newCall(client(),url);}public static Call newCall(String url,String tag){return newCall(client(),url,tag);}
    public static Call newCall(OkHttpClient client,String url){return client.newCall(new Request.Builder().url(url).build());}
    public static Call newCall(OkHttpClient client,String url,String tag){return client.newCall(new Request.Builder().url(url).tag(tag).build());}
    public static Call newCall(String url,Map<String,String> headers){return client().newCall(new Request.Builder().url(url).headers(headers(headers)).build());}
    public static Call newCall(String url,Map<String,String> headers,androidx.collection.ArrayMap<String,String> params){HttpUrl.Builder builder=HttpUrl.get(url).newBuilder();if(params!=null)for(Map.Entry<String,String> e:params.entrySet())builder.addQueryParameter(e.getKey(),e.getValue());return newCall(builder.build().toString(),headers);}
    public static Call newCall(String url,Map<String,String> headers,RequestBody body){return client().newCall(new Request.Builder().url(url).headers(headers(headers)).post(body).build());}
    public static Call newCall(String url,RequestBody body,String tag){return client().newCall(new Request.Builder().url(url).tag(tag).post(body).build());}
    public static Call newCall(OkHttpClient client,String url,RequestBody body){return client.newCall(new Request.Builder().url(url).post(body).build());}
    public static void cancel(String tag){cancel(client(),tag);}public static void cancel(OkHttpClient client,String tag){if(client==null||tag==null)return;for(Call call:client.dispatcher().queuedCalls())if(tag.equals(call.request().tag()))call.cancel();for(Call call:client.dispatcher().runningCalls())if(tag.equals(call.request().tag()))call.cancel();}
    public static void cancelAll(){cancelAll(client());}public static void cancelAll(OkHttpClient client){if(client!=null)client.dispatcher().cancelAll();}
    public static FormBody toBody(androidx.collection.ArrayMap<String,String> params){FormBody.Builder builder=new FormBody.Builder();if(params!=null)for(Map.Entry<String,String> e:params.entrySet())builder.add(e.getKey(),e.getValue());return builder.build();}
}
