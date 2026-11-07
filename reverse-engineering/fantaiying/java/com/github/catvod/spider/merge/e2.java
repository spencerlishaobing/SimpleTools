/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.lm;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

public final class e2 {
    @SerializedName(value="data")
    private List<lm> yq;

    public static e2 SN(String string) {
        return (e2)Z.yq(string, e2.class);
    }

    public final List<lm> yq() {
        List<lm> list;
        List<lm> list2 = list = this.yq;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }
}

