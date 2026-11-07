/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.kt_0;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public final class nS {
    private String B;
    private int G;
    private String[] Gc = new String[512];
    private int KJ = 1;
    private ArrayList<Integer> M = null;
    private int N;
    private Reader SN;
    private int i;
    private boolean q;
    private int t0 = -1;
    private int tF;
    private char[] yq;
    private int zH;

    public nS(Reader reader, int n2) {
        co_0.tF(reader.markSupported());
        this.SN = reader;
        this.yq = new char[Math.min(n2, 32768)];
        this.SN();
    }

    private static String N(char[] object, String[] stringArray, int n2, int n3) {
        int n4;
        if (n3 > 12) {
            return new String((char[])object, n2, n3);
        }
        boolean bl = true;
        if (n3 < 1) {
            return "";
        }
        int n5 = 0;
        for (n4 = 0; n4 < n3; ++n4) {
            n5 = n5 * 31 + object[n2 + n4];
        }
        int n7 = n5 & 0x1FF;
        String string = stringArray[n7];
        if (string != null) {
            boolean bl2;
            if (n3 == string.length()) {
                int n8 = n2;
                n4 = n3;
                n5 = 0;
                while (true) {
                    bl2 = bl;
                    if (n4 != 0) {
                        if (object[n8] != string.charAt(n5)) break;
                        ++n8;
                        --n4;
                        ++n5;
                        continue;
                    }
                    break;
                }
            } else {
                bl2 = false;
            }
            if (bl2) {
                return string;
            }
        }
        object = new String((char[])object, n2, n3);
        stringArray[n7] = object;
        return object;
    }

    private boolean Nl() {
        boolean bl = this.zH >= this.N;
        return bl;
    }

    private int O(int n2) {
        int n3;
        if (!this.OW()) {
            return 0;
        }
        n2 = n3 = Collections.binarySearch(this.M, n2);
        if (n3 < -1) {
            n2 = Math.abs(n3) - 2;
        }
        return n2;
    }

    private void SN() {
        int n2;
        if (!this.q && (n2 = this.zH) >= this.tF) {
            block13: {
                boolean bl;
                int n3;
                int n4;
                block14: {
                    n4 = this.t0;
                    if (n4 != -1) {
                        n3 = n2 - n4;
                        n2 = n4;
                    } else {
                        n3 = 0;
                    }
                    Reader reader = this.SN;
                    long l = n2;
                    long l2 = reader.skip(l);
                    this.SN.mark(32768);
                    n4 = 0;
                    while (true) {
                        int n5;
                        block12: {
                            bl = true;
                            if (n4 > 1024) break;
                            reader = this.SN;
                            char[] cArray = this.yq;
                            n5 = reader.read(cArray, n4, cArray.length - n4);
                            if (n5 != -1) break block12;
                            this.q = true;
                        }
                        if (n5 <= 0) break;
                        n4 += n5;
                    }
                    try {
                        this.SN.reset();
                        if (n4 <= 0) break block13;
                        if (l2 == l) break block14;
                        bl = false;
                    }
                    catch (IOException iOException) {
                        throw new kt_0(iOException);
                    }
                }
                co_0.tF(bl);
                this.N = n4;
                this.i += n2;
                this.zH = n3;
                if (this.t0 != -1) {
                    this.t0 = 0;
                }
                this.tF = Math.min(n4, 24576);
            }
            this.m();
            this.B = null;
            return;
        }
    }

    private void m() {
        int n2;
        if (!this.OW()) {
            return;
        }
        if (this.M.size() > 0) {
            int n3;
            n2 = n3 = this.O(this.i);
            if (n3 == -1) {
                n2 = 0;
            }
            n3 = this.M.get(n2);
            this.KJ += n2;
            this.M.clear();
            this.M.add(n3);
        }
        for (n2 = this.zH; n2 < this.N; ++n2) {
            if (this.yq[n2] != '\n') continue;
            this.M.add(this.i + 1 + n2);
        }
    }

    final String B() {
        char[] cArray;
        char c;
        char c2;
        int n2;
        this.SN();
        int n3 = this.zH;
        while ((n2 = ++this.zH) < this.N && ((c2 = this.yq[n2]) >= 'A' && c2 <= 'Z' || c2 >= 'a' && c2 <= 'z' || Character.isLetter(c2))) {
        }
        while (!this.Nl() && (c = (cArray = this.yq)[n2 = this.zH]) >= '0' && c <= '9') {
            this.zH = n2 + 1;
        }
        return nS.N(this.yq, this.Gc, n3, this.zH - n3);
    }

    final boolean Dr(char[] cArray) {
        this.SN();
        boolean bl = !this.Gd() && Arrays.binarySearch(cArray, this.yq[this.zH]) >= 0;
        return bl;
    }

    public final int E1() {
        return this.i + this.zH;
    }

    public final String F5(char c) {
        block2: {
            this.SN();
            for (int i2 = this.zH; i2 < this.N; ++i2) {
                if (c != this.yq[i2]) continue;
                c = (char)(i2 - this.zH);
                break block2;
            }
            c = (char)-1;
        }
        if (c != '\uffffffff') {
            String string = nS.N(this.yq, this.Gc, this.zH, c);
            this.zH += c;
            return string;
        }
        return this.v();
    }

    final int Fz(CharSequence charSequence) {
        this.SN();
        char c = charSequence.charAt(0);
        int n2 = this.zH;
        while (n2 < this.N) {
            int n3 = this.yq[n2];
            int n4 = 1;
            int n5 = n2;
            if (c != n3) {
                do {
                    n5 = ++n2;
                    if (n2 >= this.N) break;
                    n5 = n2;
                } while (c != this.yq[n2]);
            }
            n2 = n5 + 1;
            int n7 = charSequence.length() + n2 - 1;
            n3 = this.N;
            if (n5 >= n3 || n7 > n3) continue;
            n3 = n2;
            while (n3 < n7 && charSequence.charAt(n4) == this.yq[n3]) {
                ++n3;
                ++n4;
            }
            if (n3 != n7) continue;
            return n5 - this.zH;
        }
        return -1;
    }

    final String G() {
        char c;
        int n2;
        int n3 = this.zH;
        int n4 = this.N;
        Object object = this.yq;
        for (n2 = n3; n2 < n4 && (c = object[n2]) != '\u0000' && c != '<'; ++n2) {
        }
        this.zH = n2;
        object = n2 > n3 ? (Object)nS.N(this.yq, this.Gc, n3, n2 - n3) : (Object)"";
        return object;
    }

    final String G4() {
        char c;
        int n2;
        this.SN();
        int n3 = this.zH;
        int n4 = this.N;
        Object object = this.yq;
        for (n2 = n3; n2 < n4 && (c = object[n2]) != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ' && c != '/' && c != '<' && c != '>'; ++n2) {
        }
        this.zH = n2;
        object = n2 > n3 ? (Object)nS.N(this.yq, this.Gc, n3, n2 - n3) : (Object)"";
        return object;
    }

    final String Gc() {
        char c;
        int n2;
        int n3 = this.zH;
        int n4 = this.N;
        Object object = this.yq;
        for (n2 = n3; n2 < n4 && (c = object[n2]) != '\u0000' && c != '&' && c != '<'; ++n2) {
        }
        this.zH = n2;
        object = n2 > n3 ? (Object)nS.N(this.yq, this.Gc, n3, n2 - n3) : (Object)"";
        return object;
    }

    public final boolean Gd() {
        this.SN();
        boolean bl = this.zH >= this.N;
        return bl;
    }

    final boolean H() {
        boolean bl = this.Gd();
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        char c = this.yq[this.zH];
        bl = bl2;
        if (c >= '0') {
            bl = bl2;
            if (c <= '9') {
                bl = true;
            }
        }
        return bl;
    }

    final String KJ() {
        char c;
        int n2;
        this.SN();
        int n3 = this.zH;
        while ((n2 = this.zH) < this.N && ((c = this.yq[n2]) >= '0' && c <= '9' || c >= 'A' && c <= 'F' || c >= 'a' && c <= 'f')) {
            this.zH = n2 + 1;
        }
        return nS.N(this.yq, this.Gc, n3, n2 - n3);
    }

    final String M() {
        char c;
        int n2;
        this.SN();
        int n3 = this.zH;
        while ((n2 = this.zH) < this.N && (c = this.yq[n2]) >= '0' && c <= '9') {
            this.zH = n2 + 1;
        }
        return nS.N(this.yq, this.Gc, n3, n2 - n3);
    }

    public final boolean OW() {
        boolean bl = this.M != null;
        return bl;
    }

    final void RQ() {
        int n2 = this.zH;
        if (n2 >= 1) {
            this.zH = n2 - 1;
            return;
        }
        throw new kt_0(new IOException("WTF: No buffer left to unconsume."));
    }

    final boolean U() {
        boolean bl = this.Gd();
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        char c = this.yq[this.zH];
        if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || Character.isLetter(c)) {
            bl2 = true;
        }
        return bl2;
    }

    final String W(char ... object) {
        int n2;
        this.SN();
        int n3 = this.zH;
        int n4 = this.N;
        char[] cArray = this.yq;
        for (n2 = n3; n2 < n4 && Arrays.binarySearch((char[])object, cArray[n2]) < 0; ++n2) {
        }
        this.zH = n2;
        object = n2 > n3 ? (Object)nS.N(this.yq, this.Gc, n3, n2 - n3) : (Object)"";
        return object;
    }

    final void Z() {
        this.t0 = -1;
    }

    final boolean Zm(char ... cArray) {
        if (this.Gd()) {
            return false;
        }
        this.SN();
        char c = this.yq[this.zH];
        int n2 = cArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (cArray[i2] != c) continue;
            return true;
        }
        return false;
    }

    final boolean b(char c) {
        boolean bl = !this.Gd() && this.yq[this.zH] == c;
        return bl;
    }

    final String dT() {
        int n2 = this.Fz("]]>");
        if (n2 != -1) {
            String string = nS.N(this.yq, this.Gc, this.zH, n2);
            this.zH += n2;
            return string;
        }
        int n3 = this.N;
        n2 = this.zH;
        if (n3 - n2 < 3) {
            return this.v();
        }
        n3 = n3 - 3 + 1;
        String string = nS.N(this.yq, this.Gc, n2, n3 - n2);
        this.zH = n3;
        return string;
    }

    final boolean ee(String string) {
        int n2;
        boolean bl = string.equals(this.B);
        boolean bl2 = false;
        int n3 = -1;
        if (bl) {
            n2 = this.G;
            if (n2 == -1) {
                return false;
            }
            if (n2 >= this.zH) {
                return true;
            }
        }
        this.B = string;
        Locale locale = Locale.ENGLISH;
        n2 = this.Fz(string.toLowerCase(locale));
        if (n2 > -1) {
            this.G = this.zH + n2;
            return true;
        }
        n2 = this.Fz(string.toUpperCase(locale));
        if (n2 > -1) {
            bl2 = true;
        }
        if (bl2) {
            n3 = this.zH + n2;
        }
        this.G = n3;
        return bl2;
    }

    final boolean g() {
        boolean bl;
        block5: {
            block4: {
                bl = this.Gd();
                boolean bl2 = false;
                if (bl) {
                    return false;
                }
                char c = this.yq[this.zH];
                if (c >= 'A' && c <= 'Z') break block4;
                bl = bl2;
                if (c < 'a') break block5;
                bl = bl2;
                if (c > 'z') break block5;
            }
            bl = true;
        }
        return bl;
    }

    final int g1(int n2) {
        if (!this.OW()) {
            return 1;
        }
        if ((n2 = this.O(n2)) == -1) {
            return this.KJ;
        }
        return n2 + this.KJ + 1;
    }

    public final char g9() {
        this.SN();
        char c = this.Nl() ? (char)'\uffff' : this.yq[this.zH];
        return c;
    }

    final char i() {
        this.SN();
        char c = this.Nl() ? (char)'\uffff' : this.yq[this.zH];
        ++this.zH;
        return c;
    }

    public final void k(boolean bl) {
        if (bl && this.M == null) {
            this.M = new ArrayList(409);
            this.m();
        } else if (!bl) {
            this.M = null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    final boolean n(String string) {
        int n2;
        this.SN();
        this.SN();
        int n3 = string.length();
        if (n3 > this.N - this.zH) return false;
        for (n2 = 0; n2 < n3; ++n2) {
            if (string.charAt(n2) == this.yq[this.zH + n2]) continue;
            return false;
        }
        n2 = 1;
        if (n2 == 0) return false;
        n2 = this.zH;
        this.zH = string.length() + n2;
        return true;
    }

    final String q() {
        char c;
        int n2;
        this.SN();
        int n3 = this.zH;
        while ((n2 = ++this.zH) < this.N && ((c = this.yq[n2]) >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || Character.isLetter(c))) {
        }
        return nS.N(this.yq, this.Gc, n3, this.zH - n3);
    }

    final void s() {
        if (this.N - this.zH < 1024) {
            this.tF = 0;
        }
        this.SN();
        this.t0 = this.zH;
    }

    final String t0(boolean bl) {
        char c;
        int n2;
        int n3 = this.zH;
        int n4 = this.N;
        Object object = this.yq;
        for (n2 = n3; n2 < n4 && (c = object[n2]) != '\u0000'; ++n2) {
            if (c != '\"') {
                if (c == '&') break;
                if (c != '\'') continue;
                if (bl) break;
            }
            if (!bl) break;
        }
        this.zH = n2;
        object = n2 > n3 ? (Object)nS.N(this.yq, this.Gc, n3, n2 - n3) : (Object)"";
        return object;
    }

    /*
     * Unable to fully structure code
     */
    public final void tF() {
        var1_1 = this.SN;
        if (var1_1 == null) {
            return;
        }
        try {
            var1_1.close();
        }
        catch (Throwable var1_2) {
            this.SN = null;
            this.yq = null;
            this.Gc = null;
            throw var1_2;
        }
lbl12:
        // 2 sources

        while (true) {
            this.SN = null;
            this.yq = null;
            this.Gc = null;
            return;
        }
        catch (IOException var1_3) {
            ** continue;
        }
    }

    final void tO() {
        int n2 = this.t0;
        if (n2 != -1) {
            this.zH = n2;
            this.t0 = -1;
            return;
        }
        throw new kt_0(new IOException("Mark invalid"));
    }

    public final String toString() {
        int n2 = this.N;
        int n3 = this.zH;
        if (n2 - n3 < 0) {
            return "";
        }
        return new String(this.yq, n3, n2 - n3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    final boolean un(String string) {
        int n2;
        this.SN();
        int n3 = string.length();
        if (n3 > this.N - this.zH) return false;
        for (n2 = 0; n2 < n3; ++n2) {
            if (Character.toUpperCase(string.charAt(n2)) == Character.toUpperCase(this.yq[this.zH + n2])) continue;
            return false;
        }
        n2 = 1;
        if (n2 == 0) return false;
        n2 = this.zH;
        this.zH = string.length() + n2;
        return true;
    }

    final String v() {
        this.SN();
        Object object = this.yq;
        String[] stringArray = this.Gc;
        int n2 = this.zH;
        object = nS.N(object, stringArray, n2, this.N - n2);
        this.zH = this.N;
        return object;
    }

    public final String v3(char ... object) {
        int n2;
        this.SN();
        int n3 = this.zH;
        int n4 = this.N;
        char[] cArray = this.yq;
        int n5 = ((char[])object).length;
        block0: for (n2 = n3; n2 < n4; ++n2) {
            for (int i2 = 0; i2 < n5; ++i2) {
                if (cArray[n2] == object[i2]) break block0;
            }
        }
        this.zH = n2;
        object = n2 > n3 ? (Object)nS.N(this.yq, this.Gc, n3, n2 - n3) : (Object)"";
        return object;
    }

    final String xa() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.g1(this.i + this.zH));
        stringBuilder.append(":");
        stringBuilder.append(this.zH(this.i + this.zH));
        return stringBuilder.toString();
    }

    public final void yq() {
        ++this.zH;
    }

    final int zH(int n2) {
        if (!this.OW()) {
            return n2 + 1;
        }
        int n3 = this.O(n2);
        if (n3 == -1) {
            return n2 + 1;
        }
        return n2 - this.M.get(n3) + 1;
    }
}

