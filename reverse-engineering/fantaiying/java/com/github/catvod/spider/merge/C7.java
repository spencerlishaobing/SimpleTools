/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.Alllive;

public final class C7
implements DialogInterface.OnDismissListener {
    public final Alllive yq;

    public /* synthetic */ C7(Alllive alllive) {
        this.yq = alllive;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Alllive.N(this.yq);
    }
}

