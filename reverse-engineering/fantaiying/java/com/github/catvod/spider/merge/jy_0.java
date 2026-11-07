/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Bd;
import com.github.catvod.spider.merge.Uz;
import com.github.catvod.spider.merge.Wh;
import com.github.catvod.spider.merge.q2;
import com.github.catvod.spider.merge.wg;
import java.util.Arrays;

/*
 * Renamed from com.github.catvod.spider.merge.Jy
 */
public final class jy_0 {
    private final int SN;
    private final Uz[] yq;

    public jy_0(Uz[] uzArray) {
        this.yq = uzArray;
        int n2 = uzArray.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 = wg.i(n3, uzArray[i2]);
        }
        this.SN = wg.SN(n3, uzArray.length);
    }

    public static jy_0 yq(jy_0 uzArray, Uz uz) {
        if (uzArray == null) {
            return new jy_0(new Uz[]{uz});
        }
        uzArray = uzArray.yq;
        uzArray = Arrays.copyOf(uzArray, uzArray.length + 1);
        uzArray[uzArray.length - 1] = uz;
        return new jy_0(uzArray);
    }

    public final jy_0 N(int n2) {
        Uz[] uzArray;
        Uz[] uzArray2 = null;
        for (int i2 = 0; i2 < (uzArray = this.yq).length; ++i2) {
            Uz[] uzArray3 = uzArray2;
            if (uzArray[i2].yq()) {
                uzArray = this.yq;
                uzArray3 = uzArray2;
                if (!(uzArray[i2] instanceof Wh)) {
                    uzArray3 = uzArray2;
                    if (uzArray2 == null) {
                        uzArray3 = (Uz[])uzArray.clone();
                    }
                    uzArray3[i2] = new Wh(n2, this.yq[i2]);
                }
            }
            uzArray2 = uzArray3;
        }
        if (uzArray2 == null) {
            return this;
        }
        return new jy_0(uzArray2);
    }

    /*
     * WARNING - void declaration
     */
    public final void SN(Bd bd, q2 q22, int n2) {
        void var1_4;
        block16: {
            int n3;
            block15: {
                int n4;
                int n5;
                Uz[] uzArray;
                n3 = q22.Gc();
                int n7 = 0;
                try {
                    uzArray = this.yq;
                    n5 = uzArray.length;
                    n4 = 0;
                }
                catch (Throwable throwable) {
                    n2 = n7;
                }
                for (int i2 = 0; i2 < n5; ++i2) {
                    Uz uz;
                    int n8;
                    block14: {
                        block13: {
                            Uz uz2;
                            block12: {
                                uz2 = uzArray[i2];
                                n8 = n4;
                                try {
                                    if (!(uz2 instanceof Wh)) break block12;
                                    n8 = n4;
                                }
                                catch (Throwable throwable) {
                                    n2 = n8;
                                    break block15;
                                }
                                n7 = ((Wh)uz2).tF() + n2;
                                n8 = n4;
                                q22.zH(n7);
                                n8 = n4;
                                uz = uz2 = ((Wh)uz2).N();
                                if (n7 == n3) break block13;
                                n7 = 1;
                                uz = uz2;
                                break block14;
                            }
                            n7 = n4;
                            uz = uz2;
                            n8 = n4;
                            if (!uz2.yq()) break block14;
                            n8 = n4;
                            q22.zH(n3);
                            uz = uz2;
                        }
                        n7 = 0;
                    }
                    n8 = n7;
                    uz.SN(bd);
                    n4 = n7;
                    continue;
                }
                if (n4 != 0) {
                    q22.zH(n3);
                }
                return;
            }
            if (n2 == 0) break block16;
            q22.zH(n3);
        }
        throw var1_4;
    }

    public final boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof jy_0)) {
            return false;
        }
        object = (jy_0)object;
        if (this.SN != ((jy_0)object).SN || !Arrays.equals(this.yq, ((jy_0)object).yq)) {
            bl = false;
        }
        return bl;
    }

    public final int hashCode() {
        return this.SN;
    }
}

