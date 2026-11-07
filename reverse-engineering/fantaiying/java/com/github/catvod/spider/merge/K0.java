/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.merge.i3;

public final class K0
implements DialogInterface.OnDismissListener {
    public static final K0 yq = new K0();

    private /* synthetic */ K0() {
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        i3.s().v = false;
    }
}

