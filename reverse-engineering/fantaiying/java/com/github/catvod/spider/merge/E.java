/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.Bili;

public final class E
implements Runnable {
    public final String SN;
    public final Bili yq;

    public /* synthetic */ E(Bili bili, String string) {
        this.yq = bili;
        this.SN = string;
    }

    @Override
    public final void run() {
        Bili.B(this.yq, this.SN);
    }
}

