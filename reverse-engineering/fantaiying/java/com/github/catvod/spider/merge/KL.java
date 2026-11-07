/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.w4;

public final class KL
implements Runnable {
    public static final KL N;
    public static final KL SN;
    public final int yq;

    static {
        SN = new KL(0);
        N = new KL(1);
    }

    public /* synthetic */ KL(int n2) {
        this.yq = n2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                int n2 = ProxyOrigin.Gc;
                StringBuilder stringBuilder = oi_0.yq("http://127.0.0.1:9978/action?do=refresh&type=danmaku&path=");
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(ProxyOrigin.getOwnProxyUrl());
                stringBuilder2.append("proxy?do=noDanmu");
                stringBuilder.append(ME.b(stringBuilder2.toString()));
                Bo.q(stringBuilder.toString());
                return;
            }
        }
        int n3 = ProxyOrigin.Gc;
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

