/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.o;
import com.github.catvod.spider.merge.wg;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class lT<K, V>
implements Map<K, V> {
    protected int N = 0;
    protected LinkedList<yq<K, V>>[] SN;
    protected int tF = 12;
    protected final o yq;

    public lT(o o2) {
        this.yq = o2;
        this.SN = new LinkedList[8];
    }

    @Override
    public final void clear() {
        this.SN = new LinkedList[16];
        this.N = 0;
    }

    @Override
    public final boolean containsKey(Object object) {
        boolean bl = this.get(object) != null;
        return bl;
    }

    @Override
    public final boolean containsValue(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean equals(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final V get(Object object) {
        if (object == null) {
            return null;
        }
        int n2 = this.yq.Zm(object);
        Object object2 = this.SN;
        if ((object2 = object2[n2 & ((LinkedList<yq<K, V>>[])object2).length - 1]) == null) {
            return null;
        }
        object2 = ((AbstractCollection)object2).iterator();
        while (object2.hasNext()) {
            yq yq2 = (yq)object2.next();
            if (!this.yq.b(yq2.yq, object)) continue;
            return yq2.SN;
        }
        return null;
    }

    @Override
    public final int hashCode() {
        LinkedList<yq<K, V>>[] linkedListArray = this.SN;
        int n2 = linkedListArray.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4;
            Object object = linkedListArray[i2];
            if (object == null) {
                n4 = n3;
            } else {
                Iterator iterator = ((AbstractCollection)object).iterator();
                while (true) {
                    n4 = n3;
                    if (!iterator.hasNext()) break;
                    object = (yq)iterator.next();
                    if (object == null) {
                        n4 = n3;
                        break;
                    }
                    n3 = wg.zH(n3, this.yq.Zm(((yq)object).yq));
                }
            }
            n3 = n4;
        }
        return wg.SN(n3, this.N);
    }

    @Override
    public final boolean isEmpty() {
        boolean bl = this.N == 0;
        return bl;
    }

    @Override
    public final Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final V put(K object, V v2) {
        Object object2;
        Object object32;
        int n2;
        Object object4;
        if (object == null) {
            return null;
        }
        if (this.N > this.tF) {
            object4 = this.SN;
            n2 = ((LinkedList<yq<K, V>>[])object4).length * 2;
            this.SN = new LinkedList[n2];
            double d = n2;
            Double.isNaN(d);
            Double.isNaN(d);
            Double.isNaN(d);
            this.tF = (int)(d * 0.75);
            int n3 = this.N;
            for (Object object32 : object4) {
                if (object32 == null) continue;
                object32 = ((AbstractCollection)object32).iterator();
                while (object32.hasNext() && (object2 = (yq)object32.next()) != null) {
                    this.put(((yq)object2).yq, ((yq)object2).SN);
                }
            }
            this.N = n3;
        }
        n2 = this.yq.Zm(object);
        object2 = this.SN;
        object32 = object2[n2 &= ((LinkedList<yq<K, V>>[])object2).length - 1];
        object4 = object32;
        if (object32 == null) {
            object2[n2] = object4 = new LinkedList();
        }
        object2 = ((AbstractCollection)object4).iterator();
        while (object2.hasNext()) {
            object32 = (yq)object2.next();
            if (!this.yq.b(((yq)object32).yq, object)) continue;
            object = ((yq)object32).SN;
            ((yq)object32).SN = v2;
            ++this.N;
            return (V)object;
        }
        ((LinkedList)object4).add(new yq<K, V>(object, v2));
        ++this.N;
        return null;
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final V remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int size() {
        return this.N;
    }

    public final String toString() {
        if (this.N == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        LinkedList<yq<K, V>>[] linkedListArray = this.SN;
        int n2 = linkedListArray.length;
        boolean bl = true;
        for (int i2 = 0; i2 < n2; ++i2) {
            boolean bl2;
            LinkedList<yq<K, V>> linkedList = linkedListArray[i2];
            if (linkedList == null) {
                bl2 = bl;
            } else {
                linkedList = ((AbstractCollection)linkedList).iterator();
                while (true) {
                    bl2 = bl;
                    if (!linkedList.hasNext()) break;
                    yq yq2 = (yq)linkedList.next();
                    if (yq2 == null) {
                        bl2 = bl;
                        break;
                    }
                    if (bl) {
                        bl = false;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(yq2.toString());
                }
            }
            bl = bl2;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    public final Collection<V> values() {
        ArrayList arrayList = new ArrayList(this.N);
        for (LinkedList<yq<K, V>> linkedList : this.SN) {
            if (linkedList == null) continue;
            linkedList = ((AbstractCollection)linkedList).iterator();
            while (linkedList.hasNext()) {
                arrayList.add(((yq)linkedList.next()).SN);
            }
        }
        return arrayList;
    }

    public static final class yq<K, V> {
        public V SN;
        public final K yq;

        public yq(K k2, V v2) {
            this.yq = k2;
            this.SN = v2;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.yq.toString());
            stringBuilder.append(":");
            stringBuilder.append(this.SN.toString());
            return stringBuilder.toString();
        }
    }
}

