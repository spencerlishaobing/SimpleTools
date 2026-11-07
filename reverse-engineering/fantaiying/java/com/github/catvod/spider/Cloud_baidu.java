/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.Spider
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Cloud_baidu
extends Spider {
    public static boolean i = false;
    private static final short[] short = new short[]{2021, 1977, 2021, 2018, 1937, 1940, 2021, 1943, 2017, 2019, 1942, 2037, 1978, 1981, 1966, 2039, 2018, 2018, 1937, 1940, 2021, 1943, 2017, 2019, 2019, 24903, 20801, 31382, 685, 703, 703, 716, 713, 696, 714, 700, 702, 702, 475, 458, 453, 389, 457, 458, 450, 463, 478, 389, 456, 452, 454, 388, 389, 385, 404, 503, 404, 472, 478, 473, 455, 406, 387, 496, 501, 388, 502, 384, 386, 397, 475, 476, 463, 406, 387, 387, 496, 501, 388, 502, 384, 386, 386, 1023, 931, 1023, 1016, 907, 910, 908, 1007, 909, 1019, 1017, 2384, 2397, 2388, 2369, 537, 543, 520, 1625, 1626, 1624, 3114, 3117, 3123, 3126, 3127, 24846, 20744, 31455, 2083, 23159, 23159, 27016, -26056, 1621, 1658, 1657, 1635, 1650, 1595, 1650, 1636, 1663, 1632, 1651, 373, 372, 2645, 2643, 2676, 2652, 1359, 1037, 1041, 1041, 1045, 844, 2082, 2084, 389, 404, 411, 426, 390, 410, 384, 391, 406, 400, 426, 390, 410, 391, 385, 2684, 2656, 2685, 2683, 1948, 1980, 3325, 3202, 1775, 24782, 25428, -28444, 24044, 1769, 28623, 27278, 28900, 27501, 28582, 27909, 25648, 27720, 28123, -2071, 23295, 21783, 27278, 28900, 32353, -31982, 23250, 27989, 2401, 2401, 2401};
    private static String zH = "";
    private final Pattern N;
    private final Pattern SN;
    private final Pattern tF;
    private final Pattern yq = \ufea9\ufe8f\u0647\ufead.\u0646\ufedd\u0634\ufed9(\u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Cloud_baidu.\u0635\ufea5\u0628\ufec5(), 0, 25, 1994));

    /*
     * Enabled aggressive block sorting
     */
    public Cloud_baidu() {
        this.SN = \ufea9\ufe8f\u0647\ufead.\u0646\ufedd\u0634\ufed9(\ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(Cloud_baidu.\u0635\ufea5\u0628\ufec5(), 25, 13, 663));
        this.N = \ufea9\ufe8f\u0647\ufead.\u0646\ufedd\u0634\ufed9(\u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(Cloud_baidu.\u0635\ufea5\u0628\ufec5(), 38, 45, 427));
        this.tF = \ufea9\ufe8f\u0647\ufead.\u0646\ufedd\u0634\ufed9(\ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(Cloud_baidu.\u0635\ufea5\u0628\ufec5(), 83, 11, 976));
        int n = \ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1();
        int n2 = 1616;
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (n <= 0) {
                        n2 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block6;
                }
                case 204: {
                    Float f = Float.decode((String)\ufe9d\ufeab\u062e\u0640.\ufea1\ufecd\u0646\u0648("QF548cVHhxySBI4xHPNG3Q"));
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
    public static Object[] proxy(Map<String, String> objectArray) {
        String string = (String)\ufea9\ufec5\u0647\u0641.\ufe95\u0627\ufea1\u0647(objectArray, \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(Cloud_baidu.\u0635\ufea5\u0628\ufec5(), 94, 4, 2340));
        boolean bl = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(string, \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(Cloud_baidu.\u0635\ufea5\u0628\ufec5(), 98, 3, 618));
        int n = 1616;
        block18: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block18;
                }
                case 49: {
                    if (bl) {
                        n = 1709;
                        continue block18;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block18;
                }
                case 204: {
                    return \u0632\ufead\u062f\u0628.\u0639\ufeb9\ufecd\u0641(\u062d\ufeb9\ufeab\ufef1.\ufeed\u0645\u0636\u0644(), objectArray);
                }
                case 239: 
            }
            break;
        }
        bl = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(string, \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(Cloud_baidu.\u0635\ufea5\u0628\ufec5(), 101, 3, 1642));
        n = 1740;
        block19: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block19;
                }
                case 17: {
                    if (bl) {
                        n = 1833;
                        continue block19;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block19;
                }
                case 500: {
                    return \ufeb9\u0643\ufed9\ufed5.\ufe8e\ufe9d\ufe99\u064a(\u062d\ufeb9\ufeab\ufef1.\ufeed\u0645\u0636\u0644());
                }
                case 471: 
            }
            break;
        }
        bl = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(string, \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(Cloud_baidu.\u0635\ufea5\u0628\ufec5(), 104, 5, 3139));
        n = 1864;
        block20: while (true) {
            switch (n ^= 0x759) {
                default: {
                    continue block20;
                }
                case 17: {
                    if (bl) {
                        n = 48736;
                        continue block20;
                    }
                }
                case 47483: {
                    n = 48705;
                    continue block20;
                }
                case 47417: {
                    return \ufecd\u0642\u062e\ufe9d.\ufeab\ufead\ufebd\u0633(\u062d\ufeb9\ufeab\ufef1.\ufeed\u0645\u0636\u0644(), objectArray);
                }
                case 47384: 
            }
            break;
        }
        return null;
    }

    public static Object[] proxys(Map<String, String> object, Map<String, String> map, String object2) {
        object = "\u06e3\u06e0\u06e8";
        object2 = null;
        Object[] objectArray = null;
        block4: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(object)) {
                default: {
                    object2 = \u062d\ufeb9\ufeab\ufef1.\ufeed\u0645\u0636\u0644();
                    object = "\u06e4\u06e6\u06e1";
                    continue block4;
                }
                case 1751711: {
                    objectArray = \u062d\ufeb9\ufeab\ufef1.\ufeaf\ufeab\u0639\ufe8f(object2, map);
                    object = "\u06e8\u06e7\u06e3";
                    continue block4;
                }
                case 1755588: 
            }
            break;
        }
        return objectArray;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Pattern \u062a\u0646\u0644\ufe99(Object object) {
        int n = \ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f();
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n > 0) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((Cloud_baidu)((Object)object)).yq;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            object = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return object;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n2 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Pattern \u062e\u062c\ufedd\ufe95(Object object) {
        int n = \u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9();
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n <= 0) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((Cloud_baidu)((Object)object)).tF;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            object = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return object;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n2 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static short[] \u0635\ufea5\u0628\ufec5() {
        int n = \ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1();
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n > 0) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
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
        n2 = 1740;
        block11: while (true) {
            short[] sArray = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return sArray;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n2 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0645\ufee9\ufec5\u0642() {
        int n = \u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd();
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n >= 0) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    return zH;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            String string = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return string;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n2 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Pattern \u064a\u0628\ufeb5\u063a(Object object) {
        int n = \ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646();
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n <= 0) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((Cloud_baidu)((Object)object)).N;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            object = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return object;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n2 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Pattern \ufecd\ufeb1\u0648\ufea1(Object object) {
        int n = \u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631();
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n >= 0) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((Cloud_baidu)((Object)object)).SN;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            object = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return object;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n2 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public String detailContent(List<String> object) {
        object = \u0645\u0641\u0630\u062d.\u064a\ufea9\u0644\u0643((Object)this, object);
        int n = 1616;
        block6: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (object == null) {
                        n = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block6;
                }
                case 204: {
                    return \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                }
                case 239: 
            }
            break;
        }
        return \ufea9\ufec5\u0647\u0641.\ufebd\ufeaf\ufee1\ufed5(object);
    }

    /*
     * Exception decompiling
     */
    public Ef detailVideo(List<String> var1_1) {
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
    public void init(Context var1_1, String var2_3) {
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
    public String playerContent(String var1_1, String var2_2, List<String> var3_4) {
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
     * Enabled aggressive block sorting
     */
    public void setFlag(String object) {
        zH = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        int n = \ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1();
        int n2 = 1616;
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (n >= 0) {
                        n2 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block6;
                }
                case 204: {
                    object = Long.decode(\ufee9\u0631\ufeb5\u0628.\ufed9\ufeed\ufe8f\ufed5("Z8AmIKzDvUtq9W"));
                    System.out.println(object);
                    return;
                }
                case 239: 
            }
            break;
        }
    }
}

