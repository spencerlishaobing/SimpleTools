/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences$Editor
 *  android.net.Uri$Builder
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.spider.Cloud_ali;
import com.github.catvod.spider.JPJ;
import com.github.catvod.spider.Music;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.ID;
import com.github.catvod.spider.merge.J7;
import com.github.catvod.spider.merge.LP;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.RO;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.X0;
import com.github.catvod.spider.merge.lm;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.zip.Inflater;
import org.json.JSONArray;
import org.json.JSONObject;

public class \u0630\ufebd\u0634\ufec9 {
    public static int \u0630\ufec1\ufea9\ufea5 = 657;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONArray \u062b\u0637\ufeaf\ufe95(Object object, int n) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() > 0) return null;
        return ((JSONArray)object).put(n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Class \u062b\ufe8f\u0630\u0648(Object clazz, Object object) {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() <= 0) return null;
        return ((ClassLoader)((Object)clazz)).loadClass((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static RO \u062c\u0640\u0647\u0638(Object object) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() < 0) return null;
        return ((LP)object).Gc();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static n6 \u062c\ufeab\u0631\u0628(Object object, Object object2) {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() > 0) return null;
        return ((n6)object).s((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u062e\u062a\u062d\ufeed(Object object, Object object2) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() > 0) return false;
        return ((ArrayList)object).contains(object2);
    }

    public static int \u062f\ufe8f\u0630\ufed5() {
        return 0x281 ^ \ufea9\u0643\u062d\u063a.\ufeaf\ufeb1\ufec1\ufeab;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062f\ufee1\u0642\ufe8f(Object object, Object object2, Object object3) {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() < 0) return null;
        return ((JPJ)((Object)object)).searchContent((String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0630\u0638\u062e\u0640(Object object) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() >= 0) return null;
        return ((ID)object).i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0631\ufe95\ufecd\ufead(Object object) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() <= 0) return null;
        return ((lm)object).SN();
    }

    public static void \u0632\u0646\u0639\u0635(Object object, Object object2) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() > 0) {
            ((MessageDigest)object).update((byte[])object2);
        }
    }

    public static void \u0632\ufea1\ufef1\ufec1(Object object, Object object2) {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() <= 0) {
            ((Cloud_ali)((Object)object)).setFlag((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0633\u0627\ufef1\u0641(Object object) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return null;
        return ((Music)((Object)object)).generateSessionId();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0635\ufec5\ufee1\u0639(String object) {
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
    public static X0 \u0636\u063a\u0638\u0630(Object object) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() < 0) return null;
        return X0.Gc((String)object);
    }

    public static void \u0637\u0635\u062c\ufec9(Object object) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() < 0) {
            ((Inflater)object).end();
        }
    }

    public static String \u0639\ufe8f\u064a\ufebd(short[] sArray, int n, int n2, int n3) {
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
    public static List \u0641\ufea1\ufea9\ufecd(Object list) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() >= 0) return null;
        return H7.yq((String)((Object)list));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONArray \u0642\u0627\u0645\u0643(Object object, Object object2) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() < 0) return null;
        return ((JSONObject)object).optJSONArray((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static SharedPreferences.Editor \u0644\u0632\ufee1\ufe9d(Object object, Object object2, long l) {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() > 0) return null;
        return ((SharedPreferences.Editor)object).putLong((String)object2, l);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONArray \u0645\ufead\u0635\u0634(Object object, Object object2) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() <= 0) return null;
        return ((JSONArray)object).put(object2);
    }

    public static int \u0647\u0638\u0627\u0631(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8e\u0636\ufea5\ufebd() {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() <= 0) return null;
        return "&client_id=";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe9d\u0638\u0632\u062f(Object object) {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() < 0) return null;
        return J7.SN((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufea1\u0641\u0630\ufef1(Object object) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() > 0) return false;
        return ((Inflater)object).needsInput();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea9\u062f\u0648\u062d(long l) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() >= 0) return null;
        return String.valueOf(l);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \ufeab\ufee9\u0641\ufed5(Object object, Object object2) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() > 0) return null;
        return ((Tq)object).t0((JSONObject)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeaf\ufe99\ufedd\ufec1() {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() < 0) return null;
        return "\u4f18\u6c50\u65e0\u9650";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeb9\u0640\u0643\u0631() {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() > 0) return null;
        return ME.yq;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Uri.Builder \ufec9\u062d\ufeab\u0643(Object object, Object object2) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() > 0) return null;
        return ((Uri.Builder)object).scheme((String)object2);
    }

    public static void \ufed5\ufea1\u0641\u0648(Object object, Object object2) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() < 0) {
            ((DateFormat)object).setTimeZone((TimeZone)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufedd\u0631\u0637\u0647(Object object, Object object2) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return null;
        return TextUtils.join((CharSequence)((CharSequence)object), (Object[])((Object[])object2));
    }
}

