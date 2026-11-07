/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.CM;
import java.io.Writer;

@Deprecated
public final class IL
extends CM {
    private final int N;
    private final int SN;

    private IL(int n2, int n3) {
        this.SN = n2;
        this.N = n3;
    }

    public static IL N(int n2, int n3) {
        return new IL(n2, n3);
    }

    @Override
    public final boolean SN(int n2, Writer writer) {
        if (n2 >= this.SN && n2 <= this.N) {
            writer.write("&#");
            writer.write(Integer.toString(n2, 10));
            writer.write(59);
            return true;
        }
        return false;
    }
}

