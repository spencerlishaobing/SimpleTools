/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.Random;

public class wg {
    private static String[] yq = new String[]{"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36 Edg/148.0.0.0", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:148.0) Gecko/20100101 Firefox/148.0", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36 Edg/112.0.1722.64", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36", "Mozilla/5.0 (Macintosh; Intel Mac OS X 13_0_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Safari/605.1.15", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36", "Mozilla/5.0 (iPhone; CPU iPhone OS 18_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Mobile/15E148 Safari/604.1", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.7727.56 Safari/537.36"};

    public static String N() {
        Random random = new Random();
        return yq[random.nextInt(11)];
    }

    public static int SN(int n, int n2) {
        n ^= n2 * 4;
        n = (n ^ n >>> 16) * -2048144789;
        n = (n ^ n >>> 13) * -1028477387;
        return n ^ n >>> 16;
    }

    public static int i(int n, Object object) {
        int n2 = object != null ? object.hashCode() : 0;
        return wg.zH(n, n2);
    }

    public static boolean tF(byte by2, int n) {
        boolean bl = (1L << n & (long)by2) != 0L;
        return bl;
    }

    public static final void yq(int n, int n2) {
        if (n <= n2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex (");
        stringBuilder.append(n);
        stringBuilder.append(") is greater than size (");
        stringBuilder.append(n2);
        stringBuilder.append(").");
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public static int zH(int n, int n2) {
        return ((n ^= ((n2 *= -862048943) >>> 17 | n2 << 15) * 461845907) >>> 19 | n << 13) * 5 - 430675100;
    }
}

