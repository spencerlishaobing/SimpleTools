/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.cq;
import com.github.catvod.spider.merge.eW;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/*
 * Renamed from com.github.catvod.spider.merge.Qt
 */
public final class qt_0<K, V>
extends cq<K, V>
implements Map<K, V> {
    eW<K, V> Gc;

    private eW<K, V> B() {
        if (this.Gc == null) {
            this.Gc = new eW<K, V>(this){
                final qt_0 tF;
                {
                    this.tF = qt_02;
                }

                @Override
                protected final int N(Object object) {
                    return this.tF.i(object);
                }

                @Override
                protected final Object SN(int n2, int n3) {
                    return this.tF.SN[(n2 << 1) + n3];
                }

                @Override
                protected final void tF(int n2) {
                    this.tF.KJ(n2);
                }

                @Override
                protected final void yq() {
                    this.tF.clear();
                }
            };
        }
        return this.Gc;
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        eW<K, V> eW2 = this.B();
        if (eW2.yq == null) {
            eW2.yq = new eW.SN(eW2);
        }
        return eW2.yq;
    }

    @Override
    public final Set<K> keySet() {
        eW<K, V> eW2 = this.B();
        if (eW2.SN == null) {
            eW2.SN = new eW.N(eW2);
        }
        return eW2.SN;
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> object) {
        int n2 = this.N;
        this.N(object.size() + n2);
        for (Map.Entry entry : object.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public final Collection<V> values() {
        eW<K, V> eW2 = this.B();
        if (eW2.N == null) {
            eW2.N = new eW.zH(eW2);
        }
        return eW2.N;
    }
}

