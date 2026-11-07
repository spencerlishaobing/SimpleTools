/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.spider.merge.Fy
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Fy;
import com.github.catvod.spider.merge.fo_0;
import com.github.catvod.spider.merge.hy;
import com.github.catvod.spider.merge.qt;
import com.github.catvod.spider.merge.yE;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/*
 * Renamed from com.github.catvod.spider.merge.Fy
 */
final class fy_0<V>
extends fo_0<Object, V> {
    private SN<?> F5;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    fy_0(hy hy2, Callable callable) {
        super(hy2);
        this.F5 = new yq(this, callable);
        this.U();
    }

    static /* synthetic */ void E1(fy_0 fy_02) {
        fy_02.F5 = null;
    }

    @Override
    final void Fz(fo_0.yq yq2) {
        super.Fz(yq2);
        if (yq2 == fo_0.yq.yq) {
            this.F5 = null;
        }
    }

    @Override
    final void Zm() {
    }

    @Override
    final void g() {
        SN<?> sN = this.F5;
        if (sN != null) {
            sN.Gc();
        }
    }

    @Override
    protected final void v3() {
        SN<?> sN = this.F5;
        if (sN != null) {
            sN.N();
        }
    }

    private abstract class SN<T>
    extends qt<T> {
        private final Executor N;
        final fy_0 tF;

        SN(fy_0 fy_02) {
            yE yE2 = yE.yq;
            this.tF = fy_02;
            this.N = yE2;
        }

        final void Gc() {
            try {
                this.N.execute(this);
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                this.tF.g9(rejectedExecutionException);
            }
        }

        @Override
        final void SN(T t) {
            Fy.E1((fy_0)this.tF);
            ((yq)this).i.ee(t);
        }

        @Override
        final boolean tF() {
            return this.tF.isDone();
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        final void yq(Throwable throwable) {
            fy_0 fy_02;
            Fy.E1((fy_0)this.tF);
            if (throwable instanceof ExecutionException) {
                fy_02 = this.tF;
                throwable = ((ExecutionException)throwable).getCause();
            } else {
                if (throwable instanceof CancellationException) {
                    this.tF.cancel(false);
                    return;
                }
                fy_02 = this.tF;
            }
            fy_02.g9(throwable);
        }
    }

    private final class yq
    extends SN<V> {
        final fy_0 i;
        private final Callable<V> zH;

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        yq(fy_0 fy_02, Callable callable) {
            this.i = fy_02;
            super(fy_02);
            this.zH = callable;
        }

        @Override
        final String i() {
            return this.zH.toString();
        }

        @Override
        final V zH() {
            return this.zH.call();
        }
    }
}

