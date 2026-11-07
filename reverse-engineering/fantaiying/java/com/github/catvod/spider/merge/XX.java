/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.YG;
import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.fM;
import com.github.catvod.spider.merge.pv;
import java.util.LinkedList;
import java.util.List;

public final class XX
implements fM {
    @Override
    public final String name() {
        return "substring-ex";
    }

    @Override
    public final pv yq(af_1 object, List<pv> object2) {
        object = (LinkedList)object2;
        object2 = ((pv)((LinkedList)object).get(0)).t0();
        int n2 = ((pv)((LinkedList)object).get(1)).i().intValue();
        if (((LinkedList)object).get(2) != null) {
            return new pv(YG.KJ((String)object2, n2, ((pv)((LinkedList)object).get(2)).i().intValue()));
        }
        return new pv(YG.M((String)object2, n2));
    }
}

