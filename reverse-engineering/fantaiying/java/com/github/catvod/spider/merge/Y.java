/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.B7;
import com.github.catvod.spider.merge.cp;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.u5;
import com.github.catvod.spider.merge.uo_0;
import java.io.InputStream;

abstract class Y<T extends u5>
extends InputStream {
    private byte[] N;
    private T SN;
    private byte[] tF = new byte[1];
    private uo_0 yq;
    private B7 zH;

    public Y(uo_0 uo_02, B7 b7, char[] cArray, int n2) {
        this.yq = uo_02;
        this.SN = this.zH(b7, cArray);
        this.zH = b7;
        if (cp.yq(rs_0.G4(b7), 2)) {
            this.N = new byte[n2];
        }
    }

    public final byte[] N() {
        return this.N;
    }

    public final T SN() {
        return this.SN;
    }

    @Override
    public final void close() {
        this.yq.close();
    }

    protected final int i(byte[] byArray) {
        return this.yq.yq(byArray);
    }

    @Override
    public int read() {
        if (this.read(this.tF) == -1) {
            return -1;
        }
        return this.tF[0] & 0xFF;
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) {
        if ((n3 = rs_0.W(this.yq, byArray, n2, n3)) > 0) {
            byte[] byArray2 = this.N;
            if (byArray2 != null) {
                System.arraycopy(byArray, 0, byArray2, 0, n3);
            }
            this.SN.yq(byArray, n2, n3);
        }
        return n3;
    }

    public final B7 tF() {
        return this.zH;
    }

    protected void yq(InputStream inputStream) {
    }

    protected abstract T zH(B7 var1, char[] var2);
}

