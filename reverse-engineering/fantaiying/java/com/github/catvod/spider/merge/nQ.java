/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Kt;
import com.github.catvod.spider.merge.N;
import com.github.catvod.spider.merge.bA;
import com.github.catvod.spider.merge.o;
import java.util.List;

public abstract class nQ
extends o {
    private Kt B;
    private boolean F5;
    private N G;
    private boolean G4;
    private String Gc;
    private int KJ = 1;
    private boolean M;
    private long N;
    private int SN;
    private List<bA> dT;
    private long i = 0L;
    private boolean q;
    private int t0;
    private long tF = 0L;
    private byte[] yq;
    private long zH = 0L;

    public final void C(int n) {
        this.SN = n;
    }

    public final void Cu(Kt kt) {
        this.B = kt;
    }

    public final N Dr() {
        return this.G;
    }

    public final List<bA> E1() {
        return this.dT;
    }

    public final int Fz() {
        return this.KJ;
    }

    public final int H() {
        return this.SN;
    }

    public final void Hj(int n) {
        this.KJ = n;
    }

    public final boolean J() {
        return this.G4;
    }

    public final void L(long l) {
        this.i = l;
    }

    public final void LY(boolean bl) {
        this.G4 = bl;
    }

    public final boolean N0() {
        return this.F5;
    }

    public final void Q4(long l) {
        this.tF = l;
    }

    public final boolean R() {
        return this.M;
    }

    public final long RQ() {
        return this.N;
    }

    public final long U() {
        return this.tF;
    }

    public final Kt V() {
        return this.B;
    }

    public final void XO(List<bA> list) {
        this.dT = list;
    }

    public final long Z() {
        return this.i;
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof nQ)) {
            return false;
        }
        return this.Gc.equals(((nQ)object).Gc);
    }

    public final long g() {
        return this.zH;
    }

    public final void i3(N n) {
        this.G = n;
    }

    public final void j(int n) {
        this.t0 = n;
    }

    public final byte[] k() {
        return this.yq;
    }

    public final void kR(long l) {
        this.N = l;
    }

    public final void lF(long l) {
        this.zH = l;
    }

    public final String m() {
        return this.Gc;
    }

    public final void mG(boolean bl) {
        this.M = bl;
    }

    public final void nQ(byte[] byArray) {
        this.yq = byArray;
    }

    public final void o(String string) {
        this.Gc = string;
    }

    public final void p(boolean bl) {
        this.q = bl;
    }

    public final int tO() {
        return this.t0;
    }

    public final void w(boolean bl) {
        this.F5 = bl;
    }

    public final boolean xU() {
        return this.q;
    }
}

