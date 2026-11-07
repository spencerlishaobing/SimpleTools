/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.HA;
import com.github.catvod.spider.merge.t_0;
import com.github.catvod.spider.merge.xN;
import com.github.catvod.spider.merge.zh_0;

public final class JN {
    private HA N;
    private int SN;
    private int tF = -1;
    private xN yq;
    private t_0 zH;

    public final void N(int n2) {
        this.tF = n2;
    }

    public final void SN(int n2) {
        this.SN = n2;
    }

    public final void i(HA hA) {
        this.N = hA;
    }

    public final void tF(t_0 t_02) {
        this.zH = t_02;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append((Object)this.yq);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(zh_0.tF(this.SN));
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.N);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.tF);
        if (this.zH == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.zH);
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }

    public final t_0 yq() {
        return this.zH;
    }

    public final void zH(xN xN2) {
        this.yq = xN2;
    }
}

