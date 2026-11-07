/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Aj;
import com.github.catvod.spider.merge.cS;
import com.github.catvod.spider.merge.hE;
import com.github.catvod.spider.merge.kR;
import com.github.catvod.spider.merge.m7;
import com.github.catvod.spider.merge.mV;
import com.github.catvod.spider.merge.og_0;
import com.github.catvod.spider.merge.yE;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/*
 * Renamed from com.github.catvod.spider.merge.mI
 */
public final class mi_0 {
    public static m7 SN(ExecutorService executorService) {
        executorService = executorService instanceof m7 ? (m7)executorService : (executorService instanceof ScheduledExecutorService ? new SN((ScheduledExecutorService)executorService) : new yq(executorService));
        return executorService;
    }

    public static Executor yq() {
        return yE.yq;
    }

    private static final class com.github.catvod.spider.merge.mI$SN
    extends com.github.catvod.spider.merge.mI$yq
    implements ScheduledExecutorService {
        final ScheduledExecutorService SN;

        com.github.catvod.spider.merge.mI$SN(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.SN = scheduledExecutorService;
        }

        public final ScheduledFuture schedule(Runnable og_02, long l, TimeUnit timeUnit) {
            og_02 = new og_0<Object>(Executors.callable(og_02, null));
            return new yq<Object>(og_02, this.SN.schedule(og_02, l, timeUnit));
        }

        public final ScheduledFuture schedule(Callable object, long l, TimeUnit timeUnit) {
            object = new og_0(object);
            return new yq(object, this.SN.schedule((Runnable)object, l, timeUnit));
        }

        public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
            runnable = new SN(runnable);
            return new yq(runnable, this.SN.scheduleAtFixedRate(runnable, l, l2, timeUnit));
        }

        public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
            runnable = new SN(runnable);
            return new yq(runnable, this.SN.scheduleWithFixedDelay(runnable, l, l2, timeUnit));
        }

        private static final class SN
        extends kR.M<Void>
        implements Runnable {
            private final Runnable Gc;

            public SN(Runnable runnable) {
                Objects.requireNonNull(runnable);
                this.Gc = runnable;
            }

            @Override
            protected final String W() {
                String string = String.valueOf(this.Gc);
                StringBuilder stringBuilder = new StringBuilder(string.length() + 7);
                stringBuilder.append("task=[");
                stringBuilder.append(string);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }

            @Override
            public final void run() {
                try {
                    this.Gc.run();
                    return;
                }
                catch (Throwable throwable) {
                    this.g9(throwable);
                    int n2 = mV.SN;
                    if (!(throwable instanceof RuntimeException)) {
                        if (!(throwable instanceof Error)) {
                            throw new RuntimeException(throwable);
                        }
                        throw (Error)throwable;
                    }
                    throw (RuntimeException)throwable;
                }
            }
        }

        private static final class yq<V>
        extends Aj.yq<V>
        implements ScheduledFuture {
            private final ScheduledFuture<?> SN;

            public yq(hE<V> hE2, ScheduledFuture<?> scheduledFuture) {
                super(hE2);
                this.SN = scheduledFuture;
            }

            @Override
            public final boolean cancel(boolean bl) {
                boolean bl2 = super.cancel(bl);
                if (bl2) {
                    this.SN.cancel(bl);
                }
                return bl2;
            }

            @Override
            public final int compareTo(Object object) {
                object = (Delayed)object;
                return this.SN.compareTo(object);
            }

            @Override
            public final long getDelay(TimeUnit timeUnit) {
                return this.SN.getDelay(timeUnit);
            }
        }
    }

    private static class yq
    extends cS {
        private final ExecutorService yq;

        yq(ExecutorService executorService) {
            Objects.requireNonNull(executorService);
            this.yq = executorService;
        }

        @Override
        public final boolean awaitTermination(long l, TimeUnit timeUnit) {
            return this.yq.awaitTermination(l, timeUnit);
        }

        @Override
        public final void execute(Runnable runnable) {
            this.yq.execute(runnable);
        }

        @Override
        public final boolean isShutdown() {
            return this.yq.isShutdown();
        }

        @Override
        public final boolean isTerminated() {
            return this.yq.isTerminated();
        }

        @Override
        public final void shutdown() {
            this.yq.shutdown();
        }

        @Override
        public final List<Runnable> shutdownNow() {
            return this.yq.shutdownNow();
        }

        public final String toString() {
            String string = super.toString();
            String string2 = String.valueOf(this.yq);
            int n2 = String.valueOf(string).length();
            StringBuilder stringBuilder = new StringBuilder(string2.length() + (n2 + 2));
            stringBuilder.append(string);
            stringBuilder.append("[");
            stringBuilder.append(string2);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }
}

