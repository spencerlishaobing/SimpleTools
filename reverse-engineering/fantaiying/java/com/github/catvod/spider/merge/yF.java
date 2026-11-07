/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Z4;
import com.github.catvod.spider.merge.eN;
import com.github.catvod.spider.merge.jM;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Objects;
import java.util.logging.Level;

public final class yF
implements Runnable {
    private IOException N;
    private final int SN;
    private boolean tF = false;
    private jM yq;

    public yF(jM jM2) {
        this.yq = jM2;
        this.SN = 15;
    }

    public final boolean SN() {
        return this.tF;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void run() {
        Object object;
        Object object2;
        Closeable closeable;
        try {
            closeable = this.yq.SN();
            if (this.yq.yq != null) {
                object2 = this.yq;
                object = new InetSocketAddress(((jM)object2).yq, ((jM)object2).SN);
            } else {
                object = new InetSocketAddress(this.yq.SN);
            }
            ((ServerSocket)closeable).bind((SocketAddress)object);
            this.tF = true;
        }
        catch (IOException iOException) {
            this.N = iOException;
            return;
        }
        do {
            try {
                closeable = this.yq.SN().accept();
                int n2 = this.SN;
                if (n2 > 0) {
                    ((Socket)closeable).setSoTimeout(n2);
                }
                object2 = ((Socket)closeable).getInputStream();
                object = this.yq;
                eN eN2 = ((jM)object).Gc;
                Objects.requireNonNull(object);
                Z4 z4 = new Z4((jM)object, (InputStream)object2, (Socket)closeable);
                eN2.N(z4);
            }
            catch (IOException iOException) {
                jM.KJ.log(Level.FINE, "Communication with the client broken", iOException);
            }
        } while (!this.yq.SN().isClosed());
    }

    public final IOException yq() {
        return this.N;
    }
}

