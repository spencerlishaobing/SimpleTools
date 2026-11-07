/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.Bili;

/*
 * Renamed from com.github.catvod.spider.merge.c
 */
public final class c_0
implements DialogInterface.OnCancelListener {
    public final Bili yq;

    public /* synthetic */ c_0(Bili bili) {
        this.yq = bili;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        Bili.v3(this.yq);
    }
}

