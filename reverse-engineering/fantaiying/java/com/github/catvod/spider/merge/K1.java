/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Pu;
import com.github.catvod.spider.merge.oi_0;

public final class K1
extends Enum<K1>
implements Pu {
    public static final /* enum */ K1 N;
    public static final /* enum */ K1 i;
    private static final K1[] t0;
    public static final /* enum */ K1 tF;
    public static final /* enum */ K1 zH;
    private final String SN;
    private final int yq;

    static {
        K1 k1;
        K1 k12;
        K1 k13;
        K1 k14;
        K1 k15 = new K1(101, "Switching Protocols");
        N = k14 = new K1(200, "OK");
        K1 k16 = new K1(201, "Created");
        K1 k17 = new K1(202, "Accepted");
        K1 k18 = new K1(204, "No Content");
        K1 k19 = new K1(206, "Partial Content");
        K1 k110 = new K1(207, "Multi-Status");
        K1 k111 = new K1(301, "Moved Permanently");
        K1 k112 = new K1(302, "Found");
        K1 k113 = new K1(303, "See Other");
        K1 k114 = new K1(304, "Not Modified");
        K1 k115 = new K1(307, "Temporary Redirect");
        tF = k13 = new K1(400, "Bad Request");
        K1 k116 = new K1(401, "Unauthorized");
        K1 k117 = new K1(403, "Forbidden");
        zH = k12 = new K1(404, "Not Found");
        K1 k118 = new K1(405, "Method Not Allowed");
        K1 k119 = new K1(406, "Not Acceptable");
        K1 k120 = new K1(408, "Request Timeout");
        K1 k121 = new K1(409, "Conflict");
        K1 k122 = new K1(410, "Gone");
        K1 k123 = new K1(411, "Length Required");
        K1 k124 = new K1(412, "Precondition Failed");
        K1 k125 = new K1(413, "Payload Too Large");
        K1 k126 = new K1(415, "Unsupported Media Type");
        K1 k127 = new K1(416, "Requested Range Not Satisfiable");
        K1 k128 = new K1(417, "Expectation Failed");
        K1 k129 = new K1(429, "Too Many Requests");
        i = k1 = new K1(500, "Internal Server Error");
        t0 = new K1[]{k15, k14, k16, k17, k18, k19, k110, k111, k112, k113, k114, k115, k13, k116, k117, k12, k118, k119, k120, k121, k122, k123, k124, k125, k126, k127, k128, k129, k1, new K1(501, "Not Implemented"), new K1(503, "Service Unavailable"), new K1(505, "HTTP Version Not Supported")};
    }

    private K1(int n3, String string2) {
        this.yq = n3;
        this.SN = string2;
    }

    public static K1 SN(int n2) {
        for (K1 k1 : K1.values()) {
            if (k1.yq != n2) continue;
            return k1;
        }
        return null;
    }

    public static K1 valueOf(String string) {
        return Enum.valueOf(K1.class, string);
    }

    public static K1[] values() {
        return (K1[])t0.clone();
    }

    public final String yq() {
        StringBuilder stringBuilder = oi_0.yq("");
        stringBuilder.append(this.yq);
        stringBuilder.append(" ");
        stringBuilder.append(this.SN);
        return stringBuilder.toString();
    }
}

