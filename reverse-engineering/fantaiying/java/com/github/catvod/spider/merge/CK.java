/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Os;
import com.github.catvod.spider.merge.SY;
import com.github.catvod.spider.merge.hB;
import com.github.catvod.spider.merge.j;
import com.github.catvod.spider.merge.ku_0;
import com.github.catvod.spider.merge.lF;
import com.github.catvod.spider.merge.l_0;
import com.github.catvod.spider.merge.le_1;
import com.github.catvod.spider.merge.ly_1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;

public abstract class CK {
    public static final hB SN = new hB();
    public final int yq;

    protected CK(int n) {
        this.yq = n;
    }

    public static CK SN(CK cK, ku_0 ku_02, IdentityHashMap<CK, CK> identityHashMap) {
        if (cK.i()) {
            return cK;
        }
        Object object = identityHashMap.get(cK);
        if (object != null) {
            return object;
        }
        object = (CK)((HashMap)ku_02.yq).get(cK);
        if (object != null) {
            identityHashMap.put(cK, (CK)object);
            return object;
        }
        object = new CK[cK.Gc()];
        int n = 0;
        for (int i2 = 0; i2 < ((CK[])object).length; ++i2) {
            int n2;
            CK[] cKArray;
            block11: {
                CK cK2;
                block10: {
                    cK2 = CK.SN(cK.N(i2), ku_02, identityHashMap);
                    if (n != 0) break block10;
                    cKArray = object;
                    n2 = n;
                    if (cK2 == cK.N(i2)) break block11;
                }
                n2 = n;
                if (n == 0) {
                    object = new CK[cK.Gc()];
                    for (n = 0; n < cK.Gc(); ++n) {
                        object[n] = cK.N(n);
                    }
                    n2 = 1;
                }
                object[i2] = cK2;
                cKArray = object;
            }
            object = cKArray;
            n = n2;
        }
        if (n == 0) {
            ku_02.yq(cK);
            identityHashMap.put(cK, cK);
            return cK;
        }
        object = ((CK[])object).length == 0 ? SN : (((CK[])object).length == 1 ? SY.M(object[0], cK.tF(0)) : new l_0((CK[])object, ((l_0)cK).tF));
        ku_02.yq((CK)object);
        identityHashMap.put((CK)object, (CK)object);
        identityHashMap.put(cK, (CK)object);
        return object;
    }

    /*
     * Exception decompiling
     */
    public static CK t0(CK var0, CK var1_1, boolean var2_2, le_1<CK, CK, CK> var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static CK yq(lF lF2, ly_1 ly_12) {
        ly_1 ly_13 = ly_12;
        if (ly_12 == null) {
            ly_13 = ly_1.N;
        }
        if ((ly_12 = ly_13.yq) != null && ly_13 != ly_1.N) {
            return SY.M(CK.yq(lF2, ly_12), ((Os)((j)((ArrayList)lF2.yq).get((int)ly_13.SN)).tF((int)0)).N.SN);
        }
        return SN;
    }

    public abstract int Gc();

    public abstract CK N(int var1);

    public abstract boolean equals(Object var1);

    public final int hashCode() {
        return this.yq;
    }

    public boolean i() {
        boolean bl = this == SN;
        return bl;
    }

    public abstract int tF(int var1);

    public final boolean zH() {
        int n = this.Gc();
        boolean bl = true;
        if (this.tF(n - 1) != Integer.MAX_VALUE) {
            bl = false;
        }
        return bl;
    }
}

