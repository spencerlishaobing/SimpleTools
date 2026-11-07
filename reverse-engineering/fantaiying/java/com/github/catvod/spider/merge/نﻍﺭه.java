/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.Xu;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.f1_0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.i8_0;
import com.github.catvod.spider.merge.jA;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.nb_0;
import com.github.catvod.spider.merge.rs_1;
import com.github.catvod.spider.merge.sI;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.ts_0;
import com.github.catvod.spider.merge.wg;
import com.github.catvod.spider.merge.x5;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class \u0646\ufecd\ufead\u0647 {
    public static int \u0635\ufec5\ufed5\ufead = 418;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0627\ufead\u0640\u0639() {
        if (\ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9() <= 0) return null;
        return "\u64ad\u4f18\u6c50\u667a\u9700\u518d\u626b\u7801\u4e00\u6b21,\u6ca1\u770b\u5230\u7801\u7684\u91cd\u542f\u8bd5\u8bd5";
    }

    public static void \u0628\ufeb9\u0639\u0627(Object object, Object object2, Object object3) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() >= 0) {
            ((xu_0)object).tO((String)object2, (String)object3);
        }
    }

    public static int \u0628\ufee1\ufef1\u0630(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static StringBuilder \u062a\u0647\u0635\u0646(Object object, Object object2) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() >= 0) return null;
        return ((StringBuilder)object).append((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062c\ufecd\u062e\u0635() {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() < 0) return null;
        return "callPlayMode";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062f\u0638\ufe8e\ufe99() {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() < 0) return null;
        return "video/*";
    }

    public static int \u0631\u0642\u062d\u064a() {
        return 0xFFFFFEA2 ^ \u062a\u0635\ufeb1\u0642.\ufebd\ufea1\u0631\ufea5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Matcher \u0635\ufec1\u0640\u0632(Object object, Object object2) {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() < 0) return null;
        return ((Pattern)object).matcher((CharSequence)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0635\ufec9\u0638\ufeb1() {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() >= 0) return null;
        return Build.BRAND;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0636\u0646\u062e\ufeb5(Object object, Object object2) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() >= 0) return null;
        return Xu.yq((String)object, (String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0636\ufeb5\ufec5\u0640(Object object) {
        if (\ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9() <= 0) return null;
        return ((tX)object).xa();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0637\u063a\u0641\u0647(Object object) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return null;
        return ((dl_0)object).q();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \u0637\ufee9\u062c\ufe95(Object object, Object object2) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() < 0) return null;
        return ((Tq)object).g1((String)object2);
    }

    public static void \u0638\ufeaf\u0631\u0640(Object object, boolean bl) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() >= 0) {
            ((AccessibleObject)object).setAccessible(bl);
        }
    }

    public static String \u0640\u062e\ufed5\ufeaf(short[] sArray, int n2, int n3, int n4) {
        char[] cArray = new char[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            cArray[i2] = (char)(sArray[n2 + i2] ^ n4);
        }
        return new String(cArray);
    }

    public static void \u0642\u0641\ufef1\u062b(Object object) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() >= 0) {
            ((InputStream)object).close();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \u0642\ufea5\ufeaf\ufef1(Object object, int n2) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() < 0) return null;
        return ((PackageManager)object).getInstalledApplications(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \u0643\ufe8e\u0644\ufe95(Object object, int n2) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return null;
        return ((List)object).get(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0645\ufeb1\ufead\ufea1(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() >= 0) return 0;
        return ((i8_0)object).SN;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Locale \u0646\u0627\u062a\u062d() {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() > 0) return null;
        return Locale.getDefault();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static nb_0 \u0648\ufed9\u0639\ufe9d(Object object) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() > 0) return null;
        return ((nb_0)object).B();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8e\ufedd\ufe9d\ufec5(Object object) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() < 0) return null;
        return ((tX)object).g9();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \ufe8f\u0640\u062e\ufec9(Object object) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() > 0) return null;
        return ((Tq)object).G4();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufe8f\ufed9\ufeaf\u0639(String object) {
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
    public static String \ufe95\ufec1\ufeb9\ufeb1() {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() >= 0) return null;
        return wg.N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \ufe99\u0636\u0627\ufe8f() {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() < 0) return null;
        return rs_1.ee();
    }

    public static void \ufe9d\u0628\u0636\ufea5(Object object, Object object2) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() >= 0) {
            ((Ef)object).W((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static AlertDialog.Builder \ufe9d\ufeaf\u062a\u0646(Object object, Object object2) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() <= 0) return null;
        return ((AlertDialog.Builder)object).setMessage((CharSequence)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \ufead\u062d\ufedd\u0648(Object hashMap, Object object) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() >= 0) return null;
        return ((xu_0)((Object)hashMap)).b((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static jA \ufeb5\u062f\ufeb9\ufef1() {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() >= 0) return null;
        return jA.SN;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \ufeb9\u0642\ufeab\u062b(Object hashMap, Object object) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() < 0) return null;
        return ((N0)((Object)hashMap)).cp((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufebd\u0639\u0638\u062f(Object object, Object object2) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() < 0) return false;
        return ((i3)object).m((String)object2);
    }

    public static void \ufec1\u0639\ufec5\ufee1(Object object, Object object2) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() > 0) {
            ((tX)object).Zm((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Iterator \ufec5\ufecd\ufe95\u0627(Object iterator) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() > 0) return null;
        return ((ArrayList)((Object)iterator)).iterator();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \ufecd\u062e\ufec1\u0632(Object object) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return null;
        return ((Tq)object).zH();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufed5\u0641\ufeed\u0636() {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return false;
        return sI.SN();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static x5 \ufed9\u062f\u0627\u0630(Object object) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() < 0) return null;
        return ((x5)object).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static f1_0 \ufed9\ufee9\u0646\u0630(Object object) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() < 0) return null;
        return ((ts_0)object).KJ();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee9\u0627\u062b\ufea1(Object object) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() < 0) return null;
        return ((n6)object).Nl();
    }
}

