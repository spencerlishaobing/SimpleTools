/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.C;
import com.github.catvod.spider.merge.o;
import com.github.catvod.spider.merge.wg;

final class Z2
extends o {
    public static final Z2 yq = new Z2();

    private Z2() {
    }

    @Override
    public final int Zm(Object object) {
        object = (C)object;
        return wg.SN(wg.i(wg.zH(7, ((C)object).yq.SN), ((C)object).N), 2);
    }

    @Override
    public final boolean b(Object object, Object object2) {
        object = (C)object;
        object2 = (C)object2;
        boolean bl = true;
        if (!(object == object2 || object != null && object2 != null && ((C)object).yq.SN == ((C)object2).yq.SN && ((C)object).N.equals(((C)object2).N))) {
            bl = false;
        }
        return bl;
    }
}

