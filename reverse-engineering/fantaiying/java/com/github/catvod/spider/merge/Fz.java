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
import com.github.catvod.spider.merge.xu_0;
import java.util.Objects;

public final class Fz
implements DialogInterface.OnDismissListener {
    public final Object SN;
    public final int yq;

    public /* synthetic */ Fz(Object object, int n2) {
        this.yq = n2;
        this.SN = object;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                xu_0.q((xu_0)this.SN);
                return;
            }
        }
        Objects.requireNonNull((Bili)((Object)this.SN));
    }
}

