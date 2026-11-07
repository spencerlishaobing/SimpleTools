/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public final class p9 {
    @SerializedName(value="value")
    private List<yq> N;
    @SerializedName(value="name")
    private String SN;
    @SerializedName(value="key")
    private String yq;

    public p9(String string, String string2, List<yq> list) {
        this.yq = string;
        this.SN = string2;
        this.N = list;
    }

    public static final class yq {
        @SerializedName(value="v")
        private String SN;
        @SerializedName(value="n")
        private String yq;

        public yq(String string, String string2) {
            this.yq = string;
            this.SN = string2;
        }
    }
}

