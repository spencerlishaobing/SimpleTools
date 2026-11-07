/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.fo_0;
import com.github.catvod.spider.merge.hy;

/*
 * Renamed from com.github.catvod.spider.merge.tl
 */
public final class tl_0
implements Runnable {
    public final hy SN;
    public final fo_0 yq;

    public /* synthetic */ tl_0(fo_0 fo_02, hy hy2) {
        this.yq = fo_02;
        this.SN = hy2;
    }

    @Override
    public final void run() {
        fo_0.b(this.yq, this.SN);
    }
}

