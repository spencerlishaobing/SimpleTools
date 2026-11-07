/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  okhttp3.FormBody$Builder
 *  okhttp3.MediaType
 *  okhttp3.OkHttpClient
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.RequestBody
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.github.catvod.spider.merge.Jr;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.oX;
import java.io.IOException;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/*
 * Renamed from com.github.catvod.spider.merge.eF
 */
final class ef_0 {
    private final String N;
    private final Map<String, String> SN;
    private String i;
    private final String tF;
    private final Map<String, String> yq;
    private Request zH;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private ef_0(String object42, String string, String map, Map object22, Map object3) {
        StringBuilder stringBuilder;
        this.i = string;
        this.tF = map;
        this.N = object42;
        this.SN = object22;
        this.yq = stringBuilder;
        string = new Request.Builder();
        if (object42.equals("GET") && object22 != null) {
            this.i = k_0.i(new StringBuilder(), this.i, "?");
            for (Object object42 : object22.keySet()) {
                map = this.i;
                stringBuilder = oX.yq((String)object42, "=");
                stringBuilder.append(this.SN.get(object42));
                stringBuilder.append("&");
                this.i = ((String)((Object)map)).concat(stringBuilder.toString());
            }
            this.i = ME.s(this.i);
        }
        if (this.N.equals("POST")) {
            if (!TextUtils.isEmpty((CharSequence)this.tF)) {
                object42 = RequestBody.create((MediaType)MediaType.parse((String)"application/json; charset=utf-8"), (String)this.tF);
            } else {
                object42 = new FormBody.Builder();
                map = this.SN;
                if (map != null) {
                    for (String string2 : map.keySet()) {
                        object42.add(string2, this.SN.get(string2));
                    }
                }
                object42 = object42.build();
            }
            string.post((RequestBody)object42);
        }
        if ((object42 = this.yq) != null) {
            for (Object object42 : object42.keySet()) {
                string.addHeader((String)object42, this.yq.get(object42));
            }
        }
        this.zH = string.url(this.i).build();
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    ef_0(String string, String string2, Map map) {
        this("POST", string, string2, null, map);
    }

    ef_0(String string, String string2, Map<String, String> map, Map<String, String> map2) {
        this(string, string2, null, map, map2);
    }

    public final Jr yq(OkHttpClient object) {
        try {
            object = object.newCall(this.zH).execute();
            object = new Jr(object.code(), object.body().string());
            return object;
        }
        catch (IOException iOException) {
            return new Jr();
        }
    }
}

