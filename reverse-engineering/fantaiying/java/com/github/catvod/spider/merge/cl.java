/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.RH;
import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.fM;
import com.github.catvod.spider.merge.pv;
import java.util.LinkedList;
import java.util.List;

public final class cl
implements fM {
    @Override
    public final String name() {
        return "not";
    }

    @Override
    public final pv yq(af_1 object, List<pv> list) {
        object = (LinkedList)list;
        if (((LinkedList)object).size() == 1) {
            return new pv(((pv)((LinkedList)object).get(0)).yq() ^ true);
        }
        throw new RH("error param in not(bool) function.Please check.");
    }
}

