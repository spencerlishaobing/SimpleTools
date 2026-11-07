/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Ei;
import com.github.catvod.spider.merge.HA;
import com.github.catvod.spider.merge.JN;
import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.Uf;
import com.github.catvod.spider.merge.Zk;
import com.github.catvod.spider.merge.f_0;
import com.github.catvod.spider.merge.fp_0;
import com.github.catvod.spider.merge.oU;
import com.github.catvod.spider.merge.rs_1;
import com.github.catvod.spider.merge.t_0;
import com.github.catvod.spider.merge.xN;
import com.github.catvod.spider.merge.zk_0;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public final class CT {
    private static final int[] yq = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /*
     * Ignored method signature, as it can't be verified against descriptor
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static JN N(String var0, int var1_3, Map var2_4) {
        block68: {
            var18_5 = xN.zH;
            var16_6 /* !! */  = zk_0.SN;
            var17_8 = var2_4.containsKey((Object)var16_6 /* !! */ ) != false ? var2_4.get((Object)var16_6 /* !! */ ).toString() : "ISO-8859-1";
            if (!"Shift_JIS".equals(var17_8)) ** GOTO lbl22
            try {
                var16_6 /* !! */  = (zk_0)var0.getBytes("Shift_JIS");
            }
            catch (UnsupportedEncodingException var16_7) {
                ** continue;
            }
            var4_9 = ((zk_0)var16_6 /* !! */ ).length;
            if (var4_9 % 2 != 0) break block68;
            for (var3_10 = 0; var3_10 < var4_9; var3_10 += 2) {
                var5_11 = var16_6 /* !! */ [var3_10] & 255;
                if (var5_11 >= 129 && var5_11 <= 159 || var5_11 >= 224 && var5_11 <= 235) {
                    continue;
                }
                break block68;
            }
            var3_10 = 1;
            ** GOTO lbl19
        }
lbl17:
        // 2 sources

        while (true) {
            block76: {
                block71: {
                    block72: {
                        block73: {
                            block74: {
                                block70: {
                                    block69: {
                                        var3_10 = 0;
lbl19:
                                        // 2 sources

                                        if (var3_10 == 0) break block69;
                                        var16_6 /* !! */  = xN.t0;
                                        break block70;
                                    }
                                    var4_9 = 0;
                                    var5_11 = 0;
                                    for (var3_10 = 0; var3_10 < var0.length(); ++var3_10) {
                                        var6_12 = var0.charAt(var3_10);
                                        if (var6_12 >= 48 && var6_12 <= 57) {
                                            var5_11 = 1;
                                            continue;
                                        }
                                        if (CT.tF(var6_12) != -1) {
                                            var4_9 = 1;
                                            continue;
                                        }
                                        ** GOTO lbl-1000
                                    }
                                    if (var4_9 != 0) {
                                        var16_6 /* !! */  = xN.tF;
                                    } else if (var5_11 != 0) {
                                        var16_6 /* !! */  = xN.N;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        var16_6 /* !! */  = var18_5;
                                    }
                                }
                                var19_13 = new f_0();
                                if (var16_6 /* !! */  == var18_5 && !"ISO-8859-1".equals(var17_8) && (var20_14 /* !! */  = Zk.yq((String)var17_8)) != null) {
                                    var19_13.N(xN.i.yq(), 4);
                                    var19_13.N(var20_14 /* !! */ .SN(), 8);
                                }
                                var19_13.N(var16_6 /* !! */ .yq(), 4);
                                var20_14 /* !! */  = new f_0();
                                var3_10 = var16_6 /* !! */ .ordinal();
                                if (var3_10 == 1) break block71;
                                if (var3_10 == 2) break block72;
                                if (var3_10 == 4) break block73;
                                if (var3_10 != 6) break block74;
                                try {
                                    var17_8 = var0.getBytes("Shift_JIS");
                                }
                                catch (UnsupportedEncodingException var0_1) {
                                    throw new Uf(var0_1);
                                }
                                var5_11 = ((String)var17_8).length;
                                for (var3_10 = 0; var3_10 < var5_11; var3_10 += 2) {
                                    block75: {
                                        var6_12 = (var17_8[var3_10] & 255) << 8 | var17_8[var3_10 + 1] & 255;
                                        if (var6_12 < 33088 || var6_12 > 40956) break block75;
                                        var4_9 = 33088;
                                        ** GOTO lbl64
                                    }
                                    if (var6_12 >= 57408 && var6_12 <= 60351) {
                                        var4_9 = 49472;
lbl64:
                                        // 2 sources

                                        var4_9 = var6_12 - var4_9;
                                    } else {
                                        var4_9 = -1;
                                    }
                                    if (var4_9 != -1) {
                                        var20_14 /* !! */ .N((var4_9 >> 8) * 192 + (var4_9 & 255), 13);
                                        continue;
                                    }
                                    throw new Uf("Invalid byte sequence");
                                }
                                break block76;
                            }
                            var0 = new StringBuilder("Invalid mode: ");
                            var0.append((Object)var16_6 /* !! */ );
                            throw new Uf(var0.toString());
                        }
                        try {
                            var17_8 = var0.getBytes((String)var17_8);
                        }
                        catch (UnsupportedEncodingException var0_2) {
                            throw new Uf(var0_2);
                        }
                        var4_9 = ((String)var17_8).length;
                        for (var3_10 = 0; var3_10 < var4_9; ++var3_10) {
                            var20_14 /* !! */ .N((int)var17_8[var3_10], 8);
                        }
                        break block76;
                    }
                    var5_11 = var0.length();
                    var3_10 = 0;
                    while (var3_10 < var5_11) {
                        var6_12 = CT.tF(var0.charAt(var3_10));
                        if (var6_12 != -1) {
                            var4_9 = var3_10 + 1;
                            if (var4_9 < var5_11) {
                                if ((var4_9 = CT.tF(var0.charAt(var4_9))) != -1) {
                                    var20_14 /* !! */ .N(var6_12 * 45 + var4_9, 11);
                                    var3_10 += 2;
                                    continue;
                                }
                                throw new Uf();
                            }
                            var20_14 /* !! */ .N(var6_12, 6);
                            var3_10 = var4_9;
                            continue;
                        }
                        throw new Uf();
                    }
                    break block76;
                }
                var5_11 = var0.length();
                var3_10 = 0;
                while (var3_10 < var5_11) {
                    var6_12 = var0.charAt(var3_10) - 48;
                    var4_9 = var3_10 + 2;
                    if (var4_9 < var5_11) {
                        var20_14 /* !! */ .N((var0.charAt(var3_10 + 1) - 48) * 10 + var6_12 * 100 + (var0.charAt(var4_9) - 48), 10);
                        var3_10 += 3;
                        continue;
                    }
                    if (++var3_10 < var5_11) {
                        var20_14 /* !! */ .N(var6_12 * 10 + (var0.charAt(var3_10) - 48), 7);
                        var3_10 = var4_9;
                        continue;
                    }
                    var20_14 /* !! */ .N(var6_12, 4);
                }
            }
            if (var2_4.containsKey(var17_8 = zk_0.q)) {
                if (!CT.zH(CT.yq((xN)var16_6 /* !! */ , (f_0)var19_13, (f_0)var20_14 /* !! */ , (HA)(var2_4 = HA.zH(Integer.parseInt(var2_4.get(var17_8).toString())))), (HA)var2_4, var1_3)) {
                    throw new Uf("Data too big for requested version");
                }
            } else {
                var2_4 = CT.SN(CT.yq((xN)var16_6 /* !! */ , (f_0)var19_13, (f_0)var20_14 /* !! */ , CT.SN(CT.yq((xN)var16_6 /* !! */ , (f_0)var19_13, (f_0)var20_14 /* !! */ , HA.zH(1)), var1_3)), var1_3);
            }
            var17_8 = new f_0();
            var17_8.SN((f_0)var19_13);
            var3_10 = var16_6 /* !! */  == var18_5 ? var20_14 /* !! */ .t0() : var0.length();
            var4_9 = var16_6 /* !! */ .SN((HA)var2_4);
            var5_11 = 1 << var4_9;
            if (var3_10 < var5_11) {
                var17_8.N(var3_10, var4_9);
                var17_8.SN((f_0)var20_14 /* !! */ );
                var0 = var2_4.N(var1_3);
                var14_15 = var2_4.tF() - var0.tF();
                var5_11 = var14_15 << 3;
                if (var17_8.i() <= var5_11) {
                    for (var3_10 = 0; var3_10 < 4 && var17_8.i() < var5_11; ++var3_10) {
                        var17_8.yq(false);
                    }
                    var3_10 = var17_8.i() & 7;
                    if (var3_10 > 0) {
                        while (var3_10 < 8) {
                            var17_8.yq(false);
                            ++var3_10;
                        }
                    }
                    var6_12 = var17_8.t0();
                    for (var3_10 = 0; var3_10 < var14_15 - var6_12; ++var3_10) {
                        var4_9 = (var3_10 & 1) == 0 ? 236 : 17;
                        var17_8.N(var4_9, 8);
                    }
                    if (var17_8.i() == var5_11) {
                        var3_10 = var2_4.tF();
                        var4_9 = var0.N();
                        if (var17_8.t0() == var14_15) {
                            var0 = new ArrayList<E>(var4_9);
                            var7_17 = 0;
                            var6_12 = 0;
                            var5_11 = 0;
                            for (var8_16 = 0; var8_16 < var4_9; ++var8_16) {
                                var18_5 = new int[1];
                                var20_14 /* !! */  = (Zk)new int[1];
                                if (var8_16 < var4_9) {
                                    var13_22 = var3_10 % var4_9;
                                    var10_19 /* !! */  = var4_9 - var13_22;
                                    var15_23 /* !! */  = var3_10 / var4_9;
                                    var12_21 = var14_15 / var4_9;
                                    var11_20 = var15_23 /* !! */  - var12_21;
                                    var9_18 = var12_21 + 1;
                                    if (var11_20 == (var15_23 /* !! */  = var15_23 /* !! */  + 1 - var9_18)) {
                                        if (var4_9 == var10_19 /* !! */  + var13_22) {
                                            if (var3_10 == (var9_18 + var15_23 /* !! */ ) * var13_22 + (var12_21 + var11_20) * var10_19 /* !! */ ) {
                                                if (var8_16 < var10_19 /* !! */ ) {
                                                    var18_5[0] = var12_21;
                                                    var20_14 /* !! */ [0] = (Zk)var11_20;
                                                } else {
                                                    var18_5[0] = var9_18;
                                                    var20_14 /* !! */ [0] = (Zk)var15_23 /* !! */ ;
                                                }
                                                var15_23 /* !! */  = (int)var18_5[0];
                                                var19_13 = new byte[var15_23 /* !! */ ];
                                                var10_19 /* !! */  = var7_17 << 3;
                                                for (var9_18 = 0; var9_18 < var15_23 /* !! */ ; ++var9_18) {
                                                    var13_22 = 0;
                                                    for (var11_20 = 0; var11_20 < 8; ++var11_20) {
                                                        var12_21 = var13_22;
                                                        if (var17_8.zH(var10_19 /* !! */ )) {
                                                            var12_21 = var13_22 | 1 << 7 - var11_20;
                                                        }
                                                        ++var10_19 /* !! */ ;
                                                        var13_22 = var12_21;
                                                    }
                                                    var19_13[var9_18 + 0] = (byte)var13_22;
                                                }
                                                var10_19 /* !! */  = (int)var20_14 /* !! */ [0];
                                                var20_14 /* !! */  = (Zk)new int[var15_23 /* !! */  + var10_19 /* !! */ ];
                                                for (var9_18 = 0; var9_18 < var15_23 /* !! */ ; ++var9_18) {
                                                    var20_14 /* !! */ [var9_18] = (Zk)(var19_13[var9_18] & 255);
                                                }
                                                new oU(Ei.q).yq((int[])var20_14 /* !! */ , var10_19 /* !! */ );
                                                var21_24 = new byte[var10_19 /* !! */ ];
                                                for (var9_18 = 0; var9_18 < var10_19 /* !! */ ; ++var9_18) {
                                                    var21_24[var9_18] = (byte)var20_14 /* !! */ [var15_23 /* !! */  + var9_18];
                                                }
                                                var0.add(new fp_0((byte[])var19_13, var21_24));
                                                var6_12 = Math.max(var6_12, var15_23 /* !! */ );
                                                var5_11 = Math.max(var5_11, var10_19 /* !! */ );
                                                var7_17 += var18_5[0];
                                                continue;
                                            }
                                            throw new Uf("Total bytes mismatch");
                                        }
                                        throw new Uf("RS blocks mismatch");
                                    }
                                    throw new Uf("EC bytes mismatch");
                                }
                                throw new Uf("Block ID too large");
                            }
                            if (var14_15 == var7_17) {
                                var17_8 = new f_0();
                                for (var4_9 = 0; var4_9 < var6_12; ++var4_9) {
                                    var18_5 = var0.iterator();
                                    while (var18_5.hasNext()) {
                                        var19_13 = ((fp_0)var18_5.next()).yq();
                                        if (var4_9 >= ((Object)var19_13).length) continue;
                                        var17_8.N((int)var19_13[var4_9], 8);
                                    }
                                }
                                for (var4_9 = 0; var4_9 < var5_11; ++var4_9) {
                                    var18_5 = var0.iterator();
                                    while (var18_5.hasNext()) {
                                        var19_13 = ((fp_0)var18_5.next()).SN();
                                        if (var4_9 >= ((Object)var19_13).length) continue;
                                        var17_8.N((int)var19_13[var4_9], 8);
                                    }
                                }
                                if (var3_10 == var17_8.t0()) {
                                    var18_5 = new JN();
                                    var18_5.SN(var1_3);
                                    var18_5.zH((xN)var16_6 /* !! */ );
                                    var18_5.i((HA)var2_4);
                                    var3_10 = var2_4.SN();
                                    var16_6 /* !! */  = new t_0(var3_10, var3_10);
                                    var5_11 = 0x7FFFFFFF;
                                    var6_12 = -1;
                                    for (var3_10 = 0; var3_10 < 8; ++var3_10) {
                                        rs_1.zH((f_0)var17_8, var1_3, (HA)var2_4, var3_10, (t_0)var16_6 /* !! */ );
                                        var12_21 = U7.yq((t_0)var16_6 /* !! */ );
                                        var19_13 = var16_6 /* !! */ .N();
                                        var8_16 = var16_6 /* !! */ .zH();
                                        var13_22 = var16_6 /* !! */ .tF();
                                        var7_17 = 0;
                                        for (var4_9 = 0; var4_9 < var13_22 - 1; ++var4_9) {
                                            var10_19 /* !! */  = 0;
                                            while (var10_19 /* !! */  < var8_16 - 1) {
                                                var15_23 /* !! */  = (int)var19_13[var4_9][var10_19 /* !! */ ];
                                                var0 = var19_13[var4_9];
                                                var11_20 = var10_19 /* !! */  + 1;
                                                var9_18 = var7_17;
                                                if (var15_23 /* !! */  == var0[var11_20]) {
                                                    var14_15 = var4_9 + 1;
                                                    var9_18 = var7_17;
                                                    if (var15_23 /* !! */  == var19_13[var14_15][var10_19 /* !! */ ]) {
                                                        var9_18 = var7_17;
                                                        if (var15_23 /* !! */  == var19_13[var14_15][var11_20]) {
                                                            var9_18 = var7_17 + 1;
                                                        }
                                                    }
                                                }
                                                var10_19 /* !! */  = var11_20;
                                                var7_17 = var9_18;
                                            }
                                        }
                                        var13_22 = U7.N((t_0)var16_6 /* !! */ );
                                        var0 = var16_6 /* !! */ .N();
                                        var9_18 = var16_6 /* !! */ .zH();
                                        var14_15 = var16_6 /* !! */ .tF();
                                        var4_9 = 0;
                                        for (var8_16 = 0; var8_16 < var14_15; ++var8_16) {
                                            var19_13 = var0[var8_16];
                                            for (var11_20 = 0; var11_20 < var9_18; ++var11_20) {
                                                var10_19 /* !! */  = var4_9;
                                                if (var19_13[var11_20] == true) {
                                                    var10_19 /* !! */  = var4_9 + 1;
                                                }
                                                var4_9 = var10_19 /* !! */ ;
                                            }
                                        }
                                        var8_16 = var16_6 /* !! */ .tF();
                                        var8_16 = var16_6 /* !! */ .zH() * var8_16;
                                        var7_17 = Math.abs((var4_9 << 1) - var8_16) * 10 / var8_16 * 10 + (var7_17 * 3 + var12_21 + var13_22);
                                        var4_9 = var5_11;
                                        if (var7_17 < var5_11) {
                                            var4_9 = var7_17;
                                            var6_12 = var3_10;
                                        }
                                        var5_11 = var4_9;
                                    }
                                    var18_5.N(var6_12);
                                    rs_1.zH((f_0)var17_8, var1_3, (HA)var2_4, var6_12, (t_0)var16_6 /* !! */ );
                                    var18_5.tF((t_0)var16_6 /* !! */ );
                                    return var18_5;
                                }
                                var0 = new StringBuilder("Interleaving error: ");
                                var0.append(var3_10);
                                var0.append(" and ");
                                var0.append(var17_8.t0());
                                var0.append(" differ.");
                                throw new Uf(var0.toString());
                            }
                            throw new Uf("Data bytes does not match offset");
                        }
                        throw new Uf("Number of bits and data bytes does not match");
                    }
                    throw new Uf("Bits size does not equal capacity");
                }
                var0 = new StringBuilder("data bits cannot fit in the QR Code");
                var0.append(var17_8.i());
                var0.append(" > ");
                var0.append(var5_11);
                throw new Uf(var0.toString());
            }
            var0 = new StringBuilder();
            var0.append(var3_10);
            var0.append(" is bigger than ");
            var0.append(var5_11 - 1);
            var0 = new Uf(var0.toString());
            throw var0;
        }
    }

    private static HA SN(int n, int n2) {
        Object object;
        for (int i2 = 1; i2 <= 40; ++i2) {
            object = HA.zH(i2);
            if (!CT.zH(n, (HA)object, n2)) continue;
            return object;
        }
        object = new Uf("Data too big");
        throw object;
    }

    static int tF(int n) {
        int[] nArray = yq;
        if (n < 96) {
            return nArray[n];
        }
        return -1;
    }

    private static int yq(xN xN2, f_0 f_02, f_0 f_03, HA hA) {
        int n = f_02.i();
        int n2 = xN2.SN(hA);
        return f_03.i() + (n2 + n);
    }

    private static boolean zH(int n, HA hA, int n2) {
        return hA.tF() - hA.N(n2).tF() >= (n + 7) / 8;
    }
}

