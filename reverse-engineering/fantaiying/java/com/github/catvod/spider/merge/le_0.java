/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import android.net.Uri;
import android.text.TextUtils;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.eY;
import com.google.gson.annotations.SerializedName;
import java.net.URLEncoder;
import java.util.AbstractMap;
import java.util.LinkedHashMap;

/*
 * Renamed from com.github.catvod.spider.merge.Le
 */
public final class le_0 {
    @SerializedName(value="sub_url")
    private String N;
    @SerializedName(value="img_url")
    private String SN;
    private final int[] yq = new int[]{46, 47, 18, 2, 53, 8, 23, 32, 15, 50, 10, 31, 58, 3, 45, 35, 27, 43, 5, 49, 33, 9, 42, 19, 29, 28, 14, 39, 12, 38, 41, 13, 37, 48, 7, 16, 24, 55, 40, 61, 26, 17, 0, 1, 60, 51, 30, 4, 22, 25, 54, 21, 56, 59, 6, 63, 57, 62, 11, 36, 20, 34, 44, 52};

    public final String yq(LinkedHashMap<String, Object> object) {
        boolean bl = TextUtils.isEmpty((CharSequence)this.SN);
        String charSequence2 = "";
        Object object2 = bl ? "" : this.SN;
        object2 = Uri.parse((String)object2).getLastPathSegment().split("\\.");
        String string = object2[0];
        object2 = TextUtils.isEmpty((CharSequence)this.N) ? charSequence2 : this.N;
        object2 = eY.yq(string, Uri.parse((String)object2).getLastPathSegment().split("\\.")[0]);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < 32; ++i2) {
            stringBuilder.append(object2.charAt(this.yq[i2]));
        }
        object2 = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        ((AbstractMap)object).put("wts", System.currentTimeMillis() / 1000L);
        for (String string2 : ((LinkedHashMap)object).keySet()) {
            stringBuilder2.append(string2);
            stringBuilder2.append("=");
            stringBuilder2.append(URLEncoder.encode(((LinkedHashMap)object).get(string2).toString()));
            stringBuilder2.append("&");
        }
        object = ME.s(stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append((String)object);
        stringBuilder3.append((String)object2);
        return Z.SN((String)object, "&w_rid=", ME.zH(stringBuilder3.toString()));
    }
}

