/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.og;
import com.github.catvod.spider.merge.pv;
import java.util.AbstractCollection;
import java.util.LinkedList;
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.gt
 */
public final class gt_0
implements og {
    @Override
    public final String name() {
        return "ancestor-or-self";
    }

    @Override
    public final pv yq(kb_0 object) {
        LinkedList<hN> linkedList = new LinkedList<hN>();
        object = ((AbstractCollection)object).iterator();
        while (object.hasNext()) {
            hN hN2 = (hN)object.next();
            linkedList.addAll(hN2.Cu());
            linkedList.add(hN2);
        }
        return new pv(new kb_0((List<hN>)linkedList));
    }
}

