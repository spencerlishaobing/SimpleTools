/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 *  com.google.gson.Gson
 *  com.google.gson.annotations.SerializedName
 *  com.google.gson.reflect.TypeToken
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import android.util.Log;
import com.github.catvod.spider.merge.Am;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.oX;
import com.github.catvod.spider.merge.oi_0;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class tX {
    @SerializedName(value="pg")
    private String B;
    @SerializedName(value="pdir_fid")
    private String F5;
    @SerializedName(value="owner_ucid")
    private String G;
    @SerializedName(value="file_type")
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
    @SerializedName(value="obj_category")
    private String W;
    @SerializedName(value="big_thumbnail")
    private String dT;
    @SerializedName(value="parent")
    private String ee;
    @SerializedName(value="format_type")
    private String g9;
    @SerializedName(value="size")
    private long i;
    @SerializedName(value="sToken")
    private String q;
    @SerializedName(value="file_name")
    private String t0;
    @SerializedName(value="fid")
    private String tF;
    @SerializedName(value="l_created_at")
    private long v;
    @SerializedName(value="category")
    private int v3;
    @SerializedName(value="list")
    private List<tX> yq;
    @SerializedName(value="share_fid_token")
    private String zH;

    public static String SN(Object object) {
        return new Gson().toJson(object);
    }

    public static tX s(String string) {
        return (tX)Z.yq(string, tX.class);
    }

    public static List<tX> yq(String string) {
        Type type = new TypeToken<List<tX>>(){}.getType();
        return (List)new Gson().fromJson(string, type);
    }

    public final String B() {
        String string = ME.ee(this.F5) ? "" : this.F5;
        return string;
    }

    public final void Dr() {
        this.t0 = "\u6700\u8fd1\u4fdd\u5b58";
    }

    public final void E1(String string) {
        this.KJ = string;
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
        this.N = string;
    }

    public final String G() {
        String string = ME.ee(this.B) ? "1" : this.B;
        return string;
    }

    public final String G4(String charSequence) {
        if (this.OW()) {
            return charSequence;
        }
        if (ME.ee(this.dT)) {
            charSequence = "";
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(this.dT);
            ((StringBuilder)charSequence).append("@Referer=https://pan.quark.cn/@User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36@Cookie=");
            int n2 = N0.g;
            ((StringBuilder)charSequence).append(N0.tF.yq.F5);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public final String Gc() {
        String string = ME.ee(this.g9) ? "" : this.g9;
        return string;
    }

    public final Ef Gd(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.F5());
        stringBuilder.append(" ");
        stringBuilder.append(this.KJ());
        return new Ef(string, stringBuilder.toString().trim(), this.G4(string2), string3, this.OW());
    }

    public final void H(String string) {
        this.M = string;
    }

    public final String KJ() {
        boolean bl = ME.ee(this.t0);
        String string = "";
        if (!bl) {
            string = Am.yq(this.t0).Fo().trim().replace("#", "").replace("@", "").replace("&", "").replace("+", "");
        }
        return string;
    }

    public final List<tX> M() {
        List<tX> list;
        List<tX> list2 = list = this.yq;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }

    public final long N() {
        long l;
        long l2 = l = this.v;
        if (l == 0L) {
            l2 = 0L;
        }
        return l2;
    }

    public final String Nl() {
        String string = ME.ee(this.t0) ? "" : this.Gc;
        return string;
    }

    public final boolean O() {
        boolean bl = ME.ee(this.W);
        String string = "";
        String string2 = bl ? "" : this.W;
        bl = string2.equals("video") || (string2 = ME.ee(this.W) ? string : this.W).equals("audio") || this.KJ().contains("iso") || this.KJ().contains(".ts");
        return bl;
    }

    public final boolean OW() {
        boolean bl = this.v3 == 0;
        return bl;
    }

    public final void U(String string) {
        this.q = string;
    }

    public final String W() {
        String string = ME.ee(this.q) ? "" : this.q;
        return string;
    }

    public final void Zm(String string) {
        this.SN = string;
    }

    public final void b(String string) {
        this.zH = string;
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
        this.B = string;
    }

    public final boolean g1() {
        boolean bl = !ME.ee(this.g9) && this.g9.equals("image/png") && ME.g9(this.t0);
        return bl;
    }

    public final String g9() {
        String string = ME.ee(this.G4) ? "" : this.G4;
        return string;
    }

    public final String i() {
        String string = ME.ee(this.zH) ? "" : this.zH;
        return string;
    }

    public final tX n(String string) {
        this.ee = string;
        return this;
    }

    public final String q() {
        CharSequence charSequence;
        if (ME.ee(this.ee)) {
            charSequence = "";
        } else {
            charSequence = oi_0.yq("[");
            ((StringBuilder)charSequence).append(this.ee.trim());
            ((StringBuilder)charSequence).append("]");
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public final String t0() {
        String string = ME.ee(this.SN) ? "" : this.SN;
        return string;
    }

    public final String tF(String string) {
        StringBuilder stringBuilder = oX.yq(string, "  ");
        stringBuilder.append(this.t0);
        Log.e((String)"test", (String)stringBuilder.toString());
        string = this.q().replaceAll("\\d+\u96c6", "").replace("\ud83d\udc32\u6b27\u4e13\u7528", "").replace(string, "").replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", "");
        return TextUtils.join((CharSequence)" ", Arrays.asList(this.F5(), string, this.KJ().replace("\ud83d\udc32\u6b27\u4e13\u7528", ""))).trim();
    }

    public final void tO(String string) {
        this.Gc = string;
    }

    public final void un(String string) {
        this.tF = string;
    }

    public final String v() {
        String string = ME.ee(this.N) ? "" : this.N;
        return string;
    }

    public final String v3() {
        return TextUtils.join((CharSequence)" ", Arrays.asList(this.q(), this.KJ())).trim();
    }

    public final String xa() {
        long l = this.i;
        String string = l < 500L ? "" : String.valueOf(l);
        return string;
    }

    public final String zH() {
        String string = ME.ee(this.tF) ? "" : this.tF;
        return string;
    }

    public static final class SN {
        @SerializedName(value="pg")
        private String B;
        @SerializedName(value="parent")
        private String G;
        @SerializedName(value="l_created_at")
        private long G4;
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
        @SerializedName(value="format_type")
        private String dT;
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

        public SN(tX tX2) {
            this.yq = tX2.t0();
            this.SN = tX2.zH();
            this.N = tX2.i();
            long l = tX2.xa().isEmpty() ? 0L : Long.parseLong(tX2.xa());
            this.tF = l;
            this.zH = tX2.KJ();
            this.i = tX2.Nl();
            this.t0 = tX2.v();
            this.Gc = tX2.dT();
            this.KJ = tX2.W();
            this.M = tX2.ee();
            this.q = tX2.B();
            this.B = tX2.G();
            this.G = tX2.q();
            this.G4 = tX2.N();
            this.dT = tX2.Gc();
        }
    }
}

