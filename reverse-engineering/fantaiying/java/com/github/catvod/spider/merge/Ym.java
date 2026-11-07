/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.YW;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.k6;
import com.github.catvod.spider.merge.kb_0;
import java.util.AbstractCollection;

public final class Ym
extends hN {
    private final kb_0 KJ = new kb_0();

    public Ym(YW yW, k6 k62) {
        super(yW, null, k62);
    }

    public final Ym OT(hN hN2) {
        ((AbstractCollection)this.KJ).add(hN2);
        return this;
    }

    @Override
    protected final void n(iK iK2) {
        super.n(iK2);
        ((AbstractCollection)this.KJ).remove(iK2);
    }

    public final Ym z() {
        return (Ym)super.i3();
    }
}

