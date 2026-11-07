/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 *  com.github.catvod.crawler.SpiderDebug
 *  okhttp3.OkHttpClient
 *  okhttp3.OkHttpClient$Builder
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import android.util.Base64;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.oi_0;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class DC {
    private static final Map<Integer, Set<BigDecimal>> N;
    private static String SN;
    public static final int tF = 0;
    private static final Pattern yq;

    static {
        yq = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
        new BigDecimal("0.000001");
        SN = "";
        HashMap<Integer, Set<BigDecimal>> hashMap = new HashMap<Integer, Set<BigDecimal>>();
        for (int i2 = 0; i2 < 3; ++i2) {
            int n = (new int[]{30, 25, 24})[i2];
            HashSet<BigDecimal> hashSet = new HashSet<BigDecimal>();
            double d = n;
            DC.SN(hashSet, d, n);
            if (n == 24 || n == 30 || n == 60) {
                Double.isNaN(d);
                Double.isNaN(d);
                Double.isNaN(d);
                Double.isNaN(d);
                DC.SN(hashSet, d / 1.001, n * 10);
            }
            hashMap.put(n, hashSet);
        }
        N = hashMap;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static String B(String string, HashMap object) {
        if (object != null && !((HashMap)object).isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry entry : ((HashMap)object).entrySet()) {
                stringBuilder.append(URLEncoder.encode((String)entry.getKey()));
                stringBuilder.append(":");
                stringBuilder.append(URLEncoder.encode((String)entry.getValue()));
                stringBuilder.append(";");
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
            object = Base64.encodeToString((byte[])stringBuilder.toString().getBytes(), (int)2);
            stringBuilder = new StringBuilder();
            stringBuilder.append(ProxyOrigin.getUrl());
            stringBuilder.append("?do=m3u8&url=");
            stringBuilder.append(URLEncoder.encode(string));
            stringBuilder.append("&headers=");
            stringBuilder.append((String)object);
            return stringBuilder.toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(ProxyOrigin.getUrl());
        ((StringBuilder)object).append("?do=m3u8&url=");
        ((StringBuilder)object).append(URLEncoder.encode(string));
        return ((StringBuilder)object).toString();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static String G(String var0, String var1_1) {
        block101: {
            if (!var0.contains("#EXT-X-ENDLIST")) {
                var0 = System.out;
                var21_2 = new StringBuilder();
                var21_2.append("\u53ef\u80fd\u4e3a\u76f4\u64ad\u8fd4\u56de\u539f\u5730\u5740\uff1a");
                var21_2.append(var1_1);
                var0.println(var21_2.toString());
                return var1_1;
            }
            var0 = var0.trim();
            var22_4 = "\n";
            var24_5 = var0.split("\n");
            var21_3 = new HashSet<E>();
            if (var24_5 == null) {
                var0 = new HashSet<E>();
            } else {
                var25_6 = new HashMap<K, V>();
                var11_7 = var24_5.length;
                var9_9 = 0;
                for (var8_8 = 0; var8_8 < var11_7; ++var8_8) {
                    var0 = var24_5[var8_8];
                    if (var0 == null) {
                        var10_11 = var9_9;
                    } else {
                        var23_10 = var0.trim();
                        var10_11 = var9_9;
                        if (!var23_10.isEmpty()) {
                            if (var23_10.startsWith("#")) {
                                var10_11 = var9_9;
                            } else {
                                var10_11 = var9_9 + 1;
                                var9_9 = var23_10.lastIndexOf(47);
                                var0 = var9_9 != -1 ? var23_10.substring(0, var9_9) : "NO_PATH";
                                if (!var25_6.containsKey(var0)) {
                                    var25_6.put(var0, new ArrayList<E>());
                                }
                                ((List)var25_6.get(var0)).add(var23_10);
                            }
                        }
                    }
                    var9_9 = var10_11;
                }
                if (var9_9 < 2) {
                    var0 = new HashSet<String[]>();
                } else {
                    var9_9 = DC.zH(DC.t0(var24_5).divide(new BigDecimal("60"), 2, RoundingMode.HALF_UP).doubleValue());
                    var0 = null;
                    var26_12 /* !! */  = var25_6.entrySet().iterator();
                    block1: while (true) {
                        var8_8 = 0;
                        while (var26_12 /* !! */ .hasNext()) {
                            var23_10 = (Map.Entry)var26_12 /* !! */ .next();
                            var10_11 = ((List)var23_10.getValue()).size();
                            if (var0 == null || var10_11 < (var11_7 = ((List)var0.getValue()).size())) {
                                var0 = var23_10;
                                var8_8 = 1;
                                continue;
                            }
                            if (var10_11 != var11_7) continue;
                            continue block1;
                        }
                        break;
                    }
                    var10_11 = ((List)var0.getValue()).size();
                    if (var8_8 != 0 && var10_11 < var9_9 && var25_6.size() > 1) {
                        System.out.println(String.format("\u5207\u7247\u8def\u5f84\u68c0\u6d4b\uff1a\u53d1\u73b0\u4e0d\u540c\u5207\u7247 %s \u6761, \u9608\u503c %s \uff0c\u7b26\u5408\u6761\u4ef6", new Object[]{var10_11, var9_9}));
                        var0 = new HashSet<E>((Collection)var0.getValue());
                    } else {
                        var0 = new HashSet<E>();
                    }
                }
            }
            var21_3.addAll(var0);
            if (var21_3.isEmpty()) {
                var0 = new LinkedHashSet<E>();
                for (var8_8 = 0; var8_8 < var24_5.length; ++var8_8) {
                    var23_10 = var24_5[var8_8];
                    if (var23_10.startsWith("#")) continue;
                    var0.add(var23_10);
                }
                var26_12 /* !! */  = new ArrayList<E>(var0);
                if (var26_12 /* !! */ .size() < 2) {
                    var23_10 = var26_12 /* !! */ .toArray(new String[0]);
                    var22_4 = "\n";
                    var0 = var21_3;
                    var21_3 = var23_10;
                } else {
                    var9_9 = 0x7FFFFFFF;
                    for (var10_11 = 0; var10_11 < var26_12 /* !! */ .size(); ++var10_11) {
                        var0 = (String)var26_12 /* !! */ .get(var10_11);
                        var8_8 = var9_9;
                        if (var0.length() < var9_9) {
                            var8_8 = var0.length();
                        }
                        var9_9 = var8_8;
                    }
                    var2_13 = 0.0;
                    var23_10 = new HashMap<K, V>();
                    var10_11 = -1;
                    var0 = var22_4;
                    for (var8_8 = 5; var8_8 < var9_9 - 4; ++var8_8) {
                        var25_6 = new HashMap<K, V>();
                        for (var11_7 = 0; var11_7 < var26_12 /* !! */ .size(); ++var11_7) {
                            var27_16 = (String)var26_12 /* !! */ .get(var11_7);
                            var28_17 = var27_16.substring(0, var8_8);
                            var22_4 = (List)var25_6.get(var28_17);
                            if (var22_4 == null) {
                                var22_4 = new ArrayList<Iterator<V>>();
                                var25_6.put(var28_17, var22_4);
                            }
                            var22_4.add(var27_16);
                        }
                        if (var25_6.size() > 1 && var25_6.size() <= 10) {
                            var27_16 = var25_6.values().iterator();
                            var11_7 = 0;
                            while (var27_16.hasNext()) {
                                var22_4 = (List)var27_16.next();
                                if (var22_4.size() <= var11_7) continue;
                                var11_7 = var22_4.size();
                            }
                            var6_15 = var11_7;
                            var4_14 = var26_12 /* !! */ .size();
                            Double.isNaN(var6_15);
                            Double.isNaN(var4_14);
                            Double.isNaN(var6_15);
                            Double.isNaN(var4_14);
                            Double.isNaN(var6_15);
                            Double.isNaN(var4_14);
                            Double.isNaN(var6_15);
                            Double.isNaN(var4_14);
                            var6_15 /= var4_14;
                            var22_4 = var23_10;
                            var4_14 = var2_13;
                            var11_7 = var10_11;
                            if (var6_15 > var2_13) {
                                var22_4 = var23_10;
                                var4_14 = var2_13;
                                var11_7 = var10_11;
                                if (var6_15 >= 0.83) {
                                    var11_7 = var8_8;
                                    var22_4 = var25_6;
                                    var4_14 = var6_15;
                                }
                            }
                        } else {
                            var11_7 = var10_11;
                            var4_14 = var2_13;
                            var22_4 = var23_10;
                        }
                        var23_10 = var22_4;
                        var2_13 = var4_14;
                        var10_11 = var11_7;
                    }
                    var22_4 = var0;
                    var0 = var21_3;
                    if (var10_11 != -1 && var23_10.size() > 0) {
                        var21_3 = new ArrayList<E>();
                        for (Object var23_10 : var23_10.values()) {
                            if (var23_10.size() <= var21_3.size()) continue;
                            var21_3 = var23_10;
                        }
                        var21_3 = var21_3.toArray(new String[0]);
                    } else {
                        var21_3 = var26_12 /* !! */ .toArray(new String[0]);
                    }
                }
                var21_3 = (String[])var21_3;
                if (((String[])var21_3).length < 10) {
                    var21_3 = new HashSet<E>();
                } else {
                    var25_6 = var21_3[0];
                    var9_9 = DC.yq(var25_6, var21_3[((String[])var21_3).length - 1]);
                    new ArrayList<E>();
                    var23_10 = new LinkedHashMap<K, V>();
                    var8_8 = 0;
                    while (true) {
                        var21_3 = var23_10;
                        if (var8_8 >= 3) break;
                        var26_12 /* !! */  = new ArrayList<Object>();
                        var21_3 = new LinkedHashMap<K, V>();
                        var27_16 = new ArrayList<E>();
                        var11_7 = var24_5.length;
                        for (var10_11 = 0; var10_11 < var11_7; ++var10_11) {
                            var28_17 = var24_5[var10_11];
                            var12_18 = DC.yq((String)var25_6, (String)var28_17);
                            if (!var28_17.startsWith("#") && var12_18 < var9_9) {
                                var21_3.put(var28_17, var28_17);
                                if (var26_12 /* !! */ .isEmpty()) continue;
                                var27_16.add((String)var26_12 /* !! */ .remove(var26_12 /* !! */ .size() - 1));
                                continue;
                            }
                            var26_12 /* !! */ .add(var28_17);
                        }
                        if (var21_3.size() < 60) break;
                        --var9_9;
                        ++var8_8;
                    }
                    var8_8 = DC.zH(DC.t0(var24_5).divide(new BigDecimal("60"), 2, RoundingMode.HALF_UP).doubleValue());
                    if (!var21_3.isEmpty() && var21_3.size() < var8_8) {
                        System.out.println(String.format("\u76f8\u4f3c\u5ea6\u68c0\u6d4b: \u7591\u4f3c\u5207\u7247 %s \u6761, \u9608\u503c %s, \u7b26\u5408\u6761\u4ef6", new Object[]{var21_3.size(), var8_8}));
                        var21_3 = new HashSet<K>(var21_3.keySet());
                    } else {
                        var21_3 = new HashSet<E>();
                    }
                }
                var0.addAll(var21_3);
                var26_12 /* !! */  = var0;
            } else {
                var22_4 = "\n";
                var26_12 /* !! */  = var21_3;
            }
            if (!var26_12 /* !! */ .isEmpty()) break block101;
            var32_19 = new ArrayList<Object>();
            var34_20 = new ArrayList<String>();
            var21_3 = BigDecimal.ZERO;
            var31_21 = new LinkedHashMap<Integer, Integer>();
            var30_22 = new LinkedHashMap<Integer, Integer>();
            var0 = 30;
            var25_6 = 0;
            var30_22.put((Integer)var0, (Integer)var25_6);
            var23_10 = 25;
            var30_22.put((Integer)var23_10, (Integer)var25_6);
            var27_16 = 24;
            var30_22.put((Integer)var27_16, (Integer)var25_6);
            var33_23 = -1;
            var30_22.put(var33_23, (Integer)var25_6);
            var8_8 = 0x7FFFFFFF;
            var9_9 = 0;
            var11_7 = 0;
            var10_11 = 0;
            for (var16_24 = 0; var16_24 < var24_5.length; ++var16_24) {
                block103: {
                    block104: {
                        block102: {
                            var35_32 = var24_5[var16_24].trim();
                            if (!var35_32.isEmpty()) break block102;
                            var13_25 = var10_11;
                            var28_17 = var23_10;
                            break block103;
                        }
                        if (var35_32.startsWith("#EXT-X-DISCONTINUITY") || var16_24 == var24_5.length - 1) break block104;
                        var15_27 = var9_9;
                        var14_26 = var11_7;
                        var25_6 = var21_3;
                        var12_18 = var8_8;
                        ** GOTO lbl289
                    }
                    var12_18 = var9_9;
                    if (var16_24 == var24_5.length - 1) {
                        var12_18 = var9_9;
                        if (!var35_32.startsWith("#")) {
                            var12_18 = var9_9;
                            if (!var35_32.isEmpty()) {
                                var34_20.add(var35_32);
                                var12_18 = var9_9 + 1;
                            }
                        }
                    }
                    if (!var34_20.isEmpty()) {
                        var21_3 = new yq(new ArrayList<String>(var34_20), var12_18, (BigDecimal)var21_3, var11_7);
                        var32_19.add(var21_3);
                        var25_6 = var31_21.get(var21_3.SN);
                        var11_7 = var21_3.SN;
                        var9_9 = var25_6 == null ? 1 : var25_6.intValue() + 1;
                        var31_21.put(var11_7, var9_9);
                        var11_7 = var21_3.SN;
                        var9_9 = var8_8;
                        if (var11_7 < var8_8) {
                            var9_9 = var11_7;
                        }
                        var8_8 = var9_9;
                        var12_18 = var10_11;
                        if (var11_7 > var10_11) {
                            var8_8 = var9_9;
                            var12_18 = var11_7;
                        }
                    } else {
                        var12_18 = var10_11;
                    }
                    var34_20.clear();
                    var21_3 = BigDecimal.ZERO;
                    if (var35_32.startsWith("#EXT-X-DISCONTINUITY")) {
                        var9_9 = 0;
                        var11_7 = 0;
                        var13_25 = var12_18;
                        var28_17 = var23_10;
                    } else {
                        var15_27 = 0;
                        var14_26 = 0;
                        var10_11 = var12_18;
                        var12_18 = var8_8;
                        var25_6 = var21_3;
lbl289:
                        // 2 sources

                        if (var35_32.startsWith("#EXTINF")) {
                            var28_17 = DC.KJ(var35_32);
                            var21_3 = var25_6.add((BigDecimal)var28_17);
                            var20_30 = DC.Gc((BigDecimal)var28_17, 30);
                            var19_29 = DC.Gc((BigDecimal)var28_17, 25);
                            var18_28 = DC.Gc((BigDecimal)var28_17, 24);
                            if (!(var20_30 || var19_29 || var18_28)) {
                                var30_22.put(var33_23, var30_22.get(var33_23) + 1);
                            } else {
                                if (var20_30) {
                                    var30_22.put((Integer)var0, var30_22.get(var0) + 1);
                                }
                                if (var19_29) {
                                    var30_22.put((Integer)var23_10, var30_22.get(var23_10) + 1);
                                }
                                if (var18_28) {
                                    var30_22.put((Integer)var27_16, var30_22.get(var27_16) + 1);
                                }
                            }
                            var34_20.add(var35_32);
                            var11_7 = var14_26 + 1;
                            var9_9 = var15_27;
                            var8_8 = var12_18;
                            var13_25 = var10_11;
                            var28_17 = var23_10;
                        } else {
                            var29_31 = var0;
                            var9_9 = var15_27;
                            var11_7 = var14_26;
                            var21_3 = var25_6;
                            var0 = var29_31;
                            var8_8 = var12_18;
                            var13_25 = var10_11;
                            var28_17 = var23_10;
                            if (!var35_32.startsWith("#")) {
                                var34_20.add(var35_32);
                                var9_9 = var15_27 + 1;
                                var28_17 = var23_10;
                                var13_25 = var10_11;
                                var8_8 = var12_18;
                                var0 = var29_31;
                                var21_3 = var25_6;
                                var11_7 = var14_26;
                            }
                        }
                    }
                }
                var10_11 = var13_25;
                var23_10 = var28_17;
            }
            if (var32_19.isEmpty()) {
                var0 = new SN(var32_19, 0, 0);
            } else {
                var8_8 = DC.N(var31_21);
                var0 = new SN(var32_19, DC.N(var30_22), var8_8);
            }
            var21_3 = var0.yq;
            var16_24 = var0.SN;
            var17_33 = var0.N;
            var23_10 = System.out;
            var0 = new StringBuilder();
            var0.append(">>> Master FPS: ");
            var0.append(var16_24);
            var0.append(" | \u6807\u51c6\u5927\u5c0f: ");
            var0.append(var17_33);
            var23_10.println(var0.toString());
            var23_10 = new LinkedHashMap<K, V>();
            var0 = var21_3;
            for (var10_11 = 0; var10_11 < var0.size(); ++var10_11) {
                block106: {
                    block105: {
                        var25_6 = (yq)var0.get(var10_11);
                        var8_8 = var10_11 == var0.size() - 1 ? 1 : 0;
                        var21_3 = var25_6.yq.iterator();
                        var9_9 = 0;
                        var12_18 = 0;
                        var11_7 = 0;
                        while (var21_3.hasNext()) {
                            var27_16 = (String)var21_3.next();
                            if (var27_16.startsWith("#EXTINF")) {
                                var27_16 = DC.KJ((String)var27_16);
                                var20_30 = DC.Gc((BigDecimal)var27_16, 30);
                                var18_28 = DC.Gc((BigDecimal)var27_16, 25);
                                var19_29 = DC.Gc((BigDecimal)var27_16, 24);
                                if (var20_30 && var18_28) {
                                    var13_25 = var9_9;
                                    var14_26 = var12_18;
                                    var15_27 = var11_7;
                                } else if (var20_30 && var19_29) {
                                    var13_25 = var9_9;
                                    var14_26 = var12_18;
                                    var15_27 = var11_7;
                                } else if (var20_30) {
                                    var13_25 = var9_9 + 1;
                                    var14_26 = var12_18;
                                    var15_27 = var11_7;
                                } else if (var18_28) {
                                    var14_26 = var12_18 + 1;
                                    var13_25 = var9_9;
                                    var15_27 = var11_7;
                                } else {
                                    var13_25 = var9_9;
                                    var14_26 = var12_18;
                                    var15_27 = var11_7;
                                    if (var19_29) {
                                        var15_27 = var11_7 + 1;
                                        var13_25 = var9_9;
                                        var14_26 = var12_18;
                                    }
                                }
                            } else {
                                var15_27 = var11_7;
                                var14_26 = var12_18;
                                var13_25 = var9_9;
                            }
                            var9_9 = var13_25;
                            var12_18 = var14_26;
                            var11_7 = var15_27;
                        }
                        var9_9 = var16_24 != 30 && var9_9 > 0 ? 1 : 0;
                        var14_26 = var25_6.SN;
                        var13_25 = var14_26 != var17_33 && var14_26 % var17_33 != 0 && var14_26 < var17_33 * 2 ? 1 : 0;
                        var9_9 = var9_9 == 0 && var13_25 == 0 ? 0 : 1;
                        if (var8_8 != 0 || var14_26 >= 12) {
                            var9_9 = 0;
                        }
                        if (var16_24 == 25 && var12_18 > 0) break block105;
                        var8_8 = var9_9;
                        if (var16_24 != 24) break block106;
                        var8_8 = var9_9;
                        if (var11_7 <= 0) break block106;
                    }
                    var8_8 = 0;
                }
                var9_9 = var8_8;
                if (var16_24 == -1) {
                    var9_9 = var8_8;
                    if (var14_26 == var17_33) {
                        var9_9 = 0;
                    }
                }
                if (var9_9 == 0) continue;
                var23_10.put(var10_11, var25_6);
            }
            var0 = new ArrayList<K>(var23_10.keySet());
            var21_3 = new HashSet<E>();
            if (var0.size() >= 3) {
                var8_8 = 0;
                while (var8_8 <= var0.size() - 3) {
                    var11_7 = (Integer)var0.get(var8_8);
                    var9_9 = var8_8 + 1;
                    var10_11 = (Integer)var0.get(var9_9);
                    var8_8 = (Integer)var0.get(var8_8 + 2);
                    if (var10_11 == var11_7 + 1 && var8_8 == var10_11 + 1) {
                        var21_3.add(var11_7);
                    }
                    var8_8 = var9_9;
                }
            }
            var0 = new HashSet<E>();
            var23_10 = var23_10.entrySet().iterator();
            var8_8 = 0;
            block15: while (var23_10.hasNext()) {
                var25_6 = (Map.Entry)var23_10.next();
                if (var21_3.contains((int)((Integer)var25_6.getKey()))) continue;
                var9_9 = var8_8 + 1;
                var27_16 = ((yq)var25_6.getValue()).yq.iterator();
                while (true) {
                    var8_8 = var9_9;
                    if (!var27_16.hasNext()) continue block15;
                    var25_6 = var27_16.next();
                    if (var25_6.startsWith("#")) continue;
                    var0.add(var25_6);
                }
            }
            if (var8_8 > 0) {
                System.out.println(String.format("\u3010\u8bc6\u522b\u6210\u529f\u3011\u547d\u4e2d\u5e7f\u544a Block: %d", new Object[]{var8_8}));
            } else {
                var0 = new HashSet<E>();
            }
            var26_12 /* !! */ .addAll((Collection<Object>)var0);
        }
        var0 = var22_4;
        if (!var26_12 /* !! */ .isEmpty()) {
            var22_4 = System.out;
            var21_3 = oi_0.yq("\u68c0\u6d4b\u5230\u5e7f\u544a\u6bb5: ");
            var21_3.append(var26_12 /* !! */ .size());
            var22_4.println(var21_3.toString());
            System.out.println("----\u5e7f\u544a\u5730\u5740----");
            System.out.println(var26_12 /* !! */ );
            InitOrigin.show(String.format("\u5df2\u8fc7\u6ee4\u89c6\u9891\u4e2d\u5e7f\u544a(%s\u6761)", new Object[]{var26_12 /* !! */ .size()}));
        }
        var22_4 = new StringBuilder();
        var10_11 = 0;
        var9_9 = 0;
        for (var8_8 = 0; var8_8 < var24_5.length; ++var8_8) {
            block112: {
                block109: {
                    block111: {
                        block110: {
                            block107: {
                                block108: {
                                    var21_3 = var24_5[var8_8].trim();
                                    if (var21_3.isEmpty()) continue;
                                    if (!var21_3.startsWith("#EXT-X-DISCONTINUITY")) break block107;
                                    if (var10_11 == 0) break block108;
                                    var10_11 = 0;
                                    break block109;
                                }
                                var9_9 = 1;
                                continue;
                            }
                            if (!var21_3.startsWith("#EXTINF")) break block110;
                            var10_11 = var8_8 + 1;
                            if (var10_11 >= var24_5.length) ** GOTO lbl-1000
                            var18_28 = var19_29 = var26_12 /* !! */ .contains(var24_5[var10_11].trim());
                            if (var19_29) {
                                var8_8 = var10_11;
                                var18_28 = var19_29;
                            }
                            break block111;
                        }
                        if (var26_12 /* !! */ .contains(var21_3)) {
                            var18_28 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var18_28 = false;
                        }
                    }
                    if (!var18_28) break block112;
                    var10_11 = 1;
                }
                var9_9 = 0;
                continue;
            }
            if (var9_9 != 0) {
                var22_4.append("#EXT-X-DISCONTINUITY");
                var22_4.append((String)var0);
                var9_9 = 0;
            }
            var21_3 = var21_3.startsWith("#") == false ? DC.M(var1_1, (String)var21_3) : DC.G4((String)var21_3, var1_1);
            var22_4.append((String)var21_3);
            var22_4.append((String)var0);
            var10_11 = 0;
        }
        return var22_4.toString();
    }

    private static String G4(String charSequence, String string) {
        Matcher matcher = Pattern.compile("URI=\"(.*?)\"").matcher(charSequence);
        if (matcher.find()) {
            charSequence = oi_0.yq("URI=\"");
            ((StringBuilder)charSequence).append(DC.M(string, matcher.group(1)));
            ((StringBuilder)charSequence).append("\"");
            charSequence = matcher.replaceFirst(((StringBuilder)charSequence).toString());
        }
        return charSequence;
    }

    public static boolean Gc(BigDecimal bigDecimal, int n) {
        Map<Integer, Set<BigDecimal>> map;
        if (bigDecimal != null && ((HashMap)(map = N)).containsKey(n)) {
            bigDecimal = bigDecimal.remainder(BigDecimal.ONE).abs().stripTrailingZeros();
            return ((Set)((HashMap)map).get(n)).contains(bigDecimal);
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static BigDecimal KJ(String object) {
        int n;
        int n2;
        try {
            n2 = ((String)object).indexOf(58);
            n = ((String)object).indexOf(44, n2);
            if (n2 == -1) return BigDecimal.ZERO;
            if (n == -1) return BigDecimal.ZERO;
        }
        catch (Exception exception) {
            return BigDecimal.ZERO;
        }
        object = ((String)object).substring(n2 + 1, n).trim();
        BigDecimal bigDecimal = new BigDecimal((String)object);
        return bigDecimal.stripTrailingZeros();
    }

    public static String M(String string, String object) {
        Object object2 = string;
        if (string == null) {
            object2 = "";
        }
        string = object;
        if (object == null) {
            string = "";
        }
        try {
            object = new URI(((String)object2).trim());
            string = string.trim();
            object2 = new URI(string);
            if (!string.startsWith("http://") && !string.startsWith("https://")) {
                if (string.startsWith("://")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(((URI)object).getScheme());
                    stringBuilder.append(string);
                    object2 = new URI(stringBuilder.toString());
                    return ((URI)object2).toString();
                }
                if (string.startsWith("//")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(((URI)object).getScheme());
                    stringBuilder.append(":");
                    stringBuilder.append(string);
                    object2 = new URI(stringBuilder.toString());
                    return ((URI)object2).toString();
                }
                return ((URI)object).resolve(string).toString();
            }
            string = ((URI)object2).toString();
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private static int N(Map<Integer, Integer> object) {
        int n;
        block3: {
            Iterator<Object> iterator = object.values().iterator();
            int n2 = 0;
            n = 0;
            while (iterator.hasNext()) {
                n += iterator.next().intValue();
            }
            if (n < 15) {
                return object.keySet().iterator().next();
            }
            int n3 = -1;
            iterator = object.entrySet().iterator();
            n = 0;
            while (iterator.hasNext()) {
                object = (Map.Entry)iterator.next();
                int n4 = (Integer)object.getValue();
                if (n4 <= n3) continue;
                n = (Integer)object.getKey();
                n3 = n4;
            }
            if (n3 > 0) break block3;
            n = n2;
        }
        return n;
    }

    private static void SN(Set<BigDecimal> set, double d, int n) {
        BigDecimal bigDecimal = BigDecimal.valueOf(d);
        for (int i2 = 1; i2 <= n; ++i2) {
            BigDecimal bigDecimal2 = BigDecimal.valueOf(i2).divide(bigDecimal, 10, RoundingMode.HALF_UP).remainder(BigDecimal.ONE);
            for (int i4 = 3; i4 <= 6; ++i4) {
                BigDecimal bigDecimal3 = bigDecimal2.setScale(i4, RoundingMode.HALF_UP).stripTrailingZeros();
                if (bigDecimal3.compareTo(BigDecimal.ZERO) == 0) continue;
                set.add(bigDecimal3);
            }
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static String i(String object, Map map) {
        Object object2 = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = object2.followRedirects(false).build();
        for (int i2 = 0; i2 < 2; ++i2) {
            Response object32;
            object2 = new Request.Builder().url((String)object);
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    object2.addHeader((String)entry.getKey(), (String)entry.getValue());
                }
            }
            if ((object32 = okHttpClient.newCall(object2.build()).execute()).isRedirect()) {
                object2 = object32.header("Location");
                object32.close();
                if (object2 != null && !((String)object2).isEmpty()) {
                    object = object2;
                    continue;
                }
                return object;
            }
            object32.close();
            break;
        }
        return object;
    }

    public static String q(String string) {
        return DC.B(string, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static BigDecimal t0(String[] stringArray) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            String string = stringArray[n2];
            BigDecimal bigDecimal2 = bigDecimal;
            if (string.startsWith("#EXTINF")) {
                Matcher matcher = yq.matcher(string);
                bigDecimal2 = bigDecimal;
                if (matcher.find()) {
                    try {
                        bigDecimal2 = new BigDecimal(matcher.group(1));
                        bigDecimal2 = bigDecimal.add(bigDecimal2);
                    }
                    catch (Exception exception) {
                        bigDecimal2 = bigDecimal;
                    }
                }
            }
            ++n2;
            bigDecimal = bigDecimal2;
        }
        return bigDecimal;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     * Unable to fully structure code
     */
    public static String tF(String var0, HashMap var1_2) {
        block32: {
            if (var0 == null) break block32;
            try {
                new URL((String)var0);
                var2_3 = true;
                ** GOTO lbl10
            }
            catch (MalformedURLException var6_4) {
                ** continue;
            }
        }
lbl8:
        // 2 sources

        while (true) {
            block30: {
                block31: {
                    block33: {
                        block29: {
                            block28: {
                                var2_3 = false;
lbl10:
                                // 2 sources

                                var9_9 = "";
                                if (!var2_3) {
                                    System.out.println("\u8bf7\u68c0\u67e5url\u683c\u5f0f\u662f\u5426\u6b63\u786e");
                                    return "";
                                }
                                var6_5 = var0;
                                if (var0.contains("hmrvideo")) {
                                    try {
                                        var7_10 = new URI((String)var0);
                                        var6_5 = new URI(var7_10.getScheme(), var7_10.getUserInfo(), "686868-m3u8.hmrvideovip.com", var7_10.getPort(), var7_10.getPath(), var7_10.getQuery(), var7_10.getFragment());
                                        var6_5 = var6_5.toString();
                                    }
                                    catch (Exception var6_6) {
                                        SpiderDebug.log((String)"\u66ff\u6362\u5931\u8d25\u8fd4\u56de\u539f\u5730\u5740");
                                        var6_5 = var0;
                                    }
                                }
                                var5_11 = var6_5.contains(".m3u8");
                                if (var5_11) break block28;
                                var0 = var6_5;
                                ** GOTO lbl37
                            }
                            var0 = DC.i((String)var6_5, (Map)var1_2);
                            if (!TextUtils.isEmpty((CharSequence)var0)) break block29;
                            var0 = var6_5;
                        }
                        if (var0.contains(".m3u8")) break block33;
lbl37:
                        // 2 sources

                        System.out.println("\u975eM3U8,\u8fd4\u56de\u539f\u5730\u5740");
                        break block30;
                    }
                    var10_12 = Bo.B((String)var0, (Map)var1_2);
                    if (!var10_12.contains("#EXTM3U")) {
                        var1_2 = System.out;
                        var6_5 = new StringBuilder();
                        var6_5.append("m3u8\u5185\u5bb9\u83b7\u53d6\u5931\u8d251");
                        var6_5.append((String)var0);
lbl48:
                        // 2 sources

                        while (true) {
                            var6_5 = var6_5.toString();
                            ** GOTO lbl98
                            break;
                        }
                    } else {
                        if (!var10_12.contains("#EXT-X-MEDIA:TYPE=AUDIO")) break block31;
                        var1_2 = System.out;
                        var6_5 = "\u5305\u542b\u97f3\u8f68\u8fd4\u56de\u539f\u5730\u5740";
                    }
                    ** GOTO lbl98
                }
                var6_5 = System.out;
                var7_10 = new StringBuilder();
                var7_10.append("\u539f\u59cbm3u8_url:");
                var7_10.append((String)var0);
                var6_5.println(var7_10.toString());
                var7_10 = var10_12.trim().split("\n");
                var6_5 = var7_10[((Comparable<URI>)var7_10).length - 1];
                var8_13 = var6_5;
                if (var6_5.length() < 5) {
                    var8_13 = var7_10[((Comparable<URI>)var7_10).length - 2];
                }
                var6_5 = var10_12;
                var7_10 = var0;
                if (!var8_13.contains(".m3u8")) ** GOTO lbl100
                var6_5 = var10_12;
                var7_10 = var0;
                if (var8_13.equals(var0)) ** GOTO lbl100
                var0 = DC.M((String)var0, var8_13);
                var6_5 = System.out;
                var7_10 = new StringBuilder();
                var7_10.append("\u5d4c\u5957\u7684m3u8_url:");
                var7_10.append((String)var0);
                var6_5.println(var7_10.toString());
                var6_5 = var1_2 = Bo.B((String)var0, (Map)var1_2);
                var7_10 = var0;
                try {
                    block34: {
                        if (!var1_2.contains("#EXTM3U")) {
                            var1_2 = System.out;
                            var6_5 = new StringBuilder();
                            var6_5.append("m3u8\u5185\u5bb9\u83b7\u53d6\u5931\u8d252");
                            var6_5.append((String)var0);
                            ** continue;
                        }
                        break block34;
lbl98:
                        // 2 sources

                        var1_2.println((String)var6_5);
                        break block30;
                    }
                    var0 = new StringBuilder();
                    var0.append((String)var7_10);
                    var0.append("$$$");
                    var0.append((String)var6_5);
                    var0 = var0.toString();
                }
                catch (Exception var0_1) {
                    SpiderDebug.log((Throwable)var0_1);
                    var0 = "";
                }
            }
            if (!var0.contains("$$$")) {
                return var0;
            }
            var3_14 = System.currentTimeMillis();
            var6_5 = var0.split("\\$\\$\\$");
            var0 = TextUtils.isEmpty((CharSequence)var6_5[0]) == false ? var6_5[0] : "";
            var1_2 = var9_9;
            if (((String[])var6_5).length > 1) {
                var1_2 = var9_9;
                if (!TextUtils.isEmpty((CharSequence)var6_5[1])) {
                    var1_2 = var6_5[1];
                }
            }
            try {
                var6_5 = new Exception("\u89c4\u5219 JSON \u521d\u59cb\u5316\u5931\u8d25");
                throw var6_5;
            }
            catch (Exception var6_7) {
                System.out.println("\u5f02\u5e38\u4fe1\u606f\uff1a");
                System.out.println("\u9ed8\u8ba4\u5904\u7406\u65b9\u5f0f");
                var1_2 = DC.G((String)var1_2, (String)var0);
                var0 = System.out;
                var6_8 = oi_0.yq("\u5904\u7406\u8017\u65f6\uff1a");
                var6_8.append(System.currentTimeMillis() - var3_14);
                var6_8.append("ms");
                var0.println(var6_8.toString());
                return var1_2;
            }
            break;
        }
    }

    private static int yq(String string, String string2) {
        int n;
        for (n = 0; n < string.length() && n < string2.length() && string.charAt(n) == string2.charAt(n); ++n) {
        }
        return n;
    }

    private static int zH(double d) {
        if (d <= 30.0) {
            return 15;
        }
        if (d <= 60.0) {
            return 20;
        }
        if (d <= 90.0) {
            return 25;
        }
        return 30;
    }

    static final class SN {
        int N;
        int SN;
        List<yq> yq;

        SN(List<yq> list, int n, int n2, int n3, int n4) {
            this.yq = list;
            this.SN = n;
            this.N = n2;
        }
    }

    static final class yq {
        BigDecimal N;
        int SN;
        BigDecimal tF = BigDecimal.ZERO;
        List<String> yq;

        yq(List<String> list, int n, BigDecimal bigDecimal, int n2) {
            this.yq = list;
            this.SN = n;
            this.N = bigDecimal;
            if (n2 > 0) {
                this.tF = bigDecimal.divide(new BigDecimal(n2), 6, RoundingMode.HALF_UP).stripTrailingZeros();
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = oi_0.yq("BlockInfo{uriSize=");
            stringBuilder.append(this.SN);
            stringBuilder.append(", avgDuration=");
            stringBuilder.append(this.tF);
            stringBuilder.append(", totalDuration=");
            stringBuilder.append(this.N);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
}

