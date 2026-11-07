/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.gson.Gson
 *  com.google.gson.annotations.SerializedName
 *  com.google.gson.reflect.TypeToken
 *  com.thegrizzlylabs.sardineandroid.DavResource
 *  com.thegrizzlylabs.sardineandroid.Sardine
 *  com.thegrizzlylabs.sardineandroid.impl.OkHttpSardine
 */
package com.github.catvod.spider.merge;

import android.net.Uri;
import android.text.TextUtils;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.ME;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.thegrizzlylabs.sardineandroid.DavResource;
import com.thegrizzlylabs.sardineandroid.Sardine;
import com.thegrizzlylabs.sardineandroid.impl.OkHttpSardine;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.List;

public final class WN {
    @SerializedName(value="authorization")
    private String Gc;
    private OkHttpSardine KJ;
    @SerializedName(value="webAuthorization")
    private String M;
    @SerializedName(value="user")
    private String N;
    @SerializedName(value="server")
    private String SN;
    @SerializedName(value="base_path")
    private String i;
    @SerializedName(value="search")
    private Boolean t0;
    @SerializedName(value="pass")
    private String tF;
    @SerializedName(value="name")
    private String yq;
    @SerializedName(value="path")
    private String zH;

    public WN(String string) {
        this.yq = string;
    }

    public static List<WN> yq(String string) {
        Type type = new TypeToken<List<WN>>(){}.getType();
        return (List)new Gson().fromJson(string, type);
    }

    public final Boolean B() {
        Boolean bl = this.t0;
        boolean bl2 = bl == null ? false : bl;
        return bl2;
    }

    public final void G(String string) {
        this.i = string;
    }

    public final void G4(String string) {
        this.M = string;
    }

    public final String Gc() {
        String string = TextUtils.isEmpty((CharSequence)this.SN) ? "" : this.SN;
        return string;
    }

    public final String KJ() {
        String string = TextUtils.isEmpty((CharSequence)this.M) ? "" : this.M;
        return string;
    }

    public final String M() {
        String string = TextUtils.isEmpty((CharSequence)this.N) ? "" : this.N;
        return string;
    }

    public final String N() {
        boolean bl = TextUtils.isEmpty((CharSequence)this.i);
        String string = "";
        if (!bl && !this.i.equals("/")) {
            string = this.i;
        }
        return string;
    }

    public final WN SN() {
        if (this.zH == null) {
            String string;
            String string2 = string = Uri.parse((String)this.Gc()).getPath();
            if (TextUtils.isEmpty((CharSequence)string)) {
                string2 = "";
            }
            this.zH = string2;
        }
        return this;
    }

    public final Ef dT(DavResource davResource, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.zH());
        stringBuilder.append(davResource.getPath());
        return new Ef(URLEncoder.encode(stringBuilder.toString()), davResource.getName(), string, ME.v3(davResource.getContentLength().longValue()), davResource.isDirectory());
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WN)) {
            return false;
        }
        object = (WN)object;
        return this.zH().equals(((WN)object).zH());
    }

    public final String i() {
        String string = TextUtils.isEmpty((CharSequence)this.tF) ? "" : this.tF;
        return string;
    }

    public final Sardine q() {
        if (this.KJ == null) {
            Object object;
            this.KJ = object = new OkHttpSardine();
            object.setCredentials(this.M(), this.i());
            String string = Uri.parse((String)this.Gc()).getPath();
            object = string;
            if (TextUtils.isEmpty((CharSequence)string)) {
                object = "";
            }
            this.zH = object;
        }
        return this.KJ;
    }

    public final String t0() {
        String string = ME.ee(this.zH) ? "" : this.zH;
        return string;
    }

    public final String tF() {
        return this.Gc().replace(this.t0(), "");
    }

    public final String zH() {
        String string = TextUtils.isEmpty((CharSequence)this.yq) ? "" : this.yq;
        return string;
    }
}

