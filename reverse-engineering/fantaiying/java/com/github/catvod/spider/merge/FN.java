/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.fM;
import com.github.catvod.spider.merge.pv;
import java.util.List;

public final class FN
implements fM {
    @Override
    public final String name() {
        return "position";
    }

    @Override
    public final pv yq(af_1 af_12, List<pv> list) {
        return new pv(Nh.KJ(af_12.q(), af_12.zH()));
    }
}

