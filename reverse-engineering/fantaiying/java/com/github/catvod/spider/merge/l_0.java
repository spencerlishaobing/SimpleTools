/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.CK;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.wg;
import java.util.Arrays;

/*
 * Renamed from com.github.catvod.spider.merge.l
 */
public final class l_0
extends CK {
    public final CK[] N;
    public final int[] tF;

    public l_0(CK[] cKArray, int[] nArray) {
        int n2;
        int n3 = cKArray.length;
        int n4 = 0;
        int n5 = 1;
        for (n2 = 0; n2 < n3; ++n2) {
            n5 = wg.i(n5, cKArray[n2]);
        }
        n3 = nArray.length;
        for (n2 = n4; n2 < n3; ++n2) {
            n5 = wg.zH(n5, nArray[n2]);
        }
        super(wg.SN(n5, cKArray.length * 2));
        this.N = cKArray;
        this.tF = nArray;
    }

    @Override
    public final int Gc() {
        return this.tF.length;
    }

    @Override
    public final CK N(int n2) {
        return this.N[n2];
    }

    @Override
    public final boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof l_0)) {
            return false;
        }
        if (this.yq != object.hashCode()) {
            return false;
        }
        object = (l_0)object;
        if (!Arrays.equals(this.tF, ((l_0)object).tF) || !Arrays.equals(this.N, ((l_0)object).N)) {
            bl = false;
        }
        return bl;
    }

    @Override
    public final boolean i() {
        int[] nArray = this.tF;
        boolean bl = false;
        if (nArray[0] == Integer.MAX_VALUE) {
            bl = true;
        }
        return bl;
    }

    @Override
    public final int tF(int n2) {
        return this.tF[n2];
    }

    public final String toString() {
        if (this.i()) {
            return "[]";
        }
        StringBuilder stringBuilder = oi_0.yq("[");
        for (int i2 = 0; i2 < this.tF.length; ++i2) {
            Object object;
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            if ((object = this.tF)[i2] == Integer.MAX_VALUE) {
                object = "$";
            } else {
                stringBuilder.append(object[i2]);
                if (this.N[i2] != null) {
                    stringBuilder.append(' ');
                    object = this.N[i2].toString();
                } else {
                    object = "null";
                }
            }
            stringBuilder.append((String)object);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

