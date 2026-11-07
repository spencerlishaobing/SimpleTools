/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.q2;
import com.github.catvod.spider.merge.ta_1;
import java.nio.charset.StandardCharsets;

public abstract class BB
implements q2 {
    protected int SN;
    protected final int yq;

    BB(int n) {
        this.yq = n;
        this.SN = 0;
    }

    @Override
    public final int Gc() {
        return this.SN;
    }

    @Override
    public final void KJ() {
        int n = this.yq;
        int n2 = this.SN;
        if (n - n2 != 0) {
            this.SN = n2 + 1;
            return;
        }
        throw new IllegalStateException("cannot consume EOF");
    }

    @Override
    public final int N() {
        return -1;
    }

    @Override
    public final int size() {
        return this.yq;
    }

    public final String toString() {
        return this.tF(ta_1.SN(0, this.yq - 1));
    }

    @Override
    public final void yq() {
    }

    @Override
    public final void zH(int n) {
        this.SN = n;
    }

    private static final class N
    extends BB {
        private final byte[] N;

        N(int n, int n2, byte[] byArray) {
            super(n2);
            this.N = byArray;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public final int t0(int n) {
            n = Integer.signum(1);
            if (n != -1) {
                if (n == 0) return 0;
                if (n != 1) throw new UnsupportedOperationException("Not reached");
                n = this.SN + 1 - 1;
                if (n >= this.yq) {
                    return -1;
                }
                n = this.N[n];
                return n & 0xFF;
            } else {
                n = this.SN + 1;
                if (n < 0) {
                    return -1;
                }
                n = this.N[n];
            }
            return n & 0xFF;
        }

        @Override
        public final String tF(ta_1 ta_12) {
            int n = Math.min(ta_12.yq, this.yq);
            int n2 = Math.min(ta_12.SN - ta_12.yq + 1, this.yq - n);
            return new String(this.N, n, n2, StandardCharsets.ISO_8859_1);
        }
    }

    private static final class SN
    extends BB {
        private final int[] N;

        SN(int n, int n2, int[] nArray) {
            super(n2);
            this.N = nArray;
        }

        @Override
        public final int t0(int n) {
            n = Integer.signum(1);
            if (n != -1) {
                if (n != 0) {
                    if (n == 1) {
                        n = this.SN + 1 - 1;
                        if (n >= this.yq) {
                            return -1;
                        }
                        return this.N[n];
                    }
                    throw new UnsupportedOperationException("Not reached");
                }
                return 0;
            }
            n = this.SN + 1;
            if (n < 0) {
                return -1;
            }
            return this.N[n];
        }

        @Override
        public final String tF(ta_1 ta_12) {
            int n = Math.min(ta_12.yq, this.yq);
            int n2 = Math.min(ta_12.SN - ta_12.yq + 1, this.yq - n);
            return new String(this.N, n, n2);
        }
    }

    private static final class yq
    extends BB {
        private final char[] N;

        yq(int n, int n2, char[] cArray) {
            super(n2);
            this.N = cArray;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public final int t0(int n) {
            n = Integer.signum(1);
            if (n != -1) {
                if (n == 0) return 0;
                if (n != 1) throw new UnsupportedOperationException("Not reached");
                n = this.SN + 1 - 1;
                if (n >= this.yq) {
                    return -1;
                }
                n = this.N[n];
                return n & 0xFFFF;
            } else {
                n = this.SN + 1;
                if (n < 0) {
                    return -1;
                }
                n = this.N[n];
            }
            return n & 0xFFFF;
        }

        @Override
        public final String tF(ta_1 ta_12) {
            int n = Math.min(ta_12.yq, this.yq);
            int n2 = Math.min(ta_12.SN - ta_12.yq + 1, this.yq - n);
            return new String(this.N, n, n2);
        }
    }
}

