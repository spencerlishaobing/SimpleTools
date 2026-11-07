/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.DO;
import com.github.catvod.spider.merge.Is;
import com.github.catvod.spider.merge.Lv;
import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.eY;
import com.github.catvod.spider.merge.fh;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.mg_1;
import com.github.catvod.spider.merge.q2;
import com.github.catvod.spider.merge.zh_0;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Nh
implements Is {
    public static final Nh yq = new Nh();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean B(String stringArray) {
        boolean bl;
        boolean bl2;
        block7: {
            block5: {
                int n2;
                block6: {
                    block4: {
                        String[] stringArray2;
                        bl2 = Nh.q((String)stringArray);
                        bl = false;
                        if (bl2) return true;
                        if (stringArray == null || stringArray.isEmpty() || (stringArray2 = stringArray.split(":")).length != 2) break block4;
                        try {
                            n2 = Integer.parseInt(stringArray2[1]);
                            if (n2 < 1 || n2 > 65535) break block4;
                        }
                        catch (NumberFormatException numberFormatException) {}
                        bl2 = Nh.q(stringArray2[0]);
                        break block6;
                    }
                    bl2 = false;
                }
                if (bl2) return true;
                if (Nh.G((String)stringArray)) return true;
                if (stringArray == null || stringArray.isEmpty() || (stringArray = stringArray.split(":")).length != 2) break block5;
                try {
                    n2 = Integer.parseInt(stringArray[1]);
                    if (n2 < 1 || n2 > 65535) break block5;
                }
                catch (NumberFormatException numberFormatException) {}
                bl2 = Nh.G(stringArray[0]);
                break block7;
            }
            bl2 = false;
        }
        if (!bl2) return bl;
        return true;
    }

    private static Throwable F5(Throwable throwable) {
        String string = Nh.class.getName();
        StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
        int n2 = stackTraceElementArray.length;
        int n3 = -1;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string.equals(stackTraceElementArray[i2].getClassName())) continue;
            n3 = i2;
        }
        throwable.setStackTrace(Arrays.copyOfRange(stackTraceElementArray, n3 + 1, n2));
        return throwable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean G(String string2) {
        if (string2 == null) return false;
        if (string2.isEmpty()) {
            return false;
        }
        String[] stringArray = string2.split("\\.");
        if (stringArray.length != 4) {
            return false;
        }
        int n2 = stringArray.length;
        int n3 = 0;
        while (n3 < n2) {
            string2 = stringArray[n3];
            try {
                int n22 = Integer.parseInt(string2);
                if (n22 < 0) return false;
                if (n22 > 255) {
                    return false;
                }
                boolean bl = String.valueOf(n22).equals(string2);
                if (!bl) {
                    return false;
                }
                ++n3;
            }
            catch (NumberFormatException numberFormatException) {
                return false;
            }
        }
        return true;
    }

    private static String G4(String string) {
        StringBuilder stringBuilder;
        boolean bl = string.startsWith("_");
        boolean bl2 = true;
        String string2 = string;
        if (bl) {
            string2 = string.substring(1);
        }
        string = string2;
        if (string2.startsWith("-")) {
            string = string2.substring(1);
        }
        string2 = string;
        if (string.startsWith("-")) {
            string2 = string.substring(1);
        }
        boolean bl3 = string2.contains("HDR") || string2.contains("hdr") || string2.contains("\u5e27") || string2.contains("\u9ad8\u7801") || string2.contains("FPS") || string2.contains("fps") || string2.contains("DV") || string2.contains("\u675c\u6bd4");
        if (bl3) {
            stringBuilder = new StringBuilder();
            string = "3K";
        } else {
            bl3 = bl2;
            if (!string2.contains("4K")) {
                bl3 = bl2;
                if (!string2.contains("4k")) {
                    bl3 = string2.contains("2160") ? bl2 : false;
                }
            }
            stringBuilder = new StringBuilder();
            string = bl3 ? "1K" : "2K";
        }
        return k_0.i(stringBuilder, string, string2);
    }

    public static int KJ(hN hN2, af_1 af_12) {
        Iterator iterator = ((AbstractCollection)hN2.L().J()).iterator();
        int n2 = 1;
        while (iterator.hasNext()) {
            hN hN3 = (hN)iterator.next();
            if (!hN2.tl().equals(hN3.tl()) || !((AbstractCollection)af_12.yq()).contains(hN3)) continue;
            boolean bl = hN2 == hN3;
            if (bl) break;
            ++n2;
        }
        return n2;
    }

    public static kb_0 M(hN hN2) {
        kb_0 kb_02 = new kb_0();
        while ((hN2 = hN2.o()) != null) {
            ((AbstractCollection)kb_02).add(hN2);
        }
        if (((AbstractCollection)kb_02).size() > 0) {
            return kb_02;
        }
        return null;
    }

    public static void N(Object object, String string) {
        if (object != null) {
            return;
        }
        object = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Nh.F5((Throwable)object);
        throw object;
    }

    public static void SN(Object object) {
        if (object != null) {
            return;
        }
        object = new NullPointerException();
        Nh.F5((Throwable)object);
        throw object;
    }

    public static void W(hN hN2, int n2) {
        hN2.V("EL_SAME_TAG_ALL_NUM", String.valueOf(n2));
    }

    public static kb_0 dT(hN hN2) {
        kb_0 kb_02 = new kb_0();
        while ((hN2 = hN2.u7()) != null) {
            ((AbstractCollection)kb_02).add(hN2);
        }
        if (((AbstractCollection)kb_02).size() > 0) {
            return kb_02;
        }
        return null;
    }

    public static int i(int n2, int n3) {
        n2 = n2 < n3 ? -1 : (n2 == n3 ? 0 : 1);
        return n2;
    }

    public static boolean q(String string) {
        if (string != null && !string.isEmpty()) {
            if (Pattern.matches("^([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,}$", string)) {
                return true;
            }
            return Pattern.matches("^[a-zA-Z0-9\\-]+$", string);
        }
        return false;
    }

    public static int t0(String iterator, String object) {
        iterator = Nh.G4((String)((Object)iterator));
        object = Nh.G4((String)object);
        iterator = Nh.v((String)((Object)iterator));
        object = Nh.v((String)object);
        iterator = ((ArrayList)((Object)iterator)).iterator();
        Iterator iterator2 = ((ArrayList)object).iterator();
        while (iterator.hasNext() && iterator2.hasNext()) {
            int n2;
            object = (String)iterator.next();
            String string = (String)iterator2.next();
            if (((String)object).matches("\\d+") && string.matches("\\d+")) {
                int n3;
                n2 = Integer.parseInt((String)object);
                if (n2 == (n3 = Integer.parseInt(string))) continue;
                return Integer.compare(n2, n3);
            }
            n2 = ((String)object).compareTo(string);
            if (n2 == 0) continue;
            return n2;
        }
        if (iterator.hasNext()) {
            return 1;
        }
        if (iterator2.hasNext()) {
            return -1;
        }
        return 0;
    }

    public static void tF(Object object, String string) {
        if (object != null) {
            return;
        }
        object = new NullPointerException(eY.yq(string, " must not be null"));
        Nh.F5((Throwable)object);
        throw object;
    }

    private static List v(String object) {
        ArrayList<String> arrayList = new ArrayList<String>();
        object = Pattern.compile("(\\d+)|[^\\d]+").matcher((CharSequence)object);
        while (((Matcher)object).find()) {
            arrayList.add(((Matcher)object).group());
        }
        return arrayList;
    }

    public static void v3(hN hN2, int n2) {
        hN2.V("EL_SAME_TAG_INDEX", String.valueOf(n2));
    }

    public static boolean yq(Object object, Object object2) {
        boolean bl = object == null ? object2 == null : object.equals(object2);
        return bl;
    }

    public static void zH(Object object, String string) {
        if (object != null) {
            return;
        }
        object = Thread.currentThread().getStackTrace()[4];
        object = zh_0.N("Parameter specified as non-null is null: method ", ((StackTraceElement)object).getClassName(), ".", ((StackTraceElement)object).getMethodName(), ", parameter ");
        ((StringBuilder)object).append(string);
        object = new NullPointerException(((StringBuilder)object).toString());
        Nh.F5((Throwable)object);
        throw object;
    }

    public DO Gc(mg_1 serializable, int n2, String string, int n3, int n4, int n5, int n7, int n8) {
        serializable = new Lv((mg_1<fh, q2>)serializable, n2, n3, n4, n5);
        ((Lv)serializable).SN = n7;
        ((Lv)serializable).N = n8;
        if (string != null) {
            ((Lv)serializable).i = string;
        }
        return serializable;
    }
}

