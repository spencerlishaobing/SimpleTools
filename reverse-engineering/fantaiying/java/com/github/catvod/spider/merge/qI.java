/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package com.github.catvod.spider.merge;

import android.view.MotionEvent;
import android.view.View;
import com.github.catvod.spider.ProxyOrigin;

public final class qI
implements View.OnTouchListener {
    public static final qI yq = new qI();

    private /* synthetic */ qI() {
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return ProxyOrigin.N(view, motionEvent);
    }
}

