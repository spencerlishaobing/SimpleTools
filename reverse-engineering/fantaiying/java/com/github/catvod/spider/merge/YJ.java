/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.github.catvod.spider.merge;

import android.os.Build;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class YJ
implements Comparator<n6> {
    private static final short[] short = new short[]{446, 774};

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void SN(List<n6> list) {
        if (Build.VERSION.SDK_INT >= 24) {
            list.sort(new YJ());
            return;
        }
        Collections.sort(list, new YJ());
    }

    private String yq(String string) {
        int n2 = string.lastIndexOf(\ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 0, 1, 400));
        CharSequence charSequence = string;
        if (n2 > 0) {
            charSequence = string;
            if (n2 < string.length() - 1) {
                String string2 = string.substring(0, n2);
                char c = string2.charAt(string2.length() - 1);
                charSequence = string;
                if (Character.isDigit(c)) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(string2.substring(0, string2.length() - 1));
                    ((StringBuilder)charSequence).append(\u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(short, 1, 1, 822));
                    ((StringBuilder)charSequence).append(c);
                    ((StringBuilder)charSequence).append(string.substring(n2));
                    charSequence = ((StringBuilder)charSequence).toString();
                }
            }
        }
        return charSequence;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe9d\ufecd\u0633\u0645(Object object, Object object2) {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() <= 0) return null;
        return ((YJ)object).yq((String)object2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final int compare(Object object, Object object2) {
        object = (n6)object;
        object2 = (n6)object2;
        boolean bl = \ufeb9\u0627\ufea5\ufe9d.\ufeb9\u0633\u0627\ufed9(object);
        boolean bl2 = \ufeb9\u0627\ufea5\ufe9d.\ufeb9\u0633\u0627\ufed9(object2);
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
        return \u0635\u0631\u0645\u0628.\u062b\ufebd\u0635\u0637(YJ.\ufe9d\ufecd\u0633\u0645(this, \u0632\ufead\u062f\u0628.\u0634\u063a\u062e\ufeb5(object)), YJ.\ufe9d\ufecd\u0633\u0645(this, \u0632\ufead\u062f\u0628.\u0634\u063a\u062e\ufeb5(object2)));
    }
}

