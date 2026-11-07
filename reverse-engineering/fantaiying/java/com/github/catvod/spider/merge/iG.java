/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.Toast
 */
package com.github.catvod.spider.merge;

import android.content.Context;
import android.widget.Toast;
import com.github.catvod.spider.InitOrigin;

final class iG
implements Runnable {
    final String yq;

    iG(String string) {
        this.yq = string;
    }

    @Override
    public final void run() {
        Toast.makeText((Context)InitOrigin.context(), (CharSequence)this.yq, (int)1).show();
    }
}

