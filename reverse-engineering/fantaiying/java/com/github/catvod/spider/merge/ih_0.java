/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.github.catvod.spider.merge.w2;
import java.util.HashMap;

/*
 * Renamed from com.github.catvod.spider.merge.ih
 */
final class ih_0
implements Runnable {
    final String yq;

    ih_0(String string) {
        this.yq = string;
    }

    @Override
    public final void run() {
        try {
            if (TextUtils.isEmpty((CharSequence)this.yq)) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("User-Agent", "Mozilla/5.0 (X11; Linux aarch64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36");
            w2.W(this.yq, hashMap);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

