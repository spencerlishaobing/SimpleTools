/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.Y4;
import com.github.catvod.spider.merge.hN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public abstract class X7
extends Y4 {
    int SN = 0;
    final ArrayList<Y4> yq = new ArrayList();

    X7() {
    }

    final void SN() {
        this.SN = this.yq.size();
    }

    public static final class SN
    extends X7 {
        SN() {
        }

        SN(Y4 ... object) {
            object = Arrays.asList(object);
            if (this.SN > 1) {
                this.yq.add(new yq((Collection<Y4>)object));
            } else {
                this.yq.addAll((Collection<Y4>)object);
            }
            this.SN();
        }

        public final String toString() {
            return Nr.i(this.yq, ", ");
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            for (int i2 = 0; i2 < this.SN; ++i2) {
                if (!this.yq.get(i2).yq(hN2, hN3)) continue;
                return true;
            }
            return false;
        }
    }

    public static final class yq
    extends X7 {
        yq(Collection<Y4> collection) {
            this.yq.addAll(collection);
            this.SN();
        }

        yq(Y4 ... y4Array) {
            this(Arrays.asList(y4Array));
        }

        public final String toString() {
            return Nr.i(this.yq, "");
        }

        @Override
        public final boolean yq(hN hN2, hN hN3) {
            for (int i2 = this.SN - 1; i2 >= 0; --i2) {
                if (this.yq.get(i2).yq(hN2, hN3)) continue;
                return false;
            }
            return true;
        }
    }
}

