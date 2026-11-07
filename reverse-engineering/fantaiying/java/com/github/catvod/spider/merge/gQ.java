/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Bd;
import com.github.catvod.spider.merge.Uz;
import com.github.catvod.spider.merge.wg;

public final class gQ
implements Uz {
    private final int yq;

    public gQ(int n2) {
        this.yq = n2;
    }

    @Override
    public final void SN(Bd bd) {
        bd.dT = this.yq;
    }

    public final boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof gQ)) {
            return false;
        }
        if (this.yq != ((gQ)object).yq) {
            bl = false;
        }
        return bl;
    }

    public final int hashCode() {
        return wg.SN(wg.zH(wg.zH(0, 2), this.yq), 2);
    }

    public final String toString() {
        return String.format("mode(%d)", this.yq);
    }

    @Override
    public final boolean yq() {
        return false;
    }
}

