/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.thegrizzlylabs.sardineandroid.DavResource
 */
package com.github.catvod.spider.merge;

import com.thegrizzlylabs.sardineandroid.DavResource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public final class of
implements Comparator<DavResource> {
    private final String SN;
    private final String yq;

    public of(String string, String string2) {
        this.yq = string;
        this.SN = string2;
    }

    public static void yq(String string, String string2, List<DavResource> list) {
        Collections.sort(list, new of(string, string2));
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public final int compare(Object var1_1, Object var2_2) {
        block12: {
            block10: {
                block11: {
                    var1_1 = (DavResource)var1_1;
                    var2_2 = (DavResource)var2_2;
                    var7_3 = this.SN.equals("asc");
                    var8_4 = this.yq;
                    Objects.requireNonNull(var8_4);
                    var3_5 = var8_4.hashCode();
                    var4_6 = -1;
                    if (var3_5 == 3076014) break block10;
                    if (var3_5 == 3373707) break block11;
                    if (var3_5 != 3530753 || !var8_4.equals("size")) ** GOTO lbl-1000
                    var3_5 = 2;
                    break block12;
                }
                if (!var8_4.equals("name")) ** GOTO lbl-1000
                var3_5 = 1;
                break block12;
            }
            if (!var8_4.equals("date")) lbl-1000:
            // 3 sources

            {
                var3_5 = -1;
            } else {
                var3_5 = 0;
            }
        }
        if (var3_5 != 0) {
            if (var3_5 != 1) {
                if (var3_5 != 2) {
                    var3_5 = var4_6;
                } else {
                    if (var7_3) {
                        var5_7 = var1_1.getContentLength();
                        var1_1 = var2_2.getContentLength();
                    } else {
                        var5_7 = var2_2.getContentLength();
                        var1_1 = var1_1.getContentLength();
                    }
                    var3_5 = Long.compare(var5_7, var1_1.longValue());
                }
            } else {
                var3_5 = var7_3 ? var1_1.getName().compareTo(var2_2.getName()) : var2_2.getName().compareTo(var1_1.getName());
            }
        } else {
            var3_5 = var7_3 ? var1_1.getModified().compareTo(var2_2.getModified()) : var2_2.getModified().compareTo(var1_1.getModified());
        }
        return var3_5;
    }
}

