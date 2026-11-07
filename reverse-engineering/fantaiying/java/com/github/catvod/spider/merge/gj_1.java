/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  com.github.catvod.spider.merge.gJ
 */
package com.github.catvod.spider.merge;

import android.util.Base64;
import com.github.catvod.spider.merge.ZV;
import com.github.catvod.spider.merge.gJ;
import com.github.catvod.spider.merge.rs_1;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Renamed from com.github.catvod.spider.merge.gJ
 */
public final class gj_1 {
    private static final byte[] Gc;
    private static final String KJ;
    private static final byte[] M;
    private static final byte[] N;
    private static final int[] SN;
    private static final byte[] i;
    private static final long q;
    private static final byte[] t0;
    private static final byte[] tF;
    private static final SecureRandom yq;
    private static final byte[] zH;

    static {
        SecureRandom secureRandom;
        yq = secureRandom = new SecureRandom();
        SN = new int[]{-1481703904, 1900671446, 1206176263, -373977241, -1816582946, -971714315, 951050479, -1296323213, -498842429, -1657082725, -545572892, -659460800, -122932808, 1991878923, 836252654, -1790980508, 892704164, 1175044411, 915558408, -1939011291, 1576386935, 486274347, -1974491152, 290235230, -2121008764, 2054850355, 829076693, 1008783305, -1495776173, 974671884, 2039399546, -1750635736, 1724186518, 1366385731, 231930939, -1251381849, -1142211899, 1548997124, -752482098, 1920580076, -199717169, -136866853, 858571921, -1418285547, -1679038681, 413143940, 1542060199, 1603315540, 968254400, 912735363, 2090005780, -1652714281, -488056406, 1602133673, 2059224401, 1453196762, 1084380722, 1039509925, -1162642048, 1161987804, 1063079544, 64468829, -1308734729, -1515510109};
        N = ZV.SN("0f0704000908030a060b050d0e010c020f05080c0009020103070e060b0a0d04060500070c000a04080f010b0d09020e060b02050403080101070a000d0c090e0d070e0f0b0208030c0509010004060a0d0902060f0b0a040807000c0503010e0c090f07060f030e020d0405010b0a000c050a090e0802040407030f01060b000b0f0408020a0700090d06010e03050c0b060a0508020c03070f0e090d0001040906080f050800040a0b030d01020c0e090d0c0604070a03030f00080105020e01000d0f090a0b0e0402080703060c0501080a0c0f0905060b000304020e070d04080f000c0f0e0d0a01060207090503040205080d0b0a0606000e0f070c09030a08040f000b01060d0c0709030e05020a070b050f00020e0108030d0c0609040d070f08050f06040b0a0e0c090002030d0c020704010b0e0e08060f09050003");
        tF = Base64.decode((String)"+n0Ia5xZs0sEXznQOEqRmQBnpiCf9U2Ccybu3xhmgzOAAxn72f6uqqmwUsYL83klTni0NqxdGieeiNu9PGPsSRXBMB/cuFbUbM3KCUPINaPvHvSW0vwOcnuUhNHqRVpiAj/TEoE0K91+5ijypUYTATsh9mE3KSoN7Yyvv51cuyR2D3XkU4nhmI2xmmVwT1RMWKtub4sjxAcRDLrPoKSO2AU9FLLadMPX577Wf95IFj6FkKFVt3dCIsmGUC4X+WQxLJvxbRxEaOPpqJOXyzJX6+Vxaq3AzMfF/WAdoi1Hp+JRaV56zgpBtpWP97mH4DoGEIq1+FvV8LyS/3wvwugbQOwb2r26mJEMsiuDQTRn+wrYdrVGBVlhI3WQhyrjUBVMrLF5667llUcEaPCGPVGLD8qO5LlO8hKCvA7V9+8oJc9bXelqVQLhM76T5/WtnT45JKji+hdX0HoNCDDWuKON/QeaxB5uImSX0h2wv0VmP2zd2yeApxHcpsVS+MC2yFwAc2B7oBkTqsk1SEvTpM2fmfMQREBUfin0Bh+iq6EvPPavhWI2IX9e3yAas7Tm/3KEj2UmlFp36kN4x0rMLBRrxuh0U/zUHM4xcAMYjJY4MonxOl/X+alpt2M3WMI7w3HLnpIBigtNiJu7T21v4P6lSd5WFgntnMEt7oF92XzRLkJbTcGmXepE/UVOG6E/0YnhfS+q26utWcuxzpooyeD2cDlK1/8w9d28VzsRjbLuALbmGlp8+d7EzS6Au7lMpZ+ECMZvQmzwJ+eLOpxR+2chdUExp8ogQyq3v9l68rX4jCwjg0+PYKAEEzcU4wHFY2ZcdIHfWL1okD3SszT0GZMyKdZJrg1L2AeerB4tC0C4crp2EHGo5FYdSP7lwkeR2ocmnR+Ia8CYviUJlzOjhRZef9xuVOn3qcjow3fQgivsAmKKkg4+sA8F8/GWeDiGNhg8JM8KtFPMYWWkx5TVFX5t73kiNRJqjlIGVXtGZFCV4gzt0xcDopuZ6xz8r9Rzafpf9ywev8jh8592gHFIqpStZPuJxmDDMrNN0uBE3V+oscdoIzTJbRJ/t+sVvqnReJOgDJKk10fjisJwqyZBmnmn2BSFj8BvVtCMEbkuPOKdzw7eA11GPs04Qw8zWtkaZWwiO/wwpojqN6K0jY5RnNZA7vn4hPSul+nKCkVnVwQvg1zVxcSCtqORmB9KrJaBbssbCQivGJVJfVTt+hYxOtq4ZvWl8f4QAQZ0zGPffCgl9s6yT4vlvIdpu4YhBwA25wtQWZsc6GJYGWHyvSdeuh3mmUI9DSq13Fsp8C1MU3tqc04/df9LoTUXVXI5INOw/e8C7Hd+5CvbkMEFnnrUUmskEw==", (int)0);
        zH = ZV.SN("8ebdfa3806ecc5cee79423e6029ed82540bc2218bb7eaef71cb691f7aa8aa2f5");
        i = ZV.SN("f1593376766ea98d34f31b057a9d5be4");
        t0 = ZV.SN("1fe109a4125283f418de9e051a969e12");
        Gc = ZV.SN("f7e85ffad7d7dc3bd62ac87057cf6118");
        M = ZV.SN("4001000000000000");
        byte[] byArray = new byte[18];
        secureRandom.nextBytes(byArray);
        KJ = Base64.encodeToString((byte[])byArray, (int)11);
        q = System.currentTimeMillis();
    }

    private static byte[] B(int n2) {
        byte[] byArray = new byte[4];
        gj_1.W(byArray, 0, n2);
        return byArray;
    }

    private static byte[] F5(Object[][] objectArray) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (Object object : objectArray) {
            Object object2 = ((Object[])object).length > 2 ? String.valueOf(object[2]) : "string";
            long l = ((Number)object[0]).longValue();
            if ((object = object[1]) == null || "string".equals(object2) && "".equals(object)) {
                object2 = new byte[0];
            } else {
                if ("bytes".equals(object2)) {
                    object2 = (byte[])object;
                    object = gj_1.Gc(gj_1.g1(l << 3 | 2L), gj_1.g1(((Object)object2).length));
                } else if ("message".equals(object2)) {
                    object2 = (byte[])object;
                    object = gj_1.Gc(gj_1.g1(l << 3 | 2L), gj_1.g1(((Object)object2).length));
                } else if ("string".equals(object2)) {
                    object2 = String.valueOf(object).getBytes(StandardCharsets.UTF_8);
                    object = gj_1.Gc(gj_1.g1(l << 3 | 2L), gj_1.g1(((Object)object2).length));
                } else if ("float".equals(object2)) {
                    object2 = new byte[4];
                    gj_1.W((byte[])object2, 0, Float.floatToIntBits(((Number)object).floatValue()));
                    object = gj_1.g1(l << 3 | 5L);
                } else {
                    long l2 = ((Number)object).longValue();
                    object = gj_1.g1(l << 3);
                    l = l2;
                    if ("sint".equals(object2)) {
                        l = l2 < 0L ? -l2 * 2L - 1L : l2 * 2L;
                    }
                    object2 = gj_1.g1(l);
                }
                object2 = gj_1.Gc((byte[])object, (byte[])object2);
            }
            arrayList.add(object2);
        }
        return gj_1.Gc((byte[][])arrayList.toArray((T[])new byte[0][]));
    }

    private static byte[] G(byte[] byArray) {
        int n2 = ZV.SN;
        try {
            byArray = MessageDigest.getInstance("MD5").digest(byArray);
            return byArray;
        }
        catch (Exception exception) {
            throw new RuntimeException("MD5 \u4e0d\u53ef\u7528", exception);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int G4(int n2, int n3, int n4, int n5, int n7, int n8, int n9, int n10) {
        if (n2 == 0) {
            n2 = n4 & n5;
            n5 = ~n4;
            return n4 + gj_1.xa(n3 + (n2 |= n5 & n7) + n8 + n10, n9);
        }
        if (n2 == 1) {
            n2 = n4 & n7;
            n7 ^= 0xFFFFFFFF;
            return n4 + gj_1.xa(n3 + (n2 |= n5 & n7) + n8 + n10, n9);
        }
        if (n2 == 2) {
            n2 = n4 ^ n5 ^ n7;
            return n4 + gj_1.xa(n3 + n2 + n8 + n10, n9);
        }
        n2 = (~n7 | n4) ^ n5;
        return n4 + gj_1.xa(n3 + n2 + n8 + n10, n9);
    }

    private static byte[] Gc(byte[] ... byArray) {
        int n2;
        int n3 = byArray.length;
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            n4 += byArray[n2].length;
        }
        byte[] byArray2 = new byte[n4];
        n3 = byArray.length;
        n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            byte[] byArray3 = byArray[n2];
            System.arraycopy(byArray3, 0, byArray2, n4, byArray3.length);
            n4 += byArray3.length;
        }
        return byArray2;
    }

    private static int Gd(int n2) {
        return (n2 >>> 5 | n2 << 3) & 0xFF;
    }

    private static int KJ(int n2, byte[] byArray) {
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            int n3 = byArray[i2] & 0xFF;
            n2 = (i2 & 1) == 0 ? n2 << 6 ^ (n2 >>> 4 ^ n2) ^ n3 : ~((n2 << 12 | n3) ^ (n2 >>> 7 ^ n2));
        }
        return n2;
    }

    private static byte[] M(String string) {
        Integer n2 = 36;
        Integer n3 = 3;
        Integer n4 = 1;
        Integer n5 = 0;
        Object[] objectArray = Integer.valueOf(2);
        Object[] objectArray2 = new Object[]{objectArray, objectArray, "sint"};
        Integer n7 = 4;
        Object[] objectArray3 = new Object[]{5, KJ};
        objectArray = new Object[]{6, "!noperm!"};
        Integer n8 = -888888;
        Object[] objectArray4 = new Object[]{7, n8, "sint"};
        Object[] objectArray5 = new Object[]{10, n8, "sint"};
        Object[] objectArray6 = new Object[]{13, "zh_CN"};
        Object[] objectArray7 = new Object[]{14, n7, "sint"};
        Object[] objectArray8 = new Object[]{18, n5, "float"};
        Object[] objectArray9 = new Object[]{20, n5, "float"};
        Object[] objectArray10 = new Object[]{24, n2, "sint"};
        long l = q;
        Object[] objectArray11 = new Object[]{25, l, "sint"};
        Object[] objectArray12 = new Object[]{27, l, "sint"};
        Object[] objectArray13 = new Object[]{28, l, "sint"};
        Object[] objectArray14 = new Object[]{29, -1, "sint"};
        Object[] objectArray15 = new Object[]{30, "25053RT47C"};
        Integer n9 = 31;
        Object[] objectArray16 = new Object[]{n9, "Redmi"};
        Object[] objectArray17 = new Object[]{32, "25053RT47C"};
        Object[] objectArray18 = new Object[]{33, "25053RT47C"};
        Object[] objectArray19 = new Object[]{35, "Redmi"};
        return gj_1.F5(new Object[][]{{n4, n4, "sint"}, objectArray2, {n3, "8662"}, {n7, string}, objectArray3, objectArray, objectArray4, {8, n8, "sint"}, {9, n3, "sint"}, objectArray5, {11, "!notset!"}, {12, "Asia/Shanghai,8"}, objectArray6, objectArray7, {16, n5, "float"}, {17, n5, "float"}, objectArray8, {19, n5, "float"}, objectArray9, {21, n5, "float"}, {22, "16"}, {23, 41, "sint"}, objectArray10, objectArray11, {26, l, "sint"}, objectArray12, objectArray13, objectArray14, objectArray15, objectArray16, objectArray17, objectArray18, {34, "Xiaomi"}, objectArray19, {n2, "Redmi"}, {38, n9, "sint"}});
    }

    static /* synthetic */ void N(byte[] byArray, int n2, int n3) {
        gj_1.W(byArray, n2, n3);
    }

    public static Map<String, String> Nl(String string, byte[] byArray, long l) {
        int n2;
        int n3;
        int n4 = yq.nextInt(65536);
        String string2 = gj_1.v(string);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        Object[] objectArray = gj_1.OW(gj_1.G(string2.getBytes(StandardCharsets.UTF_8)), 0, 4);
        Object object = byArray != null && byArray.length > 0 ? gj_1.OW(gj_1.G(byArray), 0, 4) : new byte[4];
        byte[] byArray2 = gj_1.B(0x4060400);
        Object object2 = new byte[4];
        int n5 = (int)l;
        byte[] byArray3 = new byte[4];
        gj_1.v3(byArray3, 0, n5);
        objectArray = gj_1.Gc(new byte[][]{objectArray, object, object2, byArray2, byArray3});
        int n7 = n4 >> 8 & 0xFF;
        int n8 = n4 & 0xFF;
        object = new int[256];
        for (n4 = 0; n4 < 256; ++n4) {
            object[n4] = n4;
        }
        int n9 = 0;
        for (n4 = 0; n4 < 256; ++n4) {
            n9 = n9 + object[n4] + (new int[]{74, 64, 22, n7, 71, 108, 1, n8})[n4 % 8] & 0xFF;
            object[n4] = object[n9];
        }
        int n10 = objectArray.length;
        object2 = new byte[n10];
        int n11 = 0;
        n9 = 0;
        for (n4 = 0; n4 < objectArray.length; ++n4) {
            object[n11] = n3 = object[(n9 += object[++n11]) & 0xFF];
            n2 = objectArray[n4];
            object2[n4] = (byte)(object[n3 + n3 & 0xFF] ^ n2);
        }
        n4 = 0;
        while (n4 < n10) {
            int n12 = object2[n4] & 0xFF;
            n2 = n4 + 1;
            n9 = n2 < n10 ? object2[n2] : object2[0];
            n3 = 0;
            for (n11 = 0; n11 < 8; ++n11) {
                n3 = (((n12 >>> 4 | n12 << 4) & 0xFF ^ n9 & 0xFF) & 0xFF) >> n11 & 1 | n3 << 1;
            }
            object2[n4] = (byte)(~(n3 ^ 0x14) & 0xFF);
            n4 = n2;
        }
        linkedHashMap.put("x-gorgon", ZV.yq(gj_1.Gc(new byte[][]{ZV.SN("8404"), {(byte)n8, (byte)n7, 64, 1}, object2})));
        linkedHashMap.put("x-khronos", String.valueOf(l));
        object = new byte[4];
        gj_1.v3(object, 0, n5);
        linkedHashMap.put("x-ladon", Base64.encodeToString((byte[])object, (int)2));
        linkedHashMap.put("x-argus", Base64.encodeToString((byte[])gj_1.B(n5), (int)2));
        n11 = yq.nextInt();
        objectArray = gj_1.G(gj_1.Gc(gj_1.B(n11), "8662".getBytes(StandardCharsets.UTF_8)));
        object = new StringBuilder(32);
        n9 = objectArray.length;
        for (n4 = 0; n4 < n9; ++n4) {
            object.append(String.format("%02x", objectArray[n4]));
        }
        objectArray = object.toString().getBytes(StandardCharsets.US_ASCII);
        object = new long[4];
        for (n4 = 0; n4 < 4; ++n4) {
            object[n4] = (byte)gj_1.ee(objectArray, n4 * 8);
        }
        object2 = new ArrayDeque();
        ((ArrayDeque)object2).addLast(Long.valueOf(object[2]));
        ((ArrayDeque)object2).addLast(Long.valueOf(object[3]));
        byte by2 = object[0];
        int n13 = object[1];
        objectArray = new long[35];
        objectArray[0] = object[0];
        n4 = 0;
        while (n4 < 34) {
            n13 = (int)(Long.rotateRight(n13, 8) + by2 ^ (long)n4);
            ((ArrayDeque)object2).addLast(Long.valueOf(n13));
            by2 = (byte)(Long.rotateRight(by2, 61) ^ n13);
            objectArray[++n4] = by2;
            n13 = (int)((Long)((ArrayDeque)object2).pollFirst()).longValue();
        }
        object = new StringBuilder();
        object.append(l);
        object.append("-1588093228-8662");
        object2 = object.toString().getBytes(StandardCharsets.UTF_8);
        n3 = (((byte[])object2).length + 1 + 15) / 16 * 16;
        object = new byte[n3];
        Arrays.fill(object, (byte)(16 - ((Object)object2).length % 16));
        System.arraycopy(object2, 0, object, 0, ((Object)object2).length);
        object2 = new ArrayList();
        for (n4 = 0; n4 < n3; n4 += 16) {
            by2 = (byte)gj_1.ee(object, n4);
            n13 = (int)gj_1.ee(object, n4 + 8);
            for (n9 = 0; n9 < 34; ++n9) {
                n13 = objectArray[n9] ^ Long.rotateRight(n13, 8) + by2;
                by2 = (byte)(Long.rotateRight(by2, 61) ^ n13);
            }
            byArray3 = new byte[16];
            for (n9 = 0; n9 < 8; ++n9) {
                byArray3[0 + n9] = (byte)(by2 >>> n9 * 8);
            }
            for (n9 = 0; n9 < 8; ++n9) {
                byArray3[8 + n9] = (byte)(n13 >>> n9 * 8);
            }
            ((ArrayList)object2).add(byArray3);
        }
        object = new ArrayList();
        object.add(gj_1.B(n11));
        object.addAll(object2);
        linkedHashMap.put("x-helios", Base64.encodeToString((byte[])gj_1.Gc((byte[][])object.toArray((T[])new byte[0][])), (int)2));
        linkedHashMap.put("x-medusa", gj_1.t0(string, byArray, l, gj_1.dT(string2, "device_id", "0"), gj_1.dT(string2, "version_name", "7.1.3.32")));
        return linkedHashMap;
    }

    private static int O(byte[] byArray) {
        int n2 = 0x20220420;
        for (int i2 = 0; i2 < 12; ++i2) {
            int n3 = i2 & 1;
            int n4 = n3 == 0 ? n2 >>> 3 : n2 >>> 5;
            int n5 = n3 == 0 ? n2 << 7 ^ byArray[i2] & 0xFF : n2 << 11 | byArray[i2] & 0xFF;
            int n7 = n5;
            if (n3 != 0) {
                n7 = ~n5;
            }
            n2 = n7 ^ (n4 ^ n2);
        }
        return (n2 | 4) ^ 0x1000000;
    }

    private static byte[] OW(byte[] byArray, int n2, int n3) {
        byte[] byArray2 = new byte[n3 -= n2];
        System.arraycopy(byArray, n2, byArray2, 0, n3);
        return byArray2;
    }

    static /* synthetic */ byte[] SN(byte[] byArray, int n2, int n3) {
        return gj_1.OW(byArray, n2, n3);
    }

    private static void W(byte[] byArray, int n2, int n3) {
        byArray[n2] = (byte)n3;
        byArray[n2 + 1] = (byte)(n3 >>> 8);
        byArray[n2 + 2] = (byte)(n3 >>> 16);
        byArray[n2 + 3] = (byte)(n3 >>> 24);
    }

    private static String dT(String stringArray, String string, String string2) {
        for (String string3 : stringArray.split("&")) {
            int n2 = string3.indexOf(61);
            if (n2 <= 0 || !string3.substring(0, n2).equals(string) || (string3 = string3.substring(n2 + 1)).isEmpty()) continue;
            return string3;
        }
        return string2;
    }

    private static long ee(byte[] byArray, int n2) {
        long l = 0L;
        for (int i2 = 7; i2 >= 0; --i2) {
            l = l << 8 | (long)byArray[n2 + i2] & 0xFFL;
        }
        return l;
    }

    private static byte[] g1(long l) {
        ArrayList<Byte> arrayList = new ArrayList<Byte>();
        while (l > 127L) {
            arrayList.add((byte)(0x7FL & l | 0x80L));
            l >>= 7;
        }
        arrayList.add((byte)l);
        int n2 = arrayList.size();
        byte[] byArray = new byte[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            byArray[i2] = (Byte)arrayList.get(i2);
        }
        return byArray;
    }

    private static int g9(int n2, int n3) {
        return n2 << (32 - (n3 &= 0x1F) & 0x1F) | n2 >>> n3;
    }

    public static int i(String string, byte[] byArray, long l) {
        byArray = byArray != null && byArray.length > 0 ? gj_1.G(byArray) : new byte[16];
        int n2 = gj_1.KJ(gj_1.KJ(gj_1.KJ(539167016, rs_1.F5(gj_1.v(string).getBytes(StandardCharsets.UTF_8))), byArray), gj_1.B((int)l)) & 0xF;
        return n2 - (n2 * 171 >> 9) * 3;
    }

    private static int q(byte[] byArray, int n2) {
        byte by2 = byArray[n2];
        byte by3 = byArray[n2 + 1];
        byte by4 = byArray[n2 + 2];
        return (byArray[n2 + 3] & 0xFF) << 24 | (by2 & 0xFF | (by3 & 0xFF) << 8 | (by4 & 0xFF) << 16);
    }

    private static byte[] s(byte[] byArray, byte[] byArray2) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n7 = byArray.length;
        byte[] byArray3 = new byte[n7];
        for (n5 = 0; n5 < byArray.length; ++n5) {
            n4 = n5 * 4 & 0x1C;
            n3 = byArray2[n4] & 0xFF;
            n4 = byArray2[n4 + 1] & 0xFF;
            n2 = byArray[n5] & 0xFF;
            n2 = gj_1.Gd((~(((n2 >>> 4 | n2 << 4) & 0xFF) + n3) ^ n4) & 0xFF);
            byArray3[byArray.length - n5 - 1] = (byte)(~((n2 + n4 & 0xFF ^ n3) & 0xFF) & 0xFF);
        }
        n4 = n7 - 1;
        n5 = byArray3[n4];
        n2 = n7 - 2;
        n5 = (n5 ^ byArray3[n2]) & 0xFF;
        n3 = byArray3[0] & 0xFF;
        byArray3[0] = (byte)(~n5 + n3 & 0xFF);
        byArray3[1] = (byte)((byArray3[0] ^ byArray3[n4] ^ 0xFE) + byArray3[1] & 0xFF);
        byArray3[2] = (byte)(byArray3[2] + (n5 - n3 ^ gj_1.Gd(byArray3[1] & 0xFF) ^ 2) & 0xFF);
        n5 = 0;
        while (n5 < n7 - 4) {
            int n8 = gj_1.Gd(byArray3[n5 + 2] & 0xFF);
            n3 = n5 + 1;
            byte by2 = byArray3[n3];
            byArray3[n5 += 3] = (byte)(~(n8 ^ by2 ^ n5) + byArray3[n5] & 0xFF);
            n5 = n3;
        }
        byArray3[n4] = (byte)(byArray3[n4] ^ byArray3[n2]);
        n5 = 0;
        n3 = 0;
        while (n5 < n4) {
            n3 += byArray3[++n5] & 0xFF;
        }
        byArray3[0] = (byte)((byArray3[0] ^ byArray3[1]) + n3 & 0xFF);
        return byArray3;
    }

    private static String t0(String object, byte[] object2, long l, String object3, String object4) {
        Object object5;
        Object[] objectArray;
        Object[] objectArray2;
        Object[] objectArray3;
        Object object6;
        Object[] objectArray4;
        Object object7;
        Object object8;
        long l2;
        Object object9;
        Object object10;
        Object object11;
        int n2;
        byte[] byArray;
        Object object12;
        byte[] byArray2;
        block32: {
            Object object13;
            Object object14;
            Object object15;
            Object object16;
            Object object17;
            int n3;
            int n4;
            Object object18;
            Object object19;
            block28: {
                byArray2 = object2 != null && ((byte[])object2).length > 0 ? gj_1.G(object2) : new byte[16];
                object12 = gj_1.v((String)object);
                byArray = rs_1.F5(((String)object12).getBytes(StandardCharsets.UTF_8));
                n2 = (int)l;
                object2 = gj_1.B(n2);
                object11 = gj_1.KJ(gj_1.KJ(gj_1.KJ(539167016, byArray), byArray2), object2);
                object10 = object11 & 0xF;
                if ((object10 -= (object19 = object10 * 171 >> 9) * 3) != 2) break block28;
                object11 = (object11 & 0xD) * 86;
                object9 = (object11 >>> 15 & 0xFF) + (object11 >>> 8 & 0xFF);
                l2 = (long)(new int[]{-1988037989, -346776449, -1333319973, -737364506, -386573852})[object9] + l;
                object8 = (int)(l2 + 1L & 0xFFL);
                object10 = (int)l2;
                Object object20 = object = (Object)new int[8];
                object20[0] = 132;
                object20[1] = 150;
                object20[2] = 119;
                object20[3] = 157;
                object20[4] = 212;
                object20[5] = 21;
                object20[6] = 11;
                object20[7] = 248;
                object7 = new byte[8];
                for (object11 = 0; object11 < 8; ++object11) {
                    object7[object11] = (byte)((object[object11] | object[object11] << 8) >> (object10 + 5 & 7) & 0xFF);
                }
                object = gj_1.Gc(new byte[][]{byArray, byArray2, object2, object7, ZV.SN("a0010000")});
                object11 = object9 << 6;
                object9 = (object9 + 1 << 6) - object11;
                objectArray4 = new byte[object9];
                System.arraycopy(N, object11, objectArray4, 0, object9);
                object9 = SN.length;
                object6 = new int[object9];
                for (object11 = 0; object11 < object9; ++object11) {
                    object6[object11] = gj_1.g9(SN[object11], object8);
                }
                objectArray3 = new int[4];
                objectArray3[0] = gj_1.g9(2044785403, object10);
                objectArray3[1] = gj_1.g9(-927652496, object10);
                objectArray3[2] = gj_1.g9(-339543859, object10);
                objectArray3[3] = gj_1.g9(2081443219, object10);
                object11 = object10 + 6 & 0xFF;
                objectArray2 = new int[4];
                objectArray2[0] = gj_1.g9(431900774, object11);
                objectArray2[1] = gj_1.g9(-396785996, object11);
                objectArray2[2] = gj_1.g9(-509922706, object11);
                objectArray2[3] = gj_1.g9(1909577684, object11);
                objectArray = new int[16];
                for (object11 = 0; object11 < 16; ++object11) {
                    objectArray[object11] = gj_1.q((byte[])object, object11 * 4);
                }
                object10 = objectArray3[0];
                object11 = objectArray3[1];
                object8 = objectArray3[2];
                object18 = objectArray3[3];
                object2 = new int[16];
                byte[] byArray3 = object2;
                byArray3[0] = 7;
                byArray3[1] = 12;
                byArray3[2] = 17;
                byArray3[3] = 22;
                byArray3[4] = 7;
                byArray3[5] = 12;
                byArray3[6] = 17;
                byArray3[7] = 22;
                byArray3[8] = 7;
                byArray3[9] = 12;
                byArray3[10] = 17;
                byArray3[11] = 22;
                byArray3[12] = 7;
                byArray3[13] = 12;
                byArray3[14] = 17;
                byArray3[15] = 22;
                Object[] objectArray5 = object7 = (Object)new int[16];
                object7[0] = 5;
                objectArray5[1] = 9;
                objectArray5[2] = 14;
                objectArray5[3] = 20;
                objectArray5[4] = 5;
                objectArray5[5] = 9;
                objectArray5[6] = 14;
                objectArray5[7] = 20;
                objectArray5[8] = 5;
                objectArray5[9] = 9;
                objectArray5[10] = 14;
                objectArray5[11] = 20;
                objectArray5[12] = 5;
                objectArray5[13] = 9;
                objectArray5[14] = 14;
                objectArray5[15] = 20;
                for (n4 = 0; n4 < 4; ++n4) {
                    object = n4 == 0 ? (Object)object2 : (n4 == 1 ? (Object)object7 : (n4 == 2 ? (Object)new int[]{4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23} : (Object)new int[]{6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21}));
                    object9 = object10;
                    object10 = object18;
                    for (n3 = 0; n3 < 16; ++n3) {
                        block31: {
                            block30: {
                                block29: {
                                    object17 = n3 & 3;
                                    object18 = n4 * 16 + n3;
                                    object16 = objectArray[objectArray4[object18] & 0xFF];
                                    byte by2 = object6[object18];
                                    if (object17 == 0) {
                                        object15 = object[n3];
                                        object19 = object8;
                                        object14 = object10;
                                        object13 = object11;
                                        object18 = object9;
                                    } else if (object17 == 1) {
                                        object15 = object[n3];
                                        object14 = object8;
                                        object18 = object10;
                                        object19 = object11;
                                        object13 = object9;
                                    } else if (object17 == 2) {
                                        object15 = object[n3];
                                        object18 = object8;
                                        object13 = object10;
                                        object14 = object11;
                                        object19 = object9;
                                    } else {
                                        object15 = object[n3];
                                        object13 = object8;
                                        object19 = object10;
                                        object18 = object11;
                                        object14 = object9;
                                    }
                                    object18 = gj_1.G4(n4, object18, object13, object19, object14, object16, object15, by2);
                                    if (object17 == 0) {
                                        object9 = object18;
                                        continue;
                                    }
                                    if (object17 != 1) break block29;
                                    object10 = object18;
                                    break block30;
                                }
                                object19 = object18;
                                object13 = object10;
                                if (object17 != 2) break block31;
                                object8 = object18;
                            }
                            object13 = object10;
                            object19 = object11;
                        }
                        object11 = object19;
                        object10 = object13;
                    }
                    object18 = object10;
                    object10 = object9;
                }
                object = new byte[16];
                gj_1.W((byte[])object, 0, objectArray3[0] + object10 ^ objectArray2[0]);
                gj_1.W((byte[])object, 4, objectArray3[1] + object11 ^ objectArray2[1]);
                gj_1.W((byte[])object, 8, objectArray3[2] + object8 ^ objectArray2[2]);
                gj_1.W((byte[])object, 12, objectArray3[3] + object18 ^ objectArray2[3]);
                object = gj_1.Gc((byte[])object, gj_1.B(gj_1.O((byte[])object)));
                break block32;
            }
            if (object10 != 0) {
                object = gj_1.Gc(gj_1.OW(byArray, 0, 16), byArray2, gj_1.B(gj_1.O(gj_1.Gc(byArray, byArray2))));
            } else {
                object9 = (new int[]{-995654272, -1279197895, -980658554, -911590489, -173560334, -1774440751})[object19];
                l2 = (long)object9 + l;
                object10 = (int)(1L + l2 & 0xFFL);
                object14 = (int)l2;
                object = new int[64];
                for (object11 = 0; object11 < 64; ++object11) {
                    object[object11] = gj_1.g9((new int[]{-340373585, 128638146, -818837569, -535742209, 1829502207, 1513137086, -1273309640, 873991864, -231478417, -1314552628, -859632185, 1204935505, -715762722, 1890078625, 1464286226, -143719800, 738688778, -636630320, -71798932, -37433600, 1753874957, -428423514, -1932119157, 440175886, -857165717, 1792077067, -1605228777, -596530045, 579197809, -709567066, 1936688720, 1700802668, 1635574438, -467451522, 172024131, 1414414386, -1998587094, 1902910176, 1279687304, 95566771, -506415002, -1163666248, -1372359469, -1019733424, 386070363, -26369176, -256585912, 1309670328, 1923797261, 650459709, -222502666, -1269467775, 1243971549, -1942912350, -1425327226, 1029569300, 1326462516, -746892585, 1146027798, -351652911, 1822977902, 2640807, 137919738, 1605596550})[object11], object10);
                }
                Object[] objectArray6 = object7 = (Object)new int[4];
                object7[0] = 250;
                objectArray6[1] = 69;
                objectArray6[2] = 97;
                objectArray6[3] = 215;
                objectArray3 = new byte[4];
                for (object11 = 0; object11 < 4; ++object11) {
                    objectArray3[object11] = (byte)((object7[object11] | object7[object11] << 8) >> (object14 + 2 & 7) & 0xFF);
                }
                object7 = gj_1.Gc(new byte[][]{byArray, byArray2, object2, (byte[])objectArray3, ZV.SN("00000000000001a0")});
                object2 = new int[((byte[])object7).length / 4 + 112 + 16];
                object10 = 0;
                object11 = 0;
                while ((object15 = object10 + 3) < ((byte[])object7).length) {
                    object18 = object7[object10];
                    object13 = object7[object10 + 1];
                    object8 = object7[object10 + 2];
                    object2[object11] = object7[object15] & 0xFF | ((object13 & 0xFF) << 16 | (object18 & 0xFF) << 24 | (object8 & 0xFF) << 8);
                    object10 += 4;
                    ++object11;
                }
                object18 = object2[0];
                object10 = 0;
                object8 = object11;
                object11 = object18;
                while (object10 < 112) {
                    object13 = object10 + 1;
                    object18 = object2[object13];
                    n4 = object2[object10 + 14];
                    n3 = gj_1.xa(object18, 14);
                    object15 = gj_1.xa(object18, 25);
                    object17 = gj_1.xa(n4, 13);
                    object16 = gj_1.xa(n4, 15);
                    object2[object8] = object11 + object2[object10 + 9] + (object15 ^ n3 ^ object18 >>> 3) + (object16 ^ object17 ^ n4 >>> 10);
                    ++object8;
                    object10 = object13;
                    object11 = object18;
                }
                object7 = new int[8];
                for (object11 = 0; object11 < 8; ++object11) {
                    object7[object11] = gj_1.g9((new int[]{2059030472, 1729520903, 1677982208, 873419055, 984304912, -1289919430, -1420842003, -2142554032})[object11], object14 & 0x1F);
                }
                objectArray3 = new int[]{101, 5, 7, 6, 3, 2, 1, 0, 5, 4, 3};
                objectArray2 = new int[]{96, 0, 6, 7, 5, 3, 2, 1, 5, 4, 4};
                objectArray = new int[]{96, 0, 5, 6, 7, 3, 1, 2, 5, 4, 4};
                objectArray2 = (new int[][]{(int[])objectArray3, (int[])objectArray2, {96, 7, 6, 2, 1, 4, 0, 5, 4, 3, 5}, {99, 3, 6, 2, 4, 5, 1, 0, 0, 7, 6}, (int[])objectArray, {100, 2, 0, 3, 5, 4, 6, 7, 2, 1, 5}})[object19];
                objectArray3 = (int[])object7.clone();
                object10 = object9;
                for (object11 = 0; object11 < objectArray2[0]; ++object11) {
                    object9 = object10 + object11;
                    object8 = object2[object9 & 0x7F];
                    object19 = objectArray3[objectArray2[3]];
                    object18 = objectArray3[objectArray2[4]];
                    object13 = objectArray3[objectArray2[1]];
                    n4 = object8 + (objectArray3[objectArray2[3]] ^ (object19 ^ object18) & object13) + (gj_1.xa((int)objectArray3[objectArray2[1]], 26) ^ gj_1.xa((int)objectArray3[objectArray2[1]], 21) ^ gj_1.xa((int)objectArray3[objectArray2[1]], 7)) + object[object9 & 0x3F] + objectArray3[objectArray2[5]];
                    object16 = gj_1.xa((int)objectArray3[objectArray2[2]], 30);
                    object18 = gj_1.xa((int)objectArray3[objectArray2[2]], 19);
                    n3 = gj_1.xa((int)objectArray3[objectArray2[2]], 10);
                    object13 = objectArray3[objectArray2[2]];
                    object14 = objectArray3[objectArray2[6]];
                    object9 = objectArray3[objectArray2[2]];
                    object15 = objectArray3[objectArray2[6]];
                    object17 = objectArray3[objectArray2[7]];
                    object8 = objectArray3[objectArray2[9]];
                    object19 = objectArray3[objectArray3.length - 1];
                    System.arraycopy(objectArray3, 0, objectArray3, 1, objectArray3.length - 1);
                    objectArray3[0] = object19;
                    objectArray3[objectArray2[10]] = (object16 ^ object18 ^ n3) + ((object9 | object15) & object17 | object13 & object14) + n4;
                    objectArray3[objectArray2[8]] = object8 + n4;
                }
                object = new byte[32];
                for (object11 = 0; object11 < 8; ++object11) {
                    gj_1.v3((byte[])object, object11 * 4, (int)(objectArray3[object11] + object7[object11]));
                }
                for (object11 = 0; object11 < 16; ++object11) {
                    object[object11] = (byte)(object[object11] ^ object[object11 + 16]);
                }
                object = gj_1.Gc(gj_1.OW((byte[])object, 0, 16), gj_1.B(gj_1.O(gj_1.OW((byte[])object, 0, 16))));
            }
        }
        object7 = new byte[4];
        object2 = yq;
        object2.nextBytes((byte[])object7);
        l2 = gj_1.q(object7, 0);
        object11 = object2.nextInt(21);
        object10 = object2.nextInt(2000);
        objectArray3 = new Object[]{2, 146331399, "sint"};
        objectArray2 = new Object[]{3, 146331396, "sint"};
        objectArray = new Object[]{7, object10 + 10001, "sint"};
        object6 = gj_1.M((String)object3);
        object7 = gj_1.F5(new Object[][]{{1, System.currentTimeMillis() / 1000L, "sint"}, {2, -2, "sint"}, {4, 200, "sint"}});
        object7 = gj_1.F5(new Object[][]{{1, object11 + 100, "sint"}, objectArray3, objectArray2, {5, 7, "sint"}, {6, "v04.06.04.03-bugfix"}, objectArray, {12, object6, "message"}, {13, object7, "message"}, {14, object4}});
        object12 = rs_1.F5(gj_1.Gc(((String)object12).getBytes(StandardCharsets.UTF_8), byArray2, "none".getBytes(StandardCharsets.UTF_8)));
        objectArray3 = gj_1.F5(new Object[][]{{1, 111, "sint"}, {2, 10, "sint"}, {3, 694367, "sint"}, {5, 586952199, "sint"}});
        byArray2 = Gc;
        objectArray4 = new Object[]{5, object3};
        objectArray2 = new Object[]{6, "1588093228"};
        object3 = M;
        objectArray = gj_1.OW(byArray, 0, 6);
        object6 = KJ;
        object4 = gj_1.F5(new Object[][]{{1, byArray2, "bytes"}, {2, 3, "sint"}, {3, 0xFFFFFFFFL & l2, "sint"}, {4, "8662"}, objectArray4, objectArray2, {7, object4}, {8, "v04.06.04-ml-android"}, {9, 0x4060400, "sint"}, {10, object3, "bytes"}, {12, l, "sint"}, {13, object, "bytes"}, {14, objectArray, "bytes"}, {15, objectArray3, "message"}, {16, object6}, {17, l, "sint"}, {19, object12, "bytes"}, {20, "none"}, {21, 312, "sint"}, {23, object7, "message"}, {24, "{\"cmr\":16777216,\"cmr2\":16777216,\"un_h\":1879194040,\"vpn\":0,\"kd\":0,\"fkd\":3672518972,\"pd\":-1872573247,\"dyn\":\"\",\"do\":0,\"tk\":true}"}});
        object8 = object2.nextInt();
        object2 = zH;
        object7 = rs_1.F5(gj_1.Gc(new byte[][]{object2, gj_1.B(object8), object2}));
        object9 = object8 >> 16 & 0xFF;
        object2 = new byte[2][];
        object2[0] = (byte)object7;
        object2[1] = (byte)gj_1.B(~((object9 << 11 | object8 >>> 24) ^ object9 >> 5 ^ object9));
        object7 = object2[0];
        object2 = object2[1];
        object3 = gj_1.Gc((byte[])object3, gj_1.s((byte[])object4, object7));
        object11 = ((Object)object3).length - 1;
        for (object10 = 0; object10 < object11; ++object10, --object11) {
            object5 = object3[object10];
            object3[object10] = object3[object11];
            object3[object11] = object5;
        }
        for (object11 = 0; object11 < ((Object)object3).length; ++object11) {
            object3[object11] = (byte)(object3[object11] ^ object2[~object11 & 3]);
        }
        object10 = byArray[0];
        object11 = object[0];
        object2 = gj_1.B(yq.nextInt());
        object = gj_1.B((object11 & 0x3F) << 8 | ((object10 & 0x3F) << 14 | 0x18000001));
        byte by3 = (byte)object9;
        object5 = (byte)(object8 >> 24 & 0xFF);
        object = gj_1.Gc(new byte[][]{{53}, object2, (byte[])object, (byte[])object3, {by3, (byte)object5}});
        object = new yq(i, l).SN((byte[])object, t0);
        object2 = ZV.SN("03000000f7e85ffad7d7dc3bd62ac87057cf6118");
        object3 = new byte[20];
        for (object11 = 0; object11 < 20; object11 += 4) {
            gj_1.W((byte[])object3, object11, gj_1.q(object2, object11) ^ n2);
        }
        return Base64.encodeToString((byte[])gj_1.Gc((byte[])object3, {(byte)(object8 & 0xFF), (byte)(object8 >> 8 & 0xFF), 0, 1}, (byte[])object), (int)2);
    }

    static byte[] tF(byte[] byArray, byte[] byArray2) {
        byArray = (byte[])byArray.clone();
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            byArray[i2] = (byte)(byArray[i2] ^ byArray2[i2 % byArray2.length]);
        }
        return byArray;
    }

    private static String v(String string) {
        int n2 = string.indexOf(63);
        string = n2 < 0 ? "" : string.substring(n2 + 1);
        return string;
    }

    private static void v3(byte[] byArray, int n2, int n3) {
        byArray[n2] = (byte)(n3 >>> 24);
        byArray[n2 + 1] = (byte)(n3 >>> 16);
        byArray[n2 + 2] = (byte)(n3 >>> 8);
        byArray[n2 + 3] = (byte)n3;
    }

    private static int xa(int n2, int n3) {
        return n2 >>> (32 - (n3 &= 0x1F) & 0x1F) | n2 << n3;
    }

    static /* synthetic */ byte[] yq() {
        return tF;
    }

    static /* synthetic */ byte[] zH(byte[][] byArray) {
        return gj_1.Gc(byArray);
    }

    private static final class yq {
        private final int[] N;
        private final int[] SN;
        private final int[][] tF;
        private final byte[] yq;

        yq(byte[] byArray, long l) {
            int n2 = (int)(l & 3L);
            this.yq = gJ.SN((byte[])gJ.yq(), (int)(n2 * 256), (int)((n2 + 1) * 256));
            Object[] objectArray = new int[]{0, 9, 14, 11, 4, 13, 2, 7, 8, 1, 6, 15, 12, 5, 10, 3};
            int[] nArray = new int[]{0, 9, 14, 11, 4, 13, 2, 7, 8, 1, 6, 15, 12, 5, 10, 3};
            this.SN = (new int[][]{{1, 0, 2, 3}, {2, 0, 3, 1}, {0, 1, 3, 2}, {1, 0, 2, 3}})[n2];
            this.N = (new int[][]{objectArray, {0, 9, 14, 15, 4, 13, 2, 7, 8, 1, 6, 3, 12, 5, 10, 11}, {0, 9, 14, 7, 4, 13, 2, 11, 8, 1, 6, 3, 12, 5, 10, 15}, nArray})[n2];
            int n3 = (new int[]{-905814564, -2109881018, -918420093, -1030217121})[n2];
            objectArray = new byte[16];
            for (n2 = 0; n2 < 4; ++n2) {
                gJ.N((byte[])objectArray, (int)(n2 * 4), (int)n3);
            }
            objectArray = gJ.zH((byte[][])new byte[][]{gJ.tF((byte[])objectArray, (byte[])byArray), new byte[32]});
            int n4 = 8;
            for (n2 = 4; n2 < 12; ++n2) {
                int n5 = (n2 - 1) * 4;
                int n7 = objectArray[n5] & 0xFF;
                int n8 = objectArray[n5 + 1] & 0xFF;
                int n9 = objectArray[n5 + 2] & 0xFF;
                int n10 = objectArray[n5 + 3] & 0xFF;
                int n11 = n7;
                int n12 = n8;
                int n13 = n9;
                int n14 = n10;
                if ((n2 & 3) == 0) {
                    byArray = this.yq;
                    n13 = byArray[n8];
                    n12 = byArray[n9];
                    n10 = byArray[n10];
                    n14 = byArray[n7] & 0xFF;
                    n11 = (n13 & 0xFF ^ n3 >>> (n4 & 0x18)) & 0xFF;
                    n12 &= 0xFF;
                    n13 = n10 & 0xFF;
                }
                n4 += 2;
                objectArray[n5 + 4] = (byte)(n11 ^ objectArray[n5 - 12] & 0xFF);
                objectArray[n5 + 5] = (byte)(n12 ^ objectArray[n5 - 11] & 0xFF);
                objectArray[n5 + 6] = (byte)(objectArray[n5 - 10] & 0xFF ^ n13);
                objectArray[n5 + 7] = (byte)(objectArray[n5 - 9] & 0xFF ^ n14);
            }
            this.tF = new int[12][4];
            for (n2 = 0; n2 < 12; ++n2) {
                for (n4 = 0; n4 < 4; ++n4) {
                    this.tF[n2][n4] = objectArray[n2 * 4 + n4] & 0xFF;
                }
            }
        }

        private static byte[] N(int[][] nArray) {
            byte[] byArray = new byte[16];
            for (int i2 = 0; i2 < 4; ++i2) {
                for (int i4 = 0; i4 < 4; ++i4) {
                    byArray[i2 * 4 + i4] = (byte)nArray[i2][i4];
                }
            }
            return byArray;
        }

        private static int i(int n2) {
            int n3 = (n2 & 0x80) != 0 ? 27 : 0;
            return (n3 ^ n2 << 1) & 0xFF;
        }

        private static void tF(byte[] byArray, int n2, int n3) {
            if (n2 >= 0 && n2 < byArray.length) {
                byArray[n2] = (byte)n3;
            }
        }

        private void yq(int[][] nArray, int[][] nArray2) {
            for (int i2 = 0; i2 < 4; ++i2) {
                for (int i4 = 0; i4 < 4; ++i4) {
                    int[] nArray3 = nArray[i2];
                    nArray3[i4] = nArray3[i4] ^ nArray2[i2][this.SN[i4]];
                }
            }
        }

        private int[][] zH(int n2) {
            int[][] nArray = new int[4][4];
            for (int i2 = 0; i2 < 4; ++i2) {
                System.arraycopy(this.tF[n2 + i2], 0, nArray[i2], 0, 4);
            }
            return nArray;
        }

        final byte[] SN(byte[] byArray, byte[] object) {
            int n2;
            int n3;
            int n4;
            int n5;
            int n7;
            int n8;
            int n9;
            byte[] byArray2 = new byte[32];
            for (n9 = 0; n9 < 31; ++n9) {
                int n10 = n9 * 8;
                n8 = n10 < byArray.length ? byArray[n10] & 0xFF : 0;
                n7 = n10 + 1;
                n7 = n7 < byArray.length ? byArray[n7] & 0xFF : 0;
                n5 = n10 + 2;
                n5 = n5 < byArray.length ? byArray[n5] & 0xFF : 0;
                n4 = n10 + 3;
                n4 = n4 < byArray.length ? byArray[n4] & 0xFF : 0;
                n3 = n10 + 4;
                n3 = n3 < byArray.length ? byArray[n3] & 0xFF : 0;
                n2 = n10 + 5;
                n2 = n2 < byArray.length ? byArray[n2] & 0xFF : 0;
                int n11 = n10 + 6;
                n11 = n11 < byArray.length ? byArray[n11] & 0xFF : 0;
                n10 = (n10 += 7) < byArray.length ? byArray[n10] & 0xFF : 0;
                byArray2[n9] = (byte)(n10 >> 4 & 8 | (0x10 & n2 << 3 | (n5 >> 2 & 1 | (n8 >> 4 & 2 | n7 & 0x40) | n4 << 3 & 0x80 | n3 >> 1 & 4) | n11 << 5 & 0x20));
            }
            byArray2[31] = 1;
            ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
            object = (byte[])object.clone();
            n9 = 0;
            while (n9 < 32) {
                n5 = n9 + 16;
                Object object2 = gJ.tF((byte[])gJ.SN((byte[])byArray2, (int)n9, (int)n5), (byte[])object);
                object = new int[4][4];
                for (n9 = 0; n9 < 4; ++n9) {
                    for (n8 = 0; n8 < 4; ++n8) {
                        object[n9][n8] = object2[n9 * 4 + n8] & 0xFF;
                    }
                }
                this.yq((int[][])object, this.zH(0));
                for (n9 = 1; n9 < 3; ++n9) {
                    for (n8 = 0; n8 < 4; ++n8) {
                        for (n7 = 0; n7 < 4; ++n7) {
                            object[n8][n7] = this.yq[object[n8][n7]] & 0xFF;
                        }
                    }
                    object2 = new int[4][];
                    for (n8 = 0; n8 < 4; ++n8) {
                        object2[n8] = (byte)((int[])object[n8].clone());
                    }
                    for (n8 = 0; n8 < 4; ++n8) {
                        object[n8] = object2[this.SN[n8]];
                    }
                    object2 = com.github.catvod.spider.merge.gJ$yq.N((int[][])object);
                    for (n8 = 0; n8 < 16; ++n8) {
                        object[n8 / 4][n8 % 4] = object2[this.N[n8]] & 0xFF;
                    }
                    if (n9 == 1) {
                        object2 = new int[4][];
                        for (n8 = 0; n8 < 4; ++n8) {
                            object2[n8] = (byte)((int[])object[n8].clone());
                        }
                        for (n8 = 0; n8 < 4; ++n8) {
                            for (n7 = 0; n7 < 4; ++n7) {
                                object[n8][n7] = object2[n8][this.SN[n7]];
                            }
                        }
                        for (n8 = 0; n8 < 4; ++n8) {
                            n7 = object[0][n8] ^ object[1][n8] ^ object[2][n8] ^ object[3][n8];
                            n3 = object[0][n8];
                            object2 = object[0];
                            object2[n8] = object2[n8] ^ (com.github.catvod.spider.merge.gJ$yq.i(object[0][n8] ^ object[1][n8]) ^ n7);
                            object2 = object[1];
                            object2[n8] = object2[n8] ^ (com.github.catvod.spider.merge.gJ$yq.i(object[1][n8] ^ object[2][n8]) ^ n7);
                            object2 = object[2];
                            object2[n8] = object2[n8] ^ (com.github.catvod.spider.merge.gJ$yq.i(object[2][n8] ^ object[3][n8]) ^ n7);
                            object2 = object[3];
                            n4 = object2[n8];
                            object2[n8] = n7 ^ com.github.catvod.spider.merge.gJ$yq.i(n3 ^ object[3][n8]) ^ n4;
                        }
                    }
                    this.yq((int[][])object, this.zH(n9 * 4));
                }
                object2 = this.zH(4);
                for (n9 = 0; n9 < 4; ++n9) {
                    for (n8 = 0; n8 < 4; ++n8) {
                        byte by2 = object[n9];
                        by2[n8] = by2[n8] ^ object2[n9][n8];
                    }
                }
                object = com.github.catvod.spider.merge.gJ$yq.N((int[][])object);
                arrayList.add((byte[])object);
                n9 = n5;
            }
            object = gJ.zH((byte[][])((byte[][])arrayList.toArray((T[])new byte[0][])));
            byArray = (byte[])byArray.clone();
            for (n9 = 0; n9 < 31; ++n9) {
                n5 = n9 * 8;
                n4 = object[n9] & 0xFF;
                n8 = n5 < byArray.length ? byArray[n5] & 0xFF : 0;
                n7 = n4 << 4;
                com.github.catvod.spider.merge.gJ$yq.tF(byArray, n5, n8 & 0xDF | n7 & 0x20);
                n3 = n5 + 1;
                n8 = n3 < byArray.length ? byArray[n3] & 0xFF : 0;
                com.github.catvod.spider.merge.gJ$yq.tF(byArray, n3, n8 & 0xBF | n4 & 0x40);
                n3 = n5 + 2;
                n8 = n3 < byArray.length ? byArray[n3] & 0xFF : 0;
                com.github.catvod.spider.merge.gJ$yq.tF(byArray, n3, n8 & 0xFB | n4 << 2 & 4);
                n2 = n5 + 3;
                n8 = n2 < byArray.length ? byArray[n2] & 0xFF : 0;
                n3 = n4 >> 3;
                com.github.catvod.spider.merge.gJ$yq.tF(byArray, n2, n8 & 0xEF | n3 & 0x10);
                n2 = n5 + 4;
                n8 = n2 < byArray.length ? byArray[n2] & 0xFF : 0;
                com.github.catvod.spider.merge.gJ$yq.tF(byArray, n2, n8 & 0xF7 | n4 + n4 & 8);
                n2 = n5 + 5;
                n8 = n2 < byArray.length ? byArray[n2] & 0xFF : 0;
                com.github.catvod.spider.merge.gJ$yq.tF(byArray, n2, n8 & 0xFD | n3 & 2);
                n3 = n5 + 6;
                n8 = n3 < byArray.length ? byArray[n3] & 0xFF : 0;
                com.github.catvod.spider.merge.gJ$yq.tF(byArray, n3, n4 >> 5 & 1 | n8 & 0xFE);
                n8 = (n5 += 7) < byArray.length ? byArray[n5] & 0xFF : 0;
                com.github.catvod.spider.merge.gJ$yq.tF(byArray, n5, n8 & 0x7F | n7 & 0x80);
            }
            return gJ.zH((byte[][])new byte[][]{gJ.SN((byte[])object, (int)(((byte[])object).length - 1), (int)((byte[])object).length), byArray});
        }
    }
}

