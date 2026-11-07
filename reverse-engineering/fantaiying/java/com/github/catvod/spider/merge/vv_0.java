/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.O9;
import com.github.catvod.spider.merge.QZ;
import com.github.catvod.spider.merge.cp;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.jt;
import com.github.catvod.spider.merge.xL;
import com.github.catvod.spider.merge.xc;
import java.util.ArrayList;
import java.util.Objects;

/*
 * Renamed from com.github.catvod.spider.merge.vV
 */
abstract class vv_0
extends Enum<vv_0> {
    public static final /* enum */ N B;
    public static final /* enum */ t0 F5;
    public static final /* enum */ tF G;
    public static final /* enum */ zH G4;
    public static final /* enum */ Gd Gc;
    public static final /* enum */ dT Gd;
    public static final /* enum */ yq KJ;
    public static final /* enum */ Nl M;
    public static final /* enum */ W N;
    public static final /* enum */ F5 Nl;
    private static final vv_0[] O;
    private static final String OW;
    public static final /* enum */ v3 SN;
    public static final /* enum */ M W;
    public static final /* enum */ i dT;
    public static final /* enum */ B ee;
    public static final /* enum */ G g9;
    public static final /* enum */ g9 i;
    public static final /* enum */ SN q;
    public static final /* enum */ xa t0;
    public static final /* enum */ v tF;
    public static final /* enum */ KJ v;
    public static final /* enum */ Gc v3;
    public static final /* enum */ G4 xa;
    public static final /* enum */ q yq;
    public static final /* enum */ ee zH;

    static {
        vv_0 vv_02 = new vv_0(){

            @Override
            final boolean tF(xc object, QZ qZ) {
                v3 v32;
                block7: {
                    block6: {
                        block5: {
                            v32 = SN;
                            if (vv_0.yq((xc)object)) {
                                return true;
                            }
                            if (!((xc)object).N()) break block5;
                            qZ.U((xc.N)object);
                            break block6;
                        }
                        if (!((xc)object).tF()) break block7;
                        xc.tF tF2 = (xc.tF)object;
                        object = new xL(qZ.Gc.tF(tF2.tF.toString()), tF2.i.toString(), tF2.t0.toString());
                        ((xL)object).E1(tF2.zH);
                        qZ.tF.E1((iK)object);
                        if (tF2.Gc) {
                            qZ.tF.gt();
                        }
                        qZ.I(v32);
                    }
                    return true;
                }
                qZ.I(v32);
                return qZ.zH((xc)object);
            }
        };
        yq = vv_02;
        vv_0 vv_03 = new vv_0(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            final boolean tF(xc xc2, QZ qZ) {
                W w = N;
                if (xc2.tF()) {
                    qZ.W(this);
                    return false;
                }
                if (xc2.N()) {
                    qZ.U((xc.N)xc2);
                    return true;
                }
                if (vv_0.yq(xc2)) {
                    qZ.H((xc.SN)xc2);
                    return true;
                }
                if (xc2.t0()) {
                    xc.t0 t02 = (xc.t0)xc2;
                    if (t02.zH.equals("html")) {
                        qZ.g(t02);
                        qZ.I(w);
                        return true;
                    }
                }
                if (xc2.i() && Nr.N(((xc.i)xc2).zH, com.github.catvod.spider.merge.vV$OW.zH) || !xc2.i()) {
                    qZ.RQ();
                    qZ.I(w);
                    return qZ.zH(xc2);
                }
                qZ.W(this);
                return false;
            }
        };
        SN = vv_03;
        vv_0 vv_04 = new vv_0(){

            @Override
            final boolean tF(xc xc2, QZ qZ) {
                block10: {
                    block8: {
                        block9: {
                            block7: {
                                if (!vv_0.yq(xc2)) break block7;
                                qZ.H((xc.SN)xc2);
                                break block8;
                            }
                            if (!xc2.N()) break block9;
                            qZ.U((xc.N)xc2);
                            break block8;
                        }
                        if (xc2.tF()) {
                            qZ.W(this);
                            return false;
                        }
                        if (xc2.t0() && ((xc.t0)xc2).zH.equals("html")) {
                            return t0.tF(xc2, qZ);
                        }
                        if (!xc2.t0()) break block10;
                        xc.t0 t02 = (xc.t0)xc2;
                        if (!t02.zH.equals("head")) break block10;
                        qZ.OB(qZ.g(t02));
                        qZ.I(tF);
                    }
                    return true;
                }
                if (xc2.i() && Nr.N(((xc.i)xc2).zH, com.github.catvod.spider.merge.vV$OW.zH)) {
                    qZ.Gc("head");
                    return qZ.zH(xc2);
                }
                if (xc2.i()) {
                    qZ.W(this);
                    return false;
                }
                qZ.Gc("head");
                return qZ.zH(xc2);
            }
        };
        N = vv_04;
        vv_0 vv_05 = new vv_0(){

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             */
            @Override
            final boolean tF(xc object, QZ qZ) {
                String string;
                xc.t0 t02;
                void var2_7;
                Gd gd;
                block24: {
                    void var1_3;
                    block23: {
                        gd = Gc;
                        if (vv_0.yq(object)) {
                            var2_7.H((xc.SN)object);
                            return true;
                        }
                        int n2 = cp.SN(object.yq);
                        if (n2 == 0) {
                            var2_7.W(this);
                            return false;
                        }
                        if (n2 != 1) {
                            if (n2 != 2) {
                                if (n2 != 3) {
                                    var2_7.i("head");
                                    return var2_7.zH((xc)object);
                                }
                                var2_7.U((xc.N)object);
                                return true;
                            }
                            String string2 = ((xc.i)object).zH;
                            if (string2.equals("head")) {
                                var2_7.Q4();
                                g9 g92 = i;
                                break block23;
                            } else {
                                if (Nr.N(string2, com.github.catvod.spider.merge.vV$OW.N)) {
                                    var2_7.i("head");
                                    return var2_7.zH((xc)object);
                                }
                                if (!string2.equals("template")) {
                                    var2_7.W(this);
                                    return false;
                                }
                                if (!var2_7.i3(string2)) {
                                    var2_7.W(this);
                                    return true;
                                }
                                var2_7.xa(true);
                                if (!string2.equals(var2_7.yq().nQ())) {
                                    var2_7.W(this);
                                }
                                var2_7.p(string2);
                                var2_7.B();
                                var2_7.w();
                                var2_7.cp();
                                return true;
                            }
                        }
                        t02 = (xc.t0)object;
                        string = t02.zH;
                        if (string.equals("html")) {
                            return t0.tF((xc)object, (QZ)var2_7);
                        }
                        if (Nr.N(string, com.github.catvod.spider.merge.vV$OW.yq)) {
                            hN hN2 = var2_7.Fz(t02);
                            if (!string.equals("base")) return true;
                            if (!hN2.G4("href")) return true;
                            var2_7.N0(hN2);
                            return true;
                        }
                        if (string.equals("meta")) {
                            var2_7.Fz(t02);
                            return true;
                        }
                        if (string.equals("title")) {
                            var2_7.N.xa(O9.N);
                            var2_7.xU();
                            var2_7.I(gd);
                            var2_7.g(t02);
                            return true;
                        }
                        if (Nr.N(string, com.github.catvod.spider.merge.vV$OW.SN)) {
                            vv_0.SN(t02, (QZ)var2_7);
                            return true;
                        }
                        if (!string.equals("noscript")) break block24;
                        var2_7.g(t02);
                        ee ee2 = zH;
                    }
                    var2_7.I((vv_0)var1_3);
                    return true;
                }
                if (string.equals("script")) {
                    var2_7.N.xa(O9.i);
                    var2_7.xU();
                    var2_7.I(gd);
                    var2_7.g(t02);
                    return true;
                }
                if (string.equals("head")) {
                    var2_7.W(this);
                    return false;
                }
                if (string.equals("template")) {
                    var2_7.g(t02);
                    var2_7.m();
                    var2_7.v(false);
                    M m2 = W;
                    var2_7.I(m2);
                    var2_7.j(m2);
                    return true;
                }
                var2_7.i("head");
                return var2_7.zH((xc)object);
            }
        };
        tF = vv_05;
        vv_0 vv_06 = new vv_0(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            final boolean tF(xc xc2, QZ qZ) {
                Object object = tF;
                if (xc2.tF()) {
                    qZ.W(this);
                    return true;
                }
                if (xc2.t0() && ((xc.t0)xc2).zH.equals("html")) {
                    return qZ.Hj(xc2, t0);
                }
                if (xc2.i() && ((xc.i)xc2).zH.equals("noscript")) {
                    qZ.Q4();
                    qZ.I((vv_0)((Object)object));
                    return true;
                }
                if (vv_0.yq(xc2)) return qZ.Hj(xc2, (vv_0)((Object)((Object)object)));
                if (xc2.N()) return qZ.Hj(xc2, (vv_0)((Object)((Object)object)));
                if (xc2.t0() && Nr.N(((xc.t0)xc2).zH, com.github.catvod.spider.merge.vV$OW.i)) {
                    return qZ.Hj(xc2, (vv_0)((Object)object));
                }
                if (xc2.i() && ((xc.i)xc2).zH.equals("br")) {
                    qZ.W(this);
                    object = new xc.SN();
                } else {
                    if (xc2.t0() && Nr.N(((xc.t0)xc2).zH, com.github.catvod.spider.merge.vV$OW.H) || xc2.i()) {
                        qZ.W(this);
                        return false;
                    }
                    qZ.W(this);
                    object = new xc.SN();
                }
                ((xc.SN)object).q(xc2.toString());
                qZ.H((xc.SN)object);
                return true;
            }
        };
        zH = vv_06;
        vv_0 vv_07 = new vv_0(){

            private boolean zH(xc xc2, QZ qZ) {
                qZ.Gc("body");
                qZ.v(true);
                return qZ.zH(xc2);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            final boolean tF(xc xc2, QZ qZ) {
                String string;
                v v2 = tF;
                xa xa2 = t0;
                if (vv_0.yq(xc2)) {
                    qZ.H((xc.SN)xc2);
                    return true;
                }
                if (xc2.N()) {
                    qZ.U((xc.N)xc2);
                    return true;
                }
                if (xc2.tF()) {
                    qZ.W(this);
                    return true;
                }
                if (xc2.t0()) {
                    xc.t0 t02 = (xc.t0)xc2;
                    Object object = t02.zH;
                    if (((String)object).equals("html")) {
                        return qZ.Hj(xc2, xa2);
                    }
                    if (((String)object).equals("body")) {
                        qZ.g(t02);
                        qZ.v(false);
                        qZ.I(xa2);
                        return true;
                    }
                    if (((String)object).equals("frameset")) {
                        qZ.g(t02);
                        qZ.I(ee);
                        return true;
                    }
                    if (Nr.N((String)object, com.github.catvod.spider.merge.vV$OW.t0)) {
                        qZ.W(this);
                        object = qZ.O();
                        qZ.zH.add((hN)object);
                        qZ.Hj(xc2, v2);
                        qZ.kR((hN)object);
                        return true;
                    }
                    if (((String)object).equals("head")) {
                        qZ.W(this);
                        return false;
                    }
                } else if (xc2.i() && !Nr.N(string = ((xc.i)xc2).zH, com.github.catvod.spider.merge.vV$OW.tF)) {
                    if (string.equals("template")) {
                        qZ.Hj(xc2, v2);
                        return true;
                    }
                    qZ.W(this);
                    return false;
                }
                this.zH(xc2, qZ);
                return true;
            }
        };
        i = vv_07;
        vv_0 vv_08 = new vv_0(){

            /*
             * Exception decompiling
             */
            @Override
            final boolean tF(xc var1_1, QZ var2_2) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 13[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }

            final boolean zH(xc object, QZ qZ) {
                Objects.requireNonNull(object);
                object = ((xc.i)object).zH;
                ArrayList<hN> arrayList = qZ.zH;
                if (qZ.OW((String)object) == null) {
                    qZ.W(this);
                    return false;
                }
                for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
                    hN hN2 = arrayList.get(i2);
                    if (hN2.nQ().equals(object)) {
                        qZ.g9((String)object);
                        if (!qZ.SN((String)object)) {
                            qZ.W(this);
                        }
                        qZ.p((String)object);
                        break;
                    }
                    if (!qZ.V(hN2)) continue;
                    qZ.W(this);
                    return false;
                }
                return true;
            }
        };
        t0 = vv_08;
        vv_0 vv_09 = new vv_0(){

            @Override
            final boolean tF(xc xc2, QZ qZ) {
                if (xc2.SN()) {
                    qZ.H((xc.SN)xc2);
                } else {
                    if (xc2.zH()) {
                        qZ.W(this);
                        qZ.Q4();
                        qZ.I(qZ.C());
                        return qZ.zH(xc2);
                    }
                    if (xc2.i()) {
                        qZ.Q4();
                        qZ.I(qZ.C());
                    }
                }
                return true;
            }
        };
        Gc = vv_09;
        vv_0 vv_010 = new vv_0(){

            @Override
            final boolean tF(xc object, QZ qZ) {
                block33: {
                    block36: {
                        block35: {
                            String string;
                            v v2;
                            block34: {
                                block21: {
                                    block31: {
                                        block32: {
                                            block27: {
                                                String string2;
                                                xc.t0 t02;
                                                block29: {
                                                    block30: {
                                                        block28: {
                                                            block20: {
                                                                block26: {
                                                                    block23: {
                                                                        block25: {
                                                                            block24: {
                                                                                block22: {
                                                                                    block19: {
                                                                                        v2 = tF;
                                                                                        if (!object.SN() || !Nr.N(qZ.yq().nQ(), com.github.catvod.spider.merge.vV$OW.g1)) break block19;
                                                                                        qZ.R();
                                                                                        qZ.xU();
                                                                                        qZ.I(KJ);
                                                                                        break block20;
                                                                                    }
                                                                                    if (object.N()) {
                                                                                        qZ.U((xc.N)object);
                                                                                        return true;
                                                                                    }
                                                                                    if (object.tF()) {
                                                                                        qZ.W(this);
                                                                                        return false;
                                                                                    }
                                                                                    if (!object.t0()) break block21;
                                                                                    t02 = (xc.t0)object;
                                                                                    string2 = t02.zH;
                                                                                    if (!string2.equals("caption")) break block22;
                                                                                    qZ.dT();
                                                                                    qZ.m();
                                                                                    qZ.g(t02);
                                                                                    object = q;
                                                                                    break block23;
                                                                                }
                                                                                if (!string2.equals("colgroup")) break block24;
                                                                                qZ.dT();
                                                                                qZ.g(t02);
                                                                                object = B;
                                                                                break block23;
                                                                            }
                                                                            if (!string2.equals("col")) break block25;
                                                                            qZ.dT();
                                                                            qZ.Gc("colgroup");
                                                                            break block20;
                                                                        }
                                                                        if (!Nr.N(string2, com.github.catvod.spider.merge.vV$OW.v)) break block26;
                                                                        qZ.dT();
                                                                        qZ.g(t02);
                                                                        object = G;
                                                                    }
                                                                    qZ.I((vv_0)((Object)object));
                                                                    break block27;
                                                                }
                                                                if (!Nr.N(string2, com.github.catvod.spider.merge.vV$OW.ee)) break block28;
                                                                qZ.dT();
                                                                qZ.Gc("tbody");
                                                            }
                                                            return qZ.zH((xc)object);
                                                        }
                                                        if (string2.equals("table")) {
                                                            qZ.W(this);
                                                            if (!qZ.Dr(string2)) {
                                                                return false;
                                                            }
                                                            qZ.p(string2);
                                                            if (!qZ.cp()) {
                                                                qZ.g(t02);
                                                                return true;
                                                            }
                                                            return qZ.zH((xc)object);
                                                        }
                                                        if (Nr.N(string2, com.github.catvod.spider.merge.vV$OW.g9)) {
                                                            return qZ.Hj((xc)object, v2);
                                                        }
                                                        if (!string2.equals("input")) break block29;
                                                        if (!t02.g9() || !t02.G4.B("type").equalsIgnoreCase("hidden")) break block30;
                                                        qZ.Fz(t02);
                                                        break block27;
                                                    }
                                                    this.zH((xc)object, qZ);
                                                    return true;
                                                }
                                                if (!string2.equals("form")) break block31;
                                                qZ.W(this);
                                                if (qZ.Nl() != null || qZ.i3("template")) break block32;
                                                qZ.E1(t02, false, false);
                                            }
                                            return true;
                                        }
                                        return false;
                                    }
                                    this.zH((xc)object, qZ);
                                    return true;
                                }
                                if (!object.i()) break block33;
                                string = ((xc.i)object).zH;
                                if (!string.equals("table")) break block34;
                                if (!qZ.Dr(string)) {
                                    qZ.W(this);
                                    return false;
                                }
                                qZ.p("table");
                                qZ.cp();
                                break block35;
                            }
                            if (Nr.N(string, com.github.catvod.spider.merge.vV$OW.O)) {
                                qZ.W(this);
                                return false;
                            }
                            if (!string.equals("template")) break block36;
                            qZ.Hj((xc)object, v2);
                        }
                        return true;
                    }
                    this.zH((xc)object, qZ);
                    return true;
                }
                if (object.zH()) {
                    if (qZ.SN("html")) {
                        qZ.W(this);
                    }
                    return true;
                }
                this.zH((xc)object, qZ);
                return true;
            }

            final void zH(xc xc2, QZ qZ) {
                qZ.W(this);
                qZ.cS(true);
                qZ.Hj(xc2, t0);
                qZ.cS(false);
            }
        };
        M = vv_010;
        vv_0 vv_011 = new vv_0(){

            @Override
            final boolean tF(xc object, QZ object2) {
                Object object3 = t0;
                if (((xc)object).yq == 5) {
                    object3 = (xc.SN)object;
                    if (((xc.SN)object3).B().equals(OW)) {
                        ((QZ)object2).W(this);
                        return false;
                    }
                    object = ((QZ)object2).g1();
                    object2 = ((xc.SN)object3).B();
                    ((ArrayList)object).add(object2);
                    return true;
                }
                if (((ArrayList)((QZ)object2).g1()).size() > 0) {
                    for (String string : (ArrayList)((QZ)object2).g1()) {
                        xc.SN sN;
                        if (!Nr.tF(string)) {
                            ((QZ)object2).W(this);
                            if (Nr.N(((jt)object2).yq().nQ(), com.github.catvod.spider.merge.vV$OW.g1)) {
                                ((QZ)object2).cS(true);
                                sN = new xc.SN();
                                sN.q(string);
                                ((QZ)object2).Hj(sN, (vv_0)((Object)object3));
                                ((QZ)object2).cS(false);
                                continue;
                            }
                            sN = new xc.SN();
                            sN.q(string);
                            ((QZ)object2).Hj(sN, (vv_0)((Object)object3));
                            continue;
                        }
                        sN = new xc.SN();
                        sN.q(string);
                        ((QZ)object2).H(sN);
                    }
                    ((QZ)object2).R();
                }
                ((QZ)object2).I(((QZ)object2).C());
                return ((QZ)object2).zH((xc)object);
            }
        };
        KJ = vv_011;
        vv_0 vv_012 = new vv_0(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            final boolean tF(xc xc2, QZ qZ) {
                if (xc2.i()) {
                    xc.i i2 = (xc.i)xc2;
                    if (i2.zH.equals("caption")) {
                        if (!qZ.Dr(i2.zH)) {
                            qZ.W(this);
                            return false;
                        }
                        qZ.xa(false);
                        if (!qZ.SN("caption")) {
                            qZ.W(this);
                        }
                        qZ.p("caption");
                        qZ.B();
                        qZ.I(M);
                        return true;
                    }
                }
                if (xc2.t0() && Nr.N(((xc.t0)xc2).zH, com.github.catvod.spider.merge.vV$OW.OW) || xc2.i() && ((xc.i)xc2).zH.equals("table")) {
                    qZ.W(this);
                    if (!qZ.i("caption")) return true;
                    return qZ.zH(xc2);
                }
                if (!xc2.i() || !Nr.N(((xc.i)xc2).zH, com.github.catvod.spider.merge.vV$OW.U)) return qZ.Hj(xc2, t0);
                qZ.W(this);
                return false;
            }
        };
        q = vv_012;
        vv_0 vv_013 = new vv_0(){

            private boolean zH(xc xc2, QZ qZ) {
                if (!qZ.SN("colgroup")) {
                    qZ.W(this);
                    return false;
                }
                qZ.Q4();
                qZ.I(M);
                qZ.zH(xc2);
                return true;
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            final boolean tF(xc xc2, QZ qZ) {
                xc.t0 t02;
                int n2;
                block23: {
                    v v2;
                    block18: {
                        block22: {
                            block21: {
                                String string;
                                block19: {
                                    block20: {
                                        int n3;
                                        block17: {
                                            v2 = tF;
                                            if (vv_0.yq(xc2)) {
                                                qZ.H((xc.SN)xc2);
                                                return true;
                                            }
                                            n3 = cp.SN(xc2.yq);
                                            if (n3 == 0) {
                                                qZ.W(this);
                                                return true;
                                            }
                                            n2 = 0;
                                            if (n3 == 1) break block17;
                                            if (n3 != 2) {
                                                if (n3 == 3) {
                                                    qZ.U((xc.N)xc2);
                                                    return true;
                                                }
                                                if (n3 != 5) {
                                                    return this.zH(xc2, qZ);
                                                }
                                                if (!qZ.SN("html")) return this.zH(xc2, qZ);
                                                return true;
                                            }
                                            String string2 = ((xc.i)xc2).zH;
                                            Objects.requireNonNull(string2);
                                            if (!string2.equals("template")) {
                                                if (!string2.equals("colgroup")) {
                                                    return this.zH(xc2, qZ);
                                                }
                                                if (!qZ.SN(string2)) {
                                                    qZ.W(this);
                                                    return false;
                                                }
                                                qZ.Q4();
                                                qZ.I(M);
                                                return true;
                                            }
                                            break block18;
                                        }
                                        t02 = (xc.t0)xc2;
                                        string = t02.zH;
                                        Objects.requireNonNull(string);
                                        n3 = string.hashCode();
                                        if (n3 == -1321546630) break block19;
                                        if (n3 == 98688) break block20;
                                        if (n3 != 3213227 || !string.equals("html")) break block21;
                                        n2 = 2;
                                        break block22;
                                    }
                                    if (!string.equals("col")) break block21;
                                    n2 = 1;
                                    break block22;
                                }
                                if (string.equals("template")) break block22;
                            }
                            n2 = -1;
                        }
                        if (n2 != 0) break block23;
                    }
                    qZ.Hj(xc2, v2);
                    return true;
                }
                if (n2 != 1) {
                    if (n2 == 2) return qZ.Hj(xc2, t0);
                    return this.zH(xc2, qZ);
                }
                qZ.Fz(t02);
                return true;
            }
        };
        B = vv_013;
        vv_0 vv_014 = new vv_0(){

            private boolean zH(xc xc2, QZ qZ) {
                if (!(qZ.Dr("tbody") || qZ.Dr("thead") || qZ.n("tfoot", null))) {
                    qZ.W(this);
                    return false;
                }
                qZ.G4();
                qZ.i(qZ.yq().nQ());
                return qZ.zH(xc2);
            }

            @Override
            final boolean tF(xc xc2, QZ qZ) {
                String string;
                xc.t0 t02;
                Nl nl;
                block12: {
                    block11: {
                        block9: {
                            String string2;
                            block10: {
                                nl = M;
                                int n2 = cp.SN(xc2.yq);
                                if (n2 == 1) break block9;
                                if (n2 != 2) {
                                    return qZ.Hj(xc2, nl);
                                }
                                string2 = ((xc.i)xc2).zH;
                                if (!Nr.N(string2, com.github.catvod.spider.merge.vV$OW.g)) break block10;
                                if (!qZ.Dr(string2)) {
                                    qZ.W(this);
                                    return false;
                                }
                                qZ.G4();
                                qZ.Q4();
                                qZ.I(nl);
                                break block11;
                            }
                            if (string2.equals("table")) {
                                return this.zH(xc2, qZ);
                            }
                            if (Nr.N(string2, com.github.catvod.spider.merge.vV$OW.n)) {
                                qZ.W(this);
                                return false;
                            }
                            return qZ.Hj(xc2, nl);
                        }
                        t02 = (xc.t0)xc2;
                        string = t02.zH;
                        if (!string.equals("tr")) break block12;
                        qZ.G4();
                        qZ.g(t02);
                        qZ.I(G4);
                    }
                    return true;
                }
                if (Nr.N(string, com.github.catvod.spider.merge.vV$OW.xa)) {
                    qZ.W(this);
                    qZ.Gc("tr");
                    return qZ.zH(t02);
                }
                if (Nr.N(string, com.github.catvod.spider.merge.vV$OW.s)) {
                    return this.zH(xc2, qZ);
                }
                return qZ.Hj(xc2, nl);
            }
        };
        G = vv_014;
        vv_0 vv_015 = new vv_0(){

            @Override
            final boolean tF(xc xc2, QZ qZ) {
                Nl nl;
                block13: {
                    String string;
                    block16: {
                        block17: {
                            block12: {
                                Object object;
                                block15: {
                                    boolean bl;
                                    boolean bl2;
                                    block14: {
                                        block10: {
                                            block11: {
                                                object = G;
                                                nl = M;
                                                boolean bl3 = xc2.t0();
                                                bl2 = false;
                                                bl = false;
                                                if (!bl3) break block10;
                                                xc.t0 t02 = (xc.t0)xc2;
                                                object = t02.zH;
                                                if (!Nr.N((String)object, com.github.catvod.spider.merge.vV$OW.xa)) break block11;
                                                qZ.F5();
                                                qZ.g(t02);
                                                qZ.I(dT);
                                                qZ.m();
                                                break block12;
                                            }
                                            if (Nr.N((String)object, com.github.catvod.spider.merge.vV$OW.un)) {
                                                if (qZ.i("tr")) {
                                                    bl = qZ.zH(xc2);
                                                }
                                                return bl;
                                            }
                                            return qZ.Hj(xc2, nl);
                                        }
                                        if (!xc2.i()) break block13;
                                        string = ((xc.i)xc2).zH;
                                        if (!string.equals("tr")) break block14;
                                        if (!qZ.Dr(string)) {
                                            qZ.W(this);
                                            return false;
                                        }
                                        break block15;
                                    }
                                    if (string.equals("table")) {
                                        bl = bl2;
                                        if (qZ.i("tr")) {
                                            bl = qZ.zH(xc2);
                                        }
                                        return bl;
                                    }
                                    if (!Nr.N(string, com.github.catvod.spider.merge.vV$OW.v)) break block16;
                                    if (!qZ.Dr(string) || !qZ.Dr("tr")) break block17;
                                }
                                qZ.F5();
                                qZ.Q4();
                                qZ.I((vv_0)((Object)object));
                            }
                            return true;
                        }
                        qZ.W(this);
                        return false;
                    }
                    if (Nr.N(string, com.github.catvod.spider.merge.vV$OW.b)) {
                        qZ.W(this);
                        return false;
                    }
                    return qZ.Hj(xc2, nl);
                }
                return qZ.Hj(xc2, nl);
            }
        };
        G4 = vv_015;
        vv_0 vv_016 = new vv_0(){

            @Override
            final boolean tF(xc xc2, QZ qZ) {
                zH zH2 = G4;
                xa xa2 = t0;
                boolean bl = xc2.i();
                String string = "th";
                if (bl) {
                    String string2 = ((xc.i)xc2).zH;
                    if (Nr.N(string2, com.github.catvod.spider.merge.vV$OW.xa)) {
                        if (!qZ.Dr(string2)) {
                            qZ.W(this);
                            qZ.I(zH2);
                            return false;
                        }
                        qZ.xa(false);
                        if (!qZ.SN(string2)) {
                            qZ.W(this);
                        }
                        qZ.p(string2);
                        qZ.B();
                        qZ.I(zH2);
                        return true;
                    }
                    if (Nr.N(string2, com.github.catvod.spider.merge.vV$OW.Gd)) {
                        qZ.W(this);
                        return false;
                    }
                    if (Nr.N(string2, com.github.catvod.spider.merge.vV$OW.Nl)) {
                        if (!qZ.Dr(string2)) {
                            qZ.W(this);
                            return false;
                        }
                        if (qZ.Dr("td")) {
                            string = "td";
                        }
                        qZ.i(string);
                        return qZ.zH(xc2);
                    }
                    return qZ.Hj(xc2, xa2);
                }
                if (xc2.t0() && Nr.N(((xc.t0)xc2).zH, com.github.catvod.spider.merge.vV$OW.OW)) {
                    if (!qZ.Dr("td") && !qZ.Dr("th")) {
                        qZ.W(this);
                        return false;
                    }
                    if (qZ.Dr("td")) {
                        string = "td";
                    }
                    qZ.i(string);
                    return qZ.zH(xc2);
                }
                return qZ.Hj(xc2, xa2);
            }
        };
        dT = vv_016;
        vv_0 vv_017 = new vv_0(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            final boolean tF(xc xc2, QZ qZ) {
                String string;
                xc.t0 t02;
                v v2;
                block41: {
                    block40: {
                        block39: {
                            block35: {
                                block34: {
                                    block38: {
                                        block36: {
                                            String string2;
                                            block37: {
                                                v2 = tF;
                                                int n2 = cp.SN(xc2.yq);
                                                if (n2 == 0) {
                                                    qZ.W(this);
                                                    return false;
                                                }
                                                if (n2 == 1) break block35;
                                                if (n2 != 2) {
                                                    if (n2 == 3) {
                                                        qZ.U((xc.N)xc2);
                                                        return true;
                                                    }
                                                    if (n2 != 4) {
                                                        if (n2 != 5) {
                                                            qZ.W(this);
                                                            return false;
                                                        }
                                                        if (qZ.SN("html")) return true;
                                                        break block34;
                                                    } else {
                                                        if (((xc.SN)(xc2 = (xc.SN)xc2)).B().equals(OW)) {
                                                            qZ.W(this);
                                                            return false;
                                                        }
                                                        qZ.H((xc.SN)xc2);
                                                        return true;
                                                    }
                                                }
                                                string2 = ((xc.i)xc2).zH;
                                                Objects.requireNonNull(string2);
                                                int n3 = string2.hashCode();
                                                n2 = -1;
                                                switch (n3) {
                                                    default: {
                                                        break;
                                                    }
                                                    case -80773204: {
                                                        if (!string2.equals("optgroup")) break;
                                                        n2 = 3;
                                                        break;
                                                    }
                                                    case -906021636: {
                                                        if (!string2.equals("select")) break;
                                                        n2 = 2;
                                                        break;
                                                    }
                                                    case -1010136971: {
                                                        if (!string2.equals("option")) break;
                                                        n2 = 1;
                                                        break;
                                                    }
                                                    case -1321546630: {
                                                        if (!string2.equals("template")) break;
                                                        n2 = 0;
                                                    }
                                                }
                                                if (n2 == 0) return qZ.Hj(xc2, v2);
                                                if (n2 == 1) break block36;
                                                if (n2 == 2) break block37;
                                                if (n2 != 3) {
                                                    qZ.W(this);
                                                    return false;
                                                }
                                                if (qZ.SN("option") && qZ.KJ(qZ.yq()) != null && qZ.KJ(qZ.yq()).nQ().equals("optgroup")) {
                                                    qZ.i("option");
                                                }
                                                if (!qZ.SN("optgroup")) break block34;
                                                break block38;
                                            }
                                            if (!qZ.b(string2)) {
                                                qZ.W(this);
                                                return false;
                                            }
                                            qZ.p(string2);
                                            qZ.cp();
                                            return true;
                                        }
                                        if (!qZ.SN("option")) break block34;
                                    }
                                    qZ.Q4();
                                    return true;
                                }
                                qZ.W(this);
                                return true;
                            }
                            t02 = (xc.t0)xc2;
                            string = t02.zH;
                            if (string.equals("html")) {
                                return qZ.Hj(t02, t0);
                            }
                            if (!string.equals("option")) break block39;
                            if (qZ.SN("option")) {
                                qZ.i("option");
                            }
                            break block40;
                        }
                        if (!string.equals("optgroup")) break block41;
                        if (qZ.SN("option")) {
                            qZ.i("option");
                        }
                        if (qZ.SN("optgroup")) {
                            qZ.i("optgroup");
                        }
                    }
                    qZ.g(t02);
                    return true;
                }
                if (string.equals("select")) {
                    qZ.W(this);
                    return qZ.i("select");
                }
                if (Nr.N(string, com.github.catvod.spider.merge.vV$OW.Zm)) {
                    qZ.W(this);
                    if (!qZ.b("select")) {
                        return false;
                    }
                    qZ.i("select");
                    return qZ.zH(t02);
                }
                if (string.equals("script")) return qZ.Hj(xc2, v2);
                if (string.equals("template")) {
                    return qZ.Hj(xc2, v2);
                }
                qZ.W(this);
                return false;
            }
        };
        F5 = vv_017;
        vv_0 vv_018 = new vv_0(){

            @Override
            final boolean tF(xc xc2, QZ qZ) {
                if (xc2.t0() && Nr.N(((xc.t0)xc2).zH, com.github.catvod.spider.merge.vV$OW.Dr)) {
                    qZ.W(this);
                    qZ.p("select");
                    qZ.cp();
                    return qZ.zH(xc2);
                }
                if (xc2.i()) {
                    xc.i i2 = (xc.i)xc2;
                    if (Nr.N(i2.zH, com.github.catvod.spider.merge.vV$OW.Dr)) {
                        qZ.W(this);
                        if (qZ.Dr(i2.zH)) {
                            qZ.p("select");
                            qZ.cp();
                            return qZ.zH(xc2);
                        }
                        return false;
                    }
                }
                return qZ.Hj(xc2, F5);
            }
        };
        v3 = vv_018;
        vv_0 vv_019 = new vv_0(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            final boolean tF(xc xc2, QZ qZ) {
                xa xa2;
                block12: {
                    String string;
                    block16: {
                        v v2;
                        block15: {
                            block13: {
                                block14: {
                                    v2 = tF;
                                    xa2 = t0;
                                    int n2 = cp.SN(xc2.yq);
                                    if (n2 == 0) break block12;
                                    if (n2 == 1) break block13;
                                    if (n2 == 2) break block14;
                                    if (n2 != 3 && n2 != 4) {
                                        if (n2 != 5) {
                                            return true;
                                        }
                                        if (!qZ.i3("template")) {
                                            return true;
                                        }
                                        qZ.W(this);
                                        qZ.p("template");
                                        qZ.B();
                                        qZ.w();
                                        qZ.cp();
                                        if (qZ.x() == W) return true;
                                        if (qZ.ue() >= 12) return true;
                                        return qZ.zH(xc2);
                                    }
                                    break block12;
                                }
                                if (!((xc.i)xc2).zH.equals("template")) {
                                    qZ.W(this);
                                    return false;
                                }
                                break block15;
                            }
                            string = ((xc.t0)xc2).zH;
                            if (!Nr.N(string, com.github.catvod.spider.merge.vV$OW.Fz)) break block16;
                        }
                        qZ.Hj(xc2, v2);
                        return true;
                    }
                    if (Nr.N(string, com.github.catvod.spider.merge.vV$OW.E1)) {
                        qZ.w();
                        Nl nl = M;
                        qZ.j(nl);
                        qZ.I(nl);
                        return qZ.zH(xc2);
                    }
                    if (string.equals("col")) {
                        qZ.w();
                        N n3 = B;
                        qZ.j(n3);
                        qZ.I(n3);
                        return qZ.zH(xc2);
                    }
                    if (string.equals("tr")) {
                        qZ.w();
                        tF tF2 = G;
                        qZ.j(tF2);
                        qZ.I(tF2);
                        return qZ.zH(xc2);
                    }
                    if (!string.equals("td") && !string.equals("th")) {
                        qZ.w();
                        qZ.j(xa2);
                        qZ.I(xa2);
                        return qZ.zH(xc2);
                    }
                    qZ.w();
                    zH zH2 = G4;
                    qZ.j(zH2);
                    qZ.I(zH2);
                    return qZ.zH(xc2);
                }
                qZ.Hj(xc2, xa2);
                return true;
            }
        };
        W = vv_019;
        vv_0 vv_020 = new vv_0(){

            @Override
            final boolean tF(xc xc2, QZ qZ) {
                block10: {
                    block7: {
                        block9: {
                            block8: {
                                block6: {
                                    if (!vv_0.yq(xc2)) break block6;
                                    qZ.H((xc.SN)xc2);
                                    break block7;
                                }
                                if (!xc2.N()) break block8;
                                qZ.U((xc.N)xc2);
                                break block7;
                            }
                            if (xc2.tF()) {
                                qZ.W(this);
                                return false;
                            }
                            if (xc2.t0() && ((xc.t0)xc2).zH.equals("html")) {
                                return qZ.Hj(xc2, t0);
                            }
                            if (!xc2.i() || !((xc.i)xc2).zH.equals("html")) break block9;
                            Objects.requireNonNull(qZ);
                            if (qZ.i3("html")) {
                                qZ.p("html");
                            }
                            qZ.I(xa);
                            break block7;
                        }
                        if (!xc2.zH()) break block10;
                    }
                    return true;
                }
                qZ.W(this);
                qZ.Cu();
                return qZ.zH(xc2);
            }
        };
        v = vv_020;
        vv_0 vv_021 = new vv_0(){

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            final boolean tF(xc object, QZ qZ) {
                void var2_6;
                if (vv_0.yq((xc)object)) {
                    var2_6.H((xc.SN)object);
                    return true;
                }
                if (((xc)object).N()) {
                    var2_6.U((xc.N)object);
                    return true;
                }
                if (((xc)object).tF()) {
                    var2_6.W(this);
                    return false;
                }
                if (((xc)object).t0()) {
                    xc.t0 t02 = (xc.t0)object;
                    String string = t02.zH;
                    Objects.requireNonNull(string);
                    int n2 = -1;
                    switch (string.hashCode()) {
                        default: {
                            break;
                        }
                        case 1192721831: {
                            if (!string.equals("noframes")) break;
                            n2 = 3;
                            break;
                        }
                        case 97692013: {
                            if (!string.equals("frame")) break;
                            n2 = 2;
                            break;
                        }
                        case 3213227: {
                            if (!string.equals("html")) break;
                            n2 = 1;
                            break;
                        }
                        case -1644953643: {
                            if (!string.equals("frameset")) break;
                            n2 = 0;
                        }
                    }
                    switch (n2) {
                        default: {
                            var2_6.W(this);
                            return false;
                        }
                        case 3: {
                            void var1_5;
                            v v2 = tF;
                            return var2_6.Hj(t02, (vv_0)var1_5);
                        }
                        case 2: {
                            var2_6.Fz(t02);
                            return true;
                        }
                        case 1: {
                            void var1_5;
                            xa xa2 = t0;
                            return var2_6.Hj(t02, (vv_0)var1_5);
                        }
                        case 0: 
                    }
                    var2_6.g(t02);
                    return true;
                }
                if (((xc)object).i() && ((xc.i)object).zH.equals("frameset")) {
                    if (var2_6.SN("html")) {
                        var2_6.W(this);
                        return false;
                    }
                    var2_6.Q4();
                    if (var2_6.SN("frameset")) return true;
                    var2_6.I(g9);
                    return true;
                }
                if (((xc)object).zH()) {
                    if (var2_6.SN("html")) return true;
                    var2_6.W(this);
                    return true;
                }
                var2_6.W(this);
                return false;
            }
        };
        ee = vv_021;
        vv_0 vv_022 = new vv_0(){

            @Override
            final boolean tF(xc xc2, QZ qZ) {
                block14: {
                    block8: {
                        block13: {
                            vv_0 vv_02;
                            block11: {
                                block12: {
                                    block10: {
                                        block9: {
                                            block7: {
                                                if (!vv_0.yq(xc2)) break block7;
                                                qZ.H((xc.SN)xc2);
                                                break block8;
                                            }
                                            if (!xc2.N()) break block9;
                                            qZ.U((xc.N)xc2);
                                            break block8;
                                        }
                                        if (xc2.tF()) {
                                            qZ.W(this);
                                            return false;
                                        }
                                        if (!xc2.t0() || !((xc.t0)xc2).zH.equals("html")) break block10;
                                        vv_02 = t0;
                                        break block11;
                                    }
                                    if (!xc2.i() || !((xc.i)xc2).zH.equals("html")) break block12;
                                    qZ.I(Gd);
                                    break block8;
                                }
                                if (!xc2.t0() || !((xc.t0)xc2).zH.equals("noframes")) break block13;
                                vv_02 = tF;
                            }
                            return qZ.Hj(xc2, vv_02);
                        }
                        if (!xc2.zH()) break block14;
                    }
                    return true;
                }
                qZ.W(this);
                return false;
            }
        };
        g9 = vv_022;
        vv_0 vv_023 = new vv_0(){

            @Override
            final boolean tF(xc xc2, QZ qZ) {
                block4: {
                    block6: {
                        block3: {
                            block5: {
                                block2: {
                                    if (!xc2.N()) break block2;
                                    qZ.U((xc.N)xc2);
                                    break block3;
                                }
                                if (xc2.tF() || xc2.t0() && ((xc.t0)xc2).zH.equals("html")) break block4;
                                if (!vv_0.yq(xc2)) break block5;
                                qZ.H((xc.SN)xc2);
                                break block3;
                            }
                            if (!xc2.zH()) break block6;
                        }
                        return true;
                    }
                    qZ.W(this);
                    qZ.Cu();
                    return qZ.zH(xc2);
                }
                return qZ.Hj(xc2, t0);
            }
        };
        xa = vv_023;
        vv_0 vv_024 = new vv_0(){

            @Override
            final boolean tF(xc xc2, QZ qZ) {
                block6: {
                    block7: {
                        block5: {
                            block4: {
                                if (!xc2.N()) break block4;
                                qZ.U((xc.N)xc2);
                                break block5;
                            }
                            if (xc2.tF() || vv_0.yq(xc2) || xc2.t0() && ((xc.t0)xc2).zH.equals("html")) break block6;
                            if (!xc2.zH()) break block7;
                        }
                        return true;
                    }
                    if (xc2.t0() && ((xc.t0)xc2).zH.equals("noframes")) {
                        return qZ.Hj(xc2, tF);
                    }
                    qZ.W(this);
                    return false;
                }
                return qZ.Hj(xc2, t0);
            }
        };
        Gd = vv_024;
        vv_0 vv_025 = new vv_0(){

            @Override
            final boolean tF(xc xc2, QZ qZ) {
                return true;
            }
        };
        Nl = vv_025;
        O = new vv_0[]{vv_02, vv_03, vv_04, vv_05, vv_06, vv_07, vv_08, vv_09, vv_010, vv_011, vv_012, vv_013, vv_014, vv_015, vv_016, vv_017, vv_018, vv_019, vv_020, vv_021, vv_022, vv_023, vv_024, vv_025};
        OW = String.valueOf('\u0000');
    }

    vv_0(q q4) {
    }

    static void SN(xc.t0 t02, QZ qZ) {
        qZ.N.xa(O9.zH);
        qZ.xU();
        qZ.I(Gc);
        qZ.g(t02);
    }

    public static vv_0 valueOf(String string) {
        return Enum.valueOf(vv_0.class, string);
    }

    public static vv_0[] values() {
        return (vv_0[])O.clone();
    }

    static boolean yq(xc xc2) {
        boolean bl = xc2.SN() ? Nr.tF(((xc.SN)xc2).B()) : false;
        return bl;
    }

    abstract boolean tF(xc var1, QZ var2);

    static final class OW {
        static final String[] B;
        static final String[] Dr;
        static final String[] E1;
        static final String[] F5;
        static final String[] Fz;
        static final String[] G;
        static final String[] G4;
        static final String[] Gc;
        static final String[] Gd;
        static final String[] H;
        static final String[] KJ;
        static final String[] M;
        static final String[] N;
        static final String[] Nl;
        static final String[] O;
        static final String[] OW;
        static final String[] SN;
        static final String[] U;
        static final String[] W;
        static final String[] Zm;
        static final String[] b;
        static final String[] dT;
        static final String[] ee;
        static final String[] g;
        static final String[] g1;
        static final String[] g9;
        static final String[] i;
        static final String[] n;
        static final String[] q;
        static final String[] s;
        static final String[] t0;
        static final String[] tF;
        static final String[] un;
        static final String[] v;
        static final String[] v3;
        static final String[] xa;
        static final String[] yq;
        static final String[] zH;

        static {
            yq = new String[]{"base", "basefont", "bgsound", "command", "link"};
            SN = new String[]{"noframes", "style"};
            N = new String[]{"body", "br", "html"};
            tF = new String[]{"body", "br", "html"};
            zH = new String[]{"body", "br", "head", "html"};
            i = new String[]{"basefont", "bgsound", "link", "meta", "noframes", "style"};
            t0 = new String[]{"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "template", "title"};
            Gc = new String[]{"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};
            M = new String[]{"h1", "h2", "h3", "h4", "h5", "h6"};
            KJ = new String[]{"address", "div", "p"};
            q = new String[]{"dd", "dt"};
            B = new String[]{"applet", "marquee", "object"};
            G = new String[]{"param", "source", "track"};
            G4 = new String[]{"action", "name", "prompt"};
            dT = new String[]{"caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
            F5 = new String[]{"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
            v3 = new String[]{"a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
            W = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
            v = new String[]{"tbody", "tfoot", "thead"};
            ee = new String[]{"td", "th", "tr"};
            g9 = new String[]{"script", "style", "template"};
            xa = new String[]{"td", "th"};
            Gd = new String[]{"body", "caption", "col", "colgroup", "html"};
            Nl = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
            OW = new String[]{"caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"};
            O = new String[]{"body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
            g1 = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
            s = new String[]{"caption", "col", "colgroup", "tbody", "tfoot", "thead"};
            n = new String[]{"body", "caption", "col", "colgroup", "html", "td", "th", "tr"};
            un = new String[]{"caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"};
            b = new String[]{"body", "caption", "col", "colgroup", "html", "td", "th"};
            Zm = new String[]{"input", "keygen", "textarea"};
            Dr = new String[]{"caption", "table", "tbody", "td", "tfoot", "th", "thead", "tr"};
            g = new String[]{"tbody", "tfoot", "thead"};
            H = new String[]{"head", "noscript"};
            U = new String[]{"body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
            Fz = new String[]{"base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "template", "title"};
            E1 = new String[]{"caption", "colgroup", "tbody", "tfoot", "thead"};
        }
    }
}

