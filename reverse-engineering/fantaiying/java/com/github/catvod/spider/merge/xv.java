/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Js;
import com.github.catvod.spider.merge.QZ;
import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.jt;
import com.github.catvod.spider.merge.l4;
import com.github.catvod.spider.merge.x1;
import com.github.catvod.spider.merge.xc;
import java.io.StringReader;

public final class xv {
    private l4 N;
    private Js SN;
    private jt yq;

    public xv(jt jt2) {
        this.yq = jt2;
        this.N = l4.N;
        this.SN = new Js();
    }

    public static Va tF(String object) {
        QZ qZ = new QZ();
        qZ.N(new StringReader((String)object), new xv(qZ));
        x1 x12 = qZ.N;
        do {
            object = x12.g9();
            qZ.zH((xc)object);
            ((xc)object).Gc();
        } while (((xc)object).yq != 6);
        qZ.SN.tF();
        qZ.SN = null;
        qZ.N = null;
        qZ.zH = null;
        qZ.M = null;
        return qZ.tF;
    }

    public final boolean N() {
        boolean bl = this.SN.SN() > 0;
        return bl;
    }

    public final boolean SN(String string) {
        return this.yq.tF(string);
    }

    public final Js yq() {
        return this.SN;
    }

    public final l4 zH() {
        return this.N;
    }
}

