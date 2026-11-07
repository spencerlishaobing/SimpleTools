/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.github.catvod.spider.merge;

import android.view.View;
import com.github.catvod.spider.Pan;

public final class nA
implements View.OnClickListener {
    public final Pan yq;

    public /* synthetic */ nA(Pan pan) {
        this.yq = pan;
    }

    public final void onClick(View view) {
        Pan.SN(this.yq, view);
    }
}

