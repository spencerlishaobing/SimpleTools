/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.github.catvod.spider.merge;

import android.os.Build;
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
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public final class SO
extends SSLSocketFactory {
    static String[] N;
    static String[] SN;
    public static final X509TrustManager tF;
    private final SSLSocketFactory yq;

    static {
        block6: {
            SSLSocket sSLSocket = (SSLSocket)SSLSocketFactory.getDefault().createSocket();
            if (sSLSocket == null) break block6;
            AbstractCollection abstractCollection = new LinkedList();
            for (String string : sSLSocket.getSupportedProtocols()) {
                if (string.toUpperCase().contains("SSL")) continue;
                ((LinkedList)abstractCollection).add(string);
            }
            try {
                SN = ((LinkedList)abstractCollection).toArray(new String[((LinkedList)abstractCollection).size()]);
                if (Build.VERSION.SDK_INT >= 21) break block6;
                List<String> list = Arrays.asList("TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECHDE_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
                List<String> list2 = Arrays.asList(sSLSocket.getSupportedCipherSuites());
                abstractCollection = new HashSet(list);
                abstractCollection.retainAll(list2);
                HashSet<String> hashSet = new HashSet<String>(Arrays.asList(sSLSocket.getEnabledCipherSuites()));
                abstractCollection.addAll(hashSet);
                N = abstractCollection.toArray(new String[((HashSet)abstractCollection).size()]);
            }
            catch (IOException iOException) {
                RuntimeException runtimeException = new RuntimeException(iOException);
                throw runtimeException;
            }
        }
        tF = new X509TrustManager(){

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
    }

    public SO(X509TrustManager x509TrustManagerArray) {
        SSLContext sSLContext;
        block5: {
            block4: {
                try {
                    sSLContext = SSLContext.getInstance("TLS");
                    if (x509TrustManagerArray == null) break block4;
                }
                catch (GeneralSecurityException generalSecurityException) {
                    throw new AssertionError();
                }
                X509TrustManager[] x509TrustManagerArray2 = new X509TrustManager[]{x509TrustManagerArray};
                x509TrustManagerArray = x509TrustManagerArray2;
                break block5;
            }
            x509TrustManagerArray = null;
        }
        sSLContext.init(null, x509TrustManagerArray, null);
        this.yq = sSLContext.getSocketFactory();
    }

    private void yq(SSLSocket sSLSocket) {
        String[] stringArray = SN;
        if (stringArray != null) {
            sSLSocket.setEnabledProtocols(stringArray);
        }
        if (Build.VERSION.SDK_INT < 21 && (stringArray = N) != null) {
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
        return N;
    }

    @Override
    public final String[] getSupportedCipherSuites() {
        return N;
    }
}

