/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.cr_0;

public final class Ei {
    public static final Ei B;
    public static final Ei Gc;
    public static final Ei KJ;
    public static final Ei M;
    public static final Ei q;
    public static final Ei t0;
    private final cr_0 N;
    private final int[] SN;
    private final int i;
    private final int tF;
    private final int[] yq;
    private final int zH;

    static {
        t0 = new Ei(4201, 4096, 1);
        Gc = new Ei(1033, 1024, 1);
        M = new Ei(67, 64, 1);
        KJ = new Ei(19, 16, 1);
        q = new Ei(285, 256, 0);
        B = new Ei(301, 256, 1);
    }

    public Ei(int n2, int n3, int n4) {
        this.zH = n2;
        this.tF = n3;
        this.i = n4;
        this.yq = new int[n3];
        this.SN = new int[n3];
        n4 = 1;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n5;
            this.yq[i2] = n4;
            n4 = n5 = n4 << 1;
            if (n5 < n3) continue;
            n4 = (n5 ^ n2) & n3 - 1;
        }
        for (n2 = 0; n2 < n3 - 1; ++n2) {
            this.SN[this.yq[n2]] = n2;
        }
        this.N = new cr_0(this, new int[]{0});
        new cr_0(this, new int[]{1});
    }

    public final int N() {
        return this.i;
    }

    final int SN(int n2) {
        return this.yq[n2];
    }

    final int i(int n2) {
        if (n2 != 0) {
            return this.SN[n2];
        }
        throw new IllegalArgumentException();
    }

    final int t0(int n2, int n3) {
        if (n2 != 0 && n3 != 0) {
            int[] nArray = this.yq;
            int[] nArray2 = this.SN;
            return nArray[(nArray2[n2] + nArray2[n3]) % (this.tF - 1)];
        }
        return 0;
    }

    final cr_0 tF() {
        return this.N;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("GF(0x");
        stringBuilder.append(Integer.toHexString(this.zH));
        stringBuilder.append(',');
        stringBuilder.append(this.tF);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    final cr_0 yq(int n2, int n3) {
        if (n2 >= 0) {
            if (n3 == 0) {
                return this.N;
            }
            int[] nArray = new int[n2 + 1];
            nArray[0] = n3;
            return new cr_0(this, nArray);
        }
        throw new IllegalArgumentException();
    }

    final int zH(int n2) {
        if (n2 != 0) {
            return this.yq[this.tF - this.SN[n2] - 1];
        }
        throw new ArithmeticException();
    }
}

