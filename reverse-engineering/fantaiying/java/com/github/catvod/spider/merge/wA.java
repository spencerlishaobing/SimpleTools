/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.nS;
import com.github.catvod.spider.merge.oi_0;
import java.util.Objects;

public final class wA {
    private String SN;
    private String yq;

    wA(nS nS2, String string) {
        Objects.requireNonNull(nS2);
        this.yq = nS2.xa();
        this.SN = string;
    }

    wA(nS nS2, String string, Object ... objectArray) {
        Objects.requireNonNull(nS2);
        this.yq = nS2.xa();
        this.SN = String.format(string, objectArray);
    }

    public final String toString() {
        StringBuilder stringBuilder = oi_0.yq("<");
        stringBuilder.append(this.yq);
        stringBuilder.append(">: ");
        stringBuilder.append(this.SN);
        return stringBuilder.toString();
    }
}

