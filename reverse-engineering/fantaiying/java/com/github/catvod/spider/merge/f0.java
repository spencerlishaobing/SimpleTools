/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.widget.EditText
 */
package com.github.catvod.spider.merge;

import android.content.DialogInterface;
import android.widget.EditText;
import com.github.catvod.spider.Bili;

public final class f0
implements DialogInterface.OnClickListener {
    public final EditText SN;
    public final Bili yq;

    public /* synthetic */ f0(Bili bili, EditText editText) {
        this.yq = bili;
        this.SN = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        Bili.Gd(this.yq, this.SN);
    }
}

