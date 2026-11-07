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

public final class Db
implements fM {
    @Override
    public final String name() {
        return "substring-after-last";
    }

    @Override
    public final pv yq(af_1 object, List<pv> object2) {
        object2 = (LinkedList)object2;
        object = ((pv)((LinkedList)object2).get(0)).t0();
        object2 = ((pv)((LinkedList)object2).get(1)).t0();
        if (!YG.N((CharSequence)object)) {
            int n;
            object = !YG.N((CharSequence)object2) && (n = ((String)object).lastIndexOf((String)object2)) != -1 && n != ((String)object).length() - ((String)object2).length() ? ((String)object).substring(((String)object2).length() + n) : "";
        }
        return new pv(object);
    }
}

