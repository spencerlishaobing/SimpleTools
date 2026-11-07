/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.TO;
import com.github.catvod.spider.merge.vR;
import com.github.catvod.spider.merge.vd_1;

public final class KU
extends TO {
    public static void KJ() {
        Object object = new vd_1(2, 36);
        boolean bl = ((vR)object).yq() <= 16 && 16 <= ((vR)object).SN();
        if (bl) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("radix ");
        ((StringBuilder)object).append(16);
        ((StringBuilder)object).append(" was not in valid range ");
        ((StringBuilder)object).append(new vd_1(2, 36));
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }
}

