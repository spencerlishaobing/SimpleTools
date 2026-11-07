/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.gson.Gson
 *  com.google.gson.JsonElement
 *  com.google.gson.annotations.SerializedName
 *  com.google.gson.reflect.TypeToken
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.github.catvod.spider.merge.Am;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.LP;
import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.oi_0;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public final class My {
    @SerializedName(value="data")
    private LP N;
    @SerializedName(value="message")
    private String SN;
    @SerializedName(value="code")
    private Integer yq;

    public static My SN(String string) {
        return (My)Z.yq(string, My.class);
    }

    public final LP yq() {
        LP lP;
        LP lP2 = lP = this.N;
        if (lP == null) {
            lP2 = new LP();
        }
        return lP2;
    }

    public static final class yq {
        @SerializedName(value="title")
        private String N;
        @SerializedName(value="aid")
        private String SN;
        @SerializedName(value="length")
        private String i;
        @SerializedName(value="pic")
        private String tF;
        @SerializedName(value="bvid")
        private String yq;
        @SerializedName(value="duration")
        private String zH;

        public static List<yq> yq(JsonElement jsonElement) {
            Type type = new TypeToken<List<yq>>(){}.getType();
            return (List)new Gson().fromJson(jsonElement, type);
        }

        public final String N() {
            String string = TextUtils.isEmpty((CharSequence)this.N) ? "" : this.N;
            return string;
        }

        public final String SN() {
            String string = TextUtils.isEmpty((CharSequence)this.tF) ? "" : this.tF;
            return string;
        }

        /*
         * Unable to fully structure code
         */
        public final Ef tF() {
            block5: {
                block6: {
                    block4: {
                        var4_1 = new Ef();
                        var5_2 = new StringBuilder();
                        var1_3 = TextUtils.isEmpty((CharSequence)this.yq);
                        var3_4 = "";
                        var2_5 = var1_3 != false ? "" : this.yq;
                        var5_2.append((String)var2_5);
                        var5_2.append("@");
                        var2_5 = TextUtils.isEmpty((CharSequence)this.SN) != false ? "" : this.SN;
                        var5_2.append((String)var2_5);
                        var4_1.G(var5_2.toString());
                        var2_5 = TextUtils.isEmpty((CharSequence)this.N) != false ? "" : this.N;
                        var4_1.G4(Am.yq((String)var2_5).Fo());
                        if (this.SN().startsWith("//")) {
                            var2_5 = oi_0.yq("https:");
                            var2_5.append(this.SN());
                            var2_5 = var2_5.toString();
                        } else {
                            var2_5 = this.SN();
                        }
                        var4_1.dT((String)var2_5);
                        if (!TextUtils.isEmpty((CharSequence)this.zH)) break block4;
                        var2_5 = TextUtils.isEmpty((CharSequence)this.i) ? var3_4 : this.i;
                        break block5;
                    }
                    if (!this.zH.contains(":")) break block6;
                    var2_5 = new StringBuilder();
                    var2_5.append(this.zH.split(":")[0]);
                    ** GOTO lbl43
                }
                if (Integer.parseInt(this.zH) < 60) {
                    var2_5 = new StringBuilder();
                    var2_5.append(this.zH);
                    var3_4 = "\u79d2";
                } else {
                    var2_5 = new StringBuilder();
                    var2_5.append(Integer.parseInt(this.zH) / 60);
lbl43:
                    // 2 sources

                    var3_4 = "\u5206\u9418";
                }
                var2_5.append(var3_4);
                var2_5 = var2_5.toString();
            }
            var4_1.W((String)var2_5);
            return var4_1;
        }
    }
}

