/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import android.util.Base64;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.M4;
import com.github.catvod.spider.merge.V;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.zh_0;
import java.net.URL;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.json.JSONException;
import org.json.JSONObject;

public final class HG {
    private static final Set<String> SN;
    private static final Set<String> yq;

    static {
        yq = new HashSet<String>(Arrays.asList("domain", "expires", "max-age", "path", "httponly", "secure", "samesite"));
        SN = new HashSet<String>(Arrays.asList("DedeUserID", "DedeUserID__ckMd5", "SESSDATA", "bili_jct", "sid"));
    }

    public static String N(Map<String, List<String>> object3) {
        List<String> list = w2.i((Map<String, List<String>>)object3);
        if (list != null && !list.isEmpty()) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
            for (String string : list) {
                String string2;
                String string3;
                int n2;
                String[] stringArray;
                if (TextUtils.isEmpty((CharSequence)string) || (stringArray = string.split(";")).length == 0 || (n2 = (string3 = stringArray[0].trim()).indexOf(61)) <= 0 || ((HashSet)yq).contains((string2 = string3.substring(0, n2).trim()).toLowerCase())) continue;
                ((AbstractMap)linkedHashMap).put(string2, string3.substring(n2 + 1).trim());
            }
            if (((AbstractMap)linkedHashMap).isEmpty()) {
                return "";
            }
            list = new StringBuilder();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (((StringBuilder)((Object)list)).length() > 0) {
                    ((StringBuilder)((Object)list)).append(";");
                }
                ((StringBuilder)((Object)list)).append((String)entry.getKey());
                ((StringBuilder)((Object)list)).append("=");
                ((StringBuilder)((Object)list)).append((String)entry.getValue());
            }
            return ((StringBuilder)((Object)list)).toString();
        }
        return "";
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static String SN(long var0, String var2_1) {
        var5_2 /* !! */  = new StringBuilder();
        var5_2 /* !! */ .append("https://www.bilibili.com/correspond/1/");
        var4_3 = new X509EncodedKeySpec(Base64.decode((String)"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDLgd2OAkcGVtoE3ThUREbio0EgUc/prcajMKXvkCKFCWhJYJcLkcM2DKKcSeFpD/j6Boy538YXnR6VhcuUJOhH2x71nzPjfdTcqMz7djHum0qSZA0AyCBDABUqCrfNgCiJ00Ra7GmRj+YCK1NJEuewlb40JNrRuoEUXpabUzGB8QIDAQAB", (int)0));
        var6_6 = KeyFactory.getInstance("RSA").generatePublic((KeySpec)var4_3);
        var4_3 = Cipher.getInstance("RSA/ECB/OAEPPadding");
        var7_7 = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
        var4_3.init(1, (Key)var6_6, var7_7);
        var6_6 = new StringBuilder();
        var6_6.append("refresh_");
        var6_6.append(var0);
        var6_6 = var4_3.doFinal(var6_6.toString().getBytes());
        var4_3 = new StringBuilder(((Object)var6_6).length * 2);
        ** for (var3_5 = 0;
        ; var3_5 < ((Object)var6_6).length; ++var3_5)
lbl-1000:
        // 1 sources

        {
            if ((var6_6[var3_5] & 255) >= 16) ** GOTO lbl22
            var4_3.append("0");
lbl22:
            // 2 sources

            var4_3.append(Long.toString(var6_6[var3_5] & 255, 16));
            continue;
        }
lbl25:
        // 1 sources

        try {
            var4_3 = var4_3.toString();
        }
        catch (Exception var4_4) {
            var4_4.printStackTrace();
            var4_3 = "";
        }
        var5_2 /* !! */ .append((String)var4_3);
        var5_2 /* !! */  = var5_2 /* !! */ .toString();
        var4_3 = V.tF("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36", "Referer", "https://www.bilibili.com");
        var4_3.put("cookie", var2_1);
        var2_1 = Bo.B((String)var5_2 /* !! */ , (Map)var4_3);
        var2_1 = Pattern.compile("<div +id=\"1-name\">(.+?)</div>").matcher((CharSequence)var2_1);
        if (!var2_1.find()) {
            return "";
        }
        return var2_1.group(1).trim();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String tF(String string) {
        int n2;
        int n3;
        String string2;
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        String string3 = M4.tF(M4.SN("bili_refresh_token"));
        if (TextUtils.isEmpty((CharSequence)string3)) {
            return null;
        }
        Object object = V.tF("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36", "Referer", "https://www.bilibili.com");
        ((HashMap)object).put("cookie", string);
        String[] stringArray = Bo.B("https://passport.bilibili.com/x/passport-login/web/cookie/info", (Map)object);
        try {
            object = new JSONObject((String)stringArray);
            object = object.getJSONObject("data");
            if (!object.getBoolean("refresh")) {
                System.out.println("bili \u65e0\u9700\u5237\u65b0token");
                return null;
            }
            string2 = HG.SN(object.getLong("timestamp"), string);
            if (TextUtils.isEmpty((CharSequence)string2)) {
                System.out.println("bili getRefreshCsrf fail");
                return null;
            }
            System.out.println("bili getRefreshCsrf success");
            object = "";
            stringArray = string.split(";");
            n3 = stringArray.length;
            n2 = 0;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return null;
        }
        while (n2 < n3) {
            String string4 = stringArray[n2];
            {
                if (string4.startsWith("bili_jct")) {
                    object = string4.split("=")[1];
                }
                ++n2;
            }
        }
        return HG.zH(string2, (String)object, string3, string);
    }

    public static String yq(String object) {
        block12: {
            String string;
            block11: {
                if (TextUtils.isEmpty((CharSequence)object)) {
                    return "";
                }
                URL object22 = new URL((String)object);
                string = object22.getQuery();
                if (!TextUtils.isEmpty((CharSequence)string)) break block11;
                return "";
            }
            object = new LinkedHashMap();
            for (String string2 : string.split("&")) {
                int n2 = string2.indexOf(61);
                if (n2 <= 0) continue;
                String string3 = string2.substring(0, n2);
                if (!((HashSet)SN).contains(string3)) continue;
                ((AbstractMap)object).put(string3, string2.substring(n2 + 1));
            }
            if (!((AbstractMap)object).isEmpty()) break block12;
            return "";
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry entry : ((LinkedHashMap)object).entrySet()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(";");
                }
                stringBuilder.append((String)entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append((String)entry.getValue());
            }
            object = stringBuilder.toString();
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    private static String zH(String object, String string, String string2, String string3) {
        object = zh_0.N("https://passport.bilibili.com/x/passport-login/web/cookie/refresh?csrf=", string, "&refresh_csrf=", (String)object, "&source=main_web&refresh_token=");
        ((StringBuilder)object).append(string2);
        string = ((StringBuilder)object).toString();
        object = V.tF("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36", "Referer", "https://www.bilibili.com");
        ((HashMap)object).put("cookie", string3);
        object = w2.dT(string, null, (Map<String, String>)object);
        try {
            string = new JSONObject(object.body().string());
            string = string.getJSONObject("data");
            if (string.getInt("status") == 0) {
                string = string.getString("refresh_token");
                if (!TextUtils.isEmpty((CharSequence)(object = HG.N(object.headers().toMultimap())))) {
                    System.out.println("bili refreshCookie success");
                    M4.i(M4.SN("bili_refresh_token"), string);
                    M4.i(M4.SN("bili"), (String)object);
                    return object;
                }
            }
            return null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}

