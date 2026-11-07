/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.spider.Hmys;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.RO;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.WN;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class \ufeaf\u0633\u0648\ufee9 {
    public static int \u0634\u062b\ufec9\ufeb5 = 373;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static StringBuilder \u0627\u062c\u062d\u062a(Object object, char c) {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() >= 0) return null;
        return ((StringBuilder)object).append(c);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Boolean \u0628\u0641\ufe95\ufee1(boolean bl) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() < 0) return null;
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object[] \u062a\ufec9\ufeab\u064a(Object objectArray, Object object) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() >= 0) return null;
        return ((xu_0)objectArray).kR((HashMap)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062c\u0636\ufeed\u0641() {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() >= 0) return null;
        return "VIP";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062d\u0631\u0644\u0645() {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() > 0) return null;
        return "\u63a8\u9001";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \u062e\u062f\u0644\u0645(Object object, int n2) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() < 0) return null;
        return ((JSONArray)object).getJSONObject(n2);
    }

    public static String \u062e\u0645\u0644\u0648(short[] sArray, int n2, int n3, int n4) {
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
    public static String \u0631\ufea9\u0636\ufeb9(Object object) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() > 0) return null;
        return ((tX)object).t0();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0633\ufed9\u064a\u0630(Object object) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() <= 0) return null;
        return ((n6)object).W();
    }

    public static int \u0635\u0637\ufe9d\ufec5(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0636\u0630\ufeb1\ufea1(Object object) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return null;
        return ((RO)object).yq();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0637\u0644\u0643\ufeab(String object) {
        int n2 = 0;
        String string = "";
        String string2 = "";
        int n3 = 0;
        while (true) {
            if (n3 >= 15) {
                while (string.length() > 0) {
                }
                break;
            }
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
    public static String \u0637\ufed9\ufeb9\u0634(Object object, Object object2) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() >= 0) return null;
        return Bo.KJ((String)object, (Map)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0639\ufef1\u0628\u063a(Object object, Object object2, Object object3) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() <= 0) return null;
        return ((xu_0)object).R((String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0640\u062f\ufed5\ufeaf(Object object, Object object2) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() <= 0) return null;
        return ME.F5((String)object, (String)object2);
    }

    public static int \u0641\u062b\u062d\ufeed() {
        return 0xFFFFFCE3 ^ \ufea9\ufe8f\u0647\ufead.\ufee9\u062d\u0627\u0643;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0643\ufe8e\u0628\u062a() {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() >= 0) return null;
        return "\u9009\u62e9\u652f\u6301\u7684WEBDAV\u670d\u52a1\u7684\u64ad\u653e\u5668";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object[] \u0643\ufeed\ufeb9\ufe8e(Object objectArray, Object object) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() < 0) return null;
        return ((List)objectArray).toArray((Object[])object);
    }

    public static void \u0645\u0636\u0640\ufef1(Object object, Object object2) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() <= 0) {
            ((H7)object).g((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0646\u0630\ufeb1\ufe8f(Object object) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() > 0) return null;
        return ((WN)object).tF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0647\ufea1\ufe8e\u063a(Object object, Object object2) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() > 0) return null;
        return Bo.M((String)object, (String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0647\ufebd\u0644\ufeb5(int n2) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() > 0) return null;
        return Hmys.randomDeviceId(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \ufe8f\u062d\u0643\ufed9(Object object, Object object2) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() <= 0) return null;
        return ((Tq)object).O((List)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe99\ufea5\ufec5\ufeaf() {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() < 0) return null;
        return "status\":2,";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Boolean \ufe9d\u0636\u064a\u0648() {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return null;
        return Boolean.TRUE;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea9\u062f\ufeaf\ufeb1() {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() < 0) return null;
        return "1";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeb5\u0634\u0640\ufea1(Object object) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() <= 0) return null;
        return ((JSONObject)object).toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Ef.yq \ufecd\ufec9\u062c\u0627() {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() <= 0) return null;
        return Ef.yq.yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee1\u0636\u0639\ufeb1(Object object) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() < 0) return null;
        return ((tX)object).v3();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee9\u062c\ufef1\ufed5() {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() < 0) return null;
        return "limit[{0}]";
    }
}

