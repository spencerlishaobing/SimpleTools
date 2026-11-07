/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.content.SharedPreferences;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.spider.Jpys;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.HG;
import com.github.catvod.spider.merge.LP;
import com.github.catvod.spider.merge.gh;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.nb_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class \ufebd\u0640\u0648\u062b {
    public static int \u0637\u0631\ufeb9\u0628 = -509;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062a\u0635\ufeb1\u0642(Object object, Object object2, Object object3, Object object4, boolean bl) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() < 0) return null;
        return ((i3)object).Q4((String)object2, (H7)object3, (String)object4, bl);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \u062f\u0637\u062b\u0633(Object list, Object object) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() < 0) return null;
        return ((j_0)((Object)list)).b((n6)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0632\u0631\ufe9d\u0644(Object object, Object object2, Object object3) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() > 0) return null;
        return ((SharedPreferences)object).getString((String)object2, (String)object3);
    }

    public static int \u0633\u0637\u0632\ufeab() {
        return 0x3B6 ^ \u0644\ufe8f\u0628\u062a.\ufead\ufeb9\ufec1\ufedd;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0638\ufee1\ufec9\u0634() {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return null;
        return "\u6765\u81ea\u5206\u4eab";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0640\u0636\ufeb5\u063a(Object object, Object object2) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return null;
        return ((String)object).toUpperCase((Locale)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0642\ufec1\u0648\u0640(Object object) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() >= 0) return null;
        return Jpys.sha1((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0643\u0627\ufef1\ufebd(Object object) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return null;
        return ((H7)object).Gc();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0644\ufeed\ufee1\u0635() {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() < 0) return null;
        return "cookie";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0646\ufed5\u0630\ufec9(Object object, Object object2) {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() < 0) return null;
        return Bo.B((String)object, (Map)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0648\ufecd\u0630\ufe9d() {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() <= 0) return null;
        return "stoken";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8e\u0640\ufec1\u064a(Object object) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() < 0) return null;
        return HG.N((Map)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8f\ufedd\ufeab\ufecd() {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() < 0) return null;
        return "\u8bf7\u9009\u62e9\u4e0b\u8f7d\u5de5\u5177";
    }

    public static int \ufe95\ufecd\u062b\ufe99(Object object) {
        return object.hashCode();
    }

    public static void \ufe9d\ufecd\u0633\u0645(Object object) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() > 0) {
            gh.SN((List)object);
        }
    }

    public static String \ufea5\u0639\u0631\ufe95(short[] sArray, int n2, int n3, int n4) {
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
    public static boolean \ufeb1\u0640\u0638\u0647(Object object, Object object2) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() <= 0) return false;
        return ((JSONObject)object).isNull((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufebd\u062d\u0633\ufeaf(Object object, Object object2) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() > 0) return 0;
        return ((StringBuilder)object).lastIndexOf((String)object2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufebd\u0634\ufe99\u0647(String string) {
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
    public static String \ufedd\ufec1\u0627\ufeb5() {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() < 0) return null;
        return "uc_ck";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static nb_0 \ufee9\u0627\u063a\u0637(Object object) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return null;
        return ((nb_0)object).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeed\ufeaf\u0648\ufec9() {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() >= 0) return null;
        return "ffc6341c056de41cf4ab95343d9c22fe";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufef1\u0632\u0634\u0645(Object list) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() > 0) return null;
        return ((LP)((Object)list)).SN();
    }
}

