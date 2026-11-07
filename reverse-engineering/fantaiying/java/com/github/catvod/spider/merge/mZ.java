/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.OB;
import com.github.catvod.spider.merge.j;

public final class mZ
extends OB {
    public final int SN;

    public mZ(j j3, int n2) {
        super(j3);
        this.SN = n2;
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.SN);
        stringBuilder.append(" >= _p");
        return stringBuilder.toString();
    }

    @Override
    public final int yq() {
        return 10;
    }
}

