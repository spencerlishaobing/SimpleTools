/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.QE;
import com.github.catvod.spider.merge.io;
import com.github.catvod.spider.merge.mu;
import java.util.Queue;

/*
 * Renamed from com.github.catvod.spider.merge.fN
 */
public final class fn_0
implements mu {
    Queue<io> N;
    QE SN;
    String yq;

    public fn_0(QE qE, Queue<io> queue) {
        this.SN = qE;
        this.yq = qE.getName();
        this.N = queue;
    }

    @Override
    public final String getName() {
        return this.yq;
    }

    @Override
    public final void yq(String object, Throwable throwable) {
        object = new io();
        System.currentTimeMillis();
        ((io)object).yq = this.SN;
        Thread.currentThread().getName();
        this.N.add((io)object);
    }
}

