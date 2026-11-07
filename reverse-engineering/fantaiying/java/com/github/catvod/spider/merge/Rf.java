/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.DO;
import com.github.catvod.spider.merge.Fp;
import com.github.catvod.spider.merge.Tu;
import com.github.catvod.spider.merge.Xj;
import com.github.catvod.spider.merge.ei_0;
import com.github.catvod.spider.merge.fU;
import com.github.catvod.spider.merge.ly_1;
import com.github.catvod.spider.merge.r6;

public final class Rf
extends Fp {
    @Override
    public final void i(Tu object, fU fU2) {
        object = ((Tu)object).G4();
        while (object != null) {
            object = (ei_0)((ly_1)object).yq;
        }
        object = new r6(fU2);
        throw object;
    }

    @Override
    public final DO t0(Tu object) {
        Xj xj = new Xj((Tu)object);
        object = ((Tu)object).G4();
        while (object != null) {
            object = (ei_0)((ly_1)object).yq;
        }
        object = new r6(xj);
        throw object;
    }
}

