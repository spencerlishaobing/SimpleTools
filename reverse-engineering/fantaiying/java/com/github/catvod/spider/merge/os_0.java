/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 */
package com.github.catvod.spider.merge;

import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * Renamed from com.github.catvod.spider.merge.oS
 */
public final class os_0 {
    private static final List<String> N;
    private static final List<String> SN;
    private static final Random yq;

    static {
        yq = new Random();
        SN = Arrays.asList("25060RK16C");
        N = Arrays.asList("Xiaomi");
    }

    public static String SN() {
        boolean bl;
        Object object = Build.MODEL;
        boolean bl2 = bl = true;
        if (object != null) {
            int n2;
            block3: {
                int n3;
                int n4 = ((String)object).length();
                int n5 = 0;
                for (n2 = 0; n2 < n4; n2 += Character.charCount(n3)) {
                    n3 = ((String)object).codePointAt(n2);
                    if (Character.isWhitespace(n3)) continue;
                    n2 = n5;
                    break block3;
                }
                n2 = 1;
            }
            bl2 = n2 != 0 ? bl : ((String)object).matches(".*[^a-zA-Z0-9_\\-\\.].*");
        }
        if (bl2) {
            object = SN;
            object = (String)object.get(yq.nextInt(object.size()));
        }
        return object;
    }

    public static String yq() {
        Object object = Build.BRAND;
        if (object != null && !((String)object).trim().isEmpty()) {
            return object;
        }
        object = N;
        return (String)object.get(yq.nextInt(object.size()));
    }
}

