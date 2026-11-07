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
import com.github.catvod.spider.Alllive;

public final class D
implements DialogInterface.OnClickListener {
    public final EditText SN;
    public final Alllive yq;

    public /* synthetic */ D(Alllive alllive, EditText editText) {
        this.yq = alllive;
        this.SN = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        Alllive.yq(this.yq, this.SN);
    }
}

