/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.cp;

/*
 * Renamed from com.github.catvod.spider.merge.RQ
 */
public final class rq_0 {
    public static String N(String string, long l) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(l);
        return stringBuilder.toString();
    }

    public static /* synthetic */ int SN(int n2) {
        if (n2 == 1) {
            return 1;
        }
        if (n2 == 2) {
            return 2;
        }
        throw null;
    }

    public static int yq(int n2) {
        for (int n3 : cp.N(2)) {
            if (rq_0.SN(n3) != n2) continue;
            return n3;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported Aes version");
        throw illegalArgumentException;
    }
}

