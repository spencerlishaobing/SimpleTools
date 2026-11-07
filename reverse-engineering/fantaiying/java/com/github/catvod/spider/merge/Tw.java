/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nh;
import java.nio.charset.Charset;

public final class Tw {
    public static final Charset yq;

    static {
        Charset charset = Charset.forName("UTF-8");
        Nh.tF(charset, "forName(\"UTF-8\")");
        yq = charset;
        Nh.tF(Charset.forName("UTF-16"), "forName(\"UTF-16\")");
        Nh.tF(Charset.forName("UTF-16BE"), "forName(\"UTF-16BE\")");
        Nh.tF(Charset.forName("UTF-16LE"), "forName(\"UTF-16LE\")");
        Nh.tF(Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        Nh.tF(Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }
}

