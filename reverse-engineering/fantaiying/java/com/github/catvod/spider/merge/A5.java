/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.w4;

public final class A5
implements Runnable {
    public static final A5 yq = new A5();

    private /* synthetic */ A5() {
    }

    @Override
    public final void run() {
        CharSequence charSequence = w4.W;
        charSequence = oi_0.yq("http://127.0.0.1:9978/action?do=refresh&type=danmaku&path=");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ProxyOrigin.getOwnProxyUrl());
        stringBuilder.append("proxy?do=noDanmu");
        ((StringBuilder)charSequence).append(ME.b(stringBuilder.toString()));
        Bo.q(((StringBuilder)charSequence).toString());
    }
}

