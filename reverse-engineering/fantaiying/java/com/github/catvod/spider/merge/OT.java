/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.co;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.pv;
import java.util.LinkedList;

public final class OT
implements co {
    @Override
    public final String name() {
        return "allText";
    }

    @Override
    public final pv yq(af_1 object2) {
        LinkedList<Object> linkedList = new LinkedList<Object>();
        for (Object object2 : ((af_1)object2).yq()) {
            object2 = "script".equals(((hN)object2).v()) ? ((hN)object2).lF() : ((hN)object2).Fo();
            linkedList.add(object2);
        }
        return new pv(linkedList);
    }
}

