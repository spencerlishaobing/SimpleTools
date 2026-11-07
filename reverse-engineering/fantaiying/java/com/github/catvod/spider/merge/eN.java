/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Z4;
import com.github.catvod.spider.merge.oi_0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eN {
    private final List<Z4> SN = Collections.synchronizedList(new ArrayList());
    protected long yq;

    public final void N(Z4 object) {
        ++this.yq;
        this.SN.add((Z4)object);
        Thread thread = new Thread((Runnable)object);
        thread.setDaemon(true);
        object = oi_0.yq("NanoHttpd Request Processor (#");
        ((StringBuilder)object).append(this.yq);
        ((StringBuilder)object).append(")");
        thread.setName(((StringBuilder)object).toString());
        thread.start();
    }

    public final void SN(Z4 z4) {
        this.SN.remove(z4);
    }

    public final void yq() {
        Iterator<Z4> iterator = new ArrayList<Z4>(this.SN).iterator();
        while (iterator.hasNext()) {
            iterator.next().yq();
        }
    }
}

