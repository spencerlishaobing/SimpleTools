/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.Arrays;

/*
 * Renamed from com.github.catvod.spider.merge.f
 */
public final class f_0
implements Cloneable {
    private int SN;
    private int[] yq;

    public f_0() {
        this.SN = 0;
        this.yq = new int[1];
    }

    f_0(int[] nArray, int n2) {
        this.yq = nArray;
        this.SN = n2;
    }

    private void tF(int n2) {
        int[] nArray = this.yq;
        if (n2 > nArray.length << 5) {
            int[] nArray2 = new int[(n2 + 31) / 32];
            System.arraycopy(nArray, 0, nArray2, 0, nArray.length);
            this.yq = nArray2;
        }
    }

    public final void Gc(f_0 object) {
        if (this.SN == ((f_0)object).SN) {
            int[] nArray;
            for (int i2 = 0; i2 < (nArray = this.yq).length; ++i2) {
                nArray[i2] = nArray[i2] ^ ((f_0)object).yq[i2];
            }
            return;
        }
        object = new IllegalArgumentException("Sizes don't match");
        throw object;
    }

    public final void N(int n2, int n3) {
        if (n3 >= 0 && n3 <= 32) {
            this.tF(this.SN + n3);
            while (n3 > 0) {
                boolean bl = true;
                if ((n2 >> n3 - 1 & 1) != 1) {
                    bl = false;
                }
                this.yq(bl);
                --n3;
            }
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Num bits must be between 0 and 32");
        throw illegalArgumentException;
    }

    public final void SN(f_0 f_02) {
        int n2 = f_02.SN;
        this.tF(this.SN + n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.yq(f_02.zH(i2));
        }
    }

    public final Object clone() {
        return new f_0((int[])this.yq.clone(), this.SN);
    }

    public final boolean equals(Object object) {
        if (!(object instanceof f_0)) {
            return false;
        }
        object = (f_0)object;
        return this.SN == ((f_0)object).SN && Arrays.equals(this.yq, ((f_0)object).yq);
    }

    public final int hashCode() {
        int n2 = this.SN;
        return Arrays.hashCode(this.yq) + n2 * 31;
    }

    public final int i() {
        return this.SN;
    }

    public final int t0() {
        return (this.SN + 7) / 8;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.SN);
        for (int i2 = 0; i2 < this.SN; ++i2) {
            if ((i2 & 7) == 0) {
                stringBuilder.append(' ');
            }
            char c = this.zH(i2) ? (char)'X' : '.';
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public final void yq(boolean bl) {
        this.tF(this.SN + 1);
        if (bl) {
            int[] nArray = this.yq;
            int n2 = this.SN;
            int n3 = n2 / 32;
            nArray[n3] = 1 << (n2 & 0x1F) | nArray[n3];
        }
        ++this.SN;
    }

    public final boolean zH(int n2) {
        return (1 << (n2 & 0x1F) & this.yq[n2 / 32]) != 0;
    }
}

