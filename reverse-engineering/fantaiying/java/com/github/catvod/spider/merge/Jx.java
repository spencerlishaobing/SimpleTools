/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.Bili;

public final class Jx
implements Runnable {
    public final Bili SN;
    public final int yq;

    public /* synthetic */ Jx(Bili bili, int n2) {
        this.yq = n2;
        this.SN = bili;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                Bili.G(this.SN);
                return;
            }
        }
        Bili.F5(this.SN);
    }
}

