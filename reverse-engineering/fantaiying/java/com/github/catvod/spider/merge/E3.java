/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Cu;
import com.github.catvod.spider.merge.R5;
import com.github.catvod.spider.merge.TA;
import com.github.catvod.spider.merge.hy;
import com.github.catvod.spider.merge.jY;
import com.github.catvod.spider.merge.li;
import com.github.catvod.spider.merge.pM;
import com.github.catvod.spider.merge.rs_0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class E3<E>
extends hy<E>
implements List<E>,
RandomAccess {
    public static final int N = 0;
    private static final li<Object> SN = new yq<Object>(pM.i, 0);

    E3() {
    }

    public static <E> E3<E> i(E[] object) {
        if (((E[])object).length == 0) {
            object = pM.i;
        } else {
            int n2;
            object = (Object[])object.clone();
            int n3 = ((E[])object).length;
            for (n2 = 0; n2 < n3; ++n2) {
                TA.yq(object[n2], n2);
            }
            n2 = ((E[])object).length;
            object = n2 == 0 ? pM.i : new pM((Object[])object, n2);
        }
        return object;
    }

    public E3<E> Gc(int n2, int n3) {
        rs_0.Gc(n2, n3, this.size());
        if ((n3 -= n2) == this.size()) {
            return this;
        }
        if (n3 == 0) {
            return pM.i;
        }
        return new SN(this, n2, n3);
    }

    @Override
    @Deprecated
    public final void add(int n2, E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean addAll(int n2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean contains(Object object) {
        boolean bl = this.indexOf(object) >= 0;
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final boolean equals(Object iterator) {
        boolean bl = false;
        if (iterator == this) {
            return true;
        }
        if (!(iterator instanceof List)) return bl;
        Object object = (List)((Object)iterator);
        int n2 = this.size();
        if (n2 != object.size()) return bl;
        if (object instanceof RandomAccess) {
            int n3 = 0;
            while (n3 < n2) {
                if (!R5.SN(this.get(n3), object.get(n3))) return bl;
                ++n3;
            }
            return true;
        }
        iterator = this.iterator();
        object = object.iterator();
        do {
            if (!iterator.hasNext()) return object.hasNext() ^ true;
        } while (object.hasNext() && R5.SN(iterator.next(), object.next()));
        return bl;
    }

    @Override
    public final int hashCode() {
        int n2 = this.size();
        int n3 = 1;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 = ~(~(this.get(i2).hashCode() + n3 * 31));
        }
        return n3;
    }

    @Override
    public final int indexOf(Object object) {
        int n2;
        int n3 = -1;
        if (object == null) {
            n2 = n3;
        } else {
            int n4 = this.size();
            int n5 = 0;
            while (true) {
                n2 = n3;
                if (n5 >= n4) break;
                if (object.equals(this.get(n5))) {
                    n2 = n5;
                    break;
                }
                ++n5;
            }
        }
        return n2;
    }

    @Override
    public Iterator iterator() {
        return this.t0(0);
    }

    @Override
    public final int lastIndexOf(Object object) {
        int n2;
        int n3 = -1;
        if (object == null) {
            n2 = n3;
        } else {
            int n4 = this.size() - 1;
            while (true) {
                n2 = n3;
                if (n4 < 0) break;
                if (object.equals(this.get(n4))) {
                    n2 = n4;
                    break;
                }
                --n4;
            }
        }
        return n2;
    }

    @Override
    public ListIterator listIterator() {
        return this.t0(0);
    }

    @Override
    @Deprecated
    public final E remove(int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final E set(int n2, E e) {
        throw new UnsupportedOperationException();
    }

    public final li<E> t0(int n2) {
        rs_0.t0(n2, this.size());
        if (this.isEmpty()) {
            return SN;
        }
        return new yq(this, n2);
    }

    @Override
    int yq(Object[] objectArray) {
        int n2 = this.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            objectArray[0 + i2] = this.get(i2);
        }
        return 0 + n2;
    }

    @Override
    public final jY<E> zH() {
        return this.t0(0);
    }

    final class SN
    extends E3<E> {
        final E3 i;
        final transient int tF;
        final transient int zH;

        SN(E3 e3, int n2, int n3) {
            this.i = e3;
            this.tF = n2;
            this.zH = n3;
        }

        @Override
        public final E3<E> Gc(int n2, int n3) {
            rs_0.Gc(n2, n3, this.zH);
            E3 e3 = this.i;
            int n4 = this.tF;
            return e3.Gc(n2 + n4, n3 + n4);
        }

        @Override
        final int N() {
            return this.i.tF() + this.tF + this.zH;
        }

        @Override
        final Object[] SN() {
            return this.i.SN();
        }

        @Override
        public final E get(int n2) {
            rs_0.i(n2, this.zH);
            return this.i.get(n2 + this.tF);
        }

        @Override
        public final Iterator iterator() {
            return this.t0(0);
        }

        @Override
        public final ListIterator listIterator() {
            return this.t0(0);
        }

        @Override
        public final int size() {
            return this.zH;
        }

        @Override
        final int tF() {
            return this.i.tF() + this.tF;
        }
    }

    static final class yq<E>
    extends Cu<E> {
        private final E3<E> N;

        yq(E3<E> e3, int n2) {
            super(e3.size(), n2);
            this.N = e3;
        }

        @Override
        protected final E SN(int n2) {
            return this.N.get(n2);
        }
    }
}

