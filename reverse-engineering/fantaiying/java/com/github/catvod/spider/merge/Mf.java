/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.Arrays;

public class Mf {
    private static int[] N = new int[0];
    private int SN;
    private int[] yq = N;

    public final int N(int n2) {
        if (n2 >= 0 && n2 < this.SN) {
            return this.yq[n2];
        }
        throw new IndexOutOfBoundsException();
    }

    public final void SN() {
        Arrays.fill(this.yq, 0, this.SN, 0);
        this.SN = 0;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Mf)) {
            return false;
        }
        object = (Mf)object;
        if (this.SN != ((Mf)object).SN) {
            return false;
        }
        for (int i2 = 0; i2 < this.SN; ++i2) {
            if (this.yq[i2] == ((Mf)object).yq[i2]) continue;
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int n2 = 1;
        for (int i2 = 0; i2 < this.SN; ++i2) {
            n2 = n2 * 31 + this.yq[i2];
        }
        return n2;
    }

    public final int i() {
        return this.SN;
    }

    public final boolean tF() {
        boolean bl = this.SN == 0;
        return bl;
    }

    public final String toString() {
        int n2 = this.SN;
        int[] nArray = n2 == 0 ? N : Arrays.copyOf(this.yq, n2);
        return Arrays.toString(nArray);
    }

    public final void yq(int n2) {
        int[] nArray = this.yq;
        int n3 = nArray.length;
        int n4 = this.SN;
        if (n3 == n4) {
            int n5 = n4 + 1;
            if (n5 >= 0 && n5 <= 0x7FFFFFF7) {
                n3 = nArray.length == 0 ? 4 : nArray.length;
                while (n3 < n5) {
                    n4 = n3 * 2;
                    if (n4 >= 0) {
                        n3 = n4;
                        if (n4 <= 0x7FFFFFF7) continue;
                    }
                    n3 = 0x7FFFFFF7;
                }
                this.yq = Arrays.copyOf(this.yq, n3);
            } else {
                throw new OutOfMemoryError();
            }
        }
        nArray = this.yq;
        n3 = this.SN;
        nArray[n3] = n2;
        this.SN = n3 + 1;
    }

    public final int zH(int n2) {
        int n3;
        if (n2 >= 0 && n2 < (n3 = this.SN)) {
            int[] nArray = this.yq;
            int n4 = nArray[n2];
            System.arraycopy(nArray, n2 + 1, nArray, n2, n3 - n2 - 1);
            nArray = this.yq;
            n2 = this.SN;
            nArray[n2 - 1] = 0;
            this.SN = n2 - 1;
            return n4;
        }
        throw new IndexOutOfBoundsException();
    }
}

