/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Ng;
import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.YW;
import com.github.catvod.spider.merge.a_0;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.eb;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.l4;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.sA;
import com.github.catvod.spider.merge.xL;
import com.github.catvod.spider.merge.xq;
import com.github.catvod.spider.merge.y4;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.regex.Pattern;

public abstract class Y4 {
    protected Y4() {
    }

    public abstract boolean yq(hN var1, hN var2);

    public static final class B
    extends Y4 {
        private final String yq;

        public B(String string) {
            this.yq = U7.M(string);
        }

        public final String toString() {
            return String.format(":containsData(%s)", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return U7.M(hN3.lF()).contains(this.yq);
        }
    }

    public static final class Dr
    extends Y4 {
        public final String toString() {
            return ":only-of-type";
        }

        @Override
        public final boolean yq(hN object, hN hN2) {
            boolean bl;
            object = hN2.L();
            boolean bl2 = bl = false;
            if (object != null) {
                if (object instanceof Va) {
                    bl2 = bl;
                } else {
                    object = ((AbstractCollection)((hN)object).J()).iterator();
                    int n2 = 0;
                    while (object.hasNext()) {
                        if (!((hN)object.next()).I().equals(hN2.I())) continue;
                        ++n2;
                    }
                    bl2 = bl;
                    if (n2 == 1) {
                        bl2 = true;
                    }
                }
            }
            return bl2;
        }
    }

    public static final class E1
    extends Y4 {
        private final Pattern yq;

        public E1(Pattern pattern) {
            this.yq = pattern;
        }

        public final String toString() {
            return String.format(":matchesWholeOwnText(%s)", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return this.yq.matcher(hN3.h()).find();
        }
    }

    public static final class F5
    extends Y4 {
        private final String yq;

        public F5(String string) {
            this.yq = string;
        }

        public final String toString() {
            return String.format(":containsWholeText(%s)", this.yq);
        }

        @Override
        public final boolean yq(hN object, hN hN2) {
            object = Nr.SN();
            rs_0.v(new sA((StringBuilder)object), hN2);
            return Nr.Gc((StringBuilder)object).contains(this.yq);
        }
    }

    public static final class Fz
    extends Y4 {
        private final Pattern yq;

        public Fz(Pattern pattern) {
            this.yq = pattern;
        }

        public final String toString() {
            return String.format(":matchesOwn(%s)", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return this.yq.matcher(hN3.kR()).find();
        }
    }

    public static final class G
    extends Y4 {
        private final String yq;

        public G(String string) {
            StringBuilder stringBuilder = Nr.SN();
            Nr.yq(stringBuilder, string, false);
            this.yq = U7.M(Nr.Gc(stringBuilder));
        }

        public final String toString() {
            return String.format(":containsOwn(%s)", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return U7.M(hN3.kR()).contains(this.yq);
        }
    }

    public static final class G4
    extends Y4 {
        private final String yq;

        public G4(String string) {
            StringBuilder stringBuilder = Nr.SN();
            Nr.yq(stringBuilder, string, false);
            this.yq = U7.M(Nr.Gc(stringBuilder));
        }

        public final String toString() {
            return String.format(":contains(%s)", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return U7.M(hN3.Fo()).contains(this.yq);
        }
    }

    public static final class Gc
    extends Y4 {
        Pattern SN;
        String yq;

        public Gc(String string, Pattern pattern) {
            this.yq = U7.KJ(string);
            this.SN = pattern;
        }

        public final String toString() {
            return String.format("[%s~=%s]", this.yq, this.SN.toString());
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            boolean bl = hN3.G4(this.yq) && this.SN.matcher(hN3.N(this.yq)).find();
            return bl;
        }
    }

    public static final class Gd
    extends Y4 {
        public final String toString() {
            return ":empty";
        }

        @Override
        public final boolean yq(hN iK22, hN object) {
            Iterator<iK> iterator;
            for (iK iK2 : ((iK)((Object)iterator)).Gc()) {
                if (iK2 instanceof eb || iK2 instanceof xL) continue;
                return false;
            }
            return true;
        }
    }

    public static final class H
    extends Y4 {
        public final String toString() {
            return ":matchText";
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean yq(hN iK22, hN hN2) {
            void var2_4;
            if (var2_4 instanceof xq) {
                return true;
            }
            for (Ng ng : var2_4.s0()) {
                xq xq2 = new xq(YW.G(var2_4.tl(), l4.tF), var2_4.zH(), var2_4.tF());
                ng.un(xq2);
                xq2.E1(ng);
            }
            return false;
        }
    }

    public static final class KJ
    extends N {
        public KJ(String string, String string2) {
            super(string, string2, false);
        }

        public final String toString() {
            return String.format("[%s^=%s]", this.yq, this.SN);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            boolean bl = hN3.G4(this.yq) && U7.M(hN3.N(this.yq)).startsWith(this.SN);
            return bl;
        }
    }

    public static final class M
    extends N {
        public M(String string, String string2) {
            super(string, string2, true);
        }

        public final String toString() {
            return String.format("[%s!=%s]", this.yq, this.SN);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return this.SN.equalsIgnoreCase(hN3.N(this.yq)) ^ true;
        }
    }

    public static abstract class N
    extends Y4 {
        String SN;
        String yq;

        public N(String string, String string2, boolean bl) {
            co_0.i(string);
            co_0.i(string2);
            this.yq = U7.KJ(string);
            boolean bl2 = string2.startsWith("'") && string2.endsWith("'") || string2.startsWith("\"") && string2.endsWith("\"");
            string = string2;
            if (bl2) {
                string = string2.substring(1, string2.length() - 1);
            }
            string = bl ? U7.KJ(string) : (bl2 ? U7.M(string) : U7.KJ(string));
            this.SN = string;
        }
    }

    public static final class Nl
    extends Y4 {
        public final String toString() {
            return ":first-child";
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            hN2 = hN3.L();
            boolean bl = hN2 != null && !(hN2 instanceof Va) && hN3.C() == 0;
            return bl;
        }
    }

    public static final class O
    extends Y4 {
        public final String toString() {
            return ":last-child";
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            hN2 = hN3.L();
            boolean bl = true;
            if (hN2 == null || hN2 instanceof Va || hN3.C() != ((AbstractCollection)hN2.J()).size() - 1) {
                bl = false;
            }
            return bl;
        }
    }

    public static final class OW
    extends y4.b_0 {
        public OW() {
            super(0, 1);
        }

        @Override
        public final String toString() {
            return ":first-of-type";
        }
    }

    public static final class SN
    extends Y4 {
        private final String yq;

        public SN(String string) {
            this.yq = string;
        }

        public final String toString() {
            return String.format("[%s]", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return hN3.G4(this.yq);
        }
    }

    public static final class U
    extends Y4 {
        private final Pattern yq;

        public U(Pattern pattern) {
            this.yq = pattern;
        }

        public final String toString() {
            return String.format(":matches(%s)", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return this.yq.matcher(hN3.Fo()).find();
        }
    }

    public static final class W
    extends Y4 {
        private final String yq;

        public W(String string) {
            this.yq = string;
        }

        public final String toString() {
            return String.format("#%s", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return this.yq.equals(hN3.Hj());
        }
    }

    public static final class Zm
    extends Y4 {
        public final String toString() {
            return ":only-child";
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            hN2 = hN3.L();
            boolean bl = hN2 != null && !(hN2 instanceof Va) && ((AbstractCollection)hN3.ue()).isEmpty();
            return bl;
        }
    }

    public static final class dT
    extends Y4 {
        private final String yq;

        public dT(String string) {
            this.yq = string;
        }

        public final String toString() {
            return String.format(":containsWholeOwnText(%s)", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return hN3.h().contains(this.yq);
        }
    }

    public static abstract class ee
    extends Y4 {
        int yq;

        public ee(int n2) {
            this.yq = n2;
        }
    }

    public static final class g1
    extends un {
        public g1() {
            super(0, 1);
        }

        @Override
        public final String toString() {
            return ":last-of-type";
        }
    }

    public static final class g9
    extends ee {
        public g9(int n2) {
            super(n2);
        }

        public final String toString() {
            return String.format(":gt(%d)", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            boolean bl = hN3.C() > this.yq;
            return bl;
        }
    }

    public static final class i
    extends N {
        public i(String string, String string2) {
            super(string, string2, true);
        }

        public final String toString() {
            return String.format("[%s*=%s]", this.yq, this.SN);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            boolean bl = hN3.G4(this.yq) && U7.M(hN3.N(this.yq)).contains(this.SN);
            return bl;
        }
    }

    public static final class k
    extends Y4 {
        private final String yq;

        public k(String string) {
            this.yq = string;
        }

        public final String toString() {
            return String.format("%s", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return hN3.nQ().endsWith(this.yq);
        }
    }

    public static final class q
    extends Y4 {
        private final String yq;

        public q(String string) {
            this.yq = string;
        }

        public final String toString() {
            return String.format(".%s", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return hN3.p(this.yq);
        }
    }

    public static final class s
    extends v3 {
        public s(int n2, int n3) {
            super(n2, n3);
        }

        @Override
        protected final String N() {
            return "nth-child";
        }

        @Override
        protected final int SN(hN hN2) {
            return hN2.C() + 1;
        }
    }

    public static final class t0
    extends N {
        public t0(String string, String string2) {
            super(string, string2, false);
        }

        public final String toString() {
            return String.format("[%s$=%s]", this.yq, this.SN);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            boolean bl = hN3.G4(this.yq) && U7.M(hN3.N(this.yq)).endsWith(this.SN);
            return bl;
        }
    }

    public static final class tF
    extends Y4 {
        private final String yq;

        public tF(String string) {
            co_0.i(string);
            this.yq = U7.M(string);
        }

        public final String toString() {
            return String.format("[^%s]", this.yq);
        }

        @Override
        public final boolean yq(hN object, hN hN2) {
            object = hN2.tF().t0().iterator();
            while (object.hasNext()) {
                if (!U7.M(((a_0)object.next()).yq()).startsWith(this.yq)) continue;
                return true;
            }
            return false;
        }
    }

    public static final class tO
    extends Y4 {
        private final Pattern yq;

        public tO(Pattern pattern) {
            this.yq = pattern;
        }

        public final String toString() {
            return String.format(":matchesWholeText(%s)", this.yq);
        }

        @Override
        public final boolean yq(hN object, hN hN2) {
            object = this.yq;
            StringBuilder stringBuilder = Nr.SN();
            rs_0.v(new sA(stringBuilder), hN2);
            return ((Pattern)object).matcher(Nr.Gc(stringBuilder)).find();
        }
    }

    public static class un
    extends v3 {
        public un(int n2, int n3) {
            super(n2, n3);
        }

        @Override
        protected final String N() {
            return "nth-last-of-type";
        }

        @Override
        protected final int SN(hN hN2) {
            Cloneable cloneable = hN2.L();
            int n2 = 0;
            if (cloneable == null) {
                return 0;
            }
            cloneable = hN2.L().J();
            for (int i2 = hN2.C(); i2 < ((AbstractCollection)((Object)cloneable)).size(); ++i2) {
                int n3 = n2;
                if (((hN)((AbstractList)((Object)cloneable)).get(i2)).I().equals(hN2.I())) {
                    n3 = n2 + 1;
                }
                n2 = n3;
            }
            return n2;
        }
    }

    public static final class v
    extends ee {
        public v(int n2) {
            super(n2);
        }

        public final String toString() {
            return String.format(":eq(%d)", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            boolean bl = hN3.C() == this.yq;
            return bl;
        }
    }

    public static abstract class v3
    extends Y4 {
        protected final int SN;
        protected final int yq;

        public v3(int n2, int n3) {
            this.yq = n2;
            this.SN = n3;
        }

        protected abstract String N();

        protected abstract int SN(hN var1);

        public String toString() {
            if (this.yq == 0) {
                return String.format(":%s(%d)", this.N(), this.SN);
            }
            if (this.SN == 0) {
                return String.format(":%s(%dn)", this.N(), this.yq);
            }
            return String.format(":%s(%dn%+d)", this.N(), this.yq, this.SN);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            boolean bl;
            block5: {
                block4: {
                    hN2 = hN3.L();
                    bl = true;
                    boolean bl2 = true;
                    if (hN2 == null || hN2 instanceof Va) break block4;
                    int n2 = this.SN(hN3);
                    int n3 = this.yq;
                    if (n3 == 0) {
                        bl = n2 == this.SN ? bl2 : false;
                        return bl;
                    }
                    if ((n2 -= this.SN) * n3 >= 0 && n2 % n3 == 0) break block5;
                }
                bl = false;
            }
            return bl;
        }
    }

    public static final class xa
    extends ee {
        public xa(int n2) {
            super(n2);
        }

        public final String toString() {
            return String.format(":lt(%d)", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            boolean bl = hN2 != hN3 && hN3.C() < this.yq;
            return bl;
        }
    }

    public static final class yq
    extends Y4 {
        public final String toString() {
            return "*";
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return true;
        }
    }

    public static final class zH
    extends N {
        public zH(String string, String string2) {
            super(string, string2, true);
        }

        public final String toString() {
            return String.format("[%s=%s]", this.yq, this.SN);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            boolean bl = hN3.G4(this.yq) && this.SN.equalsIgnoreCase(hN3.N(this.yq).trim());
            return bl;
        }
    }
}

