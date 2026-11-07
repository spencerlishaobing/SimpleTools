/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Bj;
import com.github.catvod.spider.merge.CK;
import com.github.catvod.spider.merge.Os;
import com.github.catvod.spider.merge.Q6;
import com.github.catvod.spider.merge.Uz;
import com.github.catvod.spider.merge.V2;
import com.github.catvod.spider.merge.Wo;
import com.github.catvod.spider.merge.aq;
import com.github.catvod.spider.merge.bb_0;
import com.github.catvod.spider.merge.j;
import com.github.catvod.spider.merge.ly_1;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class lF {
    public Uz[] Gc;
    public final List<Q6> M;
    public Bj[] N;
    public final List<V2> SN;
    public final int i;
    public int[] t0;
    public Wo[] tF;
    public final List<j> yq = new ArrayList<j>();
    public final int zH;

    public lF(int n2, int n3) {
        this.SN = new ArrayList<V2>();
        new LinkedHashMap();
        this.M = new ArrayList<Q6>();
        this.zH = n2;
        this.i = n3;
    }

    public final aq N(int n2, ly_1 object) {
        if (n2 >= 0 && n2 < ((ArrayList)this.yq).size()) {
            aq aq2 = this.zH((j)((ArrayList)this.yq).get(n2));
            if (!aq2.tF(-2)) {
                return aq2;
            }
            aq aq3 = new aq(new int[0]);
            aq3.N(aq2);
            aq3.Gc();
            while (object != null && ((ly_1)object).SN >= 0 && aq2.tF(-2)) {
                aq2 = this.zH(((Os)((j)((ArrayList)this.yq).get((int)((ly_1)object).SN)).tF((int)0)).N);
                aq3.N(aq2);
                aq3.Gc();
                object = ((ly_1)object).yq;
            }
            if (aq2.tF(-2)) {
                aq3.yq(-1);
            }
            return aq3;
        }
        object = new IllegalArgumentException("Invalid state number.");
        throw object;
    }

    public final V2 SN(int n2) {
        if (!((ArrayList)this.SN).isEmpty()) {
            return (V2)((ArrayList)this.SN).get(n2);
        }
        return null;
    }

    public final aq i(j j3, ly_1 object) {
        bb_0 bb_02 = new bb_0(this);
        aq aq2 = new aq(new int[0]);
        object = object != null ? CK.yq(j3.yq, (ly_1)object) : null;
        bb_02.yq(j3, (CK)object, aq2, new HashSet(), new BitSet());
        return aq2;
    }

    public final int tF() {
        return ((ArrayList)this.SN).size();
    }

    public final void yq(j j3) {
        if (j3 != null) {
            j3.yq = this;
            j3.SN = ((ArrayList)this.yq).size();
        }
        ((ArrayList)this.yq).add(j3);
    }

    public final aq zH(j j3) {
        aq aq2 = j3.i;
        if (aq2 != null) {
            return aq2;
        }
        j3.i = aq2 = this.i(j3, null);
        aq2.M();
        return j3.i;
    }
}

