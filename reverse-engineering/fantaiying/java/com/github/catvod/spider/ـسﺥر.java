/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Intent
 *  android.os.Build
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.spider.merge.LP;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.MI;
import com.github.catvod.spider.merge.My;
import com.github.catvod.spider.merge.QB;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.hm;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.k9;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class \u0640\u0633\ufea5\u0631 {
    public static int \u0642\u0641\u062e\ufe9d = 682;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \u0628\ufea1\u0643\ufee9() {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() >= 0) return null;
        return ME.yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0628\ufee9\u063a\u0632(Object object) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() < 0) return null;
        return ((iK)object).ee();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062c\u0636\ufeb1\ufeaf() {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() >= 0) return null;
        return "webdav.mkv";
    }

    public static void \u062d\u0636\ufea9\u0640(Object object, Object object2) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() < 0) {
            ((dl_0)object).n((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \u062e\u062f\u062a\ufedd(Object object, Object object2) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() > 0) return null;
        return ((Tq)object).yq((String)object2);
    }

    public static int \u0632\ufead\u062f\u0628(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0633\u0627\ufec1\ufeb1() {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() >= 0) return null;
        return "{\"action_type\":2,\"filelist\":%s,\"exclude_fids\":[]}";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0636\ufed5\ufeb1\u0640(Object object) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() >= 0) return null;
        return ((n6)object).tF();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0637\u0646\u062c\ufead(String object) {
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
    public static Intent \u0639\u0644\u0633\ufe9d(Object object, Object object2) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return null;
        return ((Intent)object).setComponent((ComponentName)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0640\u0634\u0627\ufecd(Object object) {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() <= 0) return false;
        return ME.g9((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0641\u062a\ufeb5\u0634(Object object) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() >= 0) return 0;
        return ((HashMap)object).size();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0644\u063a\u0636\u0645(Object object) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() > 0) return null;
        return ME.g1((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0647\u0633\u0639\u0648(Object object) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() >= 0) return 0;
        return ((StringBuilder)object).length();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \u0648\u0647\u062b\ufe9d() {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() > 0) return null;
        return QB.G;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8f\ufeab\u0642\u0635(Object object) {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return null;
        return ((MI)object).zH();
    }

    public static int \ufe8f\ufed9\ufec5\ufe9d() {
        return 0x370 ^ \ufe9d\ufeab\u062e\u0640.\ufe8e\ufe9d\ufeab\ufebd;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe9d\ufec1\ufeaf\ufed9() {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() < 0) return null;
        return "webdavMode";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea5\u0634\u062b\ufecd(Object object) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() > 0) return null;
        return ((hm)object).tF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufead\u0648\ufebd\u0633() {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() <= 0) return null;
        return Build.BOARD;
    }

    public static String \ufeb1\u0632\u062f\ufe8f(short[] sArray, int n2, int n3, int n4) {
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
    public static Map \ufeb1\u0638\u0648\ufef1(Object map) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() < 0) return null;
        return ((k9)((Object)map)).tF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object[] \ufec9\u0630\ufed9\ufeb1(Object objectArray) {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() < 0) return null;
        return ((ArrayList)objectArray).toArray();
    }

    public static void \ufecd\u0647\ufe8e\u0627(Object object, Object object2) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() <= 0) {
            ((xu_0)object).ee((JSONObject)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static LP \ufed9\ufea1\u0638\u062d(Object object) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() > 0) return null;
        return ((My)object).yq();
    }
}

