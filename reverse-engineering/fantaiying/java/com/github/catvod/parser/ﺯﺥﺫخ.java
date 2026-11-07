/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.ViewGroup$MarginLayoutParams
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.os.Build;
import android.view.ViewGroup;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.spider.Appgz;
import com.github.catvod.spider.Cloud_ali;
import com.github.catvod.spider.Cloud_baidu;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.LP;
import com.github.catvod.spider.merge.MI;
import com.github.catvod.spider.merge.X0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.ts_0;
import com.github.catvod.spider.merge.zh_0;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import org.json.JSONObject;

public class \ufeaf\ufea5\ufeab\u062e {
    public static int \u0641\ufeb5\ufea5\u0643 = -112;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062f\ufe8e\ufec1\u063a() {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() > 0) return null;
        return "{\"action_type\":1,\"to_pdir_fid\":\"%s\",\"filelist\":%s,\"exclude_fids\":[]}";
    }

    public static int \u0630\ufeaf\ufe99\u0646() {
        return 0xFFFFFC81 ^ \u062d\u062e\ufe8e\u0645.\ufead\ufec5\ufe99\u062d;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0630\ufeb1\u0636\ufea5() {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() < 0) return null;
        return "<!DOCTYPE html>\n<html lang=\"zh-cmn-Hans\">\n<head>\n  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover\">\n  <style>\n    body { display:flex; flex-direction:column; align-items:center; justify-content:center; min-height:100vh; margin:0; font-family:Arial,sans-serif; }\n    .container { width:90%; max-width:500px; display:flex; flex-direction:column; align-items:center; }\n    .title { font-size:1.2em; margin-bottom:30px; text-align:center; }\n    .title span { color:red; font-weight:bold; }\n    .input-wrapper { width:100%; margin-bottom:15px; }\n    .input-wrapper textarea { width:100%; height:100px; box-sizing:border-box; padding:10px; font-size:1em; resize:none; }\n    .button { width:100%; height:42px; box-sizing:border-box; font-size:1em; margin-bottom:10px; cursor:pointer; }\n    .button.push { background-color:#4CAF50; color:white; border:none; }\n    .button.clear { background-color:#f44336; color:white; border:none; }\n    .image-wrapper { width:100%; display:flex; justify-content:center; margin-bottom:15px; }\n    .image-wrapper img { width:20%; }\n  </style>\n</head>\n<body>\n  <div class=\"container\">\n    <div class=\"image-wrapper\">\n      <img src=\"https://img07.sogoucdn.com/v2/thumb/retype_exclude_gif/ext/auto/q/95/crop/xy/ai/t/0/?appid=122&url=https://s1.imagehub.cc/images/2026/03/01/02825385af7950edd9bcc89687373210.md.png\" alt=\"\u56fe\u7247\">\n    </div>\n    <div class=\"input-wrapper\">\n      <textarea id=\"push_url\"\n        placeholder=\"\u8bf7\u8f93\u5165\u641c\u7d22\u5173\u952e\u8bcd\"></textarea>\n    </div>\n    <button class=\"button push\" onclick=\"push()\">\u641c\u7d22</button>\n    <button class=\"button clear\" onclick=\"clearInput()\">\u6e05\u9664</button>\n  </div>\n\n  <script>\n    function clearInput() {\n      document.getElementById('push_url').value = '';\n    }\n\n    function push() {\n      var pushUrl = encodeURIComponent(document.getElementById('push_url').value);\n      var apiUrl = 'http://";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0631\u0647\u0639\ufebd(Object object) {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() <= 0) return null;
        return ((i3)object).OW;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0633\ufecd\ufeb1\u062c(String object) {
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
        int n4 = string2.length();
        n2 = 0;
        while (true) {
            if (n2 >= n3) break;
            object[n2] = (byte)(object[n2] ^ string2.charAt(n2 % n4));
            ++n2;
        }
        n2 = n;
        while (n2 < ((Object)object).length) {
            n2 = "".length() + 1;
        }
        return new String((byte[])object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0638\u0632\u0635\ufef1() {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return null;
        return ProxyOrigin.getInternalUrl();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u063a\u062f\ufead\u0630(Object object) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return null;
        return zh_0.SN((Iterable)object);
    }

    public static String \u0641\u062f\u0637\u0630(short[] sArray, int n, int n2, int n3) {
        char[] cArray = new char[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            cArray[i2] = (char)(sArray[n + i2] ^ n3);
        }
        return new String(cArray);
    }

    public static void \u0641\u0645\u0636\ufe9d(Object object, int n, int n2, int n3, int n4) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() > 0) {
            ((ViewGroup.MarginLayoutParams)object).setMargins(n, n2, n3, n4);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0641\ufeb9\u0630\u0628(Object object) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() > 0) return false;
        return ((LP)object).dT();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0644\u0635\ufebd\u062f() {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() <= 0) return null;
        return "Content-Type";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static n6 \u0645\ufec1\u0631\u063a(Object object) {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() >= 0) return null;
        return n6.g1((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0647\u0643\ufedd\ufebd(Object object) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return false;
        return ((ArrayList)object).isEmpty();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long \u0648\u062f\u0634\ufed9(Object object) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() > 0) return 0L;
        return ((X0)object).SN();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \ufe99\ufea9\u0647\u0641(Object object, Object object2) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() < 0) return null;
        return ((JSONObject)object).getJSONObject((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea1\ufec5\ufec9\u0640(Object object) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() > 0) return null;
        return ((ts_0)object).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea5\ufed9\u062e\ufef1(int n) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() <= 0) return null;
        return Appgz.generateRandomString(n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static char[] \ufea9\u0635\ufe8f\u0640(Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return null;
        return ((String)object).toCharArray();
    }

    public static int \ufeab\u0648\u0631\u0640(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufeaf\u0631\u062a\u0634() {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() >= 0) return false;
        return Cloud_baidu.i;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Cloud_ali \ufeb1\ufebd\ufea9\u0647(Object object) {
        void var0_2;
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() <= 0) return var0_2;
        Cloud_ali cloud_ali = ((Pan)((Object)object)).SN;
        return var0_2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufed9\ufe8e\ufeab\u0633(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() > 0) return null;
        return ((MI)object).N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufef1\u0643\ufea9\u0645() {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() < 0) return 0;
        return Build.VERSION.SDK_INT;
    }
}

