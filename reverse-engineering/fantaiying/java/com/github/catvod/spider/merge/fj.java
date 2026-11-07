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
import com.github.catvod.spider.Pan;

public final class fj
implements View.OnFocusChangeListener {
    public final Button SN;
    public final Pan yq;

    public /* synthetic */ fj(Pan pan, Button button) {
        this.yq = pan;
        this.SN = button;
    }

    public final void onFocusChange(View view, boolean bl) {
        Pan.i(this.yq, this.SN, view, bl);
    }
}

