/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.gson.Gson
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.github.catvod.spider.merge.Z;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public final class X0 {
    @SerializedName(value="use_capacity")
    private long N;
    @SerializedName(value="total_capacity")
    private long SN;
    @SerializedName(value="token")
    private String tF;
    @SerializedName(value="member_type")
    private String yq;

    public static X0 Gc(String object) {
        X0 x0 = (X0)Z.yq((String)object, X0.class);
        object = x0;
        if (x0 == null) {
            object = new X0();
        }
        return object;
    }

    public final X0 M(String string) {
        this.tF = string;
        return this;
    }

    public final String N() {
        String string = TextUtils.isEmpty((CharSequence)this.tF) ? "" : this.tF;
        return string;
    }

    public final long SN() {
        long l = this.SN;
        long l2 = 0L;
        if (l != 0L) {
            l2 = l - this.N;
        }
        return l2;
    }

    public final boolean i() {
        return this.yq.equals("SUPER_VIP");
    }

    public final boolean t0() {
        return this.yq.equals("Z_VIP");
    }

    public final String tF() {
        String string = TextUtils.isEmpty((CharSequence)this.yq) ? "" : this.yq;
        return string;
    }

    public final String toString() {
        return new Gson().toJson((Object)this);
    }

    public final X0 yq() {
        this.yq = "";
        this.SN = 0L;
        this.tF = "";
        this.N = 0L;
        return this;
    }

    public final boolean zH() {
        return this.yq.equals("EXP_SVIP");
    }
}

