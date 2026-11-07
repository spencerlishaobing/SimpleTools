/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nh;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Renamed from com.github.catvod.spider.merge.hY
 */
final class hy_0<T>
implements Iterator<T> {
    private int SN;
    private final T[] yq;

    public hy_0(T[] TArray) {
        Nh.zH(TArray, "array");
        this.yq = TArray;
    }

    @Override
    public final boolean hasNext() {
        boolean bl = this.SN < this.yq.length;
        return bl;
    }

    @Override
    public final T next() {
        int n2;
        Object object;
        try {
            object = this.yq;
            n2 = this.SN;
            this.SN = n2 + 1;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            --this.SN;
            throw new NoSuchElementException(arrayIndexOutOfBoundsException.getMessage());
        }
        object = object[n2];
        return (T)object;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

