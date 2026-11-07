/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 */
package com.github.catvod.spider.merge;

import android.view.View;
import android.widget.Button;
import com.github.catvod.spider.merge.w4;

public final class PE
implements View.OnClickListener {
    public final Button SN;
    public final w4 yq;

    public /* synthetic */ PE(w4 w42, Button button) {
        this.yq = w42;
        this.SN = button;
    }

    public final void onClick(View view) {
        w4.KJ(this.yq, this.SN);
    }
}

