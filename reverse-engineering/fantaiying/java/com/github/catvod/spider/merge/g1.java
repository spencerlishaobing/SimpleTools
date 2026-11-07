/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.Alllive;
import com.github.catvod.spider.Music;
import com.github.catvod.spider.merge.fk;
import com.github.catvod.spider.merge.j_0;

public final class g1
implements Runnable {
    public final Object SN;
    public final int yq;

    public /* synthetic */ g1(Object object, int n2) {
        this.yq = n2;
        this.SN = object;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 2: {
                Music.zH((Music)((Object)this.SN));
                return;
            }
            case 1: {
                Alllive.zH((String)this.SN);
                return;
            }
            case 0: {
                j_0.tF((j_0)this.SN);
                return;
            }
        }
        fk.SN((fk)this.SN);
    }
}

