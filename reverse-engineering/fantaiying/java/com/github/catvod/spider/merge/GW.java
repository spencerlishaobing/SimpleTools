/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.JL;

public final class GW
implements DialogInterface.OnClickListener {
    public static final GW yq = new GW();

    private /* synthetic */ GW() {
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        InitOrigin.execute(new JL(n2));
    }
}

