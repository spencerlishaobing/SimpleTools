/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  com.google.gson.Gson
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import android.util.Base64;
import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.e7;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public final class k9 {
    @SerializedName(value="t")
    private String N;
    @SerializedName(value="content")
    private k9 SN;
    @SerializedName(value="qrCodeStatus")
    private String i;
    @SerializedName(value="bizExt")
    private String t0;
    @SerializedName(value="ck")
    private String tF;
    @SerializedName(value="data")
    private k9 yq;
    @SerializedName(value="codeContent")
    private String zH;

    public static k9 t0(String object) {
        block3: {
            try {
                Object object2 = new Gson();
                object2 = (k9)object2.fromJson((String)object, k9.class);
                object = object2;
                if (object2 != null) break block3;
            }
            catch (Exception exception) {
                return new k9();
            }
            object = new k9();
        }
        return object;
    }

    public final k9 N() {
        k9 k92;
        k9 k93 = k92 = this.yq;
        if (k92 == null) {
            k93 = new k9();
        }
        return k93;
    }

    public final k9 SN() {
        k9 k92;
        k9 k93 = k92 = this.SN;
        if (k92 == null) {
            k93 = new k9();
        }
        return k93;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean i() {
        String string = this.i;
        String string2 = "";
        String string3 = string;
        if (string == null) {
            string3 = "";
        }
        if (!string3.equals("CONFIRMED")) return false;
        string3 = this.t0;
        if (string3 == null) {
            string3 = string2;
        }
        if (string3.length() <= 0) return false;
        return true;
    }

    public final Map<String, String> tF() {
        String string;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string2 = string = this.N;
        if (string == null) {
            string2 = "";
        }
        hashMap.put("t", string2);
        string2 = string = this.tF;
        if (string == null) {
            string2 = "";
        }
        hashMap.put("ck", string2);
        hashMap.put("appName", "aliyun_drive");
        hashMap.put("appEntrance", "web");
        hashMap.put("isMobile", "false");
        hashMap.put("lang", "zh_CN");
        hashMap.put("returnUrl", "");
        hashMap.put("fromSite", "52");
        hashMap.put("bizParams", "");
        hashMap.put("navlanguage", "zh-CN");
        hashMap.put("navPlatform", "MacIntel");
        return hashMap;
    }

    public final String yq() {
        String string;
        String string2 = string = this.zH;
        if (string == null) {
            string2 = "";
        }
        return string2;
    }

    public final String zH() {
        String string;
        String string2 = string = this.t0;
        if (string == null) {
            string2 = "";
        }
        return ((e7)Z.yq(new String(Base64.decode((String)string2, (int)0)), e7.class)).yq().SN();
    }
}

