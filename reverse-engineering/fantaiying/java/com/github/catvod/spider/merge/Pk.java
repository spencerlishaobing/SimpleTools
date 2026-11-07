/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.fu_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.kb_0;
import java.util.Objects;

public final class Pk {
    private Object yq;

    public Pk(Object object) {
        this.yq = object;
    }

    public final Pk SN(String object) {
        object = !(this.yq instanceof hN) ? null : new fu_0(new kb_0((hN)this.yq)).yq((String)object);
        if (object != null && object.size() > 0) {
            return (Pk)object.get(0);
        }
        return null;
    }

    public final String toString() {
        return this.yq();
    }

    public final String yq() {
        Object object = this.yq;
        if (object == null) {
            return "";
        }
        if (object instanceof String) {
            return (String)object;
        }
        if (object instanceof hN) {
            if (Objects.equals(((hN)(object = (hN)object)).tl(), "JX_TEXT")) {
                return ((hN)object).kR();
            }
            return ((iK)object).ee();
        }
        return String.valueOf(object);
    }
}

