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
import com.github.catvod.spider.merge.ew_0;

public final class bM
implements DialogInterface.OnClickListener {
    public final Object SN;
    public final int yq;

    public /* synthetic */ bM(Object object, int n2) {
        this.yq = n2;
        this.SN = object;
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                Bili.OW((Bili)((Object)this.SN));
                return;
            }
        }
        ew_0.SN((ew_0)this.SN);
    }
}

