/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  android.widget.EditText
 */
package com.github.catvod.spider.merge;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.EditText;
import com.github.catvod.spider.merge.w4;

/*
 * Renamed from com.github.catvod.spider.merge.Sn
 */
public final class sn_0
implements DialogInterface.OnShowListener {
    public final EditText N;
    public final Activity SN;
    public final w4 yq;

    public /* synthetic */ sn_0(w4 w42, Activity activity, EditText editText) {
        this.yq = w42;
        this.SN = activity;
        this.N = editText;
    }

    public final void onShow(DialogInterface dialogInterface) {
        w4.M(this.yq, this.SN, this.N);
    }
}

