/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.github.catvod.spider.merge.uA;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.zm_0;
import java.util.HashMap;
import java.util.regex.Matcher;

final class wD
implements Runnable {
    final String yq;

    wD(String string) {
        this.yq = string;
    }

    @Override
    public final void run() {
        block5: {
            if (TextUtils.isEmpty((CharSequence)this.yq)) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("User-Agent", "Mozilla/5.0 (X11; Linux aarch64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36");
            String string = zm_0.SN(this.yq, hashMap, 0);
            if (!string.contains("btwaf")) break block5;
            Object object = uA.tF().matcher(string);
            string = "";
            try {
                if (((Matcher)object).find()) {
                    string = ((Matcher)object).group(0);
                }
                object = new StringBuilder();
                ((StringBuilder)object).append(this.yq);
                ((StringBuilder)object).append("?btwaf=");
                ((StringBuilder)object).append(string);
                w2.W(((StringBuilder)object).toString(), hashMap);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

