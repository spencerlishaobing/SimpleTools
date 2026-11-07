/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.CT;
import com.github.catvod.spider.merge.F;
import com.github.catvod.spider.merge.Gj;
import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.ct_0;
import com.github.catvod.spider.merge.hy_0;
import com.github.catvod.spider.merge.t_0;
import com.github.catvod.spider.merge.zh_0;
import com.github.catvod.spider.merge.zk_0;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public final class R5
implements ct_0 {
    private static final Object[] yq = new Object[0];

    public static final Iterator N(Object[] objectArray) {
        Nh.zH(objectArray, "array");
        return new hy_0<Object>(objectArray);
    }

    public static boolean SN(Object object, Object object2) {
        boolean bl = object == object2 || object != null && object.equals(object2);
        return bl;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Object[] i(Collection object, Object[] objectArray) {
        void var0_11;
        void var1_13;
        Nh.zH(object, "collection");
        Objects.requireNonNull(var1_13);
        int n2 = object.size();
        int n3 = 0;
        if (n2 == 0) {
            void var0_1 = var1_13;
            if (((void)var1_13).length <= 0) return var0_11;
            var1_13[0] = null;
            void var0_2 = var1_13;
            return var0_11;
        }
        Iterator iterator = object.iterator();
        if (!iterator.hasNext()) {
            void var0_3 = var1_13;
            if (((void)var1_13).length <= 0) return var0_11;
            var1_13[0] = null;
            void var0_4 = var1_13;
            return var0_11;
        }
        if (n2 <= ((void)var1_13).length) {
            void var0_5 = var1_13;
        } else {
            Object object2 = Array.newInstance(var1_13.getClass().getComponentType(), n2);
            Nh.N(object2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            Object[] objectArray2 = (Object[])object2;
        }
        while (true) {
            void var5_18;
            void var0_8;
            n2 = n3 + 1;
            var0_8[n3] = iterator.next();
            if (n2 >= ((void)var0_8).length) {
                int n4;
                if (!iterator.hasNext()) return var0_11;
                n3 = n4 = n2 * 3 + 1 >>> 1;
                if (n4 <= n2) {
                    if (n2 >= 0x7FFFFFFD) throw new OutOfMemoryError();
                    n3 = 0x7FFFFFFD;
                }
                T[] TArray = Arrays.copyOf(var0_8, n3);
                Nh.tF(TArray, "copyOf(result, newSize)");
            } else {
                void var5_20 = var0_8;
                if (!iterator.hasNext()) {
                    if (var0_8 == var1_13) {
                        var1_13[n2] = null;
                        void var0_9 = var1_13;
                        return var0_11;
                    } else {
                        T[] TArray = Arrays.copyOf(var0_8, n2);
                        Nh.tF(TArray, "copyOf(result, size)");
                    }
                    return var0_11;
                }
            }
            n3 = n2;
            void var0_12 = var5_18;
        }
    }

    public static String tF(String string) {
        byte[] byArray = MessageDigest.getInstance("SHA-1").digest(string.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = byArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            string = Integer.toHexString(byArray[i2] & 0xFF);
            if (string.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string);
            continue;
        }
        try {
            string = stringBuilder.toString();
            return string;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            RuntimeException runtimeException = new RuntimeException("SHA-1 \u7b97\u6cd5\u4e0d\u5b58\u5728", noSuchAlgorithmException);
            throw runtimeException;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final Object[] zH(Collection objectArray) {
        Nh.zH(objectArray, "collection");
        int n2 = objectArray.size();
        if (n2 == 0) return yq;
        Iterator iterator = objectArray.iterator();
        if (!iterator.hasNext()) {
            return yq;
        }
        objectArray = new Object[n2];
        n2 = 0;
        while (true) {
            Object[] objectArray2;
            int n3 = n2 + 1;
            objectArray[n2] = iterator.next();
            if (n3 >= objectArray.length) {
                int n4;
                if (!iterator.hasNext()) {
                    return objectArray;
                }
                n2 = n4 = n3 * 3 + 1 >>> 1;
                if (n4 <= n3) {
                    if (n3 >= 0x7FFFFFFD) throw new OutOfMemoryError();
                    n2 = 0x7FFFFFFD;
                }
                objectArray2 = Arrays.copyOf(objectArray, n2);
                Nh.tF(objectArray2, "copyOf(result, newSize)");
            } else {
                objectArray2 = objectArray;
                if (!iterator.hasNext()) {
                    objectArray = Arrays.copyOf(objectArray, n3);
                    Nh.tF(objectArray, "copyOf(result, size)");
                    return objectArray;
                }
            }
            n2 = n3;
            objectArray = objectArray2;
        }
    }

    public F yq(String object, Gj object2, int n2, int n3, Map map) {
        if (!((String)object).isEmpty()) {
            if (n2 >= 0 && n3 >= 0) {
                int n4 = 4;
                object2 = zk_0.yq;
                int n5 = map.containsKey(object2) ? zh_0.zH(map.get(object2).toString()) : 1;
                object2 = zk_0.i;
                if (map.containsKey(object2)) {
                    n4 = Integer.parseInt(map.get(object2).toString());
                }
                if ((object = CT.N((String)object, n5, map).yq()) != null) {
                    int n7 = ((t_0)object).zH();
                    int n8 = ((t_0)object).tF();
                    n5 = n4 << 1;
                    n4 = n7 + n5;
                    int n9 = n5 + n8;
                    n5 = Math.max(n2, n4);
                    n3 = Math.max(n3, n9);
                    int n10 = Math.min(n5 / n4, n3 / n9);
                    n9 = (n5 - n7 * n10) / 2;
                    n2 = (n3 - n8 * n10) / 2;
                    object2 = new F(n5, n3);
                    n3 = 0;
                    while (n3 < n8) {
                        n5 = n9;
                        n4 = 0;
                        while (n4 < n7) {
                            if (((t_0)object).SN(n4, n3) == 1) {
                                ((F)object2).tF(n5, n2, n10, n10);
                            }
                            ++n4;
                            n5 += n10;
                        }
                        ++n3;
                        n2 += n10;
                    }
                    return object2;
                }
                throw new IllegalStateException();
            }
            object = new StringBuilder("Requested dimensions are too small: ");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append('x');
            ((StringBuilder)object).append(n3);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        object = new IllegalArgumentException("Found empty contents");
        throw object;
    }
}

