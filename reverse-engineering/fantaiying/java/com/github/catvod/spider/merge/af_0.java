/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.github.catvod.spider.merge;

import android.view.View;
import com.github.catvod.spider.merge.Zc;
import com.github.catvod.spider.merge.dT;
import com.github.catvod.spider.merge.w4;
import java.util.Objects;

/*
 * Renamed from com.github.catvod.spider.merge.Af
 */
public final class af_0
implements View.OnClickListener {
    public final Zc SN;
    public final w4 yq;

    public /* synthetic */ af_0(w4 w42, Zc zc) {
        this.yq = w42;
        this.SN = zc;
    }

    public final void onClick(View object) {
        object = this.yq;
        Zc zc = this.SN;
        Objects.requireNonNull(object);
        new Thread(new dT(object, zc, 3)).start();
    }
}

