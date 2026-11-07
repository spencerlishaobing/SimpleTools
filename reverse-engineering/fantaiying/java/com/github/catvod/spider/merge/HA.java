/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

public final class HA {
    private static final HA[] tF = HA.yq();
    private final int N;
    private final SN[] SN;
    private final int yq;

    private HA(int n2, SN ... object) {
        this.yq = n2;
        this.SN = object;
        int n3 = object[0].SN();
        yq[] yqArray = object[0].yq();
        int n4 = yqArray.length;
        int n5 = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            object = yqArray[n2];
            int n7 = ((yq)object).yq();
            n5 += (((yq)object).SN() + n3) * n7;
        }
        this.N = n5;
    }

    private static HA[] yq() {
        return new HA[]{new HA(1, new SN(7, new yq(1, 19)), new SN(10, new yq(1, 16)), new SN(13, new yq(1, 13)), new SN(17, new yq(1, 9))), new HA(2, new SN(10, new yq(1, 34)), new SN(16, new yq(1, 28)), new SN(22, new yq(1, 22)), new SN(28, new yq(1, 16))), new HA(3, new SN(15, new yq(1, 55)), new SN(26, new yq(1, 44)), new SN(18, new yq(2, 17)), new SN(22, new yq(2, 13))), new HA(4, new SN(20, new yq(1, 80)), new SN(18, new yq(2, 32)), new SN(26, new yq(2, 24)), new SN(16, new yq(4, 9))), new HA(5, new SN(26, new yq(1, 108)), new SN(24, new yq(2, 43)), new SN(18, new yq(2, 15), new yq(2, 16)), new SN(22, new yq(2, 11), new yq(2, 12))), new HA(6, new SN(18, new yq(2, 68)), new SN(16, new yq(4, 27)), new SN(24, new yq(4, 19)), new SN(28, new yq(4, 15))), new HA(7, new SN(20, new yq(2, 78)), new SN(18, new yq(4, 31)), new SN(18, new yq(2, 14), new yq(4, 15)), new SN(26, new yq(4, 13), new yq(1, 14))), new HA(8, new SN(24, new yq(2, 97)), new SN(22, new yq(2, 38), new yq(2, 39)), new SN(22, new yq(4, 18), new yq(2, 19)), new SN(26, new yq(4, 14), new yq(2, 15))), new HA(9, new SN(30, new yq(2, 116)), new SN(22, new yq(3, 36), new yq(2, 37)), new SN(20, new yq(4, 16), new yq(4, 17)), new SN(24, new yq(4, 12), new yq(4, 13))), new HA(10, new SN(18, new yq(2, 68), new yq(2, 69)), new SN(26, new yq(4, 43), new yq(1, 44)), new SN(24, new yq(6, 19), new yq(2, 20)), new SN(28, new yq(6, 15), new yq(2, 16))), new HA(11, new SN(20, new yq(4, 81)), new SN(30, new yq(1, 50), new yq(4, 51)), new SN(28, new yq(4, 22), new yq(4, 23)), new SN(24, new yq(3, 12), new yq(8, 13))), new HA(12, new SN(24, new yq(2, 92), new yq(2, 93)), new SN(22, new yq(6, 36), new yq(2, 37)), new SN(26, new yq(4, 20), new yq(6, 21)), new SN(28, new yq(7, 14), new yq(4, 15))), new HA(13, new SN(26, new yq(4, 107)), new SN(22, new yq(8, 37), new yq(1, 38)), new SN(24, new yq(8, 20), new yq(4, 21)), new SN(22, new yq(12, 11), new yq(4, 12))), new HA(14, new SN(30, new yq(3, 115), new yq(1, 116)), new SN(24, new yq(4, 40), new yq(5, 41)), new SN(20, new yq(11, 16), new yq(5, 17)), new SN(24, new yq(11, 12), new yq(5, 13))), new HA(15, new SN(22, new yq(5, 87), new yq(1, 88)), new SN(24, new yq(5, 41), new yq(5, 42)), new SN(30, new yq(5, 24), new yq(7, 25)), new SN(24, new yq(11, 12), new yq(7, 13))), new HA(16, new SN(24, new yq(5, 98), new yq(1, 99)), new SN(28, new yq(7, 45), new yq(3, 46)), new SN(24, new yq(15, 19), new yq(2, 20)), new SN(30, new yq(3, 15), new yq(13, 16))), new HA(17, new SN(28, new yq(1, 107), new yq(5, 108)), new SN(28, new yq(10, 46), new yq(1, 47)), new SN(28, new yq(1, 22), new yq(15, 23)), new SN(28, new yq(2, 14), new yq(17, 15))), new HA(18, new SN(30, new yq(5, 120), new yq(1, 121)), new SN(26, new yq(9, 43), new yq(4, 44)), new SN(28, new yq(17, 22), new yq(1, 23)), new SN(28, new yq(2, 14), new yq(19, 15))), new HA(19, new SN(28, new yq(3, 113), new yq(4, 114)), new SN(26, new yq(3, 44), new yq(11, 45)), new SN(26, new yq(17, 21), new yq(4, 22)), new SN(26, new yq(9, 13), new yq(16, 14))), new HA(20, new SN(28, new yq(3, 107), new yq(5, 108)), new SN(26, new yq(3, 41), new yq(13, 42)), new SN(30, new yq(15, 24), new yq(5, 25)), new SN(28, new yq(15, 15), new yq(10, 16))), new HA(21, new SN(28, new yq(4, 116), new yq(4, 117)), new SN(26, new yq(17, 42)), new SN(28, new yq(17, 22), new yq(6, 23)), new SN(30, new yq(19, 16), new yq(6, 17))), new HA(22, new SN(28, new yq(2, 111), new yq(7, 112)), new SN(28, new yq(17, 46)), new SN(30, new yq(7, 24), new yq(16, 25)), new SN(24, new yq(34, 13))), new HA(23, new SN(30, new yq(4, 121), new yq(5, 122)), new SN(28, new yq(4, 47), new yq(14, 48)), new SN(30, new yq(11, 24), new yq(14, 25)), new SN(30, new yq(16, 15), new yq(14, 16))), new HA(24, new SN(30, new yq(6, 117), new yq(4, 118)), new SN(28, new yq(6, 45), new yq(14, 46)), new SN(30, new yq(11, 24), new yq(16, 25)), new SN(30, new yq(30, 16), new yq(2, 17))), new HA(25, new SN(26, new yq(8, 106), new yq(4, 107)), new SN(28, new yq(8, 47), new yq(13, 48)), new SN(30, new yq(7, 24), new yq(22, 25)), new SN(30, new yq(22, 15), new yq(13, 16))), new HA(26, new SN(28, new yq(10, 114), new yq(2, 115)), new SN(28, new yq(19, 46), new yq(4, 47)), new SN(28, new yq(28, 22), new yq(6, 23)), new SN(30, new yq(33, 16), new yq(4, 17))), new HA(27, new SN(30, new yq(8, 122), new yq(4, 123)), new SN(28, new yq(22, 45), new yq(3, 46)), new SN(30, new yq(8, 23), new yq(26, 24)), new SN(30, new yq(12, 15), new yq(28, 16))), new HA(28, new SN(30, new yq(3, 117), new yq(10, 118)), new SN(28, new yq(3, 45), new yq(23, 46)), new SN(30, new yq(4, 24), new yq(31, 25)), new SN(30, new yq(11, 15), new yq(31, 16))), new HA(29, new SN(30, new yq(7, 116), new yq(7, 117)), new SN(28, new yq(21, 45), new yq(7, 46)), new SN(30, new yq(1, 23), new yq(37, 24)), new SN(30, new yq(19, 15), new yq(26, 16))), new HA(30, new SN(30, new yq(5, 115), new yq(10, 116)), new SN(28, new yq(19, 47), new yq(10, 48)), new SN(30, new yq(15, 24), new yq(25, 25)), new SN(30, new yq(23, 15), new yq(25, 16))), new HA(31, new SN(30, new yq(13, 115), new yq(3, 116)), new SN(28, new yq(2, 46), new yq(29, 47)), new SN(30, new yq(42, 24), new yq(1, 25)), new SN(30, new yq(23, 15), new yq(28, 16))), new HA(32, new SN(30, new yq(17, 115)), new SN(28, new yq(10, 46), new yq(23, 47)), new SN(30, new yq(10, 24), new yq(35, 25)), new SN(30, new yq(19, 15), new yq(35, 16))), new HA(33, new SN(30, new yq(17, 115), new yq(1, 116)), new SN(28, new yq(14, 46), new yq(21, 47)), new SN(30, new yq(29, 24), new yq(19, 25)), new SN(30, new yq(11, 15), new yq(46, 16))), new HA(34, new SN(30, new yq(13, 115), new yq(6, 116)), new SN(28, new yq(14, 46), new yq(23, 47)), new SN(30, new yq(44, 24), new yq(7, 25)), new SN(30, new yq(59, 16), new yq(1, 17))), new HA(35, new SN(30, new yq(12, 121), new yq(7, 122)), new SN(28, new yq(12, 47), new yq(26, 48)), new SN(30, new yq(39, 24), new yq(14, 25)), new SN(30, new yq(22, 15), new yq(41, 16))), new HA(36, new SN(30, new yq(6, 121), new yq(14, 122)), new SN(28, new yq(6, 47), new yq(34, 48)), new SN(30, new yq(46, 24), new yq(10, 25)), new SN(30, new yq(2, 15), new yq(64, 16))), new HA(37, new SN(30, new yq(17, 122), new yq(4, 123)), new SN(28, new yq(29, 46), new yq(14, 47)), new SN(30, new yq(49, 24), new yq(10, 25)), new SN(30, new yq(24, 15), new yq(46, 16))), new HA(38, new SN(30, new yq(4, 122), new yq(18, 123)), new SN(28, new yq(13, 46), new yq(32, 47)), new SN(30, new yq(48, 24), new yq(14, 25)), new SN(30, new yq(42, 15), new yq(32, 16))), new HA(39, new SN(30, new yq(20, 117), new yq(4, 118)), new SN(28, new yq(40, 47), new yq(7, 48)), new SN(30, new yq(43, 24), new yq(22, 25)), new SN(30, new yq(10, 15), new yq(67, 16))), new HA(40, new SN(30, new yq(19, 118), new yq(6, 119)), new SN(28, new yq(18, 47), new yq(31, 48)), new SN(30, new yq(34, 24), new yq(34, 25)), new SN(30, new yq(20, 15), new yq(61, 16)))};
    }

    public static HA zH(int n2) {
        if (n2 > 0 && n2 <= 40) {
            return tF[n2 - 1];
        }
        throw new IllegalArgumentException();
    }

    public final SN N(int n2) {
        SN[] sNArray = this.SN;
        if (n2 != 0) {
            return sNArray[n2 - 1];
        }
        throw null;
    }

    public final int SN() {
        return this.yq * 4 + 17;
    }

    public final int i() {
        return this.yq;
    }

    public final int tF() {
        return this.N;
    }

    public final String toString() {
        return String.valueOf(this.yq);
    }

    public static final class SN {
        private final yq[] SN;
        private final int yq;

        SN(int n2, yq ... yqArray) {
            this.yq = n2;
            this.SN = yqArray;
        }

        public final int N() {
            yq[] yqArray = this.SN;
            int n2 = yqArray.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                n3 += yqArray[i2].yq();
            }
            return n3;
        }

        public final int SN() {
            return this.yq;
        }

        public final int tF() {
            int n2 = this.yq;
            yq[] yqArray = this.SN;
            int n3 = yqArray.length;
            int n4 = 0;
            for (int i2 = 0; i2 < n3; ++i2) {
                n4 += yqArray[i2].yq();
            }
            return n2 * n4;
        }

        public final yq[] yq() {
            return this.SN;
        }
    }

    public static final class yq {
        private final int SN;
        private final int yq;

        yq(int n2, int n3) {
            this.yq = n2;
            this.SN = n3;
        }

        public final int SN() {
            return this.SN;
        }

        public final int yq() {
            return this.yq;
        }
    }
}

