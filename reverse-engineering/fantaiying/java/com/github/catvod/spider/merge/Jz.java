/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import com.google.gson.annotations.SerializedName;

public final class Jz {
    @SerializedName(value="type_flag")
    private String N;
    @SerializedName(value="type_name")
    private String SN;
    @SerializedName(value="type_id")
    private String yq;

    public Jz(String string, String string2) {
        this(string, string2, "");
    }

    public Jz(String string, String string2, String string3) {
        this.yq = string;
        this.SN = string2;
        this.N = string3;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Jz)) {
            return false;
        }
        object = (Jz)object;
        return this.yq.equals(((Jz)object).yq);
    }

    public final String yq() {
        return this.yq;
    }
}

