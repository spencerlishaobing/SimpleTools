/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.io.File;
import java.io.FileFilter;

final class Ab
implements FileFilter {
    Ab() {
    }

    @Override
    public final boolean accept(File file) {
        return file.getName().equals("MultiDex.lock") ^ true;
    }
}

