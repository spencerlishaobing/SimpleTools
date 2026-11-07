/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.github.catvod.crawler.Spider
 *  okhttp3.FormBody$Builder
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.RequestBody
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Am;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.TO;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.xv;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONObject;

public class SixV
extends Spider {
    private String yq;

    private String N(Pattern object, String string) {
        try {
            object = ((Pattern)object).matcher(string);
            if (((Matcher)object).find()) {
                object = ((Matcher)object).group(1).trim();
                return object;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return "";
    }

    private String SN(Pattern pattern, String string) {
        return this.N(pattern, string).replaceAll("</?[^>]+>", "").replaceAll("\n", "").replaceAll("\u3000\u3000\u3000\u3000", "").replaceAll("&amp;", "").replaceAll("middot;", "\u30fb").replaceAll("ldquo;", "\u3010").replaceAll("rdquo;", "\u3011");
    }

    private String yq(Pattern pattern, String string) {
        return this.N(pattern, string).replaceAll("<br>", "").replaceAll("&nbsp;", "").replaceAll("&amp;", "").replaceAll("middot;", "\u30fb").replaceAll("\u3000\u3000\u3000\u3000\u3000", ",");
    }

    public String categoryContent(String object, String object2, boolean bl, HashMap<String, String> object3) {
        object3 = new StringBuilder();
        ((StringBuilder)object3).append(this.yq);
        ((StringBuilder)object3).append("/");
        ((StringBuilder)object3).append((String)object);
        object = object3 = ((StringBuilder)object3).toString();
        try {
            if (!((String)object2).equals("1")) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append("/index_");
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(".html");
                object = ((StringBuilder)object).toString();
            }
            object2 = new HashMap();
            ((HashMap)object2).put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36");
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(this.yq);
            ((StringBuilder)object3).append("/");
            ((HashMap)object2).put("Referer", ((StringBuilder)object3).toString());
            object2 = xv.tF(Bo.B((String)object, object2)).cS("#post_container .post_hover");
            object = new JSONArray();
            object2 = ((AbstractCollection)object2).iterator();
            while (object2.hasNext()) {
                Object object4 = (hN)object2.next();
                Object object5 = (hN)((AbstractList)((hN)object4).cS("[class=zoom]")).get(0);
                String string = ((iK)object5).N("href");
                object3 = ((iK)object5).N("title");
                if (TO.zH((String)object3)) continue;
                object5 = ((hN)object5).cS("img").yq("src");
                object4 = ((hN)object4).cS("[rel=category tag]").t0();
                JSONObject jSONObject = new JSONObject();
                object.put((Object)jSONObject.put("vod_id", (Object)string).put("vod_name", object3).put("vod_pic", object5).put("vod_remarks", object4));
            }
            object2 = new JSONObject();
            object = object2.put("pagecount", 999).put("list", object).toString();
            return object;
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
    public String detailContent(List<String> object) {
        try {
            Object object2 = (String)object.get(0);
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append(this.yq);
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            object3 = new HashMap();
            ((HashMap)object3).put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36");
            object3 = xv.tF(Bo.B((String)object2, (Map)object3));
            object2 = ((hN)object3).cS("#post_content");
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
            object2 = ((AbstractCollection)object2).iterator();
            int n = 0;
            while (true) {
                boolean bl;
                Object object4;
                String string;
                String string2;
                Object object5;
                int n2;
                Object object6;
                if (object2.hasNext()) {
                    object6 = (hN)object2.next();
                    n2 = n + 1;
                    object5 = ((hN)object6).cS("table a");
                    object6 = new ArrayList();
                    object5 = ((AbstractCollection)object5).iterator();
                } else {
                    object6 = ((hN)object3).cS(".context");
                    object2 = Nr.SN();
                    object5 = ((AbstractCollection)object6).iterator();
                    while (object5.hasNext()) {
                        object6 = (hN)object5.next();
                        if (((StringBuilder)object2).length() != 0) {
                            ((StringBuilder)object2).append("\n");
                        }
                        ((StringBuilder)object2).append(((hN)object6).mG());
                    }
                    String string3 = Nr.Gc((StringBuilder)object2);
                    object6 = ((hN)object3).cS(".article_container > h1").t0();
                    object5 = ((hN)object3).cS("#post_content img").yq("src");
                    string2 = this.N(Pattern.compile("\u25ce\u7c7b\u3000\u3000\u522b\u3000(.*?)<br>"), string3);
                    String string4 = this.N(Pattern.compile("\u25ce\u5e74\u3000\u3000\u4ee3\u3000(.*?)<br>"), string3);
                    string = this.N(Pattern.compile("\u25ce\u4ea7\u3000\u3000\u5730\u3000(.*?)<br>"), string3);
                    object4 = this.N(Pattern.compile("\u25ce\u4e0a\u6620\u65e5\u671f\u3000(.*?)<br>"), string3);
                    object3 = object2 = this.yq(Pattern.compile("\u25ce\u6f14\u3000\u3000\u5458\u3000(.*?)</p>"), string3);
                    if (((String)object2).equals("")) {
                        object3 = this.yq(Pattern.compile("\u25ce\u4e3b\u3000\u3000\u6f14\u3000(.*?)</p>"), string3);
                    }
                    object2 = this.yq(Pattern.compile("\u25ce\u5bfc\u3000\u3000\u6f14\u3000(.*?)<br>"), string3);
                    string3 = this.SN(Pattern.compile("\u25ce\u7b80\u3000\u3000\u4ecb(.*?)<hr>", 34), string3);
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = jSONObject.put("vod_id", object.get(0)).put("vod_name", object6).put("vod_pic", object5).put("type_name", (Object)string2).put("vod_year", (Object)string4).put("vod_area", (Object)string).put("vod_remarks", object4).put("vod_actor", object3).put("vod_director", object2).put("vod_content", (Object)string3);
                    if (linkedHashMap.size() > 0) {
                        jSONObject2.put("vod_play_from", (Object)"\u6b64\u78c1\u529b\u6e90\u662f\u8fb9\u4e0b\u8f7d\u8fb9\u64ad\uff0c\u5185\u5b58\u5c0f\u7684\u614e\u7528");
                        jSONObject2.put("vod_play_url", (Object)TextUtils.join((CharSequence)"$$$", linkedHashMap.values()));
                    }
                    object3 = new JSONArray();
                    JSONArray jSONArray = object3.put((Object)jSONObject2);
                    object3 = new JSONObject();
                    return object3.put("list", (Object)jSONArray).toString();
                }
                while (bl = object5.hasNext()) {
                    object4 = (hN)object5.next();
                    string2 = ((iK)object4).N("href");
                    string = ((hN)object4).Fo();
                    if (!string2.startsWith("magnet")) continue;
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append(string);
                    ((StringBuilder)object4).append("$");
                    ((StringBuilder)object4).append(string2);
                    ((ArrayList)object6).add(((StringBuilder)object4).toString());
                }
                n = n2;
                if (((ArrayList)object6).size() <= 0) continue;
                object5 = new StringBuilder();
                ((StringBuilder)object5).append("magnet");
                ((StringBuilder)object5).append(n2);
                linkedHashMap.put(((StringBuilder)object5).toString(), TextUtils.join((CharSequence)"#", (Iterable)object6));
                n = n2;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public String homeContent(boolean bl) {
        Object object = new JSONArray();
        List<String> list = Arrays.asList("dianshiju/guoju", "dianshiju/rihanju", "dianshiju/oumeiju", "xijupian", "dongzuopian", "aiqingpian", "kehuanpian", "kongbupian", "juqingpian", "zhanzhengpian", "jilupian", "donghuapian");
        JSONObject jSONObject = Arrays.asList("\u56fd\u5267", "\u65e5\u97e9\u5267", "\u6b27\u7f8e\u5267", "\u559c\u5267\u7247", "\u52a8\u4f5c\u7247", "\u7231\u60c5\u7247", "\u79d1\u5e7b\u7247", "\u6050\u6016\u7247", "\u5267\u60c5\u7247", "\u6218\u4e89\u7247", "\u7eaa\u5f55\u7247", "\u52a8\u753b\u7247");
        int n = 0;
        while (true) {
            if (n >= list.size()) break;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type_id", (Object)list.get(n));
            jSONObject2.put("type_name", jSONObject.get(n));
            if (!TO.zH((String)jSONObject.get(n))) {
                object.put((Object)jSONObject2);
            }
            ++n;
            continue;
            break;
        }
        try {
            jSONObject = new JSONObject();
            object = jSONObject.put("class", object).toString();
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public void init(Context object, String string) {
        super.init(object, string);
        object = string;
        if (string.endsWith("/")) {
            object = string.substring(0, string.lastIndexOf("/"));
        }
        this.yq = object;
    }

    public String playerContent(String string, String string2, List<String> list) {
        ProxyOrigin.getan();
        try {
            string = new JSONObject();
            string = string.put("parse", 0).put("header", (Object)"").put("playUrl", (Object)"").put("url", (Object)string2).toString();
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public String searchContent(String string, boolean bl) {
        Object object;
        Object object2;
        block4: {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(this.yq);
            ((StringBuilder)object2).append("/e/search/11index.php");
            object2 = ((StringBuilder)object2).toString();
            object = new FormBody.Builder();
            string = object.add("show", "title").add("tempid", "1").add("tbname", "article").add("mid", "1").add("dopost", "search").add("submit", "").addEncoded("keyboard", string).build();
            object = new Request.Builder();
            object = object.url((String)object2).addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36").addHeader("Origin", this.yq);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(this.yq);
            ((StringBuilder)object2).append("/");
            string = object.addHeader("Referer", ((StringBuilder)object2).toString()).post((RequestBody)string).build();
            object2 = Bo.SN().newCall((Request)string).execute();
            if (object2.body() != null) break block4;
            return "";
        }
        try {
            string = object2.body().string();
            object2.close();
            object2 = Am.yq(string).cS("#post_container [class=zoom]");
            string = new JSONArray();
            Iterator iterator = ((AbstractCollection)object2).iterator();
            while (iterator.hasNext()) {
                Object object3 = (hN)iterator.next();
                object = ((iK)object3).N("href");
                object2 = ((iK)object3).N("title").replaceAll("</?[^>]+>", "");
                if (TO.zH((String)object2)) continue;
                object3 = ((hN)object3).cS("img").yq("src");
                JSONObject jSONObject = new JSONObject();
                string.put((Object)jSONObject.put("vod_id", object).put("vod_name", object2).put("vod_pic", object3).put("vod_remarks", (Object)""));
            }
            object2 = new JSONObject();
            string = object2.put("list", (Object)string).toString();
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }
}

