/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nv;
import com.github.catvod.spider.merge.Q4;
import com.github.catvod.spider.merge.jy_0;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.wg;
import java.util.Arrays;

public final class Mx {
    public yq[] Gc;
    public Mx[] N;
    public Q4 SN;
    public jy_0 i;
    public boolean t0;
    public boolean tF;
    public int yq = -1;
    public int zH;

    public Mx() {
        this.SN = new Q4(true);
        this.tF = false;
    }

    public Mx(Q4 q4) {
        new Q4(true);
        this.tF = false;
        this.SN = q4;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Mx)) {
            return false;
        }
        object = (Mx)object;
        return this.SN.equals(((Mx)object).SN);
    }

    public final int hashCode() {
        return wg.SN(wg.zH(7, this.SN.hashCode()), 1);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.yq);
        stringBuilder.append(":");
        stringBuilder.append(this.SN);
        if (this.tF) {
            stringBuilder.append("=>");
            Object[] objectArray = this.Gc;
            if (objectArray != null) {
                stringBuilder.append(Arrays.toString(objectArray));
            } else {
                stringBuilder.append(this.zH);
            }
        }
        return stringBuilder.toString();
    }

    public static final class yq {
        public int SN;
        public Nv yq;

        public yq(Nv nv, int n2) {
            this.SN = n2;
            this.yq = nv;
        }

        public final String toString() {
            StringBuilder stringBuilder = oi_0.yq("(");
            stringBuilder.append(this.yq);
            stringBuilder.append(", ");
            stringBuilder.append(this.SN);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }
}

