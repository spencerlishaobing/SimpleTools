/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Y;
import com.github.catvod.spider.merge.ma_0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/*
 * Renamed from com.github.catvod.spider.merge.am
 */
public final class am_0
extends ma_0 {
    private Inflater N;
    private int i;
    private byte[] tF;
    private byte[] zH = new byte[1];

    public am_0(Y y, int n2) {
        super(y);
        this.N = new Inflater(true);
        this.tF = new byte[n2];
    }

    @Override
    public final void N(PushbackInputStream pushbackInputStream) {
        int n2 = this.N.getRemaining();
        if (n2 > 0) {
            pushbackInputStream.unread(this.SN(), this.i - n2, n2);
        }
    }

    @Override
    public final void close() {
        Inflater inflater = this.N;
        if (inflater != null) {
            inflater.end();
        }
        super.close();
    }

    @Override
    public final int read() {
        if (this.read(this.zH) == -1) {
            return -1;
        }
        return this.zH[0];
    }

    @Override
    public final int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final int read(byte[] object, int n2, int n3) {
        try {
            int n4;
            while ((n4 = this.N.inflate((byte[])object, n2, n3)) == 0) {
                if (this.N.finished()) return -1;
                if (this.N.needsDictionary()) {
                    return -1;
                }
                if (!this.N.needsInput()) continue;
                byte[] byArray = this.tF;
                this.i = n4 = super.read(byArray, 0, byArray.length);
                if (n4 == -1) {
                    object = new EOFException;
                    object("Unexpected end of input stream");
                    throw object;
                }
                this.N.setInput(this.tF, 0, n4);
            }
            return n4;
        }
        catch (DataFormatException dataFormatException) {
            IOException iOException = new IOException(dataFormatException);
            throw iOException;
        }
    }

    @Override
    public final void yq(InputStream inputStream) {
        Inflater inflater = this.N;
        if (inflater != null) {
            inflater.end();
            this.N = null;
        }
        super.yq(inputStream);
    }
}

