/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.SpiderDebug
 */
package com.github.catvod.spider.merge;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.JsonBasic;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.w2;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public final class rN
implements Callable {
    public final String N;
    public final String SN;
    public final String yq;

    public /* synthetic */ rN(String string, String string2, String string3) {
        this.yq = string;
        this.SN = string2;
        this.N = string3;
    }

    public final Object call() {
        Object object = this.yq;
        String string = this.SN;
        String string2 = this.N;
        try {
            object = JsonBasic.getReqHeader((String)object);
            String string3 = (String)((HashMap)object).get("url");
            ((HashMap)object).remove("url");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(string);
            SpiderDebug.log((String)stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(string);
            string3 = stringBuilder.toString();
            string = ME.Nl(string, w2.xa(w2.yq(0), string3, "p_json_parse", null, (Map<String, String>)object, null));
            string.put("jxFrom", (Object)string2);
            SpiderDebug.log((String)string.toString());
        }
        catch (Exception exception) {
            string = null;
        }
        return string;
    }
}

