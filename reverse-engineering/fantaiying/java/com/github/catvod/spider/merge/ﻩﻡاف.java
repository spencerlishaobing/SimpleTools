/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.kp;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.t_0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.zh_0;
import com.github.catvod.spider.merge.zm_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class \ufee9\ufee1\u0627\u0641 {
    public static int \u0639\u062c\ufed5\u0632 = 145;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Set \u0628\ufec9\u0642\u0636(Object set) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() >= 0) return null;
        return ((Map)((Object)set)).entrySet();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \u062a\u0630\u062e\u063a(Object list) {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() > 0) return null;
        return ((H7)((Object)list)).t0();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062b\ufedd\ufeed\u062f(Object object) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() > 0) return null;
        return ((hN)object).Fo();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0636\ufedd\ufebd\ufea5(Object object) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() <= 0) return null;
        return ((Uri)object).getScheme();
    }

    public static void \u0638\ufe9d\u0627\u0641(Object object, Object object2) {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() >= 0) {
            ((dl_0)object).g1((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u063a\ufeaf\u0647\ufe8e() {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() < 0) return null;
        return Pan.Gd;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static StringBuilder \u063a\ufec5\ufee1\u0645(Object object, Object object2, Object object3, Object object4, Object object5) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() < 0) return null;
        return zh_0.N((String)object, (String)object2, (String)object3, (String)object4, (String)object5);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0641\u0633\u0647\ufed9(Object object, Object object2, Object object3, boolean bl, Object object4, Object object5) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() <= 0) return null;
        return ((N0)object).OW((tX)object2, (String)object3, bl, (String)object4, (File)object5);
    }

    public static int \u0641\u0638\ufeb1\ufeb5() {
        return 0xD8 ^ \ufeb1\ufe8e\ufee1\ufe9d.\ufead\u0630\ufed9\ufeb5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0641\ufea1\ufeb9\u0632(Object object, Object object2) {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() < 0) return false;
        return ((PackageManager)object).hasSystemFeature((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0643\ufea1\ufe95\ufebd(Object object) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() < 0) return 0;
        return ((t_0)object).zH();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0644\ufef1\u0643\u0631(String object) {
        int n2 = 0;
        String string = "";
        String string2 = "";
        int n3 = 0;
        while (true) {
            if (n3 >= 15) break;
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
        n3 = string2.length();
        while (true) {
            if (n4 <= 0) break;
            object[-1] = (byte)(object[-1] ^ string2.charAt(-1 % n3));
        }
        n3 = n2;
        while (n3 < ((Object)object).length) {
            n3 = "".length() + 1;
        }
        return new String((byte[])object);
    }

    public static void \u0645\ufe99\u0631\ufea5(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() < 0) {
            ((Dialog)object).show();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \u0647\ufed5\u0640\u0630(Object hashMap, Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return null;
        return ((xu_0)((Object)hashMap)).i3((String)object);
    }

    public static void \u064a\ufec9\u063a\ufeed(Object object, Object object2) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() >= 0) {
            ((tX)object).Fz((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \ufe8e\ufed5\ufeed\ufeaf(Object object, Object object2, Object object3) {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() >= 0) return null;
        return ((j_0)object).g((String)object2, (String)object3);
    }

    public static int \ufe8e\ufee9\u0647\u0631(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8f\u0639\ufef1\u0634() {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() > 0) return null;
        return "User-Agent";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Thread \ufe8f\ufe95\u0645\ufed9() {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() >= 0) return null;
        return Thread.currentThread();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufe95\u062b\u062e\u0646() {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() <= 0) return 0;
        return kp.yq;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe9d\u0632\u0627\u0633(Object object) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() > 0) return null;
        return ((Class)object).getName();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea1\u0641\u0630\ufef1(Object object) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() > 0) return null;
        return ((H7)object).q();
    }

    public static String \ufea1\ufebd\u063a\u0630(short[] sArray, int n2, int n3, int n4) {
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
    public static String \ufea5\ufed9\u0635\ufea1() {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() < 0) return null;
        return "+";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONArray \ufead\ufeb1\u0627\u0641(Object object, Object object2) {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() <= 0) return null;
        return ((JSONObject)object).getJSONArray((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeaf\ufeb5\ufead\u0635(Object object) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return ((H7)object).ee();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec1\u062e\ufeab\ufebd(Object object, Object object2, Object object3) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() >= 0) return null;
        return zm_0.i((String)object, (Map)object2, (Map)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec5\u062a\u0640\u0627(Object object, Object object2) {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() <= 0) return null;
        return ((H7)object).N((String)object2);
    }

    public static void \ufeed\u0645\u0636\u0644(Object object, Object object2) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() > 0) {
            ((Context)object).startActivity((Intent)object2);
        }
    }
}

