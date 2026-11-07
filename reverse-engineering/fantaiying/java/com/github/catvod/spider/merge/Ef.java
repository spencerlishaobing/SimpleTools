/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.ME;
import com.google.gson.annotations.SerializedName;

public final class Ef {
    @SerializedName(value="vod_content")
    private String B;
    @SerializedName(value="style")
    private yq F5;
    @SerializedName(value="vod_play_from")
    private String G;
    @SerializedName(value="vod_play_url")
    private String G4;
    @SerializedName(value="vod_area")
    private String Gc;
    @SerializedName(value="action")
    private String KJ;
    @SerializedName(value="vod_actor")
    private String M;
    @SerializedName(value="vod_name")
    private String N;
    @SerializedName(value="vod_id")
    private String SN;
    @SerializedName(value="vod_tag")
    private String dT;
    @SerializedName(value="vod_remarks")
    private String i;
    @SerializedName(value="vod_director")
    private String q;
    @SerializedName(value="vod_year")
    private String t0;
    @SerializedName(value="vod_pic")
    private String tF;
    @SerializedName(value="shareUser_Id")
    private String v3;
    @SerializedName(value="type_name")
    private String yq;
    @SerializedName(value="vod_class")
    private String zH;

    public Ef() {
    }

    public Ef(String string, String string2, String string3) {
        this.SN = string;
        this.N = string2;
        this.tF = string3;
    }

    public Ef(String string, String string2, String string3, String string4) {
        this.SN = string;
        this.N = string2;
        this.tF = string3;
        this.i = string4;
    }

    public Ef(String string, String string2, String string3, String string4, String string5) {
        this.SN = string;
        this.N = string2;
        this.tF = string3;
        this.i = "";
        this.KJ = string5;
    }

    public Ef(String string, String string2, String string3, String string4, boolean bl) {
        this.SN = string;
        this.N = string2;
        this.tF = string3;
        this.i = string4;
        string = bl ? "folder" : "file";
        this.dT = string;
    }

    public final void B(String string) {
        this.q = string;
    }

    public final void F5(String string) {
        this.G = string;
    }

    public final void G(String string) {
        this.SN = string;
    }

    public final void G4(String string) {
        this.N = string;
    }

    public final void Gc(String string) {
        this.yq = string;
    }

    public final void KJ(String string) {
        this.Gc = string;
    }

    public final void M(String string) {
        this.M = string;
    }

    public final String N() {
        return this.G;
    }

    public final String SN() {
        return this.SN;
    }

    public final void W(String string) {
        this.i = string;
    }

    public final void dT(String string) {
        this.tF = string;
    }

    public final void ee(String string) {
        this.t0 = string;
    }

    public final void i(String string) {
        this.v3 = string;
    }

    public final void q(String string) {
        this.B = string;
    }

    public final void t0(yq yq2) {
        this.F5 = yq2;
    }

    public final String tF() {
        return this.G4;
    }

    public final void v(String string) {
        this.dT = string;
    }

    public final void v3(String string) {
        this.G4 = string;
    }

    public final String yq() {
        String string = ME.ee(this.v3) ? "" : new String(ME.v(this.v3));
        return string;
    }

    public final void zH(String string) {
        this.KJ = string;
    }

    public static final class yq {
        @SerializedName(value="ratio")
        private Float SN;
        @SerializedName(value="type")
        private String yq = "list";

        public static yq yq() {
            return new yq();
        }
    }
}

