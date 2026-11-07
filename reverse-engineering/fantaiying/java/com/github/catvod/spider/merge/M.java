/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.xu_0;

public final class M
implements Runnable {
    public final String N;
    public final byte[] SN;
    public final String tF;
    public final xu_0 yq;
    public final long zH;

    public /* synthetic */ M(xu_0 xu_02, byte[] byArray, String string, String string2, long l) {
        this.yq = xu_02;
        this.SN = byArray;
        this.N = string;
        this.tF = string2;
        this.zH = l;
    }

    @Override
    public final void run() {
        xu_0.zH(this.yq, this.SN, this.N, this.tF, this.zH);
    }
}

