/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public final class MJ {
    public static String SN(byte[] object, int n2) {
        int n3;
        N n4;
        int n5;
        block10: {
            int n7;
            try {
                n5 = ((byte[])object).length;
                n4 = new N(n2);
                n3 = n5 / 3 * 4;
                boolean bl = n4.i;
                n7 = 1;
                if (bl) {
                    n2 = n3;
                    if (n5 % 3 > 0) {
                        n2 = n3 + 4;
                    }
                } else {
                    n2 = n5 % 3;
                    n2 = n2 != 1 ? (n2 != 2 ? n3 : n3 + 3) : n3 + 2;
                }
                n3 = n2;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new AssertionError((Object)unsupportedEncodingException);
            }
            if (!n4.t0) break block10;
            n3 = n2;
            if (n5 <= 0) break block10;
            int n8 = (n5 - 1) / 57;
            n3 = n7;
            if (n4.Gc) {
                n3 = 2;
            }
            n3 = n2 + (n8 + 1) * n3;
        }
        n4.yq = new byte[n3];
        n4.yq((byte[])object, n5);
        object = new String(n4.yq, "US-ASCII");
        return object;
    }

    public static byte[] yq(String object, int n2) {
        byte[] byArray = ((String)object).getBytes();
        int n3 = byArray.length;
        if (((SN)(object = new SN(n2, new byte[n3 * 3 / 4]))).yq(byArray, n3)) {
            n2 = ((yq)object).SN;
            object = ((yq)object).yq;
            if (n2 != ((Object)object).length) {
                byArray = new byte[n2];
                System.arraycopy(object, 0, byArray, 0, n2);
                object = byArray;
            }
            return object;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    static final class N
    extends yq {
        private static final byte[] KJ = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] q = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public final boolean Gc;
        private final byte[] M;
        private final byte[] N;
        public final boolean i;
        public final boolean t0;
        int tF;
        private int zH;

        public N(int n2) {
            this.yq = null;
            boolean bl = true;
            boolean bl2 = (n2 & 1) == 0;
            this.i = bl2;
            bl2 = (n2 & 2) == 0;
            this.t0 = bl2;
            if ((n2 & 4) == 0) {
                bl = false;
            }
            this.Gc = bl;
            byte[] byArray = (n2 & 8) == 0 ? KJ : q;
            this.M = byArray;
            this.N = new byte[2];
            this.tF = 0;
            n2 = bl2 ? 19 : -1;
            this.zH = n2;
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        public final boolean yq(byte[] var1_1, int var2_2) {
            block33: {
                block32: {
                    block31: {
                        block29: {
                            block30: {
                                block28: {
                                    block27: {
                                        var9_3 = this.M;
                                        var11_4 = this.yq;
                                        var4_5 = this.zH;
                                        var8_6 = 0;
                                        var5_7 = var2_2 + 0;
                                        var2_2 = this.tF;
                                        if (var2_2 == 1) break block27;
                                        if (var2_2 != 2 || 1 > var5_7) ** GOTO lbl-1000
                                        var10_8 /* !! */  = this.N;
                                        var2_2 = var10_8 /* !! */ [0];
                                        var3_9 = (var10_8 /* !! */ [1] & 255) << 8 | (var2_2 & 255) << 16 | var1_1 /* !! */ [0] & 255;
                                        this.tF = 0;
                                        var2_2 = 1;
                                        break block28;
                                    }
                                    if (2 <= var5_7) {
                                        var3_9 = (this.N[0] & 255) << 16 | (var1_1 /* !! */ [0] & 255) << 8 | var1_1 /* !! */ [1] & 255;
                                        this.tF = 0;
                                        var2_2 = 2;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        var3_9 = -1;
                                        var2_2 = 0;
                                    }
                                }
                                if (var3_9 == -1) break block29;
                                var11_4[0] = var9_3[var3_9 >> 18 & 63];
                                var11_4[1] = var9_3[var3_9 >> 12 & 63];
                                var11_4[2] = var9_3[var3_9 >> 6 & 63];
                                var11_4[3] = var9_3[var3_9 & 63];
                                if (--var4_5 != 0) break block30;
                                if (this.Gc) {
                                    var3_9 = 5;
                                    var11_4[4] = 13;
                                } else {
                                    var3_9 = 4;
                                }
                                var11_4[var3_9] = 10;
                                var12_10 /* !! */  = (byte[])this;
                                var4_5 = var3_9 + 1;
                                var10_8 /* !! */  = var9_3;
                                var9_3 = var1_1 /* !! */ ;
                                var1_1 /* !! */  = var12_10 /* !! */ ;
                                ** GOTO lbl74
                            }
                            var3_9 = 4;
                            break block31;
                        }
                        var3_9 = 0;
                    }
                    var10_8 /* !! */  = (byte[])this;
                    var6_11 = var4_5;
                    var12_10 /* !! */  = var1_1 /* !! */ ;
                    var1_1 /* !! */  = var10_8 /* !! */ ;
                    var4_5 = var2_2;
                    var2_2 = var3_9;
                    var3_9 = var5_7;
                    var10_8 /* !! */  = var9_3;
                    var9_3 = var12_10 /* !! */ ;
                    while ((var5_7 = var4_5 + 3) <= var3_9) {
                        var7_12 = var9_3[var4_5];
                        var4_5 = (var9_3[var4_5 + 1] & 255) << 8 | (var7_12 & 255) << 16 | var9_3[var4_5 + 2] & 255;
                        var11_4[var2_2] = var10_8 /* !! */ [var4_5 >> 18 & 63];
                        var11_4[var2_2 + 1] = var10_8 /* !! */ [var4_5 >> 12 & 63];
                        var11_4[var2_2 + 2] = var10_8 /* !! */ [var4_5 >> 6 & 63];
                        var11_4[var2_2 + 3] = var10_8 /* !! */ [var4_5 & 63];
                        var2_2 += 4;
                        if (--var6_11 == 0) {
                            var4_5 = var2_2;
                            if (var1_1 /* !! */ .Gc) {
                                var11_4[var2_2] = 13;
                                var4_5 = var2_2 + 1;
                            }
                            var11_4[var4_5] = 10;
                            ++var4_5;
                            var2_2 = var5_7;
                            var5_7 = var3_9;
lbl74:
                            // 2 sources

                            var3_9 = 19;
                            var7_12 = var5_7;
                            var5_7 = var4_5;
                            var4_5 = var2_2;
                        } else {
                            var4_5 = var5_7;
                            var5_7 = var2_2;
                            var7_12 = var3_9;
                            var3_9 = var6_11;
                        }
                        var6_11 = var3_9;
                        var3_9 = var7_12;
                        var2_2 = var5_7;
                    }
                    var7_12 = var1_1 /* !! */ .tF;
                    var5_7 = var4_5 - var7_12;
                    if (var5_7 != var3_9 - 1) break block32;
                    if (var7_12 > 0) {
                        var4_5 = var1_1 /* !! */ .N[0];
                        var3_9 = 1;
                    } else {
                        var4_5 = var9_3[var4_5];
                        var3_9 = var8_6;
                    }
                    var4_5 = (var4_5 & 255) << 4;
                    var1_1 /* !! */ .tF = var7_12 - var3_9;
                    var3_9 = var2_2 + 1;
                    var11_4[var2_2] = var10_8 /* !! */ [var4_5 >> 6 & 63];
                    var2_2 = var3_9 + 1;
                    var11_4[var3_9] = var10_8 /* !! */ [var4_5 & 63];
                    if (var1_1 /* !! */ .i) {
                        var3_9 = var2_2 + 1;
                        var11_4[var2_2] = 61;
                        var11_4[var3_9] = 61;
                        var2_2 = var3_9 + 1;
                    }
                    var3_9 = var2_2;
                    if (!var1_1 /* !! */ .t0) break block33;
                    var3_9 = var2_2;
                    if (var1_1 /* !! */ .Gc) {
                        var11_4[var2_2] = 13;
                        var3_9 = var2_2 + 1;
                    }
                    var2_2 = var3_9 + 1;
                    var11_4[var3_9] = 10;
                    ** GOTO lbl149
                }
                if (var5_7 == var3_9 - 2) {
                    if (var7_12 > 1) {
                        var5_7 = var1_1 /* !! */ .N[0];
                        var3_9 = 1;
                    } else {
                        var5_7 = var9_3[var4_5];
                        ++var4_5;
                        var3_9 = 0;
                    }
                    if (var7_12 > 0) {
                        var4_5 = var1_1 /* !! */ .N[var3_9];
                        ++var3_9;
                    } else {
                        var4_5 = var9_3[var4_5];
                    }
                    var4_5 = (var4_5 & 255) << 2 | (var5_7 & 255) << 10;
                    var1_1 /* !! */ .tF = var7_12 - var3_9;
                    var3_9 = var2_2 + 1;
                    var11_4[var2_2] = var10_8 /* !! */ [var4_5 >> 12 & 63];
                    var2_2 = var3_9 + 1;
                    var11_4[var3_9] = var10_8 /* !! */ [var4_5 >> 6 & 63];
                    var3_9 = var2_2 + 1;
                    var11_4[var2_2] = var10_8 /* !! */ [var4_5 & 63];
                    var2_2 = var3_9;
                    if (var1_1 /* !! */ .i) {
                        var11_4[var3_9] = 61;
                        var2_2 = var3_9 + 1;
                    }
                    if (var1_1 /* !! */ .t0) {
                        var3_9 = var2_2;
                        if (var1_1 /* !! */ .Gc) {
                            var11_4[var2_2] = 13;
                            var3_9 = var2_2 + 1;
                        }
                        var2_2 = var3_9 + 1;
                        var11_4[var3_9] = 10;
lbl149:
                        // 3 sources

                        while (true) {
                            var3_9 = var2_2;
                            break;
                        }
                    } else {
                        var3_9 = var2_2;
                    }
                } else {
                    var3_9 = var2_2;
                    if (var1_1 /* !! */ .t0) {
                        var3_9 = var2_2;
                        if (var2_2 > 0) {
                            var3_9 = var2_2;
                            if (var6_11 != 19) {
                                var3_9 = var2_2;
                                if (var1_1 /* !! */ .Gc) {
                                    var11_4[var2_2] = 13;
                                    var3_9 = var2_2 + 1;
                                }
                                var2_2 = var3_9 + 1;
                                var11_4[var3_9] = 10;
                                ** continue;
                            }
                        }
                    }
                }
            }
            var1_1 /* !! */ .SN = var3_9;
            var1_1 /* !! */ .zH = var6_11;
            return true;
        }
    }

    static final class SN
    extends yq {
        private static final int[] i = SN.$d2j$hex$a86c6600$decode_I("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff3e000000ffffffffffffffffffffffff3f0000003400000035000000360000003700000038000000390000003a0000003b0000003c0000003d000000fffffffffffffffffffffffffeffffffffffffffffffffffffffffff000000000100000002000000030000000400000005000000060000000700000008000000090000000a0000000b0000000c0000000d0000000e0000000f00000010000000110000001200000013000000140000001500000016000000170000001800000019000000ffffffffffffffffffffffffffffffffffffffffffffffff1a0000001b0000001c0000001d0000001e0000001f000000200000002100000022000000230000002400000025000000260000002700000028000000290000002a0000002b0000002c0000002d0000002e0000002f00000030000000310000003200000033000000ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        private static final int[] t0 = SN.$d2j$hex$a86c6600$decode_I("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff3e000000ffffffffffffffff3400000035000000360000003700000038000000390000003a0000003b0000003c0000003d000000fffffffffffffffffffffffffeffffffffffffffffffffffffffffff000000000100000002000000030000000400000005000000060000000700000008000000090000000a0000000b0000000c0000000d0000000e0000000f00000010000000110000001200000013000000140000001500000016000000170000001800000019000000ffffffffffffffffffffffffffffffff3f000000ffffffff1a0000001b0000001c0000001d0000001e0000001f000000200000002100000022000000230000002400000025000000260000002700000028000000290000002a0000002b0000002c0000002d0000002e0000002f00000030000000310000003200000033000000ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        private int N;
        private int tF;
        private final int[] zH;

        public SN(int n2, byte[] objectArray) {
            this.yq = objectArray;
            objectArray = (n2 & 8) == 0 ? (Object[])i : (Object[])t0;
            this.zH = (int[])objectArray;
            this.N = 0;
            this.tF = 0;
        }

        /*
         * Unable to fully structure code
         */
        public final boolean yq(byte[] var1_1, int var2_2) {
            var7_3 = this.N;
            if (var7_3 == 6) {
                return false;
            }
            var10_4 = var2_2 + 0;
            var2_2 = this.tF;
            var12_5 = this.yq;
            var11_6 = this.zH;
            var4_7 = 0;
            var3_8 = 0;
            while (true) {
                block26: {
                    block20: {
                        block32: {
                            block30: {
                                block21: {
                                    block27: {
                                        block31: {
                                            block22: {
                                                block29: {
                                                    block28: {
                                                        block23: {
                                                            block24: {
                                                                block25: {
                                                                    var6_10 = var2_2;
                                                                    var5_9 = var3_8;
                                                                    if (var4_7 >= var10_4) break;
                                                                    var6_10 = var2_2;
                                                                    var8_11 = var4_7;
                                                                    var5_9 = var3_8;
                                                                    if (var7_3 == 0) {
                                                                        while ((var6_10 = var4_7 + 4) <= var10_4) {
                                                                            var2_2 = var5_9 = var11_6[var1_1[var4_7] & 255] << 18 | var11_6[var1_1[var4_7 + 1] & 255] << 12 | var11_6[var1_1[var4_7 + 2] & 255] << 6 | var11_6[var1_1[var4_7 + 3] & 255];
                                                                            if (var5_9 < 0) break;
                                                                            var12_5[var3_8 + 2] = (byte)var5_9;
                                                                            var12_5[var3_8 + 1] = (byte)(var5_9 >> 8);
                                                                            var12_5[var3_8] = (byte)(var5_9 >> 16);
                                                                            var3_8 += 3;
                                                                            var4_7 = var6_10;
                                                                            var2_2 = var5_9;
                                                                        }
                                                                        var6_10 = var2_2;
                                                                        var8_11 = var4_7;
                                                                        var5_9 = var3_8;
                                                                        if (var4_7 >= var10_4) {
                                                                            var6_10 = var2_2;
                                                                            var5_9 = var3_8;
                                                                            break;
                                                                        }
                                                                    }
                                                                    var9_12 = var11_6[var1_1[var8_11] & 255];
                                                                    if (var7_3 == 0) break block20;
                                                                    if (var7_3 == 1) break block21;
                                                                    if (var7_3 == 2) break block22;
                                                                    if (var7_3 == 3) break block23;
                                                                    if (var7_3 == 4) break block24;
                                                                    if (var7_3 == 5) break block25;
                                                                    var2_2 = var7_3;
                                                                    var4_7 = var6_10;
                                                                    var3_8 = var5_9;
                                                                    break block26;
                                                                }
                                                                var2_2 = var7_3;
                                                                var4_7 = var6_10;
                                                                var3_8 = var5_9;
                                                                if (var9_12 == -1) break block26;
                                                                break block27;
                                                            }
                                                            if (var9_12 == -2) {
                                                                var2_2 = var7_3 + 1;
                                                                var4_7 = var6_10;
                                                                var3_8 = var5_9;
                                                            } else {
                                                                var2_2 = var7_3;
                                                                var4_7 = var6_10;
                                                                var3_8 = var5_9;
                                                                if (var9_12 != -1) lbl-1000:
                                                                // 4 sources

                                                                {
                                                                    while (true) {
                                                                        this.N = 6;
                                                                        return false;
                                                                    }
                                                                }
                                                            }
                                                            break block26;
                                                        }
                                                        if (var9_12 < 0) break block28;
                                                        var4_7 = var6_10 << 6 | var9_12;
                                                        var12_5[var5_9 + 2] = (byte)var4_7;
                                                        var12_5[var5_9 + 1] = (byte)(var4_7 >> 8);
                                                        var12_5[var5_9] = (byte)(var4_7 >> 16);
                                                        var3_8 = var5_9 + 3;
                                                        var2_2 = 0;
                                                        break block26;
                                                    }
                                                    if (var9_12 != -2) break block29;
                                                    var12_5[var5_9 + 1] = (byte)(var6_10 >> 2);
                                                    var12_5[var5_9] = (byte)(var6_10 >> 10);
                                                    var3_8 = var5_9 + 2;
                                                    var2_2 = 5;
                                                    var4_7 = var6_10;
                                                    break block26;
                                                }
                                                var2_2 = var7_3;
                                                var4_7 = var6_10;
                                                var3_8 = var5_9;
                                                if (var9_12 == -1) break block26;
                                                ** GOTO lbl-1000
                                            }
                                            if (var9_12 >= 0) break block30;
                                            if (var9_12 != -2) break block31;
                                            var12_5[var5_9] = (byte)(var6_10 >> 4);
                                            var3_8 = var5_9 + 1;
                                            var2_2 = 4;
                                            var4_7 = var6_10;
                                            break block26;
                                        }
                                        var2_2 = var7_3;
                                        var4_7 = var6_10;
                                        var3_8 = var5_9;
                                        if (var9_12 == -1) break block26;
                                    }
                                    this.N = 6;
                                    return false;
                                }
                                if (var9_12 < 0) break block32;
                            }
                            var2_2 = var9_12 | var6_10 << 6;
                            ** GOTO lbl122
                        }
                        var2_2 = var7_3;
                        var4_7 = var6_10;
                        var3_8 = var5_9;
                        if (var9_12 != -1) {
                            this.N = 6;
                            return false;
                        }
                        break block26;
                    }
                    if (var9_12 >= 0) {
                        var2_2 = var9_12;
lbl122:
                        // 2 sources

                        var3_8 = var7_3 + 1;
                        var4_7 = var2_2;
                        var2_2 = var3_8;
                        var3_8 = var5_9;
                    } else {
                        var2_2 = var7_3;
                        var4_7 = var6_10;
                        var3_8 = var5_9;
                        if (var9_12 != -1) {
                            this.N = 6;
                            return false;
                        }
                    }
                }
                var5_9 = var8_11 + 1;
                var7_3 = var2_2;
                var2_2 = var4_7;
                var4_7 = var5_9;
            }
            if (var7_3 == 1) ** GOTO lbl-1000
            if (var7_3 != 2) {
                if (var7_3 != 3) {
                    if (var7_3 != 4) ** break;
                    ** continue;
                } else {
                    var2_2 = var5_9 + 1;
                    var12_5[var5_9] = (byte)(var6_10 >> 10);
                    var5_9 = var2_2 + 1;
                    var12_5[var2_2] = (byte)(var6_10 >> 2);
                }
            } else {
                var12_5[var5_9] = (byte)(var6_10 >> 4);
                ++var5_9;
            }
            this.N = var7_3;
            this.SN = var5_9;
            return true;
        }

        private static long[] $d2j$hex$a86c6600$decode_J(String src) {
            byte[] d = SN.$d2j$hex$a86c6600$decode_B(src);
            ByteBuffer b2 = ByteBuffer.wrap(d);
            b2.order(ByteOrder.LITTLE_ENDIAN);
            LongBuffer s2 = b2.asLongBuffer();
            long[] data = new long[d.length / 8];
            s2.get(data);
            return data;
        }

        private static int[] $d2j$hex$a86c6600$decode_I(String src) {
            byte[] d = SN.$d2j$hex$a86c6600$decode_B(src);
            ByteBuffer b2 = ByteBuffer.wrap(d);
            b2.order(ByteOrder.LITTLE_ENDIAN);
            IntBuffer s2 = b2.asIntBuffer();
            int[] data = new int[d.length / 4];
            s2.get(data);
            return data;
        }

        private static short[] $d2j$hex$a86c6600$decode_S(String src) {
            byte[] d = SN.$d2j$hex$a86c6600$decode_B(src);
            ByteBuffer b2 = ByteBuffer.wrap(d);
            b2.order(ByteOrder.LITTLE_ENDIAN);
            ShortBuffer s2 = b2.asShortBuffer();
            short[] data = new short[d.length / 2];
            s2.get(data);
            return data;
        }

        private static byte[] $d2j$hex$a86c6600$decode_B(String src) {
            char[] d = src.toCharArray();
            byte[] ret = new byte[src.length() / 2];
            for (int i2 = 0; i2 < ret.length; ++i2) {
                int ll;
                int hh;
                char h = d[2 * i2];
                char l = d[2 * i2 + 1];
                if (h >= '0' && h <= '9') {
                    hh = h - 48;
                } else if (h >= 'a' && h <= 'f') {
                    hh = h - 97 + 10;
                } else if (h >= 'A' && h <= 'F') {
                    hh = h - 65 + 10;
                } else {
                    throw new RuntimeException();
                }
                if (l >= '0' && l <= '9') {
                    ll = l - 48;
                } else if (l >= 'a' && l <= 'f') {
                    ll = l - 97 + 10;
                } else if (l >= 'A' && l <= 'F') {
                    ll = l - 65 + 10;
                } else {
                    throw new RuntimeException();
                }
                ret[i2] = (byte)(hh << 4 | ll);
            }
            return ret;
        }
    }

    static abstract class yq {
        public int SN;
        public byte[] yq;

        yq() {
        }
    }
}

