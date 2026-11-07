/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Cr;
import com.github.catvod.spider.merge.NJ;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public abstract class AD
extends InputStream {
    private boolean N;
    protected File SN;
    private int tF = 0;
    protected RandomAccessFile yq;
    private byte[] zH = new byte[1];

    public AD(File file, boolean bl, int n) {
        this.yq = new RandomAccessFile(file, Cr.N(1));
        this.SN = file;
        this.N = bl;
        if (bl) {
            this.tF = n;
        }
    }

    public final void N(NJ nJ) {
        if (this.N && this.tF != nJ.cp()) {
            this.SN(nJ.cp());
            this.tF = nJ.cp();
        }
        this.yq.seek(nJ.cS());
    }

    protected final void SN(int n) {
        File file = this.yq(n);
        if (file.exists()) {
            this.yq.close();
            this.yq = new RandomAccessFile(file, Cr.N(1));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("zip split file does not exist: ");
        stringBuilder.append(file);
        throw new FileNotFoundException(stringBuilder.toString());
    }

    @Override
    public final void close() {
        RandomAccessFile randomAccessFile = this.yq;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
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

    @Override
    public final int read(byte[] byArray, int n, int n2) {
        block7: {
            int n3;
            block6: {
                n3 = this.yq.read(byArray, n, n2);
                if (n3 != n2) break block6;
                n = n3;
                if (n3 != -1) break block7;
            }
            n = n3;
            if (this.N) {
                this.SN(this.tF + 1);
                ++this.tF;
                int n4 = n3;
                if (n3 < 0) {
                    n4 = 0;
                }
                n2 = this.yq.read(byArray, n4, n2 - n4);
                n = n4;
                if (n2 > 0) {
                    n = n4 + n2;
                }
            }
        }
        return n;
    }

    protected abstract File yq(int var1);
}

