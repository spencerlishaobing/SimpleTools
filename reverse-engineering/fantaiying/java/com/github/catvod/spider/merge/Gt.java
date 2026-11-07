/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.p7;

public final class Gt {
    private String N;
    private String SN;
    private boolean i;
    private boolean t0;
    private String tF;
    private String yq = p7.zH("playMode", "\u9ed8\u8ba4");
    private String zH;

    public Gt() {
        this.SN = p7.zH("callPlayMode", "\u9ed8\u8ba4");
        this.N = p7.zH("proxyMode", "\u9ed8\u8ba4");
        this.tF = p7.zH("webdavMode", "\u9ed8\u8ba4");
        this.zH = p7.zH("browseMode", "\u9ed8\u8ba4");
        this.i = p7.yq("danMu", true);
        p7.zH("ad", "true");
        p7.zH("speedUp", "\u9ed8\u8ba4");
        this.t0 = p7.yq("appYsc", false);
    }

    public final void Gc(boolean bl) {
        this.i = bl;
        p7.i("danMu", bl);
    }

    public final String N() {
        return this.SN;
    }

    public final String SN() {
        return this.zH;
    }

    public final String i() {
        return this.N;
    }

    public final String t0() {
        return this.tF;
    }

    public final boolean tF() {
        return this.i;
    }

    public final boolean yq() {
        return this.t0;
    }

    public final String zH() {
        return this.yq;
    }
}

