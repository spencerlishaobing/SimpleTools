/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.og;
import com.github.catvod.spider.merge.pv;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class op
implements og {
    @Override
    public final String name() {
        return "following";
    }

    @Override
    public final pv yq(kb_0 object) {
        LinkedList<hN> linkedList = new LinkedList<hN>();
        object = ((AbstractCollection)object).iterator();
        while (object.hasNext()) {
            Object object2 = (hN)object.next();
            Iterator iterator = ((AbstractCollection)((hN)object2).Cu()).iterator();
            while (iterator.hasNext()) {
                Object object3 = Nh.M((hN)iterator.next());
                if (object3 == null) continue;
                object3 = ((AbstractCollection)object3).iterator();
                while (object3.hasNext()) {
                    linkedList.addAll(((hN)object3.next()).Q4());
                }
            }
            if ((object2 = Nh.M((hN)object2)) == null) continue;
            object2 = ((AbstractCollection)object2).iterator();
            while (object2.hasNext()) {
                linkedList.addAll(((hN)object2.next()).Q4());
            }
        }
        return new pv(new kb_0((List<hN>)linkedList));
    }
}

