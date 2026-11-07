/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.ArrayList;
import java.util.Collection;

public abstract class iY<E>
extends ArrayList<E> {
    public iY(int n2) {
        super(n2);
    }

    @Override
    public final void add(int n2, E e) {
        this.yq();
        super.add(n2, e);
    }

    @Override
    public final boolean add(E e) {
        this.yq();
        return super.add(e);
    }

    @Override
    public final boolean addAll(int n2, Collection<? extends E> collection) {
        this.yq();
        return super.addAll(n2, collection);
    }

    @Override
    public final boolean addAll(Collection<? extends E> collection) {
        this.yq();
        return super.addAll(collection);
    }

    @Override
    public final void clear() {
        this.yq();
        super.clear();
    }

    @Override
    public final E remove(int n2) {
        this.yq();
        return super.remove(n2);
    }

    @Override
    public final boolean remove(Object object) {
        this.yq();
        return super.remove(object);
    }

    @Override
    public final boolean removeAll(Collection<?> collection) {
        this.yq();
        return super.removeAll(collection);
    }

    @Override
    protected final void removeRange(int n2, int n3) {
        this.yq();
        super.removeRange(n2, n3);
    }

    @Override
    public final boolean retainAll(Collection<?> collection) {
        this.yq();
        return super.retainAll(collection);
    }

    @Override
    public final E set(int n2, E e) {
        this.yq();
        return super.set(n2, e);
    }

    public abstract void yq();
}

