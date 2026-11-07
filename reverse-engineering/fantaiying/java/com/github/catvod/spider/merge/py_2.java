/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.co_0;
import java.util.ArrayList;

/*
 * Renamed from com.github.catvod.spider.merge.py
 */
public final class py_2
extends IllegalArgumentException {
    public static final String yq = co_0.class.getName();

    public py_2(String string) {
        super(string);
    }

    @Override
    public final Throwable fillInStackTrace() {
        synchronized (this) {
            super.fillInStackTrace();
            StackTraceElement[] stackTraceElementArray = this.getStackTrace();
            ArrayList<StackTraceElement> arrayList = new ArrayList<StackTraceElement>();
            for (StackTraceElement stackTraceElement : stackTraceElementArray) {
                if (stackTraceElement.getClassName().equals(yq)) continue;
                arrayList.add(stackTraceElement);
            }
            try {
                this.setStackTrace(arrayList.toArray(new StackTraceElement[0]));
                return this;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}

