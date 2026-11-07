/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.spider.merge.X
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.E3;
import com.github.catvod.spider.merge.PY;
import com.github.catvod.spider.merge.Sq;
import com.github.catvod.spider.merge.TA;
import com.github.catvod.spider.merge.TO;
import com.github.catvod.spider.merge.X;
import com.github.catvod.spider.merge.by;
import com.github.catvod.spider.merge.fy_0;
import com.github.catvod.spider.merge.hE;
import com.github.catvod.spider.merge.hb_0;
import com.github.catvod.spider.merge.o;
import com.github.catvod.spider.merge.rs_1;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/*
 * Renamed from com.github.catvod.spider.merge.X
 */
public final class x_0
extends o {
    public static <V> void Dr(hE<V> hE2, hb_0<? super V> hb_02, Executor executor) {
        hE2.yq(new yq<V>(hE2, hb_02), executor);
    }

    public static <V> hE<V> H(Throwable throwable) {
        return new by(throwable);
    }

    @SafeVarargs
    public static <V> SN<V> U(hE<? extends V> ... hEArray) {
        return new SN(E3.i(hEArray));
    }

    public static <V> V g(Future<V> future) {
        if (future.isDone()) {
            return (V)TO.tF(future);
        }
        throw new IllegalStateException(rs_1.W("Future was expected to be done: %s", future));
    }

    public static final class SN<V> {
        private final E3<hE<? extends V>> yq;

        SN(E3 e3) {
            this.yq = e3;
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        public final hE yq(Callable callable) {
            return new fy_0(this.yq, callable);
        }
    }

    private static final class yq<V>
    implements Runnable {
        final hb_0<? super V> SN;
        final Future<V> yq;

        yq(Future<V> future, hb_0<? super V> hb_02) {
            this.yq = future;
            this.SN = hb_02;
        }

        /*
         * WARNING - void declaration
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public final void run() {
            void var1_4;
            block5: {
                Future<V> future = this.yq;
                if (future instanceof PY && (future = TA.N((PY)((Object)future))) != null) {
                    this.SN.onFailure((Throwable)((Object)future));
                    return;
                }
                try {
                    future = X.g(this.yq);
                }
                catch (Error error) {
                    break block5;
                }
                catch (RuntimeException runtimeException) {
                    // empty catch block
                    break block5;
                }
                catch (ExecutionException executionException) {
                    this.SN.onFailure(executionException.getCause());
                    return;
                }
                this.SN.onSuccess(future);
                return;
            }
            this.SN.onFailure((Throwable)var1_4);
        }

        public final String toString() {
            Sq.yq yq2 = Sq.yq(this);
            yq2.yq(this.SN);
            return yq2.toString();
        }
    }
}

