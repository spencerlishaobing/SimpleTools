/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.HA;
import com.github.catvod.spider.merge.ID;
import com.github.catvod.spider.merge.ak;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.hm;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.nb_0;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.x5;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.nio.channels.Pipe;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.zip.Inflater;

public class \u062d\ufeb9\ufeab\ufef1 {
    public static int \ufed9\u0631\ufeab\ufeb9 = -89;

    public static void \u0627\u062e\u0643\ufec1(Object object, Object object2, Object object3) {
        if (\u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a() <= 0) {
            ((xu_0)object).o((String)object2, (List)object3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u062c\ufec9\ufeb5\u0640(Object object) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() > 0) return 0;
        return ((HA)object).i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Pipe.SourceChannel \u062e\ufeb9\u0648\ufe8f(Object object) {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() <= 0) return null;
        return ((Pipe)object).source();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \u0631\u0634\u062c\ufed5(Object list, Object object) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() <= 0) return null;
        return ((xu_0)((Object)list)).U((dl_0)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0632\ufec9\ufeb1\ufe95(Object object) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() < 0) return false;
        return ((tX)object).O();
    }

    public static void \u0633\ufeb1\ufebd\u0646(Object object, Object object2) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() >= 0) {
            ((Inflater)object).setInput((byte[])object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0634\u0630\ufec9\u0636(Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() <= 0) return null;
        return ((ak)object).t0();
    }

    public static void \u0635\ufed9\u0630\u0648(Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() > 0) {
            ((MessageDigest)object).reset();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0639\ufeb5\u0643\u0641(Object object, Object object2) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() >= 0) return null;
        return ((H7)object).G((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0641\u0642\ufea9\ufedd(Object object) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() > 0) return null;
        return ((hm)object).N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0642\ufef1\u0638\ufea9(Object object) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() >= 0) return null;
        return ((Matcher)object).group();
    }

    public static void \u0646\u0637\u0644\ufea9(Object object) {
        if (\ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1() < 0) {
            ((xu_0)object).Hj();
        }
    }

    public static int \u0647\u0635\u0643\u062e(Object object) {
        return object.hashCode();
    }

    public static int \ufe8e\u0645\u0632\u0628() {
        return 0xFFFFFCCA ^ \u0632\ufead\u062f\u0628.\u0648\u0647\ufe9d\u062b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Charset \ufe8f\ufe99\u0645\u0627() {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() >= 0) return null;
        return StandardCharsets.UTF_8;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe99\u0640\u062c\ufeaf(Object object) {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() < 0) return null;
        return ((H7)object).dT();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static StringBuilder \ufe9d\u0637\u0627\ufeb9(Object object, Object object2) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() <= 0) return null;
        return ((StringBuilder)object).append(object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea1\ufecd\ufeed\u063a(Object object) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() > 0) return null;
        return ((i3)object).Gc;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufea5\ufec9\ufe8f\ufeab(String object) {
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object[] \ufeaf\ufeab\u0639\ufe8f(Object objectArray, Object object) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() >= 0) return null;
        return ((xu_0)objectArray).C((Map)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufeb9\ufec5\ufed5\u0634(Object object, Object object2) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() < 0) return false;
        return Collections.addAll((Collection)object, (Object[])object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufebd\u0637\u0640\ufec5(Object object, Object object2, Object object3) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() <= 0) return null;
        return w2.Gd((String)object, (Map)object2, (Map)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufec1\u062e\ufed5\u0644(Object object) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() > 0) return false;
        return ((nb_0)object).KJ();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufec5\u0641\u0628\ufeb9(Object object, Object object2, Object object3) {
        if (\u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9() >= 0) return null;
        return ((AbstractMap)object).put(object2, object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ID \ufed5\ufeb1\u0632\u0637(Object object) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() <= 0) return null;
        return ((ID)object).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee9\ufe9d\u0642\ufebd(Object object) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() < 0) return null;
        return ((x5)object).SN();
    }

    public static String \ufeed\u0638\u0635\ufed5(short[] sArray, int n2, int n3, int n4) {
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
    public static xu_0 \ufeed\u0645\u0636\u0644() {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() < 0) return null;
        return xu_0.xa();
    }

    public static void \ufeed\ufea5\u0643\ufee9(Object object, int n2) {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() >= 0) {
            ((ByteArrayOutputStream)object).write(n2);
        }
    }
}

