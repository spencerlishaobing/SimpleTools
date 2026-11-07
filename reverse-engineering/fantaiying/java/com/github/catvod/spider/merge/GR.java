/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.DL;
import com.github.catvod.spider.merge.TO;
import com.github.catvod.spider.merge.vd_1;

class GR
extends DL {
    public static final int tF(CharSequence charSequence, String string, int n2, boolean bl) {
        n2 = !bl && charSequence instanceof String ? ((String)charSequence).indexOf(string, n2) : GR.zH(charSequence, string, n2, charSequence.length(), bl);
        return n2;
    }

    /*
     * Unable to fully structure code
     */
    static int zH(CharSequence var0, CharSequence var1_1, int var2_2, int var3_3, boolean var4_4) {
        block16: {
            block22: {
                block21: {
                    block18: {
                        block20: {
                            block19: {
                                var6_5 = -1;
                                var5_6 = var2_2;
                                if (var2_2 < 0) {
                                    var5_6 = 0;
                                }
                                var7_7 = var0.length();
                                var2_2 = var3_3;
                                if (var3_3 > var7_7) {
                                    var2_2 = var7_7;
                                }
                                var10_8 = new vd_1(var5_6, var2_2);
                                if (!(var0 instanceof String) || !(var1_1 instanceof String)) break block18;
                                var5_6 = var10_8.yq();
                                var8_9 = var10_8.SN();
                                var7_7 = var10_8.N();
                                if (var7_7 <= 0) break block19;
                                var2_2 = var5_6;
                                if (var5_6 <= var8_9) break block20;
                            }
                            var3_3 = var6_5;
                            if (var7_7 >= 0) break block16;
                            var3_3 = var6_5;
                            if (var8_9 > var5_6) break block16;
                            var2_2 = var5_6;
                        }
                        while (true) {
                            var10_8 = (String)var1_1;
                            var11_12 = (String)var0;
                            var3_3 = var1_1.length();
                            var9_11 = var4_4 == false ? var10_8.regionMatches(0, var11_12, var2_2, var3_3) : var10_8.regionMatches(var4_4, 0, var11_12, var2_2, var3_3);
                            if (!var9_11) {
                                var3_3 = var6_5;
                                if (var2_2 != var8_9) {
                                    var2_2 += var7_7;
                                    continue;
                                }
                                break block16;
                            }
                            ** GOTO lbl62
                            break;
                        }
                    }
                    var5_6 = var10_8.yq();
                    var7_7 = var10_8.SN();
                    var8_10 = var10_8.N();
                    if (var8_10 <= 0) break block21;
                    var2_2 = var5_6;
                    if (var5_6 <= var7_7) break block22;
                }
                var3_3 = var6_5;
                if (var8_10 >= 0) break block16;
                var3_3 = var6_5;
                if (var7_7 > var5_6) break block16;
                var2_2 = var5_6;
            }
            while (true) {
                block23: {
                    var5_6 = var1_1.length();
                    if (var2_2 >= 0 && var1_1.length() - var5_6 >= 0 && var2_2 <= var0.length() - var5_6) {
                        for (var3_3 = 0; var3_3 < var5_6; ++var3_3) {
                            if (TO.N(var1_1.charAt(0 + var3_3), var0.charAt(var2_2 + var3_3), var4_4)) {
                                continue;
                            }
                            ** break block17
                        }
                        var3_3 = 1;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var3_3 = 0;
                    }
                    if (var3_3 == 0) break block23;
lbl62:
                    // 2 sources

                    var3_3 = var2_2;
                    break;
                }
                var3_3 = var6_5;
                if (var2_2 == var7_7) break;
                var2_2 += var8_10;
            }
        }
        return var3_3;
    }
}

