/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.DO;
import com.github.catvod.spider.merge.HL;
import com.github.catvod.spider.merge.VQ;
import com.github.catvod.spider.merge.aq;
import com.github.catvod.spider.merge.ei_0;

public class fU
extends RuntimeException {
    private final HL N;
    private final ei_0 SN;
    private DO tF;
    private final VQ<?, ?> yq;
    private int zH = -1;

    public fU(VQ<?, ?> vQ, HL hL, ei_0 ei_02) {
        this.yq = vQ;
        this.N = hL;
        this.SN = ei_02;
        if (vQ != null) {
            this.zH = vQ.t0();
        }
    }

    public final DO N() {
        return this.tF;
    }

    public final HL SN() {
        return this.N;
    }

    protected final void tF(int n) {
        this.zH = n;
    }

    public final aq yq() {
        VQ<?, ?> vQ = this.yq;
        if (vQ != null) {
            return vQ.tF().N(this.zH, this.SN);
        }
        return null;
    }

    protected final void zH(DO dO) {
        this.tF = dO;
    }
}

