/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.concurrent.Executor;

final class yE
extends Enum<yE>
implements Executor {
    private static final yE[] SN;
    public static final /* enum */ yE yq;

    static {
        yE yE2;
        yq = yE2 = new yE();
        SN = new yE[]{yE2};
    }

    public static yE valueOf(String string) {
        return Enum.valueOf(yE.class, string);
    }

    public static yE[] values() {
        return (yE[])SN.clone();
    }

    @Override
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}

