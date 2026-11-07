/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.SpiderDebug
 *  test.MainActivity
 */
package com.github.catvod.spider.merge;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.Music;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.QB;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.xu_0;
import java.util.concurrent.atomic.AtomicReference;
import test.MainActivity;

public final class Jb
implements Runnable {
    public final Object SN;
    public final int yq;

    public /* synthetic */ Jb(Object object, int n2) {
        this.yq = n2;
        this.SN = object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 5: {
                AtomicReference atomicReference = (AtomicReference)this.SN;
                atomicReference = atomicReference.getAndSet(null);
                if (atomicReference == null) return;
                try {
                    if (!atomicReference.isShowing()) return;
                    atomicReference.dismiss();
                    return;
                }
                catch (Exception exception) {
                    SpiderDebug.log((Throwable)exception);
                }
                return;
            }
            case 4: {
                Music.N((String)this.SN);
                return;
            }
            case 3: {
                i3.yq((i3)this.SN);
                return;
            }
            case 2: {
                N0.W((N0)this.SN);
                return;
            }
            case 1: {
                xu_0.tF((xu_0)this.SN);
                return;
            }
            case 0: {
                QB.M((QB)this.SN);
                return;
            }
        }
        MainActivity.yq((MainActivity)((MainActivity)this.SN));
    }
}

