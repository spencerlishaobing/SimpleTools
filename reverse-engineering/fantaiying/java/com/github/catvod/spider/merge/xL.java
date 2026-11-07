/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.zg;

public final class xL
extends zg {
    public xL(String string, String string2, String string3) {
        block4: {
            block3: {
                block2: {
                    co_0.Gc(string);
                    co_0.Gc(string2);
                    co_0.Gc(string3);
                    super.g("name", string);
                    super.g("publicId", string2);
                    super.g("systemId", string3);
                    if (!this.Fz("publicId")) break block2;
                    string = "PUBLIC";
                    break block3;
                }
                if (!this.Fz("systemId")) break block4;
                string = "SYSTEM";
            }
            super.g("pubSysKey", string);
        }
    }

    private boolean Fz(String string) {
        return Nr.tF(super.N(string)) ^ true;
    }

    @Override
    public final iK B() {
        return this;
    }

    public final void E1(String string) {
        if (string != null) {
            super.g("pubSysKey", string);
        }
    }

    @Override
    final void Gd(Appendable appendable, int n2, Va.yq yq2) {
    }

    @Override
    public final String v() {
        return "#doctype";
    }

    @Override
    final void xa(Appendable appendable, int n2, Va.yq object) {
        if (this.SN > 0 && ((Va.yq)object).t0()) {
            appendable.append('\n');
        }
        object = ((Va.yq)object).Gc() == 1 && !this.Fz("publicId") && !this.Fz("systemId") ? "<!doctype" : "<!DOCTYPE";
        appendable.append((CharSequence)object);
        if (this.Fz("name")) {
            appendable.append(" ").append(super.N("name"));
        }
        if (this.Fz("pubSysKey")) {
            appendable.append(" ").append(super.N("pubSysKey"));
        }
        if (this.Fz("publicId")) {
            appendable.append(" \"").append(super.N("publicId")).append('\"');
        }
        if (this.Fz("systemId")) {
            appendable.append(" \"").append(super.N("systemId")).append('\"');
        }
        appendable.append('>');
    }
}

