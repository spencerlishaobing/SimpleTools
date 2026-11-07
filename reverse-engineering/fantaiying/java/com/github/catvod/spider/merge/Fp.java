/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.A1;
import com.github.catvod.spider.merge.DO;
import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.Os;
import com.github.catvod.spider.merge.T9;
import com.github.catvod.spider.merge.Tu;
import com.github.catvod.spider.merge.VQ;
import com.github.catvod.spider.merge.Xj;
import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.aq;
import com.github.catvod.spider.merge.ei_0;
import com.github.catvod.spider.merge.fU;
import com.github.catvod.spider.merge.fh;
import com.github.catvod.spider.merge.j;
import com.github.catvod.spider.merge.lC;
import com.github.catvod.spider.merge.lF;
import com.github.catvod.spider.merge.ly_1;
import com.github.catvod.spider.merge.md;
import com.github.catvod.spider.merge.mg_1;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.q2;
import com.github.catvod.spider.merge.qX;
import com.github.catvod.spider.merge.we;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;

public class Fp {
    protected aq N;
    protected int SN = -1;
    protected ei_0 tF;
    protected boolean yq = false;
    protected int zH;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void B(Tu tu) {
        Object object = (j)((ArrayList)((md)tu.SN).yq.yq).get(tu.t0());
        if (this.yq) {
            return;
        }
        int n2 = tu.zH.t0(1);
        Object object2 = we.v3;
        aq aq2 = ((lF)object2).zH((j)object);
        if (aq2.tF(n2)) {
            this.tF = null;
            this.zH = -1;
            return;
        }
        if (aq2.tF(-2)) {
            if (this.tF != null) return;
            this.tF = tu.t0;
            this.zH = tu.t0();
            return;
        }
        n2 = ((j)object).N();
        if (n2 != 3 && n2 != 4 && n2 != 5) {
            switch (n2) {
                default: {
                    return;
                }
                case 9: 
                case 11: {
                    this.KJ(tu);
                    object2 = ((lF)object2).N(tu.t0(), tu.t0);
                    aq2 = this.N(tu);
                    object = new aq(new int[0]);
                    ((aq)object).N((qX)object2);
                    ((aq)object).N(aq2);
                    this.yq(tu, (aq)object);
                    return;
                }
                case 10: 
            }
        }
        if (this.q(tu) == null) throw new Xj(tu);
    }

    public final void Gc(Tu tu, fU object) {
        if (this.yq) {
            return;
        }
        this.yq = true;
        if (object instanceof T9) {
            T9 t9 = (T9)object;
            object = tu.zH;
            object = object != null ? (t9.i().getType() == -1 ? "<EOF>" : object.M(t9.i(), t9.N())) : "<unknown input>";
            StringBuilder stringBuilder = oi_0.yq("no viable alternative at input ");
            stringBuilder.append(this.SN((String)object));
            object = stringBuilder.toString();
            tu.W(t9.N(), (String)object, t9);
        } else if (object instanceof Xj) {
            object = (Xj)object;
            StringBuilder stringBuilder = oi_0.yq("mismatched input ");
            stringBuilder.append(this.zH(((fU)object).N()));
            stringBuilder.append(" expecting ");
            Object object2 = ((fU)object).yq();
            Objects.requireNonNull((we)tu);
            stringBuilder.append(((aq)object2).B(we.dT));
            object2 = stringBuilder.toString();
            tu.W(((fU)object).N(), (String)object2, (fU)object);
        } else if (object instanceof A1) {
            object = (A1)object;
            Objects.requireNonNull((we)tu);
            String string = we.G4[tu.t0.zH()];
            CharSequence charSequence = new StringBuilder();
            charSequence.append("rule ");
            charSequence.append(string);
            charSequence.append(" ");
            charSequence.append(((Throwable)object).getMessage());
            charSequence = charSequence.toString();
            tu.W(((fU)object).N(), (String)charSequence, (fU)object);
        } else {
            PrintStream printStream = System.err;
            StringBuilder stringBuilder = oi_0.yq("unknown recognition error type: ");
            stringBuilder.append(object.getClass().getName());
            printStream.println(stringBuilder.toString());
            tu.W(((fU)object).N(), ((Throwable)object).getMessage(), (fU)object);
        }
    }

    protected final void KJ(Tu tu) {
        if (this.yq) {
            return;
        }
        this.yq = true;
        DO dO = tu.dT();
        String string = this.zH(dO);
        aq aq2 = this.tF(tu);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("extraneous input ");
        stringBuilder.append(string);
        stringBuilder.append(" expecting ");
        stringBuilder.append(aq2.B(we.dT));
        tu.W(dO, stringBuilder.toString(), null);
    }

    public final void M() {
        this.yq = false;
        this.N = null;
        this.SN = -1;
    }

    protected final aq N(Tu object) {
        int n2;
        lF lF2 = ((md)((VQ)object).SN).yq;
        object = ((Tu)object).t0;
        aq aq2 = new aq(new int[0]);
        while (object != null && (n2 = ((ly_1)object).SN) >= 0) {
            aq2.N(lF2.zH(((Os)((j)((ArrayList)lF2.yq).get((int)n2)).tF((int)0)).N));
            object = ((ly_1)object).yq;
        }
        aq2.Gc();
        return aq2;
    }

    protected final String SN(String string) {
        return Z.SN("'", string.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t"), "'");
    }

    public void i(Tu tu, fU object) {
        if (this.SN == tu.zH.Gc() && (object = this.N) != null && ((aq)object).tF(tu.t0())) {
            tu.KJ();
        }
        this.SN = tu.zH.Gc();
        if (this.N == null) {
            this.N = new aq(new int[0]);
        }
        this.N.yq(tu.t0());
        this.yq(tu, this.N(tu));
    }

    protected final DO q(Tu object) {
        int n2 = ((Tu)object).zH.t0(2);
        if (this.tF((Tu)object).tF(n2)) {
            this.KJ((Tu)object);
            ((Tu)object).KJ();
            object = ((Tu)object).dT();
            this.M();
            return object;
        }
        return null;
    }

    public DO t0(Tu object) {
        Object object2;
        Object object3;
        Object object4 = this.q((Tu)object);
        if (object4 != null) {
            ((Tu)object).KJ();
            return object4;
        }
        object4 = ((Tu)object).zH;
        int n2 = 1;
        int n3 = object4.t0(1);
        object4 = ((j)((ArrayList)((md)((VQ)object).SN).yq.yq).get((int)((VQ)object).t0())).tF((int)0).yq;
        if (((md)((VQ)object).SN).yq.i((j)object4, ((Tu)object).t0).tF(n3)) {
            if (!this.yq) {
                this.yq = true;
                object3 = ((Tu)object).dT();
                object4 = this.tF((Tu)object);
                object2 = oi_0.yq("missing ");
                ((StringBuilder)object2).append(((aq)object4).B(we.dT));
                ((StringBuilder)object2).append(" at ");
                ((StringBuilder)object2).append(this.zH((DO)object3));
                ((Tu)object).W((DO)object3, ((StringBuilder)object2).toString(), null);
            }
        } else {
            n2 = 0;
        }
        if (n2 != 0) {
            object3 = ((Tu)object).dT();
            object4 = this.tF((Tu)object);
            n2 = !((aq)object4).i() ? ((aq)object4).zH() : 0;
            if (n2 == -1) {
                object4 = "<missing EOF>";
            } else {
                object4 = oi_0.yq("<missing ");
                ((StringBuilder)object4).append(we.dT.yq(n2));
                ((StringBuilder)object4).append(">");
                object4 = ((StringBuilder)object4).toString();
            }
            DO dO = ((Tu)object).zH.i(-1);
            object2 = object3;
            if (object3.getType() == -1) {
                object2 = object3;
                if (dO != null) {
                    object2 = dO;
                }
            }
            object = ((Tu)object).zH.SN().N();
            object3 = new mg_1<fh, q2>(object2.SN(), object2.SN().SN());
            n3 = object2.getLine();
            int n4 = object2.yq();
            return ((Nh)object).Gc((mg_1)object3, n2, (String)object4, 0, -1, -1, n3, n4);
        }
        object = this.tF == null ? new Xj((Tu)object) : new Xj((Tu)object, this.zH, this.tF);
        throw object;
    }

    protected final aq tF(Tu tu) {
        Objects.requireNonNull(tu);
        return we.v3.N(tu.t0(), tu.t0);
    }

    protected final void yq(Tu tu, aq aq2) {
        int n2;
        lC lC2 = tu.zH;
        while ((n2 = lC2.t0(1)) != -1 && !aq2.tF(n2)) {
            tu.KJ();
            lC2 = tu.zH;
        }
    }

    protected final String zH(DO dO) {
        if (dO == null) {
            return "<no token>";
        }
        String string = dO.getText();
        CharSequence charSequence = string;
        if (string == null) {
            if (dO.getType() == -1) {
                charSequence = "<EOF>";
            } else {
                charSequence = oi_0.yq("<");
                ((StringBuilder)charSequence).append(dO.getType());
                ((StringBuilder)charSequence).append(">");
                charSequence = ((StringBuilder)charSequence).toString();
            }
        }
        return this.SN((String)charSequence);
    }
}

