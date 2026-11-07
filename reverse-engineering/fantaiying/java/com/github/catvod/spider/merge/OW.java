/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.merge.j_0;

public final class OW
implements DialogInterface.OnDismissListener {
    public static final OW yq = new OW();

    private /* synthetic */ OW() {
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        j_0.yq();
    }
}

