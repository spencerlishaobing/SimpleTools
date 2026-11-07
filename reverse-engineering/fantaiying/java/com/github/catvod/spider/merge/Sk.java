/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.R5;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

final class Sk<T>
implements Collection<T> {
    private final boolean SN;
    private final T[] yq;

    public Sk(T[] TArray, boolean bl) {
        Nh.zH(TArray, "values");
        this.yq = TArray;
        this.SN = bl;
    }

    @Override
    public final boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean contains(Object object) {
        int n2;
        boolean bl;
        block7: {
            T[] TArray = this.yq;
            Nh.zH(TArray, "<this>");
            bl = false;
            if (object == null) {
                int n3 = TArray.length;
                for (n2 = 0; n2 < n3; ++n2) {
                    if (TArray[n2] != null) {
                        continue;
                    }
                    break block7;
                }
            } else {
                int n4 = TArray.length;
                for (n2 = 0; n2 < n4; ++n2) {
                    if (!Nh.yq(object, TArray[n2])) {
                        continue;
                    }
                    break block7;
                }
            }
            n2 = -1;
        }
        if (n2 >= 0) {
            bl = true;
        }
        return bl;
    }

    @Override
    public final boolean containsAll(Collection<? extends Object> object) {
        boolean bl;
        block3: {
            Nh.zH(object, "elements");
            bl = object.isEmpty();
            boolean bl2 = true;
            if (bl) {
                bl = bl2;
            } else {
                object = object.iterator();
                do {
                    bl = bl2;
                    if (!object.hasNext()) break block3;
                } while (this.contains(object.next()));
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public final boolean isEmpty() {
        boolean bl = this.yq.length == 0;
        return bl;
    }

    @Override
    public final Iterator<T> iterator() {
        return R5.N(this.yq);
    }

    @Override
    public final boolean remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return this.yq.length;
    }

    @Override
    public final Object[] toArray() {
        Object[] objectArray = this.yq;
        boolean bl = this.SN;
        Nh.zH(objectArray, "<this>");
        if (!bl || !Nh.yq(objectArray.getClass(), Object[].class)) {
            objectArray = Arrays.copyOf(objectArray, objectArray.length, Object[].class);
            Nh.tF(objectArray, "copyOf(this, this.size, Array<Any?>::class.java)");
        }
        return objectArray;
    }

    @Override
    public final <T> T[] toArray(T[] TArray) {
        Nh.zH(TArray, "array");
        return R5.i(this, TArray);
    }
}

