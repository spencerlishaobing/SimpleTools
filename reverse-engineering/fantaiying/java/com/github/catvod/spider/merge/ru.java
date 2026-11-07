/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Bd;
import com.github.catvod.spider.merge.Uz;
import com.github.catvod.spider.merge.wg;
import java.util.Objects;

public final class ru
implements Uz {
    private final int SN;
    private final int yq;

    public ru(int n2, int n3) {
        this.yq = n2;
        this.SN = n3;
    }

    @Override
    public final void SN(Bd bd) {
        Objects.requireNonNull(bd);
    }

    public final boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof ru)) {
            return false;
        }
        object = (ru)object;
        if (this.yq != ((ru)object).yq || this.SN != ((ru)object).SN) {
            bl = false;
        }
        return bl;
    }

    public final int hashCode() {
        return wg.SN(wg.zH(wg.zH(wg.zH(0, 1), this.yq), this.SN), 3);
    }

    @Override
    public final boolean yq() {
        return true;
    }
}

