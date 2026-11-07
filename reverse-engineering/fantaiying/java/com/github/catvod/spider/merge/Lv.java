/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.LJ;
import com.github.catvod.spider.merge.fh;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.mg_1;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.q2;
import com.github.catvod.spider.merge.ta_1;
import java.io.Serializable;

public final class Lv
implements LJ,
Serializable {
    protected int Gc;
    protected int M;
    protected int N = -1;
    protected int SN;
    protected String i;
    protected int t0 = -1;
    protected int tF;
    protected int yq;
    protected mg_1<fh, q2> zH;

    public Lv(mg_1<fh, q2> mg_12, int n2, int n3, int n4, int n5) {
        this.zH = mg_12;
        this.yq = n2;
        this.tF = n3;
        this.Gc = n4;
        this.M = n5;
        Object a = mg_12.yq;
        if (a != null) {
            this.SN = ((fh)a).getLine();
            this.N = ((fh)mg_12.yq).yq();
        }
    }

    @Override
    public final int N() {
        return this.t0;
    }

    @Override
    public final fh SN() {
        return (fh)this.zH.yq;
    }

    @Override
    public final int getChannel() {
        return this.tF;
    }

    @Override
    public final int getLine() {
        return this.SN;
    }

    @Override
    public final String getText() {
        int n2;
        Object object = this.i;
        if (object != null) {
            return object;
        }
        object = (q2)this.zH.SN;
        if (object == null) {
            return null;
        }
        int n3 = this.Gc;
        int n4 = object.size();
        if (n3 < n4 && (n2 = this.M) < n4) {
            return object.tF(ta_1.SN(n3, n2));
        }
        return "<EOF>";
    }

    @Override
    public final int getType() {
        return this.yq;
    }

    @Override
    public final void tF(int n2) {
        this.t0 = n2;
    }

    public final String toString() {
        CharSequence charSequence;
        if (this.tF > 0) {
            charSequence = oi_0.yq(",channel=");
            ((StringBuilder)charSequence).append(this.tF);
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "";
        }
        String string = this.getText();
        string = string != null ? string.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t") : "<no text>";
        int n2 = this.yq;
        StringBuilder stringBuilder = oi_0.yq("[@");
        stringBuilder.append(this.t0);
        stringBuilder.append(",");
        stringBuilder.append(this.Gc);
        stringBuilder.append(":");
        stringBuilder.append(this.M);
        stringBuilder.append("='");
        stringBuilder.append(string);
        stringBuilder.append("',<");
        k_0.t0(stringBuilder, String.valueOf(n2), ">", (String)charSequence, ",");
        stringBuilder.append(this.SN);
        stringBuilder.append(":");
        stringBuilder.append(this.N);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public final int yq() {
        return this.N;
    }
}

