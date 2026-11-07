/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.FE;
import com.github.catvod.spider.merge.Mx;
import com.github.catvod.spider.merge.Q4;
import com.github.catvod.spider.merge.V2;
import com.github.catvod.spider.merge.qQ;
import com.github.catvod.spider.merge.si_0;
import com.github.catvod.spider.merge.vb;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class QY {
    public final int N;
    public volatile Mx SN;
    public final V2 tF;
    public final Map<Mx, Mx> yq = new HashMap<Mx, Mx>();
    private final boolean zH;

    public QY(V2 object, int n2) {
        this.tF = object;
        this.N = n2;
        boolean bl = object instanceof si_0;
        boolean bl2 = true;
        if (bl && ((si_0)object).KJ) {
            object = new Mx(new Q4(true));
            ((Mx)object).N = new Mx[0];
            ((Mx)object).tF = false;
            ((Mx)object).t0 = false;
            this.SN = object;
        } else {
            bl2 = false;
        }
        this.zH = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void N(int n2, Mx mx) {
        if (!this.zH) {
            throw new IllegalStateException("Only precedence DFAs may contain a precedence start state.");
        }
        if (n2 < 0) {
            return;
        }
        Mx mx2 = this.SN;
        synchronized (mx2) {
            if (n2 >= this.SN.N.length) {
                this.SN.N = Arrays.copyOf(this.SN.N, n2 + 1);
            }
            this.SN.N[n2] = mx;
            return;
        }
    }

    public final boolean SN() {
        return this.zH;
    }

    public final String toString() {
        Object object = FE.zH;
        object = this.SN == null ? "" : new vb(this, (qQ)object).toString();
        return object;
    }

    public final Mx yq(int n2) {
        if (this.zH) {
            if (n2 >= 0 && n2 < this.SN.N.length) {
                return this.SN.N[n2];
            }
            return null;
        }
        throw new IllegalStateException("Only precedence DFAs may contain a precedence start state.");
    }
}

