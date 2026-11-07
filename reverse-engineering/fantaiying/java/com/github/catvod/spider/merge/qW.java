/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.rs_0;

public abstract class qW {
    protected qW() {
    }

    public abstract boolean SN(char var1);

    public int yq(CharSequence charSequence, int n2) {
        int n3 = charSequence.length();
        rs_0.t0(n2, n3);
        while (n2 < n3) {
            if (this.SN(charSequence.charAt(n2))) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    static abstract class N
    extends yq {
        private final String yq;

        N(String string) {
            this.yq = string;
        }

        public final String toString() {
            return this.yq;
        }
    }

    private static final class SN
    extends yq {
        private final char yq = (char)44;

        SN() {
        }

        @Override
        public final boolean SN(char c) {
            boolean bl = c == this.yq;
            return bl;
        }

        public final String toString() {
            char c = this.yq;
            Object object = new char[6];
            char[] cArray = object;
            object[0] = 92;
            cArray[1] = 117;
            cArray[2] = 0;
            cArray[3] = 0;
            cArray[4] = 0;
            cArray[5] = 0;
            for (int i2 = 0; i2 < 4; ++i2) {
                object[5 - i2] = "0123456789ABCDEF".charAt(c & 0xF);
                c = (char)(c >> 4);
            }
            String string = String.copyValueOf((char[])object);
            object = new StringBuilder(String.valueOf(string).length() + 18);
            ((StringBuilder)object).append("CharMatcher.is('");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append("')");
            return ((StringBuilder)object).toString();
        }
    }

    private static final class tF
    extends N {
        static final tF SN = new tF();

        private tF() {
            super("CharMatcher.none()");
        }

        @Override
        public final boolean SN(char c) {
            return false;
        }

        @Override
        public final int yq(CharSequence charSequence, int n2) {
            rs_0.t0(n2, charSequence.length());
            return -1;
        }
    }

    static abstract class yq
    extends qW {
        yq() {
        }
    }

    static final class zH
    extends N {
        static final zH N;
        static final int SN;

        static {
            SN = Integer.numberOfLeadingZeros(31);
            N = new zH();
        }

        zH() {
            super("CharMatcher.whitespace()");
        }

        @Override
        public final boolean SN(char c) {
            boolean bl = "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f\u00a0\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".charAt(1682554634 * c >>> SN) == c;
            return bl;
        }
    }
}

