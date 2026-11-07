/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.YG;
import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.fM;
import com.github.catvod.spider.merge.pv;
import java.util.LinkedList;
import java.util.List;

public final class em
implements fM {
    @Override
    public final String name() {
        return "substring-before";
    }

    @Override
    public final pv yq(af_1 object, List<pv> object2) {
        object = (LinkedList)object2;
        object2 = ((pv)((LinkedList)object).get(0)).t0();
        String string = ((pv)((LinkedList)object).get(1)).t0();
        object = object2;
        if (!YG.N((CharSequence)object2)) {
            int n2;
            object = string == null ? object2 : (string.isEmpty() ? "" : ((n2 = ((String)object2).indexOf(string)) == -1 ? object2 : ((String)object2).substring(0, n2)));
        }
        return new pv(object);
    }
}

