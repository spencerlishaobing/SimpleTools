/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Pg;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.zT;
import java.util.Objects;

/*
 * Renamed from com.github.catvod.spider.merge.Py
 */
public final class py_0 {
    private zT SN;
    private Pg yq;

    public py_0(Pg pg) {
        this.yq = pg;
        this.SN = null;
    }

    public final byte[] yq(char[] objectArray, int n2) {
        Objects.requireNonNull(objectArray);
        objectArray = rs_0.q(objectArray);
        if (this.SN == null) {
            Objects.requireNonNull(this.yq);
            this.SN = new zT("HmacSHA1");
        }
        this.SN.tF((byte[])objectArray);
        if (n2 == 0) {
            n2 = this.SN.N();
        }
        zT zT2 = this.SN;
        byte[] byArray = this.yq.yq;
        objectArray = byArray;
        if (byArray == null) {
            objectArray = new byte[0];
        }
        int n3 = zT2.N();
        int n4 = n2 % n3 > 0 ? 1 : 0;
        int n5 = n2 / n3 + n4;
        byte[] byArray2 = new byte[n5 * n3];
        n4 = 0;
        for (int i2 = 1; i2 <= n5; ++i2) {
            int n7 = zT2.N();
            byte[] byArray3 = new byte[n7];
            byArray = new byte[objectArray.length + 4];
            System.arraycopy(objectArray, 0, byArray, 0, objectArray.length);
            int n8 = objectArray.length;
            byArray[n8] = (byte)(i2 / 0x1000000);
            byArray[n8 + 1] = (byte)(i2 / 65536);
            byArray[n8 + 2] = (byte)(i2 / 256);
            byArray[n8 + 3] = (byte)i2;
            for (n8 = 0; n8 < 1000; ++n8) {
                byArray = zT2.SN(byArray);
                for (int i4 = 0; i4 < n7; ++i4) {
                    byArray3[i4] = (byte)(byArray3[i4] ^ byArray[i4]);
                }
            }
            System.arraycopy(byArray3, 0, byArray2, n4, n7);
            n4 += n3;
        }
        objectArray = byArray2;
        if (n2 - (n5 - 1) * n3 < n3) {
            objectArray = new byte[n2];
            System.arraycopy(byArray2, 0, objectArray, 0, n2);
        }
        return objectArray;
    }
}

