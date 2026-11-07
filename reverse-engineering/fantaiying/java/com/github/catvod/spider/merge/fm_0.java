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

/*
 * Renamed from com.github.catvod.spider.merge.FM
 */
public final class fm_0
implements View.OnClickListener {
    public final Button N;
    public final String SN;
    public final w4 yq;

    public /* synthetic */ fm_0(w4 w42, String string, Button button) {
        this.yq = w42;
        this.SN = string;
        this.N = button;
    }

    public final void onClick(View view) {
        w4.i(this.yq, this.SN, this.N);
    }
}

