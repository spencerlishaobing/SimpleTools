/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.RH;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.oi_0;
import java.util.AbstractCollection;

/*
 * Renamed from com.github.catvod.spider.merge.aF
 */
public final class af_1 {
    private af_1 N;
    private boolean SN = false;
    private kb_0 yq;

    private af_1(hN hN2) {
        kb_0 kb_02;
        this.yq = kb_02 = new kb_0();
        ((AbstractCollection)kb_02).add(hN2);
    }

    private af_1(kb_0 kb_02) {
        kb_0 kb_03;
        this.yq = kb_03 = new kb_0();
        ((AbstractCollection)kb_03).addAll(kb_02);
    }

    public static af_1 N(kb_0 kb_02) {
        return new af_1(kb_02);
    }

    public static af_1 SN(hN hN2) {
        return new af_1(hN2);
    }

    public static af_1 tF(af_1 af_12) {
        af_1 af_13 = new af_1(af_12.yq);
        af_13.N = af_12;
        return af_13;
    }

    final void Gc() {
        this.SN = true;
    }

    public final af_1 KJ(af_1 af_12) {
        this.N = af_12;
        return this;
    }

    public final void M(kb_0 kb_02) {
        this.yq = kb_02;
    }

    public final boolean i() {
        return this.SN;
    }

    public final hN q() {
        if (((AbstractCollection)this.yq).size() == 1) {
            return this.yq.tF();
        }
        StringBuilder stringBuilder = oi_0.yq("current context is more than one el,total = ");
        stringBuilder.append(((AbstractCollection)this.yq).size());
        throw new RH(stringBuilder.toString());
    }

    public final void t0() {
        this.SN = false;
    }

    public final kb_0 yq() {
        return this.yq;
    }

    public final af_1 zH() {
        return this.N;
    }
}

