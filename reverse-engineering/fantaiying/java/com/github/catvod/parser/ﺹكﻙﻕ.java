/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.content.ContentResolver;
import android.content.Context;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.spider.AppYsV2;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.Jr;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.My;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.nb_0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class \ufeb9\u0643\ufed9\ufed5 {
    public static int \u0637\ufecd\u0636\u0633 = -302;

    public static void \u0627\u0641\u064a\u062f(Object object) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() >= 0) {
            InitOrigin.init((Context)object);
        }
    }

    public static String \u0628\u062f\ufea1\u0642(short[] sArray, int n, int n2, int n3) {
        char[] cArray = new char[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            cArray[i2] = (char)(sArray[n + i2] ^ n3);
        }
        return new String(cArray);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0632\u062d\ufeab\u0640(Object object) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() > 0) return null;
        return ((AppYsV2)((Object)object)).yq;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0636\u0647\ufee9\ufeed(Object object, Object object2) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() < 0) return false;
        return ((JSONObject)object).has((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0636\ufeb9\u0633\ufecd() {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() >= 0) return null;
        return "1/clouddrive/file/delete?pr=ucpro&fr=pc&uc_param_str=";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0641\ufec9\ufea1\u062a(Object object) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() <= 0) return false;
        return ME.Gd((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long \u0643\u062d\u062e\ufee9(Object object, Object object2) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() >= 0) return 0L;
        return ((JSONObject)object).optLong((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0644\u0631\ufecd\u0638(Object object, Object object2, Object object3) {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() <= 0) return null;
        return ((xu_0)object).g9((String)object2, (List)object3);
    }

    public static void \u0645\u0630\ufeb9\ufea1(Object object) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() >= 0) {
            ((i3)object).Nl();
        }
    }

    public static int \u0645\u0636\ufebd\ufe8e(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0647\ufeab\ufe99\u0639(String string) {
        int n = 0;
        Object object = "";
        String string2 = "";
        int n2 = 0;
        while (true) {
            if (n2 >= 15) break;
            object = new StringBuffer().append((String)object).append(Integer.toHexString(n2)).toString();
            string2 = new StringBuffer().append(string2).append((int)(Math.random() * (double)10) ^ n2).toString();
            ++n2;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(string.length() / 2);
        n2 = 0;
        while (true) {
            if (n2 >= string.length()) break;
            byteArrayOutputStream.write(((String)object).indexOf(string.charAt(n2)) << 4 | ((String)object).indexOf(string.charAt(n2 + 1)));
            n2 += 2;
        }
        object = byteArrayOutputStream.toByteArray();
        string = "a";
        while (true) {
            if (string.length() <= 0) break;
            string = "";
            if ("".length() != 0) continue;
            string = "a";
        }
        int n3 = string.length();
        int n4 = string2.length();
        n2 = 0;
        while (true) {
            if (n2 >= n3) break;
            object[n2] = (byte)(object[n2] ^ string2.charAt(n2 % n4));
            ++n2;
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
    public static Object[] \ufe8e\ufe9d\ufe99\u064a(Object objectArray) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() <= 0) return null;
        return ((xu_0)objectArray).lF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Jr \ufe9d\u062a\ufecd\ufec1(Object object, Object object2, Object object3) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return null;
        return Bo.t0((String)object, (String)object2, (Map)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ContentResolver \ufea1\u062c\u0631\ufe95(Object object) {
        if (\ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9() < 0) return null;
        return ((Context)object).getContentResolver();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea1\ufedd\ufed5\u0648() {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() >= 0) return null;
        return "bytes=0-0";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea5\u0634\u062b\ufecd() {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() < 0) return null;
        return ProxyOrigin.getOwnProxyUrl();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea9\ufea5\ufe8e\u0645(Object object) {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() < 0) return null;
        return ((nb_0)object).SN();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long \ufec1\u0637\ufe95\u0634() {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return 0L;
        return Pan.xa;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufed5\ufed9\ufe9d\u0636(Object object) {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() <= 0) return null;
        return ((My.yq)object).N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static hN \ufedd\u062e\u0644\u062c(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() > 0) return null;
        return ((hN)object).o();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufedd\ufe95\u0638\ufed5(Object object) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() >= 0) return null;
        return ((dl_0)object).Gc();
    }

    public static int \ufeed\u0631\u0648\ufea5() {
        return 0x23D ^ \u0630\ufebd\u0634\ufec9.\u0630\ufec1\ufea9\ufea5;
    }
}

