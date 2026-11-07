/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.an;
import com.github.catvod.spider.merge.hE;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract class Aj<V>
extends an<V>
implements hE<V> {
    protected Aj() {
    }

    protected abstract hE<? extends V> tF();

    @Override
    public final void yq(Runnable runnable, Executor executor) {
        this.tF().yq(runnable, executor);
    }

    public static abstract class yq<V>
    extends Aj<V> {
        private final hE<V> yq;

        protected yq(hE<V> hE2) {
            this.yq = hE2;
        }

        @Override
        protected final Future N() {
            return this.yq;
        }

        @Override
        protected final Object SN() {
            return this.yq;
        }

        @Override
        protected final hE<V> tF() {
            return this.yq;
        }
    }
}

