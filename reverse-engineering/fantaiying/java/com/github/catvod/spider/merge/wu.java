/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.ic_0;
import com.github.catvod.spider.merge.kR;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class wu<V>
extends ic_0<V> {
    wu() {
    }

    static abstract class yq<V>
    extends wu<V>
    implements kR.Gc<V> {
        yq() {
        }

        @Override
        public final boolean cancel(boolean bl) {
            return super.cancel(bl);
        }

        @Override
        public final V get() {
            return super.get();
        }

        @Override
        public final V get(long l, TimeUnit timeUnit) {
            return super.get(l, timeUnit);
        }

        @Override
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override
        public final boolean isDone() {
            return super.isDone();
        }

        @Override
        public final void yq(Runnable runnable, Executor executor) {
            super.yq(runnable, executor);
        }
    }
}

