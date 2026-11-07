/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.YG;
import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.co;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.pv;
import java.util.AbstractCollection;

public final class aA
implements co {
    @Override
    public final String name() {
        return "node";
    }

    @Override
    public final pv yq(af_1 object) {
        kb_0 kb_02 = new kb_0();
        for (hN hN2 : ((af_1)object).yq()) {
            ((AbstractCollection)kb_02).addAll(hN2.J());
            String string = hN2.kR();
            if (!YG.tF(string)) continue;
            hN2 = new hN("");
            hN2.RQ(string);
            ((AbstractCollection)kb_02).add(hN2);
        }
        return new pv(kb_02);
    }
}

