/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Mx;
import java.util.Comparator;

/*
 * Renamed from com.github.catvod.spider.merge.du
 */
final class du_0
implements Comparator<Mx> {
    du_0() {
    }

    @Override
    public final int compare(Object object, Object object2) {
        object = (Mx)object;
        object2 = (Mx)object2;
        return ((Mx)object).yq - ((Mx)object2).yq;
    }
}

