/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.il_1;
import com.github.catvod.spider.merge.zg;

public class Ng
extends zg {
    public Ng(String string) {
        this.tF = string;
    }

    static boolean m(StringBuilder stringBuilder) {
        int n2 = stringBuilder.length();
        boolean bl = true;
        if (n2 == 0 || stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
            bl = false;
        }
        return bl;
    }

    @Override
    public final iK B() {
        return this;
    }

    public final String E1() {
        return this.H();
    }

    public Ng Fz() {
        return (Ng)super.M();
    }

    @Override
    void Gd(Appendable appendable, int n2, Va.yq yq2) {
    }

    public final boolean tO() {
        return Nr.tF(this.H());
    }

    @Override
    public final String toString() {
        return this.ee();
    }

    @Override
    public String v() {
        return "#text";
    }

    @Override
    void xa(Appendable appendable, int n2, Va.yq yq2) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        block9: {
            block6: {
                boolean bl4;
                hN hN2;
                block8: {
                    boolean bl5;
                    iK iK2;
                    block7: {
                        bl3 = yq2.t0();
                        iK2 = this.yq;
                        hN2 = iK2 instanceof hN ? (hN)iK2 : null;
                        bl5 = true;
                        bl2 = bl3 && !hN.cp(iK2);
                        if (!bl2) break block6;
                        bl3 = this.SN == 0 && hN2 != null && hN2.I().N() || this.yq instanceof Va;
                        bl = this.W() == null && hN2 != null && hN2.I().N();
                        iK2 = this.W();
                        if (!(iK2 instanceof hN)) break block7;
                        bl4 = bl5;
                        if (((hN)iK2).x(yq2)) break block8;
                    }
                    bl4 = iK2 instanceof Ng && ((Ng)iK2).tO() ? bl5 : false;
                }
                if (bl4 && this.tO()) {
                    return;
                }
                if (this.SN == 0 && hN2 != null && hN2.I().yq() && !this.tO()) {
                    this.v3(appendable, n2, yq2);
                }
                break block9;
            }
            bl3 = false;
            bl = false;
        }
        il_1.tF(appendable, this.H(), yq2, false, bl2, bl3, bl);
    }
}

