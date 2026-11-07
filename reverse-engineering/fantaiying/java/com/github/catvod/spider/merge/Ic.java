/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.DO;
import com.github.catvod.spider.merge.QL;
import com.github.catvod.spider.merge.lR;

public class Ic
implements QL {
    public DO yq;

    public Ic(DO dO) {
        this.yq = dO;
    }

    @Override
    public final DO SN() {
        return this.yq;
    }

    @Override
    public final String getText() {
        return this.yq.getText();
    }

    public final String toString() {
        if (this.yq.getType() == -1) {
            return "<EOF>";
        }
        return this.yq.getText();
    }

    @Override
    public <T> T yq(lR<? extends T> lR2) {
        lR2.M();
        return null;
    }
}

