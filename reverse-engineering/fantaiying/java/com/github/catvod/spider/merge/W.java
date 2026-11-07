/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.widget.LinearLayout$LayoutParams
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.app.Activity;
import android.widget.LinearLayout;
import com.github.catvod.spider.Bili;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.w4;
import java.util.Objects;
import org.json.JSONObject;

public final class W
implements Runnable {
    public final Object N;
    public final Object SN;
    public final Object tF;
    public final int yq;

    public /* synthetic */ W(Object object, Object object2, Object object3, int n2) {
        this.yq = n2;
        this.N = object;
        this.tF = object2;
        this.SN = object3;
    }

    public /* synthetic */ W(Object object, String string, Object object2, int n2) {
        this.yq = n2;
        this.N = object;
        this.SN = string;
        this.tF = object2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 2: {
                w4 w42 = (w4)this.N;
                String string = (String)this.SN;
                String string2 = (String)this.tF;
                String string3 = w4.W;
                Objects.requireNonNull(w42);
                try {
                    w42.b(string, string2);
                    return;
                }
                catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }
            case 1: {
                Bili.q((Bili)((Object)this.N), (String)this.SN, (JSONObject)this.tF);
                return;
            }
            case 0: {
                N0.zH((N0)this.N, (String)this.SN);
                return;
            }
        }
        w4.yq((w4)this.N, (Activity)this.tF, (LinearLayout.LayoutParams)this.SN);
    }
}

