/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.Bili;

public final class L9
implements DialogInterface.OnClickListener {
    public final Bili yq;

    public /* synthetic */ L9(Bili bili) {
        this.yq = bili;
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        Bili.G4(this.yq);
    }
}

