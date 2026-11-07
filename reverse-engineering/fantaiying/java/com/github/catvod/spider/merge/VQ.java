/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.XO;
import com.github.catvod.spider.merge.lF;
import com.github.catvod.spider.merge.rg;
import com.github.catvod.spider.merge.tF;
import com.github.catvod.spider.merge.uT;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class VQ<Symbol, ATNInterpreter extends XO> {
    private int N = -1;
    protected ATNInterpreter SN;
    private List<tF> yq = new CopyOnWriteArrayList<tF>(){
        {
            this.add(uT.yq);
        }
    };

    static {
        new WeakHashMap();
        new WeakHashMap();
    }

    public boolean Gc(int n) {
        return true;
    }

    public final void M(int n) {
        this.N = n;
    }

    public final ATNInterpreter i() {
        return this.SN;
    }

    public final int t0() {
        return this.N;
    }

    public abstract lF tF();

    public final tF zH() {
        return new rg(this.yq);
    }
}

