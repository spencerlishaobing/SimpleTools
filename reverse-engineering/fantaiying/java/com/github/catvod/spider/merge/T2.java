/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.io.IOException;
import java.util.Objects;

public final class T2 {
    private final String yq;

    private T2() {
        this.yq = ", ";
    }

    public static T2 SN() {
        return new T2();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final StringBuilder yq(StringBuilder var1_1, Iterable<? extends Object> var2_4) {
        block8: {
            var2_4 = var2_4.iterator();
            var3_5 = var1_1;
            try {
                block9: {
                    if (!var2_4.hasNext()) break block8;
                    var6_6 /* !! */  = var2_4.next();
                    Objects.requireNonNull(var6_6 /* !! */ );
                    if (!(var6_6 /* !! */  instanceof CharSequence)) break block9;
                    var4_7 = var1_1;
                    ** GOTO lbl38
                }
                var7_8 = var6_6 /* !! */ ;
                var5_9 = var2_4;
                var4_7 = var1_1;
            }
            catch (IOException var1_2) {
                var1_3 = new AssertionError((Object)var1_2);
                throw var1_3;
            }
            block6: while (true) {
                var6_6 /* !! */  = var7_8.toString();
                var2_4 = var4_7;
                var3_5 = var5_9;
                while (true) {
                    var1_1.append((CharSequence)var6_6 /* !! */ );
                    if (!var3_5.hasNext()) break block6;
                    var1_1.append((CharSequence)this.yq);
                    var6_6 /* !! */  = var3_5.next();
                    Objects.requireNonNull(var6_6 /* !! */ );
                    var5_9 = var3_5;
                    var7_8 = var6_6 /* !! */ ;
                    var4_7 = var2_4;
                    if (!(var6_6 /* !! */  instanceof CharSequence)) continue block6;
                    var4_7 = var2_4;
                    var2_4 = var3_5;
lbl38:
                    // 3 sources

                    var5_9 = (CharSequence)var6_6 /* !! */ ;
                    var3_5 = var2_4;
                    var6_6 /* !! */  = var5_9;
                    var2_4 = var4_7;
                    continue;
                    break;
                }
                break;
            }
            var3_5 = var2_4;
        }
        return var3_5;
    }
}

