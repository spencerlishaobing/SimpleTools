/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.HashMap;
import java.util.Map;

public final class Zk
extends Enum<Zk> {
    private static final Map<Integer, Zk> N;
    private static final Map<String, Zk> tF;
    private static final Zk[] zH;
    private final String[] SN;
    private final int[] yq;

    static {
        zH = new Zk[]{new Zk(new int[]{0, 2}, new String[0]), new Zk(new int[]{1, 3}, "ISO-8859-1"), new Zk(4, "ISO-8859-2"), new Zk(5, "ISO-8859-3"), new Zk(6, "ISO-8859-4"), new Zk(7, "ISO-8859-5"), new Zk(8, "ISO-8859-6"), new Zk(9, "ISO-8859-7"), new Zk(10, "ISO-8859-8"), new Zk(11, "ISO-8859-9"), new Zk(12, "ISO-8859-10"), new Zk(13, "ISO-8859-11"), new Zk(15, "ISO-8859-13"), new Zk(16, "ISO-8859-14"), new Zk(17, "ISO-8859-15"), new Zk(18, "ISO-8859-16"), new Zk(20, "Shift_JIS"), new Zk(21, "windows-1250"), new Zk(22, "windows-1251"), new Zk(23, "windows-1252"), new Zk(24, "windows-1256"), new Zk(25, "UTF-16BE", "UnicodeBig"), new Zk(26, "UTF-8"), new Zk(new int[]{27, 170}, "US-ASCII"), new Zk(new int[]{28}, new String[0]), new Zk(29, "GB2312", "EUC_CN", "GBK"), new Zk(30, "EUC-KR")};
        N = new HashMap<Integer, Zk>();
        tF = new HashMap<String, Zk>();
        for (Zk zk : Zk.values()) {
            for (int n2 : zk.yq) {
                ((HashMap)N).put(n2, zk);
            }
            ((HashMap)tF).put(zk.name(), zk);
            for (String string : zk.SN) {
                ((HashMap)tF).put(string, zk);
            }
        }
    }

    private Zk(int n3, String ... stringArray) {
        this.yq = new int[]{n3};
        this.SN = stringArray;
    }

    private Zk(int[] nArray, String ... stringArray) {
        this.yq = nArray;
        this.SN = stringArray;
    }

    public static Zk valueOf(String string) {
        return Enum.valueOf(Zk.class, string);
    }

    public static Zk[] values() {
        return (Zk[])zH.clone();
    }

    public static Zk yq(String string) {
        return (Zk)((Object)((HashMap)tF).get(string));
    }

    public final int SN() {
        return this.yq[0];
    }
}

