/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Yv;
import com.github.catvod.spider.merge.aq;
import com.github.catvod.spider.merge.j;

public final class fx
extends Yv {
    public final int SN;

    public fx(j j3, int n2) {
        super(j3);
        this.SN = n2;
    }

    @Override
    public final aq N() {
        int n2 = this.SN;
        aq aq2 = new aq(new int[0]);
        aq2.yq(n2);
        return aq2;
    }

    @Override
    public final boolean tF(int n2, int n3) {
        boolean bl = this.SN == n2;
        return bl;
    }

    public final String toString() {
        return String.valueOf(this.SN);
    }

    @Override
    public final int yq() {
        return 5;
    }
}

