/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.function.BinaryOperator;

public final class D5
implements BinaryOperator {
    public static final D5 yq = new D5();

    private /* synthetic */ D5() {
    }

    @Override
    public final Object apply(Object object, Object object2) {
        double d = (Double)object;
        return (Double)object2 + d;
    }
}

