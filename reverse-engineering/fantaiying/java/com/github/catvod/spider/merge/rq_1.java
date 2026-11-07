/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 */
package com.github.catvod.spider.merge;

import android.content.Context;
import android.webkit.WebView;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.ME;

/*
 * Renamed from com.github.catvod.spider.merge.rq
 */
public final class rq_1
implements Runnable {
    public static final rq_1 yq = new rq_1();

    private /* synthetic */ rq_1() {
    }

    @Override
    public final void run() {
        String string = ME.yq;
        ME.yq = new WebView((Context)InitOrigin.context()).getSettings().getUserAgentString();
    }
}

