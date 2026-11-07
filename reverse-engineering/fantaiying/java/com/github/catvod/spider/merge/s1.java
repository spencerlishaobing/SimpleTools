/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

public final class s1
extends Error {
    Exception yq;

    public s1(String string, Exception exception) {
        super(string);
        this.yq = exception;
    }

    @Override
    public final String getMessage() {
        Object object = super.getMessage();
        if (object != null) {
            return object;
        }
        Object object2 = this.yq;
        if (object2 != null) {
            object = object2 = ((Throwable)object2).getMessage();
            if (object2 == null) {
                object = this.yq.getClass().toString();
            }
        }
        return object;
    }
}

