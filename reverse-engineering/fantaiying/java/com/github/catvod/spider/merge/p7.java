/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 */
package com.github.catvod.spider.merge;

import android.content.SharedPreferences;
import com.github.catvod.spider.InitOrigin;

public final class p7 {
    private static SharedPreferences N() {
        return InitOrigin.context().getSharedPreferences("spUtils", 0);
    }

    public static int SN(String string) {
        return p7.N().getInt(string, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void i(String string, Object object) {
        if (object == null) {
            return;
        }
        if (object instanceof String) {
            string = p7.N().edit().putString(string, (String)object);
        } else if (object instanceof Boolean) {
            string = p7.N().edit().putBoolean(string, ((Boolean)object).booleanValue());
        } else if (object instanceof Float) {
            string = p7.N().edit().putFloat(string, ((Float)object).floatValue());
        } else if (object instanceof Integer) {
            string = p7.N().edit().putInt(string, ((Integer)object).intValue());
        } else {
            if (!(object instanceof Long)) return;
            string = p7.N().edit().putLong(string, ((Long)object).longValue());
        }
        string.apply();
    }

    public static String tF(String string) {
        return p7.zH(string, "");
    }

    public static boolean yq(String string, boolean bl) {
        return p7.N().getBoolean(string, bl);
    }

    public static String zH(String string, String string2) {
        return p7.N().getString(string, string2);
    }
}

