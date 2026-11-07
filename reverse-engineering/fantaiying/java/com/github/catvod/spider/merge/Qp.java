/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.widget.LinearLayout$LayoutParams
 */
package com.github.catvod.spider.merge;

import android.app.Activity;
import android.widget.LinearLayout;
import com.github.catvod.spider.merge.w4;

public final class Qp
implements Runnable {
    public final String N;
    public final String SN;
    public final Activity tF;
    public final w4 yq;
    public final LinearLayout.LayoutParams zH;

    public /* synthetic */ Qp(w4 w42, String string, String string2, Activity activity, LinearLayout.LayoutParams layoutParams) {
        this.yq = w42;
        this.SN = string;
        this.N = string2;
        this.tF = activity;
        this.zH = layoutParams;
    }

    @Override
    public final void run() {
        w4.Gc(this.yq, this.SN, this.N, this.tF, this.zH);
    }
}

