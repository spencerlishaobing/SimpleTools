/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public final class Yx {
    @SerializedName(value="is_svip")
    private int N = 0;
    @SerializedName(value="used")
    private long SN = 0L;
    @SerializedName(value="uid")
    private String i;
    @SerializedName(value="username")
    private String tF;
    @SerializedName(value="total")
    private long yq = 0L;
    @SerializedName(value="uk")
    private String zH;

    /*
     * Enabled aggressive block sorting
     */
    public Yx() {
        Object object = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        this.tF = object;
        this.zH = object;
        this.i = object;
        int n2 = \ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9();
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
                    object = Integer.valueOf(\ufe9d\ufeab\u062e\u0640.\ufea1\ufecd\u0646\u0648("Te8qux3k"));
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
    public static Yx i(String object) {
        Yx yx = (Yx)\ufe99\u062e\u0642\u0644.\u0644\u0645\ufeaf\u0627(object, Yx.class);
        int n2 = 1616;
        block6: while (true) {
            object = yx;
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (yx == null) {
                        n2 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block6;
                }
                case 204: {
                    return new Yx();
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
    public static String \u0638\ufeb1\ufebd\ufea5(Object object, Object object2) {
        int n2 = \u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d();
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
    public static String \u0644\u0647\ufe8f\u0637(Object object) {
        int n2 = \u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647();
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
                    return ((Yx)object).i;
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
    public static long \ufea5\u0628\u0639\u0627(Object object) {
        int n2 = \ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c();
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
                    return ((Yx)object).SN;
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
    public static long \ufeab\ufeed\ufea5\u0641(Object object) {
        int n2 = \ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647();
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
                    return ((Yx)object).yq;
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
    public static int \ufed9\u0645\u062b\u062f(Object object) {
        int n2 = \ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5();
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
                    return ((Yx)object).N;
                }
                case 239: 
            }
            break;
        }
        n2 = 0;
        n3 = 1740;
        block11: while (true) {
            int n4 = n3 ^ 0x6DD;
            n3 = n2;
            switch (n4) {
                case 54: {
                    return n3;
                }
                default: {
                    n3 = n4;
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
    public final long N() {
        long l;
        long l2 = 0L;
        long l5 = Yx.\ufeab\ufeed\ufea5\u0641(this);
        int n2 = 1616;
        block6: while (true) {
            l = l2;
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (l5 == 0L) {
                        n2 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block6;
                }
                case 239: {
                    return l5;
                }
                case 204: 
            }
            break;
        }
        return l;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final long SN() {
        long l = 0L;
        long l2 = Yx.\ufeab\ufeed\ufea5\u0641(this);
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (l2 == 0L) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    n2 = 1740;
                    block11: while (true) {
                        l2 = l;
                        switch (n2 ^= 0x6DD) {
                            default: {
                                continue block11;
                            }
                            case 17: {
                                n2 = 1771;
                                continue block11;
                            }
                            case 54: 
                        }
                        break;
                    }
                    return l2;
                }
                case 239: 
            }
            break;
        }
        l2 -= Yx.\ufea5\u0628\u0639\u0627(this);
        return l2;
    }

    public final void t0(String string) {
        this.i = string;
    }

    public final String tF() {
        return Yx.\u0644\u0647\ufe8f\u0637(this);
    }

    public final String toString() {
        return Yx.\u0638\ufeb1\ufebd\ufea5(new Gson(), this);
    }

    public final Yx yq() {
        String string = null;
        String string2 = "\u06e5\u06e8\u06e1";
        block9: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string2)) {
                default: {
                    this.yq = 0L;
                    string2 = "\u06e5\u06e6\u06e3";
                    continue block9;
                }
                case 1752674: {
                    this.SN = 0L;
                    string2 = "\u06e3\u06e0\u06e0";
                    continue block9;
                }
                case 1750563: {
                    string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                    string2 = "\u06e2\u06e0\u06e4";
                    continue block9;
                }
                case 1749606: {
                    this.zH = string;
                    string2 = "\u06df\u06df\u06e4";
                    continue block9;
                }
                case 1753511: {
                    this.N = 0;
                    string2 = "\u06e3\u06e2\u06e4";
                    continue block9;
                }
                case 1746692: {
                    this.tF = string;
                    string2 = "\u06e6\u06e2\u06e3";
                    continue block9;
                }
                case 1750629: {
                    this.i = string;
                    string2 = "\u06e2\u06e7\u06e5";
                    continue block9;
                }
                case 1749824: 
            }
            break;
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean zH() {
        boolean bl = true;
        int n2 = Yx.\ufed9\u0645\u062b\u062f(this);
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 == 1) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    boolean bl2;
                    n3 = 1740;
                    block11: while (true) {
                        bl2 = bl;
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
                    return bl2;
                }
                case 239: 
            }
            break;
        }
        return false;
    }
}

