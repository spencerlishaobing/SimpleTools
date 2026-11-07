/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.view.View
 *  android.view.Window
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.spider.Kanqiu;
import com.github.catvod.spider.merge.Cr;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.ID;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.lm;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONObject;

public class \u062d\u062e\ufe8e\u0645 {
    public static int \ufead\ufec5\ufe99\u062d = -512;

    public static String \u062d\ufeab\u0642\u0647(short[] sArray, int n2, int n3, int n4) {
        char[] cArray = new char[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            cArray[i2] = (char)(sArray[n2 + i2] ^ n4);
        }
        return new String(cArray);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static StringBuilder \u0630\ufe9d\ufec5\ufe95(Object object, int n2) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() < 0) return null;
        return ((StringBuilder)object).append(n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0631\u063a\u0647\ufead(String object) {
        int n2 = 0;
        String string = "";
        String string2 = "";
        int n3 = 0;
        while (true) {
            if (n3 >= 15) break;
            string = new StringBuffer().append(string).append(Integer.toHexString(n3)).toString();
            string2 = new StringBuffer().append(string2).append((int)(Math.random() * (double)10) ^ n3).toString();
            ++n3;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((String)object).length() / 2);
        n3 = 0;
        while (true) {
            if (n3 >= ((String)object).length()) break;
            byteArrayOutputStream.write(string.indexOf(((String)object).charAt(n3)) << 4 | string.indexOf(((String)object).charAt(n3 + 1)));
            n3 += 2;
        }
        object = byteArrayOutputStream.toByteArray();
        int n4 = ((Object)object).length;
        int n5 = string2.length();
        n3 = 0;
        while (true) {
            if (n3 >= n4) break;
            object[n3] = (byte)(object[n3] ^ string2.charAt(n3 % n5));
            ++n3;
        }
        n3 = n2;
        while (n3 < ((Object)object).length) {
            n3 = "".length() + 1;
        }
        return new String((byte[])object);
    }

    public static void \u0633\u0632\ufec5\u0642(Object object, Object object2, Object object3) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() >= 0) {
            U7.q((JSONArray)object, (JSONObject)object2, (String)object3);
        }
    }

    public static void \u0635\u062c\ufeaf\ufea1(Object object, Object object2) {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() < 0) {
            ((H7)object).Dr((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0635\u0648\ufe95\u0639(Object object, Object object2) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() <= 0) return false;
        return ((HashSet)object).add(object2);
    }

    public static int \u0637\ufea1\ufed5\ufeab() {
        return 0x2FE ^ \ufea1\u0645\u062b\u0634.\ufec5\ufef1\ufebd\u0643;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0638\u0646\ufeed\u0637(Object object) {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() < 0) return false;
        return ((N0)object).Gd();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0638\ufe99\u063a\u0627() {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return null;
        return "{\"1\":[{\"name\":\"\u7c7b\u578b\",\"key\":\"tid\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"1\"},{\"n\":\"\u52a8\u4f5c\u7247\",\"v\":\"5\"},{\"n\":\"\u559c\u5267\u7247\",\"v\":\"6\"},{\"n\":\"\u7231\u60c5\u7247\",\"v\":\"7\"},{\"n\":\"\u79d1\u5e7b\u7247\",\"v\":\"8\"},{\"n\":\"\u6050\u6016\u7247\",\"v\":\"9\"},{\"n\":\"\u5267\u60c5\u7247\",\"v\":\"10\"},{\"n\":\"\u6218\u4e89\u7247\",\"v\":\"11\"},{\"n\":\"\u60ca\u609a\u7247\",\"v\":\"16\"},{\"n\":\"\u5947\u5e7b\u7247\",\"v\":\"17\"}]},{\"name\":\"\u5e74\u4efd\",\"key\":\"year\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2026\",\"v\":\"2026\"},{\"n\":\"2025\",\"v\":\"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"}]},{\"name\":\"\u5730\u533a\",\"key\":\"area\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u5927\u9646\",\"v\":\"\u5927\u9646\"},{\"n\":\"\u9999\u6e2f\",\"v\":\"\u9999\u6e2f\"},{\"n\":\"\u53f0\u6e7e\",\"v\":\"\u53f0\u6e7e\"},{\"n\":\"\u7c73\u56fd\",\"v\":\"\u7c73\u56fd\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u65b0\u52a0\u5761\",\"v\":\"\u65b0\u52a0\u5761\"},{\"n\":\"\u9a6c\u6765\u897f\u4e9a\",\"v\":\"\u9a6c\u6765\u897f\u4e9a\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u52a0\u62ff\u5927\",\"v\":\"\u52a0\u62ff\u5927\"}]},{\"name\":\"\u6392\u5e8f\",\"key\":\"by\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u65f6\u95f4\",\"v\":\"time\"},{\"n\":\"\u4eba\u6c14\",\"v\":\"hits\"},{\"n\":\"\u8bc4\u5206\",\"v\":\"score\"}]}],\"2\":[{\"name\":\"\u7c7b\u578b\",\"key\":\"tid\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"2\"},{\"n\":\"\u56fd\u4ea7\u5267\",\"v\":\"12\"},{\"n\":\"\u6e2f\u53f0\u5267\",\"v\":\"13\"},{\"n\":\"\u65e5\u97e9\u5267\",\"v\":\"14\"},{\"n\":\"\u6b27\u7f8e\u5267\",\"v\":\"15\"}]},{\"name\":\"\u5e74\u4efd\",\"key\":\"year\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2026\",\"v\":\"2026\"},{\"n\":\"2025\",\"v\":\"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"}]},{\"name\":\"\u5730\u533a\",\"key\":\"area\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u5927\u9646\",\"v\":\"\u5927\u9646\"},{\"n\":\"\u9999\u6e2f\",\"v\":\"\u9999\u6e2f\"},{\"n\":\"\u53f0\u6e7e\",\"v\":\"\u53f0\u6e7e\"},{\"n\":\"\u7c73\u56fd\",\"v\":\"\u7c73\u56fd\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u65b0\u52a0\u5761\",\"v\":\"\u65b0\u52a0\u5761\"},{\"n\":\"\u9a6c\u6765\u897f\u4e9a\",\"v\":\"\u9a6c\u6765\u897f\u4e9a\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u52a0\u62ff\u5927\",\"v\":\"\u52a0\u62ff\u5927\"}]},{\"name\":\"\u6392\u5e8f\",\"key\":\"by\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u65f6\u95f4\",\"v\":\"time\"},{\"n\":\"\u4eba\u6c14\",\"v\":\"hits\"},{\"n\":\"\u8bc4\u5206\",\"v\":\"score\"}]}],\"3\":[{\"name\":\"\u7c7b\u578b\",\"key\":\"tid\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"3\"}]},{\"name\":\"\u5e74\u4efd\",\"key\":\"year\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2026\",\"v\":\"2026\"},{\"n\":\"2025\",\"v\":\"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"}]},{\"name\":\"\u5730\u533a\",\"key\":\"area\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u5927\u9646\",\"v\":\"\u5927\u9646\"},{\"n\":\"\u9999\u6e2f\",\"v\":\"\u9999\u6e2f\"},{\"n\":\"\u53f0\u6e7e\",\"v\":\"\u53f0\u6e7e\"},{\"n\":\"\u7c73\u56fd\",\"v\":\"\u7c73\u56fd\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u65b0\u52a0\u5761\",\"v\":\"\u65b0\u52a0\u5761\"},{\"n\":\"\u9a6c\u6765\u897f\u4e9a\",\"v\":\"\u9a6c\u6765\u897f\u4e9a\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u52a0\u62ff\u5927\",\"v\":\"\u52a0\u62ff\u5927\"}]},{\"name\":\"\u6392\u5e8f\",\"key\":\"by\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u65f6\u95f4\",\"v\":\"time\"},{\"n\":\"\u4eba\u6c14\",\"v\":\"hits\"},{\"n\":\"\u8bc4\u5206\",\"v\":\"score\"}]}],\"4\":[{\"name\":\"\u7c7b\u578b\",\"key\":\"tid\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"4\"},{\"n\":\"\u52a8\u6f2b\u5267\",\"v\":\"18\"},{\"n\":\"\u52a8\u6f2b\u7247\",\"v\":\"19\"}]},{\"name\":\"\u5e74\u4efd\",\"key\":\"year\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2026\",\"v\":\"2026\"},{\"n\":\"2025\",\"v\":\"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"}]},{\"name\":\"\u5730\u533a\",\"key\":\"area\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u5927\u9646\",\"v\":\"\u5927\u9646\"},{\"n\":\"\u9999\u6e2f\",\"v\":\"\u9999\u6e2f\"},{\"n\":\"\u53f0\u6e7e\",\"v\":\"\u53f0\u6e7e\"},{\"n\":\"\u7c73\u56fd\",\"v\":\"\u7c73\u56fd\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u65b0\u52a0\u5761\",\"v\":\"\u65b0\u52a0\u5761\"},{\"n\":\"\u9a6c\u6765\u897f\u4e9a\",\"v\":\"\u9a6c\u6765\u897f\u4e9a\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u52a0\u62ff\u5927\",\"v\":\"\u52a0\u62ff\u5927\"}]},{\"name\":\"\u6392\u5e8f\",\"key\":\"by\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u65f6\u95f4\",\"v\":\"time\"},{\"n\":\"\u4eba\u6c14\",\"v\":\"hits\"},{\"n\":\"\u8bc4\u5206\",\"v\":\"score\"}]}]}";
    }

    public static int \u0639\ufee1\u0628\ufe9d(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0640\ufec1\u0632\ufed9(Object object, int n2) {
        if (\u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a() >= 0) return null;
        return ((Matcher)object).group(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0641\ufee9\u0627\ufee1(Object object) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() < 0) return null;
        return ((dl_0)object).G();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static double \u0642\u0634\ufed9\ufed5(Object object) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() > 0) return 0.0;
        return ((n6)object).F5();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Intent \u0642\ufec5\u0634\ufeab(Object object, Object object2, Object object3) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() > 0) return null;
        return ((Intent)object).setDataAndType((Uri)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0643\u062d\u0646\u064a(Object object) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() > 0) return null;
        return Cr.tF((Iterable)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0646\ufef1\u0640\ufeaf(Object object, Object object2, Object object3) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() <= 0) return null;
        return ((Kanqiu)((Object)object)).xxteaDecrypt((byte[])object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u064a\u0631\ufe8f\u0642(Object object) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() <= 0) return 0;
        return ((String)object).hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8f\u0642\u0632\u0630() {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() <= 0) return null;
        return "ut-";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static kb_0 \ufe9d\u062c\ufea5\u0634(Object object, int n2) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() <= 0) return null;
        return ((kb_0)object).N(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea5\ufed9\u0633\u0646(Object object) {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() <= 0) return null;
        return ((lm)object).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static PrintStream \ufead\ufea5\ufec1\u0637() {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() >= 0) return null;
        return System.out;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ID \ufeaf\ufec9\ufea1\u0646(Object object) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() < 0) return null;
        return ((ID)object).M();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeb5\u064a\ufec5\ufe99(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() >= 0) return null;
        return ((tX)object).W();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeb9\u062f\ufee9\u0644() {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() > 0) return null;
        return "https";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static View \ufec9\ufea1\ufeb1\ufec1(Object object) {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() > 0) return null;
        return ((Window)object).getDecorView();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \ufecd\u0643\u0641\ufebd(Object hashMap, Object object, int n2) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() <= 0) return null;
        return ME.N((String)((Object)hashMap), (String)object, n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \ufee1\u0646\ufeb9\u062f(Object hashMap) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() < 0) return null;
        return ((xu_0)((Object)hashMap)).un();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufeed\ufe99\ufeb5\ufec1(Object object, Object object2) {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() <= 0) return false;
        return ((Map)object).containsKey(object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufef1\ufec9\u0644\ufee9() {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() >= 0) return null;
        return "https://api.oplist.org/";
    }
}

