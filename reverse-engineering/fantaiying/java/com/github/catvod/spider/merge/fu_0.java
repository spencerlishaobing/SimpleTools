/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Fp;
import com.github.catvod.spider.merge.Kk;
import com.github.catvod.spider.merge.MA;
import com.github.catvod.spider.merge.N3;
import com.github.catvod.spider.merge.Pk;
import com.github.catvod.spider.merge.Rf;
import com.github.catvod.spider.merge.TM;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.lC;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.p0;
import com.github.catvod.spider.merge.pv;
import com.github.catvod.spider.merge.q2;
import com.github.catvod.spider.merge.rs_1;
import com.github.catvod.spider.merge.we;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.fu
 */
public final class fu_0 {
    private kb_0 yq;

    public fu_0(kb_0 kb_02) {
        this.yq = kb_02;
    }

    public final List<Pk> yq(String object32) {
        pv pv2;
        Serializable serializable;
        block20: {
            block19: {
                block18: {
                    block17: {
                        block16: {
                            block15: {
                                block14: {
                                    serializable = new LinkedList();
                                    object32 = Kk.yq((String)object32);
                                    TM object22 = new TM((q2)object32);
                                    object32 = new p0(object22);
                                    we we2 = new we((lC)object32);
                                    object32 = new Rf();
                                    we2.ee((Fp)object32);
                                    we.B b2 = we2.Zm();
                                    object32 = new N3(this.yq);
                                    pv2 = (pv)b2.yq(object32);
                                    if (pv2 != null) break block14;
                                    object32 = new Pk("");
                                    ((LinkedList)serializable).add(object32);
                                    return serializable;
                                }
                                if (!pv2.G4()) break block15;
                                for (Object object32 : pv2.tF()) {
                                    Pk pk = new Pk(object32);
                                    ((LinkedList)serializable).add(pk);
                                }
                                return serializable;
                            }
                            try {
                                if (!pv2.F5()) break block16;
                                for (String string : pv2.zH()) {
                                    object32 = new Pk(string);
                                    ((LinkedList)serializable).add(object32);
                                }
                                return serializable;
                            }
                            catch (Exception exception) {
                                serializable = oi_0.yq("Please check the syntax of your xpath expr or commit a ");
                                ((StringBuilder)serializable).append(rs_1.dT(exception));
                                MA mA = new MA(((StringBuilder)serializable).toString(), exception);
                                throw mA;
                            }
                        }
                        if (!pv2.W()) break block17;
                        String string = pv2.t0();
                        object32 = new Pk(string);
                        ((LinkedList)serializable).add(object32);
                        return serializable;
                    }
                    if (!pv2.v3()) break block18;
                    object32 = pv2.v();
                    if (!((Class)object32).isAssignableFrom(Long.class) && !((Class)object32).isAssignableFrom(Integer.class)) {
                        object32 = new Pk(pv2.N());
                    } else {
                        Long l = pv2.i();
                        object32 = new Pk(l);
                    }
                    ((LinkedList)serializable).add(object32);
                    return serializable;
                }
                if (!pv2.B()) break block19;
                Boolean bl = pv2.yq();
                object32 = new Pk(bl);
                ((LinkedList)serializable).add(object32);
                return serializable;
            }
            if (!pv2.G()) break block20;
            object32 = pv2.SN();
            Pk pk = new Pk(object32);
            ((LinkedList)serializable).add(pk);
            return serializable;
        }
        object32 = pv2.t0();
        Pk pk = new Pk(object32);
        ((LinkedList)serializable).add(pk);
        return serializable;
    }
}

