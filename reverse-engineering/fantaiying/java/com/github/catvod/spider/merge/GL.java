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

public final class GL
implements og {
    @Override
    public final String name() {
        return "ancestor";
    }

    @Override
    public final pv yq(kb_0 object) {
        LinkedList<hN> linkedList = new LinkedList<hN>();
        object = ((AbstractCollection)object).iterator();
        while (object.hasNext()) {
            linkedList.addAll(((hN)object.next()).Cu());
        }
        return new pv(new kb_0((List<hN>)linkedList));
    }
}

