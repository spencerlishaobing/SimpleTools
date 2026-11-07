/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.zg;

public final class eb
extends zg {
    public eb(String string) {
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
        return (eb)super.M();
    }

    @Override
    public final Object clone() {
        return (eb)super.M();
    }

    @Override
    public final String toString() {
        return this.ee();
    }

    @Override
    public final String v() {
        return "#comment";
    }

    @Override
    final void xa(Appendable appendable, int n2, Va.yq yq2) {
        iK iK2;
        if (yq2.t0() && this.SN == 0 && (iK2 = this.yq) instanceof hN && ((hN)iK2).I().yq()) {
            this.v3(appendable, n2, yq2);
        }
        appendable.append("<!--").append(this.H()).append("-->");
    }
}

