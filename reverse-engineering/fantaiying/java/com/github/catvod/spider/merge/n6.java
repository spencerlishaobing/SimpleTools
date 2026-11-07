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
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.oi_0;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class n6 {
    @SerializedName(value="vodName")
    private String B;
    @SerializedName(value="category")
    private String F5;
    @SerializedName(value="type")
    private String G;
    @SerializedName(value="parent_file_id")
    private String G4;
    @SerializedName(value="sId")
    private String Gc;
    @SerializedName(value="name")
    private String KJ;
    @SerializedName(value="sToken")
    private String M;
    @SerializedName(value="sub")
    private String N;
    @SerializedName(value="flag")
    private String SN;
    @SerializedName(value="created_at")
    private String W;
    @SerializedName(value="file_extension")
    private String dT;
    @SerializedName(value="file_id")
    private String i;
    @SerializedName(value="drive_id")
    private String q;
    @SerializedName(value="saveId")
    private String t0;
    @SerializedName(value="next_marker")
    private String tF;
    @SerializedName(value="parent")
    private String v;
    @SerializedName(value="size")
    private long v3;
    @SerializedName(value="items")
    private List<n6> yq;
    @SerializedName(value="thumbnail")
    private String zH;

    public n6() {
    }

    public n6(String string) {
        this.i = string;
    }

    public static String SN(Object object) {
        return new Gson().toJson(object);
    }

    public static n6 g1(String string) {
        return (n6)Z.yq(string, n6.class);
    }

    public static List<n6> yq(String string) {
        Type type = new TypeToken<List<n6>>(){}.getType();
        return (List)new Gson().fromJson(string, type);
    }

    public final String B() {
        String string = ME.ee(this.v) ? "" : k_0.i(oi_0.yq("["), this.v, "]");
        return string;
    }

    public final void Dr(String string) {
        this.Gc = string;
    }

    public final double F5() {
        return this.v3;
    }

    public final void Fz(String string) {
        this.B = string;
    }

    public final String G() {
        String string = TextUtils.isEmpty((CharSequence)this.G4) ? "" : this.G4;
        return string;
    }

    public final String G4(String string) {
        if (this.OW()) {
            return string;
        }
        string = TextUtils.isEmpty((CharSequence)this.zH) ? "" : k_0.i(new StringBuilder(), this.zH, "@Referer=https://www.aliyundrive.com/");
        return string;
    }

    public final String Gc() {
        String string = TextUtils.isEmpty((CharSequence)this.SN) ? "" : this.SN;
        return string;
    }

    public final Ef Gd(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((double)this.v3);
        stringBuilder.append("");
        stringBuilder.append(this.KJ());
        return new Ef(string, stringBuilder.toString().trim(), this.G4(string2), "", string3);
    }

    public final void H(String string) {
        this.N = string;
    }

    public final String KJ() {
        boolean bl = ME.ee(this.KJ);
        String string = "";
        if (!bl) {
            string = this.KJ.replace("#", "").replace("@", "").replace("&", "").replace("+", "").trim();
        }
        return string;
    }

    public final List<n6> M() {
        List<n6> list;
        List<n6> list2 = list = this.yq;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }

    public final String N() {
        CharSequence charSequence;
        if (this.v3 < 500L) {
            charSequence = "";
        } else {
            charSequence = oi_0.yq("[");
            ((StringBuilder)charSequence).append(ME.v3(this.v3));
            ((StringBuilder)charSequence).append("]");
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public final String Nl() {
        String string = TextUtils.isEmpty((CharSequence)this.B) ? "" : this.B;
        return string;
    }

    public final boolean O() {
        boolean bl = this.tF().equals("video") || this.tF().equals("audio") || this.KJ().contains("iso") || this.KJ().contains(".ts");
        return bl;
    }

    public final boolean OW() {
        String string = TextUtils.isEmpty((CharSequence)this.G) ? "" : this.G;
        return string.equals("folder");
    }

    public final void U() {
        this.G = "folder";
    }

    public final String W() {
        String string = TextUtils.isEmpty((CharSequence)this.M) ? "" : this.M;
        return string;
    }

    public final void Zm(String string) {
        this.KJ = string;
    }

    public final void b(String string) {
        this.SN = string;
    }

    public final String dT() {
        String string = ME.ee(this.Gc) ? "" : this.Gc;
        return string;
    }

    public final String ee() {
        String string = TextUtils.isEmpty((CharSequence)this.G) ? "" : this.G;
        return string;
    }

    public final void g(String string) {
        this.M = string;
    }

    public final String g9() {
        long l = this.v3;
        String string = l < 500L ? "" : String.valueOf(l);
        return string;
    }

    public final String i() {
        String string = TextUtils.isEmpty((CharSequence)this.dT) ? "" : this.dT;
        return string;
    }

    public final void n(String string) {
        this.q = string;
    }

    public final String q() {
        String string = TextUtils.isEmpty((CharSequence)this.tF) ? "" : this.tF;
        return string;
    }

    public final n6 s(String string) {
        this.v = string;
        return this;
    }

    public final String t0() {
        String string = TextUtils.isEmpty((CharSequence)this.i) ? "" : this.i;
        return string;
    }

    public final String tF() {
        String string = TextUtils.isEmpty((CharSequence)this.F5) ? "" : this.F5;
        return string;
    }

    public final void un(String string) {
        this.i = string;
    }

    public final String v() {
        String string = TextUtils.isEmpty((CharSequence)this.N) ? "" : this.N;
        return string;
    }

    public final String v3() {
        return TextUtils.join((CharSequence)" ", Arrays.asList(this.B(), this.KJ())).trim();
    }

    public final Ef xa(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.N());
        stringBuilder.append(" ");
        stringBuilder.append(this.KJ());
        return new Ef(string, stringBuilder.toString().trim(), this.G4(string2), string3, this.OW());
    }

    public final String zH() {
        return this.q;
    }

    public static final class SN {
        @SerializedName(value="drive_id")
        private String Gc;
        @SerializedName(value="parent_file_id")
        private String KJ;
        @SerializedName(value="sToken")
        private String M;
        @SerializedName(value="size")
        private long N;
        @SerializedName(value="file_id")
        private String SN;
        @SerializedName(value="sub")
        private String i;
        @SerializedName(value="pg")
        private String q;
        @SerializedName(value="sId")
        private String t0;
        @SerializedName(value="name")
        private String tF;
        @SerializedName(value="flag")
        private String yq;
        @SerializedName(value="vodName")
        private String zH;

        public SN(n6 n62) {
            this.yq = n62.Gc();
            this.SN = n62.t0();
            long l = n62.g9().isEmpty() ? 0L : Long.parseLong(n62.g9());
            this.N = l;
            this.zH = n62.Nl();
            this.tF = n62.KJ();
            this.i = n62.v();
            this.t0 = n62.dT();
            this.M = n62.W();
            this.KJ = n62.G();
            this.Gc = n62.zH();
        }
    }
}

