/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.Bili;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.i3;
import org.json.JSONObject;

public final class F5
implements Runnable {
    public final Object N;
    public final Object SN;
    public final int yq;

    public /* synthetic */ F5(Object object, Object object2, int n2) {
        this.yq = n2;
        this.N = object;
        this.SN = object2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 1: {
                i3.dT((i3)this.N, (String)this.SN);
                return;
            }
            case 0: {
                N0.N((N0)this.N, (String)this.SN);
                return;
            }
        }
        Bili.Nl((Bili)((Object)this.N), (JSONObject)this.SN);
    }
}

