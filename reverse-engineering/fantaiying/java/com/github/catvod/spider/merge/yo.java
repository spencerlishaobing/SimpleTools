/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.B7;
import com.github.catvod.spider.merge.I;
import com.github.catvod.spider.merge.LX;
import com.github.catvod.spider.merge.NJ;
import com.github.catvod.spider.merge.NW;
import com.github.catvod.spider.merge.Th;
import com.github.catvod.spider.merge.V;
import com.github.catvod.spider.merge.Y;
import com.github.catvod.spider.merge.Z8;
import com.github.catvod.spider.merge.a0;
import com.github.catvod.spider.merge.am_0;
import com.github.catvod.spider.merge.bA;
import com.github.catvod.spider.merge.cp;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.ma_0;
import com.github.catvod.spider.merge.mt_0;
import com.github.catvod.spider.merge.nQ;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.rt_0;
import com.github.catvod.spider.merge.uo_0;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.CRC32;

public final class yo
extends InputStream {
    private boolean Gc = false;
    private boolean KJ = false;
    private a0 M;
    private Z8 N = new Z8();
    private ma_0 SN;
    private CRC32 i = new CRC32();
    private boolean q = false;
    private byte[] t0;
    private char[] tF;
    private PushbackInputStream yq;
    private B7 zH;

    public yo(InputStream inputStream, char[] cArray, a0 a02) {
        if (a02.yq() >= 512) {
            this.yq = new PushbackInputStream(inputStream, a02.yq());
            this.tF = cArray;
            this.M = a02;
            return;
        }
        throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
    }

    private boolean N(B7 b7) {
        boolean bl = b7.R() && cp.yq(2, b7.Fz());
        return bl;
    }

    private void yq() {
        Object object;
        this.SN.N(this.yq);
        this.SN.yq(this.yq);
        boolean bl = this.zH.xU();
        int n2 = 1;
        if (bl && !this.Gc) {
            Z8 z8;
            block6: {
                z8 = this.N;
                object = this.yq;
                Object object2 = this.zH.E1();
                boolean bl2 = false;
                if (object2 == null) {
                    bl = bl2;
                } else {
                    object2 = object2.iterator();
                    do {
                        bl = bl2;
                        if (!object2.hasNext()) break block6;
                    } while (((bA)object2.next()).g() != V.SN(11));
                    bl = true;
                }
            }
            object = z8.tF((InputStream)object, bl);
            this.zH.lF(((rt_0)object).Dr());
            this.zH.L(((rt_0)object).H());
            this.zH.Q4(((rt_0)object).g());
        }
        if (!(this.zH.Fz() == 4 && cp.yq(this.zH.Dr().g(), 2) || this.zH.U() == this.i.getValue())) {
            if (!this.N(this.zH)) {
                n2 = 3;
            }
            object = oi_0.yq("Reached end of entry, but crc verification failed for ");
            ((StringBuilder)object).append(this.zH.m());
            throw new mt_0(((StringBuilder)object).toString(), n2);
        }
        this.zH = null;
        this.i.reset();
        this.q = true;
    }

    public final B7 SN(NJ object) {
        B7 b7;
        block20: {
            block18: {
                block19: {
                    block17: {
                        long l;
                        block12: {
                            int n2;
                            block16: {
                                block14: {
                                    block15: {
                                        block13: {
                                            block11: {
                                                b7 = this.zH;
                                                if (b7 != null && (!b7.N0() && this.zH.g() != 0L || this.zH.xU())) {
                                                    if (this.t0 == null) {
                                                        this.t0 = new byte[512];
                                                    }
                                                    while (this.read(this.t0) != -1) {
                                                    }
                                                    this.q = true;
                                                }
                                                this.zH = b7 = this.N.i(this.yq, this.M.SN());
                                                if (b7 == null) {
                                                    return null;
                                                }
                                                String string = b7.m();
                                                n2 = !string.endsWith("/") && !string.endsWith("\\") ? 0 : 1;
                                                if (n2 == 0 && b7.H() == 1 && b7.Z() < 0L) {
                                                    object = oi_0.yq("Invalid local file header for: ");
                                                    ((StringBuilder)object).append(b7.m());
                                                    ((StringBuilder)object).append(". Uncompressed size has to be set for entry of compression type store which is not a directory");
                                                    throw new IOException(((StringBuilder)object).toString());
                                                }
                                                this.i.reset();
                                                this.zH.Q4(((nQ)object).U());
                                                this.zH.lF(((nQ)object).g());
                                                this.zH.L(((nQ)object).Z());
                                                this.zH.w(((nQ)object).N0());
                                                this.Gc = true;
                                                b7 = this.zH;
                                                object = this.yq;
                                                if (!cp.yq(rs_0.G4(b7), 1)) break block11;
                                                l = b7.Z();
                                                break block12;
                                            }
                                            if (!b7.xU() || this.Gc) break block13;
                                            l = -1L;
                                            break block12;
                                        }
                                        l = b7.g();
                                        boolean bl = b7.R();
                                        n2 = 12;
                                        if (!bl) break block14;
                                        if (!cp.yq(b7.Fz(), 4)) break block15;
                                        n2 = 12 + k_0.zH(b7.Dr().Dr());
                                        break block16;
                                    }
                                    if (cp.yq(b7.Fz(), 2)) break block16;
                                }
                                n2 = 0;
                            }
                            l -= (long)n2;
                        }
                        object = new uo_0((InputStream)object, l);
                        if (b7.R()) break block17;
                        object = new LX((uo_0)object, b7, this.tF, this.M.yq());
                        break block18;
                    }
                    if (b7.Fz() != 4) break block19;
                    object = new I((uo_0)object, b7, this.tF, this.M.yq());
                    break block18;
                }
                if (b7.Fz() != 2) break block20;
                object = new NW((uo_0)object, b7, this.tF, this.M.yq());
            }
            object = rs_0.G4(b7) == 2 ? new am_0((Y)object, this.M.yq()) : new Th((Y)object);
            this.SN = object;
            this.q = false;
            return this.zH;
        }
        object = new mt_0(String.format("Entry [%s] Strong Encryption not supported", b7.m()), 6);
        throw object;
    }

    @Override
    public final int available() {
        if (!this.KJ) {
            return this.q ^ 1;
        }
        throw new IOException("Stream closed");
    }

    @Override
    public final void close() {
        if (this.KJ) {
            return;
        }
        ma_0 ma_02 = this.SN;
        if (ma_02 != null) {
            ma_02.close();
        }
        this.KJ = true;
    }

    @Override
    public final int read() {
        byte[] byArray = new byte[1];
        if (this.read(byArray, 0, 1) == -1) {
            return -1;
        }
        return byArray[0] & 0xFF;
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
    public final int read(byte[] byArray, int n2, int n3) {
        if (this.KJ) throw new IOException("Stream closed");
        if (n3 < 0) throw new IllegalArgumentException("Negative read length");
        if (n3 == 0) {
            return 0;
        }
        B7 b7 = this.zH;
        if (b7 == null) {
            return -1;
        }
        if (b7.N0()) {
            return -1;
        }
        try {
            n3 = this.SN.read(byArray, n2, n3);
            if (n3 == -1) {
                this.yq();
                return n3;
            }
            this.i.update(byArray, n2, n3);
            return n3;
        }
        catch (IOException iOException) {
            if (!this.N(this.zH)) throw iOException;
            throw new mt_0(iOException.getMessage(), iOException.getCause());
        }
    }
}

