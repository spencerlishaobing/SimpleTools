/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import java.io.ByteArrayOutputStream;

public class \ufee9\u0631\ufeb5\u0628 {
    public static int \ufecd\ufeb1\u0648\ufea1 = -703;

    public static String \u0636\ufeab\u0634\u0633(short[] sArray, int n2, int n3, int n4) {
        char[] cArray = new char[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            cArray[i2] = (char)(sArray[n2 + i2] ^ n4);
        }
        return new String(cArray);
    }

    public static int \u0645\ufea5\u0639\u0640() {
        return 0xFFFFFFCD ^ \u0630\ufebd\u0634\ufec9.\u0630\ufec1\ufea9\ufea5;
    }

    public static int \u0647\ufeab\u0636\u063a(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufed9\ufeed\ufe8f\ufed5(String object) {
        int n2 = 0;
        String string = "";
        String string2 = "";
        int n3 = 0;
        while (true) {
            if (n3 >= 15) break;
            string = new StringBuffer().append(string).append(Integer.toHexString(n3)).toString();
            string2 = new StringBuffer().append(string2).append((int)(Math.random() * (double)10) ^ n3).toString();
            ++n3;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((String)object).length() / 2);
        n3 = 0;
        while (true) {
            if (n3 >= ((String)object).length()) break;
            byteArrayOutputStream.write(string.indexOf(((String)object).charAt(n3)) << 4 | string.indexOf(((String)object).charAt(n3 + 1)));
            n3 += 2;
        }
        object = byteArrayOutputStream.toByteArray();
        int n4 = ((Object)object).length;
        int n5 = string2.length();
        n3 = 0;
        while (true) {
            if (n3 >= n4) break;
            object[n3] = (byte)(object[n3] ^ string2.charAt(n3 % n5));
            ++n3;
        }
        n3 = n2;
        while (n3 < ((Object)object).length) {
            n3 = "".length() + 1;
        }
        return new String((byte[])object);
    }
}

