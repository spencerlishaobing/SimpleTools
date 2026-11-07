/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.app.AlertDialog;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Gt;
import com.github.catvod.spider.merge.ID;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.Yx;
import com.github.catvod.spider.merge.ak;
import com.github.catvod.spider.merge.e2;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.nb_0;
import com.github.catvod.spider.merge.qq_0;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.x5;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

public class \ufe8e\u0627\ufecd\u062a {
    public static int \ufec9\ufee9\u0635\u062a = 429;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062a\u0645\ufea9\u0637(Object object, Object object2) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() >= 0) return null;
        return ((ByteArrayOutputStream)object).toString((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062f\u0631\u0648\u0642(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() > 0) return null;
        return ((Gt)object).zH();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u062f\u0638\ufe8e\ufe99(Object object) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() >= 0) return false;
        return ((Iterator)object).hasNext();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0630\ufeb1\ufed5\ufeb5(Object object) {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() > 0) return false;
        return ((HashMap)object).isEmpty();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0633\u0643\ufead\u0627(Object object, int n2) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() >= 0) return 0;
        return ((Random)object).nextInt(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0633\ufeed\ufea9\u063a() {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() > 0) return null;
        return "\u8bbe\u7f6eUT\u6210\u529f";
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0634\u0627\ufee1\ufea5(String object) {
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
        while (true) {
            if (((String)object).length() <= 0) break;
            byteArrayOutputStream.write(string.indexOf(((String)object).charAt(-2)) << 4 | string.indexOf(((String)object).charAt(-1)));
        }
        object = byteArrayOutputStream.toByteArray();
        int n4 = ((Object)object).length;
        int n5 = string2.length();
        n3 = n2;
        while (n3 < n4) {
            object[n3] = (byte)(object[n3] ^ string2.charAt(n3 % n5));
            ++n3;
        }
        return new String((byte[])object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \u0634\u0648\u0633\ufe8f(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() >= 0) return null;
        return Pan.msg((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static AlertDialog \u0634\ufeb1\ufecd\u0648(Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return null;
        return ((AlertDialog.Builder)object).create();
    }

    public static void \u0636\ufe99\u0628\ufe8f(Object object, Object object2) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() > 0) {
            ((n6)object).n((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Boolean \u0637\ufec1\ufe8f\ufeb9() {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() > 0) return null;
        return Boolean.FALSE;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0637\ufec9\ufe95\ufed9(Object object) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() < 0) return null;
        return ((nb_0)object).N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \u0640\u0647\u062c\u062d(Object list) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() <= 0) return null;
        return ((e2)((Object)list)).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long \u0640\ufec5\ufedd\u0634(Object object) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() < 0) return 0L;
        return ((Date)object).getTime();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Yx \u0641\u0633\ufeed\u0631(Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return null;
        return ((Yx)object).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static qq_0 \u0641\u0640\ufee1\ufea9(Object object, Object object2) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() >= 0) return null;
        return ((qq_0)object).SN((String)object2);
    }

    public static String \u0641\ufea1\ufea9\ufecd(short[] sArray, int n2, int n3, int n4) {
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
    public static byte[] \u0642\u0634\u0633\ufea1(Object object) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return null;
        return ((String)object).getBytes();
    }

    public static int \u0642\ufec5\u062d\u0643(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0647\u0633\u0639\u0648() {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() < 0) return null;
        return "\u7528\u6237\u7981\u6b62\u8f6c\u5b58\u81ea\u5df1";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static x5 \u0648\u0639\ufef1\u062e(Object object) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return null;
        return x5.zH((String)object);
    }

    public static int \ufe99\ufead\ufeb5\ufe95() {
        return 0x366 ^ \ufe8f\ufe8e\ufeb5\u0641.\ufed5\u0636\u0638\u062c;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static x5 \ufe99\ufecd\u0644\ufeb1(Object object) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() <= 0) return null;
        return ((j_0)object).M;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ID \ufeab\u0634\u0648\ufea9(Object object, Object object2) {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() < 0) return null;
        return ((ID)object).q((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeab\u0641\ufeb5\ufeb9(Object object, Object object2, Object object3) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() >= 0) return null;
        return ((N0)object).un((String)object2, (List)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeab\ufe9d\u062a\u0627() {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() <= 0) return null;
        return "sub";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \ufeb1\u0644\u0628\u0639(Object object) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() >= 0) return null;
        return ((N0)object).G4;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufebd\u064a\u0648\u062a(Object list) {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() < 0) return null;
        return ((j_0)((Object)list)).s();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec9\u062e\ufed5\u062d() {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() < 0) return null;
        return "text/html";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec9\ufee1\ufe99\ufec1(Object object) {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() <= 0) return null;
        return ((n6)object).zH();
    }

    public static void \ufedd\u0648\ufe9d\u062f(Object object, Object object2) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() > 0) {
            ((tX)object).tO((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee9\ufec9\u0642\u0643(Object object) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() >= 0) return null;
        return ((ak)object).SN();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File \ufeed\u0628\ufe8f\u0642(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() >= 0) return null;
        return ((xu_0)object).O();
    }
}

