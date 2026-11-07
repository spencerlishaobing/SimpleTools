/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.rs_0;

public final class FO {
    private static final int[] SN = new int[256];
    private final int[] yq = new int[3];

    static {
        for (int i2 = 0; i2 < 256; ++i2) {
            int n2 = i2;
            for (int i4 = 0; i4 < 8; ++i4) {
                int n3;
                int n4 = n3 = n2 >>> 1;
                if ((n2 & 1) == 1) {
                    n4 = n3 ^ 0xEDB88320;
                }
                n2 = n4;
            }
            FO.SN[i2] = n2;
        }
    }

    public final void N(byte by2) {
        int[] nArray = this.yq;
        int n2 = nArray[0];
        int[] nArray2 = SN;
        nArray[0] = nArray2[(by2 ^ n2) & 0xFF] ^ n2 >>> 8;
        nArray[1] = nArray[1] + (nArray[0] & 0xFF);
        nArray[1] = nArray[1] * 134775813 + 1;
        by2 = (byte)nArray[2];
        nArray[2] = nArray2[((byte)(nArray[1] >> 24) ^ by2) & 0xFF] ^ by2 >>> 8;
    }

    public final void SN(char[] objectArray) {
        int[] nArray = this.yq;
        nArray[0] = 305419896;
        nArray[1] = 591751049;
        nArray[2] = 878082192;
        objectArray = rs_0.q(objectArray);
        int n2 = objectArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.N((byte)(objectArray[i2] & 0xFF));
        }
    }

    public final byte yq() {
        int n2 = this.yq[2] | 2;
        return (byte)(n2 * (n2 ^ 1) >>> 8);
    }
}

