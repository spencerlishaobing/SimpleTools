/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.app.Activity;
import com.github.catvod.spider.Bili;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.Zc;
import com.github.catvod.spider.merge.w4;
import org.json.JSONObject;

public final class dT
implements Runnable {
    public final Object N;
    public final Object SN;
    public final int yq;

    public /* synthetic */ dT(Object object, Object object2, int n2) {
        this.yq = n2;
        this.SN = object;
        this.N = object2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 2: {
                Pan.tF((Pan)((Object)this.SN), (Activity)this.N);
                return;
            }
            case 1: {
                Bili.dT((Bili)((Object)this.SN), (JSONObject)this.N);
                return;
            }
            case 0: {
                N0.yq((N0)this.SN, (String)this.N);
                return;
            }
        }
        w4.t0((w4)this.SN, (Zc)this.N);
    }
}

