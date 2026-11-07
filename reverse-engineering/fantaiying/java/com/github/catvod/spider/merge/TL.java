/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Yv;
import com.github.catvod.spider.merge.aq;
import com.github.catvod.spider.merge.j;

public class TL
extends Yv {
    public final aq SN;

    public TL(j object, aq aq2) {
        super((j)object);
        object = aq2;
        if (aq2 == null) {
            object = new aq(new int[0]);
            ((aq)object).yq(0);
        }
        this.SN = object;
    }

    @Override
    public final aq N() {
        return this.SN;
    }

    @Override
    public boolean tF(int n2, int n3) {
        return this.SN.tF(n2);
    }

    public String toString() {
        return this.SN.toString();
    }

    @Override
    public int yq() {
        return 7;
    }
}

