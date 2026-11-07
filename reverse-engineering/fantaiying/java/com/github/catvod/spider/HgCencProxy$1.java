/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider;

import com.github.catvod.spider.HgCencProxy;
import java.util.Comparator;

class HgCencProxy$1
implements Comparator<HgCencProxy.Sample> {
    HgCencProxy$1() {
    }

    @Override
    public int compare(HgCencProxy.Sample sample, HgCencProxy.Sample sample2) {
        return Long.compare(sample.yq, sample2.yq);
    }
}

