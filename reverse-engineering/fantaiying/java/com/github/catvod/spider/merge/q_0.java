/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.N0;

/*
 * Renamed from com.github.catvod.spider.merge.q
 */
public final class q_0
implements Runnable {
    public final N0 SN;
    public final int yq;

    public /* synthetic */ q_0(N0 n0, int n2) {
        this.yq = n2;
        this.SN = n0;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                N0.SN(this.SN);
                return;
            }
        }
        N0.G(this.SN);
    }
}

