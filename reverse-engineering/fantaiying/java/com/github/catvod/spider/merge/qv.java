/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.merge.N5;
import com.github.catvod.spider.merge.w4;

public final class qv
implements DialogInterface.OnDismissListener {
    public static final qv N;
    public static final qv SN;
    public final int yq;

    static {
        SN = new qv(0);
        N = new qv(1);
    }

    public /* synthetic */ qv(int n2) {
        this.yq = n2;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                w4.q();
                return;
            }
        }
        N5.SN();
    }
}

