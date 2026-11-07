/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.UC;
import com.github.catvod.spider.merge.b9;
import com.github.catvod.spider.merge.jM;
import com.github.catvod.spider.merge.sx;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Objects;
import java.util.logging.Level;

public final class Z4
implements Runnable {
    private final Socket N;
    private final InputStream SN;
    private final jM yq;

    public Z4(jM jM2, InputStream inputStream, Socket socket) {
        this.yq = jM2;
        this.SN = inputStream;
        this.N = socket;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void run() {
        Throwable throwable2;
        OutputStream outputStream;
        block8: {
            Object object;
            block7: {
                OutputStream outputStream2 = null;
                outputStream = null;
                try {
                    try {
                        OutputStream outputStream3;
                        outputStream = outputStream3 = this.N.getOutputStream();
                        outputStream2 = outputStream3;
                        Objects.requireNonNull(this.yq.N());
                        outputStream = outputStream3;
                        outputStream2 = outputStream3;
                        outputStream = outputStream3;
                        outputStream2 = outputStream3;
                        object = new UC();
                        outputStream = outputStream3;
                        outputStream2 = outputStream3;
                        outputStream = outputStream3;
                        outputStream2 = outputStream3;
                        sx sx2 = new sx(this.yq, (b9)object, this.SN, outputStream3, this.N.getInetAddress());
                        while (true) {
                            outputStream = outputStream3;
                            outputStream2 = outputStream3;
                            object = outputStream3;
                            if (!this.N.isClosed()) {
                                outputStream = outputStream3;
                                outputStream2 = outputStream3;
                                sx2.i();
                                continue;
                            }
                            break;
                        }
                    }
                    catch (Exception exception) {
                        outputStream = outputStream2;
                        if (exception instanceof SocketException) {
                            outputStream = outputStream2;
                            object = outputStream2;
                            if ("NanoHttpd Shutdown".equals(exception.getMessage())) break block7;
                        }
                        outputStream = outputStream2;
                        object = outputStream2;
                        if (exception instanceof SocketTimeoutException) break block7;
                        outputStream = outputStream2;
                        jM.KJ.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", exception);
                        object = outputStream2;
                    }
                }
                catch (Throwable throwable2) {
                    break block8;
                }
            }
            jM.zH(object);
            jM.zH(this.SN);
            jM.zH(this.N);
            this.yq.Gc.SN(this);
            return;
        }
        jM.zH(outputStream);
        jM.zH(this.SN);
        jM.zH(this.N);
        this.yq.Gc.SN(this);
        throw throwable2;
    }

    public final void yq() {
        jM.zH(this.SN);
        jM.zH(this.N);
    }
}

