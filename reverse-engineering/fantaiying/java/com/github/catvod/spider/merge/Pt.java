/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Bd;
import com.github.catvod.spider.merge.Uz;
import com.github.catvod.spider.merge.wg;

public final class Pt
implements Uz {
    private final int yq;

    public Pt(int n2) {
        this.yq = n2;
    }

    @Override
    public final void SN(Bd bd) {
        bd.B = this.yq;
    }

    public final boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof Pt)) {
            return false;
        }
        if (this.yq != ((Pt)object).yq) {
            bl = false;
        }
        return bl;
    }

    public final int hashCode() {
        return wg.SN(wg.zH(wg.zH(0, 0), this.yq), 2);
    }

    public final String toString() {
        return String.format("channel(%d)", this.yq);
    }

    @Override
    public final boolean yq() {
        return false;
    }
}

