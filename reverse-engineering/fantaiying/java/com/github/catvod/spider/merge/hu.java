/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnFocusChangeListener
 *  android.widget.Button
 */
package com.github.catvod.spider.merge;

import android.view.View;
import android.widget.Button;
import com.github.catvod.spider.merge.w4;

public final class hu
implements View.OnFocusChangeListener {
    public final Button N;
    public final String SN;
    public final w4 yq;

    public /* synthetic */ hu(w4 w42, String string, Button button) {
        this.yq = w42;
        this.SN = string;
        this.N = button;
    }

    public final void onFocusChange(View view, boolean bl) {
        w4.SN(this.yq, this.SN, this.N, bl);
    }
}

