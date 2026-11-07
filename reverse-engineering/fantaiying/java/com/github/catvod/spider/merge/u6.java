/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.jY;
import com.github.catvod.spider.merge.q3;
import com.github.catvod.spider.merge.rd;

final class u6<E>
extends rd<E> {
    final transient E N;

    u6(E e) {
        this.N = e;
    }

    @Override
    public final boolean contains(Object object) {
        return this.N.equals(object);
    }

    @Override
    public final int hashCode() {
        return this.N.hashCode();
    }

    @Override
    public final int size() {
        return 1;
    }

    @Override
    public final String toString() {
        String string = this.N.toString();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 2);
        stringBuilder.append('[');
        stringBuilder.append(string);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override
    final int yq(Object[] objectArray) {
        objectArray[0] = this.N;
        return 1;
    }

    @Override
    public final jY<E> zH() {
        return new q3(this.N);
    }
}

