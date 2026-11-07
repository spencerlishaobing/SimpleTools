/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Ir;
import com.github.catvod.spider.merge.lR;

public abstract class o
implements lR {
    @Override
    public void M() {
    }

    public abstract int Zm(Object var1);

    public abstract boolean b(Object var1, Object var2);

    public Object tF(Ir ir) {
        int n = ir.tF();
        Object var4_3 = null;
        for (int i2 = 0; i2 < n; ++i2) {
            var4_3 = ir.N(i2).yq(this);
        }
        return var4_3;
    }

    @Override
    public void yq() {
    }
}

