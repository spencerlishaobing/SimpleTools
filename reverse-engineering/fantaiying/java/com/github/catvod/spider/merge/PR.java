/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 */
package com.github.catvod.spider.merge;

import android.view.View;
import com.github.catvod.spider.ProxyOrigin;

public final class PR
implements View.OnLongClickListener {
    public static final PR yq = new PR();

    private /* synthetic */ PR() {
    }

    public final boolean onLongClick(View view) {
        ProxyOrigin.yq(view);
        return true;
    }
}

