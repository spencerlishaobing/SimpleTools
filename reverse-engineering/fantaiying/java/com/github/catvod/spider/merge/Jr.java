/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;

public final class Jr {
    private final String SN;
    private final int yq;

    public Jr() {
        this.yq = 500;
        this.SN = "";
    }

    public Jr(int n2, String string) {
        this.yq = n2;
        this.SN = string;
    }

    public final int SN() {
        return this.yq;
    }

    public final String yq() {
        String string = TextUtils.isEmpty((CharSequence)this.SN) ? "" : this.SN;
        return string;
    }
}

