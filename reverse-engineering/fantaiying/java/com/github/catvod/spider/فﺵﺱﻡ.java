/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.net.Uri
 *  android.widget.TextView
 */
package com.github.catvod.spider;

import android.app.Activity;
import android.net.Uri;
import android.widget.TextView;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.spider.Cloud_uc;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Ah;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.RT;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.X0;
import com.github.catvod.spider.merge.Yx;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.hm;
import com.github.catvod.spider.merge.lm;
import com.github.catvod.spider.merge.p7;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.ts_0;
import com.github.catvod.spider.merge.uA;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class \u0641\ufeb5\ufeb1\ufee1 {
    public static int \u0646\u0633\u0647\u062b = -674;

    public static void \u0627\u0639\ufeb9\u062c(Object object, Object object2) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() <= 0) {
            ((TextView)object).setText((CharSequence)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062c\ufecd\u062b\ufed9(Object object) {
        if (\ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5() < 0) return null;
        return ((RT)object).yq;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062e\ufee9\u0635\u0632(Object object) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() >= 0) return null;
        return ((ts_0)object).M();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0630\u0648\u0628\ufea1(String object) {
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
    public static boolean \u0634\u0639\u0631\ufe8f(Object object, Object object2) {
        if (\ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1() <= 0) return false;
        return ((Pan)((Object)object)).isAli((String)object2);
    }

    public static String \u0639\u0630\ufeaf\ufe95(short[] sArray, int n2, int n3, int n4) {
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
    public static String \u063a\u0644\u0641\u0631(Object object, Object object2, Object object3) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() > 0) return null;
        return ((N0)object).Nl((tX)object2, (File)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0641\u0642\u0639\u0643(Object object, Object object2) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() > 0) return null;
        return Tq.xa((List)object, (List)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0641\ufeaf\ufec5\ufea1() {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return false;
        return Cloud_uc.tF;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Activity \u0642\ufee1\u0637\u0648() {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return InitOrigin.getActivity();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u0643\ufead\u0642\ufea5(Object object, Object object2, int n2, int n3) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() >= 0) return 0;
        return ((InputStream)object).read((byte[])object2, n2, n3);
    }

    public static int \u0644\u0630\ufeb1\ufead() {
        return 0xFFFFFD63 ^ \ufea9\u0643\u062d\u063a.\ufeaf\ufeb1\ufec1\ufeab;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0644\u0646\ufeb5\ufec5() {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() >= 0) return null;
        return uA.tF;
    }

    public static void \u0644\ufeb9\ufee1\ufeab(Object object, Object object2) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() > 0) {
            ((hm)object).B((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0645\u0637\ufe95\ufec1(Object object) {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() >= 0) return null;
        return ((ts_0)object).q();
    }

    public static void \u0646\u062e\u0640\ufed5(Object object) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() <= 0) {
            ((ReentrantLock)object).lock();
        }
    }

    public static void \u0648\ufec9\ufef1\u062a(Object object, Object object2) {
        if (\ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647() <= 0) {
            ((tX)object).g((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufe8f\u062d\u0643\ufed9(Object object, Object object2) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() >= 0) return 0;
        return ((InputStream)object).read((byte[])object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static X0 \ufea5\ufeed\u0633\u0632(Object object) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() > 0) return null;
        return ((X0)object).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeaf\u062c\u0643\ufec5(Object object) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() < 0) return null;
        return ((dl_0)object).M();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Throwable \ufeb9\u0633\u064a\u062a(Object object) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() > 0) return null;
        return ((Throwable)object).getCause();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long \ufebd\ufe99\ufef1\u0643(Object object) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return 0L;
        return ((Yx)object).N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec1\ufed5\ufe99\ufea9() {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() <= 0) return null;
        return "\u5df2\u542f\u52a8\u5916\u7f6ewebDav\u64ad\u653e\u5668\u64ad\u653e";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Set \ufec5\u0630\u062c\u0643(Object set) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() <= 0) return null;
        return ((HashMap)((Object)set)).entrySet();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufec5\u064a\ufeb1\u062c(Object object, int n2, Object object2) {
        if (\u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a() > 0) return null;
        return ((ArrayList)object).set(n2, object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec9\u0634\ufed5\ufea1(Object object) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return null;
        return ((dl_0)object).B();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufec9\ufeab\ufed5\ufec5(Object object, int n2, Object object2) {
        if (\u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9() > 0) return null;
        return ((List)object).set(n2, object2);
    }

    public static int \ufed5\ufe8e\u0640\ufed9(Object object) {
        return object.hashCode();
    }

    public static void \ufed5\ufeb9\ufe99\ufea5(Object object, Object object2) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() < 0) {
            p7.i((String)object, object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufedd\u0630\u0636\u0647(Object object) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() >= 0) return null;
        return Objects.requireNonNull(object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Ef \ufedd\u0631\ufea9\ufec5(Object object, Object object2) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() <= 0) return null;
        return ((lm)object).G((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufedd\ufec5\ufea9\u0632() {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() < 0) return null;
        return "\u4f18\u6c50\u76d8";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufee1\ufeb1\u0638\u0644(Object object) {
        if (\ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647() >= 0) return null;
        return ((Ah)object).getResult();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufeed\u063a\u0647\ufe8e(Object object) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() > 0) return 0;
        return ((Uri)object).getPort();
    }
}

