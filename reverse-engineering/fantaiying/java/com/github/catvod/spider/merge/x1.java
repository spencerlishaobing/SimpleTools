/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Js;
import com.github.catvod.spider.merge.O9;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.il_1;
import com.github.catvod.spider.merge.nS;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.wA;
import com.github.catvod.spider.merge.xc;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Objects;

final class x1 {
    private static final char[] g9;
    static final int[] xa;
    xc.SN B;
    private String F5;
    xc.tF G;
    xc.N G4;
    StringBuilder Gc;
    xc.i KJ;
    xc.t0 M;
    private O9 N = O9.yq;
    private final Js SN;
    private int W = -1;
    private String dT;
    private final int[] ee;
    private String i = null;
    xc.Gc q;
    private final StringBuilder t0 = new StringBuilder(1024);
    private xc tF = null;
    private final int[] v;
    private int v3;
    private final nS yq;
    private boolean zH = false;

    static {
        char[] cArray;
        char[] cArray2 = cArray = new char[7];
        cArray[0] = 9;
        cArray2[1] = 10;
        cArray2[2] = 13;
        cArray2[3] = 12;
        cArray2[4] = 32;
        cArray2[5] = 60;
        cArray2[6] = 38;
        g9 = cArray;
        xa = new int[]{8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
        Arrays.sort(cArray);
    }

    x1(nS nS2, Js js) {
        this.Gc = new StringBuilder(1024);
        this.M = new xc.t0();
        this.KJ = new xc.i();
        this.q = this.M;
        this.B = new xc.SN();
        this.G = new xc.tF();
        this.G4 = new xc.N();
        this.v = new int[1];
        this.ee = new int[2];
        this.yq = nS2;
        this.SN = js;
    }

    private void tF(String string, Object ... objectArray) {
        if (this.SN.yq()) {
            Js js = this.SN;
            nS nS2 = this.yq;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid character reference: ");
            stringBuilder.append(string);
            ((AbstractCollection)js).add(new wA(nS2, String.format(stringBuilder.toString(), objectArray)));
        }
    }

    final void B(String string) {
        if (this.i == null) {
            this.i = string;
        } else {
            if (this.t0.length() == 0) {
                this.t0.append(this.i);
            }
            this.t0.append(string);
        }
        this.B.KJ(this.W);
        this.B.yq(this.yq.E1());
    }

    final void F5() {
        this.q.v();
        this.q(this.q);
    }

    final void G(StringBuilder stringBuilder) {
        if (this.i == null) {
            this.i = stringBuilder.toString();
        } else {
            if (this.t0.length() == 0) {
                this.t0.append(this.i);
            }
            this.t0.append((CharSequence)stringBuilder);
        }
        this.B.KJ(this.W);
        this.B.yq(this.yq.E1());
    }

    final void G4() {
        this.q(this.G4);
    }

    final xc.Gc Gc(boolean bl) {
        xc.Gc gc;
        if (bl) {
            gc = this.M;
            ((xc.t0)gc).OW();
        } else {
            gc = this.KJ;
            gc.OW();
        }
        this.q = gc;
        return gc;
    }

    final void KJ(char c) {
        if (this.i == null) {
            this.i = String.valueOf(c);
        } else {
            if (this.t0.length() == 0) {
                this.t0.append(this.i);
            }
            this.t0.append(c);
        }
        this.B.KJ(this.W);
        this.B.yq(this.yq.E1());
    }

    final void M() {
        xc.M(this.Gc);
    }

    final String N() {
        if (this.F5 == null) {
            StringBuilder stringBuilder = oi_0.yq("</");
            stringBuilder.append(this.dT);
            this.F5 = stringBuilder.toString();
        }
        return this.F5;
    }

    final String SN() {
        return this.dT;
    }

    final void W(O9 o92) {
        if (this.SN.yq()) {
            Js js = this.SN;
            nS nS2 = this.yq;
            ((AbstractCollection)js).add(new wA(nS2, "Unexpected character '%s' in input state [%s]", new Object[]{Character.valueOf(nS2.g9()), o92}));
        }
    }

    final void dT() {
        this.q(this.G);
    }

    final boolean ee() {
        boolean bl = this.dT != null && this.q.Gd().equalsIgnoreCase(this.dT);
        return bl;
    }

    final xc g9() {
        while (!this.zH) {
            this.N.t0(this, this.yq);
        }
        Object object = this.t0;
        if (((StringBuilder)object).length() != 0) {
            String string = ((StringBuilder)object).toString();
            ((StringBuilder)object).delete(0, ((StringBuilder)object).length());
            object = this.B;
            ((xc.SN)object).q(string);
            this.i = null;
            return object;
        }
        String string = this.i;
        if (string != null) {
            object = this.B;
            ((xc.SN)object).q(string);
            this.i = null;
            return object;
        }
        this.zH = false;
        return this.tF;
    }

    final void i() {
        this.G4.Gc();
        Objects.requireNonNull(this.G4);
    }

    final void q(xc xc2) {
        co_0.N(this.zH);
        this.tF = xc2;
        this.zH = true;
        xc2.KJ(this.v3);
        xc2.yq(this.yq.E1());
        this.W = -1;
        int n2 = xc2.yq;
        if (n2 == 2) {
            this.dT = ((xc.t0)xc2).tF;
            this.F5 = null;
        } else if (n2 == 3 && ((xc.Gc)(xc2 = (xc.i)xc2)).g9()) {
            this.v("Attributes incorrectly present on end tag [/%s]", ((xc.Gc)xc2).zH);
        }
    }

    final void t0() {
        this.G.Gc();
    }

    final void v(String string, Object ... objectArray) {
        if (this.SN.yq()) {
            ((AbstractCollection)this.SN).add(new wA(this.yq, string, objectArray));
        }
    }

    final void v3(O9 o92) {
        if (this.SN.yq()) {
            ((AbstractCollection)this.SN).add(new wA(this.yq, "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[]{o92}));
        }
    }

    final void xa(O9 o92) {
        int n2 = o92.ordinal();
        if (n2 != 0) {
            if (n2 == 7) {
                this.v3 = this.yq.E1();
            }
        } else if (this.W == -1) {
            this.W = this.yq.E1();
        }
        this.N = o92;
    }

    final void yq(O9 o92) {
        this.xa(o92);
        this.yq.yq();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final int[] zH(Character object, boolean bl) {
        int n2;
        Object object2;
        block21: {
            block20: {
                block19: {
                    if (this.yq.Gd()) {
                        return null;
                    }
                    if (object != null && ((Character)object).charValue() == this.yq.g9()) {
                        return null;
                    }
                    if (this.yq.Dr(g9)) {
                        return null;
                    }
                    object2 = this.v;
                    this.yq.s();
                    if (!this.yq.n("#")) break block19;
                    bl = this.yq.un("X");
                    object = this.yq;
                    object = bl ? ((nS)object).KJ() : ((nS)object).M();
                    if (((String)object).length() == 0) {
                        this.tF("numeric reference with no numerals", new Object[0]);
                        break block20;
                    } else {
                        this.yq.Z();
                        if (!this.yq.n(";")) {
                            this.tF("missing semicolon on [&#%s]", object);
                        }
                        int n3 = bl ? 16 : 10;
                        try {
                            n3 = Integer.valueOf((String)object, n3);
                        }
                        catch (NumberFormatException numberFormatException) {
                            n3 = -1;
                        }
                        if (n3 != -1 && (n3 < 55296 || n3 > 57343) && n3 <= 0x10FFFF) {
                            Object object3;
                            int n4 = n3;
                            if (n3 >= 128) {
                                object = xa;
                                int n5 = n3;
                                if (n3 < 160) {
                                    this.tF("character [%s] is not a valid unicode code point", n3);
                                    object3 = object[n3 - 128];
                                }
                            }
                            object2[0] = object3;
                            return object2;
                        }
                        this.tF("character [%s] outside of valid range", n3);
                        object2[0] = 65533;
                        return object2;
                    }
                }
                object = this.yq.B();
                boolean bl2 = this.yq.b(';');
                n2 = !(il_1.zH((String)object) || il_1.i((String)object) && bl2) ? 0 : 1;
                if (n2 == 0) {
                    this.yq.tO();
                    if (!bl2) return null;
                    this.tF("invalid named reference [%s]", object);
                    return null;
                }
                if (!bl || !this.yq.U() && !this.yq.H() && !this.yq.Zm('=', '-', '_')) break block21;
            }
            this.yq.tO();
            return null;
        }
        this.yq.Z();
        if (!this.yq.n(";")) {
            this.tF("missing semicolon on [&%s]", object);
        }
        if ((n2 = il_1.N((String)object, this.ee)) == 1) {
            object2[0] = this.ee[0];
            return object2;
        }
        if (n2 == 2) {
            return this.ee;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Unexpected characters returned for ");
        ((StringBuilder)object2).append((String)object);
        co_0.SN(((StringBuilder)object2).toString());
        throw null;
    }
}

