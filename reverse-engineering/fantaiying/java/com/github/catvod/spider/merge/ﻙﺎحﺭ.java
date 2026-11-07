/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.app.Dialog;
import android.widget.ImageView;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.MI;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.nb_0;
import com.github.catvod.spider.merge.oE;
import com.github.catvod.spider.merge.qq_0;
import com.github.catvod.spider.merge.rs_1;
import com.github.catvod.spider.merge.x5;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class \ufed9\ufe8e\u062d\ufead {
    public static int \u0635\u0638\u0646\ufea1 = -570;

    public static void \u062b\ufe8e\u062d\u0645(Object object) {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() > 0) {
            ((Throwable)object).printStackTrace();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062d\ufee1\u064a\ufecd(Object object, Object object2, Object object3) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() > 0) return null;
        return Tq.Nl((List)object, (List)object2, (JSONObject)object3);
    }

    public static String \u062f\ufef1\u0636\u0644(short[] sArray, int n2, int n3, int n4) {
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
    public static String \u0631\u0627\u0636\ufe95() {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return null;
        return "title";
    }

    public static void \u0633\u0643\u0630\ufebd(Object object) {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() > 0) {
            ((Dialog)object).dismiss();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \u0636\u062c\ufec9\ufe95(Object hashMap) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() < 0) return null;
        return ((i3)((Object)hashMap)).C7();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static StringBuilder \u0638\u0642\ufe99\ufea1(Object object, boolean bl) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return null;
        return ((StringBuilder)object).append(bl);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File \u0644\ufee1\u0630\u0646(Object object) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() > 0) return null;
        return ((j_0)object).Dr();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0645\ufeb5\ufeb9\ufedd(Object object, boolean bl, boolean bl2) {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() <= 0) return false;
        return ((j_0)object).i3(bl, bl2);
    }

    public static void \u0646\u062d\ufebd\u062c(Object object) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() <= 0) {
            oE.SN((List)object);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \u0646\u0635\ufe99\u0630(Object hashMap) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() < 0) return null;
        return ((N0)((Object)hashMap)).U();
    }

    public static void \u0647\u0639\u062e\u0648(Object object) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() <= 0) {
            rs_1.Nl((String)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0647\u0642\u0627\u0641(String object) {
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
    public static qq_0 \u0648\u0630\u0634\ufebd(Object object, Object object2) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() > 0) return null;
        return ((qq_0)object).zH((String)object2);
    }

    public static int \ufe8e\ufec1\u0641\u0644() {
        return 0x2E7 ^ \ufecd\u0642\u062e\ufe9d.\ufeed\u062e\ufeb9\ufec9;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe95\ufea9\u0630\u062a() {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() >= 0) return null;
        return "\u4f18\u6c50";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe99\ufeed\ufea5\u0635() {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() < 0) return null;
        return "\"status\":401";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static x5 \ufeaf\u0630\u0647\ufeb9(Object object) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() <= 0) return null;
        return ((x5)object).i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] \ufeaf\u0630\ufedd\ufeb1(Object object) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() >= 0) return null;
        return ME.un((byte[])object);
    }

    public static void \ufeb9\ufed9\u062b\u0631(Object object, Object object2) {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() < 0) {
            ((ImageView)object).setScaleType((ImageView.ScaleType)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufebd\ufea9\u0636\u0630(Object object) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return null;
        return ((MI)object).SN();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec1\u0637\ufe95\u0634() {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() < 0) return null;
        return "\\*\\*\\*";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec5\ufeb5\u0637\ufe95(Object object) {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() <= 0) return null;
        return ((nb_0)object).zH();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Comparator \ufecd\u0631\ufeab\ufedd() {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() > 0) return null;
        return String.CASE_INSENSITIVE_ORDER;
    }

    public static void \ufecd\u0639\u0644\ufed5(Object object) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() <= 0) {
            ((xu_0)object).p();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufedd\u062e\ufea5\u063a(Object object, Object object2, Object object3) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() >= 0) return null;
        return ((xu_0)object).Gd((String)object2, (HashMap)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufedd\u063a\u0639\ufeb1(Object object) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() >= 0) return null;
        return ((H7)object).zH();
    }

    public static int \ufeed\u062e\u0631\u0645(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufeed\u0643\ufecd\u062d(Object object) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() >= 0) return null;
        return ((Map.Entry)object).getValue();
    }

    public static void \ufef1\ufe8f\ufec9\ufea5(Object object, int n2, Object object2) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() <= 0) {
            ((List)object).add(n2, object2);
        }
    }
}

