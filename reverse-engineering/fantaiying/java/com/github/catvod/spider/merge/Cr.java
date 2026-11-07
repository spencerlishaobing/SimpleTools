/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.cp;
import com.github.catvod.spider.merge.mt_0;

public final class Cr {
    public static /* synthetic */ String N(int n) {
        if (n == 1) {
            return "r";
        }
        if (n == 2) {
            return "rw";
        }
        throw null;
    }

    public static /* synthetic */ int SN(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 8;
        }
        if (n == 3) {
            return 99;
        }
        throw null;
    }

    public static /* synthetic */ String tF(Iterable object) {
        StringBuilder stringBuilder = new StringBuilder();
        if ((object = object.iterator()).hasNext()) {
            while (true) {
                stringBuilder.append((CharSequence)object.next());
                if (!object.hasNext()) break;
                stringBuilder.append((CharSequence)"#");
            }
        }
        return stringBuilder.toString();
    }

    public static int yq(int n) {
        for (int n2 : cp.N(3)) {
            if (Cr.SN(n2) != n) continue;
            return n2;
        }
        mt_0 mt_02 = new mt_0("Unknown compression method", 4);
        throw mt_02;
    }
}

