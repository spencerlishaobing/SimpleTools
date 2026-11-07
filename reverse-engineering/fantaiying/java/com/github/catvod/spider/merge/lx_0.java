/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Bd;
import com.github.catvod.spider.merge.Uz;
import com.github.catvod.spider.merge.tj_0;
import com.github.catvod.spider.merge.wg;
import java.util.EmptyStackException;

/*
 * Renamed from com.github.catvod.spider.merge.lx
 */
public final class lx_0
implements Uz {
    public static final lx_0 yq = new lx_0();

    private lx_0() {
    }

    @Override
    public final void SN(Bd bd) {
        if (!bd.G4.tF()) {
            tj_0 tj_02 = bd.G4;
            bd.dT = tj_02.zH(tj_02.i() - 1);
            return;
        }
        throw new EmptyStackException();
    }

    public final boolean equals(Object object) {
        boolean bl = object == this;
        return bl;
    }

    public final int hashCode() {
        return wg.SN(wg.zH(0, 4), 1);
    }

    public final String toString() {
        return "popMode";
    }

    @Override
    public final boolean yq() {
        return false;
    }
}

