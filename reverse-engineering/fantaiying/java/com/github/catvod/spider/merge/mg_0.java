/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Hj;

/*
 * Renamed from com.github.catvod.spider.merge.mG
 */
final class mg_0
implements Hj.yq {
    mg_0() {
    }

    @Override
    public final int size() {
        return 2;
    }

    @Override
    public final int yq(char[] cArray, int n2) {
        char c = cArray[n2];
        return cArray[n2 + 1] << 16 | c;
    }
}

