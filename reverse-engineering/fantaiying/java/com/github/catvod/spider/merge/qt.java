/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

abstract class qt<T>
extends AtomicReference<Runnable>
implements Runnable {
    private static final Runnable SN;
    private static final Runnable yq;

    static {
        yq = new N();
        SN = new N();
    }

    qt() {
    }

    private void t0(Thread thread) {
        Runnable runnable = (Runnable)this.get();
        SN sN = null;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            int n4;
            block8: {
                block6: {
                    block7: {
                        boolean bl;
                        if (!(bl = runnable instanceof SN) && runnable != SN) {
                            if (n2 != 0) {
                                thread.interrupt();
                            }
                            return;
                        }
                        if (bl) {
                            sN = (SN)runnable;
                        }
                        if ((n4 = n3 + 1) <= 1000) break block6;
                        Runnable runnable2 = SN;
                        if (runnable == runnable2) break block7;
                        n3 = n2;
                        if (!this.compareAndSet(runnable, runnable2)) break block8;
                    }
                    n2 = !Thread.interrupted() && n2 == 0 ? 0 : 1;
                    LockSupport.park(sN);
                    n3 = n2;
                    break block8;
                }
                Thread.yield();
                n3 = n2;
            }
            runnable = (Runnable)this.get();
            n2 = n3;
            n3 = n4;
        }
    }

    final void N() {
        Runnable runnable = (Runnable)this.get();
        if (runnable instanceof Thread) {
            SN sN = new SN(this, null);
            com.github.catvod.spider.merge.qt$SN.yq(sN, Thread.currentThread());
            if (this.compareAndSet(runnable, sN)) {
                try {
                    ((Thread)runnable).interrupt();
                }
                finally {
                    if (this.getAndSet(yq) == SN) {
                        LockSupport.unpark((Thread)runnable);
                    }
                }
            }
        }
    }

    abstract void SN(T var1);

    abstract String i();

    @Override
    public final void run() {
        block8: {
            Thread thread = Thread.currentThread();
            T t = null;
            if (!this.compareAndSet(null, thread)) {
                return;
            }
            boolean bl = this.tF() ^ true;
            if (bl) {
                try {
                    t = this.zH();
                }
                catch (Throwable throwable) {
                    if (!this.compareAndSet(thread, yq)) {
                        this.t0(thread);
                    }
                    if (bl) {
                        this.yq(throwable);
                    }
                    break block8;
                }
            }
            if (!this.compareAndSet(thread, yq)) {
                this.t0(thread);
            }
            if (bl) {
                this.SN(t);
            }
        }
    }

    abstract boolean tF();

    @Override
    public final String toString() {
        CharSequence charSequence;
        Object object = (Runnable)this.get();
        if (object == yq) {
            object = "running=[DONE]";
        } else if (object instanceof SN) {
            object = "running=[INTERRUPTED]";
        } else if (object instanceof Thread) {
            object = ((Thread)object).getName();
            charSequence = new StringBuilder(String.valueOf(object).length() + 21);
            ((StringBuilder)charSequence).append("running=[RUNNING ON ");
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append("]");
            object = ((StringBuilder)charSequence).toString();
        } else {
            object = "running=[NOT STARTED YET]";
        }
        charSequence = this.i();
        int n2 = String.valueOf(object).length();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(charSequence).length() + (n2 + 2));
        stringBuilder.append((String)object);
        stringBuilder.append(", ");
        stringBuilder.append((String)charSequence);
        return stringBuilder.toString();
    }

    abstract void yq(Throwable var1);

    abstract T zH();

    private static final class N
    implements Runnable {
        N() {
        }

        @Override
        public final void run() {
        }
    }

    static final class SN
    extends AbstractOwnableSynchronizer
    implements Runnable {
        private final qt<?> yq;

        SN(qt qt2, yq_0 yq_02) {
            this.yq = qt2;
        }

        static void yq(SN sN, Thread thread) {
            sN.setExclusiveOwnerThread(thread);
        }

        @Override
        public final void run() {
        }

        public final String toString() {
            return this.yq.toString();
        }
    }
}

