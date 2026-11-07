/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Q4;
import com.github.catvod.spider.merge.QY;
import com.github.catvod.spider.merge.Tu;
import com.github.catvod.spider.merge.VQ;
import com.github.catvod.spider.merge.fU;
import com.github.catvod.spider.merge.tF;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public final class rg
implements tF {
    private final Collection<? extends tF> yq;

    public rg(Collection<? extends tF> collection) {
        Objects.requireNonNull(collection, "delegates");
        this.yq = collection;
    }

    @Override
    public final void N(Tu tu, QY qY, int n2, int n3, int n4, Q4 q4) {
        Iterator<? extends tF> iterator = this.yq.iterator();
        while (iterator.hasNext()) {
            iterator.next().N(tu, qY, n2, n3, n4, q4);
        }
    }

    @Override
    public final void SN(Tu tu, QY qY, int n2, int n3, BitSet bitSet, Q4 q4) {
        Iterator<? extends tF> iterator = this.yq.iterator();
        while (iterator.hasNext()) {
            iterator.next().SN(tu, qY, n2, n3, bitSet, q4);
        }
    }

    @Override
    public final void tF(Tu tu, QY qY, int n2, int n3, BitSet bitSet, Q4 q4) {
        Iterator<? extends tF> iterator = this.yq.iterator();
        while (iterator.hasNext()) {
            iterator.next().tF(tu, qY, n2, n3, bitSet, q4);
        }
    }

    @Override
    public final void yq(VQ<?, ?> vQ, Object object, int n2, int n3, String string, fU fU2) {
        Iterator<? extends tF> iterator = this.yq.iterator();
        while (iterator.hasNext()) {
            iterator.next().yq(vQ, object, n2, n3, string, fU2);
        }
    }
}

