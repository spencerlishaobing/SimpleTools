/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public final class y7 {
    @SerializedName(value="refreshMode")
    private Boolean B;
    @SerializedName(value="ext")
    private Object F5;
    @SerializedName(value="ad")
    private Boolean G;
    @SerializedName(value="disableRVideo")
    private Boolean G4;
    @SerializedName(value="type")
    private String Gc;
    @SerializedName(value="searchMode")
    private String Gd;
    @SerializedName(value="threadMode")
    private int KJ;
    @SerializedName(value="thread")
    private Boolean M;
    @SerializedName(value="login")
    private String N;
    @SerializedName(value="only")
    private Boolean Nl;
    @SerializedName(value="filter")
    private String O;
    @SerializedName(value="request")
    private Integer OW;
    @SerializedName(value="cookie")
    private String SN;
    @SerializedName(value="DanMu")
    private String W;
    @SerializedName(value="danMu")
    private Boolean dT;
    @SerializedName(value="m3u8AdZy")
    private String ee;
    @SerializedName(value="picSite")
    private String g1;
    @SerializedName(value="filterSpeedUp")
    private String g9;
    @SerializedName(value="name")
    private String i;
    @SerializedName(value="playMode")
    private Boolean q;
    @SerializedName(value="modulePath")
    private String t0;
    @SerializedName(value="from")
    private String tF;
    @SerializedName(value="socks5")
    private String v;
    @SerializedName(value="Cloud-drive")
    private String v3;
    @SerializedName(value="searcFrom")
    private String xa;
    @SerializedName(value="siteUrl")
    private String yq;
    @SerializedName(value="123Host")
    private String zH;

    public final String N() {
        return this.Gc;
    }

    public final String SN() {
        return this.t0;
    }

    public final boolean tF() {
        Boolean bl = this.dT;
        if (bl == null) {
            return true;
        }
        return bl;
    }

    public final String yq() {
        Object object = this.F5;
        if (object == null) {
            return "";
        }
        if (object instanceof String) {
            return (String)object;
        }
        return new Gson().toJson(this.F5);
    }

    public final boolean zH() {
        String string = this.v;
        if (string == null) {
            return true;
        }
        return string.contains("pic");
    }
}

