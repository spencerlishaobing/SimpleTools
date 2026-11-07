/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Y4;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.wu_0;

abstract class zF
extends Y4 {
    Y4 yq;

    zF() {
    }

    static final class N
    extends zF {
        public N(Y4 y42) {
            this.yq = y42;
        }

        public final String toString() {
            return String.format("%s + ", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            boolean bl = false;
            if (hN2 == hN3) {
                return false;
            }
            hN3 = hN3.u7();
            boolean bl2 = bl;
            if (hN3 != null) {
                bl2 = bl;
                if (this.yq.yq(hN2, hN3)) {
                    bl2 = true;
                }
            }
            return bl2;
        }
    }

    static final class SN
    extends zF {
        public SN(Y4 y42) {
            this.yq = y42;
        }

        public final String toString() {
            return String.format("%s > ", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            boolean bl = false;
            if (hN2 == hN3) {
                return false;
            }
            hN3 = hN3.L();
            boolean bl2 = bl;
            if (hN3 != null) {
                bl2 = bl;
                if (this.yq.yq(hN2, hN3)) {
                    bl2 = true;
                }
            }
            return bl2;
        }
    }

    static final class i
    extends zF {
        public i(Y4 y42) {
            this.yq = y42;
        }

        public final String toString() {
            return String.format("%s ~ ", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            hN hN4 = hN3;
            if (hN2 == hN3) {
                return false;
            }
            while ((hN3 = hN4.u7()) != null) {
                hN4 = hN3;
                if (!this.yq.yq(hN2, hN3)) continue;
                return true;
            }
            return false;
        }
    }

    static final class t0
    extends Y4 {
        t0() {
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            boolean bl = hN2 == hN3;
            return bl;
        }
    }

    static final class tF
    extends zF {
        public tF(Y4 y42) {
            this.yq = y42;
        }

        public final String toString() {
            return String.format(":not(%s)", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            return this.yq.yq(hN2, hN3) ^ true;
        }
    }

    static final class yq
    extends zF {
        final wu_0.SN SN;

        public yq(Y4 y42) {
            this.yq = y42;
            this.SN = new wu_0.SN(y42);
        }

        public final String toString() {
            return String.format(":has(%s)", this.yq);
        }

        @Override
        public final boolean yq(hN iK2, hN hN2) {
            for (int i2 = 0; i2 < hN2.t0(); ++i2) {
                iK2 = hN2.i(i2);
                if (!(iK2 instanceof hN) || this.SN.yq(hN2, (hN)iK2) == null) continue;
                return true;
            }
            return false;
        }
    }

    static final class zH
    extends zF {
        public zH(Y4 y42) {
            this.yq = y42;
        }

        public final String toString() {
            return String.format("%s ", this.yq);
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            hN hN4 = hN3;
            if (hN2 == hN3) {
                return false;
            }
            while ((hN3 = hN4.L()) != null) {
                if (this.yq.yq(hN2, hN3)) {
                    return true;
                }
                hN4 = hN3;
                if (hN3 != hN2) continue;
            }
            return false;
        }
    }
}

