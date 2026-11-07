/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.CK;
import com.github.catvod.spider.merge.Nv;
import com.github.catvod.spider.merge.j;
import com.github.catvod.spider.merge.wg;

public class C {
    public CK N;
    public final int SN;
    public int tF;
    public final j yq;
    public final Nv zH;

    public C(C c, j j3, CK cK, Nv nv) {
        this.yq = j3;
        this.SN = c.SN;
        this.N = cK;
        this.zH = nv;
        this.tF = c.tF;
    }

    public C(j j3, int n, CK cK, Nv nv) {
        this.yq = j3;
        this.SN = n;
        this.N = cK;
        this.zH = nv;
    }

    public final boolean N() {
        boolean bl = (this.tF & 0x40000000) != 0;
        return bl;
    }

    public final int SN() {
        return this.tF & 0xBFFFFFFF;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof C)) {
            return false;
        }
        return this.yq((C)object);
    }

    public int hashCode() {
        return wg.SN(wg.i(wg.i(wg.zH(wg.zH(7, this.yq.SN), this.SN), this.N), this.zH), 4);
    }

    public final String toString() {
        Nv nv;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        stringBuilder.append(this.yq);
        stringBuilder.append(",");
        stringBuilder.append(this.SN);
        if (this.N != null) {
            stringBuilder.append(",[");
            stringBuilder.append(this.N.toString());
            stringBuilder.append("]");
        }
        if ((nv = this.zH) != null && nv != Nv.yq) {
            stringBuilder.append(",");
            stringBuilder.append(this.zH);
        }
        if (this.SN() > 0) {
            stringBuilder.append(",up=");
            stringBuilder.append(this.SN());
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public boolean yq(C c) {
        CK cK;
        CK cK2;
        boolean bl = true;
        if (this == c) {
            return true;
        }
        if (c == null) {
            return false;
        }
        if (this.yq.SN != c.yq.SN || this.SN != c.SN || (cK2 = this.N) != (cK = c.N) && (cK2 == null || !cK2.equals(cK)) || !this.zH.equals(c.zH) || this.N() != c.N()) {
            bl = false;
        }
        return bl;
    }
}

