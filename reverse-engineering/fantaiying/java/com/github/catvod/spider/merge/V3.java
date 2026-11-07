/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.qk;
import java.io.Writer;

@Deprecated
public final class V3
extends qk {
    private boolean SN(char c) {
        boolean bl = c >= '0' && c <= '7';
        return bl;
    }

    @Override
    public final int yq(CharSequence charSequence, int n2, Writer writer) {
        int n3;
        int n4 = charSequence.length() - n2 - 1;
        StringBuilder stringBuilder = new StringBuilder();
        int n5 = charSequence.charAt(n2);
        int n7 = 0;
        if (n5 == 92 && n4 > 0 && this.SN(charSequence.charAt(n3 = n2 + 1))) {
            int n8 = n2 + 2;
            n5 = n2 + 3;
            stringBuilder.append(charSequence.charAt(n3));
            if (n4 > 1 && this.SN(charSequence.charAt(n8))) {
                stringBuilder.append(charSequence.charAt(n8));
                if (n4 > 2) {
                    n4 = charSequence.charAt(n3);
                    n2 = n7;
                    if (n4 >= 48) {
                        n2 = n7;
                        if (n4 <= 51) {
                            n2 = 1;
                        }
                    }
                    if (n2 != 0 && this.SN(charSequence.charAt(n5))) {
                        stringBuilder.append(charSequence.charAt(n5));
                    }
                }
            }
            writer.write(Integer.parseInt(stringBuilder.toString(), 8));
            return stringBuilder.length() + 1;
        }
        return 0;
    }
}

