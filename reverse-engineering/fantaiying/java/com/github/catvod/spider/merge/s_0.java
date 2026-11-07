/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.widget.Toast
 */
package com.github.catvod.spider.merge;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.xu_0;

/*
 * Renamed from com.github.catvod.spider.merge.s
 */
public final class s_0
implements Runnable {
    public final Object SN;
    public final int yq;

    public /* synthetic */ s_0(Object object, int n2) {
        this.yq = n2;
        this.SN = object;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 1: {
                xu_0.t0((xu_0)this.SN);
                return;
            }
            case 0: {
                j_0.N((j_0)this.SN);
                return;
            }
        }
        Exception exception = (Exception)this.SN;
        CharSequence charSequence = ME.yq;
        Application application = InitOrigin.context();
        charSequence = oi_0.yq("\u521d\u59cb\u5316\u5931\u8d25:");
        ((StringBuilder)charSequence).append(exception.getCause().getMessage());
        Toast.makeText((Context)application, (CharSequence)((StringBuilder)charSequence).toString(), (int)1).show();
    }
}

