/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 */
package com.github.catvod.parser;

import android.view.View;
import android.view.ViewGroup;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.spider.Cloud_baidu;
import com.github.catvod.spider.Nmyswv;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Gt;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.M4;
import com.github.catvod.spider.merge.RT;
import com.github.catvod.spider.merge.ak;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.ew_0;
import com.github.catvod.spider.merge.f_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.lm;
import com.github.catvod.spider.merge.nb_0;
import com.github.catvod.spider.merge.qD;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.t_0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.y5;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.LinkedList;

public class \ufe8f\ufe8e\ufeb5\u0641 {
    public static int \ufed5\u0636\u0638\u062c = -14;

    public static String \u062f\u0627\u0640\ufee1(short[] sArray, int n, int n2, int n3) {
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
    public static String \u062f\u0645\ufea5\u0646(Object object) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() >= 0) return null;
        return ((hN)object).kR();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0630\u0637\ufe95\ufeb1(Object object) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() <= 0) return null;
        return ((ak)object).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0630\u0647\u062d\u0641(Object object, int n) {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() < 0) return false;
        return ((f_0)object).zH(n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0633\ufef1\u0637\u062a(Object object) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() >= 0) return null;
        return ((nb_0)object).i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0635\ufea5\u0636\ufeb9(Object object) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() > 0) return null;
        return ((lm)object).B();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0639\ufe8f\u0630\ufead(Object object) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() < 0) return null;
        return ((Gt)object).N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0640\u062f\u0638\u0631(Object object) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() <= 0) return null;
        return ((dl_0)object).zH();
    }

    public static int \u0647\u0639\ufee9\ufedd() {
        return 0x366 ^ \u0644\ufe8f\u0628\u062a.\ufead\ufeb9\ufec1\ufedd;
    }

    public static void \u0647\u0648\u0634\u062f(Object object, int n, int n2, boolean bl) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() < 0) {
            ((t_0)object).t0(n, n2, bl);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Boolean \ufe8e\u0641\u062c\u064a(Object object, Object object2) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return null;
        return ((xu_0)object).Z((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufe8f\ufed5\u0630\ufecd(Object object) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return 0;
        return ((LinkedList)object).size();
    }

    public static void \ufe95\ufeaf\u0641\ufe99(Object object, Object object2) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() > 0) {
            Nmyswv.addView((View)object, (ViewGroup.LayoutParams)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe99\u0639\u0641\ufed9(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() >= 0) return null;
        return ((RT)object).tF;
    }

    public static int \ufe9d\ufee1\ufeab\ufe8e(Object object) {
        return object.hashCode();
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Cloud_baidu \ufeab\u0644\ufead\ufeaf(Object object) {
        void var0_2;
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() <= 0) return var0_2;
        Cloud_baidu cloud_baidu = ((Pan)((Object)object)).tF;
        return var0_2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static qD \ufeaf\u062c\u0643\ufec5(Object object) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() < 0) return null;
        return qD.i((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufebd\u062f\ufea9\ufe9d(Object object) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() > 0) return null;
        return M4.tF((File)object);
    }

    public static void \ufec5\u0627\u0644\u0628(Object object, Object object2) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() < 0) {
            ((tX)object).b((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec9\ufea1\ufeb5\u0643(Object object, Object object2) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() > 0) return null;
        return ((ew_0)object).i((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object[] \ufecd\u0627\ufeb5\u062c(Object objectArray) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() > 0) return null;
        return ((y5)objectArray).i();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufed5\u0644\ufea9\u0635(String object) {
        int n = 0;
        String string = "";
        String string2 = "";
        int n2 = 0;
        while (true) {
            if (n2 >= 15) break;
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
        n2 = ((Object)object).length;
        int n3 = string2.length();
        while (true) {
            if (n2 <= 0) break;
            object[-1] = (byte)(object[-1] ^ string2.charAt(-1 % n3));
        }
        n2 = n;
        while (n2 < ((Object)object).length) {
            n2 = "".length() + 1;
        }
        return new String((byte[])object);
    }

    public static void \ufedd\ufeab\u0638\ufec5(Object object, Object object2) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() <= 0) {
            ((H7)object).H((String)object2);
        }
    }
}

