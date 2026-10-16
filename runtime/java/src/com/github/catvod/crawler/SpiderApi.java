package com.github.catvod.crawler;
public class SpiderApi {
    public String getAddress(boolean local) { return "http://127.0.0.1:9978"; }
    public String getPort() { return "9978"; }
    public void log(String message) { android.util.Log.i("TVBoxSpider",message); }
    public int getScreenOrientation() { return 0; }
    public String webParse(String url,String flag) {
        if (url == null || url.isEmpty()) return "";
        String encoded = java.util.Base64.getUrlEncoder()
            .encodeToString(url.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        return "proxy://go=SuperParse&flag=" + (flag == null ? "" : flag) + "&url=" + encoded;
    }
}
