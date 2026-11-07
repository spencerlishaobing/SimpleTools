/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.Music;

public final class FY
implements DialogInterface.OnClickListener {
    public final Music yq;

    public /* synthetic */ FY(Music music) {
        this.yq = music;
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        Music.i(this.yq);
    }
}

