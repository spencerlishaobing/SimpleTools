/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.graphics.Bitmap
 *  android.view.Window
 *  android.webkit.WebSettings
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Window;
import android.webkit.WebSettings;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.R5;
import com.github.catvod.spider.merge.Rw;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.X0;
import com.github.catvod.spider.merge.Yx;
import com.github.catvod.spider.merge.f1_0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.i8_0;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.rs_1;
import com.github.catvod.spider.merge.ts_0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.zm_0;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.json.JSONArray;
import org.json.JSONObject;

public class \ufea1\u0645\u062b\u0634 {
    public static int \ufec5\ufef1\ufebd\u0643 = -607;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u062c\ufe8f\u0627\u0633(Object object, int n2) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() > 0) return 0;
        return ((JSONArray)object).getInt(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062d\u0635\ufecd\u0631(Object object) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() <= 0) return null;
        return ((f1_0)object).yq();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u062f\ufead\ufee9\u0631(String object) {
        int n2 = 0;
        String string = "";
        String string2 = "";
        int n3 = 0;
        while (true) {
            if (n3 >= 15) {
                while (string.length() > 0) {
                }
                break;
            }
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
        n3 = n2;
        while (n3 < n4) {
            object[n3] = (byte)(object[n3] ^ string2.charAt(n3 % n5));
            ++n3;
        }
        return new String((byte[])object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Level \u0632\u0631\ufe8f\ufee1() {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() <= 0) return null;
        return Level.WARNING;
    }

    public static void \u0635\ufeaf\u064a\u0646(Object object, boolean bl) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() >= 0) {
            ((WebSettings)object).setDomStorageEnabled(bl);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0636\u062f\u0633\ufeaf() {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() <= 0) return null;
        return "lastQuarkDownUrl";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0636\ufeaf\ufea1\u0631(Object object) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return false;
        return ((X0)object).zH();
    }

    public static int \u0637\u0627\u0639\u0647(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \u0637\ufeb9\u064a\u0628() {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() < 0) return null;
        return Tq.Gc();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0638\u0642\u0646\ufee9(Object object, Object object2, int n2) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() > 0) return null;
        return zm_0.SN((String)object, (Map)object2, n2);
    }

    public static String \u0638\ufec9\u0630\ufe95(short[] sArray, int n2, int n3, int n4) {
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
    public static JSONObject \u0639\u0644\ufe8e\ufe95() {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() > 0) return null;
        return rs_1.g9();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0641\u0646\u0644\ufee9(Object object, Object object2) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() <= 0) return null;
        return zm_0.yq((String)object, (Map)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0643\ufe8e\u0644\ufe95(Object object) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return ((i8_0)object).N;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Yx \u0646\ufeb1\u0643\ufed5(Object object) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() <= 0) return null;
        return ((xu_0)object).G;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0648\u062f\ufea1\ufe95(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() >= 0) return null;
        return ((ts_0)object).i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0648\ufee1\u0638\u062f() {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return null;
        return "save_as_top_fids";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8e\u062d\u062f\ufed5(Object object) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() >= 0) return null;
        return n6.SN(object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufe95\ufeaf\ufeb9\ufea1(Object object) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() <= 0) return null;
        return ((Iterator)object).next();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Window \ufe95\ufed5\ufe8e\u0635(Object object) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() < 0) return null;
        return ((Activity)object).getWindow();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe95\ufeed\ufea9\u0634(Object object) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() >= 0) return null;
        return R5.tF((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Bitmap \ufe99\u062e\u0641\u062c(Object object, int n2, int n3) {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() < 0) return null;
        return Rw.yq((String)object, n2, n3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufe99\ufebd\ufec5\u064a(Object list) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() > 0) return null;
        return ((xu_0)((Object)list)).Dr();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeaf\u0630\u0643\u0640() {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() < 0) return null;
        return "application/json";
    }

    public static int \ufec1\u0634\ufecd\u0643() {
        return 0xFFFFFCC0 ^ \u0641\ufeb5\ufeb1\ufee1.\u0646\u0633\u0647\u062b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static i3 \ufec5\u062e\ufe95\ufec9() {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() < 0) return null;
        return i3.s();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec9\ufec5\ufeed\u0644(Object object) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() <= 0) return null;
        return ((H7)object).i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufecd\u0634\ufea1\u0637(double d) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return null;
        return ME.v3(d);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \ufedd\u0639\ufee1\ufea5(Object object, Object object2) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() < 0) return null;
        return ((Tq)object).n((List)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee9\ufee1\ufecd\ufedd(Object object, Object object2) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() >= 0) return null;
        return String.format((String)object, (Object[])object2);
    }
}

