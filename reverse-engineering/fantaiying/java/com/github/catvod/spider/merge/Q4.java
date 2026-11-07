/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.C;
import com.github.catvod.spider.merge.CK;
import com.github.catvod.spider.merge.Nv;
import com.github.catvod.spider.merge.XO;
import com.github.catvod.spider.merge.dU;
import com.github.catvod.spider.merge.ku_0;
import com.github.catvod.spider.merge.le_1;
import com.github.catvod.spider.merge.o;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;

public class Q4
implements Set<C> {
    public final boolean Gc;
    private int M = -1;
    public final ArrayList<C> N = new ArrayList(7);
    public yq SN = new N();
    public boolean i;
    public boolean t0;
    public int tF;
    protected boolean yq = false;
    protected BitSet zH;

    public Q4() {
        this(true);
    }

    public Q4(boolean bl) {
        this.Gc = bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void SN(XO object) {
        if (this.yq) {
            object = new IllegalStateException("This set is readonly");
            throw object;
        }
        if (this.SN.isEmpty()) {
            return;
        }
        Iterator<C> iterator = this.N.iterator();
        while (iterator.hasNext()) {
            C c = iterator.next();
            CK cK = c.N;
            ku_0 ku_02 = ((XO)object).SN;
            if (ku_02 != null) {
                synchronized (ku_02) {
                    IdentityHashMap<CK, CK> identityHashMap = new IdentityHashMap<CK, CK>();
                    cK = CK.SN(cK, ((XO)object).SN, identityHashMap);
                }
            }
            c.N = cK;
        }
    }

    @Override
    public final boolean add(Object object) {
        this.yq((C)object, null);
        return true;
    }

    @Override
    public final boolean addAll(Collection<? extends C> object) {
        object = object.iterator();
        while (object.hasNext()) {
            this.yq((C)object.next(), null);
        }
        return false;
    }

    @Override
    public final void clear() {
        if (!this.yq) {
            this.N.clear();
            this.M = -1;
            this.SN.clear();
            return;
        }
        throw new IllegalStateException("This set is readonly");
    }

    @Override
    public final boolean contains(Object object) {
        yq yq2 = this.SN;
        if (yq2 != null) {
            return yq2.contains(object);
        }
        throw new UnsupportedOperationException("This method is not implemented for readonly sets.");
    }

    @Override
    public final boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof Q4)) {
            return false;
        }
        object = (Q4)object;
        ArrayList<C> arrayList = this.N;
        if (arrayList == null || !((Object)arrayList).equals(((Q4)object).N) || this.Gc != ((Q4)object).Gc || this.tF != ((Q4)object).tF || this.zH != ((Q4)object).zH || this.i != ((Q4)object).i || this.t0 != ((Q4)object).t0) {
            bl = false;
        }
        return bl;
    }

    @Override
    public final int hashCode() {
        if (this.yq) {
            if (this.M == -1) {
                this.M = ((Object)this.N).hashCode();
            }
            return this.M;
        }
        return ((Object)this.N).hashCode();
    }

    @Override
    public final boolean isEmpty() {
        return this.N.isEmpty();
    }

    @Override
    public final Iterator<C> iterator() {
        return this.N.iterator();
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
        return this.N.size();
    }

    @Override
    public final Object[] toArray() {
        return (C[])this.SN.toArray();
    }

    @Override
    public final <T> T[] toArray(T[] TArray) {
        return this.SN.toArray((U[])TArray);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Object)this.N).toString());
        if (this.i) {
            stringBuilder.append(",hasSemanticContext=");
            stringBuilder.append(this.i);
        }
        if (this.tF != 0) {
            stringBuilder.append(",uniqueAlt=");
            stringBuilder.append(this.tF);
        }
        if (this.zH != null) {
            stringBuilder.append(",conflictingAlts=");
            stringBuilder.append(this.zH);
        }
        if (this.t0) {
            stringBuilder.append(",dipsIntoOuterContext");
        }
        return stringBuilder.toString();
    }

    public final boolean yq(C c, le_1<CK, CK, CK> object) {
        if (!this.yq) {
            C c2;
            if (c.zH != Nv.yq) {
                this.i = true;
            }
            if (c.SN() > 0) {
                this.t0 = true;
            }
            if ((c2 = this.SN.i(c)) == c) {
                this.M = -1;
                this.N.add(c);
                return;
            }
            boolean bl = this.Gc;
            object = CK.t0(c2.N, c.N, bl ^ true, object);
            c2.tF = Math.max(c2.tF, c.tF);
            if (c.N()) {
                c2.tF |= 0x40000000;
            }
            c2.N = object;
            return;
        }
        throw new IllegalStateException("This set is readonly");
    }

    public static final class N
    extends yq {
        public N() {
            super(com.github.catvod.spider.merge.Q4$SN.yq);
        }
    }

    public static final class SN
    extends o {
        public static final SN yq = new SN();

        private SN() {
        }

        @Override
        public final int Zm(Object object) {
            object = (C)object;
            int n2 = ((C)object).yq.SN;
            int n3 = ((C)object).SN;
            return ((C)object).zH.hashCode() + ((n2 + 217) * 31 + n3) * 31;
        }

        @Override
        public final boolean b(Object object, Object object2) {
            object = (C)object;
            object2 = (C)object2;
            boolean bl = true;
            if (!(object == object2 || object != null && object2 != null && ((C)object).yq.SN == ((C)object2).yq.SN && ((C)object).SN == ((C)object2).SN && ((C)object).zH.equals(((C)object2).zH))) {
                bl = false;
            }
            return bl;
        }
    }

    public static abstract class yq
    extends dU<C> {
        public yq(o o2) {
            super(o2, 2);
        }

        @Override
        protected final Object[] N(int n2) {
            return new C[n2];
        }

        @Override
        protected final Object[][] tF(int n2) {
            return new C[n2][];
        }

        @Override
        protected final Object yq(Object object) {
            object = !(object instanceof C) ? null : (C)object;
            return object;
        }
    }
}

