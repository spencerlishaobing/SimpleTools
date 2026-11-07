/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.vR;

/*
 * Renamed from com.github.catvod.spider.merge.vD
 */
public final class vd_1
extends vR {
    static {
        new vd_1(1, 0);
    }

    public vd_1(int n2, int n3) {
        super(n2, n3, 1);
    }

    public final boolean equals(Object object) {
        int n2;
        boolean bl = object instanceof vd_1 && (this.isEmpty() && ((vd_1)object).isEmpty() || (n2 = this.yq()) == ((vR)(object = (vd_1)object)).yq() && this.SN() == ((vR)object).SN());
        return bl;
    }

    public final int hashCode() {
        int n2 = this.isEmpty() ? -1 : this.yq() * 31 + this.SN();
        return n2;
    }

    public final boolean isEmpty() {
        boolean bl = this.yq() > this.SN();
        return bl;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.yq());
        stringBuilder.append("..");
        stringBuilder.append(this.SN());
        return stringBuilder.toString();
    }
}

