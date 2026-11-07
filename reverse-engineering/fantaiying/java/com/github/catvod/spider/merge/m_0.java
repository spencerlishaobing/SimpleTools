/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.Alllive;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.M;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.xu_0;
import java.io.PrintStream;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONObject;

/*
 * Renamed from com.github.catvod.spider.merge.m
 */
public final class m_0
implements Runnable {
    public final Object SN;
    public final int yq;

    public /* synthetic */ m_0(Object object, int n2) {
        this.yq = n2;
        this.SN = object;
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 1: {
                ((Alllive)((Object)this.SN)).showInputQRCode();
                return;
            }
            case 0: {
                xu_0 xu_02 = (xu_0)this.SN;
                Objects.requireNonNull(xu_02);
                String string = ME.yq;
                long l = System.currentTimeMillis();
                string = UUID.randomUUID().toString().toUpperCase();
                Object object = new StringBuilder();
                ((StringBuilder)object).append("https://passport.baidu.com/v2/api/getqrcode?lp=pc&qrloginfrom=pc&gid=");
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append("&callback=tangram_guid_");
                ((StringBuilder)object).append(l);
                ((StringBuilder)object).append("&apiver=v3&tt=");
                ((StringBuilder)object).append(l);
                ((StringBuilder)object).append("&tpl=netdisk&logPage=traceId%3Apc_loginv5_1751366078%2ClogPage%3Aloginv5&_=");
                ((StringBuilder)object).append(l);
                Object object2 = Bo.B(((StringBuilder)object).toString(), xu_02.b(""));
                object = System.out;
                Object object3 = new StringBuilder();
                ((StringBuilder)object3).append("json-");
                ((StringBuilder)object3).append((String)object2);
                ((PrintStream)object).println(((StringBuilder)object3).toString());
                object3 = ((String)object2).substring(((String)object2).indexOf(123), ((String)object2).lastIndexOf(125) + 1);
                object = new JSONObject((String)object3);
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("https://");
                ((StringBuilder)object3).append(object.getString("imgurl"));
                object3 = ((StringBuilder)object3).toString();
                object = object.getString("sign");
                object3 = Bo.tF((String)object3).body().bytes();
                object2 = new M(xu_02, (byte[])object3, (String)object, string, l);
                InitOrigin.run((Runnable)object2);
                return;
            }
        }
        ((Pan)((Object)this.SN)).showInputQRCode();
        return;
        catch (Exception exception) {
            return;
        }
    }
}

