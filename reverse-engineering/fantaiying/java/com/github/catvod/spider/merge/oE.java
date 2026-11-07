/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.github.catvod.spider.merge;

import android.os.Build;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.\ufea5\ufea9\u0633\ufed5;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class oE
implements Comparator<tX> {
    private static final short[] short = new short[]{902, 3250};

    /*
     * Enabled aggressive block sorting
     */
    public oE() {
        int n2 = \ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5();
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
                    Double d = Double.valueOf(\ufeab\u062d\u063a\ufea9.\u064a\u0644\u0639\ufe99("WtvjrYFkdozc7wxaHDzt85VACYzTH"));
                    System.out.println(d);
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
    public static void SN(List<tX> list) {
        int n2 = Build.VERSION.SDK_INT;
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 >= 24) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    list.sort(new oE());
                    n3 = 1740;
                    block11: while (true) {
                        switch (n3 ^= 0x6DD) {
                            default: {
                                continue block11;
                            }
                            case 17: {
                                n3 = 1771;
                                continue block11;
                            }
                            case 54: 
                        }
                        break;
                    }
                    return;
                }
                case 239: 
            }
            break;
        }
        Collections.sort(list, new oE());
    }

    /*
     * Unable to fully structure code
     */
    private String yq(String var1_1) {
        var4_2 = var1_1.lastIndexOf(\ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(oE.short, 0, 1, 936));
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
                                            var7_4.append(\ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(oE.short, 1, 1, 3202));
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
    public static String \u0631\u0640\ufec1\ufee9(Object object, Object object2) {
        int n2 = \ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95();
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
                    return ((oE)object).yq((String)object2);
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
        object = (tX)object;
        object2 = (tX)object2;
        boolean bl = \ufeed\ufebd\u0635\ufedd.\ufee9\ufec5\u0642\u0644(object);
        boolean bl2 = \ufeed\ufebd\u0635\ufedd.\ufee9\ufec5\u0642\u0644(object2);
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
        return \u0635\u0631\u0645\u0628.\u062b\ufebd\u0635\u0637(oE.\u0631\u0640\ufec1\ufee9(this, \ufeaf\u0633\u0648\ufee9.\ufee1\u0636\u0639\ufeb1(object)), oE.\u0631\u0640\ufec1\ufee9(this, \ufeaf\u0633\u0648\ufee9.\ufee1\u0636\u0639\ufeb1(object2)));
    }
}

