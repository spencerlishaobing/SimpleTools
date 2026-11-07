/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.fo_0;
import com.github.catvod.spider.merge.hE;

/*
 * Renamed from com.github.catvod.spider.merge.Qz
 */
public final class qz_0
implements Runnable {
    public final int N;
    public final hE SN;
    public final fo_0 yq;

    public /* synthetic */ qz_0(fo_0 fo_02, hE hE2, int n2) {
        this.yq = fo_02;
        this.SN = hE2;
        this.N = n2;
    }

    @Override
    public final void run() {
        fo_0.un(this.yq, this.SN, this.N);
    }
}

