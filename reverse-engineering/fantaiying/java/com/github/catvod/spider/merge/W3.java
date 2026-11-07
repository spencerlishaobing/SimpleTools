/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.TL;
import com.github.catvod.spider.merge.aq;
import com.github.catvod.spider.merge.j;

public final class W3
extends TL {
    public W3(j j3, aq aq2) {
        super(j3, aq2);
    }

    @Override
    public final boolean tF(int n2, int n3) {
        boolean bl = n2 >= 0 && n2 <= n3 && !super.tF(n2, n3);
        return bl;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('~');
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }

    @Override
    public final int yq() {
        return 8;
    }
}

