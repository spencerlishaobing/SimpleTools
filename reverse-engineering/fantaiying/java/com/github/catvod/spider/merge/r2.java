/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  com.github.catvod.crawler.SpiderDebug
 */
package com.github.catvod.spider.merge;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.GW;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.PA;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.xu_0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class r2
implements Runnable {
    public final i3 N;
    public final AtomicReference SN;
    public final xu_0 tF;
    public final AtomicBoolean yq;
    public final N0 zH;

    public /* synthetic */ r2(AtomicBoolean atomicBoolean, AtomicReference atomicReference, i3 i32, xu_0 xu_02, N0 n0) {
        this.yq = atomicBoolean;
        this.SN = atomicReference;
        this.N = i32;
        this.tF = xu_02;
        this.zH = n0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void run() {
        AtomicBoolean atomicBoolean = this.yq;
        AtomicReference atomicReference = this.SN;
        i3 i32 = this.N;
        xu_0 xu_02 = this.tF;
        N0 n0 = this.zH;
        try {
            Activity activity = InitOrigin.getActivity();
            if (activity == null) {
                atomicBoolean.set(true);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity);
            builder.setTitle((CharSequence)"\u9009\u62e9\u4efb\u610f\u7f51\u76d8\u626b\u7801\u540e\u5373\u53ef\u64ad\u653e");
            GW gW = GW.yq;
            builder.setSingleChoiceItems((CharSequence[])new String[]{"\u5938\u7236\u626b\u7801\u767b\u5f55", "\u4f18\u6c50\u626b\u7801\u767b\u5f55", "\u561f\u561f\u626b\u7801\u767b\u5f55"}, -1, (DialogInterface.OnClickListener)gW);
            builder.setNegativeButton((CharSequence)"\u53d6\u6d88", null);
            AlertDialog alertDialog = builder.create();
            alertDialog.setCanceledOnTouchOutside(false);
            PA pA = new PA(i32, xu_02, n0, atomicBoolean);
            alertDialog.setOnDismissListener((DialogInterface.OnDismissListener)pA);
            atomicReference.set(alertDialog);
            alertDialog.show();
            return;
        }
        catch (Exception exception) {
            SpiderDebug.log((Throwable)exception);
            atomicBoolean.set(true);
        }
    }
}

