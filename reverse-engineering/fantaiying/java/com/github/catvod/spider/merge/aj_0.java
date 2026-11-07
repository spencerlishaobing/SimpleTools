/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.ts_0;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.aj
 */
public final class aj_0 {
    @SerializedName(value="video")
    private List<ts_0> N;
    @SerializedName(value="minBufferTime")
    private String SN;
    @SerializedName(value="audio")
    private List<ts_0> tF;
    @SerializedName(value="duration")
    private String yq;

    public final String N() {
        String string;
        String string2 = string = this.SN;
        if (string == null) {
            string2 = "0";
        }
        return string2;
    }

    public final String SN() {
        String string;
        String string2 = string = this.yq;
        if (string == null) {
            string2 = "0";
        }
        return string2;
    }

    public final List<ts_0> tF() {
        List<ts_0> list;
        List<ts_0> list2 = list = this.N;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }

    public final List<ts_0> yq() {
        List<ts_0> list;
        List<ts_0> list2 = list = this.tF;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }
}

