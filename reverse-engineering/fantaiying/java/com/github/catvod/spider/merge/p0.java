/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.DO;
import com.github.catvod.spider.merge.O4;
import com.github.catvod.spider.merge.fh;
import java.util.ArrayList;

public final class p0
extends O4 {
    public p0(fh fh2) {
        super(fh2);
    }

    protected final DO F5(int n2) {
        int n3;
        if (n2 != 0 && (n3 = this.N) - n2 >= 0) {
            block0: for (int i2 = 1; i2 <= n2 && n3 > 0; ++i2) {
                this.dT(--n3);
                int n4 = n3;
                if (n3 >= this.size()) {
                    n3 = this.size() - 1;
                    continue;
                }
                while (true) {
                    n3 = n4;
                    if (n4 < 0) continue block0;
                    DO dO = (DO)((ArrayList)this.SN).get(n4);
                    n3 = n4--;
                    if (dO.getType() == -1) continue block0;
                    if (dO.getChannel() != 0) continue;
                    n3 = n4;
                    continue block0;
                }
            }
            if (n3 < 0) {
                return null;
            }
            return (DO)((ArrayList)this.SN).get(n3);
        }
        return null;
    }

    @Override
    public final DO i(int n2) {
        this.G();
        if (n2 == 0) {
            return null;
        }
        if (n2 < 0) {
            return this.F5(-n2);
        }
        int n3 = this.N;
        for (int i2 = 1; i2 < n2; ++i2) {
            int n4 = n3 + 1;
            if (!this.dT(n4)) continue;
            n3 = this.G4(n4);
        }
        return (DO)((ArrayList)this.SN).get(n3);
    }

    @Override
    protected final int q(int n2) {
        return this.G4(n2);
    }
}

