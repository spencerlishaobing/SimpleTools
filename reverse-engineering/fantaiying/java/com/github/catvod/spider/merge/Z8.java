/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.B7;
import com.github.catvod.spider.merge.Cr;
import com.github.catvod.spider.merge.DS;
import com.github.catvod.spider.merge.Gx;
import com.github.catvod.spider.merge.I9;
import com.github.catvod.spider.merge.Kt;
import com.github.catvod.spider.merge.N;
import com.github.catvod.spider.merge.NJ;
import com.github.catvod.spider.merge.OM;
import com.github.catvod.spider.merge.T;
import com.github.catvod.spider.merge.TA;
import com.github.catvod.spider.merge.V;
import com.github.catvod.spider.merge.a0;
import com.github.catvod.spider.merge.bA;
import com.github.catvod.spider.merge.fz_0;
import com.github.catvod.spider.merge.ht;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.mt_0;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.pD;
import com.github.catvod.spider.merge.rq_0;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.rt_0;
import com.github.catvod.spider.merge.vt;
import com.github.catvod.spider.merge.wg;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Z8 {
    private final byte[] N;
    private final DS SN = new DS();
    private fz_0 yq;

    public Z8() {
        this.N = new byte[4];
    }

    private void Gc(RandomAccessFile randomAccessFile, long l) {
        if (randomAccessFile instanceof OM) {
            ((OM)randomAccessFile).N(l);
        } else {
            randomAccessFile.seek(l);
        }
    }

    private N SN(List<bA> object, DS dS) {
        if (object == null) {
            return null;
        }
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (bA)object.next();
            if (object2 == null || ((bA)object2).g() != V.SN(12)) continue;
            if (((bA)object2).Dr() != null) {
                object = new N();
                object2 = ((bA)object2).Dr();
                ((N)object).Fz(rq_0.yq(dS.B((byte[])object2, 0)));
                byte[] byArray = new byte[2];
                System.arraycopy(object2, 2, byArray, 0, 2);
                new String(byArray);
                ((N)object).U(k_0.yq(object2[4] & 0xFF));
                ((N)object).E1(Cr.yq(dS.B((byte[])object2, 5)));
                return object;
            }
            throw new mt_0("corrupt AES extra data records");
        }
        return null;
    }

    private Kt t0(List<bA> object, DS dS, long l, long l2, long l5, int n2) {
        Object object2 = object.iterator();
        while (object2.hasNext()) {
            int n3;
            object = object2.next();
            if (object == null || V.SN(11) != ((bA)object).g()) continue;
            Kt kt = new Kt();
            object2 = ((bA)object).Dr();
            if (((bA)object).H() <= 0) {
                return null;
            }
            int n4 = n3 = 0;
            if (((bA)object).H() > 0) {
                n4 = n3;
                if (l == 0xFFFFFFFFL) {
                    kt.m(dS.t0((byte[])object2, 0));
                    n4 = 8;
                }
            }
            n3 = n4;
            if (n4 < ((bA)object).H()) {
                n3 = n4;
                if (l2 == 0xFFFFFFFFL) {
                    kt.Fz(dS.t0((byte[])object2, n4));
                    n3 = n4 + 8;
                }
            }
            n4 = n3;
            if (n3 < ((bA)object).H()) {
                n4 = n3;
                if (l5 == 0xFFFFFFFFL) {
                    kt.tO(dS.t0((byte[])object2, n3));
                    n4 = n3 + 8;
                }
            }
            if (n4 < ((bA)object).H() && n2 == 65535) {
                kt.E1(dS.tF((byte[])object2, n4));
            }
            return kt;
        }
        return null;
    }

    private List<bA> yq(byte[] object, int n2) {
        ArrayList<bA> arrayList = new ArrayList<bA>();
        int n3 = 0;
        while (n3 < n2) {
            bA bA2 = new bA();
            bA2.Fz(this.SN.B((byte[])object, n3));
            int n4 = n3 + 2;
            n3 = this.SN.B((byte[])object, n4);
            bA2.E1(n3);
            n4 += 2;
            if (n3 > 0) {
                byte[] byArray = new byte[n3];
                System.arraycopy(object, n4, byArray, 0, n3);
                bA2.U(byArray);
            }
            n3 = n4 + n3;
            arrayList.add(bA2);
        }
        object = arrayList.size() > 0 ? (Object)arrayList : null;
        return object;
    }

    /*
     * Unable to fully structure code
     */
    private vt zH(RandomAccessFile var1_1, DS var2_3, a0 var3_4) {
        block7: {
            var5_5 = var1_1.length();
            if (var5_5 < 22L) break block7;
            var7_6 = var5_5 - 22L;
            this.Gc((RandomAccessFile)var1_1, var7_6);
            if ((long)this.SN.N((RandomAccessFile)var1_1) == V.SN(4)) ** GOTO lbl16
            var9_7 = var1_1.length() - 22L;
            var11_8 = var1_1.length();
            var5_5 = 65536L;
            var7_6 = var9_7;
            if (var11_8 < 65536L) {
                var5_5 = var1_1.length();
                var7_6 = var9_7;
            }
            while (var5_5 > 0L && var7_6 > 0L) {
                block8: {
                    block9: {
                        block6: {
                            this.Gc((RandomAccessFile)var1_1, --var7_6);
                            if ((long)this.SN.N((RandomAccessFile)var1_1) != V.SN(4)) break block8;
lbl16:
                            // 2 sources

                            this.Gc((RandomAccessFile)var1_1, 4L + var7_6);
                            var14_9 = new vt();
                            var14_9.Fz(var2_3.q((RandomAccessFile)var1_1));
                            var2_3.q((RandomAccessFile)var1_1);
                            var2_3.q((RandomAccessFile)var1_1);
                            var14_9.m(var2_3.q((RandomAccessFile)var1_1));
                            var2_3.N((RandomAccessFile)var1_1);
                            var14_9.E1(var7_6);
                            var1_1.readFully(this.N);
                            var15_10 = this.N;
                            var13_11 = false;
                            var14_9.tO(var2_3.t0(var15_10, 0));
                            var4_12 = var2_3.q((RandomAccessFile)var1_1);
                            var2_3 = var3_4.SN();
                            if (var4_12 <= 0) break block9;
                            var3_4 = new byte[var4_12];
                            var1_1.readFully((byte[])var3_4);
                            if (var2_3 == null) break block6;
                            var1_1 = var2_3;
                            ** GOTO lbl43
                        }
                        try {
                            var1_1 = ht.N;
lbl43:
                            // 2 sources

                            TA.SN((byte[])var3_4, false, (Charset)var1_1);
                        }
                        catch (IOException var1_2) {
                            // empty catch block
                        }
                    }
                    var1_1 = this.yq;
                    if (var14_9.Dr() > 0) {
                        var13_11 = true;
                    }
                    var1_1.KJ(var13_11);
                    return var14_9;
                }
                --var5_5;
            }
            throw new mt_0("Zip headers not found. Probably not a zip file");
        }
        var1_1 = new mt_0("Zip file size less than size of zip headers. Probably not a zip file.");
        throw var1_1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final fz_0 N(RandomAccessFile object, a0 object2) {
        Object object3 = this;
        if (((RandomAccessFile)object).length() >= 22L) {
            ArrayList<NJ> arrayList;
            DS dS;
            Object object4;
            Object object5;
            block32: {
                long l;
                Object object6;
                object5 = new fz_0();
                ((Z8)object3).yq = object5;
                try {
                    ((fz_0)object5).M(((Z8)object3).zH((RandomAccessFile)object, ((Z8)object3).SN, (a0)object2));
                    if (((Z8)object3).yq.SN().U() == 0) {
                        return ((Z8)object3).yq;
                    }
                    object4 = ((Z8)object3).yq;
                    object6 = ((Z8)object3).SN;
                    l = ((fz_0)object4).SN().g();
                    object5 = new I9();
                    ((Z8)object3).Gc((RandomAccessFile)object, l - 4L - 8L - 4L - 4L);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    throw new mt_0("Zip headers not found. Probably not a zip file or a corrupted zip file", iOException);
                }
                catch (mt_0 mt_02) {
                    throw mt_02;
                }
                if ((long)((DS)object6).N((RandomAccessFile)object) == V.SN(9)) {
                    ((Z8)object3).yq.G(true);
                    ((DS)object6).N((RandomAccessFile)object);
                    ((I9)object5).g(((DS)object6).i((RandomAccessFile)object));
                    ((DS)object6).N((RandomAccessFile)object);
                } else {
                    ((Z8)object3).yq.G(false);
                    object5 = null;
                }
                ((fz_0)object4).q((I9)object5);
                if (((Z8)object3).yq.t0()) {
                    object4 = ((Z8)object3).yq;
                    object6 = ((Z8)object3).SN;
                    if (((fz_0)object4).N() == null) throw new mt_0("invalid zip64 end of central directory locator");
                    l = ((Z8)object3).yq.N().Dr();
                    if (l < 0L) throw new mt_0("invalid offset for start of end of central directory record");
                    ((RandomAccessFile)object).seek(l);
                    object5 = new pD();
                    if ((long)((DS)object6).N((RandomAccessFile)object) != V.SN(10)) throw new mt_0("invalid signature for zip64 end of central directory record");
                    ((pD)object5).tO(((DS)object6).i((RandomAccessFile)object));
                    ((DS)object6).q((RandomAccessFile)object);
                    ((DS)object6).q((RandomAccessFile)object);
                    ((pD)object5).Fz(((DS)object6).N((RandomAccessFile)object));
                    ((DS)object6).N((RandomAccessFile)object);
                    ((DS)object6).i((RandomAccessFile)object);
                    ((pD)object5).m(((DS)object6).i((RandomAccessFile)object));
                    ((DS)object6).i((RandomAccessFile)object);
                    ((pD)object5).E1(((DS)object6).i((RandomAccessFile)object));
                    l = ((pD)object5).H() - 44L;
                    if (l > 0L) {
                        ((RandomAccessFile)object).readFully(new byte[(int)l]);
                    }
                    ((fz_0)object4).B((pD)object5);
                    if (((Z8)object3).yq.tF() != null && ((Z8)object3).yq.tF().Dr() > 0) {
                        ((Z8)object3).yq.KJ(true);
                    } else {
                        ((Z8)object3).yq.KJ(false);
                    }
                }
                object4 = ((Z8)object3).yq;
                dS = ((Z8)object3).SN;
                Charset charset = ((a0)object2).SN();
                object5 = new Gx();
                arrayList = new ArrayList<NJ>();
                object2 = ((Z8)object3).yq;
                long l2 = ((fz_0)object2).t0() ? ((fz_0)object2).tF().g() : ((fz_0)object2).SN().H();
                object2 = ((Z8)object3).yq;
                l = ((fz_0)object2).t0() ? ((fz_0)object2).tF().U() : (long)((fz_0)object2).SN().U();
                ((RandomAccessFile)object).seek(l2);
                object6 = new byte[2];
                object2 = new byte[4];
                int n2 = 0;
                object3 = object4;
                object4 = object2;
                while (true) {
                    String string;
                    object2 = this;
                    if ((long)n2 >= l) break block32;
                    NJ nJ = new NJ();
                    if ((long)dS.N((RandomAccessFile)object) != V.SN(3)) break;
                    dS.q((RandomAccessFile)object);
                    dS.q((RandomAccessFile)object);
                    object2 = new byte[2];
                    ((RandomAccessFile)object).readFully((byte[])object2);
                    nJ.mG(wg.tF((byte)object2[0], 0));
                    nJ.p(wg.tF((byte)object2[0], 3));
                    nJ.LY(wg.tF((byte)object2[1], 3));
                    nJ.nQ((byte[])object2.clone());
                    nJ.C(Cr.yq(dS.q((RandomAccessFile)object)));
                    nJ.kR(dS.N((RandomAccessFile)object));
                    ((RandomAccessFile)object).readFully((byte[])object4);
                    nJ.Q4(dS.t0((byte[])object4, 0));
                    nJ.lF(dS.M((RandomAccessFile)object));
                    nJ.L(dS.M((RandomAccessFile)object));
                    int n3 = dS.q((RandomAccessFile)object);
                    nJ.j(dS.q((RandomAccessFile)object));
                    int n4 = dS.q((RandomAccessFile)object);
                    nJ.OB(dS.q((RandomAccessFile)object));
                    ((RandomAccessFile)object).readFully((byte[])object6);
                    ((RandomAccessFile)object).readFully((byte[])object4);
                    nJ.x((byte[])object4.clone());
                    ((RandomAccessFile)object).readFully((byte[])object4);
                    nJ.ue(dS.t0((byte[])object4, 0));
                    if (n3 > 0) {
                        object2 = new byte[n3];
                        ((RandomAccessFile)object).readFully((byte[])object2);
                        string = TA.SN((byte[])object2, nJ.J(), charset);
                        object2 = string;
                        if (string.contains(":\\")) {
                            object2 = string.substring(string.indexOf(":\\") + 2);
                        }
                        nJ.o((String)object2);
                    } else {
                        nJ.o(null);
                    }
                    object2 = nJ.u7();
                    string = nJ.m();
                    boolean bl = object2[0] != false && wg.tF((byte)object2[0], 4) || object2[3] != false && wg.tF((byte)object2[3], 6) || string != null && (string.endsWith("/") || string.endsWith("\\"));
                    nJ.w(bl);
                    n3 = nJ.tO();
                    if (n3 > 0) {
                        if (n3 < 4) {
                            if (n3 > 0) {
                                ((RandomAccessFile)object).skipBytes(n3);
                            }
                            object2 = null;
                        } else {
                            object2 = new byte[n3];
                            ((RandomAccessFile)object).read((byte[])object2);
                            try {
                                object2 = this.yq((byte[])object2, n3);
                            }
                            catch (Exception exception) {
                                object2 = Collections.emptyList();
                            }
                        }
                        nJ.XO((List<bA>)object2);
                    }
                    if (nJ.E1() != null && nJ.E1().size() > 0) {
                        long l5;
                        long l6;
                        object2 = nJ.E1();
                        l2 = nJ.Z();
                        if ((object2 = this.t0((List<bA>)object2, dS, l2, l6 = nJ.g(), l5 = nJ.cS(), n3 = nJ.cp())) != null) {
                            nJ.Cu((Kt)object2);
                            if (((Kt)object2).U() != -1L) {
                                nJ.L(((Kt)object2).U());
                            }
                            if (((Kt)object2).Dr() != -1L) {
                                nJ.lF(((Kt)object2).Dr());
                            }
                            if (((Kt)object2).H() != -1L) {
                                nJ.ue(((Kt)object2).H());
                            }
                            if (((Kt)object2).g() != -1) {
                                nJ.OB(((Kt)object2).g());
                            }
                        }
                    }
                    if (nJ.E1() != null && nJ.E1().size() > 0 && (object2 = this.SN(nJ.E1(), dS)) != null) {
                        nJ.i3((N)object2);
                        nJ.Hj(4);
                    }
                    if (n4 > 0) {
                        object2 = new byte[n4];
                        ((RandomAccessFile)object).readFully((byte[])object2);
                        TA.SN(object2, nJ.J(), charset);
                    }
                    if (nJ.R()) {
                        n4 = nJ.Dr() != null ? 4 : 2;
                        nJ.Hj(n4);
                    }
                    arrayList.add(nJ);
                    ++n2;
                    object2 = this;
                }
                object = oi_0.yq("Expected central directory entry not found (#");
                ((StringBuilder)object).append(n2 + 1);
                ((StringBuilder)object).append(")");
                throw new mt_0(((StringBuilder)object).toString());
            }
            ((Gx)object5).SN(arrayList);
            object4 = new T();
            if ((long)dS.N((RandomAccessFile)object) == V.SN(6)) {
                ((T)object4).g(dS.q((RandomAccessFile)object));
                if (((T)object4).Dr() > 0) {
                    object4 = new byte[((T)object4).Dr()];
                    ((RandomAccessFile)object).readFully((byte[])object4);
                    new String((byte[])object4);
                }
            }
            ((fz_0)object3).Gc((Gx)object5);
            return ((Z8)object2).yq;
        }
        object = new mt_0("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
        throw object;
    }

    public final B7 i(InputStream object, Charset object2) {
        int n2;
        B7 b7 = new B7();
        Object object3 = new byte[4];
        int n3 = n2 = this.SN.SN((InputStream)object);
        if ((long)n2 == V.SN(5)) {
            n3 = this.SN.SN((InputStream)object);
        }
        long l = n3;
        boolean bl = true;
        long l2 = V.SN(1);
        Object var11_11 = null;
        if (l != l2) {
            return null;
        }
        this.SN.KJ((InputStream)object);
        n3 = 2;
        Object object4 = new byte[2];
        if (rs_0.v3((InputStream)object, (byte[])object4) == 2) {
            b7.mG(wg.tF(object4[0], 0));
            b7.p(wg.tF(object4[0], 3));
            b7.LY(wg.tF(object4[1], 3));
            b7.nQ((byte[])object4.clone());
            b7.C(Cr.yq(this.SN.KJ((InputStream)object)));
            b7.kR(this.SN.SN((InputStream)object));
            rs_0.v3((InputStream)object, (byte[])object3);
            b7.Q4(this.SN.t0((byte[])object3, 0));
            b7.lF(this.SN.Gc((InputStream)object));
            b7.L(this.SN.Gc((InputStream)object));
            n2 = this.SN.KJ((InputStream)object);
            b7.j(this.SN.KJ((InputStream)object));
            if (n2 > 0) {
                object4 = new byte[n2];
                rs_0.v3((InputStream)object, (byte[])object4);
                object4 = TA.SN((byte[])object4, b7.J(), (Charset)object2);
                object3 = oi_0.yq(":");
                ((StringBuilder)object3).append(System.getProperty("file.separator"));
                object2 = object4;
                if (((String)object4).contains(((StringBuilder)object3).toString())) {
                    object2 = oi_0.yq(":");
                    ((StringBuilder)object2).append(System.getProperty("file.separator"));
                    object2 = ((String)object4).substring(((String)object4).indexOf(((StringBuilder)object2).toString()) + 2);
                }
                b7.o((String)object2);
                boolean bl2 = bl;
                if (!((String)object2).endsWith("/")) {
                    bl2 = ((String)object2).endsWith("\\") ? bl : false;
                }
                b7.w(bl2);
            } else {
                b7.o(null);
            }
            n2 = b7.tO();
            if (n2 > 0) {
                if (n2 < 4) {
                    object2 = var11_11;
                    if (n2 > 0) {
                        ((InputStream)object).skip(n2);
                        object2 = var11_11;
                    }
                } else {
                    object2 = new byte[n2];
                    rs_0.v3((InputStream)object, (byte[])object2);
                    try {
                        object2 = this.yq((byte[])object2, n2);
                    }
                    catch (Exception exception) {
                        object2 = Collections.emptyList();
                    }
                }
                b7.XO((List<bA>)object2);
            }
            object = this.SN;
            if (b7.E1() != null && b7.E1().size() > 0 && (object = this.t0(b7.E1(), (DS)object, b7.Z(), b7.g(), 0L, 0)) != null) {
                b7.Cu((Kt)object);
                if (((Kt)object).U() != -1L) {
                    b7.L(((Kt)object).U());
                }
                if (((Kt)object).Dr() != -1L) {
                    b7.lF(((Kt)object).Dr());
                }
            }
            object = this.SN;
            if (b7.E1() != null && b7.E1().size() > 0 && (object = this.SN(b7.E1(), (DS)object)) != null) {
                b7.i3((N)object);
                b7.Hj(4);
            }
            if (b7.R() && b7.Fz() != 4) {
                if (wg.tF(b7.k()[0], 6)) {
                    n3 = 3;
                }
                b7.Hj(n3);
            }
            return b7;
        }
        throw new mt_0("Could not read enough bytes for generalPurposeFlags");
    }

    public final rt_0 tF(InputStream inputStream, boolean bl) {
        rt_0 rt_02 = new rt_0();
        byte[] byArray = new byte[4];
        rs_0.v3(inputStream, byArray);
        long l = this.SN.t0(byArray, 0);
        if (l == V.SN(2)) {
            rs_0.v3(inputStream, byArray);
            rt_02.Fz(this.SN.t0(byArray, 0));
        } else {
            rt_02.Fz(l);
        }
        if (bl) {
            rt_02.U(this.SN.zH(inputStream));
            l = this.SN.zH(inputStream);
        } else {
            rt_02.U(this.SN.SN(inputStream));
            l = this.SN.SN(inputStream);
        }
        rt_02.E1(l);
        return rt_02;
    }
}

