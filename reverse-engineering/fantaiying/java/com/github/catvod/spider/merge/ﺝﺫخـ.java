/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Cloud_quark;
import com.github.catvod.spider.Cloud_uc;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.F1;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.aj_0;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.eY;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.pq;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class \ufe9d\ufeab\u062e\u0640 {
    public static int \ufe8e\ufe9d\ufeab\ufebd = 424;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0627\ufea5\u062e\ufea9(Object object, Object object2) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() <= 0) return 0;
        return ((String)object).indexOf((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062c\u0637\u0643\u062d(Object object) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() >= 0) return null;
        return ((H7)object).F5();
    }

    public static void \u062d\u063a\u062b\u0640(Object object, Object object2) {
        if (\u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a() <= 0) {
            ((n6)object).Fz((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0630\u0646\ufead\u0640(Object object) {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() < 0) return null;
        return ((N0)object).zH;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0631\ufec1\u064a\ufea5(Object object) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() < 0) return null;
        return ((n6)object).i();
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Cloud_uc \u0635\u0637\u0643\ufe95(Object object) {
        void var0_2;
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return var0_2;
        Cloud_uc cloud_uc = ((Pan)((Object)object)).N;
        return var0_2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0638\ufe8f\u062e\u062f(Object object, Object object2, Object object3, boolean bl, Object object4, Object object5) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() <= 0) return null;
        return ((i3)object).xa((H7)object2, (String)object3, bl, (String)object4, (File)object5);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0639\u0638\ufeed\u0641(int n2, int n3) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() < 0) return 0;
        return Integer.compare(n2, n3);
    }

    public static int \u0640\ufe8e\u0630\ufe95(Object object) {
        return object.hashCode();
    }

    public static void \u0640\ufea5\u062b\ufe99(Object object, Object object2) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() < 0) {
            ((n6)object).g((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0646\ufea5\u063a\u0637(Object object) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() <= 0) return null;
        return ((xu_0)object).F5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0646\ufeb5\ufe99\ufecd() {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() >= 0) return false;
        return F1.yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Tq \u0648\u062d\u0643\ufeb1(Object object, Object object2) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() > 0) return null;
        return ((Tq)object).SN((List)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufe9d\u062e\u062b\u0636(Object object, Object object2) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() >= 0) return null;
        return ((HashMap)object).remove(object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe9d\u0632\u0627\u0633(Object object, Object object2) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() <= 0) return null;
        return ((Pan.KeyValueData)object).get((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea1\ufe99\u0635\u0641(Object object) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() >= 0) return null;
        return ((pq)object).SN();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufea1\ufecd\u0646\u0648(String object) {
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
    public static Tq \ufead\ufe8e\u064a\ufeb5(Object object, Object object2) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() <= 0) return null;
        return ((Tq)object).b((List)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static hN \ufeb5\ufe99\u0635\ufead(Object object) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() <= 0) return null;
        return ((kb_0)object).tF();
    }

    public static int \ufeb5\ufead\u0638\u062f() {
        return 0xFFFFFCBE ^ \u062a\u0635\ufeb1\u0642.\ufebd\ufea1\u0631\ufea5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufebd\ufead\u0646\ufeed() {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() <= 0) return false;
        return Cloud_quark.tF;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufec1\u0648\ufee1\u0636(Object object, Object object2) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() > 0) return false;
        return ((ArrayList)object).remove(object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec1\ufebd\u0643\u0641(Object object, Object object2) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return null;
        return eY.yq((String)object, (String)object2);
    }

    public static String \ufec9\u0636\ufeed\u064a(short[] sArray, int n2, int n3, int n4) {
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
    public static boolean \ufec9\ufedd\ufeed\u063a(Object object) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() > 0) return false;
        return ((dl_0)object).Nl();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Collection \ufed5\u0644\u0634\ufeaf(Object collection) {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() >= 0) return null;
        return ((LinkedHashMap)((Object)collection)).values();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufedd\u0639\u0647\ufee1(Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() <= 0) return null;
        return ((aj_0)object).N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufef1\u0643\u0639\u0632(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() >= 0) return null;
        return ((H7)object).M();
    }
}

