/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.cu_0;
import com.github.catvod.spider.merge.w2;
import java.util.Objects;
import java.util.concurrent.Callable;

public final class rz
implements Callable {
    public final String SN;
    public final cu_0 yq;

    public /* synthetic */ rz(cu_0 cu_02, String string) {
        this.yq = cu_02;
        this.SN = string;
    }

    public final Object call() {
        Object object = this.yq;
        String string = this.SN;
        Objects.requireNonNull(object);
        System.currentTimeMillis();
        object = string.contains("&ajax") ? string.split("&")[0] : string;
        try {
            object = w2.M((String)object, ME.M("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKlt/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36"), 7);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = null;
        }
        if (object != null && object.isSuccessful() && object.code() >= 200 && object.code() <= 302) {
            System.currentTimeMillis();
            object = new cu_0.yq(string, object.body().string());
        } else {
            System.currentTimeMillis();
            object = new cu_0.yq(string, "");
        }
        return object;
    }
}

