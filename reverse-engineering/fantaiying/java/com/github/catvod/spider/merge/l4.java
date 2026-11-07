/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.k6;

public final class l4 {
    public static final l4 N = new l4(false, false);
    public static final l4 tF = new l4(true, true);
    private final boolean SN;
    private final boolean yq;

    public l4(boolean bl, boolean bl2) {
        this.yq = bl;
        this.SN = bl2;
    }

    static String yq(String string) {
        return U7.M(string.trim());
    }

    final k6 N(k6 k62) {
        if (k62 != null && !this.SN) {
            k62.g9();
        }
        return k62;
    }

    public final String SN(String string) {
        String string2;
        string = string2 = string.trim();
        if (!this.SN) {
            string = U7.M(string2);
        }
        return string;
    }

    public final boolean i() {
        return this.yq;
    }

    public final String tF(String string) {
        String string2;
        string = string2 = string.trim();
        if (!this.yq) {
            string = U7.M(string2);
        }
        return string;
    }

    public final boolean zH() {
        return this.SN;
    }
}

