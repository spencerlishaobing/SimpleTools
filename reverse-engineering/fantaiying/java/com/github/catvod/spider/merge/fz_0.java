/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Gx;
import com.github.catvod.spider.merge.I9;
import com.github.catvod.spider.merge.pD;
import com.github.catvod.spider.merge.vt;
import java.io.File;
import java.util.ArrayList;

/*
 * Renamed from com.github.catvod.spider.merge.fZ
 */
public final class fz_0
implements Cloneable {
    private I9 N;
    private vt SN;
    private File i;
    private boolean t0;
    private pD tF;
    private Gx yq;
    private boolean zH;

    public fz_0() {
        new ArrayList();
        new ArrayList();
        this.yq = new Gx();
        this.SN = new vt();
        this.N = new I9();
        this.tF = new pD();
        this.t0 = false;
    }

    public final void B(pD pD2) {
        this.tF = pD2;
    }

    public final void G(boolean bl) {
        this.t0 = bl;
    }

    public final void G4(File file) {
        this.i = file;
    }

    public final void Gc(Gx gx) {
        this.yq = gx;
    }

    public final void KJ(boolean bl) {
        this.zH = bl;
    }

    public final void M(vt vt2) {
        this.SN = vt2;
    }

    public final I9 N() {
        return this.N;
    }

    public final vt SN() {
        return this.SN;
    }

    public final Object clone() {
        return super.clone();
    }

    public final boolean i() {
        return this.zH;
    }

    public final void q(I9 i9) {
        this.N = i9;
    }

    public final boolean t0() {
        return this.t0;
    }

    public final pD tF() {
        return this.tF;
    }

    public final Gx yq() {
        return this.yq;
    }

    public final File zH() {
        return this.i;
    }
}

