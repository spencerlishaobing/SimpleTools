/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.tX;
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.v
 */
public final class v_0
implements Runnable {
    public final Object Gc;
    public final String N;
    public final String SN;
    public final int i;
    public final Object t0;
    public final List tF;
    public final int yq;
    public final List zH;

    public /* synthetic */ v_0(Object object, Object object2, String string, String string2, List list, List list2, int n2, int n3) {
        this.yq = n3;
        this.t0 = object;
        this.Gc = object2;
        this.SN = string;
        this.N = string2;
        this.tF = list;
        this.zH = list2;
        this.i = n2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                N0.B((N0)this.t0, (tX)this.Gc, this.SN, this.N, this.tF, this.zH, this.i);
                return;
            }
        }
        i3.i((i3)this.t0, (H7)this.Gc, this.SN, this.N, this.tF, this.zH, this.i);
    }
}

