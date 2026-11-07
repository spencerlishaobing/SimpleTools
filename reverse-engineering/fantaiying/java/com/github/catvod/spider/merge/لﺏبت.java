/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 */
package com.github.catvod.spider.merge;

import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.Yx;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.nb_0;
import com.github.catvod.spider.merge.p7;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.zm_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Mac;
import org.json.JSONArray;

public class \u0644\ufe8f\u0628\u062a {
    public static int \ufead\ufeb9\ufec1\ufedd = 776;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0630\ufef1\ufecd\ufec1(Object object) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() < 0) return null;
        return ((Mac)object).getAlgorithm();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0632\u0647\ufeaf\u0631(Object object) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() > 0) return null;
        return ((Yx)object).tF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0632\ufead\u062f\u0628() {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() < 0) return null;
        return "flag";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \u0634\ufeb9\u0639\u0643(Object list) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() <= 0) return null;
        return ((N0)((Object)list)).E1();
    }

    public static String \u0636\u063a\u0638\u0630(short[] sArray, int n2, int n3, int n4) {
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
    public static String \u0637\u0631\ufeaf\u0647(Object object, Object object2) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() < 0) return null;
        return p7.zH((String)object, (String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0637\u0631\ufeed\u0633() {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() < 0) return null;
        return "task_resp";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0640\u062c\u0631\u0647(Object object, Object object2, Object object3) {
        if (\u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a() >= 0) return null;
        return zm_0.t0((String)object, (Map)object2, (Map)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0640\u062f\u0643\ufeb9() {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() > 0) return null;
        return "Choose an app";
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0643\ufe8e\ufeb1\ufed9(String object) {
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
    public static String \u0647\u062e\u062f\u0631(Object object, Object object2, Object object3, int n2) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() >= 0) return null;
        return rs_0.G((String)object, (String)object2, (String)object3, n2);
    }

    public static int \u0647\ufebd\u0627\u0631() {
        return 0x1B4 ^ \u0632\ufead\u062f\u0628.\u0648\u0647\ufe9d\u062b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File \u064a\u0641\ufec5\u0630(Object object) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() > 0) return null;
        return ((i3)object).R();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufe9d\u0628\u062f\u0645(Object object) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() >= 0) return false;
        return ((AtomicBoolean)object).get();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeaf\u062b\ufed5\ufec1(int n2) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() <= 0) return null;
        return String.valueOf(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeb5\ufecd\u062f\u0627(Object object) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return null;
        return ME.B((String)object);
    }

    public static int \ufeb5\ufee1\ufeaf\u062f(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec1\u062e\ufed5\u0644() {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return null;
        return ProxyOrigin.getUrl();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec5\u0645\ufeed\u0635() {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() >= 0) return null;
        return "<!DOCTYPE html>\n<html lang=\"zh-cmn-Hans\">\n<head>\n  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover\">\n  <style>\n    body { display:flex; flex-direction:column; align-items:center; justify-content:center; min-height:100vh; margin:0; font-family:Arial,sans-serif; }\n    .container { width:90%; max-width:500px; display:flex; flex-direction:column; align-items:center; }\n    .title { font-size:1.2em; margin-bottom:30px; text-align:center; }\n    .title span { color:red; font-weight:bold; }\n    .input-wrapper { width:100%; margin-bottom:15px; }\n    .input-wrapper textarea { width:100%; height:100px; box-sizing:border-box; padding:10px; font-size:1em; resize:none; }\n    .button { width:100%; height:42px; box-sizing:border-box; font-size:1em; margin-bottom:10px; cursor:pointer; }\n    .button.push { background-color:#4CAF50; color:white; border:none; }\n    .button.clear { background-color:#f44336; color:white; border:none; }\n    .image-wrapper { width:100%; display:flex; justify-content:center; margin-bottom:15px; }\n    .image-wrapper img { width:20%; }\n  </style>\n</head>\n<body>\n  <div class=\"container\">\n    <div class=\"image-wrapper\">\n      <img src=\"https://img07.sogoucdn.com/v2/thumb/retype_exclude_gif/ext/auto/q/95/crop/xy/ai/t/0/?appid=122&url=https://s1.imagehub.cc/images/2026/03/01/02825385af7950edd9bcc89687373210.md.png\" alt=\"\u56fe\u7247\">\n    <div class=\"input-wrapper\">\n      <textarea id=\"push_url\" placeholder=\"\u8bf7\u8f93\u5165\u641c\u7d22\u5173\u952e\u8bcd\"></textarea>\n    </div>\n    <button class=\"button push\" onclick=\"push()\">\u641c\u7d22</button>\n    <button class=\"button clear\" onclick=\"clearInput()\">\u6e05\u9664</button>\n  </div>\n  <script>\n    function clearInput() { document.getElementById('push_url').value = ''; }\n    function push() {\n      var kw = document.getElementById('push_url').value;\n      var apiUrl = 'http://";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static nb_0 \ufec5\u064a\u0633\ufed5(Object object) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() >= 0) return null;
        return nb_0.q((String)object);
    }

    public static void \ufed9\ufead\ufef1\ufea5(Object object, Object object2) {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() <= 0) {
            ((Ef)object).Gc((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufee9\ufe8e\ufe99\u0631(Object object) {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() >= 0) return 0;
        return ((JSONArray)object).length();
    }
}

