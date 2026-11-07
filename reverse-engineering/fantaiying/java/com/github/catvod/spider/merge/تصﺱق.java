/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.DialogInterface$OnClickListener
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.Jr;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.YJ;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.y7;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import javax.crypto.Mac;
import org.json.JSONObject;

public class \u062a\u0635\ufeb1\u0642 {
    public static int \ufebd\ufea1\u0631\ufea5 = -556;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0628\ufe99\u0634\u062b(Object object, Object object2) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() < 0) return 0;
        return ((String)object).lastIndexOf((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ApplicationInfo \u062f\u0643\u062d\ufeab(Object object, Object object2, int n2) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() >= 0) return null;
        return ((PackageManager)object).getApplicationInfo((String)object2, n2);
    }

    public static String \u0637\u0636\u062a\ufedd(short[] sArray, int n2, int n3, int n4) {
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
    public static String \u0638\ufe8e\u0627\u0634(Object object) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() >= 0) return null;
        return ((Uri)object).toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0643\u0638\u0646\ufea5(Object object) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() > 0) return null;
        return ((y7)object).N();
    }

    public static int \u0644\u0639\ufecd\ufee9(Object object) {
        return object.hashCode();
    }

    public static void \u0646\u0627\u062a\u062d(Object object, Object object2) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() > 0) {
            ((Mac)object).init((Key)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Uri.Builder \u064a\u0628\u0635\ufe8e(Object object, Object object2) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() <= 0) return null;
        return ((Uri.Builder)object).encodedAuthority((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8f\u062a\ufed5\ufeaf(Object object) {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() > 0) return null;
        return ((String)object).toUpperCase();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8f\u062f\u062a\ufe8e(Object object) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() < 0) return null;
        return ((Jr)object).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufe8f\u0637\u0642\u062e(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() >= 0) return false;
        return (Boolean)object;
    }

    public static int \ufe8f\ufec5\ufe95\u063a() {
        return 0x2D3 ^ \u0641\ufeb5\ufeb1\ufee1.\u0646\u0633\u0647\u062b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static AlertDialog.Builder \ufe9d\u062c\ufead\ufe8f(Object object, Object object2, Object object3) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() <= 0) return null;
        return ((AlertDialog.Builder)object).setPositiveButton((CharSequence)object2, (DialogInterface.OnClickListener)object3);
    }

    public static void \ufe9d\u0634\u0640\u0635(Object object, Object object2) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() <= 0) {
            ((dl_0)object).O((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static TimeZone \ufeb9\ufec1\ufead\ufe95(Object object) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() >= 0) return null;
        return TimeZone.getTimeZone((String)object);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufebd\u0635\u0628\ufee1(String object) {
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
        n3 = ((Object)object).length;
        int n4 = string2.length();
        while (true) {
            if (n3 <= 0) break;
            object[-1] = (byte)(object[-1] ^ string2.charAt(-1 % n4));
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
    public static AlertDialog \ufec5\ufeaf\ufead\u0648(Object object) {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() > 0) return null;
        return ((AlertDialog.Builder)object).show();
    }

    public static void \ufec5\ufecd\u0644\ufe95(Object object) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() < 0) {
            YJ.SN((List)object);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufec9\ufeb9\u0642\u063a(Object list) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() < 0) return null;
        return ((ExecutorService)((Object)list)).shutdownNow();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufed5\u0630\u0647\ufec9(Object object, Object object2) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() > 0) return null;
        return Tq.OW((List)object, (JSONObject)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static StringBuilder \ufedd\u062d\ufe9d\ufed5(Object object, Object object2) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() > 0) return null;
        return ((StringBuilder)object).append((CharSequence)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufedd\ufeb5\ufead\u0627(Object object, Object object2, Object object3) {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() <= 0) return null;
        return ((xu_0)object).H((String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee1\u0639\u063a\u0645() {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() > 0) return null;
        return "0";
    }
}

