/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.BB;
import com.github.catvod.spider.merge.cp;
import com.github.catvod.spider.merge.ho;
import java.nio.CharBuffer;

public final class Kk {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static BB yq(String object) {
        ho.yq yq2 = new ho.yq(((String)object).length());
        Object object2 = CharBuffer.allocate(((String)object).length());
        ((CharBuffer)object2).put((String)object);
        ((CharBuffer)object2).flip();
        yq2.yq((CharBuffer)object2);
        object = yq2.tF();
        int n2 = cp.SN(((ho)object).tF());
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) throw new UnsupportedOperationException("Not reached");
                int n3 = ((ho)object).i();
                n2 = ((ho)object).t0();
                object2 = ((ho)object).zH();
                ((ho)object).yq();
                return new BB.SN(n3, n2, (int[])object2);
            }
            int n4 = ((ho)object).i();
            n2 = ((ho)object).t0();
            object2 = ((ho)object).N();
            ((ho)object).yq();
            return new BB.yq(n4, n2, (char[])object2);
        }
        n2 = ((ho)object).i();
        int n5 = ((ho)object).t0();
        object2 = ((ho)object).SN();
        ((ho)object).yq();
        return new BB.N(n2, n5, (byte[])object2);
    }
}

