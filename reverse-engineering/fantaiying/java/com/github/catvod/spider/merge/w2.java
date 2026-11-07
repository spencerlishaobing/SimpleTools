/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.SpiderDebug
 *  okhttp3.Call
 *  okhttp3.ConnectionPool
 *  okhttp3.Dispatcher
 *  okhttp3.Dns
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.OkHttpClient
 *  okhttp3.OkHttpClient$Builder
 *  okhttp3.Protocol
 *  okhttp3.Response
 */
package com.github.catvod.spider.merge;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.Ah;
import com.github.catvod.spider.merge.L1;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.RS;
import com.github.catvod.spider.merge.SO;
import com.github.catvod.spider.merge.oy;
import com.github.catvod.spider.merge.yb;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;

public final class w2 {
    private static final ConnectionPool Gc;
    private static OkHttpClient N;
    private static final Object SN;
    private static String i;
    private static OkHttpClient t0;
    private static OkHttpClient tF;
    private static int yq;
    public static OkHttpClient zH;

    static {
        SN = new Object();
        Gc = new ConnectionPool(50, 5L, TimeUnit.MINUTES);
    }

    public static String B(String string, Map<String, String> map, Map<String, String> map2) {
        return w2.G4(string, map, map2, "");
    }

    public static Response F5(String string, Map<String, String> map, Map<String, String> map2) {
        return new yb("POST", string, map, map2, null).SN(w2.yq(0));
    }

    public static void G(OkHttpClient okHttpClient, String string, Map<String, String> map, Map<String, String> map2, Ah ah) {
        new yb("POST", string, map, map2, ah).yq(okHttpClient);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String G4(String string, Map map, Map map2, String string2) {
        if (!string2.isEmpty()) {
            string2 = w2.SN(string2, 0);
            return w2.g9((OkHttpClient)string2, "POST", string, null, map, map2, null);
        }
        string2.isEmpty();
        string2.isEmpty();
        string2 = w2.yq(0);
        return w2.g9((OkHttpClient)string2, "POST", string, null, map, map2, null);
    }

    public static Response Gc(String string, Map<String, String> map) {
        return w2.KJ(string, map, "", 0);
    }

    public static String Gd(String string, Map<String, String> map, Map<String, List<String>> map2) {
        return w2.xa(w2.q(0), string, null, null, map, map2);
    }

    public static Response KJ(String string, Map<String, String> map, String string2, int n2) {
        if (!ME.ee(string2) && n2 == 0) {
            return new yb("GET", string, "", map).SN(w2.SN(string2, 0));
        }
        if (n2 != 0 && ME.ee(string2)) {
            return new yb("GET", string, "", map).SN(w2.yq(n2));
        }
        return new yb("GET", string, "", map).SN(w2.yq(0));
    }

    public static Response M(String string, Map<String, String> map, int n2) {
        return w2.KJ(string, map, "", n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static OkHttpClient N() {
        Object object = new Dispatcher();
        object.setMaxRequests(100);
        object.setMaxRequestsPerHost(50);
        Object object2 = SN;
        synchronized (object2) {
            Object object3 = zH;
            if (object3 == null) {
                object3 = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                object = object3.readTimeout(15L, timeUnit).writeTimeout(15L, timeUnit).connectTimeout(15L, timeUnit).retryOnConnectionFailure(true).connectionPool(Gc).dispatcher(object).protocols(Collections.singletonList(Protocol.HTTP_1_1));
                object3 = L1.SN;
                object3 = object.hostnameVerifier((HostnameVerifier)oy.yq);
                object = new L1();
                object = object3.sslSocketFactory((SSLSocketFactory)object, L1.SN).build();
                zH = object;
                yq = 0;
                return object;
            }
            if (yq == 0) {
                return object3;
            }
            zH = null;
            return w2.N();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static OkHttpClient SN(String object, int n2) {
        Object object2 = SN;
        synchronized (object2) {
            Object object3 = ((String)object).split("\\|");
            boolean bl = false;
            String string = object3[0];
            if (tF == null) {
                if (((String[])object3).length > 1) {
                    bl = Boolean.parseBoolean((String)object3[1]);
                }
                object3 = new OkHttpClient.Builder();
                object = new Dns(string){
                    final String yq;
                    {
                        this.yq = string;
                    }

                    public final List<InetAddress> lookup(String string) {
                        return Collections.singletonList(InetAddress.getByName(this.yq));
                    }
                };
                object3 = object3.dns((Dns)object);
                long l = 15L;
                long l2 = n2 == 0 ? 15L : (long)n2;
                object = TimeUnit.SECONDS;
                object3 = object3.readTimeout(l2, (TimeUnit)((Object)object));
                l2 = n2 == 0 ? 15L : (long)n2;
                object3 = object3.writeTimeout(l2, (TimeUnit)((Object)object));
                l2 = n2 == 0 ? l : (long)n2;
                object3 = object3.connectTimeout(l2, (TimeUnit)((Object)object)).retryOnConnectionFailure(true).connectionPool(Gc);
                object = L1.SN;
                object = object3.hostnameVerifier((HostnameVerifier)oy.yq);
                object3 = new L1();
                object = object.sslSocketFactory((SSLSocketFactory)object3, L1.SN);
                if (bl) {
                    object3 = new Interceptor(string){
                        final String yq;
                        {
                            this.yq = string;
                        }

                        public final Response intercept(Interceptor.Chain chain) {
                            return chain.proceed(chain.request().newBuilder().header("Host", this.yq).build());
                        }
                    };
                    object.addInterceptor((Interceptor)object3);
                }
                object = object.build();
                tF = object;
                i = string;
                return object;
            }
            if (i.equals(string)) {
                return tF;
            }
            tF = null;
            return w2.SN((String)object, n2);
        }
    }

    public static String W(String string, Map<String, String> map) {
        return w2.ee(string, map, "", 0);
    }

    public static Response dT(String string, String string2, Map<String, String> map) {
        String string3 = ME.yq;
        return new yb("POST", string, string2, map).SN(w2.yq(0));
    }

    public static String ee(String string, Map<String, String> map, String string2, int n2) {
        if (!string2.isEmpty() && n2 == 0) {
            return w2.xa(w2.SN(string2, 0), string, null, null, map, null);
        }
        if (!string2.isEmpty() && n2 > 0) {
            return w2.xa(w2.SN(string2, n2), string, null, null, map, null);
        }
        if (string2.isEmpty() && n2 > 0) {
            return w2.xa(w2.yq(n2), string, null, null, map, null);
        }
        return w2.xa(w2.yq(0), string, null, null, map, null);
    }

    public static String g9(OkHttpClient okHttpClient, String object, String string, String string2, Map<String, String> map, Map<String, String> map2, Map<String, List<String>> object2) {
        object2 = new Ah<String>(object2){
            final Map SN;
            {
                this.SN = map;
            }

            @Override
            public final void onFailure(Call call, Exception exception) {
                this.SN("");
                SpiderDebug.log((Throwable)exception);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            public final Object onParseResponse(Call object, Response response) {
                try {
                    object = this.SN;
                    if (object == null) return response.body().string();
                }
                catch (IOException iOException) {
                    return "";
                }
                object.clear();
                this.SN.putAll(response.headers().toMultimap());
                return response.body().string();
            }
        };
        object = new yb((String)object, string, map, map2, (Ah)object2);
        ((yb)object).N(string2);
        ((yb)object).yq(okHttpClient);
        return (String)((Ah)object2).getResult();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List<String> i(Map<String, List<String>> map) {
        if (map == null) {
            return null;
        }
        String string = "set-cookie";
        if (map.containsKey("set-cookie")) {
            return map.get(string);
        }
        string = "Set-Cookie";
        if (!map.containsKey("Set-Cookie")) return null;
        return map.get(string);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static OkHttpClient q(int n2) {
        Object object = SN;
        synchronized (object) {
            if (t0 != null) return t0;
            Object object2 = new OkHttpClient.Builder();
            long l = 15L;
            long l2 = n2 == 0 ? 15L : (long)n2;
            Object object3 = TimeUnit.SECONDS;
            object2 = object2.readTimeout(l2, (TimeUnit)((Object)object3));
            l2 = n2 == 0 ? 15L : (long)n2;
            object2 = object2.writeTimeout(l2, (TimeUnit)((Object)object3));
            l2 = n2 == 0 ? l : (long)n2;
            OkHttpClient.Builder builder = object2.connectTimeout(l2, (TimeUnit)((Object)object3)).followRedirects(false).followSslRedirects(false).retryOnConnectionFailure(true);
            object3 = SO.tF;
            object2 = new SO((X509TrustManager)object3);
            t0 = builder.sslSocketFactory((SSLSocketFactory)object2, (X509TrustManager)object3).build();
            return t0;
        }
    }

    public static String t0(Map<String, List<String>> map) {
        block3: {
            String string;
            block2: {
                string = "location";
                if (map.containsKey("location")) break block2;
                string = "Location";
                if (!map.containsKey("Location")) break block3;
            }
            return map.get(string).get(0);
        }
        return null;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static void tF(OkHttpClient okHttpClient, String string, Map map, Ah ah) {
        new yb("GET", string, null, map, ah).yq(okHttpClient);
    }

    public static String v(String string, Map<String, String> map, int n2) {
        return w2.ee(string, map, "", n2);
    }

    public static Response v3(String object, Map<String, String> map, Map<String, List<String>> object2, int n2) {
        OkHttpClient okHttpClient = w2.q(n2);
        object2 = new RS((Map)object2);
        object = new yb("GET", (String)object, null, map, (Ah)object2);
        ((yb)object).N(null);
        ((yb)object).yq(okHttpClient);
        return (Response)((Ah)object2).getResult();
    }

    public static String xa(OkHttpClient okHttpClient, String string, String string2, Map<String, String> map, Map<String, String> map2, Map<String, List<String>> map3) {
        return w2.g9(okHttpClient, "GET", string, string2, map, map2, map3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static OkHttpClient yq(int n2) {
        Object object = new Dispatcher();
        object.setMaxRequests(100);
        object.setMaxRequestsPerHost(50);
        Object object2 = SN;
        synchronized (object2) {
            Object object3 = N;
            if (object3 == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                long l = 15L;
                long l2 = n2 == 0 ? 15L : (long)n2;
                object3 = TimeUnit.SECONDS;
                builder = builder.readTimeout(l2, (TimeUnit)((Object)object3));
                l2 = n2 == 0 ? 15L : (long)n2;
                builder = builder.writeTimeout(l2, (TimeUnit)((Object)object3));
                l2 = n2 == 0 ? l : (long)n2;
                object = builder.connectTimeout(l2, (TimeUnit)((Object)object3)).retryOnConnectionFailure(true).connectionPool(Gc).dispatcher(object);
                object3 = L1.SN;
                object3 = object.hostnameVerifier((HostnameVerifier)oy.yq);
                object = new L1();
                object = object3.sslSocketFactory((SSLSocketFactory)object, L1.SN).build();
                N = object;
                yq = n2;
                return object;
            }
            if (yq == n2) {
                return object3;
            }
            N = null;
            return w2.yq(n2);
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static String zH(Map map) {
        block5: {
            String string;
            block4: {
                if (map == null) {
                    return null;
                }
                string = "set-cookie";
                if (map.containsKey("set-cookie")) break block4;
                string = "Set-Cookie";
                if (!map.containsKey("Set-Cookie")) break block5;
            }
            return (String)((List)map.get(string)).get(0);
        }
        return null;
    }
}

