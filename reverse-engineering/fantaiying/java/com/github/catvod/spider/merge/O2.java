/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.qk;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

@Deprecated
public final class O2
extends qk {
    private final HashSet<Character> N;
    private final HashMap<String, String> SN = new HashMap();
    private final int tF;
    private final int zH;

    public O2(CharSequence[] ... charSequenceArray) {
        this.N = new HashSet();
        int n2 = charSequenceArray.length;
        int n3 = Integer.MAX_VALUE;
        int n4 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            CharSequence[] charSequenceArray2 = charSequenceArray[i2];
            this.SN.put(charSequenceArray2[0].toString(), charSequenceArray2[1].toString());
            this.N.add(Character.valueOf(charSequenceArray2[0].charAt(0)));
            int n5 = charSequenceArray2[0].length();
            int n7 = n3;
            if (n5 < n3) {
                n7 = n5;
            }
            int n8 = n4;
            if (n5 > n4) {
                n8 = n5;
            }
            n3 = n7;
            n4 = n8;
        }
        this.tF = n3;
        this.zH = n4;
    }

    @Override
    public final int yq(CharSequence charSequence, int n2, Writer writer) {
        if (this.N.contains(Character.valueOf(charSequence.charAt(n2)))) {
            int n3;
            int n4 = n3 = this.zH;
            if (n2 + n3 > charSequence.length()) {
                n4 = charSequence.length() - n2;
            }
            while (n4 >= this.tF) {
                CharSequence charSequence2 = charSequence.subSequence(n2, n2 + n4);
                if ((charSequence2 = this.SN.get(charSequence2.toString())) != null) {
                    writer.write((String)charSequence2);
                    return n4;
                }
                --n4;
            }
        }
        return 0;
    }
}

