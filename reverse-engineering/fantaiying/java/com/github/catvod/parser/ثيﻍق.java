/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.parser;

import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.LP;
import com.github.catvod.spider.merge.MI;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.T1;
import com.github.catvod.spider.merge.X0;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.fu_0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.qD;
import com.github.catvod.spider.merge.t_0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;

public class \u062b\u064a\ufecd\u0642 {
    public static int \u0630\ufecd\ufeab\ufee9 = 459;

    public static void \u0628\ufe95\ufef1\ufed5(Object object, Object object2) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() > 0) {
            ((H7)object).b((String)object2);
        }
    }

    public static void \u0628\ufee1\ufeb1\u0631(Object object) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() >= 0) {
            ((N0)object).g1();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062a\u0630\ufead\ufea9(Object object) {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() >= 0) return null;
        return ((String)object).toLowerCase();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u062a\ufeb5\ufee1\u0627(Object object) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() > 0) return false;
        return ((H7)object).OW();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] \u062b\ufe9d\ufeb5\ufe95(Object object, Object object2) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() <= 0) return null;
        return ((Mac)object).doFinal((byte[])object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte \u062c\ufeed\ufecd\u0627(Object object, int n, int n2) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() > 0) return 0;
        return ((t_0)object).SN(n, n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u062d\ufea5\u0642\ufed5(Object object, int n) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() > 0) return 0;
        return ((String)object).lastIndexOf(n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \u062e\u0638\ufecd\ufea9(Object list, Object object) {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() > 0) return null;
        return ((fu_0)((Object)list)).yq((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static MI \u062f\u062d\ufea9\u0627(Object object) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() <= 0) return null;
        return ((xu_0)object).v;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0631\u0635\u0648\ufe95(Object object) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() > 0) return null;
        return ((LP)object).zH();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0635\ufecd\ufe99\u0647() {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() >= 0) return null;
        return "lastUcDownUrl";
    }

    public static int \u0637\ufecd\u0636\u0633(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static X0 \u0639\u0630\ufead\ufec1(Object object) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() > 0) return null;
        return ((N0)object).dT;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0640\ufea1\ufee9\u0642(Object object, Object object2, Object object3) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() <= 0) return null;
        return ((i3)object).o((H7)object2, (String)object3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0641\ufea1\u0646\u062f(String object) {
        int n = 0;
        String string = "";
        String string2 = "";
        int n2 = 0;
        while (true) {
            if (n2 >= 15) {
                while (string.length() > 0) {
                }
                break;
            }
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
    public static String \u0642\ufec5\u0631\u0635() {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return null;
        return "android.intent.action.VIEW";
    }

    public static void \u064a\u062b\u0639\ufee9(Object object, Object object2, int n, int n2) {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() >= 0) {
            ((ByteArrayOutputStream)object).write((byte[])object2, n, n2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8f\u0633\u0639\ufef1() {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() >= 0) return null;
        return "{\"fid_list\":[\"%s\"],\"fid_token_list\":[\"%s\"],\"to_pdir_fid\":\"%s\",\"pwd_id\":\"%s\",\"stoken\":\"%s\",\"pdir_fid\":\"0\"}";
    }

    public static int \ufea9\ufec5\ufec1\ufec9() {
        return 0x14D ^ \ufeb9\u0643\ufed9\ufed5.\u0637\ufecd\u0636\u0633;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufead\ufe8e\ufeb9\ufed5(Object object) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() < 0) return null;
        return ((qD)object).SN();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufead\ufe99\u0648\u0639(Object object) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() >= 0) return 0;
        return ((Random)object).nextInt();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufead\ufeed\u0648\ufef1(Object object, long l, Object object2) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() < 0) return false;
        return ((ExecutorService)object).awaitTermination(l, (TimeUnit)((Object)object2));
    }

    public static void \ufebd\ufea9\u0636\u0630(Object object, Object object2) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() < 0) {
            ((dl_0)object).Zm((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec9\ufead\ufea9\ufe8f(Object object) {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() >= 0) return null;
        return URLEncoder.encode((String)object);
    }

    public static String \ufed9\u0630\u0627\ufea5(short[] sArray, int n, int n2, int n3) {
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
    public static String \ufedd\ufed5\u0642\ufed9() {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() < 0) return null;
        return "\u65e0\u6548";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static T1 \ufef1\u0627\u0637\ufea9(Object object) {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() < 0) return null;
        return ((i3)object).v3;
    }
}

