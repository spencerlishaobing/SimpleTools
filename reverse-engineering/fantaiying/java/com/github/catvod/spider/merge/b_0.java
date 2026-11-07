/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.k9;

/*
 * Renamed from com.github.catvod.spider.merge.b
 */
public final class b_0
implements Runnable {
    public final Object N;
    public final Object SN;
    public final int yq;

    public /* synthetic */ b_0(Object object, Object object2, int n2) {
        this.yq = n2;
        this.SN = object;
        this.N = object2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                j_0.t0((j_0)this.SN, (k9)this.N);
                return;
            }
        }
        i3.SN((i3)this.SN, (String)this.N);
    }
}

