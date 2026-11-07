/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.qt_0;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class cq<K, V> {
    static Object[] i;
    static int t0;
    static Object[] tF;
    static int zH;
    int N = 0;
    Object[] SN;
    int[] yq = U7.yq;

    public cq() {
        this.SN = U7.SN;
    }

    private static int SN(int[] nArray, int n2, int n3) {
        int n4;
        block3: {
            n4 = n2 - 1;
            n2 = 0;
            while (n2 <= n4) {
                int n5 = n2 + n4 >>> 1;
                int n7 = nArray[n5];
                if (n7 < n3) {
                    n2 = n5 + 1;
                    continue;
                }
                n4 = n5;
                if (n7 > n3) {
                    n4 = n5 - 1;
                    continue;
                }
                break block3;
            }
            n4 = ~n2;
        }
        return n4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void tF(int[] nArray, Object[] objectArray, int n2) {
        if (nArray.length == 8) {
            synchronized (qt_0.class) {
                if (t0 >= 10) return;
                objectArray[0] = i;
                objectArray[1] = nArray;
                n2 = (n2 << 1) - 1;
                while (true) {
                    if (n2 < 2) {
                        i = objectArray;
                        ++t0;
                        return;
                    }
                    objectArray[n2] = null;
                    --n2;
                }
            }
        }
        if (nArray.length != 4) return;
        synchronized (qt_0.class) {
            if (zH >= 10) return;
            objectArray[0] = tF;
            objectArray[1] = nArray;
            n2 = (n2 << 1) - 1;
            while (true) {
                if (n2 < 2) {
                    tF = objectArray;
                    ++zH;
                    return;
                }
                objectArray[n2] = null;
                --n2;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void yq(int n2) {
        if (n2 == 8) {
            synchronized (qt_0.class) {
                Object[] objectArray = i;
                if (objectArray != null) {
                    this.SN = objectArray;
                    i = (Object[])objectArray[0];
                    this.yq = (int[])objectArray[1];
                    objectArray[1] = null;
                    objectArray[0] = null;
                    --t0;
                    return;
                }
            }
        } else if (n2 == 4) {
            synchronized (qt_0.class) {
                Object[] objectArray = tF;
                if (objectArray != null) {
                    this.SN = objectArray;
                    tF = (Object[])objectArray[0];
                    this.yq = (int[])objectArray[1];
                    objectArray[1] = null;
                    objectArray[0] = null;
                    --zH;
                    return;
                }
            }
        }
        this.yq = new int[n2];
        this.SN = new Object[n2 << 1];
    }

    final int Gc(Object object) {
        int n2 = this.N * 2;
        Object[] objectArray = this.SN;
        if (object == null) {
            for (int i2 = 1; i2 < n2; i2 += 2) {
                if (objectArray[i2] != null) continue;
                return i2 >> 1;
            }
        } else {
            for (int i4 = 1; i4 < n2; i4 += 2) {
                if (!object.equals(objectArray[i4])) continue;
                return i4 >> 1;
            }
        }
        return -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final V KJ(int n2) {
        Object[] objectArray = this.SN;
        int n3 = n2 << 1;
        Object object = objectArray[n3 + 1];
        int n4 = this.N;
        int n5 = 0;
        if (n4 <= 1) {
            cq.tF(this.yq, objectArray, n4);
            this.yq = U7.yq;
            this.SN = U7.SN;
            n2 = n5;
        } else {
            int n7 = n4 - 1;
            int[] nArray = this.yq;
            int n8 = nArray.length;
            n5 = 8;
            if (n8 > 8 && n4 < nArray.length / 3) {
                if (n4 > 8) {
                    n5 = n4 + (n4 >> 1);
                }
                this.yq(n5);
                if (n4 != this.N) throw new ConcurrentModificationException();
                if (n2 > 0) {
                    System.arraycopy(nArray, 0, this.yq, 0, n2);
                    System.arraycopy(objectArray, 0, this.SN, 0, n3);
                }
                if (n2 < n7) {
                    n5 = n2 + 1;
                    int[] nArray2 = this.yq;
                    n8 = n7 - n2;
                    System.arraycopy(nArray, n5, nArray2, n2, n8);
                    System.arraycopy(objectArray, n5 << 1, this.SN, n3, n8 << 1);
                }
            } else {
                Object[] objectArray2;
                if (n2 < n7) {
                    n8 = n2 + 1;
                    n5 = n7 - n2;
                    System.arraycopy(nArray, n8, nArray, n2, n5);
                    objectArray2 = this.SN;
                    System.arraycopy(objectArray2, n8 << 1, objectArray2, n3, n5 << 1);
                }
                objectArray2 = this.SN;
                n2 = n7 << 1;
                objectArray2[n2] = null;
                objectArray2[n2 + 1] = null;
            }
            n2 = n7;
        }
        if (n4 != this.N) throw new ConcurrentModificationException();
        this.N = n2;
        return (V)object;
    }

    public final K M(int n2) {
        return (K)this.SN[n2 << 1];
    }

    public final void N(int n2) {
        int n3 = this.N;
        int[] nArray = this.yq;
        if (nArray.length < n2) {
            Object[] objectArray = this.SN;
            this.yq(n2);
            if (this.N > 0) {
                System.arraycopy(nArray, 0, this.yq, 0, n3);
                System.arraycopy(objectArray, 0, this.SN, 0, n3 << 1);
            }
            cq.tF(nArray, objectArray, n3);
        }
        if (this.N == n3) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public final void clear() {
        int n2 = this.N;
        if (n2 > 0) {
            int[] nArray = this.yq;
            Object[] objectArray = this.SN;
            this.yq = U7.yq;
            this.SN = U7.SN;
            this.N = 0;
            cq.tF(nArray, objectArray, n2);
        }
        if (this.N <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public final boolean containsKey(Object object) {
        boolean bl = this.i(object) >= 0;
        return bl;
    }

    public final boolean containsValue(Object object) {
        boolean bl = this.Gc(object) >= 0;
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof cq)) {
            if (!(object instanceof Map)) return false;
            if (this.N != (object = (Map)object).size()) {
                return false;
            }
        } else {
            cq cq2 = (cq)object;
            if (this.N != cq2.N) {
                return false;
            }
            int n2 = 0;
            try {
                while (n2 < this.N) {
                    K k2 = this.M(n2);
                    V v2 = this.q(n2);
                    object = cq2.get(k2);
                    if (v2 == null) {
                        if (object != null) return false;
                        if (!cq2.containsKey(k2)) {
                            return false;
                        }
                    } else {
                        boolean bl = v2.equals(object);
                        if (!bl) {
                            return false;
                        }
                    }
                    ++n2;
                }
                return true;
            }
            catch (ClassCastException | NullPointerException runtimeException) {
                return false;
            }
        }
        int n3 = 0;
        try {
            while (n3 < this.N) {
                K k3 = this.M(n3);
                V v4 = this.q(n3);
                Object v5 = object.get(k3);
                if (v4 == null) {
                    if (v5 != null) return false;
                    if (!object.containsKey(k3)) {
                        return false;
                    }
                } else {
                    boolean bl = v4.equals(v5);
                    if (!bl) {
                        return false;
                    }
                }
                ++n3;
            }
            return true;
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
    }

    public final V get(Object object) {
        int n2 = this.i(object);
        object = n2 >= 0 ? this.SN[(n2 << 1) + 1] : null;
        return (V)object;
    }

    public final int hashCode() {
        int[] nArray = this.yq;
        Object[] objectArray = this.SN;
        int n2 = this.N;
        int n3 = 1;
        int n4 = 0;
        int n5 = 0;
        while (n4 < n2) {
            Object object = objectArray[n3];
            int n7 = nArray[n4];
            int n8 = object == null ? 0 : object.hashCode();
            n5 += n8 ^ n7;
            ++n4;
            n3 += 2;
        }
        return n5;
    }

    public final int i(Object object) {
        int n2 = object == null ? this.t0() : this.zH(object, object.hashCode());
        return n2;
    }

    public final boolean isEmpty() {
        boolean bl = this.N <= 0;
        return bl;
    }

    public final V put(K object, V v2) {
        int n2;
        int n3;
        int n4 = this.N;
        if (object == null) {
            n3 = this.t0();
            n2 = 0;
        } else {
            n2 = object.hashCode();
            n3 = this.zH(object, n2);
        }
        if (n3 >= 0) {
            n3 = (n3 << 1) + 1;
            Object[] objectArray = this.SN;
            object = objectArray[n3];
            objectArray[n3] = v2;
            return (V)object;
        }
        int n5 = ~n3;
        Object[] objectArray = this.yq;
        if (n4 >= objectArray.length) {
            n3 = 4;
            if (n4 >= 8) {
                n3 = (n4 >> 1) + n4;
            } else if (n4 >= 4) {
                n3 = 8;
            }
            Object[] objectArray2 = this.SN;
            this.yq(n3);
            if (n4 == this.N) {
                int[] nArray = this.yq;
                if (nArray.length > 0) {
                    System.arraycopy(objectArray, 0, nArray, 0, objectArray.length);
                    System.arraycopy(objectArray2, 0, this.SN, 0, objectArray2.length);
                }
                cq.tF(objectArray, objectArray2, n4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (n5 < n4) {
            objectArray = this.yq;
            n3 = n5 + 1;
            System.arraycopy(objectArray, n5, objectArray, n3, n4 - n5);
            objectArray = this.SN;
            System.arraycopy(objectArray, n5 << 1, objectArray, n3 << 1, this.N - n5 << 1);
        }
        if (n4 == (n3 = this.N) && n5 < (objectArray = this.yq).length) {
            objectArray[n5] = n2;
            objectArray = this.SN;
            n2 = n5 << 1;
            objectArray[n2] = (int)object;
            objectArray[n2 + 1] = (int)v2;
            this.N = n3 + 1;
            return null;
        }
        throw new ConcurrentModificationException();
    }

    public final V q(int n2) {
        return (V)this.SN[(n2 << 1) + 1];
    }

    public final V remove(Object object) {
        int n2 = this.i(object);
        if (n2 >= 0) {
            return this.KJ(n2);
        }
        return null;
    }

    public final int size() {
        return this.N;
    }

    final int t0() {
        int n2;
        int n3 = this.N;
        if (n3 == 0) {
            return -1;
        }
        int n4 = cq.SN(this.yq, n3, 0);
        if (n4 < 0) {
            return n4;
        }
        if (this.SN[n4 << 1] == null) {
            return n4;
        }
        for (n2 = n4 + 1; n2 < n3 && this.yq[n2] == 0; ++n2) {
            if (this.SN[n2 << 1] != null) continue;
            return n2;
        }
        for (n3 = n4 - 1; n3 >= 0 && this.yq[n3] == 0; --n3) {
            if (this.SN[n3 << 1] != null) continue;
            return n3;
        }
        return ~n2;
    }

    public final String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.N * 28);
        stringBuilder.append('{');
        for (int i2 = 0; i2 < this.N; ++i2) {
            Object object;
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            if ((object = this.M(i2)) != this) {
                stringBuilder.append(object);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            object = this.q(i2);
            if (object != this) {
                stringBuilder.append(object);
                continue;
            }
            stringBuilder.append("(this Map)");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    final int zH(Object object, int n2) {
        int n3;
        int n4 = this.N;
        if (n4 == 0) {
            return -1;
        }
        int n5 = cq.SN(this.yq, n4, n2);
        if (n5 < 0) {
            return n5;
        }
        if (object.equals(this.SN[n5 << 1])) {
            return n5;
        }
        for (n3 = n5 + 1; n3 < n4 && this.yq[n3] == n2; ++n3) {
            if (!object.equals(this.SN[n3 << 1])) continue;
            return n3;
        }
        for (n4 = n5 - 1; n4 >= 0 && this.yq[n4] == n2; --n4) {
            if (!object.equals(this.SN[n4 << 1])) continue;
            return n4;
        }
        return ~n3;
    }
}

