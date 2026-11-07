/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.co_0;

public final class Wy {
    private int SN = 0;
    private String yq;

    public Wy(String string) {
        co_0.Gc(string);
        this.yq = string;
    }

    public static String dT(String object) {
        StringBuilder stringBuilder = Nr.SN();
        object = ((String)object).toCharArray();
        int n2 = ((Object)object).length;
        Object object2 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object3 = object[i2];
            if (object3 != 92 || object2 == 92) {
                stringBuilder.append((char)object3);
            }
            object2 = object3;
        }
        return Nr.Gc(stringBuilder);
    }

    public final boolean B(String ... stringArray) {
        int n2 = stringArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.q(stringArray[i2])) continue;
            return true;
        }
        return false;
    }

    public final boolean G() {
        boolean bl = !this.M() && Character.isLetterOrDigit(this.yq.charAt(this.SN));
        return bl;
    }

    public final String G4() {
        String string = this.yq.substring(this.SN);
        this.SN = this.yq.length();
        return string;
    }

    public final boolean Gc() {
        boolean bl;
        boolean bl2 = false;
        while (bl = !this.M() && Nr.zH(this.yq.charAt(this.SN))) {
            ++this.SN;
            bl2 = true;
        }
        return bl2;
    }

    public final boolean KJ(String string) {
        if (this.q(string)) {
            int n2 = this.SN;
            this.SN = string.length() + n2;
            return true;
        }
        return false;
    }

    public final boolean M() {
        boolean bl = this.yq.length() - this.SN == 0;
        return bl;
    }

    public final char N() {
        String string = this.yq;
        int n2 = this.SN;
        this.SN = n2 + 1;
        return string.charAt(n2);
    }

    public final String SN() {
        String string;
        int n2 = this.yq.indexOf(")", this.SN);
        if (n2 != -1) {
            string = this.yq.substring(this.SN, n2);
            n2 = this.SN;
            this.SN = string.length() + n2;
        } else {
            string = this.G4();
        }
        this.KJ(")");
        return string;
    }

    public final String i() {
        int n2 = this.SN;
        while (!this.M() && (this.G() || this.B("*|", "|", "_", "-"))) {
            ++this.SN;
        }
        return this.yq.substring(n2, this.SN);
    }

    public final boolean q(String string) {
        return this.yq.regionMatches(true, this.SN, string, 0, string.length());
    }

    public final String t0(String ... stringArray) {
        int n2 = this.SN;
        while (!this.M() && !this.B(stringArray)) {
            ++this.SN;
        }
        return this.yq.substring(n2, this.SN);
    }

    public final void tF(String string) {
        if (this.q(string)) {
            int n2;
            int n3;
            int n4 = string.length();
            if (n4 <= (n3 = this.yq.length()) - (n2 = this.SN)) {
                this.SN = n2 + n4;
                return;
            }
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public final String toString() {
        return this.yq.substring(this.SN);
    }

    public final String yq(char c, char c2) {
        int n2 = 0;
        boolean bl = false;
        boolean bl2 = false;
        int n3 = -1;
        int n4 = -1;
        int n5 = 0;
        boolean bl3 = false;
        while (true) {
            boolean bl4;
            int n7;
            int n8;
            int n9;
            char c3;
            block25: {
                block20: {
                    block22: {
                        boolean bl5;
                        int n10;
                        int n11;
                        boolean bl6;
                        boolean bl7;
                        block24: {
                            block21: {
                                boolean bl8;
                                boolean bl9;
                                block23: {
                                    if (this.M()) break block20;
                                    c3 = this.N();
                                    if (n2 == 92) break block21;
                                    if (c3 == '\'' && c3 != c && !bl) {
                                        bl9 = bl2 ^ true;
                                        bl8 = bl;
                                    } else {
                                        bl8 = bl;
                                        bl9 = bl2;
                                        if (c3 == '\"') {
                                            bl8 = bl;
                                            bl9 = bl2;
                                            if (c3 != c) {
                                                bl8 = bl;
                                                bl9 = bl2;
                                                if (!bl2) {
                                                    bl8 = bl ^ true;
                                                    bl9 = bl2;
                                                }
                                            }
                                        }
                                    }
                                    bl = bl8;
                                    bl2 = bl9;
                                    n9 = n3;
                                    n8 = n4;
                                    n7 = n5;
                                    bl4 = bl3;
                                    if (bl9) break block22;
                                    bl = bl8;
                                    bl2 = bl9;
                                    n9 = n3;
                                    n8 = n4;
                                    n7 = n5++;
                                    bl4 = bl3;
                                    if (bl8) break block22;
                                    if (!bl3) break block23;
                                    bl = bl8;
                                    bl2 = bl9;
                                    n9 = n3;
                                    n8 = n4;
                                    n7 = n5;
                                    bl4 = bl3;
                                    break block22;
                                }
                                if (c3 == c) {
                                    bl7 = bl8;
                                    bl6 = bl9;
                                    n11 = n3;
                                    n10 = n5;
                                    bl5 = bl3;
                                    if (n3 == -1) {
                                        n11 = this.SN;
                                        bl7 = bl8;
                                        bl6 = bl9;
                                        n10 = n5;
                                        bl5 = bl3;
                                    }
                                } else {
                                    bl7 = bl8;
                                    bl6 = bl9;
                                    n11 = n3;
                                    n10 = n5;
                                    bl5 = bl3;
                                    if (c3 == c2) {
                                        n10 = n5 - 1;
                                        bl7 = bl8;
                                        bl6 = bl9;
                                        n11 = n3;
                                        bl5 = bl3;
                                    }
                                }
                                break block24;
                            }
                            if (c3 == 'Q') {
                                bl5 = true;
                                bl7 = bl;
                                bl6 = bl2;
                                n11 = n3;
                                n10 = n5;
                            } else {
                                bl7 = bl;
                                bl6 = bl2;
                                n11 = n3;
                                n10 = n5;
                                bl5 = bl3;
                                if (c3 == 'E') {
                                    bl5 = false;
                                    n10 = n5;
                                    n11 = n3;
                                    bl6 = bl2;
                                    bl7 = bl;
                                }
                            }
                        }
                        bl = bl7;
                        bl2 = bl6;
                        n9 = n11;
                        n8 = n4;
                        n7 = n10;
                        bl4 = bl5;
                        if (n10 > 0) {
                            bl = bl7;
                            bl2 = bl6;
                            n9 = n11;
                            n8 = n4;
                            n7 = n10;
                            bl4 = bl5;
                            if (n2 != 0) {
                                n8 = this.SN;
                                bl4 = bl5;
                                n7 = n10;
                                n9 = n11;
                                bl2 = bl6;
                                bl = bl7;
                            }
                        }
                    }
                    if (n7 > 0) break block25;
                    n5 = n7;
                    n4 = n8;
                    n3 = n9;
                }
                String string = n4 >= 0 ? this.yq.substring(n3, n4) : "";
                if (n5 <= 0) {
                    return string;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Did not find balanced marker at '");
                stringBuilder.append(string);
                stringBuilder.append("'");
                co_0.SN(stringBuilder.toString());
                throw null;
            }
            n2 = c3;
            n3 = n9;
            n4 = n8;
            n5 = n7;
            bl3 = bl4;
        }
    }

    public final String zH() {
        int n2 = this.SN;
        while (!this.M()) {
            if (!this.G()) {
                char c;
                boolean bl = this.M();
                char c2 = '\u0000';
                if (bl) {
                    c = c2;
                } else {
                    int n3 = 0;
                    while (true) {
                        c = c2;
                        if (n3 >= 2) break;
                        c = (new char[]{'-', '_'})[n3];
                        if (this.yq.charAt(this.SN) == c) {
                            c = '\u0001';
                            break;
                        }
                        ++n3;
                    }
                }
                if (c == '\u0000') break;
            }
            ++this.SN;
        }
        return this.yq.substring(n2, this.SN);
    }
}

