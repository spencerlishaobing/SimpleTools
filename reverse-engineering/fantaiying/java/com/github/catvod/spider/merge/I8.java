/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.AD;
import com.github.catvod.spider.merge.LY;
import com.github.catvod.spider.merge.NJ;
import com.github.catvod.spider.merge.RL;
import com.github.catvod.spider.merge.TA;
import com.github.catvod.spider.merge.Ud;
import com.github.catvod.spider.merge.ZQ;
import com.github.catvod.spider.merge.a0;
import com.github.catvod.spider.merge.fz_0;
import com.github.catvod.spider.merge.qy_0;
import com.github.catvod.spider.merge.x;
import com.github.catvod.spider.merge.yo;

public final class I8
extends LY<yq> {
    private final char[] i;
    private AD t0;

    public I8(fz_0 fz_02, char[] cArray, TA tA, RL.SN sN) {
        super(fz_02, tA, sN);
        this.i = cArray;
    }

    private yo q(a0 a02) {
        Object object = this.M();
        object = ((fz_0)object).zH().getName().endsWith(".zip.001") ? new ZQ(((fz_0)object).zH(), ((fz_0)object).SN().Dr()) : new qy_0(((fz_0)object).zH(), ((fz_0)object).i(), ((fz_0)object).SN().Dr());
        this.t0 = object;
        object = this.M();
        object = ((fz_0)object).yq() != null && ((fz_0)object).yq().yq() != null && ((fz_0)object).yq().yq().size() != 0 ? ((fz_0)object).yq().yq().get(0) : null;
        if (object != null) {
            this.t0.N((NJ)object);
        }
        return new yo(this.t0, this.i, a02);
    }

    /*
     * Exception decompiling
     */
    @Override
    protected final void zH(Object var1_1, Ud var2_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    public static final class yq
    extends x {
        private final String SN;

        public yq(String string, a0 a02) {
            super(a02);
            this.SN = string;
        }

        static /* synthetic */ String yq(yq yq2) {
            return yq2.SN;
        }
    }
}

