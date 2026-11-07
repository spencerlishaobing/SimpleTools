/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.util.Arrays;

public final class Sq {
    public static yq yq(Object object) {
        return new yq(object.getClass().getSimpleName());
    }

    public static final class com.github.catvod.spider.merge.Sq$yq {
        private yq N;
        private final yq SN;
        private final String yq;

        com.github.catvod.spider.merge.Sq$yq(String string) {
            yq yq2;
            this.SN = yq2 = new yq();
            this.N = yq2;
            this.yq = string;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append(this.yq);
            stringBuilder.append('{');
            yq yq2 = this.SN.SN;
            String string = "";
            while (yq2 != null) {
                Object object = yq2.yq;
                stringBuilder.append(string);
                if (object != null && object.getClass().isArray()) {
                    string = Arrays.deepToString(new Object[]{object});
                    stringBuilder.append(string, 1, string.length() - 1);
                } else {
                    stringBuilder.append(object);
                }
                yq2 = yq2.SN;
                string = ", ";
            }
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public final com.github.catvod.spider.merge.Sq$yq yq(Object object) {
            yq yq2;
            this.N.SN = yq2 = new yq();
            this.N = yq2;
            yq2.yq = object;
            return this;
        }

        private static class yq {
            yq SN;
            Object yq;

            yq() {
            }
        }
    }
}

