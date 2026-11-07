/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.RH;
import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.fM;
import com.github.catvod.spider.merge.pv;
import com.github.catvod.spider.merge.rE;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class m0
implements fM {
    @Override
    public final String name() {
        return "format-date";
    }

    @Override
    public final pv yq(af_1 object, List<pv> object2) {
        Cloneable cloneable = (LinkedList)object2;
        object = ((pv)((LinkedList)cloneable).get(0)).t0();
        object2 = ((pv)((LinkedList)cloneable).get(1)).t0();
        try {
            if (((LinkedList)cloneable).size() > 2 && ((LinkedList)cloneable).get(2) != null) {
                Locale locale = Locale.forLanguageTag(((pv)((LinkedList)cloneable).get(2)).t0());
                cloneable = new SimpleDateFormat((String)object2, locale);
                return new pv(((DateFormat)cloneable).parse((String)object));
            }
            object = new pv(rE.SN((String)object2).N((String)object));
            return object;
        }
        catch (ParseException parseException) {
            throw new RH(parseException);
        }
    }
}

