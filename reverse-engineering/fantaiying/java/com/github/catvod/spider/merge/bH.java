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
import com.github.catvod.spider.Pan;

public final class bH
implements View.OnClickListener {
    public final Button SN;
    public final Pan yq;

    public /* synthetic */ bH(Pan pan, Button button) {
        this.yq = pan;
        this.SN = button;
    }

    public final void onClick(View view) {
        Pan.zH(this.yq, this.SN, view);
    }
}

