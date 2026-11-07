/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.fM;
import com.github.catvod.spider.merge.pv;
import java.util.LinkedList;
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.qb
 */
public final class qb_0
implements fM {
    @Override
    public final String name() {
        return "contains";
    }

    @Override
    public final pv yq(af_1 object, List<pv> list) {
        object = (LinkedList)list;
        return new pv(((pv)((LinkedList)object).get(0)).t0().contains(((pv)((LinkedList)object).get(1)).t0()));
    }
}

