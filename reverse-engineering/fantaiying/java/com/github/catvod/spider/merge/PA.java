/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.sI;
import com.github.catvod.spider.merge.xu_0;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PA
implements DialogInterface.OnDismissListener {
    public final N0 N;
    public final xu_0 SN;
    public final AtomicBoolean tF;
    public final i3 yq;

    public /* synthetic */ PA(i3 i32, xu_0 xu_02, N0 n0, AtomicBoolean atomicBoolean) {
        this.yq = i32;
        this.SN = xu_02;
        this.N = n0;
        this.tF = atomicBoolean;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        sI.yq(this.yq, this.SN, this.N, this.tF);
    }
}

