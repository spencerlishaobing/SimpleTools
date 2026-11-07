/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.DO;
import com.github.catvod.spider.merge.Tu;
import com.github.catvod.spider.merge.ei_0;
import com.github.catvod.spider.merge.fU;
import com.github.catvod.spider.merge.lC;

public final class T9
extends fU {
    private final DO i;

    public T9(Tu tu) {
        lC lC2 = tu.zH;
        DO dO = tu.dT();
        DO dO2 = tu.dT();
        super(tu, lC2, tu.t0);
        this.i = dO;
        this.zH(dO2);
    }

    public T9(Tu tu, lC lC2, DO dO, DO dO2, ei_0 ei_02) {
        super(tu, lC2, ei_02);
        this.i = dO;
        this.zH(dO2);
    }

    public final DO i() {
        return this.i;
    }
}

