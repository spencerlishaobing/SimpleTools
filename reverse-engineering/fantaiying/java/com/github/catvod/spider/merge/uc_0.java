/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.D5;
import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.fM;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.pv;
import com.github.catvod.spider.merge.s8;
import java.math.BigDecimal;
import java.util.AbstractCollection;
import java.util.LinkedList;
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.uC
 */
public final class uc_0
implements fM {
    private Double SN(String string) {
        if (s8.yq.matcher(string).matches()) {
            return Double.parseDouble(string);
        }
        return null;
    }

    @Override
    public final String name() {
        return "sum";
    }

    @Override
    public final pv yq(af_1 object, List<pv> object2) {
        if (object2.isEmpty()) {
            return new pv(0);
        }
        object = new LinkedList();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Double d;
            Object object3 = (pv)object2.next();
            if (((pv)object3).v3()) {
                ((LinkedList)object).add(((pv)object3).N());
            }
            if (((pv)object3).W()) {
                d = this.SN(((pv)object3).t0());
                if (d == null) {
                    return null;
                }
                ((LinkedList)object).add(d);
            }
            if (!((pv)object3).G4()) continue;
            object3 = ((AbstractCollection)((pv)object3).tF()).iterator();
            while (object3.hasNext()) {
                d = this.SN(((hN)object3.next()).kR());
                if (d == null) {
                    return null;
                }
                ((LinkedList)object).add(d);
            }
        }
        if (((Double)(object = object.stream().reduce(0.0, D5.yq))).compareTo(new BigDecimal(((Double)object).longValue()).doubleValue()) == 0) {
            return new pv(new Long(((Double)object).longValue()));
        }
        return new pv(object);
    }
}

