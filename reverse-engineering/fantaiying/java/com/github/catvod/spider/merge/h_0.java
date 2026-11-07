/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.qk;
import java.io.Writer;

/*
 * Renamed from com.github.catvod.spider.merge.h
 */
@Deprecated
public final class h_0
extends qk {
    private final qk[] SN;

    public h_0(qk ... qkArray) {
        this.SN = (qk[])((Object[])qkArray.clone());
    }

    @Override
    public final int yq(CharSequence charSequence, int n2, Writer writer) {
        qk[] qkArray = this.SN;
        int n3 = qkArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = qkArray[i2].yq(charSequence, n2, writer);
            if (n4 == 0) continue;
            return n4;
        }
        return 0;
    }
}

