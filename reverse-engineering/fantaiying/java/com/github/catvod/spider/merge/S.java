/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.github.catvod.spider.merge;

import android.content.Context;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.spider.merge.uA;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;

final class S
implements Runnable {
    final Context yq;

    S(Context context) {
        this.yq = context;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Context \ufe8f\u062f\u062a\ufe8e(Object object) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return null;
        return ((S)object).yq;
    }

    public static void \ufea5\ufead\ufee9\ufe99(Object object) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() > 0) {
            uA.yq((Context)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final void run() {
        S.\ufea5\ufead\ufee9\ufe99(S.\ufe8f\u062f\u062a\ufe8e(this));
        int n2 = \u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628();
        int n3 = 1616;
        block6: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (n2 >= 0) {
                        n3 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block6;
                }
                case 204: {
                    Long l = Long.decode(\ufeb9\u0627\ufea5\ufe9d.\u0648\u0647\u0628\u062b("GAhayI5Ki"));
                    System.out.println(l);
                    return;
                }
                case 239: 
            }
            break;
        }
    }
}

