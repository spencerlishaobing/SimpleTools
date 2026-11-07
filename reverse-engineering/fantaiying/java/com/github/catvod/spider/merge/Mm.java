/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.qi_0;
import com.github.catvod.spider.merge.xe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public final class Mm
implements Iterable<String> {
    private final ArrayList<qi_0> SN;
    private final HashMap<String, String> yq = new HashMap();

    public Mm(Map<String, String> stringArray) {
        this.SN = new ArrayList();
        stringArray = stringArray.get("cookie");
        if (stringArray != null) {
            String[] stringArray2 = stringArray.split(";");
            int n2 = stringArray2.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                stringArray = stringArray2[i2].trim().split("=");
                if (stringArray.length != 2) continue;
                this.yq.put(stringArray[0], stringArray[1]);
            }
        }
    }

    @Override
    public final Iterator<String> iterator() {
        return this.yq.keySet().iterator();
    }

    public final void yq(xe xe2) {
        Iterator<qi_0> iterator = this.SN.iterator();
        while (iterator.hasNext()) {
            Objects.requireNonNull(iterator.next());
            xe2.SN(String.format("%s=%s; expires=%s", null, null, null));
        }
    }
}

