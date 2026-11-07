/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Yv;
import com.github.catvod.spider.merge.j;
import com.github.catvod.spider.merge.oi_0;

public final class ue
extends Yv {
    public final int N;
    public final int SN;

    public ue(j j3, int n2, int n3) {
        super(j3);
        this.SN = n2;
        this.N = n3;
    }

    @Override
    public final boolean tF(int n2, int n3) {
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = oi_0.yq("action_");
        stringBuilder.append(this.SN);
        stringBuilder.append(":");
        stringBuilder.append(this.N);
        return stringBuilder.toString();
    }

    @Override
    public final int yq() {
        return 6;
    }
}

