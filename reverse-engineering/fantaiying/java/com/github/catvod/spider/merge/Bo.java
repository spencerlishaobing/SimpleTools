/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.Spider
 *  okhttp3.Call
 *  okhttp3.Dns
 *  okhttp3.Headers
 *  okhttp3.OkHttpClient
 *  okhttp3.OkHttpClient$Builder
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 */
package com.github.catvod.spider.merge;

import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.merge.Jr;
import com.github.catvod.spider.merge.ef_0;
import com.github.catvod.spider.merge.jn_0;
import com.github.catvod.spider.merge.pe_0;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class Bo {
    private OkHttpClient yq;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static String B(String string, Map map) {
        string = string.startsWith("http") ? new ef_0("GET", string, null, map).yq(Bo.SN()).yq() : "";
        return string;
    }

    public static String G(String string) {
        Object object;
        Object object2;
        block6: {
            object2 = new OkHttpClient.Builder();
            object = TimeUnit.SECONDS;
            string = object2.connectTimeout(2L, object).readTimeout(2L, object).writeTimeout(2L, object).build().newCall(new Request.Builder().url(string).build()).execute();
            try {
                if (!string.isSuccessful()) break block6;
                object2 = string.body().string();
            }
            catch (Throwable throwable) {
                if (string != null) {
                    try {
                        string.close();
                    }
                    catch (Throwable throwable2) {
                        throwable.addSuppressed(throwable2);
                    }
                }
                throw throwable;
            }
            string.close();
            return object2;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("\u8bf7\u6c42\u5931\u8d25: ");
        ((StringBuilder)object2).append(string.code());
        object = new Exception(((StringBuilder)object2).toString());
        throw object;
    }

    public static Jr Gc(String string, Map<String, String> map, Map<String, String> map2) {
        return new ef_0("POST", string, map, map2).yq(Bo.SN());
    }

    public static String KJ(String string, Map<String, String> map) {
        return Bo.Gc(string, map, null).yq();
    }

    public static String M(String string, String string2) {
        return Bo.t0(string, string2, null).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String N(String string, Map<String, String> map) {
        map = Bo.SN().newBuilder().followRedirects(false).followSslRedirects(false).build().newCall(new Request.Builder().url(string).headers(Headers.of((Map)map)).build()).execute().headers().toMultimap();
        if (map == null) return null;
        string = "location";
        if (map.containsKey("location")) return (String)((List)map.get(string)).get(0);
        string = "Location";
        if (!map.containsKey("Location")) return null;
        return (String)((List)map.get(string)).get(0);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static OkHttpClient SN() {
        try {
            OkHttpClient okHttpClient = Spider.client();
            Objects.requireNonNull(okHttpClient);
            OkHttpClient okHttpClient2 = okHttpClient;
            return okHttpClient;
        }
        catch (Throwable throwable) {
            void var0_13;
            OkHttpClient okHttpClient;
            void var0_9;
            void var0_15;
            if (com.github.catvod.spider.merge.Bo$yq.yq.yq != null) {
                OkHttpClient okHttpClient3 = com.github.catvod.spider.merge.Bo$yq.yq.yq;
                return var0_15;
            }
            Bo bo = com.github.catvod.spider.merge.Bo$yq.yq;
            Object object = new OkHttpClient.Builder();
            try {
                Dns dns = Spider.safeDns();
                Objects.requireNonNull(dns);
            }
            catch (Throwable throwable2) {
                Dns dns = Dns.SYSTEM;
            }
            OkHttpClient.Builder builder = object.dns((Dns)var0_9);
            object = TimeUnit.SECONDS;
            OkHttpClient.Builder builder2 = builder.connectTimeout(30L, (TimeUnit)((Object)object)).readTimeout(30L, (TimeUnit)((Object)object)).writeTimeout(30L, (TimeUnit)((Object)object)).hostnameVerifier((HostnameVerifier)pe_0.yq);
            Object var0_11 = null;
            try {
                object = SSLContext.getInstance("TLS");
                jn_0 jn_02 = new jn_0();
                SecureRandom secureRandom = new SecureRandom();
                ((SSLContext)object).init(null, new TrustManager[]{jn_02}, secureRandom);
                Object object2 = object;
            }
            catch (Throwable throwable3) {}
            bo.yq = okHttpClient = builder2.sslSocketFactory(var0_13.getSocketFactory(), (X509TrustManager)new jn_0()).build();
            return var0_15;
        }
    }

    public static Response i(Request request) {
        return Bo.SN().newCall(request).execute();
    }

    public static String q(String string) {
        return Bo.B(string, null);
    }

    public static Jr t0(String string, String string2, Map<String, String> map) {
        return new ef_0(string, string2, map).yq(Bo.SN());
    }

    public static Response tF(String string) {
        return Bo.SN().newCall(new Request.Builder().url(string).build()).execute();
    }

    public static void yq() {
        for (Call call : Bo.SN().dispatcher().queuedCalls()) {
            if (!"p_json_parse".equals(call.request().tag())) continue;
            call.cancel();
        }
        for (Call call : Bo.SN().dispatcher().runningCalls()) {
            if (!"p_json_parse".equals(call.request().tag())) continue;
            call.cancel();
        }
    }

    public static Response zH(String string, Map<String, String> map) {
        return Bo.SN().newCall(new Request.Builder().url(string).headers(Headers.of(map)).build()).execute();
    }

    private static final class yq {
        static volatile Bo yq = new Bo();
    }
}

