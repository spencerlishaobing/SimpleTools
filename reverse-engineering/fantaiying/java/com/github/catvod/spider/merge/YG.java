/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.zN;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Pattern;

public final class YG {
    public static final int yq = 0;

    static {
        Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    }

    public static String Gc(String string, String string2, String string3) {
        CharSequence charSequence = string;
        if (!YG.N(string)) {
            charSequence = string;
            if (!YG.N(string2)) {
                charSequence = string;
                if (string3 != null) {
                    int n2 = 0;
                    int n3 = string != null && string2 != null ? zN.yq(string, string2, 0) : -1;
                    if (n3 == -1) {
                        charSequence = string;
                    } else {
                        int n4 = string2.length();
                        int n5 = Math.max(string3.length() - n4, 0);
                        charSequence = new StringBuilder(string.length() + n5 * 16);
                        n5 = -1;
                        int n7 = n3;
                        n3 = n2;
                        while (true) {
                            n2 = n3;
                            if (n7 == -1) break;
                            ((StringBuilder)charSequence).append(string, n3, n7);
                            ((StringBuilder)charSequence).append(string3);
                            n3 = n7 + n4;
                            if (--n5 == 0) {
                                n2 = n3;
                                break;
                            }
                            n7 = zN.yq(string, string2, n3);
                        }
                        ((StringBuilder)charSequence).append(string, n2, string.length());
                        charSequence = ((StringBuilder)charSequence).toString();
                    }
                }
            }
        }
        return charSequence;
    }

    public static String KJ(String string, int n2, int n3) {
        if (string == null) {
            return null;
        }
        int n4 = n3;
        if (n3 < 0) {
            n4 = n3 + string.length();
        }
        n3 = n2;
        if (n2 < 0) {
            n3 = n2 + string.length();
        }
        n2 = n4;
        if (n4 > string.length()) {
            n2 = string.length();
        }
        if (n3 > n2) {
            return "";
        }
        n4 = n3;
        if (n3 < 0) {
            n4 = 0;
        }
        n3 = n2;
        if (n2 < 0) {
            n3 = 0;
        }
        return string.substring(n4, n3);
    }

    public static String M(String string, int n2) {
        if (string == null) {
            return null;
        }
        int n3 = n2;
        if (n2 < 0) {
            n3 = n2 + string.length();
        }
        n2 = n3;
        if (n3 < 0) {
            n2 = 0;
        }
        if (n2 > string.length()) {
            return "";
        }
        return string.substring(n2);
    }

    public static boolean N(CharSequence charSequence) {
        boolean bl = charSequence == null || charSequence.length() == 0;
        return bl;
    }

    public static boolean SN(CharSequence charSequence) {
        int n2 = charSequence == null ? 0 : charSequence.length();
        if (n2 == 0) {
            return true;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            if (Character.isWhitespace(charSequence.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    public static String i(String string, String string2) {
        String string3 = string;
        if (!YG.N(string)) {
            if (YG.N(string2)) {
                string3 = string;
            } else {
                string3 = string;
                if (string.endsWith(string2)) {
                    string3 = string.substring(0, string.length() - string2.length());
                }
            }
        }
        return string3;
    }

    public static String t0(String string, String string2) {
        String string3 = string;
        if (!YG.N(string)) {
            if (YG.N(string2)) {
                string3 = string;
            } else {
                string3 = string;
                if (string.startsWith(string2)) {
                    string3 = string.substring(string2.length());
                }
            }
        }
        return string3;
    }

    public static boolean tF(CharSequence charSequence) {
        return YG.SN(charSequence) ^ true;
    }

    public static boolean yq(CharSequence charSequence, CharSequence charSequence2) {
        boolean bl = false;
        if (charSequence != null && charSequence2 != null) {
            if (charSequence2.length() <= charSequence.length()) {
                bl = zN.SN(charSequence, false, charSequence.length() - charSequence2.length(), charSequence2, charSequence2.length());
            }
        } else if (charSequence == charSequence2) {
            bl = true;
        }
        return bl;
    }

    /*
     * Handled impossible loop by duplicating code
     * Enabled aggressive block sorting
     */
    public static String zH(Iterable<?> object, String string) {
        StringBuilder stringBuilder = null;
        if (object == null) {
            return null;
        }
        Iterator iterator = object.iterator();
        if (iterator == null) {
            return stringBuilder;
        }
        if (!iterator.hasNext()) {
            return "";
        }
        object = iterator.next();
        if (!iterator.hasNext()) {
            return Objects.toString(object, "");
        }
        stringBuilder = new StringBuilder(256);
        if (object != null) {
            stringBuilder.append(object);
        }
        while (iterator.hasNext()) {
            if (string != null) {
                stringBuilder.append(string);
            }
            if ((object = iterator.next()) == null) continue;
            stringBuilder.append(object);
        }
        return stringBuilder.toString();
    }
}

