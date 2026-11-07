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
import java.util.LinkedList;

public final class hf
implements og {
    @Override
    public final String name() {
        return "following-sibling";
    }

    @Override
    public final pv yq(kb_0 object) {
        LinkedList<hN> linkedList = new LinkedList<hN>();
        object = ((AbstractCollection)object).iterator();
        while (object.hasNext()) {
            kb_0 kb_02 = Nh.M((hN)object.next());
            if (kb_02 == null) continue;
            linkedList.addAll(kb_02);
        }
        object = new kb_0();
        ((AbstractCollection)object).addAll(linkedList);
        return new pv(object);
    }
}

