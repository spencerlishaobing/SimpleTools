/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.i3;

public final class Gd
implements Runnable {
    public final i3 SN;
    public final int yq;

    public /* synthetic */ Gd(i3 i32, int n2) {
        this.yq = n2;
        this.SN = i32;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                i3.G(this.SN);
                return;
            }
        }
        i3.t0(this.SN);
    }
}

