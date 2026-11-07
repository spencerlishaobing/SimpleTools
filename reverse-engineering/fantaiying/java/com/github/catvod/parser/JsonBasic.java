/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.util.Base64;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.ME;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONObject;

public class JsonBasic {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap<String, String> getReqHeader(String string) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("url", string);
        if (!string.contains("cat_ext")) {
            return hashMap;
        }
        try {
            int n = string.indexOf("cat_ext=");
            int n2 = string.indexOf("&", n);
            CharSequence charSequence = string.substring(n + 8, n2);
            Object object = new String(Base64.decode((String)charSequence, (int)10));
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string.substring(0, n));
            ((StringBuilder)charSequence).append(string.substring(n2 + 1));
            string = ((StringBuilder)charSequence).toString();
            charSequence = new JSONObject((String)object);
            if (charSequence.has("header")) {
                JSONObject jSONObject = charSequence.optJSONObject("header");
                object = jSONObject.keys();
                while (object.hasNext()) {
                    charSequence = (String)object.next();
                    hashMap.put((String)charSequence, jSONObject.optString((String)charSequence, ""));
                }
            }
            hashMap.put("url", string);
            return hashMap;
        }
        catch (Exception exception) {
            return hashMap;
        }
    }

    public static JSONObject parse(LinkedHashMap<String, String> linkedHashMap, String string) {
        SpiderDebug.log((String)"Load Json Parse Basic...");
        if (((AbstractMap)linkedHashMap).isEmpty()) {
            return new JSONObject();
        }
        for (String string2 : linkedHashMap.keySet()) {
            String string3;
            HashMap<String, String> hashMap = JsonBasic.getReqHeader(linkedHashMap.get(string2));
            try {
                string3 = hashMap.get("url");
                hashMap.remove("url");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append(string);
                SpiderDebug.log((String)stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append(string);
                string3 = ME.Nl(string, Bo.B(stringBuilder.toString(), hashMap));
                if (string3 == null) continue;
            }
            catch (Exception exception) {}
            string3.put("jxFrom", (Object)string2);
            SpiderDebug.log((String)string3.toString());
            return string3;
        }
        return new JSONObject();
    }
}

