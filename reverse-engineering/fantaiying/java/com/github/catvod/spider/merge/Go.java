/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.IV;
import com.github.catvod.spider.merge.Ng;
import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.YG;
import com.github.catvod.spider.merge.af_1;
import com.github.catvod.spider.merge.co;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.pv;
import com.github.catvod.spider.merge.rs_0;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Map;

public final class Go
implements co {
    @Override
    public final String name() {
        return "text";
    }

    @Override
    public final pv yq(af_1 object4) {
        kb_0 kb_02;
        block7: {
            Object object2 = ((af_1)object4).yq();
            kb_02 = new kb_0();
            Object object3 = new HashMap();
            if (object2 == null || ((AbstractCollection)object2).size() <= 0) break block7;
            if (((af_1)object4).i()) {
                object2 = ((AbstractCollection)object2).iterator();
                while (object2.hasNext()) {
                    object4 = (hN)object2.next();
                    rs_0.v(new IV((Map)object3, kb_02){
                        final kb_0 SN;
                        final Map yq;
                        {
                            this.yq = map;
                            this.SN = kb_02;
                        }

                        /*
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         */
                        @Override
                        public final void SN(iK object, int n2) {
                            if (object instanceof Ng) {
                                Ng ng = (Ng)object;
                                object = new StringBuilder();
                                ((StringBuilder)object).append(n2);
                                ((StringBuilder)object).append("_");
                                ((StringBuilder)object).append(ng.OW().hashCode());
                                Object object2 = ((StringBuilder)object).toString();
                                object = (Integer)this.yq.get(object2);
                                object = object == null ? Integer.valueOf(1) : Integer.valueOf((Integer)object + 1);
                                this.yq.put(object2, object);
                                hN hN2 = new hN("JX_TEXT");
                                hN2.Qz(ng.E1());
                                hN2.V("EL_DEPTH", (String)object2);
                                try {
                                    object2 = iK.class.getDeclaredMethod("setParentNode", iK.class);
                                    ((AccessibleObject)object2).setAccessible(true);
                                    ((Method)object2).invoke(hN2, ng.OW());
                                }
                                catch (Exception exception) {}
                                Nh.v3(hN2, (Integer)object);
                                ((AbstractCollection)this.SN).add(hN2);
                            }
                        }

                        @Override
                        public final void yq(iK iK2, int n2) {
                        }
                    }, (iK)object4);
                }
                for (Object object4 : kb_02) {
                    Object object5 = ((iK)object4).N("EL_DEPTH");
                    if (!YG.tF((CharSequence)object5) || (object5 = (Integer)((HashMap)object3).get(object5)) == null) continue;
                    Nh.W((hN)object4, (Integer)object5);
                }
            } else {
                object4 = ((AbstractCollection)object2).iterator();
                while (object4.hasNext()) {
                    object3 = (hN)object4.next();
                    if ("script".equals(((hN)object3).v())) {
                        object2 = new hN("JX_TEXT");
                        ((hN)object2).Qz(((hN)object3).lF());
                        Nh.v3((hN)object2, 1);
                        Nh.W((hN)object2, 1);
                        ((AbstractCollection)kb_02).add(object2);
                        continue;
                    }
                    object3 = ((hN)object3).s0();
                    int n2 = 0;
                    while (n2 < object3.size()) {
                        object2 = (Ng)object3.get(n2);
                        hN hN2 = new hN("JX_TEXT");
                        hN2.Qz(((Ng)object2).E1());
                        Nh.v3(hN2, ++n2);
                        Nh.W(hN2, object3.size());
                        ((AbstractCollection)kb_02).add(hN2);
                    }
                }
            }
        }
        return new pv(kb_02);
    }
}

