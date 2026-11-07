/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.Toast
 *  com.github.catvod.crawler.SpiderDebug
 */
package com.github.catvod.spider.merge;

import android.content.Context;
import android.widget.Toast;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.Bili;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.Music;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.ew_0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.y5;
import java.io.InputStream;

/*
 * Renamed from com.github.catvod.spider.merge.tO
 */
public final class to_0
implements Runnable {
    public final Object SN;
    public final int yq;

    public /* synthetic */ to_0(Object object, int n2) {
        this.yq = n2;
        this.SN = object;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 6: {
                ew_0.tF((ew_0)this.SN);
                return;
            }
            case 5: {
                InputStream inputStream = (InputStream)this.SN;
                int n2 = ProxyOrigin.Gc;
                try {
                    inputStream.close();
                }
                catch (Exception exception) {
                    SpiderDebug.log((String)"Failed to close input stream: ");
                }
                return;
            }
            case 4: {
                ((Music)((Object)this.SN)).showInputQRCode();
                return;
            }
            case 3: {
                String string = (String)this.SN;
                Toast.makeText((Context)InitOrigin.context(), (CharSequence)string, (int)1).show();
                return;
            }
            case 2: {
                Bili.W((Bili)((Object)this.SN));
                return;
            }
            case 1: {
                i3.Gc((i3)this.SN);
                return;
            }
            case 0: {
                xu_0.N((xu_0)this.SN);
                return;
            }
        }
        y5.yq((y5)this.SN);
    }
}

