/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebViewClient
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.webkit.WebViewClient;
import com.github.catvod.spider.Bili;
import com.github.catvod.spider.Nmyswv;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.k9;
import org.json.JSONObject;

public final class Zm
implements Runnable {
    public final Object N;
    public final Object SN;
    public final int yq;

    public /* synthetic */ Zm(Object object, Object object2, int n2) {
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
                Bili.Nl((Bili)((Object)this.SN), (JSONObject)this.N);
                return;
            }
            case 1: {
                N0.t0((N0)this.SN, (String)this.N);
                return;
            }
            case 0: {
                j_0.SN((j_0)this.SN, (k9)this.N);
                return;
            }
        }
        Nmyswv.yq((WebViewClient)this.SN, (String)this.N);
    }
}

