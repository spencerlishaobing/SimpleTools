/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.SystemClock
 *  okhttp3.Call
 *  okhttp3.Headers
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 */
package com.github.catvod.spider.merge;

import android.app.Activity;
import android.os.SystemClock;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.E1;
import com.github.catvod.spider.merge.g_0;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.to_0;
import com.github.catvod.spider.merge.w2;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

public final class y5 {
    private long B = -1L;
    private boolean F5;
    public final AtomicBoolean G;
    private List<Call> G4;
    private long Gc;
    private long KJ = -1L;
    private long M = -1L;
    private final String N;
    private final Map<String, String> SN;
    private ExecutorService dT;
    private int i;
    private long q = -1L;
    private final int t0;
    private long tF;
    private volatile boolean v3;
    private BlockingQueue<yq> yq;
    private final ReentrantLock zH;

    public y5(String string, Map<String, String> map, int n2, long l, long l2, int n3) {
        boolean bl = true;
        this.G = new AtomicBoolean(true);
        this.N = string;
        this.SN = map;
        this.t0 = n2;
        this.zH = new ReentrantLock();
        this.yq = new PriorityBlockingQueue<yq>(n3, new SN());
        this.tF = l;
        this.Gc = l2;
        this.i = n3;
        this.G4 = new CopyOnWriteArrayList<Call>();
        this.dT = Executors.newFixedThreadPool(n2);
        if (string.contains(".ts") || string.contains(".png") || string.contains(".jpg") || string.contains(".jpeg")) {
            bl = false;
        }
        this.v3 = bl;
    }

    public y5(String string, Map<String, String> map, int n2, long l, long l2, int n3, boolean bl) {
        this.G = new AtomicBoolean(true);
        this.N = string;
        this.SN = map;
        this.t0 = n2;
        this.zH = new ReentrantLock();
        this.yq = new PriorityBlockingQueue<yq>(n3, new SN());
        this.tF = l;
        this.Gc = l2;
        this.i = n3;
        this.G4 = new CopyOnWriteArrayList<Call>();
        this.dT = Executors.newFixedThreadPool(n2);
        this.F5 = bl;
        this.v3 = true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void N(y5 var0) {
        block25: while (true) {
            block48: {
                block47: {
                    block49: {
                        if (var0.G.get() == false) return;
                        if (Thread.currentThread().isInterrupted()) {
                            return;
                        }
                        try {
                            var0.zH.lock();
                            var8_6 = var0.B;
                            if (!var0.v3) ** GOTO lbl-1000
                            var6_5 = var0.Gc;
                            if (var6_5 <= 0x100000L) ** GOTO lbl-1000
                            var4_4 = var0.KJ;
                            if (var8_6 > var4_4) ** GOTO lbl39
                            var6_5 = var8_6 + 0x1900000L - 1L;
                            if (var6_5 <= var4_4) {
                                var4_4 = var6_5;
                            }
                        }
                        catch (Exception var11_16) {
                            var10_7 /* !! */  = null;
                            break block47;
                        }
                        {
                            var11_14 = new yq(var8_6, var4_4, var0.v3);
                            var10_7 /* !! */  = var11_14;
                        }
                        try {
                            var0.B += 0x1900000L;
                            ** GOTO lbl40
                        }
                        catch (Exception var11_15) {
                            break block47;
                        }
lbl-1000:
                        // 1 sources

                        {
                            var4_4 = var0.KJ;
                            if (var8_6 > var4_4) ** GOTO lbl39
                            if ((var6_5 = var6_5 + var8_6 - 1L) > var4_4) ** GOTO lbl-1000
                            var4_4 = var6_5;
                            ** GOTO lbl-1000
                        }
                        catch (Throwable var10_8) {
                            break;
                        }
lbl-1000:
                        // 2 sources

                        {
                            var11_14 = new yq(var8_6, var4_4, var0.v3);
                            var10_7 /* !! */  = var11_14;
                        }
                        {
                            block51: {
                                var0.B += var0.Gc;
                                break block51;
lbl39:
                                // 2 sources

                                var11_14 = null;
                            }
                            var10_7 /* !! */  = var11_14;
                            var0.yq.add((yq)((Activity)var11_14));
                            var10_7 /* !! */  = var11_14;
                            var0.v3 = false;
                            break block48;
                        }
lbl-1000:
                        // 1 sources

                        {
                            var4_4 = var0.KJ;
                            if (var8_6 > var4_4) break block49;
                            var6_5 = var0.Gc + var8_6 - 1L;
                            if (var6_5 <= var4_4) {
                                var4_4 = var6_5;
                            }
                            var11_14 = new yq(var8_6, var4_4, var0.v3);
                            var10_7 /* !! */  = var11_14;
                        }
                        {
                            var0.B += var0.Gc;
                            var10_7 /* !! */  = var11_14;
                            var0.yq.add((yq)((Activity)var11_14));
                            break block48;
                        }
                    }
                    var11_14 = null;
                    break block48;
                }
                System.out.println(var11_14);
                var11_14 = var10_7 /* !! */ ;
            }
            var0.zH.unlock();
            if (var11_14 == null) {
                return;
            }
            try {
                var10_7 /* !! */  = InitOrigin.getActivity();
            }
            catch (Exception var10_9) {
                var10_7 /* !! */  = null;
            }
            if (var10_7 /* !! */  != null) {
                try {
                    var10_7 /* !! */  = InitOrigin.getActivity();
                }
                catch (Exception var10_10) {
                    var10_7 /* !! */  = null;
                }
                try {
                    var10_7 /* !! */ .getComponentName().getClassName();
                }
                catch (Exception var10_11) {
                    // empty catch block
                }
            }
            while (var0.G.get() && com.github.catvod.spider.merge.y5$yq.N((yq)var11_14) - var0.q >= var0.Gc * (long)var0.i) {
                SystemClock.sleep((long)50L);
            }
            var2_2 = 0;
            while (true) {
                block50: {
                    if (!var0.G.get()) continue block25;
                    var1_1 = var2_2;
                    var1_1 = var2_2;
                    var10_7 /* !! */  = new HashMap();
                    var1_1 = var2_2;
                    var12_17 = var0.SN.entrySet().iterator();
                    while (true) {
                        var1_1 = var2_2;
                        if (!var12_17.hasNext()) break;
                        var1_1 = var2_2;
                        var13_18 = (Map.Entry)var12_17.next();
                        var1_1 = var2_2;
                        if (((String)var13_18.getKey()).equalsIgnoreCase("Range")) {
                            var1_1 = var2_2;
                            var10_7 /* !! */ .put("Range", String.format(Locale.getDefault(), "bytes=%d-%d", new Object[]{com.github.catvod.spider.merge.y5$yq.N((yq)var11_14), com.github.catvod.spider.merge.y5$yq.SN((yq)var11_14)}));
                            continue;
                        }
                        var1_1 = var2_2;
                        var10_7 /* !! */ .put((String)var13_18.getKey(), (String)var13_18.getValue());
                    }
                    var1_1 = var2_2;
                    var10_7 /* !! */ .remove("connection");
                    var1_1 = var2_2;
                    var10_7 /* !! */ .put("connection", "keep-alive");
                    {
                        catch (Exception var10_13) {
                            if (var1_1 > 5) {
                                var12_17 = oi_0.yq("\u5f02\u5e38-");
                                var12_17.append(var10_13.getMessage());
                                InitOrigin.show(var12_17.toString());
                                var0.tF();
                            }
                            var2_2 = var1_1 + 1;
                            break block50;
                        }
                        var13_18 = w2.yq(0);
                        var12_17 = new Request.Builder();
                        var14_19 = var13_18.newCall(var12_17.url(var0.N).headers(Headers.of((Map)var10_7 /* !! */ )).build());
                        var12_17 = var14_19.execute();
                        var0.G4.add(var14_19);
                        if (var12_17 == null) ** GOTO lbl184
                        var1_1 = var2_2;
                        {
                            if (var12_17.code() >= 200) {
                                var1_1 = var2_2;
                                if (var12_17.code() <= 206) {
                                    var1_1 = var2_2;
                                    if (!var0.G.get()) continue block25;
                                    var1_1 = var2_2;
                                    if (com.github.catvod.spider.merge.y5$yq.yq((yq)var11_14)) {
                                        var1_1 = var2_2;
                                        var11_14.i((Response)var12_17);
                                        continue block25;
                                    }
                                    var1_1 = var2_2;
                                    var13_18 = var12_17.body();
                                    var1_1 = var2_2;
                                    var16_21 = var13_18.byteStream();
                                    var1_1 = var2_2;
                                    var1_1 = var2_2;
                                    var15_20 = new ByteArrayOutputStream();
                                    var1_1 = var2_2;
                                    var10_7 /* !! */  = (Activity)new byte[32768];
                                    while (true) {
                                        var1_1 = var2_2;
                                        var3_3 = var16_21.read((byte[])var10_7 /* !! */ );
                                        if (var3_3 == -1) break;
                                        var1_1 = var2_2;
                                        if (!var0.G.get()) break;
                                        var1_1 = var2_2;
                                        var15_20.write((byte[])var10_7 /* !! */ , 0, var3_3);
                                    }
                                    var1_1 = var2_2;
                                    if (var0.G.get()) {
                                        var1_1 = var2_2;
                                        var10_7 /* !! */  = (Activity)var15_20.toByteArray();
                                    } else {
                                        var10_7 /* !! */  = null;
                                    }
                                    var1_1 = var2_2;
                                    var13_18.close();
                                    if (var10_7 /* !! */  != null) {
                                        var1_1 = var2_2;
                                        var11_14.t0((byte[])var10_7 /* !! */ );
                                        var1_1 = var2_2;
                                        var0.G4.remove(var14_19);
                                        continue block25;
                                    }
                                    var1_1 = var2_2;
                                    var12_17.close();
                                    continue block25;
                                }
                            }
lbl184:
                            // 5 sources

                            var3_3 = var2_2;
                            if (var12_17 != null) {
                                if (var2_2 >= 2) {
                                    var1_1 = var2_2;
                                    InitOrigin.show(String.valueOf(var12_17.code()));
                                    var1_1 = var2_2;
                                    var0.tF();
                                }
                                var1_1 = var3_3 = var2_2 + 1;
                                var12_17.close();
                                var1_1 = var3_3;
                                var0.G4.remove(var14_19);
                                var1_1 = var3_3;
                                SystemClock.sleep((long)100L);
                            }
                            var2_2 = var3_3;
                            if (var12_17 != null) break block50;
                            if (var3_3 > 5) {
                                var1_1 = var3_3;
                                InitOrigin.show("\u65e0\u54cd\u5e94");
                                var1_1 = var3_3;
                                var0.tF();
                            }
                            var1_1 = var2_2 = var3_3 + 1;
                            var0.G4.remove(var14_19);
                            catch (Exception var10_12) {}
                            if (var2_2 > 5) {
                                var1_1 = var2_2;
                                var1_1 = var2_2;
                                var12_17 = new StringBuilder();
                                var1_1 = var2_2;
                                var12_17.append("\u8bf7\u6c42\u5f02\u5e38-");
                                var1_1 = var2_2;
                                var12_17.append(var10_12.getMessage());
                                var1_1 = var2_2;
                                InitOrigin.show(var12_17.toString());
                                var1_1 = var2_2;
                                var0.tF();
                            }
                            var1_1 = ++var2_2;
                        }
                        {
                            SystemClock.sleep((long)200L);
                            continue;
                        }
                    }
                }
                SystemClock.sleep((long)200L);
            }
            break;
        }
        var0.zH.unlock();
        throw var10_8;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void SN(y5 y52, Pipe.SinkChannel sinkChannel) {
        Throwable throwable2;
        block15: {
            block16: {
                Objects.requireNonNull(y52);
                while (true) {
                    if (!y52.G.get()) break;
                    Object object = y52.zH();
                    {
                        catch (Throwable throwable2) {
                            break block15;
                        }
                        catch (Exception exception) {}
                        {
                            exception.printStackTrace();
                            y52.tF();
                            break;
                        }
                    }
                    Object object2 = object[0];
                    Closeable closeable = null;
                    object2 = object2 != null ? (Response)object[0] : null;
                    object = object[1] != null ? (Object)((byte[])object[1]) : null;
                    {
                        if ((object == null || ((Object[])object).length == 0) && object2 == null) break;
                        if (object2 != null) {
                            closeable = Channels.newChannel(object2.body().byteStream());
                        }
                        if (object != null) {
                            closeable = new ByteArrayInputStream((byte[])object);
                            closeable = Channels.newChannel((InputStream)closeable);
                        }
                        object = ByteBuffer.allocateDirect(8192);
                        while (y52.G.get()) {
                            ((ByteBuffer)object).clear();
                            if (closeable.read((ByteBuffer)object) == -1) break;
                            ((ByteBuffer)object).flip();
                            while (((Buffer)object).hasRemaining() && y52.G.get()) {
                                if (sinkChannel.write((ByteBuffer)object) != 0) continue;
                                SystemClock.sleep((long)1L);
                            }
                        }
                        if (object2 == null) continue;
                        object2.close();
                        continue;
                    }
                    break;
                }
                try {
                    sinkChannel.close();
                    break block16;
                }
                catch (Exception exception) {}
                exception.printStackTrace();
                y52.tF();
            }
            y52.tF();
            return;
        }
        try {
            sinkChannel.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            y52.tF();
        }
        y52.tF();
        throw throwable2;
    }

    public static void yq(y5 y52) {
        long l = 0L;
        for (int i2 = 0; i2 < y52.t0; ++i2) {
            long l2;
            block6: {
                l2 = l;
                if (y52.G.get()) {
                    l2 = l;
                    if (!y52.dT.isShutdown()) {
                        Object object;
                        try {
                            ExecutorService executorService = y52.dT;
                            object = new E1(y52, 4);
                            executorService.submit((Runnable)object);
                            l2 = l;
                            if (i2 > 5) break block6;
                        }
                        catch (Exception exception) {
                            object = oi_0.yq("\u5f02\u5e38--");
                            ((StringBuilder)object).append(exception.getMessage());
                            InitOrigin.show(((StringBuilder)object).toString());
                            break;
                        }
                        SystemClock.sleep((long)l);
                        l2 = l + 50L;
                    }
                }
            }
            l = l2;
        }
    }

    private Object[] zH() {
        if (this.q > this.KJ) {
            return null;
        }
        yq yq2 = (yq)((PriorityBlockingQueue)this.yq).poll(20L, TimeUnit.SECONDS);
        if (yq2 != null) {
            while (this.G.get()) {
                byte[] byArray;
                Response response;
                if (yq2.tF) {
                    response = yq2.zH();
                    byArray = null;
                } else {
                    byArray = yq2.tF();
                    response = null;
                }
                if (byArray != null) {
                    this.q += (long)byArray.length;
                    return new Object[]{null, byArray};
                }
                if (response != null) {
                    long l = this.q;
                    this.q = yq2.SN - yq2.yq + 1L + l;
                    return new Object[]{response, null};
                }
                SystemClock.sleep((long)20L);
            }
            return null;
        }
        Exception exception = new Exception("read timeout");
        throw exception;
    }

    public final Object[] i() {
        Object object = Pattern.compile("bytes=(\\d+)-(\\d+)?").matcher(this.SN.get("Range"));
        if (object.find()) {
            long l;
            long l2;
            long l5 = this.F5 ? Long.parseLong(object.group(1)) + 8L : Long.parseLong(object.group(1));
            this.M = l5;
            int n2 = l5 == 0L ? 200 : 206;
            if (object.group(2) != null) {
                this.KJ = Long.parseLong(object.group(2));
            }
            this.B = l2 = this.M;
            this.q = l2;
            if (this.KJ <= 0L) {
                this.KJ = this.tF - 1L;
            }
            boolean bl = this.F5;
            l5 = l = this.tF;
            if (bl) {
                l5 = l - 8L;
            }
            if (this.Gc > (l5 = (l2 = l5 - l2) / (long)this.t0 + 1L)) {
                this.Gc = l5;
            }
            InitOrigin.execute(new to_0(this, 7));
            object = Pipe.open();
            Pipe.SinkChannel sinkChannel = object.sink();
            Pipe.SourceChannel sourceChannel = object.source();
            Object object2 = new HashMap<String, String>();
            if (this.F5) {
                if (this.M == 8L) {
                    object = "0";
                } else {
                    object = new StringBuilder();
                    object.append(this.M);
                    object.append("-");
                    l5 = this.KJ;
                    l5 = l5 <= 0L ? this.tF - 1L - 8L : (l5 -= 8L);
                    object.append(l5);
                    object.append("/");
                    object.append(this.tF - 8L);
                    object = object.toString();
                }
            } else {
                object = new StringBuilder();
                object.append(this.M);
                object.append("-");
                l5 = l = this.KJ;
                if (l <= 0L) {
                    l5 = this.tF - 1L;
                }
                object.append(l5);
                object.append("/");
                object.append(this.tF);
                object = object.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("bytes ");
            stringBuilder.append((String)object);
            ((HashMap)object2).put("Content-Range", stringBuilder.toString());
            ((HashMap)object2).put("Content-Length", String.valueOf(l2));
            ((HashMap)object2).put("Connection", "keep-alive");
            ((HashMap)object2).put("Accept-Ranges", "bytes");
            object = new Object[]{n2, "application/oct-stream", Channels.newInputStream(sourceChannel), object2};
            object2 = (InputStream)object[2];
            new Thread(new g_0(this, sinkChannel, 2)).start();
            return object;
        }
        object = oi_0.yq("invalid Range: ");
        object.append(this.SN.get("Range"));
        throw new Exception(object.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void tF() {
        if (this.G.get()) {
            this.G.set(false);
            this.dT.shutdownNow();
            ((PriorityBlockingQueue)this.yq).clear();
            List<Call> list = this.G4;
            if (list != null && ((CopyOnWriteArrayList)list).size() > 0) {
                list = this.G4;
                synchronized (list) {
                    for (Call call : this.G4) {
                        if (call == null) continue;
                        try {
                            call.cancel();
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                    ((CopyOnWriteArrayList)this.G4).clear();
                }
            }
            System.gc();
        }
    }

    private static final class SN
    implements Comparator<yq> {
        SN() {
        }

        @Override
        public final int compare(Object object, Object object2) {
            object = (yq)object;
            object2 = (yq)object2;
            return Long.compare(((yq)object).yq, ((yq)object2).yq);
        }
    }

    public final class yq {
        private byte[] N;
        private final long SN;
        private boolean tF;
        private final long yq;
        private Response zH;

        public yq(long l, long l2, boolean bl) {
            this.yq = l;
            this.SN = l2;
            this.tF = bl;
        }

        public final void i(Response response) {
            this.zH = response;
        }

        public final void t0(byte[] byArray) {
            this.N = byArray;
        }

        public final byte[] tF() {
            return this.N;
        }

        public final Response zH() {
            return this.zH;
        }
    }
}

