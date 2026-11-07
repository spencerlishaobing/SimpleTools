/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.g8;
import java.util.Objects;

/*
 * Renamed from com.github.catvod.spider.merge.zc
 */
public final class zc_0 {
    public static void yq(StringBuffer stringBuffer, Object object) {
        Objects.requireNonNull(object, new g8("object", new Object[0]));
        String string = object.getClass().getName();
        object = Integer.toHexString(System.identityHashCode(object));
        int n2 = stringBuffer.length();
        int n3 = string.length();
        stringBuffer.ensureCapacity(((String)object).length() + (n3 + n2 + 1));
        stringBuffer.append(string);
        stringBuffer.append('@');
        stringBuffer.append((String)object);
    }
}

