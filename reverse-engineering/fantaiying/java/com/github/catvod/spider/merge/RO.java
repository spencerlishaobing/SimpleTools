/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.github.catvod.spider.merge.k_0;
import com.google.gson.annotations.SerializedName;

public final class RO {
    @SerializedName(value="name")
    private String SN;
    @SerializedName(value="mid")
    private String yq;

    public final String yq() {
        CharSequence charSequence = new StringBuilder();
        boolean bl = TextUtils.isEmpty((CharSequence)this.yq);
        String string = "";
        String string2 = bl ? "" : this.yq;
        charSequence = k_0.i(charSequence, string2, "/{pg}");
        string2 = TextUtils.isEmpty((CharSequence)this.SN) ? "" : this.SN;
        if (!TextUtils.isEmpty((CharSequence)this.SN)) {
            string = this.SN;
        }
        return String.format("[a=cr:{\"id\":\"%s\",\"name\":\"%s\"}/]%s[/a]", charSequence, string2, string);
    }
}

