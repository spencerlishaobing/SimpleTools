/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.cB;
import com.github.catvod.spider.merge.o;
import com.github.catvod.spider.merge.wg;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class dU<T>
implements Set<T> {
    protected int N = 0;
    protected T[][] SN;
    protected int tF = (int)Math.floor(12.0);
    protected final o yq;
    protected int zH = 8;

    public dU() {
        this(null, 8);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public dU(o o2, int n2) {
        o o3 = o2;
        if (o2 == null) {
            o3 = cB.yq;
        }
        this.yq = o3;
        this.SN = this.tF(16);
        this.zH = n2;
    }

    protected T[] N(int n2) {
        return new Object[n2];
    }

    public final boolean SN(T t) {
        Object var5_6;
        boolean bl = false;
        if (t == null) {
            return false;
        }
        int n2 = this.zH(t);
        T[] TArray = this.SN[n2];
        Object var6_5 = null;
        if (TArray == null) {
            var5_6 = var6_5;
        } else {
            int n3 = TArray.length;
            n2 = 0;
            while (true) {
                var5_6 = var6_5;
                if (n2 >= n3) break;
                var5_6 = TArray[n2];
                if (var5_6 == null) {
                    var5_6 = var6_5;
                    break;
                }
                if (this.yq.b(var5_6, t)) break;
                ++n2;
            }
        }
        if (var5_6 != null) {
            bl = true;
        }
        return bl;
    }

    @Override
    public final boolean add(T t) {
        boolean bl = this.i(t) == t;
        return bl;
    }

    @Override
    public final boolean addAll(Collection<? extends T> object) {
        object = object.iterator();
        boolean bl = false;
        while (object.hasNext()) {
            Object e = object.next();
            if (this.i(e) == e) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public final void clear() {
        this.SN = this.tF(16);
        this.N = 0;
        this.tF = (int)Math.floor(12.0);
    }

    @Override
    public final boolean contains(Object object) {
        return this.SN(this.yq(object));
    }

    @Override
    public final boolean containsAll(Collection<?> TArray) {
        if (TArray instanceof dU) {
            for (T[] TArray2 : ((dU)TArray).SN) {
                T t;
                if (TArray2 == null) continue;
                int n2 = TArray2.length;
                for (int i2 = 0; i2 < n2 && (t = TArray2[i2]) != null; ++i2) {
                    if (this.SN(this.yq(t))) continue;
                    return false;
                }
            }
        } else {
            TArray = TArray.iterator();
            while (TArray.hasNext()) {
                if (this.SN(this.yq(TArray.next()))) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof dU)) {
            return false;
        }
        object = (dU)object;
        if (((dU)object).N != this.N) {
            return false;
        }
        return this.containsAll((Collection<?>)object);
    }

    @Override
    public final int hashCode() {
        T[][] TArray = this.SN;
        int n2 = TArray.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4;
            T[] TArray2 = TArray[i2];
            if (TArray2 == null) {
                n4 = n3;
            } else {
                int n5 = TArray2.length;
                int n7 = 0;
                while (true) {
                    n4 = n3;
                    if (n7 >= n5) break;
                    T t = TArray2[n7];
                    if (t == null) {
                        n4 = n3;
                        break;
                    }
                    n3 = wg.zH(n3, this.yq.Zm(t));
                    ++n7;
                }
            }
            n3 = n4;
        }
        return wg.SN(n3, this.N);
    }

    public final T i(T object) {
        block11: {
            block10: {
                T[] TArray;
                Object object2;
                int n2 = this.N;
                int n3 = this.tF;
                int n4 = 0;
                if (n2 > n3) {
                    T[][] TArray2 = this.SN;
                    n3 = TArray2.length * 2;
                    T[][] TArray3 = this.tF(n3);
                    int[] nArray = new int[TArray3.length];
                    this.SN = TArray3;
                    double d = n3;
                    Double.isNaN(d);
                    Double.isNaN(d);
                    Double.isNaN(d);
                    this.tF = (int)(d * 0.75);
                    int n5 = TArray2.length;
                    for (n3 = 0; n3 < n5; ++n3) {
                        T[] TArray4 = TArray2[n3];
                        if (TArray4 == null) continue;
                        for (T t : TArray4) {
                            if (t == null) break;
                            int n7 = this.zH(t);
                            int n8 = nArray[n7];
                            if (n8 == 0) {
                                object2 = this.N(this.zH);
                                TArray3[n7] = object2;
                            } else {
                                TArray = TArray3[n7];
                                object2 = TArray;
                                if (n8 == TArray.length) {
                                    object2 = Arrays.copyOf(TArray, TArray.length * 2);
                                    TArray3[n7] = object2;
                                }
                            }
                            object2[n8] = t;
                            nArray[n7] = nArray[n7] + 1;
                        }
                    }
                }
                n2 = this.zH(object);
                TArray = this.SN[n2];
                if (TArray == null) {
                    object2 = this.N(this.zH);
                    object2[0] = object;
                    this.SN[n2] = object2;
                } else {
                    for (n3 = n4; n3 < TArray.length; ++n3) {
                        object2 = TArray[n3];
                        if (object2 == null) {
                            TArray[n3] = object;
                            break block10;
                        }
                        if (!this.yq.b(object2, object)) continue;
                        object = object2;
                        break block11;
                    }
                    n3 = TArray.length;
                    object2 = Arrays.copyOf(TArray, TArray.length * 2);
                    this.SN[n2] = object2;
                    object2[n3] = object;
                }
            }
            ++this.N;
        }
        return object;
    }

    @Override
    public final boolean isEmpty() {
        boolean bl = this.N == 0;
        return bl;
    }

    @Override
    public final Iterator<T> iterator() {
        return new yq(this, this.toArray());
    }

    @Override
    public final boolean remove(Object object) {
        return this.t0(this.yq(object));
    }

    @Override
    public final boolean removeAll(Collection<?> object) {
        object = object.iterator();
        boolean bl = false;
        while (object.hasNext()) {
            bl |= this.t0(this.yq(object.next()));
        }
        return bl;
    }

    @Override
    public final boolean retainAll(Collection<?> collection) {
        T[][] TArray = this.SN;
        int n2 = TArray.length;
        boolean bl = false;
        int n3 = 0;
        block0: for (int i2 = 0; i2 < n2; ++i2) {
            int n4;
            T[] TArray2 = TArray[i2];
            if (TArray2 == null) continue;
            int n5 = 0;
            for (n4 = 0; n4 < TArray2.length && TArray2[n4] != null; ++n4) {
                if (!collection.contains(TArray2[n4])) continue;
                if (n4 != n5) {
                    TArray2[n5] = TArray2[n4];
                }
                ++n5;
                ++n3;
            }
            int n7 = n3 + n5;
            while (true) {
                n3 = n7;
                if (n5 >= n4) continue block0;
                TArray2[n5] = null;
                ++n5;
            }
        }
        if (n3 != this.N) {
            bl = true;
        }
        this.N = n3;
        return bl;
    }

    @Override
    public final int size() {
        return this.N;
    }

    public final boolean t0(T t) {
        if (t == null) {
            return false;
        }
        int n2 = this.zH(t);
        T[] TArray = this.SN[n2];
        if (TArray == null) {
            return false;
        }
        for (n2 = 0; n2 < TArray.length; ++n2) {
            T t2 = TArray[n2];
            if (t2 == null) {
                return false;
            }
            if (!this.yq.b(t2, t)) continue;
            System.arraycopy(TArray, n2 + 1, TArray, n2, TArray.length - n2 - 1);
            TArray[TArray.length - 1] = null;
            --this.N;
            return true;
        }
        return false;
    }

    protected T[][] tF(int n2) {
        return new Object[n2][];
    }

    @Override
    public final T[] toArray() {
        T[] TArray = this.N(this.N);
        T[][] TArray2 = this.SN;
        int n2 = TArray2.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4;
            T[] TArray3 = TArray2[i2];
            if (TArray3 == null) {
                n4 = n3;
            } else {
                int n5 = TArray3.length;
                int n7 = 0;
                while (true) {
                    n4 = ++n3;
                    if (n7 >= n5) break;
                    T t = TArray3[n7];
                    if (t == null) {
                        n4 = n3;
                        break;
                    }
                    TArray[n3] = t;
                    ++n7;
                }
            }
            n3 = n4;
        }
        return TArray;
    }

    @Override
    public final <U> U[] toArray(U[] object) {
        int n2 = ((U[])object).length;
        int n3 = this.N;
        U[] UArray = object;
        if (n2 < n3) {
            UArray = Arrays.copyOf(object, n3);
        }
        T[][] TArray = this.SN;
        int n4 = TArray.length;
        n2 = 0;
        for (n3 = 0; n3 < n4; ++n3) {
            int n5;
            T[] TArray2 = TArray[n3];
            if (TArray2 == null) {
                n5 = n2;
            } else {
                int n7 = TArray2.length;
                int n8 = 0;
                while (true) {
                    n5 = ++n2;
                    if (n8 >= n7) break;
                    object = TArray2[n8];
                    if (object == null) {
                        n5 = n2;
                        break;
                    }
                    UArray[n2] = object;
                    ++n8;
                }
            }
            n2 = n5;
        }
        return UArray;
    }

    public final String toString() {
        if (this.N == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        T[][] TArray = this.SN;
        int n2 = TArray.length;
        boolean bl = true;
        for (int i2 = 0; i2 < n2; ++i2) {
            boolean bl2;
            T[] TArray2 = TArray[i2];
            if (TArray2 == null) {
                bl2 = bl;
            } else {
                int n3 = TArray2.length;
                int n4 = 0;
                while (true) {
                    bl2 = bl;
                    if (n4 >= n3) break;
                    T t = TArray2[n4];
                    if (t == null) {
                        bl2 = bl;
                        break;
                    }
                    if (bl) {
                        bl = false;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(t.toString());
                    ++n4;
                }
            }
            bl = bl2;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    protected T yq(Object object) {
        return (T)object;
    }

    protected final int zH(T t) {
        return this.yq.Zm(t) & this.SN.length - 1;
    }

    protected final class yq
    implements Iterator<T> {
        boolean N;
        int SN;
        final dU tF;
        final T[] yq;

        public yq(dU dU2, T[] TArray) {
            this.tF = dU2;
            this.SN = 0;
            this.N = true;
            this.yq = TArray;
        }

        @Override
        public final boolean hasNext() {
            boolean bl = this.SN < this.yq.length;
            return bl;
        }

        @Override
        public final T next() {
            if (this.hasNext()) {
                this.N = false;
                T[] TArray = this.yq;
                int n2 = this.SN;
                this.SN = n2 + 1;
                return TArray[n2];
            }
            throw new NoSuchElementException();
        }

        @Override
        public final void remove() {
            if (!this.N) {
                this.tF.remove(this.yq[this.SN - 1]);
                this.N = true;
                return;
            }
            throw new IllegalStateException();
        }
    }
}

