/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.E3;
import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.jY;
import com.github.catvod.spider.merge.pM;
import com.github.catvod.spider.merge.rd;

final class iX<E>
extends rd<E> {
    private static final Object[] Gc;
    static final iX<Object> M;
    final transient Object[] N;
    private final transient int i;
    private final transient int t0;
    private final transient int tF;
    final transient Object[] zH;

    static {
        Object[] objectArray = new Object[]{};
        Gc = objectArray;
        M = new iX(objectArray, 0, objectArray, 0, 0);
    }

    iX(Object[] objectArray, int n2, Object[] objectArray2, int n3, int n4) {
        this.N = objectArray;
        this.tF = n2;
        this.zH = objectArray2;
        this.i = n3;
        this.t0 = n4;
    }

    @Override
    final E3<E> M() {
        Object object = this.N;
        int n2 = this.t0;
        int n3 = E3.N;
        object = n2 == 0 ? pM.i : new pM((Object[])object, n2);
        return object;
    }

    @Override
    final int N() {
        return this.t0;
    }

    @Override
    final Object[] SN() {
        return this.N;
    }

    @Override
    public final boolean contains(Object object) {
        Object[] objectArray = this.zH;
        if (object != null && objectArray.length != 0) {
            int n2 = U7.G(object.hashCode());
            while (true) {
                Object object2;
                if ((object2 = objectArray[n2 &= this.i]) == null) {
                    return false;
                }
                if (object2.equals(object)) {
                    return true;
                }
                ++n2;
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.tF;
    }

    @Override
    public final int size() {
        return this.t0;
    }

    @Override
    final int tF() {
        return 0;
    }

    @Override
    final int yq(Object[] objectArray) {
        System.arraycopy(this.N, 0, objectArray, 0, this.t0);
        return this.t0 + 0;
    }

    @Override
    public final jY<E> zH() {
        return this.i().t0(0);
    }
}

