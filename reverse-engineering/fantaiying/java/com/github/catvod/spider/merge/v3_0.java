/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.i3;
import java.util.Map;

/*
 * Renamed from com.github.catvod.spider.merge.v3
 */
public final class v3_0
implements Runnable {
    public final String N;
    public final Map SN;
    public final Object tF;
    public final int yq;

    public /* synthetic */ v3_0(Object object, Map map, String string, int n2) {
        this.yq = n2;
        this.tF = object;
        this.SN = map;
        this.N = string;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                N0.zH((N0)this.tF, this.N);
                return;
            }
        }
        i3.tF((i3)this.tF, this.SN, this.N);
    }
}

