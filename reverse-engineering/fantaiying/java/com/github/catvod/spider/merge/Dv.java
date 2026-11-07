/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.zg;

public final class Dv
extends zg {
    public Dv(String string) {
        this.tF = string;
    }

    @Override
    public final iK B() {
        return this;
    }

    @Override
    final void Gd(Appendable appendable, int n2, Va.yq yq2) {
    }

    @Override
    public final iK M() {
        return (Dv)super.M();
    }

    @Override
    public final Object clone() {
        return (Dv)super.M();
    }

    @Override
    public final String toString() {
        return this.ee();
    }

    @Override
    public final String v() {
        return "#data";
    }

    @Override
    final void xa(Appendable appendable, int n2, Va.yq yq2) {
        appendable.append(this.H());
    }
}

