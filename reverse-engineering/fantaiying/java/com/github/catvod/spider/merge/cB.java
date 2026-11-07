/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.o;

public final class cB
extends o {
    public static final cB yq = new cB();

    @Override
    public final int Zm(Object object) {
        if (object == null) {
            return 0;
        }
        return object.hashCode();
    }

    @Override
    public final boolean b(Object object, Object object2) {
        if (object == null) {
            boolean bl = object2 == null;
            return bl;
        }
        return object.equals(object2);
    }
}

