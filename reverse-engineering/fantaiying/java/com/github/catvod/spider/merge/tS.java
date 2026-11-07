/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.DexNative;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.w4;

public final class tS
implements Runnable {
    public static final tS N;
    public static final tS SN;
    public final int yq;

    static {
        SN = new tS(0);
        N = new tS(1);
    }

    public /* synthetic */ tS(int n2) {
        this.yq = n2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                DexNative.danmuStart();
                return;
            }
        }
        int n2 = ProxyOrigin.Gc;
        try {
            w4 w42 = new w4(Tq.ee, "push");
            w42.g1();
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}

