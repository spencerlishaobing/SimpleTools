/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public final class rP
extends FilterOutputStream {
    public rP(OutputStream outputStream) {
        super(outputStream);
    }

    @Override
    public final void write(int n2) {
        this.write(new byte[]{(byte)n2}, 0, 1);
    }

    @Override
    public final void write(byte[] byArray) {
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public final void write(byte[] byArray, int n2, int n3) {
        if (n3 == 0) {
            return;
        }
        this.out.write(String.format("%x\r\n", n3).getBytes());
        this.out.write(byArray, n2, n3);
        this.out.write("\r\n".getBytes());
    }

    public final void yq() {
        this.out.write("0\r\n\r\n".getBytes());
    }
}

