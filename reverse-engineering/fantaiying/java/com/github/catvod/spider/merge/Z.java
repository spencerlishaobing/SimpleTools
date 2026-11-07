/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 */
package com.github.catvod.spider.merge;

import com.google.gson.Gson;

public final class Z {
    public static String SN(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public static Object yq(String string, Class clazz) {
        return new Gson().fromJson(string, clazz);
    }
}

