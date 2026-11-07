/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.do_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.wu_0;

/*
 * Renamed from com.github.catvod.spider.merge.z2
 */
public final class z2_0 {
    public static hN yq(String string, hN hN2) {
        co_0.i(string);
        return new wu_0.SN(do_0.KJ(string)).yq(hN2, hN2);
    }

    public static final class yq
    extends IllegalStateException {
        public yq(String string) {
            super(string);
        }

        public yq(String string, Object ... objectArray) {
            super(String.format(string, objectArray));
        }
    }
}

