/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.spider.merge.tW
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.I2;
import com.github.catvod.spider.merge.Nc;
import com.github.catvod.spider.merge.eY;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.tW;
import com.github.catvod.spider.merge.yP;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Renamed from com.github.catvod.spider.merge.tW
 */
public final class tw_0
implements Serializable {
    private static final M B;
    private static final M F5;
    private static final M G;
    private static final M G4;
    private static final Comparator<String> Gc;
    private static final M Gd;
    private static final yq KJ;
    private static final ConcurrentMap<Locale, q>[] M;
    private static final M Nl;
    private static final M OW;
    private static final M W;
    private static final M dT;
    private static final tF ee;
    private static final zH g9;
    private static final SN q;
    static final Locale t0;
    private static final M v;
    private static final N v3;
    private static final M xa;
    private final Locale N;
    private final TimeZone SN;
    private transient List<B> i;
    private final int tF;
    private final String yq;
    private final int zH;

    static {
        t0 = new Locale("ja", "JP", "JP");
        Gc = yP.yq();
        M = new ConcurrentMap[17];
        KJ = new M(){

            @Override
            final int N(tw_0 tw_02, int n2) {
                int n3 = n2;
                if (n2 < 100) {
                    n3 = tw_0.tF(tw_02, n2);
                }
                return n3;
            }
        };
        q = new M(){

            @Override
            final int N(tw_0 tw_02, int n2) {
                return n2 - 1;
            }
        };
        B = new M(1);
        G = new M(3);
        G4 = new M(4);
        dT = new M(6);
        F5 = new M(5);
        v3 = new M(){

            @Override
            final int N(tw_0 tw_02, int n2) {
                int n3 = 1;
                n2 = n2 == 7 ? n3 : ++n2;
                return n2;
            }
        };
        W = new M(8);
        v = new M(11);
        ee = new M(){

            @Override
            final int N(tw_0 tw_02, int n2) {
                int n3 = n2;
                if (n2 == 24) {
                    n3 = 0;
                }
                return n3;
            }
        };
        g9 = new M(){

            @Override
            final int N(tw_0 tw_02, int n2) {
                int n3 = n2;
                if (n2 == 12) {
                    n3 = 0;
                }
                return n3;
            }
        };
        xa = new M(10);
        Gd = new M(12);
        Nl = new M(13);
        OW = new M(14);
    }

    protected tw_0(String object, TimeZone object2, Locale locale) {
        int n2;
        int n3;
        this.yq = object;
        this.SN = object2;
        this.N = object = Nc.yq(locale);
        object2 = Calendar.getInstance((TimeZone)object2, (Locale)object);
        if (((Locale)object).equals(t0)) {
            n3 = 0;
        } else {
            ((Calendar)object2).setTime(new Date());
            n3 = ((Calendar)object2).get(1) - 80;
        }
        this.tF = n2 = n3 / 100 * 100;
        this.zH = n3 - n2;
        this.i = new ArrayList<B>();
        object = new G(this, (Calendar)object2);
        while ((object2 = ((G)object).yq()) != null) {
            ((ArrayList)this.i).add((B)object2);
        }
        return;
    }

    /*
     * Unable to fully structure code
     */
    private static StringBuilder KJ(StringBuilder var0, String var1_1) {
        for (var3_2 = 0; var3_2 < var1_1.length(); ++var3_2) {
            var2_3 = var1_1.charAt(var3_2);
            if (var2_3 == '$' || var2_3 == '.' || var2_3 == '?' || var2_3 == '^' || var2_3 == '[' || var2_3 == '\\' || var2_3 == '{' || var2_3 == '|') ** GOTO lbl-1000
            switch (var2_3) {
                default: {
                    break;
                }
                case '(': 
                case ')': 
                case '*': 
                case '+': lbl-1000:
                // 2 sources

                {
                    var0.append('\\');
                }
            }
            var0.append(var2_3);
        }
        if (var0.charAt(var0.length() - 1) == '.') {
            var0.append('?');
        }
        return var0;
    }

    static Map N(Calendar object, Locale locale, int n2, StringBuilder stringBuilder) {
        HashMap hashMap = new HashMap();
        locale = Nc.yq(locale);
        Map<String, Integer> map = ((Calendar)object).getDisplayNames(n2, 0, locale);
        object = new TreeSet<String>(Gc);
        for (Map.Entry entry : map.entrySet()) {
            String string = ((String)entry.getKey()).toLowerCase(locale);
            if (!((TreeSet)object).add(string)) continue;
            hashMap.put(string, entry.getValue());
        }
        object = ((TreeSet)object).iterator();
        while (object.hasNext()) {
            tw_0.KJ(stringBuilder, (String)object.next());
            stringBuilder.append('|');
        }
        return hashMap;
    }

    /*
     * Exception decompiling
     */
    static q SN(tw_0 var0, char var1_1, int var2_2, Calendar var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE], 8[CASE]], but top level block is 20[SWITCH]
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

    static /* synthetic */ StringBuilder i(StringBuilder stringBuilder, String string) {
        tw_0.KJ(stringBuilder, string);
        return stringBuilder;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private q t0(int n2, Calendar object) {
        ConcurrentMap<Locale, q> concurrentMap;
        Object object2;
        Object object3 = M;
        synchronized (object3) {
            if (object3[n2] == null) {
                object2 = new ConcurrentHashMap(3);
                object3[n2] = object2;
            }
            concurrentMap = object3[n2];
        }
        object2 = (q)concurrentMap.get(this.N);
        object3 = object2;
        if (object2 == null) {
            object = n2 == 15 ? new G4(this.N) : new i(n2, (Calendar)object, this.N);
            object2 = concurrentMap.putIfAbsent(this.N, (q)object);
            object3 = object;
            if (object2 != null) {
                return object2;
            }
        }
        return object3;
    }

    static int tF(tw_0 tw_02, int n2) {
        int n3 = tw_02.tF + n2;
        n2 = n2 >= tw_02.zH ? n3 : n3 + 100;
        return n2;
    }

    static /* synthetic */ String yq(tw_0 tw_02) {
        return tw_02.yq;
    }

    static /* synthetic */ Comparator zH() {
        return Gc;
    }

    public final Date Gc(String string) {
        ParsePosition parsePosition = new ParsePosition(0);
        Comparable<Date> comparable = this.M(string, parsePosition);
        if (comparable == null) {
            if (this.N.equals(t0)) {
                comparable = oi_0.yq("(The ");
                ((StringBuilder)comparable).append(this.N);
                ((StringBuilder)comparable).append(" locale does not support dates before 1868 AD)\nUnparseable date: \"");
                ((StringBuilder)comparable).append(string);
                throw new ParseException(((StringBuilder)comparable).toString(), parsePosition.getErrorIndex());
            }
            throw new ParseException(eY.yq("Unparseable date: ", string), parsePosition.getErrorIndex());
        }
        return comparable;
    }

    public final Date M(String object, ParsePosition parsePosition) {
        int n2;
        Calendar calendar;
        block4: {
            block3: {
                int n3;
                B b2;
                calendar = Calendar.getInstance(this.SN, this.N);
                calendar.clear();
                ListIterator listIterator = ((ArrayList)this.i).listIterator();
                do {
                    boolean bl = listIterator.hasNext();
                    n3 = 0;
                    if (!bl) break block3;
                    b2 = (B)listIterator.next();
                    if (b2.yq.yq() && listIterator.hasNext()) {
                        q q4 = ((B)listIterator.next()).yq;
                        listIterator.previous();
                        if (q4.yq()) {
                            n2 = b2.SN;
                            continue;
                        }
                    }
                    n2 = 0;
                } while (b2.yq.SN(this, calendar, (String)object, parsePosition, n2));
                n2 = n3;
                break block4;
            }
            n2 = 1;
        }
        object = n2 != 0 ? calendar.getTime() : null;
        return object;
    }

    public final boolean equals(Object object) {
        boolean bl = object instanceof tw_0;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        object = (tw_0)object;
        bl = bl2;
        if (this.yq.equals(((tw_0)object).yq)) {
            bl = bl2;
            if (this.SN.equals(((tw_0)object).SN)) {
                bl = bl2;
                if (this.N.equals(((tw_0)object).N)) {
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

    public final String toString() {
        StringBuilder stringBuilder = oi_0.yq("FastDateParser[");
        stringBuilder.append(this.yq);
        stringBuilder.append(", ");
        stringBuilder.append(this.N);
        stringBuilder.append(", ");
        stringBuilder.append(this.SN.getID());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static final class B {
        final int SN;
        final q yq;

        B(q q4, int n2) {
            this.yq = q4;
            this.SN = n2;
        }

        public final String toString() {
            StringBuilder stringBuilder = oi_0.yq("StrategyAndWidth [strategy=");
            stringBuilder.append(this.yq);
            stringBuilder.append(", width=");
            stringBuilder.append(this.SN);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private final class G {
        final tw_0 N;
        private int SN;
        private final Calendar yq;

        G(tw_0 tw_02, Calendar calendar) {
            this.N = tw_02;
            this.yq = calendar;
        }

        final B yq() {
            if (this.SN >= tW.yq((tw_0)this.N).length()) {
                return null;
            }
            char c = tW.yq((tw_0)this.N).charAt(this.SN);
            int n2 = c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' ? 1 : 0;
            if (n2 != 0) {
                int n3;
                n2 = this.SN;
                do {
                    this.SN = n3 = this.SN + 1;
                } while (n3 < tW.yq((tw_0)this.N).length() && tW.yq((tw_0)this.N).charAt(this.SN) == c);
                n2 = this.SN - n2;
                return new B(tW.SN((tw_0)this.N, (char)c, (int)n2, (Calendar)this.yq), n2);
            }
            Object object = new StringBuilder();
            n2 = 0;
            while (this.SN < tW.yq((tw_0)this.N).length()) {
                int n4;
                c = tW.yq((tw_0)this.N).charAt(this.SN);
                if (n2 == 0 && (n4 = c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' ? 1 : 0) != 0) break;
                if (c == '\'') {
                    this.SN = n4 = this.SN + 1;
                    if (n4 == tW.yq((tw_0)this.N).length() || tW.yq((tw_0)this.N).charAt(this.SN) != '\'') {
                        n2 ^= 1;
                        continue;
                    }
                }
                ++this.SN;
                ((StringBuilder)object).append(c);
            }
            if (n2 == 0) {
                object = ((StringBuilder)object).toString();
                return new B(new t0((String)object), ((String)object).length());
            }
            object = new IllegalArgumentException("Unterminated quote");
            throw object;
        }
    }

    static final class G4
    extends KJ {
        private final Map<String, yq> N = new HashMap<String, yq>();
        private final Locale SN;

        G4(Locale object3) {
            this.SN = Nc.yq((Locale)object3);
            StringBuilder stringBuilder = oi_0.yq("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
            TreeSet<String> treeSet = new TreeSet<String>(tW.zH());
            for (String[] stringArray : DateFormatSymbols.getInstance((Locale)object3).getZoneStrings()) {
                Object object = stringArray[0];
                if (((String)object).equalsIgnoreCase("GMT")) continue;
                TimeZone timeZone = TimeZone.getTimeZone((String)object);
                yq yq2 = new yq(timeZone, false);
                object = yq2;
                for (int i2 = 1; i2 < stringArray.length; ++i2) {
                    String string;
                    if (i2 != 3) {
                        if (i2 == 5) {
                            object = yq2;
                        }
                    } else {
                        object = new yq(timeZone, true);
                    }
                    if (stringArray[i2] == null || !treeSet.add(string = stringArray[i2].toLowerCase((Locale)object3))) continue;
                    ((HashMap)this.N).put(string, (yq)object);
                }
            }
            for (String string : treeSet) {
                stringBuilder.append('|');
                tW.i((StringBuilder)stringBuilder, (String)string);
            }
            stringBuilder.append(")");
            this.yq = Pattern.compile(stringBuilder.toString());
        }

        @Override
        final void N(Calendar calendar, String object) {
            Object object2 = I2.yq((String)object);
            if (object2 != null) {
                calendar.setTimeZone((TimeZone)object2);
            } else {
                String string = ((String)object).toLowerCase(this.SN);
                object = object2 = (yq)((HashMap)this.N).get(string);
                if (object2 == null) {
                    object = this.N;
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(string);
                    ((StringBuilder)object2).append('.');
                    object = (yq)((HashMap)object).get(((StringBuilder)object2).toString());
                }
                calendar.set(16, ((yq)object).SN);
                calendar.set(15, ((yq)object).yq.getRawOffset());
            }
        }

        @Override
        public final String toString() {
            StringBuilder stringBuilder = oi_0.yq("TimeZoneStrategy [locale=");
            stringBuilder.append(this.SN);
            stringBuilder.append(", tzNames=");
            stringBuilder.append(this.N);
            stringBuilder.append(", pattern=");
            stringBuilder.append(this.yq);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        private static final class yq {
            final int SN;
            final TimeZone yq;

            yq(TimeZone timeZone, boolean bl) {
                this.yq = timeZone;
                int n2 = bl ? timeZone.getDSTSavings() : 0;
                this.SN = n2;
            }
        }
    }

    private static final class Gc
    extends KJ {
        private static final Gc N;
        private static final Gc SN;
        private static final Gc tF;

        static {
            SN = new Gc("(Z|(?:[+-]\\d{2}))");
            N = new Gc("(Z|(?:[+-]\\d{2}\\d{2}))");
            tF = new Gc("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");
        }

        Gc(String string) {
            this.yq = Pattern.compile(string);
        }

        static /* synthetic */ q tF() {
            return tF;
        }

        static q zH(int n2) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 == 3) {
                        return tF;
                    }
                    throw new IllegalArgumentException("invalid number of X");
                }
                return N;
            }
            return SN;
        }

        @Override
        final void N(Calendar calendar, String string) {
            calendar.setTimeZone(I2.yq(string));
        }
    }

    private static abstract class KJ
    extends q {
        Pattern yq;

        KJ() {
        }

        abstract void N(Calendar var1, String var2);

        @Override
        final boolean SN(tw_0 object, Calendar calendar, String string, ParsePosition parsePosition, int n2) {
            object = this.yq.matcher(string.substring(parsePosition.getIndex()));
            if (!((Matcher)object).lookingAt()) {
                parsePosition.setErrorIndex(parsePosition.getIndex());
                return false;
            }
            n2 = parsePosition.getIndex();
            parsePosition.setIndex(((Matcher)object).end(1) + n2);
            this.N(calendar, ((Matcher)object).group(1));
            return true;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getClass().getSimpleName());
            stringBuilder.append(" [pattern=");
            stringBuilder.append(this.yq);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        @Override
        final boolean yq() {
            return false;
        }
    }

    private static class M
    extends q {
        private final int yq;

        M(int n2) {
            this.yq = n2;
        }

        int N(tw_0 tw_02, int n2) {
            return n2;
        }

        @Override
        final boolean SN(tw_0 tw_02, Calendar calendar, String string, ParsePosition parsePosition, int n2) {
            int n3;
            int n4 = parsePosition.getIndex();
            int n5 = string.length();
            if (n2 == 0) {
                for (n2 = n4; n2 < n5 && Character.isWhitespace(string.charAt(n2)); ++n2) {
                }
                parsePosition.setIndex(n2);
                n3 = n5;
            } else {
                int n7 = n2 + n4;
                n2 = n4;
                n3 = n5;
                if (n5 > n7) {
                    n3 = n7;
                    n2 = n4;
                }
            }
            while (n2 < n3 && Character.isDigit(string.charAt(n2))) {
                ++n2;
            }
            if (parsePosition.getIndex() == n2) {
                parsePosition.setErrorIndex(n2);
                return false;
            }
            n4 = Integer.parseInt(string.substring(parsePosition.getIndex(), n2));
            parsePosition.setIndex(n2);
            calendar.set(this.yq, this.N(tw_02, n4));
            return true;
        }

        public final String toString() {
            StringBuilder stringBuilder = oi_0.yq("NumberStrategy [field=");
            stringBuilder.append(this.yq);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        @Override
        final boolean yq() {
            return true;
        }
    }

    private static final class i
    extends KJ {
        final Locale N;
        private final int SN;
        private final Map<String, Integer> tF;

        i(int n2, Calendar calendar, Locale locale) {
            this.SN = n2;
            this.N = Nc.yq(locale);
            StringBuilder stringBuilder = oi_0.yq("((?iu)");
            this.tF = (HashMap)tW.N((Calendar)calendar, (Locale)locale, (int)n2, (StringBuilder)stringBuilder);
            stringBuilder.setLength(stringBuilder.length() - 1);
            stringBuilder.append(")");
            this.yq = Pattern.compile(stringBuilder.toString());
        }

        @Override
        final void N(Calendar calendar, String object) {
            Object object2;
            String string = ((String)object).toLowerCase(this.N);
            object = object2 = (Integer)((HashMap)this.tF).get(string);
            if (object2 == null) {
                object2 = this.tF;
                object = new StringBuilder();
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append('.');
                object = (Integer)((HashMap)object2).get(((StringBuilder)object).toString());
            }
            calendar.set(this.SN, (Integer)object);
        }

        @Override
        public final String toString() {
            StringBuilder stringBuilder = oi_0.yq("CaseInsensitiveTextStrategy [field=");
            stringBuilder.append(this.SN);
            stringBuilder.append(", locale=");
            stringBuilder.append(this.N);
            stringBuilder.append(", lKeyValues=");
            stringBuilder.append(this.tF);
            stringBuilder.append(", pattern=");
            stringBuilder.append(this.yq);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private static abstract class q {
        private q() {
        }

        abstract boolean SN(tw_0 var1, Calendar var2, String var3, ParsePosition var4, int var5);

        boolean yq() {
            return false;
        }
    }

    private static final class t0
    extends q {
        private final String yq;

        t0(String string) {
            this.yq = string;
        }

        @Override
        final boolean SN(tw_0 tw_02, Calendar calendar, String string, ParsePosition parsePosition, int n2) {
            for (n2 = 0; n2 < this.yq.length(); ++n2) {
                int n3 = parsePosition.getIndex() + n2;
                if (n3 == string.length()) {
                    parsePosition.setErrorIndex(n3);
                    return false;
                }
                if (this.yq.charAt(n2) == string.charAt(n3)) continue;
                parsePosition.setErrorIndex(n3);
                return false;
            }
            n2 = this.yq.length();
            parsePosition.setIndex(parsePosition.getIndex() + n2);
            return true;
        }

        public final String toString() {
            return k_0.i(oi_0.yq("CopyQuotedStrategy [formatField="), this.yq, "]");
        }
    }
}

