/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider;

import com.github.catvod.spider.Pan;
import java.util.Arrays;
import java.util.concurrent.Callable;

public final class N
implements Callable {
    public final String N;
    public final String SN;
    public final Pan yq;

    public /* synthetic */ N(Pan pan, String string, String string2) {
        this.yq = pan;
        this.SN = string;
        this.N = string2;
    }

    /*
     * Unable to fully structure code
     */
    public final Object call() {
        var9_1 = this.yq;
        var10_2 = this.SN;
        var11_3 = this.N;
        var1_4 = var9_1.isQuark(var10_2);
        var7_5 = "";
        var2_6 = null;
        var3_10 = null;
        if (!var1_4) ** GOTO lbl-1000
        try {
            var3_10 = var2_6 = var9_1.yq.detailVideo(Arrays.asList(new String[]{var10_2.replace("q-:", "https://pan.quark.cn/s/")}), var11_3);
        }
        catch (Exception var2_7) {
            var2_7.printStackTrace();
        }
        var2_6 = var3_10;
        if (var3_10 == null) ** GOTO lbl-1000
        var2_6 = var3_10;
        if (!var3_10.tF().startsWith("$$$")) {
            var7_5 = var3_10.N();
            var6_12 = var3_10.tF();
            var4_13 = var3_10.yq();
        } else lbl-1000:
        // 3 sources

        {
            var6_12 = "";
            var4_13 = "";
            var3_10 = var2_6;
        }
        var8_14 = var6_12;
        var5_15 = var7_5;
        var2_6 = var3_10;
        if (var9_1.isBd(var10_2)) {
            try {
                var3_10 = var2_6 = var9_1.tF.detailVideo(Arrays.asList(new String[]{var10_2.replace("bd-:", "https://pan.baidu.com/s/")}));
            }
            catch (Exception var2_8) {
                var2_8.printStackTrace();
            }
            var8_14 = var6_12;
            var5_15 = var7_5;
            var2_6 = var3_10;
            if (var3_10 != null) {
                var8_14 = var6_12;
                var5_15 = var7_5;
                var2_6 = var3_10;
                if (!var3_10.tF().startsWith("$$$")) {
                    var5_15 = var3_10.N();
                    var8_14 = var3_10.tF();
                    var2_6 = var3_10;
                }
            }
        }
        var7_5 = var8_14;
        var6_12 = var5_15;
        var3_10 = var2_6;
        if (var9_1.isAli(var10_2)) {
            try {
                var2_6 = var3_10 = var9_1.SN.detailVideo(Arrays.asList(new String[]{var10_2.replace("a-:", "https://www.alipan.com/s/")}), var11_3);
            }
            catch (Exception var3_11) {
                var3_11.printStackTrace();
            }
            var7_5 = var8_14;
            var6_12 = var5_15;
            var3_10 = var2_6;
            if (var2_6 != null) {
                var7_5 = var8_14;
                var6_12 = var5_15;
                var3_10 = var2_6;
                if (!var2_6.tF().startsWith("$$$")) {
                    var6_12 = var2_6.N();
                    var7_5 = var2_6.tF();
                    var3_10 = var2_6;
                }
            }
        }
        var8_14 = var7_5;
        var5_15 = var6_12;
        var2_6 = var4_13;
        if (var9_1.isUc(var10_2)) {
            try {
                var3_10 = var2_6 = var9_1.N.detailVideo(Arrays.asList(new String[]{var10_2.replace("u-:", "https://drive.uc.cn/s/")}), var11_3);
            }
            catch (Exception var2_9) {
                var2_9.printStackTrace();
            }
            var8_14 = var7_5;
            var5_15 = var6_12;
            var2_6 = var4_13;
            if (var3_10 != null) {
                var8_14 = var7_5;
                var5_15 = var6_12;
                var2_6 = var4_13;
                if (!var3_10.tF().startsWith("$$$")) {
                    var5_15 = var3_10.N();
                    var8_14 = var3_10.tF();
                    var2_6 = var3_10.yq();
                }
            }
        }
        return new Pan.VodResult(var9_1, var5_15, var8_14, (String)var2_6);
    }
}

