/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.t_0;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public final class U7 {
    static final Object[] SN;
    static final int[] yq;

    static {
        yq = new int[0];
        SN = new Object[0];
    }

    public static void B(String string, String string2, JSONArray jSONArray) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type_id", (Object)string);
            jSONObject.put("type_name", (Object)string2);
            string = new JSONObject(jSONObject.toString());
            jSONArray.put((Object)string);
        }
        catch (Exception exception) {
            SpiderDebug.log((Throwable)exception);
        }
    }

    static int G(int n2) {
        return (int)((long)Integer.rotateLeft((int)((long)n2 * -862048943L), 15) * 461845907L);
    }

    public static String Gc(Iterator iterator, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static String KJ(String string) {
        return U7.M(string).trim();
    }

    public static String M(String string) {
        string = string != null ? string.toLowerCase(Locale.ENGLISH) : "";
        return string;
    }

    static int N(t_0 object) {
        byte[][] byArray = ((t_0)object).N();
        int n2 = ((t_0)object).zH();
        int n3 = ((t_0)object).tF();
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i4 = 0; i4 < n2; ++i4) {
                int n5;
                int n7;
                block6: {
                    block7: {
                        object = byArray[i2];
                        n7 = i4 + 6;
                        n5 = n4;
                        if (n7 >= n2) break block6;
                        n5 = n4;
                        if (object[i4] != true) break block6;
                        n5 = n4;
                        if (object[i4 + 1] != false) break block6;
                        n5 = n4;
                        if (object[i4 + 2] != true) break block6;
                        n5 = n4;
                        if (object[i4 + 3] != true) break block6;
                        n5 = n4;
                        if (object[i4 + 4] != true) break block6;
                        n5 = n4;
                        if (object[i4 + 5] != false) break block6;
                        n5 = n4;
                        if (object[n7] != true) break block6;
                        if (U7.i((byte[])object, i4 - 4, i4)) break block7;
                        n5 = n4;
                        if (!U7.i((byte[])object, i4 + 7, i4 + 11)) break block6;
                    }
                    n5 = n4 + 1;
                }
                n7 = i2 + 6;
                n4 = n5;
                if (n7 >= n3) continue;
                n4 = n5;
                if (byArray[i2][i4] != 1) continue;
                n4 = n5;
                if (byArray[i2 + 1][i4] != 0) continue;
                n4 = n5;
                if (byArray[i2 + 2][i4] != 1) continue;
                n4 = n5;
                if (byArray[i2 + 3][i4] != 1) continue;
                n4 = n5;
                if (byArray[i2 + 4][i4] != 1) continue;
                n4 = n5;
                if (byArray[i2 + 5][i4] != 0) continue;
                n4 = n5;
                if (byArray[n7][i4] != 1) continue;
                if (!U7.t0(byArray, i4, i2 - 4, i2)) {
                    n4 = n5;
                    if (!U7.t0(byArray, i4, i2 + 7, i2 + 11)) continue;
                }
                n4 = n5 + 1;
            }
        }
        return n4 * 40;
    }

    private static int SN(t_0 object, boolean bl) {
        int n2 = bl ? ((t_0)object).tF() : ((t_0)object).zH();
        int n3 = bl ? ((t_0)object).zH() : ((t_0)object).tF();
        object = ((t_0)object).N();
        int n4 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5 = -1;
            Object object2 = 0;
            for (int i4 = 0; i4 < n3; ++i4) {
                Object object3 = bl ? object[i2][i4] : object[i4][i2];
                if (object3 == n5) {
                    object3 = object2 + 1;
                    object2 = n5;
                } else {
                    n5 = n4;
                    if (object2 >= 5) {
                        n5 = n4 + (object2 - 5 + 3);
                    }
                    object2 = object3;
                    object3 = true;
                    n4 = n5;
                }
                n5 = object2;
                object2 = object3;
            }
            n5 = n4;
            if (object2 >= 5) {
                n5 = object2 - 5 + 3 + n4;
            }
            n4 = n5;
        }
        return n4;
    }

    private static boolean i(byte[] byArray, int n2, int n3) {
        n3 = Math.min(n3, byArray.length);
        for (n2 = Math.max(n2, 0); n2 < n3; ++n2) {
            if (byArray[n2] != 1) continue;
            return false;
        }
        return true;
    }

    public static void q(JSONArray jSONArray, JSONObject jSONObject, String string) {
        jSONObject.put("page", (Object)string);
        int n2 = jSONArray.length();
        int n3 = Integer.MAX_VALUE;
        n2 = n2 == 0 ? 1 : Integer.MAX_VALUE;
        jSONObject.put("pagecount", n2);
        jSONObject.put("limit", jSONArray.length());
        n2 = n3;
        try {
            if (jSONArray.length() == 0) {
                n2 = jSONArray.length();
            }
            jSONObject.put("total", n2);
            jSONObject.put("list", (Object)jSONArray);
        }
        catch (Exception exception) {
            SpiderDebug.log((Throwable)exception);
        }
    }

    private static boolean t0(byte[][] byArray, int n2, int n3, int n4) {
        n4 = Math.min(n4, byArray.length);
        for (n3 = Math.max(n3, 0); n3 < n4; ++n3) {
            if (byArray[n3][n2] != 1) continue;
            return false;
        }
        return true;
    }

    public static boolean tF(Object object, Object object2) {
        boolean bl = object == object2 || object != null && object.equals(object2);
        return bl;
    }

    static int yq(t_0 t_02) {
        return U7.SN(t_02, true) + U7.SN(t_02, false);
    }

    public static boolean zH(CharSequence charSequence, CharSequence charSequence2) {
        int n2 = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (n2 != charSequence2.length()) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            char c;
            char c2 = charSequence.charAt(i2);
            if (c2 == (c = charSequence2.charAt(i2)) || (c2 = (char)((c2 | 0x20) - 97)) < '\u001a' && c2 == (char)((c | 0x20) - 97)) {
                continue;
            }
            return false;
        }
        return true;
    }
}

