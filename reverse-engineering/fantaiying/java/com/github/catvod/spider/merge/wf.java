/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.fM;
import com.github.catvod.spider.merge.pv;
import java.util.AbstractCollection;
import java.util.LinkedList;
import java.util.List;

public final class wf
implements fM {
    @Override
    public final String name() {
        return "count";
    }

    @Override
    public final pv yq(af_1 object, List<pv> list) {
        object = (LinkedList)list;
        if (((LinkedList)object).size() == 0) {
            return new pv(0);
        }
        return new pv(((AbstractCollection)((pv)((LinkedList)object).get(0)).tF()).size());
    }
}

