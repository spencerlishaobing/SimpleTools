/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.xu_0;

public final class ej
implements Runnable {
    public static final ej N;
    public static final ej SN;
    public final int yq;

    static {
        SN = new ej(0);
        N = new ej(1);
    }

    public /* synthetic */ ej(int n2) {
        this.yq = n2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                xu_0.xa().p();
                return;
            }
        }
        ProxyOrigin.zH();
    }
}

