/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.DO;
import com.github.catvod.spider.merge.Fp;
import com.github.catvod.spider.merge.Fw;
import com.github.catvod.spider.merge.Ic;
import com.github.catvod.spider.merge.QL;
import com.github.catvod.spider.merge.VQ;
import com.github.catvod.spider.merge.XO;
import com.github.catvod.spider.merge.ei_0;
import com.github.catvod.spider.merge.fU;
import com.github.catvod.spider.merge.hs;
import com.github.catvod.spider.merge.l3;
import com.github.catvod.spider.merge.lC;
import com.github.catvod.spider.merge.ly_1;
import com.github.catvod.spider.merge.md;
import com.github.catvod.spider.merge.rg;
import com.github.catvod.spider.merge.tj_0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

public abstract class Tu
extends VQ<DO, md> {
    protected boolean Gc;
    protected List<l3> KJ;
    private yq M;
    protected final tj_0 i;
    protected boolean q;
    protected ei_0 t0;
    protected Fp tF = new Fp();
    protected lC zH;

    static {
        new WeakHashMap();
    }

    public Tu(lC lC2) {
        tj_0 tj_02;
        this.i = tj_02 = new tj_0();
        tj_02.yq(0);
        this.Gc = true;
        this.zH = null;
        Fp fp = this.tF;
        fp.yq = false;
        fp.N = null;
        fp.SN = -1;
        this.t0 = null;
        this.q = false;
        this.v(this.M);
        this.M = null;
        tj_02.SN();
        tj_02.yq(0);
        fp = this.SN;
        if (fp != null) {
            ((XO)((Object)fp)).yq();
        }
        this.zH = lC2;
    }

    public final void B(ei_0 object, int n2) {
        Object object2;
        this.M(n2);
        this.t0 = object;
        ((ei_0)object).zH = this.zH.i(1);
        if (this.Gc) {
            object = this.t0;
            object2 = (ei_0)((ly_1)object).yq;
            if (object2 != null) {
                ((ei_0)object2).t0(object);
            }
        }
        if ((object = this.KJ) != null) {
            object2 = ((ArrayList)object).iterator();
            while (object2.hasNext()) {
                object = (l3)object2.next();
                object.G(this.t0);
                this.t0.Gc((l3)object);
            }
        }
    }

    public final int F5() {
        if (this.i.tF()) {
            return -1;
        }
        tj_0 tj_02 = this.i;
        return tj_02.N(tj_02.i() - 1);
    }

    public final void G() {
        DO dO;
        Object object;
        if (this.q) {
            object = this.t0;
            dO = this.zH.i(1);
        } else {
            object = this.t0;
            dO = this.zH.i(-1);
        }
        ((ei_0)object).i = dO;
        object = this.KJ;
        if (object != null) {
            for (int i2 = ((ArrayList)object).size() - 1; i2 >= 0; --i2) {
                object = (l3)((ArrayList)this.KJ).get(i2);
                this.t0.M((l3)object);
                object.un(this.t0);
            }
        }
        this.M(this.t0.SN);
        this.t0 = (ei_0)this.t0.yq;
    }

    public final ei_0 G4() {
        return this.t0;
    }

    @Override
    public final boolean Gc(int n2) {
        tj_0 tj_02 = this.i;
        boolean bl = n2 >= tj_02.N(tj_02.i() - 1);
        return bl;
    }

    public final DO KJ() {
        DO dO;
        block4: {
            Object object;
            block5: {
                dO = this.dT();
                if (dO.getType() != -1) {
                    this.zH.KJ();
                }
                boolean bl = (object = this.KJ) != null && !((ArrayList)object).isEmpty();
                if (!this.Gc && !bl) break block4;
                if (!this.tF.yq) break block5;
                ei_0 ei_02 = this.t0;
                object = new hs(dO);
                Objects.requireNonNull(ei_02);
                ei_02.t0(object);
                object = this.KJ;
                if (object == null) break block4;
                object = ((ArrayList)object).iterator();
                while (object.hasNext()) {
                    ((l3)object.next()).yq();
                }
                break block4;
            }
            Iterator iterator = this.t0;
            object = new Ic(dO);
            Objects.requireNonNull(iterator);
            ((ei_0)((Object)iterator)).t0(object);
            iterator = this.KJ;
            if (iterator != null) {
                iterator = ((ArrayList)((Object)iterator)).iterator();
                while (iterator.hasNext()) {
                    ((l3)iterator.next()).RQ((QL)object);
                }
            }
        }
        return dO;
    }

    public final void W(DO dO, String string, fU fU2) {
        int n2 = dO.getLine();
        int n3 = dO.yq();
        ((rg)this.zH()).yq(this, dO, n2, n3, string, fU2);
    }

    public final DO dT() {
        return this.zH.i(1);
    }

    public final void ee(Fp fp) {
        this.tF = fp;
    }

    public final void q(ei_0 ei_02) {
        ei_0 ei_03;
        if (this.Gc && (ei_03 = this.t0) != ei_02 && (ei_03 = (ei_0)ei_03.yq) != null) {
            List<Fw> list = ei_03.tF;
            if (list != null) {
                ((ArrayList)list).remove(((ArrayList)list).size() - 1);
            }
            ei_03.t0(ei_02);
        }
        this.t0 = ei_02;
    }

    public final void v(l3 l32) {
        List<l3> list = this.KJ;
        if (list != null && ((ArrayList)list).remove(l32) && ((ArrayList)this.KJ).isEmpty()) {
            this.KJ = null;
        }
    }

    public final DO v3(int n2) {
        Object object = this.dT();
        if (object.getType() == n2) {
            if (n2 == -1) {
                this.q = true;
            }
            this.tF.M();
            this.KJ();
        } else {
            DO dO = this.tF.t0(this);
            object = dO;
            if (this.Gc) {
                object = dO;
                if (dO.N() == -1) {
                    ei_0 ei_02 = this.t0;
                    object = new hs(dO);
                    Objects.requireNonNull(ei_02);
                    ei_02.t0(object);
                    object = dO;
                }
            }
        }
        return object;
    }

    public final class yq
    implements l3 {
    }
}

