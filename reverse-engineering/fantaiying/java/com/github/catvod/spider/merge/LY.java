/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.CC;
import com.github.catvod.spider.merge.NJ;
import com.github.catvod.spider.merge.RL;
import com.github.catvod.spider.merge.TA;
import com.github.catvod.spider.merge.Ud;
import com.github.catvod.spider.merge.Z;
import com.github.catvod.spider.merge.eY;
import com.github.catvod.spider.merge.fz_0;
import com.github.catvod.spider.merge.ht;
import com.github.catvod.spider.merge.mt_0;
import com.github.catvod.spider.merge.nQ;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.wg;
import com.github.catvod.spider.merge.yo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.Objects;
import java.util.regex.Matcher;

public abstract class LY<T>
extends RL<T> {
    private final fz_0 tF;
    private final TA zH;

    public LY(fz_0 fz_02, TA tA, RL.SN sN) {
        super(sN);
        this.tF = fz_02;
        this.zH = tA;
    }

    private boolean KJ(NJ object) {
        if ((object = (Object)((NJ)object).u7()) != null && ((Object)object).length >= 4) {
            return wg.tF((byte)object[3], 5);
        }
        return false;
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected final void Gc(yo object, NJ nJ, String object2, Ud object3, byte[] byArray) {
        if (this.KJ(nJ)) {
            Objects.requireNonNull(this.zH);
        }
        CharSequence charSequence = ht.yq;
        Object object4 = object2;
        if (!((String)object2).endsWith((String)charSequence)) {
            object4 = eY.yq((String)object2, (String)charSequence);
        }
        object2 = new File(Z.SN((String)object4, (String)charSequence, nJ.m().replaceAll("[/\\\\]", Matcher.quoteReplacement((String)charSequence))));
        ((File)object2).getAbsolutePath();
        Objects.requireNonNull(object3);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(new File((String)object4).getCanonicalPath());
        ((StringBuilder)charSequence).append(File.separator);
        object4 = ((StringBuilder)charSequence).toString();
        if (((File)object2).getCanonicalPath().startsWith((String)object4)) {
            if (!wg.tF(nJ.k()[0], 6)) {
                object4 = ((yo)object).SN(nJ);
                if (object4 != null) {
                    block38: {
                        if (!nJ.m().equals(((nQ)object4).m())) throw new mt_0("File header and local file header mismatch");
                        if (nJ.N0()) {
                            if (!((File)object2).exists() && !((File)object2).mkdirs()) {
                                object = new StringBuilder();
                                ((StringBuilder)object).append("Could not create directory: ");
                                ((StringBuilder)object).append(object2);
                                throw new mt_0(((StringBuilder)object).toString());
                            }
                        } else if (this.KJ(nJ)) {
                            int n2 = (int)nJ.Z();
                            byArray = new byte[n2];
                            if (((yo)object).read(byArray, 0, n2) != n2) throw new mt_0("Could not read complete entry");
                            ((Ud)object3).t0(n2);
                            object = new String(byArray);
                            if (!((File)object2).getParentFile().exists() && !((File)object2).getParentFile().mkdirs()) {
                                throw new mt_0("Could not create parent directories");
                            }
                            try {
                                object3 = Paths.get((String)object, new String[0]);
                                Files.createSymbolicLink(((File)object2).toPath(), (Path)object3, new FileAttribute[0]);
                            }
                            catch (NoSuchMethodError noSuchMethodError) {
                                FileOutputStream fileOutputStream = new FileOutputStream((File)object2);
                                try {
                                    ((OutputStream)fileOutputStream).write(((String)object).getBytes());
                                }
                                catch (Throwable throwable) {
                                    try {
                                        throw throwable;
                                    }
                                    catch (Throwable throwable2) {
                                        try {
                                            ((OutputStream)fileOutputStream).close();
                                            throw throwable2;
                                        }
                                        catch (Throwable throwable3) {
                                            throwable.addSuppressed(throwable3);
                                        }
                                        throw throwable2;
                                    }
                                }
                                ((OutputStream)fileOutputStream).close();
                            }
                        } else {
                            if (!((File)object2).getParentFile().exists() && !((File)object2).getParentFile().mkdirs()) {
                                object = oi_0.yq("Unable to create parent directories: ");
                                ((StringBuilder)object).append(((File)object2).getParentFile());
                                throw new mt_0(((StringBuilder)object).toString());
                            }
                            object4 = new FileOutputStream((File)object2);
                            while (true) {
                                int n3 = ((yo)object).read(byArray, 0, byArray.length);
                                if (n3 == -1) break;
                                ((OutputStream)object4).write(byArray, 0, n3);
                                ((Ud)object3).t0(n3);
                                this.t0();
                                continue;
                                break;
                            }
                            ((OutputStream)object4).close();
                        }
                        object = ((File)object2).toPath();
                        CC.N((Path)object, nJ.u7());
                        long l = nJ.RQ();
                        if (l <= 0L) break block38;
                        boolean bl = Files.exists((Path)object, new LinkOption[0]);
                        if (!bl) break block38;
                        try {
                            Files.setLastModifiedTime((Path)object, FileTime.fromMillis(rs_0.B(l)));
                            return;
                        }
                        catch (NoSuchMethodError noSuchMethodError) {
                            ((File)object2).setLastModified(rs_0.B(nJ.RQ()));
                        }
                    }
                    return;
                    catch (Throwable throwable) {
                        try {
                            throw throwable;
                        }
                        catch (Throwable throwable4) {
                            try {
                                ((OutputStream)object4).close();
                                throw throwable4;
                            }
                            catch (Throwable throwable5) {
                                try {
                                    throwable.addSuppressed(throwable5);
                                    throw throwable4;
                                }
                                catch (Exception exception) {
                                    if (!((File)object2).exists()) throw exception;
                                    ((File)object2).delete();
                                    throw exception;
                                }
                            }
                        }
                    }
                }
                object = oi_0.yq("Could not read corresponding local file header for file header: ");
                ((StringBuilder)object).append(nJ.m());
                throw new mt_0(((StringBuilder)object).toString());
            }
            object = oi_0.yq("Entry with name ");
            ((StringBuilder)object).append(nJ.m());
            ((StringBuilder)object).append(" is encrypted with Strong Encryption. Zip4j does not support Strong Encryption, as this is patented.");
            throw new mt_0(((StringBuilder)object).toString());
        }
        object = oi_0.yq("illegal file name that breaks out of the target directory: ");
        ((StringBuilder)object).append(nJ.m());
        object = new mt_0(((StringBuilder)object).toString());
        throw object;
        catch (Exception exception) {
            return;
        }
    }

    public final fz_0 M() {
        return this.tF;
    }
}

