/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.AD;
import com.github.catvod.spider.merge.oi_0;
import java.io.File;

public final class ZQ
extends AD {
    public ZQ(File file, int n2) {
        super(file, true, n2);
    }

    @Override
    protected final File yq(int n2) {
        String string = this.SN.getCanonicalPath();
        StringBuilder stringBuilder = oi_0.yq(string.substring(0, string.lastIndexOf(".")));
        StringBuilder stringBuilder2 = oi_0.yq(".");
        string = n2 < 9 ? "00" : (n2 < 99 ? "0" : "");
        stringBuilder2.append(string);
        stringBuilder2.append(n2 + 1);
        stringBuilder.append(stringBuilder2.toString());
        return new File(stringBuilder.toString());
    }
}

