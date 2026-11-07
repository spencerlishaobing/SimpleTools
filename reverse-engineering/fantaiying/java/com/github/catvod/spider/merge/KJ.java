/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.Bili;
import com.github.catvod.spider.Music;
import com.github.catvod.spider.merge.N0;

public final class KJ
implements DialogInterface.OnDismissListener {
    public final Object SN;
    public final int yq;

    public /* synthetic */ KJ(Object object, int n2) {
        this.yq = n2;
        this.SN = object;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.yq) {
            default: {
                break;
            }
            case 1: {
                Bili.v((Bili)((Object)this.SN));
                return;
            }
            case 0: {
                N0.q((N0)this.SN);
                return;
            }
        }
        Music.SN((Music)((Object)this.SN));
    }
}

