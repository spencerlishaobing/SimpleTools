/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.qQ;

public final class FE
implements qQ {
    private static final String[] tF;
    public static final FE zH;
    private final String[] N;
    private final String[] SN;
    private final String[] yq;

    static {
        String[] stringArray = new String[]{};
        tF = stringArray;
        zH = new FE(stringArray, stringArray, stringArray);
    }

    public FE(String[] stringArray, String[] stringArray2, String[] stringArray3) {
        this.yq = stringArray;
        this.SN = stringArray2;
        if (stringArray3 == null) {
            stringArray3 = tF;
        }
        this.N = stringArray3;
        Math.max(stringArray3.length, Math.max(stringArray.length, stringArray2.length));
    }

    public final String N(int n2) {
        String[] stringArray;
        if (n2 >= 0 && n2 < (stringArray = this.SN).length) {
            return stringArray[n2];
        }
        if (n2 == -1) {
            return "EOF";
        }
        return null;
    }

    public final String SN(int n2) {
        String[] stringArray;
        if (n2 >= 0 && n2 < (stringArray = this.yq).length) {
            return stringArray[n2];
        }
        return null;
    }

    public final String yq(int n2) {
        Object object;
        if (n2 >= 0 && n2 < ((String[])(object = this.N)).length && (object = object[n2]) != null) {
            return object;
        }
        object = this.SN(n2);
        if (object != null) {
            return object;
        }
        object = this.N(n2);
        if (object != null) {
            return object;
        }
        return Integer.toString(n2);
    }
}

