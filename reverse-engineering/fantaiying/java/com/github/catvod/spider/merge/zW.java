/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Bd;
import com.github.catvod.spider.merge.fU;
import com.github.catvod.spider.merge.q2;
import com.github.catvod.spider.merge.ta_1;
import java.util.Locale;

public final class zW
extends fU {
    private final int i;

    public zW(Bd bd, q2 q22, int n2) {
        super(bd, q22, null);
        this.i = n2;
    }

    @Override
    public final String toString() {
        Object object;
        block8: {
            block3: {
                int n2 = this.i;
                if (n2 < 0 || n2 >= ((q2)this.SN()).size()) break block3;
                object = (q2)this.SN();
                n2 = this.i;
                object = object.tF(ta_1.SN(n2, n2));
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : ((String)object).toCharArray()) {
                    block7: {
                        block5: {
                            block6: {
                                block4: {
                                    if (c != '\t') break block4;
                                    object = "\\t";
                                    break block5;
                                }
                                if (c != '\n') break block6;
                                object = "\\n";
                                break block5;
                            }
                            if (c != '\r') break block7;
                            object = "\\r";
                        }
                        stringBuilder.append((String)object);
                        continue;
                    }
                    stringBuilder.append(c);
                }
                object = stringBuilder.toString();
                break block8;
            }
            object = "";
        }
        return String.format(Locale.getDefault(), "%s('%s')", zW.class.getSimpleName(), object);
    }
}

