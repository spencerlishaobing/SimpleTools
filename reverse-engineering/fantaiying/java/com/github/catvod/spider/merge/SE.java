/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  android.widget.LinearLayout$LayoutParams
 */
package com.github.catvod.spider.merge;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.github.catvod.spider.merge.w4;

public final class SE
implements View.OnClickListener {
    public final EditText N;
    public final EditText SN;
    public final Activity tF;
    public final w4 yq;
    public final LinearLayout.LayoutParams zH;

    public /* synthetic */ SE(w4 w42, EditText editText, EditText editText2, Activity activity, LinearLayout.LayoutParams layoutParams) {
        this.yq = w42;
        this.SN = editText;
        this.N = editText2;
        this.tF = activity;
        this.zH = layoutParams;
    }

    public final void onClick(View view) {
        w4.B(this.yq, this.SN, this.N, this.tF, this.zH);
    }
}

