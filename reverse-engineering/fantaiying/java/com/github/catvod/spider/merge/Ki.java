/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.io.File;
import java.util.Comparator;

public final class Ki
implements Comparator {
    public static final Ki yq = new Ki();

    private /* synthetic */ Ki() {
    }

    public final int compare(Object object, Object object2) {
        object = (File)object;
        object2 = (File)object2;
        return ((File)object).getName().compareTo(((File)object2).getName());
    }
}

