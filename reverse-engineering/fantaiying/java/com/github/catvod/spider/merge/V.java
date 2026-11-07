/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.HashMap;
import java.util.Objects;

public final class V {
    public static /* synthetic */ String N(Iterable object) {
        StringBuilder stringBuilder = new StringBuilder();
        if ((object = object.iterator()).hasNext()) {
            while (true) {
                stringBuilder.append((CharSequence)object.next());
                if (!object.hasNext()) break;
                stringBuilder.append((CharSequence)"-");
            }
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ long SN(int n2) {
        if (n2 == 1) {
            return 67324752L;
        }
        if (n2 == 2) {
            return 134695760L;
        }
        if (n2 == 3) {
            return 33639248L;
        }
        if (n2 == 4) {
            return 101010256L;
        }
        if (n2 == 5) {
            return 808471376L;
        }
        if (n2 == 6) {
            return 84233040L;
        }
        if (n2 == 7) {
            return 134630224L;
        }
        if (n2 == 8) {
            return 134695760L;
        }
        if (n2 == 9) {
            return 117853008L;
        }
        if (n2 == 10) {
            return 101075792L;
        }
        if (n2 == 11) {
            return 1L;
        }
        if (n2 == 12) {
            return 39169L;
        }
        throw null;
    }

    public static /* synthetic */ int i(String string) {
        Objects.requireNonNull(string, "Name is null");
        if (string.equals("GET")) {
            return 1;
        }
        if (string.equals("PUT")) {
            return 2;
        }
        if (string.equals("POST")) {
            return 3;
        }
        if (string.equals("DELETE")) {
            return 4;
        }
        if (string.equals("HEAD")) {
            return 5;
        }
        if (string.equals("OPTIONS")) {
            return 6;
        }
        if (string.equals("TRACE")) {
            return 7;
        }
        if (string.equals("CONNECT")) {
            return 8;
        }
        if (string.equals("PATCH")) {
            return 9;
        }
        if (string.equals("PROPFIND")) {
            return 10;
        }
        if (string.equals("PROPPATCH")) {
            return 11;
        }
        if (string.equals("MKCOL")) {
            return 12;
        }
        if (string.equals("MOVE")) {
            return 13;
        }
        if (string.equals("COPY")) {
            return 14;
        }
        if (string.equals("LOCK")) {
            return 15;
        }
        if (string.equals("UNLOCK")) {
            return 16;
        }
        if (string.equals("NOTIFY")) {
            return 17;
        }
        if (string.equals("SUBSCRIBE")) {
            return 18;
        }
        throw new IllegalArgumentException("No enum constant org.nanohttpd.protocols.http.request.Method.".concat(string));
    }

    public static HashMap tF(String string, String string2, String string3, String string4) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put(string, string2);
        hashMap.put(string3, string4);
        return hashMap;
    }

    public static int yq(String string) {
        if (string == null) {
            return 0;
        }
        try {
            int n2 = V.i(string);
            return n2;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return 0;
        }
    }

    public static /* synthetic */ String zH(int n2) {
        if (n2 == 1) {
            return "GET";
        }
        if (n2 == 2) {
            return "PUT";
        }
        if (n2 == 3) {
            return "POST";
        }
        if (n2 == 4) {
            return "DELETE";
        }
        if (n2 == 5) {
            return "HEAD";
        }
        if (n2 == 6) {
            return "OPTIONS";
        }
        if (n2 == 7) {
            return "TRACE";
        }
        if (n2 == 8) {
            return "CONNECT";
        }
        if (n2 == 9) {
            return "PATCH";
        }
        if (n2 == 10) {
            return "PROPFIND";
        }
        if (n2 == 11) {
            return "PROPPATCH";
        }
        if (n2 == 12) {
            return "MKCOL";
        }
        if (n2 == 13) {
            return "MOVE";
        }
        if (n2 == 14) {
            return "COPY";
        }
        if (n2 == 15) {
            return "LOCK";
        }
        if (n2 == 16) {
            return "UNLOCK";
        }
        if (n2 == 17) {
            return "NOTIFY";
        }
        if (n2 == 18) {
            return "SUBSCRIBE";
        }
        throw null;
    }
}

