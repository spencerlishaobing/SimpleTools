/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.CK;
import com.github.catvod.spider.merge.wg;

public class SY
extends CK {
    public final CK N;
    public final int tF;

    SY(CK cK, int n2) {
        int n3 = cK != null ? wg.SN(wg.zH(wg.i(1, cK), n2), 2) : wg.SN(1, 0);
        super(n3);
        this.N = cK;
        this.tF = n2;
    }

    public static SY M(CK cK, int n2) {
        if (n2 == Integer.MAX_VALUE && cK == null) {
            return CK.SN;
        }
        return new SY(cK, n2);
    }

    @Override
    public int Gc() {
        return 1;
    }

    @Override
    public CK N(int n2) {
        return this.N;
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof SY)) {
            return false;
        }
        if (this.yq != object.hashCode()) {
            return false;
        }
        SY sY = (SY)object;
        if (this.tF != sY.tF || (object = this.N) == null || !((CK)object).equals(sY.N)) {
            bl = false;
        }
        return bl;
    }

    @Override
    public int tF(int n2) {
        return this.tF;
    }

    public String toString() {
        Object object = this.N;
        object = object != null ? object.toString() : "";
        if (((String)object).length() == 0) {
            int n2 = this.tF;
            if (n2 == Integer.MAX_VALUE) {
                return "$";
            }
            return String.valueOf(n2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(this.tF));
        stringBuilder.append(" ");
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }
}

