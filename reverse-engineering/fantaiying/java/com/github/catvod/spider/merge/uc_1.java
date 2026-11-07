/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.C;
import com.github.catvod.spider.merge.CK;
import com.github.catvod.spider.merge.Nv;
import com.github.catvod.spider.merge.V2;
import com.github.catvod.spider.merge.j;
import com.github.catvod.spider.merge.jy_0;
import com.github.catvod.spider.merge.wg;

/*
 * Renamed from com.github.catvod.spider.merge.uc
 */
public final class uc_1
extends C {
    private final jy_0 i;
    private final boolean t0;

    public uc_1(j j3, int n2, CK cK) {
        super(j3, n2, cK, (Nv)Nv.yq);
        this.t0 = false;
        this.i = null;
    }

    public uc_1(uc_1 uc_12, j j3) {
        super(uc_12, j3, uc_12.N, uc_12.zH);
        this.i = uc_12.i;
        this.t0 = uc_1.tF(uc_12, j3);
    }

    public uc_1(uc_1 uc_12, j j3, CK cK) {
        super(uc_12, j3, cK, uc_12.zH);
        this.i = uc_12.i;
        this.t0 = uc_1.tF(uc_12, j3);
    }

    public uc_1(uc_1 uc_12, j j3, jy_0 jy_02) {
        super(uc_12, j3, uc_12.N, uc_12.zH);
        this.i = jy_02;
        this.t0 = uc_1.tF(uc_12, j3);
    }

    private static boolean tF(uc_1 uc_12, j j3) {
        boolean bl = uc_12.t0 || j3 instanceof V2 && ((V2)j3).Gc;
        return bl;
    }

    @Override
    public final int hashCode() {
        return wg.SN(wg.i(wg.zH(wg.i(wg.i(wg.zH(wg.zH(7, this.yq.SN), this.SN), this.N), this.zH), this.t0 ? 1 : 0), this.i), 6);
    }

    public final boolean i() {
        return this.t0;
    }

    @Override
    public final boolean yq(C c) {
        boolean bl = true;
        if (this == c) {
            return true;
        }
        if (!(c instanceof uc_1)) {
            return false;
        }
        Object object = (uc_1)c;
        if (this.t0 != ((uc_1)object).t0) {
            return false;
        }
        jy_0 jy_02 = this.i;
        object = ((uc_1)object).i;
        if (jy_02 == null) {
            if (object != null) {
                bl = false;
            }
        } else {
            bl = ((Object)jy_02).equals(object);
        }
        if (!bl) {
            return false;
        }
        return super.yq(c);
    }

    public final jy_0 zH() {
        return this.i;
    }
}

