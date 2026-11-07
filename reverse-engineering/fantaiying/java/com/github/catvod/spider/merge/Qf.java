/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.w4;
import java.net.URLEncoder;

public final class Qf
implements Runnable {
    public static final Qf yq = new Qf();

    private /* synthetic */ Qf() {
    }

    @Override
    public final void run() {
        CharSequence charSequence = w4.W;
        StringBuilder stringBuilder = oi_0.yq("http://127.0.0.1:9978/action?do=refresh&type=danmaku&path=");
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(ProxyOrigin.getOwnProxyUrl());
        ((StringBuilder)charSequence).append("proxy?do=danmu&act=&url=");
        ((StringBuilder)charSequence).append(URLEncoder.encode(Tq.ee));
        stringBuilder.append(ME.b(((StringBuilder)charSequence).toString()));
        Bo.q(stringBuilder.toString());
    }
}

