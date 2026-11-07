/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.Objects;

/*
 * Renamed from com.github.catvod.spider.merge.zH
 */
public final class zh_0 {
    public static StringBuilder N(String string, String string2, String string3, String string4, String string5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(string4);
        stringBuilder.append(string5);
        return stringBuilder;
    }

    public static /* synthetic */ String SN(Iterable object) {
        StringBuilder stringBuilder = new StringBuilder();
        if ((object = object.iterator()).hasNext()) {
            while (true) {
                stringBuilder.append((CharSequence)object.next());
                if (!object.hasNext()) break;
                stringBuilder.append((CharSequence)"/");
            }
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ String tF(int n2) {
        if (n2 == 1) {
            return "L";
        }
        if (n2 == 2) {
            return "M";
        }
        if (n2 == 3) {
            return "Q";
        }
        if (n2 == 4) {
            return "H";
        }
        return "null";
    }

    public static /* synthetic */ int yq(int n2) {
        if (n2 == 1) {
            return 1;
        }
        if (n2 == 2) {
            return 0;
        }
        if (n2 == 3) {
            return 3;
        }
        if (n2 == 4) {
            return 2;
        }
        throw null;
    }

    public static /* synthetic */ int zH(String string) {
        Objects.requireNonNull(string, "Name is null");
        if (string.equals("L")) {
            return 1;
        }
        if (string.equals("M")) {
            return 2;
        }
        if (string.equals("Q")) {
            return 3;
        }
        if (string.equals("H")) {
            return 4;
        }
        throw new IllegalArgumentException("No enum constant com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.".concat(string));
    }
}

