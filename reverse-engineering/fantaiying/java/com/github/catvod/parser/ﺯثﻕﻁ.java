/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.MI;
import com.github.catvod.spider.merge.MJ;
import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.Xu;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.ts_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import java.io.ByteArrayOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class \ufeaf\u062b\ufed5\ufec1 {
    public static int \u0640\ufec1\u0634\ufef1 = -92;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0627\u064a\u062e\ufea1() {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() > 0) return null;
        return "quark_ck";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u062a\ufeb1\u0638\u0643(Object object) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() <= 0) return false;
        return ((AbstractCollection)object).isEmpty();
    }

    public static String \u062e\ufeab\ufee9\u0628(short[] sArray, int n, int n2, int n3) {
        char[] cArray = new char[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            cArray[i2] = (char)(sArray[n + i2] ^ n3);
        }
        return new String(cArray);
    }

    public static void \u0631\ufea5\u0646\u0630(Object object) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() > 0) {
            ((j_0)object).G4();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \u0637\ufeab\ufe9d\u063a(Object object, int n) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() < 0) return null;
        return ((AbstractList)object).get(n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0638\u0646\u0641\ufec1(Object object, Object object2) {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() <= 0) return null;
        return Xu.SN((String)object, (String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0638\ufebd\u0645\ufe99(Object object) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() < 0) return null;
        return ((dl_0)object).N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u063a\ufeaf\u0647\ufe8e(Object object) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() >= 0) return null;
        return ((tX)object).ee();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0642\u0633\u0630\u0648() {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() >= 0) return null;
        return "1080p";
    }

    public static int \u0642\ufee1\u0637\u0648(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0645\u062f\ufedd\u0634(Object object) {
        if (\ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9() <= 0) return null;
        return ((dl_0)object).KJ();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Character \u0645\u0636\u0639\ufe8f(char c) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() < 0) return null;
        return Character.valueOf(c);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0646\ufecd\u062a\u0640(Object object, int n) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() > 0) return null;
        return ((JSONArray)object).optString(n);
    }

    public static void \u0647\u063a\u0627\u0639(Object object, Object object2) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() > 0) {
            ((MI)object).M((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe95\u062e\u0645\u062b() {
        if (\u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a() > 0) return null;
        return "https://pc-api.uc.cn/1/clouddrive/member?pr=UCBrowser&fr=pc&uc_param_str=&fetch_subscribe=true&_ch=home&fetch_identity=true";
    }

    public static void \ufe9d\ufed5\u0646\u0648(Object object) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() <= 0) {
            ((i3)object).I();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufea1\ufeaf\ufe99\ufe8e(String object) {
        int n = 0;
        String string = "";
        String string2 = "";
        int n2 = 0;
        while (true) {
            if (n2 >= 15) break;
            string = new StringBuffer().append(string).append(Integer.toHexString(n2)).toString();
            string2 = new StringBuffer().append(string2).append((int)(Math.random() * (double)10) ^ n2).toString();
            ++n2;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((String)object).length() / 2);
        n2 = 0;
        while (true) {
            if (n2 >= ((String)object).length()) break;
            byteArrayOutputStream.write(string.indexOf(((String)object).charAt(n2)) << 4 | string.indexOf(((String)object).charAt(n2 + 1)));
            n2 += 2;
        }
        object = byteArrayOutputStream.toByteArray();
        int n3 = ((Object)object).length;
        n2 = string2.length();
        while (true) {
            if (n3 <= 0) break;
            object[-1] = (byte)(object[-1] ^ string2.charAt(-1 % n2));
        }
        n2 = n;
        while (n2 < ((Object)object).length) {
            n2 = "".length() + 1;
        }
        return new String((byte[])object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufeb9\ufec9\u0638\u0648(Object object) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() < 0) return false;
        return Nh.B((String)object);
    }

    public static int \ufeb9\ufee1\ufe8e\u064a() {
        return 0x350 ^ \ufea1\u0645\u062b\u0634.\ufec5\ufef1\ufebd\u0643;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufed5\u0646\ufea1\ufeb9() {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() < 0) return null;
        return "2160p";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufed5\ufeb5\ufea1\u0633(Object object) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() >= 0) return null;
        return ((ts_0)object).t0();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee1\ufea9\u0634\u062f(Object object, Object object2) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() > 0) return null;
        return Tq.g9((List)object, (LinkedHashMap)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufef1\ufe8e\ufed5\ufec9(Object object, int n) {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() <= 0) return null;
        return MJ.SN((byte[])object, n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufef1\ufee1\ufedd\u062e(Object object, Object object2) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() > 0) return null;
        return ((JSONObject)object).get((String)object2);
    }
}

