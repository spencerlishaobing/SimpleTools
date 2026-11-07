/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.github.catvod.spider.merge;

import android.content.Context;
import com.github.catvod.spider.Pan;

public final class St
implements Runnable {
    public final String N;
    public final Context SN;
    public final Pan yq;

    public /* synthetic */ St(Pan pan, Context context, String string) {
        this.yq = pan;
        this.SN = context;
        this.N = string;
    }

    @Override
    public final void run() {
        this.yq.showAppChooserDialog(this.SN, this.N);
    }
}

