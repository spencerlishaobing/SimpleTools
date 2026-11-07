/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.EL;
import java.util.NoSuchElementException;

/*
 * Renamed from com.github.catvod.spider.merge.cM
 */
public final class cm_0
extends EL {
    private boolean N;
    private final int SN;
    private int tF;
    private final int yq;

    public cm_0(int n2, int n3, int n4) {
        this.yq = n4;
        this.SN = n3;
        boolean bl = true;
        if (!(n4 > 0 ? n2 <= n3 : n2 >= n3)) {
            bl = false;
        }
        this.N = bl;
        if (!bl) {
            n2 = n3;
        }
        this.tF = n2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final int SN() {
        int n2 = this.tF;
        if (n2 == this.SN) {
            if (!this.N) throw new NoSuchElementException();
            this.N = false;
            return n2;
        } else {
            this.tF = this.yq + n2;
        }
        return n2;
    }

    @Override
    public final boolean hasNext() {
        return this.N;
    }
}

