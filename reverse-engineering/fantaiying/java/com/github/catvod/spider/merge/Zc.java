/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import com.google.gson.annotations.SerializedName;

public final class Zc {
    @SerializedName(value="url")
    private String N;
    @SerializedName(value="name")
    private String SN;
    private String yq = "\u5168\u90e8";

    public final String N() {
        return this.N;
    }

    public final String SN() {
        return this.yq;
    }

    public final Zc i(String string) {
        this.N = string;
        return this;
    }

    public final Zc tF(String string) {
        this.SN = string;
        return this;
    }

    public final String yq() {
        return this.SN;
    }

    public final Zc zH(String string) {
        this.yq = string;
        return this;
    }
}

