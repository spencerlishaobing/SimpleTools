/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.nS;
import com.github.catvod.spider.merge.o9;
import com.github.catvod.spider.merge.x1;
import com.github.catvod.spider.merge.xc;

abstract class O9
extends Enum<O9> {
    public static final /* enum */ N B;
    public static final /* enum */ N0 C;
    public static final /* enum */ LY Cu;
    public static final /* enum */ O Dr;
    public static final /* enum */ o9.b_0 E1;
    public static final /* enum */ t0 F5;
    public static final /* enum */ un Fz;
    public static final /* enum */ tF G;
    public static final /* enum */ zH G4;
    public static final /* enum */ u7 Gc;
    public static final /* enum */ dT Gd;
    public static final /* enum */ s H;
    public static final /* enum */ C Hj;
    private static final O9[] I;
    public static final /* enum */ RQ J;
    public static final /* enum */ yq KJ;
    public static final /* enum */ o9.o_0 L;
    public static final /* enum */ Hj LY;
    public static final /* enum */ cS M;
    public static final /* enum */ Dr N;
    public static final /* enum */ o9.m_0 N0;
    public static final /* enum */ F5 Nl;
    public static final /* enum */ W O;
    static final char[] OB;
    public static final /* enum */ v3 OW;
    public static final /* enum */ R Q4;
    public static final /* enum */ k R;
    public static final /* enum */ U RQ;
    public static final /* enum */ xa SN;
    public static final /* enum */ o9.n_0 U;
    public static final /* enum */ E1 V;
    public static final /* enum */ M W;
    public static final /* enum */ Q4 XO;
    public static final /* enum */ Fz Z;
    public static final /* enum */ OW Zm;
    public static final /* enum */ Nl b;
    public static final /* enum */ L cS;
    public static final /* enum */ nQ cp;
    public static final /* enum */ i dT;
    public static final /* enum */ B ee;
    public static final /* enum */ g1 g;
    public static final /* enum */ o9.v_0 g1;
    public static final /* enum */ G g9;
    public static final /* enum */ Cu i;
    public static final /* enum */ Z i3;
    public static final /* enum */ p j;
    public static final /* enum */ H k;
    public static final /* enum */ o9.j_0 kR;
    public static final /* enum */ xU lF;
    public static final /* enum */ o9.g_0 m;
    public static final /* enum */ lF mG;
    public static final /* enum */ g9 n;
    public static final /* enum */ XO nQ;
    public static final /* enum */ o9.w_0 o;
    public static final /* enum */ J p;
    public static final /* enum */ SN q;
    public static final /* enum */ ee s;
    public static final /* enum */ cp t0;
    public static final /* enum */ V tF;
    public static final /* enum */ Zm tO;
    public static final /* enum */ kR u7;
    private static final String ue;
    public static final /* enum */ Gd un;
    public static final /* enum */ KJ v;
    public static final /* enum */ Gc v3;
    public static final /* enum */ i3 w;
    static final char[] x;
    public static final /* enum */ tO xU;
    public static final /* enum */ G4 xa;
    public static final /* enum */ q yq;
    public static final /* enum */ mG zH;

    static {
        O9 o92 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block5: {
                    block2: {
                        block6: {
                            block3: {
                                block4: {
                                    char c = ((nS)object).g9();
                                    if (c == '\u0000') break block2;
                                    if (c == '&') break block3;
                                    if (c == '<') break block4;
                                    if (c != '\uffff') {
                                        x12.B(((nS)object).Gc());
                                    } else {
                                        x12.q(new xc.zH());
                                    }
                                    break block5;
                                }
                                object = Gc;
                                break block6;
                            }
                            object = SN;
                        }
                        x12.yq((O9)((Object)object));
                        break block5;
                    }
                    x12.W(this);
                    x12.KJ(((nS)object).i());
                }
            }
        };
        yq = o92;
        O9 o93 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                O9.yq(x12, yq);
            }
        };
        SN = o93;
        O9 o94 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block5: {
                    block2: {
                        block6: {
                            block3: {
                                block4: {
                                    char c = ((nS)object).g9();
                                    if (c == '\u0000') break block2;
                                    if (c == '&') break block3;
                                    if (c == '<') break block4;
                                    if (c != '\uffff') {
                                        x12.B(((nS)object).Gc());
                                    } else {
                                        x12.q(new xc.zH());
                                    }
                                    break block5;
                                }
                                object = q;
                                break block6;
                            }
                            object = tF;
                        }
                        x12.yq((O9)((Object)object));
                        break block5;
                    }
                    x12.W(this);
                    ((nS)object).yq();
                    x12.KJ('\ufffd');
                }
            }
        };
        N = o94;
        O9 o95 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                O9.yq(x12, N);
            }
        };
        tF = o95;
        O9 o96 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                O9.SN(x12, nS2, this, G4);
            }
        };
        zH = o96;
        O9 o97 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                O9.SN(x12, nS2, this, v3);
            }
        };
        i = o97;
        O9 o98 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                char c = nS2.g9();
                if (c != '\u0000') {
                    if (c != '\uffff') {
                        x12.B(nS2.F5('\u0000'));
                    } else {
                        x12.q(new xc.zH());
                    }
                } else {
                    x12.W(this);
                    nS2.yq();
                    x12.KJ('\ufffd');
                }
            }
        };
        t0 = o98;
        O9 o99 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block6: {
                    block7: {
                        block4: {
                            block5: {
                                char c = object.g9();
                                if (c == '!') break block4;
                                if (c == '/') break block5;
                                if (c != '?') {
                                    if (object.g()) {
                                        x12.Gc(true);
                                        object = KJ;
                                    } else {
                                        x12.W(this);
                                        x12.KJ('<');
                                        object = yq;
                                    }
                                } else {
                                    x12.i();
                                    object = Z;
                                }
                                x12.xa((O9)((Object)object));
                                break block6;
                            }
                            object = M;
                            break block7;
                        }
                        object = V;
                    }
                    x12.yq((O9)((Object)object));
                }
            }
        };
        Gc = o99;
        O9 o910 = new O9(){

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             */
            @Override
            final void t0(x1 x12, nS object) {
                void var2_5;
                q q4 = yq;
                if (((nS)object).Gd()) {
                    x12.v3(this);
                    x12.B("</");
                    x12.xa(q4);
                    return;
                }
                if (((nS)object).g()) {
                    x12.Gc(false);
                    yq yq2 = KJ;
                } else {
                    boolean bl = ((nS)object).b('>');
                    x12.W(this);
                    if (bl) {
                        x12.yq(q4);
                        return;
                    }
                    x12.i();
                    x12.G4.q('/');
                    Fz fz = Z;
                }
                x12.xa((O9)var2_5);
            }
        };
        M = o910;
        O9 o911 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block6: {
                    block0: {
                        block8: {
                            block1: {
                                block2: {
                                    q q4;
                                    block7: {
                                        block4: {
                                            block3: {
                                                block5: {
                                                    q4 = yq;
                                                    String string = ((nS)object).G4();
                                                    x12.q.v3(string);
                                                    char c = ((nS)object).i();
                                                    if (c == '\u0000') break block0;
                                                    if (c == ' ') break block1;
                                                    if (c == '/') break block2;
                                                    if (c == '<') break block3;
                                                    if (c == '>') break block4;
                                                    if (c == '\uffff') break block5;
                                                    if (c == '\t' || c == '\n' || c == '\f' || c == '\r') break block1;
                                                    x12.q.F5(c);
                                                    break block6;
                                                }
                                                x12.v3(this);
                                                break block7;
                                            }
                                            ((nS)object).RQ();
                                            x12.W(this);
                                        }
                                        x12.F5();
                                    }
                                    x12.xa(q4);
                                    break block6;
                                }
                                object = RQ;
                                break block8;
                            }
                            object = g;
                        }
                        x12.xa((O9)((Object)object));
                        break block6;
                    }
                    x12.q.v3(ue);
                }
            }
        };
        KJ = o911;
        O9 o912 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                if (object.b('/')) {
                    x12.M();
                    x12.yq(B);
                } else {
                    if (object.g() && x12.SN() != null && !object.ee(x12.N())) {
                        object = x12.Gc(false);
                        ((xc.Gc)object).xa(x12.SN());
                        x12.q = object;
                        x12.F5();
                        object = Gc;
                    } else {
                        x12.B("<");
                        object = N;
                    }
                    x12.xa((O9)((Object)object));
                }
            }
        };
        q = o912;
        O9 o913 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                if (nS2.g()) {
                    x12.Gc(false);
                    x12.q.F5(nS2.g9());
                    x12.Gc.append(nS2.g9());
                    x12.yq(G);
                } else {
                    x12.B("</");
                    x12.xa(N);
                }
            }
        };
        B = o913;
        O9 o914 = new O9(){

            private void Gc(x1 x12, nS nS2) {
                x12.B("</");
                x12.G(x12.Gc);
                nS2.RQ();
                x12.xa(N);
            }

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             */
            @Override
            final void t0(x1 x12, nS object) {
                block6: {
                    void var2_7;
                    block7: {
                        block4: {
                            block5: {
                                if (((nS)object).g()) {
                                    String string = ((nS)object).q();
                                    x12.q.v3(string);
                                    x12.Gc.append(string);
                                    return;
                                }
                                char c = ((nS)object).i();
                                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') break block4;
                                if (c == '/') break block5;
                                if (c != '>' || !x12.ee()) break block6;
                                x12.F5();
                                q q4 = yq;
                                break block7;
                            }
                            if (!x12.ee()) break block6;
                            U u = RQ;
                            break block7;
                        }
                        if (!x12.ee()) break block6;
                        g1 g12 = g;
                    }
                    x12.xa((O9)var2_7);
                    return;
                }
                this.Gc(x12, (nS)object);
            }
        };
        G = o914;
        O9 o915 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                if (nS2.b('/')) {
                    x12.M();
                    x12.yq(dT);
                } else {
                    x12.KJ('<');
                    x12.xa(zH);
                }
            }
        };
        G4 = o915;
        O9 o916 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                O9.tF(x12, nS2, F5, zH);
            }
        };
        dT = o916;
        O9 o917 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                O9.zH(x12, nS2, zH);
            }
        };
        F5 = o917;
        O9 o918 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                char c = object.i();
                if (c != '!') {
                    if (c != '/') {
                        x12.B("<");
                        if (c != '\uffff') {
                            object.RQ();
                            object = i;
                        } else {
                            x12.v3(this);
                            object = yq;
                        }
                    } else {
                        x12.M();
                        object = W;
                    }
                } else {
                    x12.B("<!");
                    object = ee;
                }
                x12.xa((O9)((Object)object));
            }
        };
        v3 = o918;
        O9 o919 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                O9.tF(x12, nS2, v, i);
            }
        };
        W = o919;
        O9 o920 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                O9.zH(x12, nS2, i);
            }
        };
        v = o920;
        O9 o921 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                if (nS2.b('-')) {
                    x12.KJ('-');
                    x12.yq(g9);
                } else {
                    x12.xa(i);
                }
            }
        };
        ee = o921;
        O9 o922 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                if (nS2.b('-')) {
                    x12.KJ('-');
                    x12.yq(Nl);
                } else {
                    x12.xa(i);
                }
            }
        };
        g9 = o922;
        O9 o923 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block4: {
                    block1: {
                        block5: {
                            block2: {
                                block3: {
                                    if (object.Gd()) {
                                        x12.v3(this);
                                        x12.xa(yq);
                                        return;
                                    }
                                    char c = object.g9();
                                    if (c == '\u0000') break block1;
                                    if (c == '-') break block2;
                                    if (c == '<') break block3;
                                    x12.B(object.v3('-', '<', '\u0000'));
                                    break block4;
                                }
                                object = OW;
                                break block5;
                            }
                            x12.KJ('-');
                            object = Gd;
                        }
                        x12.yq((O9)((Object)object));
                        break block4;
                    }
                    x12.W(this);
                    object.yq();
                    x12.KJ('\ufffd');
                }
            }
        };
        xa = o923;
        O9 o924 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block5: {
                    char c;
                    G4 g4;
                    block3: {
                        block1: {
                            block4: {
                                block2: {
                                    g4 = xa;
                                    if (object.Gd()) {
                                        x12.v3(this);
                                        x12.xa(yq);
                                        return;
                                    }
                                    c = object.i();
                                    if (c == '\u0000') break block1;
                                    if (c == '-') break block2;
                                    if (c != '<') break block3;
                                    object = OW;
                                    break block4;
                                }
                                x12.KJ(c);
                                object = Nl;
                            }
                            x12.xa((O9)((Object)object));
                            break block5;
                        }
                        x12.W(this);
                        c = '\ufffd';
                    }
                    x12.KJ(c);
                    x12.xa(g4);
                }
            }
        };
        Gd = o924;
        O9 o925 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block6: {
                    G4 g4;
                    block4: {
                        block1: {
                            char c;
                            block2: {
                                block5: {
                                    block3: {
                                        g4 = xa;
                                        if (object.Gd()) {
                                            x12.v3(this);
                                            x12.xa(yq);
                                            return;
                                        }
                                        c = object.i();
                                        if (c == '\u0000') break block1;
                                        if (c == '-') break block2;
                                        if (c == '<') break block3;
                                        x12.KJ(c);
                                        if (c != '>') break block4;
                                        object = i;
                                        break block5;
                                    }
                                    object = OW;
                                }
                                x12.xa((O9)((Object)object));
                                break block6;
                            }
                            x12.KJ(c);
                            break block6;
                        }
                        x12.W(this);
                        x12.KJ('\ufffd');
                    }
                    x12.xa(g4);
                }
            }
        };
        Nl = o925;
        O9 o926 = new O9(){

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             */
            @Override
            final void t0(x1 x12, nS object) {
                void var2_5;
                if (((nS)object).g()) {
                    x12.M();
                    x12.Gc.append(((nS)object).g9());
                    x12.B("<");
                    x12.KJ(((nS)object).g9());
                    ee ee2 = s;
                } else {
                    if (!((nS)object).b('/')) {
                        x12.KJ('<');
                        x12.xa(xa);
                        return;
                    }
                    x12.M();
                    W w = O;
                }
                x12.yq((O9)var2_5);
            }
        };
        OW = o926;
        O9 o927 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                if (nS2.g()) {
                    x12.Gc(false);
                    x12.q.F5(nS2.g9());
                    x12.Gc.append(nS2.g9());
                    x12.yq(g1);
                } else {
                    x12.B("</");
                    x12.xa(xa);
                }
            }
        };
        O = o927;
        O9 o928 = new O9(){

            final void t0(x1 x12, nS nS2) {
                O9.zH(x12, nS2, O9.xa);
            }
        };
        g1 = o928;
        O9 o929 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                O9.i(x12, nS2, n, xa);
            }
        };
        s = o929;
        O9 o930 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block5: {
                    block2: {
                        block6: {
                            char c;
                            block3: {
                                block4: {
                                    c = object.g9();
                                    if (c == '\u0000') break block2;
                                    if (c == '-') break block3;
                                    if (c == '<') break block4;
                                    if (c != '\uffff') {
                                        x12.B(object.v3('-', '<', '\u0000'));
                                    } else {
                                        x12.v3(this);
                                        x12.xa(yq);
                                    }
                                    break block5;
                                }
                                x12.KJ(c);
                                object = Zm;
                                break block6;
                            }
                            x12.KJ(c);
                            object = un;
                        }
                        x12.yq((O9)((Object)object));
                        break block5;
                    }
                    x12.W(this);
                    object.yq();
                    x12.KJ('\ufffd');
                }
            }
        };
        n = o930;
        O9 o931 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block5: {
                    char c;
                    g9 g92;
                    block3: {
                        block0: {
                            block4: {
                                block1: {
                                    block2: {
                                        g92 = n;
                                        c = object.i();
                                        if (c == '\u0000') break block0;
                                        if (c == '-') break block1;
                                        if (c == 60) break block2;
                                        if (c != '\uffff') break block3;
                                        x12.v3(this);
                                        object = yq;
                                        break block4;
                                    }
                                    x12.KJ(c);
                                    object = Zm;
                                    break block4;
                                }
                                x12.KJ(c);
                                object = b;
                            }
                            x12.xa((O9)((Object)object));
                            break block5;
                        }
                        x12.W(this);
                        c = '\ufffd';
                    }
                    x12.KJ(c);
                    x12.xa(g92);
                }
            }
        };
        un = o931;
        O9 o932 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block6: {
                    char c;
                    g9 g92;
                    block4: {
                        block0: {
                            block1: {
                                block5: {
                                    block2: {
                                        block3: {
                                            g92 = n;
                                            c = object.i();
                                            if (c == '\u0000') break block0;
                                            if (c == '-') break block1;
                                            if (c == 60) break block2;
                                            if (c == 62) break block3;
                                            if (c != '\uffff') break block4;
                                            x12.v3(this);
                                            object = yq;
                                            break block5;
                                        }
                                        x12.KJ(c);
                                        object = i;
                                        break block5;
                                    }
                                    x12.KJ(c);
                                    object = Zm;
                                }
                                x12.xa((O9)((Object)object));
                                break block6;
                            }
                            x12.KJ(c);
                            break block6;
                        }
                        x12.W(this);
                        c = '\ufffd';
                    }
                    x12.KJ(c);
                    x12.xa(g92);
                }
            }
        };
        b = o932;
        O9 o933 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                if (nS2.b('/')) {
                    x12.KJ('/');
                    x12.M();
                    x12.yq(Dr);
                } else {
                    x12.xa(n);
                }
            }
        };
        Zm = o933;
        O9 o934 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                O9.i(x12, nS2, xa, n);
            }
        };
        Dr = o934;
        O9 o935 = new O9(){

            /*
             * Unable to fully structure code
             */
            @Override
            final void t0(x1 var1_1, nS var2_2) {
                block6: {
                    block7: {
                        block5: {
                            var5_3 = O9.yq;
                            var4_4 = O9.H;
                            var3_5 = var2_2.i();
                            if (var3_5 == '\u0000') break block5;
                            if (var3_5 == ' ') break block6;
                            if (var3_5 == '\"' || var3_5 == '\'') ** GOTO lbl-1000
                            if (var3_5 == '/') ** GOTO lbl24
                            if (var3_5 == '\uffff') ** GOTO lbl21
                            if (var3_5 == '\t' || var3_5 == '\n' || var3_5 == '\f' || var3_5 == '\r') break block6;
                            switch (var3_5) {
                                default: {
                                    var1_1.q.Nl();
                                    var2_2.RQ();
                                    break;
                                }
                                case '<': {
                                    var2_2.RQ();
                                    var1_1.W(this);
                                }
                                case '>': {
                                    var1_1.F5();
                                    ** GOTO lbl22
                                }
lbl21:
                                // 1 sources

                                var1_1.v3(this);
lbl22:
                                // 2 sources

                                var1_1.xa(var5_3);
                                break block6;
lbl24:
                                // 1 sources

                                var1_1.xa(O9.RQ);
                                break block6;
                                case '=': lbl-1000:
                                // 2 sources

                                {
                                    var1_1.W(this);
                                    var1_1.q.Nl();
                                    var1_1.q.q(var3_5);
                                    break;
                                }
                            }
                            break block7;
                        }
                        var2_2.RQ();
                        var1_1.W(this);
                        var1_1.q.Nl();
                    }
                    var1_1.xa(var4_4);
                }
            }
        };
        g = o935;
        O9 o936 = new O9(){

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            @Override
            final void t0(x1 var1_1, nS var2_2) {
                block10: {
                    block9: {
                        block5: {
                            block8: {
                                block6: {
                                    block7: {
                                        var4_3 = O9.yq;
                                        var5_4 = var2_2.W(O9.OB);
                                        var1_1.q.B(var5_4);
                                        var3_5 = var2_2.i();
                                        if (var3_5 == '\t' || var3_5 == '\n' || var3_5 == '\f' || var3_5 == '\r' || var3_5 == ' ') break block5;
                                        if (var3_5 == '\"' || var3_5 == '\'') break block6;
                                        if (var3_5 == '/') break block7;
                                        if (var3_5 == '\uffff') ** GOTO lbl18
                                        switch (var3_5) {
                                            default: {
                                                break block8;
                                            }
                                            case '>': {
                                                var1_1.F5();
                                                break;
                                            }
                                            case '=': {
                                                var2_2 = O9.Fz;
                                                break block9;
                                            }
lbl18:
                                            // 1 sources

                                            var1_1.v3(this);
                                        }
                                        var1_1.xa(var4_3);
                                        break block10;
                                    }
                                    var2_2 = O9.RQ;
                                    break block9;
                                    {
                                        ** case 60:
                                    }
                                }
                                var1_1.W(this);
                            }
                            var1_1.q.q(var3_5);
                            break block10;
                        }
                        var2_2 = O9.U;
                    }
                    var1_1.xa((O9)var2_2);
                }
            }
        };
        H = o936;
        O9 o937 = new O9(){

            /*
             * Unable to fully structure code
             */
            final void t0(x1 var1_1, nS var2_2) {
                block6: {
                    block9: {
                        block5: {
                            block7: {
                                block10: {
                                    block8: {
                                        var4_3 = O9.yq;
                                        var5_4 = O9.H;
                                        var3_5 = var2_2.i();
                                        if (var3_5 == '\u0000') break block5;
                                        if (var3_5 == ' ') break block6;
                                        if (var3_5 == '\"' || var3_5 == '\'') break block7;
                                        if (var3_5 == '/') break block8;
                                        if (var3_5 == '\uffff') ** GOTO lbl21
                                        if (var3_5 == '\t' || var3_5 == '\n' || var3_5 == '\f' || var3_5 == '\r') break block6;
                                        switch (var3_5) {
                                            default: {
                                                var1_1.q.Nl();
                                                var2_2.RQ();
                                                break block9;
                                            }
                                            case '>': {
                                                var1_1.F5();
                                                break;
                                            }
                                            case '=': {
                                                var2_2 = O9.Fz;
                                                break block10;
                                            }
lbl21:
                                            // 1 sources

                                            var1_1.v3(this);
                                        }
                                        var1_1.xa(var4_3);
                                        break block6;
                                    }
                                    var2_2 = O9.RQ;
                                }
                                var1_1.xa((O9)var2_2);
                                break block6;
                                {
                                    ** case 60:
                                }
                            }
                            var1_1.W(this);
                            var1_1.q.Nl();
                            var1_1.q.q(var3_5);
                            break block9;
                        }
                        var1_1.W(this);
                        var1_1.q.q('\ufffd');
                    }
                    var1_1.xa(var5_4);
                }
            }
        };
        U = o937;
        O9 o938 = new O9(){

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            @Override
            final void t0(x1 var1_1, nS var2_2) {
                block5: {
                    block12: {
                        block4: {
                            block11: {
                                block6: {
                                    block7: {
                                        block10: {
                                            block8: {
                                                block9: {
                                                    var4_3 = O9.yq;
                                                    var5_4 = O9.m;
                                                    var3_5 = var2_2.i();
                                                    if (var3_5 == '\u0000') break block4;
                                                    if (var3_5 == ' ') break block5;
                                                    if (var3_5 == '\"') break block6;
                                                    if (var3_5 == '`') break block7;
                                                    if (var3_5 == '\uffff') break block8;
                                                    if (var3_5 == '\t' || var3_5 == '\n' || var3_5 == '\f' || var3_5 == '\r') break block5;
                                                    if (var3_5 == '&') break block9;
                                                    if (var3_5 == '\'') ** GOTO lbl18
                                                    switch (var3_5) {
                                                        default: {
                                                            break;
                                                        }
                                                        case '>': {
                                                            var1_1.W(this);
                                                            break block10;
                                                        }
lbl18:
                                                        // 1 sources

                                                        var2_2 = O9.tO;
                                                        break block11;
                                                    }
                                                }
                                                var2_2.RQ();
                                                break block12;
                                            }
                                            var1_1.v3(this);
                                        }
                                        var1_1.F5();
                                        var1_1.xa(var4_3);
                                        break block5;
                                        {
                                            ** case 60:
                                            ** case 61:
                                        }
                                    }
                                    var1_1.W(this);
                                    var1_1.q.G(var3_5);
                                    break block12;
                                }
                                var2_2 = O9.E1;
                            }
                            var1_1.xa((O9)var2_2);
                            break block5;
                        }
                        var1_1.W(this);
                        var1_1.q.G('\ufffd');
                    }
                    var1_1.xa(var5_4);
                }
            }
        };
        Fz = o938;
        O9 o939 = new O9(){

            final void t0(x1 object, nS object2) {
                block10: {
                    char c;
                    block8: {
                        block4: {
                            block9: {
                                block5: {
                                    block6: {
                                        block7: {
                                            String string = object2.t0(false);
                                            if (string.length() > 0) {
                                                ((x1)object).q.G4(string);
                                            } else {
                                                ((x1)object).q.O();
                                            }
                                            c = object2.i();
                                            if (c == '\u0000') break block4;
                                            if (c == '\"') break block5;
                                            if (c == '&') break block6;
                                            if (c == 65535) break block7;
                                            object = ((x1)object).q;
                                            break block8;
                                        }
                                        ((x1)object).v3(this);
                                        object2 = O9.yq;
                                        break block9;
                                    }
                                    object2 = ((x1)object).zH(Character.valueOf('\"'), true);
                                    object = ((x1)object).q;
                                    if (object2 != null) {
                                        ((xc.Gc)object).dT((int[])object2);
                                    } else {
                                        ((xc.Gc)object).G('&');
                                    }
                                    break block10;
                                }
                                object2 = O9.k;
                            }
                            ((x1)object).xa((O9)((Object)object2));
                            break block10;
                        }
                        ((x1)object).W(this);
                        object = ((x1)object).q;
                        c = '\ufffd';
                    }
                    ((xc.Gc)object).G(c);
                }
            }
        };
        E1 = o939;
        O9 o940 = new O9(){

            @Override
            final void t0(x1 object, nS object2) {
                block10: {
                    char c;
                    block8: {
                        block4: {
                            block9: {
                                block5: {
                                    block6: {
                                        block7: {
                                            String string = object2.t0(true);
                                            if (string.length() > 0) {
                                                ((x1)object).q.G4(string);
                                            } else {
                                                ((x1)object).q.O();
                                            }
                                            c = object2.i();
                                            if (c == '\u0000') break block4;
                                            if (c == '\uffff') break block5;
                                            if (c == '&') break block6;
                                            if (c == 39) break block7;
                                            object = ((x1)object).q;
                                            break block8;
                                        }
                                        object2 = k;
                                        break block9;
                                    }
                                    object2 = ((x1)object).zH(Character.valueOf('\''), true);
                                    object = ((x1)object).q;
                                    if (object2 != null) {
                                        ((xc.Gc)object).dT((int[])object2);
                                    } else {
                                        ((xc.Gc)object).G('&');
                                    }
                                    break block10;
                                }
                                ((x1)object).v3(this);
                                object2 = yq;
                            }
                            ((x1)object).xa((O9)((Object)object2));
                            break block10;
                        }
                        ((x1)object).W(this);
                        object = ((x1)object).q;
                        c = '\ufffd';
                    }
                    ((xc.Gc)object).G(c);
                }
            }
        };
        tO = o940;
        O9 o941 = new O9(){

            /*
             * Unable to fully structure code
             */
            final void t0(x1 var1_1, nS var2_2) {
                block9: {
                    block10: {
                        block7: {
                            block8: {
                                var4_3 = O9.yq;
                                var5_4 = var2_2.W(O9.x);
                                if (var5_4.length() > 0) {
                                    var1_1.q.G4(var5_4);
                                }
                                if ((var3_5 = var2_2.i()) == '\u0000') break block7;
                                if (var3_5 == ' ') break block8;
                                if (var3_5 == '\"' || var3_5 == 96) ** GOTO lbl-1000
                                if (var3_5 == 65535) ** GOTO lbl25
                                if (var3_5 == 9 || var3_5 == 10 || var3_5 == 12 || var3_5 == 13) break block8;
                                if (var3_5 == 38) ** GOTO lbl18
                                if (var3_5 == 39) ** GOTO lbl-1000
                                switch (var3_5) {
                                    default: {
                                        break;
                                    }
                                    case '>': {
                                        var1_1.F5();
                                        ** GOTO lbl26
                                    }
lbl18:
                                    // 1 sources

                                    var2_2 = var1_1.zH(Character.valueOf('>'), true);
                                    var1_1 = var1_1.q;
                                    if (var2_2 != null) {
                                        var1_1.dT((int[])var2_2);
                                    } else {
                                        var1_1.G('&');
                                    }
                                    break block9;
lbl25:
                                    // 1 sources

                                    var1_1.v3(this);
lbl26:
                                    // 2 sources

                                    var1_1.xa(var4_3);
                                    break block9;
                                    case '<': 
                                    case '=': lbl-1000:
                                    // 3 sources

                                    {
                                        var1_1.W(this);
                                    }
                                }
                                var1_1 = var1_1.q;
                                break block10;
                            }
                            var1_1.xa(O9.g);
                            break block9;
                        }
                        var1_1.W(this);
                        var1_1 = var1_1.q;
                        var3_5 = '\ufffd';
                    }
                    var1_1.G(var3_5);
                }
            }
        };
        m = o941;
        O9 o942 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                block5: {
                    g1 g12;
                    block0: {
                        block1: {
                            q q4;
                            block4: {
                                block2: {
                                    block3: {
                                        q4 = yq;
                                        g12 = g;
                                        char c = nS2.i();
                                        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') break block0;
                                        if (c == '/') break block1;
                                        if (c == '>') break block2;
                                        if (c == '\uffff') break block3;
                                        nS2.RQ();
                                        x12.W(this);
                                        break block0;
                                    }
                                    x12.v3(this);
                                    break block4;
                                }
                                x12.F5();
                            }
                            x12.xa(q4);
                            break block5;
                        }
                        x12.xa(RQ);
                        break block5;
                    }
                    x12.xa(g12);
                }
            }
        };
        k = o942;
        O9 o943 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                block2: {
                    q q4;
                    block3: {
                        block0: {
                            block1: {
                                q4 = yq;
                                char c = nS2.i();
                                if (c == '>') break block0;
                                if (c == '\uffff') break block1;
                                nS2.RQ();
                                x12.W(this);
                                x12.xa(g);
                                break block2;
                            }
                            x12.v3(this);
                            break block3;
                        }
                        x12.q.G = true;
                        x12.F5();
                    }
                    x12.xa(q4);
                }
            }
        };
        RQ = o943;
        O9 o944 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                x12.G4.B(nS2.F5('>'));
                char c = nS2.g9();
                if (c == '>' || c == '\uffff') {
                    nS2.i();
                    x12.G4();
                    x12.xa(yq);
                }
            }
        };
        Z = o944;
        O9 o945 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                if (object.n("--")) {
                    x12.G4.Gc();
                    object = xU;
                } else if (object.un("DOCTYPE")) {
                    object = C;
                } else if (object.n("[CDATA[")) {
                    x12.M();
                    object = cS;
                } else {
                    x12.W(this);
                    x12.i();
                    object = Z;
                }
                x12.xa((O9)((Object)object));
            }
        };
        V = o945;
        O9 o946 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                block6: {
                    k k2;
                    block4: {
                        block0: {
                            block1: {
                                q q4;
                                block5: {
                                    block2: {
                                        block3: {
                                            q4 = yq;
                                            k2 = R;
                                            char c = nS2.i();
                                            if (c == '\u0000') break block0;
                                            if (c == '-') break block1;
                                            if (c == '>') break block2;
                                            if (c == '\uffff') break block3;
                                            nS2.RQ();
                                            break block4;
                                        }
                                        x12.v3(this);
                                        break block5;
                                    }
                                    x12.W(this);
                                }
                                x12.G4();
                                x12.xa(q4);
                                break block6;
                            }
                            x12.xa(N0);
                            break block6;
                        }
                        x12.W(this);
                        x12.G4.q('\ufffd');
                    }
                    x12.xa(k2);
                }
            }
        };
        xU = o946;
        O9 o947 = new O9(){

            final void t0(x1 x12, nS nS2) {
                block6: {
                    k k2;
                    block4: {
                        block0: {
                            block1: {
                                q q4;
                                block5: {
                                    block2: {
                                        block3: {
                                            q4 = O9.yq;
                                            k2 = O9.R;
                                            char c = nS2.i();
                                            if (c == '\u0000') break block0;
                                            if (c == '-') break block1;
                                            if (c == '>') break block2;
                                            if (c == '\uffff') break block3;
                                            x12.G4.q(c);
                                            break block4;
                                        }
                                        x12.v3(this);
                                        break block5;
                                    }
                                    x12.W(this);
                                }
                                x12.G4();
                                x12.xa(q4);
                                break block6;
                            }
                            x12.xa(O9.i3);
                            break block6;
                        }
                        x12.W(this);
                        x12.G4.q('\ufffd');
                    }
                    x12.xa(k2);
                }
            }
        };
        N0 = o947;
        O9 o948 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                char c = nS2.g9();
                if (c != '\u0000') {
                    if (c != '-') {
                        if (c != '\uffff') {
                            x12.G4.B(nS2.v3('-', '\u0000'));
                        } else {
                            x12.v3(this);
                            x12.G4();
                            x12.xa(yq);
                        }
                    } else {
                        x12.yq(J);
                    }
                } else {
                    x12.W(this);
                    nS2.yq();
                    x12.G4.q('\ufffd');
                }
            }
        };
        R = o948;
        O9 o949 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block5: {
                    k k2;
                    block3: {
                        block0: {
                            block4: {
                                block1: {
                                    block2: {
                                        k2 = R;
                                        char c = ((nS)object).i();
                                        if (c == '\u0000') break block0;
                                        if (c == '-') break block1;
                                        if (c == '\uffff') break block2;
                                        object = x12.G4;
                                        ((xc.N)object).q('-');
                                        ((xc.N)object).q(c);
                                        break block3;
                                    }
                                    x12.v3(this);
                                    x12.G4();
                                    object = yq;
                                    break block4;
                                }
                                object = i3;
                            }
                            x12.xa((O9)((Object)object));
                            break block5;
                        }
                        x12.W(this);
                        object = x12.G4;
                        ((xc.N)object).q('-');
                        ((xc.N)object).q('\ufffd');
                    }
                    x12.xa(k2);
                }
            }
        };
        J = o949;
        O9 o950 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block6: {
                    k k2;
                    block5: {
                        block0: {
                            block1: {
                                block2: {
                                    q q4;
                                    block3: {
                                        block4: {
                                            q4 = yq;
                                            k2 = R;
                                            char c = ((nS)object).i();
                                            if (c == '\u0000') break block0;
                                            if (c == '!') break block1;
                                            if (c == '-') break block2;
                                            if (c == '>') break block3;
                                            if (c == '\uffff') break block4;
                                            object = x12.G4;
                                            ((xc.N)object).B("--");
                                            ((xc.N)object).q(c);
                                            break block5;
                                        }
                                        x12.v3(this);
                                    }
                                    x12.G4();
                                    x12.xa(q4);
                                    break block6;
                                }
                                x12.G4.q('-');
                                break block6;
                            }
                            x12.xa(lF);
                            break block6;
                        }
                        x12.W(this);
                        object = x12.G4;
                        ((xc.N)object).B("--");
                        ((xc.N)object).q('\ufffd');
                    }
                    x12.xa(k2);
                }
            }
        };
        i3 = o950;
        O9 o951 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block5: {
                    k k2;
                    block4: {
                        block0: {
                            block1: {
                                q q4;
                                block2: {
                                    block3: {
                                        q4 = yq;
                                        k2 = R;
                                        char c = ((nS)object).i();
                                        if (c == '\u0000') break block0;
                                        if (c == '-') break block1;
                                        if (c == '>') break block2;
                                        if (c == '\uffff') break block3;
                                        object = x12.G4;
                                        ((xc.N)object).B("--!");
                                        ((xc.N)object).q(c);
                                        break block4;
                                    }
                                    x12.v3(this);
                                }
                                x12.G4();
                                x12.xa(q4);
                                break block5;
                            }
                            x12.G4.B("--!");
                            x12.xa(J);
                            break block5;
                        }
                        x12.W(this);
                        object = x12.G4;
                        ((xc.N)object).B("--!");
                        ((xc.N)object).q('\ufffd');
                    }
                    x12.xa(k2);
                }
            }
        };
        lF = o951;
        O9 o952 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                block3: {
                    R r3;
                    block0: {
                        block1: {
                            block2: {
                                r3 = Q4;
                                char c = nS2.i();
                                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') break block0;
                                if (c == '>') break block1;
                                if (c == '\uffff') break block2;
                                x12.W(this);
                                break block0;
                            }
                            x12.v3(this);
                        }
                        x12.W(this);
                        x12.t0();
                        x12.G.Gc = true;
                        x12.dT();
                        x12.xa(yq);
                        break block3;
                    }
                    x12.xa(r3);
                }
            }
        };
        C = o952;
        O9 o953 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                block2: {
                    J j3;
                    block4: {
                        block1: {
                            block3: {
                                j3 = p;
                                if (nS2.g()) {
                                    x12.t0();
                                    x12.xa(j3);
                                    return;
                                }
                                char c = nS2.i();
                                if (c == '\u0000') break block1;
                                if (c == ' ') break block2;
                                if (c == '\uffff') break block3;
                                if (c == '\t' || c == '\n' || c == '\f' || c == '\r') break block2;
                                x12.t0();
                                x12.G.tF.append(c);
                                break block4;
                            }
                            x12.v3(this);
                            x12.t0();
                            x12.G.Gc = true;
                            x12.dT();
                            x12.xa(yq);
                            break block2;
                        }
                        x12.W(this);
                        x12.t0();
                        x12.G.tF.append('\ufffd');
                    }
                    x12.xa(j3);
                }
            }
        };
        Q4 = o953;
        O9 o954 = new O9(){

            @Override
            final void t0(x1 object, nS object2) {
                block6: {
                    char c;
                    block5: {
                        block1: {
                            block2: {
                                q q4;
                                block3: {
                                    block4: {
                                        q4 = yq;
                                        if (((nS)object2).U()) {
                                            object2 = ((nS)object2).q();
                                            ((x1)object).G.tF.append((String)object2);
                                            return;
                                        }
                                        c = ((nS)object2).i();
                                        if (c == '\u0000') break block1;
                                        if (c == ' ') break block2;
                                        if (c == '>') break block3;
                                        if (c == '\uffff') break block4;
                                        if (c == 9 || c == 10 || c == 12 || c == 13) break block2;
                                        object = ((x1)object).G.tF;
                                        break block5;
                                    }
                                    ((x1)object).v3(this);
                                    ((x1)object).G.Gc = true;
                                }
                                ((x1)object).dT();
                                ((x1)object).xa(q4);
                                break block6;
                            }
                            ((x1)object).xa(w);
                            break block6;
                        }
                        ((x1)object).W(this);
                        object = ((x1)object).G.tF;
                        c = '\ufffd';
                    }
                    ((StringBuilder)object).append(c);
                }
            }
        };
        p = o954;
        O9 o955 = new O9(){

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             */
            @Override
            final void t0(x1 x12, nS object) {
                void var2_5;
                q q4 = yq;
                if (((nS)object).Gd()) {
                    x12.v3(this);
                    x12.G.Gc = true;
                    x12.dT();
                    x12.xa(q4);
                    return;
                }
                if (((nS)object).Zm('\t', '\n', '\r', '\f', ' ')) {
                    ((nS)object).yq();
                    return;
                }
                if (((nS)object).b('>')) {
                    x12.dT();
                    x12.yq(q4);
                    return;
                }
                if (((nS)object).un("PUBLIC")) {
                    x12.G.zH = "PUBLIC";
                    lF lF2 = mG;
                } else {
                    if (!((nS)object).un("SYSTEM")) {
                        x12.W(this);
                        x12.G.Gc = true;
                        x12.yq(u7);
                        return;
                    }
                    x12.G.zH = "SYSTEM";
                    XO xO = nQ;
                }
                x12.xa((O9)var2_5);
            }
        };
        w = o955;
        O9 o956 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block7: {
                    block5: {
                        block0: {
                            block1: {
                                block2: {
                                    q q4;
                                    block6: {
                                        block3: {
                                            block4: {
                                                q4 = yq;
                                                char c = object.i();
                                                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') break block0;
                                                if (c == '\"') break block1;
                                                if (c == '\'') break block2;
                                                if (c == '>') break block3;
                                                if (c == '\uffff') break block4;
                                                x12.W(this);
                                                x12.G.Gc = true;
                                                object = u7;
                                                break block5;
                                            }
                                            x12.v3(this);
                                            break block6;
                                        }
                                        x12.W(this);
                                    }
                                    x12.G.Gc = true;
                                    x12.dT();
                                    x12.xa(q4);
                                    break block7;
                                }
                                x12.W(this);
                                object = j;
                                break block5;
                            }
                            x12.W(this);
                            object = XO;
                            break block5;
                        }
                        object = Hj;
                    }
                    x12.xa((O9)((Object)object));
                }
            }
        };
        mG = o956;
        O9 o957 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block0: {
                    block5: {
                        block1: {
                            block2: {
                                q q4;
                                block6: {
                                    block3: {
                                        block4: {
                                            q4 = yq;
                                            char c = object.i();
                                            if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') break block0;
                                            if (c == '\"') break block1;
                                            if (c == '\'') break block2;
                                            if (c == '>') break block3;
                                            if (c == '\uffff') break block4;
                                            x12.W(this);
                                            x12.G.Gc = true;
                                            object = u7;
                                            break block5;
                                        }
                                        x12.v3(this);
                                        break block6;
                                    }
                                    x12.W(this);
                                }
                                x12.G.Gc = true;
                                x12.dT();
                                x12.xa(q4);
                                break block0;
                            }
                            object = j;
                            break block5;
                        }
                        object = XO;
                    }
                    x12.xa((O9)((Object)object));
                }
            }
        };
        Hj = o957;
        O9 o958 = new O9(){

            @Override
            final void t0(x1 object, nS nS2) {
                block6: {
                    char c;
                    block4: {
                        block0: {
                            block1: {
                                q q4;
                                block5: {
                                    block2: {
                                        block3: {
                                            q4 = yq;
                                            c = nS2.i();
                                            if (c == '\u0000') break block0;
                                            if (c == '\"') break block1;
                                            if (c == '>') break block2;
                                            if (c == '\uffff') break block3;
                                            object = ((x1)object).G.i;
                                            break block4;
                                        }
                                        ((x1)object).v3(this);
                                        break block5;
                                    }
                                    ((x1)object).W(this);
                                }
                                ((x1)object).G.Gc = true;
                                ((x1)object).dT();
                                ((x1)object).xa(q4);
                                break block6;
                            }
                            ((x1)object).xa(o);
                            break block6;
                        }
                        ((x1)object).W(this);
                        object = ((x1)object).G.i;
                        c = '\ufffd';
                    }
                    ((StringBuilder)object).append(c);
                }
            }
        };
        XO = o958;
        O9 o959 = new O9(){

            @Override
            final void t0(x1 object, nS nS2) {
                block6: {
                    char c;
                    block4: {
                        block0: {
                            block1: {
                                q q4;
                                block5: {
                                    block2: {
                                        block3: {
                                            q4 = yq;
                                            c = nS2.i();
                                            if (c == '\u0000') break block0;
                                            if (c == '\'') break block1;
                                            if (c == '>') break block2;
                                            if (c == '\uffff') break block3;
                                            object = ((x1)object).G.i;
                                            break block4;
                                        }
                                        ((x1)object).v3(this);
                                        break block5;
                                    }
                                    ((x1)object).W(this);
                                }
                                ((x1)object).G.Gc = true;
                                ((x1)object).dT();
                                ((x1)object).xa(q4);
                                break block6;
                            }
                            ((x1)object).xa(o);
                            break block6;
                        }
                        ((x1)object).W(this);
                        object = ((x1)object).G.i;
                        c = '\ufffd';
                    }
                    ((StringBuilder)object).append(c);
                }
            }
        };
        j = o959;
        O9 o960 = new O9(){

            final void t0(x1 x12, nS object) {
                block6: {
                    block5: {
                        block0: {
                            block1: {
                                block2: {
                                    q q4;
                                    block3: {
                                        block4: {
                                            q4 = O9.yq;
                                            char c = object.i();
                                            if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') break block0;
                                            if (c == '\"') break block1;
                                            if (c == '\'') break block2;
                                            if (c == '>') break block3;
                                            if (c == '\uffff') break block4;
                                            x12.W(this);
                                            x12.G.Gc = true;
                                            object = O9.u7;
                                            break block5;
                                        }
                                        x12.v3(this);
                                        x12.G.Gc = true;
                                    }
                                    x12.dT();
                                    x12.xa(q4);
                                    break block6;
                                }
                                x12.W(this);
                                object = O9.Cu;
                                break block5;
                            }
                            x12.W(this);
                            object = O9.L;
                            break block5;
                        }
                        object = O9.LY;
                    }
                    x12.xa((O9)((Object)object));
                }
            }
        };
        o = o960;
        O9 o961 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block0: {
                    block5: {
                        block1: {
                            block2: {
                                q q4;
                                block3: {
                                    block4: {
                                        q4 = yq;
                                        char c = object.i();
                                        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') break block0;
                                        if (c == '\"') break block1;
                                        if (c == '\'') break block2;
                                        if (c == '>') break block3;
                                        if (c == '\uffff') break block4;
                                        x12.W(this);
                                        x12.G.Gc = true;
                                        object = u7;
                                        break block5;
                                    }
                                    x12.v3(this);
                                    x12.G.Gc = true;
                                }
                                x12.dT();
                                x12.xa(q4);
                                break block0;
                            }
                            x12.W(this);
                            object = Cu;
                            break block5;
                        }
                        x12.W(this);
                        object = L;
                    }
                    x12.xa((O9)((Object)object));
                }
            }
        };
        LY = o961;
        O9 o962 = new O9(){

            @Override
            final void t0(x1 x12, nS object) {
                block5: {
                    block7: {
                        block0: {
                            block1: {
                                block2: {
                                    q q4;
                                    block6: {
                                        block3: {
                                            block4: {
                                                q4 = yq;
                                                char c = object.i();
                                                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') break block0;
                                                if (c == '\"') break block1;
                                                if (c == '\'') break block2;
                                                if (c == '>') break block3;
                                                if (c == '\uffff') break block4;
                                                x12.W(this);
                                                x12.G.Gc = true;
                                                x12.dT();
                                                break block5;
                                            }
                                            x12.v3(this);
                                            break block6;
                                        }
                                        x12.W(this);
                                    }
                                    x12.G.Gc = true;
                                    x12.dT();
                                    x12.xa(q4);
                                    break block5;
                                }
                                x12.W(this);
                                object = Cu;
                                break block7;
                            }
                            x12.W(this);
                            object = L;
                            break block7;
                        }
                        object = kR;
                    }
                    x12.xa((O9)((Object)object));
                }
            }
        };
        nQ = o962;
        O9 o963 = new O9(){

            final void t0(x1 x12, nS object) {
                block0: {
                    block5: {
                        block1: {
                            block2: {
                                q q4;
                                block6: {
                                    block3: {
                                        block4: {
                                            q4 = O9.yq;
                                            char c = object.i();
                                            if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') break block0;
                                            if (c == '\"') break block1;
                                            if (c == '\'') break block2;
                                            if (c == '>') break block3;
                                            if (c == '\uffff') break block4;
                                            x12.W(this);
                                            x12.G.Gc = true;
                                            object = O9.u7;
                                            break block5;
                                        }
                                        x12.v3(this);
                                        break block6;
                                    }
                                    x12.W(this);
                                }
                                x12.G.Gc = true;
                                x12.dT();
                                x12.xa(q4);
                                break block0;
                            }
                            object = O9.Cu;
                            break block5;
                        }
                        object = O9.L;
                    }
                    x12.xa((O9)((Object)object));
                }
            }
        };
        kR = o963;
        O9 o964 = new O9(){

            final void t0(x1 object, nS nS2) {
                block6: {
                    char c;
                    block4: {
                        block0: {
                            block1: {
                                q q4;
                                block5: {
                                    block2: {
                                        block3: {
                                            q4 = O9.yq;
                                            c = nS2.i();
                                            if (c == '\u0000') break block0;
                                            if (c == '\"') break block1;
                                            if (c == '>') break block2;
                                            if (c == '\uffff') break block3;
                                            object = ((x1)object).G.t0;
                                            break block4;
                                        }
                                        ((x1)object).v3(this);
                                        break block5;
                                    }
                                    ((x1)object).W(this);
                                }
                                ((x1)object).G.Gc = true;
                                ((x1)object).dT();
                                ((x1)object).xa(q4);
                                break block6;
                            }
                            ((x1)object).xa(O9.cp);
                            break block6;
                        }
                        ((x1)object).W(this);
                        object = ((x1)object).G.t0;
                        c = '\ufffd';
                    }
                    ((StringBuilder)object).append(c);
                }
            }
        };
        L = o964;
        O9 o965 = new O9(){

            @Override
            final void t0(x1 object, nS nS2) {
                block6: {
                    char c;
                    block4: {
                        block0: {
                            block1: {
                                q q4;
                                block5: {
                                    block2: {
                                        block3: {
                                            q4 = yq;
                                            c = nS2.i();
                                            if (c == '\u0000') break block0;
                                            if (c == '\'') break block1;
                                            if (c == '>') break block2;
                                            if (c == '\uffff') break block3;
                                            object = ((x1)object).G.t0;
                                            break block4;
                                        }
                                        ((x1)object).v3(this);
                                        break block5;
                                    }
                                    ((x1)object).W(this);
                                }
                                ((x1)object).G.Gc = true;
                                ((x1)object).dT();
                                ((x1)object).xa(q4);
                                break block6;
                            }
                            ((x1)object).xa(cp);
                            break block6;
                        }
                        ((x1)object).W(this);
                        object = ((x1)object).G.t0;
                        c = '\ufffd';
                    }
                    ((StringBuilder)object).append(c);
                }
            }
        };
        Cu = o965;
        O9 o966 = new O9(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            final void t0(x1 x12, nS nS2) {
                q q4 = yq;
                char c = nS2.i();
                if (c == '\t') return;
                if (c == '\n') return;
                if (c == '\f') return;
                if (c == '\r') return;
                if (c == ' ') return;
                if (c != '>') {
                    if (c != '\uffff') {
                        x12.W(this);
                        x12.xa(u7);
                        return;
                    }
                    x12.v3(this);
                    x12.G.Gc = true;
                }
                x12.dT();
                x12.xa(q4);
            }
        };
        cp = o966;
        O9 o967 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                q q4 = yq;
                char c = nS2.i();
                if (c == '>' || c == '\uffff') {
                    x12.dT();
                    x12.xa(q4);
                }
            }
        };
        u7 = o967;
        O9 o968 = new O9(){

            @Override
            final void t0(x1 x12, nS nS2) {
                String string = nS2.dT();
                x12.Gc.append(string);
                if (nS2.n("]]>") || nS2.Gd()) {
                    x12.q(new xc.yq(x12.Gc.toString()));
                    x12.xa(yq);
                }
            }
        };
        cS = o968;
        I = new O9[]{o92, o93, o94, o95, o96, o97, o98, o99, o910, o911, o912, o913, o914, o915, o916, o917, o918, o919, o920, o921, o922, o923, o924, o925, o926, o927, o928, o929, o930, o931, o932, o933, o934, o935, o936, o937, o938, o939, o940, o941, o942, o943, o944, o945, o946, o947, o948, o949, o950, o951, o952, o953, o954, o955, o956, o957, o958, o959, o960, o961, o962, o963, o964, o965, o966, o967, o968};
        OB = new char[]{'\t', '\n', '\f', '\r', ' ', '\"', '\'', '/', '<', '=', '>'};
        x = new char[]{'\u0000', '\t', '\n', '\f', '\r', ' ', '\"', '&', '\'', '<', '=', '>', '`'};
        ue = String.valueOf('\ufffd');
    }

    O9(q q4) {
    }

    static void SN(x1 x12, nS nS2, O9 o92, O9 o93) {
        char c = nS2.g9();
        if (c != '\u0000') {
            if (c != '<') {
                if (c != '\uffff') {
                    x12.B(nS2.G());
                } else {
                    x12.q(new xc.zH());
                }
            } else {
                x12.yq(o93);
            }
        } else {
            x12.W(o92);
            nS2.yq();
            x12.KJ('\ufffd');
        }
    }

    static void i(x1 x12, nS object, O9 o92, O9 o93) {
        if (((nS)object).U()) {
            object = ((nS)object).q();
            x12.Gc.append((String)object);
            x12.B((String)object);
        } else {
            char c = ((nS)object).i();
            if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ' && c != '/' && c != '>') {
                ((nS)object).RQ();
                x12.xa(o93);
            } else {
                if (x12.Gc.toString().equals("script")) {
                    x12.xa(o92);
                } else {
                    x12.xa(o93);
                }
                x12.KJ(c);
            }
        }
    }

    static void tF(x1 x12, nS nS2, O9 o92, O9 o93) {
        if (nS2.g()) {
            x12.Gc(false);
            x12.xa(o92);
        } else {
            x12.B("</");
            x12.xa(o93);
        }
    }

    public static O9 valueOf(String string) {
        return Enum.valueOf(O9.class, string);
    }

    public static O9[] values() {
        return (O9[])I.clone();
    }

    static void yq(x1 x12, O9 o92) {
        int[] nArray = x12.zH(null, false);
        if (nArray == null) {
            x12.KJ('&');
        } else {
            x12.B(new String(nArray, 0, nArray.length));
        }
        x12.xa(o92);
    }

    static void zH(x1 x12, nS object, O9 o92) {
        block2: {
            boolean bl;
            block3: {
                boolean bl2;
                block7: {
                    block4: {
                        block5: {
                            block6: {
                                boolean bl3;
                                block1: {
                                    if (!((nS)object).U()) break block1;
                                    object = ((nS)object).q();
                                    x12.q.v3((String)object);
                                    x12.Gc.append((String)object);
                                    break block2;
                                }
                                bl2 = false;
                                boolean bl4 = x12.ee();
                                bl = bl3 = true;
                                if (!bl4) break block3;
                                bl = bl3;
                                if (((nS)object).Gd()) break block3;
                                char c = ((nS)object).i();
                                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') break block4;
                                if (c == '/') break block5;
                                if (c == '>') break block6;
                                x12.Gc.append(c);
                                bl = true;
                                break block3;
                            }
                            x12.F5();
                            object = yq;
                            break block7;
                        }
                        object = RQ;
                        break block7;
                    }
                    object = g;
                }
                x12.xa((O9)((Object)object));
                bl = bl2;
            }
            if (bl) {
                x12.B("</");
                x12.G(x12.Gc);
                x12.xa(o92);
            }
        }
    }

    abstract void t0(x1 var1, nS var2);
}

