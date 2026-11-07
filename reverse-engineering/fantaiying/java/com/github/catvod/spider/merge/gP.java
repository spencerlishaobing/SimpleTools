/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.k_0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class gP {
    private static final Pattern i;
    private static final Pattern tF;
    private static final Pattern zH;
    private final String N;
    private final String SN;
    private final String yq;

    static {
        tF = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);
        zH = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
        i = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
    }

    public gP(String string) {
        String string2;
        this.yq = string;
        if (string != null) {
            this.SN = this.SN(string, tF, "", 1);
            string2 = this.SN(string, zH, null, 2);
        } else {
            this.SN = "";
            string2 = "UTF-8";
        }
        this.N = string2;
        if ("multipart/form-data".equalsIgnoreCase(this.SN)) {
            this.SN(string, i, null, 2);
        }
    }

    private String SN(String object, Pattern pattern, String string, int n2) {
        if (((Matcher)(object = pattern.matcher((CharSequence)object))).find()) {
            string = ((Matcher)object).group(n2);
        }
        return string;
    }

    public final String N() {
        String string;
        String string2 = string = this.N;
        if (string == null) {
            string2 = "US-ASCII";
        }
        return string2;
    }

    public final gP tF() {
        if (this.N == null) {
            return new gP(k_0.i(new StringBuilder(), this.yq, "; charset=UTF-8"));
        }
        return this;
    }

    public final String yq() {
        return this.yq;
    }
}

