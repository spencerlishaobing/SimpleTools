/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface$OnDismissListener
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.OW;
import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.aj_0;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.nb_0;
import com.github.catvod.spider.merge.rq_1;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.zip.Inflater;
import org.json.JSONObject;

public class \u062b\ufec1\ufeb1\u062d {
    public static int \ufeb9\u0641\u062c\ufebd = -278;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0627\u062d\u0639\ufec9(Object object) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() >= 0) return false;
        return ((Inflater)object).finished();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0628\ufeed\ufea5\u0636(Object object, Object object2) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() >= 0) return null;
        return TextUtils.join((CharSequence)((CharSequence)object), (Iterable)((Iterable)object2));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static OW \u062a\ufe8f\ufeed\ufee1() {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() > 0) return null;
        return OW.yq;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static nb_0 \u062c\u0632\ufebd\u063a(Object object) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() < 0) return null;
        return ((j_0)object).Gc;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Iterator \u062d\ufec5\ufed9\u0634(Object object) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return null;
        return ((JSONObject)object).keys();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \u0632\ufeab\u0645\u063a(Object list) {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() <= 0) return null;
        return ((aj_0)((Object)list)).tF();
    }

    public static String \u0637\u0647\u0635\u0630(short[] sArray, int n2, int n3, int n4) {
        char[] cArray = new char[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            cArray[i2] = (char)(sArray[n2 + i2] ^ n4);
        }
        return new String(cArray);
    }

    public static int \u0638\u0628\ufea5\u064a(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0639\u0647\ufebd\u0633(Object object, Object object2) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() <= 0) return false;
        return ((Pan)((Object)object)).isBd((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0640\ufe99\ufedd\u062a() {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return "\u5206\u4eab\u7684stoken\u8fc7\u671f";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0643\u062a\ufe9d\u0638(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() >= 0) return null;
        return ((H7)object).Nl();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Uri \u0645\ufef1\u062d\ufee9(Object object) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() <= 0) return null;
        return Uri.parse((String)((String)object));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \u0648\ufed9\ufeaf\ufead(Object object) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return null;
        return ((Future)object).get();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Uri \ufe8e\ufec5\u062a\u0637(Object object) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() < 0) return null;
        return ((Uri.Builder)object).build();
    }

    public static int \ufe8f\ufe9d\u0628\ufe99() {
        return 0x227 ^ \u0641\ufeb5\ufeb1\ufee1.\u0646\u0633\u0647\u062b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static rq_1 \ufe8f\ufecd\ufe8e\u0627() {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() > 0) return null;
        return rq_1.yq;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static StringBuilder \ufe95\ufeaf\ufedd\u0644(Object object, Object object2, int n2, int n3) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() > 0) return null;
        return ((StringBuilder)object).append((CharSequence)object2, n2, n3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe99\ufeb5\ufead\u0637(Object object, Object object2, Object object3) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() > 0) return null;
        return Z.SN((String)object, (String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufea9\u0628\u0637\ufe95(Object object, Object object2) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return false;
        return ((String)object).equals(object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte \ufead\u062b\ufeb1\u0644(Object object) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() >= 0) return 0;
        return (Byte)object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufeb9\u0631\ufed9\ufed5(Object object) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() > 0) return 0;
        return ((JSONObject)object).length();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufec1\u062d\ufebd\ufec9(Object list) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() <= 0) return null;
        return w2.i((Map)((Object)list));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static URI \ufec1\u062e\ufea1\ufec9(Object object) {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() <= 0) return null;
        return URI.create((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec5\ufee9\ufed5\u0646() {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return null;
        return "__pus";
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufec9\u062e\u0635\ufe8e(String object) {
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
        n3 = string2.length();
        while (true) {
            if (n4 <= 0) break;
            object[-1] = (byte)(object[-1] ^ string2.charAt(-1 % n3));
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
    public static String \ufec9\u0640\u0646\u0644() {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() <= 0) return null;
        return "http";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufed5\u0644\u0642\u0638(Object object, int n2) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() < 0) return null;
        return ((ArrayList)object).get(n2);
    }

    public static void \ufef1\u0636\u062c\u0634(Object object, Object object2) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() >= 0) {
            ((Dialog)object).setOnDismissListener((DialogInterface.OnDismissListener)object2);
        }
    }

    public static void \ufef1\ufeb1\ufe95\u0628() {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() >= 0) {
            ProxyOrigin.getan();
        }
    }
}

