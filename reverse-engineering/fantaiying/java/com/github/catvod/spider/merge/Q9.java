/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nc;
import com.github.catvod.spider.merge.jv;
import com.github.catvod.spider.merge.rE;
import java.text.Format;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

abstract class Q9<F extends Format> {
    private final ConcurrentMap<yq, F> yq = new ConcurrentHashMap<yq, F>(7);

    static {
        new ConcurrentHashMap(7);
    }

    Q9() {
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final Format yq(String object, Locale object2) {
        jv.yq(object, new Object[0]);
        TimeZone timeZone = TimeZone.getDefault();
        Locale locale = Nc.yq((Locale)object2);
        yq yq2 = new yq(object, timeZone, locale);
        Format format = (Format)((ConcurrentHashMap)this.yq).get(yq2);
        object2 = format;
        if (format == null && (object = (Format)((Object)((ConcurrentHashMap)this.yq).putIfAbsent(yq2, (Locale)(object2 = new rE((String)object, timeZone, locale))))) != null) {
            object2 = object;
        }
        return object2;
    }

    private static final class yq {
        private final int SN;
        private final Object[] yq;

        yq(Object ... objectArray) {
            this.yq = objectArray;
            this.SN = Arrays.hashCode(objectArray) + 31;
        }

        public final boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (yq.class != object.getClass()) {
                return false;
            }
            object = (yq)object;
            return Arrays.deepEquals(this.yq, ((yq)object).yq);
        }

        public final int hashCode() {
            return this.SN;
        }
    }
}

