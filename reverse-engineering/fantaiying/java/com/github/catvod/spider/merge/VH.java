/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.Music;

public final class VH
implements DialogInterface.OnDismissListener {
    public final Music yq;

    public /* synthetic */ VH(Music music) {
        this.yq = music;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Music.tF(this.yq);
    }
}

