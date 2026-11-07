/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Response
 */
package com.github.catvod.spider.merge;

import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.spider.merge.g1;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import java.nio.channels.Pipe;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import okhttp3.Response;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class fk {
    private static final short[] short = new short[]{1304, 1323, 1316, 1325, 1327, 576, 588, 589, 589, 582, 576, 599, 586, 588, 589, 2334, 2309, 2312, 2329, 2319, 2369, 2393, 2328, 2385, 847, 833, 833, 852, 777, 837, 840, 845, 850, 833, 740, 767, 754, 739, 757, 699, 686, 730, 738, 685, 687, 683, 686, 730, 738, 685, 687, 697, 722, 737, 750, 743, 741, 2999, 2029, 1235, 1007, 1012, 1017, 1000, 1022, 941, 2523, 2551, 2550, 2540, 2557, 2550, 2540, 2485, 2506, 2553, 2550, 2559, 2557, 1415, 1451, 1450, 1456, 1441, 1450, 1456, 1513, 1416, 1441, 1450, 1443, 1456, 1452, 1896, 1866, 1866, 1868, 1881, 1885, 1796, 1915, 1864, 1863, 1870, 1868, 1882, 2491, 2464, 2477, 2492, 2474, 2422, 2394, 2395, 2395, 2384, 2390, 2369, 2396, 2394, 2395, 2660, 2666, 2666, 2687, 2594, 2670, 2659, 2662, 2681, 2666, 418, 435, 435, 431, 426, 416, 418, 439, 426, 428, 429, 492, 428, 416, 439, 494, 432, 439, 433, 422, 418, 430, 1973, 1970, 1962, 1981, 1968, 1973, 1976, 2044, 1934, 1981, 1970, 1979, 1977, 2022, 2044};
    private boolean B;
    private ExecutorService G;
    private long Gc = -1L;
    private boolean KJ = true;
    private long M = -1L;
    private final String N;
    private final Map<String, String> SN;
    private long i;
    private boolean q = true;
    private long t0 = -1L;
    private long tF;
    private final BlockingQueue<yq> yq = new LinkedBlockingQueue<yq>();
    private boolean zH = false;

    /*
     * Enabled aggressive block sorting
     */
    public fk(String string, Map<String, String> map, Long l, long l2) {
        this.G = \ufe99\u062c\u0643\ufec1.\ufebd\ufeab\u064a\ufe8e(2);
        this.N = string;
        this.SN = map;
        this.tF = \ufeb1\ufe8e\ufee1\ufe9d.\u0642\ufeaf\u0648\ufea5(l);
        this.i = l2;
        this.B = false;
        int n2 = \u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd();
        int n3 = 1616;
        block6: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (n2 >= 0) {
                        n3 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block6;
                }
                case 204: {
                    float f = Float.parseFloat(\ufed9\ufe9d\ufeed\ufeb5.\ufecd\u0639\u0642\u0638("fA3hTkjy7NtgHrq33"));
                    System.out.println(f);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public fk(String string, Map<String, String> map, Long l, long l2, boolean bl) {
        this.G = Executors.newFixedThreadPool(2);
        this.N = string;
        this.SN = map;
        this.tF = l;
        this.i = l2;
        this.B = bl;
        int n2 = \u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd();
        int n3 = 1616;
        block6: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (n2 <= 0) {
                        n3 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block6;
                }
                case 204: {
                    float f = Float.parseFloat(\ufeaf\u062b\ufed5\ufec1.\ufea1\ufeaf\ufe99\ufe8e("GuVjo"));
                    System.out.println(f);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    public static void N(fk fk2) {
        fk2.G.submit(new g1(fk2, 3));
    }

    /*
     * Exception decompiling
     */
    public static void SN(fk var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous, and can't clone.
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:611)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:94)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:517)
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

    /*
     * Exception decompiling
     */
    public static void yq(fk var0, Pipe.SinkChannel var1_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 13[TRYBLOCK] [31 : 1086->1094)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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

    /*
     * Enabled aggressive block sorting
     */
    public static long \u0637\ufeed\ufead\ufebd(Object object) {
        int n2 = \ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 <= 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((fk)object).t0;
                }
                case 239: 
            }
            break;
        }
        long l = 0L;
        n3 = 1740;
        block11: while (true) {
            long l2 = l;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return l2;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Map \u064a\ufed5\ufec9\ufeed(Object map) {
        int n2 = \u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 <= 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((fk)((Object)map)).SN;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            map = var3_3;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return map;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static long \ufe9d\ufec1\ufee9\u0634(Object object) {
        int n2 = \ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 > 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((fk)object).Gc;
                }
                case 239: 
            }
            break;
        }
        long l = 0L;
        n3 = 1740;
        block11: while (true) {
            long l2 = l;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return l2;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static long \ufead\u062e\u0639\ufeaf(Object object) {
        int n2 = \ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 >= 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((fk)object).tF;
                }
                case 239: 
            }
            break;
        }
        long l = 0L;
        n3 = 1740;
        block11: while (true) {
            long l2 = l;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return l2;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static short[] \ufeb5\u0641\u0636\ufee1() {
        int n2 = \ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 < 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    return short;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            short[] sArray = var3_3;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return sArray;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean \ufed5\ufecd\u062b\u0637(Object object) {
        int n2 = \ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 >= 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((fk)object).B;
                }
                case 239: 
            }
            break;
        }
        boolean bl = false;
        n3 = 1740;
        block11: while (true) {
            boolean bl2 = bl;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return bl2;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Exception decompiling
     */
    public final Object[] tF() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous, and can't clone.
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:611)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:94)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:517)
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

    private static final class yq {
        private Response N;
        private final long SN;
        private final long yq;

        /*
         * Enabled aggressive block sorting
         */
        public yq(long l, long l2) {
            this.yq = l;
            this.SN = l2;
            int n2 = \ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9();
            int n3 = 1616;
            block6: while (true) {
                switch (n3 ^= 0x661) {
                    default: {
                        continue block6;
                    }
                    case 49: {
                        if (n2 >= 0) {
                            n3 = 1709;
                            continue block6;
                        }
                    }
                    case 14: {
                        n3 = 1678;
                        continue block6;
                    }
                    case 204: {
                        l = Long.parseLong(\u0633\u064a\u0644\u0637.\ufebd\u062e\ufef1\u064a("aaKxeilNBvm"));
                        System.out.println(l);
                        return;
                    }
                    case 239: 
                }
                break;
            }
        }

        static /* synthetic */ long SN(yq yq2) {
            return yq2.yq;
        }

        static /* synthetic */ long yq(yq yq2) {
            return yq2.SN;
        }

        public final Response N() {
            return this.N;
        }

        public final void tF(Response response) {
            this.N = response;
        }
    }
}

