/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.CM;
import java.io.Writer;

@Deprecated
public final class Rc
extends CM {
    @Override
    public final boolean SN(int n2, Writer writer) {
        boolean bl = n2 >= 55296 && n2 <= 57343;
        return bl;
    }
}

