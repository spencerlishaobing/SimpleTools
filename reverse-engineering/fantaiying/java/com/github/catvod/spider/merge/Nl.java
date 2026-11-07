/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.i3;
import java.util.Map;

public final class Nl
implements Runnable {
    public final Map N;
    public final i3 SN;
    public final String tF;
    public final int yq;

    public /* synthetic */ Nl(i3 i32, Map map, String string, int n2) {
        this.yq = n2;
        this.SN = i32;
        this.N = map;
        this.tF = string;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                i3.tF(this.SN, this.N, this.tF);
                return;
            }
        }
        i3.G4(this.SN, this.N, this.tF);
    }
}

