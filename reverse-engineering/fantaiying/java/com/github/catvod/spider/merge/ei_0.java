/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.DO;
import com.github.catvod.spider.merge.Fw;
import com.github.catvod.spider.merge.QL;
import com.github.catvod.spider.merge.l3;
import com.github.catvod.spider.merge.ly_1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.ei
 */
public class ei_0
extends ly_1 {
    public DO i;
    public List<Fw> tF;
    public DO zH;

    public ei_0() {
    }

    public ei_0(ei_0 ei_02, int n2) {
        super(ei_02, n2);
    }

    public final QL B(int n2) {
        List<Fw> list = this.tF;
        if (list != null && ((ArrayList)list).size() > 0) {
            for (Fw fw : this.tF) {
                if (!(fw instanceof QL) || (fw = (QL)fw).SN().getType() != n2) continue;
                return fw;
            }
        }
        return null;
    }

    public void Gc(l3 l32) {
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final ei_0 KJ(Class object) {
        List<Fw> list = this.tF;
        if (list != null && ((ArrayList)list).size() > 0) {
            for (Fw fw : this.tF) {
                if (!((Class)object).isInstance(fw)) continue;
                object = (Fw)((Class)object).cast(fw);
                break;
            }
        } else {
            object = null;
        }
        return (ei_0)object;
    }

    public void M(l3 l32) {
    }

    @Override
    public final Fw N(int n2) {
        List<Fw> list = this.tF;
        list = list != null && n2 >= 0 && n2 < ((ArrayList)list).size() ? (Fw)((ArrayList)this.tF).get(n2) : null;
        return list;
    }

    public final <T extends ei_0> List<T> q(Class<? extends T> clazz) {
        List<Fw> list = this.tF;
        if (list == null) {
            return Collections.emptyList();
        }
        List<Fw> list2 = null;
        for (Fw fw : list) {
            if (!clazz.isInstance(fw)) continue;
            list = list2;
            if (list2 == null) {
                list = new ArrayList<Fw>();
            }
            list.add((Fw)clazz.cast(fw));
            list2 = list;
        }
        if (list2 == null) {
            return Collections.emptyList();
        }
        return list2;
    }

    public final <T extends Fw> T t0(T t) {
        if (this.tF == null) {
            this.tF = new ArrayList<Fw>();
        }
        ((ArrayList)this.tF).add(t);
        return t;
    }

    @Override
    public final int tF() {
        List<Fw> list = this.tF;
        int n2 = list != null ? ((ArrayList)list).size() : 0;
        return n2;
    }
}

