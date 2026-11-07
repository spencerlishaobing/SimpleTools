/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.LE;
import com.github.catvod.spider.merge.RH;
import com.github.catvod.spider.merge.YG;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.xo_0;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.AbstractCollection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class pv
implements Comparable<pv> {
    private boolean N = false;
    private boolean SN = false;
    private Object yq;

    public pv(Object object) {
        this.yq = object;
    }

    public final boolean B() {
        return this.yq instanceof Boolean;
    }

    public final boolean F5() {
        return this.yq instanceof List;
    }

    public final boolean G() {
        return this.yq instanceof Date;
    }

    public final boolean G4() {
        return this.yq instanceof kb_0;
    }

    public final pv Gc() {
        this.SN = true;
        return this;
    }

    public final pv KJ() {
        this.N = true;
        this.yq = YG.i(YG.i(YG.t0(YG.t0(String.valueOf(this.yq), "'"), "\""), "'"), "\"");
        return this;
    }

    public final int M(pv comparable) {
        if (this.equals(comparable)) {
            return 0;
        }
        if (comparable != null && ((pv)comparable).yq != null) {
            Object object = this.yq;
            if (object == null) {
                return -1;
            }
            if (object instanceof String) {
                return this.t0().compareTo(((pv)comparable).t0());
            }
            if (object instanceof Number) {
                return this.N().compareTo(((pv)comparable).N());
            }
            comparable = oi_0.yq("Unsupported comparable XValue = ");
            ((StringBuilder)comparable).append(this.toString());
            throw new RH(((StringBuilder)comparable).toString());
        }
        return 1;
    }

    public final Double N() {
        Object object;
        block4: {
            double d;
            block3: {
                block2: {
                    object = this.yq;
                    if (!(object instanceof String)) break block2;
                    d = new BigDecimal((String)this.yq).doubleValue();
                    break block3;
                }
                if (!(object instanceof Number)) break block4;
                d = ((Number)object).doubleValue();
            }
            return d;
        }
        object = oi_0.yq("cast to number fail. vale = ");
        ((StringBuilder)object).append(this.yq);
        throw new RH(((StringBuilder)object).toString());
    }

    public final Date SN() {
        Object object = this.yq;
        if (object instanceof String) {
            try {
                object = LE.yq.N((String)object);
                return object;
            }
            catch (ParseException parseException) {
                StringBuilder stringBuilder = oi_0.yq("cast to date fail. vale = ");
                stringBuilder.append(this.yq);
                throw new RH(stringBuilder.toString());
            }
        }
        if (object instanceof Date) {
            return (Date)object;
        }
        object = oi_0.yq("cast to date fail. vale = ");
        ((StringBuilder)object).append(this.yq);
        throw new RH(((StringBuilder)object).toString());
    }

    public final boolean W() {
        return this.yq instanceof String;
    }

    public final boolean dT() {
        return this.N;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && pv.class == object.getClass()) {
            object = (pv)object;
            return Objects.equals(this.yq, ((pv)object).yq);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.yq);
    }

    public final Long i() {
        Object object;
        block4: {
            long l;
            block3: {
                block2: {
                    object = this.yq;
                    if (!(object instanceof String)) break block2;
                    l = new BigDecimal((String)this.yq).setScale(0, 4).longValue();
                    break block3;
                }
                if (!(object instanceof Number)) break block4;
                l = ((Number)object).longValue();
            }
            return l;
        }
        object = oi_0.yq("cast to number fail. vale = ");
        ((StringBuilder)object).append(this.yq);
        throw new RH(((StringBuilder)object).toString());
    }

    public final boolean q() {
        return this.SN;
    }

    public final String t0() {
        Object object = this.yq;
        if (object instanceof kb_0) {
            object = new StringBuilder();
            Iterator iterator = ((AbstractCollection)((kb_0)this.yq)).iterator();
            while (iterator.hasNext()) {
                ((StringBuilder)object).append(((hN)iterator.next()).kR());
            }
            return ((StringBuilder)object).toString();
        }
        if (object instanceof hN && Objects.equals(((hN)object).tl(), "JX_TEXT")) {
            return ((hN)this.yq).kR();
        }
        object = this.yq;
        if (object instanceof List) {
            return YG.zH((List)object, ",");
        }
        return String.valueOf(object).trim();
    }

    public final kb_0 tF() {
        return (kb_0)this.yq;
    }

    public final String toString() {
        xo_0 xo_02 = new xo_0(this);
        xo_02.yq(this.yq);
        xo_02.SN("isAttr", this.SN);
        xo_02.SN("isExprStr", this.N);
        return xo_02.toString();
    }

    public final Class v() {
        Object object = this.yq;
        if (object == null) {
            return Object.class;
        }
        return object.getClass();
    }

    public final boolean v3() {
        return this.yq instanceof Number;
    }

    public final Boolean yq() {
        Object object = this.yq;
        if (object instanceof Boolean) {
            return (Boolean)object;
        }
        boolean bl = object != null && !YG.SN(this.t0());
        return bl;
    }

    public final List<String> zH() {
        return (List)this.yq;
    }
}

