/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.app.Activity;
import android.content.SharedPreferences;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.spider.Cloud_quark;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.rs_1;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.y7;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.crypto.Mac;
import org.json.JSONObject;

public class \ufe99\u062c\u0643\ufec1 {
    public static int \u0636\u0630\ufeb1\ufea1 = 455;

    public static void \u062d\ufeb1\ufec9\u0642(Object object, Object object2) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() > 0) {
            ((HashMap)object).putAll((Map)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u062f\ufed5\u0633\u0632(Object object, Object object2) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() < 0) return false;
        return ((ArrayList)object).add(object2);
    }

    public static void \u062f\ufed9\u0627\u062e(Object object, Object object2) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() > 0) {
            ((Ef)object).KJ((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \u0638\u0643\u064a\ufe95(Object list) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() < 0) return null;
        return ((i3)((Object)list)).Fz();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0641\u062c\u0628\u063a() {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() < 0) return null;
        return "author";
    }

    public static void \u0643\ufe95\u0637\ufead(Object object, Object object2) {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() >= 0) {
            ((dl_0)object).b((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \u0643\ufedd\u0628\ufee9() {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() >= 0) return null;
        return rs_1.O();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0644\ufec5\u062e\u0631(Object object) {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() >= 0) return null;
        return ME.tF((String)object);
    }

    public static String \u0648\u0634\u063a\ufeb1(short[] sArray, int n2, int n3, int n4) {
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
    public static Byte \ufea1\u0636\u0638\u0635(byte by2) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() < 0) return null;
        return by2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static StringBuilder \ufea1\u064a\ufecd\u0647(Object object, int n2, Object object2) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() <= 0) return null;
        return ((StringBuilder)object).insert(n2, (String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeab\ufea9\u0640\u0632() {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() < 0) return null;
        return ME.SN;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufeab\ufec9\u062a\ufed5(String object) {
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
        n3 = ((Object)object).length;
        int n4 = string2.length();
        while (true) {
            if (n3 <= 0) break;
            object[-1] = (byte)(object[-1] ^ string2.charAt(-1 % n4));
        }
        n3 = n2;
        while (n3 < ((Object)object).length) {
            n3 = "".length() + 1;
        }
        return new String((byte[])object);
    }

    public static void \ufeb1\u0638\u063a\u0627(Object object, Object object2) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() > 0) {
            ((Cloud_quark)((Object)object)).setFlag((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] \ufebd\u062c\ufeb9\ufe99(Object object, int n2) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() <= 0) return null;
        return Arrays.copyOf((byte[])object, n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \ufebd\u0631\u0641\u0638(Object object, Object object2) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() >= 0) return null;
        return ((Tq)object).un((Ef)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Mac \ufebd\u0633\u0648\ufeab(Object object) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() < 0) return null;
        return Mac.getInstance((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ExecutorService \ufebd\ufeab\u064a\ufe8e(int n2) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return null;
        return Executors.newFixedThreadPool(n2);
    }

    public static int \ufebd\ufeb1\ufeb9\ufeaf(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufec5\ufeb5\u0637\ufe95(Object object) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return false;
        return ((y7)object).tF();
    }

    public static int \ufec5\ufee9\ufe8e\ufea1() {
        return 0x91 ^ \u0632\ufead\u062f\u0628.\u0648\u0647\ufe9d\u062b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec9\u0637\u062b\u0636(Object object) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() >= 0) return null;
        return ((tX)object).KJ();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static SharedPreferences.Editor \ufec9\ufec1\u0628\ufed9(Object object) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() <= 0) return null;
        return ((SharedPreferences)object).edit();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static H7 \ufecd\u0636\u062a\ufead(Object object, Object object2) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() <= 0) return null;
        return ((H7)object).s((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object[] \ufecd\u0643\ufea5\u0640(Object objectArray, Object object, int n2, long l, int n3) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() <= 0) return null;
        return ((j_0)objectArray).Zm((HashMap)object, n2, l, n3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long \ufedd\u0641\u062b\ufea9() {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() < 0) return 0L;
        return System.currentTimeMillis();
    }

    public static void \ufef1\u0638\u0635\ufedd(Object object, Object object2, Object object3) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() < 0) {
            ((Pan)((Object)object)).show((String)object2, (Activity)object3);
        }
    }
}

