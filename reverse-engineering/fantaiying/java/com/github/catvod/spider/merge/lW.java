/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.w4;
import java.nio.channels.Pipe;

public final class lW
implements Runnable {
    public final Pipe.SinkChannel N;
    public final boolean SN;
    public final w4 yq;

    public /* synthetic */ lW(w4 w42, Pipe.SinkChannel sinkChannel) {
        this.yq = w42;
        this.SN = false;
        this.N = sinkChannel;
    }

    @Override
    public final void run() {
        w4.tF(this.yq, this.SN, this.N);
    }
}

