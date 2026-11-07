/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.wg;
import java.io.Serializable;

/*
 * Renamed from com.github.catvod.spider.merge.mg
 */
public final class mg_1<A, B>
implements Serializable {
    public final B SN;
    public final A yq;

    public mg_1(A a, B b2) {
        this.yq = a;
        this.SN = b2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean equals(Object object) {
        boolean bl;
        boolean bl2 = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof mg_1)) {
            return false;
        }
        object = (mg_1)object;
        A a = this.yq;
        Object object2 = ((mg_1)object).yq;
        if (a == null) {
            if (object2 != null) return false;
            bl = true;
        } else {
            bl = a.equals(object2);
        }
        if (!bl) return false;
        object2 = this.SN;
        object = ((mg_1)object).SN;
        if (object2 == null) {
            if (object != null) return false;
            bl = true;
        } else {
            bl = object2.equals(object);
        }
        if (!bl) return false;
        return bl2;
    }

    public final int hashCode() {
        return wg.SN(wg.i(wg.i(0, this.yq), this.SN), 2);
    }

    public final String toString() {
        return String.format("(%s, %s)", this.yq, this.SN);
    }
}

