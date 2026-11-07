/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.B7;
import com.github.catvod.spider.merge.Y;
import com.github.catvod.spider.merge.nQ;
import com.github.catvod.spider.merge.sU;
import com.github.catvod.spider.merge.u5;
import com.github.catvod.spider.merge.uo_0;

final class NW
extends Y<sU> {
    public NW(uo_0 uo_02, B7 b7, char[] cArray, int n2) {
        super(uo_02, b7, cArray, n2);
    }

    @Override
    protected final u5 zH(B7 object, char[] cArray) {
        long l = ((nQ)object).U();
        long l2 = ((nQ)object).RQ();
        object = new byte[12];
        this.i((byte[])object);
        return new sU(cArray, l, l2, (byte[])object);
    }
}

