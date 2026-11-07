/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.net.Uri
 */
package com.github.catvod.spider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.k9;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.qD;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

public class \u0631\ufea1\u0638\u0627 {
    public static int \u0646\u064a\u0633\u062c = 46;

    public static int \u0627\u0648\ufecd\ufee9() {
        return 0xE8 ^ \ufea1\u0645\u062b\u0634.\ufec5\ufef1\ufebd\u0643;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Intent \u0628\u0632\u0645\ufed5(Object object, Object object2) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() >= 0) return null;
        return ((Intent)object).setData((Uri)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062a\u0630\u0635\u062b(Object object) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() >= 0) return null;
        return ((UUID)object).toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] \u062a\ufec1\u0642\ufeed(Object object) {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() >= 0) return null;
        return ((MessageDigest)object).digest();
    }

    public static void \u062b\u062c\ufea9\ufe9d(Object object) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() < 0) {
            ((N0)object).x();
        }
    }

    public static void \u062c\u063a\ufed5\u0646(Object object) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() > 0) {
            ((ArrayList)object).clear();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static kb_0 \u062d\u0641\ufe8e\ufe95(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() >= 0) return null;
        return ((hN)object).J();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062e\u0634\ufee9\u0639(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() > 0) return null;
        return ((i3)object).M;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062f\ufe9d\ufea9\u0633(Object object) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() < 0) return null;
        return ((k9)object).yq();
    }

    public static int \u0630\ufecd\u062b\u062e(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0633\u0627\u0644\ufeab(Object object) {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() > 0) return null;
        return ((Uri)object).getLastPathSegment();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long \u0636\u063a\u0646\ufec5(Object object, Object object2, long l) {
        if (\u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a() > 0) return 0L;
        return ((SharedPreferences)object).getLong((String)object2, l);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0638\ufee9\u0633\u0640(String string) {
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
    public static String \u0639\u0645\ufecd\ufe8f(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() > 0) return null;
        return tX.SN(object);
    }

    public static void \u0640\u062b\u0635\u0643(Object object) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() <= 0) {
            ((Thread)object).start();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0640\u0645\u0632\ufeb1() {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() > 0) return null;
        return "quarkSt";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static kb_0 \u0642\ufeaf\ufeb9\u0631(Object object, Object object2) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() >= 0) return null;
        return ((kb_0)object).i((String)object2);
    }

    public static String \u0645\u062f\u062d\ufeaf(short[] sArray, int n2, int n3, int n4) {
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
    public static Set \ufeab\u0643\u0645\ufee1(Object set) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() <= 0) return null;
        return ((HashMap)((Object)set)).keySet();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeaf\ufe95\ufecd\ufee1(Object object, Object object2, Object object3) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() > 0) return null;
        return ((i3)object).g9((H7)object2, (File)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec1\u0644\ufeb1\u062b(Object object) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() < 0) return null;
        return ((tX)object).Nl();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec9\u0640\u0639\u0645(Object object, Object object2, Object object3) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() > 0) return null;
        return String.format((Locale)object, (String)object2, (Object[])object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static qD \ufed9\ufeb9\u062e\ufec5(Object object) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() > 0) return null;
        return ((j_0)object).t0;
    }
}

