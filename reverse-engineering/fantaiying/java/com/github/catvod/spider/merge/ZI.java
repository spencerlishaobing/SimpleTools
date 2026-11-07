/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.mu;
import java.io.Serializable;

public abstract class ZI
implements mu,
Serializable {
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append("(");
        stringBuilder.append("NOP");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

