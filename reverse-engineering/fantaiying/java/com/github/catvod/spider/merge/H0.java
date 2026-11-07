/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.io.PrintStream;

public final class H0
extends Exception {
    protected Throwable yq;

    public H0(String string) {
        super(string);
    }

    public H0(Throwable throwable) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("");
        stringBuffer.append("");
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("caused by: ");
        stringBuffer2.append(throwable);
        stringBuffer.append(stringBuffer2.toString());
        super(stringBuffer.toString());
        this.yq = throwable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void printStackTrace() {
        if (this.yq == null) {
            super.printStackTrace();
            return;
        }
        PrintStream printStream = System.err;
        synchronized (printStream) {
            PrintStream printStream2 = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.getMessage());
            stringBuffer.append("; nested exception is:");
            printStream2.println(stringBuffer.toString());
            this.yq.printStackTrace();
            return;
        }
    }
}

