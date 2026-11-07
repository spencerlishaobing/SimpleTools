/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

public final class ZV {
    public static final int SN = 0;
    private static final char[] yq = "0123456789abcdef".toCharArray();

    public static byte[] SN(String object) {
        if (((String)(object = ((String)object).trim())).length() % 2 == 0) {
            int n2 = ((String)object).length() / 2;
            byte[] byArray = new byte[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = i2 * 2;
                int n4 = Character.digit(((String)object).charAt(n3), 16);
                n3 = Character.digit(((String)object).charAt(n3 + 1), 16);
                if (n4 >= 0 && n3 >= 0) {
                    byArray[i2] = (byte)(n3 | n4 << 4);
                    continue;
                }
                throw new IllegalArgumentException("\u975e\u6cd5\u5341\u516d\u8fdb\u5236\u5b57\u7b26");
            }
            return byArray;
        }
        object = new IllegalArgumentException("\u5341\u516d\u8fdb\u5236\u957f\u5ea6\u5fc5\u987b\u4e3a\u5076\u6570");
        throw object;
    }

    public static String yq(byte[] byArray) {
        char[] cArray = new char[byArray.length * 2];
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            int n2 = byArray[i2] & 0xFF;
            int n3 = i2 * 2;
            char[] cArray2 = yq;
            cArray[n3] = cArray2[n2 >>> 4];
            cArray[n3 + 1] = cArray2[n2 & 0xF];
        }
        return new String(cArray);
    }
}

