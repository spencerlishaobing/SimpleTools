/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.CM;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.qk;
import java.io.Writer;
import java.util.Locale;

@Deprecated
public final class J6
extends CM {
    private final int N;
    private final int SN;

    public J6() {
        this.SN = 32;
        this.N = 127;
    }

    @Override
    public final boolean SN(int n2, Writer writer) {
        int n3 = this.SN;
        boolean bl = true;
        if (n2 >= n3 && n2 <= this.N) {
            bl = false;
        } else if (n2 > 65535) {
            char[] cArray = Character.toChars(n2);
            StringBuilder stringBuilder = oi_0.yq("\\u");
            String string = Integer.toHexString(cArray[0]);
            Locale locale = Locale.ENGLISH;
            stringBuilder.append(string.toUpperCase(locale));
            stringBuilder.append("\\u");
            stringBuilder.append(Integer.toHexString(cArray[1]).toUpperCase(locale));
            writer.write(stringBuilder.toString());
        } else {
            writer.write("\\u");
            char[] cArray = qk.yq;
            writer.write(cArray[n2 >> 12 & 0xF]);
            writer.write(cArray[n2 >> 8 & 0xF]);
            writer.write(cArray[n2 >> 4 & 0xF]);
            writer.write(cArray[n2 & 0xF]);
        }
        return bl;
    }
}

