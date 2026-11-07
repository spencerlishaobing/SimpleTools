/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.ew_0;

public final class xT
implements Runnable {
    public final int SN;
    public final ew_0 yq;

    public /* synthetic */ xT(ew_0 ew_02, int n2) {
        this.yq = ew_02;
        this.SN = n2;
    }

    @Override
    public final void run() {
        ew_0.N(this.yq, this.SN);
    }
}

