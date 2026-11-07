/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.N0;

public final class B
implements Runnable {
    public final N0 SN;
    public final int yq;

    public /* synthetic */ B(N0 n0, int n) {
        this.yq = n;
        this.SN = n0;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                N0.KJ(this.SN);
                return;
            }
        }
        N0.v3(this.SN);
    }
}

