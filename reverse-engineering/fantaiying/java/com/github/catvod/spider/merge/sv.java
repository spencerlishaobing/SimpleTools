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
import com.github.catvod.spider.Music;

public final class sv
implements DialogInterface.OnClickListener {
    public final EditText SN;
    public final Music yq;

    public /* synthetic */ sv(Music music, EditText editText) {
        this.yq = music;
        this.SN = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        Music.yq(this.yq, this.SN);
    }
}

