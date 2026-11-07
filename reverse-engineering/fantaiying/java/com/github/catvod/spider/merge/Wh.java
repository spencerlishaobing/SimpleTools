/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Bd;
import com.github.catvod.spider.merge.Uz;
import com.github.catvod.spider.merge.wg;

public final class Wh
implements Uz {
    private final Uz SN;
    private final int yq;

    public Wh(int n2, Uz uz) {
        this.yq = n2;
        this.SN = uz;
    }

    public final Uz N() {
        return this.SN;
    }

    @Override
    public final void SN(Bd bd) {
        this.SN.SN(bd);
    }

    public final boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof Wh)) {
            return false;
        }
        object = (Wh)object;
        if (this.yq != ((Wh)object).yq || !this.SN.equals(((Wh)object).SN)) {
            bl = false;
        }
        return bl;
    }

    public final int hashCode() {
        return wg.SN(wg.i(wg.zH(0, this.yq), this.SN), 2);
    }

    public final int tF() {
        return this.yq;
    }

    @Override
    public final boolean yq() {
        return true;
    }
}

