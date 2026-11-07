/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.N0;

public final class G4
implements Runnable {
    public final N0 SN;
    public final int yq;

    public /* synthetic */ G4(N0 n0, int n2) {
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
                N0.F5(this.SN);
                return;
            }
        }
        N0.M(this.SN);
    }
}

