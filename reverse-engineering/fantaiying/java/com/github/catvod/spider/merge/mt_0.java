/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.io.IOException;

/*
 * Renamed from com.github.catvod.spider.merge.Mt
 */
public final class mt_0
extends IOException {
    public mt_0(Exception exception) {
        super(exception);
    }

    public mt_0(String string) {
        super(string);
    }

    public mt_0(String string, int n2) {
        super(string);
    }

    public mt_0(String string, Exception exception) {
        super("Zip headers not found. Probably not a zip file or a corrupted zip file", exception);
    }

    public mt_0(String string, Throwable throwable) {
        super(string, throwable);
    }
}

