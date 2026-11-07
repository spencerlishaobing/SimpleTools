/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.B5;
import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.Sk;
import com.github.catvod.spider.merge.wg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Rx
extends B5 {
    public static byte[] Gc(byte[] byArray, int n2, int n3) {
        Nh.zH(byArray, "<this>");
        wg.yq(n3, byArray.length);
        byArray = Arrays.copyOfRange(byArray, n2, n3);
        Nh.tF(byArray, "copyOfRange(this, fromIndex, toIndex)");
        return byArray;
    }

    public static List KJ(Object[] objectArray) {
        Nh.zH(objectArray, "<this>");
        return new ArrayList<Object>(new Sk<Object>(objectArray, false));
    }

    public static Object[] M(Object[] objectArray, int n2, int n3) {
        Nh.zH(objectArray, "<this>");
        wg.yq(n3, objectArray.length);
        objectArray = Arrays.copyOfRange(objectArray, n2, n3);
        Nh.tF(objectArray, "copyOfRange(this, fromIndex, toIndex)");
        return objectArray;
    }

    public static byte[] t0(byte[] byArray, byte[] byArray2, int n2, int n3, int n4) {
        Nh.zH(byArray, "<this>");
        Nh.zH(byArray2, "destination");
        System.arraycopy(byArray, n3, byArray2, n2, n4 - n3);
        return byArray2;
    }
}

