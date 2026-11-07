/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.C;
import com.github.catvod.spider.merge.PJ;
import com.github.catvod.spider.merge.Q4;
import com.github.catvod.spider.merge.Wo;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;

/*
 * Renamed from com.github.catvod.spider.merge.nV
 */
public final class nv_0 {
    public static int N(Collection<BitSet> object) {
        BitSet bitSet = new BitSet();
        object = object.iterator();
        while (object.hasNext()) {
            bitSet.set(((BitSet)object.next()).nextSetBit(0));
            if (bitSet.cardinality() <= 1) continue;
            return 0;
        }
        return bitSet.nextSetBit(0);
    }

    public static Collection<BitSet> SN(Q4 object) {
        PJ pJ = new PJ();
        Iterator<C> iterator = ((Q4)object).iterator();
        while (iterator.hasNext()) {
            C c = iterator.next();
            BitSet bitSet = (BitSet)pJ.get(c);
            object = bitSet;
            if (bitSet == null) {
                object = new BitSet();
                pJ.put(c, object);
            }
            ((BitSet)object).set(c.SN);
        }
        return pJ.values();
    }

    public static boolean yq(Q4 object) {
        object = ((Q4)object).iterator();
        while (object.hasNext()) {
            if (((C)object.next()).yq instanceof Wo) continue;
            return false;
        }
        return true;
    }
}

