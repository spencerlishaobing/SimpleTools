/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.mt_0;
import com.github.catvod.spider.merge.rs_0;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

public final class DS {
    private final byte[] N;
    private final byte[] SN;
    private final byte[] yq = new byte[2];

    public DS() {
        this.SN = new byte[4];
        this.N = new byte[8];
    }

    private void yq(InputStream inputStream, byte[] byArray, int n) {
        if (rs_0.W(inputStream, byArray, 0, n) == n) {
            return;
        }
        throw new mt_0("Could not fill buffer");
    }

    public final int B(byte[] byArray, int n) {
        byte by2 = byArray[n];
        return (byArray[n + 1] & 0xFF) << 8 | by2 & 0xFF;
    }

    public final long Gc(InputStream inputStream) {
        Arrays.fill(this.N, (byte)0);
        this.yq(inputStream, this.N, 4);
        return this.t0(this.N, 0);
    }

    public final int KJ(InputStream inputStream) {
        byte[] byArray = this.yq;
        this.yq(inputStream, byArray, byArray.length);
        return this.B(this.yq, 0);
    }

    public final long M(RandomAccessFile randomAccessFile) {
        Arrays.fill(this.N, (byte)0);
        randomAccessFile.readFully(this.N, 0, 4);
        return this.t0(this.N, 0);
    }

    public final int N(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.SN);
        return this.tF(this.SN, 0);
    }

    public final int SN(InputStream inputStream) {
        this.yq(inputStream, this.SN, 4);
        return this.tF(this.SN, 0);
    }

    public final long i(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.N);
        return this.t0(this.N, 0);
    }

    public final int q(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.yq);
        return this.B(this.yq, 0);
    }

    public final long t0(byte[] byArray, int n) {
        if (byArray.length - n < 8) {
            Arrays.fill(this.N, (byte)0);
        }
        byte[] byArray2 = this.N;
        int n2 = byArray.length < 8 ? byArray.length - n : 8;
        System.arraycopy(byArray, n, byArray2, 0, n2);
        byArray = this.N;
        return (((((((0L | (long)(byArray[7] & 0xFF)) << 8 | (long)(byArray[6] & 0xFF)) << 8 | (long)(byArray[5] & 0xFF)) << 8 | (long)(byArray[4] & 0xFF)) << 8 | (long)(byArray[3] & 0xFF)) << 8 | (long)(byArray[2] & 0xFF)) << 8 | (long)(byArray[1] & 0xFF)) << 8 | (long)(byArray[0] & 0xFF);
    }

    public final int tF(byte[] byArray, int n) {
        byte by2 = byArray[n];
        byte by3 = byArray[n + 1];
        byte by4 = byArray[n + 2];
        return ((byArray[n + 3] & 0xFF) << 8 | by4 & 0xFF) << 16 | (by2 & 0xFF | (by3 & 0xFF) << 8);
    }

    public final long zH(InputStream inputStream) {
        byte[] byArray = this.N;
        this.yq(inputStream, byArray, byArray.length);
        return this.t0(this.N, 0);
    }
}

