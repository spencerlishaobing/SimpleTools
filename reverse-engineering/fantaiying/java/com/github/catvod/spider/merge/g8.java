/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.function.Supplier;

public final class g8
implements Supplier {
    public final Object[] SN;
    public final String yq;

    public /* synthetic */ g8(String string, Object[] objectArray) {
        this.yq = string;
        this.SN = objectArray;
    }

    public final Object get() {
        return String.format(this.yq, this.SN);
    }
}

