/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.Arrays;

public final class F
implements Cloneable {
    private final int N;
    private final int SN;
    private final int[] tF;
    private final int yq;

    public F(int n2, int n3) {
        if (n2 > 0 && n3 > 0) {
            this.yq = n2;
            this.SN = n3;
            this.N = n2 = (n2 + 31) / 32;
            this.tF = new int[n2 * n3];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    private F(int n2, int n3, int n4, int[] nArray) {
        this.yq = n2;
        this.SN = n3;
        this.N = n4;
        this.tF = nArray;
    }

    public final int N() {
        return this.yq;
    }

    public final int SN() {
        return this.SN;
    }

    public final Object clone() {
        return new F(this.yq, this.SN, this.N, (int[])this.tF.clone());
    }

    public final boolean equals(Object object) {
        if (!(object instanceof F)) {
            return false;
        }
        object = (F)object;
        return this.yq == ((F)object).yq && this.SN == ((F)object).SN && this.N == ((F)object).N && Arrays.equals(this.tF, ((F)object).tF);
    }

    public final int hashCode() {
        int n2 = this.yq;
        int n3 = this.SN;
        int n4 = this.N;
        return Arrays.hashCode(this.tF) + (((n2 * 31 + n2) * 31 + n3) * 31 + n4) * 31;
    }

    public final void tF(int n2, int n3, int n4, int n5) {
        if (n3 >= 0 && n2 >= 0) {
            if (n5 > 0 && n4 > 0) {
                int n7 = n4 + n2;
                if ((n5 += n3) <= this.SN && n7 <= this.yq) {
                    while (n3 < n5) {
                        int n8 = this.N;
                        for (n4 = n2; n4 < n7; ++n4) {
                            int[] nArray = this.tF;
                            int n9 = n4 / 32 + n8 * n3;
                            nArray[n9] = nArray[n9] | 1 << (n4 & 0x1F);
                        }
                        ++n3;
                    }
                    return;
                }
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Left and top must be nonnegative");
        throw illegalArgumentException;
    }

    public final String toString() {
        int n2 = this.SN;
        StringBuilder stringBuilder = new StringBuilder((this.yq + 1) * n2);
        for (n2 = 0; n2 < this.SN; ++n2) {
            for (int i2 = 0; i2 < this.yq; ++i2) {
                String string = this.yq(i2, n2) ? "X " : "  ";
                stringBuilder.append(string);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public final boolean yq(int n2, int n3) {
        int n4 = n2 / 32;
        int n5 = this.N;
        return (this.tF[n4 + n3 * n5] >>> (n2 & 0x1F) & 1) != 0;
    }
}

