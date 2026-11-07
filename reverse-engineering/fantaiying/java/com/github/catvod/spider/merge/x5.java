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
import com.github.catvod.spider.merge.M4;
import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.j_0;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public final class x5 {
    @SerializedName(value="totalTraffic")
    private String SN;
    @SerializedName(value="hasVip")
    private String yq;

    public static x5 zH(String object) {
        x5 x52 = (x5)Z.yq((String)object, x5.class);
        object = x52;
        if (x52 == null) {
            object = new x5();
        }
        return object;
    }

    public final boolean N() {
        return this.SN().equals("true");
    }

    public final String SN() {
        String string = TextUtils.isEmpty((CharSequence)this.yq) ? "" : this.yq;
        return string;
    }

    public final x5 i() {
        M4.i(j_0.v().O(), this.toString());
        return this;
    }

    public final boolean tF() {
        long l = TextUtils.isEmpty((CharSequence)this.SN) ? 0L : Long.valueOf(this.SN);
        boolean bl = l > 0x280000000L;
        return bl;
    }

    public final String toString() {
        return new Gson().toJson((Object)this);
    }

    public final x5 yq() {
        this.yq = "";
        this.SN = "";
        return this;
    }
}

