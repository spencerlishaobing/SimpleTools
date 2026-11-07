/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.og;
import com.github.catvod.spider.merge.pv;
import java.util.AbstractCollection;

/*
 * Renamed from com.github.catvod.spider.merge.h0
 */
public final class h0_0
implements og {
    @Override
    public final String name() {
        return "child";
    }

    @Override
    public final pv yq(kb_0 object) {
        kb_0 kb_02 = new kb_0();
        object = ((AbstractCollection)object).iterator();
        while (object.hasNext()) {
            ((AbstractCollection)kb_02).addAll(((hN)object.next()).J());
        }
        return new pv(kb_02);
    }
}

