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

public final class wV
implements og {
    @Override
    public final String name() {
        return "parent";
    }

    @Override
    public final pv yq(kb_0 object) {
        LinkedList<hN> linkedList = new LinkedList<hN>();
        kb_0 kb_02 = new kb_0();
        object = ((AbstractCollection)object).iterator();
        while (object.hasNext()) {
            linkedList.add(((hN)object.next()).L());
        }
        ((AbstractCollection)kb_02).addAll(linkedList);
        return new pv(kb_02);
    }
}

