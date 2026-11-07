/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.AD;
import java.io.File;

/*
 * Renamed from com.github.catvod.spider.merge.qY
 */
public final class qy_0
extends AD {
    private int i;

    public qy_0(File file, boolean bl, int n2) {
        super(file, bl, n2);
        this.i = n2;
    }

    @Override
    protected final File yq(int n2) {
        if (n2 == this.i) {
            return this.SN;
        }
        String string = this.SN.getCanonicalPath();
        String string2 = n2 >= 9 ? ".z" : ".z0";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.substring(0, string.lastIndexOf(".")));
        stringBuilder.append(string2);
        stringBuilder.append(n2 + 1);
        return new File(stringBuilder.toString());
    }
}

