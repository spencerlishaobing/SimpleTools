/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.IV;
import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.Oh;
import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.k6;
import com.github.catvod.spider.merge.py_2;
import com.github.catvod.spider.merge.rs_0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class iK
implements Cloneable {
    static final List<iK> N = Collections.emptyList();
    int SN;
    iK yq;

    protected iK() {
    }

    private void g1(int n2) {
        int n3 = this.t0();
        if (n3 == 0) {
            return;
        }
        List<iK> list = this.G();
        while (n2 < n3) {
            list.get((int)n2).SN = n2;
            ++n2;
        }
    }

    public abstract iK B();

    public final int Dr() {
        return this.SN;
    }

    public final boolean F5() {
        boolean bl = this.yq != null;
        return bl;
    }

    protected abstract List<iK> G();

    public final boolean G4(String string) {
        co_0.Gc(string);
        if (!this.dT()) {
            return false;
        }
        if (string.startsWith("abs:")) {
            String string2 = string.substring(4);
            if (this.tF().dT(string2) && !this.yq(string2).isEmpty()) {
                return true;
            }
        }
        return this.tF().dT(string);
    }

    public final List<iK> Gc() {
        if (this.t0() == 0) {
            return N;
        }
        List<iK> list = this.G();
        ArrayList<iK> arrayList = new ArrayList<iK>(list.size());
        arrayList.addAll(list);
        return Collections.unmodifiableList(arrayList);
    }

    abstract void Gd(Appendable var1, int var2, Va.yq var3);

    protected iK KJ(iK iK2) {
        iK iK3;
        try {
            iK3 = (iK)super.clone();
            iK3.yq = iK2;
            int n2 = iK2 == null ? 0 : this.SN;
            iK3.SN = n2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
        if (iK2 == null && !(this instanceof Va) && (iK2 = this.Nl()) != null) {
            iK3.yq = iK2 = ((Va)iK2).K();
            ((hN)iK2).G().add(iK3);
        }
        return iK3;
    }

    public iK M() {
        iK iK2 = this.KJ(null);
        LinkedList<iK> linkedList = new LinkedList<iK>();
        linkedList.add(iK2);
        while (!linkedList.isEmpty()) {
            iK iK3 = (iK)linkedList.remove();
            int n2 = iK3.t0();
            for (int i2 = 0; i2 < n2; ++i2) {
                List<iK> list = iK3.G();
                iK iK4 = list.get(i2).KJ(iK3);
                list.set(i2, iK4);
                linkedList.add(iK4);
            }
        }
        return iK2;
    }

    public String N(String string) {
        co_0.Gc(string);
        if (!this.dT()) {
            return "";
        }
        String string2 = this.tF().G(string);
        if (string2.length() > 0) {
            return string2;
        }
        if (string.startsWith("abs:")) {
            return this.yq(string.substring(4));
        }
        return "";
    }

    public final Va Nl() {
        iK iK2 = this.b();
        iK2 = iK2 instanceof Va ? (Va)iK2 : null;
        return iK2;
    }

    public final iK O() {
        return this.yq;
    }

    public iK OW() {
        return this.yq;
    }

    protected final void SN(int n2, iK ... iKArray) {
        int n3;
        int n4;
        Object object;
        co_0.Gc(iKArray);
        if (iKArray.length == 0) {
            return;
        }
        List<iK> list = this.G();
        int n5 = 0;
        iK iK2 = iKArray[0].OW();
        if (iK2 != null && iK2.t0() == iKArray.length) {
            block11: {
                object = iK2.G();
                n4 = iKArray.length;
                while (true) {
                    int n7 = n4 - 1;
                    n3 = 1;
                    if (n4 <= 0) break;
                    if (iKArray[n7] != object.get(n7)) {
                        n4 = 0;
                        break block11;
                    }
                    n4 = n7;
                }
                n4 = 1;
            }
            if (n4 != 0) {
                n4 = this.t0() == 0 ? n3 : 0;
                iK2.B();
                list.addAll(n2, Arrays.asList(iKArray));
                n5 = iKArray.length;
                while (true) {
                    n3 = n5 - 1;
                    if (n5 <= 0) break;
                    iKArray[n3].yq = this;
                    n5 = n3;
                }
                if (n4 == 0 || iKArray[0].SN != 0) {
                    this.g1(n2);
                }
                return;
            }
        }
        n3 = iKArray.length;
        for (n4 = 0; n4 < n3; ++n4) {
            if (iKArray[n4] != null) {
                continue;
            }
            throw new py_2("Array must not contain any null objects");
        }
        n3 = iKArray.length;
        for (n4 = n5; n4 < n3; ++n4) {
            object = iKArray[n4];
            Objects.requireNonNull(object);
            iK2 = ((iK)object).yq;
            if (iK2 != null) {
                iK2.n((iK)object);
            }
            ((iK)object).yq = this;
        }
        list.addAll(n2, Arrays.asList(iKArray));
        this.g1(n2);
    }

    public final iK W() {
        Object object = this.yq;
        if (object == null) {
            return null;
        }
        object = ((iK)object).G();
        int n2 = this.SN + 1;
        if (object.size() > n2) {
            return (iK)object.get(n2);
        }
        return null;
    }

    public final void Zm(String string) {
        this.q(string);
    }

    public iK b() {
        iK iK2;
        iK iK3 = this;
        while ((iK2 = iK3.yq) != null) {
            iK3 = iK2;
        }
        return iK3;
    }

    protected abstract boolean dT();

    public String ee() {
        StringBuilder stringBuilder = Nr.SN();
        this.g9(stringBuilder);
        return Nr.Gc(stringBuilder);
    }

    public final boolean equals(Object object) {
        boolean bl = this == object;
        return bl;
    }

    protected final void g9(Appendable appendable) {
        Va va2 = this.Nl();
        if (va2 == null) {
            va2 = new Va("");
        }
        rs_0.v(new yq(appendable, va2.D()), this);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final iK i(int n2) {
        return this.G().get(n2);
    }

    protected void n(iK iK2) {
        boolean bl = iK2.yq == this;
        co_0.tF(bl);
        int n2 = iK2.SN;
        this.G().remove(n2);
        this.g1(n2);
        iK2.yq = null;
    }

    protected abstract void q(String var1);

    public final void s() {
        co_0.Gc(this.yq);
        this.yq.n(this);
    }

    public abstract int t0();

    public abstract k6 tF();

    public String toString() {
        return this.ee();
    }

    public final void un(iK iK2) {
        co_0.Gc(this.yq);
        iK iK3 = this.yq;
        Objects.requireNonNull(iK3);
        boolean bl = this.yq == iK3;
        co_0.tF(bl);
        iK iK4 = iK2.yq;
        if (iK4 != null) {
            iK4.n(iK2);
        }
        int n2 = this.SN;
        iK3.G().set(n2, iK2);
        iK2.yq = iK3;
        iK2.SN = n2;
        this.yq = null;
    }

    public abstract String v();

    protected final void v3(Appendable appendable, int n2, Va.yq yq2) {
        appendable.append('\n').append(Nr.t0(yq2.tF() * n2, yq2.zH()));
    }

    abstract void xa(Appendable var1, int var2, Va.yq var3);

    public String yq(String string) {
        co_0.i(string);
        if (this.dT() && this.tF().dT(string)) {
            return Nr.M(this.zH(), this.tF().G(string));
        }
        return "";
    }

    public abstract String zH();

    private static final class yq
    implements IV {
        private final Va.yq SN;
        private final Appendable yq;

        yq(Appendable appendable, Va.yq yq2) {
            this.yq = appendable;
            this.SN = yq2;
            yq2.i();
        }

        @Override
        public final void SN(iK iK2, int n2) {
            try {
                iK2.xa(this.yq, n2, this.SN);
                return;
            }
            catch (IOException iOException) {
                throw new Oh(iOException);
            }
        }

        @Override
        public final void yq(iK iK2, int n2) {
            if (!iK2.v().equals("#text")) {
                try {
                    iK2.Gd(this.yq, n2, this.SN);
                }
                catch (IOException iOException) {
                    throw new Oh(iOException);
                }
            }
        }
    }
}

