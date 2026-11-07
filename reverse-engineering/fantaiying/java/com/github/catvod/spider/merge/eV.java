/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.YG;
import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.co;
import com.github.catvod.spider.merge.pv;
import com.github.catvod.spider.merge.s8;
import com.github.catvod.spider.merge.xW;
import java.math.BigDecimal;
import java.util.regex.Matcher;

public final class eV
implements co {
    @Override
    public final String name() {
        return "num";
    }

    @Override
    public final pv yq(af_1 object) {
        object = YG.zH(xW.SN("allText").yq((af_1)object).zH(), "");
        if (((Matcher)(object = s8.yq.matcher((CharSequence)object))).find()) {
            if (((BigDecimal)(object = new BigDecimal(((Matcher)object).group()))).compareTo(new BigDecimal(((BigDecimal)object).longValue())) == 0) {
                return new pv(((BigDecimal)object).longValue());
            }
            return new pv(((BigDecimal)object).doubleValue());
        }
        return new pv(null);
    }
}

