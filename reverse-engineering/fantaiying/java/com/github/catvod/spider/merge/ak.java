/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.github.catvod.spider.merge.Am;
import com.google.gson.annotations.SerializedName;

public final class ak {
    @SerializedName(value="path")
    private String B;
    @SerializedName(value="pg")
    private String G;
    @SerializedName(value="drive_id")
    private String G4;
    @SerializedName(value="vodName")
    private String Gc;
    @SerializedName(value="pdir_fid")
    private String KJ;
    @SerializedName(value="sub")
    private String M;
    @SerializedName(value="fs_id")
    private String N;
    @SerializedName(value="fid")
    private String SN;
    @SerializedName(value="file_name")
    private String i;
    @SerializedName(value="parent_file_id")
    private String q;
    @SerializedName(value="name")
    private String t0;
    @SerializedName(value="file_id")
    private String tF;
    @SerializedName(value="flag")
    private String yq;
    @SerializedName(value="size")
    private long zH;

    public final String N() {
        String string = TextUtils.isEmpty((CharSequence)this.yq) ? "" : this.yq;
        return string;
    }

    public final String SN() {
        if (!TextUtils.isEmpty((CharSequence)this.SN)) {
            return this.SN;
        }
        if (!TextUtils.isEmpty((CharSequence)this.tF)) {
            return this.tF;
        }
        return "";
    }

    public final String i() {
        if (!TextUtils.isEmpty((CharSequence)this.KJ)) {
            return this.KJ;
        }
        if (!TextUtils.isEmpty((CharSequence)this.q)) {
            return this.q;
        }
        return "";
    }

    public final String t0() {
        String string = TextUtils.isEmpty((CharSequence)this.Gc) ? "" : this.Gc;
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final String tF() {
        String string;
        if (!TextUtils.isEmpty((CharSequence)this.i)) {
            string = this.i;
            return Am.yq(string).Fo().replace(" ", ".").replace("+", "").replaceAll("[/@]", "-").replace("@@@", "").trim();
        }
        if (TextUtils.isEmpty((CharSequence)this.t0)) return "";
        string = this.t0;
        return Am.yq(string).Fo().replace(" ", ".").replace("+", "").replaceAll("[/@]", "-").replace("@@@", "").trim();
    }

    public final String yq() {
        return this.G4;
    }

    public final String zH() {
        String string = TextUtils.isEmpty((CharSequence)this.B) ? "" : this.B;
        return string;
    }
}

