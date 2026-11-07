/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Q9;
import com.github.catvod.spider.merge.dN;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.tw_0;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class rE
extends Format {
    private static final Q9<rE> N = new Q9<rE>(){};
    private final tw_0 SN;
    private final dN yq;

    protected rE(String string, TimeZone timeZone, Locale locale) {
        this.yq = new dN(string, timeZone, locale);
        this.SN = new tw_0(string, timeZone, locale);
    }

    public static rE SN(String string) {
        return (rE)N.yq(string, null);
    }

    public static rE yq() {
        Locale locale = Locale.US;
        return (rE)N.yq("EEE, dd MMM yyyy HH:mm:ss Z", locale);
    }

    public final Date N(String string) {
        return this.SN.Gc(string);
    }

    public final boolean equals(Object object) {
        if (!(object instanceof rE)) {
            return false;
        }
        object = (rE)object;
        return this.yq.equals(((rE)object).yq);
    }

    @Override
    public final StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        stringBuffer.append(this.yq.tF(object));
        return stringBuffer;
    }

    public final int hashCode() {
        return this.yq.hashCode();
    }

    @Override
    public final Object parseObject(String string, ParsePosition parsePosition) {
        return this.SN.M(string, parsePosition);
    }

    public final String toString() {
        StringBuilder stringBuilder = oi_0.yq("FastDateFormat[");
        stringBuilder.append(this.yq.i());
        stringBuilder.append(",");
        stringBuilder.append(this.yq.zH());
        stringBuilder.append(",");
        stringBuilder.append(this.yq.t0().getID());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

