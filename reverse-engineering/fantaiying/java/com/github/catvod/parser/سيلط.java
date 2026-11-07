/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.DialogInterface$OnClickListener
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 */
package com.github.catvod.parser;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.M4;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.crypto.Cipher;

public class \u0633\u064a\u0644\u0637 {
    public static int \ufea5\u0640\ufe8e\u0627 = 429;

    public static void \u062c\ufe9d\u0632\ufeab(Object object, Object object2) {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() >= 0) {
            M4.i((File)object, (String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062e\ufeb9\ufea9\u0628(Object object) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() <= 0) return null;
        return ((dl_0)object).i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object[] \u0630\u0644\u0628\u0637(Object objectArray, Object object) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() <= 0) return null;
        return ((N0)objectArray).z((HashMap)object);
    }

    public static void \u0634\ufeb1\ufecd\u0648(Object object, Object object2, Object object3) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() <= 0) {
            ((ViewGroup)object).addView((View)object2, (ViewGroup.LayoutParams)object3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static UUID \u0635\ufed9\u0636\ufec9() {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() >= 0) return null;
        return UUID.randomUUID();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0635\ufee9\u0646\u064a(Object object) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() >= 0) return null;
        return ((tX)object).B();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static kb_0 \u0636\ufead\u062c\u0630(Object object, Object object2) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return ((hN)object).cS((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Cipher \u0638\ufec9\ufebd\u0645(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() >= 0) return null;
        return Cipher.getInstance((String)object);
    }

    public static void \u0639\ufeaf\ufec9\u0632(Object object, Object object2) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() > 0) {
            ((Ef)object).dT((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0640\ufea9\ufea5\u0636(Object object) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() >= 0) return null;
        return ((URL)object).getProtocol();
    }

    public static void \u0641\u0634\u0647\u0636(Object object, Object object2) {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() <= 0) {
            ((dl_0)object).s((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0646\u062b\u0631\ufeed(Object object, Object object2) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() < 0) return false;
        return Objects.equals(object, object2);
    }

    public static void \u064a\u062f\ufeb5\ufeaf(Object object, Object object2, Object object3) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() >= 0) {
            ((Pan.KeyValueData)object).put((String)object2, (String)object3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufe8f\ufea1\ufea9\u062a(Object list) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() < 0) return null;
        return ((dl_0)((Object)list)).t0();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe95\u062e\ufe8e\ufe99(int n) {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() >= 0) return null;
        return ME.G4(n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeab\ufee1\u0633\u0646() {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return null;
        return "#";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static AlertDialog.Builder \ufead\ufe9d\u0641\ufee9(Object object, Object object2, Object object3) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() > 0) return null;
        return ((AlertDialog.Builder)object).setNeutralButton((CharSequence)object2, (DialogInterface.OnClickListener)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File \ufeb5\u0634\u0640\ufea1(Object object) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() >= 0) return null;
        return ((j_0)object).O();
    }

    public static void \ufeb9\ufea9\u062d\ufebd(Object object, Object object2) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() < 0) {
            ((WebView)object).loadUrl((String)object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufebd\u062e\ufef1\u064a(String object) {
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
        int n3 = ((Object)object).length;
        n2 = string2.length();
        while (true) {
            if (n3 <= 0) break;
            object[-1] = (byte)(object[-1] ^ string2.charAt(-1 % n2));
        }
        n2 = n;
        while (n2 < ((Object)object).length) {
            n2 = "".length() + 1;
        }
        return new String((byte[])object);
    }

    public static int \ufec1\u062e\u0643\ufedd() {
        return 0x3A3 ^ \ufeb1\ufe8e\ufee1\ufe9d.\ufead\u0630\ufed9\ufeb5;
    }

    public static int \ufec1\u0631\u0633\ufec9(Object object) {
        return object.hashCode();
    }

    public static String \ufec9\ufeed\ufeb5\u0640(short[] sArray, int n, int n2, int n3) {
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
    public static String \ufed5\ufea1\u0641\u0648() {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() < 0) return null;
        return "Referer";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeed\u0648\ufea1\u0645(Object object, Object object2, Object object3) {
        if (\u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a() >= 0) return null;
        return ((String)object).replaceFirst((String)object2, (String)object3);
    }
}

