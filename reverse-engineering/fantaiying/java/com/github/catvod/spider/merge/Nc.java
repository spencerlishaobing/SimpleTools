/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public final class Nc {
    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public static Locale yq(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return locale;
    }
}

