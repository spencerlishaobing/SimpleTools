/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.VQ;
import com.github.catvod.spider.merge.fU;
import com.github.catvod.spider.merge.hC;
import java.io.PrintStream;

public final class uT
extends hC {
    public static final uT yq = new uT();

    @Override
    public final void yq(VQ<?, ?> object, Object object2, int n2, int n3, String string, fU fU2) {
        object = System.err;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("line ");
        ((StringBuilder)object2).append(n2);
        ((StringBuilder)object2).append(":");
        ((StringBuilder)object2).append(n3);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append(string);
        ((PrintStream)object).println(((StringBuilder)object2).toString());
    }
}

