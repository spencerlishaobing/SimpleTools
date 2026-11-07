/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.OB;
import com.github.catvod.spider.merge.j;
import com.github.catvod.spider.merge.oi_0;

public final class Wt
extends OB {
    public final int N;
    public final int SN;
    public final boolean tF;

    public Wt(j j3, int n2, int n3, boolean bl) {
        super(j3);
        this.SN = n2;
        this.N = n3;
        this.tF = bl;
    }

    @Override
    public final boolean SN() {
        return true;
    }

    @Override
    public final boolean tF(int n2, int n3) {
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = oi_0.yq("pred_");
        stringBuilder.append(this.SN);
        stringBuilder.append(":");
        stringBuilder.append(this.N);
        return stringBuilder.toString();
    }

    @Override
    public final int yq() {
        return 4;
    }
}

