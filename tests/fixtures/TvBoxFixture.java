package com.github.catvod.spider;
import com.github.catvod.crawler.Spider;
import android.content.Context;
import android.util.Base64;
import java.util.*;
public class TvBoxFixture extends Spider {
    private String extend;
    public void init(Context context,String extend){
        super.init(context,extend);this.extend=extend;
        android.content.SharedPreferences prefs=context.getSharedPreferences("fixture",0);
        if(!prefs.edit().putString("value",extend).putInt("count",7).commit()||!prefs.getString("value","").equals(extend)||prefs.getInt("count",0)!=7)throw new IllegalStateException("Preferences failed");
        String roundtrip=new String(Base64.decode(Base64.encodeToString("编码测试".getBytes(java.nio.charset.StandardCharsets.UTF_8),Base64.DEFAULT),Base64.DEFAULT),java.nio.charset.StandardCharsets.UTF_8);
        if(!roundtrip.equals("编码测试"))throw new IllegalStateException("Base64 failed");
        String webProxy=new com.github.catvod.crawler.SpiderApi().webParse("https://video.test/watch?name=中文", "4K");
        if(!webProxy.startsWith("proxy://go=SuperParse&flag=4K&url="))throw new IllegalStateException("webParse proxy failed");
        String webEncoded=webProxy.substring(webProxy.indexOf("&url=")+5);
        if(!new String(java.util.Base64.getUrlDecoder().decode(webEncoded),java.nio.charset.StandardCharsets.UTF_8).equals("https://video.test/watch?name=中文"))throw new IllegalStateException("webParse URL failed");
        if(!android.net.Uri.parse("https://example.test/?x=%E6%B5%8B%E8%AF%95").getQueryParameter("x").equals("测试"))throw new IllegalStateException("URI failed");
        if(com.github.catvod.net.OkHttp.client(false,5000).followRedirects())throw new IllegalStateException("HTTP redirect option failed");
        androidx.collection.ArrayMap<String,String> form=new androidx.collection.ArrayMap<>();form.put("x","测试");
        if(!com.github.catvod.net.OkHttp.toBody(form).value(0).equals("测试"))throw new IllegalStateException("HTTP form failed");
        try{if(com.github.catvod.net.OkHttp.dns().lookup("localhost").isEmpty())throw new IllegalStateException("DNS failed");}catch(java.net.UnknownHostException e){throw new IllegalStateException(e);}
    }
    public String homeContent(boolean filter){return "{\"class\":[{\"type_id\":\"1\",\"type_name\":\"DEX 分类\"}]}";}
    public String homeVideoContent(){return "{\"list\":[{\"vod_id\":\"1\",\"vod_name\":\"Android DEX "+android.os.Build.VERSION.SDK_INT+"\"}]}";}
    public String categoryContent(String tid,String page,boolean filter,HashMap<String,String> ext){return homeVideoContent();}
    public String detailContent(List<String> ids){return "{\"list\":[{\"vod_id\":\""+ids.get(0)+"\",\"vod_name\":\"DEX 电影\",\"vod_play_from\":\"测试\",\"vod_play_url\":\"第一集$test-id\"}]}";}
    public String searchContent(String key,boolean quick,String pg){return "{\"list\":[{\"vod_name\":\""+key+"\",\"vod_id\":\"1\"}],\"page\":\""+pg+"\"}";}
    public String playerContent(String flag,String id,List<String> flags){
        if(id.equals("web-id"))return "{\"parse\":1,\"url\":\""+new com.github.catvod.crawler.SpiderApi().webParse("https://video.test/watch?name=中文",flag)+"\"}";
        return "{\"parse\":0,\"url\":\"http://127.0.0.1:9978/proxy?do=fixture\",\"header\":{\"X-Extend\":\""+extend+"\"}}";
    }
    public Object[] proxyLocal(Map<String,String> args){return new Object[]{200,"text/plain",Base64.decode("REVYIHByb3h5IG9r",Base64.DEFAULT)};}
}
