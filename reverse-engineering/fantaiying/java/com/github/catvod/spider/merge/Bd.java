/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.DO;
import com.github.catvod.spider.merge.Is;
import com.github.catvod.spider.merge.N2;
import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.VQ;
import com.github.catvod.spider.merge.fh;
import com.github.catvod.spider.merge.mg_1;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.q2;
import com.github.catvod.spider.merge.rg;
import com.github.catvod.spider.merge.ta_1;
import com.github.catvod.spider.merge.tj_0;
import com.github.catvod.spider.merge.zW;

public abstract class Bd
extends VQ<Integer, N2>
implements fh {
    public int B;
    public int G;
    public final tj_0 G4;
    public int Gc = -1;
    public int KJ;
    public int M;
    public int dT = 0;
    protected Is<?> i = Nh.yq;
    public boolean q;
    public DO t0;
    public q2 tF;
    protected mg_1<fh, q2> zH;

    public Bd(q2 q22) {
        this.G4 = new tj_0();
        this.tF = q22;
        this.zH = new mg_1<Bd, q2>(this, q22);
    }

    public final DO KJ() {
        DO dO;
        int n = ((N2)this.SN).t0();
        int n2 = ((N2)this.SN).Gc();
        this.t0 = dO = ((Nh)this.i).Gc(this.zH, -1, null, 0, this.tF.Gc(), this.tF.Gc() - 1, n2, n);
        return dO;
    }

    public final Is<? extends DO> N() {
        return this.i;
    }

    @Override
    public final q2 SN() {
        return this.tF;
    }

    @Override
    public final int getLine() {
        return ((N2)this.SN).Gc();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final DO nextToken() {
        Object object = this.tF;
        if (object == null) {
            object = new IllegalStateException("nextToken requires a non-null input stream.");
            throw object;
        }
        object.N();
        try {
            block13: {
                int n;
                block5: while (true) {
                    if (this.q) {
                        this.KJ();
                        break block13;
                    }
                    this.t0 = null;
                    this.B = 0;
                    this.Gc = this.tF.Gc();
                    this.KJ = ((N2)this.SN).t0();
                    this.M = ((N2)this.SN).Gc();
                    do {
                        this.G = 0;
                        try {
                            n = ((N2)this.SN).M(this.tF, this.dT);
                        }
                        catch (zW zW2) {
                            this.q(zW2);
                            if (this.tF.t0(1) != -1) {
                                ((N2)this.SN).zH(this.tF);
                            }
                            n = -3;
                        }
                        if (this.tF.t0(1) == -1) {
                            this.q = true;
                        }
                        if (this.G == 0) {
                            this.G = n;
                        }
                        if ((n = this.G) == -3) continue block5;
                    } while (n == -2);
                    break;
                }
                if (this.t0 == null) {
                    this.t0 = ((Nh)this.i).Gc(this.zH, n, null, this.B, this.Gc, this.tF.Gc() - 1, this.M, this.KJ);
                }
            }
            object = this.t0;
            return object;
        }
        finally {
            this.tF.yq();
        }
    }

    public final void q(zW zW2) {
        Object object = this.tF;
        object = object.tF(ta_1.SN(this.Gc, object.Gc()));
        StringBuilder stringBuilder = oi_0.yq("token recognition error at: '");
        Object object2 = new StringBuilder();
        for (char c : ((String)object).toCharArray()) {
            object = String.valueOf(c);
            if (c != '\uffffffff') {
                if (c != '\r') {
                    if (c != '\t') {
                        if (c == '\n') {
                            object = "\\n";
                        }
                    } else {
                        object = "\\t";
                    }
                } else {
                    object = "\\r";
                }
            } else {
                object = "<EOF>";
            }
            ((StringBuilder)object2).append((String)object);
        }
        stringBuilder.append(((StringBuilder)object2).toString());
        stringBuilder.append("'");
        object = stringBuilder.toString();
        object2 = this.zH();
        int n = this.M;
        int n2 = this.KJ;
        ((rg)object2).yq(this, null, n, n2, (String)object, zW2);
    }

    @Override
    public final int yq() {
        return ((N2)this.SN).t0();
    }
}

