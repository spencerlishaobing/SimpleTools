/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.spider.merge.WU$yq
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.IV;
import com.github.catvod.spider.merge.WU;
import com.github.catvod.spider.merge.Y4;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.rs_0;

/*
 * Renamed from com.github.catvod.spider.merge.WU
 */
public final class wu_0 {
    public static kb_0 yq(Y4 y42, hN hN2) {
        kb_0 kb_02 = new kb_0();
        rs_0.v((IV)new WU.yq(hN2, kb_02, y42), hN2);
        return kb_02;
    }

    static final class SN {
        private final Y4 N;
        private hN SN = null;
        private hN yq = null;

        SN(Y4 y42) {
            this.N = y42;
        }

        public final int SN(iK iK2) {
            if (iK2 instanceof hN && this.N.yq(this.yq, (hN)(iK2 = (hN)iK2))) {
                this.SN = iK2;
                return 5;
            }
            return 1;
        }

        final hN yq(hN iK2, hN hN2) {
            int n2;
            this.yq = iK2;
            this.SN = null;
            iK2 = hN2;
            int n3 = 0;
            while (iK2 != null && (n2 = this.SN(iK2)) != 5) {
                int n4 = 1;
                hN hN3 = iK2;
                int n5 = n3;
                int n7 = n2;
                if (n2 == 1) {
                    hN3 = iK2;
                    n5 = n3++;
                    n7 = n2;
                    if (((iK)iK2).t0() > 0) {
                        iK2 = iK2.i(0);
                        continue;
                    }
                }
                while (hN3.W() == null && n5 > 0) {
                    block11: {
                        block10: {
                            if (n7 == 1) break block10;
                            n3 = n7;
                            if (n7 != 2) break block11;
                        }
                        n3 = 1;
                    }
                    iK2 = hN3.O();
                    --n5;
                    if (n3 == 4) {
                        hN3.s();
                    }
                    hN3 = iK2;
                    n7 = 1;
                }
                n3 = n4;
                if (n7 != 1) {
                    n3 = n7 == 2 ? n4 : n7;
                }
                if (hN3 == hN2) break;
                iK2 = hN3.W();
                if (n3 == 4) {
                    hN3.s();
                }
                n3 = n5;
            }
            return this.SN;
        }
    }
}

