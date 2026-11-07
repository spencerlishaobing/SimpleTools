/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.gson.JsonElement
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.github.catvod.spider.merge.RO;
import com.github.catvod.spider.merge.XM;
import com.github.catvod.spider.merge.aj_0;
import com.github.catvod.spider.merge.le_0;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

public final class LP {
    @SerializedName(value="duration")
    private Long B;
    @SerializedName(value="pages")
    private List<XM> F5;
    @SerializedName(value="desc")
    private String G;
    @SerializedName(value="accept_description")
    private List<String> G4;
    @SerializedName(value="cid")
    private String Gc;
    @SerializedName(value="tname")
    private String KJ;
    @SerializedName(value="title")
    private String M;
    @SerializedName(value="isLogin")
    private Boolean N;
    @SerializedName(value="list")
    private JsonElement SN;
    @SerializedName(value="owner")
    private RO W;
    @SerializedName(value="accept_quality")
    private List<Integer> dT;
    @SerializedName(value="url")
    private String i;
    @SerializedName(value="pic")
    private String q;
    @SerializedName(value="aid")
    private String t0;
    @SerializedName(value="vipStatus")
    private Integer tF;
    @SerializedName(value="wbi_img")
    private le_0 v;
    @SerializedName(value="dash")
    private aj_0 v3;
    @SerializedName(value="result")
    private JsonElement yq;
    @SerializedName(value="qrcode_key")
    private String zH;

    public final String B() {
        String string = TextUtils.isEmpty((CharSequence)this.M) ? "" : this.M;
        return string;
    }

    public final boolean F5() {
        Integer n2 = this.tF;
        boolean bl = n2 != null && n2 != 0;
        return bl;
    }

    public final String G() {
        String string = TextUtils.isEmpty((CharSequence)this.KJ) ? "" : this.KJ;
        return string;
    }

    public final le_0 G4() {
        le_0 le_02;
        le_0 le_03 = le_02 = this.v;
        if (le_02 == null) {
            le_03 = new le_0();
        }
        return le_03;
    }

    public final RO Gc() {
        RO rO;
        RO rO2 = rO = this.W;
        if (rO == null) {
            rO2 = new RO();
        }
        return rO2;
    }

    public final String KJ() {
        String string = TextUtils.isEmpty((CharSequence)this.q) ? "" : this.q;
        return string;
    }

    public final List<XM> M() {
        List<XM> list;
        List<XM> list2 = list = this.F5;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }

    public final String N() {
        String string = TextUtils.isEmpty((CharSequence)this.Gc) ? "" : this.Gc;
        return string;
    }

    public final List<Integer> SN() {
        List<Integer> list;
        List<Integer> list2 = list = this.dT;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }

    public final boolean dT() {
        Boolean bl = this.N;
        boolean bl2 = bl != null && bl != false;
        return bl2;
    }

    public final Long i() {
        Long l = this.B;
        long l2 = l == null ? 0L : l;
        return l2;
    }

    public final JsonElement q() {
        return this.yq;
    }

    public final JsonElement t0() {
        return this.SN;
    }

    public final aj_0 tF() {
        aj_0 aj_02;
        aj_0 aj_03 = aj_02 = this.v3;
        if (aj_02 == null) {
            aj_03 = new aj_0();
        }
        return aj_03;
    }

    public final List<String> yq() {
        List<String> list;
        List<String> list2 = list = this.G4;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }

    public final String zH() {
        String string = TextUtils.isEmpty((CharSequence)this.G) ? "" : this.G;
        return string;
    }
}

