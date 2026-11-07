/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.hE;
import com.github.catvod.spider.merge.hy;
import com.github.catvod.spider.merge.jY;
import com.github.catvod.spider.merge.qz_0;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.s0;
import com.github.catvod.spider.merge.tl_0;
import com.github.catvod.spider.merge.x_0;
import com.github.catvod.spider.merge.yE;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Renamed from com.github.catvod.spider.merge.Fo
 */
abstract class fo_0<InputT, OutputT>
extends s0<OutputT> {
    private static final Logger dT = Logger.getLogger(fo_0.class.getName());
    private hy<? extends hE<? extends InputT>> B;
    private final boolean G;
    private final boolean G4;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    fo_0(hy hy2) {
        super(hy2.size());
        this.B = hy2;
        this.G = false;
        this.G4 = false;
    }

    private void Dr(hy<? extends Future<? extends InputT>> object) {
        int n2 = this.s();
        boolean bl = n2 >= 0;
        rs_0.KJ(bl, "Less than 0 remaining futures");
        if (n2 == 0) {
            if (object != null) {
                jY<Future<InputT>> jY2 = ((hy)object).zH();
                while (jY2.hasNext()) {
                    object = (Future)jY2.next();
                    if (object.isCancelled()) continue;
                    try {
                        x_0.g(object);
                        this.Zm();
                        continue;
                    }
                    catch (Throwable throwable) {
                    }
                    catch (ExecutionException executionException) {
                        object = executionException.getCause();
                    }
                    this.H((Throwable)object);
                }
            }
            this.g1();
            this.g();
            this.Fz(yq.SN);
        }
    }

    private void H(Throwable throwable) {
        Objects.requireNonNull(throwable);
        boolean bl = this.G;
        String string = "Input Future failed with Error";
        if (bl && !this.g9(throwable)) {
            boolean bl2;
            block6: {
                Set<Throwable> set = this.n();
                for (Throwable throwable2 = throwable; throwable2 != null; throwable2 = throwable2.getCause()) {
                    if (set.add(throwable2)) continue;
                    bl2 = false;
                    break block6;
                }
                bl2 = true;
            }
            if (bl2) {
                if (!(throwable instanceof Error)) {
                    string = "Got more than one input Future failure. Logging failures after the first";
                }
                dT.log(Level.SEVERE, string, throwable);
                return;
            }
        }
        if (bl = throwable instanceof Error) {
            if (!bl) {
                string = "Got more than one input Future failure. Logging failures after the first";
            }
            dT.log(Level.SEVERE, string, throwable);
        }
    }

    public static /* synthetic */ void b(fo_0 fo_02, hy hy2) {
        fo_02.Dr(hy2);
    }

    /*
     * Unable to fully structure code
     */
    public static void un(fo_0 var0, hE var1_1, int var2_6) {
        block7: {
            Objects.requireNonNull(var0);
            if (!var1_1.isCancelled()) break block7;
            var0.B = null;
            var0.cancel(false);
            {
                catch (Throwable var1_5) {
                    throw var1_5;
                }
            }
        }
        try {
            x_0.g(var1_1);
            var0.Zm();
        }
        catch (Throwable var1_2) {
            ** GOTO lbl22
        }
        catch (ExecutionException var1_3) {
            var1_4 = var1_3.getCause();
lbl22:
            // 2 sources

            var0.H(var1_4);
        }
        return;
        {
            finally {
                var0.Dr(null);
            }
        }
    }

    void Fz(yq yq2) {
        this.B = null;
    }

    @Override
    final void O(Set<Throwable> set) {
        Objects.requireNonNull(set);
        if (!this.isCancelled()) {
            Throwable throwable;
            Objects.requireNonNull(throwable);
            Throwable throwable2 = throwable;
            for (throwable = this.SN(); throwable != null && set.add(throwable); throwable = throwable.getCause()) {
            }
        }
    }

    final void U() {
        yE yE2 = yE.yq;
        Objects.requireNonNull(this.B);
        if (this.B.isEmpty()) {
            this.g();
            return;
        }
        if (this.G) {
            int n2 = 0;
            jY<hE<InputT>> jY2 = this.B.zH();
            while (jY2.hasNext()) {
                hE hE2 = (hE)jY2.next();
                hE2.yq(new qz_0(this, hE2, n2), yE2);
                ++n2;
            }
        } else {
            hy<hE<InputT>> hy2 = this.G4 ? this.B : null;
            hy2 = new tl_0(this, hy2);
            jY<hE<InputT>> jY3 = this.B.zH();
            while (jY3.hasNext()) {
                ((hE)jY3.next()).yq((Runnable)((Object)hy2), yE2);
            }
        }
    }

    @Override
    protected final String W() {
        Serializable serializable = this.B;
        if (serializable != null) {
            String string = String.valueOf(serializable);
            serializable = new StringBuilder(string.length() + 8);
            ((StringBuilder)serializable).append("futures=");
            ((StringBuilder)serializable).append(string);
            return ((StringBuilder)serializable).toString();
        }
        return super.W();
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    abstract void Zm();

    abstract void g();

    @Override
    protected final void q() {
        Object object = this.B;
        this.Fz(yq.yq);
        boolean bl = this.isCancelled();
        boolean bl2 = object != null;
        if (bl & bl2) {
            bl = this.xa();
            object = ((hy)object).zH();
            while (object.hasNext()) {
                ((Future)object.next()).cancel(bl);
            }
        }
    }

    static final class yq
    extends Enum<yq> {
        private static final yq[] N;
        public static final /* enum */ yq SN;
        public static final /* enum */ yq yq;

        static {
            yq yq2;
            yq yq3;
            yq = yq3 = new yq();
            SN = yq2 = new yq();
            N = new yq[]{yq3, yq2};
        }

        public static yq valueOf(String string) {
            return Enum.valueOf(yq.class, string);
        }

        public static yq[] values() {
            return (yq[])N.clone();
        }
    }
}

