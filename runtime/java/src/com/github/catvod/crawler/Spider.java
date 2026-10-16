package com.github.catvod.crawler;
import android.content.Context;
import java.util.*;
import org.json.JSONObject;
import okhttp3.*;
/** Public CatVod ABI implemented independently for the desktop bridge. */
public class Spider {
    public static JSONObject empty = new JSONObject();
    public String siteKey;
    protected static Context mContext;
    public void init(Context context) { mContext=context; }
    public void init(Context context,String extend) { init(context); }
    public void initApi(SpiderApi api) {}
    public String homeContent(boolean filter) { return "{}"; }
    public String homeVideoContent() { return "{}"; }
    public String categoryContent(String tid,String pg,boolean filter,HashMap<String,String> extend) { return "{}"; }
    public String detailContent(List<String> ids) { return "{}"; }
    public String searchContent(String key,boolean quick) { return "{}"; }
    public String searchContent(String key,boolean quick,String pg) { return searchContent(key,quick); }
    public String playerContent(String flag,String id,List<String> vipFlags) { return "{}"; }
    public String liveContent(String url) { return "{}"; }
    public boolean isVideoFormat(String url) { return false; }
    public boolean manualVideoCheck() { return false; }
    public static Dns safeDns() { return com.github.catvod.net.OkHttp.dns(); }
    public static OkHttpClient client() { return com.github.catvod.net.OkHttp.client(); }
    public void cancelByTag() {}
    public void destroy() {}
    public Object[] proxyLocal(Map<String,String> params) { return null; }
    public Object[] proxy(Map<String,String> params) { return proxyLocal(params); }
    public String action(String action) { return ""; }
}
