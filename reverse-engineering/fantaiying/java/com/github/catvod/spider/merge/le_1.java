/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Renamed from com.github.catvod.spider.merge.lE
 */
public final class le_1<Key1, Key2, Value> {
    Map<Key1, Map<Key2, Value>> yq = new LinkedHashMap<Key1, Map<Key2, Value>>();

    public final Value SN(Key1 object, Key2 Key2, Value Value) {
        Map map;
        Map map2 = (Map)((LinkedHashMap)this.yq).get(object);
        if (map2 == null) {
            map = new LinkedHashMap();
            this.yq.put(object, map);
            map2 = null;
            object = map;
            map = map2;
        } else {
            map = map2.get(Key2);
            object = map2;
        }
        object.put(Key2, Value);
        return (Value)map;
    }

    public final Value yq(Key1 object, Key2 Key2) {
        if ((object = (Map)((LinkedHashMap)this.yq).get(object)) == null) {
            return null;
        }
        return (Value)object.get(Key2);
    }
}

