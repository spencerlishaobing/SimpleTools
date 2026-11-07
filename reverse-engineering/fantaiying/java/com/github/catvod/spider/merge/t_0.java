/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

/*
 * Renamed from com.github.catvod.spider.merge.t
 */
public final class t_0 {
    private final int N;
    private final int SN;
    private final byte[][] yq;

    public t_0(int n2, int n3) {
        this.yq = new byte[n3][n2];
        this.SN = n2;
        this.N = n3;
    }

    public final byte[][] N() {
        return this.yq;
    }

    public final byte SN(int n2, int n3) {
        return this.yq[n3][n2];
    }

    public final void i(int n2, int n3, int n4) {
        this.yq[n3][n2] = (byte)n4;
    }

    public final void t0(int n2, int n3, boolean bl) {
        this.yq[n3][n2] = (byte)(bl ? 1 : 0);
    }

    public final int tF() {
        return this.N;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.SN * 2 * this.N + 2);
        for (int i2 = 0; i2 < this.N; ++i2) {
            for (int i4 = 0; i4 < this.SN; ++i4) {
                byte by2 = this.yq[i2][i4];
                String string = by2 != 0 ? (by2 != 1 ? "  " : " 1") : " 0";
                stringBuilder.append(string);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    public final void yq() {
        for (int i2 = 0; i2 < this.N; ++i2) {
            for (int i4 = 0; i4 < this.SN; ++i4) {
                this.yq[i2][i4] = -1;
            }
        }
    }

    public final int zH() {
        return this.SN;
    }
}

