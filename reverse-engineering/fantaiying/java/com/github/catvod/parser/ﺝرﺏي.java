/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Build
 *  android.webkit.WebSettings
 */
package com.github.catvod.parser;

import android.net.Uri;
import android.os.Build;
import android.webkit.WebSettings;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.WoGG;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.V;
import com.github.catvod.spider.merge.VV;
import com.github.catvod.spider.merge.db_0;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.nb_0;
import com.github.catvod.spider.merge.qD;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.y7;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class \ufe9d\u0631\ufe8f\u064a {
    public static int \ufeab\u0634\ufeed\ufeb5 = -165;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062d\u062e\u0632\ufec1(Object object) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() < 0) return null;
        return ((Uri)object).getHost();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062e\ufee1\ufecd\ufee9(Object object) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return null;
        return ((dl_0)object).Gd();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0630\u064a\ufea9\u062e() {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() >= 0) return null;
        return "https://pc-api.uc.cn/1/clouddrive/file/move?pr=UCBrowser&fr=pc&uc_param_str=";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0631\u0639\u0637\u0634(Object object) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() > 0) return null;
        return VV.yq((Class)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0632\u0641\ufedd\ufed9() {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() >= 0) return null;
        return Build.HARDWARE;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0633\u0643\u0630\ufebd(int n) {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() < 0) return 0;
        return Math.abs(n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0634\ufead\ufeab\u062c(Object object) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() <= 0) return null;
        return ((y7)object).SN();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0635\u0633\ufebd\u0638(String object) {
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
        while (true) {
            if (((String)object).length() <= 0) break;
            byteArrayOutputStream.write(string.indexOf(((String)object).charAt(-2)) << 4 | string.indexOf(((String)object).charAt(-1)));
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
    public static String \u0636\ufec1\u0632\u0627(Object object) {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() > 0) return null;
        return ((nb_0)object).Gc();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \u0637\u0633\ufeb1\u063a(Object object, Object object2, Object object3, Object object4) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() < 0) return null;
        return V.tF((String)object, (String)object2, (String)object3, (String)object4);
    }

    public static int \u0638\ufea5\ufea9\ufee9(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0645\u064a\ufeaf\u0633(Object object, Object object2) {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() >= 0) return false;
        return ((Pan.KeyValueData)object).containsKey((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0648\ufee1\u0640\ufec9() {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() <= 0) return null;
        return "$$$";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea1\ufead\ufebd\u0639(Object object, Object object2, boolean bl) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() < 0) return null;
        return ((j_0)object).dT((n6)object2, bl);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufea9\u0633\u0640\u062a(Object object, Object object2) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() < 0) return false;
        return ((ArrayList)object).addAll((Collection)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ClassLoader \ufeab\u0647\ufee1\ufeaf(Object object) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() >= 0) return null;
        return ((Thread)object).getContextClassLoader();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeaf\ufeb5\u062a\ufedd() {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() > 0) return null;
        return "\u6a21\u5f0f";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static qD \ufeb1\ufee1\u0645\u0638(Object object) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() <= 0) return null;
        return ((qD)object).yq();
    }

    public static String \ufeb5\u0633\ufea5\ufecd(short[] sArray, int n, int n2, int n3) {
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
    public static Class \ufeb5\u0640\ufec9\ufec5(Object clazz) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() <= 0) return null;
        return Class.forName((String)((Object)clazz));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Ef \ufeb9\ufead\u064a\u0636(Object object, Object object2, Object object3, Object object4) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() <= 0) return null;
        return ((tX)object).Gd((String)object2, (String)object3, (String)object4);
    }

    public static int \ufebd\u0643\ufe9d\u062c() {
        return 0x344 ^ \u0644\ufe8f\u0628\u062a.\ufead\ufeb9\ufec1\ufedd;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufebd\u064a\ufed5\ufe8f(Object list) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() <= 0) return null;
        return db_0.N((String)((Object)list));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufecd\u0643\ufea5\u0640(Object object, Object object2) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() < 0) return null;
        return ((WoGG)((Object)object)).getPic((String)object2);
    }

    public static void \ufee1\u062a\u062d\u0644(Object object, boolean bl) {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() < 0) {
            ((WebSettings)object).setDatabaseEnabled(bl);
        }
    }
}

