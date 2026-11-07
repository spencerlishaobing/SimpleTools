/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.CC;
import com.github.catvod.spider.merge.Cr;
import com.github.catvod.spider.merge.I8;
import com.github.catvod.spider.merge.OM;
import com.github.catvod.spider.merge.RL;
import com.github.catvod.spider.merge.TA;
import com.github.catvod.spider.merge.Ud;
import com.github.catvod.spider.merge.Z8;
import com.github.catvod.spider.merge.a0;
import com.github.catvod.spider.merge.fz_0;
import com.github.catvod.spider.merge.mt_0;
import com.github.catvod.spider.merge.oX;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.Sy
 */
public final class sy_0
implements Closeable {
    private Ud N;
    private fz_0 SN;
    private Charset tF = null;
    private File yq;
    private List<InputStream> zH = new ArrayList<InputStream>();

    public sy_0(File file) {
        this.yq = file;
        this.N = new Ud();
    }

    private RandomAccessFile N() {
        if (this.yq.getName().endsWith(".zip.001")) {
            Object object = CC.SN(this.yq);
            object = new OM(this.yq, Cr.N(1), (File[])object);
            ((OM)object).yq();
            return object;
        }
        return new RandomAccessFile(this.yq, Cr.N(1));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void zH() {
        if (this.SN != null) {
            return;
        }
        if (!this.yq.exists()) {
            fz_0 fz_02;
            this.SN = fz_02 = new fz_0();
            fz_02.G4(this.yq);
            return;
        }
        if (!this.yq.canRead()) throw new mt_0("no read access for the input zip file");
        RandomAccessFile randomAccessFile = this.N();
        try {
            Z8 z8 = new Z8();
            Object object = new a0(this.tF, 4096);
            this.SN = object = z8.N(randomAccessFile, (a0)object);
            ((fz_0)object).G4(this.yq);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                try {
                    randomAccessFile.close();
                    throw throwable2;
                }
                catch (Throwable throwable3) {
                    try {
                        throwable.addSuppressed(throwable3);
                        throw throwable2;
                    }
                    catch (IOException iOException) {
                        throw new mt_0(iOException);
                    }
                    catch (mt_0 mt_02) {
                        throw mt_02;
                    }
                }
            }
        }
        randomAccessFile.close();
    }

    public final List<File> SN() {
        block7: {
            block10: {
                Object object;
                block9: {
                    int n2;
                    fz_0 fz_02;
                    block8: {
                        this.zH();
                        fz_02 = this.SN;
                        if (fz_02 == null) break block7;
                        if (fz_02.SN() != null) break block8;
                        object = null;
                        break block9;
                    }
                    if (!fz_02.zH().exists()) break block10;
                    ArrayList<File> arrayList = new ArrayList<File>();
                    File file = fz_02.zH();
                    if (!fz_02.i() || (n2 = fz_02.SN().Dr()) == 0) {
                        arrayList.add(file);
                    } else {
                        for (int i2 = 0; i2 <= n2; ++i2) {
                            if (i2 == n2) {
                                arrayList.add(fz_02.zH());
                                continue;
                            }
                            object = i2 >= 9 ? ".z" : ".z0";
                            String string = file.getName().contains(".") ? file.getPath().substring(0, file.getPath().lastIndexOf(".")) : file.getPath();
                            object = oX.yq(string, (String)object);
                            ((StringBuilder)object).append(i2 + 1);
                            arrayList.add(new File(((StringBuilder)object).toString()));
                        }
                    }
                    object = arrayList;
                }
                return object;
            }
            throw new mt_0("zip file does not exist");
        }
        mt_0 mt_02 = new mt_0("cannot get split zip files: zipmodel is null");
        throw mt_02;
    }

    @Override
    public final void close() {
        Iterator iterator = ((ArrayList)this.zH).iterator();
        while (iterator.hasNext()) {
            ((InputStream)iterator.next()).close();
        }
        ((ArrayList)this.zH).clear();
    }

    public final void i(Charset charset) {
        if (charset != null) {
            this.tF = charset;
            return;
        }
        throw new IllegalArgumentException("charset cannot be null");
    }

    public final boolean tF() {
        if (!this.yq.exists()) {
            return false;
        }
        try {
            this.zH();
            if (this.SN.i()) {
                boolean bl;
                block6: {
                    Iterator<File> iterator = this.SN().iterator();
                    while (iterator.hasNext()) {
                        boolean bl2 = iterator.next().exists();
                        if (bl2) continue;
                        bl = false;
                        break block6;
                    }
                    bl = true;
                }
                if (!bl) {
                    return false;
                }
            }
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public final String toString() {
        return this.yq.toString();
    }

    public final void yq(String string) {
        block7: {
            block10: {
                Object object;
                TA tA;
                block9: {
                    block8: {
                        tA = new TA();
                        boolean bl = string != null && string.trim().length() > 0;
                        if (!bl) break block7;
                        object = new File(string);
                        if (!((File)object).exists()) break block8;
                        if (!((File)object).isDirectory()) {
                            throw new mt_0("output directory is not valid");
                        }
                        break block9;
                    }
                    if (!((File)object).mkdirs()) break block10;
                }
                if (this.SN == null) {
                    this.zH();
                }
                if ((object = this.SN) != null) {
                    new I8((fz_0)object, null, tA, new RL.SN(null, this.N)).tF(new I8.yq(string, new a0(this.tF, 4096)));
                    return;
                }
                throw new mt_0("Internal error occurred when extracting zip file");
            }
            throw new mt_0("Cannot create output directories");
        }
        throw new mt_0("output path is null or invalid");
    }
}

