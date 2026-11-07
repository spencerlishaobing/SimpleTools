/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.ApplicationInfo
 *  android.webkit.WebSettings
 */
package com.github.catvod.parser;

import android.content.pm.ApplicationInfo;
import android.webkit.WebSettings;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Bili;
import com.github.catvod.spider.Cloud_baidu;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.NewCz;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.ID;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.MI;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.db_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.hm;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class \u0645\u0641\u0630\u062d {
    public static int \u0627\ufef1\u062a\u0628 = 795;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0627\ufe8e\ufeb5\ufeb9(Object object, Object object2, Object object3, Object object4) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() <= 0) return null;
        return ((NewCz)((Object)object)).playerContent((String)object2, (String)object3, (List)object4);
    }

    public static void \u062a\u0648\u0641\ufeaf() {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() < 0) {
            InitOrigin.stopShowingToast();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long \u062c\ufea5\u0640\u0630(Object object) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() > 0) return 0L;
        return ((MI)object).tF();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062f\u063a\u062e\u0636(Object object) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() >= 0) return null;
        return ((hm)object).t0();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0633\u0647\ufe99\u0636(Object object) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return db_0.yq((List)object);
    }

    public static void \u0634\ufebd\u0633\u0645(Object object) {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() > 0) {
            ((n6)object).U();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \u063a\u0647\u0638\ufea1(Object object, Object object2, boolean bl) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() >= 0) return null;
        return ((Tq)object).s((String)object2, bl);
    }

    public static String \u0642\u062a\u0630\ufebd(short[] sArray, int n, int n2, int n3) {
        char[] cArray = new char[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            cArray[i2] = (char)(sArray[n + i2] ^ n3);
        }
        return new String(cArray);
    }

    public static void \u0642\u0645\ufed5\u0632(Object object, Object object2) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() >= 0) {
            ((Ef)object).t0((Ef.yq)object2);
        }
    }

    public static void \u0643\u0636\ufe99\ufed5(Object object, Object object2) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() <= 0) {
            ((Ef)object).G4((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Ef \u064a\ufea9\u0644\u0643(Object object, Object object2) {
        if (\ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631() >= 0) return null;
        return ((Cloud_baidu)((Object)object)).detailVideo((List)object2);
    }

    public static void \ufe8f\u0645\u0635\ufeb9(Object object, int n) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() < 0) {
            ((WebSettings)object).setMixedContentMode(n);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufe95\ufeed\u064a\ufe8f(String object) {
        int n = 0;
        String string = "";
        String string2 = "";
        int n2 = 0;
        while (true) {
            if (n2 >= 15) {
                while (string.length() > 0) {
                }
                break;
            }
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
        n2 = n;
        while (n2 < n3) {
            object[n2] = (byte)(object[n2] ^ string2.charAt(n2 % n4));
            ++n2;
        }
        return new String((byte[])object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufe9d\u0636\u064a\u0648(Object list) {
        if (\ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9() < 0) return null;
        return Arrays.asList((Object[])list);
    }

    public static void \ufe9d\u0647\ufe8f\ufee1(Object object, Object object2) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() <= 0) {
            ((ID)object).B((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea1\ufe8f\u0631\ufea5(Object object) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() < 0) return null;
        return ((ApplicationInfo)object).packageName;
    }

    public static int \ufea5\u0639\u063a\u062e(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufead\u062b\u0647\u0642(Object object, Object object2) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() >= 0) return null;
        return w2.W((String)object, (Map)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static TimeUnit \ufeaf\u063a\ufed5\u0645() {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() < 0) return null;
        return TimeUnit.NANOSECONDS;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \ufeaf\ufec9\u0638\ufeb1(Object object, Object object2) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() > 0) return null;
        return ((Tq)object).B((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static hN \ufeb1\u064a\ufea5\u0647(Object object, Object object2) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() > 0) return null;
        return ((hN)object).OB((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufeb9\u062d\ufeed\u0643(Object object) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() <= 0) return false;
        return Bili.containsChinese((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufebd\ufeb9\u0646\u062d() {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() >= 0) return null;
        return "https://drive.uc.cn/";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec5\ufecd\u0644\ufe95() {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() < 0) return null;
        return "lastQuarkPlayUrl";
    }

    public static int \ufee1\ufec5\ufea9\u064a() {
        return 0x265 ^ \u0641\ufeb5\ufeb1\ufee1.\u0646\u0633\u0647\u062b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufef1\ufeaf\ufead\ufeb5(Object object) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() <= 0) return null;
        return ME.b((String)object);
    }
}

