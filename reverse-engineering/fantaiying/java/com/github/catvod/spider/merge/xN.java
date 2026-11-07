/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.HA;

public final class xN
extends Enum<xN> {
    private static final xN[] Gc;
    public static final /* enum */ xN N;
    public static final /* enum */ xN i;
    public static final /* enum */ xN t0;
    public static final /* enum */ xN tF;
    public static final /* enum */ xN zH;
    private final int SN;
    private final int[] yq;

    static {
        xN xN2;
        xN xN3;
        xN xN4;
        xN xN5;
        xN xN6;
        xN xN7 = new xN(new int[]{0, 0, 0}, 0);
        N = xN6 = new xN(new int[]{10, 12, 14}, 1);
        tF = xN5 = new xN(new int[]{9, 11, 13}, 2);
        xN xN8 = new xN(new int[]{0, 0, 0}, 3);
        zH = xN4 = new xN(new int[]{8, 16, 16}, 4);
        i = xN3 = new xN(new int[]{0, 0, 0}, 7);
        t0 = xN2 = new xN(new int[]{8, 10, 12}, 8);
        Gc = new xN[]{xN7, xN6, xN5, xN8, xN4, xN3, xN2, new xN(new int[]{0, 0, 0}, 5), new xN(new int[]{0, 0, 0}, 9), new xN(new int[]{8, 10, 12}, 13)};
    }

    private xN(int[] nArray, int n3) {
        this.yq = nArray;
        this.SN = n3;
    }

    public static xN valueOf(String string) {
        return Enum.valueOf(xN.class, string);
    }

    public static xN[] values() {
        return (xN[])Gc.clone();
    }

    public final int SN(HA hA) {
        int n2 = hA.i();
        n2 = n2 <= 9 ? 0 : (n2 <= 26 ? 1 : 2);
        return this.yq[n2];
    }

    public final int yq() {
        return this.SN;
    }
}

