/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.io.IOException;
import java.io.InputStream;

/*
 * Renamed from com.github.catvod.spider.merge.uO
 */
final class uo_0
extends InputStream {
    private byte[] N = new byte[1];
    private long SN = 0L;
    private long tF;
    private InputStream yq;

    public uo_0(InputStream inputStream, long l) {
        this.yq = inputStream;
        this.tF = l;
    }

    @Override
    public final void close() {
        this.yq.close();
    }

    @Override
    public final int read() {
        if (this.read(this.N) == -1) {
            return -1;
        }
        return this.N[0];
    }

    @Override
    public final int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public final int read(byte[] byArray, int n2, int n3) {
        long l = this.tF;
        int n4 = n3;
        if (l != -1L) {
            long l2 = this.SN;
            if (l2 >= l) {
                return -1;
            }
            n4 = n3;
            if ((long)n3 > l - l2) {
                n4 = (int)(l - l2);
            }
        }
        if ((n2 = this.yq.read(byArray, n2, n4)) > 0) {
            this.SN += (long)n2;
        }
        return n2;
    }

    public final int yq(byte[] byArray) {
        int n2;
        int n3 = n2 = this.yq.read(byArray);
        if (n2 != byArray.length) {
            int n4 = byArray.length - n2;
            int n5 = 0;
            for (n3 = 0; n2 < byArray.length && n5 != -1 && n3 < 15; ++n3) {
                int n7 = n5 + this.yq.read(byArray, n2, n4);
                int n8 = n2;
                n5 = n4;
                if (n7 > 0) {
                    n8 = n2 + n7;
                    n5 = n4 - n7;
                }
                n2 = n8;
                n4 = n5;
                n5 = n7;
            }
            if (n2 == byArray.length) {
                n3 = n2;
            } else {
                throw new IOException("Cannot read fully into byte buffer");
            }
        }
        return n3;
    }
}

