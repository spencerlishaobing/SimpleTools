/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.FE;
import com.github.catvod.spider.merge.qQ;
import com.github.catvod.spider.merge.qX;
import com.github.catvod.spider.merge.ta_1;
import com.github.catvod.spider.merge.wg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class aq
implements qX {
    protected boolean SN;
    protected List<ta_1> yq;

    static {
        aq.t0(0, 0x10FFFF).M();
        new aq(new int[0]).M();
    }

    public aq(int ... nArray) {
        this.yq = new ArrayList<ta_1>(nArray.length);
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.yq(nArray[i2]);
        }
    }

    public static aq q(aq object, aq aq2) {
        aq aq3;
        block6: {
            boolean bl = ((aq)object).i();
            int n2 = 0;
            if (bl) {
                return new aq(new int[0]);
            }
            aq3 = new aq(new int[0]);
            aq3.N((qX)object);
            if (aq2.i()) break block6;
            int n3 = 0;
            while (n2 < ((ArrayList)aq3.yq).size() && n3 < ((ArrayList)aq2.yq).size()) {
                List<ta_1> list;
                block10: {
                    block7: {
                        ta_1 ta_12;
                        block9: {
                            block8: {
                                ta_12 = (ta_1)((ArrayList)aq3.yq).get(n2);
                                object = (ta_1)((ArrayList)aq2.yq).get(n3);
                                int n4 = ((ta_1)object).SN;
                                int n5 = ta_12.yq;
                                if (n4 < n5) break block7;
                                int n7 = ((ta_1)object).yq;
                                int n8 = ta_12.SN;
                                if (n7 > n8) break block8;
                                ta_12 = null;
                                object = n7 > n5 ? new ta_1(n5, n7 - 1) : null;
                                if (n4 < n8) {
                                    ta_12 = new ta_1(n4 + 1, n8);
                                }
                                list = aq3.yq;
                                if (object == null) break block9;
                                ((ArrayList)list).set(n2, (ta_1)object);
                                if (ta_12 == null) break block8;
                                object = aq3.yq;
                                ((ArrayList)object).add(++n2, (ta_1)ta_12);
                                break block7;
                            }
                            ++n2;
                            continue;
                        }
                        if (ta_12 == null) break block10;
                        ((ArrayList)list).set(n2, ta_12);
                    }
                    ++n3;
                    continue;
                }
                ((ArrayList)list).remove(n2);
            }
        }
        return aq3;
    }

    public static aq t0(int n2, int n3) {
        aq aq2 = new aq(new int[0]);
        aq2.SN(n2, n3);
        return aq2;
    }

    public final String B(qQ qQ2) {
        StringBuilder stringBuilder = new StringBuilder();
        List<ta_1> list = this.yq;
        if (list != null && !((ArrayList)list).isEmpty()) {
            if (this.KJ() > 1) {
                stringBuilder.append("{");
            }
            Iterator iterator = ((ArrayList)this.yq).iterator();
            while (iterator.hasNext()) {
                list = (ta_1)iterator.next();
                int n2 = ((ta_1)((Object)list)).yq;
                int n3 = ((ta_1)((Object)list)).SN;
                list = "<EPSILON>";
                if (n2 == n3) {
                    if (n2 == -1) {
                        list = "<EOF>";
                    } else if (n2 != -2) {
                        list = ((FE)qQ2).yq(n2);
                    }
                    stringBuilder.append((String)((Object)list));
                } else {
                    for (int i2 = n2; i2 <= n3; ++i2) {
                        if (i2 > n2) {
                            stringBuilder.append(", ");
                        }
                        list = i2 == -1 ? "<EOF>" : (i2 == -2 ? "<EPSILON>" : ((FE)qQ2).yq(i2));
                        stringBuilder.append((String)((Object)list));
                    }
                }
                if (!iterator.hasNext()) continue;
                stringBuilder.append(", ");
            }
            if (this.KJ() > 1) {
                stringBuilder.append("}");
            }
            return stringBuilder.toString();
        }
        return "{}";
    }

    public final void Gc() {
        if (!this.SN) {
            int n2 = ((ArrayList)this.yq).size();
            for (int i2 = 0; i2 < n2; ++i2) {
                ta_1 ta_12 = (ta_1)((ArrayList)this.yq).get(i2);
                int n3 = ta_12.yq;
                int n4 = ta_12.SN;
                if (-2 < n3) break;
                if (-2 == n3 && -2 == n4) {
                    ((ArrayList)this.yq).remove(i2);
                    break;
                }
                if (-2 == n3) {
                    ta_12.yq = n3 + 1;
                    break;
                }
                if (-2 == n4) {
                    ta_12.SN = n4 - 1;
                    break;
                }
                if (-2 <= n3 || -2 >= n4) continue;
                ta_12.SN = -3;
                this.SN(-1, n4);
            }
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("can't alter readonly IntervalSet");
        throw illegalStateException;
    }

    public final int KJ() {
        int n2 = ((ArrayList)this.yq).size();
        if (n2 == 1) {
            ta_1 ta_12 = (ta_1)((ArrayList)this.yq).get(0);
            return ta_12.SN - ta_12.yq + 1;
        }
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            ta_1 ta_13 = (ta_1)((ArrayList)this.yq).get(i2);
            n3 += ta_13.SN - ta_13.yq + 1;
        }
        return n3;
    }

    public final void M() {
        boolean bl = this.SN;
        this.SN = true;
    }

    public final aq N(qX object) {
        int n2;
        if (object == null) {
            return this;
        }
        boolean bl = object instanceof aq;
        int n3 = 0;
        if (bl) {
            aq aq2 = (aq)object;
            int n4 = ((ArrayList)aq2.yq).size();
            for (n2 = n3; n2 < n4; ++n2) {
                object = (ta_1)((ArrayList)aq2.yq).get(n2);
                this.SN(((ta_1)object).yq, ((ta_1)object).SN);
            }
        } else {
            aq aq3 = (aq)object;
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            int n5 = ((ArrayList)aq3.yq).size();
            for (n2 = 0; n2 < n5; ++n2) {
                object = (ta_1)((ArrayList)aq3.yq).get(n2);
                int n7 = ((ta_1)object).SN;
                for (n3 = ((ta_1)object).yq; n3 <= n7; ++n3) {
                    arrayList.add(n3);
                }
            }
            object = arrayList.iterator();
            while (object.hasNext()) {
                this.yq((Integer)object.next());
            }
        }
        return this;
    }

    public final void SN(int n2, int n3) {
        ta_1 ta_12 = ta_1.SN(n2, n3);
        if (!this.SN) {
            block6: {
                if (ta_12.SN >= ta_12.yq) {
                    ListIterator<ta_1> listIterator = ((ArrayList)this.yq).listIterator();
                    while (listIterator.hasNext()) {
                        ta_1 ta_13 = (ta_1)listIterator.next();
                        if (ta_12.equals(ta_13)) break block6;
                        n2 = ta_12.yq;
                        int n4 = ta_13.SN;
                        n3 = 1;
                        n2 = n2 != n4 + 1 && ta_12.SN != ta_13.yq - 1 ? 0 : 1;
                        if (n2 == 0 && ta_12.yq(ta_13)) {
                            n2 = ta_12.yq;
                            n4 = ta_13.yq;
                            n2 = n2 < n4 && ta_12.SN < n4 ? n3 : 0;
                            if (n2 == 0) continue;
                            listIterator.previous();
                            listIterator.add(ta_12);
                            break block6;
                        }
                        ta_13 = ta_12.N(ta_13);
                        listIterator.set(ta_13);
                        while (listIterator.hasNext()) {
                            ta_12 = (ta_1)listIterator.next();
                            n2 = ta_13.yq != ta_12.SN + 1 && ta_13.SN != ta_12.yq - 1 ? 0 : 1;
                            if (n2 != 0 || !ta_13.yq(ta_12)) {
                                listIterator.remove();
                                listIterator.previous();
                                listIterator.set(ta_13.N(ta_12));
                                listIterator.next();
                                continue;
                            }
                            break block6;
                        }
                        break block6;
                    }
                    ((ArrayList)this.yq).add(ta_12);
                }
            }
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("can't alter readonly IntervalSet");
        throw illegalStateException;
    }

    public final boolean equals(Object object) {
        if (object != null && object instanceof aq) {
            object = (aq)object;
            return this.yq.equals(((aq)object).yq);
        }
        return false;
    }

    public final int hashCode() {
        Iterator iterator = ((ArrayList)this.yq).iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            ta_1 ta_12 = (ta_1)iterator.next();
            n2 = wg.zH(wg.zH(n2, ta_12.yq), ta_12.SN);
        }
        return wg.SN(n2, ((ArrayList)this.yq).size() * 2);
    }

    public final boolean i() {
        List<ta_1> list = this.yq;
        boolean bl = list == null || ((ArrayList)list).isEmpty();
        return bl;
    }

    public final boolean tF(int n2) {
        int n3 = ((ArrayList)this.yq).size() - 1;
        int n4 = 0;
        while (n4 <= n3) {
            int n5 = (n4 + n3) / 2;
            ta_1 ta_12 = (ta_1)((ArrayList)this.yq).get(n5);
            int n7 = ta_12.yq;
            if (ta_12.SN < n2) {
                n4 = n5 + 1;
                continue;
            }
            if (n7 > n2) {
                n3 = n5 - 1;
                continue;
            }
            return true;
        }
        return false;
    }

    public final String toString() {
        CharSequence charSequence = new StringBuilder();
        List<ta_1> list = this.yq;
        if (list != null && !((ArrayList)list).isEmpty()) {
            if (this.KJ() > 1) {
                ((StringBuilder)charSequence).append("{");
            }
            list = ((ArrayList)this.yq).iterator();
            while (list.hasNext()) {
                ta_1 ta_12 = (ta_1)list.next();
                int n2 = ta_12.yq;
                int n3 = ta_12.SN;
                if (n2 == n3) {
                    if (n2 == -1) {
                        ((StringBuilder)charSequence).append("<EOF>");
                    } else {
                        ((StringBuilder)charSequence).append(n2);
                    }
                } else {
                    ((StringBuilder)charSequence).append(n2);
                    ((StringBuilder)charSequence).append("..");
                    ((StringBuilder)charSequence).append(n3);
                }
                if (!list.hasNext()) continue;
                ((StringBuilder)charSequence).append(", ");
            }
            if (this.KJ() > 1) {
                ((StringBuilder)charSequence).append("}");
            }
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "{}";
        }
        return charSequence;
    }

    public final void yq(int n2) {
        if (!this.SN) {
            this.SN(n2, n2);
            return;
        }
        throw new IllegalStateException("can't alter readonly IntervalSet");
    }

    public final int zH() {
        if (!this.i()) {
            return ((ta_1)((ArrayList)this.yq).get((int)0)).yq;
        }
        throw new RuntimeException("set is empty");
    }
}

