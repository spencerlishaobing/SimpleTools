/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Jb;
import com.github.catvod.spider.merge.K1;
import com.github.catvod.spider.merge.Pu;
import com.github.catvod.spider.merge.V;
import com.github.catvod.spider.merge.VG;
import com.github.catvod.spider.merge.jM;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.xe;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public final class QB
extends jM {
    public static int B;
    public static JSONObject G;
    public static String G4;
    private static int dT;
    private static ExecutorService q;

    static {
        G = new JSONObject();
        G4 = "";
        dT = 2;
    }

    public QB(int n2) {
        super(n2);
        q = Executors.newFixedThreadPool(65);
    }

    /*
     * Unable to fully structure code
     */
    public static void KJ() {
        block9: {
            var1 = 6677;
            try {
                var2_1 = new ServerSocket(6677);
                var2_1.close();
                var0_5 = 0;
            }
            catch (IOException var2_2) {
                var0_5 = 1;
            }
            if (var0_5 == 0) break block9;
            QB.B = 6677;
            var0_5 = 6678;
            while (true) {
                block10: {
                    var1 = var0_5;
                    if (var0_5 >= 7000) ** GOTO lbl32
                    try {
                        var2_1 = new ServerSocket(var0_5);
                        var2_1.close();
                        var1 = 0;
                    }
                    catch (IOException var2_3) {
                        var1 = 1;
                    }
                    if (var1 != 0) break block10;
                    var1 = var0_5;
                    ** GOTO lbl32
                }
                ++var0_5;
            }
        }
        try {
            QB.B = 6678;
lbl32:
            // 3 sources

            var2_1 = new QB(var1);
            var2_1.t0();
lbl34:
            // 2 sources

            return;
        }
        catch (IOException var2_4) {
            ** continue;
        }
    }

    public static void M(QB qB) {
        Objects.requireNonNull(qB);
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        ExecutorService executorService = q;
        if (executorService != null && !executorService.isShutdown()) {
            q.shutdown();
            SpiderDebug.log((String)"Executor service stopped.");
        }
        super.Gc();
        SpiderDebug.log((String)"Server stopped.");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final xe i(VG object4) {
        K1 k1 = K1.N;
        Object object3 = object4.SN();
        HashMap<String, String> hashMap = V.zH(object4.yq());
        Iterator iterator = object4.getParameters();
        Object object22 = object4.N();
        if ("GET".equals(hashMap) && ((String)object3).startsWith("/live")) {
            object22 = new HashMap<String, String>();
            for (String string : iterator.keySet()) {
                ((HashMap)object22).put((String)string, (String)iterator.get(string).get(0));
            }
            String string = (String)((HashMap)object22).get("url");
            object3 = oi_0.yq("#EXTM3U\n#EXT-X-VERSION:3\n#EXT-X-ALLOW-CACHE:NO\n#EXT-X-MEDIA-SEQUENCE:");
            ((StringBuilder)object3).append(dT);
            ((StringBuilder)object3).append("\n#EXT-X-TARGETDURATION:130\n\n#EXTINF:-1,Live Stream Segment  ");
            ((StringBuilder)object3).append(dT);
            ((StringBuilder)object3).append("\n");
            ((StringBuilder)object3).append(ProxyOrigin.getOwnProxyUrl());
            ((StringBuilder)object3).append("proxy/huya");
            ((StringBuilder)object3).append(dT);
            ((StringBuilder)object3).append(".ts?do=huya&url=");
            ((StringBuilder)object3).append(string);
            ((StringBuilder)object3).append("\n");
            String string2 = ((StringBuilder)object3).toString();
            ++dT;
            return xe.i(k1, "application/vnd.apple.mpegurl", new ByteArrayInputStream(string2.getBytes()));
        }
        if ("GET".equals(hashMap) && (((String)object3).startsWith("/proxy") || ((String)object3).startsWith("/play"))) {
            String string;
            block16: {
                HashMap hashMap2;
                block18: {
                    block17: {
                        void var1_8;
                        String string3 = object3;
                        if (((String)object3).startsWith("/proxy")) {
                            String string4 = ((String)object3).replace("/proxy", "");
                        }
                        hashMap = new HashMap<String, String>();
                        for (String string5 : iterator.keySet()) {
                            hashMap.put(string5, iterator.get(string5).get(0));
                        }
                        Object[] objectArray = ProxyOrigin.proxyDrive(hashMap, (String)var1_8, object22, "", G4);
                        object3 = K1.SN((Integer)objectArray[0]);
                        string = (String)objectArray[1];
                        iterator = (InputStream)objectArray[2];
                        if (objectArray.length <= 3) break block16;
                        hashMap2 = (HashMap)objectArray[3];
                        if (!hashMap2.containsKey("location")) break block17;
                        object3 = xe.Gc((Pu)object3, string, (InputStream)((Object)iterator), 0L);
                        ((xe)object3).N("location", (String)hashMap2.get("location"));
                        return object3;
                    }
                    boolean bl = object22.get("user-agent").contains("Kodi");
                    if (bl) break block18;
                    if (object22.get("user-agent").contains("Galaxy") || object22.get("user-agent").contains("VLC") || object22.get("user-agent").contains("Lavf")) break block18;
                    object3 = xe.i((Pu)object3, string, (InputStream)((Object)iterator));
                    for (Object object22 : hashMap2.keySet()) {
                        ((xe)object3).N((String)object22, (String)hashMap2.get(object22));
                    }
                    return object3;
                }
                try {
                    iterator = xe.Gc((Pu)object3, string, (InputStream)((Object)iterator), Long.parseLong((String)hashMap2.get("Content-Length")));
                    for (Object object3 : hashMap2.keySet()) {
                        ((xe)((Object)iterator)).N((String)object3, (String)hashMap2.get(object3));
                    }
                    if (object22.get("user-agent").contains("VLC")) {
                        ((xe)((Object)iterator)).N("Connection", "close");
                    }
                    return iterator;
                }
                catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }
            xe xe2 = xe.i((Pu)object3, string, (InputStream)((Object)iterator));
            return xe2;
        }
        if (((String)object3).equals("/shutdown") && "GET".equals(hashMap)) {
            new Thread(new Jb(this, 0)).start();
            return xe.t0(k1, "Server is shutting down...");
        }
        if ("HEAD".equals(hashMap)) {
            return xe.t0(K1.SN(404), "");
        }
        return null;
    }
}

