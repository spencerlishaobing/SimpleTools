/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.fM;
import com.github.catvod.spider.merge.pv;
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.jC
 */
public final class jc_1
implements fM {
    @Override
    public final String name() {
        return "concat";
    }

    @Override
    public final pv yq(af_1 object, List<pv> object2) {
        object = new StringBuilder();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            ((StringBuilder)object).append(((pv)object2.next()).t0());
        }
        return new pv(((StringBuilder)object).toString());
    }
}

