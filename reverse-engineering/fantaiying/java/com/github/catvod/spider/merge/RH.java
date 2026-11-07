/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

public final class RH
extends RuntimeException {
    public RH(String string) {
        super(string);
    }

    public RH(Throwable throwable) {
        super("date format exception!", throwable);
    }
}

