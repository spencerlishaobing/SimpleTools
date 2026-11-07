/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.QB;
import com.github.catvod.spider.merge.oi_0;

public final class jA
implements Runnable {
    public static final jA N;
    public static final jA SN;
    public final int yq;

    static {
        SN = new jA(0);
        N = new jA(1);
    }

    public /* synthetic */ jA(int n2) {
        this.yq = n2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                StringBuilder stringBuilder = oi_0.yq("http://127.0.0.1:");
                stringBuilder.append(QB.B);
                stringBuilder.append("/shutdown");
                Bo.q(stringBuilder.toString());
                return;
            }
        }
        ProxyOrigin.tF();
    }
}

