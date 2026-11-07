/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

/*
 * Renamed from com.github.catvod.spider.merge.ta
 */
public final class ta_1 {
    static ta_1[] N = new ta_1[1001];
    public int SN;
    public int yq;

    public ta_1(int n2, int n3) {
        this.yq = n2;
        this.SN = n3;
    }

    public static ta_1 SN(int n2, int n3) {
        if (n2 == n3 && n2 >= 0 && n2 <= 1000) {
            ta_1[] ta_1Array = N;
            if (ta_1Array[n2] == null) {
                ta_1Array[n2] = new ta_1(n2, n2);
            }
            return ta_1Array[n2];
        }
        return new ta_1(n2, n3);
    }

    public final ta_1 N(ta_1 ta_12) {
        return ta_1.SN(Math.min(this.yq, ta_12.yq), Math.max(this.SN, ta_12.SN));
    }

    public final boolean equals(Object object) {
        boolean bl;
        boolean bl2 = bl = false;
        if (object != null) {
            if (!(object instanceof ta_1)) {
                bl2 = bl;
            } else {
                object = (ta_1)object;
                bl2 = bl;
                if (this.yq == ((ta_1)object).yq) {
                    bl2 = bl;
                    if (this.SN == ((ta_1)object).SN) {
                        bl2 = true;
                    }
                }
            }
        }
        return bl2;
    }

    public final int hashCode() {
        return (713 + this.yq) * 31 + this.SN;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.yq);
        stringBuilder.append("..");
        stringBuilder.append(this.SN);
        return stringBuilder.toString();
    }

    public final boolean yq(ta_1 ta_12) {
        int n2 = this.yq;
        int n3 = ta_12.yq;
        boolean bl = false;
        if ((n3 = n2 < n3 && this.SN < n3 ? 1 : 0) != 0 || (n3 = n2 > ta_12.SN ? 1 : 0) != 0) {
            bl = true;
        }
        return bl;
    }
}

