/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.cq;
import com.github.catvod.spider.merge.qt_0;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class eW<K, V> {
    zH N;
    N SN;
    SN yq;

    eW() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static <T> boolean zH(Set<T> set, Object object) {
        boolean bl = true;
        if (set == object) {
            return true;
        }
        if (!(object instanceof Set)) return false;
        object = (Set)object;
        try {
            if (set.size() != object.size()) return false;
            boolean bl2 = set.containsAll((Collection<?>)object);
            if (!bl2) return false;
            return bl;
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
    }

    protected abstract int N(Object var1);

    protected abstract Object SN(int var1, int var2);

    public final Object[] i(int n2) {
        int n3 = (this).tF.N;
        Object[] objectArray = new Object[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            objectArray[i2] = this.SN(i2, n2);
        }
        return objectArray;
    }

    public final <T> T[] t0(T[] TArray, int n2) {
        int n3 = (this).tF.N;
        Object[] objectArray = TArray;
        if (TArray.length < n3) {
            objectArray = (Object[])Array.newInstance(TArray.getClass().getComponentType(), n3);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            objectArray[i2] = this.SN(i2, n2);
        }
        if (objectArray.length > n3) {
            objectArray[n3] = null;
        }
        return objectArray;
    }

    protected abstract void tF(int var1);

    protected abstract void yq();

    final class N
    implements Set<K> {
        final eW yq;

        N(eW eW2) {
            this.yq = eW2;
        }

        @Override
        public final boolean add(K k2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final void clear() {
            this.yq.yq();
        }

        @Override
        public final boolean contains(Object object) {
            boolean bl = this.yq.N(object) >= 0;
            return bl;
        }

        @Override
        public final boolean containsAll(Collection<?> object) {
            boolean bl;
            block1: {
                qt_0 qt_02 = (this.yq).tF;
                object = object.iterator();
                while (object.hasNext()) {
                    if (qt_02.containsKey(object.next())) continue;
                    bl = false;
                    break block1;
                }
                bl = true;
            }
            return bl;
        }

        @Override
        public final boolean equals(Object object) {
            return eW.zH(this, object);
        }

        @Override
        public final int hashCode() {
            int n2 = 0;
            for (int i2 = (this.yq).tF.N - 1; i2 >= 0; --i2) {
                Object object = this.yq.SN(i2, 0);
                int n3 = object == null ? 0 : object.hashCode();
                n2 += n3;
            }
            return n2;
        }

        @Override
        public final boolean isEmpty() {
            boolean bl = (this.yq).tF.N == 0;
            return bl;
        }

        @Override
        public final Iterator<K> iterator() {
            return new yq(this.yq, 0);
        }

        @Override
        public final boolean remove(Object object) {
            int n2 = this.yq.N(object);
            if (n2 >= 0) {
                this.yq.tF(n2);
                return true;
            }
            return false;
        }

        @Override
        public final boolean removeAll(Collection<?> object) {
            qt_0 qt_02 = (this.yq).tF;
            int n2 = qt_02.size();
            object = object.iterator();
            while (object.hasNext()) {
                qt_02.remove(object.next());
            }
            boolean bl = n2 != qt_02.size();
            return bl;
        }

        @Override
        public final boolean retainAll(Collection<?> collection) {
            qt_0 qt_02 = (this.yq).tF;
            int n2 = qt_02.size();
            Iterator iterator = qt_02.keySet().iterator();
            while (iterator.hasNext()) {
                if (collection.contains(iterator.next())) continue;
                iterator.remove();
            }
            boolean bl = n2 != qt_02.size();
            return bl;
        }

        @Override
        public final int size() {
            return (this.yq).tF.N;
        }

        @Override
        public final Object[] toArray() {
            return this.yq.i(0);
        }

        @Override
        public final <T> T[] toArray(T[] TArray) {
            return this.yq.t0(TArray, 0);
        }
    }

    final class SN
    implements Set<Map.Entry<K, V>> {
        final eW yq;

        SN(eW eW2) {
            this.yq = eW2;
        }

        @Override
        public final boolean add(Object object) {
            object = (Map.Entry)object;
            throw new UnsupportedOperationException();
        }

        @Override
        public final boolean addAll(Collection<? extends Map.Entry<K, V>> object) {
            int n2 = (this.yq).tF.N;
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = iterator.next();
                object = this.yq;
                Object k2 = entry.getKey();
                entry = entry.getValue();
                (object).tF.put(k2, entry);
            }
            boolean bl = n2 != (this.yq).tF.N;
            return bl;
        }

        @Override
        public final void clear() {
            this.yq.yq();
        }

        @Override
        public final boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            int n2 = this.yq.N((object = (Map.Entry)object).getKey());
            if (n2 < 0) {
                return false;
            }
            return U7.tF(this.yq.SN(n2, 1), object.getValue());
        }

        @Override
        public final boolean containsAll(Collection<?> object) {
            object = object.iterator();
            while (object.hasNext()) {
                if (this.contains(object.next())) continue;
                return false;
            }
            return true;
        }

        @Override
        public final boolean equals(Object object) {
            return eW.zH(this, object);
        }

        @Override
        public final int hashCode() {
            int n2 = 0;
            for (int i2 = (this.yq).tF.N - 1; i2 >= 0; --i2) {
                Object object = this.yq.SN(i2, 0);
                Object object2 = this.yq.SN(i2, 1);
                int n3 = object == null ? 0 : object.hashCode();
                int n4 = object2 == null ? 0 : object2.hashCode();
                n2 += n3 ^ n4;
            }
            return n2;
        }

        @Override
        public final boolean isEmpty() {
            boolean bl = (this.yq).tF.N == 0;
            return bl;
        }

        @Override
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new tF(this.yq);
        }

        @Override
        public final boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final int size() {
            return (this.yq).tF.N;
        }

        @Override
        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final <T> T[] toArray(T[] TArray) {
            throw new UnsupportedOperationException();
        }
    }

    final class tF
    implements Iterator<Map.Entry<K, V>>,
    Map.Entry<K, V> {
        boolean N;
        int SN;
        final eW tF;
        int yq;

        tF(eW eW2) {
            this.tF = eW2;
            this.N = false;
            this.yq = (eW2).tF.N - 1;
            this.SN = -1;
        }

        @Override
        public final boolean equals(Object object) {
            if (this.N) {
                boolean bl = object instanceof Map.Entry;
                boolean bl2 = false;
                if (!bl) {
                    return false;
                }
                object = (Map.Entry)object;
                bl = bl2;
                if (U7.tF(object.getKey(), this.tF.SN(this.SN, 0))) {
                    bl = bl2;
                    if (U7.tF(object.getValue(), this.tF.SN(this.SN, 1))) {
                        bl = true;
                    }
                }
                return bl;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override
        public final K getKey() {
            if (this.N) {
                return this.tF.SN(this.SN, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override
        public final V getValue() {
            if (this.N) {
                return this.tF.SN(this.SN, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override
        public final boolean hasNext() {
            boolean bl = this.SN < this.yq;
            return bl;
        }

        @Override
        public final int hashCode() {
            if (this.N) {
                Object object = this.tF;
                int n2 = this.SN;
                int n3 = 0;
                Object object2 = ((eW)object).SN(n2, 0);
                object = this.tF.SN(this.SN, 1);
                n2 = object2 == null ? 0 : object2.hashCode();
                if (object != null) {
                    n3 = object.hashCode();
                }
                return n2 ^ n3;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override
        public final Object next() {
            if (this.hasNext()) {
                ++this.SN;
                this.N = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override
        public final void remove() {
            if (this.N) {
                this.tF.tF(this.SN);
                --this.SN;
                --this.yq;
                this.N = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override
        public final V setValue(V v2) {
            if (this.N) {
                Object object = this.tF;
                int n2 = this.SN;
                object = (object).tF;
                n2 = (n2 << 1) + 1;
                Object[] objectArray = ((cq)object).SN;
                object = objectArray[n2];
                objectArray[n2] = v2;
                return object;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getKey());
            stringBuilder.append("=");
            stringBuilder.append(this.getValue());
            return stringBuilder.toString();
        }
    }

    final class yq<T>
    implements Iterator<T> {
        int N;
        int SN;
        boolean tF;
        final int yq;
        final eW zH;

        yq(eW eW2, int n2) {
            this.zH = eW2;
            this.tF = false;
            this.yq = n2;
            this.SN = (eW2).tF.N;
        }

        @Override
        public final boolean hasNext() {
            boolean bl = this.N < this.SN;
            return bl;
        }

        @Override
        public final T next() {
            if (this.hasNext()) {
                Object object = this.zH.SN(this.N, this.yq);
                ++this.N;
                this.tF = true;
                return (T)object;
            }
            throw new NoSuchElementException();
        }

        @Override
        public final void remove() {
            if (this.tF) {
                int n2;
                this.N = n2 = this.N - 1;
                --this.SN;
                this.tF = false;
                this.zH.tF(n2);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class zH
    implements Collection<V> {
        final eW yq;

        zH(eW eW2) {
            this.yq = eW2;
        }

        @Override
        public final boolean add(V v2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final void clear() {
            this.yq.yq();
        }

        @Override
        public final boolean contains(Object object) {
            boolean bl = (this.yq).tF.Gc(object) >= 0;
            return bl;
        }

        @Override
        public final boolean containsAll(Collection<?> object) {
            object = object.iterator();
            while (object.hasNext()) {
                if (this.contains(object.next())) continue;
                return false;
            }
            return true;
        }

        @Override
        public final boolean isEmpty() {
            boolean bl = (this.yq).tF.N == 0;
            return bl;
        }

        @Override
        public final Iterator<V> iterator() {
            return new yq(this.yq, 1);
        }

        @Override
        public final boolean remove(Object object) {
            int n2 = (this.yq).tF.Gc(object);
            if (n2 >= 0) {
                this.yq.tF(n2);
                return true;
            }
            return false;
        }

        @Override
        public final boolean removeAll(Collection<?> collection) {
            int n2 = (this.yq).tF.N;
            int n3 = 0;
            boolean bl = false;
            while (n3 < n2) {
                int n4 = n2;
                int n5 = n3;
                if (collection.contains(this.yq.SN(n3, 1))) {
                    this.yq.tF(n3);
                    n5 = n3 - 1;
                    n4 = n2 - 1;
                    bl = true;
                }
                n3 = n5 + 1;
                n2 = n4;
            }
            return bl;
        }

        @Override
        public final boolean retainAll(Collection<?> collection) {
            int n2 = (this.yq).tF.N;
            int n3 = 0;
            boolean bl = false;
            while (n3 < n2) {
                int n4 = n2;
                int n5 = n3;
                if (!collection.contains(this.yq.SN(n3, 1))) {
                    this.yq.tF(n3);
                    n5 = n3 - 1;
                    n4 = n2 - 1;
                    bl = true;
                }
                n3 = n5 + 1;
                n2 = n4;
            }
            return bl;
        }

        @Override
        public final int size() {
            return (this.yq).tF.N;
        }

        @Override
        public final Object[] toArray() {
            return this.yq.i(1);
        }

        @Override
        public final <T> T[] toArray(T[] TArray) {
            return this.yq.t0(TArray, 1);
        }
    }
}

