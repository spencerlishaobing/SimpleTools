/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/*
 * Renamed from com.github.catvod.spider.merge.qq
 */
public final class qq_0 {
    @SerializedName(value="lang")
    private String N;
    @SerializedName(value="name")
    private String SN;
    @SerializedName(value="data")
    private String i;
    @SerializedName(value="format")
    private String tF;
    @SerializedName(value="url")
    private String yq;
    @SerializedName(value="selected")
    private boolean zH;

    public final qq_0 N(String string) {
        this.SN = string;
        return this;
    }

    public final qq_0 SN(String string) {
        Objects.requireNonNull(string);
        int n2 = string.hashCode();
        int n3 = -1;
        switch (n2) {
            default: {
                break;
            }
            case 117110: {
                if (!string.equals("vtt")) break;
                n3 = 2;
                break;
            }
            case 114177: {
                if (!string.equals("ssa")) break;
                n3 = 1;
                break;
            }
            case 96897: {
                if (!string.equals("ass")) break;
                n3 = 0;
            }
        }
        switch (n3) {
            default: {
                this.tF = "application/x-subrip";
                return this;
            }
            case 2: {
                this.tF = "text/vtt";
                return this;
            }
            case 0: 
            case 1: 
        }
        this.tF = "text/x-ssa";
        return this;
    }

    public final qq_0 tF() {
        this.zH = true;
        return this;
    }

    public final qq_0 yq(String string) {
        this.i = string;
        return this;
    }

    public final qq_0 zH(String string) {
        this.yq = string;
        return this;
    }
}

