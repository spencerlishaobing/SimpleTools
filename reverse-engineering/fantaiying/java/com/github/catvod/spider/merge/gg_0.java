/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.spider.merge.GG
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.GG;
import com.github.catvod.spider.merge.VV;
import com.github.catvod.spider.merge.YG;
import com.github.catvod.spider.merge.ev_0;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.zc_0;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/*
 * Renamed from com.github.catvod.spider.merge.GG
 */
public abstract class gg_0
implements Serializable {
    private static final ThreadLocal<WeakHashMap<Object, Object>> W;
    public static final gg_0 v3;
    private String B = "<null>";
    private String F5 = ">";
    private String G = "<size=";
    private String G4 = ">";
    private boolean Gc;
    private String KJ = "{";
    private String M = ",";
    private boolean N;
    private boolean SN = true;
    private String dT = "<";
    private String i = "]";
    private String q = "}";
    private String t0 = "=";
    private boolean tF = true;
    private boolean yq = true;
    private String zH = "[";

    static {
        v3 = new yq();
        new N();
        new zH();
        new i();
        new t0();
        new tF();
        new SN();
        W = new ThreadLocal();
    }

    protected gg_0() {
    }

    static void E1(Object object) {
        Map<Object, Object> map;
        if (object != null && (map = gg_0.ee()) != null) {
            map.remove(object);
            if (map.isEmpty()) {
                W.remove();
            }
        }
    }

    static Map<Object, Object> ee() {
        return W.get();
    }

    static void g9(Object object) {
        if (object != null) {
            if (gg_0.ee() == null) {
                W.set(new WeakHashMap());
            }
            gg_0.ee().put(object, null);
        }
    }

    protected final void B(StringBuffer stringBuffer) {
        stringBuffer.append(this.B);
    }

    protected final void Dr() {
        this.dT = "\"<";
    }

    protected final String F5() {
        return this.KJ;
    }

    protected final void Fz() {
        this.N = true;
    }

    public final void G(StringBuffer stringBuffer, Object object) {
        if (object != null) {
            if (this.SN) {
                gg_0.g9(object);
                boolean bl = this.N;
                Object object2 = object.getClass();
                object2 = bl ? VV.yq(object2) : ((Class)object2).getName();
                stringBuffer.append((String)object2);
            }
            if (this.tF) {
                gg_0.g9(object);
                stringBuffer.append('@');
                stringBuffer.append(Integer.toHexString(System.identityHashCode(object)));
            }
            stringBuffer.append(this.zH);
            if (this.Gc) {
                stringBuffer.append(this.M);
            }
        }
    }

    protected final void G4(StringBuffer stringBuffer, int n2) {
        stringBuffer.append(this.G);
        stringBuffer.append(n2);
        stringBuffer.append(this.G4);
    }

    public final void Gc(StringBuffer stringBuffer, Object object) {
        if (YG.yq(stringBuffer, this.M)) {
            stringBuffer.setLength(stringBuffer.length() - this.M.length());
        }
        stringBuffer.append(this.i);
        gg_0.E1(object);
    }

    protected final void Gd() {
        this.KJ = "[";
    }

    protected final void H() {
        this.yq = false;
    }

    protected void KJ(StringBuffer stringBuffer, String string) {
        if (this.yq && string != null) {
            stringBuffer.append(string);
            stringBuffer.append(this.t0);
        }
    }

    protected final void M(StringBuffer stringBuffer) {
        stringBuffer.append(this.M);
    }

    protected void N(StringBuffer stringBuffer, char c) {
        stringBuffer.append(c);
    }

    protected final void Nl(String string) {
        String string2 = string;
        if (string == null) {
            string2 = "";
        }
        this.i = string2;
    }

    protected final void O() {
        this.t0 = ":";
    }

    protected final void OW(String string) {
        this.zH = string;
    }

    public final void SN(StringBuffer stringBuffer, String string, boolean bl) {
        this.KJ(stringBuffer, string);
        stringBuffer.append(bl);
        stringBuffer.append(this.M);
    }

    protected final void U() {
        this.tF = false;
    }

    protected final String W() {
        return this.zH;
    }

    protected final void Zm() {
        this.F5 = ">\"";
    }

    protected final void b() {
        this.G = "\"<size=";
    }

    protected final String dT() {
        return this.q;
    }

    protected final void g() {
        this.SN = false;
    }

    protected final void g1(String string) {
        String string2 = string;
        if (string == null) {
            string2 = "";
        }
        this.M = string2;
    }

    protected void i(StringBuffer stringBuffer, String string, Collection<?> collection) {
        stringBuffer.append(collection);
    }

    protected final void n() {
        this.B = "null";
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final void q(StringBuffer var1_1, String var2_3, Object var3_4, boolean var4_5) {
        block39: {
            var16_6 = gg_0.ee();
            var7_7 = 0;
            var13_8 = 0;
            var10_9 = 0;
            var11_10 = 0;
            var8_11 = 0;
            var9_12 = 0;
            var6_13 = 0;
            var12_14 = 0;
            var14_15 = 0;
            var5_16 = var16_6 != null && var16_6.containsKey(var3_4) != false ? 1 : 0;
            if (!(var5_16 == 0 || var3_4 instanceof Number || var3_4 instanceof Boolean || var3_4 instanceof Character)) {
                zc_0.yq(var1_1, var3_4);
                return;
            }
            gg_0.g9(var3_4);
            try {
                block41: {
                    block40: {
                        if (!(var3_4 instanceof Collection)) break block40;
                        if (var4_5) {
                            this.i(var1_1, (String)var2_3, (Collection)var3_4);
                            break block39;
                        }
                        var5_16 = ((Collection)var3_4).size();
                        ** GOTO lbl29
                    }
                    if (!(var3_4 instanceof Map)) break block41;
                    if (var4_5) {
                        this.t0(var1_1, (Map)var3_4);
                        break block39;
                    } else {
                        var5_16 = ((Map)var3_4).size();
lbl29:
                        // 2 sources

                        this.G4(var1_1, var5_16);
                    }
                    break block39;
                }
                var15_17 = var3_4 instanceof long[];
                if (!var15_17) ** GOTO lbl55
                if (var4_5) {
                    var2_3 = (long[])var3_4;
                    var1_1.append(this.KJ);
                    for (var5_16 = var14_15; var5_16 < ((Object)var2_3).length; ++var5_16) {
                        if (var5_16 > 0) {
                            var1_1.append(",");
                        }
                        var1_1.append((long)var2_3[var5_16]);
                    }
                }
                ** GOTO lbl53
            }
            catch (Throwable var1_2) {
                gg_0.E1(var3_4);
                throw var1_2;
            }
            {
                var1_1.append(this.q);
                break block39;
lbl53:
                // 1 sources

                this.G4(var1_1, ((long[])var3_4).length);
                break block39;
lbl55:
                // 1 sources

                if (!(var3_4 instanceof int[])) ** GOTO lbl72
                if (!var4_5) ** GOTO lbl70
                var2_3 = (int[])var3_4;
                var1_1.append(this.KJ);
                for (var5_16 = var7_7; var5_16 < ((Object)var2_3).length; ++var5_16) {
                    if (var5_16 > 0) {
                        var1_1.append(",");
                    }
                    var1_1.append((int)var2_3[var5_16]);
                }
            }
            {
                var1_1.append(this.q);
                break block39;
lbl70:
                // 1 sources

                this.G4(var1_1, ((int[])var3_4).length);
                break block39;
lbl72:
                // 1 sources

                if (!(var3_4 instanceof short[])) ** GOTO lbl89
                if (!var4_5) ** GOTO lbl87
                var2_3 = (short[])var3_4;
                var1_1.append(this.KJ);
                for (var5_16 = var13_8; var5_16 < ((Object)var2_3).length; ++var5_16) {
                    if (var5_16 > 0) {
                        var1_1.append(",");
                    }
                    var1_1.append((int)var2_3[var5_16]);
                }
            }
            {
                var1_1.append(this.q);
                break block39;
lbl87:
                // 1 sources

                this.G4(var1_1, ((short[])var3_4).length);
                break block39;
lbl89:
                // 1 sources

                if (!(var3_4 instanceof byte[])) ** GOTO lbl106
                if (!var4_5) ** GOTO lbl104
                var2_3 = (byte[])var3_4;
                var1_1.append(this.KJ);
                for (var5_16 = var10_9; var5_16 < ((Object)var2_3).length; ++var5_16) {
                    if (var5_16 > 0) {
                        var1_1.append(",");
                    }
                    var1_1.append((int)var2_3[var5_16]);
                }
            }
            {
                var1_1.append(this.q);
                break block39;
lbl104:
                // 1 sources

                this.G4(var1_1, ((byte[])var3_4).length);
                break block39;
lbl106:
                // 1 sources

                if (!(var3_4 instanceof char[])) ** GOTO lbl122
                if (!var4_5) ** GOTO lbl120
                var2_3 = (char[])var3_4;
                var1_1.append(this.KJ);
                for (var5_16 = var11_10; var5_16 < ((Object)var2_3).length; ++var5_16) {
                    if (var5_16 > 0) {
                        var1_1.append(",");
                    }
                    this.N(var1_1, (char)var2_3[var5_16]);
                }
            }
            {
                var1_1.append(this.q);
                break block39;
lbl120:
                // 1 sources

                this.G4(var1_1, ((char[])var3_4).length);
                break block39;
lbl122:
                // 1 sources

                if (!(var3_4 instanceof double[])) ** GOTO lbl139
                if (!var4_5) ** GOTO lbl137
                var2_3 = (double[])var3_4;
                var1_1.append(this.KJ);
                for (var5_16 = var8_11; var5_16 < ((Object)var2_3).length; ++var5_16) {
                    if (var5_16 > 0) {
                        var1_1.append(",");
                    }
                    var1_1.append((double)var2_3[var5_16]);
                }
            }
            {
                var1_1.append(this.q);
                break block39;
lbl137:
                // 1 sources

                this.G4(var1_1, ((double[])var3_4).length);
                break block39;
lbl139:
                // 1 sources

                if (!(var3_4 instanceof float[])) ** GOTO lbl156
                if (!var4_5) ** GOTO lbl154
                var2_3 = (float[])var3_4;
                var1_1.append(this.KJ);
                for (var5_16 = var9_12; var5_16 < ((Object)var2_3).length; ++var5_16) {
                    if (var5_16 > 0) {
                        var1_1.append(",");
                    }
                    var1_1.append((float)var2_3[var5_16]);
                }
            }
            {
                var1_1.append(this.q);
                break block39;
lbl154:
                // 1 sources

                this.G4(var1_1, ((float[])var3_4).length);
                break block39;
lbl156:
                // 1 sources

                if (!(var3_4 instanceof boolean[])) ** GOTO lbl173
                if (!var4_5) ** GOTO lbl171
                var2_3 = (boolean[])var3_4;
                var1_1.append(this.KJ);
                for (var5_16 = var6_13; var5_16 < ((Object)var2_3).length; ++var5_16) {
                    if (var5_16 > 0) {
                        var1_1.append(",");
                    }
                    var1_1.append((boolean)var2_3[var5_16]);
                }
            }
            {
                var1_1.append(this.q);
                break block39;
lbl171:
                // 1 sources

                this.G4(var1_1, ((boolean[])var3_4).length);
                break block39;
lbl173:
                // 1 sources

                if (!var3_4.getClass().isArray()) ** GOTO lbl194
                if (!var4_5) ** GOTO lbl192
                var17_18 = (Object[])var3_4;
                var1_1.append(this.KJ);
                ** for (var5_16 = var12_14;
                ; var5_16 < var17_18.length; ++var5_16)
            }
lbl-1000:
            // 1 sources

            {
                var16_6 = var17_18[var5_16];
                if (var5_16 <= 0) ** GOTO lbl183
                {
                    var1_1.append(",");
lbl183:
                    // 2 sources

                    if (var16_6 == null) {
                        var1_1.append(this.B);
                        continue;
                    }
                    this.q(var1_1, (String)var2_3, var16_6, true);
                    continue;
                }
            }
lbl-1000:
            // 1 sources

            {
                var1_1.append(this.q);
                break block39;
lbl192:
                // 1 sources

                this.G4(var1_1, ((Object[])var3_4).length);
                break block39;
lbl194:
                // 1 sources

                if (var4_5) {
                    this.zH(var1_1, (String)var2_3, var3_4);
                    break block39;
                }
                var1_1.append(this.dT);
                var1_1.append(VV.yq(var3_4.getClass()));
                var1_1.append(this.F5);
            }
        }
        gg_0.E1(var3_4);
    }

    protected final void s() {
        this.Gc = true;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    protected void t0(StringBuffer stringBuffer, Map map) {
        stringBuffer.append(map);
    }

    protected final void tF(StringBuffer stringBuffer, String string, int n2, Object object) {
        if (n2 > 0) {
            stringBuffer.append(",");
        }
        if (object == null) {
            stringBuffer.append(this.B);
        } else {
            this.q(stringBuffer, string, object, true);
        }
    }

    protected final void un() {
        this.G4 = ">\"";
    }

    protected final String v() {
        return this.B;
    }

    protected final String v3() {
        return this.i;
    }

    protected final void xa() {
        this.q = "]";
    }

    public void yq(StringBuffer stringBuffer, Object object) {
        this.KJ(stringBuffer, "value");
        if (object == null) {
            stringBuffer.append(this.B);
        } else {
            this.q(stringBuffer, "value", object, true);
        }
        stringBuffer.append(this.M);
    }

    protected void zH(StringBuffer stringBuffer, String string, Object object) {
        stringBuffer.append(object);
    }

    private static final class N
    extends GG {
        N() {
            this.OW("[");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("  ");
            this.g1(stringBuilder.toString());
            this.s();
            stringBuilder = new StringBuilder();
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("]");
            this.Nl(stringBuilder.toString());
        }
    }

    private static final class SN
    extends GG {
        SN() {
            this.g();
            this.U();
            this.OW("{");
            this.Nl("}");
            this.Gd();
            this.xa();
            this.g1(",");
            this.O();
            this.n();
            this.Dr();
            this.Zm();
            this.b();
            this.un();
        }

        protected final void KJ(StringBuffer stringBuffer, String string) {
            StringBuilder stringBuilder = oi_0.yq("\"");
            stringBuilder.append(ev_0.yq(string));
            stringBuilder.append("\"");
            super.KJ(stringBuffer, stringBuilder.toString());
        }

        protected final void N(StringBuffer stringBuffer, char c) {
            stringBuffer.append('\"');
            stringBuffer.append(ev_0.yq(String.valueOf(c)));
            stringBuffer.append('\"');
        }

        protected final void i(StringBuffer stringBuffer, String string, Collection<?> object) {
            if (object != null && !object.isEmpty()) {
                stringBuffer.append(this.F5());
                int n2 = 0;
                object = object.iterator();
                while (object.hasNext()) {
                    this.tF(stringBuffer, string, n2, object.next());
                    ++n2;
                }
                stringBuffer.append(this.dT());
                return;
            }
            stringBuffer.append(object);
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        protected final void t0(StringBuffer stringBuffer, Map object) {
            if (object != null && !object.isEmpty()) {
                stringBuffer.append(this.W());
                Iterator iterator = object.entrySet().iterator();
                boolean bl = true;
                while (iterator.hasNext()) {
                    Map.Entry entry = iterator.next();
                    object = Objects.toString(entry.getKey(), null);
                    if (object == null) continue;
                    if (bl) {
                        bl = false;
                    } else {
                        this.M(stringBuffer);
                    }
                    this.KJ(stringBuffer, (String)object);
                    entry = entry.getValue();
                    if (entry == null) {
                        this.B(stringBuffer);
                        continue;
                    }
                    this.q(stringBuffer, (String)object, entry, true);
                }
                stringBuffer.append(this.v3());
                return;
            }
            stringBuffer.append(object);
        }

        public final void yq(StringBuffer stringBuffer, Object object) {
            super.yq(stringBuffer, object);
        }

        protected final void zH(StringBuffer stringBuffer, String string, Object object) {
            if (object == null) {
                this.B(stringBuffer);
                return;
            }
            if (!(object instanceof String) && !(object instanceof Character)) {
                if (!(object instanceof Number) && !(object instanceof Boolean)) {
                    String string2 = object.toString();
                    boolean bl = string2.startsWith(this.W());
                    boolean bl2 = false;
                    boolean bl3 = bl && string2.endsWith(this.v3());
                    if (!bl3) {
                        bl3 = bl2;
                        if (string2.startsWith(this.F5())) {
                            bl3 = bl2;
                            if (string2.endsWith(this.dT())) {
                                bl3 = true;
                            }
                        }
                        if (!bl3) {
                            this.zH(stringBuffer, string, string2);
                            return;
                        }
                    }
                    stringBuffer.append(object);
                    return;
                }
                stringBuffer.append(object);
                return;
            }
            string = object.toString();
            stringBuffer.append('\"');
            stringBuffer.append(ev_0.yq(string));
            stringBuffer.append('\"');
        }
    }

    private static final class i
    extends GG {
        i() {
            this.Fz();
            this.U();
        }
    }

    private static final class t0
    extends GG {
        t0() {
            this.g();
            this.U();
            this.H();
            this.OW("");
            this.Nl("");
        }
    }

    private static final class tF
    extends GG {
        tF() {
            this.g();
            this.U();
        }
    }

    private static final class yq
    extends GG {
        yq() {
        }
    }

    private static final class zH
    extends GG {
        zH() {
            this.H();
        }
    }
}

