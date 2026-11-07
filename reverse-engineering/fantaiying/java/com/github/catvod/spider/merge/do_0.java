/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.Wy;
import com.github.catvod.spider.merge.X7;
import com.github.catvod.spider.merge.Y4;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.y4;
import com.github.catvod.spider.merge.z2_0;
import com.github.catvod.spider.merge.zF;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/*
 * Renamed from com.github.catvod.spider.merge.Do
 */
public final class do_0 {
    private static final Pattern i;
    private static final Pattern t0;
    private static final String[] tF;
    private static final String[] zH;
    private final List<Y4> N = new ArrayList<Y4>();
    private final String SN;
    private final Wy yq;

    static {
        tF = new String[]{",", ">", "+", "~", " "};
        zH = new String[]{"=", "!=", "^=", "$=", "*=", "~="};
        i = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);
        t0 = Pattern.compile("([+-])?(\\d+)");
    }

    private do_0(String string) {
        co_0.i(string);
        this.SN = string = string.trim();
        this.yq = new Wy(string);
    }

    private void Gc(boolean bl) {
        Object object = bl ? ":matchesWholeOwnText" : ":matchesWholeText";
        this.yq.tF((String)object);
        String string = this.yq.yq('(', ')');
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("(regex) query must not be empty");
        co_0.t0(string, ((StringBuilder)object2).toString());
        object2 = this.N;
        object = bl ? new Y4.E1(Pattern.compile(string)) : new Y4.tO(Pattern.compile(string));
        ((ArrayList)object2).add(object);
    }

    public static Y4 KJ(String object) {
        try {
            do_0 do_02 = new do_0((String)object);
            object = do_02.M();
            return object;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new z2_0.yq(illegalArgumentException.getMessage());
        }
    }

    private void N(boolean bl) {
        Object object = bl ? ":containsOwn" : ":contains";
        this.yq.tF((String)object);
        String string = Wy.dT(this.yq.yq('(', ')'));
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("(text) query must not be empty");
        co_0.t0(string, ((StringBuilder)object2).toString());
        object2 = this.N;
        object = bl ? new Y4.G(string) : new Y4.G4(string);
        ((ArrayList)object2).add(object);
    }

    private int SN() {
        boolean bl;
        String string;
        block4: {
            boolean bl2;
            string = this.yq.SN().trim();
            int n2 = Nr.i;
            bl = bl2 = false;
            if (string != null) {
                if (string.length() == 0) {
                    bl = bl2;
                } else {
                    int n3 = string.length();
                    for (n2 = 0; n2 < n3; ++n2) {
                        if (Character.isDigit(string.codePointAt(n2))) continue;
                        bl = bl2;
                        break block4;
                    }
                    bl = true;
                }
            }
        }
        co_0.zH(bl, "Index must be numeric");
        return Integer.parseInt(string);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void i() {
        if (this.yq.KJ("#")) {
            String string = this.yq.zH();
            co_0.i(string);
            ((ArrayList)this.N).add(new Y4.W(string));
            return;
        } else if (this.yq.KJ(".")) {
            String string = this.yq.zH();
            co_0.i(string);
            ((ArrayList)this.N).add(new Y4.q(string.trim()));
            return;
        } else if (!this.yq.G() && !this.yq.q("*|")) {
            if (this.yq.q("[")) {
                Wy wy = new Wy(this.yq.yq('[', ']'));
                String string = wy.t0(zH);
                co_0.i(string);
                wy.Gc();
                if (wy.M()) {
                    void var2_15;
                    List<Y4> list;
                    if (string.startsWith("^")) {
                        list = this.N;
                        Y4.tF tF2 = new Y4.tF(string.substring(1));
                    } else {
                        list = this.N;
                        Y4.SN sN = new Y4.SN(string);
                    }
                    ((ArrayList)list).add((Y4)var2_15);
                    return;
                } else {
                    void var2_22;
                    List<Y4> list;
                    if (wy.KJ("=")) {
                        list = this.N;
                        Y4.zH zH2 = new Y4.zH(string, wy.G4());
                    } else if (wy.KJ("!=")) {
                        list = this.N;
                        Y4.M m2 = new Y4.M(string, wy.G4());
                    } else if (wy.KJ("^=")) {
                        list = this.N;
                        Y4.KJ kJ = new Y4.KJ(string, wy.G4());
                    } else if (wy.KJ("$=")) {
                        list = this.N;
                        Y4.t0 t02 = new Y4.t0(string, wy.G4());
                    } else if (wy.KJ("*=")) {
                        list = this.N;
                        Y4.i i2 = new Y4.i(string, wy.G4());
                    } else {
                        if (!wy.KJ("~=")) throw new z2_0.yq("Could not parse attribute query '%s': unexpected token at '%s'", this.SN, wy.G4());
                        list = this.N;
                        Y4.Gc gc = new Y4.Gc(string, Pattern.compile(wy.G4()));
                    }
                    ((ArrayList)list).add((Y4)var2_22);
                }
                return;
            } else if (this.yq.KJ("*")) {
                ((ArrayList)this.N).add(new Y4.yq());
                return;
            } else if (this.yq.KJ(":lt(")) {
                ((ArrayList)this.N).add(new Y4.xa(this.SN()));
                return;
            } else if (this.yq.KJ(":gt(")) {
                ((ArrayList)this.N).add(new Y4.g9(this.SN()));
                return;
            } else if (this.yq.KJ(":eq(")) {
                ((ArrayList)this.N).add(new Y4.v(this.SN()));
                return;
            } else if (this.yq.q(":has(")) {
                this.yq.tF(":has");
                String string = this.yq.yq('(', ')');
                co_0.t0(string, ":has(selector) sub-select must not be empty");
                ((ArrayList)this.N).add(new zF.yq(do_0.KJ(string)));
                return;
            } else if (this.yq.q(":contains(")) {
                this.N(false);
                return;
            } else if (this.yq.q(":containsOwn(")) {
                this.N(true);
                return;
            } else if (this.yq.q(":containsWholeText(")) {
                this.tF(false);
                return;
            } else if (this.yq.q(":containsWholeOwnText(")) {
                this.tF(true);
                return;
            } else if (this.yq.q(":containsData(")) {
                this.yq.tF(":containsData");
                String string = Wy.dT(this.yq.yq('(', ')'));
                co_0.t0(string, ":containsData(text) query must not be empty");
                ((ArrayList)this.N).add(new Y4.B(string));
                return;
            } else if (this.yq.q(":matches(")) {
                this.t0(false);
                return;
            } else if (this.yq.q(":matchesOwn(")) {
                this.t0(true);
                return;
            } else if (this.yq.q(":matchesWholeText(")) {
                this.Gc(false);
                return;
            } else if (this.yq.q(":matchesWholeOwnText(")) {
                this.Gc(true);
                return;
            } else if (this.yq.q(":not(")) {
                this.yq.tF(":not");
                String string = this.yq.yq('(', ')');
                co_0.t0(string, ":not(selector) subselect must not be empty");
                ((ArrayList)this.N).add(new zF.tF(do_0.KJ(string)));
                return;
            } else if (this.yq.KJ(":nth-child(")) {
                this.zH(false, false);
                return;
            } else if (this.yq.KJ(":nth-last-child(")) {
                this.zH(true, false);
                return;
            } else if (this.yq.KJ(":nth-of-type(")) {
                this.zH(false, true);
                return;
            } else if (this.yq.KJ(":nth-last-of-type(")) {
                this.zH(true, true);
                return;
            } else {
                void var2_32;
                List<Y4> list;
                if (this.yq.KJ(":first-child")) {
                    list = this.N;
                    Y4.Nl nl = new Y4.Nl();
                } else if (this.yq.KJ(":last-child")) {
                    list = this.N;
                    Y4.O o2 = new Y4.O();
                } else if (this.yq.KJ(":first-of-type")) {
                    list = this.N;
                    Y4.OW oW = new Y4.OW();
                } else if (this.yq.KJ(":last-of-type")) {
                    list = this.N;
                    Y4.g1 g12 = new Y4.g1();
                } else if (this.yq.KJ(":only-child")) {
                    list = this.N;
                    Y4.Zm zm = new Y4.Zm();
                } else if (this.yq.KJ(":only-of-type")) {
                    list = this.N;
                    Y4.Dr dr = new Y4.Dr();
                } else if (this.yq.KJ(":empty")) {
                    list = this.N;
                    Y4.Gd gd = new Y4.Gd();
                } else if (this.yq.KJ(":root")) {
                    list = this.N;
                    y4.g_0 g_02 = new y4.g_0();
                } else {
                    if (!this.yq.KJ(":matchText")) throw new z2_0.yq("Could not parse query '%s': unexpected token at '%s'", this.SN, this.yq.G4());
                    list = this.N;
                    Y4.H h = new Y4.H();
                }
                ((ArrayList)list).add((Y4)var2_32);
            }
            return;
        } else {
            String string = U7.KJ(this.yq.i());
            co_0.i(string);
            if (string.startsWith("*|")) {
                String string2 = string.substring(2);
                ((ArrayList)this.N).add(new X7.SN(new y4.m_0(string2), new Y4.k(string.replace("*|", ":"))));
                return;
            } else {
                String string3 = string;
                if (string.contains("|")) {
                    string3 = string.replace("|", ":");
                }
                ((ArrayList)this.N).add(new y4.m_0(string3));
            }
        }
    }

    private void t0(boolean bl) {
        Object object = bl ? ":matchesOwn" : ":matches";
        this.yq.tF((String)object);
        String string = this.yq.yq('(', ')');
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("(regex) query must not be empty");
        co_0.t0(string, ((StringBuilder)object2).toString());
        object2 = this.N;
        object = bl ? new Y4.Fz(Pattern.compile(string)) : new Y4.U(Pattern.compile(string));
        ((ArrayList)object2).add(object);
    }

    private void tF(boolean bl) {
        Object object = bl ? ":containsWholeOwnText" : ":containsWholeText";
        this.yq.tF((String)object);
        String string = Wy.dT(this.yq.yq('(', ')'));
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("(text) query must not be empty");
        co_0.t0(string, ((StringBuilder)object2).toString());
        object2 = this.N;
        object = bl ? new Y4.dT(string) : new Y4.F5(string);
        ((ArrayList)object2).add(object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void yq(char c) {
        Object object;
        int n2;
        Y4 y42;
        Object object2;
        Object object3;
        block21: {
            block20: {
                block19: {
                    this.yq.Gc();
                    object3 = Nr.SN();
                    while (!this.yq.M()) {
                        block18: {
                            block17: {
                                block16: {
                                    if (!this.yq.q("(")) break block16;
                                    ((StringBuilder)object3).append("(");
                                    ((StringBuilder)object3).append(this.yq.yq('(', ')'));
                                    object2 = ")";
                                    break block17;
                                }
                                if (!this.yq.q("[")) break block18;
                                ((StringBuilder)object3).append("[");
                                ((StringBuilder)object3).append(this.yq.yq('[', ']'));
                                object2 = "]";
                            }
                            ((StringBuilder)object3).append((String)object2);
                            continue;
                        }
                        if (this.yq.B(tF)) {
                            if (((StringBuilder)object3).length() > 0) break;
                            this.yq.N();
                            continue;
                        }
                        ((StringBuilder)object3).append(this.yq.N());
                    }
                    y42 = do_0.KJ(Nr.Gc((StringBuilder)object3));
                    if (((ArrayList)this.N).size() != 1) break block19;
                    object2 = object3 = (Y4)((ArrayList)this.N).get(0);
                    if (!(object3 instanceof X7.SN)) break block20;
                    object2 = object3;
                    if (c == ',') break block20;
                    object2 = (X7.SN)object3;
                    n2 = ((X7)object2).SN;
                    object2 = n2 > 0 ? ((X7)object2).yq.get(n2 - 1) : null;
                    n2 = 1;
                    object = object2;
                    break block21;
                }
                object2 = new X7.yq(this.N);
            }
            object = object2;
            n2 = 0;
            object3 = object2;
        }
        ((ArrayList)this.N).clear();
        if (c != ' ') {
            if (c != '>') {
                if (c != '~') {
                    if (c != '+') {
                        if (c != ',') throw new z2_0.yq("Unknown combinator '%s'", Character.valueOf(c));
                        if (object instanceof X7.SN) {
                            object2 = (X7.SN)object;
                        } else {
                            object2 = new X7.SN();
                            ((X7)object2).yq.add((Y4)object);
                            ((X7)object2).SN();
                        }
                        ((X7)object2).yq.add(y42);
                        ((X7)object2).SN();
                    } else {
                        object2 = new X7.yq(new zF.N((Y4)object), y42);
                    }
                } else {
                    object2 = new X7.yq(new zF.i((Y4)object), y42);
                }
            } else {
                object2 = new X7.yq(new zF.SN((Y4)object), y42);
            }
        } else {
            object2 = new X7.yq(new zF.zH((Y4)object), y42);
        }
        if (n2 != 0) {
            object = (X7.SN)object3;
            ((X7)object).yq.set(((X7)object).SN - 1, (Y4)object2);
            object2 = object3;
        }
        ((ArrayList)this.N).add((Y4)object2);
    }

    /*
     * Unable to fully structure code
     */
    private void zH(boolean var1_1, boolean var2_2) {
        block17: {
            block15: {
                block16: {
                    var8_3 = U7.KJ(this.yq.SN());
                    var7_4 = do_0.i.matcher((CharSequence)var8_3);
                    var9_5 = do_0.t0.matcher((CharSequence)var8_3);
                    var6_6 = "odd".equals(var8_3);
                    var3_7 = 0;
                    var4_8 = 0;
                    var5_9 = 1;
                    if (var6_6) {
                        var3_7 = 1;
lbl10:
                        // 2 sources

                        while (true) {
                            var4_8 = 2;
                            break block15;
                            break;
                        }
                    }
                    if ("even".equals(var8_3)) {
                        var3_7 = 0;
                        ** continue;
                    }
                    if (!var7_4.matches()) break block16;
                    var3_7 = var5_9;
                    if (var7_4.group(3) != null) {
                        var3_7 = Integer.parseInt(var7_4.group(1).replaceFirst("^\\+", ""));
                    }
                    if (var7_4.group(4) != null) {
                        var4_8 = Integer.parseInt(var7_4.group(4).replaceFirst("^\\+", ""));
                    }
                    var5_9 = var3_7;
                    var3_7 = var4_8;
                    var4_8 = var5_9;
                    break block15;
                }
                if (!var9_5.matches()) break block17;
                var5_9 = Integer.parseInt(var9_5.group().replaceFirst("^\\+", ""));
                var4_8 = var3_7;
                var3_7 = var5_9;
            }
            if (var2_2) {
                if (var1_1) {
                    var7_4 = this.N;
                    var8_3 = new Y4.un(var4_8, var3_7);
                } else {
                    var7_4 = this.N;
                    var8_3 = new y4.b_0(var4_8, var3_7);
                }
            } else if (var1_1) {
                var7_4 = this.N;
                var8_3 = new y4.n_0(var4_8, var3_7);
            } else {
                var7_4 = this.N;
                var8_3 = new Y4.s(var4_8, var3_7);
            }
            var7_4.add((Object)var8_3);
            return;
        }
        var7_4 = new z2_0.yq("Could not parse nth-index '%s': unexpected format", new Object[]{var8_3});
        throw var7_4;
    }

    /*
     * Unable to fully structure code
     */
    final Y4 M() {
        block5: {
            this.yq.Gc();
            if (!this.yq.B(do_0.tF)) break block5;
            this.N.add(new zF.t0());
            var3_1 = this;
            ** GOTO lbl-1000
        }
        var4_2 = this;
        block0: while (true) {
            var4_2.i();
            var3_1 = var4_2;
            while (!var3_1.yq.M()) {
                var2_4 = var3_1.yq.Gc();
                if (var3_1.yq.B(do_0.tF)) lbl-1000:
                // 2 sources

                {
                    var1_3 = var3_1.yq.N();
                } else {
                    var4_2 = var3_1;
                    if (!var2_4) continue block0;
                    var1_3 = 32;
                }
                var3_1.yq((char)var1_3);
            }
            break;
        }
        if (var3_1.N.size() == 1) {
            return (Y4)var3_1.N.get(0);
        }
        return new X7.yq(var3_1.N);
    }

    public final String toString() {
        return this.SN;
    }
}

