/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.concurrent.CancellationException;

public final class r6
extends CancellationException {
    public r6(Throwable throwable) {
        this.initCause(throwable);
    }
}

