/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.ID;
import com.github.catvod.spider.merge.J7;
import com.github.catvod.spider.merge.MI;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.qq_0;
import com.github.catvod.spider.merge.rq_0;
import com.github.catvod.spider.merge.ts_0;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.json.JSONObject;

public class \ufe8e\ufeb9\u0647\u0642 {
    public static int \ufed5\u0627\ufea5\ufeb9 = 737;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Long \u0627\u062a\ufe95\u0630(long l) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() <= 0) return null;
        return l;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062a\ufef1\ufee1\u0628() {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() >= 0) return null;
        return "\"status\":500";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062b\ufee1\u0630\ufea9() {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return null;
        return "data";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static qq_0 \u062c\u0631\ufeaf\ufe8e(Object object, Object object2) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() < 0) return null;
        return ((qq_0)object).N((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File \u0632\u0638\ufeb9\u0633(Object object) {
        if (\ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a() > 0) return null;
        return ((i3)object).J();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static InputStream \u0645\ufeaf\ufeab\ufea9(Object object) {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() <= 0) return null;
        return Channels.newInputStream((ReadableByteChannel)object);
    }

    public static int \u0646\u062f\u0632\u0636(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0646\ufea1\u0630\ufe99(Object object) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() >= 0) return null;
        return ((H7)object).G4();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0647\ufed9\ufecd\u0628(Object object, Object object2, Object object3) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() >= 0) return null;
        return w2.B((String)object, (Map)object2, (Map)object3);
    }

    public static void \u0648\u0636\ufea9\u0630(Object object) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() > 0) {
            InitOrigin.show((String)object);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static TimeUnit \u064a\ufeb1\u0642\ufea5() {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() <= 0) return null;
        return TimeUnit.SECONDS;
    }

    public static void \ufe8e\ufeb1\ufeab\u062a(Object object, Object object2) {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() < 0) {
            ((ID)object).G((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ClassLoader \ufe95\u0638\u062e\ufee9(Object object) {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() > 0) return null;
        return ((Class)object).getClassLoader();
    }

    public static void \ufe95\u064a\u063a\u0631(Object object) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() < 0) {
            ((HashMap)object).clear();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe95\ufeb5\ufee9\u0648(Object object, long l) {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() >= 0) return null;
        return rq_0.N((String)object, l);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe95\ufec5\u0635\ufead() {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() <= 0) return null;
        return "\u5df2\u542f\u52a8\u5916\u7f6e\u64ad\u653e\u5668\u64ad\u653e";
    }

    public static int \ufe99\u062b\ufea1\u0647() {
        return 0xFFFFFE5B ^ \u062f\ufead\ufeaf\u062d.\ufee1\ufee9\ufef1\u0627;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea1\ufead\u0646\ufedd(Object object, Object object2, int n2) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() >= 0) return null;
        return J7.N((String)object, (String)object2, n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufea1\ufead\ufed5\ufe95(Object object, Object object2, int n2) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() < 0) return 0;
        return ((JSONObject)object).optInt((String)object2, n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea5\ufed9\u062e\ufef1(Object object) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() <= 0) return null;
        return w2.t0((Map)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Logger \ufea9\ufea5\u0637\ufee1(Object object) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() >= 0) return null;
        return Logger.getLogger((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufead\u0630\u0635\ufe99(Object object) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() < 0) return null;
        return ((ts_0)object).zH();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufead\u0632\u062b\ufee9() {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() < 0) return null;
        return "{\"fids\":[\"%s\"],\"pwd_id\":\"%s\",\"stoken\":\"%s\",\"fids_token\":[\"%s\"]}";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static MI \ufeb9\ufea5\u0647\ufe95(Object object) {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() < 0) return null;
        return ((MI)object).Gc();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufec1\ufed5\ufe99\ufea9(Object object, Object object2) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() >= 0) return false;
        return ((HashMap)object).containsKey(object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File \ufed5\u062c\ufedd\u0642(Object object) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() <= 0) return null;
        return ((N0)object).V();
    }

    public static String \ufee1\u062f\ufedd\u0643(short[] sArray, int n2, int n3, int n4) {
        char[] cArray = new char[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            cArray[i2] = (char)(sArray[n2 + i2] ^ n4);
        }
        return new String(cArray);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufee9\ufeed\u0645\u0630(String object) {
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
        while (true) {
            if (((String)object).length() <= 0) break;
            byteArrayOutputStream.write(string.indexOf(((String)object).charAt(-2)) << 4 | string.indexOf(((String)object).charAt(-1)));
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

    public static void \ufef1\ufeab\ufebd\u0640(Object object, Object object2, Object object3, Object object4, Object object5) {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() >= 0) {
            k_0.t0((StringBuilder)object, (String)object2, (String)object3, (String)object4, (String)object5);
        }
    }
}

