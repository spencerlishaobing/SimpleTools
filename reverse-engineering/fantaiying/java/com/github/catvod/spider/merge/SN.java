/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.mt_0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public final class SN {
    private static final int[] Gc;
    private static final int[] M;
    private static final byte[] t0;
    private int N;
    private int[][] SN = null;
    private int i;
    private int tF;
    private int yq;
    private int zH;

    static {
        t0 = new byte[]{99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, -128, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, 127, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, -68, -74, -38, 33, 16, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22};
        Gc = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};
        M = com.github.catvod.spider.merge.SN.$d2j$hex$f5d1ab71$decode_I("c66363a5f87c7c84ee777799f67b7b8dfff2f20dd66b6bbdde6f6fb191c5c5546030305002010103ce6767a9562b2b7de7fefe19b5d7d7624dababe6ec76769a8fcaca451f82829d89c9c940fa7d7d87effafa15b25959eb8e4747c9fbf0f00b41adadecb3d4d4675fa2a2fd45afafea239c9cbf53a4a4f7e47272969bc0c05b75b7b7c2e1fdfd1c3d9393ae4c26266a6c36365a7e3f3f41f5f7f70283cccc4f6834345c51a5a5f4d1e5e534f9f1f108e2717193abd8d873623131532a15153f0804040c95c7c752462323659dc3c35e30181828379696a10a05050f2f9a9ab50e070709241212361b80809bdfe2e23dcdebeb264e2727697fb2b2cdea75759f1209091b1d83839e582c2c74341a1a2e361b1b2ddc6e6eb2b45a5aee5ba0a0fba45252f6763b3b4db7d6d6617db3b3ce5229297bdde3e33e5e2f2f7113848497a65353f5b9d1d16800000000c1eded2c40202060e3fcfc1f79b1b1c8b65b5bedd46a6abe8dcbcb4667bebed97239394b944a4ade984c4cd4b05858e885cfcf4abbd0d06bc5efef2a4faaaae5edfbfb16864343c59a4d4dd766333355118585948a4545cfe9f9f91004020206fe7f7f81a05050f0783c3c44259f9fba4ba8a8e3a25151f35da3a3fe804040c0058f8f8a3f9292ad219d9dbc70383848f1f5f50463bcbcdf77b6b6c1afdada754221216320101030e5ffff1afdf3f30ebfd2d26d81cdcd4c180c0c1426131335c3ecec2fbe5f5fe1359797a2884444cc2e17173993c4c45755a7a7f2fc7e7e827a3d3d47c86464acba5d5de73219192be6737395c06060a0198181989e4f4fd1a3dcdc7f44222266542a2a7e3b9090ab0b8888838c4646cac7eeee296bb8b8d32814143ca7dede79bc5e5ee2160b0b1daddbdb76dbe0e03b64323256743a3a4e140a0a1e924949db0c06060a4824246cb85c5ce49fc2c25dbdd3d36e43acacefc46262a6399191a8319595a4d3e4e437f279798bd5e7e7328bc8c8436e373759da6d6db7018d8d8cb1d5d5649c4e4ed249a9a9e0d86c6cb4ac5656faf3f4f407cfeaea25ca6565aff47a7a8e47aeaee9100808186fbabad5f07878884a25256f5c2e2e72381c1c2457a6a6f173b4b4c797c6c651cbe8e823a1dddd7ce874749c3e1f1f21964b4bdd61bdbddc0d8b8b860f8a8a85e07070907c3e3e4271b5b5c4cc6666aa904848d806030305f7f6f6011c0e0e12c26161a36a35355fae5757f969b9b9d01786869199c1c1583a1d1d27279e9eb9d9e1e138ebf8f8132b9898b322111133d26969bba9d9d970078e8e89339494a72d9b9bb63c1e1e2215878792c9e9e92087cece49aa5555ff50282878a5dfdf7a038c8c8f59a1a1f8098989801a0d0d1765bfbfdad7e6e631844242c6d06868b8824141c3299999b05a2d2d771e0f0f117bb0b0cba85454fc6dbbbbd62c16163a");
    }

    public SN(byte[] object) {
        int n2 = ((byte[])object).length / 4;
        if ((n2 == 4 || n2 == 6 || n2 == 8) && n2 * 4 == ((byte[])object).length) {
            int n3;
            this.yq = n3 = n2 + 6;
            int n4 = 0;
            int[][] nArray = new int[n3 + 1][4];
            n3 = 0;
            while (n4 < ((byte[])object).length) {
                nArray[n3 >> 2][n3 & 3] = object[n4] & 0xFF | (object[n4 + 1] & 0xFF) << 8 | (object[n4 + 2] & 0xFF) << 16 | object[n4 + 3] << 24;
                n4 += 4;
                ++n3;
            }
            int n5 = this.yq;
            for (n4 = n2; n4 < n5 + 1 << 2; ++n4) {
                n3 = n4 - 1;
                int n7 = nArray[n3 >> 2][n3 & 3];
                int n8 = n4 % n2;
                if (n8 == 0) {
                    n3 = this.SN(n7 << -8 | n7 >>> 8) ^ Gc[n4 / n2 - 1];
                } else {
                    n3 = n7;
                    if (n2 > 6) {
                        n3 = n7;
                        if (n8 == 4) {
                            n3 = this.SN(n7);
                        }
                    }
                }
                object = nArray[n4 >> 2];
                n7 = n4 - n2;
                object[n4 & 3] = n3 ^ nArray[n7 >> 2][n7 & 3];
            }
            this.SN = nArray;
            return;
        }
        object = new mt_0("invalid key length (not 128/192/256)");
        throw object;
    }

    private int SN(int n2) {
        byte[] byArray = t0;
        byte by2 = byArray[n2 & 0xFF];
        byte by3 = byArray[n2 >> 8 & 0xFF];
        byte by4 = byArray[n2 >> 16 & 0xFF];
        return byArray[n2 >> 24 & 0xFF] << 24 | (by2 & 0xFF | (by3 & 0xFF) << 8 | (by4 & 0xFF) << 16);
    }

    public final void yq(byte[] object, byte[] byArray) {
        int[][] nArray = this.SN;
        if (nArray != null) {
            if (16 <= ((byte[])object).length) {
                if (16 <= byArray.length) {
                    byte by2;
                    byte by3;
                    byte by4;
                    int n2;
                    int n3;
                    int n4;
                    int n5;
                    int n7;
                    int n8;
                    int n9;
                    int n10;
                    this.N = n10 = object[0] & 0xFF;
                    this.N = n10 |= (object[1] & 0xFF) << 8;
                    this.N = n10 |= (object[2] & 0xFF) << 16;
                    this.N = n10 |= object[3] << 24;
                    this.tF = n9 = object[4] & 0xFF;
                    this.tF = n9 |= (object[5] & 0xFF) << 8;
                    this.tF = n9 |= (object[6] & 0xFF) << 16;
                    this.tF = n9 |= object[7] << 24;
                    this.zH = n8 = object[8] & 0xFF;
                    this.zH = n8 = (object[9] & 0xFF) << 8 | n8;
                    this.zH = n8 |= (object[10] & 0xFF) << 16;
                    this.zH = n8 |= object[11] << 24;
                    this.i = n7 = object[12] & 0xFF;
                    this.i = n7 = (object[13] & 0xFF) << 8 | n7;
                    this.i = n7 |= (object[14] & 0xFF) << 16;
                    this.i = n7 = object[15] << 24 | n7;
                    this.N = n10 ^ nArray[0][0];
                    this.tF = nArray[0][1] ^ n9;
                    this.zH = nArray[0][2] ^ n8;
                    this.i = n7 ^ nArray[0][3];
                    n10 = 1;
                    while (n10 < this.yq - 1) {
                        object = M;
                        n5 = this.N;
                        n9 = object[n5 & 0xFF];
                        n4 = this.tF;
                        n7 = object[n4 >> 8 & 0xFF];
                        n3 = this.zH;
                        n8 = object[n3 >> 16 & 0xFF];
                        n2 = this.i;
                        by4 = object[n2 >> 24 & 0xFF];
                        n9 = (by4 << -8 | by4 >>> 8) ^ ((n8 << -16 | n8 >>> 16) ^ (n9 ^ (n7 << -24 | n7 >>> 24))) ^ nArray[n10][0];
                        n8 = object[n4 & 0xFF];
                        by4 = object[n3 >> 8 & 0xFF];
                        by3 = object[n2 >> 16 & 0xFF];
                        n7 = object[n5 >> 24 & 0xFF];
                        n8 = (by4 << -24 | by4 >>> 24) ^ n8 ^ (by3 << -16 | by3 >>> 16) ^ (n7 << -8 | n7 >>> 8) ^ nArray[n10][1];
                        by4 = object[n3 & 0xFF];
                        by3 = object[n2 >> 8 & 0xFF];
                        by2 = object[n5 >> 16 & 0xFF];
                        n7 = object[n4 >> 24 & 0xFF];
                        n7 = (by3 << -24 | by3 >>> 24) ^ by4 ^ (by2 << -16 | by2 >>> 16) ^ (n7 << -8 | n7 >>> 8) ^ nArray[n10][2];
                        n2 = object[n2 & 0xFF];
                        n5 = object[n5 >> 8 & 0xFF];
                        n4 = object[n4 >> 16 & 0xFF];
                        by4 = object[n3 >> 24 & 0xFF];
                        n3 = n10 + 1;
                        n10 = nArray[n10][3] ^ (n2 ^ (n5 << -24 | n5 >>> 24) ^ (n4 << -16 | n4 >>> 16) ^ (by4 << -8 | by4 >>> 8));
                        n5 = object[n9 & 0xFF];
                        by4 = object[n8 >> 8 & 0xFF];
                        n2 = object[n7 >> 16 & 0xFF];
                        n4 = object[n10 >> 24 & 0xFF];
                        this.N = n5 ^ (by4 << -24 | by4 >>> 24) ^ (n2 << -16 | n2 >>> 16) ^ (n4 << -8 | n4 >>> 8) ^ nArray[n3][0];
                        n5 = object[n8 & 0xFF];
                        by4 = object[n7 >> 8 & 0xFF];
                        n2 = object[n10 >> 16 & 0xFF];
                        n4 = object[n9 >> 24 & 0xFF];
                        this.tF = n5 ^ (by4 << -24 | by4 >>> 24) ^ (n2 << -16 | n2 >>> 16) ^ (n4 << -8 | n4 >>> 8) ^ nArray[n3][1];
                        n4 = object[n7 & 0xFF];
                        n2 = object[n10 >> 8 & 0xFF];
                        by4 = object[n9 >> 16 & 0xFF];
                        n5 = object[n8 >> 24 & 0xFF];
                        this.zH = n4 ^ (n2 << -24 | n2 >>> 24) ^ (by4 << -16 | by4 >>> 16) ^ (n5 << -8 | n5 >>> 8) ^ nArray[n3][2];
                        n10 = object[n10 & 0xFF];
                        n9 = object[n9 >> 8 & 0xFF];
                        n8 = object[n8 >> 16 & 0xFF];
                        n7 = object[n7 >> 24 & 0xFF];
                        this.i = n10 ^ (n9 << -24 | n9 >>> 24) ^ (n8 << -16 | n8 >>> 16) ^ (n7 << -8 | n7 >>> 8) ^ nArray[n3][3];
                        n10 = n3 + 1;
                    }
                    object = M;
                    n4 = this.N;
                    n9 = object[n4 & 0xFF];
                    n7 = this.tF;
                    n2 = object[n7 >> 8 & 0xFF];
                    n8 = this.zH;
                    by4 = object[n8 >> 16 & 0xFF];
                    n5 = this.i;
                    n3 = object[n5 >> 24 & 0xFF];
                    n9 = n9 ^ (n2 << -24 | n2 >>> 24) ^ (by4 << -16 | by4 >>> 16) ^ (n3 << -8 | n3 >>> 8) ^ nArray[n10][0];
                    n2 = object[n7 & 0xFF];
                    by4 = object[n8 >> 8 & 0xFF];
                    by3 = object[n5 >> 16 & 0xFF];
                    n3 = object[n4 >> 24 & 0xFF];
                    n3 = n2 ^ (by4 << -24 | by4 >>> 24) ^ (by3 << -16 | by3 >>> 16) ^ (n3 << -8 | n3 >>> 8) ^ nArray[n10][1];
                    by3 = object[n8 & 0xFF];
                    by2 = object[n5 >> 8 & 0xFF];
                    by4 = object[n4 >> 16 & 0xFF];
                    n2 = object[n7 >> 24 & 0xFF];
                    n2 = by3 ^ (by2 << -24 | by2 >>> 24) ^ (by4 << -16 | by4 >>> 16) ^ (n2 << -8 | n2 >>> 8) ^ nArray[n10][2];
                    n5 = object[n5 & 0xFF];
                    n4 = object[n4 >> 8 & 0xFF];
                    n7 = object[n7 >> 16 & 0xFF];
                    by4 = object[n8 >> 24 & 0xFF];
                    n8 = n10 + 1;
                    n5 = nArray[n10][3] ^ ((by4 << -8 | by4 >>> 8) ^ ((n4 << -24 | n4 >>> 24) ^ n5 ^ (n7 << -16 | n7 >>> 16)));
                    object = t0;
                    this.N = n10 = object[n9 & 0xFF] & 0xFF ^ (object[n3 >> 8 & 0xFF] & 0xFF) << 8 ^ (object[n2 >> 16 & 0xFF] & 0xFF) << 16 ^ object[n5 >> 24 & 0xFF] << 24 ^ nArray[n8][0];
                    this.tF = n4 = object[n3 & 0xFF] & 0xFF ^ (object[n2 >> 8 & 0xFF] & 0xFF) << 8 ^ (object[n5 >> 16 & 0xFF] & 0xFF) << 16 ^ object[n9 >> 24 & 0xFF] << 24 ^ nArray[n8][1];
                    this.zH = n7 = object[n2 & 0xFF] & 0xFF ^ (object[n5 >> 8 & 0xFF] & 0xFF) << 8 ^ (object[n9 >> 16 & 0xFF] & 0xFF) << 16 ^ object[n3 >> 24 & 0xFF] << 24 ^ nArray[n8][2];
                    this.i = n9 = object[n5 & 0xFF] & 0xFF ^ (object[n9 >> 8 & 0xFF] & 0xFF) << 8 ^ (object[n3 >> 16 & 0xFF] & 0xFF) << 16 ^ object[n2 >> 24 & 0xFF] << 24 ^ nArray[n8][3];
                    byArray[0] = (byte)n10;
                    byArray[1] = (byte)(n10 >> 8);
                    byArray[2] = (byte)(n10 >> 16);
                    byArray[3] = (byte)(n10 >> 24);
                    byArray[4] = (byte)n4;
                    byArray[5] = (byte)(n4 >> 8);
                    byArray[6] = (byte)(n4 >> 16);
                    byArray[7] = (byte)(n4 >> 24);
                    byArray[8] = (byte)n7;
                    byArray[9] = (byte)(n7 >> 8);
                    byArray[10] = (byte)(n7 >> 16);
                    byArray[11] = (byte)(n7 >> 24);
                    byArray[12] = (byte)n9;
                    byArray[13] = (byte)(n9 >> 8);
                    byArray[14] = (byte)(n9 >> 16);
                    byArray[15] = (byte)(n9 >> 24);
                    return;
                }
                throw new mt_0("output buffer too short");
            }
            throw new mt_0("input buffer too short");
        }
        object = new mt_0("AES engine not initialised");
        throw object;
    }

    private static long[] $d2j$hex$f5d1ab71$decode_J(String src) {
        byte[] d = com.github.catvod.spider.merge.SN.$d2j$hex$f5d1ab71$decode_B(src);
        ByteBuffer b2 = ByteBuffer.wrap(d);
        b2.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b2.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$f5d1ab71$decode_I(String src) {
        byte[] d = com.github.catvod.spider.merge.SN.$d2j$hex$f5d1ab71$decode_B(src);
        ByteBuffer b2 = ByteBuffer.wrap(d);
        b2.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b2.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$f5d1ab71$decode_S(String src) {
        byte[] d = com.github.catvod.spider.merge.SN.$d2j$hex$f5d1ab71$decode_B(src);
        ByteBuffer b2 = ByteBuffer.wrap(d);
        b2.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b2.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$f5d1ab71$decode_B(String src) {
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

