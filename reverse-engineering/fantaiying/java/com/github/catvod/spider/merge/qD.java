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
import com.github.catvod.spider.merge.j_0;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public final class qD {
    @SerializedName(value="refresh_token")
    private String N;
    @SerializedName(value="access_token")
    private String SN;
    @SerializedName(value="refreshToken")
    private String i;
    @SerializedName(value="signature")
    private String t0;
    @SerializedName(value="tokenType")
    private String tF;
    @SerializedName(value="token_type")
    private String yq;
    @SerializedName(value="accessToken")
    private String zH;

    public static qD i(String object) {
        qD qD2 = (qD)Z.yq((String)object, qD.class);
        object = qD2;
        if (qD2 == null) {
            object = new qD();
        }
        return object;
    }

    public final String N() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = TextUtils.isEmpty((CharSequence)this.tF);
        String string = "";
        String string2 = bl ? "" : this.tF;
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        string2 = TextUtils.isEmpty((CharSequence)this.zH) ? string : this.zH;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final String SN() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = TextUtils.isEmpty((CharSequence)this.yq);
        String string = "";
        String string2 = bl ? "" : this.yq;
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        string2 = TextUtils.isEmpty((CharSequence)this.SN) ? string : this.SN;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final qD t0() {
        M4.i(j_0.v().g1(), ME.B(this.toString()));
        return this;
    }

    public final String tF() {
        String string = TextUtils.isEmpty((CharSequence)this.N) ? "" : this.N;
        return string;
    }

    public final String toString() {
        return new Gson().toJson((Object)this);
    }

    public final qD yq() {
        this.N = "";
        this.SN = "";
        this.i = "";
        this.zH = "";
        return this;
    }

    public final String zH() {
        String string = TextUtils.isEmpty((CharSequence)this.i) ? "" : this.i;
        return string;
    }
}

