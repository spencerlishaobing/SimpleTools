/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.I8;
import com.github.catvod.spider.merge.NJ;
import com.github.catvod.spider.merge.Ud;
import com.github.catvod.spider.merge.cp;
import com.github.catvod.spider.merge.mt_0;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public abstract class RL<T> {
    private final ExecutorService N;
    private final boolean SN;
    private final Ud yq;

    public RL(SN sN) {
        this.yq = sN.yq;
        this.SN = false;
        this.N = sN.SN;
    }

    static /* synthetic */ ExecutorService N(RL rL) {
        return rL.N;
    }

    static /* synthetic */ void SN(RL rL, Object object, Ud ud) {
        rL.i(object, ud);
    }

    private void i(T t, Ud ud) {
        try {
            this.zH(t, ud);
            ud.yq();
            return;
        }
        catch (Exception exception) {
            ud.SN();
            throw new mt_0(exception);
        }
        catch (mt_0 mt_02) {
            ud.SN();
            throw mt_02;
        }
    }

    static /* synthetic */ Ud yq(RL rL) {
        return rL.yq;
    }

    protected final void t0() {
        Objects.requireNonNull(this.yq);
    }

    public final void tF(T t) {
        if (this.SN && cp.yq(2, this.yq.tF())) {
            throw new mt_0("invalid operation - Zip4j is in busy state");
        }
        this.yq.N();
        this.yq.zH();
        Objects.requireNonNull(this.yq);
        if (this.SN) {
            Iterator<NJ> iterator = ((I8)this).M().yq().yq().iterator();
            long l = 0L;
            while (iterator.hasNext()) {
                NJ nJ = iterator.next();
                long l2 = nJ.V() != null && nJ.V().U() > 0L ? nJ.V().U() : nJ.Z();
                l += l2;
            }
            this.yq.i(l);
            this.N.execute(new Runnable(this, t){
                final RL SN;
                final Object yq;
                {
                    this.SN = rL;
                    this.yq = object;
                }

                /*
                 * Unable to fully structure code
                 */
                @Override
                public final void run() {
                    try {
                        var1_1 = this.SN;
                        RL.SN(var1_1, this.yq, RL.yq(var1_1));
                    }
                    catch (Throwable var1_2) {
                        RL.N(this.SN).shutdown();
                        throw var1_2;
                    }
lbl8:
                    // 2 sources

                    while (true) {
                        RL.N(this.SN).shutdown();
                        return;
                    }
                    catch (mt_0 var1_3) {
                        ** continue;
                    }
                }
            });
        } else {
            this.i(t, this.yq);
        }
    }

    protected abstract void zH(T var1, Ud var2);

    public static final class SN {
        private final ExecutorService SN;
        private final Ud yq;

        public SN(ExecutorService executorService, Ud ud) {
            this.SN = executorService;
            this.yq = ud;
        }
    }
}

