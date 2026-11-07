/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.fk;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.k9;
import java.nio.channels.Pipe;
import java.util.Map;
import java.util.Objects;

public final class H
implements Runnable {
    public final Object N;
    public final Object SN;
    public final int yq;

    public /* synthetic */ H(Object object, Object object2, int n2) {
        this.yq = n2;
        this.SN = object;
        this.N = object2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 0: {
                j_0 j_02 = (j_0)this.SN;
                Object object = (Map)this.N;
                Objects.requireNonNull(j_02);
                object = k9.t0(Bo.KJ("https://passport.aliyundrive.com/newlogin/qrcode/query.do?appName=aliyun_drive&fromSite=52&_bx-v=2.2.3", (Map<String, String>)object)).SN().N();
                if (((k9)object).i()) {
                    String string = ((k9)object).zH();
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Token:");
                    ((StringBuilder)object).append(string);
                    InitOrigin.show(((StringBuilder)object).toString());
                    j_02.Gc.G4(string);
                    j_02.i3(true, false);
                }
                return;
            }
        }
        fk.yq((fk)this.SN, (Pipe.SinkChannel)this.N);
    }
}

