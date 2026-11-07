/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.C;
import com.github.catvod.spider.merge.CK;
import com.github.catvod.spider.merge.Mx;
import com.github.catvod.spider.merge.Nv;
import com.github.catvod.spider.merge.Os;
import com.github.catvod.spider.merge.Q4;
import com.github.catvod.spider.merge.QY;
import com.github.catvod.spider.merge.SY;
import com.github.catvod.spider.merge.T9;
import com.github.catvod.spider.merge.Tu;
import com.github.catvod.spider.merge.VQ;
import com.github.catvod.spider.merge.Wo;
import com.github.catvod.spider.merge.Wt;
import com.github.catvod.spider.merge.XO;
import com.github.catvod.spider.merge.aq;
import com.github.catvod.spider.merge.e_0;
import com.github.catvod.spider.merge.ei_0;
import com.github.catvod.spider.merge.j;
import com.github.catvod.spider.merge.j2;
import com.github.catvod.spider.merge.ku_0;
import com.github.catvod.spider.merge.lC;
import com.github.catvod.spider.merge.lF;
import com.github.catvod.spider.merge.le_1;
import com.github.catvod.spider.merge.ly_1;
import com.github.catvod.spider.merge.mZ;
import com.github.catvod.spider.merge.nv_0;
import com.github.catvod.spider.merge.rg;
import com.github.catvod.spider.merge.si_0;
import com.github.catvod.spider.merge.ue;
import com.github.catvod.spider.merge.zn_0;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class md
extends XO {
    public static final boolean q;
    protected int Gc;
    protected QY KJ;
    protected ei_0 M;
    protected le_1<CK, CK, CK> i;
    protected lC t0;
    protected final Tu tF;
    public final QY[] zH;

    static {
        String string;
        try {
            string = System.getenv("TURN_OFF_LR_LOOP_ENTRY_BRANCH_OPT");
        }
        catch (SecurityException securityException) {
            string = null;
        }
        q = Boolean.parseBoolean(string);
    }

    public md(Tu tu, lF lF2, QY[] qYArray, ku_0 ku_02) {
        super(lF2, ku_02);
        this.tF = tu;
        this.zH = qYArray;
    }

    protected static int dT(Q4 object) {
        object = ((Q4)object).iterator();
        int n2 = 0;
        while (object.hasNext()) {
            C c = (C)object.next();
            if (n2 == 0) {
                n2 = c.SN;
                continue;
            }
            if (c.SN == n2) continue;
            return 0;
        }
        return n2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    protected final int B(QY var1_1, Mx var2_2, lC var3_3, int var4_4, ei_0 var5_5) {
        var6_6 = var3_3.t0(1);
        var12_7 /* !! */  = var2_2;
        while (true) {
            block54: {
                block50: {
                    block53: {
                        block48: {
                            block52: {
                                block51: {
                                    var11_12 /* !! */  = (var2_2 = var12_7 /* !! */ .N) != null && (var7_8 = var6_6 + 1) >= 0 && var7_8 < ((Mx[])var2_2).length ? var2_2[var7_8] : null;
                                    var2_2 = var11_12 /* !! */ ;
                                    if (var11_12 /* !! */  != null) break block50;
                                    var14_14 = this.Gc(var12_7 /* !! */ .SN, var6_6, false);
                                    if (var14_14 != null) break block51;
                                    var2_2 = XO.N;
                                    this.N((QY)var1_1, (Mx)var12_7 /* !! */ , var6_6, (Mx)var2_2);
                                    break block50;
                                }
                                var13_13 = new Mx((Q4)var14_14);
                                var7_8 = md.dT((Q4)var14_14);
                                if (var7_8 == 0) break block52;
                                var13_13.tF = true;
                                var13_13.SN.tF = var7_8;
                                var13_13.zH = var7_8;
                                break block53;
                            }
                            if (nv_0.yq((Q4)var14_14)) ** GOTO lbl-1000
                            var2_2 = ((ArrayList)nv_0.SN((Q4)var14_14)).iterator();
                            while (var2_2.hasNext()) {
                                if (((BitSet)var2_2.next()).cardinality() <= 1) continue;
                                var7_8 = 1;
                                break block48;
                            }
                            var7_8 = 0;
                        }
                        if (var7_8 != 0) {
                            block49: {
                                var15_15 = new HashMap<j, Object>();
                                var16_16 = var14_14.iterator();
                                while (var16_16.hasNext()) {
                                    var17_17 = var16_16.next();
                                    var11_12 /* !! */  = (BitSet)var15_15.get(var17_17.yq);
                                    var2_2 = var11_12 /* !! */ ;
                                    if (var11_12 /* !! */  == null) {
                                        var2_2 = new BitSet();
                                        var15_15.put(var17_17.yq, var2_2);
                                    }
                                    var2_2.set(var17_17.SN);
                                }
                                var2_2 = var15_15.values().iterator();
                                while (var2_2.hasNext()) {
                                    if (((BitSet)var2_2.next()).cardinality() != 1) continue;
                                    var7_8 = 1;
                                    break block49;
                                }
                                var7_8 = 0;
                            }
                            ** if (var7_8 != 0) goto lbl-1000
                        }
                        ** GOTO lbl-1000
lbl-1000:
                        // 2 sources

                        {
                            var7_8 = 1;
                            ** GOTO lbl55
                        }
lbl-1000:
                        // 2 sources

                        {
                            var7_8 = 0;
                        }
lbl55:
                        // 2 sources

                        if (var7_8 != 0) {
                            var2_2 = var13_13.SN;
                            var14_14 = nv_0.SN((Q4)var14_14);
                            var11_12 /* !! */  = new BitSet();
                            var14_14 = ((ArrayList)var14_14).iterator();
                            while (var14_14.hasNext()) {
                                var11_12 /* !! */ .or((BitSet)var14_14.next());
                            }
                            var2_2.zH = var11_12 /* !! */ ;
                            var13_13.t0 = true;
                            var13_13.tF = true;
                            var13_13.zH = var13_13.SN.zH.nextSetBit(0);
                        }
                    }
                    if (var13_13.tF && var13_13.SN.i) {
                        var10_11 = this.yq.SN(var1_1.N).SN();
                        var11_12 /* !! */  = var13_13.SN;
                        if (var11_12 /* !! */ .tF != 0) {
                            var2_2 = new BitSet();
                            var2_2.set(var11_12 /* !! */ .tF);
                        } else {
                            var2_2 = var11_12 /* !! */ .zH;
                        }
                        var14_14 = var13_13.SN;
                        var11_12 /* !! */  = new Nv[var10_11 + 1];
                        var14_14 = var14_14.iterator();
                        while (var14_14.hasNext()) {
                            var15_15 = var14_14.next();
                            if (!var2_2.get(var15_15.SN)) continue;
                            var7_8 = var15_15.SN;
                            var11_12 /* !! */ [var7_8] = Nv.zH(var11_12 /* !! */ [var7_8], var15_15.zH);
                        }
                        var8_9 = 0;
                        for (var7_8 = 1; var7_8 <= var10_11; ++var7_8) {
                            if (var11_12 /* !! */ [var7_8] == null) {
                                var11_12 /* !! */ [var7_8] = Nv.yq;
                                var9_10 = var8_9;
                            } else {
                                var9_10 = var8_9;
                                if (var11_12 /* !! */ [var7_8] != Nv.yq) {
                                    var9_10 = var8_9 + 1;
                                }
                            }
                            var8_9 = var9_10;
                        }
                        if (var8_9 == 0) {
                            var11_12 /* !! */  = null;
                        }
                        if (var11_12 /* !! */  != null) {
                            var14_14 = new ArrayList<E>();
                            var8_9 = 0;
                            for (var7_8 = 1; var7_8 < var11_12 /* !! */ .length; ++var7_8) {
                                var15_15 = var11_12 /* !! */ [var7_8];
                                if (var2_2 != null && var2_2.get(var7_8)) {
                                    var14_14.add(new Mx.yq((Nv)var15_15, var7_8));
                                }
                                if (var15_15 == Nv.yq) continue;
                                var8_9 = 1;
                            }
                            var2_2 = var8_9 == 0 ? null : var14_14.toArray(new Mx.yq[var14_14.size()]);
                            var13_13.Gc = var2_2;
                            var13_13.zH = 0;
                        } else {
                            var13_13.zH = var2_2.nextSetBit(0);
                        }
                        if (var13_13.Gc != null) {
                            var13_13.zH = 0;
                        }
                    }
                    var2_2 = this.N((QY)var1_1, (Mx)var12_7 /* !! */ , var6_6, (Mx)var13_13);
                }
                if (var2_2 == XO.N) {
                    var1_1 = this.F5((lC)var3_3, var5_5, var12_7 /* !! */ .SN, var4_4);
                    var3_3.zH(var4_4);
                    var4_4 = this.G4(var12_7 /* !! */ .SN, var5_5);
                    if (var4_4 != 0) {
                        return var4_4;
                    }
                    throw var1_1;
                }
                if (!var2_2.t0) break block54;
                var11_12 /* !! */  = var2_2.SN.zH;
                if (var2_2.Gc != null) {
                    var6_6 = var3_3.Gc();
                    if (var6_6 != var4_4) {
                        var3_3.zH(var4_4);
                    }
                    if ((var11_12 /* !! */  = this.KJ(var2_2.Gc, var5_5)).cardinality() == 1) {
                        return var11_12 /* !! */ .nextSetBit(0);
                    }
                    if (var6_6 != var4_4) {
                        var3_3.zH(var6_6);
                    }
                }
                var12_7 /* !! */  = this.M(var1_1.tF, var5_5, true);
                var2_2 = var2_2.SN;
                var6_6 = var3_3.Gc();
                var13_13 = this.tF;
                if (var13_13 != null) {
                    var13_13 = var13_13.zH();
                    var14_14 = this.tF;
                    ((rg)var13_13).tF((Tu)var14_14, (QY)var1_1, var4_4, var6_6, (BitSet)var11_12 /* !! */ , (Q4)var2_2);
                }
                var3_3.zH(var4_4);
                var6_6 = var3_3.t0(1);
                var2_2 = var12_7 /* !! */ ;
                while (true) {
                    block59: {
                        block56: {
                            block58: {
                                block57: {
                                    block55: {
                                        if ((var11_12 /* !! */  = this.Gc((Q4)var2_2, var6_6, true)) != null) break block55;
                                        var1_1 = this.F5((lC)var3_3, var5_5, (Q4)var2_2, var4_4);
                                        var3_3.zH(var4_4);
                                        var6_6 = this.G4((Q4)var2_2, var5_5);
                                        if (var6_6 == 0) {
                                            throw var1_1;
                                        }
                                        break block56;
                                    }
                                    var2_2 = nv_0.SN((Q4)var11_12 /* !! */ );
                                    var11_12 /* !! */ .tF = var7_8 = md.dT((Q4)var11_12 /* !! */ );
                                    if (var7_8 == 0) break block57;
                                    var6_6 = var7_8;
                                    break block58;
                                }
                                var7_8 = nv_0.N((Collection<BitSet>)var2_2);
                                if (var7_8 == 0) break block59;
                                var6_6 = var7_8;
                            }
                            var7_8 = var11_12 /* !! */ .tF;
                            var8_9 = var3_3.Gc();
                            if (var7_8 != 0) {
                                var2_2 = this.tF;
                                if (var2_2 != null) {
                                    var3_3 = var2_2.zH();
                                    var2_2 = this.tF;
                                    ((rg)var3_3).N((Tu)var2_2, (QY)var1_1, var4_4, var8_9, var6_6, (Q4)var11_12 /* !! */ );
                                }
                            } else {
                                var3_3 = new BitSet();
                                var2_2 = var11_12 /* !! */ .N.iterator();
                                while (var2_2.hasNext()) {
                                    var3_3.set(((C)var2_2.next()).SN);
                                }
                                this.v3((QY)var1_1, var4_4, var8_9, (BitSet)var3_3, (Q4)var11_12 /* !! */ );
                            }
                        }
                        return var6_6;
                    }
                    var7_8 = var6_6;
                    if (var6_6 != -1) {
                        var3_3.KJ();
                        var7_8 = var3_3.t0(1);
                    }
                    var2_2 = var11_12 /* !! */ ;
                    var6_6 = var7_8;
                }
            }
            if (var2_2.tF) {
                if (var2_2.Gc == null) {
                    return var2_2.zH;
                }
                var6_6 = var3_3.Gc();
                var3_3.zH(var4_4);
                var11_12 /* !! */  = this.KJ(var2_2.Gc, var5_5);
                var7_8 = var11_12 /* !! */ .cardinality();
                if (var7_8 != 0) {
                    if (var7_8 != 1) {
                        this.v3((QY)var1_1, var4_4, var6_6, (BitSet)var11_12 /* !! */ , var2_2.SN);
                        return var11_12 /* !! */ .nextSetBit(0);
                    }
                    return var11_12 /* !! */ .nextSetBit(0);
                }
                throw this.F5((lC)var3_3, var5_5, var2_2.SN, var4_4);
            }
            if (var6_6 != -1) {
                var3_3.KJ();
                var6_6 = var3_3.t0(1);
            }
            var12_7 /* !! */  = var2_2;
        }
    }

    protected final T9 F5(lC lC2, ei_0 ei_02, Q4 q4, int n2) {
        return new T9(this.tF, lC2, lC2.get(n2), lC2.i(1), ei_02);
    }

    protected final int G(Q4 object) {
        aq aq2 = new aq(new int[0]);
        object = ((Q4)object).iterator();
        while (object.hasNext()) {
            C c = (C)object.next();
            if (c.SN() <= 0 && (!(c.yq instanceof Wo) || !c.N.zH())) continue;
            aq2.yq(c.SN);
        }
        if (aq2.KJ() == 0) {
            return 0;
        }
        return aq2.zH();
    }

    protected final int G4(Q4 object, ei_0 ei_02) {
        Q4 q4 = new Q4(((Q4)object).Gc);
        Q4 q42 = new Q4(((Q4)object).Gc);
        object = ((Q4)object).iterator();
        while (object.hasNext()) {
            C c = (C)object.next();
            Nv nv = c.zH;
            if (nv != Nv.yq && !this.q(nv, ei_02)) {
                q42.yq(c, null);
                continue;
            }
            q4.yq(c, null);
        }
        int n2 = this.G(q4);
        if (n2 != 0) {
            return n2;
        }
        if (q42.size() > 0 && (n2 = this.G(q42)) != 0) {
            return n2;
        }
        return 0;
    }

    /*
     * Unable to fully structure code
     */
    protected final Q4 Gc(Q4 var1_1, int var2_2, boolean var3_3) {
        block20: {
            block21: {
                block19: {
                    if (this.i == null) {
                        this.i = new le_1<Key1, Key2, Value>();
                    }
                    var10_4 = new Q4(var3_3);
                    var9_5 = var1_1.iterator();
                    var8_6 = null;
                    block0: while (true) {
                        var7_10 = var9_5.hasNext();
                        var4_7 = 0;
                        var5_8 = 0;
                        if (!var7_10) break;
                        var11_11 = var9_5.next();
                        var1_1 = var11_11.yq;
                        if (var1_1 instanceof Wo) {
                            if (!var3_3 && var2_2 != -1) continue;
                            var1_1 = var8_6;
                            if (var8_6 == null) {
                                var1_1 = new ArrayList<E>();
                            }
                            var1_1.add((Object)var11_11);
                            var8_6 = var1_1;
                            continue;
                        }
                        var6_9 = var1_1.SN();
                        var4_7 = var5_8;
                        while (true) {
                            if (var4_7 < var6_9) ** break;
                            continue block0;
                            var1_1 = var11_11.yq.tF(var4_7);
                            var1_1 = var1_1.tF(var2_2, this.yq.i) != false ? var1_1.yq : null;
                            if (var1_1 != null) {
                                var10_4.yq(new C((C)var11_11, (j)var1_1, var11_11.N, var11_11.zH), this.i);
                            }
                            ++var4_7;
                        }
                        break;
                    }
                    var1_1 = var8_6 == null && var2_2 != -1 && (var10_4.size() == 1 || md.dT((Q4)var10_4) != 0) ? var10_4 : null;
                    if (var1_1 == null) {
                        var1_1 = new Q4(var3_3);
                        var11_11 = new HashSet<E>();
                        var7_10 = var2_2 == -1;
                        var9_5 = var10_4.iterator();
                        while (var9_5.hasNext()) {
                            this.i((C)var9_5.next(), (Q4)var1_1, (Set<C>)var11_11, false, var3_3, 0, var7_10);
                        }
                    }
                    var9_5 = var1_1;
                    if (var2_2 == -1) {
                        var2_2 = var1_1 == var10_4 ? 1 : 0;
                        if (nv_0.yq((Q4)var1_1)) {
                            var9_5 = var1_1;
                        } else {
                            var9_5 = new Q4(var1_1.Gc);
                            var1_1 = var1_1.iterator();
                            while (var1_1.hasNext()) {
                                var11_11 = var1_1.next();
                                var10_4 = var11_11.yq;
                                if (var10_4 instanceof Wo) {
                                    var9_5.yq((C)var11_11, this.i);
                                    continue;
                                }
                                if (var2_2 == 0 || !var10_4.tF || !this.yq.zH((j)var10_4).tF(-2)) continue;
                                var9_5.yq(new C((C)var11_11, this.yq.tF[var11_11.yq.N], var11_11.N, var11_11.zH), this.i);
                            }
                        }
                    }
                    if (var8_6 == null) break block20;
                    if (!var3_3) break block21;
                    var1_1 = var9_5.iterator();
                    do {
                        var2_2 = var4_7;
                        if (!var1_1.hasNext()) break block19;
                    } while (!(((C)var1_1.next()).yq instanceof Wo));
                    var2_2 = 1;
                }
                if (var2_2 != 0) break block20;
            }
            var1_1 = var8_6.iterator();
            while (var1_1.hasNext()) {
                var9_5.yq((C)var1_1.next(), this.i);
            }
        }
        if (var9_5.isEmpty()) {
            return null;
        }
        return var9_5;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected final BitSet KJ(Mx.yq[] yqArray, ei_0 ei_02) {
        BitSet bitSet = new BitSet();
        int n2 = yqArray.length;
        int n3 = 0;
        while (n3 < n2) {
            Mx.yq yq2 = yqArray[n3];
            Nv nv = yq2.yq;
            if (nv == Nv.yq || this.q(nv, ei_02)) {
                bitSet.set(yq2.SN);
            }
            ++n3;
        }
        return bitSet;
    }

    protected final Q4 M(j j3, ly_1 object, boolean bl) {
        object = CK.yq(this.yq, (ly_1)object);
        Q4 q4 = new Q4(bl);
        int n2 = 0;
        while (n2 < j3.SN()) {
            j j4 = j3.tF((int)n2).yq;
            this.i(new C(j4, ++n2, (CK)object, (Nv)Nv.yq), q4, new HashSet<C>(), true, bl, 0, false);
        }
        return q4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final Mx N(QY object, Mx mx, int n2, Mx mx2) {
        if (mx2 == null) {
            return null;
        }
        object = this.tF((QY)object, mx2);
        if (n2 < -1) return object;
        if (n2 > this.yq.i) {
            return object;
        }
        synchronized (mx) {
            if (mx.N == null) {
                mx.N = new Mx[this.yq.i + 1 + 1];
            }
            mx.N[n2 + 1] = object;
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final int SN(lC lC2, int n2, ei_0 object) {
        QY qY;
        this.t0 = lC2;
        this.Gc = lC2.Gc();
        this.M = object;
        this.KJ = qY = this.zH[n2];
        lC2.N();
        n2 = this.Gc;
        try {
            Object object2 = qY.SN() ? qY.yq(this.tF.F5()) : qY.SN;
            Mx mx = object2;
            Object object3 = object;
            if (object2 == null) {
                object2 = object;
                if (object == null) {
                    object2 = ly_1.N;
                }
                object = this.M(qY.tF, ly_1.N, false);
                if (qY.SN()) {
                    qY.SN.SN = object;
                    object = this.zH((Q4)object);
                    mx = new Mx((Q4)object);
                    mx = this.tF(qY, mx);
                    qY.N(this.tF.F5(), mx);
                    object3 = object2;
                } else {
                    mx = new Mx((Q4)object);
                    qY.SN = mx = this.tF(qY, mx);
                    object3 = object2;
                }
            }
            int n3 = this.B(qY, mx, lC2, n2, (ei_0)object3);
            return n3;
        }
        finally {
            this.i = null;
            this.KJ = null;
            lC2.zH(n2);
            lC2.yq();
        }
    }

    protected final void i(C c, Q4 q4, Set<C> set, boolean bl, boolean bl2, int n2, boolean bl3) {
        if (c.yq instanceof Wo) {
            if (!c.N.i()) {
                for (int i2 = 0; i2 < c.N.Gc(); ++i2) {
                    if (c.N.tF(i2) == Integer.MAX_VALUE) {
                        if (bl2) {
                            q4.yq(new C(c, c.yq, (CK)CK.SN, c.zH), this.i);
                            continue;
                        }
                        this.t0(c, q4, set, bl, bl2, n2, bl3);
                        continue;
                    }
                    Object object = (j)((ArrayList)this.yq.yq).get(c.N.tF(i2));
                    CK cK = c.N.N(i2);
                    object = new C((j)object, c.SN, cK, c.zH);
                    ((C)object).tF = c.tF;
                    this.i((C)object, q4, set, bl, bl2, n2 - 1, bl3);
                }
                return;
            }
            if (bl2) {
                q4.yq(c, this.i);
                return;
            }
        }
        this.t0(c, q4, set, bl, bl2, n2, bl3);
    }

    protected final boolean q(Nv nv, ei_0 ei_02) {
        return nv.N(this.tF, ei_02);
    }

    /*
     * Unable to fully structure code
     */
    protected final void t0(C var1_1, Q4 var2_2, Set<C> var3_3, boolean var4_4, boolean var5_5, int var6_6, boolean var7_7) {
        var16_8 = var1_1.yq;
        if (!var16_8.tF) {
            var2_2.yq(var1_1, this.i);
        }
        for (var9_9 = 0; var9_9 < var16_8.SN(); ++var9_9) {
            block29: {
                block28: {
                    if (var9_9 == 0) {
                        if (!md.q && (var18_18 = var1_1.yq).N() == 10 && ((si_0)var18_18).KJ && !var1_1.N.i() && !var1_1.N.zH()) {
                            var10_11 = var1_1.N.Gc();
                            for (var8_10 = 0; var8_10 < var10_11; ++var8_10) {
                                if (((j)this.yq.yq.get((int)var1_1.N.tF((int)var8_10))).N == var18_18.N) {
                                    continue;
                                }
                                ** break block27
                            }
                            var8_10 = ((j2)var18_18.tF((int)0).yq).M.SN;
                            var17_17 = (e_0)this.yq.yq.get(var8_10);
                            for (var8_10 = 0; var8_10 < var10_11; ++var8_10) {
                                var11_12 = var1_1.N.tF(var8_10);
                                var15_16 = (j)this.yq.yq.get(var11_12);
                                if (var15_16.SN() != 1 || !var15_16.tF(0).SN()) ** break block27
                                var14_15 = var15_16.tF((int)0).yq;
                                if (var15_16.N() == 8 && var14_15 == var18_18 || var15_16 == var17_17 || var14_15 == var17_17 || var14_15.N() == 8 && var14_15.SN() == 1 && var14_15.tF(0).SN() && var14_15.tF((int)0).yq == var18_18) {
                                    continue;
                                }
                                ** break block27
                            }
                            var8_10 = 1;
                        } else lbl-1000:
                        // 4 sources

                        {
                            var8_10 = 0;
                        }
                        if (var8_10 != 0) continue;
                    }
                    var12_13 = (var17_17 = var16_8.tF(var9_9)) instanceof ue == false && var4_4 != false;
                    var8_10 = var6_6 == 0 ? 1 : 0;
                    var10_11 = var17_17.yq();
                    var15_16 = null;
                    if (var10_11 == 10) break block28;
                    switch (var10_11) {
                        default: {
                            var14_15 = var15_16;
                            break block29;
                        }
                        case 6: {
                            var14_15 = new C(var1_1, ((ue)var17_17).yq, var1_1.N, var1_1.zH);
                            break;
                        }
                        case 4: {
                            var15_16 = (Wt)var17_17;
                            if (!var12_13 || (var13_14 = var15_16.tF) && (!var13_14 || var8_10 == 0)) ** GOTO lbl53
                            if (var5_5) {
                                var8_10 = this.t0.Gc();
                                this.t0.zH(this.Gc);
                                Objects.requireNonNull(this.tF);
                                this.t0.zH(var8_10);
                                var14_15 = new C(var1_1, var15_16.yq, var1_1.N, var1_1.zH);
                                break;
                            }
                            var14_15 = Nv.SN(var1_1.zH, new Nv.zH(var15_16.SN, var15_16.N, var13_14));
                            var14_15 = new C(var1_1, var15_16.yq, var1_1.N, (Nv)var14_15);
                            break block29;
lbl53:
                            // 1 sources

                            var14_15 = new C(var1_1, var15_16.yq, var1_1.N, var1_1.zH);
                            break;
                        }
                        case 3: {
                            var14_15 = (Os)var17_17;
                            var15_16 = var14_15.N;
                            var15_16 = SY.M(var1_1.N, var15_16.SN);
                            var14_15 = new C(var1_1, var14_15.yq, (CK)var15_16, var1_1.zH);
                            break block29;
                        }
                        case 2: 
                        case 5: 
                        case 7: {
                            var14_15 = var15_16;
                            if (var7_7) {
                                var14_15 = var15_16;
                                if (var17_17.tF(-1, 1)) {
                                    var14_15 = new C(var1_1, var17_17.yq, var1_1.N, var1_1.zH);
                                    break;
                                }
                            }
                            break block29;
                        }
                        case 1: {
                            var14_15 = new C(var1_1, var17_17.yq, var1_1.N, var1_1.zH);
                            break;
                        }
                    }
                    break block29;
                }
                var18_18 = (mZ)var17_17;
                if (var12_13 && var8_10 != 0) {
                    if (var5_5) {
                        var8_10 = this.t0.Gc();
                        this.t0.zH(this.Gc);
                        var10_11 = var18_18.SN;
                        var13_14 = this.tF.Gc(var10_11);
                        this.t0.zH(var8_10);
                        var14_15 = var15_16;
                        if (var13_14) {
                            var14_15 = new C(var1_1, var18_18.yq, var1_1.N, var1_1.zH);
                        }
                    } else {
                        var14_15 = Nv.SN(var1_1.zH, new Nv.tF(var18_18.SN));
                        var14_15 = new C(var1_1, var18_18.yq, var1_1.N, (Nv)var14_15);
                    }
                } else {
                    var14_15 = new C(var1_1, var18_18.yq, var1_1.N, var1_1.zH);
                }
            }
            if (var14_15 == null) continue;
            if (var1_1.yq instanceof Wo) {
                var15_16 = this.KJ;
                if (var15_16 != null && var15_16.SN() && ((zn_0)var17_17).zH() == this.KJ.tF.N) {
                    var14_15.tF |= 0x40000000;
                }
                ++var14_15.tF;
                if (!var3_3.add((C)var14_15)) continue;
                var2_2.t0 = true;
                var8_10 = var6_6 - 1;
            } else {
                if (!var17_17.SN() && !var3_3.add((C)var14_15)) continue;
                var8_10 = var17_17 instanceof Os != false && var6_6 >= 0 ? var6_6 + 1 : var6_6;
            }
            this.i((C)var14_15, var2_2, var3_3, var12_13, var5_5, var8_10, var7_7);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final Mx tF(QY qY, Mx mx) {
        if (mx == XO.N) {
            return mx;
        }
        Map<Mx, Mx> map = qY.yq;
        synchronized (map) {
            Object object = (Mx)((HashMap)qY.yq).get(mx);
            if (object != null) {
                return object;
            }
            mx.yq = ((HashMap)qY.yq).size();
            object = mx.SN;
            if (!((Q4)object).yq) {
                ((Q4)object).SN(this);
                object = mx.SN;
                ((Q4)object).yq = true;
                ((Q4)object).SN = null;
            }
            ((HashMap)qY.yq).put(mx, mx);
            return mx;
        }
    }

    protected final void v3(QY qY, int n2, int n3, BitSet bitSet, Q4 q4) {
        Object object = this.tF;
        if (object != null) {
            object = ((VQ)object).zH();
            Tu tu = this.tF;
            ((rg)object).SN(tu, qY, n2, n3, bitSet, q4);
        }
    }

    @Override
    public final void yq() {
    }

    protected final Q4 zH(Q4 object) {
        Object object2;
        HashMap<Integer, CK> hashMap = new HashMap<Integer, CK>();
        Q4 q4 = new Q4(((Q4)object).Gc);
        Object object3 = ((Q4)object).iterator();
        while (object3.hasNext()) {
            C c = object3.next();
            if (c.SN != 1 || (object2 = c.zH.tF(this.tF, this.M)) == null) continue;
            hashMap.put(c.yq.SN, c.N);
            if (object2 != c.zH) {
                q4.yq(new C(c, c.yq, c.N, (Nv)object2), this.i);
                continue;
            }
            q4.yq(c, this.i);
        }
        object2 = ((Q4)object).iterator();
        while (object2.hasNext()) {
            object = object2.next();
            if (((C)object).SN == 1 || !((C)object).N() && (object3 = (CK)hashMap.get(((C)object).yq.SN)) != null && ((CK)object3).equals(((C)object).N)) continue;
            q4.yq((C)object, this.i);
        }
        return q4;
    }
}

