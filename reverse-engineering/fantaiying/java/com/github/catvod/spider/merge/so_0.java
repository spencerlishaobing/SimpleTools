/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.og;
import com.github.catvod.spider.merge.pv;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.LinkedList;

/*
 * Renamed from com.github.catvod.spider.merge.So
 */
public final class so_0
implements og {
    @Override
    public final String name() {
        return "preceding";
    }

    @Override
    public final pv yq(kb_0 object) {
        kb_0 kb_02 = new kb_0();
        LinkedList<hN> linkedList = new LinkedList<hN>();
        object = ((AbstractCollection)object).iterator();
        while (object.hasNext()) {
            hN hN2 = (hN)object.next();
            Object object2 = ((AbstractCollection)hN2.Cu()).iterator();
            while (object2.hasNext()) {
                kb_0 kb_03 = Nh.dT((hN)object2.next());
                if (kb_03 == null) continue;
                linkedList.addAll(kb_03);
            }
            object2 = Nh.dT(hN2);
            if (object2 == null) continue;
            linkedList.addAll((Collection<hN>)object2);
        }
        ((AbstractCollection)kb_02).addAll(linkedList);
        return new pv(kb_02);
    }
}

