/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.io.Serializable;

public final class A4
implements Serializable {
    private String N;
    private String SN;
    private String yq;

    public A4(String string, String string2, String string3) {
        if (string2 != null) {
            String string4 = string;
            if (string == null) {
                string4 = "";
            }
            string = string3;
            if (string3 == null) {
                string = "";
            }
            this.yq = string4;
            this.SN = string2;
            this.N = string;
            return;
        }
        throw new IllegalArgumentException("Local part not allowed to be null");
    }

    public final String N() {
        return this.N;
    }

    public final String SN() {
        return this.yq;
    }

    public final boolean equals(Object object) {
        boolean bl = false;
        if (object == null) {
            return false;
        }
        if (!(object instanceof A4)) {
            return false;
        }
        object = (A4)object;
        boolean bl2 = bl;
        if (this.SN.equals(((A4)object).SN)) {
            bl2 = bl;
            if (this.yq.equals(((A4)object).yq)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public final int hashCode() {
        return this.yq.hashCode() ^ this.SN.hashCode();
    }

    public final String toString() {
        if (this.yq.equals("")) {
            return this.SN;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append(this.yq);
        stringBuffer.append("}");
        stringBuffer.append(this.SN);
        return stringBuffer.toString();
    }

    public final String yq() {
        return this.SN;
    }
}

