/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.jY;
import java.util.NoSuchElementException;

final class q3
extends jY<Object> {
    final Object SN;
    boolean yq;

    q3(Object object) {
        this.SN = object;
    }

    @Override
    public final boolean hasNext() {
        return this.yq ^ true;
    }

    @Override
    public final Object next() {
        if (!this.yq) {
            this.yq = true;
            return this.SN;
        }
        throw new NoSuchElementException();
    }
}

