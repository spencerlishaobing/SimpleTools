/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/*
 * Renamed from com.github.catvod.spider.merge.Pe
 */
public final class pe_0
implements HostnameVerifier {
    public static final pe_0 yq = new pe_0();

    private /* synthetic */ pe_0() {
    }

    @Override
    public final boolean verify(String string, SSLSession sSLSession) {
        return true;
    }
}

