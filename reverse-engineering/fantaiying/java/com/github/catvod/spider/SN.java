/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider;

import com.github.catvod.spider.KkSs;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.UuSs;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.zm_0;
import java.util.Objects;
import java.util.concurrent.Callable;

public final class SN
implements Callable {
    public final String N;
    public final String SN;
    public final Pan tF;
    public final int yq;

    public /* synthetic */ SN(Pan pan, String string, String string2, int n) {
        this.yq = n;
        this.tF = pan;
        this.SN = string;
        this.N = string2;
    }

    public final Object call() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                Object object = (KkSs)this.tF;
                String string = this.SN;
                String string2 = this.N;
                Objects.requireNonNull(object);
                try {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string);
                    ((StringBuilder)object).append("index.php/vod/search.html?wd=");
                    ((StringBuilder)object).append(string2);
                    string2 = zm_0.SN(((StringBuilder)object).toString(), ME.yq(), 6);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    string2 = null;
                }
                return new KkSs.WebsiteResponse(string, string2);
            }
        }
        Object object = (UuSs)this.tF;
        String string = this.SN;
        String string3 = this.N;
        Objects.requireNonNull(object);
        try {
            object = new StringBuilder();
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append("index.php/vod/search.html?wd=");
            ((StringBuilder)object).append(string3);
            string3 = zm_0.SN(((StringBuilder)object).toString(), ME.yq(), 6);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            string3 = "";
        }
        return new UuSs.WebsiteResponse(string, string3);
    }
}

