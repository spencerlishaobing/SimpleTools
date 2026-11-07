/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.Oh;
import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.a_0;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.l4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class k6
implements Iterable<a_0>,
Cloneable {
    Object[] N;
    String[] SN = new String[3];
    private int yq = 0;

    public k6() {
        this.N = new Object[3];
    }

    private void Gc(int n2) {
        boolean bl = n2 >= this.yq;
        co_0.tF(bl);
        String[] stringArray = this.SN;
        int n3 = stringArray.length;
        if (n3 >= n2) {
            return;
        }
        int n4 = 3;
        if (n3 >= 3) {
            n4 = this.yq * 2;
        }
        if (n2 <= n4) {
            n2 = n4;
        }
        this.SN = Arrays.copyOf(stringArray, n2);
        this.N = Arrays.copyOf(this.N, n2);
    }

    static String M(Object object) {
        object = object == null ? "" : (String)object;
        return object;
    }

    private void OW(int n2) {
        boolean bl = n2 >= this.yq;
        co_0.N(bl);
        int n3 = this.yq - n2 - 1;
        if (n3 > 0) {
            Object[] objectArray = this.SN;
            int n4 = n2 + 1;
            System.arraycopy(objectArray, n4, objectArray, n2, n3);
            objectArray = this.N;
            System.arraycopy(objectArray, n4, objectArray, n2, n3);
        }
        this.yq = n2 = this.yq - 1;
        this.SN[n2] = null;
        this.N[n2] = null;
    }

    private int W(String string) {
        co_0.Gc(string);
        for (int i2 = 0; i2 < this.yq; ++i2) {
            if (!string.equalsIgnoreCase(this.SN[i2])) continue;
            return i2;
        }
        return -1;
    }

    private boolean ee(String string) {
        boolean bl = true;
        if (string == null || string.length() <= 1 || string.charAt(0) != '/') {
            bl = false;
        }
        return bl;
    }

    private void i(String string, Object object) {
        this.Gc(this.yq + 1);
        String[] stringArray = this.SN;
        int n2 = this.yq;
        stringArray[n2] = string;
        this.N[n2] = object;
        this.yq = n2 + 1;
    }

    static String v(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('/');
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public final String B(String string) {
        int n2 = this.v3(string);
        string = n2 == -1 ? "" : k6.M(this.N[n2]);
        return string;
    }

    final void F5(Appendable appendable, Va.yq yq2) {
        int n2 = this.yq;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string;
            if (this.ee(this.SN[i2]) || (string = a_0.SN(this.SN[i2], yq2.Gc())) == null) continue;
            a_0.tF(string, (String)this.N[i2], appendable.append(' '), yq2);
        }
    }

    public final String G(String string) {
        int n2 = this.W(string);
        string = n2 == -1 ? "" : k6.M(this.N[n2]);
        return string;
    }

    public final boolean G4(String string) {
        boolean bl = this.v3(string) != -1;
        return bl;
    }

    public final k6 Gd(String string, String string2) {
        co_0.Gc(string);
        int n2 = this.v3(string);
        if (n2 != -1) {
            this.N[n2] = string2;
        } else {
            this.i(string, string2);
        }
        return this;
    }

    public final k6 KJ() {
        k6 k62;
        try {
            k62 = (k6)super.clone();
            k62.yq = this.yq;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
        k62.SN = Arrays.copyOf(this.SN, this.yq);
        k62.N = Arrays.copyOf(this.N, this.yq);
        return k62;
    }

    final void Nl(String string, String string2) {
        int n2 = this.W(string);
        if (n2 != -1) {
            this.N[n2] = string2;
            if (!this.SN[n2].equals(string)) {
                this.SN[n2] = string;
            }
        } else {
            this.i(string, string2);
        }
    }

    public final boolean dT(String string) {
        boolean bl = this.W(string) != -1;
        return bl;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && k6.class == object.getClass()) {
            object = (k6)object;
            if (this.yq != ((k6)object).yq) {
                return false;
            }
            for (int i2 = 0; i2 < this.yq; ++i2) {
                int n2 = ((k6)object).v3(this.SN[i2]);
                if (n2 == -1) {
                    return false;
                }
                Object object2 = this.N[i2];
                Object object3 = ((k6)object).N[n2];
                if (!(object2 == null ? object3 != null : !object2.equals(object3))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public final void g9() {
        for (int i2 = 0; i2 < this.yq; ++i2) {
            String[] stringArray = this.SN;
            stringArray[i2] = U7.M(stringArray[i2]);
        }
    }

    public final int hashCode() {
        int n2 = this.yq;
        int n3 = Arrays.hashCode(this.SN);
        return Arrays.hashCode(this.N) + (n2 * 31 + n3) * 31;
    }

    public final boolean isEmpty() {
        boolean bl = this.yq == 0;
        return bl;
    }

    @Override
    public final Iterator<a_0> iterator() {
        return new Iterator<a_0>(this){
            final k6 SN;
            int yq;
            {
                this.SN = k62;
                this.yq = 0;
            }

            @Override
            public final boolean hasNext() {
                boolean bl;
                k6 k62;
                int n2;
                int n3;
                do {
                    n3 = ++this.yq;
                    n2 = this.SN.yq;
                    bl = true;
                } while (n3 < n2 && (k62 = this.SN).ee(k62.SN[this.yq]));
                if (this.yq >= this.SN.yq) {
                    bl = false;
                }
                return bl;
            }

            @Override
            public final Object next() {
                Cloneable cloneable = this.SN;
                String[] stringArray = cloneable.SN;
                int n2 = this.yq++;
                cloneable = new a_0(stringArray[n2], (String)cloneable.N[n2], (k6)cloneable);
                return cloneable;
            }

            @Override
            public final void remove() {
                int n2;
                k6 k62 = this.SN;
                this.yq = n2 = this.yq - 1;
                k62.OW(n2);
            }
        };
    }

    public final int q(l4 stringArray) {
        int n2 = this.yq;
        int n3 = 0;
        if ((n2 = n2 == 0 ? 1 : 0) != 0) {
            return 0;
        }
        boolean bl = stringArray.zH();
        int n4 = 0;
        while (n3 < this.SN.length) {
            int n5;
            n2 = n5 = n3 + 1;
            while (n2 < (stringArray = this.SN).length && stringArray[n2] != null) {
                int n7;
                int n8;
                block7: {
                    block6: {
                        if (bl && stringArray[n3].equals(stringArray[n2])) break block6;
                        n8 = n4;
                        n7 = n2;
                        if (bl) break block7;
                        stringArray = this.SN;
                        n8 = n4;
                        n7 = n2;
                        if (!stringArray[n3].equalsIgnoreCase(stringArray[n2])) break block7;
                    }
                    n8 = n4 + 1;
                    this.OW(n2);
                    n7 = n2 - 1;
                }
                n2 = n7 + 1;
                n4 = n8;
            }
            n3 = n5;
        }
        return n4;
    }

    public final int size() {
        return this.yq;
    }

    public final List<a_0> t0() {
        ArrayList<a_0> arrayList = new ArrayList<a_0>(this.yq);
        for (int i2 = 0; i2 < this.yq; ++i2) {
            if (this.ee(this.SN[i2])) continue;
            arrayList.add(new a_0(this.SN[i2], (String)this.N[i2], this));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final k6 tF(String string, String string2) {
        this.i(string, string2);
        return this;
    }

    public final String toString() {
        StringBuilder stringBuilder = Nr.SN();
        try {
            Va va2 = new Va("");
            this.F5(stringBuilder, va2.D());
        }
        catch (IOException iOException) {
            throw new Oh(iOException);
        }
        return Nr.Gc(stringBuilder);
    }

    final int v3(String string) {
        co_0.Gc(string);
        for (int i2 = 0; i2 < this.yq; ++i2) {
            if (!string.equals(this.SN[i2])) continue;
            return i2;
        }
        return -1;
    }

    public final k6 xa(a_0 a_02) {
        this.Gd(a_02.yq(), a_02.N());
        a_02.N = this;
        return this;
    }

    public final void zH(k6 k62) {
        int n2 = k62.yq;
        if (n2 == 0) {
            return;
        }
        this.Gc(this.yq + n2);
        boolean bl = this.yq != 0;
        n2 = 0;
        while (true) {
            if (n2 < k62.yq && k62.ee(k62.SN[n2])) {
                ++n2;
                continue;
            }
            boolean bl2 = n2 < k62.yq;
            if (!bl2) break;
            a_0 a_02 = new a_0(k62.SN[n2], (String)k62.N[n2], k62);
            ++n2;
            if (bl) {
                this.xa(a_02);
                continue;
            }
            this.i(a_02.yq(), a_02.N());
        }
    }
}

