/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.view.View
 */
package com.github.catvod.spider.merge;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.AppYsV2;
import com.github.catvod.spider.Bili;
import com.github.catvod.spider.Cloud_uc;
import com.github.catvod.spider.Hmys;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.XM;
import com.github.catvod.spider.merge.ak;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.fk;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class \u0641\u0631\ufeed\u0643 {
    public static int \ufeab\ufeed\u0638\u062b = 755;

    /*
     * Enabled aggressive block sorting
     */
    public static String \u062b\ufed9\ufeb1\u0632(String string) {
        int n2 = 0;
        Object object = "";
        String string2 = "";
        int n3 = 0;
        while (true) {
            if (n3 >= 15) break;
            object = new StringBuffer().append((String)object).append(Integer.toHexString(n3)).toString();
            string2 = new StringBuffer().append(string2).append((int)(Math.random() * (double)10) ^ n3).toString();
            ++n3;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(string.length() / 2);
        n3 = 0;
        while (true) {
            if (n3 >= string.length()) break;
            byteArrayOutputStream.write(((String)object).indexOf(string.charAt(n3)) << 4 | ((String)object).indexOf(string.charAt(n3 + 1)));
            n3 += 2;
        }
        object = byteArrayOutputStream.toByteArray();
        string = "a";
        while (true) {
            if (string.length() <= 0) break;
            string = "";
            if ("".length() != 0) continue;
            string = "a";
        }
        int n4 = string.length();
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062c\u0643\ufeb5\ufea5() {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return null;
        return "{\"1\":[{\"name\":\"\u5730\u533a\",\"key\":\"area\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u4e2d\u56fd\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u4e2d\u56fd\u9999\u6e2f\",\"v\":\"\u4e2d\u56fd\u9999\u6e2f\"},{\"n\":\"\u4e2d\u56fd\u53f0\u6e7e\",\"v\":\"\u4e2d\u56fd\u53f0\u6e7e\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"name\":\"\u5e74\u4efd\",\"key\":\"year\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"},{\"n\":\"2009~2000\",\"v\":\"2009~2000\"},{\"n\":\"90\u5e74\u4ee3\",\"v\":\"90\u5e74\u4ee3\"},{\"n\":\"80\u5e74\u4ee3\",\"v\":\"80\u5e74\u4ee3\"}]}],\"2\":[{\"name\":\"\u5730\u533a\",\"key\":\"area\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u4e2d\u56fd\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u4e2d\u56fd\u9999\u6e2f\",\"v\":\"\u4e2d\u56fd\u9999\u6e2f\"},{\"n\":\"\u4e2d\u56fd\u53f0\u6e7e\",\"v\":\"\u4e2d\u56fd\u53f0\u6e7e\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"name\":\"\u5e74\u4efd\",\"key\":\"year\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"},{\"n\":\"2009~2000\",\"v\":\"2009~2000\"},{\"n\":\"90\u5e74\u4ee3\",\"v\":\"90\u5e74\u4ee3\"},{\"n\":\"80\u5e74\u4ee3\",\"v\":\"80\u5e74\u4ee3\"}]}],\"3\":[{\"name\":\"\u5730\u533a\",\"key\":\"area\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u4e2d\u56fd\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u4e2d\u56fd\u9999\u6e2f\",\"v\":\"\u4e2d\u56fd\u9999\u6e2f\"},{\"n\":\"\u4e2d\u56fd\u53f0\u6e7e\",\"v\":\"\u4e2d\u56fd\u53f0\u6e7e\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"name\":\"\u5e74\u4efd\",\"key\":\"year\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"\u66f4\u65e9\",\"v\":\"\u66f4\u65e9\"}]}],\"4\":[{\"name\":\"\u5730\u533a\",\"key\":\"area\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u4e2d\u56fd\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"name\":\"\u5e74\u4efd\",\"key\":\"year\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"},{\"n\":\"2009~2000\",\"v\":\"2009~2000\"},{\"n\":\"90\u5e74\u4ee3\",\"v\":\"90\u5e74\u4ee3\"},{\"n\":\"80\u5e74\u4ee3\",\"v\":\"80\u5e74\u4ee3\"},{\"n\":\"\u66f4\u65e9\",\"v\":\"\u66f4\u65e9\"}]}]}";
    }

    public static void \u062d\u063a\u062b\u062c(Object object) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() > 0) {
            ((Hmys)((Object)object)).regLogin();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u062e\ufeb9\u062c\u0646(Object object) {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() < 0) return false;
        return ((N0)object).g9;
    }

    public static String \u062f\u0631\ufea5\u0647(short[] sArray, int n2, int n3, int n4) {
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
    public static boolean \u0631\u0648\ufeaf\u062f(Object object, Object object2) {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() >= 0) return false;
        return Bili.isAppInstalled((Context)object, (String)object2);
    }

    public static void \u0631\ufebd\ufe8e\ufe9d(Object object) {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() < 0) {
            ((List)object).clear();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0632\ufe9d\ufec9\u0639() {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() > 0) return null;
        return " ";
    }

    public static void \u0632\ufed9\u0640\u062d(long l) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() < 0) {
            Thread.sleep(l);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0642\u0627\u0645\u0643(Object object) {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() >= 0) return null;
        return ((XM)object).SN();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static AlertDialog.Builder \u0644\ufeb9\u062b\ufe99(Object object, Object object2) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() >= 0) return null;
        return ((AlertDialog.Builder)object).setView((View)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0645\u062a\ufeaf\u062f(Object object) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() < 0) return null;
        return ((ak)object).zH();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0646\ufeb1\u0643\ufed5(Object object) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() <= 0) return null;
        return ((N0)object).F5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u064a\ufeaf\u0636\u0632(Object object, int n2) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() > 0) return 0;
        return ((String)object).indexOf(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8f\u0644\u062f\u0636(Object object, Object object2) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() >= 0) return null;
        return AppYsV2.xiaFanSign((Map)object, (String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static KeyFactory \ufea5\ufec9\ufe95\ufecd(Object object) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() <= 0) return null;
        return KeyFactory.getInstance((String)object);
    }

    public static void \ufeab\u0639\ufec1\ufec5(Object object) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() < 0) {
            ((xu_0)object).w();
        }
    }

    public static int \ufeb5\ufe8f\u0630\u0647() {
        return 0xFFFFFE7E ^ \u062a\u0635\ufeb1\u0642.\ufebd\ufea1\u0631\ufea5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object[] \ufeb9\u064a\u0643\ufe8e(Object objectArray) {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() < 0) return null;
        return ((fk)objectArray).tF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Ef \ufeb9\ufec1\ufef1\ufea5(Object object, Object object2, Object object3) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() > 0) return null;
        return ((xu_0)object).m((String)object2, (String)object3);
    }

    public static void \ufebd\ufecd\ufee1\ufea1(Object object, Object object2) {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() > 0) {
            ((Cloud_uc)((Object)object)).setFlag((String)object2);
        }
    }

    public static int \ufed5\u0641\ufe8e\u0644(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufedd\u0631\ufebd\u062d(Object object, Object object2) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return null;
        return ((HashMap)object).get(object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeed\u0630\ufecd\u0632(Object object) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() > 0) return null;
        return ((dl_0)object).F5();
    }
}

