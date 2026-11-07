/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.Y4;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.do_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.wu_0;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/*
 * Renamed from com.github.catvod.spider.merge.kB
 */
public final class kb_0
extends ArrayList<hN> {
    public kb_0() {
    }

    public kb_0(int n2) {
        super(n2);
    }

    public kb_0(List<hN> list) {
        super(list);
    }

    public kb_0(hN ... hNArray) {
        super(Arrays.asList(hNArray));
    }

    public final kb_0 N(int n2) {
        kb_0 kb_02 = ((AbstractCollection)this).size() > n2 ? new kb_0((hN)((AbstractList)this).get(n2)) : new kb_0();
        return kb_02;
    }

    public final List<String> SN() {
        ArrayList<String> arrayList = new ArrayList<String>(((AbstractCollection)this).size());
        for (hN hN2 : this) {
            if (!hN2.w()) continue;
            arrayList.add(hN2.Fo());
        }
        return arrayList;
    }

    @Override
    public final Object clone() {
        kb_0 kb_02 = new kb_0(((AbstractCollection)this).size());
        Iterator iterator = ((AbstractCollection)this).iterator();
        while (iterator.hasNext()) {
            ((AbstractCollection)kb_02).add(((hN)iterator.next()).i3());
        }
        return kb_02;
    }

    public final kb_0 i(String object) {
        co_0.i((String)object);
        Y4 y42 = do_0.KJ((String)object);
        kb_0 kb_02 = new kb_0();
        object = new IdentityHashMap();
        for (hN hN22 : this) {
            co_0.Gc(y42);
            co_0.Gc(hN22);
            for (hN hN22 : wu_0.yq(y42, hN22)) {
                if (((IdentityHashMap)object).put(hN22, Boolean.TRUE) != null) continue;
                ((AbstractCollection)kb_02).add(hN22);
            }
        }
        return kb_02;
    }

    public final String t0() {
        StringBuilder stringBuilder = Nr.SN();
        for (hN hN2 : this) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(hN2.Fo());
        }
        return Nr.Gc(stringBuilder);
    }

    public final hN tF() {
        hN hN2 = ((AbstractCollection)this).isEmpty() ? null : (hN)((AbstractList)this).get(0);
        return hN2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = Nr.SN();
        for (hN hN2 : this) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(hN2.ee());
        }
        return Nr.Gc(stringBuilder);
    }

    public final String yq(String string) {
        for (hN hN2 : this) {
            if (!hN2.G4(string)) continue;
            return hN2.N(string);
        }
        return "";
    }

    public final hN zH() {
        hN hN2 = ((AbstractCollection)this).isEmpty() ? null : (hN)((AbstractList)this).get(((AbstractCollection)this).size() - 1);
        return hN2;
    }
}

