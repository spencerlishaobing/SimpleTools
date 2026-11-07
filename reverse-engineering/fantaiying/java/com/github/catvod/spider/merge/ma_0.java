/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Y;
import java.io.InputStream;
import java.io.PushbackInputStream;

/*
 * Renamed from com.github.catvod.spider.merge.ma
 */
abstract class ma_0
extends InputStream {
    protected byte[] SN = new byte[1];
    private Y yq;

    public ma_0(Y y) {
        this.yq = y;
    }

    public void N(PushbackInputStream pushbackInputStream) {
    }

    protected final byte[] SN() {
        return this.yq.N();
    }

    @Override
    public void close() {
        this.yq.close();
    }

    @Override
    public int read() {
        if (this.read(this.SN) == -1) {
            return -1;
        }
        return this.SN[0];
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) {
        return this.yq.read(byArray, n2, n3);
    }

    public void yq(InputStream inputStream) {
        this.yq.yq(inputStream);
    }
}

