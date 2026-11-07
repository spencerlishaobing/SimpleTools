/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/*
 * Renamed from com.github.catvod.spider.merge.jn
 */
final class jn_0
implements X509TrustManager {
    jn_0() {
    }

    @Override
    public final void checkClientTrusted(X509Certificate[] x509CertificateArray, String string) {
    }

    @Override
    public final void checkServerTrusted(X509Certificate[] x509CertificateArray, String string) {
    }

    @Override
    public final X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}

