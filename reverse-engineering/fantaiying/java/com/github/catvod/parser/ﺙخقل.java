/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.os.Build;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.WN;
import com.github.catvod.spider.merge.X0;
import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.uA;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.zh_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class \ufe99\u062e\u0642\u0644 {
    public static int \ufe8e\ufeb1\ufea5\u0640 = 64;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static dl_0 \u062a\ufedd\u0630\u062e(Object object) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() >= 0) return null;
        return dl_0.OW((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u062b\u0642\u0633\u0638(int n) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() < 0) return 0;
        return zh_0.yq(n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062d\u062b\ufec9\ufeab() {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() <= 0) return null;
        return "$";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062d\ufead\u0644\ufec5(Object object) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() >= 0) return null;
        return ((String)object).trim();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0632\ufe9d\ufec9\u0639(Object object) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() >= 0) return null;
        return ((WN)object).M();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \u0634\u0627\ufee1\ufea5(Object object, Object object2) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() >= 0) return null;
        return ((JSONObject)object).opt((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0634\ufeaf\u0638\u0641(Object object) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() <= 0) return null;
        return ((n6)object).q();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0635\u0634\u0640\ufee1(Object object, Object object2, boolean bl, Object object3, Object object4) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() > 0) return null;
        return ((xu_0)object).W((dl_0)object2, bl, (String)object3, (File)object4);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0635\ufe8e\u0631\ufef1() {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() < 0) return null;
        return "subFid_token";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0642\u062c\u063a\ufec1() {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() > 0) return null;
        return uA.zH;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \u0644\u0645\ufeaf\u0627(Object object, Object object2) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() >= 0) return null;
        return Z.yq((String)object, (Class)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0645\ufeed\u064a\u0631(Object object) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() < 0) return null;
        return ((X0)object).N();
    }

    public static void \u0647\u0640\ufed9\u0643(Object object, Object object2) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() > 0) {
            ((SecureRandom)object).nextBytes((byte[])object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \u064a\ufea9\ufec9\u0637() {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return JSONObject.NULL;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufe8f\ufecd\u0636\u0634(Object object, Object object2) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() > 0) return false;
        return ((JSONObject)object).getBoolean((String)object2);
    }

    public static int \ufe99\ufec9\ufec5\u0646() {
        return 0x38B ^ \ufe8f\ufe8e\ufeb5\u0641.\ufed5\u0636\u0638\u062c;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe9d\u062b\u0642\u0627() {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() < 0) return null;
        return Build.DEVICE;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea1\u062e\ufecd\ufeab(Object object) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() >= 0) return null;
        return Tq.ee((List)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea1\ufecd\ufeed\u063a() {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() <= 0) return null;
        return "playMode";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufeab\u0635\u0645\ufe95(Object object) {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() < 0) return false;
        return ((i3)object).ee();
    }

    public static void \ufeab\u0639\ufea1\u062d(Object object, Object object2, Object object3, Object object4, Object object5) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() < 0) {
            ((Pan)((Object)object)).setNewData((JSONObject)object2, (JSONArray)object3, (String)object4, (HashMap)object5);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeaf\u062f\ufe99\u0636(Object object) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() > 0) return null;
        return dl_0.SN(object);
    }

    public static int \ufeb5\ufee1\ufea5\ufec9(Object object) {
        return object.hashCode();
    }

    public static String \ufec1\u0644\u0645\ufec9(short[] sArray, int n, int n2, int n3) {
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
    public static List \ufee9\u064a\u0643\u0634(Object list, Object object) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() > 0) return null;
        return ((i3)((Object)list)).xU((H7)object);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufeed\u0628\ufeb1\u0639(String string) {
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
}

