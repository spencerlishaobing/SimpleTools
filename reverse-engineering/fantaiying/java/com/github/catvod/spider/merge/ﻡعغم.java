/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.DialogInterface$OnClickListener
 *  android.util.Base64
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package com.github.catvod.spider.merge;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Base64;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Cloud_baidu;
import com.github.catvod.spider.KkSs;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.ID;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.aj_0;
import com.github.catvod.spider.merge.ak;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.hm;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.qD;
import com.github.catvod.spider.merge.qq_0;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.y7;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;

public class \ufee1\u0639\u063a\u0645 {
    public static int \ufea1\ufec1\ufeaf\u062f = 464;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0627\u062e\ufea1\ufee1(Object object, Object object2) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() >= 0) return false;
        return ((List)object).addAll((Collection)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062b\u064a\u0639\u0640(Object object, Object object2) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() >= 0) return null;
        return ((kb_0)object).yq((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062c\ufe8e\u063a\u062e() {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return null;
        return "https://openapi.baidu.com/oauth/2.0/token?grant_type=refresh_token&refresh_token=";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static qq_0 \u062d\u0642\u0632\ufe8f(Object object) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() < 0) return null;
        return ((qq_0)object).tF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062d\ufead\u0644\ufec5() {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() < 0) return null;
        return Pan.g9;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static AlertDialog.Builder \u062d\ufee9\u0647\u0640(Object object, Object object2, Object object3) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() <= 0) return null;
        return ((AlertDialog.Builder)object).setNegativeButton((CharSequence)object2, (DialogInterface.OnClickListener)object3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u062f\ufea9\u0635\u0646(String object) {
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
    public static String \u0630\ufea5\u0646\u062e() {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() < 0) return null;
        return Tq.i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0632\ufeaf\ufec1\u0647(Object object) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() >= 0) return null;
        return ((ak)object).N();
    }

    public static void \u0633\u062b\ufe9d\u0648(Object object) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() >= 0) {
            ((i3)object).ue();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Future \u0635\u0641\ufee1\u062b(Object future) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() > 0) return null;
        return ((ExecutorCompletionService)((Object)future)).take();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0637\u0638\ufed5\ufe99(Object object, int n2) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() >= 0) return null;
        return Base64.encodeToString((byte[])((byte[])object), (int)n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0638\u0647\ufeed\ufed5(Object object, Object object2, Object object3, Object object4) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() <= 0) return null;
        return w2.G4((String)object, (Map)object2, (Map)object3, (String)object4);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0638\ufeb1\ufebd\ufea5(Object object, Object object2, Object object3, int n2) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() > 0) return null;
        return w2.ee((String)object, (Map)object2, (String)object3, n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u063a\u0636\ufeb9\u062d() {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() < 0) return null;
        return "->->";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File \u063a\ufec1\u0628\ufee9(Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() <= 0) return null;
        return ((i3)object).un();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] \u0640\ufea9\ufea5\u0636(Object object) {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() < 0) return null;
        return ME.v((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0641\ufea1\u0631\u062d(char c) {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() <= 0) return null;
        return String.valueOf(c);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0644\ufe8f\u0628\u062a(Object object) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() > 0) return null;
        return ((H7)object).g9();
    }

    public static int \u0645\u0631\ufea1\ufeaf(Object object) {
        return object.hashCode();
    }

    public static void \u0646\u0645\ufef1\ufeaf(Object object, Object object2, Object object3, Object object4) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() > 0) {
            ((KkSs)((Object)object)).requestWebsites((String[])object2, (List)object3, (String)object4);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0646\ufea1\u0639\ufebd(Object object) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() < 0) return null;
        return ((ak)object).i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u064a\u062b\u0635\ufe9d(Object object) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() < 0) return null;
        return ((hm)object).Gc();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static hN \u064a\ufe99\u0640\ufeb9(Object object) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() < 0) return null;
        return ((kb_0)object).zH();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u064a\ufead\u0633\u0644(Object object, Object object2) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() > 0) return false;
        return ((List)object).contains(object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufe8e\u0633\u062d\ufeaf(Object object) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() < 0) return false;
        return ((y7)object).zH();
    }

    public static String \ufe8f\u0635\u062e\ufee1(short[] sArray, int n2, int n3, int n4) {
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
    public static HashMap \ufe8f\ufed9\u0636\ufec5(Object hashMap) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() < 0) return null;
        return ME.SN((String)((Object)hashMap));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeab\u0631\u0635\u0640() {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() < 0) return null;
        return "{";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeb1\ufec1\u062e\ufedd(Object object) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() > 0) return null;
        return ((qD)object).zH();
    }

    public static void \ufeb5\u0632\u0644\u0642(Object object, Object object2) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() <= 0) {
            ((WebView)object).setWebViewClient((WebViewClient)object2);
        }
    }

    public static void \ufeb5\u0643\u0640\ufec5(Object object, Object object2) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() > 0) {
            ((Cloud_baidu)((Object)object)).setFlag((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufebd\u0648\ufed9\ufe8e(Object object, Object object2) {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() > 0) return null;
        return URLDecoder.decode((String)object, (String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufed9\u0642\u0637\ufeb1() {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return null;
        return ProxyOrigin.getFileUrl();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufedd\u0647\u0633\u0634(Object object) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() <= 0) return null;
        return ((ID)object).tF();
    }

    public static int \ufee1\u0628\u062f\u0632() {
        return 0xFFFFFF87 ^ \u0631\u0640\ufec1\ufee9.\u0644\u0630\ufeb1\ufead;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufee1\ufef1\u0640\u0637(Object list) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() < 0) return null;
        return ((aj_0)((Object)list)).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufee9\u0643\ufeab\ufec1(Object list, Object object) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() > 0) return null;
        return ((N0)((Object)list)).i3((tX)object);
    }

    public static void \ufef1\u062c\u0638\u062f(Object object, Object object2) {
        if (\ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f() >= 0) {
            ((PrintStream)object).println((String)object2);
        }
    }
}

