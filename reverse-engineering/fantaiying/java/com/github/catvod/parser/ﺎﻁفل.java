/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface$OnDismissListener
 *  android.os.Build
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.content.DialogInterface;
import android.os.Build;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.DexNative;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.LP;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Pk;
import com.github.catvod.spider.merge.TZ;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.p7;
import com.github.catvod.spider.merge.qD;
import com.github.catvod.spider.merge.ts_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class \ufe8e\ufec1\u0641\u0644 {
    public static int \ufeab\ufef1\u0634\u062d = -993;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0627\u064a\ufed5\u0635(Object object, Object object2, Object object3) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() > 0) return false;
        return ME.G((JSONObject)object, (String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Integer \u062b\u0635\ufeab\ufeaf(int n) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() > 0) return null;
        return n;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062b\u0648\u0646\u0628() {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() < 0) return null;
        return "passcode";
    }

    public static int \u062c\u0642\ufe9d\ufef1() {
        return 0x188 ^ \u0630\ufebd\u0634\ufec9.\u0630\ufec1\ufea9\ufea5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Pk \u062c\ufe8e\ufed5\u062e(Object object, Object object2) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() < 0) return null;
        return ((Pk)object).SN((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062d\ufed5\u0632\ufec9(Object object) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() <= 0) return null;
        return ((Ef)object).tF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0630\u0633\u0639\u0628() {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() < 0) return null;
        return "fid";
    }

    public static int \u0633\ufeed\ufe8f\ufeab(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Set \u0635\u0628\u0632\ufed9(Object set) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() > 0) return null;
        return ((TreeMap)((Object)set)).entrySet();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0635\ufee9\ufeab\u062c(Object object) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() >= 0) return 0;
        return p7.SN((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0638\ufed9\u064a\ufebd(Object object) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() <= 0) return null;
        return ((dl_0)object).v3();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0642\u0647\ufeb9\u0640() {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() < 0) return null;
        return "";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0645\ufed9\ufedd\u0641(Object object, Object object2, int n) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() >= 0) return 0;
        return ((String)object).indexOf((String)object2, n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0646\ufe9d\u064a\u0628(Object object) {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() < 0) return null;
        return ProxyOrigin.getOwnProxyUrl((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static DialogInterface.OnDismissListener \u0646\ufe9d\ufe8e\ufeaf() {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() < 0) return null;
        return Pan.dismissInputQRCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0647\ufef1\u064a\ufeaf() {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() >= 0) return null;
        return "videoLength";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static qD \u0648\ufea1\ufeab\ufeed(Object object) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() <= 0) return null;
        return ((qD)object).t0();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \ufe95\ufeed\ufec1\u0639(Object hashMap) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() > 0) return null;
        return ((j_0)((Object)hashMap)).Nl();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufe99\ufeab\u0639\ufed5(Object list) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() >= 0) return null;
        return ((LP)((Object)list)).M();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufead\u0631\ufee1\u062f(Object object, Object object2, int n) {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() <= 0) return 0;
        return ((String)object).lastIndexOf((String)object2, n);
    }

    public static void \ufeb1\u0636\ufeaf\u0639(Object object, Object object2) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() > 0) {
            ((Ef)object).q((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static j_0 \ufeb1\ufeb9\u062f\u0635() {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() < 0) return null;
        return j_0.v();
    }

    public static void \ufeb9\ufec9\u0648\u062d(Object object) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() < 0) {
            TZ.SN((List)object);
        }
    }

    public static String \ufec5\u062b\ufeb5\u062c(short[] sArray, int n, int n2, int n3) {
        char[] cArray = new char[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            cArray[i2] = (char)(sArray[n + i2] ^ n3);
        }
        return new String(cArray);
    }

    public static void \ufec5\ufe99\ufed9\u0639(boolean bl) {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() < 0) {
            DexNative.danmuStart(bl);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec5\ufeab\u0646\u064a(Object object) {
        if (\ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9() < 0) return null;
        return ME.n((String)object);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufec9\u0646\ufe8e\u0636(String object) {
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
    public static String \ufed5\u062c\ufec5\u0632(Object object) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() > 0) return null;
        return ((Throwable)object).getMessage();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufed5\ufeb5\u062e\u064a() {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return null;
        return Build.PRODUCT;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee9\u062a\u062d\u0640(Object object) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() <= 0) return null;
        return ((ts_0)object).SN();
    }
}

