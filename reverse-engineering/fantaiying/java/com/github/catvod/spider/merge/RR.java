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

public final class RR
implements og {
    @Override
    public final String name() {
        return "preceding-sibling-one";
    }

    @Override
    public final pv yq(kb_0 object) {
        LinkedList<hN> linkedList = new LinkedList<hN>();
        object = ((AbstractCollection)object).iterator();
        while (object.hasNext()) {
            hN hN2 = (hN)object.next();
            if (hN2.u7() == null) continue;
            linkedList.add(hN2.u7());
        }
        object = new kb_0();
        ((AbstractCollection)object).addAll(linkedList);
        return new pv(object);
    }
}

