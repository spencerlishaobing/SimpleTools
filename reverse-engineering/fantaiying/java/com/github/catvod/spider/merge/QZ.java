/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Dv;
import com.github.catvod.spider.merge.Js;
import com.github.catvod.spider.merge.Ng;
import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.O9;
import com.github.catvod.spider.merge.YW;
import com.github.catvod.spider.merge.Ym;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.eb;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.jt;
import com.github.catvod.spider.merge.k6;
import com.github.catvod.spider.merge.l4;
import com.github.catvod.spider.merge.oJ;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.py_2;
import com.github.catvod.spider.merge.vv_0;
import com.github.catvod.spider.merge.wA;
import com.github.catvod.spider.merge.x1;
import com.github.catvod.spider.merge.xc;
import com.github.catvod.spider.merge.xv;
import java.io.Reader;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class QZ
extends jt {
    static final String[] Nl = new String[]{"applet", "caption", "html", "marquee", "object", "table", "td", "th"};
    static final String[] O;
    static final String[] OW;
    static final String[] b;
    static final String[] g1;
    static final String[] n;
    static final String[] s;
    static final String[] un;
    private vv_0 B;
    private Ym F5;
    private vv_0 G;
    private boolean G4;
    private String[] Gd = new String[]{null};
    private ArrayList<vv_0> W;
    private hN dT;
    private xc.i ee;
    private boolean g9;
    private List<String> v;
    private ArrayList<hN> v3;
    private boolean xa;

    static {
        OW = new String[]{"ol", "ul"};
        O = new String[]{"button"};
        g1 = new String[]{"html", "table"};
        s = new String[]{"optgroup", "option"};
        n = new String[]{"dd", "dt", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc"};
        un = new String[]{"caption", "colgroup", "dd", "dt", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc", "tbody", "td", "tfoot", "th", "thead", "tr"};
        b = new String[]{"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};
    }

    private void G(String ... stringArray) {
        for (int i2 = this.zH.size() - 1; i2 >= 0; --i2) {
            hN hN2 = this.zH.get(i2);
            String string = hN2.nQ();
            int n2 = Nr.i;
            int n3 = stringArray.length;
            int n4 = 0;
            int n5 = 0;
            while (true) {
                n2 = n4;
                if (n5 >= n3) break;
                if (stringArray[n5].equals(string)) {
                    n2 = 1;
                    break;
                }
                ++n5;
            }
            if (n2 != 0 || hN2.nQ().equals("html")) break;
            this.zH.remove(i2);
        }
    }

    private boolean Zm(String[] stringArray, String[] stringArray2, String[] stringArray3) {
        int n2 = this.zH.size() - 1;
        int n3 = n2 > 100 ? n2 - 100 : 0;
        while (n2 >= n3) {
            String string = this.zH.get(n2).nQ();
            if (Nr.N(string, stringArray)) {
                return true;
            }
            if (Nr.N(string, stringArray2)) {
                return false;
            }
            if (stringArray3 != null && Nr.N(string, stringArray3)) {
                return false;
            }
            --n2;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private void k(iK var1_1) {
        block3: {
            if (!this.zH.isEmpty()) break block3;
            var2_2 = this.tF;
            ** GOTO lbl9
        }
        if (this.xa && Nr.N(this.yq().nQ(), vv_0.OW.g1)) {
            this.tO(var1_1);
        } else {
            var2_2 = this.yq();
lbl9:
            // 2 sources

            var2_2.E1(var1_1);
        }
        if (var1_1 instanceof hN && (var2_2 = (hN)var1_1).I().zH() && (var1_1 = this.F5) != null) {
            var1_1.OT(var2_2);
        }
    }

    private static boolean lF(ArrayList<hN> arrayList, hN hN2) {
        int n2 = arrayList.size() - 1;
        int n3 = n2 >= 256 ? n2 - 256 : 0;
        while (n2 >= n3) {
            if (arrayList.get(n2) == hN2) {
                return true;
            }
            --n2;
        }
        return false;
    }

    final void B() {
        int n2;
        hN hN2;
        while (!this.v3.isEmpty() && (hN2 = (n2 = this.v3.size()) > 0 ? this.v3.remove(n2 - 1) : null) != null) {
        }
    }

    final vv_0 C() {
        return this.G;
    }

    final void Cu() {
        if (!this.i3("body")) {
            this.zH.add(this.tF.OT());
        }
        this.B = vv_0.t0;
    }

    final boolean Dr(String string) {
        String[] stringArray = g1;
        String[] stringArray2 = this.Gd;
        stringArray2[0] = string;
        return this.Zm(stringArray2, stringArray, null);
    }

    final Ym E1(xc.t0 object, boolean bl, boolean bl2) {
        YW yW = this.M(((xc.Gc)object).Gd(), this.Gc);
        l4 l42 = this.Gc;
        object = ((xc.Gc)object).G4;
        l42.N((k6)object);
        object = new Ym(yW, (k6)object);
        if (!bl2 || !this.i3("template")) {
            this.F5 = object;
        }
        this.k((iK)object);
        if (bl) {
            this.zH.add((hN)object);
        }
        return object;
    }

    final void F5() {
        this.G("tr", "template");
    }

    final hN Fz(xc.t0 t02) {
        YW yW = this.M(t02.Gd(), this.Gc);
        l4 l42 = this.Gc;
        Cloneable cloneable = t02.G4;
        l42.N((k6)cloneable);
        cloneable = new hN(yW, null, (k6)cloneable);
        this.k((iK)cloneable);
        if (t02.G) {
            if (yW.t0()) {
                if (!yW.tF()) {
                    this.N.v("Tag [%s] cannot be self closing; not a void tag", yW.KJ());
                }
            } else {
                yW.B();
            }
        }
        return cloneable;
    }

    final void G4() {
        this.G("tbody", "tfoot", "thead", "template");
    }

    final hN Gd(String string) {
        hN hN2;
        for (int i2 = this.v3.size() - 1; i2 >= 0 && (hN2 = this.v3.get(i2)) != null; --i2) {
            if (!hN2.nQ().equals(string)) continue;
            return hN2;
        }
        return null;
    }

    final void H(xc.SN object) {
        hN hN2 = this.yq();
        String string = hN2.nQ();
        String string2 = ((xc.SN)object).B();
        object = object instanceof xc.yq ? new oJ(string2) : (this.tF(string) ? new Dv(string2) : new Ng(string2));
        hN2.E1((iK)object);
    }

    final boolean Hj(xc xc2, vv_0 vv_02) {
        this.t0 = xc2;
        return vv_02.tF(xc2, this);
    }

    final void I(vv_0 vv_02) {
        this.B = vv_02;
    }

    final boolean J(hN hN2) {
        return QZ.lF(this.zH, hN2);
    }

    final hN KJ(hN hN2) {
        for (int i2 = this.zH.size() - 1; i2 >= 0; --i2) {
            if (this.zH.get(i2) != hN2) continue;
            return this.zH.get(i2 - 1);
        }
        return null;
    }

    final void L(hN hN2, hN hN3) {
        ArrayList<hN> arrayList = this.v3;
        int n2 = arrayList.lastIndexOf(hN2);
        boolean bl = n2 != -1;
        co_0.tF(bl);
        arrayList.set(n2, hN3);
    }

    /*
     * Unable to fully structure code
     */
    final void LY() {
        block7: {
            if (this.zH.size() > 256) {
                return;
            }
            if (this.v3.size() > 0) {
                var6_1 = this.v3;
                var6_1 = var6_1.get(var6_1.size() - 1);
            } else {
                var6_1 = null;
            }
            if (var6_1 == null || this.J((hN)var6_1)) break block7;
            var3_2 = this.v3.size();
            var2_4 = var1_3 = var3_2 - 12;
            if (var1_3 < 0) {
                var2_4 = 0;
            }
            var5_5 = 1;
            var1_3 = var4_6 = var3_2 - 1;
            do {
                block8: {
                    if (var1_3 != var2_4) break block8;
                    var7_7 = this;
                    var3_2 = var5_5;
                    var2_4 = var1_3;
                    ** GOTO lbl35
                }
                var6_1 = this.v3;
                var3_2 = var1_3 - 1;
                var7_7 = (hN)var6_1.get(var3_2);
                if (var7_7 == null) break;
                var6_1 = var7_7;
                var1_3 = var3_2;
            } while (!this.J((hN)var7_7));
            var8_8 = this;
            var2_4 = var3_2;
            var6_1 = var7_7;
            do {
                var3_2 = 0;
                var7_7 = var8_8;
lbl35:
                // 2 sources

                var1_3 = var2_4;
                if (var3_2 == 0) {
                    var6_1 = var7_7.v3;
                    var1_3 = var2_4 + 1;
                    var6_1 = (hN)var6_1.get(var1_3);
                }
                co_0.Gc(var6_1);
                var8_8 = new hN(var7_7.M(var6_1.nQ(), var7_7.Gc), null, var6_1.tF().KJ());
                super.k((iK)var8_8);
                var7_7.zH.add((hN)var8_8);
                var7_7.v3.set(var1_3, (hN)var8_8);
                var8_8 = var7_7;
                var2_4 = var1_3;
            } while (var1_3 != var4_6);
        }
    }

    @Override
    protected final void N(Reader reader, xv xv2) {
        super.N(reader, xv2);
        this.B = vv_0.yq;
        this.G = null;
        this.G4 = false;
        this.dT = null;
        this.F5 = null;
        this.v3 = new ArrayList();
        this.W = new ArrayList();
        this.v = new ArrayList<String>();
        this.ee = new xc.i();
        this.g9 = true;
        this.xa = false;
    }

    final void N0(hN object) {
        if (this.G4) {
            return;
        }
        if (((String)(object = ((iK)object).yq("href"))).length() != 0) {
            this.i = object;
            this.G4 = true;
            this.tF.Zm((String)object);
        }
    }

    final Ym Nl() {
        return this.F5;
    }

    final hN O() {
        return this.dT;
    }

    final void OB(hN hN2) {
        this.dT = hN2;
    }

    final hN OW(String string) {
        int n2 = this.zH.size() - 1;
        int n3 = n2 >= 256 ? n2 - 256 : 0;
        while (n2 >= n3) {
            hN hN2 = this.zH.get(n2);
            if (hN2.nQ().equals(string)) {
                return hN2;
            }
            --n2;
        }
        return null;
    }

    final hN Q4() {
        int n2 = this.zH.size();
        return this.zH.remove(n2 - 1);
    }

    final void R() {
        this.v = new ArrayList<String>();
    }

    final hN RQ() {
        hN hN2 = new hN(this.M("html", this.Gc), null, null);
        this.k(hN2);
        this.zH.add(hN2);
        return hN2;
    }

    final void U(xc.N n2) {
        this.k(new eb(n2.G()));
    }

    final boolean V(hN hN2) {
        return Nr.N(hN2.nQ(), b);
    }

    final void W(vv_0 vv_02) {
        if (this.yq.yq().yq()) {
            ((AbstractCollection)this.yq.yq()).add(new wA(this.SN, "Unexpected %s token [%s] when in state [%s]", new Object[]{this.t0.getClass().getSimpleName(), this.t0, vv_02}));
        }
    }

    final void XO(hN hN2) {
        this.q(hN2);
        this.v3.add(hN2);
    }

    final boolean Z(hN hN2) {
        return QZ.lF(this.v3, hN2);
    }

    final boolean b(String string) {
        for (int i2 = this.zH.size() - 1; i2 >= 0; --i2) {
            String string2 = this.zH.get(i2).nQ();
            if (string2.equals(string)) {
                return true;
            }
            if (Nr.N(string2, s)) continue;
            return false;
        }
        co_0.SN("Should not be reachable");
        throw null;
    }

    final void cS(boolean bl) {
        this.xa = bl;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    final boolean cp() {
        var1_1 = this.zH.size();
        var5_2 = true;
        var3_3 = var1_1 - 1;
        var2_4 = var3_3 >= 256 ? var3_3 - 256 : 0;
        var7_5 = this.B;
        if (this.zH.size() == 0) {
            this.B = vv_0.t0;
        }
        var4_6 = false;
        while (var3_3 >= var2_4) {
            block54: {
                block53: {
                    var6_7 /* !! */  = this.zH.get(var3_3);
                    if (var3_3 == var2_4) {
                        var4_6 = true;
                    }
                    var6_7 /* !! */  = var6_7 /* !! */  != null ? var6_7 /* !! */ .nQ() : "";
                    Objects.requireNonNull(var6_7 /* !! */ );
                    tmp = -1;
                    switch (var6_7 /* !! */ .hashCode()) {
                        case 552573414: {
                            if (!var6_7 /* !! */ .equals("caption")) break;
                            tmp = 1;
                            break;
                        }
                        case 110326868: {
                            if (!var6_7 /* !! */ .equals("thead")) break;
                            tmp = 2;
                            break;
                        }
                        case 110277346: {
                            if (!var6_7 /* !! */ .equals("tfoot")) break;
                            tmp = 3;
                            break;
                        }
                        case 110157846: {
                            if (!var6_7 /* !! */ .equals("tbody")) break;
                            tmp = 4;
                            break;
                        }
                        case 110115790: {
                            if (!var6_7 /* !! */ .equals("table")) break;
                            tmp = 5;
                            break;
                        }
                        case 3213227: {
                            if (!var6_7 /* !! */ .equals("html")) break;
                            tmp = 6;
                            break;
                        }
                        case 3198432: {
                            if (!var6_7 /* !! */ .equals("head")) break;
                            tmp = 7;
                            break;
                        }
                        case 3029410: {
                            if (!var6_7 /* !! */ .equals("body")) break;
                            tmp = 8;
                            break;
                        }
                        case 3710: {
                            if (!var6_7 /* !! */ .equals("tr")) break;
                            tmp = 9;
                            break;
                        }
                        case 3700: {
                            if (!var6_7 /* !! */ .equals("th")) break;
                            tmp = 10;
                            break;
                        }
                        case 3696: {
                            if (!var6_7 /* !! */ .equals("td")) break;
                            tmp = 11;
                            break;
                        }
                        case -636197633: {
                            if (!var6_7 /* !! */ .equals("colgroup")) break;
                            tmp = 12;
                            break;
                        }
                        case -906021636: {
                            if (!var6_7 /* !! */ .equals("select")) break;
                            tmp = 13;
                            break;
                        }
                        case -1321546630: {
                            if (!var6_7 /* !! */ .equals("template")) break;
                            tmp = 14;
                            break;
                        }
                        case -1644953643: {
                            if (!var6_7 /* !! */ .equals("frameset")) break;
                            tmp = 15;
                            break;
                        }
                    }
                    switch (tmp) {
                        default: {
                            break;
                        }
                        case 1: {
                            var1_1 = 14;
                            break block53;
                        }
                        case 2: {
                            var1_1 = 13;
                            break block53;
                        }
                        case 3: {
                            var1_1 = 12;
                            break block53;
                        }
                        case 4: {
                            var1_1 = 11;
                            break block53;
                        }
                        case 5: {
                            var1_1 = 10;
                            break block53;
                        }
                        case 6: {
                            var1_1 = 9;
                            break block53;
                        }
                        case 7: {
                            var1_1 = 8;
                            break block53;
                        }
                        case 8: {
                            var1_1 = 7;
                            break block53;
                        }
                        case 9: {
                            var1_1 = 6;
                            break block53;
                        }
                        case 10: {
                            var1_1 = 5;
                            break block53;
                        }
                        case 11: {
                            var1_1 = 4;
                            break block53;
                        }
                        case 12: {
                            var1_1 = 3;
                            break block53;
                        }
                        case 13: {
                            var1_1 = 2;
                            break block53;
                        }
                        case 14: {
                            var1_1 = 1;
                            break block53;
                        }
                        case 15: {
                            var1_1 = 0;
                            break block53;
                        }
                    }
                    var1_1 = -1;
                }
                switch (var1_1) {
                    default: {
                        ** break;
                    }
                    case 14: {
                        var6_7 /* !! */  = vv_0.q;
                        break block54;
                    }
                    case 11: 
                    case 12: 
                    case 13: {
                        var6_7 /* !! */  = vv_0.G;
                        break block54;
                    }
                    case 10: {
                        var6_7 /* !! */  = vv_0.M;
                        break block54;
                    }
                    case 9: {
                        var6_7 /* !! */  = this.dT == null ? vv_0.N : vv_0.i;
                        break block54;
                    }
                    case 8: {
                        if (var4_6) ** GOTO lbl171
                        var6_7 /* !! */  = vv_0.tF;
                        break block54;
                    }
                    case 6: {
                        var6_7 /* !! */  = vv_0.G4;
                        break block54;
                    }
                    case 4: 
                    case 5: {
                        if (var4_6) ** GOTO lbl171
                        var6_7 /* !! */  = vv_0.dT;
                        break block54;
                    }
                    case 3: {
                        var6_7 /* !! */  = vv_0.B;
                        break block54;
                    }
                    case 2: {
                        var6_7 /* !! */  = vv_0.F5;
                        break block54;
                    }
                    case 1: {
                        if (this.W.size() > 0) {
                            var6_7 /* !! */  = this.W;
                            var6_7 /* !! */  = var6_7 /* !! */ .get(var6_7 /* !! */ .size() - 1);
                        } else {
                            var6_7 /* !! */  = null;
                        }
                        if (var6_7 /* !! */  == null) throw new py_2("Bug: no template insertion mode on stack!");
                        break block54;
                    }
                    case 0: {
                        var6_7 /* !! */  = vv_0.ee;
                        break block54;
                    }
lbl171:
                    // 3 sources

                    if (!var4_6) ** break;
                    break;
                    case 7: 
                }
                var6_7 /* !! */  = vv_0.t0;
            }
            this.B = var6_7 /* !! */ ;
            break;
            --var3_3;
        }
        if (this.B == var7_5) return false;
        return var5_2;
    }

    final void dT() {
        this.G("table", "template");
    }

    final boolean ee() {
        return this.g9;
    }

    final hN g(xc.t0 object) {
        Object object2;
        Object object3;
        if (((xc.Gc)object).g9() && !((xc.Gc)object).G4.isEmpty() && ((xc.Gc)object).G4.q(this.Gc) > 0) {
            object3 = ((xc.Gc)object).zH;
            object2 = this.yq.yq();
            if (((Js)object2).yq()) {
                ((AbstractCollection)object2).add(new wA(this.SN, "Dropped duplicate attribute(s) in tag [%s]", object3));
            }
        }
        if (((xc.Gc)object).G) {
            object3 = this.Fz((xc.t0)object);
            this.zH.add((hN)object3);
            this.N.xa(O9.yq);
            object2 = this.N;
            object = this.ee;
            ((xc.Gc)object).OW();
            ((xc.Gc)object).xa(((hN)object3).tl());
            ((x1)object2).q((xc)object);
            return object3;
        }
        object3 = this.M(((xc.Gc)object).Gd(), this.Gc);
        object2 = this.Gc;
        object = ((xc.Gc)object).G4;
        ((l4)object2).N((k6)object);
        object = new hN((YW)object3, null, (k6)object);
        this.k((iK)object);
        this.zH.add((hN)object);
        return object;
    }

    final List<String> g1() {
        return this.v;
    }

    final void g9(String string) {
        while (Nr.N(this.yq().nQ(), n) && (string == null || !this.SN(string))) {
            this.Q4();
        }
    }

    final boolean i3(String string) {
        boolean bl = this.OW(string) != null;
        return bl;
    }

    final void j(vv_0 vv_02) {
        this.W.add(vv_02);
    }

    final boolean kR(hN hN2) {
        for (int i2 = this.zH.size() - 1; i2 >= 0; --i2) {
            if (this.zH.get(i2) != hN2) continue;
            this.zH.remove(i2);
            return true;
        }
        return false;
    }

    final void m() {
        this.v3.add(null);
    }

    final int mG(hN hN2) {
        for (int i2 = 0; i2 < this.v3.size(); ++i2) {
            if (hN2 != this.v3.get(i2)) continue;
            return i2;
        }
        return -1;
    }

    final boolean n(String string, String[] stringArray) {
        String[] stringArray2 = Nl;
        String[] stringArray3 = this.Gd;
        stringArray3[0] = string;
        return this.Zm(stringArray3, stringArray2, stringArray);
    }

    final void nQ(hN hN2) {
        int n2;
        int n3 = this.v3.size();
        while ((n2 = n3 - 1) >= 0) {
            n3 = n2;
            if (this.v3.get(n2) != hN2) continue;
            this.v3.remove(n2);
            break;
        }
    }

    final void o(hN hN2, int n2) {
        this.q(hN2);
        try {
            this.v3.add(n2, hN2);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.v3.add(hN2);
        }
    }

    final hN p(String string) {
        for (int i2 = this.zH.size() - 1; i2 >= 0; --i2) {
            hN hN2 = this.zH.get(i2);
            this.zH.remove(i2);
            if (!hN2.nQ().equals(string)) continue;
            boolean bl = this.t0 instanceof xc.i;
            return hN2;
        }
        return null;
    }

    final void q(hN hN2) {
        hN hN3;
        int n2;
        int n3 = this.v3.size() - 1;
        int n4 = n2 = n3 - 12;
        if (n2 < 0) {
            n4 = 0;
        }
        n2 = 0;
        while (n3 >= n4 && (hN3 = this.v3.get(n3)) != null) {
            boolean bl = hN2.nQ().equals(hN3.nQ()) && hN2.tF().equals(hN3.tF());
            int n5 = n2;
            if (bl) {
                n5 = n2 + 1;
            }
            if (n5 == 3) {
                this.v3.remove(n3);
                break;
            }
            --n3;
            n2 = n5;
        }
    }

    final boolean s(String string) {
        return this.n(string, O);
    }

    @Override
    protected final boolean tF(String string) {
        boolean bl = string.equals("script") || string.equals("style");
        return bl;
    }

    final void tO(iK iK2) {
        hN hN2;
        hN hN3 = this.OW("table");
        boolean bl = false;
        if (hN3 != null) {
            if (hN3.L() != null) {
                hN2 = hN3.L();
                bl = true;
            } else {
                hN2 = this.KJ(hN3);
            }
        } else {
            hN2 = this.zH.get(0);
        }
        if (bl) {
            co_0.Gc(hN3);
            hN3.xU(iK2);
        } else {
            hN2.E1(iK2);
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = oi_0.yq("TreeBuilder{currentToken=");
        stringBuilder.append(this.t0);
        stringBuilder.append(", state=");
        stringBuilder.append((Object)this.B);
        stringBuilder.append(", currentElement=");
        stringBuilder.append(this.yq());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    final void u7() {
        this.F5 = null;
    }

    final int ue() {
        return this.W.size();
    }

    final boolean un(String[] stringArray) {
        return this.Zm(stringArray, Nl, null);
    }

    final void v(boolean bl) {
        this.g9 = bl;
    }

    final void v3() {
        this.g9("p");
        if (!"p".equals(this.yq().nQ())) {
            this.W(this.B);
        }
        this.p("p");
    }

    final vv_0 w() {
        if (this.W.size() > 0) {
            ArrayList<vv_0> arrayList = this.W;
            return arrayList.remove(arrayList.size() - 1);
        }
        return null;
    }

    final vv_0 x() {
        return this.B;
    }

    final void xU() {
        this.G = this.B;
    }

    final void xa(boolean bl) {
        String[] stringArray = bl ? un : n;
        while (Nr.N(this.yq().nQ(), stringArray)) {
            this.Q4();
        }
    }

    @Override
    protected final boolean zH(xc xc2) {
        this.t0 = xc2;
        return this.B.tF(xc2, this);
    }
}

