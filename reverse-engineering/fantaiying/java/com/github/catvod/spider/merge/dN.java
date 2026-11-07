/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nc;
import com.github.catvod.spider.merge.oi_0;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class dN
implements Serializable {
    private static final i[] i = new i[0];
    private static final ConcurrentMap<M, String> t0 = new ConcurrentHashMap<M, String>(7);
    private final Locale N;
    private final TimeZone SN;
    private transient i[] tF;
    private final String yq;
    private transient int zH;

    /*
     * Exception decompiling
     */
    protected dN(String var1_1, TimeZone var2_2, Locale var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [15[CASE], 1[CASE]], but top level block is 21[SWITCH]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
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

    static String Gc(TimeZone object, boolean bl, int n2, Locale locale) {
        M m2 = new M((TimeZone)object, bl, n2, locale);
        ConcurrentMap<M, String> concurrentMap = t0;
        String string = (String)((ConcurrentHashMap)concurrentMap).get(m2);
        Object object2 = string;
        if (string == null && (object = ((ConcurrentHashMap)concurrentMap).putIfAbsent(m2, (String)(object2 = ((TimeZone)object).getDisplayName(bl, n2, locale)))) != null) {
            object2 = object;
        }
        return object2;
    }

    private String N(Calendar calendar) {
        int n2;
        i[] iArray;
        StringBuilder stringBuilder = new StringBuilder(this.zH);
        try {
            iArray = this.tF;
            n2 = iArray.length;
        }
        catch (IOException iOException) {
            throw iOException;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            iArray[i2].SN(stringBuilder, calendar);
            continue;
        }
        return stringBuilder.toString();
    }

    static void SN(Appendable appendable, int n2, int n3) {
        block12: {
            block8: {
                char c;
                block9: {
                    block10: {
                        block11: {
                            if (n2 >= 10000) break block8;
                            int n4 = n2 < 1000 ? (n2 < 100 ? (n2 < 10 ? 1 : 2) : 3) : 4;
                            n3 -= n4;
                            while (n3 > 0) {
                                ((StringBuilder)appendable).append('0');
                                --n3;
                            }
                            n3 = n2;
                            if (n4 == 1) break block9;
                            n3 = n2;
                            if (n4 == 2) break block10;
                            n3 = n2;
                            if (n4 == 3) break block11;
                            if (n4 != 4) break block12;
                            c = (char)(n2 / 1000 + 48);
                            ((StringBuilder)appendable).append(c);
                            n3 = n2 % 1000;
                        }
                        if (n3 >= 100) {
                            c = (char)(n3 / 100 + 48);
                            ((StringBuilder)appendable).append(c);
                            n3 %= 100;
                        } else {
                            ((StringBuilder)appendable).append('0');
                        }
                    }
                    if (n3 >= 10) {
                        c = (char)(n3 / 10 + 48);
                        ((StringBuilder)appendable).append(c);
                        n3 %= 10;
                    } else {
                        ((StringBuilder)appendable).append('0');
                    }
                }
                c = (char)(n3 + 48);
                ((StringBuilder)appendable).append(c);
                break block12;
            }
            char[] cArray = new char[10];
            int n5 = 0;
            int n7 = n2;
            n2 = n5;
            while (true) {
                n5 = n3;
                if (n7 == 0) break;
                cArray[n2] = (char)(n7 % 10 + 48);
                n7 /= 10;
                ++n2;
            }
            while (true) {
                n3 = n2;
                if (n2 >= n5) break;
                ((StringBuilder)appendable).append('0');
                --n5;
            }
            while (--n3 >= 0) {
                char c = cArray[n3];
                ((StringBuilder)appendable).append(c);
            }
        }
    }

    static void yq(Appendable appendable, int n2) {
        char c = (char)(n2 / 10 + 48);
        appendable = (StringBuilder)appendable;
        ((StringBuilder)appendable).append(c);
        ((StringBuilder)appendable).append((char)(n2 % 10 + 48));
    }

    protected final tF M(int n2, int n3) {
        if (n3 != 1) {
            if (n3 != 2) {
                return new zH(n2, n3);
            }
            return new dT(n2);
        }
        return new W(n2);
    }

    public final boolean equals(Object object) {
        boolean bl = object instanceof dN;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        object = (dN)object;
        bl = bl2;
        if (this.yq.equals(((dN)object).yq)) {
            bl = bl2;
            if (this.SN.equals(((dN)object).SN)) {
                bl = bl2;
                if (this.N.equals(((dN)object).N)) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    public final int hashCode() {
        int n2 = this.yq.hashCode();
        int n3 = this.SN.hashCode();
        return (this.N.hashCode() * 13 + n3) * 13 + n2;
    }

    public final String i() {
        return this.yq;
    }

    public final TimeZone t0() {
        return this.SN;
    }

    final String tF(Object object) {
        if (object instanceof Date) {
            object = (Date)object;
            Calendar calendar = Calendar.getInstance(this.SN, this.N);
            calendar.setTime((Date)object);
            return this.N(calendar);
        }
        if (object instanceof Calendar) {
            i[] iArray = (i[])object;
            StringBuilder stringBuilder = new StringBuilder(this.zH);
            object = iArray;
            if (!iArray.getTimeZone().equals(this.SN)) {
                object = (Calendar)iArray.clone();
                ((Calendar)object).setTimeZone(this.SN);
            }
            iArray = this.tF;
            int n2 = iArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                iArray[i2].SN(stringBuilder, (Calendar)object);
                continue;
            }
            return stringBuilder.toString();
        }
        if (object instanceof Long) {
            long l = (Long)object;
            object = Calendar.getInstance(this.SN, this.N);
            ((Calendar)object).setTimeInMillis(l);
            return this.N((Calendar)object);
        }
        StringBuilder stringBuilder = oi_0.yq("Unknown class: ");
        object = object == null ? "<null>" : object.getClass().getName();
        stringBuilder.append((String)object);
        object = new IllegalArgumentException(stringBuilder.toString());
        throw object;
    }

    public final String toString() {
        StringBuilder stringBuilder = oi_0.yq("FastDatePrinter[");
        stringBuilder.append(this.yq);
        stringBuilder.append(",");
        stringBuilder.append(this.N);
        stringBuilder.append(",");
        stringBuilder.append(this.SN.getID());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final Locale zH() {
        return this.N;
    }

    private static final class B
    implements tF {
        private final tF yq;

        B(tF tF2) {
            this.yq = tF2;
        }

        @Override
        public final int N() {
            return this.yq.N();
        }

        @Override
        public final void SN(Appendable appendable, Calendar calendar) {
            int n2;
            int n3 = n2 = calendar.get(10);
            if (n2 == 0) {
                n3 = calendar.getLeastMaximum(10) + 1;
            }
            this.yq.yq(appendable, n3);
        }

        @Override
        public final void yq(Appendable appendable, int n2) {
            this.yq.yq(appendable, n2);
        }
    }

    private static final class F5
    implements tF {
        static final F5 yq = new F5();

        F5() {
        }

        @Override
        public final int N() {
            return 2;
        }

        @Override
        public final void SN(Appendable appendable, Calendar calendar) {
            this.yq(appendable, calendar.get(1) % 100);
        }

        @Override
        public final void yq(Appendable appendable, int n2) {
            dN.yq(appendable, n2 % 100);
        }
    }

    private static final class G
    implements tF {
        private final tF yq;

        G(tF tF2) {
            this.yq = tF2;
        }

        @Override
        public final int N() {
            return this.yq.N();
        }

        @Override
        public final void SN(Appendable appendable, Calendar calendar) {
            int n2;
            int n3 = n2 = calendar.get(11);
            if (n2 == 0) {
                n3 = calendar.getMaximum(11) + 1;
            }
            this.yq.yq(appendable, n3);
        }

        @Override
        public final void yq(Appendable appendable, int n2) {
            this.yq.yq(appendable, n2);
        }
    }

    private static final class G4
    implements tF {
        static final G4 yq = new G4();

        G4() {
        }

        @Override
        public final int N() {
            return 2;
        }

        @Override
        public final void SN(Appendable appendable, Calendar calendar) {
            dN.yq(appendable, calendar.get(2) + 1);
        }

        @Override
        public final void yq(Appendable appendable, int n2) {
            dN.yq(appendable, n2);
        }
    }

    private static final class Gc
    implements i {
        private final String[] SN;
        private final int yq;

        Gc(int n2, String[] stringArray) {
            this.yq = n2;
            this.SN = stringArray;
        }

        @Override
        public final int N() {
            int n2;
            int n3 = this.SN.length;
            int n4 = 0;
            while ((n2 = n3 - 1) >= 0) {
                int n5 = this.SN[n2].length();
                n3 = n2;
                if (n5 <= n4) continue;
                n4 = n5;
                n3 = n2;
            }
            return n4;
        }

        @Override
        public final void SN(Appendable appendable, Calendar object) {
            object = this.SN[((Calendar)object).get(this.yq)];
            ((StringBuilder)appendable).append((CharSequence)object);
        }
    }

    private static final class KJ
    implements i {
        private final String N;
        private final int SN;
        private final String tF;
        private final Locale yq;

        KJ(TimeZone timeZone, Locale locale, int n2) {
            this.yq = Nc.yq(locale);
            this.SN = n2;
            this.N = dN.Gc(timeZone, false, n2, locale);
            this.tF = dN.Gc(timeZone, true, n2, locale);
        }

        @Override
        public final int N() {
            return Math.max(this.N.length(), this.tF.length());
        }

        @Override
        public final void SN(Appendable appendable, Calendar object) {
            TimeZone timeZone = ((Calendar)object).getTimeZone();
            boolean bl = ((Calendar)object).get(16) != 0;
            object = dN.Gc(timeZone, bl, this.SN, this.yq);
            ((StringBuilder)appendable).append((CharSequence)object);
        }
    }

    private static final class M {
        private final Locale N;
        private final int SN;
        private final TimeZone yq;

        M(TimeZone timeZone, boolean bl, int n2, Locale locale) {
            this.yq = timeZone;
            this.SN = bl ? Integer.MIN_VALUE | n2 : n2;
            this.N = Nc.yq(locale);
        }

        public final boolean equals(Object object) {
            boolean bl = true;
            if (this == object) {
                return true;
            }
            if (object instanceof M) {
                object = (M)object;
                if (!this.yq.equals(((M)object).yq) || this.SN != ((M)object).SN || !this.N.equals(((M)object).N)) {
                    bl = false;
                }
                return bl;
            }
            return false;
        }

        public final int hashCode() {
            int n2 = this.SN;
            int n3 = this.N.hashCode();
            return this.yq.hashCode() + (n3 + n2 * 31) * 31;
        }
    }

    private static final class N
    implements i {
        static final N N;
        static final N SN;
        static final N tF;
        final int yq;

        static {
            SN = new N(3);
            N = new N(5);
            tF = new N(6);
        }

        N(int n2) {
            this.yq = n2;
        }

        @Override
        public final int N() {
            return this.yq;
        }

        @Override
        public final void SN(Appendable appendable, Calendar calendar) {
            int n2 = calendar.get(15);
            n2 = calendar.get(16) + n2;
            if (n2 == 0) {
                ((StringBuilder)appendable).append((CharSequence)"Z");
                return;
            }
            if (n2 < 0) {
                ((StringBuilder)appendable).append('-');
                n2 = -n2;
            } else {
                ((StringBuilder)appendable).append('+');
            }
            int n3 = n2 / 3600000;
            dN.yq(appendable, n3);
            int n4 = this.yq;
            if (n4 < 5) {
                return;
            }
            if (n4 == 6) {
                ((StringBuilder)appendable).append(':');
            }
            dN.yq(appendable, n2 / 60000 - n3 * 60);
        }
    }

    private static final class SN
    implements tF {
        private final tF yq;

        SN(tF tF2) {
            this.yq = tF2;
        }

        @Override
        public final int N() {
            return this.yq.N();
        }

        @Override
        public final void SN(Appendable appendable, Calendar object) {
            int n2 = 7;
            int n3 = ((Calendar)object).get(7);
            object = this.yq;
            if (n3 != 1) {
                n2 = n3 - 1;
            }
            object.yq(appendable, n2);
        }

        @Override
        public final void yq(Appendable appendable, int n2) {
            this.yq.yq(appendable, n2);
        }
    }

    private static final class W
    implements tF {
        private final int yq;

        W(int n2) {
            this.yq = n2;
        }

        @Override
        public final int N() {
            return 4;
        }

        @Override
        public final void SN(Appendable appendable, Calendar calendar) {
            this.yq(appendable, calendar.get(this.yq));
        }

        @Override
        public final void yq(Appendable appendable, int n2) {
            if (n2 < 10) {
                char c = (char)(n2 + 48);
                ((StringBuilder)appendable).append(c);
            } else if (n2 < 100) {
                dN.yq(appendable, n2);
            } else {
                dN.SN(appendable, n2, 1);
            }
        }
    }

    private static final class dT
    implements tF {
        private final int yq;

        dT(int n2) {
            this.yq = n2;
        }

        @Override
        public final int N() {
            return 2;
        }

        @Override
        public final void SN(Appendable appendable, Calendar calendar) {
            this.yq(appendable, calendar.get(this.yq));
        }

        @Override
        public final void yq(Appendable appendable, int n2) {
            if (n2 < 100) {
                dN.yq(appendable, n2);
            } else {
                dN.SN(appendable, n2, 2);
            }
        }
    }

    private static interface i {
        public int N();

        public void SN(Appendable var1, Calendar var2);
    }

    private static final class q
    implements i {
        static final q N;
        static final q SN;
        final boolean yq;

        static {
            SN = new q(true);
            N = new q(false);
        }

        q(boolean bl) {
            this.yq = bl;
        }

        @Override
        public final int N() {
            return 5;
        }

        @Override
        public final void SN(Appendable appendable, Calendar calendar) {
            int n2 = calendar.get(15);
            n2 = calendar.get(16) + n2;
            if (n2 < 0) {
                ((StringBuilder)appendable).append('-');
                n2 = -n2;
            } else {
                ((StringBuilder)appendable).append('+');
            }
            int n3 = n2 / 3600000;
            dN.yq(appendable, n3);
            if (this.yq) {
                ((StringBuilder)appendable).append(':');
            }
            dN.yq(appendable, n2 / 60000 - n3 * 60);
        }
    }

    private static final class t0
    implements i {
        private final String yq;

        t0(String string) {
            this.yq = string;
        }

        @Override
        public final int N() {
            return this.yq.length();
        }

        @Override
        public final void SN(Appendable appendable, Calendar object) {
            object = this.yq;
            ((StringBuilder)appendable).append((CharSequence)object);
        }
    }

    private static interface tF
    extends i {
        public void yq(Appendable var1, int var2);
    }

    private static final class v
    implements tF {
        private final tF yq;

        v(tF tF2) {
            this.yq = tF2;
        }

        @Override
        public final int N() {
            return this.yq.N();
        }

        @Override
        public final void SN(Appendable appendable, Calendar calendar) {
            this.yq.yq(appendable, calendar.getWeekYear());
        }

        @Override
        public final void yq(Appendable appendable, int n2) {
            this.yq.yq(appendable, n2);
        }
    }

    private static final class v3
    implements tF {
        static final v3 yq = new v3();

        v3() {
        }

        @Override
        public final int N() {
            return 2;
        }

        @Override
        public final void SN(Appendable appendable, Calendar calendar) {
            this.yq(appendable, calendar.get(2) + 1);
        }

        @Override
        public final void yq(Appendable appendable, int n2) {
            if (n2 < 10) {
                char c = (char)(n2 + 48);
                ((StringBuilder)appendable).append(c);
            } else {
                dN.yq(appendable, n2);
            }
        }
    }

    private static final class yq
    implements i {
        private final char yq;

        yq(char c) {
            this.yq = c;
        }

        @Override
        public final int N() {
            return 1;
        }

        @Override
        public final void SN(Appendable appendable, Calendar calendar) {
            char c = this.yq;
            ((StringBuilder)appendable).append(c);
        }
    }

    private static final class zH
    implements tF {
        private final int SN;
        private final int yq;

        zH(int n2, int n3) {
            if (n3 >= 3) {
                this.yq = n2;
                this.SN = n3;
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override
        public final int N() {
            return this.SN;
        }

        @Override
        public final void SN(Appendable appendable, Calendar calendar) {
            this.yq(appendable, calendar.get(this.yq));
        }

        @Override
        public final void yq(Appendable appendable, int n2) {
            dN.SN(appendable, n2, this.SN);
        }
    }
}

