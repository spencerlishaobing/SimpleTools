/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.graphics.drawable.Drawable
 *  android.widget.TextView
 */
package com.github.catvod.spider.merge;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.k9;
import com.github.catvod.spider.merge.xu_0;

public final class Dr
implements Runnable {
    public final Object N;
    public final Object SN;
    public final int yq;

    public /* synthetic */ Dr(Object object, Object object2, int n2) {
        this.yq = n2;
        this.SN = object;
        this.N = object2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 2: {
                Pan.yq((Pan)((Object)this.SN), (Activity)this.N);
                return;
            }
            case 1: {
                xu_0.B((xu_0)this.SN, (String)this.N);
                return;
            }
            case 0: {
                j_0.t0((j_0)this.SN, (k9)this.N);
                return;
            }
        }
        Drawable drawable = (Drawable)this.SN;
        TextView textView = (TextView)this.N;
        int n2 = ProxyOrigin.Gc;
        if (drawable != null && textView.getWidth() > 0 && textView.getHeight() > 0) {
            drawable.setBounds(0, 0, textView.getWidth(), textView.getHeight());
            textView.invalidate();
        }
    }
}

