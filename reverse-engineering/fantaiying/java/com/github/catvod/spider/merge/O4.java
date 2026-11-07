/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.DO;
import com.github.catvod.spider.merge.LJ;
import com.github.catvod.spider.merge.fh;
import com.github.catvod.spider.merge.lC;
import com.github.catvod.spider.merge.ta_1;
import java.util.ArrayList;
import java.util.List;

public class O4
implements lC {
    protected int N = -1;
    protected List<DO> SN = new ArrayList<DO>(100);
    protected boolean tF;
    protected fh yq;

    public O4(fh fh2) {
        this.yq = fh2;
    }

    protected final int B(int n2) {
        boolean bl = this.tF;
        if (bl) {
            return 0;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            DO dO = this.yq.nextToken();
            if (dO instanceof LJ) {
                ((LJ)dO).tF(((ArrayList)this.SN).size());
            }
            ((ArrayList)this.SN).add(dO);
            if (dO.getType() != -1) continue;
            this.tF = true;
            return i2 + 1;
        }
        return n2;
    }

    protected final void G() {
        if (this.N == -1) {
            this.dT(0);
            this.N = this.q(0);
        }
    }

    protected final int G4(int n2) {
        DO dO;
        this.dT(n2);
        int n3 = n2;
        if (n2 >= this.size()) {
            return this.size() - 1;
        }
        while ((dO = (DO)((ArrayList)this.SN).get(n3)).getChannel() != 0) {
            if (dO.getType() == -1) {
                return n3;
            }
            this.dT(++n3);
        }
        return n3;
    }

    @Override
    public final int Gc() {
        return this.N;
    }

    @Override
    public final void KJ() {
        int n2 = this.N;
        n2 = n2 >= 0 && (this.tF ? n2 < ((ArrayList)this.SN).size() - 1 : n2 < ((ArrayList)this.SN).size()) ? 1 : 0;
        if (n2 == 0 && this.t0(1) == -1) {
            throw new IllegalStateException("cannot consume EOF");
        }
        if (this.dT(this.N + 1)) {
            this.N = this.q(this.N + 1);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final String M(DO object, DO object2) {
        if (object == null) return "";
        if (object2 == null) return "";
        object = ta_1.SN(object.N(), object2.N());
        int n2 = ((ta_1)object).yq;
        int n3 = ((ta_1)object).SN;
        if (n2 < 0) return "";
        if (n3 < 0) return "";
        this.G();
        while (this.B(1000) >= 1000) {
        }
        int n4 = n3;
        if (n3 >= ((ArrayList)this.SN).size()) {
            n4 = ((ArrayList)this.SN).size() - 1;
        }
        object2 = new StringBuilder();
        while (n2 <= n4) {
            object = (DO)((ArrayList)this.SN).get(n2);
            if (object.getType() == -1) return ((StringBuilder)object2).toString();
            ((StringBuilder)object2).append(object.getText());
            ++n2;
        }
        return ((StringBuilder)object2).toString();
    }

    @Override
    public final int N() {
        return 0;
    }

    @Override
    public final fh SN() {
        return this.yq;
    }

    protected final boolean dT(int n2) {
        int n3 = ((ArrayList)this.SN).size();
        boolean bl = true;
        n2 = n2 - n3 + 1;
        boolean bl2 = bl;
        if (n2 > 0) {
            bl2 = this.B(n2) >= n2 ? bl : false;
        }
        return bl2;
    }

    @Override
    public final DO get(int n2) {
        if (n2 >= 0 && n2 < ((ArrayList)this.SN).size()) {
            return (DO)((ArrayList)this.SN).get(n2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("token index ");
        stringBuilder.append(n2);
        stringBuilder.append(" out of range 0..");
        stringBuilder.append(((ArrayList)this.SN).size() - 1);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    @Override
    public DO i(int n2) {
        throw null;
    }

    protected int q(int n2) {
        throw null;
    }

    @Override
    public final int size() {
        return ((ArrayList)this.SN).size();
    }

    @Override
    public final int t0(int n2) {
        return this.i(n2).getType();
    }

    @Override
    public final void yq() {
    }

    @Override
    public final void zH(int n2) {
        this.G();
        this.N = this.q(n2);
    }
}

