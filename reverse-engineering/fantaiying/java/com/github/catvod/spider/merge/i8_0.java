/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.oi_0;

/*
 * Renamed from com.github.catvod.spider.merge.i8
 */
public final class i8_0 {
    public String N;
    public int SN;
    public int yq;

    public i8_0(int n2, int n3, String string) {
        this.yq = n2;
        this.SN = n3;
        this.N = string;
    }

    public final String toString() {
        StringBuilder stringBuilder = oi_0.yq("TaskTemplate{template_width=");
        stringBuilder.append(this.yq);
        stringBuilder.append(", template_height=");
        stringBuilder.append(this.SN);
        stringBuilder.append(", url='");
        stringBuilder.append(this.N);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

