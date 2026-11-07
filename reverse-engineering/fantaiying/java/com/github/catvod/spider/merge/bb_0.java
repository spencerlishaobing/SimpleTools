/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.C;
import com.github.catvod.spider.merge.CK;
import com.github.catvod.spider.merge.Nv;
import com.github.catvod.spider.merge.OB;
import com.github.catvod.spider.merge.Os;
import com.github.catvod.spider.merge.SY;
import com.github.catvod.spider.merge.W3;
import com.github.catvod.spider.merge.Wo;
import com.github.catvod.spider.merge.Yv;
import com.github.catvod.spider.merge.aq;
import com.github.catvod.spider.merge.il_0;
import com.github.catvod.spider.merge.j;
import com.github.catvod.spider.merge.lF;
import com.github.catvod.spider.merge.qX;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Set;

/*
 * Renamed from com.github.catvod.spider.merge.bb
 */
public final class bb_0 {
    public final lF yq;

    public bb_0(lF lF2) {
        this.yq = lF2;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    protected final void yq(j j3, CK cK, aq aq2, Set set, BitSet bitSet) {
        Object object = Nv.yq;
        int n2 = 0;
        if (!set.add(new C(j3, 0, cK, (Nv)object))) {
            return;
        }
        if (j3 == null) {
            if (cK == null) {
                aq2.yq(-2);
                return;
            }
            if (cK.i()) {
                aq2.yq(-1);
                return;
            }
        }
        if (j3 instanceof Wo) {
            if (cK == null) {
                aq2.yq(-2);
                return;
            }
            if (cK.i()) {
                aq2.yq(-1);
                return;
            }
            if (cK != CK.SN) {
                boolean bl = bitSet.get(j3.N);
                try {
                    bitSet.clear(j3.N);
                    while (n2 < cK.Gc()) {
                        this.yq((j)((ArrayList)this.yq.yq).get(cK.tF(n2)), cK.N(n2), aq2, set, bitSet);
                        ++n2;
                    }
                    if (bl) {
                        bitSet.set(j3.N);
                    }
                    return;
                }
                catch (Throwable throwable) {
                    if (bl) {
                        bitSet.set(j3.N);
                    }
                    throw throwable;
                }
            }
        }
        int n3 = j3.SN();
        for (n2 = 0; n2 < n3; ++n2) {
            Object object2;
            Object object3 = j3.tF(n2);
            if (object3.getClass() == Os.class) {
                object = (Os)object3;
                if (bitSet.get(((Yv)object).yq.N)) continue;
                object2 = SY.M(cK, ((Os)object).N.SN);
                try {
                    bitSet.set(((Os)object3).yq.N);
                    this.yq(((Yv)object3).yq, (CK)object2, aq2, set, bitSet);
                    continue;
                }
                finally {
                    bitSet.clear(((Yv)object).yq.N);
                }
            }
            if (object3 instanceof OB || ((Yv)object3).SN()) {
                this.yq(((Yv)object3).yq, cK, aq2, set, bitSet);
                continue;
            }
            if (object3.getClass() == il_0.class) {
                aq2.N(aq.t0(1, this.yq.i));
                continue;
            }
            object2 = ((Yv)object3).N();
            if (object2 == null) continue;
            object = object2;
            if (object3 instanceof W3) {
                object3 = aq.t0(1, this.yq.i);
                if (((aq)object3).i()) {
                    object = null;
                } else if (((aq)object2).i()) {
                    object = new aq(new int[0]);
                    ((aq)object).N((qX)object3);
                } else {
                    object = aq.q((aq)object3, (aq)object2);
                }
            }
            aq2.N((qX)object);
        }
    }
}

