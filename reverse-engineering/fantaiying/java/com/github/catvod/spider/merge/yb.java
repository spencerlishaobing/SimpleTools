/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  okhttp3.Call
 *  okhttp3.FormBody$Builder
 *  okhttp3.MediaType
 *  okhttp3.OkHttpClient
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.RequestBody
 *  okhttp3.Response
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.github.catvod.spider.merge.Ah;
import com.github.catvod.spider.merge.k_0;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

final class yb {
    private final Map<String, String> N;
    private Object SN = null;
    private Request i;
    private Request.Builder t0;
    private final Map<String, String> tF;
    private String yq;
    private final Ah zH;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    yb(String string, String string2, String string3, Map map) {
        this(string, string2, string3, null, map, null);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private yb(String object5, String object22, String object3, Map object42, Map map, Ah ah) {
        this.yq = object22;
        this.N = object42;
        this.tF = map;
        this.zH = ah;
        this.t0 = new Request.Builder();
        if (!((String)object5).equals("GET")) {
            if (((String)object5).equals("POST")) {
                object22 = this.t0;
                if (!TextUtils.isEmpty((CharSequence)object3)) {
                    object5 = RequestBody.create((MediaType)MediaType.parse((String)"application/json; charset=utf-8"), (String)object3);
                } else {
                    object5 = new FormBody.Builder();
                    if (object42 != null) {
                        for (Object object42 : object42.keySet()) {
                            object5.add((String)object42, this.N.get(object42));
                        }
                    }
                    object5 = object5.build();
                }
                object22.post(object5);
            }
        } else if (object42 != null) {
            if (this.yq.contains("?")) {
                object5 = new StringBuilder();
                ((StringBuilder)object5).append(this.yq);
                ((StringBuilder)object5).append("&");
            } else {
                object5 = new StringBuilder();
                ((StringBuilder)object5).append(this.yq);
                ((StringBuilder)object5).append("?");
            }
            this.yq = ((StringBuilder)object5).toString();
            for (Object object22 : object42.keySet()) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(this.yq);
                ((StringBuilder)object3).append((String)object22);
                ((StringBuilder)object3).append("=");
                this.yq = k_0.i((StringBuilder)object3, this.N.get(object22), "&");
            }
            object5 = this.yq;
            this.yq = ((String)object5).substring(0, ((String)object5).length() - 1);
        }
        this.t0.url(this.yq);
        object5 = this.SN;
        if (object5 != null) {
            this.t0.tag(object5);
        }
        if ((object5 = this.tF) != null) {
            for (Object object5 : object5.keySet()) {
                this.t0.addHeader((String)object5, this.tF.get(object5));
            }
        }
        this.i = this.t0.build();
    }

    yb(String string, String string2, Map<String, String> map, Map<String, String> map2, Ah ah) {
        this(string, string2, null, map, map2, ah);
    }

    public final void N(Object object) {
        this.SN = object;
    }

    final Response SN(OkHttpClient okHttpClient) {
        okHttpClient = okHttpClient.newCall(this.i);
        try {
            okHttpClient = okHttpClient.execute();
            return okHttpClient;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    final void yq(OkHttpClient okHttpClient) {
        block3: {
            okHttpClient = okHttpClient.newCall(this.i);
            Object object = okHttpClient.execute();
            Ah ah = this.zH;
            if (ah == null) break block3;
            try {
                ah.yq((Call)okHttpClient, (Response)object);
            }
            catch (IOException iOException) {
                object = this.zH;
                if (object == null) break block3;
                ((Ah)object).onError((Call)okHttpClient, iOException);
            }
        }
    }
}

