/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.GR;
import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.rQ;

public final class JC
extends rQ {
    public static String Gc(String object, String string, String string2) {
        block6: {
            block5: {
                int n2;
                int n3;
                int n4 = GR.tF((CharSequence)object, string, 0, false);
                if (n4 < 0) break block5;
                int n5 = string.length();
                int n7 = 1;
                if (n5 >= 1) {
                    n7 = n5;
                }
                int n8 = ((String)object).length();
                n8 = string2.length() + (n8 - n5);
                if (n8 < 0) break block6;
                StringBuilder stringBuilder = new StringBuilder(n8);
                n8 = 0;
                do {
                    stringBuilder.append((CharSequence)object, n8, n4);
                    stringBuilder.append(string2);
                    n2 = n4 + n5;
                    if (n4 >= ((String)object).length()) break;
                    n4 = n3 = GR.tF((CharSequence)object, string, n4 + n7, false);
                    n8 = n2;
                } while (n3 > 0);
                stringBuilder.append((CharSequence)object, n2, ((String)object).length());
                object = stringBuilder.toString();
                Nh.tF(object, "stringBuilder.append(this, i, length).toString()");
            }
            return object;
        }
        object = new OutOfMemoryError();
        throw object;
    }

    public static boolean i(CharSequence charSequence) {
        boolean bl = false;
        if (GR.tF(charSequence, "getsockname failed", 0, false) >= 0) {
            bl = true;
        }
        return bl;
    }

    public static int t0(CharSequence charSequence, int n2, int n3) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        return ((String)charSequence).indexOf(46, n2);
    }
}

