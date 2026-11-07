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
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.yj
 */
public final class yj_0
implements Runnable {
    public final Activity N;
    public final List SN;
    public final LinearLayout.LayoutParams tF;
    public final w4 yq;

    public /* synthetic */ yj_0(w4 w42, List list, Activity activity, LinearLayout.LayoutParams layoutParams) {
        this.yq = w42;
        this.SN = list;
        this.N = activity;
        this.tF = layoutParams;
    }

    @Override
    public final void run() {
        w4.N(this.yq, this.SN, this.N, this.tF);
    }
}

