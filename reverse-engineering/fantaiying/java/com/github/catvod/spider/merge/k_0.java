/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.cp;

/*
 * Renamed from com.github.catvod.spider.merge.k
 */
public final class k_0 {
    public static /* synthetic */ int N(int n2) {
        if (n2 == 1) {
            return 16;
        }
        if (n2 == 2) {
            return 24;
        }
        if (n2 == 3) {
            return 32;
        }
        throw null;
    }

    public static /* synthetic */ int SN(int n2) {
        if (n2 == 1) {
            return 16;
        }
        if (n2 == 2) {
            return 24;
        }
        if (n2 == 3) {
            return 32;
        }
        throw null;
    }

    public static String i(StringBuilder stringBuilder, String string, String string2) {
        stringBuilder.append(string);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static void t0(StringBuilder stringBuilder, String string, String string2, String string3, String string4) {
        stringBuilder.append(string);
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(string4);
    }

    public static /* synthetic */ int tF(int n2) {
        if (n2 == 1) {
            return 1;
        }
        if (n2 == 2) {
            return 2;
        }
        if (n2 == 3) {
            return 3;
        }
        throw null;
    }

    public static int yq(int n2) {
        for (int n3 : cp.N(3)) {
            if (k_0.tF(n3) != n2) continue;
            return n3;
        }
        return 0;
    }

    public static /* synthetic */ int zH(int n2) {
        if (n2 == 1) {
            return 8;
        }
        if (n2 == 2) {
            return 12;
        }
        if (n2 == 3) {
            return 16;
        }
        throw null;
    }
}

