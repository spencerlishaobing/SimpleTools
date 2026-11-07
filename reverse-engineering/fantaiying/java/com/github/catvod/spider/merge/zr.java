/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.Bili;
import com.github.catvod.spider.merge.ew_0;

public final class zr
implements Runnable {
    public final Object N;
    public final String SN;
    public final int yq;

    public /* synthetic */ zr(Object object, String string, int n2) {
        this.yq = n2;
        this.N = object;
        this.SN = string;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                Bili.xa((Bili)((Object)this.N), this.SN);
                return;
            }
        }
        ew_0.zH((ew_0)this.N, this.SN);
    }
}

