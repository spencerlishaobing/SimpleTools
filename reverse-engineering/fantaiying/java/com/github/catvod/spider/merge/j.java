/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Yv;
import com.github.catvod.spider.merge.aq;
import com.github.catvod.spider.merge.lF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class j {
    public int N;
    public int SN = -1;
    public aq i;
    public boolean tF = false;
    public lF yq = null;
    protected final List<Yv> zH = new ArrayList<Yv>(4);

    static {
        Collections.unmodifiableList(Arrays.asList("INVALID", "BASIC", "RULE_START", "BLOCK_START", "PLUS_BLOCK_START", "STAR_BLOCK_START", "TOKEN_START", "RULE_STOP", "BLOCK_END", "STAR_LOOP_BACK", "STAR_LOOP_ENTRY", "PLUS_LOOP_BACK", "LOOP_END"));
    }

    public abstract int N();

    public final int SN() {
        return ((ArrayList)this.zH).size();
    }

    public final boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof j;
        boolean bl3 = bl = false;
        if (bl2) {
            bl3 = bl;
            if (this.SN == ((j)object).SN) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public final int hashCode() {
        return this.SN;
    }

    public final Yv tF(int n) {
        return (Yv)((ArrayList)this.zH).get(n);
    }

    public final String toString() {
        return String.valueOf(this.SN);
    }

    public final void yq(Yv yv) {
        boolean bl;
        int n;
        block5: {
            Yv yv2;
            n = ((ArrayList)this.zH).size();
            boolean bl2 = ((ArrayList)this.zH).isEmpty();
            boolean bl3 = false;
            if (bl2) {
                this.tF = yv.SN();
            } else if (this.tF != yv.SN()) {
                System.err.format(Locale.getDefault(), "ATN state %d has both epsilon and non-epsilon transitions.\n", this.SN);
                this.tF = false;
            }
            Iterator iterator = ((ArrayList)this.zH).iterator();
            do {
                bl = bl3;
                if (!iterator.hasNext()) break block5;
                yv2 = (Yv)iterator.next();
            } while (yv2.yq.SN != yv.yq.SN || (yv2.N() == null || yv.N() == null || !yv2.N().equals(yv.N())) && (!yv2.SN() || !yv.SN()));
            bl = true;
        }
        if (!bl) {
            ((ArrayList)this.zH).add(n, yv);
        }
    }
}

