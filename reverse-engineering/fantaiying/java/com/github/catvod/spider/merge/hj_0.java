/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.QE;
import com.github.catvod.spider.merge.io;
import com.github.catvod.spider.merge.mu;
import com.github.catvod.spider.merge.zh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * Renamed from com.github.catvod.spider.merge.hj
 */
public final class hj_0
implements zh {
    final LinkedBlockingQueue<io> N;
    final Map<String, QE> SN = new HashMap<String, QE>();
    boolean yq = false;

    public hj_0() {
        this.N = new LinkedBlockingQueue();
    }

    public final LinkedBlockingQueue<io> N() {
        return this.N;
    }

    public final void SN() {
        ((HashMap)this.SN).clear();
        this.N.clear();
    }

    public final List<QE> tF() {
        return new ArrayList<QE>(((HashMap)this.SN).values());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final mu yq(String string) {
        synchronized (this) {
            QE qE;
            QE qE2 = qE = (QE)((HashMap)this.SN).get(string);
            if (qE == null) {
                qE2 = new QE(string, this.N, this.yq);
                ((HashMap)this.SN).put(string, qE2);
            }
            return qE2;
        }
    }

    public final void zH() {
        this.yq = true;
    }
}

