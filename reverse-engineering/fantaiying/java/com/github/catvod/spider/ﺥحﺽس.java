/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Build
 *  android.text.TextUtils
 *  android.widget.ImageView
 */
package com.github.catvod.spider;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.ID;
import com.github.catvod.spider.merge.Jr;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.T1;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.os_0;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class \ufea5\u062d\ufebd\u0633 {
    public static int \u0645\ufec5\ufe8f\ufea9 = 593;

    public static void \u062a\ufeb9\ufea5\ufe95(Object object, Object object2) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() <= 0) {
            ((tX)object).un((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062f\ufe8e\ufeb1\ufee9(Object object) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return null;
        return ((H7)object).W();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0631\u062d\ufec1\u0636(Object object) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() >= 0) return false;
        return ((xu_0)object).v3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Date \u0632\u0641\ufedd\ufed9(Object object, Object object2) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() < 0) return null;
        return ((DateFormat)object).parse((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0639\u0640\u062c\ufedd() {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() >= 0) return null;
        return "\"status\":200";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0639\u0641\u0634\u064a(Object object) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() <= 0) return null;
        return ((H7)object).v();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0639\ufeb1\ufead\ufe8f(Object object) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() <= 0) return false;
        return TextUtils.isEmpty((CharSequence)((CharSequence)object));
    }

    public static int \u0640\u0637\u062a\ufead(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0645\u0648\ufea1\u0631(Object object) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() > 0) return null;
        return ((ID)object).SN();
    }

    public static int \u0645\ufe95\u0647\ufec1() {
        return 0x1B5 ^ \ufe8f\ufe8e\ufeb5\u0641.\ufed5\u0636\u0638\u062c;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0645\ufec1\ufed5\u062c(Object object, Object object2, Object object3) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() >= 0) return null;
        return ((String)object).replace((CharSequence)object2, (CharSequence)object3);
    }

    public static void \u0646\u0648\u062a\u0645(Object object, Object object2) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() >= 0) {
            ((ImageView)object).setImageBitmap((Bitmap)object2);
        }
    }

    public static void \u0647\u0633\ufe95\ufef1(Object object, Object object2, Object object3, Object object4) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() < 0) {
            ((Logger)object).log((Level)object2, (String)object3, (Throwable)object4);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe99\u0628\u0637\ufe9d(Object object, Object object2) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return null;
        return ((iK)object).N((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe99\u0640\ufead\ufef1(Object object) {
        if (\u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a() >= 0) return null;
        return ((Context)object).getPackageName();
    }

    public static String \ufea5\ufeb1\u0643\ufe8f(short[] sArray, int n2, int n3, int n4) {
        char[] cArray = new char[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            cArray[i2] = (char)(sArray[n2 + i2] ^ n4);
        }
        return new String(cArray);
    }

    public static void \ufead\ufe8e\ufeb9\ufed5(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() < 0) {
            ((ReentrantLock)object).unlock();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufead\ufeb1\ufeed\u0641() {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() >= 0) return null;
        return "sid";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Ef \ufeb5\u0632\u0642\u0638(Object object, Object object2, Object object3) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() >= 0) return null;
        return ((i3)object).p((String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeb5\ufec5\u0639\ufea1() {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() <= 0) return null;
        return "play";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static T1 \ufeb9\u0630\u062f\u0633(Object object) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() > 0) return null;
        return T1.zH((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufebd\u0632\u0645\ufedd() {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() < 0) return null;
        return "nick_name";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] \ufec5\u0634\ufeb1\u0648(Object object, Object object2, Object object3) {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() <= 0) return null;
        return rs_0.SN((byte[])object, (byte[])object2, (byte[])object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec9\u062b\u0634\u0639() {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() <= 0) return null;
        return os_0.yq();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufecd\ufe99\u0634\ufec9(String object) {
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
    public static Integer \ufee9\ufecd\ufeed\u062e(Object object) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() < 0) return null;
        return Integer.valueOf((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufeed\u0630\ufecd\u0632(Object object) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() > 0) return 0;
        return ((Jr)object).SN();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeed\ufef1\ufea1\u0643(Object object, Object object2, Object object3, Object object4) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() > 0) return null;
        return ((N0)object).mG((String)object2, (tX)object3, (String)object4);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufef1\ufe8e\u0640\ufe99() {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() >= 0) return null;
        return Build.SERIAL;
    }
}

