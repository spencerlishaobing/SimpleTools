/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.FE;
import com.github.catvod.spider.merge.Mx;
import com.github.catvod.spider.merge.QY;
import com.github.catvod.spider.merge.du_0;
import com.github.catvod.spider.merge.oX;
import com.github.catvod.spider.merge.qQ;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public final class vb {
    private final qQ SN;
    private final QY yq;

    public vb(QY qY, qQ qQ2) {
        this.yq = qY;
        this.SN = qQ2;
    }

    public final String toString() {
        if (this.yq.SN == null) {
            return null;
        }
        CharSequence charSequence = new StringBuilder();
        Iterator iterator = this.yq;
        Objects.requireNonNull(iterator);
        iterator = new ArrayList(((HashMap)((QY)((Object)iterator)).yq).keySet());
        Collections.sort(iterator, new du_0());
        iterator = ((ArrayList)((Object)iterator)).iterator();
        while (iterator.hasNext()) {
            Mx mx = (Mx)iterator.next();
            Object object = mx.N;
            int n2 = object != null ? ((Mx[])object).length : 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                object = mx.N[i2];
                if (object == null || object.yq == Integer.MAX_VALUE) continue;
                ((StringBuilder)charSequence).append(this.yq(mx));
                String string = ((FE)this.SN).yq(i2 - 1);
                ((StringBuilder)charSequence).append("-");
                ((StringBuilder)charSequence).append(string);
                ((StringBuilder)charSequence).append("->");
                ((StringBuilder)charSequence).append(this.yq((Mx)object));
                ((StringBuilder)charSequence).append('\n');
            }
        }
        if (((String)(charSequence = ((StringBuilder)charSequence).toString())).length() == 0) {
            return null;
        }
        return charSequence;
    }

    protected final String yq(Mx object) {
        int n2 = ((Mx)object).yq;
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = ((Mx)object).tF;
        String string = "";
        CharSequence charSequence = bl ? ":" : "";
        stringBuilder.append((String)charSequence);
        stringBuilder.append("s");
        stringBuilder.append(n2);
        charSequence = string;
        if (((Mx)object).t0) {
            charSequence = "^";
        }
        stringBuilder.append((String)charSequence);
        charSequence = stringBuilder.toString();
        if (((Mx)object).tF) {
            if (((Mx)object).Gc != null) {
                charSequence = oX.yq((String)charSequence, "=>");
                ((StringBuilder)charSequence).append(Arrays.toString(((Mx)object).Gc));
                object = charSequence;
            } else {
                charSequence = oX.yq((String)charSequence, "=>");
                ((StringBuilder)charSequence).append(((Mx)object).zH);
                object = charSequence;
            }
            return ((StringBuilder)object).toString();
        }
        return charSequence;
    }
}

