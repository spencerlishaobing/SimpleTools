/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.oi_0;
import java.util.Date;
import java.util.TimeZone;

/*
 * Renamed from com.github.catvod.spider.merge.Ha
 */
final class ha_0
extends TimeZone {
    private final String SN;
    private final int yq;

    ha_0(boolean bl, int n2, int n3) {
        if (n2 < 24) {
            if (n3 < 60) {
                int n4;
                int n5 = n4 = (n2 * 60 + n3) * 60000;
                if (bl) {
                    n5 = -n4;
                }
                this.yq = n5;
                StringBuilder stringBuilder = new StringBuilder(9);
                stringBuilder.append("GMT");
                char c = bl ? (char)'-' : '+';
                stringBuilder.append(c);
                stringBuilder.append((char)(n2 / 10 + 48));
                stringBuilder.append((char)(n2 % 10 + 48));
                stringBuilder.append(':');
                stringBuilder.append((char)(n3 / 10 + 48));
                stringBuilder.append((char)(n3 % 10 + 48));
                this.SN = stringBuilder.toString();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n3);
            stringBuilder.append(" minutes out of range");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n2);
        stringBuilder.append(" hours out of range");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final boolean equals(Object object) {
        boolean bl = object instanceof ha_0;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        if (this.SN == ((ha_0)object).SN) {
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public final String getID() {
        return this.SN;
    }

    @Override
    public final int getOffset(int n2, int n3, int n4, int n5, int n7, int n8) {
        return this.yq;
    }

    @Override
    public final int getRawOffset() {
        return this.yq;
    }

    public final int hashCode() {
        return this.yq;
    }

    @Override
    public final boolean inDaylightTime(Date date) {
        return false;
    }

    @Override
    public final void setRawOffset(int n2) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        StringBuilder stringBuilder = oi_0.yq("[GmtTimeZone id=\"");
        stringBuilder.append(this.SN);
        stringBuilder.append("\",offset=");
        stringBuilder.append(this.yq);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override
    public final boolean useDaylightTime() {
        return false;
    }
}

