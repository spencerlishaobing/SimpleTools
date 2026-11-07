/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Yv;
import com.github.catvod.spider.merge.aq;
import com.github.catvod.spider.merge.j;

public final class qh
extends Yv {
    public final int N;
    public final int SN;

    public qh(j j3, int n2, int n3) {
        super(j3);
        this.SN = n2;
        this.N = n3;
    }

    @Override
    public final aq N() {
        return aq.t0(this.SN, this.N);
    }

    @Override
    public final boolean tF(int n2, int n3) {
        boolean bl = n2 >= this.SN && n2 <= this.N;
        return bl;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("'").appendCodePoint(this.SN);
        stringBuilder.append("'..'");
        stringBuilder = stringBuilder.appendCodePoint(this.N);
        stringBuilder.append("'");
        return stringBuilder.toString();
    }

    @Override
    public final int yq() {
        return 2;
    }
}

