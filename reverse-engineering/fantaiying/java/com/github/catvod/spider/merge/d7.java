/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Bd;
import com.github.catvod.spider.merge.Uz;
import com.github.catvod.spider.merge.wg;

public final class d7
implements Uz {
    private final int yq;

    public d7(int n2) {
        this.yq = n2;
    }

    @Override
    public final void SN(Bd bd) {
        bd.G = this.yq;
    }

    public final boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof d7)) {
            return false;
        }
        if (this.yq != ((d7)object).yq) {
            bl = false;
        }
        return bl;
    }

    public final int hashCode() {
        return wg.SN(wg.zH(wg.zH(0, 7), this.yq), 2);
    }

    public final String toString() {
        return String.format("type(%d)", this.yq);
    }

    @Override
    public final boolean yq() {
        return false;
    }
}

