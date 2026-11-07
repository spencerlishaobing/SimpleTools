/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.lang.reflect.InvocationTargetException;

public final class mV {
    public static final int SN = 0;
    private static final Object yq;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        block14: {
            var1 = null;
            try {
                var0_1 = Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
            }
            catch (Throwable var0_2) {
                var0_1 = null;
            }
lbl7:
            // 2 sources

            mV.yq = var0_1;
            if (var0_1 != null) {
                var0_1 = Integer.TYPE;
                try {
                    Class.forName("sun.misc.JavaLangAccess", false, null).getMethod("getStackTraceElement", new Class[]{Throwable.class, var0_1});
                }
                catch (Throwable var0_3) {
                    // empty catch block
                }
            }
lbl16:
            // 4 sources

            var2_9 = mV.yq;
            if (var2_9 == null) {
                return;
            }
            try {
                var0_1 = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod("getStackTraceDepth", new Class[]{Throwable.class});
            }
            catch (Throwable var0_4) {
                var0_1 = var1;
            }
lbl24:
            // 2 sources

            if (var0_1 == null) {
                return;
            }
            ** try [egrp 3[TRYBLOCK] [6, 7, 8 : 124->153)] { 
lbl27:
            // 1 sources

            break block14;
lbl28:
            // 3 sources

            catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException var0_8) {
                return;
            }
            catch (ThreadDeath var0_7) {
                throw var0_7;
            }
            ** GOTO lbl7
            catch (ThreadDeath var0_6) {
                throw var0_6;
            }
            ** GOTO lbl16
            catch (ThreadDeath var0_5) {
                throw var0_5;
            }
            ** GOTO lbl24
        }
        var1 = new Throwable();
        var0_1.invoke(var2_9, new Object[]{var1});
    }
}

