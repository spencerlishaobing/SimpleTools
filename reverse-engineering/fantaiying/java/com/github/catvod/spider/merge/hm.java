/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufea5\ufea9\u0633\ufed5;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class hm {
    private static final short[] short = new short[]{755, 756, 751, 747, 741, 750, 1813, 1810, 1801, 1805, 1795, 1800, 1915, 2559, 2553, 2536, 2542, 2542, 637, 635, 618, 620, 620, 514, 2519, 654, 648, 665, 671, 671, 1194, 3139, 3141, 3156, 3154, 3154, 3132, 2005, 2001, 1994, 1998, 1984, 1995, 2736, 2740, 2735, 2731, 2725, 2734, 2781, 2723};
    @SerializedName(value="ptoken")
    private String N;
    @SerializedName(value="stoken")
    private String SN;
    @SerializedName(value="devuid")
    private String tF;
    @SerializedName(value="bduss")
    private String yq;

    /*
     * Enabled aggressive block sorting
     */
    public hm() {
        Object object = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        this.yq = object;
        this.SN = object;
        this.N = object;
        this.tF = object;
        int n2 = \u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a();
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
                    object = Double.valueOf(\ufecd\u0642\u062e\ufe9d.\ufe95\ufeed\ufea5\u0644("91dx"));
                    System.out.println(object);
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
    public static hm M(String object) {
        hm hm2 = (hm)\ufe99\u062e\u0642\u0644.\u0644\u0645\ufeaf\u0627(object, hm.class);
        int n2 = 1616;
        block6: while (true) {
            object = hm2;
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (hm2 == null) {
                        n2 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block6;
                }
                case 204: {
                    return new hm();
                }
                case 239: 
            }
            break;
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0630\u0641\ufec5\u0631(Object object) {
        int n2 = \u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a();
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
                    return ((hm)object).N;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            object = var3_3;
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
    public static String \u0640\u0637\u0646\u062f(Object object) {
        int n2 = \u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd();
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
                    return ((hm)object).SN;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            object = var3_3;
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
    public static short[] \u0641\ufee9\u062a\ufeb5() {
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
    public static String \u0644\u0648\ufeb9\ufeab(Object object, Object object2) {
        int n2 = \ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643();
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
                    return ((Gson)object).toJson(object2);
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
    public static String \ufead\u0642\ufe99\u0646(Object object) {
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
                    return ((hm)object).yq;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            object = var3_3;
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
    public static String \ufeb9\u062c\u0640\u0648(Object object) {
        int n2 = \ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f();
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
                    return ((hm)object).tF;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            object = var3_3;
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
    public final void B(String object) {
        this.SN = object;
        int n2 = \ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5();
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
                    object = Integer.decode(\ufe99\u062e\u0642\u0644.\ufeed\u0628\ufeb1\u0639("nvUO8IT"));
                    System.out.println(object);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public final String Gc() {
        void var3_7;
        boolean bl = \u0635\u0631\u0645\u0628.\u064a\u062c\ufeed\u062e(hm.\u0640\u0637\u0646\u062f(this));
        int n2 = 1616;
        block20: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block20;
                }
                case 49: {
                    if (bl) {
                        n2 = 1709;
                        continue block20;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block20;
                }
                case 204: {
                    String string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                    n2 = 1740;
                    block21: while (true) {
                        String string2 = string;
                        switch (n2 ^= 0x6DD) {
                            default: {
                                continue block21;
                            }
                            case 17: {
                                n2 = 1771;
                                continue block21;
                            }
                            case 54: 
                        }
                        break;
                    }
                    return var3_7;
                }
                case 239: 
            }
            break;
        }
        bl = \u0632\ufead\u062f\u0628.\u0638\ufea5\ufec1\ufe8f(hm.\u0640\u0637\u0646\u062f(this), \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(hm.\u0641\ufee9\u062a\ufeb5(), 0, 6, 672));
        n2 = 1864;
        block22: while (true) {
            switch (n2 ^= 0x759) {
                default: {
                    continue block22;
                }
                case 17: {
                    if (bl) {
                        n2 = 48736;
                        continue block22;
                    }
                }
                case 47483: {
                    n2 = 48705;
                    continue block22;
                }
                case 47417: {
                    String string = hm.\u0640\u0637\u0646\u062f(this);
                    n2 = 48767;
                    block23: while (true) {
                        String string3 = string;
                        switch (n2 ^= 0xBE90) {
                            default: {
                                continue block23;
                            }
                            case 14: {
                                return var3_7;
                            }
                            case 239: 
                        }
                        n2 = 48798;
                    }
                }
                case 47384: 
            }
            break;
        }
        StringBuilder stringBuilder = \ufea9\ufec5\u0647\u0641.\ufeed\ufe8e\ufec5\ufea9(\ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(hm.\u0641\ufee9\u062a\ufeb5(), 6, 7, 1862));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, hm.\u0640\u0637\u0646\u062f(this));
        String string = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder);
        return var3_7;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void KJ(String string) {
        this.yq = string;
        int n2 = \ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646();
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
                    float f = Float.parseFloat(\ufecd\u0642\u062e\ufe9d.\ufe95\ufeed\ufea5\u0644("RgkTaApiR8TVlmRjUaxNMdR"));
                    System.out.println(f);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public final String N() {
        void var3_7;
        boolean bl = \u0635\u0631\u0645\u0628.\u064a\u062c\ufeed\u062e(hm.\ufead\u0642\ufe99\u0646(this));
        int n2 = 1616;
        block20: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block20;
                }
                case 49: {
                    if (bl) {
                        n2 = 1709;
                        continue block20;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block20;
                }
                case 204: {
                    String string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                    n2 = 1740;
                    block21: while (true) {
                        String string2 = string;
                        switch (n2 ^= 0x6DD) {
                            default: {
                                continue block21;
                            }
                            case 17: {
                                n2 = 1771;
                                continue block21;
                            }
                            case 54: 
                        }
                        break;
                    }
                    return var3_7;
                }
                case 239: 
            }
            break;
        }
        bl = \u0632\ufead\u062f\u0628.\u0638\ufea5\ufec1\ufe8f(hm.\ufead\u0642\ufe99\u0646(this), \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(hm.\u0641\ufee9\u062a\ufeb5(), 13, 5, 2493));
        n2 = 1864;
        block22: while (true) {
            switch (n2 ^= 0x759) {
                default: {
                    continue block22;
                }
                case 17: {
                    if (bl) {
                        n2 = 48736;
                        continue block22;
                    }
                }
                case 47483: {
                    n2 = 48705;
                    continue block22;
                }
                case 47417: {
                    String string = hm.\ufead\u0642\ufe99\u0646(this);
                    n2 = 48767;
                    block23: while (true) {
                        String string3 = string;
                        switch (n2 ^= 0xBE90) {
                            default: {
                                continue block23;
                            }
                            case 14: {
                                return var3_7;
                            }
                            case 239: 
                        }
                        n2 = 48798;
                    }
                }
                case 47384: 
            }
            break;
        }
        StringBuilder stringBuilder = \ufea9\ufec5\u0647\u0641.\ufeed\ufe8e\ufec5\ufea9(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(hm.\u0641\ufee9\u062a\ufeb5(), 18, 6, 575));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, hm.\ufead\u0642\ufe99\u0646(this));
        String string = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder);
        return var3_7;
    }

    public final String SN() {
        String string = "\u06e2\u06e4\u06e2";
        StringBuilder stringBuilder = null;
        short[] sArray = null;
        String string2 = null;
        block11: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string2);
                    string = "\u06e1\u06e7\u06df";
                    continue block11;
                }
                case 1755464: {
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string2);
                    string = "\u06e8\u06e3\u06e2";
                    continue block11;
                }
                case 1748857: {
                    string2 = \u0645\u0641\u0630\u062d.\u062f\u063a\u062e\u0636(this);
                    string = "\u06e8\u06e3\u06e3";
                    continue block11;
                }
                case 1746847: {
                    string2 = \u062d\ufeb9\ufeab\ufef1.\u0641\u0642\ufea9\ufedd(this);
                    string = "\u06e5\u06e8\u06e6";
                    continue block11;
                }
                case 1753423: {
                    string2 = \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(sArray, 24, 1, 2540);
                    string = "\u06e7\u06e1\u06e2";
                    continue block11;
                }
                case 1752739: {
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string2);
                    string = "\u06e0\u06e0\u06e0";
                    continue block11;
                }
                case 1749728: {
                    stringBuilder = new StringBuilder();
                    string = "\u06df\u06e4\u06e4";
                    continue block11;
                }
                case 1747680: {
                    sArray = hm.\u0641\ufee9\u062a\ufeb5();
                    string = "\u06e6\u06df\u06e8";
                    continue block11;
                }
                case 1755463: {
                    string2 = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder);
                    string = "\u06e8\u06e4\u06e8";
                    continue block11;
                }
                case 1755500: 
            }
            break;
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final String i() {
        String string;
        boolean bl = \u0635\u0631\u0645\u0628.\u064a\u062c\ufeed\u062e(hm.\ufead\u0642\ufe99\u0646(this));
        String string2 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        int n2 = 1616;
        block20: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block20;
                }
                case 49: {
                    if (bl) {
                        n2 = 1709;
                        continue block20;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block20;
                }
                case 204: {
                    n2 = 1740;
                    block21: while (true) {
                        switch (n2 ^= 0x6DD) {
                            default: {
                                continue block21;
                            }
                            case 17: {
                                n2 = 1771;
                                continue block21;
                            }
                            case 54: 
                        }
                        break;
                    }
                    return string2;
                }
                case 239: 
            }
            break;
        }
        bl = \u0632\ufead\u062f\u0628.\u0638\ufea5\ufec1\ufe8f(hm.\ufead\u0642\ufe99\u0646(this), \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(hm.\u0641\ufee9\u062a\ufeb5(), 25, 5, 716));
        String string3 = \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(hm.\u0641\ufee9\u062a\ufeb5(), 30, 1, 1169);
        n2 = 1864;
        block22: while (true) {
            switch (n2 ^= 0x759) {
                default: {
                    continue block22;
                }
                case 17: {
                    if (bl) {
                        n2 = 48736;
                        continue block22;
                    }
                }
                case 47483: {
                    n2 = 48705;
                    continue block22;
                }
                case 47417: {
                    String string4 = \ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(hm.\ufead\u0642\ufe99\u0646(this), \u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(hm.\u0641\ufee9\u062a\ufeb5(), 31, 6, 3073), string2);
                    n2 = 48767;
                    block23: while (true) {
                        string = string4;
                        switch (n2 ^= 0xBE90) {
                            default: {
                                continue block23;
                            }
                            case 14: {
                                return \ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(string, string3, string2);
                            }
                            case 239: 
                        }
                        n2 = 48798;
                    }
                }
                case 47384: {
                    string = hm.\ufead\u0642\ufe99\u0646(this);
                }
            }
            break;
        }
        return \ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(string, string3, string2);
    }

    public final hm q(String string) {
        this.tF = string;
        return this;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public final String t0() {
        void var3_7;
        boolean bl = \u0635\u0631\u0645\u0628.\u064a\u062c\ufeed\u062e(hm.\u0630\u0641\ufec5\u0631(this));
        int n2 = 1616;
        block20: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block20;
                }
                case 49: {
                    if (bl) {
                        n2 = 1709;
                        continue block20;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block20;
                }
                case 204: {
                    String string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                    n2 = 1740;
                    block21: while (true) {
                        String string2 = string;
                        switch (n2 ^= 0x6DD) {
                            default: {
                                continue block21;
                            }
                            case 17: {
                                n2 = 1771;
                                continue block21;
                            }
                            case 54: 
                        }
                        break;
                    }
                    return var3_7;
                }
                case 239: 
            }
            break;
        }
        bl = \u0632\ufead\u062f\u0628.\u0638\ufea5\ufec1\ufe8f(hm.\u0630\u0641\ufec5\u0631(this), \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(hm.\u0641\ufee9\u062a\ufeb5(), 37, 6, 1925));
        n2 = 1864;
        block22: while (true) {
            switch (n2 ^= 0x759) {
                default: {
                    continue block22;
                }
                case 17: {
                    if (bl) {
                        n2 = 48736;
                        continue block22;
                    }
                }
                case 47483: {
                    n2 = 48705;
                    continue block22;
                }
                case 47417: {
                    String string = hm.\u0630\u0641\ufec5\u0631(this);
                    n2 = 48767;
                    block23: while (true) {
                        String string3 = string;
                        switch (n2 ^= 0xBE90) {
                            default: {
                                continue block23;
                            }
                            case 14: {
                                return var3_7;
                            }
                            case 239: 
                        }
                        n2 = 48798;
                    }
                }
                case 47384: 
            }
            break;
        }
        StringBuilder stringBuilder = \ufea9\ufec5\u0647\u0641.\ufeed\ufe8e\ufec5\ufea9(\ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(hm.\u0641\ufee9\u062a\ufeb5(), 43, 7, 2784));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, hm.\u0630\u0641\ufec5\u0631(this));
        String string = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder);
        return var3_7;
    }

    /*
     * Exception decompiling
     */
    public final String tF() {
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

    public final String toString() {
        return hm.\u0644\u0648\ufeb9\ufeab(new Gson(), this);
    }

    public final hm yq() {
        String string = null;
        String string2 = "\u06e7\u06e3";
        block7: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string2)) {
                default: {
                    return this;
                }
                case 1751715: {
                    this.N = string;
                    string2 = "\u06e0\u06e2\u06e6";
                    continue block7;
                }
                case 56540: {
                    string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                    string2 = "\u06e4\u06e6\u06e8";
                    continue block7;
                }
                case 1751718: {
                    this.yq = string;
                    string2 = "\u06e8\u06e5\u06e4";
                    continue block7;
                }
                case 1755527: {
                    this.SN = string;
                    string2 = "\u06e4\u06e6\u06e5";
                    continue block7;
                }
                case 1747748: 
            }
            this.tF = string;
            string2 = "\u06e0\u06e5\u06df";
        }
    }

    public final String zH() {
        return hm.\ufeb9\u062c\u0640\u0648(this);
    }
}

