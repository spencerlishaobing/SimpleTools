/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.B8;
import com.github.catvod.spider.merge.DO;
import com.github.catvod.spider.merge.Fw;
import com.github.catvod.spider.merge.NB;
import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.RH;
import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.YG;
import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.ei_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.kH;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.ly_1;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.pv;
import com.github.catvod.spider.merge.we;
import com.github.catvod.spider.merge.wu_0;
import com.github.catvod.spider.merge.xW;
import com.github.catvod.spider.merge.y4;
import java.util.AbstractCollection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public final class N3
extends NB<pv> {
    private af_1 SN;
    private Stack<af_1> yq;

    public N3(kb_0 object) {
        kH.tF(N3.class);
        this.yq = new Stack();
        this.SN = af_1.N((kb_0)object);
        Stack<af_1> stack = this.yq;
        object = af_1.N((kb_0)object);
        ((af_1)object).KJ(this.SN);
        stack.push((af_1)object);
    }

    private af_1 Dr() {
        return this.yq.peek();
    }

    private void g(kb_0 kb_02) {
        this.yq.peek().M(kb_02);
    }

    @Override
    public final Object B(we.ee object) {
        block7: {
            block5: {
                block6: {
                    block4: {
                        block3: {
                            block2: {
                                if (((we.ee)object).G() == null || ((we.ee)object).G().i()) break block2;
                                object = ((we.ee)object).G();
                                break block3;
                            }
                            if (((we.ee)object).G4() == null || ((we.ee)object).G4().i()) break block4;
                            object = ((we.ee)object).G4();
                        }
                        object = object.yq(this);
                        break block5;
                    }
                    if (((ei_0)object).B(39) == null) break block6;
                    object = new pv(((ei_0)object).B(39).getText());
                    ((pv)object).KJ();
                    break block5;
                }
                if (((ei_0)object).B(6) == null) break block7;
                object = (object = ((ei_0)object).B(6).getText()) == null ? null : Double.valueOf((String)object);
                object = new pv(object);
            }
            return object;
        }
        StringBuilder stringBuilder = oi_0.yq("not support variableReference:");
        stringBuilder.append(((ly_1)object).getText());
        object = new RH(stringBuilder.toString());
        throw object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final Object F5(we.dT object) {
        if (!"*".equals(((ly_1)object).getText())) {
            if (((we.dT)object).G4() != null && !((we.dT)object).G4().i()) {
                object = ((we.dT)object).G4();
                return object.yq(this);
            } else {
                if (((we.dT)object).G() == null) return null;
                if (((we.dT)object).G().i()) return null;
                object = ((we.dT)object).G();
            }
            return object.yq(this);
        }
        object = new pv("*");
        ((pv)object).KJ();
        return object;
    }

    @Override
    public final Object G(we.B b2) {
        return ((we.t0)b2.KJ(we.t0.class)).yq(this);
    }

    @Override
    public final Object G4(we.N object) {
        Object object2 = ((ei_0)object).q(we.G.class);
        int n2 = object2.size();
        if (n2 == 1) {
            object = ((Fw)object2.get(0)).yq(this);
        } else {
            object2 = ((Fw)object2.get(0)).yq(this).N();
            String string = null;
            for (int i2 = 1; i2 < ((ei_0)object).tF(); ++i2) {
                Object object3 = ((ei_0)object).N(i2);
                if (object3 instanceof we.G) {
                    object3 = object3.yq(this);
                    if ("+".equals(string)) {
                        double d = (Double)object2;
                        object2 = ((pv)object3).N() + d;
                        continue;
                    }
                    if ("-".equals(string)) {
                        object2 = (Double)object2 - ((pv)object3).N();
                        continue;
                    }
                    object2 = oi_0.yq("syntax error, ");
                    ((StringBuilder)object2).append(((ly_1)object).getText());
                    throw new RH(((StringBuilder)object2).toString());
                }
                string = object3.getText();
            }
            object = new pv(object2);
        }
        return object;
    }

    @Override
    public final Object Gc(we.M ei_022) {
        LinkedList<pv> linkedList = new LinkedList<pv>();
        pv pv2 = ((we.KJ)ei_022.KJ(we.KJ.class)).yq(this);
        for (we.t0 t02 : ei_022.q(we.t0.class)) {
            this.yq.push(af_1.tF(this.Dr()));
            linkedList.add(t02.yq(this));
            this.yq.pop();
        }
        return xW.yq(pv2.t0()).yq(this.Dr(), linkedList);
    }

    @Override
    public final Object Gd(we.zH object) {
        if (((ei_0)object).B(7) != null) {
            object = xW.N(((ei_0)object).B(7).getText()).yq(this.Dr().yq());
        } else if ("@".equals(((ly_1)object).getText())) {
            object = new pv(null);
            ((pv)object).Gc();
        } else {
            object = null;
        }
        return object;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public final Object KJ(we.Nl var1_1) {
        block18: {
            block22: {
                block27: {
                    block26: {
                        block24: {
                            block25: {
                                block23: {
                                    block21: {
                                        block19: {
                                            block20: {
                                                block17: {
                                                    if (var1_1.G() == null || var1_1.G().i()) break block17;
                                                    var1_1 = var1_1.G().yq(this);
                                                    break block18;
                                                }
                                                var4_2 = var1_1.G4();
                                                var3_3 = false;
                                                if (var4_2 == null || var1_1.G4().i() || (var4_2 = var1_1.G4().yq(this)) == null) break block19;
                                                if (!var4_2.G4()) break block20;
                                                this.g(var4_2.tF());
                                                ** GOTO lbl-1000
                                            }
                                            if (var4_2.q()) {
                                                var2_4 = true;
                                                var3_3 = true;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                var2_4 = true;
                                            }
                                            break block21;
                                        }
                                        var2_4 = false;
                                    }
                                    if (var1_1.dT() == null || var1_1.dT().i()) break block22;
                                    var4_2 = var1_1.dT().yq(this);
                                    if (!var3_3) break block23;
                                    var5_5 = this.Dr().yq();
                                    var1_1 = var4_2.t0();
                                    if (this.Dr().i()) {
                                        if (var5_5.size() == 1) {
                                            var5_5 = this.Dr().q();
                                            var4_2 = new StringBuilder();
                                            var4_2.append("[");
                                            var4_2.append((String)var1_1);
                                            var4_2.append("]");
                                            var5_5 = var5_5.cS(var4_2.toString());
                                            var4_2 = new LinkedList<Object>();
                                            var5_5 = var5_5.iterator();
                                            while (var5_5.hasNext()) {
                                                var4_2.add(((hN)var5_5.next()).N((String)var1_1));
                                            }
                                            var1_1 = new pv(var4_2);
                                        } else {
                                            var4_2 = new kb_0();
                                            var7_7 = var5_5.iterator();
                                            while (var7_7.hasNext()) {
                                                var5_5 = (hN)var7_7.next();
                                                var6_9 = new StringBuilder();
                                                var6_9.append("[");
                                                var6_9.append((String)var1_1);
                                                var6_9.append("]");
                                                var4_2.addAll(var5_5.cS(var6_9.toString()));
                                            }
                                            var5_5 = new LinkedList<String>();
                                            var4_2 = var4_2.iterator();
                                            while (var4_2.hasNext()) {
                                                var5_5.add(((hN)var4_2.next()).N((String)var1_1));
                                            }
                                            var1_1 = new pv(var5_5);
                                        }
                                    } else if (var5_5.size() == 1) {
                                        var1_1 = new pv(this.Dr().q().N((String)var1_1));
                                    } else {
                                        var4_2 = new LinkedList<E>();
                                        var5_5 = var5_5.iterator();
                                        while (var5_5.hasNext()) {
                                            var4_2.add(((hN)var5_5.next()).N((String)var1_1));
                                        }
                                        var1_1 = new pv(var4_2);
                                    }
                                    break block18;
                                }
                                if (!var4_2.dT()) break block24;
                                var4_2 = var4_2.t0();
                                var5_6 = this.Dr().yq();
                                if (!this.Dr().i()) break block25;
                                var4_2 = var5_6.i((String)var4_2);
                                break block26;
                            }
                            var5_6 = new kb_0();
                            for (Object var7_8 : this.Dr().yq()) {
                                if (var2_4) {
                                    if (!var7_8.v().equals(var4_2) && !"*".equals(var4_2)) continue;
                                    var5_6.add(var7_8);
                                    continue;
                                }
                                var7_8 = var7_8.J().iterator();
                                while (var7_8.hasNext()) {
                                    var8_11 = (hN)var7_8.next();
                                    if (!var8_11.v().equals(var4_2) && !"*".equals(var4_2)) continue;
                                    var5_6.add(var8_11);
                                }
                            }
                            this.g(var5_6);
                            break block22;
                        }
                        if (!var4_2.G4()) break block27;
                        var4_2 = var4_2.tF();
                    }
                    this.g((kb_0)var4_2);
                    break block22;
                }
                var1_1 = var4_2;
                break block18;
            }
            if (var1_1.F5() != null && var1_1.F5().size() > 0) {
                var1_1 = var1_1.F5().iterator();
                while (var1_1.hasNext()) {
                    this.g(var1_1.next().yq(this).tF());
                }
            }
            var1_1 = new pv(this.Dr().yq());
        }
        return var1_1;
    }

    @Override
    public final Object N(we.OW object) {
        pv pv2 = ((we.O)((ei_0)object).KJ(we.O.class)).yq(this);
        object = ((we.OW)object).t0 == null ? pv2 : new pv(-pv2.N().doubleValue());
        return object;
    }

    @Override
    public final Object Nl(we.Gc gc) {
        return ((we.ee)gc.KJ(we.ee.class)).yq(this);
    }

    @Override
    public final Object O(we.F5 object) {
        object = (we.dT)((ei_0)object).KJ(we.dT.class) != null ? ((we.dT)((ei_0)object).KJ(we.dT.class)).yq(this) : (((ei_0)object).B(5) != null ? xW.SN(((ei_0)object).B(5).getText()).yq(this.Dr()) : null);
        return object;
    }

    @Override
    public final Object OW(we.W ei_02) {
        if (((we.W)ei_02).G() != null && !((we.W)ei_02).G().i()) {
            ei_02 = ((we.W)ei_02).G();
        } else {
            DO dO = ((we.W)ei_02).t0;
            if (dO == null) {
                ei_02 = (we.Gc)ei_02.KJ(we.Gc.class);
            } else {
                if ("//".equals(dO.getText())) {
                    this.Dr().Gc();
                }
                ei_02 = (we.Gd)ei_02.KJ(we.Gd.class);
            }
        }
        return ei_02.yq(this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final Object SN(we.O object) {
        pv pv2;
        pv pv3;
        block16: {
            block17: {
                block13: {
                    block14: {
                        block15: {
                            block11: {
                                block12: {
                                    if (((we.O)object).G() == null && !((we.O)object).G().i()) {
                                        return ((we.O)((ei_0)object).KJ(we.O.class)).yq(this);
                                    }
                                    pv3 = ((we.O)object).G().yq(this);
                                    if (((we.O)object).t0 == null) return pv3;
                                    this.yq.push(af_1.tF(this.Dr().zH()));
                                    pv2 = ((we.O)((ei_0)object).KJ(we.O.class)).yq(this);
                                    this.yq.pop();
                                    if (pv3.G4()) {
                                        if (pv2.G4()) {
                                            ((AbstractCollection)pv3.tF()).addAll(pv2.tF());
                                            return pv3;
                                        } else {
                                            object = new hN("V");
                                            ((hN)object).RQ(pv2.t0());
                                            ((AbstractCollection)pv3.tF()).add(object);
                                        }
                                        return pv3;
                                    }
                                    if (!pv3.W()) break block11;
                                    if (!pv2.G4()) break block12;
                                    object = new hN("V");
                                    break block13;
                                }
                                object = new StringBuilder();
                                ((StringBuilder)object).append(pv3.t0());
                                ((StringBuilder)object).append(pv2.t0());
                                return new pv(((StringBuilder)object).toString());
                            }
                            if (!pv3.B()) break block14;
                            if (pv2.B()) {
                                boolean bl = pv3.yq();
                                return new pv(pv2.yq() | bl);
                            }
                            if (!pv2.G4()) break block15;
                            object = new hN("V");
                            break block13;
                        }
                        if (pv2.W()) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append(pv3.yq());
                            ((StringBuilder)object).append(pv2.t0());
                            return new pv(((StringBuilder)object).toString());
                        }
                        object = oi_0.yq("can not merge val1=");
                        ((StringBuilder)object).append(pv3.yq());
                        ((StringBuilder)object).append(",val2=");
                        ((StringBuilder)object).append(pv2.t0());
                        throw new B8(((StringBuilder)object).toString());
                    }
                    if (!pv3.v3()) break block16;
                    if (pv2.W()) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append(pv3.N());
                        ((StringBuilder)object).append(pv2.t0());
                        return new pv(((StringBuilder)object).toString());
                    }
                    if (!pv2.G4()) break block17;
                    object = new hN("V");
                }
                ((hN)object).RQ(pv3.t0());
                ((AbstractCollection)pv2.tF()).add(object);
                return pv2;
            }
            object = oi_0.yq("can not merge val1=");
            ((StringBuilder)object).append(pv3.N());
            ((StringBuilder)object).append(",val2=");
            ((StringBuilder)object).append(pv2.t0());
            throw new B8(((StringBuilder)object).toString());
        }
        object = new LinkedList();
        if (YG.tF(pv3.t0())) {
            ((LinkedList)object).add(pv3.t0());
        }
        if (!YG.tF(pv2.t0())) return new pv(YG.zH(object, ","));
        ((LinkedList)object).add(pv2.t0());
        return new pv(YG.zH(object, ","));
    }

    @Override
    public final Object W(we.t0 t02) {
        return ((we.v3)t02.KJ(we.v3.class)).yq(this);
    }

    @Override
    public final Object dT(we.G4 object) {
        object = ((ei_0)object).B(7) != null ? new pv(((ei_0)object).B(7).getText()) : new pv(((ei_0)object).B(41).getText());
        ((pv)object).KJ();
        return object;
    }

    @Override
    public final Object ee(we.KJ kJ) {
        return ((we.g9)kJ.KJ(we.g9.class)).yq(this);
    }

    @Override
    public final Object g1(we.v3 object) {
        List<we.tF> list = ((ei_0)object).q(we.tF.class);
        int n2 = list.size();
        if (n2 > 1) {
            object = ((Fw)list.get(0)).yq(this).yq();
            for (int i2 = 1; i2 < list.size(); ++i2) {
                object = (Boolean)object | ((Fw)list.get(i2)).yq(this).yq();
            }
            object = new pv(object);
        } else {
            object = ((Fw)list.get(0)).yq(this);
        }
        return object;
    }

    @Override
    public final Object g9(we.v object) {
        kb_0 kb_02 = new kb_0();
        for (hN hN2 : this.Dr().yq()) {
            Object object2;
            block12: {
                block8: {
                    block11: {
                        block10: {
                            block9: {
                                block7: {
                                    int n2;
                                    long l;
                                    object2 = this.yq;
                                    Object object3 = af_1.SN(hN2);
                                    ((af_1)object3).KJ(this.Dr());
                                    ((Stack)object2).push((af_1)object3);
                                    object2 = ((we.t0)((ei_0)object).KJ(we.t0.class)).yq(this);
                                    this.yq.pop();
                                    if (!((pv)object2).v3()) break block7;
                                    long l2 = l = ((pv)object2).i().longValue();
                                    if (l < 0L) {
                                        if (Objects.equals(hN2.tl(), "JX_TEXT")) {
                                            object2 = hN2.N("EL_SAME_TAG_ALL_NUM");
                                            n2 = YG.SN((CharSequence)object2) ? -1 : Integer.parseInt((String)object2);
                                            l = (long)n2 + l + 1L;
                                        } else {
                                            object2 = this.Dr();
                                            object3 = new kb_0();
                                            hN hN32 = hN2.L();
                                            String string = hN2.tl();
                                            Objects.requireNonNull(hN32);
                                            co_0.i(string);
                                            for (hN hN32 : wu_0.yq(new y4.m_0(U7.KJ(string)), hN32)) {
                                                if (!((AbstractCollection)((af_1)object2).yq()).contains(hN32)) continue;
                                                ((AbstractCollection)object3).add(hN32);
                                            }
                                            l = (long)((AbstractCollection)object3).size() + l + 1L;
                                        }
                                        l2 = l;
                                        if (l < 0L) {
                                            l2 = 1L;
                                        }
                                    }
                                    if (!(Objects.equals(hN2.tl(), "JX_TEXT") ? l2 == (long)(n2 = YG.SN((CharSequence)(object2 = hN2.N("EL_SAME_TAG_INDEX"))) ? -1 : Integer.parseInt((String)object2)) : l2 == (long)Nh.KJ(hN2, this.Dr()))) continue;
                                    break block8;
                                }
                                if (!((pv)object2).B()) break block9;
                                if (!((pv)object2).yq().booleanValue()) continue;
                                break block8;
                            }
                            if (!((pv)object2).W()) break block10;
                            if (!YG.tF(((pv)object2).t0())) continue;
                            break block8;
                        }
                        if (!((pv)object2).G4()) break block11;
                        if (((AbstractCollection)((pv)object2).tF()).size() <= 0) continue;
                        break block8;
                    }
                    if (((pv)object2).F5()) {
                        if (((pv)object2).zH().size() <= 0) continue;
                    }
                    break block12;
                }
                ((AbstractCollection)kb_02).add(hN2);
                continue;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("unknown expr val:");
            ((StringBuilder)object).append(object2);
            throw new RH(((StringBuilder)object).toString());
        }
        return new pv(kb_02);
    }

    @Override
    public final Object i(we.Gd gd) {
        Object object = null;
        for (int i2 = 0; i2 < gd.tF(); ++i2) {
            Object object2 = gd.N(i2);
            if (object2 instanceof we.Nl) {
                object = object2 = object2.yq(this);
                if (!((pv)object2).G4()) continue;
                this.g(((pv)object2).tF());
                object = object2;
                continue;
            }
            if ("//".equals(object2.getText())) {
                this.Dr().Gc();
                continue;
            }
            this.Dr().t0();
        }
        return object;
    }

    @Override
    public final Object n(we.SN object) {
        Stack<af_1> stack = this.yq;
        af_1 af_12 = af_1.N(this.SN.yq());
        af_12.KJ(this.Dr());
        stack.push(af_12);
        if (Objects.equals(((we.SN)object).t0.getText(), "//")) {
            this.Dr().Gc();
        }
        object = ((we.Gd)((ei_0)object).KJ(we.Gd.class)).yq(this);
        this.yq.pop();
        return object;
    }

    @Override
    public final Object q(we.tF object) {
        List<we.i> list = ((ei_0)object).q(we.i.class);
        int n2 = list.size();
        if (n2 > 1) {
            object = ((Fw)list.get(0)).yq(this).yq();
            for (int i2 = 1; i2 < list.size(); ++i2) {
                object = (Boolean)object & ((Fw)list.get(i2)).yq(this).yq();
            }
            object = new pv(object);
        } else {
            object = ((Fw)list.get(0)).yq(this);
        }
        return object;
    }

    @Override
    public final Object s(we.g9 object) {
        List<we.G4> list = ((ei_0)object).q(we.G4.class);
        if (list != null) {
            if (list.size() > 1) {
                object = new LinkedList();
                list = list.iterator();
                while (list.hasNext()) {
                    pv pv2 = ((we.G4)list.next()).yq(this);
                    if (pv2 == null) continue;
                    ((LinkedList)object).add(pv2.t0());
                }
                object = new pv(YG.zH(object, ":"));
            } else {
                object = ((Fw)list.get(0)).yq(this);
            }
        } else {
            object = null;
        }
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final Object un(we.xa object) {
        Object object2 = ((ei_0)object).q(we.N.class);
        int n2 = object2.size();
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        if (n2 == 1) {
            return ((Fw)object2.get(0)).yq(this);
        }
        if (object2.size() == 2) {
            Comparable<pv> comparable = ((Fw)object2.get(0)).yq(this);
            object2 = ((Fw)object2.get(1)).yq(this);
            switch (((we.xa)object).t0.getType()) {
                default: {
                    comparable = oi_0.yq("unknown operator");
                    ((StringBuilder)comparable).append(((we.xa)object).t0.getText());
                    throw new RH(((StringBuilder)comparable).toString());
                }
                case 34: {
                    return new pv(((pv)comparable).t0().matches(((pv)object2).t0()) ^ true);
                }
                case 33: {
                    return new pv(((pv)comparable).t0().matches(((pv)object2).t0()));
                }
                case 32: {
                    return new pv(((pv)comparable).t0().contains(((pv)object2).t0()));
                }
                case 31: {
                    return new pv(((pv)comparable).t0().endsWith(((pv)object2).t0()));
                }
                case 30: {
                    return new pv(((pv)comparable).t0().startsWith(((pv)object2).t0()));
                }
                case 27: {
                    if (((pv)comparable).M((pv)object2) >= 0) return new pv(bl4);
                    bl4 = false;
                    return new pv(bl4);
                }
                case 26: {
                    bl4 = ((pv)comparable).M((pv)object2) <= 0 ? bl : false;
                    return new pv(bl4);
                }
                case 25: {
                    bl4 = ((pv)comparable).M((pv)object2) > 0 ? bl2 : false;
                    return new pv(bl4);
                }
                case 24: {
                    bl4 = ((pv)comparable).M((pv)object2) < 0 ? bl3 : false;
                    return new pv(bl4);
                }
            }
        }
        StringBuilder stringBuilder = oi_0.yq("error equalityExpr near:");
        stringBuilder.append(((ly_1)object).getText());
        object = new RH(stringBuilder.toString());
        throw object;
    }

    @Override
    public final Object v(we.yq object) {
        if ("..".equals(((ly_1)object).getText())) {
            object = new HashSet();
            kb_0 kb_02 = new kb_0();
            Iterator iterator = ((AbstractCollection)this.Dr().yq()).iterator();
            while (iterator.hasNext()) {
                ((HashSet)object).add(((hN)iterator.next()).L());
            }
            ((AbstractCollection)kb_02).addAll(object);
            object = new pv(kb_02);
        } else {
            object = new pv(this.Dr().yq());
        }
        return object;
    }

    @Override
    public final Object v3(we.G object) {
        if (((we.G)object).G() != null && !((we.G)object).G().i()) {
            pv pv2 = ((we.OW)((ei_0)object).KJ(we.OW.class)).yq(this);
            Comparable<pv> comparable = ((we.G)object).G().yq(this);
            switch (((we.G)object).t0.getType()) {
                default: {
                    comparable = oi_0.yq("syntax error, ");
                    ((StringBuilder)comparable).append(((ly_1)object).getText());
                    throw new RH(((StringBuilder)comparable).toString());
                }
                case 19: {
                    object = new pv(pv2.N() % ((pv)comparable).N());
                    break;
                }
                case 18: {
                    object = new pv(pv2.N() / ((pv)comparable).N());
                    break;
                }
                case 17: {
                    double d = pv2.N();
                    object = new pv(((pv)comparable).N() * d);
                    break;
                }
            }
        } else {
            object = ((we.OW)((ei_0)object).KJ(we.OW.class)).yq(this);
        }
        return object;
    }

    @Override
    public final Object xa(we.q ei_02) {
        ei_02 = ei_02.G() != null && !ei_02.G().i() ? ei_02.G() : (we.SN)ei_02.KJ(we.SN.class);
        return ei_02.yq(this);
    }

    @Override
    public final Object zH(we.i object) {
        block3: {
            block2: {
                List<we.xa> list;
                block1: {
                    list = ((ei_0)object).q(we.xa.class);
                    if (list.size() != 1) break block1;
                    object = ((Fw)list.get(0)).yq(this);
                    break block2;
                }
                if (list.size() == 2) {
                    pv pv2 = ((Fw)list.get(0)).yq(this);
                    list = ((Fw)list.get(1)).yq(this);
                    object = "=".equals(((we.i)object).t0.getText()) ? (pv2.v().equals(((pv)((Object)list)).v()) ? new pv(pv2.equals(list)) : new pv(Objects.equals(pv2.t0(), ((pv)((Object)list)).t0()))) : (pv2.v().equals(((pv)((Object)list)).v()) ? new pv(pv2.equals(list) ^ true) : new pv(Objects.equals(pv2.t0(), ((pv)((Object)list)).t0()) ^ true));
                }
                break block3;
            }
            return object;
        }
        StringBuilder stringBuilder = oi_0.yq("error equalityExpr near:");
        stringBuilder.append(((ly_1)object).getText());
        throw new RH(stringBuilder.toString());
    }
}

