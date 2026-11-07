/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

public final class zN {
    static boolean SN(CharSequence charSequence, boolean bl, int n2, CharSequence charSequence2, int n3) {
        if (charSequence instanceof String && charSequence2 instanceof String) {
            return ((String)charSequence).regionMatches(bl, n2, (String)charSequence2, 0, n3);
        }
        int n4 = charSequence.length();
        int n5 = charSequence2.length();
        if (n2 >= 0 && n3 >= 0 && n4 - n2 >= n3 && n5 - 0 >= n3) {
            n4 = 0;
            n5 = n2;
            n2 = n4;
            while (n3 > 0) {
                char c;
                char c2 = charSequence.charAt(n5);
                if (c2 != (c = charSequence2.charAt(n2))) {
                    if (!bl) {
                        return false;
                    }
                    if ((c2 = Character.toUpperCase(c2)) != (c = Character.toUpperCase(c)) && Character.toLowerCase(c2) != Character.toLowerCase(c)) {
                        return false;
                    }
                }
                ++n5;
                --n3;
                ++n2;
            }
            return true;
        }
        return false;
    }

    static int yq(CharSequence charSequence, CharSequence charSequence2, int n2) {
        if (charSequence instanceof String) {
            return ((String)charSequence).indexOf(charSequence2.toString(), n2);
        }
        if (charSequence instanceof StringBuilder) {
            return ((StringBuilder)charSequence).indexOf(charSequence2.toString(), n2);
        }
        if (charSequence instanceof StringBuffer) {
            return ((StringBuffer)charSequence).indexOf(charSequence2.toString(), n2);
        }
        return charSequence.toString().indexOf(charSequence2.toString(), n2);
    }
}

