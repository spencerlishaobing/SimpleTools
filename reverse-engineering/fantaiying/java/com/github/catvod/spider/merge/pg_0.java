/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.KL;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.oi_0;

/*
 * Renamed from com.github.catvod.spider.merge.pg
 */
public final class pg_0
implements Runnable {
    public static final pg_0 N;
    public static final pg_0 SN;
    public static final pg_0 tF;
    public final int yq;

    static {
        SN = new pg_0(0);
        N = new pg_0(1);
        tF = new pg_0(2);
    }

    public /* synthetic */ pg_0(int n2) {
        this.yq = n2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 1: {
                int n2 = ProxyOrigin.Gc;
                StringBuilder stringBuilder = oi_0.yq("http://127.0.0.1:9978/action?do=refresh&type=danmaku&path=");
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(ProxyOrigin.getOwnProxyUrl());
                stringBuilder2.append("proxy?do=reLoadDanmu");
                stringBuilder.append(ME.b(stringBuilder2.toString()));
                Bo.q(stringBuilder.toString());
                return;
            }
            case 0: {
                j_0.v().i3(false, false);
                return;
            }
        }
        int n3 = ProxyOrigin.Gc;
        InitOrigin.execute(KL.N);
    }
}

