/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.spider.merge.vA
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.T2;
import com.github.catvod.spider.merge.TJ;
import com.github.catvod.spider.merge.qW;
import com.github.catvod.spider.merge.tm_1;
import com.github.catvod.spider.merge.u7_0;
import com.github.catvod.spider.merge.vA;
import java.util.Iterator;
import java.util.Objects;

/*
 * Renamed from com.github.catvod.spider.merge.vA
 */
public final class va_0 {
    private final N N;
    private final boolean SN;
    private final int tF;
    private final qW yq;

    private va_0(N n2, boolean bl, qW qW2, int n3) {
        this.N = n2;
        this.SN = bl;
        this.yq = qW2;
        this.tF = n3;
    }

    static /* synthetic */ boolean N(va_0 va_02) {
        return va_02.SN;
    }

    static /* synthetic */ qW SN(va_0 va_02) {
        return va_02.yq;
    }

    public static va_0 i() {
        return new va_0(new TJ(new qW.SN()), false, qW.tF.SN, Integer.MAX_VALUE);
    }

    static /* synthetic */ int tF(va_0 va_02) {
        return va_02.tF;
    }

    static Iterator yq(va_0 va_02, CharSequence charSequence) {
        TJ tJ = (TJ)va_02.N;
        Objects.requireNonNull(tJ);
        return new tm_1(tJ, va_02, charSequence);
    }

    public final va_0 Gc() {
        qW.zH zH2 = qW.zH.N;
        Objects.requireNonNull(zH2);
        return new va_0(this.N, this.SN, zH2, this.tF);
    }

    public final Iterable<String> t0(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        return new Iterable<String>(this, charSequence){
            final va_0 SN;
            final CharSequence yq;
            {
                this.SN = va_02;
                this.yq = charSequence;
            }

            public final Iterator<String> iterator() {
                return va_0.yq(this.SN, this.yq);
            }

            public final String toString() {
                Object object = T2.SN();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('[');
                object = ((T2)object).yq(stringBuilder, this);
                ((StringBuilder)object).append(']');
                return ((StringBuilder)object).toString();
            }
        };
    }

    public final va_0 zH() {
        return new va_0(this.N, true, this.yq, this.tF);
    }

    private static interface N {
    }

    private static abstract class SN
    extends u7_0<String> {
        final CharSequence N;
        int i = 0;
        int t0;
        final qW tF;
        final boolean zH;

        protected SN(va_0 va_02, CharSequence charSequence) {
            this.tF = vA.SN((va_0)va_02);
            this.zH = vA.N((va_0)va_02);
            this.t0 = vA.tF((va_0)va_02);
            this.N = charSequence;
        }
    }
}

