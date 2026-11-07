/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.github.catvod.spider.merge;

import android.app.Activity;
import com.github.catvod.spider.Bili;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.y5;

public final class E1
implements Runnable {
    public final Object SN;
    public final int yq;

    public /* synthetic */ E1(Object object, int n2) {
        this.yq = n2;
        this.SN = object;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 3: {
                Pan.showPanSourceSortDialog((Activity)this.SN);
                return;
            }
            case 2: {
                Bili.W((Bili)((Object)this.SN));
                return;
            }
            case 1: {
                N0.tF((N0)this.SN);
                return;
            }
            case 0: {
                xu_0.M((xu_0)this.SN);
                return;
            }
        }
        y5.N((y5)this.SN);
    }
}

