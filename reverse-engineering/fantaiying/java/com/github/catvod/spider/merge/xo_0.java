/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.gg_0;

/*
 * Renamed from com.github.catvod.spider.merge.Xo
 */
public final class xo_0 {
    private static volatile gg_0 tF = gg_0.v3;
    private final gg_0 N;
    private final Object SN;
    private final StringBuffer yq;

    public xo_0(Object object) {
        StringBuffer stringBuffer;
        gg_0 gg_02 = tF;
        this.yq = stringBuffer = new StringBuffer(512);
        this.N = gg_02;
        this.SN = object;
        gg_02.G(stringBuffer, object);
    }

    public final xo_0 SN(String string, boolean bl) {
        this.N.SN(this.yq, string, bl);
        return this;
    }

    public final String toString() {
        Object object = this.SN;
        if (object == null) {
            this.yq.append(this.N.v());
        } else {
            this.N.Gc(this.yq, object);
        }
        return this.yq.toString();
    }

    public final xo_0 yq(Object object) {
        this.N.yq(this.yq, object);
        return this;
    }
}

