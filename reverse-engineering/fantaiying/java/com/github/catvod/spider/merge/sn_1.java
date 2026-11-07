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

/*
 * Renamed from com.github.catvod.spider.merge.sN
 */
public final class sn_1
implements View.OnFocusChangeListener {
    public final String N;
    public final Button SN;
    public final Pan yq;

    public /* synthetic */ sn_1(Pan pan, Button button, String string) {
        this.yq = pan;
        this.SN = button;
        this.N = string;
    }

    public final void onFocusChange(View view, boolean bl) {
        Pan.N(this.yq, this.SN, this.N, bl);
    }
}

