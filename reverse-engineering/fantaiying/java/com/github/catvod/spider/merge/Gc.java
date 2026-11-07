/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.xu_0;

public final class Gc
implements Runnable {
    public final String N;
    public final String SN;
    public final long tF;
    public final xu_0 yq;

    public /* synthetic */ Gc(xu_0 xu_02, String string, String string2, long l) {
        this.yq = xu_02;
        this.SN = string;
        this.N = string2;
        this.tF = l;
    }

    @Override
    public final void run() {
        xu_0.i(this.yq, this.SN, this.N, this.tF);
    }
}

