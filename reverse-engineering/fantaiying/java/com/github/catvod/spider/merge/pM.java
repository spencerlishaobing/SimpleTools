/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.E3;
import com.github.catvod.spider.merge.rs_0;
import java.util.Objects;

final class pM<E>
extends E3<E> {
    static final E3<Object> i = new pM<Object>(new Object[0], 0);
    final transient Object[] tF;
    private final transient int zH;

    pM(Object[] objectArray, int n2) {
        this.tF = objectArray;
        this.zH = n2;
    }

    @Override
    final int N() {
        return this.zH;
    }

    @Override
    final Object[] SN() {
        return this.tF;
    }

    @Override
    public final E get(int n2) {
        rs_0.i(n2, this.zH);
        Object object = this.tF[n2];
        Objects.requireNonNull(object);
        return (E)object;
    }

    @Override
    public final int size() {
        return this.zH;
    }

    @Override
    final int tF() {
        return 0;
    }

    @Override
    final int yq(Object[] objectArray) {
        System.arraycopy(this.tF, 0, objectArray, 0, this.zH);
        return this.zH + 0;
    }
}

