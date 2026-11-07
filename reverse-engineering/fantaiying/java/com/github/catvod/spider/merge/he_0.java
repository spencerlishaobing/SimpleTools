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

/*
 * Renamed from com.github.catvod.spider.merge.HE
 */
public final class he_0
implements DialogInterface.OnDismissListener {
    public final Alllive yq;

    public /* synthetic */ he_0(Alllive alllive) {
        this.yq = alllive;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Alllive.i(this.yq);
    }
}

