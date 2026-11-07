/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.github.catvod.crawler.Spider
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.QB;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.w2;
import java.io.ByteArrayInputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class Cloud_ali
extends Spider {
    public static boolean N;
    private static String SN;
    public static final Pattern yq;

    static {
        yq = Pattern.compile("(www.aliyundrive.com|www.alipan.com)/s/([^/]+)(/folder/([^/]+))?");
        SN = "";
        N = false;
    }

    public static Object[] proxy(Map<String, String> object) {
        String string = object.get("type");
        Object[] objectArray = object.get("flag");
        if (string.equals("sub")) {
            return j_0.v().J((Map<String, String>)object);
        }
        if (string.equals("token")) {
            object = j_0.v();
            Objects.requireNonNull(object);
            return new Object[]{200, "text/plain", new ByteArrayInputStream(((j_0)object).Gc.t0().getBytes())};
        }
        if (string.equals("m3u8")) {
            return j_0.v().R((Map<String, String>)object, (String)objectArray);
        }
        if (string.equals("302")) {
            return j_0.v().xU();
        }
        boolean bl = string.equals("input");
        string = null;
        objectArray = string;
        if (bl) {
            j_0 j_02 = j_0.v();
            Objects.requireNonNull(j_02);
            object = URLDecoder.decode((String)object.get("\u63a8\u9001")).replace(" ", "+");
            objectArray = string;
            if (!TextUtils.isEmpty((CharSequence)object)) {
                Pan.dismissInputQRCode();
                j_02.zH = object;
                InitOrigin.show("\u606d\u559c\uff01Token\u8bbe\u7f6e\u6210\u529f\uff01");
                objectArray = new Object[]{200, "text/html", new ByteArrayInputStream(new byte[0])};
            }
        }
        return objectArray;
    }

    public static Object[] proxys(Map<String, String> map, Map<String, String> map2, String string) {
        return j_0.v().N0(map, map2);
    }

    public String detailContent(List<String> object) {
        if ((object = this.detailVideo((List<String>)object, "")) == null) {
            return "";
        }
        return Tq.v((Ef)object);
    }

    public Ef detailVideo(List<String> object, String string) {
        String string2;
        Matcher matcher;
        boolean bl = ME.ee(j_0.v().Gc.SN());
        String string3 = "";
        if (bl) {
            SN = "";
        }
        if (!(matcher = yq.matcher(string2 = object.get(0).trim())).find()) {
            return null;
        }
        String string4 = matcher.group(2);
        object = string3;
        if (matcher.groupCount() == 4) {
            object = matcher.group(4);
        }
        return j_0.v().H(string2, string4, (String)object, string);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void init(Context var1_1, String var2_2) {
        var1_1 /* !! */  = "";
        Objects.requireNonNull(j_0.v());
        if (ME.ee((String)var2_2)) ** GOTO lbl43
        var6_6 = new JSONObject((String)var2_2);
        var2_2 = var6_6.optString("Cloud-drive");
        var1_1 /* !! */  = var2_2;
        try {
            block13: {
                var5_7 = var2_2.startsWith("./");
                var6_6 = var2_2;
                if (var5_7) {
                    var1_1 /* !! */  = var2_2;
                    var1_1 /* !! */  = var2_2;
                    var6_6 = new StringBuilder();
                    var1_1 /* !! */  = var2_2;
                    var6_6.append(ProxyOrigin.getFileUrl());
                    var1_1 /* !! */  = var2_2;
                    var6_6.append(var2_2.replace(".", ""));
                    var1_1 /* !! */  = var2_2;
                    var6_6 = Bo.B(var6_6.toString(), null);
                    var1_1 /* !! */  = var2_2;
                    var1_1 /* !! */  = var2_2;
                    var7_8 = new JSONObject((String)var6_6);
                    var1_1 /* !! */  = var2_2;
                    var6_6 = var7_8.optString("token");
                }
                var2_2 = var6_6;
                var1_1 /* !! */  = var6_6;
                if (var6_6.startsWith("http")) {
                    var1_1 /* !! */  = var6_6;
                    var2_2 = var6_6 = w2.v((String)var6_6, null, 3);
                    var1_1 /* !! */  = var6_6;
                    if (var6_6.contains("token")) {
                        var1_1 /* !! */  = var6_6;
                        var1_1 /* !! */  = var6_6;
                        var2_2 = new JSONObject((String)var6_6);
                        var1_1 /* !! */  = var6_6;
                        var2_2 = var2_2.optString("token");
                    }
                }
                break block13;
lbl43:
                // 1 sources

                var2_2 = "";
            }
            var6_6 = var2_2;
            var1_1 /* !! */  = var2_2;
            if (var2_2.length() != 32) {
                var6_6 = "";
            }
            var1_1 /* !! */  = var6_6;
            var1_1 /* !! */  = var6_6;
            var2_2 = new ArrayList();
            var1_1 /* !! */  = var6_6;
            var7_8 = InitOrigin.context();
            var1_1 /* !! */  = var6_6;
            InitOrigin.context();
            var1_1 /* !! */  = var6_6;
            var7_8 = var7_8.getSharedPreferences("pan_source_sort", 0).getString("sort", "");
            var1_1 /* !! */  = var6_6;
            if (!TextUtils.isEmpty((CharSequence)var7_8)) {
                var1_1 /* !! */  = var6_6;
                var7_8 = var7_8.split("\\|");
                var1_1 /* !! */  = var6_6;
                var4_10 = Math.min(((Object)var7_8).length, 2);
                for (var3_9 = 0; var3_9 < var4_10; ++var3_9) {
                    var1_1 /* !! */  = var6_6;
                    if ("4K".equalsIgnoreCase((String)var7_8[var3_9])) {
                        var1_1 /* !! */  = var6_6;
                        var2_2.add("\u963f\u72f8\u539f");
                    }
                    var1_1 /* !! */  = var6_6;
                    if (!"AUTO".equalsIgnoreCase((String)var7_8[var3_9])) continue;
                    var1_1 /* !! */  = var6_6;
                    var2_2.add("\u963f\u72f8\u667a");
                }
            }
            var1_1 /* !! */  = var6_6;
            if (var2_2.isEmpty()) {
                var1_1 /* !! */  = var6_6;
                var2_2.add("\u963f\u72f8\u539f");
                var1_1 /* !! */  = var6_6;
                var2_2.add("\u963f\u72f8\u667a");
            }
            var1_1 /* !! */  = var6_6;
            j_0.v().Q4((String)var6_6, (List<String>)var2_2);
            return;
        }
        catch (Exception var2_3) {}
        ** GOTO lbl-1000
        catch (Exception var2_5) {}
lbl-1000:
        // 2 sources

        {
            var2_4 = new ArrayList<String>();
            var2_4.add("\u963f\u72f8\u539f");
            var2_4.add("\u963f\u72f8\u667a");
            j_0.v().Q4((String)var1_1 /* !! */ , var2_4);
        }
    }

    public String playerContent(String string, String string2, List<String> list) {
        if (!(N || ME.ee(j_0.v().Gc.t0()) && ME.ee(j_0.v().zH))) {
            j_0.v().G4();
            N = true;
        }
        if (ME.ee(j_0.v().Gc.SN()) && !SN.replaceAll("[\u667a\u539f\u5b58]", "").equals(string.replaceAll("[\u667a\u539f\u5b58]", ""))) {
            j_0.v().G4();
            SN = string;
            N = true;
        }
        QB.G4 = string;
        return j_0.v().Z(string2, string);
    }

    public void setFlag(String string) {
        SN = "";
    }
}

