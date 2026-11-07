/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.qk;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;

/*
 * Renamed from com.github.catvod.spider.merge.tM
 */
@Deprecated
public final class tm_0
extends qk {
    private final EnumSet<yq> SN;

    public tm_0(yq ... object) {
        object = ((yq[])object).length > 0 ? Arrays.asList(object) : Collections.singletonList(com.github.catvod.spider.merge.tM$yq.yq);
        this.SN = EnumSet.copyOf(object);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public final int yq(CharSequence var1_1, int var2_3, Writer var3_4) {
        block11: {
            block10: {
                var4_5 = var1_1.length();
                if (var1_1.charAt(var2_3) != '&' || var2_3 >= var4_5 - 2 || var1_1.charAt(var2_3 + 1) != '#') break block11;
                var5_6 = var1_1.charAt(var2_3 += 2);
                if (var5_6 != 'x' && var5_6 != 'X') {
                    var5_6 = '\u0000';
                } else {
                    if (++var2_3 == var4_5) {
                        return 0;
                    }
                    var5_6 = '\u0001';
                }
                for (var6_7 = var2_3; var6_7 < var4_5 && (var1_1.charAt(var6_7) >= '0' && var1_1.charAt(var6_7) <= '9' || var1_1.charAt(var6_7) >= 'a' && var1_1.charAt(var6_7) <= 'f' || var1_1.charAt(var6_7) >= 'A' && var1_1.charAt(var6_7) <= 'F'); ++var6_7) {
                }
                var7_8 = var6_7 != var4_5 && var1_1.charAt(var6_7) == ';' ? 1 : 0;
                if (var7_8 == 0) {
                    var10_9 = com.github.catvod.spider.merge.tM$yq.yq;
                    var9_10 = this.SN;
                    var4_5 = var9_10 != null && var9_10.contains((Object)var10_9) != false ? 1 : 0;
                    if (var4_5 != 0) {
                        return 0;
                    }
                    var10_9 = com.github.catvod.spider.merge.tM$yq.SN;
                    var9_10 = this.SN;
                    var4_5 = var9_10 != null && var9_10.contains((Object)var10_9) != false ? 1 : 0;
                    if (var4_5 != 0) {
                        throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
                    }
                }
                if (var5_6 == '\u0000') ** GOTO lbl28
                try {
                    block12: {
                        var4_5 = Integer.parseInt(var1_1.subSequence(var2_3, var6_7).toString(), 16);
                        break block12;
lbl28:
                        // 1 sources

                        var4_5 = Integer.parseInt(var1_1.subSequence(var2_3, var6_7).toString(), 10);
                    }
                    var8_11 /* !! */  = var4_5;
                    if (var4_5 <= 65535) break block10;
                }
                catch (NumberFormatException var1_2) {
                    ** continue;
                }
                var1_1 = Character.toChars(var4_5);
                var3_4.write((int)var1_1[0]);
                var8_11 /* !! */  = (int)var1_1[1];
            }
            var3_4.write(var8_11 /* !! */ );
            return var6_7 + 2 - var2_3 + var5_6 + var7_8;
        }
lbl39:
        // 2 sources

        return 0;
    }

    public static final class yq
    extends Enum<yq> {
        private static final yq[] N;
        public static final /* enum */ yq SN;
        public static final /* enum */ yq yq;

        static {
            yq yq2;
            yq yq3;
            yq = yq3 = new yq();
            yq yq4 = new yq();
            SN = yq2 = new yq();
            N = new yq[]{yq3, yq4, yq2};
        }

        public static yq valueOf(String string) {
            return Enum.valueOf(yq.class, string);
        }

        public static yq[] values() {
            return (yq[])N.clone();
        }
    }
}

