/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Ng;
import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.kt_0;
import java.io.IOException;

public final class oJ
extends Ng {
    public oJ(String string) {
        super(string);
    }

    @Override
    final void Gd(Appendable appendable, int n2, Va.yq yq2) {
        try {
            appendable.append("]]>");
            return;
        }
        catch (IOException iOException) {
            throw new kt_0(iOException);
        }
    }

    public final oJ k() {
        return (oJ)super.Fz();
    }

    @Override
    public final String v() {
        return "#cdata";
    }

    @Override
    final void xa(Appendable appendable, int n2, Va.yq yq2) {
        appendable.append("<![CDATA[").append(this.H());
    }
}

