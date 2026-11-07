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
import java.util.Iterator;
import java.util.LinkedList;

public final class Bp
implements og {
    @Override
    public final String name() {
        return "preceding-sibling";
    }

    @Override
    public final pv yq(kb_0 kb_02) {
        LinkedList<hN> linkedList = new LinkedList<hN>();
        Iterator iterator = ((AbstractCollection)kb_02).iterator();
        while (iterator.hasNext()) {
            kb_02 = Nh.dT((hN)iterator.next());
            if (kb_02 == null) continue;
            linkedList.addAll(kb_02);
        }
        kb_02 = new kb_0();
        ((AbstractCollection)kb_02).addAll(linkedList);
        return new pv(kb_02);
    }
}

