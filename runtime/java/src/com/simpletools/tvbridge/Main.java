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
    // 手机扫码登录页服务端口（0.0.0.0，默认 9978，被占用时顺延）：JAR 的 ProxyOrigin.proxy
    // 即登录页/推送处理器，安卓 TVBox 宿主用同一端口对内网手机提供页面
    private static int qrPort;
    private static Shared qrShared;
    private static final LinkedHashMap<String,Entry> entries=new LinkedHashMap<>();
    // 同一个 JAR（按内容哈希）的多个源共用一份解包/转换产物与类加载器：
    // 手机端 TVBox 按 JAR 缓存 JarLoader，一次加载后所有源共享；
    // 此前按 identity（含 api/key/ext）重复转换与初始化，是桌面端 JAR 源首次加载慢的根因。
    private static final Map<String,Shared> shared=new HashMap<>();
    // 初始化线程池 + 坏源标记：部分源的 init 会死循环（如网盘系 Pan.init 递归），
    // 带超时执行并在超时后标记该源不可用，避免阻塞同一 JAR 的其他源和后续请求
    private static final ExecutorService INIT_POOL=Executors.newCachedThreadPool(r->{Thread t=new Thread(r,"tvbox-init");t.setDaemon(true);return t;});
    private static final Set<String> broken=Collections.synchronizedSet(new HashSet<>());
    private static final class Shared { URLClassLoader loader;Context context;boolean cloudCookieRestored; }
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
        }catch(ZipException notZip){return null;} // 裸 classes.dex 不是 ZIP，交给 executableJar 直接转换
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
        }catch(TimeoutException timeout){/* 超时不永久标记（用户登录云盘后应可重试）*/throw new IOException("源初始化超时（该源可能与桌面端不兼容）");}
        catch(ExecutionException failed){broken.add(identity);throw new IOException("源初始化失败："+String.valueOf(failed.getCause()));}
        // 源 init 之后再恢复云盘登录态：Cloud_quark.init(ext) 会用 ext 里的 cookie 调 N0.s0，
        // ext 为空时会清空我们注入的 F5（登录态），必须在它之后重新写入
        try{restoreCloudCookie(sh);}catch(Throwable ignored){}
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
                case "home":{
                    // 加固源（如豆豆）的 homeContent 在桌面端可能抛 JSONException（接口按端返回不同数据）：
                    // 异常时忽略 home 结果，直接用「推荐」分类兜底，保证界面有分类和内容
                    JSONObject home;
                    try{home=object(spider.homeContent(true));}
                    catch(Throwable e){System.err.println("TVBoxHome: homeContent failed: "+e);home=new JSONObject();}
                    // 加固源（如豆豆）在桌面端 homeContent 不返回分类：使用 Android 实测的标准分类兑底
                    if(home.optJSONArray("class")==null||home.getJSONArray("class").length()==0){
                        JSONArray cls=new JSONArray();
                        cls.put(object("{\"type_id\":\"hot_gaia\",\"type_name\":\"热播电影\"}"));
                        cls.put(object("{\"type_id\":\"tv_hot\",\"type_name\":\"热播剧集\"}"));
                        cls.put(object("{\"type_id\":\"show_hot\",\"type_name\":\"热播综艺\"}"));
                        cls.put(object("{\"type_id\":\"movie\",\"type_name\":\"电影筛选\"}"));
                        cls.put(object("{\"type_id\":\"tv\",\"type_name\":\"电视筛选\"}"));
                        cls.put(object("{\"type_id\":\"rank_list_movie\",\"type_name\":\"电影榜单\"}"));
                        cls.put(object("{\"type_id\":\"rank_list_tv\",\"type_name\":\"电视剧榜单\"}"));
                        home.put("class",cls);
                    }
                    if(home.optJSONArray("list")==null||home.getJSONArray("list").length()==0){
                        // 首页无内容：拉「热播电影」前 3 页合并去重（与 Android 首页一致）
                        try{
                            JSONArray list=new JSONArray();
                            java.util.Set<String> seen=new java.util.HashSet<>();
                            for(String pg:new String[]{"1","2","3"}){
                                try{
                                    JSONObject r=object(spider.categoryContent("hot_gaia",pg,true,new java.util.HashMap<String,String>()));
                                    JSONArray items=r.optJSONArray("list");
                                    if(items!=null)for(int i=0;i<items.length();i++){
                                        JSONObject item=items.optJSONObject(i);if(item==null)continue;
                                        String id=item.optString("vod_id");
                                        if(id!=null&&!id.isEmpty()&&seen.add(id))list.put(item);
                                        if(list.length()>=60)break;
                                    }
                                }catch(Throwable ignored){}
                                if(list.length()>=60)break;
                            }
                            if(list.length()>0)home.put("list",list);
                        }catch(Throwable ignored){}
                    }
                    return home;
                }
                case "category":result=spider.categoryContent(args.optString("t"),args.optString("page","1"),true,map(args.optJSONObject("filters")));break;
                case "detail":result=spider.detailContent(Collections.singletonList(String.valueOf(args.get("id"))));break;
                case "search":result=spider.searchContent(args.getString("keyword"),false,args.optString("page","1"));break;
                case "play":{
                    String flag=args.optString("flag");String id=String.valueOf(args.get("id"));
                    // 线路 → 网盘类别（Pan 的 flag 分发：夸父=quark、优汐=uc、喳喳=baidu、阿狸=ali）
                    String site=flag.contains("优汐")?"uc":flag.contains("夸父")?"quark":flag.contains("喳喳")?"baidu":flag.contains("阿狸")?"ali":"quark";
                    String siteCls="quark".equals(site)?"Cloud_quark":"uc".equals(site)?"Cloud_uc":"baidu".equals(site)?"Cloud_baidu":"Cloud_ali";
                    // 预置该网盘的 flag 缓存：playerContent 只在"本次 flag 与上次不同"时调 Gd()，
                    // 而 Gd() 会死等 JAR 自己的扫码轮询（永远等不到）→ 预置同值可直接进入真实播放实现
                    try{
                        Class<?> siteClass=spider.getClass().getClassLoader().loadClass("com.github.catvod.spider."+siteCls);
                        java.lang.reflect.Field cache=siteClass.getDeclaredField("N");
                        cache.setAccessible(true);cache.set(null,flag);
                    }catch(Throwable ignored){}
                    // 按线路注入对应网盘登录态（无 cookie 时只置 tF 跳过死等，JAR 快速返回未登录提示）
                    try{Shared entryShared=shared(data);restoreSiteCookie(entryShared,site);}catch(Throwable ignored){}
                    System.err.println("[play] site="+site+" flag="+flag+" id="+id.substring(0,Math.min(240,id.length())));
                    long started=System.currentTimeMillis();
                    result=spider.playerContent(flag,id,list(args.optJSONArray("flags")));
                    String text=String.valueOf(result);
                    System.err.println("[play] elapsed="+(System.currentTimeMillis()-started)+"ms result="+text.substring(0,Math.min(240,text.length())));
                    break;
                }
                default:throw new IOException("Unsupported action");
            }
            return object(result);
        }
    }
    private static Map<String,String> query(String raw)throws Exception {
        Map<String,String> out=new HashMap<>();if(raw!=null)for(String pair:raw.split("&")){String[] parts=pair.split("=",2);out.put(URLDecoder.decode(parts[0],"UTF-8"),parts.length>1?URLDecoder.decode(parts[1],"UTF-8"):"");}return out;
    }
    /** JAR 自己的云盘推送逻辑（ProxyOrigin.proxy 的 do=xxx&type=input）：
     * 登录 cookie 会写入 JAR 内存登录态（网盘类如 Cloud_quark 内部存到 N0.F5），播放立即生效。 */
    private static Object[] pushCloudCookie(Shared item,String site,String cookie)throws Exception{
        Map<String,String> params=new HashMap<>();
        params.put("do",site);params.put("type","input");
        // 与 JAR 登录页脚本一致：推送值做一次 URL 编码（JAR 内部会再解码）
        params.put("推送",URLEncoder.encode(cookie,"UTF-8"));
        return (Object[])item.loader.loadClass("com.github.catvod.spider.ProxyOrigin").getMethod("proxy",Map.class).invoke(null,params);
    }
    /** 把登录态写入 JAR：
     * 1) 走 JAR 自己的推送逻辑（Cloud_quark.proxys → N0.s0）；
     * 2) F5 覆盖为完整 cookie：JAR 的 s0 只保留 __pus，会丢掉夸克网盘会话 __puus；
     * 3) 置 Cloud_quark.tF=true：播放时跳过 N0.Gd()——它会死等 JAR 自己的扫码轮询，导致 30 秒超时。
     */
    private static void applyCloudLogin(Shared item,String cookie)throws Exception{
        applySiteLogin(item,"quark",cookie);
    }
    private static String cookieValue(String cookie,String name){
        for(String pair:cookie.split("; "))if(pair.startsWith(name+"="))return pair.substring(name.length()+1);
        return "";
    }
    /** 把指定网盘的登录态写入 JAR（cookie 为空时只置 tF 跳过登录死等，未登录时 JAR 会快速返回提示而非 30 秒超时）
     * 优汐=Cloud_uc、夸父=Cloud_quark、喳喳=Cloud_baidu、阿狸=Cloud_ali，登录态共用 N0.F5 字段 */
    private static void applySiteLogin(Shared item,String site,String cookie)throws Exception{
        boolean hasCookie=cookie!=null&&!cookie.isEmpty();
        if(hasCookie){
            try{pushCloudCookie(item,"uc".equals(site)?"UC":site,cookie);}catch(Throwable ignored){}
            try{
                Class<?> n0=item.loader.loadClass("com.github.catvod.spider.merge.N0");
                Object instance=n0.getMethod("Zm").invoke(null);
                n0.getField("F5").set(instance,cookie);
                String bUser=cookieValue(cookie,"b-user-id");
                if(!bUser.isEmpty())n0.getField("W").set(instance,bUser);
                System.err.println("[site-login] "+site+" F5="+cookie.length()+" W="+bUser);
            }catch(Throwable failed){System.err.println("[site-login] state inject failed: "+failed);}
        }
        String cls="quark".equals(site)?"Cloud_quark":"uc".equals(site)?"Cloud_uc":"baidu".equals(site)?"Cloud_baidu":"Cloud_ali";
        try{item.loader.loadClass("com.github.catvod.spider."+cls).getField("tF").setBoolean(null,true);}catch(Throwable ignored){}
    }
    /** 从 cloud-cookies.txt 读指定网盘域名的 cookie 并写入 JAR */
    private static void restoreSiteCookie(Shared item,String site){
        try{
            File file=new File("cloud-cookies.txt");
            if(!file.isFile())return;
            String[] domains="uc".equals(site)?new String[]{"uc.cn"}
                    :"baidu".equals(site)?new String[]{"baidu.com"}
                    :"ali".equals(site)?new String[]{"alipan.com","aliyundrive.com"}
                    :new String[]{"quark.cn"};
            StringBuilder cookie=new StringBuilder();
            for(String line:Files.readAllLines(file.toPath(),StandardCharsets.UTF_8)){
                line=line.trim();
                if(line.isEmpty()||line.startsWith("#"))continue;
                int tab=line.indexOf('\t');
                if(tab<=0)continue;
                String domain=line.substring(0,tab).trim().toLowerCase();
                boolean hit=false;
                for(String d:domains)if(domain.equals(d)||domain.endsWith("."+d))hit=true;
                if(!hit)continue;
                if(cookie.length()>0)cookie.append("; ");
                cookie.append(line.substring(tab+1).trim());
            }
            applySiteLogin(item,site,cookie.toString());
        }catch(Throwable ignored){}
    }
    /** JVM 启动后恢复各网盘登录态（每个网盘一个 F5 写入；播放时会按线路重新注入） */
    private static void restoreCloudCookie(Shared item)throws Exception{
        for(String site:new String[]{"quark","uc","baidu","ali"})try{restoreSiteCookie(item,site);}catch(Throwable ignored){}
    }
    /** 找第一个能加载 ProxyOrigin 的 JAR（网盘系登录页都走它），结果缓存。 */
    private static Shared proxyOriginShared(){
        if(qrShared!=null)return qrShared;
        for(Shared item:shared.values()){
            try{item.loader.loadClass("com.github.catvod.spider.ProxyOrigin");qrShared=item;return item;}catch(Throwable ignored){}
        }
        return null;
    }
    private static String proxyInternalIP(){
        if(qrShared==null)return "";
        try{return String.valueOf(qrShared.loader.loadClass("com.github.catvod.spider.ProxyOrigin").getMethod("getInternalIP").invoke(null));}catch(Throwable ignored){return "";}
    }
    /** 手机扫码登录页服务：只处理 /proxy?do=...（do=input 登录页、do=quark/baidu/ali/bili/UC/123&type=input
     * Cookie 推送），其余路径一律 404。手机没有桌面 token，此处不做 token 校验（与安卓 TVBox 行为一致）。 */
    private static void serveQr(HttpExchange exchange)throws IOException {
        try {
            Map<String,String> params=query(exchange.getRequestURI().getRawQuery());
            if(!exchange.getRequestURI().getPath().equals("/proxy")||!params.containsKey("do")){send(exchange,404,"text/plain",new byte[0]);return;}
            params.remove("token");
            Object[] result=null;
            synchronized(Main.class){
                Shared item=proxyOriginShared();
                if(item!=null)try{
                    result=(Object[])item.loader.loadClass("com.github.catvod.spider.ProxyOrigin").getMethod("proxy",Map.class).invoke(null,params);
                }catch(java.lang.reflect.InvocationTargetException wrapped){
                    Throwable cause=wrapped.getCause()==null?wrapped:wrapped.getCause();
                    cause.printStackTrace(System.err);
                }catch(Throwable failed){failed.printStackTrace(System.err);}
            }
            if(result==null){send(exchange,404,"text/plain",new byte[0]);return;}
            int code=((Number)result[0]).intValue();String mime=String.valueOf(result[1]);
            InputStream stream=result[2] instanceof InputStream ?(InputStream)result[2]:new ByteArrayInputStream(result[2] instanceof byte[] ?(byte[])result[2]:String.valueOf(result[2]).getBytes(StandardCharsets.UTF_8));
            if(result.length>3&&result[3] instanceof Map)for(Object raw:((Map<?,?>)result[3]).entrySet()){Map.Entry<?,?> h=(Map.Entry<?,?>)raw;String key=h.getKey().toString();if(!Arrays.asList("content-length","transfer-encoding","connection").contains(key.toLowerCase(Locale.ROOT)))exchange.getResponseHeaders().set(key,h.getValue().toString());}
            String host=exchange.getRequestHeaders().getFirst("Host");if(host==null||host.isEmpty())host="127.0.0.1:"+qrPort;
            try(InputStream input=stream){
                if(mime.contains("text/html")){
                    // JAR 登录页的推送地址在本机是 http://:9978/...（桌面 WifiManager 取不到局域网 IP），
                    // 手机实际通过局域网 IP 访问本服务：统一改写为请求的 Host，保证页面内推送请求可达
                    String html=new String(readLimited(input,4*1024*1024),StandardCharsets.UTF_8).replace("http://:9978","http://"+host);
                    String internal=proxyInternalIP();
                    for(String from:new String[]{internal,"127.0.0.1","localhost"})if(from!=null&&!from.isEmpty())html=html.replace("http://"+from+":9978","http://"+host);
                    send(exchange,code,mime.isEmpty()?"text/html; charset=utf-8":mime,html.getBytes(StandardCharsets.UTF_8));
                }else send(exchange,code,mime,readLimited(input,8*1024*1024));
            }return;
        }catch(Throwable e){e.printStackTrace(System.err);send(exchange,500,"text/plain",String.valueOf(e).getBytes(StandardCharsets.UTF_8));}
        finally{exchange.close();}
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
            if(path.equals("/cloud-cookie")&&exchange.getRequestMethod().equals("POST")){
                // 扫码登录成功：把 cookie 交给 JAR 自己的推送逻辑，写入其内存登录态，播放立即生效
                JSONObject data=new JSONObject(new String(readLimited(exchange.getRequestBody(),2*1024*1024),StandardCharsets.UTF_8));
                String site=data.optString("site","quark"),cookie=data.optString("cookie","");
                if(cookie.isEmpty())throw new IOException("cookie 为空");
                synchronized(Main.class){
                    Shared item=proxyOriginShared();
                    if(item==null)throw new IOException("JAR 尚未加载，无法写入登录态");
                    applyCloudLogin(item,cookie);
                }
                send(exchange,200,"application/json; charset=utf-8","{\"ok\":true}".getBytes(StandardCharsets.UTF_8));return;
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
        server.createContext("/",Main::serve);server.setExecutor(Executors.newFixedThreadPool(20));server.start();
        // 手机扫码登录页：监听全部网卡（手机需与电脑同一局域网）。9978 是 JAR 登录页约定的端口，
        // 被占用时顺延；实际端口落盘供 Rust 生成二维码时读取
        for(int candidate=9978;candidate<=9999&&qrPort==0;candidate++){
            try{
                HttpServer qr=HttpServer.create(new InetSocketAddress("0.0.0.0",candidate),16);
                qr.createContext("/",Main::serveQr);qr.setExecutor(Executors.newFixedThreadPool(8));qr.start();qrPort=candidate;
            }catch(IOException occupied){}
        }
        try{Files.write(Paths.get("qr-port.txt"),String.valueOf(qrPort).getBytes(StandardCharsets.UTF_8));}catch(Throwable ignored){}
        System.out.println(new JSONObject().put("port",port).put("qrPort",qrPort));System.out.flush();
        // Keep protocol output separate from arbitrary plugin logging.
        System.setOut(System.err);
    }
}
