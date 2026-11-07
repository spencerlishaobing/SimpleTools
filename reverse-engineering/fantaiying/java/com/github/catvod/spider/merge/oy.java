/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.L1;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public final class oy
implements HostnameVerifier {
    public static final oy yq = new oy();

    private /* synthetic */ oy() {
    }

    @Override
    public final boolean verify(String object, SSLSession sSLSession) {
        object = L1.SN;
        return true;
    }
}

