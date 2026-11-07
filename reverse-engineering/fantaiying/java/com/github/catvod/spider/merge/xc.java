/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.k6;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.l4;
import com.github.catvod.spider.merge.oi_0;

abstract class xc {
    private int N = -1;
    private int SN;
    int yq;

    xc() {
    }

    static void M(StringBuilder stringBuilder) {
        if (stringBuilder != null) {
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    xc Gc() {
        this.SN = -1;
        this.N = -1;
        return this;
    }

    final void KJ(int n2) {
        this.SN = n2;
    }

    final boolean N() {
        boolean bl = this.yq == 4;
        return bl;
    }

    final boolean SN() {
        boolean bl = this.yq == 5;
        return bl;
    }

    final boolean i() {
        boolean bl = this.yq == 3;
        return bl;
    }

    final boolean t0() {
        boolean bl = this.yq == 2;
        return bl;
    }

    final boolean tF() {
        int n2 = this.yq;
        boolean bl = true;
        if (n2 != 1) {
            bl = false;
        }
        return bl;
    }

    final void yq(int n2) {
        this.N = n2;
    }

    final boolean zH() {
        boolean bl = this.yq == 6;
        return bl;
    }

    static abstract class Gc
    extends xc {
        private boolean B = false;
        boolean G = false;
        k6 G4;
        private boolean Gc = false;
        private String KJ;
        private final StringBuilder M;
        private final StringBuilder i = new StringBuilder();
        private boolean q = false;
        private String t0;
        protected String tF;
        protected String zH;

        Gc() {
            this.M = new StringBuilder();
        }

        private void W() {
            this.q = true;
            String string = this.KJ;
            if (string != null) {
                this.M.append(string);
                this.KJ = null;
            }
        }

        final void B(String string) {
            String string2 = string.replace('\u0000', '\ufffd');
            this.Gc = true;
            string = this.t0;
            if (string != null) {
                this.i.append(string);
                this.t0 = null;
            }
            if (this.i.length() == 0) {
                this.t0 = string2;
            } else {
                this.i.append(string2);
            }
        }

        final void F5(char c) {
            this.v3(String.valueOf(c));
        }

        final void G(char c) {
            this.W();
            this.M.append(c);
        }

        final void G4(String string) {
            this.W();
            if (this.M.length() == 0) {
                this.KJ = string;
            } else {
                this.M.append(string);
            }
        }

        final String Gd() {
            String string = this.tF;
            boolean bl = string == null || string.length() == 0;
            co_0.N(bl);
            return this.tF;
        }

        final void Nl() {
            String string;
            String string2;
            if (this.G4 == null) {
                this.G4 = new k6();
            }
            if (this.Gc && this.G4.size() < 512 && (string2 = (string = this.i.length() > 0 ? this.i.toString() : this.t0).trim()).length() > 0) {
                string = this.q ? (this.M.length() > 0 ? this.M.toString() : this.KJ) : (this.B ? "" : null);
                this.G4.tF(string2, string);
            }
            xc.M(this.i);
            this.t0 = null;
            this.Gc = false;
            xc.M(this.M);
            this.KJ = null;
            this.q = false;
            this.B = false;
        }

        final void O() {
            this.B = true;
        }

        Gc OW() {
            super.Gc();
            this.tF = null;
            this.zH = null;
            xc.M(this.i);
            this.t0 = null;
            this.Gc = false;
            xc.M(this.M);
            this.KJ = null;
            this.B = false;
            this.q = false;
            this.G = false;
            this.G4 = null;
            return this;
        }

        final void dT(int[] nArray) {
            this.W();
            for (int n2 : nArray) {
                this.M.appendCodePoint(n2);
            }
        }

        final boolean ee(String string) {
            k6 k62 = this.G4;
            boolean bl = k62 != null && k62.G4(string);
            return bl;
        }

        final String g1() {
            String string = this.tF;
            if (string == null) {
                string = "[unset]";
            }
            return string;
        }

        final boolean g9() {
            boolean bl = this.G4 != null;
            return bl;
        }

        final void q(char c) {
            this.Gc = true;
            String string = this.t0;
            if (string != null) {
                this.i.append(string);
                this.t0 = null;
            }
            this.i.append(c);
        }

        final void v() {
            if (this.Gc) {
                this.Nl();
            }
        }

        final void v3(String string) {
            string = string.replace('\u0000', '\ufffd');
            String string2 = this.tF;
            if (string2 != null) {
                string = string2.concat(string);
            }
            this.tF = string;
            this.zH = l4.yq(string);
        }

        final Gc xa(String string) {
            this.tF = string;
            this.zH = l4.yq(string);
            return this;
        }
    }

    static final class N
    extends xc {
        private final StringBuilder tF = new StringBuilder();
        private String zH;

        N() {
            this.yq = 4;
        }

        final N B(String string) {
            String string2 = this.zH;
            if (string2 != null) {
                this.tF.append(string2);
                this.zH = null;
            }
            if (this.tF.length() == 0) {
                this.zH = string;
            } else {
                this.tF.append(string);
            }
            return this;
        }

        final String G() {
            String string = this.zH;
            if (string == null) {
                string = this.tF.toString();
            }
            return string;
        }

        @Override
        final xc Gc() {
            super.Gc();
            xc.M(this.tF);
            this.zH = null;
            return this;
        }

        final N q(char c) {
            String string = this.zH;
            if (string != null) {
                this.tF.append(string);
                this.zH = null;
            }
            this.tF.append(c);
            return this;
        }

        public final String toString() {
            StringBuilder stringBuilder = oi_0.yq("<!--");
            String string = this.zH;
            if (string == null) {
                string = this.tF.toString();
            }
            return k_0.i(stringBuilder, string, "-->");
        }
    }

    static class SN
    extends xc {
        private String tF;

        SN() {
            this.yq = 5;
        }

        final String B() {
            return this.tF;
        }

        @Override
        final xc Gc() {
            super.Gc();
            this.tF = null;
            return this;
        }

        final SN q(String string) {
            this.tF = string;
            return this;
        }

        public String toString() {
            return this.tF;
        }
    }

    static final class i
    extends Gc {
        i() {
            this.yq = 3;
        }

        public final String toString() {
            return k_0.i(oi_0.yq("</"), this.g1(), ">");
        }
    }

    static final class t0
    extends Gc {
        t0() {
            this.yq = 2;
        }

        @Override
        final Gc OW() {
            super.OW();
            this.G4 = null;
            return this;
        }

        public final String toString() {
            String string;
            StringBuilder stringBuilder;
            if (this.g9() && this.G4.size() > 0) {
                stringBuilder = oi_0.yq("<");
                stringBuilder.append(this.g1());
                stringBuilder.append(" ");
                string = this.G4.toString();
            } else {
                stringBuilder = oi_0.yq("<");
                string = this.g1();
            }
            return k_0.i(stringBuilder, string, ">");
        }
    }

    static final class tF
    extends xc {
        boolean Gc = false;
        final StringBuilder i;
        final StringBuilder t0;
        final StringBuilder tF = new StringBuilder();
        String zH = null;

        tF() {
            this.i = new StringBuilder();
            this.t0 = new StringBuilder();
            this.yq = 1;
        }

        @Override
        final xc Gc() {
            super.Gc();
            xc.M(this.tF);
            this.zH = null;
            xc.M(this.i);
            xc.M(this.t0);
            this.Gc = false;
            return this;
        }

        public final String toString() {
            StringBuilder stringBuilder = oi_0.yq("<!doctype ");
            stringBuilder.append(this.tF.toString());
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    static final class yq
    extends SN {
        yq(String string) {
            this.q(string);
        }

        @Override
        public final String toString() {
            return k_0.i(oi_0.yq("<![CDATA["), this.B(), "]]>");
        }
    }

    static final class zH
    extends xc {
        zH() {
            this.yq = 6;
        }

        @Override
        final xc Gc() {
            super.Gc();
            return this;
        }

        public final String toString() {
            return "";
        }
    }
}

