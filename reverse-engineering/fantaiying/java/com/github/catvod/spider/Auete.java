/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Base64
 *  com.github.catvod.crawler.Spider
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Am;
import com.github.catvod.spider.merge.DC;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.TO;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.V;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.uA;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.z2_0;
import java.io.PrintStream;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Auete
extends Spider {
    private JSONObject N;
    private JSONObject SN;
    private Pattern i;
    private Pattern t0;
    private Pattern tF;
    private String yq = "https://auete.cc/";
    private Pattern zH;

    public Auete() {
        new ArrayList();
        this.tF = Pattern.compile("/(\\w+)/index.html");
        this.zH = Pattern.compile("/(\\w+/\\w+/\\w+)/");
        this.i = Pattern.compile("(/\\w+/\\w+/\\w+/play-\\d+-\\d+.html)");
        this.t0 = Pattern.compile("/index(\\d+).html");
    }

    protected final HashMap<String, String> SN(String object) {
        object = V.tF("method", "GET", "Upgrade-Insecure-Requests", "1");
        ((HashMap)object).put("DNT", "1");
        ((HashMap)object).put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36");
        ((HashMap)object).put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        ((HashMap)object).put("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        return object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String categoryContent(String var1_1, String var2_3, boolean var3_4, HashMap<String, String> var4_5) {
        if (var4_5 == null) ** GOTO lbl36
        try {
            if (var4_5.size() <= 0) ** GOTO lbl36
            var9_6 = var4_5.keySet().iterator();
            var8_7 = "";
lbl6:
            // 3 sources

            while (var9_6.hasNext()) {
                var8_7 = (String)var4_5.get((String)var9_6.next());
                if (var8_7 == null || var8_7.length() == 0 || var8_7 == " ") ** GOTO lbl27
                ** GOTO lbl-1000
            }
            ** GOTO lbl44
        }
        catch (Exception var1_2) {
            System.out.println(var1_2);
            return "";
        }
lbl-1000:
        // 1 sources

        {
            block14: {
                var10_8 = new StringBuilder();
                var10_8.append(this.yq);
                var10_8.append("/");
                var10_8.append((String)var1_1);
                var10_8.append("/");
                var10_8.append((String)var8_7);
                var8_7 = var10_8.toString();
                ** GOTO lbl6
lbl27:
                // 1 sources

                var8_7 = new StringBuilder();
                var8_7.append(this.yq);
                var8_7.append("/");
                var8_7.append((String)var1_1);
                var8_7 = var8_7.toString();
                ** GOTO lbl6
lbl36:
                // 2 sources

                var4_5 = new StringBuilder();
                var4_5.append(this.yq);
                var4_5.append("/");
                var4_5.append((String)var1_1);
                var8_7 = var4_5.toString();
lbl44:
                // 2 sources

                if (var2_3.equals("1")) {
                    var1_1 = new StringBuilder();
                    var1_1.append((String)var8_7);
                    var1_1.append("/index.html");
                } else {
                    var1_1 = new StringBuilder();
                    var1_1.append((String)var8_7);
                    var1_1.append("/index");
                    var1_1.append((String)var2_3);
                    var1_1.append(".html");
                }
                var1_1 = var1_1.toString();
                var9_6 = w2.W((String)var1_1, this.SN((String)var1_1));
                var1_1 = Am.yq((String)var9_6);
                var4_5 = new JSONObject();
                var8_7 = var1_1.cS("ul.pagination li");
                var5_9 = var8_7.size();
                if (var5_9 != 0) break block14;
                var6_10 = var5_9 = Integer.parseInt((String)var2_3);
                ** GOTO lbl-1000
            }
            var5_9 = -1;
            var7_11 = 0;
            while (true) {
                block15: {
                    var6_10 = var5_9;
                    if (var7_11 >= var8_7.size()) break;
                    var11_12 = (hN)var8_7.get(var7_11);
                    Objects.requireNonNull(var11_12);
                    var10_8 = z2_0.yq("a", (hN)var11_12);
                    if (var10_8 == null) break block15;
                    var2_3 = var10_8.Fo();
                    if (var5_9 == -1 && var11_12.p("active")) {
                        var11_12 = this.t0.matcher(var10_8.N("href"));
                        var5_9 = var11_12.find() != false ? Integer.parseInt(var11_12.group(1)) : (var1_1.cS("ul.threadlist li").size() > 0 ? 1 : 0);
                    }
                    if (!var2_3.equals("\u5c3e\u9875")) break block15;
                    var2_3 = this.t0.matcher(var10_8.N("href"));
                    if (var2_3.find()) {
                        var7_11 = Integer.parseInt(var2_3.group(1));
                        var6_10 = var5_9;
                        var5_9 = var7_11;
                    } else {
                        var6_10 = var5_9;
                        break;
                    }
                }
                ++var7_11;
            }
            var5_9 = 0;
        }
lbl-1000:
        // 3 sources

        {
            var8_7 = new JSONArray();
            if (var9_6.contains("\u6ca1\u6709\u627e\u5230\u60a8\u60f3\u8981\u7684\u7ed3\u679c\u54e6")) ** GOTO lbl-1000
            var9_6 = var1_1.cS("ul.threadlist li");
            for (var7_11 = 0; var7_11 < var9_6.size(); ++var7_11) {
                var11_12 = (hN)var9_6.get(var7_11);
                Objects.requireNonNull(var11_12);
                var1_1 = z2_0.yq("h2 a", (hN)var11_12);
                if (var1_1 == null || TO.zH((String)(var10_8 = var1_1.N("title")))) continue;
                var1_1 = z2_0.yq("a.pic img", (hN)var11_12);
                var1_1 = var1_1 == null ? "" : var1_1.N("src");
                var2_3 = z2_0.yq("span.hdtag", (hN)var11_12);
                var2_3 = var2_3 == null ? "" : var2_3.Fo();
                if (!(var11_12 = this.zH.matcher(z2_0.yq("a", (hN)var11_12).N("href"))).find() || (var12_13 = var11_12.group(1)).contains("/jqp/")) continue;
                var11_12 = new JSONObject();
                var11_12.put("vod_id", (Object)var12_13);
                var11_12.put("vod_name", var10_8);
                var11_12.put("vod_pic", var1_1);
                var11_12.put("vod_remarks", var2_3);
                var8_7.put(var11_12);
            }
        }
lbl-1000:
        // 2 sources

        {
            block16: {
                var4_5.put("page", var6_10);
                var4_5.put("pagecount", var5_9);
                var4_5.put("limit", 20);
                if (var5_9 > 1) break block16;
                var5_9 = var8_7.length();
                ** GOTO lbl-1000
            }
            var5_9 *= 20;
        }
lbl-1000:
        // 2 sources

        {
            var4_5.put("total", var5_9);
            var4_5.put("list", var8_7);
            return var4_5.toString();
        }
    }

    /*
     * Unable to fully structure code
     */
    public String detailContent(List<String> var1_1) {
        block79: {
            block76: {
                block65: {
                    block63: {
                        var5_6 = var17_5 = "";
                        var5_6 = var17_5;
                        var4_7 = new StringBuilder();
                        var5_6 = var17_5;
                        var4_7.append(this.yq);
                        var5_6 = var17_5;
                        var4_7.append("/");
                        var5_6 = var17_5;
                        var4_7.append(var1_1.get(0));
                        var5_6 = var17_5;
                        var4_7.append("/");
                        var5_6 = var17_5;
                        var4_7 = var4_7.toString();
                        var5_6 = var17_5;
                        var25_8 = Am.yq(w2.W((String)var4_7, this.SN((String)var4_7)));
                        var5_6 = var17_5;
                        var5_6 = var17_5;
                        var23_9 = new JSONObject();
                        var5_6 = var17_5;
                        var5_6 = var17_5;
                        var24_10 = new JSONObject();
                        var5_6 = var17_5;
                        Objects.requireNonNull(var25_8);
                        var5_6 = var17_5;
                        var10_11 = z2_0.yq("div.detail-main-card", var25_8);
                        var5_6 = var17_5;
                        var6_12 = z2_0.yq("div.detail-poster img", var25_8);
                        var5_6 = var17_5;
                        var4_7 = z2_0.yq("h1.detail-title", var25_8);
                        if (var4_7 == null) {
                            var4_7 = "";
                            break block63;
                        }
                        var5_6 = var17_5;
                        var4_7 = var4_7.Fo().replace("\u300a", "").replace("\u300b", "");
                    }
                    if (var6_12 == null) {
                        var7_13 = "";
                    } else {
                        var5_6 = var17_5;
                        var7_13 = var6_12.N("src");
                    }
                    var9_14 = var7_13;
                    var8_15 = var4_7;
                    if (var10_11 != null) {
                        block64: {
                            var6_12 = var4_7;
                            var5_6 = var17_5;
                            if (!var4_7.isEmpty()) break block64;
                            var5_6 = var17_5;
                            var6_12 = var10_11.N("data-pname");
                        }
                        var9_14 = var7_13;
                        var8_15 = var6_12;
                        var5_6 = var17_5;
                        if (!var7_13.isEmpty()) break block65;
                        var5_6 = var17_5;
                        var9_14 = var10_11.N("data-ppic");
                        var8_15 = var6_12;
                    }
                }
                var5_6 = var17_5;
                var16_16 = var25_8.cS("div.message p");
                var18_17 = "";
                var5_6 = var4_7 = (var15_18 = "");
                var6_12 = var5_6;
                var7_13 = var6_12;
                var10_11 = var7_13;
                var2_19 = 0;
                var11_20 = var7_13;
                var12_21 = var6_12;
                var13_22 = var5_6;
                var14_23 = var4_7;
                var6_12 = var18_17;
                var4_7 = var17_5;
                while (true) {
                    block72: {
                        block75: {
                            block74: {
                                block73: {
                                    block71: {
                                        block70: {
                                            block69: {
                                                block68: {
                                                    block67: {
                                                        block66: {
                                                            var5_6 = var4_7;
                                                            if (var2_19 >= var16_16.size()) break;
                                                            var5_6 = var4_7;
                                                            var17_5 = (hN)var16_16.get(var2_19);
                                                            var5_6 = var4_7;
                                                            if (var17_5.p("detail-section-title")) break block66;
                                                            var5_6 = var4_7;
                                                            if (!var17_5.p("detail-des")) break block67;
                                                            var5_6 = var4_7;
                                                            var6_12 = var17_5.Fo();
                                                        }
                                                        var7_13 = var6_12;
                                                        var17_5 = var15_18;
                                                        var19_24 = var14_23;
                                                        var21_26 = var13_22;
                                                        var20_25 = var11_20;
                                                        var22_27 = var10_11;
                                                        break block72;
                                                    }
                                                    var5_6 = var4_7;
                                                    var7_13 = z2_0.yq("span.detail-label", (hN)var17_5);
                                                    if (var7_13 == null) {
                                                        var18_17 = var4_7;
                                                        break block68;
                                                    }
                                                    var5_6 = var4_7;
                                                    var18_17 = var7_13.Fo();
                                                }
                                                var5_6 = z2_0.yq("b", (hN)var17_5);
                                                if (var5_6 != null) break block69;
                                                var7_13 = var4_7;
                                                break block70;
                                            }
                                            var7_13 = var5_6.Fo();
                                        }
                                        var5_6 = var7_13;
                                        if (var7_13.isEmpty()) {
                                            var5_6 = var17_5.Fo();
                                        }
                                        if (!var18_17.contains("\u5206\u7c7b")) break block71;
                                        var7_13 = var6_12;
                                        var17_5 = var5_6;
                                        var19_24 = var14_23;
                                        var21_26 = var13_22;
                                        var20_25 = var11_20;
                                        var22_27 = var10_11;
                                        break block72;
                                    }
                                    if (!var18_17.contains("\u5bfc\u6f14")) break block73;
                                    var7_13 = var6_12;
                                    var17_5 = var15_18;
                                    var19_24 = var14_23;
                                    var21_26 = var13_22;
                                    var20_25 = var11_20;
                                    var22_27 = var5_6;
                                    break block72;
                                }
                                if (!var18_17.contains("\u4e3b\u6f14")) break block74;
                                var7_13 = var6_12;
                                var17_5 = var15_18;
                                var19_24 = var14_23;
                                var21_26 = var13_22;
                                var20_25 = var5_6;
                                var22_27 = var10_11;
                                break block72;
                            }
                            if (!var18_17.contains("\u5730\u533a")) break block75;
                            var7_13 = var6_12;
                            var17_5 = var15_18;
                            var19_24 = var14_23;
                            var21_26 = var5_6;
                            var20_25 = var11_20;
                            var22_27 = var10_11;
                            break block72;
                        }
                        if (var18_17.contains("\u5e74\u4efd")) {
                            var7_13 = var6_12;
                            var17_5 = var15_18;
                            var19_24 = var5_6;
                            var21_26 = var13_22;
                            var20_25 = var11_20;
                            var22_27 = var10_11;
                            break block72;
                        }
                        var7_13 = var6_12;
                        var17_5 = var15_18;
                        var19_24 = var14_23;
                        var21_26 = var13_22;
                        var20_25 = var11_20;
                        var22_27 = var10_11;
                        if (!var18_17.contains("\u5907\u6ce8")) break block72;
                        var22_27 = var10_11;
                        var20_25 = var11_20;
                        var12_21 = var5_6;
                        var21_26 = var13_22;
                        var19_24 = var14_23;
                        var17_5 = var15_18;
                        var7_13 = var6_12;
                    }
                    ++var2_19;
                    var6_12 = var7_13;
                    var15_18 = var17_5;
                    var14_23 = var19_24;
                    var13_22 = var21_26;
                    var11_20 = var20_25;
                    var10_11 = var22_27;
                }
                var5_6 = var6_12;
                if (!var6_12.isEmpty()) ** GOTO lbl227
                var5_6 = z2_0.yq("div.message p.detail-des", var25_8);
                if (var5_6 != null) break block76;
                var5_6 = var4_7;
                ** GOTO lbl227
            }
            var5_6 = var5_6.Fo();
lbl227:
            // 3 sources

            var24_10.put("vod_id", (Object)var1_1.get(0));
            var24_10.put("vod_name", var8_15);
            var24_10.put("vod_pic", var9_14);
            var24_10.put("type_name", var15_18);
            var24_10.put("vod_year", var14_23);
            var24_10.put("vod_area", (Object)var13_22);
            var24_10.put("vod_remarks", var12_21);
            var24_10.put("vod_actor", var11_20);
            var24_10.put("vod_director", var10_11);
            var24_10.put("vod_content", var5_6);
            var1_1 = new Comparator<String>(this){
                final Auete yq;
                {
                    this.yq = auete;
                }

                @Override
                public int compare(String string, String string2) {
                    int n = 1;
                    try {
                        int n2 = this.yq.SN.getJSONObject(string).getInt("or");
                        int n3 = this.yq.SN.getJSONObject(string2).getInt("or");
                        if (n2 == n3) {
                            return 1;
                        }
                        if (n2 - n3 <= 0) {
                            n = -1;
                        }
                        return n;
                    }
                    catch (JSONException jSONException) {
                        System.out.println((Object)jSONException);
                        return 1;
                    }
                }
            };
            var6_12 = new TreeMap<ArrayList<E>, Object>(var1_1);
            var7_13 = var25_8.cS("div.play-card#player_list");
            var2_19 = 0;
            while (true) {
                block77: {
                    block78: {
                        if (var2_19 >= var7_13.size()) break;
                        var8_15 = (hN)var7_13.get(var2_19);
                        Objects.requireNonNull(var8_15);
                        var1_1 = z2_0.yq("div.card-header span b", (hN)var8_15);
                        if (var1_1 == null) break block77;
                        var5_6 = var1_1.Fo();
                        var3_28 = var5_6.lastIndexOf("\u300f");
                        var1_1 = var5_6;
                        if (var3_28 < 0) ** GOTO lbl266
                        var1_1 = var5_6.substring(var3_28 + 1);
lbl266:
                        // 2 sources

                        var9_14 = this.SN.keys();
                        while (var9_14.hasNext()) {
                            var5_6 = (String)var9_14.next();
                            if (!this.SN.getJSONObject((String)var5_6).getString("sh").equals(var1_1)) continue;
                            var1_1 = var5_6;
                            var3_28 = 1;
                            break block78;
                        }
                        var3_28 = 0;
                    }
                    if (var3_28 == 0) break block77;
                    var8_15 = var8_15.cS("ul.episode-list li > a");
                    var5_6 = new ArrayList();
                    var3_28 = 0;
                    while (true) {
                        if (var3_28 >= var8_15.size()) break;
                        var9_14 = (hN)var8_15.get(var3_28);
                        var10_11 = this.i.matcher(var9_14.N("href"));
                        if (var10_11.find()) {
                            var11_20 = var10_11.group(1);
                            var10_11 = new StringBuilder();
                            var10_11.append(var9_14.Fo());
                            var10_11.append("$");
                            var10_11.append((String)var11_20);
                            var5_6.add(var10_11.toString());
                        }
                        ++var3_28;
                        continue;
                        break;
                    }
                    var5_6 = var5_6.size() > 0 ? TextUtils.join((CharSequence)"#", var5_6) : var4_7;
                    if (var5_6.length() == 0) break block77;
                    var6_12.put(var1_1, var5_6);
                }
                ++var2_19;
            }
            try {
                if (var6_12.size() > 0) {
                    var1_1 = TextUtils.join((CharSequence)"$$$", var6_12.keySet());
                    var5_6 = TextUtils.join((CharSequence)"$$$", var6_12.values());
                    var24_10.put("vod_play_from", (Object)var1_1);
                    var24_10.put("vod_play_url", var5_6);
                }
                var1_1 = new Comparator<String>();
                var1_1.put(var24_10);
                var23_9.put("list", (Object)var1_1);
                var1_1 = var23_9.toString();
                return var1_1;
            }
            catch (Exception var1_2) {}
            break block79;
            catch (Exception var1_3) {
                var4_7 = var5_6;
            }
        }
        System.out.println(var1_4);
        return var4_7;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String homeContent(boolean bl) {
        Object object;
        Object object2;
        int n;
        Object object3 = this.yq;
        object3 = Am.yq(w2.W((String)object3, this.SN((String)object3)));
        Object object4 = System.out;
        Object object5 = new StringBuilder();
        ((StringBuilder)object5).append("doc--");
        ((StringBuilder)object5).append(object3);
        ((PrintStream)object4).println(((StringBuilder)object5).toString());
        object4 = ((hN)object3).cS("ul[class='navbar-nav mr-auto']> li a");
        object5 = new JSONArray();
        JSONArray jSONArray = ((AbstractCollection)object4).iterator();
        while (true) {
            block15: {
                block14: {
                    boolean bl2 = jSONArray.hasNext();
                    n = 0;
                    int n2 = 0;
                    if (!bl2) break;
                    object2 = (hN)jSONArray.next();
                    object4 = ((hN)object2).Fo();
                    if (((String)object4).equals("\u7535\u5f71") || ((String)object4).equals("\u7535\u89c6\u5267") || ((String)object4).equals("\u7efc\u827a") || ((String)object4).equals("\u52a8\u6f2b")) break block14;
                    n = n2;
                    if (!((String)object4).equals("\u5176\u4ed6")) break block15;
                }
                n = 1;
            }
            if (n == 0 || !((Matcher)(object2 = this.tF.matcher(((iK)object2).N("href")))).find()) continue;
            object2 = ((Matcher)object2).group(1).trim();
            object = new JSONObject();
            object.put("type_id", object2);
            object.put("type_name", object4);
            object5.put(object);
        }
        object4 = new JSONObject();
        if (bl) {
            object4.put("filters", (Object)this.N);
        }
        object4.put("class", object5);
        try {
            object2 = ((hN)((AbstractList)((hN)object3).cS("ul.threadlist")).get(0)).cS("li");
            jSONArray = new JSONArray();
            while (n < ((AbstractCollection)object2).size()) {
                Object object6 = (hN)((AbstractList)object2).get(n);
                Objects.requireNonNull(object6);
                object3 = z2_0.yq("h2 a", (hN)object6);
                if (object3 != null && !TO.zH((String)(object = ((iK)object3).N("title")))) {
                    String string;
                    object3 = z2_0.yq("a.pic img", (hN)object6);
                    object3 = object3 == null ? "" : ((iK)object3).N("src");
                    object5 = z2_0.yq("span.hdtag", (hN)object6);
                    object5 = object5 == null ? "" : ((hN)object5).Fo();
                    if (((Matcher)(object6 = this.zH.matcher(z2_0.yq("a", (hN)object6).N("href")))).find() && !(string = ((Matcher)object6).group(1)).contains("/jqp/")) {
                        object6 = new JSONObject();
                        object6.put("vod_id", (Object)string);
                        object6.put("vod_name", object);
                        object6.put("vod_pic", object3);
                        object6.put("vod_remarks", object5);
                        jSONArray.put(object6);
                    }
                }
                ++n;
            }
            object4.put("list", (Object)jSONArray);
            return object4.toString();
        }
        catch (Exception exception) {
            try {
                System.out.println(exception);
                return object4.toString();
            }
            catch (Exception exception2) {
                System.out.println(exception2);
                return "";
            }
        }
    }

    public void init(Context context) {
        super.init(context);
        try {
            context = new JSONObject("{\"byun\":{\"sh\":\"\u4e91\u64adB\u7ebf\",\"pu\":\"\",\"sn\":0,\"or\":999},\"yyun\":{\"sh\":\"\u4e91\u64adY\u7ebf\",\"pu\":\"\",\"sn\":0,\"or\":999},\"cyun\":{\"sh\":\"\u4e91\u64adC\u7ebf\",\"pu\":\"\",\"sn\":0,\"or\":999},\"dbm3u8\":{\"sh\":\"\u4e91\u64adD\u7ebf\",\"pu\":\"\",\"sn\":0,\"or\":999},\"i8i\":{\"sh\":\"\u4e91\u64adE\u7ebf\",\"pu\":\"\",\"sn\":0,\"or\":999},\"m3u8hd\":{\"sh\":\"\u4e91\u64adF\u7ebf\",\"pu\":\"https://haozhansou.com/api/mp.php?url=\",\"sn\":1,\"or\":999},\"oyun\":{\"sh\":\"\u4e91\u64adO\u7ebf\",\"pu\":\"https://haozhansou.com/api/mp.php?url=\",\"sn\":1,\"or\":999},\"languang\":{\"sh\":\"\u4e91\u64adG\u7ebf\",\"pu\":\"https://haozhansou.com/api/mp.php?url=\",\"sn\":1,\"or\":999},\"hyun\":{\"sh\":\"\u4e91\u64adH\u7ebf\",\"pu\":\"https://haozhansou.com/api/mp.php?url=\",\"sn\":1,\"or\":999},\"kyun\":{\"sh\":\"\u4e91\u64adK\u7ebf\",\"pu\":\"https://haozhansou.com/api/mp.php?url=\",\"sn\":1,\"or\":999},\"xun\":{\"sh\":\"\u4e91\u64adX\u7ebf\",\"pu\":\"\",\"sn\":0,\"or\":999},\"bpyueyu\":{\"sh\":\"\u4e91\u64ad\u7ca4\u8bed\",\"pu\":\"\",\"sn\":0,\"or\":999},\"bpguoyu\":{\"sh\":\"\u4e91\u64ad\u56fd\u8bed\",\"pu\":\"\",\"sn\":0,\"or\":999},\"lyun\":{\"sh\":\"\u4e91\u64adL\u7ebf\",\"pu\":\"https://haozhansou.com/api/mp.php?url=\",\"sn\":1,\"or\":999},\"myun\":{\"sh\":\"\u4e91\u64adM\u7ebf\",\"pu\":\"\",\"sn\":0,\"or\":999},\"dp\":{\"sh\":\"Dplayer\",\"pu\":\"\",\"sn\":0,\"or\":999}}");
            this.SN = context;
            context = new JSONObject("{\"Movie\":[{\"key\":0,\"name\":\"\u5206\u7c7b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u559c\u5267\u7247\",\"v\":\"xjp\"},{\"n\":\"\u52a8\u4f5c\u7247\",\"v\":\"dzp\"},{\"n\":\"\u7231\u60c5\u7247\",\"v\":\"aqp\"},{\"n\":\"\u79d1\u5e7b\u7247\",\"v\":\"khp\"},{\"n\":\"\u6050\u6016\u7247\",\"v\":\"kbp\"},{\"n\":\"\u60ca\u609a\u7247\",\"v\":\"jsp\"},{\"n\":\"\u6218\u4e89\u7247\",\"v\":\"zzp\"},{\"n\":\"\u5267\u60c5\u7247\",\"v\":\"jqp\"}]}],\"Tv\":[{\"key\":0,\"name\":\"\u5206\u7c7b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u7f8e\u5267\",\"v\":\"oumei\"},{\"n\":\"\u97e9\u5267\",\"v\":\"hanju\"},{\"n\":\"\u65e5\u5267\",\"v\":\"riju\"},{\"n\":\"\u6cf0\u5267\",\"v\":\"yataiju\"},{\"n\":\"\u7f51\u5267\",\"v\":\"wangju\"},{\"n\":\"\u53f0\u5267\",\"v\":\"taiju\"},{\"n\":\"\u56fd\u4ea7\",\"v\":\"neidi\"},{\"n\":\"\u6e2f\u5267\",\"v\":\"tvbgj\"}]}],\"Zy\":[{\"key\":0,\"name\":\"\u5206\u7c7b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u56fd\u7efc\",\"v\":\"guozong\"},{\"n\":\"\u97e9\u7efc\",\"v\":\"hanzong\"},{\"n\":\"\u7f8e\u7efc\",\"v\":\"meizong\"}]}],\"Dm\":[{\"key\":0,\"name\":\"\u5206\u7c7b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u52a8\u753b\",\"v\":\"donghua\"},{\"n\":\"\u65e5\u6f2b\",\"v\":\"riman\"},{\"n\":\"\u56fd\u6f2b\",\"v\":\"guoman\"},{\"n\":\"\u7f8e\u6f2b\",\"v\":\"meiman\"}]}],\"qita\":[{\"key\":0,\"name\":\"\u5206\u7c7b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u7eaa\u5f55\u7247\",\"v\":\"Jlp\"},{\"n\":\"\u7ecf\u5178\u7247\",\"v\":\"Jdp\"},{\"n\":\"\u7ecf\u5178\u5267\",\"v\":\"Jdj\"},{\"n\":\"\u7f51\u5927\u7535\u5f71\",\"v\":\"wlp\"},{\"n\":\"\u56fd\u4ea7\u8001\u7535\u5f71\",\"v\":\"laodianying\"}]}]}");
            this.N = context;
        }
        catch (JSONException jSONException) {
            System.out.println((Object)jSONException);
        }
    }

    public void init(Context context, String string) {
        super.init(context, string);
        try {
            if (!TextUtils.isEmpty((CharSequence)string)) {
                context = new JSONObject(string);
                if ((string = context.optString("siteUrl")).startsWith("http")) {
                    this.yq = string;
                }
                Arrays.asList(context.optString("filterSpeedUp").split(","));
            }
        }
        catch (Exception exception) {
            InitOrigin.show(exception.getMessage());
        }
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String playerContent(String object, String iterator, List<String> object2) {
        try {
            ProxyOrigin.getan();
            boolean bl = uA.yq;
            int n = 0;
            if (!bl) {
                uA.dT(false);
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(this.yq);
            ((StringBuilder)object).append((String)((Object)iterator));
            object = ((StringBuilder)object).toString();
            object = Am.yq(w2.W((String)object, this.SN((String)object))).cS("div>script");
            JSONObject jSONObject = new JSONObject();
            iterator = ((AbstractCollection)object).iterator();
            block3: while (true) {
                if (!iterator.hasNext()) return jSONObject.toString();
                String[] stringArray = ((hN)iterator.next()).lF().toString().split("var");
                int n2 = stringArray.length;
                int n3 = 0;
                while (true) {
                    block16: {
                        String string;
                        block17: {
                            block18: {
                                if (n3 >= n2) continue block3;
                                string = stringArray[n3];
                                if (!string.contains("=")) break block16;
                                bl = string.trim().startsWith("now");
                                if (!bl) break block17;
                                object = Pattern.compile("now\\s*=\\s*(.*)").matcher(string.trim());
                                if (!((Matcher)object).find()) break block16;
                                String string2 = ((Matcher)object).group(1).replaceAll("\"", "").replaceAll(";", "").trim();
                                object = string2;
                                if (!string2.startsWith("base64")) break block18;
                                object = string2.split("\\(");
                                if (((Object)object).length < 2) break block16;
                                String string3 = ((String)object[1]).split("\\)")[n];
                                int n4 = (4 - string3.length() % 4) % 4;
                                object = string3;
                                if (n4 > 0) {
                                    object = new StringBuilder();
                                    ((StringBuilder)object).append(string3);
                                    ((StringBuilder)object).append("====".substring(n, n4));
                                    object = ((StringBuilder)object).toString();
                                }
                                String string4 = new String(Base64.decode((byte[])((String)object).getBytes(), (int)n));
                                object = string4;
                            }
                            if (bl = ((String)object).startsWith("http")) {
                                void var3_12;
                                jSONObject.put("parse", 0);
                                jSONObject.put("playUrl", (Object)"");
                                if (((String)object).contains("m3u8")) {
                                    String string5 = DC.q((String)object);
                                } else {
                                    Object object3 = object;
                                }
                                jSONObject.put("url", (Object)var3_12);
                                jSONObject.put("header", (Object)"");
                                jSONObject.put("danmaku", (Object)Tq.M((String)object));
                            } else if (((String)object).contains("m3u8")) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("https://datas-s8pwfqdu9yystn90fb----------------cache.haozhansou.com/");
                                stringBuilder.append((String)object);
                                object = stringBuilder.toString();
                                jSONObject.put("parse", 0);
                                jSONObject.put("playUrl", (Object)"");
                                jSONObject.put("url", object);
                                jSONObject.put("header", (Object)"");
                                jSONObject.put("danmaku", (Object)Tq.M((String)object));
                            }
                        }
                        if (string.trim().startsWith("pn") && ((Matcher)(object = Pattern.compile("pn\\s*=\\s*(.*)").matcher(string.trim()))).find()) {
                            Objects.requireNonNull(((Matcher)object).group(1).replaceAll("\"", "").replaceAll(";", ""));
                        }
                    }
                    ++n3;
                    n = 0;
                }
                break;
            }
        }
        catch (Exception exception) {
            System.out.println(exception);
            return "";
        }
    }

    public String searchContent(String string, boolean bl) {
        return this.searchContent(string, bl, "1");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String searchContent(String object, boolean bl, String object2) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.yq);
            stringBuilder.append("auete4so.php?searchword=");
            stringBuilder.append(ME.b((String)object));
            String string = stringBuilder.toString();
            object = string;
            if (!((String)object2).equals("1")) {
                object = new StringBuilder();
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append("&page=");
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
            }
            object = Am.yq(w2.W((String)object, this.SN((String)object)));
            jSONObject = new JSONObject();
            jSONArray = new JSONArray();
            kb_0 kb_02 = ((hN)object).cS("ul.threadlist li");
            for (int i2 = 0; i2 < ((AbstractCollection)kb_02).size(); ++i2) {
                String string2;
                Object object3 = (hN)((AbstractList)kb_02).get(i2);
                Objects.requireNonNull(object3);
                object = z2_0.yq("h2 a", (hN)object3);
                if (object == null || TO.zH(string2 = ((iK)object).N("title"))) continue;
                object = z2_0.yq("a.pic img", (hN)object3);
                object = object == null ? "" : ((iK)object).N("src");
                object2 = z2_0.yq("span.hdtag", (hN)object3);
                object2 = object2 == null ? "" : ((hN)object2).Fo();
                object3 = this.zH.matcher(z2_0.yq("a", (hN)object3).N("href"));
                if (!((Matcher)object3).find() || ((String)(object3 = ((Matcher)object3).group(1))).contains("/jqp/")) continue;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("vod_id", object3);
                jSONObject2.put("vod_name", (Object)string2);
                jSONObject2.put("vod_pic", object);
                jSONObject2.put("vod_remarks", object2);
                jSONArray.put((Object)jSONObject2);
            }
        }
        catch (Exception exception) {
            System.out.println(exception);
            return "";
        }
        {
            jSONObject.put("list", (Object)jSONArray);
            return jSONObject.toString();
        }
    }
}

