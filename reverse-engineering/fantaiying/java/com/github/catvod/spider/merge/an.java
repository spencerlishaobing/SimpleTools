/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.kb;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class an<V>
extends kb
implements Future<V> {
    protected an() {
    }

    protected abstract Future<? extends V> N();

    @Override
    public boolean cancel(boolean bl) {
        return this.N().cancel(bl);
    }

    @Override
    public final V get() {
        return this.N().get();
    }

    @Override
    public final V get(long l, TimeUnit timeUnit) {
        return this.N().get(l, timeUnit);
    }

    @Override
    public final boolean isCancelled() {
        return this.N().isCancelled();
    }

    @Override
    public final boolean isDone() {
        return this.N().isDone();
    }
}

