/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.i3;
import java.util.Objects;

public final class ee
implements DialogInterface.OnDismissListener {
    public final i3 yq;

    public /* synthetic */ ee(i3 i32) {
        this.yq = i32;
    }

    public final void onDismiss(DialogInterface object) {
        object = this.yq;
        Objects.requireNonNull(object);
        InitOrigin.zH = false;
        object.v = false;
        InitOrigin.stopShowingToast();
    }
}

