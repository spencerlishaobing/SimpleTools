/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import java.util.HashMap;
import java.util.Map;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class zE {
    private static final Map<char[], Map<Character, Integer>> SN;
    private static final short[] short;
    private static final char[] yq;

    static {
        short = new short[]{538, 537, 536, 543, 542, 541, 540, 531, 530, 529, 528, 535, 534, 533, 532, 523, 522, 521, 520, 527, 526, 525, 524, 515, 514, 513, 570, 569, 568, 575, 574, 573, 572, 563, 562, 561, 560, 567, 566, 565, 564, 555, 554, 553, 552, 559, 558, 557, 556, 547, 546, 545, 619, 618, 617, 616, 623, 622, 621, 620, 611, 610, 624, 628, 614};
        yq = \ufeaf\ufea5\ufeab\u062e.\ufea9\u0635\ufe8f\u0640(\u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(zE.\ufea5\ufef1\ufeb1\u0636(), 0, 65, 603));
        SN = new HashMap<char[], Map<Character, Integer>>();
    }

    /*
     * Exception decompiling
     */
    public static String N(String var0) {
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
    static char SN(char[] cArray, Character c) {
        HashMap hashMap;
        HashMap hashMap2 = zE.\ufec9\u0640\u0646\u0644();
        HashMap hashMap3 = (HashMap)\u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(hashMap2, cArray);
        int n2 = 1616;
        block16: while (true) {
            hashMap = hashMap3;
            switch (n2 ^= 0x661) {
                default: {
                    continue block16;
                }
                case 49: {
                    if (hashMap3 == null) {
                        n2 = 1709;
                        continue block16;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block16;
                }
                case 204: {
                    hashMap = new HashMap();
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap2, cArray, hashMap);
                    int n3 = 0;
                    block17: while (true) {
                        int n4 = cArray.length;
                        n2 = 1740;
                        block18: while (true) {
                            switch (n2 ^= 0x6DD) {
                                default: {
                                    continue block18;
                                }
                                case 17: {
                                    if (n3 < n4) {
                                        n2 = 1833;
                                        continue block18;
                                    }
                                }
                                case 54: {
                                    n2 = 1802;
                                    continue block18;
                                }
                                case 500: {
                                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, \ufeaf\u062b\ufed5\ufec1.\u0645\u0636\u0639\ufe8f(cArray[n3]), \ufe8e\ufec1\u0641\u0644.\u062b\u0635\ufeab\ufeaf(n3));
                                    n4 = n3 + 1;
                                    n2 = 1864;
                                    block19: while (true) {
                                        n3 = n4;
                                        switch (n2 ^= 0x759) {
                                            case 47483: {
                                                continue block17;
                                            }
                                            default: {
                                                continue block19;
                                            }
                                            case 17: 
                                        }
                                        n2 = 48674;
                                    }
                                }
                                case 471: 
                            }
                            break;
                        }
                        break;
                    }
                    return (char)\u062f\ufead\ufeaf\u062d.\u062d\ufe9d\ufead\u0635((Integer)\ufea9\ufec5\u0647\u0641.\ufe95\u0627\ufea1\u0647(hashMap, c));
                }
                case 239: 
            }
            break;
        }
        return (char)\u062f\ufead\ufeaf\u062d.\u062d\ufe9d\ufead\u0635((Integer)\ufea9\ufec5\u0647\u0641.\ufe95\u0627\ufea1\u0647(hashMap, c));
    }

    /*
     * Enabled aggressive block sorting
     */
    public static char \u063a\ufeaf\u0628\ufe95(Object object, int n2) {
        int n3 = \u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd();
        int n4 = 1616;
        block10: while (true) {
            switch (n4 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n3 < 0) {
                        n4 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n4 = 1678;
                    continue block10;
                }
                case 204: {
                    return (object).yq(n2);
                }
                case 239: 
            }
            break;
        }
        char c = '\u0000';
        n2 = 1740;
        block11: while (true) {
            char c2 = c;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return c2;
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
    public static char[] \u0642\ufedd\ufea5\ufe8f() {
        int n2 = \ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5();
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
                    return yq;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            char[] cArray = var3_3;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return cArray;
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
    public static short[] \ufea5\ufef1\ufeb1\u0636() {
        int n2 = \u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a();
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
    public static HashMap \ufec9\u0640\u0646\u0644() {
        int n2 = \ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632();
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
                    return SN;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            Map<char[], Map<Character, Integer>> map = var3_3;
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

    private static abstract class SN {
        /*
         * Enabled aggressive block sorting
         */
        SN() {
            int n2 = \ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f();
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
                        Float f = Float.decode((String)\u062a\u0635\ufeb1\u0642.\ufebd\u0635\u0628\ufee1("6YYj5zi9kxF5AuBr7pV3A21Jqn"));
                        System.out.println(f);
                        return;
                    }
                    case 239: 
                }
                break;
            }
        }
    }
}

