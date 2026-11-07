/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.PY;
import com.github.catvod.spider.merge.ht;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class TA {
    public static Throwable N(PY pY) {
        return pY.SN();
    }

    public static String SN(byte[] byArray, boolean bl, Charset object) {
        if (object != null) {
            return new String(byArray, (Charset)object);
        }
        if (bl) {
            return new String(byArray, ht.SN);
        }
        try {
            object = new String(byArray, "Cp437");
            return object;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return new String(byArray);
        }
    }

    static Object yq(Object object, int n) {
        if (object != null) {
            return object;
        }
        object = new StringBuilder(20);
        ((StringBuilder)object).append("at index ");
        ((StringBuilder)object).append(n);
        throw new NullPointerException(((StringBuilder)object).toString());
    }
}

