/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.annotations.SerializedName
 *  com.google.gson.reflect.TypeToken
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Gt;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.p9;
import com.github.catvod.spider.merge.qq_0;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class Tq {
    public static String ee;
    @SerializedName(value="parse")
    private int B;
    @SerializedName(value="limit")
    private Integer F5;
    @SerializedName(value="jx")
    private int G;
    @SerializedName(value="page")
    private Integer G4;
    @SerializedName(value="msg")
    private String Gc;
    @SerializedName(value="url")
    private Object KJ;
    @SerializedName(value="errMsg")
    private String M;
    @SerializedName(value="filters")
    private LinkedHashMap<String, List<p9>> N;
    @SerializedName(value="list")
    private List<Ef> SN;
    @SerializedName(value="cover")
    private String W;
    @SerializedName(value="pagecount")
    private Integer dT;
    @SerializedName(value="danmaku")
    private String i;
    @SerializedName(value="subs")
    private List<qq_0> q;
    @SerializedName(value="click")
    private String t0;
    @SerializedName(value="header")
    private String tF;
    @SerializedName(value="artwork")
    private String v;
    @SerializedName(value="total")
    private Integer v3;
    @SerializedName(value="class")
    private List<Jz> yq;
    @SerializedName(value="format")
    private String zH;

    public static String G(String string) {
        Tq tq = new Tq();
        tq.Gc = string;
        tq.M = string;
        return tq.toString();
    }

    public static Tq Gc() {
        return new Tq();
    }

    public static String Gd(List<Jz> list, List<Ef> list2, LinkedHashMap<String, List<p9>> linkedHashMap) {
        Tq tq = new Tq();
        tq.yq = list;
        tq.SN = list2;
        tq.N = linkedHashMap;
        return tq.toString();
    }

    public static String M(String charSequence) {
        ee = charSequence;
        Object object = Pan.Nl;
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(ProxyOrigin.getUrl());
            ((StringBuilder)object).append("?do=danmu&act=&url=");
            ((StringBuilder)object).append(URLEncoder.encode((String)charSequence));
            return ((StringBuilder)object).toString();
        }
        if (((Gt)object).tF() && !InitOrigin.context().getPackageName().contains("okys")) {
            object = new StringBuilder();
            ((StringBuilder)object).append(ProxyOrigin.getUrl());
            ((StringBuilder)object).append("?do=danmu&act=&url=");
            ((StringBuilder)object).append(URLEncoder.encode((String)charSequence));
            return ((StringBuilder)object).toString();
        }
        if (Pan.Nl.yq()) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(ProxyOrigin.getUrl());
            ((StringBuilder)charSequence).append("proxy?do=noDanmu");
            return ((StringBuilder)charSequence).toString();
        }
        return "";
    }

    public static String Nl(List<Jz> list, List<Ef> list2, JSONObject jSONObject) {
        Tq tq = new Tq();
        tq.yq = list;
        tq.SN = list2;
        tq.t0(jSONObject);
        return tq.toString();
    }

    public static String OW(List<Jz> list, JSONObject jSONObject) {
        Tq tq = new Tq();
        tq.yq = list;
        tq.t0(jSONObject);
        return tq.toString();
    }

    public static String ee(List<?> list) {
        if (list != null && !list.isEmpty()) {
            if (list.get(0) instanceof Ef) {
                Tq tq = new Tq();
                tq.SN = list;
                return tq.toString();
            }
            if (list.get(0) instanceof Jz) {
                Tq tq = new Tq();
                tq.yq = list;
                return tq.toString();
            }
        }
        return "";
    }

    public static String g9(List<Jz> list, LinkedHashMap<String, List<p9>> linkedHashMap) {
        Tq tq = new Tq();
        tq.yq = list;
        tq.N = linkedHashMap;
        return tq.toString();
    }

    public static String i() {
        Tq tq = new Tq();
        tq.SN = Collections.emptyList();
        tq.Gc = "\u6bd4\u8d5b\u5c1a\u672a\u5f00\u59cb";
        tq.M = "\u6bd4\u8d5b\u5c1a\u672a\u5f00\u59cb";
        return tq.toString();
    }

    public static String v(Ef ef) {
        Tq tq = new Tq();
        tq.un(ef);
        return tq.toString();
    }

    public static String xa(List<Jz> list, List<Ef> list2) {
        Tq tq = new Tq();
        tq.yq = list;
        tq.SN = list2;
        return tq.toString();
    }

    public final Tq B(String string) {
        this.Gc = string;
        this.M = string;
        return this;
    }

    public final Tq F5() {
        this.B = 1;
        return this;
    }

    public final Tq G4() {
        this.zH = "application/octet-stream";
        return this;
    }

    public final Tq KJ(Map<String, String> map) {
        if (map.isEmpty()) {
            return this;
        }
        this.tF = new Gson().toJson(map);
        return this;
    }

    public final Tq N(String string) {
        this.W = string;
        return this;
    }

    public final Tq O(List<qq_0> list) {
        this.q = list;
        return this;
    }

    public final Tq SN(List<Jz> list) {
        this.yq = list;
        return this;
    }

    public final String W() {
        return this.toString();
    }

    public final Tq b(List<Ef> list) {
        this.SN = list;
        return this;
    }

    public final Tq dT(int n2, int n3, int n4, int n5) {
        if (n2 <= 0) {
            n2 = Integer.MAX_VALUE;
        }
        this.G4 = n2;
        if (n4 <= 0) {
            n4 = Integer.MAX_VALUE;
        }
        this.F5 = n4;
        if (n5 <= 0) {
            n5 = Integer.MAX_VALUE;
        }
        this.v3 = n5;
        if (n3 <= 0) {
            n3 = Integer.MAX_VALUE;
        }
        this.dT = n3;
        return this;
    }

    public final Tq g1(String string) {
        this.KJ = string;
        if (!string.isEmpty()) {
            this.i = Tq.M(string);
        }
        return this;
    }

    public final Tq n(List<String> list) {
        this.KJ = list;
        return this;
    }

    public final Tq q() {
        this.G = 1;
        return this;
    }

    public final Tq s(String string, boolean bl) {
        this.KJ = string;
        if (!string.isEmpty() && bl) {
            this.i = Tq.M(string);
        }
        return this;
    }

    public final Tq t0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return this;
        }
        Type type = new TypeToken<LinkedHashMap<String, List<p9>>>(){}.getType();
        this.N = (LinkedHashMap)new Gson().fromJson(jSONObject.toString(), type);
        return this;
    }

    public final Tq tF(String string) {
        this.i = string;
        return this;
    }

    public final String toString() {
        return new Gson().newBuilder().disableHtmlEscaping().create().toJson((Object)this);
    }

    public final Tq un(Ef ef) {
        this.SN = Arrays.asList(ef);
        return this;
    }

    public final Tq v3(int n2) {
        this.B = n2;
        return this;
    }

    public final Tq yq(String string) {
        this.v = string;
        return this;
    }

    public final Tq zH() {
        this.zH = "application/dash+xml";
        return this;
    }
}

