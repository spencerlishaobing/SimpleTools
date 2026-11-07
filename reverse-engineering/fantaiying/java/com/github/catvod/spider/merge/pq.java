/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.oX;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

public final class pq {
    @SerializedName(alternate={"path"}, value="thumbnail")
    private String N;
    @SerializedName(value="id")
    private String SN;
    @SerializedName(value="title")
    private String tF;
    @SerializedName(value="data")
    private List<pq> yq;
    @SerializedName(value="mask")
    private String zH;

    public final Ef N(String charSequence) {
        boolean bl = TextUtils.isEmpty((CharSequence)this.SN);
        String string = "";
        String string2 = bl ? "" : this.SN;
        String string3 = TextUtils.isEmpty((CharSequence)this.tF) ? "" : this.tF;
        if (TextUtils.isEmpty((CharSequence)this.N)) {
            charSequence = "";
        } else {
            charSequence = oX.yq("http://", (String)charSequence);
            ((StringBuilder)charSequence).append(this.N);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        if (!TextUtils.isEmpty((CharSequence)this.zH)) {
            string = this.zH;
        }
        return new Ef(string2, string3, (String)charSequence, string);
    }

    public final String SN() {
        String string = TextUtils.isEmpty((CharSequence)this.tF) ? "" : this.tF;
        return string;
    }

    public final List<pq> yq() {
        List<pq> list;
        List<pq> list2 = list = this.yq;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }
}

