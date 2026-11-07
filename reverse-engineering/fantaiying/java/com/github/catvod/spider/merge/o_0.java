/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.fk;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;

/*
 * Renamed from com.github.catvod.spider.merge.O
 */
public final class o_0
implements Runnable {
    public final Object SN;
    public final int yq;

    public /* synthetic */ o_0(Object object, int n2) {
        this.yq = n2;
        this.SN = object;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 2: {
                i3.KJ((i3)this.SN);
                return;
            }
            case 1: {
                N0.dT((N0)this.SN);
                return;
            }
            case 0: {
                j_0.i((j_0)this.SN);
                return;
            }
        }
        fk.N((fk)this.SN);
    }
}

