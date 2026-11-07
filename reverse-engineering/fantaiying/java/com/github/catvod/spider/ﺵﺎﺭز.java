/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 */
package com.github.catvod.spider;

import android.os.Build;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.spider.merge.HG;
import com.github.catvod.spider.merge.M4;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.lm;
import com.github.catvod.spider.merge.qD;
import com.github.catvod.spider.merge.z2_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.nio.channels.Pipe;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class \ufeb5\ufe8e\ufead\u0632 {
    public static int \u0635\u0634\u0640\ufeab = -16;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062c\u062b\u0639\u0637(Object object) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() >= 0) return null;
        return ((qD)object).tF();
    }

    public static int \u0630\u062f\u0638\ufecd(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Pipe \u0634\ufe8e\u0628\u063a() {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() > 0) return null;
        return Pipe.open();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \u0635\ufebd\u062f\u0637(Object list) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return null;
        return ((lm)((Object)list)).N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0636\ufeaf\ufea1\u0631() {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() >= 0) return null;
        return "share";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File \u0637\u062f\u0646\ufeed(Object object) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() > 0) return null;
        return M4.yq((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u063a\ufe8f\ufeb5\ufea9(Object object) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() >= 0) return null;
        return ((i3)object).t0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String[] \u0640\ufec5\ufedd\u0634(Object stringArray, Object object) {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() >= 0) return null;
        return ((String)stringArray).split((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0641\u062b\u0636\u0637() {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() > 0) return null;
        return Build.CPU_ABI2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File \u0641\u062e\ufed5\u0633(Object object) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() >= 0) return null;
        return M4.SN((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0645\u0630\ufeb9\ufea1(Object object, Object object2) {
        if (\ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9() <= 0) return null;
        return ((String)object).toLowerCase((Locale)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0645\ufeb5\u0647\ufea5(Object object, Object object2) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() > 0) return false;
        return ((j_0)object).v3((String)object2);
    }

    public static void \u0646\ufedd\u062e\ufee9(Object object) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() < 0) {
            ((OutputStream)object).flush();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Future \u0647\u0639\u062e\u0648(Object future, Object object) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() < 0) return null;
        return ((ExecutorCompletionService)((Object)future)).submit((Callable)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0647\ufea9\ufeb9\ufee1(Object object) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() > 0) return false;
        return ((ReentrantLock)object).tryLock();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0648\ufeb1\ufecd\u0627() {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() >= 0) return null;
        return "md5";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0648\ufed9\ufeab\u062a() {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() <= 0) return null;
        return "&client_secret=";
    }

    public static String \ufe8f\ufef1\u0648\ufe95(short[] sArray, int n2, int n3, int n4) {
        char[] cArray = new char[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            cArray[i2] = (char)(sArray[n2 + i2] ^ n4);
        }
        return new String(cArray);
    }

    public static int \ufe95\u0647\u062d\u0631() {
        return 0xFFFFFFBC ^ \u0632\ufead\u062f\u0628.\u0648\u0647\ufe9d\u062b;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufeab\u063a\u0632\ufec9(String object) {
        int n2 = 0;
        String string = "";
        String string2 = "";
        int n3 = 0;
        while (true) {
            if (n3 >= 15) {
                while (string.length() > 0) {
                }
                break;
            }
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
    public static String \ufec1\u0644\ufec5\ufee1(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() > 0) return null;
        return HG.yq((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec9\u0639\ufeb5\ufe8e() {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() <= 0) return null;
        return "&subFid_token=";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufecd\ufea5\ufedd\ufebd(int n2) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() < 0) return 0;
        return ME.q(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee9\u0637\ufef1\u0644(Object object) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return null;
        return ((dl_0)object).tF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static hN \ufef1\ufeab\u062c\u0640(Object object, Object object2) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() > 0) return null;
        return z2_0.yq((String)object, (hN)object2);
    }
}

