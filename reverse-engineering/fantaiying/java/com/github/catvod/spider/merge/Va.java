/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.QZ;
import com.github.catvod.spider.merge.YW;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.il_1;
import com.github.catvod.spider.merge.k6;
import com.github.catvod.spider.merge.l4;
import com.github.catvod.spider.merge.ta_0;
import com.github.catvod.spider.merge.xv;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Objects;

public final class Va
extends hN {
    private int B = 1;
    private yq KJ = new yq();
    private xv q = new xv(new QZ());

    public Va(String string) {
        super(YW.G("#root", l4.N), string, null);
    }

    public final Va C7(xv xv2) {
        this.q = xv2;
        return this;
    }

    public final yq D() {
        return this.KJ;
    }

    public final int GL() {
        return this.B;
    }

    public final xv HE() {
        return this.q;
    }

    public final Va K() {
        Va va2 = new Va(this.zH());
        k6 k62 = this.t0;
        if (k62 != null) {
            va2.t0 = k62.KJ();
        }
        va2.KJ = this.KJ.yq();
        return va2;
    }

    public final hN OT() {
        hN hN22;
        block2: {
            for (hN hN22 : this.R()) {
                if (!hN22.nQ().equals("html")) continue;
                break block2;
            }
            hN22 = this.m("html");
        }
        for (hN hN3 : hN22.R()) {
            if (!"body".equals(hN3.nQ()) && !"frameset".equals(hN3.nQ())) continue;
            return hN3;
        }
        return hN22.m("body");
    }

    @Override
    public final hN Qz(String string) {
        this.OT().Qz(string);
        return this;
    }

    @Override
    public final String ee() {
        return this.mG();
    }

    public final Va gt() {
        this.B = 2;
        return this;
    }

    @Override
    public final String v() {
        return "#document";
    }

    public final Va z() {
        Va va2 = (Va)super.i3();
        va2.KJ = this.KJ.yq();
        return va2;
    }

    public static final class yq
    implements Cloneable {
        private int Gc = 1;
        private final ThreadLocal<CharsetEncoder> N;
        private Charset SN;
        private int i = 1;
        private int t0 = 30;
        int tF;
        private il_1.yq yq = il_1.yq.i;
        private boolean zH = true;

        public yq() {
            this.SN = ta_0.yq;
            this.N = new ThreadLocal();
        }

        public final int Gc() {
            return this.Gc;
        }

        public final il_1.yq N() {
            return this.yq;
        }

        final CharsetEncoder SN() {
            CharsetEncoder charsetEncoder = this.N.get();
            if (charsetEncoder == null) {
                charsetEncoder = this.i();
            }
            return charsetEncoder;
        }

        final CharsetEncoder i() {
            CharsetEncoder charsetEncoder = this.SN.newEncoder();
            this.N.set(charsetEncoder);
            String string = charsetEncoder.charset().name();
            int n2 = string.equals("US-ASCII") ? 1 : (string.startsWith("UTF-") ? 2 : 3);
            this.tF = n2;
            return charsetEncoder;
        }

        public final boolean t0() {
            return this.zH;
        }

        public final int tF() {
            return this.i;
        }

        public final yq yq() {
            String string;
            yq yq2;
            try {
                yq2 = (yq)super.clone();
                string = this.SN.name();
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {
                throw new RuntimeException(cloneNotSupportedException);
            }
            Objects.requireNonNull(yq2);
            yq2.SN = Charset.forName(string);
            yq2.yq = il_1.yq.valueOf(this.yq.name());
            return yq2;
        }

        public final int zH() {
            return this.t0;
        }
    }
}

