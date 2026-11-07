/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.github.catvod.crawler.Spider
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.Am;
import com.github.catvod.spider.merge.V;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.z2_0;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class Opnxng
extends Spider {
    protected String SN = "https://www.lgyy.vip/";
    protected Pattern yq = Pattern.compile("/voddetail/(\\w+).html");

    private HashMap<String, String> yq() {
        HashMap hashMap = V.tF("Content-Type", "application/x-www-form-urlencoded", "Origin", "null");
        hashMap.put("Connection", "keep-alive");
        hashMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        hashMap.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 15_7 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.6,2 Mobile/15E148 Safari/604.1");
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String searchContent(String object, boolean bl) {
        try {
            JSONArray jSONArray = new HashMap();
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(this.SN);
            jSONArray.put("q", ((StringBuilder)object2).toString());
            jSONArray.put("category_general", "1");
            jSONArray.put("language", "all");
            jSONArray.put("time_range", "");
            jSONArray.put("safesearch", "0");
            jSONArray.put("theme", "simple");
            object = Am.yq(w2.B("https://search.hbubli.cc/", jSONArray, this.yq())).cS("article.result.result-default.category-general");
            jSONArray = new JSONArray();
            object2 = ((AbstractCollection)object).iterator();
            while (true) {
                if (!object2.hasNext()) {
                    object = new JSONObject();
                    object.put("list", (Object)jSONArray);
                    return object.toString();
                }
                object = (hN)object2.next();
                Objects.requireNonNull(object);
                hN hN2 = z2_0.yq("h3 a", (hN)object);
                object = hN2.N("href");
                SpiderDebug.log((String)object);
                object = this.yq.matcher((CharSequence)object);
                object = ((Matcher)object).find() ? ((Matcher)object).group(1) : null;
                if (TextUtils.isEmpty((CharSequence)object)) continue;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("vod_id", object);
                jSONObject.put("vod_name", (Object)hN2.Fo());
                jSONArray.put((Object)jSONObject);
            }
        }
        catch (Exception exception) {
            SpiderDebug.log((Throwable)exception);
            return "";
        }
    }
}

