/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public final class L1
extends SSLSocketFactory {
    static String[] N;
    public static final X509TrustManager SN;
    static String[] tF;
    private final SSLSocketFactory yq;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static {
        SN = new X509TrustManager(){

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
        };
        N = null;
        tF = null;
        SSLSocket sSLSocket = (SSLSocket)SSLSocketFactory.getDefault().createSocket();
        if (sSLSocket == null) return;
        LinkedList<String> linkedList = new LinkedList<String>();
        for (String string : sSLSocket.getSupportedProtocols()) {
            if (string.toUpperCase().contains("SSL")) continue;
            linkedList.add(string);
        }
        try {
            N = linkedList.toArray(new String[linkedList.size()]);
            List<String> list = Arrays.asList("TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECHDE_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
            List<String> list2 = Arrays.asList(sSLSocket.getSupportedCipherSuites());
            HashSet<String> hashSet = new HashSet<String>(list);
            hashSet.retainAll(list2);
            HashSet<String> hashSet2 = new HashSet<String>(Arrays.asList(sSLSocket.getEnabledCipherSuites()));
            hashSet.addAll(hashSet2);
            tF = ((AbstractCollection)hashSet).toArray(new String[hashSet.size()]);
            return;
        }
        catch (IOException iOException) {
            RuntimeException runtimeException = new RuntimeException(iOException);
            throw runtimeException;
        }
    }

    public L1() {
        try {
            Object object = SSLContext.getInstance("TLS");
            ((SSLContext)object).init(null, new X509TrustManager[]{SN}, null);
            this.yq = object = ((SSLContext)object).getSocketFactory();
            HttpsURLConnection.setDefaultSSLSocketFactory((SSLSocketFactory)object);
            return;
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw new AssertionError();
        }
    }

    private void yq(SSLSocket sSLSocket) {
        String[] stringArray = N;
        if (stringArray != null) {
            sSLSocket.setEnabledProtocols(stringArray);
        }
        if ((stringArray = tF) != null) {
            sSLSocket.setEnabledCipherSuites(stringArray);
        }
    }

    @Override
    public final Socket createSocket(String object, int n2) {
        if ((object = this.yq.createSocket((String)object, n2)) instanceof SSLSocket) {
            this.yq((SSLSocket)object);
        }
        return object;
    }

    @Override
    public final Socket createSocket(String object, int n2, InetAddress inetAddress, int n3) {
        if ((object = this.yq.createSocket((String)object, n2, inetAddress, n3)) instanceof SSLSocket) {
            this.yq((SSLSocket)object);
        }
        return object;
    }

    @Override
    public final Socket createSocket(InetAddress object, int n2) {
        if ((object = this.yq.createSocket((InetAddress)object, n2)) instanceof SSLSocket) {
            this.yq((SSLSocket)object);
        }
        return object;
    }

    @Override
    public final Socket createSocket(InetAddress object, int n2, InetAddress inetAddress, int n3) {
        if ((object = this.yq.createSocket((InetAddress)object, n2, inetAddress, n3)) instanceof SSLSocket) {
            this.yq((SSLSocket)object);
        }
        return object;
    }

    @Override
    public final Socket createSocket(Socket socket, String string, int n2, boolean bl) {
        if ((socket = this.yq.createSocket(socket, string, n2, bl)) instanceof SSLSocket) {
            this.yq((SSLSocket)socket);
        }
        return socket;
    }

    @Override
    public final String[] getDefaultCipherSuites() {
        return tF;
    }

    @Override
    public final String[] getSupportedCipherSuites() {
        return tF;
    }
}

