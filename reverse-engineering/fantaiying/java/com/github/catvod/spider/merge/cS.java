/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.hE;
import com.github.catvod.spider.merge.m7;
import com.github.catvod.spider.merge.og_0;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

public abstract class cS
extends AbstractExecutorService
implements m7 {
    @Override
    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new og_0<T>(Executors.callable(runnable, t));
    }

    @Override
    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new og_0<T>(callable);
    }

    @Override
    public final <T> hE<T> submit(Callable<T> callable) {
        return (hE)super.submit(callable);
    }

    public final Future submit(Runnable runnable) {
        return (hE)super.submit(runnable);
    }

    public final Future submit(Runnable runnable, Object object) {
        return (hE)super.submit(runnable, object);
    }

    public final Future submit(Callable callable) {
        return (hE)super.submit(callable);
    }
}

