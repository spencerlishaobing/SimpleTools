/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.li;
import com.github.catvod.spider.merge.rs_0;
import java.util.NoSuchElementException;

abstract class Cu<E>
extends li<E> {
    private int SN;
    private final int yq;

    protected Cu(int n, int n2) {
        rs_0.t0(n2, n);
        this.yq = n;
        this.SN = n2;
    }

    protected abstract E SN(int var1);

    @Override
    public final boolean hasNext() {
        boolean bl = this.SN < this.yq;
        return bl;
    }

    @Override
    public final boolean hasPrevious() {
        boolean bl = this.SN > 0;
        return bl;
    }

    @Override
    public final E next() {
        if (this.hasNext()) {
            int n = this.SN;
            this.SN = n + 1;
            return this.SN(n);
        }
        throw new NoSuchElementException();
    }

    @Override
    public final int nextIndex() {
        return this.SN;
    }

    @Override
    public final E previous() {
        if (this.hasPrevious()) {
            int n;
            this.SN = n = this.SN - 1;
            return this.SN(n);
        }
        throw new NoSuchElementException();
    }

    @Override
    public final int previousIndex() {
        return this.SN - 1;
    }
}

