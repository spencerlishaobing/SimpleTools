/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;

public final class Bu
implements DialogInterface.OnClickListener {
    public static final Bu yq = new Bu();

    private /* synthetic */ Bu() {
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        dialogInterface.dismiss();
    }
}

