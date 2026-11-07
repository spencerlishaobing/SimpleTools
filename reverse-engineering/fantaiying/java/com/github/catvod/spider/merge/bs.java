/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.io.PrintStream;

public final class bs {
    private static boolean SN;
    private static yq yq;

    private bs() {
    }

    public static final void N(String string, Throwable throwable) {
        System.err.println(string);
        System.err.println("Reported exception:");
        throwable.printStackTrace();
    }

    public static final void SN(String string) {
        PrintStream printStream = System.err;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SLF4J: ");
        stringBuilder.append(string);
        printStream.println(stringBuilder.toString());
    }

    public static Class<?> yq() {
        int n2;
        Object object = yq;
        if (object == null) {
            if (SN) {
                object = null;
            } else {
                try {
                    object = new yq();
                }
                catch (SecurityException securityException) {
                    object = null;
                }
                yq = object;
                SN = true;
            }
        }
        if (object == null) {
            return null;
        }
        object = object.getClassContext();
        String string = bs.class.getName();
        for (n2 = 0; n2 < ((Class<?>[])object).length && !string.equals(object[n2].getName()); ++n2) {
        }
        if (n2 < ((Class<?>[])object).length && (n2 += 2) < ((Class<?>[])object).length) {
            return object[n2];
        }
        object = new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        throw object;
    }

    private static final class yq
    extends SecurityManager {
        yq() {
        }

        @Override
        protected final Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }
}

