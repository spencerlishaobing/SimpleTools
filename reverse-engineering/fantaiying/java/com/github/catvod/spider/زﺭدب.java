/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences$Editor
 *  android.net.Uri
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.SharedPreferences;
import android.net.Uri;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.HG;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.qD;
import com.github.catvod.spider.merge.rs_1;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.ts_0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;

public class \u0632\ufead\u062f\u0628 {
    public static int \u0648\u0647\ufe9d\u062b = 184;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0628\ufedd\u0632\u0634(Object object) {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() >= 0) return null;
        return ((qD)object).N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062a\ufeb1\u0644\u0628() {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() <= 0) return null;
        return "https://broccoli.uc.cn/";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] \u062b\u0638\ufeb9\ufeaf(Object object, Object object2) {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() <= 0) return null;
        return ((Cipher)object).doFinal((byte[])object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \u062e\u063a\ufeb5\u0634() {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() < 0) return null;
        return rs_1.tF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0630\u0641\ufecd\ufee9(Object object, Object object2, boolean bl, int n2) {
        if (\ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9() < 0) return null;
        return ((j_0)object).F5((n6)object2, bl, n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static SharedPreferences.Editor \u0631\ufeaf\ufe99\u062d(Object object, Object object2, Object object3) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() < 0) return null;
        return ((SharedPreferences.Editor)object).putString((String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0631\ufeb5\u0640\u0635() {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return null;
        return "2";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0633\ufeed\u0634\ufef1(Object object) {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() >= 0) return null;
        return ((ts_0)object).tF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0634\u063a\u062e\ufeb5(Object object) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() >= 0) return null;
        return ((n6)object).v3();
    }

    public static int \u0637\ufeb1\ufe8f\ufec5(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0638\ufea5\ufec1\ufe8f(Object object, Object object2) {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() >= 0) return false;
        return ((String)object).startsWith((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object[] \u0639\ufeb9\ufecd\u0641(Object objectArray, Object object) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() < 0) return null;
        return ((xu_0)objectArray).Q4((Map)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \u063a\u0638\u0628\ufeb5(Object hashMap, Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return null;
        return ((i3)((Object)hashMap)).kR((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \u0640\u063a\u0630\ufee1(Object object, Object object2) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() > 0) return null;
        return ME.OW((String)object, (JSONObject)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0641\u0627\ufedd\ufec1(Object object, Object object2, Object object3) {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() > 0) return null;
        return ((i3)object).O((String)object2, (List)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0642\u062b\ufea9\ufecd(Object object, Object object2) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() > 0) return 0;
        return ((JSONObject)object).getInt((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0642\ufe8e\u0641\u0639(Object object) {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() < 0) return null;
        return ((dl_0)object).g9();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0642\ufecd\ufeaf\ufec9(Object object) {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() <= 0) return null;
        return HG.tF((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Set \u0643\u0630\u062a\u0641(Object set) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() < 0) return null;
        return ((LinkedHashMap)((Object)set)).keySet();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0643\u0644\ufec9\ufee9() {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() > 0) return null;
        return "task_id";
    }

    public static String \u0645\u062a\u0637\u0635(short[] sArray, int n2, int n3, int n4) {
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
    public static tX \u0645\u0648\ufe8f\u0634(Object object) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() > 0) return null;
        return tX.s((String)object);
    }

    public static int \u064a\u062d\ufea1\u0648() {
        return 0x3A2 ^ \u0641\ufeb5\ufeb1\ufee1.\u0646\u0633\u0647\u062b;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufe8e\ufec1\u0641\u0644(String string) {
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
    public static String \ufe99\u0631\u062e\u0632(Object object) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() <= 0) return null;
        return ((Uri)object).getPath();
    }

    public static void \ufe99\ufeab\ufe8f\u062f(Object object, Object object2) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() <= 0) {
            ((Ef)object).v3((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe9d\u0638\u062f\ufeed(Object object) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() <= 0) return null;
        return ((n6)object).B();
    }

    public static void \ufea5\u0644\ufeb1\ufe8f(Object object) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() <= 0) {
            ((ExecutorService)object).shutdown();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \ufead\u062b\ufeb1\u0644(Object object, int n2) {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() < 0) return null;
        return ((JSONArray)object).optJSONObject(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeb5\ufea5\ufeed\u0643() {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() > 0) return null;
        return "https://pc-api.uc.cn/1/clouddrive/file/download?pr=UCBrowser&fr=pc&uc_param_str=";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \ufec9\ufec1\u0631\u0642(Object hashMap) {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() <= 0) return null;
        return ((xu_0)((Object)hashMap)).g1();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufecd\ufe8e\u062f\ufebd(Object object) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return null;
        return ((tX)object).zH();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufedd\u0647\u063a\u062c(Object object) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() < 0) return null;
        return ((tX)object).v();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee1\ufef1\u0640\u0637() {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() >= 0) return null;
        return "\u6a21\u5f0f1";
    }
}

