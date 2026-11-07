/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.ha_0;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class I2 {
    public static final int N = 0;
    private static final TimeZone SN;
    private static final Pattern yq;

    static {
        yq = Pattern.compile("^(?:(?i)GMT)?([+-])?(\\d\\d?)?(:?(\\d\\d?))?$");
        SN = new ha_0(false, 0, 0);
    }

    public static TimeZone yq(String object) {
        if (!"Z".equals(object) && !"UTC".equals(object)) {
            if (((Matcher)(object = yq.matcher((CharSequence)object))).matches()) {
                String string = ((Matcher)object).group(2);
                boolean bl = false;
                int n2 = string != null ? Integer.parseInt(string) : 0;
                string = ((Matcher)object).group(4);
                int n3 = string != null ? Integer.parseInt(string) : 0;
                if (n2 == 0 && n3 == 0) {
                    return SN;
                }
                object = ((Matcher)object).group(1);
                boolean bl2 = bl;
                if (object != null) {
                    bl2 = bl;
                    if (((String)object).charAt(0) == '-') {
                        bl2 = true;
                    }
                }
                return new ha_0(bl2, n2, n3);
            }
            return null;
        }
        return SN;
    }
}

