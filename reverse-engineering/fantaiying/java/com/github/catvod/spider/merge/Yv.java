/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Os;
import com.github.catvod.spider.merge.TL;
import com.github.catvod.spider.merge.W3;
import com.github.catvod.spider.merge.Wt;
import com.github.catvod.spider.merge.aq;
import com.github.catvod.spider.merge.fx;
import com.github.catvod.spider.merge.il_0;
import com.github.catvod.spider.merge.j;
import com.github.catvod.spider.merge.mZ;
import com.github.catvod.spider.merge.qh;
import com.github.catvod.spider.merge.ue;
import com.github.catvod.spider.merge.zn_0;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public abstract class Yv {
    public j yq;

    static {
        Collections.unmodifiableList(Arrays.asList("INVALID", "EPSILON", "RANGE", "RULE", "PREDICATE", "ATOM", "ACTION", "SET", "NOT_SET", "WILDCARD", "PRECEDENCE"));
        Collections.unmodifiableMap(new HashMap<Class<? extends Yv>, Integer>(){
            {
                ((AbstractMap)this).put(zn_0.class, 1);
                ((AbstractMap)this).put(qh.class, 2);
                ((AbstractMap)this).put(Os.class, 3);
                ((AbstractMap)this).put(Wt.class, 4);
                ((AbstractMap)this).put(fx.class, 5);
                ((AbstractMap)this).put(ue.class, 6);
                ((AbstractMap)this).put(TL.class, 7);
                ((AbstractMap)this).put(W3.class, 8);
                ((AbstractMap)this).put(il_0.class, 9);
                ((AbstractMap)this).put(mZ.class, 10);
            }
        });
    }

    protected Yv(j j3) {
        Objects.requireNonNull(j3, "target cannot be null.");
        this.yq = j3;
    }

    public aq N() {
        return null;
    }

    public boolean SN() {
        return this instanceof ue;
    }

    public abstract boolean tF(int var1, int var2);

    public abstract int yq();
}

