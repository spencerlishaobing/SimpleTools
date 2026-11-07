/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.co;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.pv;
import java.util.AbstractCollection;
import java.util.LinkedList;

public final class A7
implements co {
    @Override
    public final String name() {
        return "html";
    }

    @Override
    public final pv yq(af_1 object) {
        LinkedList<String> linkedList = new LinkedList<String>();
        object = ((AbstractCollection)((af_1)object).yq()).iterator();
        while (object.hasNext()) {
            linkedList.add(((hN)object.next()).mG());
        }
        return new pv(linkedList);
    }
}

