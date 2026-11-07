/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 *  com.github.catvod.crawler.SpiderDebug
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import android.util.Base64;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.IV;
import com.github.catvod.spider.merge.MJ;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.ht;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.nQ;
import com.github.catvod.spider.merge.rs_1;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/*
 * Renamed from com.github.catvod.spider.merge.rS
 */
public final class rs_0 {
    public static long B(long l) {
        int n2 = (int)(l << 1 & 0x3EL);
        int n3 = (int)(l >> 5 & 0x3FL);
        int n4 = (int)(l >> 11 & 0x1FL);
        int n5 = (int)(l >> 16 & 0x1FL);
        int n7 = (int)((l >> 21 & 0xFL) - 1L);
        int n8 = (int)((l >> 25 & 0x7FL) + 1980L);
        Calendar calendar = Calendar.getInstance();
        calendar.set(n8, n7, n5, n4, n3, n2);
        calendar.set(14, 0);
        return calendar.getTime().getTime() + (l >> 32);
    }

    public static String F5(String string, String object) {
        Serializable serializable = new SecretKeySpec(((String)object).getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        object = Mac.getInstance("HmacSHA256");
        ((Mac)object).init((Key)serializable);
        object = ((Mac)object).doFinal(string.getBytes(StandardCharsets.UTF_8));
        serializable = new StringBuilder();
        int n2 = ((Object)object).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            string = Integer.toHexString(object[i2] & 0xFF);
            if (string.length() == 1) {
                ((StringBuilder)serializable).append('0');
            }
            ((StringBuilder)serializable).append(string);
            continue;
        }
        try {
            string = ((StringBuilder)serializable).toString();
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static String G(String string, String object, String string2, int n2) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return string;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(((String)object).getBytes("UTF-8"), "AES");
            object = Cipher.getInstance("AES/CBC/PKCS7Padding");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(string2.getBytes());
            ((Cipher)object).init(1, (Key)secretKeySpec, ivParameterSpec);
            string = MJ.SN(((Cipher)object).doFinal(string.getBytes("UTF-8")), n2);
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static int G4(nQ nQ2) {
        if (nQ2.H() != 3) {
            return nQ2.H();
        }
        if (nQ2.Dr() != null) {
            return nQ2.Dr().H();
        }
        throw new RuntimeException("AesExtraDataRecord not present in local header for aes encrypted data");
    }

    public static void Gc(int n2, int n3, int n4) {
        if (n2 >= 0 && n3 >= n2 && n3 <= n4) {
            return;
        }
        String string = n2 >= 0 && n2 <= n4 ? (n3 >= 0 && n3 <= n4 ? rs_1.W("end index (%s) must not be less than start index (%s)", n3, n2) : rs_0.N(n3, n4, "end index")) : rs_0.N(n2, n4, "start index");
        throw new IndexOutOfBoundsException(string);
    }

    public static void KJ(boolean bl, Object object) {
        if (bl) {
            return;
        }
        throw new IllegalStateException(String.valueOf(object));
    }

    public static void M(boolean bl) {
        if (bl) {
            return;
        }
        throw new IllegalStateException();
    }

    private static String N(int n2, int n3, String charSequence) {
        if (n2 < 0) {
            return rs_1.W("%s (%s) must not be negative", charSequence, n2);
        }
        if (n3 >= 0) {
            return rs_1.W("%s (%s) must not be greater than size (%s)", charSequence, n2, n3);
        }
        charSequence = new StringBuilder(26);
        ((StringBuilder)charSequence).append("negative size: ");
        ((StringBuilder)charSequence).append(n3);
        throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
    }

    public static byte[] SN(byte[] byArray, byte[] byArray2, byte[] object) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            IvParameterSpec ivParameterSpec = new IvParameterSpec((byte[])object);
            object = new SecretKeySpec;
            object(byArray2, "AES");
            cipher.init(2, (Key)object, ivParameterSpec);
            byArray = cipher.doFinal(byArray);
            return byArray;
        }
        catch (Exception exception) {
            SpiderDebug.log((Throwable)exception);
            return null;
        }
    }

    public static int W(InputStream object, byte[] byArray, int n2, int n3) {
        if (n2 >= 0) {
            if (n3 >= 0) {
                if (n3 == 0) {
                    return 0;
                }
                if (n2 + n3 <= byArray.length) {
                    int n4;
                    int n5;
                    for (n4 = 0; n4 != n3; n4 += n5) {
                        n5 = ((InputStream)object).read(byArray, n2 + n4, n3 - n4);
                        if (n5 != -1) continue;
                        if (n4 == 0) {
                            return -1;
                        }
                        return n4;
                    }
                    return n4;
                }
                throw new IllegalArgumentException("Length greater than buffer size");
            }
            throw new IllegalArgumentException("Negative length");
        }
        object = new IllegalArgumentException("Negative offset");
        throw object;
    }

    public static String dT(String object) {
        object = MessageDigest.getInstance("SHA-256").digest(((String)object).getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = ((Object)object).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = Integer.toHexString(object[i2] & 0xFF);
            if (string.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string);
            continue;
        }
        try {
            object = stringBuilder.toString();
            return object;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            RuntimeException runtimeException = new RuntimeException(noSuchAlgorithmException);
            throw runtimeException;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int i(int n2, int n3) {
        String string;
        if (n2 >= 0) {
            if (n2 < n3) return n2;
        }
        if (n2 < 0) {
            string = rs_1.W("%s (%s) must not be negative", "index", n2);
            throw new IndexOutOfBoundsException(string);
        }
        if (n3 >= 0) {
            string = rs_1.W("%s (%s) must be less than size (%s)", "index", n2, n3);
            throw new IndexOutOfBoundsException(string);
        }
        StringBuilder stringBuilder = new StringBuilder(26);
        stringBuilder.append("negative size: ");
        stringBuilder.append(n3);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static byte[] q(char[] cArray) {
        try {
            ByteBuffer byteBuffer = ht.SN.encode(CharBuffer.wrap(cArray));
            byte[] byArray = new byte[byteBuffer.limit()];
            byteBuffer.get(byArray);
            return byArray;
        }
        catch (Exception exception) {
            byte[] byArray = new byte[cArray.length];
            for (int i2 = 0; i2 < cArray.length; ++i2) {
                byArray[i2] = (byte)cArray[i2];
            }
            return byArray;
        }
    }

    public static int t0(int n2, int n3) {
        if (n2 >= 0 && n2 <= n3) {
            return n2;
        }
        throw new IndexOutOfBoundsException(rs_0.N(n2, n3, "index"));
    }

    public static String tF(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = byArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = Integer.toHexString(byArray[i2] & 0xFF);
            CharSequence charSequence = string;
            if (string.length() == 1) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append('0');
                ((StringBuilder)charSequence).append(string);
                charSequence = ((StringBuilder)charSequence).toString();
            }
            stringBuilder.append((String)charSequence);
        }
        return stringBuilder.toString();
    }

    public static void v(IV iV, iK iK2) {
        co_0.Gc(iK2);
        iK iK3 = iK2;
        int n2 = 0;
        while (iK3 != null) {
            iK iK4 = iK3.O();
            int n3 = iK4 != null ? iK4.t0() : 0;
            iK iK5 = iK3.W();
            iV.SN(iK3, n2);
            iK iK6 = iK3;
            if (iK4 != null) {
                iK6 = iK3;
                if (!iK3.F5()) {
                    if (n3 == iK4.t0()) {
                        iK6 = iK4.i(iK3.Dr());
                    } else {
                        if (iK5 == null) {
                            --n2;
                            iK3 = iK4;
                            continue;
                        }
                        iK3 = iK5;
                        continue;
                    }
                }
            }
            iK3 = iK6;
            if (iK6.t0() > 0) {
                iK3 = iK6.i(0);
                continue;
            }
            for (n3 = n2++; iK3.W() == null && n3 > 0; --n3) {
                iV.yq(iK3, n3);
                iK3 = iK3.O();
            }
            iV.yq(iK3, n3);
            if (iK3 == iK2) break;
            iK3 = iK3.W();
            n2 = n3;
        }
    }

    public static int v3(InputStream inputStream, byte[] byArray) {
        int n2;
        int n3 = n2 = inputStream.read(byArray);
        if (n2 != byArray.length) {
            int n4 = byArray.length - n2;
            int n5 = 0;
            for (n3 = 1; n2 < byArray.length && n5 != -1 && n3 < 15; ++n3) {
                int n7 = inputStream.read(byArray, n2, n4);
                int n8 = n2;
                n5 = n4;
                if (n7 > 0) {
                    n8 = n2 + n7;
                    n5 = n4 - n7;
                }
                n2 = n8;
                n4 = n5;
                n5 = n7;
            }
            if (n2 == byArray.length) {
                n3 = n2;
            } else {
                throw new IOException("Cannot read fully into byte buffer");
            }
        }
        return n3;
    }

    public static String yq(String string, String string2, String string3) {
        return new String(rs_0.SN(Base64.decode((byte[])string.getBytes(), (int)0), string2.getBytes(), string3.getBytes()));
    }

    public static void zH(boolean bl, Object object) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(object));
    }
}

