/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Ei;

/*
 * Renamed from com.github.catvod.spider.merge.cR
 */
final class cr_0 {
    private final int[] SN;
    private final Ei yq;

    cr_0(Ei object, int[] nArray) {
        if (nArray.length != 0) {
            this.yq = object;
            int n2 = nArray.length;
            if (n2 > 1 && nArray[0] == 0) {
                int n3;
                for (n3 = 1; n3 < n2 && nArray[n3] == 0; ++n3) {
                }
                if (n3 == n2) {
                    this.SN = new int[]{0};
                    return;
                }
                object = new int[n2 -= n3];
                this.SN = (int[])object;
                System.arraycopy(nArray, n3, object, 0, n2);
                return;
            }
            this.SN = nArray;
            return;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    final int N(int n2) {
        int[] nArray = this.SN;
        return nArray[nArray.length - 1 - n2];
    }

    final cr_0[] SN(cr_0 object) {
        if (this.yq.equals(((cr_0)object).yq)) {
            if (!((cr_0)object).zH()) {
                cr_0 cr_02 = this.yq.tF();
                int n2 = ((cr_0)object).N(((cr_0)object).SN.length - 1);
                int n3 = this.yq.zH(n2);
                cr_0 cr_03 = this;
                while (cr_03.SN.length - 1 >= ((cr_0)object).SN.length - 1 && !cr_03.zH()) {
                    Object object2 = cr_03.SN;
                    int n4 = ((int[])object2).length - 1 - (((cr_0)object).SN.length - 1);
                    n2 = this.yq.t0(cr_03.N(((int[])object2).length - 1), n3);
                    object2 = ((cr_0)object).t0(n4, n2);
                    cr_02 = cr_02.yq(this.yq.yq(n4, n2));
                    cr_03 = cr_03.yq((cr_0)object2);
                }
                return new cr_0[]{cr_02, cr_03};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        object = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        throw object;
    }

    final cr_0 i(cr_0 object) {
        if (this.yq.equals(((cr_0)object).yq)) {
            if (!this.zH() && !((cr_0)object).zH()) {
                int[] nArray = this.SN;
                int n2 = nArray.length;
                object = ((cr_0)object).SN;
                int n3 = ((Object)object).length;
                int[] nArray2 = new int[n2 + n3 - 1];
                for (int i2 = 0; i2 < n2; ++i2) {
                    int n4 = nArray[i2];
                    for (int i4 = 0; i4 < n3; ++i4) {
                        int n5 = i2 + i4;
                        nArray2[n5] = nArray2[n5] ^ this.yq.t0(n4, (int)object[i4]);
                    }
                }
                return new cr_0(this.yq, nArray2);
            }
            return this.yq.tF();
        }
        object = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        throw object;
    }

    final cr_0 t0(int n2, int n3) {
        if (n2 >= 0) {
            if (n3 == 0) {
                return this.yq.tF();
            }
            int n4 = this.SN.length;
            int[] nArray = new int[n2 + n4];
            for (n2 = 0; n2 < n4; ++n2) {
                nArray[n2] = this.yq.t0(this.SN[n2], n3);
            }
            return new cr_0(this.yq, nArray);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    final int[] tF() {
        return this.SN;
    }

    /*
     * Unable to fully structure code
     */
    public final String toString() {
        var5_1 = new StringBuilder((this.SN.length - 1) * 8);
        var2_2 = this.SN.length;
        ** GOTO lbl44
        while (var3_4 >= 0) {
            var4_5 = this.N(var3_4);
            var2_2 = var3_4;
            if (var4_5 != 0) {
                if (var4_5 < 0) {
                    var5_1.append(" - ");
                    var2_2 = -var4_5;
                } else {
                    var2_2 = var4_5;
                    if (var5_1.length() > 0) {
                        var5_1.append(" + ");
                        var2_2 = var4_5;
                    }
                }
                if (var3_4 == 0 || var2_2 != 1) {
                    if ((var2_2 = this.yq.i(var2_2)) == 0) {
                        var1_3 = 49;
lbl21:
                        // 2 sources

                        while (true) {
                            var5_1.append((char)var1_3);
                            break;
                        }
                    } else {
                        if (var2_2 == 1) {
                            var1_3 = 97;
                            ** continue;
                        }
                        var5_1.append("a^");
                        var5_1.append(var2_2);
                    }
                }
                var2_2 = var3_4;
                if (var3_4 != 0) {
                    if (var3_4 == 1) {
                        var5_1.append('x');
                        var2_2 = var3_4;
                    } else {
                        var5_1.append("x^");
                        var5_1.append(var3_4);
                        var2_2 = var3_4;
                    }
                }
            }
lbl44:
            // 7 sources

            var3_4 = var2_2 - 1;
        }
        return var5_1.toString();
    }

    final cr_0 yq(cr_0 object) {
        if (this.yq.equals(((cr_0)object).yq)) {
            Object object2;
            if (this.zH()) {
                return object;
            }
            if (((cr_0)object).zH()) {
                return this;
            }
            int[] nArray = this.SN;
            object = ((cr_0)object).SN;
            if (nArray.length > ((Object)object).length) {
                object2 = nArray;
            } else {
                object2 = object;
                object = nArray;
            }
            nArray = new int[((int[])object2).length];
            int n2 = ((int[])object2).length - ((Object)object).length;
            System.arraycopy(object2, 0, nArray, 0, n2);
            for (int i2 = n2; i2 < ((int[])object2).length; ++i2) {
                nArray[i2] = object[i2 - n2] ^ object2[i2];
            }
            return new cr_0(this.yq, nArray);
        }
        object = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        throw object;
    }

    final boolean zH() {
        return this.SN[0] == 0;
    }
}

