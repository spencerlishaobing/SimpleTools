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
import com.github.catvod.spider.merge.i3;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public final class ID {
    private String N = "";
    @SerializedName(value="refresh_token")
    private String SN;
    private String i = "";
    private String tF = "";
    @SerializedName(value="access_token")
    private String yq;
    private String zH = "";

    public static ID Gc(String object) {
        ID iD = (ID)Z.yq((String)object, ID.class);
        object = iD;
        if (iD == null) {
            object = new ID();
        }
        return object;
    }

    public final void B(String string) {
        this.zH = string;
    }

    public final void G(String string) {
        this.tF = string;
    }

    public final void G4(String string) {
        this.i = string;
    }

    public final void KJ(String string) {
        this.yq = string;
    }

    public final ID M() {
        int n2 = i3.H;
        M4.i(i3.tF.yq.J(), this.toString());
        return this;
    }

    public final String N() {
        String string = TextUtils.isEmpty((CharSequence)this.N) ? "" : this.N;
        return string;
    }

    public final String SN() {
        String string = ME.ee(this.yq) ? "" : this.yq;
        return string;
    }

    public final String i() {
        String string = TextUtils.isEmpty((CharSequence)this.tF) ? "" : this.tF;
        return string;
    }

    public final ID q(String string) {
        this.N = string;
        return this;
    }

    public final String t0() {
        String string = TextUtils.isEmpty((CharSequence)this.i) ? "" : this.i;
        return string;
    }

    public final String tF() {
        String string = ME.ee(this.SN) ? "" : this.SN;
        return string;
    }

    public final String toString() {
        return new Gson().toJson((Object)this);
    }

    public final ID yq() {
        this.SN = "";
        this.yq = "";
        this.N = "";
        int n2 = i3.H;
        i3.tF.yq.J().delete();
        return this;
    }

    public final String zH() {
        String string = TextUtils.isEmpty((CharSequence)this.zH) ? "" : this.zH;
        return string;
    }
}

