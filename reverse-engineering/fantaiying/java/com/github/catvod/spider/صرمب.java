/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Handler
 *  android.util.Base64
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.util.Base64;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Tingshu275;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.LP;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.QB;
import com.github.catvod.spider.merge.TO;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.X0;
import com.github.catvod.spider.merge.Yx;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.qq_0;
import com.github.catvod.spider.merge.t_0;
import com.github.catvod.spider.merge.xv;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.util.List;
import javax.crypto.Cipher;
import org.json.JSONObject;

public class \u0635\u0631\u0645\u0628 {
    public static int \u0633\u062f\ufeab\ufec5 = 67;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u062b\ufebd\u0635\u0637(Object object, Object object2) {
        if (\ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9() < 0) return 0;
        return Nh.t0((String)object, (String)object2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u062e\u0635\u062a\ufe95(String string) {
        int n2 = 0;
        Object object = "";
        String string2 = "";
        int n3 = 0;
        while (true) {
            if (n3 >= 15) break;
            object = new StringBuffer().append((String)object).append(Integer.toHexString(n3)).toString();
            string2 = new StringBuffer().append(string2).append((int)(Math.random() * (double)10) ^ n3).toString();
            ++n3;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(string.length() / 2);
        n3 = 0;
        while (true) {
            if (n3 >= string.length()) break;
            byteArrayOutputStream.write(((String)object).indexOf(string.charAt(n3)) << 4 | ((String)object).indexOf(string.charAt(n3 + 1)));
            n3 += 2;
        }
        object = byteArrayOutputStream.toByteArray();
        string = "a";
        while (true) {
            if (string.length() <= 0) break;
            string = "";
            if ("".length() != 0) continue;
            string = "a";
        }
        int n4 = string.length();
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
    public static AlertDialog.Builder \u0630\u0648\u062e\u0638(Object object, int n2, Object object2) {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() >= 0) return null;
        return ((AlertDialog.Builder)object).setPositiveButton(n2, (DialogInterface.OnClickListener)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long \u0630\ufef1\ufed5\ufeb9(Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return 0L;
        return ((Yx)object).SN();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Va \u0631\u063a\u0645\u0641(Object object) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() < 0) return null;
        return xv.tF((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0632\u062d\u0636\u0645(Object object, char c, char c2) {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() <= 0) return null;
        return ((String)object).replace(c, c2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0634\u062d\u0637\ufeb5() {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() < 0) return null;
        return "Range";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0635\u0643\u0641\u0628(Object object, Object object2, Object object3) {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() > 0) return null;
        return ((Tingshu275)((Object)object)).searchContent((String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static PublicKey \u063a\ufeed\u0645\u062a(Object object, Object object2) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() < 0) return null;
        return ((KeyFactory)object).generatePublic((KeySpec)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Uri.Builder \u0641\ufea5\ufeb9\u0647(Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() <= 0) return null;
        return ((Uri)object).buildUpon();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static char \u0643\u0637\ufeb1\ufead(Object object, int n2) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() > 0) return '\u0000';
        return ((String)object).charAt(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0644\ufeb9\u0630\u0628(Object object) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() >= 0) return false;
        return ((X0)object).t0();
    }

    public static String \u0646\u0627\u062a\u062d(short[] sArray, int n2, int n3, int n4) {
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
    public static JSONObject \u0647\u0643\ufedd\ufebd(Object object, Object object2, long l) {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() < 0) return null;
        return ((JSONObject)object).put((String)object2, l);
    }

    public static int \u064a\u062c\ufea5\u0634() {
        return 0xFFFFFED6 ^ \u062a\ufee1\ufe8e\ufeb9.\u0642\ufed5\u064a\ufecd;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u064a\u062c\ufeed\u062e(Object object) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() > 0) return false;
        return ME.ee((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Ef \u064a\ufea5\u0634\ufe9d(Object object, Object object2, Object object3, Object object4) {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() < 0) return null;
        return ((H7)object).Gd((String)object2, (String)object3, (String)object4);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufe8e\u064a\ufee9\ufe99(Object object, Object object2) {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() <= 0) return false;
        return ((Handler)object).post((Runnable)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8f\u0641\ufeed\u062b() {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() > 0) return null;
        return "\u9ed8\u8ba4";
    }

    public static int \ufe95\u0627\ufea9\ufed9(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Bitmap \ufe99\ufed5\u0637\ufeed(Object object, int n2, int n3) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() > 0) return null;
        return BitmapFactory.decodeByteArray((byte[])((byte[])object), (int)n2, (int)n3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea1\ufeaf\ufe8f\ufeb9() {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() < 0) return null;
        return "uc_fid";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea5\ufeed\u0646\u0634(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() > 0) return null;
        return ((LP)object).N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeab\u0638\ufee1\ufe9d(Object object) {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() >= 0) return null;
        return ((LP)object).G();
    }

    public static void \ufeab\ufe8f\u0646\u0639(Object object, int n2, Object object2) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() < 0) {
            ((Cipher)object).init(n2, (Key)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufead\ufe8f\ufedd\ufea9() {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return null;
        return "list";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufead\ufee9\u0643\u0632(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() > 0) return false;
        return TO.zH((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeaf\ufe8f\u0647\ufeb5(Object object) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() > 0) return null;
        return ((n6)object).Gc();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] \ufeb5\ufe99\u0635\ufead(Object object, int n2) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() <= 0) return null;
        return Base64.encode((byte[])((byte[])object), (int)n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufebd\u062a\ufef1\ufe95() {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() < 0) return null;
        return "{\"1\":[{\"key\":\"3\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u559c\u5267\",\"v\":\"\u559c\u5267\"},{\"n\":\"\u7231\u60c5\",\"v\":\"\u7231\u60c5\"},{\"n\":\"\u6050\u6016\",\"v\":\"\u6050\u6016\"},{\"n\":\"\u52a8\u4f5c\",\"v\":\"\u52a8\u4f5c\"},{\"n\":\"\u79d1\u5e7b\",\"v\":\"\u79d1\u5e7b\"},{\"n\":\"\u5267\u60c5\",\"v\":\"\u5267\u60c5\"},{\"n\":\"\u6218\u4e89\",\"v\":\"\u6218\u4e89\"},{\"n\":\"\u8b66\u532a\",\"v\":\"\u8b66\u532a\"},{\"n\":\"\u72af\u7f6a\",\"v\":\"\u72af\u7f6a\"},{\"n\":\"\u52a8\u753b\",\"v\":\"\u52a8\u753b\"},{\"n\":\"\u5947\u5e7b\",\"v\":\"\u5947\u5e7b\"},{\"n\":\"\u6b66\u4fa0\",\"v\":\"\u6b66\u4fa0\"},{\"n\":\"\u5192\u9669\",\"v\":\"\u5192\u9669\"},{\"n\":\"\u67aa\u6218\",\"v\":\"\u67aa\u6218\"},{\"n\":\"\u6050\u6016\",\"v\":\"\u6050\u6016\"},{\"n\":\"\u60ac\u7591\",\"v\":\"\u60ac\u7591\"},{\"n\":\"\u60ca\u609a\",\"v\":\"\u60ca\u609a\"},{\"n\":\"\u7ecf\u5178\",\"v\":\"\u7ecf\u5178\"},{\"n\":\"\u9752\u6625\",\"v\":\"\u9752\u6625\"},{\"n\":\"\u6587\u827a\",\"v\":\"\u6587\u827a\"},{\"n\":\"\u5fae\u7535\u5f71\",\"v\":\"\u5fae\u7535\u5f71\"},{\"n\":\"\u53e4\u88c5\",\"v\":\"\u53e4\u88c5\"},{\"n\":\"\u5386\u53f2\",\"v\":\"\u5386\u53f2\"},{\"n\":\"\u8fd0\u52a8\",\"v\":\"\u8fd0\u52a8\"},{\"n\":\"\u519c\u6751\",\"v\":\"\u519c\u6751\"},{\"n\":\"\u513f\u7ae5\",\"v\":\"\u513f\u7ae5\"}]},{\"key\":\"1\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u4e2d\u56fd\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u4e2d\u56fd\u9999\u6e2f\",\"v\":\"\u4e2d\u56fd\u9999\u6e2f\"},{\"n\":\"\u4e2d\u56fd\u53f0\u6e7e\",\"v\":\"\u4e2d\u56fd\u53f0\u6e7e\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u5fb7\u56fd\",\"v\":\"\u5fb7\u56fd\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u610f\u5927\u5229\",\"v\":\"\u610f\u5927\u5229\"},{\"n\":\"\u897f\u73ed\u7259\",\"v\":\"\u897f\u73ed\u7259\"},{\"n\":\"\u52a0\u62ff\u5927\",\"v\":\"\u52a0\u62ff\u5927\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"key\":\"11\",\"name\":\"\u5e74\u4efd\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"},{\"n\":\"2009\",\"v\":\"2009\"},{\"n\":\"2008\",\"v\":\"2008\"},{\"n\":\"2007\",\"v\":\"2007\"},{\"n\":\"2006\",\"v\":\"2006\"},{\"n\":\"2005\",\"v\":\"2005\"},{\"n\":\"2004\",\"v\":\"2004\"},{\"n\":\"2003\",\"v\":\"2003\"},{\"n\":\"2002\",\"v\":\"2002\"},{\"n\":\"2001\",\"v\":\"2001\"},{\"n\":\"2000\",\"v\":\"2000\"}]},{\"key\":\"4\",\"name\":\"\u8bed\u8a00\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u82f1\u8bed\",\"v\":\"\u82f1\u8bed\"},{\"n\":\"\u97e9\u8bed\",\"v\":\"\u97e9\u8bed\"},{\"n\":\"\u65e5\u8bed\",\"v\":\"\u65e5\u8bed\"},{\"n\":\"\u6cd5\u8bed\",\"v\":\"\u6cd5\u8bed\"},{\"n\":\"\u6cf0\u8bed\",\"v\":\"\u6cf0\u8bed\"},{\"n\":\"\u5fb7\u8bed\",\"v\":\"\u5fb7\u8bed\"},{\"n\":\"\u5370\u5ea6\u8bed\",\"v\":\"\u5370\u5ea6\u8bed\"},{\"n\":\"\u56fd\u8bed\",\"v\":\"\u56fd\u8bed\"},{\"n\":\"\u7ca4\u8bed\",\"v\":\"\u7ca4\u8bed\"},{\"n\":\"\u4fc4\u8bed\",\"v\":\"\u4fc4\u8bed\"},{\"n\":\"\u897f\u73ed\u7259\u8bed\",\"v\":\"\u897f\u73ed\u7259\u8bed\"},{\"n\":\"\u610f\u5927\u5229\u8bed\",\"v\":\"\u610f\u5927\u5229\u8bed\"},{\"n\":\"\u5176\u5b83\",\"v\":\"\u5176\u5b83\"}]},{\"key\":\"2\",\"name\":\"\u6392\u5e8f\",\"value\":[{\"n\":\"\u65f6\u95f4\",\"v\":\"time\"},{\"n\":\"\u4eba\u6c14\",\"v\":\"hits\"},{\"n\":\"\u8bc4\u5206\",\"v\":\"score\"}]}],\"2\":[{\"key\":\"3\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u53e4\u88c5\",\"v\":\"\u53e4\u88c5\"},{\"n\":\"\u6218\u4e89\",\"v\":\"\u6218\u4e89\"},{\"n\":\"\u9752\u6625\u5076\u50cf\",\"v\":\"\u9752\u6625\u5076\u50cf\"},{\"n\":\"\u559c\u5267\",\"v\":\"\u559c\u5267\"},{\"n\":\"\u5bb6\u5ead\",\"v\":\"\u5bb6\u5ead\"},{\"n\":\"\u72af\u7f6a\",\"v\":\"\u72af\u7f6a\"},{\"n\":\"\u52a8\u4f5c\",\"v\":\"\u52a8\u4f5c\"},{\"n\":\"\u5947\u5e7b\",\"v\":\"\u5947\u5e7b\"},{\"n\":\"\u5267\u60c5\",\"v\":\"\u5267\u60c5\"},{\"n\":\"\u5386\u53f2\",\"v\":\"\u5386\u53f2\"},{\"n\":\"\u7ecf\u5178\",\"v\":\"\u7ecf\u5178\"},{\"n\":\"\u4e61\u6751\",\"v\":\"\u4e61\u6751\"},{\"n\":\"\u60c5\u666f\",\"v\":\"\u60c5\u666f\"},{\"n\":\"\u5546\u6218\",\"v\":\"\u5546\u6218\"},{\"n\":\"\u7f51\u5267\",\"v\":\"\u7f51\u5267\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"key\":\"1\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u4e2d\u56fd\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u4e2d\u56fd\u53f0\u6e7e\",\"v\":\"\u4e2d\u56fd\u53f0\u6e7e\"},{\"n\":\"\u4e2d\u56fd\u9999\u6e2f\",\"v\":\"\u4e2d\u56fd\u9999\u6e2f\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u65b0\u52a0\u5761\",\"v\":\"\u65b0\u52a0\u5761\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"key\":\"4\",\"name\":\"\u8bed\u8a00\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u82f1\u8bed\",\"v\":\"\u82f1\u8bed\"},{\"n\":\"\u97e9\u8bed\",\"v\":\"\u97e9\u8bed\"},{\"n\":\"\u65e5\u8bed\",\"v\":\"\u65e5\u8bed\"},{\"n\":\"\u6cd5\u8bed\",\"v\":\"\u6cd5\u8bed\"},{\"n\":\"\u6cf0\u8bed\",\"v\":\"\u6cf0\u8bed\"},{\"n\":\"\u5fb7\u8bed\",\"v\":\"\u5fb7\u8bed\"},{\"n\":\"\u5370\u5ea6\u8bed\",\"v\":\"\u5370\u5ea6\u8bed\"},{\"n\":\"\u56fd\u8bed\",\"v\":\"\u56fd\u8bed\"},{\"n\":\"\u7ca4\u8bed\",\"v\":\"\u7ca4\u8bed\"},{\"n\":\"\u4fc4\u8bed\",\"v\":\"\u4fc4\u8bed\"},{\"n\":\"\u897f\u73ed\u7259\u8bed\",\"v\":\"\u897f\u73ed\u7259\u8bed\"},{\"n\":\"\u610f\u5927\u5229\u8bed\",\"v\":\"\u610f\u5927\u5229\u8bed\"},{\"n\":\"\u5176\u5b83\",\"v\":\"\u5176\u5b83\"}]},{\"key\":\"11\",\"name\":\"\u5e74\u4efd\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"},{\"n\":\"2009\",\"v\":\"2009\"},{\"n\":\"2008\",\"v\":\"2008\"},{\"n\":\"2007\",\"v\":\"2007\"},{\"n\":\"2006\",\"v\":\"2006\"},{\"n\":\"2005\",\"v\":\"2005\"},{\"n\":\"2004\",\"v\":\"2004\"},{\"n\":\"2003\",\"v\":\"2003\"},{\"n\":\"2002\",\"v\":\"2002\"},{\"n\":\"2001\",\"v\":\"2001\"},{\"n\":\"2000\",\"v\":\"2000\"}]},{\"key\":\"2\",\"name\":\"\u6392\u5e8f\",\"value\":[{\"n\":\"\u65f6\u95f4\",\"v\":\"time\"},{\"n\":\"\u4eba\u6c14\",\"v\":\"hits\"},{\"n\":\"\u8bc4\u5206\",\"v\":\"score\"}]}],\"4\":[{\"key\":\"3\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u60c5\u611f\",\"v\":\"\u60c5\u611f\"},{\"n\":\"\u79d1\u5e7b\",\"v\":\"\u79d1\u5e7b\"},{\"n\":\"\u70ed\u8840\",\"v\":\"\u70ed\u8840\"},{\"n\":\"\u63a8\u7406\",\"v\":\"\u63a8\u7406\"},{\"n\":\"\u641e\u7b11\",\"v\":\"\u641e\u7b11\"},{\"n\":\"\u5192\u9669\",\"v\":\"\u5192\u9669\"},{\"n\":\"\u841d\u8389\",\"v\":\"\u841d\u8389\"},{\"n\":\"\u6821\u56ed\",\"v\":\"\u6821\u56ed\"},{\"n\":\"\u52a8\u4f5c\",\"v\":\"\u52a8\u4f5c\"},{\"n\":\"\u673a\u6218\",\"v\":\"\u673a\u6218\"},{\"n\":\"\u8fd0\u52a8\",\"v\":\"\u8fd0\u52a8\"},{\"n\":\"\u6218\u4e89\",\"v\":\"\u6218\u4e89\"},{\"n\":\"\u5c11\u5e74\",\"v\":\"\u5c11\u5e74\"},{\"n\":\"\u5c11\u5973\",\"v\":\"\u5c11\u5973\"},{\"n\":\"\u793e\u4f1a\",\"v\":\"\u793e\u4f1a\"},{\"n\":\"\u539f\u521b\",\"v\":\"\u539f\u521b\"},{\"n\":\"\u4eb2\u5b50\",\"v\":\"\u4eb2\u5b50\"},{\"n\":\"\u76ca\u667a\",\"v\":\"\u76ca\u667a\"},{\"n\":\"\u52b1\u5fd7\",\"v\":\"\u52b1\u5fd7\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"key\":\"1\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u4e2d\u56fd\",\"v\":\"\u4e2d\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u6b27\u7f8e\",\"v\":\"\u6b27\u7f8e\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"key\":\"11\",\"name\":\"\u5e74\u4efd\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"},{\"n\":\"2009\",\"v\":\"2009\"},{\"n\":\"2008\",\"v\":\"2008\"},{\"n\":\"2007\",\"v\":\"2007\"},{\"n\":\"2006\",\"v\":\"2006\"},{\"n\":\"2005\",\"v\":\"2005\"},{\"n\":\"2004\",\"v\":\"2004\"},{\"n\":\"2003\",\"v\":\"2003\"},{\"n\":\"2002\",\"v\":\"2002\"},{\"n\":\"2001\",\"v\":\"2001\"},{\"n\":\"2000\",\"v\":\"2000\"}]},{\"key\":\"2\",\"name\":\"\u6392\u5e8f\",\"value\":[{\"n\":\"\u65f6\u95f4\",\"v\":\"time\"},{\"n\":\"\u4eba\u6c14\",\"v\":\"hits\"},{\"n\":\"\u8bc4\u5206\",\"v\":\"score\"}]}],\"15\":[{\"key\":\"3\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u53e4\u88c5\",\"v\":\"\u53e4\u88c5\"},{\"n\":\"\u6218\u4e89\",\"v\":\"\u6218\u4e89\"},{\"n\":\"\u9752\u6625\u5076\u50cf\",\"v\":\"\u9752\u6625\u5076\u50cf\"},{\"n\":\"\u559c\u5267\",\"v\":\"\u559c\u5267\"},{\"n\":\"\u5bb6\u5ead\",\"v\":\"\u5bb6\u5ead\"},{\"n\":\"\u72af\u7f6a\",\"v\":\"\u72af\u7f6a\"},{\"n\":\"\u52a8\u4f5c\",\"v\":\"\u52a8\u4f5c\"},{\"n\":\"\u5947\u5e7b\",\"v\":\"\u5947\u5e7b\"},{\"n\":\"\u5267\u60c5\",\"v\":\"\u5267\u60c5\"},{\"n\":\"\u5386\u53f2\",\"v\":\"\u5386\u53f2\"},{\"n\":\"\u7ecf\u5178\",\"v\":\"\u7ecf\u5178\"},{\"n\":\"\u4e61\u6751\",\"v\":\"\u4e61\u6751\"},{\"n\":\"\u60c5\u666f\",\"v\":\"\u60c5\u666f\"},{\"n\":\"\u5546\u6218\",\"v\":\"\u5546\u6218\"},{\"n\":\"\u7f51\u5267\",\"v\":\"\u7f51\u5267\"},{\"n\":\"\u60ca\u609a\",\"v\":\"\u60ca\u609a\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"key\":\"1\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"}]},{\"key\":\"11\",\"name\":\"\u5e74\u4efd\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"},{\"n\":\"2009\",\"v\":\"2009\"},{\"n\":\"2008\",\"v\":\"2008\"},{\"n\":\"2007\",\"v\":\"2007\"},{\"n\":\"2006\",\"v\":\"2006\"},{\"n\":\"2005\",\"v\":\"2005\"},{\"n\":\"2004\",\"v\":\"2004\"},{\"n\":\"2003\",\"v\":\"2003\"},{\"n\":\"2002\",\"v\":\"2002\"},{\"n\":\"2001\",\"v\":\"2001\"},{\"n\":\"2000\",\"v\":\"2000\"}]},{\"key\":\"2\",\"name\":\"\u6392\u5e8f\",\"value\":[{\"n\":\"\u65f6\u95f4\",\"v\":\"time\"},{\"n\":\"\u4eba\u6c14\",\"v\":\"hits\"},{\"n\":\"\u8bc4\u5206\",\"v\":\"score\"}]}],\"16\":[{\"key\":\"3\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u53e4\u88c5\",\"v\":\"\u53e4\u88c5\"},{\"n\":\"\u6218\u4e89\",\"v\":\"\u6218\u4e89\"},{\"n\":\"\u9752\u6625\u5076\u50cf\",\"v\":\"\u9752\u6625\u5076\u50cf\"},{\"n\":\"\u559c\u5267\",\"v\":\"\u559c\u5267\"},{\"n\":\"\u5bb6\u5ead\",\"v\":\"\u5bb6\u5ead\"},{\"n\":\"\u72af\u7f6a\",\"v\":\"\u72af\u7f6a\"},{\"n\":\"\u52a8\u4f5c\",\"v\":\"\u52a8\u4f5c\"},{\"n\":\"\u5947\u5e7b\",\"v\":\"\u5947\u5e7b\"},{\"n\":\"\u5267\u60c5\",\"v\":\"\u5267\u60c5\"},{\"n\":\"\u5386\u53f2\",\"v\":\"\u5386\u53f2\"},{\"n\":\"\u7ecf\u5178\",\"v\":\"\u7ecf\u5178\"},{\"n\":\"\u4e61\u6751\",\"v\":\"\u4e61\u6751\"},{\"n\":\"\u60c5\u666f\",\"v\":\"\u60c5\u666f\"},{\"n\":\"\u5546\u6218\",\"v\":\"\u5546\u6218\"},{\"n\":\"\u7f51\u5267\",\"v\":\"\u7f51\u5267\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"key\":\"1\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u5fb7\u56fd\",\"v\":\"\u5fb7\u56fd\"},{\"n\":\"\u52a0\u62ff\u5927\",\"v\":\"\u52a0\u62ff\u5927\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"key\":\"11\",\"name\":\"\u5e74\u4efd\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"},{\"n\":\"2009\",\"v\":\"2009\"},{\"n\":\"2008\",\"v\":\"2008\"},{\"n\":\"2007\",\"v\":\"2007\"},{\"n\":\"2006\",\"v\":\"2006\"},{\"n\":\"2005\",\"v\":\"2005\"},{\"n\":\"2004\",\"v\":\"2004\"},{\"n\":\"2003\",\"v\":\"2003\"},{\"n\":\"2002\",\"v\":\"2002\"},{\"n\":\"2001\",\"v\":\"2001\"},{\"n\":\"2000\",\"v\":\"2000\"}]},{\"key\":\"4\",\"name\":\"\u8bed\u8a00\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u56fd\u8bed\",\"v\":\"\u56fd\u8bed\"},{\"n\":\"\u65e5\u8bed\",\"v\":\"\u65e5\u8bed\"},{\"n\":\"\u82f1\u8bed\",\"v\":\"\u82f1\u8bed\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"key\":\"2\",\"name\":\"\u6392\u5e8f\",\"value\":[{\"n\":\"\u65f6\u95f4\",\"v\":\"time\"},{\"n\":\"\u4eba\u6c14\",\"v\":\"hits\"},{\"n\":\"\u8bc4\u5206\",\"v\":\"score\"}]}]}";
    }

    public static void \ufec1\u0642\u0636\ufea9(Object object) {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() > 0) {
            ((t_0)object).yq();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static qq_0 \ufec9\u062a\ufee1\u0638(Object object, Object object2) {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() < 0) return null;
        return ((qq_0)object).yq((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \ufec9\u0634\u0641\ufed5(Object object) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() < 0) return null;
        return ((Tq)object).F5();
    }

    public static void \ufed5\u0636\u064a\ufeab() {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() < 0) {
            QB.KJ();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static AlertDialog.Builder \ufedd\u0648\ufeb5\ufe95(Object object, Object object2) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return null;
        return ((AlertDialog.Builder)object).setOnCancelListener((DialogInterface.OnCancelListener)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee1\u0633\ufe8e\u0627(Object object, Object object2, Object object3) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() >= 0) return null;
        return ((j_0)object).W((String)object2, (List)object3);
    }
}

