/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.w4;
import java.util.concurrent.Callable;

public final class kY
implements Callable {
    public final String N;
    public final String SN;
    public final w4 yq;

    public /* synthetic */ kY(w4 w42, String string, String string2) {
        this.yq = w42;
        this.SN = string;
        this.N = string2;
    }

    public final Object call() {
        return w4.zH(this.yq, this.SN, this.N);
    }
}

