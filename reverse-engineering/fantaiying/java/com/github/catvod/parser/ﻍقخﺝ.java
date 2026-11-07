/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.view.Window
 *  android.widget.TextView
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.T1;
import com.github.catvod.spider.merge.V;
import com.github.catvod.spider.merge.hm;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.rs_1;
import com.github.catvod.spider.merge.t_0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.zm_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class \ufecd\u0642\u062e\ufe9d {
    public static int \ufeed\u062e\ufeb9\ufec9 = 339;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static StringBuilder \u062b\u063a\u062e\u0628(Object object, int n) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() <= 0) return null;
        return ((StringBuilder)object).deleteCharAt(n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static char \u062f\ufed9\u0643\u0631(Object object) {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() < 0) return '\u0000';
        return ((Character)object).charValue();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0632\u0639\u0647\ufec5(Object object) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() > 0) return false;
        return ((File)object).exists();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0633\ufe9d\u062d\u0648(Object object, int n) {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() > 0) return null;
        return ((String)object).substring(n);
    }

    public static int \u0634\u063a\u0628\ufeb9() {
        return 0xFFFFFC08 ^ \ufed9\ufe9d\ufeed\ufeb5.\u062f\u0645\u0644\ufeb5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \u0635\u064a\ufec5\ufe9d(Object object, Object object2) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() < 0) return null;
        return zm_0.N((String)object, (HashMap)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0636\ufead\ufeb1\u0627(Object object) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() >= 0) return null;
        return ((T1)object).SN();
    }

    public static void \u0636\ufed5\u0633\ufecd(Object object, Object object2) {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() > 0) {
            ((n6)object).H((String)object2);
        }
    }

    public static int \u0636\ufed9\u064a\u0633(Object object) {
        return object.hashCode();
    }

    public static String \u0637\ufee9\u0635\u0630(short[] sArray, int n, int n2, int n3) {
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
    public static String \u0638\ufead\u062e\ufee1() {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() < 0) return null;
        return "save_as";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0640\u0631\ufeb5\ufebd(Object object) {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() <= 0) return null;
        return ((hm)object).toString();
    }

    public static void \u0641\ufeab\u0639\ufe8f(Object object, int n, int n2, int n3) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() >= 0) {
            ((t_0)object).i(n, n2, n3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0642\ufeb9\ufee1\ufee9(Object object) {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() <= 0) return null;
        return V.N((Iterable)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0643\ufeb9\ufe8e\u0647(Object object) {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() <= 0) return false;
        return ((i3)object).ee;
    }

    public static void \u0646\u062a\u0633\ufee9(Object object, Object object2) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() < 0) {
            ((Throwable)object).addSuppressed((Throwable)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Window \ufe8f\ufeb5\u062d\u0640(Object object) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() < 0) return null;
        return ((Dialog)object).getWindow();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufe95\ufeed\ufea5\u0644(String object) {
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
        while (true) {
            if (((String)object).length() <= 0) break;
            byteArrayOutputStream.write(string.indexOf(((String)object).charAt(-2)) << 4 | string.indexOf(((String)object).charAt(-1)));
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
    public static Object[] \ufeab\ufead\ufebd\u0633(Object objectArray, Object object) {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() <= 0) return null;
        return ((xu_0)objectArray).RQ((Map)object);
    }

    public static void \ufeb9\ufeb5\u0630\ufe95(Object object, int n) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() <= 0) {
            ((TextView)object).setTextColor(n);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec1\u062a\u0640\u0644(Object object, Object object2) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() > 0) return null;
        return rs_1.t0((String)object, (String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object[] \ufec1\u0647\ufeed\u0636(Object objectArray, Object object) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() <= 0) return null;
        return ((j_0)objectArray).un((HashMap)object);
    }

    public static void \ufed9\ufea9\u063a\ufe8f(Object object, Object object2) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() >= 0) {
            ((n6)object).Dr((String)object2);
        }
    }

    public static void \ufedd\u0630\u0636\u0647(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() < 0) {
            ((H7)object).Zm();
        }
    }

    public static void \ufee9\u062c\u0643\ufedd(Object object, Object object2) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() >= 0) {
            InitOrigin.setSpStr((String)object, (String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static hm \ufee9\u0642\u0628\u062d(Object object) {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() < 0) return null;
        return ((xu_0)object).W;
    }

    public static void \ufeed\ufef1\ufe99\u0631(Object object, Object object2) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() <= 0) {
            Collections.sort((List)object, (Comparator)object2);
        }
    }
}

