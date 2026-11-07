/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import sun.misc.Unsafe;

public final class L {
    public static /* synthetic */ boolean yq(Unsafe unsafe, Object object, long l, Object object2, Object object3) {
        do {
            if (!unsafe.compareAndSwapObject(object, l, object2, object3)) continue;
            return true;
        } while (unsafe.getObject(object, l) == object2);
        return false;
    }
}

