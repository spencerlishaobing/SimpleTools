/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

public final class XM {
    @SerializedName(value="part")
    private String SN;
    @SerializedName(value="cid")
    private String yq;

    public final String SN() {
        boolean bl = TextUtils.isEmpty((CharSequence)this.SN);
        String string = "";
        if (!bl) {
            string = this.SN.replace("#", "");
        }
        return string;
    }

    public final String yq() {
        String string = TextUtils.isEmpty((CharSequence)this.yq) ? "" : this.yq;
        return string;
    }
}

