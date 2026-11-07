/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.Alllive;

/*
 * Renamed from com.github.catvod.spider.merge.z
 */
public final class z_0
implements DialogInterface.OnClickListener {
    public final Alllive yq;

    public /* synthetic */ z_0(Alllive alllive) {
        this.yq = alllive;
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        Alllive.SN(this.yq);
    }
}

