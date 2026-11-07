/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.content.Context;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.spider.NewCz;
import com.github.catvod.spider.WoGG;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.ID;
import com.github.catvod.spider.merge.LP;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.rs_1;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class \ufeb9\ufec9\u0648\u062d {
    public static int \ufeaf\ufe95\ufecd\ufee1 = -763;

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0627\u0630\u062d\ufec9(String object) {
        int n = 0;
        String string = "";
        String string2 = "";
        int n2 = 0;
        while (true) {
            if (n2 >= 15) {
                while (string.length() > 0) {
                }
                break;
            }
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
        int n4 = string2.length();
        n2 = n;
        while (n2 < n3) {
            object[n2] = (byte)(object[n2] ^ string2.charAt(n2 % n4));
            ++n2;
        }
        return new String((byte[])object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0628\u062c\ufe95\u0635(Object object) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() >= 0) return null;
        return ((hN)object).mG();
    }

    public static void \u062f\ufe8f\u063a\ufeed(Object object, Object object2) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() > 0) {
            ((dl_0)object).un((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062f\ufe99\u0645\u062d(Object object) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() >= 0) return null;
        return ME.zH((String)object);
    }

    public static void \u0632\u062b\u0647\ufec1(Object object, int n, Object object2) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() >= 0) {
            ((ArrayList)object).add(n, object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0632\u0644\u0638\ufec9(Object object) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() < 0) return false;
        return ((xu_0)object).n();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0632\ufed9\ufea1\u0641() {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return null;
        return "location";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0635\ufeaf\u064a\u0646(Object object) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() > 0) return 0;
        return System.identityHashCode(object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Context \u0636\ufebd\ufeb1\ufec1(Object object) {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() > 0) return null;
        return ((Context)object).getApplicationContext();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \u0636\ufec9\u0635\ufeb5() {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return rs_1.Gd();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0638\ufea9\ufed5\ufed9() {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() < 0) return null;
        return NewCz.zH;
    }

    public static int \u063a\u064a\ufed9\ufe8f() {
        return 0xFFFFFC03 ^ \ufeb9\u0627\ufea5\ufe9d.\u0638\ufea5\u0647\u062f;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0644\ufe8e\u0645\u063a(Object object) {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() >= 0) return null;
        return ((LP)object).B();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ID \u0645\u0630\u0639\ufea9(Object object) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() < 0) return null;
        return ID.Gc((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0645\u0638\ufeb1\ufe8e() {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() >= 0) return null;
        return "ucSt";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u064a\u0645\u062a\ufef1(Object object, Object object2) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() >= 0) return null;
        return ((WoGG)((Object)object)).refTry((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \ufe8f\ufea1\ufea9\u062a(Object hashMap) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() >= 0) return null;
        return ME.i((String)((Object)hashMap));
    }

    public static void \ufea1\u062e\u0644\u062c(Object object, Object object2) {
        if (\u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a() <= 0) {
            ((H7)object).E1((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufead\u0642\ufe99\u0646(Object object, Object object2) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() < 0) return null;
        return URLEncoder.encode((String)object, (String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeb9\u0644\u0637\ufec5(Object object, Object object2) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() < 0) return null;
        return ((tX)object).G4((String)object2);
    }

    public static void \ufec1\ufea9\u0641\u062f(Object object, Object object2) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() < 0) {
            ((H7)object).un((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufed5\u0638\u0648\u0637(Object list) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() > 0) return null;
        return dl_0.yq((String)((Object)list));
    }

    public static int \ufee1\u0631\ufe95\ufed5(Object object) {
        return object.hashCode();
    }

    public static String \ufee9\u0637\ufef1\u0644(short[] sArray, int n, int n2, int n3) {
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
    public static HashMap \ufeed\ufedd\u0634\u062f(Object hashMap) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return ME.O((String)((Object)hashMap));
    }
}

