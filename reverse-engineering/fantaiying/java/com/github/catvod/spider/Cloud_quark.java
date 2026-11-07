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
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.QB;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.w2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class Cloud_quark
extends Spider {
    private static String N = "";
    public static boolean tF;
    private final Pattern SN;
    private final Pattern yq = Pattern.compile("/s/([^/]+)#(/list/share/([^/]+))?");

    public Cloud_quark() {
        this.SN = Pattern.compile("/s/([^/]+)");
    }

    public static Object[] proxy(Map<String, String> map) {
        String string = map.get("type");
        if (string.equals("sub")) {
            return N0.Zm().OB(map);
        }
        if (string.equals("302")) {
            return N0.Zm().u7();
        }
        string.equals("play");
        if (string.equals("input")) {
            return N0.Zm().o(map);
        }
        return null;
    }

    public static Object[] proxys(Map<String, String> map, Map<String, String> map2, String string) {
        return N0.Zm().cS(map, map2);
    }

    public String detailContent(List<String> object) {
        if ((object = this.detailVideo((List<String>)object, "")) == null) {
            return "";
        }
        return Tq.v((Ef)object);
    }

    public Ef detailVideo(List<String> object, String string) {
        if (ME.ee(N0.Zm().F5)) {
            N = "";
        }
        String string2 = object.get(0).trim().replace("?entry=funletu", "");
        Matcher matcher = this.yq.matcher(string2);
        object = matcher;
        if (!matcher.find()) {
            matcher = this.SN.matcher(string2);
            object = matcher;
            if (!matcher.find()) {
                return null;
            }
        }
        object = ((Matcher)object).group(1);
        return N0.Zm().XO((String)object, string);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void init(Context object, String object2) {
        block21: {
            boolean bl;
            block20: {
                block19: {
                    block17: {
                        block18: {
                            Objects.requireNonNull(N0.Zm());
                            bl = ME.ee((String)object2);
                            if (bl) break block17;
                            object = new JSONObject((String)object2);
                            object = object.optString("Cloud-drive");
                            bl = ((String)object).startsWith("./");
                            object2 = object;
                            if (!bl) break block18;
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append(ProxyOrigin.getFileUrl());
                            ((StringBuilder)object2).append(((String)object).replace(".", ""));
                            object = Bo.B(((StringBuilder)object2).toString(), null);
                            object2 = new JSONObject((String)object);
                            object2 = object2.getString("quarkCookie");
                        }
                        object = object2;
                        if (!((String)object2).startsWith("http")) break block19;
                        object = object2 = w2.v((String)object2, null, 3);
                        if (((String)object2).contains("quarkCookie")) {
                            object = new JSONObject((String)object2);
                            object = object.optString("quarkCookie");
                        }
                        break block19;
                    }
                    object = "";
                }
                object2 = object;
                if (((String)object).contains("pus")) break block20;
                object2 = "";
            }
            object = new ArrayList();
            Object object3 = InitOrigin.context();
            InitOrigin.context();
            object3 = object3.getSharedPreferences("pan_source_sort", 0).getString("sort", "");
            bl = TextUtils.isEmpty((CharSequence)object3);
            if (bl) break block21;
            object3 = ((String)object3).split("\\|");
            int n = Math.min(((Object)object3).length, 2);
            for (int i2 = 0; i2 < n; ++i2) {
                if ("4K".equalsIgnoreCase((String)object3[i2])) {
                    ((ArrayList)object).add("\u5938\u7236\u539f");
                }
                if (!"AUTO".equalsIgnoreCase((String)object3[i2])) continue;
                ((ArrayList)object).add("\u5938\u7236\u667a");
                continue;
            }
        }
        try {
            if (((ArrayList)object).isEmpty()) {
                ((ArrayList)object).add("\u5938\u7236\u539f");
                ((ArrayList)object).add("\u5938\u7236\u667a");
            }
            N0.Zm().s0((String)object2, (List<String>)object);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public String playerContent(String string, String string2, List<String> list) {
        try {
            if (!tF && !ME.ee(N0.Zm().F5)) {
                if (N0.Zm().Gd()) {
                    boolean bl = N0.Zm().g9;
                    tF = true;
                } else {
                    tF = true;
                    return Pan.msg("\u672a\u626b\u7801\u6388\u6743\u65e0\u6cd5\u64ad\u653e\uff0c\u521a\u5df2\u626b\u7801\u7684\u8bf7\u5237\u65b0").toString();
                }
            }
            if ((ME.ee(N0.Zm().F5) || ME.ee(N0.Zm().W)) && !N.replaceAll("[\u667a\u539f\u5b58]", "").equals(string.replaceAll("[\u667a\u539f\u5b58]", ""))) {
                N0.Zm().Gd();
                N = string;
                tF = true;
            }
            QB.G4 = string;
            string = N0.Zm().Cu(string2, string);
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public void setFlag(String string) {
        N = "";
    }
}

