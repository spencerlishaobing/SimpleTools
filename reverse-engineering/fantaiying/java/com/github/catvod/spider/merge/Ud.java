/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

public final class Ud {
    private long N;
    private long SN;
    private int yq = 1;

    public final void N() {
        this.yq = 1;
        this.SN = 0L;
        this.N = 0L;
    }

    public final void SN() {
        this.yq = 1;
    }

    public final void i(long l) {
        this.SN = l;
    }

    public final void t0(long l) {
        this.N = l = this.N + l;
        long l2 = this.SN;
        if (l2 > 0L) {
            l = l * 100L / l2;
        }
    }

    public final int tF() {
        return this.yq;
    }

    public final void yq() {
        this.yq = 1;
    }

    public final void zH() {
        this.yq = 2;
    }
}

