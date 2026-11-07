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
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.xu_0;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

public final class MI {
    @SerializedName(value="refresh_token")
    private String N;
    @SerializedName(value="access_token")
    private String SN;
    @SerializedName(value="secret_key")
    private String tF;
    @SerializedName(value="client_key")
    private String yq;
    @SerializedName(value="expiry")
    private long zH;

    public static MI t0(String object) {
        MI mI = (MI)Z.yq((String)object, MI.class);
        object = mI;
        if (mI == null) {
            object = new MI();
        }
        return object;
    }

    public final MI Gc() {
        HashMap<String, Object[]> hashMap = xu_0.Zm;
        M4.i(xu_0.tF.yq.Zm(), ME.B(this.toString()));
        return this;
    }

    public final MI KJ(long l) {
        this.zH = l;
        return this;
    }

    public final void M(String string) {
        this.yq = string;
    }

    public final String N() {
        return this.yq;
    }

    public final String SN() {
        String string = TextUtils.isEmpty((CharSequence)this.SN) ? "" : this.SN;
        return string;
    }

    public final String i() {
        return this.tF;
    }

    public final void q(String string) {
        this.tF = string;
    }

    public final long tF() {
        return this.zH;
    }

    public final String toString() {
        return new Gson().toJson((Object)this);
    }

    public final MI yq() {
        this.N = "";
        this.SN = "";
        this.yq = "";
        this.tF = "";
        this.zH = 0L;
        return this;
    }

    public final String zH() {
        String string = TextUtils.isEmpty((CharSequence)this.N) ? "" : this.N;
        return string;
    }
}

