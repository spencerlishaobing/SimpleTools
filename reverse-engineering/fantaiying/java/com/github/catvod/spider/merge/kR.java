/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.L;
import com.github.catvod.spider.merge.PY;
import com.github.catvod.spider.merge.hE;
import com.github.catvod.spider.merge.mV;
import com.github.catvod.spider.merge.rs_1;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public abstract class kR<V>
extends PY
implements hE<V> {
    private static final yq i;
    private static final Object t0;
    static final boolean tF;
    private static final Logger zH;
    private volatile q N;
    private volatile tF SN;
    private volatile Object yq;

    static {
        Throwable throwable;
        Object object;
        boolean bl;
        try {
            bl = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        }
        catch (SecurityException securityException) {
            bl = false;
        }
        tF = bl;
        zH = Logger.getLogger(kR.class.getName());
        Throwable throwable2 = null;
        try {
            object = new KJ();
            throwable = null;
        }
        catch (Throwable throwable3) {
            try {
                object = new zH(AtomicReferenceFieldUpdater.newUpdater(q.class, Thread.class, "yq"), AtomicReferenceFieldUpdater.newUpdater(q.class, q.class, "SN"), AtomicReferenceFieldUpdater.newUpdater(kR.class, q.class, "N"), AtomicReferenceFieldUpdater.newUpdater(kR.class, tF.class, "SN"), AtomicReferenceFieldUpdater.newUpdater(kR.class, Object.class, "yq"));
            }
            catch (Throwable throwable4) {
                object = new t0();
            }
        }
        i = object;
        if (throwable2 != null) {
            Logger logger = zH;
            object = Level.SEVERE;
            logger.log((Level)object, "UnsafeAtomicHelper is broken!", throwable);
            logger.log((Level)object, "SafeAtomicHelper is broken!", throwable2);
        }
        t0 = new Object();
    }

    protected kR() {
    }

    private void B(StringBuilder stringBuilder, Object object) {
        if (object == null) {
            object = "null";
        } else if (object == this) {
            object = "this future";
        } else {
            stringBuilder.append(object.getClass().getName());
            stringBuilder.append("@");
            object = Integer.toHexString(System.identityHashCode(object));
        }
        stringBuilder.append((String)object);
    }

    private static <V> V F5(Future<V> future) {
        boolean bl = false;
        while (true) {
            V v2;
            block5: {
                try {
                    v2 = future.get();
                    if (!bl) break block5;
                    Thread.currentThread().interrupt();
                }
                catch (Throwable throwable) {
                    if (bl) {
                        Thread.currentThread().interrupt();
                    }
                    throw throwable;
                }
                catch (InterruptedException interruptedException) {
                    bl = true;
                    continue;
                }
            }
            return v2;
            break;
        }
    }

    private static void G(kR<?> object) {
        Object object2;
        Objects.requireNonNull(object);
        Object object3 = i.zH((kR)object);
        while (object3 != null) {
            object2 = ((q)object3).yq;
            if (object2 != null) {
                ((q)object3).yq = null;
                LockSupport.unpark((Thread)object2);
            }
            object3 = ((q)object3).SN;
        }
        ((kR)object).q();
        object = i.tF((kR)object);
        object3 = null;
        while (true) {
            object2 = object3;
            if (object == null) break;
            object2 = ((tF)object).N;
            ((tF)object).N = object3;
            object3 = object;
            object = object2;
        }
        while (object2 != null) {
            object = ((tF)object2).N;
            object3 = ((tF)object2).yq;
            Objects.requireNonNull(object3);
            if (!(object3 instanceof i)) {
                object2 = ((tF)object2).SN;
                Objects.requireNonNull(object2);
                kR.G4((Runnable)object3, (Executor)object2);
                object2 = object;
                continue;
            }
            object = (i)object3;
            throw null;
        }
    }

    private static void G4(Runnable object, Executor object2) {
        try {
            object2.execute((Runnable)object);
        }
        catch (RuntimeException runtimeException) {
            Logger logger = zH;
            Level level = Level.SEVERE;
            object = String.valueOf(object);
            String string = String.valueOf(object2);
            int n2 = ((String)object).length();
            object2 = new StringBuilder(string.length() + (n2 + 57));
            ((StringBuilder)object2).append("RuntimeException while executing runnable ");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" with executor ");
            ((StringBuilder)object2).append(string);
            logger.log(level, ((StringBuilder)object2).toString(), runtimeException);
        }
    }

    private void KJ(StringBuilder stringBuilder) {
        block4: {
            String string = "]";
            try {
                V v2 = kR.F5(this);
                stringBuilder.append("SUCCESS, result=[");
                this.B(stringBuilder, v2);
                stringBuilder.append("]");
                break block4;
            }
            catch (RuntimeException runtimeException) {
                stringBuilder.append("UNKNOWN, cause=[");
                stringBuilder.append(runtimeException.getClass());
                string = " thrown from get()]";
            }
            catch (CancellationException cancellationException) {
                string = "CANCELLED";
            }
            catch (ExecutionException executionException) {
                stringBuilder.append("FAILURE, cause=[");
                stringBuilder.append(executionException.getCause());
            }
            stringBuilder.append(string);
        }
    }

    static /* synthetic */ q M(kR kR2, q q4) {
        kR2.N = q4;
        return q4;
    }

    private V dT(Object object) {
        if (!(object instanceof SN)) {
            if (!(object instanceof N)) {
                Object object2 = object;
                if (object == t0) {
                    object2 = null;
                }
                return (V)object2;
            }
            throw new ExecutionException(((N)object).yq);
        }
        object = ((SN)object).SN;
        CancellationException cancellationException = new CancellationException("Task was cancelled.");
        cancellationException.initCause((Throwable)object);
        throw cancellationException;
    }

    static /* synthetic */ tF t0(kR kR2, tF tF2) {
        kR2.SN = tF2;
        return tF2;
    }

    /*
     * Unable to fully structure code
     */
    private void v(q var1_1) {
        var1_1.yq = null;
        block0: while (true) {
            if ((var1_1 = this.N) == q.N) {
                return;
            }
            var3_3 = null;
            while (var1_1 != null) {
                var4_4 = var1_1.SN;
                if (var1_1.yq != null) {
                    var2_2 = var1_1;
                } else if (var3_3 != null) {
                    var3_3.SN = var4_4;
                    var2_2 = var3_3;
                    if (var3_3.yq == null) {
                        continue block0;
                    }
                } else {
                    var2_2 = var3_3;
                    if (kR.i.N(this, var1_1, var4_4)) ** break;
                    continue block0;
                }
                var1_1 = var4_4;
                var3_3 = var2_2;
            }
            break;
        }
    }

    static /* synthetic */ Object zH(kR kR2, Object object) {
        kR2.yq = object;
        return object;
    }

    @Override
    protected final Throwable SN() {
        Object object;
        if (this instanceof Gc && (object = this.yq) instanceof N) {
            return ((N)object).yq;
        }
        return null;
    }

    protected String W() {
        if (this instanceof ScheduledFuture) {
            long l = ((ScheduledFuture)((Object)this)).getDelay(TimeUnit.MILLISECONDS);
            StringBuilder stringBuilder = new StringBuilder(41);
            stringBuilder.append("remaining delay=[");
            stringBuilder.append(l);
            stringBuilder.append(" ms]");
            return stringBuilder.toString();
        }
        return null;
    }

    @Override
    public boolean cancel(boolean bl) {
        block7: {
            Object object = this.yq;
            boolean bl2 = true;
            boolean bl3 = object == null;
            if (bl3 | object instanceof i) {
                Object object2;
                SN sN;
                if (tF) {
                    sN = new SN(bl, new CancellationException("Future.cancel() was called."));
                    object2 = object;
                } else {
                    object2 = bl ? com.github.catvod.spider.merge.kR$SN.N : com.github.catvod.spider.merge.kR$SN.tF;
                    Objects.requireNonNull(object2);
                    sN = object2;
                    object2 = object;
                }
                do {
                    if (i.SN(this, object2, sN)) {
                        if (bl) {
                            this.v3();
                        }
                        kR.G(this);
                        if (!(object2 instanceof i)) {
                            bl = bl2;
                            break block7;
                        }
                        Objects.requireNonNull((i)object2);
                        throw null;
                    }
                    object2 = object = this.yq;
                } while (object instanceof i);
            }
            bl = false;
        }
        return bl;
    }

    protected boolean ee(V v2) {
        Object object = v2;
        if (v2 == null) {
            object = t0;
        }
        if (i.SN(this, null, object)) {
            kR.G(this);
            return true;
        }
        return false;
    }

    protected boolean g9(Throwable object) {
        Objects.requireNonNull(object);
        object = new N((Throwable)object);
        if (i.SN(this, null, object)) {
            kR.G(this);
            return true;
        }
        return false;
    }

    @Override
    public V get() {
        if (!Thread.interrupted()) {
            Object object = this.yq;
            boolean bl = object != null;
            if (bl & (object instanceof i ^ true)) {
                return this.dT(object);
            }
            object = this.N;
            if (object != q.N) {
                q q4;
                q q5 = new q();
                do {
                    kR.i.i(q5, (q)object);
                    if (i.N(this, (q)object, q5)) {
                        block6: {
                            do {
                                LockSupport.park(this);
                                if (Thread.interrupted()) break block6;
                            } while (!((bl = (object = this.yq) != null) & (object instanceof i ^ true)));
                            return this.dT(object);
                        }
                        this.v(q5);
                        throw new InterruptedException();
                    }
                    q4 = this.N;
                    object = q4;
                } while (q4 != q.N);
            }
            object = this.yq;
            Objects.requireNonNull(object);
            return this.dT(object);
        }
        InterruptedException interruptedException = new InterruptedException();
        throw interruptedException;
    }

    @Override
    public V get(long l, TimeUnit object) {
        long l2 = ((TimeUnit)((Object)object)).toNanos(l);
        if (!Thread.interrupted()) {
            Object object2;
            Object object3;
            long l5;
            long l6;
            int n2;
            Object object4;
            block17: {
                object4 = this.yq;
                n2 = object4 != null ? 1 : 0;
                if (n2 & (object4 instanceof i ^ true)) {
                    return this.dT(object4);
                }
                l6 = l2 > 0L ? System.nanoTime() + l2 : 0L;
                l5 = l2;
                if (l2 >= 1000L) {
                    object4 = this.N;
                    if (object4 != q.N) {
                        object3 = new q();
                        do {
                            kR.i.i((q)object3, (q)object4);
                            if (i.N(this, (q)object4, (q)object3)) {
                                block16: {
                                    do {
                                        LockSupport.parkNanos(this, Math.min(l2, 2147483647999999999L));
                                        if (Thread.interrupted()) break block16;
                                        object4 = this.yq;
                                        n2 = object4 != null ? 1 : 0;
                                        if (n2 & (object4 instanceof i ^ true)) {
                                            return this.dT(object4);
                                        }
                                        l2 = l5 = l6 - System.nanoTime();
                                    } while (l5 >= 1000L);
                                    this.v((q)object3);
                                    break block17;
                                }
                                this.v((q)object3);
                                throw new InterruptedException();
                            }
                            object4 = object2 = this.N;
                        } while (object2 != q.N);
                    }
                    object = this.yq;
                    Objects.requireNonNull(object);
                    return this.dT(object);
                }
            }
            while (l5 > 0L) {
                object4 = this.yq;
                n2 = object4 != null ? 1 : 0;
                if (n2 & (object4 instanceof i ^ true)) {
                    return this.dT(object4);
                }
                if (!Thread.interrupted()) {
                    l5 = l6 - System.nanoTime();
                    continue;
                }
                throw new InterruptedException();
            }
            object3 = this.toString();
            object2 = object.toString();
            object4 = Locale.ROOT;
            String string = ((String)object2).toLowerCase((Locale)object4);
            object4 = object.toString().toLowerCase((Locale)object4);
            object2 = new StringBuilder(String.valueOf(object4).length() + 28);
            ((StringBuilder)object2).append("Waited ");
            ((StringBuilder)object2).append(l);
            ((StringBuilder)object2).append(" ");
            ((StringBuilder)object2).append((String)object4);
            object4 = object2 = ((StringBuilder)object2).toString();
            if (l5 + 1000L < 0L) {
                object4 = String.valueOf(object2).concat(" (plus ");
                l5 = -l5;
                l = ((TimeUnit)((Object)object)).convert(l5, TimeUnit.NANOSECONDS);
                n2 = l != 0L && (l5 -= ((TimeUnit)((Object)object)).toNanos(l)) <= 1000L ? 0 : 1;
                object = object4;
                if (l > 0L) {
                    object = String.valueOf(object4);
                    int n3 = ((String)object).length();
                    object4 = new StringBuilder(String.valueOf(string).length() + (n3 + 21));
                    ((StringBuilder)object4).append((String)object);
                    ((StringBuilder)object4).append(l);
                    ((StringBuilder)object4).append(" ");
                    ((StringBuilder)object4).append(string);
                    object = object4 = ((StringBuilder)object4).toString();
                    if (n2 != 0) {
                        object = String.valueOf(object4).concat(",");
                    }
                    object = String.valueOf(object).concat(" ");
                }
                object4 = object;
                if (n2 != 0) {
                    object4 = String.valueOf(object);
                    object = new StringBuilder(((String)object4).length() + 33);
                    ((StringBuilder)object).append((String)object4);
                    ((StringBuilder)object).append(l5);
                    ((StringBuilder)object).append(" nanoseconds ");
                    object4 = ((StringBuilder)object).toString();
                }
                object4 = String.valueOf(object4).concat("delay)");
            }
            if (this.isDone()) {
                throw new TimeoutException(String.valueOf(object4).concat(" but future completed as timeout expired"));
            }
            n2 = String.valueOf(object4).length();
            object = new StringBuilder(String.valueOf(object3).length() + (n2 + 5));
            ((StringBuilder)object).append((String)object4);
            ((StringBuilder)object).append(" for ");
            ((StringBuilder)object).append((String)object3);
            throw new TimeoutException(((StringBuilder)object).toString());
        }
        object = new InterruptedException();
        throw object;
    }

    @Override
    public boolean isCancelled() {
        return this.yq instanceof SN;
    }

    @Override
    public boolean isDone() {
        Object object = this.yq;
        boolean bl = object != null;
        return (object instanceof i ^ true) & bl;
    }

    protected void q() {
    }

    /*
     * WARNING - void declaration
     */
    public final String toString() {
        StringBuilder stringBuilder;
        block13: {
            int n2;
            block16: {
                block10: {
                    Object object;
                    block11: {
                        block15: {
                            void var2_5;
                            block14: {
                                block12: {
                                    stringBuilder = new StringBuilder();
                                    object = this.getClass().getName().startsWith("com.google.common.util.concurrent.") ? this.getClass().getSimpleName() : this.getClass().getName();
                                    stringBuilder.append((String)object);
                                    stringBuilder.append('@');
                                    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
                                    stringBuilder.append("[status=");
                                    if (!this.isCancelled()) break block12;
                                    stringBuilder.append("CANCELLED");
                                    break block13;
                                }
                                if (!this.isDone()) break block14;
                                this.KJ(stringBuilder);
                                break block13;
                            }
                            n2 = stringBuilder.length();
                            stringBuilder.append("PENDING");
                            object = this.yq;
                            if (!(object instanceof i)) break block15;
                            stringBuilder.append(", setFuture=[");
                            Objects.requireNonNull((i)object);
                            try {
                                stringBuilder.append((Object)null);
                                break block10;
                            }
                            catch (StackOverflowError stackOverflowError) {
                            }
                            catch (RuntimeException runtimeException) {
                                // empty catch block
                            }
                            stringBuilder.append("Exception thrown from implementation: ");
                            stringBuilder.append(var2_5.getClass());
                            break block10;
                        }
                        try {
                            object = rs_1.B(this.W());
                            break block11;
                        }
                        catch (StackOverflowError stackOverflowError) {
                        }
                        catch (RuntimeException runtimeException) {
                            // empty catch block
                        }
                        String string = String.valueOf(object.getClass());
                        object = new StringBuilder(string.length() + 38);
                        ((StringBuilder)object).append("Exception thrown from implementation: ");
                        ((StringBuilder)object).append(string);
                        object = ((StringBuilder)object).toString();
                    }
                    if (object == null) break block16;
                    stringBuilder.append(", info=[");
                    stringBuilder.append((String)object);
                }
                stringBuilder.append("]");
            }
            if (this.isDone()) {
                stringBuilder.delete(n2, stringBuilder.length());
                this.KJ(stringBuilder);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected void v3() {
    }

    protected final boolean xa() {
        Object object = this.yq;
        boolean bl = object instanceof SN && ((SN)object).yq;
        return bl;
    }

    @Override
    public void yq(Runnable runnable, Executor executor) {
        tF tF2;
        Objects.requireNonNull(executor, "Executor was null.");
        if (!this.isDone() && (tF2 = this.SN) != com.github.catvod.spider.merge.kR$tF.tF) {
            tF tF3;
            tF tF4 = new tF(runnable, executor);
            do {
                tF4.N = tF2;
                if (i.yq(this, tF2, tF4)) {
                    return;
                }
                tF2 = tF3 = this.SN;
            } while (tF3 != com.github.catvod.spider.merge.kR$tF.tF);
        }
        kR.G4(runnable, executor);
    }

    static interface Gc<V>
    extends hE<V> {
    }

    private static final class KJ
    extends yq {
        static final long N;
        static final long SN;
        static final long i;
        static final long tF;
        static final Unsafe yq;
        static final long zH;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        static {
            PrivilegedExceptionAction<Unsafe> privilegedExceptionAction;
            try {
                privilegedExceptionAction = Unsafe.getUnsafe();
            }
            catch (SecurityException securityException) {
                try {
                    privilegedExceptionAction = new PrivilegedExceptionAction<Unsafe>(){

                        public final Unsafe yq() {
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                ((AccessibleObject)field).setAccessible(true);
                                Object object = field.get(null);
                                if (!Unsafe.class.isInstance(object)) continue;
                                return (Unsafe)Unsafe.class.cast(object);
                            }
                            NoSuchFieldError noSuchFieldError = new NoSuchFieldError("the Unsafe");
                            throw noSuchFieldError;
                        }
                    };
                    privilegedExceptionAction = (Unsafe)AccessController.doPrivileged(privilegedExceptionAction);
                }
                catch (PrivilegedActionException privilegedActionException) {
                    throw new RuntimeException("Could not initialize intrinsics", privilegedActionException.getCause());
                }
            }
            try {
                N = ((Unsafe)((Object)privilegedExceptionAction)).objectFieldOffset(kR.class.getDeclaredField("N"));
                SN = ((Unsafe)((Object)privilegedExceptionAction)).objectFieldOffset(kR.class.getDeclaredField("SN"));
                tF = ((Unsafe)((Object)privilegedExceptionAction)).objectFieldOffset(kR.class.getDeclaredField("yq"));
                zH = ((Unsafe)((Object)privilegedExceptionAction)).objectFieldOffset(q.class.getDeclaredField("yq"));
                i = ((Unsafe)((Object)privilegedExceptionAction)).objectFieldOffset(q.class.getDeclaredField("SN"));
                yq = privilegedExceptionAction;
                return;
            }
            catch (Exception exception) {
                int n2 = mV.SN;
                if (exception instanceof RuntimeException) {
                    throw (RuntimeException)exception;
                }
                if (!(exception instanceof Error)) {
                    throw new RuntimeException(exception);
                }
                throw (Error)((Object)exception);
            }
        }

        KJ() {
        }

        @Override
        final boolean N(kR<?> kR2, q q4, q q5) {
            return L.yq(yq, kR2, N, q4, q5);
        }

        @Override
        final boolean SN(kR<?> kR2, Object object, Object object2) {
            return L.yq(yq, kR2, tF, object, object2);
        }

        @Override
        final void i(q q4, q q5) {
            yq.putObject(q4, i, q5);
        }

        @Override
        final void t0(q q4, Thread thread) {
            yq.putObject(q4, zH, thread);
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        @Override
        final tF tF(kR kR2) {
            tF tF2;
            tF tF3 = com.github.catvod.spider.merge.kR$tF.tF;
            do {
                if (tF3 != (tF2 = kR2.SN)) continue;
                return tF2;
            } while (!L.yq(yq, kR2, SN, tF2, tF3));
            return tF2;
        }

        @Override
        final boolean yq(kR<?> kR2, tF tF2, tF tF3) {
            return L.yq(yq, kR2, SN, tF2, tF3);
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        @Override
        final q zH(kR kR2) {
            q q4;
            q q5 = q.N;
            do {
                if (q5 != (q4 = kR2.N)) continue;
                return q4;
            } while (!this.N(kR2, q4, q5));
            return q4;
        }
    }

    static abstract class M<V>
    extends kR<V>
    implements Gc<V> {
        M() {
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

    private static final class N {
        final Throwable yq;

        static {
            new N(new Throwable(){

                /*
                 * Enabled aggressive block sorting
                 * Converted monitor instructions to comments
                 * Lifted jumps to return sites
                 */
                @Override
                public final Throwable fillInStackTrace() {
                    // MONITORENTER : this
                    // MONITOREXIT : this
                    return this;
                }
            });
        }

        N(Throwable throwable) {
            Objects.requireNonNull(throwable);
            this.yq = throwable;
        }
    }

    private static final class SN {
        static final SN N;
        static final SN tF;
        final Throwable SN;
        final boolean yq;

        static {
            if (tF) {
                tF = null;
                N = null;
            } else {
                tF = new SN(false, null);
                N = new SN(true, null);
            }
        }

        SN(boolean bl, Throwable throwable) {
            this.yq = bl;
            this.SN = throwable;
        }
    }

    private static final class i<V>
    implements Runnable {
        @Override
        public final void run() {
            null.yq;
            throw null;
        }
    }

    private static final class q {
        static final q N = new q(false);
        volatile q SN;
        volatile Thread yq;

        q() {
            i.t0(this, Thread.currentThread());
        }

        q(boolean bl) {
        }
    }

    private static final class t0
    extends yq {
        t0() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        final boolean N(kR<?> kR2, q q4, q q5) {
            synchronized (kR2) {
                if (((kR)kR2).N == q4) {
                    kR.M(kR2, q5);
                    return true;
                }
                return false;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        final boolean SN(kR<?> kR2, Object object, Object object2) {
            synchronized (kR2) {
                if (((kR)kR2).yq == object) {
                    kR.zH(kR2, object2);
                    return true;
                }
                return false;
            }
        }

        @Override
        final void i(q q4, q q5) {
            q4.SN = q5;
        }

        @Override
        final void t0(q q4, Thread thread) {
            q4.yq = thread;
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        final tF tF(kR kR2) {
            tF tF2 = com.github.catvod.spider.merge.kR$tF.tF;
            synchronized (kR2) {
                tF tF3 = kR2.SN;
                if (tF3 != tF2) {
                    kR.t0(kR2, tF2);
                }
                return tF3;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        final boolean yq(kR<?> kR2, tF tF2, tF tF3) {
            synchronized (kR2) {
                if (((kR)kR2).SN == tF2) {
                    kR.t0(kR2, tF3);
                    return true;
                }
                return false;
            }
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        final q zH(kR kR2) {
            q q4 = q.N;
            synchronized (kR2) {
                q q5 = kR2.N;
                if (q5 != q4) {
                    kR.M(kR2, q4);
                }
                return q5;
            }
        }
    }

    private static final class tF {
        static final tF tF = new tF();
        tF N;
        final Executor SN;
        final Runnable yq;

        tF() {
            this.yq = null;
            this.SN = null;
        }

        tF(Runnable runnable, Executor executor) {
            this.yq = runnable;
            this.SN = executor;
        }
    }

    private static abstract class yq {
        yq() {
        }

        abstract boolean N(kR<?> var1, q var2, q var3);

        abstract boolean SN(kR<?> var1, Object var2, Object var3);

        abstract void i(q var1, q var2);

        abstract void t0(q var1, Thread var2);

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        abstract tF tF(kR var1);

        abstract boolean yq(kR<?> var1, tF var2, tF var3);

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        abstract q zH(kR var1);
    }

    private static final class zH
    extends yq {
        final AtomicReferenceFieldUpdater<kR, q> N;
        final AtomicReferenceFieldUpdater<q, q> SN;
        final AtomicReferenceFieldUpdater<kR, tF> tF;
        final AtomicReferenceFieldUpdater<q, Thread> yq;
        final AtomicReferenceFieldUpdater<kR, Object> zH;

        zH(AtomicReferenceFieldUpdater<q, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<q, q> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<kR, q> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<kR, tF> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<kR, Object> atomicReferenceFieldUpdater5) {
            this.yq = atomicReferenceFieldUpdater;
            this.SN = atomicReferenceFieldUpdater2;
            this.N = atomicReferenceFieldUpdater3;
            this.tF = atomicReferenceFieldUpdater4;
            this.zH = atomicReferenceFieldUpdater5;
        }

        @Override
        final boolean N(kR<?> kR2, q q4, q q5) {
            boolean bl;
            block1: {
                AtomicReferenceFieldUpdater<kR, q> atomicReferenceFieldUpdater = this.N;
                do {
                    if (!atomicReferenceFieldUpdater.compareAndSet(kR2, q4, q5)) continue;
                    bl = true;
                    break block1;
                } while (atomicReferenceFieldUpdater.get(kR2) == q4);
                bl = false;
            }
            return bl;
        }

        @Override
        final boolean SN(kR<?> kR2, Object object, Object object2) {
            boolean bl;
            block1: {
                AtomicReferenceFieldUpdater<kR, Object> atomicReferenceFieldUpdater = this.zH;
                do {
                    if (!atomicReferenceFieldUpdater.compareAndSet(kR2, object, object2)) continue;
                    bl = true;
                    break block1;
                } while (atomicReferenceFieldUpdater.get(kR2) == object);
                bl = false;
            }
            return bl;
        }

        @Override
        final void i(q q4, q q5) {
            this.SN.lazySet(q4, q5);
        }

        @Override
        final void t0(q q4, Thread thread) {
            this.yq.lazySet(q4, thread);
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        @Override
        final tF tF(kR kR2) {
            tF tF2 = com.github.catvod.spider.merge.kR$tF.tF;
            return this.tF.getAndSet(kR2, tF2);
        }

        @Override
        final boolean yq(kR<?> kR2, tF tF2, tF tF3) {
            boolean bl;
            block1: {
                AtomicReferenceFieldUpdater<kR, tF> atomicReferenceFieldUpdater = this.tF;
                do {
                    if (!atomicReferenceFieldUpdater.compareAndSet(kR2, tF2, tF3)) continue;
                    bl = true;
                    break block1;
                } while (atomicReferenceFieldUpdater.get(kR2) == tF2);
                bl = false;
            }
            return bl;
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        @Override
        final q zH(kR kR2) {
            q q4 = q.N;
            return this.N.getAndSet(kR2, q4);
        }
    }
}

