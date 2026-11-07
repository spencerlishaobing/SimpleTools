/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.gson.Gson
 *  com.google.gson.annotations.SerializedName
 *  com.google.gson.reflect.TypeToken
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.github.catvod.spider.merge.Am;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.oi_0;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class H7 {
    @SerializedName(value="pg")
    private String B;
    @SerializedName(value="obj_category")
    private String F5;
    @SerializedName(value="file_type")
    private String G;
    @SerializedName(value="big_thumbnail")
    private String G4;
    @SerializedName(value="vodName")
    private String Gc;
    @SerializedName(value="shareUser")
    private String KJ;
    @SerializedName(value="sId")
    private String M;
    @SerializedName(value="sub")
    private String N;
    @SerializedName(value="flag")
    private String SN;
    @SerializedName(value="parent")
    private String W;
    @SerializedName(value="category")
    private int dT;
    @SerializedName(value="size")
    private long i;
    @SerializedName(value="sToken")
    private String q;
    @SerializedName(value="file_name")
    private String t0;
    @SerializedName(value="fid")
    private String tF;
    @SerializedName(value="pdir_fid")
    private String v3;
    @SerializedName(value="list")
    private List<H7> yq;
    @SerializedName(value="share_fid_token")
    private String zH;

    public static String SN(Object object) {
        return new Gson().toJson(object);
    }

    public static H7 g1(String string) {
        return (H7)Z.yq(string, H7.class);
    }

    public static List<H7> yq(String string) {
        Type type = new TypeToken<List<H7>>(){}.getType();
        return (List)new Gson().fromJson(string, type);
    }

    public final String B() {
        String string = TextUtils.isEmpty((CharSequence)this.B) ? "" : this.B;
        return string;
    }

    public final void Dr(String string) {
        this.B = string;
    }

    public final void E1(String string) {
        this.Gc = string;
    }

    public final String F5() {
        CharSequence charSequence;
        if (this.i < 500L) {
            charSequence = "";
        } else {
            charSequence = oi_0.yq("[");
            ((StringBuilder)charSequence).append(ME.v3(this.i));
            ((StringBuilder)charSequence).append("]");
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public final void Fz(String string) {
        this.KJ = string;
    }

    public final String G(String charSequence) {
        if (this.OW()) {
            return charSequence;
        }
        if (TextUtils.isEmpty((CharSequence)this.G4)) {
            charSequence = "";
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(this.G4);
            ((StringBuilder)charSequence).append("@Referer=https://drive.uc.cn/@User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36@Cookie=");
            int n2 = i3.H;
            ((StringBuilder)charSequence).append(i3.tF.yq.Gc);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public final String G4() {
        String string = TextUtils.isEmpty((CharSequence)this.zH) ? "" : this.zH;
        return string;
    }

    public final String Gc() {
        boolean bl = ME.ee(this.t0);
        String string = "";
        if (!bl) {
            string = Am.yq(this.t0).Fo().replace("#", "").replace("@", "").replace("&", "").replace("+", "").trim();
        }
        return string;
    }

    public final Ef Gd(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.F5());
        stringBuilder.append("");
        stringBuilder.append(this.Gc());
        return new Ef(string, stringBuilder.toString().trim(), this.G(string2), string3, this.OW());
    }

    public final void H(String string) {
        this.q = string;
    }

    public final String KJ() {
        String string = ME.ee(this.W) ? "" : k_0.i(oi_0.yq("["), this.W, "]");
        return string;
    }

    public final String M() {
        String string = TextUtils.isEmpty((CharSequence)this.F5) ? "" : this.F5;
        return string;
    }

    public final String N(String string) {
        string = this.KJ().replaceAll("\\d+\u96c6", "").replace(string, "").replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", "");
        return TextUtils.join((CharSequence)" ", Arrays.asList(this.F5(), string, this.Gc())).trim();
    }

    public final String Nl() {
        String string = ME.ee(this.t0) ? "" : this.Gc;
        return string;
    }

    public final boolean O() {
        boolean bl = this.M().equals("video") || this.M().equals("audio") || this.Gc().contains(".iso") || this.Gc().contains(".ts");
        return bl;
    }

    public final boolean OW() {
        boolean bl = this.dT == 0;
        return bl;
    }

    public final void U(String string) {
        this.N = string;
    }

    public final String W() {
        String string = TextUtils.isEmpty((CharSequence)this.q) ? "" : this.q;
        return string;
    }

    public final void Zm() {
        this.t0 = "\u6700\u8fd1\u4fdd\u5b58";
    }

    public final void b(String string) {
        this.SN = string;
    }

    public final String dT() {
        String string = ME.ee(this.M) ? "" : this.M;
        return string;
    }

    public final String ee() {
        String string = ME.ee(this.KJ) ? "" : this.KJ;
        return string;
    }

    public final void g(String string) {
        this.M = string;
    }

    public final String g9() {
        String string = TextUtils.isEmpty((CharSequence)this.G) ? "" : this.G;
        return string;
    }

    public final String i() {
        String string = TextUtils.isEmpty((CharSequence)this.SN) ? "" : this.SN;
        return string;
    }

    public final void n(String string) {
        this.tF = string;
    }

    public final String q() {
        String string = TextUtils.isEmpty((CharSequence)this.v3) ? "" : this.v3;
        return string;
    }

    public final H7 s(String string) {
        this.W = string;
        return this;
    }

    public final List<H7> t0() {
        List<H7> list;
        List<H7> list2 = list = this.yq;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }

    public final String tF() {
        String string = TextUtils.isEmpty((CharSequence)this.tF) ? "" : this.tF;
        return string;
    }

    public final void un(String string) {
        this.zH = string;
    }

    public final String v() {
        String string = TextUtils.isEmpty((CharSequence)this.N) ? "" : this.N;
        return string;
    }

    public final String v3() {
        return TextUtils.join((CharSequence)" ", Arrays.asList(this.KJ(), this.Gc())).trim();
    }

    public final String xa() {
        long l = this.i;
        String string = l < 500L ? "" : String.valueOf(l);
        return string;
    }

    public final String zH() {
        String string = TextUtils.isEmpty((CharSequence)this.zH) ? "" : this.zH;
        return string;
    }

    public static final class SN {
        @SerializedName(value="pg")
        private String B;
        @SerializedName(value="parent")
        private String G;
        @SerializedName(value="sId")
        private String Gc;
        @SerializedName(value="sToken")
        private String KJ;
        @SerializedName(value="shareUser")
        private String M;
        @SerializedName(value="share_fid_token")
        private String N;
        @SerializedName(value="fid")
        private String SN;
        @SerializedName(value="vodName")
        private String i;
        @SerializedName(value="pdir_fid")
        private String q;
        @SerializedName(value="sub")
        private String t0;
        @SerializedName(value="size")
        private long tF;
        @SerializedName(value="flag")
        private String yq;
        @SerializedName(value="file_name")
        private String zH;

        public SN(H7 h7) {
            this.yq = h7.i();
            this.SN = h7.tF();
            this.N = h7.zH();
            long l = h7.xa().isEmpty() ? 0L : Long.parseLong(h7.xa());
            this.tF = l;
            this.zH = h7.Gc();
            this.i = h7.Nl();
            this.t0 = h7.v();
            this.Gc = h7.dT();
            this.KJ = h7.W();
            this.M = h7.ee();
            this.q = h7.q();
            this.B = h7.B();
            this.G = h7.KJ();
        }
    }
}

