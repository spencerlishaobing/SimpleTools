/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Bd;
import com.github.catvod.spider.merge.C;
import com.github.catvod.spider.merge.CK;
import com.github.catvod.spider.merge.Mx;
import com.github.catvod.spider.merge.Os;
import com.github.catvod.spider.merge.Q4;
import com.github.catvod.spider.merge.QY;
import com.github.catvod.spider.merge.SY;
import com.github.catvod.spider.merge.Wo;
import com.github.catvod.spider.merge.Wt;
import com.github.catvod.spider.merge.XO;
import com.github.catvod.spider.merge.Yv;
import com.github.catvod.spider.merge.hB;
import com.github.catvod.spider.merge.j;
import com.github.catvod.spider.merge.jy_0;
import com.github.catvod.spider.merge.ku_0;
import com.github.catvod.spider.merge.lF;
import com.github.catvod.spider.merge.q2;
import com.github.catvod.spider.merge.sD;
import com.github.catvod.spider.merge.uc_1;
import com.github.catvod.spider.merge.ue;
import com.github.catvod.spider.merge.zW;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public final class N2
extends XO {
    public final QY[] Gc;
    protected final yq KJ = new yq();
    protected int M = 0;
    protected int i = 1;
    protected int t0 = 0;
    protected final Bd tF;
    protected int zH = -1;

    public N2(Bd bd, lF lF2, QY[] qYArray, ku_0 ku_02) {
        super(lF2, ku_02);
        this.Gc = qYArray;
        this.tF = bd;
    }

    public final int Gc() {
        return this.i;
    }

    protected final int KJ(q2 q22) {
        Object object;
        j j3 = (j)((ArrayList)this.yq.M).get(this.M);
        hB hB2 = CK.SN;
        sD sD2 = new sD();
        int n2 = 0;
        while (n2 < j3.SN()) {
            object = j3.tF((int)n2).yq;
            this.tF(q22, new uc_1((j)object, ++n2, (CK)hB2), sD2, false, false, false);
        }
        boolean bl = sD2.i;
        sD2.i = false;
        object = this.N(sD2);
        if (!bl) {
            this.Gc[this.M].SN = object;
        }
        return this.i(q22, (Mx)object);
    }

    public final int M(q2 q22, int n2) {
        this.M = n2;
        q22.N();
        try {
            this.zH = q22.Gc();
            Object object = this.KJ;
            ((yq)object).yq = -1;
            ((yq)object).SN = 0;
            ((yq)object).N = -1;
            ((yq)object).tF = null;
            object = this.Gc[n2];
            if (((QY)object).SN == null) {
                n2 = this.KJ(q22);
                return n2;
            }
            n2 = this.i(q22, ((QY)object).SN);
            return n2;
        }
        finally {
            q22.yq();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final Mx N(Q4 q4) {
        Object object2;
        Mx mx;
        block6: {
            mx = new Mx(q4);
            for (Object object2 : q4) {
                if (!(((C)object2).yq instanceof Wo)) continue;
                break block6;
            }
            object2 = null;
        }
        if (object2 != null) {
            mx.tF = true;
            mx.i = ((uc_1)object2).zH();
            mx.zH = this.yq.t0[((C)object2).yq.N];
        }
        QY qY = this.Gc[this.M];
        object2 = qY.yq;
        synchronized (object2) {
            Mx mx2 = (Mx)((HashMap)qY.yq).get(mx);
            if (mx2 != null) {
                return mx2;
            }
            mx.yq = ((HashMap)qY.yq).size();
            q4.yq = true;
            q4.SN = null;
            mx.SN = q4;
            ((HashMap)qY.yq).put(mx, mx);
            return mx;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final void SN(Mx mx, int n2, Mx mx2) {
        if (n2 < 0) return;
        if (n2 > 127) {
            return;
        }
        synchronized (mx) {
            if (mx.N == null) {
                mx.N = new Mx[128];
            }
            mx.N[n2 + 0] = mx2;
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    protected final int i(q2 var1_1, Mx var2_2) {
        if (var2_2 /* !! */ .tF) {
            var10_3 /* !! */  = this.KJ;
            var10_3 /* !! */ .yq = var1_1.Gc();
            var10_3 /* !! */ .SN = this.i;
            var10_3 /* !! */ .N = this.t0;
            var10_3 /* !! */ .tF = var2_2 /* !! */ ;
        }
        var5_4 = var1_1.t0(1);
        var11_5 = var2_2 /* !! */ ;
        while (true) {
            block20: {
                block23: {
                    block22: {
                        block21: {
                            block19: {
                                var2_2 /* !! */  = (var2_2 /* !! */  = var11_5.N) != null && var5_4 >= 0 && var5_4 <= 127 ? var2_2 /* !! */ [var5_4 + 0] : null;
                                var10_3 /* !! */  = var2_2 /* !! */ ;
                                if (var2_2 /* !! */  != null) ** GOTO lbl51
                                var14_14 = new sD();
                                var15_15 = var11_5.SN.iterator();
                                var3_6 = 0;
                                block1: while (var15_15.hasNext()) {
                                    var2_2 /* !! */  = var15_15.next();
                                    var8_10 = var2_2 /* !! */ .SN == var3_6;
                                    if (var8_10 && ((uc_1)var2_2 /* !! */ ).i()) {
                                        var4_7 = var3_6;
                                    } else {
                                        var6_8 = var2_2 /* !! */ .yq.SN();
                                        var7_9 = 0;
                                        while (true) {
                                            var4_7 = var3_6;
                                            if (var7_9 >= var6_8) break;
                                            var10_3 /* !! */  = var2_2 /* !! */ .yq.tF(var7_9);
                                            var10_3 /* !! */  = var10_3 /* !! */ .tF(var5_4, 0x10FFFF) != false ? var10_3 /* !! */ .yq : null;
                                            if (var10_3 /* !! */  != null) {
                                                var16_16 = (uc_1)var2_2 /* !! */ ;
                                                var12_12 = var13_13 = var16_16.zH();
                                                if (var13_13 != null) {
                                                    var12_12 = var13_13.N(var1_1.Gc() - this.zH);
                                                }
                                                if (this.tF(var1_1, new uc_1(var16_16, (j)var10_3 /* !! */ , var12_12), var14_14, var8_10, true, var9_11 = var5_4 == -1)) {
                                                    var3_6 = var2_2 /* !! */ .SN;
                                                    continue block1;
                                                }
                                            }
                                            ++var7_9;
                                        }
                                    }
                                    var3_6 = var4_7;
                                }
                                if (!var14_14.isEmpty()) {
                                    var8_10 = var14_14.i;
                                    var14_14.i = false;
                                    var2_2 /* !! */  = this.N(var14_14);
                                    if (!var8_10) {
                                        this.SN((Mx)var11_5, var5_4, (Mx)var2_2 /* !! */ );
                                    }
                                } else {
                                    if (!var14_14.i) {
                                        this.SN((Mx)var11_5, var5_4, XO.N);
                                    }
                                    var10_3 /* !! */  = XO.N;
lbl51:
                                    // 2 sources

                                    var2_2 /* !! */  = var10_3 /* !! */ ;
                                }
                                if (var2_2 /* !! */  == XO.N) break block19;
                                if (var5_4 != -1) {
                                    this.zH(var1_1);
                                }
                                if (!var2_2 /* !! */ .tF) break block20;
                                var10_3 /* !! */  = this.KJ;
                                var10_3 /* !! */ .yq = var1_1.Gc();
                                var10_3 /* !! */ .SN = this.i;
                                var10_3 /* !! */ .N = this.t0;
                                var10_3 /* !! */ .tF = var2_2 /* !! */ ;
                                if (var5_4 != -1) break block20;
                            }
                            var2_2 /* !! */  = this.KJ;
                            var10_3 /* !! */  = var2_2 /* !! */ .tF;
                            if (var10_3 /* !! */  == null) break block21;
                            var11_5 = var10_3 /* !! */ .i;
                            var5_4 = this.zH;
                            var4_7 = var2_2 /* !! */ .yq;
                            var3_6 = var2_2 /* !! */ .SN;
                            var6_8 = var2_2 /* !! */ .N;
                            var1_1.zH(var4_7);
                            this.i = var3_6;
                            this.t0 = var6_8;
                            if (var11_5 != null && (var10_3 /* !! */  = this.tF) != null) {
                                var11_5.SN((Bd)var10_3 /* !! */ , var1_1, var5_4);
                            }
                            var3_6 = var2_2 /* !! */ .tF.zH;
                            break block22;
                        }
                        if (var5_4 != -1 || var1_1.Gc() != this.zH) break block23;
                        var3_6 = -1;
                    }
                    return var3_6;
                }
                throw new zW(this.tF, var1_1, this.zH);
            }
            var5_4 = var1_1.t0(1);
            var11_5 = var2_2 /* !! */ ;
        }
    }

    public final int t0() {
        return this.t0;
    }

    protected final boolean tF(q2 q22, uc_1 uc_12, Q4 q4, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4;
        Object object;
        block23: {
            block25: {
                block24: {
                    object = uc_12.yq;
                    boolean bl5 = object instanceof Wo;
                    bl4 = true;
                    if (!bl5) break block23;
                    object = uc_12.N;
                    if (object != null && !((CK)object).zH()) break block24;
                    object = uc_12.N;
                    if (object == null || ((CK)object).i()) break block25;
                    q4.yq(new uc_1(uc_12, uc_12.yq, (CK)CK.SN), null);
                    bl = bl4;
                }
                object = uc_12.N;
                bl4 = bl;
                if (object != null) {
                    bl4 = bl;
                    if (!((CK)object).i()) {
                        for (int i2 = 0; i2 < uc_12.N.Gc(); ++i2) {
                            bl4 = bl;
                            if (uc_12.N.tF(i2) != Integer.MAX_VALUE) {
                                object = uc_12.N.N(i2);
                                bl4 = this.tF(q22, new uc_1(uc_12, (j)((ArrayList)this.yq.yq).get(uc_12.N.tF(i2)), (CK)object), q4, bl, bl2, bl3);
                            }
                            bl = bl4;
                        }
                        bl4 = bl;
                    }
                }
                return bl4;
            }
            q4.yq(uc_12, null);
            return true;
        }
        if (!(((j)object).tF || bl && uc_12.i())) {
            q4.yq(uc_12, null);
        }
        j j3 = uc_12.yq;
        bl4 = bl;
        for (int i4 = 0; i4 < j3.SN(); ++i4) {
            block26: {
                block27: {
                    object = j3.tF(i4);
                    int n2 = ((Yv)object).yq();
                    if (n2 == 10) break block26;
                    switch (n2) {
                        default: {
                            break;
                        }
                        case 6: {
                            Object object2 = uc_12.N;
                            if (object2 != null && !((CK)object2).zH()) {
                                object = new uc_1(uc_12, ((Yv)object).yq);
                            } else {
                                object2 = jy_0.yq(uc_12.zH(), this.yq.Gc[((ue)object).N]);
                                object = new uc_1(uc_12, ((Yv)object).yq, (jy_0)object2);
                            }
                            break block27;
                        }
                        case 4: {
                            int n3;
                            int n4;
                            Object object2 = (Wt)object;
                            q4.i = true;
                            if (this.tF != null && bl2) {
                                n4 = this.t0;
                                n2 = this.i;
                                n3 = q22.Gc();
                                q22.N();
                                this.zH(q22);
                                Objects.requireNonNull(this.tF);
                            }
                            object = new uc_1(uc_12, ((Yv)object).yq);
                            break block27;
                            finally {
                                this.t0 = n4;
                                this.i = n2;
                                q22.zH(n3);
                                q22.yq();
                            }
                        }
                        case 3: {
                            Object object2 = (Os)object;
                            object2 = SY.M(uc_12.N, ((Os)object2).N.SN);
                            object = new uc_1(uc_12, ((Yv)object).yq, (CK)object2);
                            break block27;
                        }
                        case 2: 
                        case 5: 
                        case 7: {
                            if (!bl3 || !((Yv)object).tF(-1, 0x10FFFF)) break;
                            object = new uc_1(uc_12, ((Yv)object).yq);
                            break block27;
                        }
                        case 1: {
                            object = new uc_1(uc_12, ((Yv)object).yq);
                            break block27;
                        }
                    }
                    object = null;
                }
                bl = bl4;
                if (object != null) {
                    bl = this.tF(q22, (uc_1)object, q4, bl4, bl2, bl3);
                }
                bl4 = bl;
                continue;
            }
            throw new UnsupportedOperationException("Precedence predicates are not supported in lexers.");
        }
        return bl4;
    }

    @Override
    public final void yq() {
        yq yq2 = this.KJ;
        yq2.yq = -1;
        yq2.SN = 0;
        yq2.N = -1;
        yq2.tF = null;
        this.zH = -1;
        this.i = 1;
        this.t0 = 0;
        this.M = 0;
    }

    public final void zH(q2 q22) {
        if (q22.t0(1) == 10) {
            ++this.i;
            this.t0 = 0;
        } else {
            ++this.t0;
        }
        q22.KJ();
    }

    protected static final class yq {
        protected int N = -1;
        protected int SN = 0;
        protected Mx tF;
        protected int yq = -1;

        protected yq() {
        }
    }
}

