/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.qk;
import java.io.Writer;

@Deprecated
public abstract class CM
extends qk {
    public abstract boolean SN(int var1, Writer var2);

    @Override
    public final int yq(CharSequence charSequence, int n, Writer writer) {
        return this.SN(Character.codePointAt(charSequence, n), writer) ? 1 : 0;
    }
}

