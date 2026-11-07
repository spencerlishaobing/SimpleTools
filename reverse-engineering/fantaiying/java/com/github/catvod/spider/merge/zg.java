/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.di;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.k6;
import java.util.List;

abstract class zg
extends iK {
    Object tF;

    zg() {
    }

    private void U() {
        Object object = this.tF;
        if (!(object instanceof k6)) {
            k6 k62 = new k6();
            this.tF = k62;
            if (object != null) {
                k62.Gd(this.v(), (String)object);
            }
        }
    }

    @Override
    public iK B() {
        return this;
    }

    @Override
    protected final List<iK> G() {
        return iK.N;
    }

    final String H() {
        return this.N(this.v());
    }

    @Override
    protected final iK KJ(iK object) {
        zg zg2 = (zg)super.KJ((iK)object);
        object = this.tF;
        if (object instanceof k6) {
            zg2.tF = ((k6)object).KJ();
        }
        return zg2;
    }

    @Override
    public String N(String string) {
        if (!(this.tF instanceof k6)) {
            string = this.v().equals(string) ? (String)this.tF : "";
            return string;
        }
        return super.N(string);
    }

    @Override
    protected final boolean dT() {
        return this.tF instanceof k6;
    }

    public iK g(String string, String string2) {
        if (!(this.tF instanceof k6) && string.equals("#doctype")) {
            this.tF = string2;
        } else {
            this.U();
            string = di.yq(this).zH().SN(string);
            this.tF().Nl(string, string2);
        }
        return this;
    }

    @Override
    protected final void q(String string) {
    }

    @Override
    public int t0() {
        return 0;
    }

    @Override
    public final k6 tF() {
        this.U();
        return (k6)this.tF;
    }

    @Override
    public String yq(String string) {
        this.U();
        return super.yq(string);
    }

    @Override
    public String zH() {
        Object object = this.yq;
        boolean bl = object != null;
        object = bl ? ((iK)object).zH() : "";
        return object;
    }
}

