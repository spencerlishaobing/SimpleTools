/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.Sk;
import com.github.catvod.spider.merge.dy;
import java.util.ArrayList;
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.oi
 */
public final class oi_1
extends dy {
    public static List t0(Object ... object) {
        Nh.zH(object, "elements");
        object = ((Object[])object).length == 0 ? new ArrayList() : new ArrayList<Object>(new Sk<Object>((T[])object, true));
        return object;
    }
}

