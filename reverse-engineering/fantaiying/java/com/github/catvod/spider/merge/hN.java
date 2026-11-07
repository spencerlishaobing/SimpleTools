/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Dv;
import com.github.catvod.spider.merge.IV;
import com.github.catvod.spider.merge.Ng;
import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.Y4;
import com.github.catvod.spider.merge.YW;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.di;
import com.github.catvod.spider.merge.do_0;
import com.github.catvod.spider.merge.eb;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.iY;
import com.github.catvod.spider.merge.k6;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.l4;
import com.github.catvod.spider.merge.oJ;
import com.github.catvod.spider.merge.py_2;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.wu_0;
import com.github.catvod.spider.merge.z2_0;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class hN
extends iK {
    private static final List<hN> Gc = Collections.emptyList();
    private static final String M;
    List<iK> i;
    k6 t0;
    private YW tF;
    private WeakReference<List<hN>> zH;

    static {
        Pattern.compile("\\s+");
        M = k6.v("baseUri");
    }

    public hN(YW yW, String string, k6 k62) {
        co_0.Gc(yW);
        this.i = iK.N;
        this.t0 = k62;
        this.tF = yW;
        if (string != null) {
            this.q(string);
        }
    }

    public hN(String string) {
        this(YW.G(string, l4.tF), "", null);
    }

    private static void Fz(hN hN2, kb_0 kb_02) {
        hN2 = (hN)hN2.yq;
        if (hN2 != null && !hN2.tl().equals("#root")) {
            ((AbstractCollection)kb_02).add(hN2);
            hN.Fz(hN2, kb_02);
        }
    }

    private static <E extends hN> int XO(hN hN2, List<E> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (list.get(i2) != hN2) continue;
            return i2;
        }
        return 0;
    }

    private static void Z(iK iK2, StringBuilder stringBuilder) {
        if (iK2 instanceof Ng) {
            stringBuilder.append(((Ng)iK2).H());
        } else if (iK2 instanceof hN && ((hN)iK2).tF.KJ().equals("br")) {
            stringBuilder.append("\n");
        }
    }

    static boolean cp(iK iK2) {
        if (iK2 instanceof hN) {
            hN hN2;
            iK2 = (hN)iK2;
            int n2 = 0;
            do {
                if (((hN)iK2).tF.q()) {
                    return true;
                }
                hN2 = (hN)iK2.yq;
                if (++n2 >= 6) break;
                iK2 = hN2;
            } while (hN2 != null);
        }
        return false;
    }

    public static /* synthetic */ void g(StringBuilder stringBuilder, iK iK2) {
        hN.Z(iK2, stringBuilder);
    }

    private static void k(StringBuilder stringBuilder, Ng ng) {
        String string = ng.H();
        if (!hN.cp(ng.yq) && !(ng instanceof oJ)) {
            Nr.yq(stringBuilder, string, Ng.m(stringBuilder));
        } else {
            stringBuilder.append(string);
        }
    }

    @Override
    public final iK B() {
        this.i.clear();
        return this;
    }

    public final int C() {
        iK iK2 = this.yq;
        if ((hN)iK2 == null) {
            return 0;
        }
        return hN.XO(this, ((hN)iK2).R());
    }

    public final kb_0 Cu() {
        kb_0 kb_02 = new kb_0();
        hN.Fz(this, kb_02);
        return kb_02;
    }

    public final hN E1(iK iK2) {
        iK iK3 = iK2.yq;
        if (iK3 != null) {
            iK3.n(iK2);
        }
        iK2.yq = this;
        this.G();
        this.i.add(iK2);
        iK2.SN = this.i.size() - 1;
        return this;
    }

    public final String Fo() {
        StringBuilder stringBuilder = Nr.SN();
        rs_0.v(new IV(stringBuilder){
            final StringBuilder yq;
            {
                this.yq = stringBuilder;
            }

            @Override
            public final void SN(iK iK2, int n2) {
                if (iK2 instanceof Ng) {
                    iK2 = (Ng)iK2;
                    hN.k(this.yq, (Ng)iK2);
                } else if (iK2 instanceof hN) {
                    iK2 = (hN)iK2;
                    if (this.yq.length() > 0 && (((hN)iK2).j() || ((hN)iK2).tF.KJ().equals("br")) && !Ng.m(this.yq)) {
                        this.yq.append(' ');
                    }
                }
            }

            @Override
            public final void yq(iK iK2, int n2) {
                if (iK2 instanceof hN && ((hN)iK2).j() && iK2.W() instanceof Ng && !Ng.m(this.yq)) {
                    this.yq.append(' ');
                }
            }
        }, this);
        return Nr.Gc(stringBuilder).trim();
    }

    @Override
    protected final List<iK> G() {
        if (this.i == iK.N) {
            this.i = new SN(this, 4);
        }
        return this.i;
    }

    @Override
    void Gd(Appendable appendable, int n2, Va.yq yq2) {
        if (!this.i.isEmpty() || !this.tF.M()) {
            if (yq2.t0() && !this.i.isEmpty() && this.tF.yq()) {
                this.v3(appendable, n2, yq2);
            }
            appendable.append("</").append(this.tl()).append('>');
        }
    }

    public final String Hj() {
        Object object = this.t0;
        object = object != null ? ((k6)object).G("id") : "";
        return object;
    }

    public final YW I() {
        return this.tF;
    }

    public final kb_0 J() {
        return new kb_0(this.R());
    }

    @Override
    protected final iK KJ(iK cloneable) {
        hN hN2 = (hN)super.KJ((iK)cloneable);
        cloneable = this.t0;
        cloneable = cloneable != null ? ((k6)cloneable).KJ() : null;
        hN2.t0 = cloneable;
        cloneable = new SN(hN2, this.i.size());
        hN2.i = cloneable;
        ((iY)cloneable).addAll(this.i);
        return hN2;
    }

    public final hN L() {
        return (hN)this.yq;
    }

    final void LY() {
        this.zH = null;
    }

    public final hN N0() {
        return this.R().get(0);
    }

    public final hN OB(String string) {
        return z2_0.yq(string, this);
    }

    @Override
    public final iK OW() {
        return (hN)this.yq;
    }

    public final kb_0 Q4() {
        return wu_0.yq(new Y4.yq(), this);
    }

    public hN Qz(String object) {
        co_0.Gc(object);
        this.i.clear();
        Va va2 = this.Nl();
        object = va2 != null && va2.HE().SN(this.nQ()) ? new Dv((String)object) : new Ng((String)object);
        this.E1((iK)object);
        return this;
    }

    final List<hN> R() {
        Object object;
        block6: {
            Object object2;
            block5: {
                if (this.t0() == 0) {
                    return Gc;
                }
                object = this.zH;
                if (object == null) break block5;
                object2 = (List)((Reference)object).get();
                object = object2;
                if (object2 != null) break block6;
            }
            int n2 = this.i.size();
            object = new ArrayList<hN>(n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                object2 = this.i.get(i2);
                if (!(object2 instanceof hN)) continue;
                ((ArrayList)object).add((hN)((hN)object2));
            }
            this.zH = new WeakReference<ArrayList<hN>>((ArrayList<hN>)object);
        }
        return object;
    }

    public final hN RQ(String string) {
        co_0.Gc(string);
        this.E1(new Ng(string));
        return this;
    }

    public final hN V(String string, String string2) {
        string = di.yq(this).zH().SN(string);
        this.tF().Nl(string, string2);
        return this;
    }

    @Override
    public final iK b() {
        iK iK2;
        iK iK3 = this;
        while ((iK2 = iK3.yq) != null) {
            iK3 = iK2;
        }
        return iK3;
    }

    public final kb_0 cS(String object) {
        co_0.i((String)object);
        object = do_0.KJ((String)object);
        co_0.Gc(object);
        return wu_0.yq((Y4)object, this);
    }

    @Override
    protected final boolean dT() {
        boolean bl = this.t0 != null;
        return bl;
    }

    public final String h() {
        StringBuilder stringBuilder = Nr.SN();
        int n2 = this.t0();
        for (int i2 = 0; i2 < n2; ++i2) {
            hN.Z(this.i.get(i2), stringBuilder);
        }
        return Nr.Gc(stringBuilder);
    }

    public hN i3() {
        return (hN)super.M();
    }

    public final boolean j() {
        return this.tF.N();
    }

    public final String kR() {
        StringBuilder stringBuilder = Nr.SN();
        for (int i2 = 0; i2 < this.t0(); ++i2) {
            iK iK2 = this.i.get(i2);
            if (iK2 instanceof Ng) {
                hN.k(stringBuilder, (Ng)iK2);
                continue;
            }
            if (!(iK2 instanceof hN) || !((hN)iK2).tF.KJ().equals("br") || Ng.m(stringBuilder)) continue;
            stringBuilder.append(" ");
        }
        return Nr.Gc(stringBuilder).trim();
    }

    /*
     * WARNING - void declaration
     */
    public final String lF() {
        StringBuilder stringBuilder = Nr.SN();
        for (iK iK2 : this.i) {
            void var1_9;
            if (iK2 instanceof Dv) {
                String string = ((Dv)iK2).H();
            } else if (iK2 instanceof eb) {
                String string = ((eb)iK2).H();
            } else if (iK2 instanceof hN) {
                String string = ((hN)iK2).lF();
            } else {
                if (!(iK2 instanceof oJ)) continue;
                String string = ((oJ)iK2).H();
            }
            stringBuilder.append((String)var1_9);
        }
        return Nr.Gc(stringBuilder);
    }

    public final hN m(String object) {
        object = new hN(YW.G((String)object, di.yq(this).zH()), this.zH(), null);
        this.E1((iK)object);
        return object;
    }

    public final String mG() {
        Object object = Nr.SN();
        int n2 = this.i.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.i.get(i2).g9((Appendable)object);
        }
        String string = Nr.Gc((StringBuilder)object);
        object = this.Nl();
        if (object == null) {
            object = new Va("");
        }
        String string2 = string;
        if (((Va)object).D().t0()) {
            string2 = string.trim();
        }
        return string2;
    }

    public final String nQ() {
        return this.tF.KJ();
    }

    public final hN o() {
        Object object = this.yq;
        if (object == null) {
            return null;
        }
        object = ((hN)object).R();
        int n2 = hN.XO(this, object);
        int n3 = object.size();
        if (n3 > ++n2) {
            return (hN)object.get(n2);
        }
        return null;
    }

    public final boolean p(String string) {
        Object object = this.t0;
        if (object == null) {
            return false;
        }
        object = ((k6)object).G("class");
        int n2 = ((String)object).length();
        int n3 = string.length();
        if (n2 != 0 && n2 >= n3) {
            if (n2 == n3) {
                return string.equalsIgnoreCase((String)object);
            }
            boolean bl = false;
            int n4 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n5;
                boolean bl2;
                if (Character.isWhitespace(((String)object).charAt(i2))) {
                    bl2 = bl;
                    n5 = n4;
                    if (bl) {
                        if (i2 - n4 == n3 && ((String)object).regionMatches(true, n4, string, 0, n3)) {
                            return true;
                        }
                        bl2 = false;
                        n5 = n4;
                    }
                } else {
                    bl2 = bl;
                    n5 = n4;
                    if (!bl) {
                        n5 = i2;
                        bl2 = true;
                    }
                }
                bl = bl2;
                n4 = n5;
            }
            if (bl && n2 - n4 == n3) {
                return ((String)object).regionMatches(true, n4, string, 0, n3);
            }
        }
        return false;
    }

    @Override
    protected final void q(String string) {
        this.tF().Gd(M, string);
    }

    public final List<Ng> s0() {
        ArrayList<Ng> arrayList = new ArrayList<Ng>();
        for (iK iK2 : this.i) {
            if (!(iK2 instanceof Ng)) continue;
            arrayList.add((Ng)iK2);
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override
    public final int t0() {
        return this.i.size();
    }

    @Override
    public final k6 tF() {
        if (this.t0 == null) {
            this.t0 = new k6();
        }
        return this.t0;
    }

    public final hN tO(Collection<? extends iK> collection) {
        if (collection != null) {
            int n2 = this.t0();
            int n3 = n2 + 1 - 1;
            boolean bl = n3 >= 0 && n3 <= n2;
            co_0.zH(bl, "Insert position out of bounds.");
            this.SN(n3, new ArrayList<iK>(collection).toArray(new iK[0]));
            return this;
        }
        throw new py_2("Children collection to be inserted must not be null.");
    }

    public final String tl() {
        return this.tF.SN();
    }

    public final hN u7() {
        Object object = this.yq;
        if (object == null) {
            return null;
        }
        int n2 = hN.XO(this, object = ((hN)object).R());
        if (n2 > 0) {
            return (hN)object.get(n2 - 1);
        }
        return null;
    }

    public final kb_0 ue() {
        Cloneable cloneable = this.yq;
        if (cloneable == null) {
            return new kb_0(0);
        }
        Object object = ((hN)cloneable).R();
        cloneable = new kb_0(object.size() - 1);
        object = object.iterator();
        while (object.hasNext()) {
            hN hN2 = (hN)object.next();
            if (hN2 == this) continue;
            ((AbstractCollection)((Object)cloneable)).add(hN2);
        }
        return cloneable;
    }

    @Override
    public String v() {
        return this.tF.SN();
    }

    public final boolean w() {
        for (iK iK2 : this.i) {
            if (!(iK2 instanceof Ng ? !((Ng)iK2).tO() : iK2 instanceof hN && ((hN)iK2).w())) continue;
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    final boolean x(Va.yq cloneable) {
        boolean bl = ((Va.yq)cloneable).t0();
        boolean bl2 = true;
        if (!bl) return false;
        if (!this.tF.yq()) {
            cloneable = (hN)this.yq;
            if (cloneable == null) return false;
            if (!((hN)cloneable).tF.yq()) {
                return false;
            }
        }
        boolean bl3 = true;
        if (!bl3) return false;
        if (this.tF.i() && ((cloneable = (hN)this.yq) == null || ((hN)cloneable).j())) {
            iK iK2 = this.yq;
            cloneable = null;
            if (iK2 != null && this.SN > 0) {
                cloneable = iK2.G().get(this.SN - 1);
            }
            if (cloneable != null) {
                return false;
            }
        }
        bl3 = false;
        if (bl3) return false;
        return bl2;
    }

    public final hN xU(iK iK2) {
        co_0.Gc(this.yq);
        this.yq.SN(this.SN, iK2);
        return this;
    }

    @Override
    void xa(Appendable appendable, int n2, Va.yq yq2) {
        if (this.x(yq2) && (!(appendable instanceof StringBuilder) || ((StringBuilder)appendable).length() > 0)) {
            this.v3(appendable, n2, yq2);
        }
        appendable.append('<').append(this.tl());
        k6 k62 = this.t0;
        if (k62 != null) {
            k62.F5(appendable, yq2);
        }
        if (this.i.isEmpty() && this.tF.M() && (yq2.Gc() != 1 || !this.tF.tF())) {
            appendable.append(" />");
        } else {
            appendable.append('>');
        }
    }

    @Override
    public final String zH() {
        Object object;
        block2: {
            String string = M;
            object = this;
            while (object != null) {
                boolean bl;
                k6 k62 = ((hN)object).t0;
                if (k62 != null && (bl = k62.v3(string) != -1)) {
                    object = ((hN)object).t0.B(string);
                    break block2;
                }
                object = (hN)((iK)object).yq;
            }
            object = "";
        }
        return object;
    }

    private static final class SN
    extends iY<iK> {
        private final hN yq;

        SN(hN hN2, int n2) {
            super(n2);
            this.yq = hN2;
        }

        @Override
        public final void yq() {
            this.yq.LY();
        }
    }
}

