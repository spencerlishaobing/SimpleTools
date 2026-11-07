/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.i3;

public final class xa
implements Runnable {
    public final i3 SN;
    public final int yq;

    public /* synthetic */ xa(i3 i32, int n2) {
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
                i3.q(this.SN);
                return;
            }
        }
        i3.B(this.SN);
    }
}

