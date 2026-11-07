/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.jY;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public abstract class hy<E>
extends AbstractCollection<E>
implements Serializable {
    private static final Object[] yq = new Object[0];

    hy() {
    }

    int N() {
        throw new UnsupportedOperationException();
    }

    Object[] SN() {
        return null;
    }

    @Override
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    int tF() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object[] toArray() {
        return this.toArray(yq);
    }

    @Override
    public final <T> T[] toArray(T[] TArray) {
        Object[] objectArray;
        Objects.requireNonNull(TArray);
        int n2 = this.size();
        if (TArray.length < n2) {
            objectArray = this.SN();
            if (objectArray != null) {
                return Arrays.copyOfRange(objectArray, this.tF(), this.N(), TArray.getClass());
            }
            objectArray = (Object[])Array.newInstance(TArray.getClass().getComponentType(), n2);
        } else {
            objectArray = TArray;
            if (TArray.length > n2) {
                TArray[n2] = null;
                objectArray = TArray;
            }
        }
        this.yq(objectArray);
        return objectArray;
    }

    int yq(Object[] objectArray) {
        jY<E> jY2 = this.zH();
        int n2 = 0;
        while (jY2.hasNext()) {
            objectArray[n2] = jY2.next();
            ++n2;
        }
        return n2;
    }

    public abstract jY<E> zH();
}

