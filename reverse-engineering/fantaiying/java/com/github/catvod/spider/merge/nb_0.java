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

/*
 * Renamed from com.github.catvod.spider.merge.nb
 */
public final class nb_0 {
    @SerializedName(value="resource_drive_id")
    private String Gc;
    @SerializedName(value="backup_drive_id")
    private String M;
    @SerializedName(value="my-driveId")
    private String N;
    @SerializedName(value="default_drive_id")
    private String SN;
    @SerializedName(value="access_token")
    private String i;
    @SerializedName(value="refresh_token")
    private String t0;
    @SerializedName(value="user_id")
    private String tF;
    @SerializedName(value="device_id")
    private String yq;
    @SerializedName(value="token_type")
    private String zH;

    public static nb_0 q(String object) {
        nb_0 nb_02 = (nb_0)Z.yq((String)object, nb_0.class);
        object = nb_02;
        if (nb_02 == null) {
            object = new nb_0();
        }
        return object;
    }

    public final nb_0 B() {
        M4.i(j_0.v().Dr(), ME.B(this.toString()));
        return this;
    }

    public final void G(String string) {
        this.M = string;
    }

    public final void G4(String string) {
        this.t0 = string;
    }

    public final String Gc() {
        return this.Gc;
    }

    public final boolean KJ() {
        String string = TextUtils.isEmpty((CharSequence)this.zH) ? "" : this.zH;
        boolean bl = string.length() > 0 && this.SN().length() > 0;
        return bl;
    }

    public final String M() {
        String string;
        block3: {
            block2: {
                String string2;
                if ("NO_ID".equals(this.Gc)) break block2;
                string = string2 = this.Gc;
                if (string2 != null) break block3;
            }
            string = this.SN;
        }
        return string;
    }

    public final String N() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = TextUtils.isEmpty((CharSequence)this.zH) ? "" : this.zH;
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(this.SN());
        return stringBuilder.toString();
    }

    public final String SN() {
        String string = TextUtils.isEmpty((CharSequence)this.i) ? "" : this.i;
        return string;
    }

    public final nb_0 dT(String string) {
        this.Gc = string;
        return this;
    }

    public final String i() {
        String string = TextUtils.isEmpty((CharSequence)this.yq) ? "" : this.yq;
        return string;
    }

    public final String t0() {
        String string = TextUtils.isEmpty((CharSequence)this.t0) ? "" : this.t0;
        return string;
    }

    public final String tF() {
        String string;
        block3: {
            block2: {
                String string2;
                if ("NO_ID".equals(this.M)) break block2;
                string = string2 = this.M;
                if (string2 != null) break block3;
            }
            string = "";
        }
        return string;
    }

    public final String toString() {
        return new Gson().toJson((Object)this);
    }

    public final nb_0 yq() {
        this.t0 = "";
        this.i = "";
        this.Gc = null;
        return this;
    }

    public final String zH() {
        String string = TextUtils.isEmpty((CharSequence)this.SN) ? "" : this.SN;
        return string;
    }
}

