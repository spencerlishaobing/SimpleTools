/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.DialogInterface;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.spider.Bili;
import com.github.catvod.spider.Hmys;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.MI;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.lm;
import com.github.catvod.spider.merge.nb_0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class \ufeb1\ufe8e\ufee1\ufe9d {
    public static int \ufead\u0630\ufed9\ufeb5 = 5;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0627\u062a\u0647\ufeab(Object object) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return ((nb_0)object).tF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u062c\ufeb5\ufea5\u063a(Object object, Object object2) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() > 0) return 0;
        return ((JSONObject)object).optInt((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Iterator \u062e\u0644\u062a\u0628(Object iterator) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() > 0) return null;
        return ((Set)((Object)iterator)).iterator();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \u062e\ufeaf\ufec1\u0643(Object hashMap, Object object) {
        if (\u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a() > 0) return null;
        return ((N0)((Object)hashMap)).Fz((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Calendar \u0631\u0638\ufec1\ufebd() {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() <= 0) return null;
        return Calendar.getInstance();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0634\ufecd\ufe99\ufec9(Object object) {
        if (\ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9() <= 0) return false;
        return ((i3)object).u7();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0637\u0646\u062a\ufec1(Object object) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() <= 0) return null;
        return ((MI)object).i();
    }

    public static void \u0637\ufedd\u062d\ufea1(Object object, Object object2) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() >= 0) {
            ((H7)object).n((String)object2);
        }
    }

    public static void \u0638\u062e\u0646\u0641(Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() >= 0) {
            ((DialogInterface)object).dismiss();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0638\ufea1\ufeab\ufeb5(Object object, Object object2) {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() <= 0) return false;
        return ((List)object).add(object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static MessageDigest \u0639\ufeab\u062b\u062f(Object object) {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() <= 0) return null;
        return MessageDigest.getInstance((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u063a\u0637\u0641\ufea1(Object object, Object object2, Object object3, boolean bl, Object object4) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() <= 0) return null;
        return ((Bili)((Object)object)).categoryContent((String)object2, (String)object3, bl, (HashMap)object4);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Ef \u063a\u0641\ufec5\u062c(Object object, Object object2, Object object3) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() >= 0) return null;
        return ((N0)object).XO((String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long \u0642\ufeaf\u0648\ufea5(Object object) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() >= 0) return 0L;
        return (Long)object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0643\ufeb9\u0628\ufeab(Object object, Object object2, Object object3) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() < 0) return null;
        return ((N0)object).J((String)object2, (String)object3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0645\ufe8e\u0627\u064a(String object) {
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

    public static int \u0645\ufe9d\u0646\u0630(Object object) {
        return object.hashCode();
    }

    public static void \ufe99\ufeab\ufe8f\u062f(Object object) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() >= 0) {
            InitOrigin.run((Runnable)object);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufead\ufea1\ufe8e\ufeb5(Object object) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return ((lm)object).q();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Date \ufebd\u0645\u0632\u0627(Object object) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() >= 0) return null;
        return ((Calendar)object).getTime();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufebd\ufedd\u0636\ufed9(Object object) {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() > 0) return null;
        return ((Hmys)((Object)object)).homeVideoContent();
    }

    public static int \ufec5\u0636\u0648\u0635() {
        return 0xFFFFFEC8 ^ \u0641\ufeb5\ufeb1\ufee1.\u0646\u0633\u0647\u062b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufee9\u062f\u062c\ufecd(Object object) {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() < 0) return false;
        return ((xu_0)object).F5();
    }

    public static String \ufeed\u0640\ufecd\ufeaf(short[] sArray, int n2, int n3, int n4) {
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
    public static HashMap \ufeed\ufeaf\u0642\u0637() {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() > 0) return null;
        return xu_0.Zm;
    }
}

