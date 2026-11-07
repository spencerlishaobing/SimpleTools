/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.qt;
import com.github.catvod.spider.merge.wu;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/*
 * Renamed from com.github.catvod.spider.merge.Og
 */
final class og_0<V>
extends wu.yq<V>
implements RunnableFuture<V> {
    private volatile qt<?> Gc;

    og_0(Callable<V> callable) {
        this.Gc = new yq(this, callable);
    }

    @Override
    protected final String W() {
        Serializable serializable = this.Gc;
        if (serializable != null) {
            String string = String.valueOf(serializable);
            serializable = new StringBuilder(string.length() + 7);
            ((StringBuilder)serializable).append("task=[");
            ((StringBuilder)serializable).append(string);
            ((StringBuilder)serializable).append("]");
            return ((StringBuilder)serializable).toString();
        }
        return super.W();
    }

    @Override
    protected final void q() {
        qt<?> qt2;
        if (this.xa() && (qt2 = this.Gc) != null) {
            qt2.N();
        }
        this.Gc = null;
    }

    @Override
    public final void run() {
        qt<?> qt2 = this.Gc;
        if (qt2 != null) {
            qt2.run();
        }
        this.Gc = null;
    }

    private final class yq
    extends qt<V> {
        private final Callable<V> N;
        final og_0 tF;

        yq(og_0 og_02, Callable<V> callable) {
            this.tF = og_02;
            Objects.requireNonNull(callable);
            this.N = callable;
        }

        @Override
        final void SN(V v2) {
            this.tF.ee(v2);
        }

        @Override
        final String i() {
            return this.N.toString();
        }

        @Override
        final boolean tF() {
            return this.tF.isDone();
        }

        @Override
        final void yq(Throwable throwable) {
            this.tF.g9(throwable);
        }

        @Override
        final V zH() {
            return this.N.call();
        }
    }
}

