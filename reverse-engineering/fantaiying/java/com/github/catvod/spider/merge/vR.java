/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.cm_0;
import java.util.Iterator;

public class vR
implements Iterable<Integer> {
    private final int N;
    private final int SN;
    private final int yq;

    public vR(int n2, int n3, int n4) {
        block12: {
            block13: {
                block16: {
                    block15: {
                        block14: {
                            if (n4 == 0) break block12;
                            if (n4 == Integer.MIN_VALUE) break block13;
                            this.yq = n2;
                            if (n4 <= 0) break block14;
                            if (n2 < n3) {
                                int n5 = n3 % n4;
                                if (n5 < 0) {
                                    n5 += n4;
                                }
                                if ((n2 %= n4) < 0) {
                                    n2 += n4;
                                }
                                n2 = (n5 - n2) % n4;
                                if (n2 < 0) {
                                    n2 += n4;
                                }
                                n3 -= n2;
                            }
                            break block15;
                        }
                        if (n4 >= 0) break block16;
                        if (n2 > n3) {
                            int n7 = -n4;
                            if ((n2 %= n7) < 0) {
                                n2 += n7;
                            }
                            int n8 = n3 % n7;
                            if (n8 < 0) {
                                n8 += n7;
                            }
                            n2 = (n2 - n8) % n7;
                            if (n2 < 0) {
                                n2 += n7;
                            }
                            n3 += n2;
                        }
                    }
                    this.SN = n3;
                    this.N = n4;
                    return;
                }
                throw new IllegalArgumentException("Step is zero.");
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public final int N() {
        return this.N;
    }

    public final int SN() {
        return this.SN;
    }

    @Override
    public final Iterator iterator() {
        return new cm_0(this.yq, this.SN, this.N);
    }

    public final int yq() {
        return this.yq;
    }
}

