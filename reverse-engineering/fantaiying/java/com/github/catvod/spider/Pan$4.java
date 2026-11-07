/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package com.github.catvod.spider;

import android.content.DialogInterface;
import com.github.catvod.spider.InitOrigin;

class Pan$4
implements DialogInterface.OnClickListener {
    final String[] yq;

    Pan$4(String[] stringArray) {
        this.yq = stringArray;
    }

    public void onClick(DialogInterface object, int n) {
        object = InitOrigin.context();
        InitOrigin.context();
        object = object.getSharedPreferences("pan_sort", 0).edit();
        object.putString("sort", this.yq[n]);
        object.apply();
        object = new StringBuilder();
        ((StringBuilder)object).append("\u6392\u5e8f\u5b8c\u6210 : ");
        ((StringBuilder)object).append(this.yq[n]);
        InitOrigin.show(((StringBuilder)object).toString());
    }
}

