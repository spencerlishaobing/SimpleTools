/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.I2;
import com.github.catvod.spider.merge.rE;
import java.util.Locale;

public final class LE {
    @Deprecated
    public static final rE yq;

    static {
        int n2 = I2.N;
        rE.SN("yyyy-MM-dd'T'HH:mm:ss");
        yq = rE.SN("yyyy-MM-dd'T'HH:mm:ssZZ");
        rE.SN("yyyy-MM-dd");
        rE.SN("yyyy-MM-ddZZ");
        rE.SN("'T'HH:mm:ss");
        rE.SN("'T'HH:mm:ssZZ");
        rE.SN("HH:mm:ss");
        rE.SN("HH:mm:ssZZ");
        Locale locale = Locale.US;
        rE.yq();
    }
}

