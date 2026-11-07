/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Bttwoo;
import com.github.catvod.spider.Cloud_ali;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Gt;
import com.github.catvod.spider.merge.Pk;
import com.github.catvod.spider.merge.hm;
import com.github.catvod.spider.merge.rs_1;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class \u062a\ufee1\ufe8e\ufeb9 {
    public static int \u0642\ufed5\u064a\ufecd = 960;

    public static int \u062e\ufeb9\u0644\ufedd() {
        return 0xFFFFFDD5 ^ \u0632\ufead\u062f\u0628.\u0648\u0647\ufe9d\u062b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0631\u0637\u0634\u0639(Object object) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() < 0) return null;
        return ((Pk)object).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0633\u0639\u0643\ufea5(Object object, Object object2) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() <= 0) return false;
        return ((Set)object).add(object2);
    }

    public static int \u0633\u0639\ufe8e\ufeb9(Object object) {
        return object.hashCode();
    }

    public static void \u0634\u0642\ufed9\u0635(Object object, Object object2) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() <= 0) {
            ((PrintStream)object).println(object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0634\u0643\u0633\u0640(String object) {
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
    public static String \u0635\u0648\u0638\u064a() {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() > 0) return null;
        return "UC\u76d8\u5bb9\u91cf\u4e0d\u8db3,\u8bf7\u8d2d\u4e70\u4f1a\u5458\u6269\u5bb9\u6216\u6e05\u7406\u7a7a\u95f4";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0635\ufea5\u0628\u0647(Object object) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() < 0) return null;
        return Bttwoo.encodePlayKey((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0636\ufedd\ufebd\ufea5() {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() <= 0) return false;
        return Cloud_ali.N;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \u0641\ufeb5\u062a\ufec1(Object object, Object object2, int n) {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() <= 0) return null;
        return ((JSONObject)object).put((String)object2, n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static hm \u0648\ufea9\u0632\u0634(Object object) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() < 0) return null;
        return hm.M((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufeab\ufea5\u0641\ufee9(Object object, Object object2, boolean bl) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() < 0) return false;
        return ((JSONObject)object).optBoolean((String)object2, bl);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufeb5\u0628\ufec1\ufe8e(Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() <= 0) return null;
        return ((Map.Entry)object).getKey();
    }

    public static void \ufeb5\u0636\u062d\ufe9d(Object object, Object object2) {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() < 0) {
            ((Ef)object).i((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeb9\u0634\u0648\ufedd(Object object) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() >= 0) return null;
        return ((Gt)object).SN();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \ufebd\u0647\u0646\ufe8f(Object object, Object object2, Object object3) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() >= 0) return null;
        return ((JSONObject)object).put((String)object2, object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] \ufec1\u062d\ufeed\u0627(Object object, int n, int n2) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() <= 0) return null;
        return Arrays.copyOfRange((byte[])object, n, n2);
    }

    public static String \ufec5\ufecd\ufea9\ufea5(short[] sArray, int n, int n2, int n3) {
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
    public static JSONObject \ufec9\u0628\u0641\ufed9() {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() <= 0) return null;
        return rs_1.SN();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufec9\u0632\u0637\ufeb1() {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() > 0) return false;
        return Pan.ee;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static WebSettings \ufedd\u0642\ufeb1\ufe8e(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() >= 0) return null;
        return ((WebView)object).getSettings();
    }
}

