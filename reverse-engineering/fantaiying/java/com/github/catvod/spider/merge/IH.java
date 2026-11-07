/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnKeyListener
 */
package com.github.catvod.spider.merge;

import android.view.KeyEvent;
import android.view.View;
import com.github.catvod.spider.ProxyOrigin;

public final class IH
implements View.OnKeyListener {
    public static final IH yq = new IH();

    private /* synthetic */ IH() {
    }

    public final boolean onKey(View view, int n2, KeyEvent keyEvent) {
        return ProxyOrigin.SN(view, n2, keyEvent);
    }
}

