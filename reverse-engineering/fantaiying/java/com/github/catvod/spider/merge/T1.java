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

public final class T1 {
    @SerializedName(value="member_type")
    private String N;
    @SerializedName(value="use_capacity")
    private long SN;
    @SerializedName(value="used")
    private String tF = "";
    @SerializedName(value="total_capacity")
    private long yq = 0L;

    public static T1 zH(String object) {
        T1 t1 = (T1)Z.yq((String)object, T1.class);
        object = t1;
        if (t1 == null) {
            object = new T1();
        }
        return object;
    }

    public final long N() {
        long l = this.yq;
        long l2 = 0L;
        if (l != 0L) {
            l2 = l - this.SN;
        }
        return l2;
    }

    public final String SN() {
        String string = TextUtils.isEmpty((CharSequence)this.N) ? "" : this.N;
        return string;
    }

    public final boolean tF() {
        boolean bl = this.SN().equals("SUPER_VIP") || this.SN().equals("Z_VIP");
        return bl;
    }

    public final String toString() {
        return new Gson().toJson((Object)this);
    }

    public final T1 yq() {
        this.N = "";
        this.yq = 0L;
        this.SN = 0L;
        return this;
    }
}

