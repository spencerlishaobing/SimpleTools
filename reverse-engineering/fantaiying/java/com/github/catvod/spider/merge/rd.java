/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.E3;
import com.github.catvod.spider.merge.TA;
import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.hy;
import com.github.catvod.spider.merge.iX;
import com.github.catvod.spider.merge.pM;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.u6;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public abstract class rd<E>
extends hy<E>
implements Set<E> {
    private transient E3<E> SN;

    rd() {
    }

    private static <E> rd<E> Gc(int n2, Object ... objectArray) {
        if (n2 != 0) {
            int n3 = 0;
            if (n2 != 1) {
                Object[] objectArray2;
                int n4;
                int n5 = rd.t0(n2);
                Object[] objectArray3 = new Object[n5];
                int n7 = n5 - 1;
                int n8 = 0;
                int n9 = 0;
                block0: for (n4 = 0; n4 < n2; ++n4) {
                    objectArray2 = objectArray[n4];
                    TA.yq(objectArray2, n4);
                    int n10 = objectArray2.hashCode();
                    int n11 = U7.G(n10);
                    while (true) {
                        int n12;
                        Object object;
                        if ((object = objectArray3[n12 = n11 & n7]) == null) {
                            objectArray[n9] = objectArray2;
                            objectArray3[n12] = objectArray2;
                            n8 += n10;
                            ++n9;
                            continue block0;
                        }
                        if (object.equals(objectArray2)) {
                            continue block0;
                        }
                        ++n11;
                    }
                }
                Arrays.fill(objectArray, n9, n2, null);
                if (n9 == 1) {
                    objectArray = objectArray[0];
                    Objects.requireNonNull(objectArray);
                    return new u6<Object[]>(objectArray);
                }
                if (rd.t0(n9) < n5 / 2) {
                    return rd.Gc(n9, objectArray);
                }
                n4 = objectArray.length;
                n2 = n3;
                if (n9 < (n4 >> 1) + (n4 >> 2)) {
                    n2 = 1;
                }
                objectArray2 = objectArray;
                if (n2 != 0) {
                    objectArray2 = Arrays.copyOf(objectArray, n9);
                }
                return new iX(objectArray2, n8, objectArray3, n7, n9);
            }
            objectArray = objectArray[0];
            Objects.requireNonNull(objectArray);
            return new u6<Object[]>(objectArray);
        }
        return iX.M;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static rd KJ() {
        return rd.Gc(4, "br", "deflate", "gzip", "x-gzip");
    }

    static int t0(int n2) {
        int n3 = Math.max(n2, 2);
        boolean bl = true;
        if (n3 < 0x2CCCCCCC) {
            n2 = Integer.highestOneBit(n3 - 1) << 1;
            while (true) {
                double d = n2;
                Double.isNaN(d);
                if (!(d * 0.7 < (double)n3)) break;
                n2 <<= 1;
            }
            return n2;
        }
        if (n3 >= 0x40000000) {
            bl = false;
        }
        rs_0.zH(bl, "collection too large");
        return 0x40000000;
    }

    E3<E> M() {
        Object object = this.toArray();
        int n2 = E3.N;
        n2 = ((Object[])object).length;
        object = n2 == 0 ? pM.i : new pM((Object[])object, n2);
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (object instanceof rd && this instanceof iX) {
            rd rd2 = (rd)object;
            Objects.requireNonNull(rd2);
            if (rd2 instanceof iX && this.hashCode() != object.hashCode()) {
                return false;
            }
        }
        if (this == object) return bl;
        if (!(object instanceof Set)) return false;
        object = (Set)object;
        try {
            if (this.size() != object.size()) return false;
            boolean bl2 = this.containsAll((Collection<?>)object);
            if (!bl2) return false;
            return bl;
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        Iterator iterator = this.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            Object e = iterator.next();
            int n3 = e != null ? e.hashCode() : 0;
            n2 = ~(~(n2 + n3));
        }
        return n2;
    }

    public final E3<E> i() {
        E3<E> e3;
        E3<E> e32 = e3 = this.SN;
        if (e3 == null) {
            this.SN = e32 = this.M();
        }
        return e32;
    }
}

