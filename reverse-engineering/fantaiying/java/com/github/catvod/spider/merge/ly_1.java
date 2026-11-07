/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Fw;
import com.github.catvod.spider.merge.Ir;
import com.github.catvod.spider.merge.ei_0;
import com.github.catvod.spider.merge.lR;
import com.github.catvod.spider.merge.oi_0;

/*
 * Renamed from com.github.catvod.spider.merge.lY
 */
public class ly_1
implements Ir {
    public static final ei_0 N = new ei_0();
    public int SN;
    public ly_1 yq;

    public ly_1() {
        this.SN = -1;
    }

    public ly_1(ly_1 ly_12, int n2) {
        this.yq = ly_12;
        this.SN = n2;
    }

    @Override
    public Fw N(int n2) {
        throw null;
    }

    @Override
    public final String getText() {
        if (this.tF() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < this.tF(); ++i2) {
            stringBuilder.append(this.N(i2).getText());
        }
        return stringBuilder.toString();
    }

    public final boolean i() {
        boolean bl = this.SN == -1;
        return bl;
    }

    @Override
    public int tF() {
        throw null;
    }

    public final String toString() {
        StringBuilder stringBuilder = oi_0.yq("[");
        ly_1 ly_12 = this;
        while (ly_12 != null) {
            ly_1 ly_13;
            if (!ly_12.i()) {
                stringBuilder.append(ly_12.SN);
            }
            if ((ly_13 = ly_12.yq) != null && !ly_13.i()) {
                stringBuilder.append(" ");
            }
            ly_12 = ly_12.yq;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public <T> T yq(lR<? extends T> lR2) {
        return lR2.tF(this);
    }

    public int zH() {
        return -1;
    }
}

