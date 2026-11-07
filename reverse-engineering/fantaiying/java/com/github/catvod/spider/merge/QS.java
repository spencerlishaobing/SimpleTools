/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.og;
import com.github.catvod.spider.merge.pv;
import java.util.AbstractCollection;
import java.util.HashSet;

public final class QS
implements og {
    @Override
    public final String name() {
        return "descendant-or-self";
    }

    @Override
    public final pv yq(kb_0 object) {
        HashSet<hN> hashSet = new HashSet<hN>();
        kb_0 kb_02 = new kb_0();
        object = ((AbstractCollection)object).iterator();
        while (object.hasNext()) {
            hashSet.addAll(((hN)object.next()).Q4());
        }
        ((AbstractCollection)kb_02).addAll(hashSet);
        return new pv(kb_02);
    }
}

