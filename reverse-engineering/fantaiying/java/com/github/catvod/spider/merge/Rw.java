/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 */
package com.github.catvod.spider.merge;

import android.graphics.Bitmap;
import com.github.catvod.spider.merge.F;
import com.github.catvod.spider.merge.Gj;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.zk_0;
import java.util.EnumMap;
import java.util.Map;

public final class Rw {
    public static Bitmap yq(String object, int n2, int n3) {
        Cloneable cloneable = new EnumMap(zk_0.class);
        ((EnumMap)cloneable).put((Object)zk_0.SN, "UTF-8");
        ((EnumMap)cloneable).put((Object)zk_0.i, (Object)n3);
        co_0 co_02 = new co_0();
        cloneable = co_02.yq((String)object, Gj.KJ, ME.q(n2), ME.q(n2), (Map)((Object)cloneable));
        int n4 = ((F)cloneable).N();
        int n5 = ((F)cloneable).SN();
        object = new int[n4 * n5];
        for (n2 = 0; n2 < n5; ++n2) {
            for (n3 = 0; n3 < n4; ++n3) {
                int n7 = ((F)cloneable).yq(n3, n2) ? -16777216 : -1;
                object[n2 * n4 + n3] = n7;
            }
        }
        try {
            cloneable = Bitmap.createBitmap((int)n4, (int)n5, (Bitmap.Config)Bitmap.Config.ARGB_8888);
            cloneable.setPixels((int[])object, 0, n4, 0, 0, n4, n5);
            return cloneable;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}

