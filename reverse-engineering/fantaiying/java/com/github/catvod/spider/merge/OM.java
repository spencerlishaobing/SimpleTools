/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Cr;
import com.github.catvod.spider.merge.Z;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class OM
extends RandomAccessFile {
    private RandomAccessFile N;
    private File[] SN;
    private String i;
    private byte[] tF = new byte[1];
    private long yq;
    private int zH = 0;

    public OM(File serializable, String object, File[] fileArray) {
        super((File)serializable, (String)object);
        this.close();
        if (!Cr.N(2).equals(object)) {
            int n2 = fileArray.length;
            int n3 = 1;
            for (int i2 = 0; i2 < n2; ++i2) {
                block5: {
                    String string = fileArray[i2].getName();
                    string = !string.contains(".") ? "" : string.substring(string.lastIndexOf(".") + 1);
                    try {
                        if (n3 != Integer.parseInt(string)) break block5;
                        ++n3;
                        continue;
                    }
                    catch (NumberFormatException numberFormatException) {
                        throw new IOException(Z.SN("Split file extension not in expected format. Found: ", string, " expected of format: .001, .002, etc"));
                    }
                }
                super();
                ((StringBuilder)serializable).append("Split file number ");
                ((StringBuilder)serializable).append(n3);
                ((StringBuilder)serializable).append(" does not exist");
                object = new IOException(((StringBuilder)serializable).toString());
                throw object;
            }
            this.N = new RandomAccessFile((File)serializable, (String)object);
            this.SN = fileArray;
            this.yq = ((File)serializable).length();
            this.i = object;
            return;
        }
        serializable = new IllegalArgumentException("write mode is not allowed for NumberedSplitRandomAccessFile");
        throw serializable;
    }

    private void SN(int n2) {
        if (this.zH == n2) {
            return;
        }
        if (n2 <= this.SN.length - 1) {
            RandomAccessFile randomAccessFile = this.N;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.N = new RandomAccessFile(this.SN[n2], this.i);
            this.zH = n2;
            return;
        }
        throw new IOException("split counter greater than number of split files");
    }

    public final void N(long l) {
        this.N.seek(l);
    }

    @Override
    public final long getFilePointer() {
        return this.N.getFilePointer();
    }

    @Override
    public final long length() {
        return this.N.length();
    }

    @Override
    public final int read() {
        if (this.read(this.tF) == -1) {
            return -1;
        }
        return this.tF[0] & 0xFF;
    }

    @Override
    public final int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public final int read(byte[] byArray, int n2, int n3) {
        int n4 = this.N.read(byArray, n2, n3);
        if (n4 == -1) {
            n4 = this.zH;
            if (n4 == this.SN.length - 1) {
                return -1;
            }
            this.SN(n4 + 1);
            return this.read(byArray, n2, n3);
        }
        return n4;
    }

    @Override
    public final void seek(long l) {
        int n2 = (int)(l / this.yq);
        if (n2 != this.zH) {
            this.SN(n2);
        }
        this.N.seek(l - (long)n2 * this.yq);
    }

    @Override
    public final void write(int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void write(byte[] byArray) {
        this.write(byArray, 0, byArray.length);
        throw null;
    }

    @Override
    public final void write(byte[] byArray, int n2, int n3) {
        throw new UnsupportedOperationException();
    }

    public final void yq() {
        this.SN(this.SN.length - 1);
    }
}

