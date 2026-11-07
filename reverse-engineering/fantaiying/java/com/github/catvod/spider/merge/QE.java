/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.fn_0;
import com.github.catvod.spider.merge.iQ;
import com.github.catvod.spider.merge.io;
import com.github.catvod.spider.merge.mu;
import com.github.catvod.spider.merge.vd_0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

public final class QE
implements mu {
    private Boolean N;
    private volatile mu SN;
    private Queue<io> i;
    private final boolean t0;
    private Method tF;
    private final String yq;
    private fn_0 zH;

    public QE(String string, Queue<io> queue, boolean bl) {
        this.yq = string;
        this.i = queue;
        this.t0 = bl;
    }

    public final boolean N() {
        return this.SN instanceof vd_0;
    }

    public final boolean SN() {
        Boolean bl = this.N;
        if (bl != null) {
            return bl;
        }
        try {
            this.tF = this.SN.getClass().getMethod("log", iQ.class);
            this.N = Boolean.TRUE;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            this.N = Boolean.FALSE;
        }
        return this.N;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && QE.class == object.getClass()) {
            object = (QE)object;
            return this.yq.equals(((QE)object).yq);
        }
        return false;
    }

    @Override
    public final String getName() {
        return this.yq;
    }

    public final int hashCode() {
        return this.yq.hashCode();
    }

    public final void i(mu mu2) {
        this.SN = mu2;
    }

    public final boolean tF() {
        boolean bl = this.SN == null;
        return bl;
    }

    @Override
    public final void yq(String string, Throwable throwable) {
        mu mu2;
        if (this.SN != null) {
            mu2 = this.SN;
        } else if (this.t0) {
            mu2 = vd_0.yq;
        } else {
            if (this.zH == null) {
                this.zH = new fn_0(this, this.i);
            }
            mu2 = this.zH;
        }
        mu2.yq(string, throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zH(iQ iQ2) {
        if (!this.SN()) return;
        try {
            this.tF.invoke(this.SN, iQ2);
            return;
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
            return;
        }
    }
}

