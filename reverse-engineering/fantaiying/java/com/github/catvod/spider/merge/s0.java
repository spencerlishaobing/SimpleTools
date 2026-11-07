/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.kR;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class s0<OutputT>
extends kR.M<OutputT> {
    private static final yq KJ;
    private static final Logger q;
    private volatile Set<Throwable> Gc = null;
    private volatile int M;

    static {
        Throwable throwable;
        yq yq2;
        q = Logger.getLogger(s0.class.getName());
        try {
            yq2 = new SN(AtomicReferenceFieldUpdater.newUpdater(s0.class, Set.class, "Gc"), AtomicIntegerFieldUpdater.newUpdater(s0.class, "M"));
            throwable = null;
        }
        catch (Throwable throwable2) {
            yq2 = new N();
        }
        KJ = yq2;
        if (throwable != null) {
            q.log(Level.SEVERE, "SafeAtomicHelper is broken!", throwable);
        }
    }

    s0(int n2) {
        this.M = n2;
    }

    static /* synthetic */ Set Nl(s0 s02, Set set) {
        s02.Gc = set;
        return set;
    }

    static /* synthetic */ int OW(s0 s02) {
        int n2;
        s02.M = n2 = s02.M - 1;
        return n2;
    }

    abstract void O(Set<Throwable> var1);

    final void g1() {
        this.Gc = null;
    }

    final Set<Throwable> n() {
        Set<Throwable> set;
        Set<Throwable> set2 = set = this.Gc;
        if (set == null) {
            set2 = Collections.newSetFromMap(new ConcurrentHashMap());
            this.O(set2);
            KJ.yq(this, set2);
            set2 = this.Gc;
            Objects.requireNonNull(set2);
        }
        return set2;
    }

    final int s() {
        return KJ.SN(this);
    }

    private static final class N
    extends yq {
        N() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        final int SN(s0<?> s02) {
            synchronized (s02) {
                return s0.OW(s02);
            }
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        final void yq(s0 s02, Set set) {
            synchronized (s02) {
                if (s02.Gc == null) {
                    s0.Nl(s02, set);
                }
                return;
            }
        }
    }

    private static final class SN
    extends yq {
        final AtomicIntegerFieldUpdater<s0<?>> SN;
        final AtomicReferenceFieldUpdater<s0<?>, Set<Throwable>> yq;

        SN(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            this.yq = atomicReferenceFieldUpdater;
            this.SN = atomicIntegerFieldUpdater;
        }

        @Override
        final int SN(s0<?> s02) {
            return this.SN.decrementAndGet(s02);
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        @Override
        final void yq(s0 s02, Set set) {
            AtomicReferenceFieldUpdater<s0<?>, Set<Throwable>> atomicReferenceFieldUpdater = this.yq;
            while (!atomicReferenceFieldUpdater.compareAndSet(s02, null, set) && atomicReferenceFieldUpdater.get(s02) == null) {
            }
        }
    }

    private static abstract class yq {
        yq() {
        }

        abstract int SN(s0<?> var1);

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        abstract void yq(s0 var1, Set var2);
    }
}

