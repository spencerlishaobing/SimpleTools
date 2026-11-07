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
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.w2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class Cloud_uc
extends Spider {
    private static String N = "";
    public static boolean tF;
    private final Pattern SN;
    private final Pattern yq = Pattern.compile("/s/([^/]+)#(/list/share/([^/]+))?");

    public Cloud_uc() {
        this.SN = Pattern.compile("/s/([^/]+)");
    }

    public static Object[] proxy(Map<String, String> map) {
        String string = map.get("type");
        if (string.equals("sub")) {
            return i3.s().cp(map);
        }
        if (string.equals("302")) {
            return i3.s().L();
        }
        if (string.equals("input")) {
            return i3.s().mG(map);
        }
        return null;
    }

    public static Object[] proxys(Map<String, String> map, Map<String, String> map2, String string) {
        return i3.s().Cu(map, map2);
    }

    public String detailContent(List<String> object) {
        if ((object = this.detailVideo((List<String>)object, "")) == null) {
            return "";
        }
        return Tq.v((Ef)object);
    }

    public Ef detailVideo(List<String> object, String string) {
        Object object2;
        if (ME.ee(i3.s().Gc) || ME.ee(i3.s().F5.SN()) && N.contains("\u667a")) {
            N = "";
        }
        String string2 = object.get(0).trim().replace("?public=1", "");
        object = object2 = this.yq.matcher(string2);
        if (!((Matcher)object2).find()) {
            object = object2 = this.SN.matcher(string2);
            if (!((Matcher)object2).find()) {
                return null;
            }
        }
        object2 = ((Matcher)object).group(1);
        if (((Matcher)object).groupCount() == 3) {
            ((Matcher)object).group(3);
        }
        return i3.s().p((String)object2, string);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void init(Context object, String object2) {
        Objects.requireNonNull(i3.s());
        try {
            Object object3;
            boolean bl;
            block15: {
                block14: {
                    bl = ME.ee((String)object2);
                    if (bl) break block14;
                    object = new JSONObject((String)object2);
                    object = object.optString("Cloud-drive");
                    bl = ((String)object).startsWith("./");
                    object2 = object;
                    if (bl) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append(ProxyOrigin.getFileUrl());
                        ((StringBuilder)object2).append(((String)object).replace(".", ""));
                        object2 = Bo.B(((StringBuilder)object2).toString(), null);
                        object = new JSONObject((String)object2);
                        object2 = object.optString("ucCookie");
                        i3.s().F5.KJ(object.optString("ucToken"));
                    }
                    object = object2;
                    if (((String)object2).startsWith("http")) {
                        object = w2.v((String)object2, null, 3);
                        object3 = new JSONObject((String)object);
                        object = object2 = object3.optString("ucCookie");
                        if (!ME.ee(object3.optString("ucToken"))) {
                            i3.s().F5.KJ(object3.optString("ucToken"));
                            object = object2;
                        }
                    }
                    break block15;
                }
                object = "";
            }
            object2 = object;
            if (!((String)object).contains("pus")) {
                object2 = "";
            }
            object = new ArrayList();
            object3 = InitOrigin.context();
            InitOrigin.context();
            object3 = object3.getSharedPreferences("pan_source_sort", 0).getString("sort", "");
            bl = TextUtils.isEmpty((CharSequence)object3);
            if (!bl) {
                object3 = ((String)object3).split("\\|");
                int n = Math.min(((Object)object3).length, 2);
                for (int i2 = 0; i2 < n; ++i2) {
                    if ("4K".equalsIgnoreCase((String)object3[i2])) {
                        if (((Object)object3).length == 3 && i2 == 0 || ((Object)object3).length == 2 && ((String)object3[1]).equals("uc")) {
                            ((ArrayList)object).add("\u4f18\u6c50\u667a");
                        } else {
                            ((ArrayList)object).add("\u4f18\u6c50\u65e0\u9650");
                        }
                    }
                    if (!"AUTO".equalsIgnoreCase((String)object3[i2])) continue;
                    if (((Object)object3).length == 3 && i2 == 1) {
                        ((ArrayList)object).add("\u4f18\u6c50\u65e0\u9650");
                        continue;
                    }
                    ((ArrayList)object).add("\u4f18\u6c50\u667a");
                }
            }
        }
        catch (Exception exception) {
            return;
        }
        {
            if (((ArrayList)object).isEmpty()) {
                ((ArrayList)object).add("\u4f18\u6c50\u667a");
                ((ArrayList)object).add("\u4f18\u6c50\u65e0\u9650");
            }
            i3.s().s0((String)object2, (List<String>)object);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String playerContent(String string, String charSequence, List<String> list) {
        try {
            block11: {
                block10: {
                    boolean bl;
                    if (!tF && !ME.ee(i3.s().Gc)) {
                        if (!i3.s().ee()) {
                            tF = true;
                            return Pan.msg("\u672a\u626b\u7801\u6388\u6743\u65e0\u6cd5\u64ad\u653e\uff0c\u521a\u5df2\u626b\u7801\u7684\u8bf7\u5237\u65b0").toString();
                        }
                        bl = i3.s().ee;
                        tF = true;
                    }
                    if ((bl = ME.ee(i3.s().Gc)) || ME.ee(i3.s().OW)) break block10;
                    if (ME.ee(i3.s().F5.SN()) && string.contains("\u667a")) {
                        if (!N.replaceAll("[\u667a\u5b58]", "").equals(string.replaceAll("[\u667a\u5b58]", ""))) {
                            i3.s().u7();
                            N = string;
                        }
                        break block11;
                    } else if (!i3.s().yq) {
                        i3.s().OB();
                    }
                    break block11;
                }
                if (!N.replaceAll("[\u667a\u65e0\u9650\u5b58]", "").equals(string.replaceAll("[\u667a\u65e0\u9650\u5b58]", ""))) {
                    i3.s().ee();
                }
                if (ME.ee(i3.s().F5.SN()) && string.contains("\u667a") && !ME.ee(i3.s().Gc) && !N.replaceAll("[\u667a\u65e0\u9650\u5b58]", "").equals(string.replaceAll("[\u667a\u65e0\u9650\u5b58]", ""))) {
                    Thread.sleep(1000L);
                    i3.s().u7();
                }
                N = string;
                tF = true;
            }
            QB.G4 = string;
            return i3.s().LY((String)charSequence, string);
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(((Object)exception).toString());
            ((StringBuilder)charSequence).append("---");
            InitOrigin.show(((StringBuilder)charSequence).toString());
            return "";
        }
    }

    public void setFlag(String string) {
        N = "";
    }
}

