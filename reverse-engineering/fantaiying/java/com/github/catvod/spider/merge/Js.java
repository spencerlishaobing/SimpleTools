/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.wA;
import java.util.AbstractCollection;
import java.util.ArrayList;

public final class Js
extends ArrayList<wA> {
    private final int yq;

    Js() {
        super(0);
        this.yq = 0;
    }

    final int SN() {
        return this.yq;
    }

    @Override
    public final Object clone() {
        return super.clone();
    }

    final boolean yq() {
        boolean bl = ((AbstractCollection)this).size() < this.yq;
        return bl;
    }
}

