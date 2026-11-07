/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  android.util.Log
 */
package com.github.catvod.spider.merge;

import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class Xu {
    public static final Charset SN;
    public static final String yq;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Xu.class.getSimpleName());
        stringBuilder.append(" --> ");
        yq = stringBuilder.toString();
        SN = Charset.forName("UTF-8");
    }

    private static void N(Exception exception) {
        exception.printStackTrace();
        String string = yq;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(exception);
        Log.e((String)string, (String)stringBuilder.toString());
    }

    /*
     * Unable to fully structure code
     */
    public static String SN(String var0, String var1_3) {
        var6_4 = null;
        var7_5 = var0.getBytes(Xu.SN);
        var8_6 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        try {
            var1_3 = Base64.decode((String)var1_3, (int)2);
            var0 = KeyFactory.getInstance("RSA");
            var9_7 = new X509EncodedKeySpec((byte[])var1_3);
            var0 = var0.generatePublic(var9_7);
        }
        catch (Exception var0_1) {
            Xu.N(var0_1);
            var0 = null;
        }
        var8_6.init(1, (Key)var0);
        var4_8 = var7_5.length;
        var1_3 = new ByteArrayOutputStream();
        var2_9 = 0;
        var3_10 = 0;
        while ((var5_11 = var4_8 - var2_9) > 0) {
            block9: {
                if (var5_11 <= 117) ** GOTO lbl26
                var0 = var8_6.doFinal(var7_5, var2_9, 117);
                break block9;
lbl26:
                // 1 sources

                var0 = var8_6.doFinal(var7_5, var2_9, var5_11);
            }
            var1_3.write((byte[])var0, 0, ((Object)var0).length);
            var2_9 = ++var3_10 * 117;
        }
        var0 = var1_3.toByteArray();
        var1_3.close();
        var0 = Base64.encodeToString((byte[])var0, (int)2);
        {
            catch (Exception var0_2) {
                Xu.N(var0_2);
                var0 = var6_4;
            }
        }
        return var0;
    }

    /*
     * Unable to fully structure code
     */
    public static String yq(String var0, String var1_3) {
        var8_4 = Base64.decode((String)var0, (int)2);
        var6_5 = null;
        var7_6 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        try {
            var0 = Base64.decode((String)var1_3, (int)2);
            var1_3 = KeyFactory.getInstance("RSA");
            var9_7 = new PKCS8EncodedKeySpec((byte[])var0);
            var0 = var1_3.generatePrivate(var9_7);
        }
        catch (Exception var0_1) {
            Xu.N(var0_1);
            var0 = null;
        }
        var7_6.init(2, (Key)var0);
        var4_8 = var8_4.length;
        var1_3 = new ByteArrayOutputStream();
        var3_9 = 0;
        var2_10 = 0;
        while ((var5_11 = var4_8 - var3_9) > 0) {
            block9: {
                if (var5_11 <= 128) ** GOTO lbl26
                var0 = var7_6.doFinal(var8_4, var3_9, 128);
                break block9;
lbl26:
                // 1 sources

                var0 = var7_6.doFinal(var8_4, var3_9, var5_11);
            }
            var1_3.write((byte[])var0, 0, ((Object)var0).length);
            var3_9 = ++var2_10 * 128;
        }
        var0 = var1_3.toByteArray();
        var1_3.close();
        var0 = new String((byte[])var0, Xu.SN);
        {
            catch (Exception var0_2) {
                Xu.N(var0_2);
                var0 = var6_5;
            }
        }
        return var0;
    }
}

