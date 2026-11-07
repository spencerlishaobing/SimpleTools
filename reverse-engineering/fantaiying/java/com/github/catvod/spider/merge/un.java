/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.Toast
 *  com.google.net.cronet.okhttptransport.CronetInterceptor
 */
package com.github.catvod.spider.merge;

import android.content.Context;
import android.widget.Toast;
import com.github.catvod.spider.Bili;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Zm;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.k9;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.xu_0;
import com.google.net.cronet.okhttptransport.CronetInterceptor;
import java.util.Objects;

public final class un
implements Runnable {
    public final Object SN;
    public final int yq;

    public /* synthetic */ un(Object object, int n2) {
        this.yq = n2;
        this.SN = object;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 3: {
                Exception exception = (Exception)this.SN;
                String string = ME.yq;
                string = InitOrigin.context();
                StringBuilder stringBuilder = oi_0.yq("\u521d\u59cb\u5316\u5931\u8d25:");
                stringBuilder.append(exception.getCause().getMessage());
                Toast.makeText((Context)string, (CharSequence)stringBuilder.toString(), (int)1).show();
                return;
            }
            case 2: {
                Bili.ee((Bili)((Object)this.SN));
                return;
            }
            case 1: {
                xu_0.Gc((xu_0)this.SN);
                return;
            }
            case 0: {
                j_0 j_02 = (j_0)this.SN;
                Objects.requireNonNull(j_02);
                InitOrigin.run(new Zm(j_02, k9.t0(Bo.B("https://passport.aliyundrive.com/newlogin/qrcode/generate.do?appName=aliyun_drive&fromSite=52&appName=aliyun_drive&appEntrance=web&isMobile=false&lang=zh_CN&returnUrl=&bizParams=&_bx-v=2.2.3", null)).SN().N(), 0));
                return;
            }
        }
        CronetInterceptor.yq((CronetInterceptor)((CronetInterceptor)this.SN));
    }
}

