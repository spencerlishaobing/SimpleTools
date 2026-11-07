/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.preference.PreferenceManager
 */
package com.github.catvod.spider.merge;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.github.catvod.spider.InitOrigin;

public final class K {
    private static SharedPreferences N() {
        return PreferenceManager.getDefaultSharedPreferences((Context)InitOrigin.context());
    }

    public static boolean SN(String string) {
        return K.N().getBoolean(string, false);
    }

    public static void tF() {
        Boolean bl = Boolean.FALSE;
        if (bl == null) {
            return;
        }
        bl = bl instanceof String ? K.N().edit().putString("danmu_load", (String)((Object)bl)) : K.N().edit().putBoolean("danmu_load", bl.booleanValue());
        bl.apply();
    }

    public static Boolean yq() {
        if (K.N().contains("danmu_load")) {
            return K.N().getBoolean("danmu_load", false);
        }
        return null;
    }
}

