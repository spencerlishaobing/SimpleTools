/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.F;
import com.github.catvod.spider.merge.Gj;
import com.github.catvod.spider.merge.R5;
import com.github.catvod.spider.merge.ct_0;
import com.github.catvod.spider.merge.py_2;
import java.util.Map;

/*
 * Renamed from com.github.catvod.spider.merge.Co
 */
public final class co_0
implements ct_0 {
    public static void Gc(Object object) {
        if (object != null) {
            return;
        }
        throw new py_2("Object must not be null");
    }

    public static void N(boolean bl) {
        if (!bl) {
            return;
        }
        throw new py_2("Must be false");
    }

    public static void SN(String string) {
        throw new py_2(string);
    }

    public static void i(String string) {
        if (string != null && string.length() != 0) {
            return;
        }
        throw new py_2("String must not be empty");
    }

    public static void t0(String string, String string2) {
        if (string != null && string.length() != 0) {
            return;
        }
        throw new py_2(string2);
    }

    public static void tF(boolean bl) {
        if (bl) {
            return;
        }
        throw new py_2("Must be true");
    }

    public static void zH(boolean bl, String string) {
        if (bl) {
            return;
        }
        throw new py_2(string);
    }

    public F yq(String string, Gj gj, int n, int n2, Map map) {
        gj = Gj.KJ;
        return new R5().yq(string, gj, n, n2, map);
    }
}

