/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.B7;
import com.github.catvod.spider.merge.N;
import com.github.catvod.spider.merge.Y;
import com.github.catvod.spider.merge.cp;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.mt_0;
import com.github.catvod.spider.merge.nQ;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.u5;
import com.github.catvod.spider.merge.uo_0;
import com.github.catvod.spider.merge.yq;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

final class I
extends Y<yq> {
    private int B = 0;
    private int G = 0;
    private int Gc = 0;
    private int KJ = 0;
    private int M = 0;
    private byte[] i = new byte[1];
    private int q = 0;
    private byte[] t0 = new byte[16];

    public I(uo_0 uo_02, B7 b7, char[] cArray, int n2) {
        super(uo_02, b7, cArray, n2);
    }

    private void t0(byte[] byArray, int n2) {
        int n3 = this.KJ;
        int n4 = this.M;
        if (n3 >= n4) {
            n3 = n4;
        }
        this.G = n3;
        System.arraycopy(this.t0, this.Gc, byArray, n2, n3);
        n2 = this.G;
        this.Gc = n3 = this.Gc + n2;
        if (n3 >= 15) {
            this.Gc = 15;
        }
        this.M = n3 = this.M - n2;
        if (n3 <= 0) {
            this.M = 0;
        }
        this.B += n2;
        this.KJ -= n2;
        this.q += n2;
    }

    @Override
    public final int read() {
        if (this.read(this.i) == -1) {
            return -1;
        }
        return this.i[0];
    }

    @Override
    public final int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public final int read(byte[] byArray, int n2, int n3) {
        this.KJ = n3;
        this.q = n2;
        this.B = 0;
        if (this.M != 0) {
            this.t0(byArray, n2);
            n2 = this.B;
            if (n2 == n3) {
                return n2;
            }
        }
        if (this.KJ < 16) {
            byte[] byArray2 = this.t0;
            n2 = super.read(byArray2, 0, byArray2.length);
            this.Gc = 0;
            if (n2 == -1) {
                this.M = 0;
                n2 = this.B;
                if (n2 > 0) {
                    return n2;
                }
                return -1;
            }
            this.M = n2;
            this.t0(byArray, this.q);
            n2 = this.B;
            if (n2 == n3) {
                return n2;
            }
        }
        n3 = this.q;
        n2 = this.KJ;
        if ((n2 = super.read(byArray, n3, n2 - n2 % 16)) == -1) {
            n2 = this.B;
            if (n2 > 0) {
                return n2;
            }
            return -1;
        }
        return n2 + this.B;
    }

    @Override
    protected final void yq(InputStream object) {
        block2: {
            block4: {
                block3: {
                    byte[] byArray = new byte[10];
                    if (rs_0.v3((InputStream)object, byArray) != 10) break block2;
                    if (this.tF().xU() && cp.yq(2, rs_0.G4(this.tF()))) break block3;
                    object = ((yq)this.SN()).SN();
                    byte[] byArray2 = new byte[10];
                    System.arraycopy(object, 0, byArray2, 0, 10);
                    if (!Arrays.equals(byArray, byArray2)) break block4;
                }
                return;
            }
            throw new IOException("Reached end of data for this entry, but aes verification failed");
        }
        throw new mt_0("Invalid AES Mac bytes. Could not read sufficient data");
    }

    @Override
    protected final u5 zH(B7 object, char[] cArray) {
        N n2 = ((nQ)object).Dr();
        if (((nQ)object).Dr() != null) {
            object = new byte[k_0.zH(((nQ)object).Dr().Dr())];
            this.i((byte[])object);
            byte[] byArray = new byte[2];
            this.i(byArray);
            return new yq(n2, cArray, (byte[])object, byArray);
        }
        throw new IOException("invalid aes extra data record");
    }
}

