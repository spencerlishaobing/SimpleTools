/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.YW;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.k6;
import com.github.catvod.spider.merge.l4;
import com.github.catvod.spider.merge.nS;
import com.github.catvod.spider.merge.x1;
import com.github.catvod.spider.merge.xc;
import com.github.catvod.spider.merge.xv;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class jt {
    protected l4 Gc;
    private xc.t0 KJ = new xc.t0();
    protected Map<String, YW> M;
    x1 N;
    nS SN;
    protected String i;
    private xc.i q = new xc.i();
    protected xc t0;
    protected Va tF;
    protected xv yq;
    protected ArrayList<hN> zH;

    jt() {
    }

    protected final boolean Gc(String string) {
        xc.t0 t02 = this.KJ;
        if (this.t0 == t02) {
            t02 = new xc.t0();
        } else {
            t02.OW();
        }
        t02.xa(string);
        return this.zH(t02);
    }

    protected final YW M(String string, l4 l42) {
        YW yW;
        YW yW2 = yW = (YW)((HashMap)this.M).get(string);
        if (yW == null) {
            yW2 = YW.G(string, l42);
            ((HashMap)this.M).put(string, yW2);
        }
        return yW2;
    }

    protected void N(Reader object, xv xv2) {
        Va va2;
        this.tF = va2 = new Va("");
        va2.C7(xv2);
        this.yq = xv2;
        this.Gc = xv2.zH();
        this.SN = object = new nS((Reader)object, 32768);
        boolean bl = xv2.N();
        ((nS)object).k(bl);
        this.t0 = null;
        this.N = new x1(this.SN, xv2.yq());
        this.zH = new ArrayList(32);
        this.M = new HashMap<String, YW>();
        this.i = "";
    }

    protected final boolean SN(String string) {
        int n2 = this.zH.size();
        boolean bl = false;
        if (n2 == 0) {
            return false;
        }
        hN hN2 = this.yq();
        boolean bl2 = bl;
        if (hN2 != null) {
            bl2 = bl;
            if (hN2.nQ().equals(string)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    protected final boolean i(String string) {
        xc xc2 = this.t0;
        xc.i i2 = this.q;
        if (xc2 == i2) {
            i2 = new xc.i();
            i2.xa(string);
            return this.zH(i2);
        }
        i2.OW();
        i2.xa(string);
        return this.zH(i2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean t0(k6 object) {
        xc.t0 t02 = this.KJ;
        if (this.t0 == t02) {
            t02 = new xc.t0();
            t02.tF = "input";
            t02.G4 = object;
            object = t02;
        } else {
            t02.OW();
            t02.tF = "input";
            t02.G4 = object;
            object = t02;
        }
        ((xc.Gc)object).zH = U7.M("input");
        return this.zH((xc)object);
    }

    protected abstract boolean tF(String var1);

    protected final hN yq() {
        int n2 = this.zH.size();
        hN hN2 = n2 > 0 ? this.zH.get(n2 - 1) : this.tF;
        return hN2;
    }

    protected abstract boolean zH(xc var1);
}

