/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.N;
import com.github.catvod.spider.merge.Pg;
import com.github.catvod.spider.merge.SN;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.mt_0;
import com.github.catvod.spider.merge.py_0;
import com.github.catvod.spider.merge.u5;
import com.github.catvod.spider.merge.zT;
import java.util.Arrays;

public final class yq
implements u5 {
    private int N = 1;
    private zT SN;
    private byte[] tF = new byte[16];
    private SN yq;
    private byte[] zH = new byte[16];

    public yq(N object, char[] objectArray, byte[] byArray, byte[] byArray2) {
        if (objectArray != null && objectArray.length > 0) {
            int n2;
            int n3 = ((N)object).Dr();
            object = new py_0(new Pg(byArray));
            int n4 = k_0.SN(n3);
            int n5 = n4 + (n2 = k_0.N(n3)) + 2;
            if (((Object)(object = (Object)((py_0)object).yq((char[])objectArray, n5))).length == n5) {
                objectArray = new byte[2];
                n5 = k_0.SN(n3);
                System.arraycopy(object, k_0.N(n3) + n5, objectArray, 0, 2);
                if (Arrays.equals(byArray2, (byte[])objectArray)) {
                    n5 = k_0.SN(n3);
                    objectArray = new byte[n5];
                    System.arraycopy(object, 0, objectArray, 0, n5);
                    this.yq = new SN((byte[])objectArray);
                    n5 = k_0.N(n3);
                    objectArray = new byte[n5];
                    System.arraycopy(object, k_0.SN(n3), objectArray, 0, n5);
                    object = new zT("HmacSHA1");
                    ((zT)object).tF((byte[])objectArray);
                    this.SN = object;
                    return;
                }
                throw new mt_0("Wrong Password", 1);
            }
            throw new mt_0(String.format("Derived Key invalid for Key Length [%d] MAC Length [%d]", n4, n2));
        }
        throw new mt_0("empty or null password provided for AES decryption");
    }

    public final byte[] SN() {
        return this.SN.yq();
    }

    @Override
    public final int yq(byte[] byArray, int n2, int n3) {
        int n4;
        int n5 = n2;
        while (n5 < (n4 = n2 + n3)) {
            int n7 = n5 + 16;
            n4 = n7 <= n4 ? 16 : (n4 -= n5);
            this.SN.zH(byArray, n5, n4);
            byte[] byArray2 = this.tF;
            int n8 = this.N;
            byte by2 = (byte)n8;
            int n9 = 0;
            byArray2[0] = by2;
            byArray2[1] = (byte)(n8 >> 8);
            byArray2[2] = (byte)(n8 >> 16);
            byArray2[3] = (byte)(n8 >> 24);
            for (n8 = 4; n8 <= 15; ++n8) {
                byArray2[n8] = 0;
            }
            this.yq.yq(this.tF, this.zH);
            for (n8 = n9; n8 < n4; ++n8) {
                n9 = n5 + n8;
                byArray[n9] = (byte)(byArray[n9] ^ this.zH[n8]);
            }
            ++this.N;
            n5 = n7;
        }
        return n3;
    }
}

