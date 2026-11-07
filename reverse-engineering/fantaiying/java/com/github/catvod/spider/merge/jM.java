/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.K1;
import com.github.catvod.spider.merge.R5;
import com.github.catvod.spider.merge.S9;
import com.github.catvod.spider.merge.VG;
import com.github.catvod.spider.merge.eN;
import com.github.catvod.spider.merge.vd;
import com.github.catvod.spider.merge.wg;
import com.github.catvod.spider.merge.xe;
import com.github.catvod.spider.merge.yF;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public abstract class jM {
    public static final Logger KJ;
    protected eN Gc;
    private wg M;
    private volatile ServerSocket N;
    public final int SN;
    private vd<VG, xe> i;
    protected List<vd<VG, xe>> t0;
    private R5 tF = new R5();
    public final String yq;
    private Thread zH;

    static {
        Pattern.compile("([ |\t]*Content-Disposition[ |\t]*:)(.*)", 2);
        Pattern.compile("([ |\t]*content-type[ |\t]*:)(.*)", 2);
        Pattern.compile("[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]");
        KJ = Logger.getLogger(jM.class.getName());
    }

    public jM(int n2) {
        this.t0 = new ArrayList<vd<VG, xe>>(4);
        this.yq = null;
        this.SN = n2;
        this.M = new wg();
        this.Gc = new eN();
        this.i = new S9(this);
    }

    public static String yq(String string) {
        try {
            string = URLDecoder.decode(string, "UTF8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            KJ.log(Level.WARNING, "Encoding not supported, ignored", unsupportedEncodingException);
            string = null;
        }
        return string;
    }

    public static final void zH(Object object) {
        block6: {
            if (object != null) {
                try {
                    if (object instanceof Closeable) {
                        ((Closeable)object).close();
                        break block6;
                    }
                    if (object instanceof Socket) {
                        ((Socket)object).close();
                        break block6;
                    }
                    if (object instanceof ServerSocket) {
                        ((ServerSocket)object).close();
                        break block6;
                    }
                    object = new IllegalArgumentException("Unknown object to close");
                    throw object;
                }
                catch (IOException iOException) {
                    KJ.log(Level.SEVERE, "Could not close", iOException);
                }
            }
        }
    }

    public void Gc() {
        block3: {
            jM.zH(this.N);
            this.Gc.yq();
            Thread thread = this.zH;
            if (thread == null) break block3;
            try {
                thread.join();
            }
            catch (Exception exception) {
                KJ.log(Level.SEVERE, "Could not stop all connections", exception);
            }
        }
    }

    public final wg N() {
        return this.M;
    }

    public final ServerSocket SN() {
        return this.N;
    }

    @Deprecated
    protected xe i(VG vG) {
        return xe.t0(K1.zH, "Not Found");
    }

    public final void t0() {
        Thread thread;
        Objects.requireNonNull(this.tF);
        this.N = new ServerSocket();
        this.N.setReuseAddress(true);
        Object object = new yF(this);
        this.zH = thread = new Thread((Runnable)object);
        thread.setDaemon(true);
        this.zH.setName("NanoHttpd Main Listener");
        this.zH.start();
        while (!((yF)object).SN() && ((yF)object).yq() == null) {
            try {
                Thread.sleep(10L);
            }
            catch (Throwable throwable) {}
        }
        if (((yF)object).yq() == null) {
            return;
        }
        object = ((yF)object).yq();
        throw object;
    }

    public final xe tF(VG vG) {
        Object object = ((ArrayList)this.t0).iterator();
        while (object.hasNext()) {
            xe xe2 = (xe)((vd)object.next()).yq(vG);
            if (xe2 == null) continue;
            return xe2;
        }
        object = (S9)this.i;
        Objects.requireNonNull(object);
        return ((S9)object).yq.i(vG);
    }

    public static final class yq
    extends Exception {
        private final K1 yq;

        public yq(K1 k1, String string) {
            super(string);
            this.yq = k1;
        }

        public yq(String string, Exception exception) {
            K1 k1 = K1.i;
            super(string, exception);
            this.yq = k1;
        }

        public final K1 yq() {
            return this.yq;
        }
    }
}

