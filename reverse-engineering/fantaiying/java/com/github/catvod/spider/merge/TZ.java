/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import java.util.Comparator;
import java.util.List;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class TZ
implements Comparator<H7> {
    private static final short[] short = new short[]{2663, 1488};

    /*
     * Enabled aggressive block sorting
     */
    public TZ() {
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
                    Long l = Long.decode(\ufeed\ufebd\u0635\ufedd.\u0647\ufebd\ufef1\u0648("qVc56cIxkJEgdGtGyn4IjTe"));
                    System.out.println(l);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    /*
     * Exception decompiling
     */
    public static void SN(List<H7> var0) {
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
     * Unable to fully structure code
     */
    private String yq(String var1_1) {
        var4_2 = var1_1.lastIndexOf(\u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(TZ.short, 0, 1, 2633));
        var3_3 = 1616;
        block18: while (true) {
            var7_4 = var1_1;
            switch (var3_3 ^= 1633) {
                default: {
                    continue block18;
                }
lbl8:
                // 2 sources

                case 14: {
                    var3_3 = 1678;
                    continue block18;
                }
                case 49: {
                    if (var4_2 <= 0) ** GOTO lbl8
                    var3_3 = 1709;
                    continue block18;
                }
                case 204: {
                    var5_5 = var1_1.length();
                    var3_3 = 1740;
                    block20: while (true) {
                        var7_4 = var1_1;
                        switch (var3_3 ^= 1757) {
                            default: {
                                continue block20;
                            }
                            case 17: {
                                if (var4_2 < var5_5 - 1) {
                                    var3_3 = 1833;
                                    continue block20;
                                }
                            }
                            case 54: {
                                var3_3 = 1802;
                                continue block20;
                            }
                            case 500: {
                                var8_6 = var1_1.substring(0, var4_2);
                                var2_7 = var8_6.charAt(var8_6.length() - 1);
                                var6_8 = Character.isDigit(var2_7);
                                var3_3 = 1864;
                                block21: while (true) {
                                    var7_4 = var1_1;
                                    switch (var3_3 ^= 1881) {
                                        default: {
                                            continue block21;
                                        }
                                        case 17: {
                                            if (var6_8) {
                                                var3_3 = 48736;
                                                continue block21;
                                            }
                                        }
                                        case 47483: {
                                            var3_3 = 48705;
                                            continue block21;
                                        }
                                        case 47417: {
                                            var7_4 = new StringBuilder();
                                            var7_4.append(var8_6.substring(0, var8_6.length() - 1));
                                            var7_4.append(\ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(TZ.short, 1, 1, 1504));
                                            var7_4.append(var2_7);
                                            var7_4.append(var1_1.substring(var4_2));
                                            var7_4 = var7_4.toString();
                                        }
                                        case 47384: 
                                    }
                                    break;
                                }
                            }
                            case 471: 
                        }
                        break;
                    }
                }
                case 239: 
            }
            break;
        }
        return var7_4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0637\ufec1\u064a\ufecd(Object object, Object object2) {
        int n2 = \ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c();
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
                    return ((TZ)object).yq((String)object2);
                }
                case 239: 
            }
            break;
        }
        object2 = null;
        n3 = 1740;
        block11: while (true) {
            object = object2;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return object;
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
    @Override
    public final int compare(Object object, Object object2) {
        object = (H7)object;
        object2 = (H7)object2;
        boolean bl = \u062b\u064a\ufecd\u0642.\u062a\ufeb5\ufee1\u0627(object);
        boolean bl2 = \u062b\u064a\ufecd\u0642.\u062a\ufeb5\ufee1\u0627(object2);
        int n2 = 1616;
        block36: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block36;
                }
                case 49: {
                    if (bl) {
                        n2 = 1709;
                        continue block36;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block36;
                }
                case 204: {
                    n2 = 1740;
                    block37: while (true) {
                        switch (n2 ^= 0x6DD) {
                            default: {
                                continue block37;
                            }
                            case 17: {
                                if (bl2) {
                                    n2 = 1833;
                                    continue block37;
                                }
                            }
                            case 54: {
                                n2 = 1802;
                                continue block37;
                            }
                            case 500: {
                                int n3 = 0;
                                n2 = 1864;
                                block38: while (true) {
                                    int n4 = n2 ^ 0x759;
                                    n2 = n3;
                                    switch (n4) {
                                        default: {
                                            n2 = n4;
                                            continue block38;
                                        }
                                        case 17: {
                                            n2 = 48674;
                                            continue block38;
                                        }
                                        case 47483: 
                                    }
                                    break;
                                }
                                return n2;
                            }
                            case 471: 
                        }
                        break;
                    }
                    break block36;
                }
                case 239: 
            }
            break;
        }
        n2 = 48767;
        block39: while (true) {
            switch (n2 ^= 0xBE90) {
                default: {
                    continue block39;
                }
                case 239: {
                    if (bl) {
                        n2 = 48860;
                        continue block39;
                    }
                }
                case 14: {
                    n2 = 48829;
                    continue block39;
                }
                case 76: {
                    int n5 = -1;
                    n2 = 48891;
                    block40: while (true) {
                        int n7 = n2 ^ 0xBF0C;
                        n2 = n5;
                        switch (n7) {
                            default: {
                                n2 = n7;
                                continue block40;
                            }
                            case 22: {
                                return n2;
                            }
                            case 503: 
                        }
                        n2 = 48922;
                    }
                }
                case 45: 
            }
            break;
        }
        n2 = 49666;
        block41: while (true) {
            switch (n2 ^= 0xC213) {
                default: {
                    continue block41;
                }
                case 17: {
                    if (bl2) {
                        n2 = 49759;
                        continue block41;
                    }
                }
                case 50: {
                    n2 = 49728;
                    continue block41;
                }
                case 76: {
                    int n8 = 1;
                    n2 = 49790;
                    block42: while (true) {
                        int n9 = n2 ^ 0xC28F;
                        n2 = n8;
                        switch (n9) {
                            case 18: {
                                return n2;
                            }
                            default: {
                                n2 = n9;
                                continue block42;
                            }
                            case 241: 
                        }
                        n2 = 49821;
                    }
                }
                case 83: 
            }
            break;
        }
        return \u0635\u0631\u0645\u0628.\u062b\ufebd\u0635\u0637(TZ.\u0637\ufec1\u064a\ufecd(this, \ufea9\u0643\u062d\u063a.\u0647\ufeb9\ufead\u0646(object)), TZ.\u0637\ufec1\u064a\ufecd(this, \ufea9\u0643\u062d\u063a.\u0647\ufeb9\ufead\u0646(object2)));
    }
}

