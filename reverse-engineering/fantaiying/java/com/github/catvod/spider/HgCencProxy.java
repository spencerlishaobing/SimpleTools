/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider;

import com.github.catvod.spider.HgCencProxy$1;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.RK;
import com.github.catvod.spider.merge.ZV;
import com.github.catvod.spider.merge.eY;
import com.github.catvod.spider.merge.jc_0;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.yq;
import java.io.ByteArrayInputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class HgCencProxy {
    private static final ConcurrentHashMap<String, Object> N;
    private static final ConcurrentHashMap<String, Session> SN;
    public static final int tF = 0;
    private static final Pattern yq;

    static {
        yq = Pattern.compile("bytes=(\\d+)-(\\d+)?", 2);
        SN = new ConcurrentHashMap();
        N = new ConcurrentHashMap();
    }

    private HgCencProxy() {
    }

    private static byte[] Gc(byte[] byArray) {
        byArray = (byte[])byArray.clone();
        HgCencProxy.t0(byArray, "encv", "avc1");
        HgCencProxy.t0(byArray, "enca", "mp4a");
        byte[] byArray2 = "sinf".getBytes(StandardCharsets.US_ASCII);
        byte[] byArray3 = "free".getBytes(StandardCharsets.US_ASCII);
        int n = 0;
        while (n + 4 <= byArray.length) {
            int n2;
            int n3;
            block8: {
                block1: while (byArray2.length + n <= byArray.length) {
                    n3 = 0;
                    while (true) {
                        n2 = n;
                        if (n3 < byArray2.length) {
                            if (byArray[n + n3] != byArray2[n3]) {
                                ++n;
                                continue block1;
                            }
                            ++n3;
                            continue;
                        }
                        break block8;
                        break;
                    }
                }
                n2 = -1;
            }
            if (n2 < 0) break;
            if (n2 >= 4) {
                n3 = n2 - 4;
                n = (byArray[n3] & 0xFF) << 24 | (byArray[n2 - 3] & 0xFF) << 16 | (byArray[n2 - 2] & 0xFF) << 8 | byArray[n2 - 1] & 0xFF;
                if (n >= 8 && n < 50000 && (n3 += n) <= byArray.length) {
                    System.arraycopy(byArray3, 0, byArray, n2, 4);
                    for (n = n2 + 4; n < n3; ++n) {
                        byArray[n] = 0;
                    }
                    n = n3;
                    continue;
                }
            }
            n = n2 + 4;
        }
        return byArray;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static Object[] M(String var0, String var1_3, String var2_4, Map<String, String> var3_5) {
        block36: {
            block42: {
                block35: {
                    block33: {
                        block37: {
                            block38: {
                                if (var1_4 == null) return HgCencProxy.SN(502, "media url missing");
                                if (!var1_4.startsWith("http")) {
                                    return HgCencProxy.SN(502, "media url missing");
                                }
                                var5_7 = 0;
                                var4_8 = var2_5 != null && var2_5.isEmpty() == false ? 1 : 0;
                                if (var4_8 == 0) break block37;
                                var17_9 = HgCencProxy.SN;
                                var15_10 = var17_9.get(var0);
                                if (var15_10 == null || !var15_10.KJ || !var1_4.equals(var15_10.yq) || var15_10.yq()) break block38;
                                var2_5 = var15_10;
                                break block33;
                            }
                            var15_10 = new Object();
                            var16_11 = HgCencProxy.N.putIfAbsent((String)var0, var15_10);
                            if (var16_11 != null) {
                                var15_10 = var16_11;
                            }
                            synchronized (var15_10) {
                                block34: {
                                    block40: {
                                        block39: {
                                            var16_11 = var15_10;
                                            var17_9 = var17_9.get(var0);
                                            if (var17_9 != null) {
                                                var16_11 = var15_10;
                                                if (var17_9.KJ) {
                                                    var16_11 = var15_10;
                                                    if (var1_4.equals(var17_9.yq)) {
                                                        var16_11 = var15_10;
                                                        if (!var17_9.yq()) {
                                                            var16_11 = var15_10;
                                                            // MONITOREXIT @DISABLED, blocks:[0, 3, 28, 29, 30, 31] lbl28 : MonitorExitStatement: MONITOREXIT : var15_10
                                                            var2_5 = var17_9;
                                                            break block33;
                                                        }
                                                    }
                                                }
                                            }
                                            var16_11 = var15_10;
                                            var2_5 = RK.SN((String)var2_5);
                                            var16_11 = var15_10;
                                            if (!RK.yq(var2_5.yq)) ** GOTO lbl145
                                            var16_11 = var15_10;
                                            var19_12 = ZV.SN(var2_5.yq);
                                            var16_11 = var15_10;
                                            var2_5 = HgCencProxy.i(var1_4, 0L, 65535L);
                                            var16_11 = var15_10;
                                            var7_13 = var2_5.SN;
                                            if (var7_13 <= 0L) ** GOTO lbl140
                                            var16_11 = var15_10;
                                            var16_11 = var15_10;
                                            var17_9 = new HttpHeadReader((String)var1_4, var7_13, var2_5.yq);
                                            var16_11 = var15_10;
                                            var20_14 = jc_0.tF((jc_0.zH)var17_9, var7_13);
                                            if (var20_14 == null) ** GOTO lbl135
                                            var16_11 = var15_10;
                                            var9_15 /* !! */  = var20_14.yq;
                                            var16_11 = var15_10;
                                            var13_16 = var20_14.SN;
                                            var11_17 = (long)(var9_15 /* !! */  + var13_16);
                                            var16_11 = var15_10;
                                            var2_5 = var2_5.yq;
                                            var16_11 = var15_10;
                                            if (var11_17 > (long)((Object)var2_5).length) break block39;
                                            var6_18 = (int)var13_16;
                                            var16_11 = var15_10;
                                            var17_9 = (ConcurrentHashMap<String, Session>)new byte[var6_18];
                                            var16_11 = var15_10;
                                            System.arraycopy(var2_5, (int)var9_15 /* !! */ , var17_9, 0, var6_18);
                                            break block40;
                                        }
                                        var16_11 = var15_10;
                                        var17_9 = (ConcurrentHashMap<String, Session>)HgCencProxy.i((String)var1_4, (long)var9_15 /* !! */ , (long)(var11_17 - 1L)).yq;
                                        var16_11 = var15_10;
                                        if ((long)((Object)var17_9).length != var20_14.SN) ** GOTO lbl130
                                    }
                                    var16_11 = var15_10;
                                    var16_11 = var15_10;
                                    var2_5 = new jc_0.tF((byte[])var17_9, var20_14.yq);
                                    var16_11 = var15_10;
                                    var2_5 = jc_0.yq((jc_0.tF)var2_5);
                                    var16_11 = var15_10;
                                    if (var2_5.yq.isEmpty()) ** GOTO lbl125
                                    var16_11 = var15_10;
                                    var16_11 = var15_10;
                                    var21_19 = new ArrayList<Sample>();
                                    var16_11 = var15_10;
                                    var22_20 = var2_5.yq.iterator();
                                    while (true) {
                                        var16_11 = var15_10;
                                        if (var22_20.hasNext()) {
                                            var16_11 = var15_10;
                                            var23_22 = (jc_0.Gc)var22_20.next();
                                            var16_11 = var15_10;
                                            var2_5 = (ArrayList)jc_0.Gc(var23_22);
                                            var16_11 = var15_10;
                                            if (var2_5.isEmpty()) {
                                                var18_21 = "";
                                            } else {
                                                var16_11 = var15_10;
                                                var18_21 = (String)var2_5.get(var5_7);
                                            }
                                            var6_18 = 0;
                                            break block34;
                                        }
                                        ** GOTO lbl104
                                        break;
                                    }
                                    {
                                        block41: {
                                            catch (Throwable var0_1) {
                                                var1_4 = var16_11;
lbl100:
                                                // 2 sources

                                                while (true) {
                                                    var2_5 = var1_4;
                                                    // ** MonitorExit[var1_4] (shouldn't be in output)
                                                    throw var0_2;
                                                }
                                            }
lbl104:
                                            // 1 sources

                                            var2_5 = var15_10;
                                            ** try [egrp 2[TRYBLOCK] [39 : 703->926)] { 
lbl106:
                                            // 1 sources

                                            if (var21_19.isEmpty()) {
                                                var2_5 = var15_10;
                                                var2_5 = var15_10;
                                                var0 = new Exception("\u65e0 CENC \u6837\u672c");
                                                var2_5 = var15_10;
                                                throw var0;
                                            }
                                            var2_5 = var15_10;
                                            var2_5 = var15_10;
                                            var16_11 = new HgCencProxy$1();
                                            var2_5 = var15_10;
                                            Collections.sort(var21_19, var16_11);
                                            var2_5 = var15_10;
                                            var2_5 = var15_10;
                                            var16_11 = new Session((String)var1_4, var19_12, var7_13, var20_14.yq, HgCencProxy.Gc((byte[])var17_9), var21_19, true);
                                            var2_5 = var15_10;
                                            HgCencProxy.zH((String)var0, (Session)var16_11);
                                            var2_5 = var15_10;
                                            // MONITOREXIT @DISABLED, blocks:[2, 3] lbl120 : MonitorExitStatement: MONITOREXIT : var15_10
                                            break block41;
lbl125:
                                            // 1 sources

                                            var2_5 = var15_10;
                                            var2_5 = var15_10;
                                            var0 = new Exception("\u65e0\u52a0\u5bc6\u8f68");
                                            var2_5 = var15_10;
                                            throw var0;
lbl130:
                                            // 1 sources

                                            var2_5 = var15_10;
                                            var2_5 = var15_10;
                                            var0 = new Exception("moov \u5206\u7247\u957f\u5ea6\u4e0d\u7b26");
                                            var2_5 = var15_10;
                                            throw var0;
lbl135:
                                            // 1 sources

                                            var2_5 = var15_10;
                                            var2_5 = var15_10;
                                            var0 = new Exception("\u672a\u627e\u5230 moov");
                                            var2_5 = var15_10;
                                            throw var0;
lbl140:
                                            // 1 sources

                                            var2_5 = var15_10;
                                            var2_5 = var15_10;
                                            var0 = new Exception("\u5a92\u4f53\u603b\u957f\u5ea6\u672a\u77e5");
                                            var2_5 = var15_10;
                                            throw var0;
lbl145:
                                            // 1 sources

                                            var2_5 = var15_10;
                                            var2_5 = var15_10;
                                            var0 = new Exception("spade \u89e3\u5305\u5931\u8d25");
                                            var2_5 = var15_10;
                                            throw var0;
                                        }
                                        var2_5 = var16_11;
                                        break block33;
                                    }
lbl153:
                                    // 1 sources

                                    catch (Throwable var0_3) {
                                        var1_4 = var2_5;
                                        ** continue;
                                    }
                                }
                                while (true) {
                                    var16_11 = var15_10;
                                    if (var6_18 >= var23_22.yq) ** continue;
                                    var16_11 = var15_10;
                                    var11_17 = var23_22.N[var6_18];
                                    var16_11 = var15_10;
                                    var2_5 = var23_22.SN;
                                    var9_15 /* !! */  = var2_5[var6_18];
                                    if (var9_15 /* !! */  > 0L) {
                                        var2_5 = var15_10;
                                        {
                                            var2_5 = var15_10;
                                            var16_11 = new Sample(var11_17, (int)var9_15 /* !! */ , jc_0.SN(var23_22, var18_21, var6_18));
                                            var2_5 = var15_10;
                                            var21_19.add((Sample)var16_11);
                                        }
                                    }
                                    ++var6_18;
                                    var5_7 = 0;
                                }
                            }
                        }
                        var2_5 = HgCencProxy.SN.get(var0);
                        if (var2_5 == null || var2_5.KJ || !var1_4.equals(var2_5.yq) || var2_5.yq()) {
                            var7_13 = HgCencProxy.i((String)var1_4, (long)0L, (long)0L).SN;
                            if (var7_13 <= 0L) {
                                var7_13 = 0L;
                            }
                            if (var7_13 <= 0L) throw new Exception("\u5a92\u4f53\u603b\u957f\u5ea6\u672a\u77e5");
                            var2_5 = Collections.emptyList();
                            var2_5 = new Session((String)var1_4, null, var7_13, 0L, new byte[0], (List<Sample>)var2_5, false);
                            HgCencProxy.zH((String)var0, (Session)var2_5);
                        }
                    }
                    var15_10 = null;
                    for (Map.Entry<K, V> var3_6 : var3_6.entrySet()) {
                        if (var3_6.getKey() == null || !((String)var3_6.getKey()).equalsIgnoreCase("Range")) continue;
                        var3_6 = (String)var3_6.getValue();
                        break block35;
                    }
                    var3_6 = null;
                }
                var7_13 = var2_5.N;
                if (var7_13 <= 0L) ** GOTO lbl-1000
                if (var3_6 == null || var3_6.trim().isEmpty()) break block42;
                if (!(var3_6 = HgCencProxy.yq.matcher(var3_6.trim())).find()) ** GOTO lbl-1000
                var11_17 = Long.parseLong(var3_6.group(1));
                var9_15 /* !! */  = var7_13 - 1L;
                var7_13 = (long)var9_15 /* !! */ ;
                if (var3_6.group(2) != null) {
                    var7_13 = (long)var9_15 /* !! */ ;
                    if (!var3_6.group(2).isEmpty()) {
                        var7_13 = Long.parseLong(var3_6.group(2));
                    }
                }
                var9_15 /* !! */  = var11_17;
                if (var11_17 < 0L) {
                    var9_15 /* !! */  = 0L;
                }
                if (var7_13 < var9_15 /* !! */ ) lbl-1000:
                // 3 sources

                {
                    var3_6 = var15_10;
                    break block36;
                } else {
                    var3_6 = (Map.Entry<K, V>)new long[2];
                    var3_6[0] = var9_15 /* !! */ ;
                    var3_6[1] = var7_13;
                }
                break block36;
            }
            var3_6 = (Map.Entry<K, V>)new long[]{0L, var7_13 - 1L};
        }
        if (var3_6 == null) {
            return HgCencProxy.SN(416, "invalid range");
        }
        var9_15 /* !! */  = var3_6[0];
        var7_13 = (long)var3_6[1];
        var11_17 = var2_5.N;
        if (var9_15 /* !! */  >= var11_17) {
            var0 = new HashMap<K, V>();
            var1_4 = oi_0.yq("bytes */");
            var1_4.append(var2_5.N);
            var0.put("Content-Range", var1_4.toString());
            var0.put("Content-Length", "0");
            return new Object[]{416, "video/mp4", new ByteArrayInputStream(new byte[0]), var0};
        }
        if (var7_13 >= var11_17) {
            var7_13 = var11_17 - 1L;
        }
        var5_7 = var9_15 /* !! */  == 0L && var7_13 == var11_17 - 1L ? 200 : 206;
        var3_6 = new HashMap<String, String>();
        var3_6.put("Accept-Ranges", "bytes");
        var15_10 = new StringBuilder();
        var15_10.append("bytes ");
        var15_10.append((long)var9_15 /* !! */ );
        var15_10.append("-");
        var15_10.append(var7_13);
        var15_10.append("/");
        var15_10.append(var2_5.N);
        var3_6.put("Content-Range", var15_10.toString());
        var3_6.put("Content-Length", String.valueOf(var7_13 - var9_15 /* !! */  + 1L));
        var3_6.put("Connection", "keep-alive");
        if (var4_8 != 0) {
            var1_4 = Pipe.open();
            new Thread((Runnable)new yq((Pipe)var1_4, (long)var9_15 /* !! */ , var7_13, (Session)var2_5), eY.yq("hg-cenc-", (String)var0)).start();
            return new Object[]{var5_7, "video/mp4", Channels.newInputStream(var1_4.source()), var3_6};
        }
        var0 = HgCencProxy.N();
        var2_5 = new StringBuilder();
        var2_5.append("bytes=");
        var2_5.append((long)var9_15 /* !! */ );
        var2_5.append("-");
        var2_5.append(var7_13);
        var0.put("Range", var2_5.toString());
        var0 = Bo.zH((String)var1_4, (Map<String, String>)var0);
        if (var0.body() != null && (var0.code() == 200 || var0.code() == 206)) {
            return new Object[]{var5_7, "video/mp4", var0.body().byteStream(), var3_6};
        }
        var4_8 = var0.code();
        var0.close();
        var0 = new StringBuilder();
        var0.append("upstream ");
        var0.append(var4_8);
        return HgCencProxy.SN(502, var0.toString());
    }

    private static Map<String, String> N() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("User-Agent", "Mozilla/5.0");
        linkedHashMap.put("Referer", "https://novel.snssdk.com/");
        linkedHashMap.put("Connection", "keep-alive");
        return linkedHashMap;
    }

    private static Object[] SN(int n, String string) {
        String string2 = string;
        if (string == null) {
            string2 = "";
        }
        return new Object[]{n, "text/plain; charset=utf-8", new ByteArrayInputStream(string2.getBytes(StandardCharsets.UTF_8))};
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private static RangeResult i(String object, long l, long l2) {
        block20: {
            Map<String, String> map = HgCencProxy.N();
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("bytes=");
            ((StringBuilder)object2).append(l);
            ((StringBuilder)object2).append("-");
            ((StringBuilder)object2).append(l2);
            map.put("Range", ((StringBuilder)object2).toString());
            l = l2 - l + 1L;
            Object var9_9 = null;
            object2 = null;
            for (int i2 = 0; i2 < 3; ++i2) {
                Object object3;
                block19: {
                    Object object4;
                    block16: {
                        block18: {
                            void var0_3;
                            block17: {
                                block14: {
                                    block15: {
                                        if (i2 > 0) {
                                            Thread.sleep((long)i2 * 400L);
                                        }
                                        object2 = Bo.zH((String)object, map);
                                        if (object2.body() == null || object2.code() != 200 && object2.code() != 206) break block14;
                                        l2 = HgCencProxy.tF(object2.header("Content-Range"), object2.header("Content-Length"), l);
                                        object3 = object2.body().bytes();
                                        if (object2.code() != 206 || (long)((Object)object3).length >= l) break block15;
                                        object4 = new StringBuilder();
                                        ((StringBuilder)object4).append("\u5206\u7247\u957f\u5ea6\u4e0d\u8db3 ");
                                        ((StringBuilder)object4).append(((Object)object3).length);
                                        ((StringBuilder)object4).append("/");
                                        ((StringBuilder)object4).append(l);
                                        object3 = new Exception(((StringBuilder)object4).toString());
                                        object4 = object2;
                                        object2 = object3;
                                        break block16;
                                    }
                                    object4 = new RangeResult((byte[])object3, l2);
                                    object2.close();
                                    return object4;
                                }
                                try {
                                    object4 = new StringBuilder();
                                    ((StringBuilder)object4).append("\u5206\u7247 HTTP ");
                                    ((StringBuilder)object4).append(object2.code());
                                    object3 = new Exception(((StringBuilder)object4).toString());
                                    object4 = object2;
                                    object2 = object3;
                                    break block16;
                                }
                                catch (Throwable throwable) {
                                    break block17;
                                }
                                catch (Exception exception) {
                                    object4 = object2;
                                    object2 = exception;
                                    break block18;
                                }
                                catch (Throwable throwable) {
                                    object2 = var9_9;
                                }
                            }
                            if (object2 != null) {
                                object2.close();
                            }
                            throw var0_3;
                            catch (Exception exception) {
                                object4 = null;
                            }
                        }
                        object3 = object2;
                        if (object4 == null) break block19;
                    }
                    object4.close();
                    object3 = object2;
                }
                object2 = object3;
            }
            object = object2;
            if (object2 != null) break block20;
            object = new Exception("\u5206\u7247\u8bf7\u6c42\u5931\u8d25");
        }
        throw object;
    }

    private static void t0(byte[] byArray, String object, String object2) {
        object = ((String)object).getBytes(StandardCharsets.US_ASCII);
        object2 = ((String)object2).getBytes(StandardCharsets.US_ASCII);
        int n = 0;
        while (n + 4 <= byArray.length) {
            if (byArray[n] == object[0] && byArray[n + 1] == object[1] && byArray[n + 2] == object[2] && byArray[n + 3] == object[3]) {
                System.arraycopy(object2, 0, byArray, n, 4);
            }
            ++n;
        }
    }

    private static long tF(String string, String string2, long l) {
        if (string != null && string.contains("/") && (string = string.substring(string.lastIndexOf(47) + 1).trim()).matches("\\d+")) {
            return Long.parseLong(string);
        }
        if (string2 != null && string2.matches("\\d+")) {
            return Long.parseLong(string2);
        }
        return l;
    }

    private static void zH(String string, Session session) {
        long l = System.currentTimeMillis();
        Object object = SN.entrySet().iterator();
        while (object.hasNext()) {
            if (l - object.next().getValue().M <= 900000L) continue;
            object.remove();
        }
        while (((ConcurrentHashMap)(object = SN)).size() >= 4 && !((ConcurrentHashMap)object).isEmpty()) {
            ((ConcurrentHashMap)object).remove(((ConcurrentHashMap)object).keySet().iterator().next());
        }
        ((ConcurrentHashMap)object).put(string, session);
    }

    private static final class HttpHeadReader
    implements jc_0.zH {
        private final byte[] N;
        private final long SN;
        private final String yq;

        HttpHeadReader(String string, long l, byte[] byArray) {
            this.yq = string;
            this.SN = l;
            this.N = byArray;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public byte[] head(long l, int n) {
            if (l < 0L) return null;
            long l2 = (long)n + l;
            if (l2 > this.SN) {
                return null;
            }
            byte[] byArray = this.N;
            if (l2 <= (long)byArray.length) {
                byte[] byArray2 = new byte[n];
                System.arraycopy(byArray, (int)l, byArray2, 0, n);
                return byArray2;
            }
            try {
                return HgCencProxy.i((String)this.yq, (long)l, (long)(l2 - 1L)).yq;
            }
            catch (Exception exception) {
                return null;
            }
        }
    }

    private static final class RangeResult {
        final long SN;
        final byte[] yq;

        RangeResult(byte[] byArray, long l) {
            this.yq = byArray;
            this.SN = l;
        }
    }

    private static final class Sample {
        final byte[] N;
        final int SN;
        final long yq;

        Sample(long l, int n, byte[] byArray) {
            this.yq = l;
            this.SN = n;
            this.N = byArray;
        }
    }

    private static final class Session {
        final long[] Gc;
        final boolean KJ;
        final long M = System.currentTimeMillis();
        final long N;
        final byte[] SN;
        final long i;
        final List<Sample> t0;
        final long tF;
        final String yq;
        final byte[] zH;

        Session(String string, byte[] byArray, long l, long l2, byte[] byArray2, List<Sample> list, boolean bl) {
            this.yq = string;
            this.SN = byArray;
            this.N = l;
            this.tF = l2;
            this.zH = byArray2;
            this.i = l2 + (long)byArray2.length;
            this.t0 = list;
            this.KJ = bl;
            this.Gc = new long[list.size()];
            for (int i2 = 0; i2 < list.size(); ++i2) {
                this.Gc[i2] = list.get((int)i2).yq;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        final byte[] SN(long l, long l2) {
            long l5;
            int n;
            byte[] byArray = HgCencProxy.i((String)this.yq, (long)l, (long)l2).yq;
            if (byArray.length == 0) {
                Exception exception = new Exception("\u5a92\u4f53\u5206\u7247\u4e3a\u7a7a");
                throw exception;
            }
            byte[] byArray2 = (byte[])byArray.clone();
            l2 = (long)byArray2.length + l - 1L;
            long[] lArray = this.Gc;
            int n2 = tF;
            int n3 = lArray.length;
            n2 = 0;
            while (n2 < n3) {
                n = n2 + n3 >>> 1;
                if (lArray[n] <= l) {
                    n2 = n + 1;
                    continue;
                }
                n3 = n;
            }
            for (n2 = Math.max(n2 - 1, 0); n2 < this.t0.size(); ++n2) {
                byte[] byArray3;
                Sample sample = this.t0.get(n2);
                l5 = sample.yq;
                if (l5 > l2) break;
                if ((long)sample.SN + l5 <= l) continue;
                long l6 = Math.max(l5, l);
                l5 = Math.min(sample.yq + (long)sample.SN - 1L, l2);
                int n4 = (int)(l6 - sample.yq);
                n = (int)(l5 - l6 + 1L);
                byte[] byArray4 = sample.N;
                n3 = n4 / 16;
                byte[] byArray5 = (byte[])byArray4.clone();
                if (n3 == 0) {
                    l5 = l2;
                } else {
                    long l7 = (long)n3 & 0xFFFFFFFFL;
                    n3 = 15;
                    while (true) {
                        l5 = l2;
                        if (n3 < 0) break;
                        l5 = l2;
                        if (l7 == 0L) break;
                        l5 = ((long)byArray5[n3] & 0xFFL) + (0xFFL & l7);
                        byArray5[n3] = (byte)l5;
                        l7 = (l7 >>> 8) + (l5 >>> 8);
                        --n3;
                    }
                }
                l2 = l5;
                int n5 = n4 % 16;
                byte[] byArray6 = new byte[n5 + n];
                n3 = (int)(l6 - l);
                System.arraycopy(byArray2, n3, byArray6, n5, n);
                byte[] byArray7 = this.SN;
                n4 = ZV.SN;
                if (byArray7.length != 16) throw new IllegalArgumentException("content key \u957f\u5ea6\u975e\u6cd5");
                if (byArray5.length != 16) throw new IllegalArgumentException("CTR \u8ba1\u6570\u5668\u5fc5\u987b 16 \u5b57\u8282");
                try {
                    Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
                    SecretKeySpec secretKeySpec = new SecretKeySpec(byArray7, "AES");
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(byArray5);
                    cipher.init(1, (Key)secretKeySpec, ivParameterSpec);
                    byArray3 = cipher.doFinal(byArray6);
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = oi_0.yq("AES-128-CTR \u5931\u8d25: ");
                    stringBuilder.append(exception.getMessage());
                    throw new RuntimeException(stringBuilder.toString(), exception);
                }
                System.arraycopy(byArray3, n5, byArray2, n3, n);
            }
            if (l >= this.i) return byArray2;
            l5 = this.tF;
            if (l2 < l5) return byArray2;
            if (this.zH.length <= 0) return byArray2;
            l5 = Math.max(l, l5);
            l2 = Math.min(l2, this.i - 1L);
            System.arraycopy(this.zH, (int)(l5 - this.tF), byArray2, (int)(l5 - l), (int)(l2 - l5 + 1L));
            return byArray2;
        }

        final boolean yq() {
            boolean bl = System.currentTimeMillis() - this.M > 900000L;
            return bl;
        }
    }
}

