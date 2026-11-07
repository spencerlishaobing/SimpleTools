/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.SharedPreferences$Editor
 *  android.view.View
 *  android.webkit.WebSettings
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.app.Application;
import android.content.SharedPreferences;
import android.view.View;
import android.webkit.WebSettings;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.T4;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.K;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.T1;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.VV;
import com.github.catvod.spider.merge.f_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.lm;
import com.github.catvod.spider.merge.nb_0;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.ts_0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import java.io.ByteArrayOutputStream;
import java.util.AbstractCollection;
import java.util.Iterator;
import org.json.JSONObject;

public class \ufeed\ufebd\u0635\ufedd {
    public static int \ufed5\u0636\u0638\u062c = 524;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0628\ufed5\ufe8e\u062c(long l) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() < 0) return null;
        return Long.toHexString(l);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062a\ufeab\ufe95\ufee9(Object object) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() >= 0) return null;
        return ((nb_0)object).t0();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Ef \u062b\ufe95\u0647\ufea1(Object object, Object object2) {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() >= 0) return null;
        return ((lm)object).G4((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u062f\u0643\u062e\u063a(Object object, Object object2) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() < 0) return false;
        return ((hN)object).p((String)object2);
    }

    public static String \u062f\ufe9d\u0642\u062d(short[] sArray, int n, int n2, int n3) {
        char[] cArray = new char[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            cArray[i2] = (char)(sArray[n + i2] ^ n3);
        }
        return new String(cArray);
    }

    public static void \u0630\u0641\u0635\u0637(Object object, Object object2) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() >= 0) {
            ((Ef)object).B((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Application \u0630\ufee9\u0647\u062e() {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() >= 0) return null;
        return InitOrigin.context();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \u0634\u0646\ufec9\u062a(Object object, Object object2) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() < 0) return null;
        return ME.Nl((String)object, (String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0636\u0631\ufeed\u0639(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() >= 0) return null;
        return ((ts_0)object).N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0637\u062e\u0643\u0639() {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() > 0) return 0;
        return VV.zH;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0637\ufe8e\ufee1\ufebd(Object object) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() <= 0) return false;
        return ((String)object).isEmpty();
    }

    public static void \u0638\u0630\u062c\ufea5(Object object, Object object2) {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() >= 0) {
            ((i3)object).Gd((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static T1 \u0638\ufeaf\u0631\u0640(Object object) {
        if (\u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a() >= 0) return null;
        return ((T1)object).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0642\ufeaf\u062b\u062d() {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() < 0) return null;
        return "http://192.168.111.200:10148/data";
    }

    public static void \u0642\ufebd\u062e\u063a(Object object, Object object2) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() < 0) {
            ((Ef)object).M((String)object2);
        }
    }

    public static void \u0645\ufeaf\ufeb1\u0627(Object object) {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() < 0) {
            ((SharedPreferences.Editor)object).apply();
        }
    }

    public static void \u0646\u0634\ufeb9\ufed9(Object object, Object object2) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() > 0) {
            ((f_0)object).Gc((f_0)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0647\ufea1\ufed5\u0645() {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() >= 0) return false;
        return InitOrigin.zH;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0647\ufebd\ufef1\u0648(String object) {
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
        n2 = ((Object)object).length;
        int n3 = string2.length();
        while (true) {
            if (n2 <= 0) break;
            object[-1] = (byte)(object[-1] ^ string2.charAt(-1 % n3));
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
    public static JSONObject \u0648\ufeb1\u0642\ufe95(Object object) {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() <= 0) return null;
        return ((xu_0)object).B;
    }

    public static int \ufe8e\u0628\u0638\u0631() {
        return 0xFFFFFCA2 ^ \ufe8e\u0627\ufecd\u062a.\ufec9\ufee9\u0635\u062a;
    }

    public static void \ufe8f\u062b\u063a\ufeb1(Object object, Object object2) {
        if (\u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a() <= 0) {
            ((Ef)object).zH((String)object2);
        }
    }

    public static void \ufe95\ufedd\u0647\ufeb5(Object object, Object object2) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() < 0) {
            ((WebSettings)object).setUserAgentString((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Ef \ufeab\ufea9\u0640\u0632(Object object, Object object2, Object object3, Object object4, Object object5) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() <= 0) return null;
        return ((j_0)object).H((String)object2, (String)object3, (String)object4, (String)object5);
    }

    public static int \ufeb1\u0634\u0635\u062a(Object object) {
        return object.hashCode();
    }

    public static void \ufec1\ufeb5\u0642\ufed5() {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() < 0) {
            K.tF();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec1\ufef1\u0632\ufe8e(Object object) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() >= 0) return null;
        return ((Tq)object).toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Iterator \ufecd\u0636\ufea9\u0628(Object iterator) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() > 0) return null;
        return ((AbstractCollection)((Object)iterator)).iterator();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static View \ufecd\u0640\ufeb1\ufec9(Object object, int n) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() >= 0) return null;
        return ((View)object).findViewById(n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Class \ufed9\ufe9d\u0638\u0637(Object clazz) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return clazz.getClass();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee9\ufea5\u0631\u0644() {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() <= 0) return null;
        return "https://pc-api.uc.cn/";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufee9\ufec5\u0642\u0644(Object object) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() < 0) return false;
        return ((tX)object).OW();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeed\ufecd\ufeab\ufec9(Object object, Object object2, boolean bl, Object object3) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() <= 0) return null;
        return ((T4)((Object)object)).searchContent((String)object2, bl, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufef1\ufebd\ufed9\ufeaf() {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() < 0) return null;
        return "me";
    }
}

