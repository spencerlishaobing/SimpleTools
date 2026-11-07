/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.N0;

public final class x3
implements Runnable {
    public static final x3 N;
    public static final x3 SN;
    public final int yq;

    static {
        SN = new x3(0);
        N = new x3(1);
    }

    public /* synthetic */ x3(int n2) {
        this.yq = n2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                N0.Zm().x();
                return;
            }
        }
        ProxyOrigin.i();
    }
}

