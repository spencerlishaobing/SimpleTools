/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.Spider
 *  okhttp3.OkHttpClient
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.merge.Am;
import com.github.catvod.spider.merge.L1;
import com.github.catvod.spider.merge.hN;
import java.net.URLEncoder;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONObject;

public class FirstAid
extends Spider {
    private String yq = "https://m.youlai.cn";

    private String yq(String string) {
        string = new Request.Builder().url(string).get().addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36").build();
        string = new OkHttpClient().newBuilder().sslSocketFactory((SSLSocketFactory)new L1(), L1.SN).build().newCall((Request)string).execute();
        String string2 = string.body().string();
        string.close();
        return string2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String categoryContent(String object, String string, boolean bl, HashMap<String, String> object2) {
        Cloneable cloneable;
        try {
            cloneable = new HashMap();
            if (object2 != null && ((HashMap)object2).size() > 0) {
                ((HashMap)cloneable).putAll(object2);
            }
            object2 = ((String)object).split("\\|");
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
        object = object2[0];
        {
            int n = Integer.parseInt((String)object2[1]);
            if (((HashMap)cloneable).get("cateId") != null) {
                object = (String)((HashMap)cloneable).get("cateId");
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(this.yq);
            ((StringBuilder)object2).append(String.format("/%s", object));
            object2 = this.yq(((StringBuilder)object2).toString());
            object = Am.yq((String)object2).cS(".block100").N(n).yq("src");
            cloneable = Am.yq((String)object2).cS(".jj-title-li").N(n).i(".list-br3");
            object2 = new JSONArray();
            Iterator iterator = ((AbstractCollection)((Object)cloneable)).iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    object = new JSONObject();
                    return object.put("page", Integer.parseInt(string)).put("pagecount", 1).put("limit", ((AbstractCollection)((Object)cloneable)).size()).put("total", ((AbstractCollection)((Object)cloneable)).size()).put("list", object2).toString();
                }
                Object object3 = (hN)iterator.next();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.yq);
                stringBuilder.append(((hN)object3).cS("a").yq("href"));
                String string2 = stringBuilder.toString();
                object3 = ((hN)object3).cS("a").t0();
                JSONObject jSONObject = new JSONObject();
                object2.put((Object)jSONObject.put("vod_id", (Object)string2).put("vod_name", object3).put("vod_pic", object));
            }
        }
    }

    public String detailContent(List<String> object) {
        try {
            Object object2 = Am.yq(this.yq(object.get(0)));
            String string = ((hN)object2).cS(".video-title.h1-title").t0();
            String string2 = ((hN)object2).cS(".video-cover.list-flex-in img").yq("src");
            String string3 = ((hN)object2).cS("span.doc-name").t0();
            String string4 = ((hN)object2).cS(".img-text-con").t0();
            object2 = ((hN)object2).cS("#video source").yq("src");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("$");
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
            stringBuilder = new JSONObject();
            object = stringBuilder.put("vod_id", object.get(0)).put("vod_name", (Object)string).put("vod_pic", (Object)string2).put("vod_area", (Object)"\u4e2d\u56fd").put("vod_actor", (Object)string3).put("vod_content", (Object)string4).put("vod_play_from", (Object)"Qile").put("vod_play_url", (Object)((String)object2).toString());
            string = new JSONArray();
            object = string.put(object);
            string = new JSONObject();
            object = string.put("list", object).toString();
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public String homeContent(boolean bl) {
        try {
            Object object = new JSONObject();
            object = object.put("type_id", (Object)"jijiu|0").put("type_name", (Object)"\u6025\u6551\u6280\u80fd");
            JSONObject jSONObject = new JSONObject();
            jSONObject = jSONObject.put("type_id", (Object)"jijiu|1").put("type_name", (Object)"\u5bb6\u5ead\u751f\u6d3b");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2 = jSONObject2.put("type_id", (Object)"jijiu|2").put("type_name", (Object)"\u6025\u5371\u91cd\u75c7");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3 = jSONObject3.put("type_id", (Object)"jijiu|3").put("type_name", (Object)"\u5e38\u89c1\u635f\u4f24");
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4 = jSONObject4.put("type_id", (Object)"jijiu|4").put("type_name", (Object)"\u52a8\u7269\u81f4\u4f24");
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5 = jSONObject5.put("type_id", (Object)"jijiu|5").put("type_name", (Object)"\u6d77\u6d0b\u6025\u6551");
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6 = jSONObject6.put("type_id", (Object)"jijiu|6").put("type_name", (Object)"\u4e2d\u6bd2\u6025\u6551");
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7 = jSONObject7.put("type_id", (Object)"jijiu|7").put("type_name", (Object)"\u610f\u5916\u4e8b\u6545");
            JSONArray jSONArray = new JSONArray();
            jSONObject = jSONArray.put(object).put((Object)jSONObject).put((Object)jSONObject2).put((Object)jSONObject3).put((Object)jSONObject4).put((Object)jSONObject5).put((Object)jSONObject6).put((Object)jSONObject7);
            object = new JSONObject();
            object = object.put("class", (Object)jSONObject).toString();
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public void init(Context context, String string) {
        super.init(context, string);
    }

    public String playerContent(String string, String string2, List<String> list) {
        try {
            string = new JSONObject();
            string = string.put("parse", 0).put("url", (Object)string2).toString();
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String searchContent(String object, boolean bl) {
        try {
            CharSequence charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(this.yq);
            ((StringBuilder)charSequence).append("/cse/search?q=");
            ((StringBuilder)charSequence).append(URLEncoder.encode((String)object));
            object = Am.yq(this.yq(((StringBuilder)charSequence).toString())).cS(".search-video-li.list-br2");
            JSONArray jSONArray = new JSONArray();
            Iterator iterator = ((AbstractCollection)object).iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    object = new JSONObject();
                    return object.put("list", (Object)jSONArray).toString();
                }
                object = (hN)iterator.next();
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(this.yq);
                ((StringBuilder)charSequence).append(((hN)object).cS("a").yq("href"));
                String string = ((StringBuilder)charSequence).toString();
                String string2 = ((hN)object).cS("h5.line-clamp1").t0();
                charSequence = ((hN)object).cS("dt.logo-bg img").yq("src");
                object = charSequence;
                if (!((String)charSequence).startsWith("https")) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("https:");
                    ((StringBuilder)object).append((String)charSequence);
                    object = ((StringBuilder)object).toString();
                }
                charSequence = new JSONObject();
                jSONArray.put((Object)charSequence.put("vod_id", string).put("vod_name", (Object)string2).put("vod_pic", object));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }
}

