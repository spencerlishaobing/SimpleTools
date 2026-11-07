/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.FO;
import com.github.catvod.spider.merge.mt_0;
import com.github.catvod.spider.merge.u5;

public final class sU
implements u5 {
    private FO yq;

    public sU(char[] object, long l, long l2, byte[] byArray) {
        FO fO;
        this.yq = fO = new FO();
        if (object != null && ((char[])object).length > 0) {
            fO.SN((char[])object);
            byte by2 = 0;
            byte by3 = byArray[0];
            while (by2 < 12) {
                byte by4 = by2 + 1;
                if (by4 == 12 && (by2 = (byte)((byte)(this.yq.yq() ^ by3))) != (byte)(l >> 24) && by2 != (byte)(l2 >> 8)) {
                    throw new mt_0("Wrong password!", 1);
                }
                object = this.yq;
                ((FO)object).N((byte)(((FO)object).yq() ^ by3));
                by2 = by4;
                if (by4 == 12) continue;
                by3 = byArray[by4];
                by2 = by4;
            }
            return;
        }
        object = new mt_0("Wrong password!", 1);
        throw object;
    }

    @Override
    public final int yq(byte[] object, int n2, int n3) {
        if (n2 >= 0 && n3 >= 0) {
            for (int i2 = n2; i2 < n2 + n3; ++i2) {
                byte by2 = object[i2];
                byte by3 = this.yq.yq();
                FO fO = this.yq;
                byte by4 = (byte)((by2 & 0xFF ^ by3) & 0xFF);
                fO.N(by4);
                object[i2] = by4;
            }
            return n3;
        }
        object = new mt_0("one of the input parameters were null in standard decrypt data");
        throw object;
    }
}

