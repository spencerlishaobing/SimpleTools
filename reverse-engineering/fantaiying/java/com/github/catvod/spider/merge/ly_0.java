/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.qk;
import java.io.Writer;

/*
 * Renamed from com.github.catvod.spider.merge.Ly
 */
@Deprecated
public final class ly_0
extends qk {
    @Override
    public final int yq(CharSequence charSequence, int n2, Writer appendable) {
        int n3;
        if (charSequence.charAt(n2) == '\\' && (n3 = n2 + 1) < charSequence.length() && charSequence.charAt(n3) == 'u') {
            int n4;
            n3 = 2;
            while ((n4 = n2 + n3) < charSequence.length() && charSequence.charAt(n4) == 'u') {
                ++n3;
            }
            int n5 = n3;
            if (n4 < charSequence.length()) {
                n5 = n3;
                if (charSequence.charAt(n4) == '+') {
                    n5 = n3 + 1;
                }
            }
            if ((n3 = (n4 = n2 + n5) + 4) <= charSequence.length()) {
                charSequence = charSequence.subSequence(n4, n3);
                try {
                    ((Writer)appendable).write((char)Integer.parseInt(charSequence.toString(), 16));
                    return n5 + 4;
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to parse unicode value: ");
                    stringBuilder.append((Object)charSequence);
                    throw new IllegalArgumentException(stringBuilder.toString(), numberFormatException);
                }
            }
            appendable = oi_0.yq("Less than 4 hex digits in unicode value: '");
            ((StringBuilder)appendable).append((Object)charSequence.subSequence(n2, charSequence.length()));
            ((StringBuilder)appendable).append("' due to end of CharSequence");
            throw new IllegalArgumentException(((StringBuilder)appendable).toString());
        }
        return 0;
    }
}

