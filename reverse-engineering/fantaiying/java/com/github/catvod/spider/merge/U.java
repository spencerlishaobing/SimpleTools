/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.n6;
import java.util.List;

public final class U
implements Runnable {
    public final List Gc;
    public final String N;
    public final int SN;
    public final List i;
    public final List t0;
    public final String tF;
    public final j_0 yq;
    public final n6 zH;

    public /* synthetic */ U(j_0 j_02, int n2, String string, String string2, n6 n62, List list, List list2, List list3) {
        this.yq = j_02;
        this.SN = n2;
        this.N = string;
        this.tF = string2;
        this.zH = n62;
        this.i = list;
        this.t0 = list2;
        this.Gc = list3;
    }

    @Override
    public final void run() {
        j_0.zH(this.yq, this.SN, this.N, this.tF, this.zH, this.i, this.t0, this.Gc);
    }
}

