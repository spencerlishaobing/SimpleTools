/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.CK;
import java.util.HashMap;
import java.util.Map;

/*
 * Renamed from com.github.catvod.spider.merge.Ku
 */
public final class ku_0 {
    protected final Map<CK, CK> yq = new HashMap<CK, CK>();

    public final CK yq(CK cK) {
        CK cK2 = CK.SN;
        if (cK == cK2) {
            return cK2;
        }
        cK2 = (CK)((HashMap)this.yq).get(cK);
        if (cK2 != null) {
            return cK2;
        }
        ((HashMap)this.yq).put(cK, cK);
        return cK;
    }
}

