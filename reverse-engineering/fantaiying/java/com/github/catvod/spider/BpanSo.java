/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.uA;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.wg;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class BpanSo
extends Pan {
    @Override
    public String detailContent(List<String> object) {
        try {
            uA.dT(true);
            object = super.detailContent((List<String>)object);
            return object;
        }
        catch (Exception exception) {
            return "";
        }
    }

    public String homeContent(boolean bl) {
        ArrayList<Ef> arrayList = new ArrayList<Ef>();
        ArrayList<Jz> arrayList2 = new ArrayList<Jz>();
        arrayList2.add(new Jz("1", "\ud83c\udf53\u672c\u6e90\u662f\u7f51\u76d8\u641c\u7d22\u6e90\uff0c\u4ec5\u652f\u6301\u641c\u7d22"));
        return Tq.Nl(arrayList2, arrayList, new JSONObject());
    }

    public String searchContent(String string, boolean bl) {
        return this.searchContent(string, bl, "1");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String searchContent(String string, boolean bl, String object) {
        int n;
        StringBuilder stringBuilder;
        Object object2 = new HashMap<String, String>();
        ((HashMap)object2).put("User-Agent", wg.N());
        Serializable serializable = new StringBuilder();
        ((StringBuilder)serializable).append("https://www.melost.cn/film/");
        ((StringBuilder)serializable).append(URLEncoder.encode(string));
        ((HashMap)object2).put("Referer", ((StringBuilder)serializable).toString());
        ((HashMap)object2).put("Origin", "https://www.melost.cn");
        serializable = new ArrayList();
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append("{\"page\":");
            stringBuilder.append((String)object);
            stringBuilder.append(",\"q\":\"");
            stringBuilder.append(string);
            stringBuilder.append("\",\"user\":\"\",\"exact\":true,\"distinct\":true,\"format\":[],\"share_time\":\"\",\"order\":\"create_desc\",\"size\":15,\"type\":\"BDY\",\"exclude_user\":[],\"format\":[\".mp4\",\".mkv\",\".flv\",\".rmvb\",\".wmv\",\".mov\",\".m3u8\",\".avi\",\".mpg\",\".mpeg\"],\"adv_params\":{\"wechat_pwd\":\"\",\"platform\":\"pc\"}}");
            object = w2.dT("https://www.melost.cn/v1/search/disk", stringBuilder.toString(), object2).body().string();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("datas");
            ((StringBuilder)object2).append((String)object);
            SpiderDebug.log((String)((StringBuilder)object2).toString());
            object2 = new JSONObject((String)object);
            stringBuilder = object2.getJSONObject("data").getJSONArray("list");
            n = 0;
        }
        catch (Exception exception) {
            return Tq.ee(serializable);
        }
        while (true) {
            Ef ef;
            JSONObject jSONObject;
            block8: {
                block9: {
                    if (n >= stringBuilder.length()) break;
                    jSONObject = stringBuilder.getJSONObject(n);
                    ef = new Ef();
                    ef.G(jSONObject.getString("link"));
                    object = object2 = jSONObject.getString("disk_name").replace("<em>", "").replace("</em>", "").trim();
                    if (!bl) break block8;
                    if (((String)object2).contains(string)) break block9;
                    object = object2;
                    if (!string.contains((CharSequence)object2)) break block8;
                }
                object = string;
            }
            ef.G4((String)object);
            ef.W(jSONObject.getString("shared_time"));
            ef.dT("https://img07.sogoucdn.com/v2/thumb/retype_exclude_gif/ext/auto/q/95/crop/xy/ai/t/0/?appid=122&url=https://s1.imagehub.cc/images/2026/05/08/e4b3624dd3b03848c6f6915d437fea36.png");
            ((ArrayList)serializable).add(ef);
            ++n;
            continue;
            break;
        }
        return Tq.ee(serializable);
    }
}

