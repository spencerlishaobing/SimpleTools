/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.i3;

/*
 * Renamed from com.github.catvod.spider.merge.my
 */
public final class my_0
implements Runnable {
    public static final my_0 N;
    public static final my_0 SN;
    public final int yq;

    static {
        SN = new my_0(0);
        N = new my_0(1);
    }

    public /* synthetic */ my_0(int n2) {
        this.yq = n2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                i3.s().cS();
                return;
            }
        }
        ProxyOrigin.t0();
    }
}

