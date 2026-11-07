/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Ei;
import com.github.catvod.spider.merge.cr_0;
import java.util.ArrayList;
import java.util.List;

public final class oU {
    private final List<cr_0> SN;
    private final Ei yq;

    public oU(Ei ei) {
        this.yq = ei;
        ArrayList<cr_0> arrayList = new ArrayList<cr_0>();
        this.SN = arrayList;
        arrayList.add(new cr_0(ei, new int[]{1}));
    }

    public final void yq(int[] object, int n2) {
        if (n2 != 0) {
            int n3 = ((int[])object).length - n2;
            if (n3 > 0) {
                Object object2;
                int n4;
                Object object3;
                if (n2 >= ((ArrayList)this.SN).size()) {
                    object3 = this.SN;
                    object3 = (cr_0)((ArrayList)object3).get(((ArrayList)object3).size() - 1);
                    for (n4 = ((ArrayList)this.SN).size(); n4 <= n2; ++n4) {
                        object2 = this.yq;
                        object3 = ((cr_0)object3).i(new cr_0((Ei)object2, new int[]{1, ((Ei)object2).SN(((Ei)object2).N() + (n4 - 1))}));
                        ((ArrayList)this.SN).add((cr_0)object3);
                    }
                }
                object3 = (cr_0)((ArrayList)this.SN).get(n2);
                object2 = new int[n3];
                System.arraycopy(object, 0, object2, 0, n3);
                object3 = new cr_0(this.yq, (int[])object2).t0(n2, 1).SN((cr_0)object3)[1].tF();
                n4 = n2 - ((Object)object3).length;
                for (n2 = 0; n2 < n4; ++n2) {
                    object[n3 + n2] = 0;
                }
                System.arraycopy(object3, 0, object, n3 + n4, ((Object)object3).length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        object = new IllegalArgumentException("No error correction bytes");
        throw object;
    }
}

