/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.JsonBasic;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.ME;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONObject;

public class JsonSequence {
    public static JSONObject parse(LinkedHashMap<String, String> linkedHashMap, String string) {
        if (((AbstractMap)linkedHashMap).isEmpty()) {
            return new JSONObject();
        }
        for (String string2 : linkedHashMap.keySet()) {
            String string3;
            try {
                HashMap<String, String> hashMap = JsonBasic.getReqHeader(linkedHashMap.get(string2));
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
            return string3;
        }
        return new JSONObject();
    }
}

