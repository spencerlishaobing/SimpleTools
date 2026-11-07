/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.SpiderDebug
 */
package com.github.catvod.spider.merge;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.xu_0;

public final class JL
implements Runnable {
    public final int yq;

    public /* synthetic */ JL(int n2) {
        this.yq = n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void run() {
        Exception exception2;
        int n2 = this.yq;
        if (n2 == 0) {
            try {
                N0.Zm().x();
                return;
            }
            catch (Exception exception2) {}
        } else {
            if (n2 == 1) {
                i3.s().cS();
                return;
            }
            if (n2 != 2) return;
            xu_0.xa().p();
            return;
        }
        SpiderDebug.log((Throwable)exception2);
    }
}

