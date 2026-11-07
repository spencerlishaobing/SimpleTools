/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.github.catvod.spider.merge;

import android.os.Build;
import com.github.catvod.spider.InitOrigin;

public final class F1 {
    private static Integer yq;

    public static boolean yq() {
        int n2;
        boolean bl;
        block7: {
            Integer n3 = yq;
            bl = false;
            if (n3 != null) {
                n2 = n3;
            } else {
                block6: {
                    n3 = InitOrigin.context();
                    if (n3 == null) break block6;
                    try {
                        yq = n3 = Integer.valueOf(n3.getPackageManager().getPackageInfo((String)n3.getPackageName(), (int)0).applicationInfo.targetSdkVersion);
                        n2 = n3;
                        break block7;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
                n2 = Build.VERSION.SDK_INT;
            }
        }
        if (n2 >= 37) {
            bl = true;
        }
        return bl;
    }
}

