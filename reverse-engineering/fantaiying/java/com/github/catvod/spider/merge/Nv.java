/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.VQ;
import com.github.catvod.spider.merge.ly_1;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.wg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public abstract class Nv {
    public static final zH yq = new zH();

    public static Nv SN(Nv nv, Nv nvArray) {
        zH zH2;
        if (nv != null && nv != (zH2 = yq)) {
            if (nvArray != null && nvArray != zH2) {
                nv = new yq(nv, (Nv)nvArray);
                nvArray = ((yq)nv).SN;
                if (nvArray.length == 1) {
                    return nvArray[0];
                }
                return nv;
            }
            return nv;
        }
        return nvArray;
    }

    static List yq(Collection list) {
        List list2;
        Iterator iterator = list.iterator();
        list = null;
        while (iterator.hasNext()) {
            Nv nv = (Nv)iterator.next();
            if (!(nv instanceof tF)) continue;
            list2 = list;
            if (list == null) {
                list2 = new ArrayList();
            }
            ((ArrayList)list2).add((tF)((tF)nv));
            iterator.remove();
            list = list2;
        }
        list2 = list;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }

    public static Nv zH(Nv nvArray, Nv nv) {
        zH zH2;
        if (nvArray == null) {
            return nv;
        }
        if (nv == null) {
            return nvArray;
        }
        Nv nv2 = zH2 = yq;
        if (nvArray != zH2) {
            if (nv == zH2) {
                nv2 = zH2;
            } else {
                nv2 = new SN((Nv)nvArray, nv);
                nvArray = ((SN)nv2).SN;
                if (nvArray.length == 1) {
                    return nvArray[0];
                }
            }
        }
        return nv2;
    }

    public abstract boolean N(VQ<?, ?> var1, ly_1 var2);

    public Nv tF(VQ<?, ?> vQ, ly_1 ly_12) {
        return this;
    }

    public static abstract class N
    extends Nv {
    }

    public static final class SN
    extends N {
        public final Nv[] SN;

        public SN(Nv object, Nv nv) {
            HashSet<Nv> hashSet = new HashSet<Nv>();
            if (object instanceof SN) {
                hashSet.addAll(Arrays.asList(((SN)object).SN));
            } else {
                hashSet.add((Nv)object);
            }
            if (nv instanceof SN) {
                hashSet.addAll(Arrays.asList(((SN)nv).SN));
            } else {
                hashSet.add(nv);
            }
            object = Nv.yq(hashSet);
            if (!object.isEmpty()) {
                hashSet.add((tF)Collections.max(object));
            }
            this.SN = hashSet.toArray(new Nv[hashSet.size()]);
        }

        @Override
        public final boolean N(VQ<?, ?> vQ, ly_1 ly_12) {
            Nv[] nvArray = this.SN;
            int n2 = nvArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!nvArray[i2].N(vQ, ly_12)) continue;
                return true;
            }
            return false;
        }

        public final boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof SN)) {
                return false;
            }
            object = (SN)object;
            return Arrays.equals(this.SN, ((SN)object).SN);
        }

        public final int hashCode() {
            Nv[] nvArray = this.SN;
            int n2 = SN.class.hashCode();
            int n3 = nvArray.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                n2 = wg.i(n2, nvArray[i2]);
            }
            return wg.SN(n2, nvArray.length);
        }

        @Override
        public final Nv tF(VQ<?, ?> object, ly_1 ly_12) {
            ArrayList<Nv> arrayList = new ArrayList<Nv>();
            Nv[] nvArray = this.SN;
            int n2 = nvArray.length;
            int n3 = 0;
            int n4 = 0;
            while (true) {
                int n5 = 1;
                int n7 = 1;
                if (n3 >= n2) break;
                Nv nv = nvArray[n3];
                Nv nv2 = nv.tF((VQ<?, ?>)object, ly_12);
                n5 = nv2 != nv ? n7 : 0;
                n4 |= n5;
                nv = yq;
                if (nv2 == nv) {
                    return nv;
                }
                if (nv2 != null) {
                    arrayList.add(nv2);
                }
                ++n3;
            }
            if (n4 == 0) {
                return this;
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            object = (Nv)arrayList.get(0);
            for (n4 = n5; n4 < arrayList.size(); ++n4) {
                object = Nv.zH((Nv)object, (Nv)arrayList.get(n4));
            }
            return object;
        }

        public final String toString() {
            return U7.Gc(Arrays.asList(this.SN).iterator(), "||");
        }
    }

    public static final class tF
    extends Nv
    implements Comparable<tF> {
        public final int SN;

        protected tF() {
            this.SN = 0;
        }

        public tF(int n2) {
            this.SN = n2;
        }

        @Override
        public final boolean N(VQ<?, ?> vQ, ly_1 ly_12) {
            return vQ.Gc(this.SN);
        }

        @Override
        public final int compareTo(Object object) {
            object = (tF)object;
            return this.SN - ((tF)object).SN;
        }

        public final boolean equals(Object object) {
            boolean bl = object instanceof tF;
            boolean bl2 = false;
            if (!bl) {
                return false;
            }
            if (this == object) {
                return true;
            }
            object = (tF)object;
            if (this.SN == ((tF)object).SN) {
                bl2 = true;
            }
            return bl2;
        }

        public final int hashCode() {
            return 31 + this.SN;
        }

        @Override
        public final Nv tF(VQ<?, ?> vQ, ly_1 ly_12) {
            if (vQ.Gc(this.SN)) {
                return yq;
            }
            return null;
        }

        public final String toString() {
            StringBuilder stringBuilder = oi_0.yq("{");
            stringBuilder.append(this.SN);
            stringBuilder.append(">=prec}?");
            return stringBuilder.toString();
        }
    }

    public static final class yq
    extends N {
        public final Nv[] SN;

        public yq(Nv object, Nv nv) {
            HashSet<Nv> hashSet = new HashSet<Nv>();
            if (object instanceof yq) {
                hashSet.addAll(Arrays.asList(((yq)object).SN));
            } else {
                hashSet.add((Nv)object);
            }
            if (nv instanceof yq) {
                hashSet.addAll(Arrays.asList(((yq)nv).SN));
            } else {
                hashSet.add(nv);
            }
            object = Nv.yq(hashSet);
            if (!object.isEmpty()) {
                hashSet.add((tF)Collections.min(object));
            }
            this.SN = hashSet.toArray(new Nv[hashSet.size()]);
        }

        @Override
        public final boolean N(VQ<?, ?> vQ, ly_1 ly_12) {
            Nv[] nvArray = this.SN;
            int n2 = nvArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (nvArray[i2].N(vQ, ly_12)) continue;
                return false;
            }
            return true;
        }

        public final boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof yq)) {
                return false;
            }
            object = (yq)object;
            return Arrays.equals(this.SN, ((yq)object).SN);
        }

        public final int hashCode() {
            Nv[] nvArray = this.SN;
            int n2 = yq.class.hashCode();
            int n3 = nvArray.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                n2 = wg.i(n2, nvArray[i2]);
            }
            return wg.SN(n2, nvArray.length);
        }

        @Override
        public final Nv tF(VQ<?, ?> object, ly_1 ly_12) {
            ArrayList<Nv> arrayList = new ArrayList<Nv>();
            Nv[] nvArray = this.SN;
            int n2 = nvArray.length;
            int n3 = 0;
            int n4 = 0;
            while (true) {
                int n5 = 1;
                int n7 = 1;
                if (n3 >= n2) break;
                Nv nv = nvArray[n3];
                Nv nv2 = nv.tF((VQ<?, ?>)object, ly_12);
                n5 = nv2 != nv ? n7 : 0;
                n4 |= n5;
                if (nv2 == null) {
                    return null;
                }
                if (nv2 != yq) {
                    arrayList.add(nv2);
                }
                ++n3;
            }
            if (n4 == 0) {
                return this;
            }
            if (arrayList.isEmpty()) {
                return yq;
            }
            object = (Nv)arrayList.get(0);
            for (n3 = n5; n3 < arrayList.size(); ++n3) {
                object = Nv.SN((Nv)object, (Nv)arrayList.get(n3));
            }
            return object;
        }

        public final String toString() {
            return U7.Gc(Arrays.asList(this.SN).iterator(), "&&");
        }
    }

    public static final class zH
    extends Nv {
        public final int N;
        public final int SN;
        public final boolean tF;

        protected zH() {
            this.SN = -1;
            this.N = -1;
            this.tF = false;
        }

        public zH(int n2, int n3, boolean bl) {
            this.SN = n2;
            this.N = n3;
            this.tF = bl;
        }

        @Override
        public final boolean N(VQ<?, ?> vQ, ly_1 ly_12) {
            Objects.requireNonNull(vQ);
            return true;
        }

        public final boolean equals(Object object) {
            boolean bl = object instanceof zH;
            boolean bl2 = false;
            if (!bl) {
                return false;
            }
            if (this == object) {
                return true;
            }
            object = (zH)object;
            bl = bl2;
            if (this.SN == ((zH)object).SN) {
                bl = bl2;
                if (this.N == ((zH)object).N) {
                    bl = bl2;
                    if (this.tF == ((zH)object).tF) {
                        bl = true;
                    }
                }
            }
            return bl;
        }

        public final int hashCode() {
            return wg.SN(wg.zH(wg.zH(wg.zH(0, this.SN), this.N), this.tF ? 1 : 0), 3);
        }

        public final String toString() {
            StringBuilder stringBuilder = oi_0.yq("{");
            stringBuilder.append(this.SN);
            stringBuilder.append(":");
            stringBuilder.append(this.N);
            stringBuilder.append("}?");
            return stringBuilder.toString();
        }
    }
}

