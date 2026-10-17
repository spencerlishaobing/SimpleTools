package com.simpletools.tvbridge;
import android.content.Context;
import com.github.catvod.crawler.*;
import com.sun.net.httpserver.*;
import org.json.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.zip.*;

/** Private JVM worker. The packaged runtime is used for both loading and DEX conversion. */
public final class Main {
    private static String token;
    private static int port;
    private static final LinkedHashMap<String,Entry> entries=new LinkedHashMap<>();
    // 同一个 JAR（按内容哈希）的多个源共用一份解包/转换产物与类加载器：
    // 手机端 TVBox 按 JAR 缓存 JarLoader，一次加载后所有源共享；
    // 此前按 identity（含 api/key/ext）重复转换与初始化，是桌面端 JAR 源首次加载慢的根因。
    private static final Map<String,Shared> shared=new HashMap<>();
    // 初始化线程池 + 坏源标记：部分源的 init 会死循环（如网盘系 Pan.init 递归），
    // 带超时执行并在超时后标记该源不可用，避免阻塞同一 JAR 的其他源和后续请求
    private static final ExecutorService INIT_POOL=Executors.newCachedThreadPool(r->{Thread t=new Thread(r,"tvbox-init");t.setDaemon(true);return t;});
    private static final Set<String> broken=Collections.synchronizedSet(new HashSet<>());
    private static final class Shared { URLClassLoader loader;Context context; }
    private static final class Entry implements Closeable {
        Spider spider;Shared shared;
        public void close(){try{spider.destroy();}catch(Exception ignored){}}
    }
    private static JSONObject object(String text){try{return text==null||text.trim().isEmpty()?new JSONObject():new JSONObject(text);}catch(org.json.JSONException e){return new JSONObject();}}
    private static HashMap<String,String> map(JSONObject obj){HashMap<String,String> out=new HashMap<>();if(obj!=null){java.util.Iterator<?> it=obj.keys();while(it.hasNext()){String key=String.valueOf(it.next());out.put(key,obj.optString(key));}}return out;}
    private static List<String> list(JSONArray a){List<String> out=new ArrayList<>();if(a!=null)for(int i=0;i<a.length();i++){try{out.add(a.getString(i));}catch(org.json.JSONException ignored){}}return out;}
    /** 修复 dex2jar 2.4 的已知产物缺陷：部分字段的 ConstantValue 属性与字段描述符类型不匹配
     * （实测：HashMap 字段携带 String 常量），JVM 定义类时直接抛 ClassFormatError
     * （Bad string initial value），导致整个 JAR 无法加载。这里将非法属性就地改名
     * （改成字段名），未知属性会被 JVM 忽略，字节长度不变，属于最小安全补丁。 */
    private static int u2(byte[] b,int o){return ((b[o]&0xff)<<8)|(b[o+1]&0xff);}
    private static long u4(byte[] b,int o){return ((long)(b[o]&0xff)<<24)|((long)(b[o+1]&0xff)<<16)|((long)(b[o+2]&0xff)<<8)|(long)(b[o+3]&0xff);}
    private static int constantValueTag(String desc){
        if(desc==null)return -1;
        switch(desc){
            case "B":case "C":case "I":case "S":case "Z":return 3;
            case "F":return 4;
            case "J":return 5;
            case "D":return 6;
            case "Ljava/lang/String;":return 8;
            default:return -1;
        }
    }
    private static byte[] repairClass(byte[] data){
        if(data.length<10||(data[0]&0xff)!=0xCA||(data[1]&0xff)!=0xFE)return data;
        try{
            int cpCount=u2(data,8);int[] tags=new int[cpCount];String[] utf8=new String[cpCount];
            int p=10;
            for(int i=1;i<cpCount;i++){int tag=data[p]&0xff;tags[i]=tag;
                switch(tag){
                    case 1:{int len=u2(data,p+1);utf8[i]=new String(data,p+3,len,StandardCharsets.UTF_8);p+=3+len;break;}
                    case 3:case 4:case 9:case 10:case 11:case 12:case 17:case 18:p+=5;break;
                    case 7:case 8:case 16:case 19:case 20:p+=3;break;
                    case 15:p+=4;break;
                    case 5:case 6:p+=9;i++;break;
                    default:return data;
                }
            }
            p+=6;int interfaces=u2(data,p);p+=2+2*interfaces;
            int fields=u2(data,p);p+=2;
            for(int f=0;f<fields;f++){
                int nameIndex=u2(data,p+2),descIndex=u2(data,p+4),valueTag=constantValueTag(utf8[descIndex]);
                p+=6;int attributes=u2(data,p);p+=2;
                for(int a=0;a<attributes;a++){
                    int attrName=u2(data,p);long length=u4(data,p+2);int content=p+6;
                    if(length>=2&&"ConstantValue".equals(utf8[attrName])&&nameIndex!=attrName){
                        int value=u2(data,content);int tag=value>0&&value<cpCount?tags[value]:0;
                        if(tag!=valueTag){data[p]=(byte)(nameIndex>>8);data[p+1]=(byte)nameIndex;}
                    }
                    p+=6+(int)length;
                }
            }
            return data;
        }catch(RuntimeException e){return data;}
    }
    /** ftyguard（神の蝶）加壳：assets/*.guard 是整文件字节值映射后的 JAR。
     * 映射规则 b∈{1,2,5,6} ? b^7 : b 在字节值域上自反（与 ftyguard_v8.so getLoader 的
     * 仿真产物逐字节比对验证，CRC 全部通过），桌面端无需 ARM 加固运行库即可离线还原真实 DEX。 */
    private static byte[] unguard(byte[] data){
        byte[] out=new byte[data.length];
        for(int i=0;i<data.length;i++){int b=data[i]&0xff;out[i]=(byte)(b==1||b==2||b==5||b==6?b^7:b);}
        return out;
    }
    private static byte[] readAll(InputStream input)throws IOException{ByteArrayOutputStream out=new ByteArrayOutputStream();byte[] buffer=new byte[65536];int n;while((n=input.read(buffer))!=-1)out.write(buffer,0,n);return out.toByteArray();}
    private static boolean looksContainer(byte[] data){
        try(ZipInputStream zip=new ZipInputStream(new ByteArrayInputStream(data))){ZipEntry item;while((item=zip.getNextEntry())!=null)if(item.getName().matches("classes[0-9]*\\.dex"))return true;return false;}
        catch(IOException e){return false;}
    }
    /** 检测 ftyguard 加壳的 JAR（assets/*.guard）：还原成功返回解壳后的 JAR 文件，普通 JAR 返回 null。 */
    private static File unguarded(File original,File folder)throws Exception {
        try(ZipFile zip=new ZipFile(original)){
            Enumeration<? extends ZipEntry> items=zip.entries();
            while(items.hasMoreElements()){
                ZipEntry item=items.nextElement();if(!item.getName().endsWith(".guard"))continue;
                byte[] raw;try(InputStream input=zip.getInputStream(item)){raw=readAll(input);}catch(IOException e){continue;}
                byte[] data=unguard(raw);if(data.length<4||data[0]!='P'||data[1]!='K'||!looksContainer(data))continue;
                File target=new File(folder,"unguarded.jar");Files.write(target.toPath(),data);return target;
            }
        }
        return null;
    }
    private static File executableJar(File original,File folder)throws Exception {
        File restored=unguarded(original,folder);File material=restored!=null?restored:original;
        boolean dex=false,classes=false;
        try(InputStream stream=new FileInputStream(material)){byte[] magic=new byte[4];if(stream.read(magic)==4)dex=Arrays.equals(magic,new byte[]{'d','e','x','\n'});}
        if(!dex)try(ZipFile zip=new ZipFile(material)){Enumeration<? extends ZipEntry> items=zip.entries();while(items.hasMoreElements()){String name=items.nextElement().getName();dex|=name.matches("classes[0-9]*\\.dex");classes|=name.endsWith(".class");}}
        if(!dex){if(!classes)throw new IOException("JAR does not contain Java classes or Android DEX");return material;}
        File converted=new File(folder,restored!=null?"converted-v2.4g.jar":"converted-v2.4r.jar");if(converted.isFile())return converted;
        File temporary=new File(folder,"converting.jar"),log=new File(folder,"conversion.log");
        Process process=new ProcessBuilder(new File(System.getProperty("java.home"),"bin/java.exe").getPath(),"-Xmx384m","-cp",System.getProperty("tvbox.dex"),"com.googlecode.dex2jar.tools.Dex2jarCmd","-f","-o",temporary.getPath(),material.getPath()).redirectErrorStream(true).redirectOutput(log).start();
        try {
            if(!process.waitFor(35,TimeUnit.SECONDS)){process.destroyForcibly();throw new IOException("DEX conversion timed out");}
            if(process.exitValue()!=0||!temporary.isFile()){
                byte[] bytes=Files.readAllBytes(log.toPath());throw new IOException("DEX conversion failed: "+new String(bytes,0,Math.min(bytes.length,3000),StandardCharsets.UTF_8));
            }
            try(ZipFile check=new ZipFile(temporary)){if(!check.stream().anyMatch(e->e.getName().endsWith(".class")))throw new IOException("DEX conversion produced no Java classes");}
            File repaired=new File(folder,"converting-fixed.jar");
            try(ZipFile source=new ZipFile(temporary);ZipOutputStream out=new ZipOutputStream(new FileOutputStream(repaired))){
                Enumeration<? extends ZipEntry> items=source.entries();byte[] buffer=new byte[65536];
                while(items.hasMoreElements()){
                    ZipEntry item=items.nextElement();out.putNextEntry(new ZipEntry(item.getName()));
                    try(InputStream input=source.getInputStream(item)){
                        if(item.getName().endsWith(".class")){ByteArrayOutputStream raw=new ByteArrayOutputStream();int n;while((n=input.read(buffer))!=-1)raw.write(buffer,0,n);out.write(repairClass(raw.toByteArray()));}
                        else{int n;while((n=input.read(buffer))!=-1)out.write(buffer,0,n);}
                    }
                    out.closeEntry();
                }
            }
            Files.move(repaired.toPath(),converted.toPath(),StandardCopyOption.REPLACE_EXISTING);return converted;
        }finally{if(process.isAlive())process.destroyForcibly();}
    }
    private static Shared shared(JSONObject data)throws Exception {
        String jarHash=data.optString("jarHash","");if(!jarHash.matches("[a-f0-9]{32}"))throw new IOException("Invalid source jar hash");
        Shared cached=shared.get(jarHash);if(cached!=null)return cached;
        File folder=new File("shared",jarHash).getAbsoluteFile();folder.mkdirs();File original=new File(folder,"source.jar");
        if(!original.isFile()){
            String encoded=data.optString("jarData","");if(encoded.isEmpty())throw new IOException("Source JAR data missing");
            byte[] bytes=Base64.getDecoder().decode(encoded);if(bytes.length>64*1024*1024)throw new IOException("JAR exceeds 64 MB");
            Path temporary=new File(folder,"source.tmp").toPath();Files.write(temporary,bytes);Files.move(temporary,original.toPath(),StandardCopyOption.REPLACE_EXISTING);
        }
        File executable=executableJar(original,folder);
        URLClassLoader loader=new URLClassLoader(new URL[]{executable.toURI().toURL(),original.toURI().toURL()},Main.class.getClassLoader());
        try {
            // spider 的 Init.init 会把传入对象强转为 android.app.Application（桌面兼容层实现），
            // 因此这里传入 Application 实例而不是裸 Context。
            Context context=new android.app.Application(new File(folder,"context"));
            // 部分 spider 通过 ActivityThread.currentActivityThread().getApplication() 取上下文
            try{android.app.ActivityThread.setApplication((android.app.Application)context);}catch(Throwable ignored){}
            final Context initContext=context;
            // Init / InitOrigin 带超时执行：部分源（如网盘系 Pan）的初始化可能陷入死循环，
            // 不能让它阻塞同一 JAR 的其他源和后续请求
            try{
                Future<?> initTask=INIT_POOL.submit(()->{
                    try{loader.loadClass("com.github.catvod.spider.Init").getMethod("init",Context.class).invoke(null,initContext);}catch(Throwable ignored){}
                    try{loader.loadClass("com.github.catvod.spider.InitOrigin").getMethod("init",Context.class).invoke(null,initContext);}catch(Throwable ignored){}
                });
                initTask.get(25,TimeUnit.SECONDS);
            }catch(TimeoutException timeout){android.util.Log.w("Main","shared init timeout: "+jarHash);}
            catch(Exception ignored){}
            // 部分混淆版本的 InitOrigin.init 会因桌面缺失依赖中途失败，这里兜底：
            // 直接把 Application 反射写入 InitOrigin 单例的上下文字段，保证 InitOrigin.context() 非空。
            try{Class<?> origin=loader.loadClass("com.github.catvod.spider.InitOrigin");Object instance=origin.getMethod("get").invoke(null);
                for(java.lang.reflect.Field field:origin.getDeclaredFields())if(field.getType()==android.app.Application.class&&!java.lang.reflect.Modifier.isStatic(field.getModifiers())){field.setAccessible(true);field.set(instance,context);}
            }catch(Throwable ignored){}
            Shared created=new Shared();created.loader=loader;created.context=context;shared.put(jarHash,created);return created;
        }catch(Throwable e){loader.close();throw e;}
    }
    private static Entry load(JSONObject data)throws Exception {
        String identity=data.getString("identity");if(!identity.matches("[a-f0-9]{32}"))throw new IOException("Invalid source identity");
        Entry cached=entries.get(identity);if(cached!=null)return cached;
        if(broken.contains(identity))throw new IOException("该源初始化失败（与桌面端不兼容），已跳过");
        Shared sh=shared(data);
        String cls=data.getString("api");if(cls.startsWith("csp_"))cls="com.github.catvod.spider."+cls.substring(4);
        // ftyguard 存根代理类（如 csp_DouDouGuard）仅供安卓宿主使用：它的构造器会调用
        // Init.getSpider 交给 native 解密后再实例化真实类。桌面端解壳后的 jar 里就是真实类
        // （命名约定：去掉 Guard 后缀，如 csp_DouDou），优先直接加载真实类，存根作为回退。
        Class<?> type;
        try{
            type=sh.loader.loadClass(cls);
        }catch(ClassNotFoundException missing){
            if(!cls.endsWith("Guard"))throw missing;
            type=sh.loader.loadClass(cls.substring(0,cls.length()-5));
        }
        Entry entry=new Entry();entry.shared=sh;
        entry.spider=(Spider)type.getDeclaredConstructor().newInstance();
        entry.spider.siteKey=data.getString("key");entry.spider.initApi(new SpiderApi());
        // spider.init 带超时：网盘系源的 init 可能死循环（如 Pan.init 递归），超时/异常则标记不可用，避免卡死
        final Spider spider=entry.spider;final Context initContext=sh.context;final String ext=data.optString("ext","");
        try{
            Future<?> initTask=INIT_POOL.submit(()->spider.init(initContext,ext));
            initTask.get(15,TimeUnit.SECONDS);
        }catch(TimeoutException timeout){broken.add(identity);throw new IOException("源初始化超时（该源可能与桌面端不兼容）");}
        catch(ExecutionException failed){broken.add(identity);throw new IOException("源初始化失败："+String.valueOf(failed.getCause()));}
        if(entries.size()>=64){String first=entries.keySet().iterator().next();try{entries.remove(first).close();}catch(Exception ignored){}}
        entries.put(identity,entry);return entry;
    }
    // 按源分段锁：同一源的调用串行（spider 可能有静态状态），不同源之间并行——
    // 之前 call 是全局 synchronized，一个网盘源的 init/请求卡死会把所有源的请求堵住
    private static final Map<String,Object> callLocks=new java.util.concurrent.ConcurrentHashMap<>();
    private static JSONObject call(JSONObject data)throws Exception {
        synchronized(callLocks.computeIfAbsent(String.valueOf(data.optString("identity","")),key->new Object())){
            Spider spider=load(data).spider;JSONObject args=data.optJSONObject("args");if(args==null)args=new JSONObject();String result;
            switch(data.getString("action")){
                case "home":JSONObject home=object(spider.homeContent(true));if(home.optJSONArray("list")==null||home.getJSONArray("list").length()==0)home.put("list",object(spider.homeVideoContent()).optJSONArray("list"));return home;
                case "category":result=spider.categoryContent(args.optString("t"),args.optString("page","1"),true,map(args.optJSONObject("filters")));break;
                case "detail":result=spider.detailContent(Collections.singletonList(String.valueOf(args.get("id"))));break;
                case "search":result=spider.searchContent(args.getString("keyword"),false,args.optString("page","1"));break;
                case "play":result=spider.playerContent(args.optString("flag"),String.valueOf(args.get("id")),list(args.optJSONArray("flags")));break;
                default:throw new IOException("Unsupported action");
            }
            return object(result);
        }
    }
    private static Map<String,String> query(String raw)throws Exception {
        Map<String,String> out=new HashMap<>();if(raw!=null)for(String pair:raw.split("&")){String[] parts=pair.split("=",2);out.put(URLDecoder.decode(parts[0],"UTF-8"),parts.length>1?URLDecoder.decode(parts[1],"UTF-8"):"");}return out;
    }
    private static String proxyUrl(String value,String identity){
        String prefix="http://127.0.0.1:"+port+"/proxy?token="+token+"&site="+identity+"&";
        for(String host:new String[]{"127.0.0.1","localhost","0.0.0.0"})value=value.replace("http://"+host+":9978/proxy?",prefix);
        return value;
    }
    private static void send(HttpExchange exchange,int code,String type,byte[] body)throws IOException {
        exchange.getResponseHeaders().set("Content-Type",type);exchange.sendResponseHeaders(code,body.length);try(OutputStream output=exchange.getResponseBody()){output.write(body);}
    }
    private static void serve(HttpExchange exchange)throws IOException {
        try {
            Map<String,String> params=query(exchange.getRequestURI().getRawQuery());
            if(!token.equals(exchange.getRequestHeaders().getFirst("X-TVBOX-Token"))&&!token.equals(params.get("token"))){send(exchange,403,"text/plain",new byte[0]);return;}
            String path=exchange.getRequestURI().getPath();
            if(path.equals("/health")){send(exchange,200,"application/json","{}".getBytes(StandardCharsets.UTF_8));return;}
            if(path.equals("/proxy")){
                String identity=params.remove("site");params.remove("token");Entry entry;Object[] result;
                synchronized(Main.class){entry=entries.get(identity);if(entry==null)throw new IOException("Source expired; play the episode again");
                    String range=exchange.getRequestHeaders().getFirst("Range");if(range!=null)params.put("range",range);
                    result=entry.spider.proxy(params);
                    if(result==null)try{result=(Object[])entry.shared.loader.loadClass("com.github.catvod.spider.Proxy").getMethod("proxy",Map.class).invoke(null,params);}catch(ClassNotFoundException|NoSuchMethodException ignored){}
                }
                if(result==null)throw new IOException("Source has no local proxy handler");
                int code=((Number)result[0]).intValue();String mime=String.valueOf(result[1]);
                InputStream stream=result[2] instanceof InputStream?(InputStream)result[2]:new ByteArrayInputStream(result[2] instanceof byte[]?(byte[])result[2]:String.valueOf(result[2]).getBytes(StandardCharsets.UTF_8));
                if(result.length>3&&result[3] instanceof Map)for(Object raw:((Map<?,?>)result[3]).entrySet()){Map.Entry<?,?> h=(Map.Entry<?,?>)raw;String key=h.getKey().toString();if(!Arrays.asList("content-length","transfer-encoding","connection").contains(key.toLowerCase(Locale.ROOT)))exchange.getResponseHeaders().set(key,h.getValue().toString());}
                try(InputStream input=stream){
                    if(mime.contains("mpegurl")||mime.contains("m3u8")){byte[] body=readLimited(input,8*1024*1024);send(exchange,code,mime,proxyUrl(new String(body,StandardCharsets.UTF_8),identity).getBytes(StandardCharsets.UTF_8));}
                    else {exchange.getResponseHeaders().set("Content-Type",mime);exchange.sendResponseHeaders(code,0);try(OutputStream out=exchange.getResponseBody()){byte[] buffer=new byte[65536];int n;while((n=input.read(buffer))!=-1)out.write(buffer,0,n);}}
                }return;
            }
            if(!path.equals("/call")||!exchange.getRequestMethod().equals("POST")){send(exchange,404,"text/plain",new byte[0]);return;}
            JSONObject data=new JSONObject(new String(readLimited(exchange.getRequestBody(),90*1024*1024),StandardCharsets.UTF_8));
            send(exchange,200,"application/json; charset=utf-8",call(data).toString().getBytes(StandardCharsets.UTF_8));
        }catch(Throwable e){while(e.getCause()!=null)e=e.getCause();e.printStackTrace(System.err);String message=e.toString();if(e instanceof LinkageError)message="JAR compatibility API missing: "+message;String body;try{body=new JSONObject().put("error",message).toString();}catch(org.json.JSONException je){body="{\"error\":\""+message.replace("\\"," ").replace("\"","")+"\"}";}send(exchange,500,"application/json; charset=utf-8",body.getBytes(StandardCharsets.UTF_8));}
        finally{exchange.close();}
    }
    private static byte[] readLimited(InputStream input,int max)throws IOException{ByteArrayOutputStream out=new ByteArrayOutputStream();byte[] buffer=new byte[65536];int n;while((n=input.read(buffer))!=-1){if(out.size()+n>max)throw new IOException("Request exceeds size limit");out.write(buffer,0,n);}return out.toByteArray();}
    public static void main(String[] args)throws Exception {
        // 注册 PKCS7Padding 兼容 Provider（Android/Conscrypt 的转换名 → 标准 JCE 的 PKCS5Padding 委托）
        try{java.security.Security.addProvider(new Pkcs7Provider());}catch(Throwable ignored){}
        token=args[0];HttpServer server=HttpServer.create(new InetSocketAddress("127.0.0.1",0),16);port=server.getAddress().getPort();
        server.createContext("/",Main::serve);server.setExecutor(Executors.newFixedThreadPool(16));server.start();
        System.out.println(new JSONObject().put("port",port));System.out.flush();
        // Keep protocol output separate from arbitrary plugin logging.
        System.setOut(System.err);
    }
}
