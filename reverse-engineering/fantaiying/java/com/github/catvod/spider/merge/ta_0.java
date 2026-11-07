/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.nio.charset.Charset;
import java.util.regex.Pattern;

/*
 * Renamed from com.github.catvod.spider.merge.Ta
 */
public final class ta_0 {
    public static final Charset yq;

    static {
        Charset charset;
        Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");
        yq = charset = Charset.forName("UTF-8");
        charset.name();
        "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }
}

