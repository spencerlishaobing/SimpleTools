/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.xu_0;
import java.util.HashMap;
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.i
 */
public final class i_0
implements Runnable {
    public final int Gc;
    public final String N;
    public final dl_0 SN;
    public final HashMap i;
    public final List t0;
    public final String tF;
    public final xu_0 yq;
    public final List zH;

    public /* synthetic */ i_0(xu_0 xu_02, dl_0 dl_02, String string, String string2, List list, HashMap hashMap, List list2, int n2) {
        this.yq = xu_02;
        this.SN = dl_02;
        this.N = string;
        this.tF = string2;
        this.zH = list;
        this.i = hashMap;
        this.t0 = list2;
        this.Gc = n2;
    }

    @Override
    public final void run() {
        xu_0.SN(this.yq, this.SN, this.N, this.tF, this.zH, this.i, this.t0, this.Gc);
    }
}

