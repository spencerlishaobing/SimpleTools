/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.IL;
import com.github.catvod.spider.merge.J6;
import com.github.catvod.spider.merge.O2;
import com.github.catvod.spider.merge.Rc;
import com.github.catvod.spider.merge.UH;
import com.github.catvod.spider.merge.V3;
import com.github.catvod.spider.merge.YG;
import com.github.catvod.spider.merge.h_0;
import com.github.catvod.spider.merge.ly_0;
import com.github.catvod.spider.merge.qk;
import com.github.catvod.spider.merge.tm_0;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.Objects;

/*
 * Renamed from com.github.catvod.spider.merge.ev
 */
@Deprecated
public final class ev_0 {
    public static final h_0 SN;
    public static final h_0 yq;

    static {
        Object object = new O2({"\"", "\\\""}, {"\\", "\\\\"});
        Object object2 = new O2(UH.M());
        Object object3 = new qk[2];
        object3[0] = object;
        System.arraycopy(new qk[]{object2}, 0, object3, 1, 1);
        object2 = new h_0((qk)object3);
        object3 = new J6();
        object = new qk[2];
        object[0] = object2;
        System.arraycopy(new qk[]{object3}, 0, object, 1, 1);
        new h_0((qk[])object);
        object2 = new String[]{"/", "\\/"};
        new h_0(new O2(new String[][]{{"'", "\\'"}, {"\"", "\\\""}, {"\\", "\\\\"}, object2}), new O2(UH.M()), new J6());
        yq = new h_0(new O2({"\"", "\\\""}, {"\\", "\\\\"}, {"/", "\\/"}), new O2(UH.M()), new J6());
        new h_0(new O2(UH.N()), new O2(UH.yq()));
        String[] stringArray = new O2(UH.N());
        O2 o2 = new O2(UH.yq());
        String[] stringArray2 = new String[]{"\u0002", ""};
        object3 = new String[]{"\u0003", ""};
        object2 = new String[]{"\u0004", ""};
        String[] stringArray3 = new String[]{"\u0005", ""};
        String[] stringArray4 = new String[]{"\u0007", ""};
        String[] stringArray5 = new String[]{"\u000b", ""};
        String[] stringArray6 = new String[]{"\f", ""};
        String[] stringArray7 = new String[]{"\u0011", ""};
        String[] stringArray8 = new String[]{"\u0013", ""};
        String[] stringArray9 = new String[]{"\u0016", ""};
        String[] stringArray10 = new String[]{"\u0017", ""};
        String[] stringArray11 = new String[]{"\u0019", ""};
        String[] stringArray12 = new String[]{"\u001b", ""};
        String[] stringArray13 = new String[]{"\u001d", ""};
        object = new String[]{"\u001f", ""};
        String[] stringArray14 = new String[]{"\uffff", ""};
        new h_0(new qk[]{stringArray, o2, new O2(new String[][]{{"\u0000", ""}, {"\u0001", ""}, stringArray2, object3, object2, stringArray3, {"\u0006", ""}, stringArray4, {"\b", ""}, stringArray5, stringArray6, {"\u000e", ""}, {"\u000f", ""}, {"\u0010", ""}, stringArray7, {"\u0012", ""}, stringArray8, {"\u0014", ""}, {"\u0015", ""}, stringArray9, stringArray10, {"\u0018", ""}, stringArray11, {"\u001a", ""}, stringArray12, {"\u001c", ""}, stringArray13, {"\u001e", ""}, object, {"\ufffe", ""}, stringArray14}), IL.N(127, 132), IL.N(134, 159), new Rc()});
        object = new O2(UH.N());
        object2 = new O2(UH.yq());
        stringArray3 = new String[]{"\u0000", ""};
        object3 = new String[]{"\u000b", "&#11;"};
        stringArray = new String[]{"\uffff", ""};
        new h_0(new qk[]{object, object2, new O2(new String[][]{stringArray3, object3, {"\f", "&#12;"}, {"\ufffe", ""}, stringArray}), IL.N(1, 8), IL.N(14, 31), IL.N(127, 132), IL.N(134, 159), new Rc()});
        new h_0(new O2(UH.N()), new O2(UH.t0()));
        new h_0(new O2(UH.N()), new O2(UH.t0()), new O2(UH.zH()));
        SN = new h_0(new V3(), new ly_0(), new O2(UH.KJ()), new O2({"\\\\", "\\"}, {"\\\"", "\""}, {"\\'", "'"}, {"\\", ""}));
        new h_0(new O2(UH.tF()), new O2(UH.Gc()), new tm_0(new tm_0.yq[0]));
        new h_0(new O2(UH.tF()), new O2(UH.Gc()), new O2(UH.i()), new tm_0(new tm_0.yq[0]));
        new h_0(new O2(UH.tF()), new O2(UH.SN()), new tm_0(new tm_0.yq[0]));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final String yq(String string) {
        h_0 h_02 = yq;
        Objects.requireNonNull(h_02);
        if (string == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter(string.length() * 2);
        int n2 = string.length();
        int n3 = 0;
        block9: while (n3 < n2) {
            int n4;
            int n5;
            block12: {
                n5 = h_02.yq(string, n3, stringWriter);
                if (n5 != 0) break block12;
                char c = string.charAt(n3);
                ((Writer)stringWriter).write(c);
                n3 = n4 = n3 + 1;
                if (!Character.isHighSurrogate(c)) continue;
                n3 = n4;
                if (n4 >= n2) continue;
                c = string.charAt(n4);
                n3 = n4;
                if (!Character.isLowSurrogate(c)) continue;
                ((Writer)stringWriter).write(c);
                n3 = n4 + 1;
                continue;
            }
            n4 = 0;
            int n7 = n3;
            while (true) {
                n3 = n7;
                if (n4 >= n5) continue block9;
                n7 += Character.charCount(Character.codePointAt(string, n7));
                ++n4;
                continue;
                break;
            }
        }
        try {
            return stringWriter.toString();
        }
        catch (IOException iOException) {
            RuntimeException runtimeException = new RuntimeException(iOException);
            throw runtimeException;
        }
    }

    static final class SN
    extends qk {
        private static final char[] N;
        private static final String SN;

        static {
            SN = String.valueOf('\"');
            N = new char[]{',', '\"', '\r', '\n'};
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        @Override
        public final int yq(CharSequence var1_1, int var2_2, Writer var3_3) {
            block10: {
                block9: {
                    if (var2_2 != 0) break block10;
                    if (var1_1.charAt(0) != '\"') ** GOTO lbl-1000
                    var2_2 = var1_1.length();
                    var7_4 = true;
                    if (var1_1.charAt(var2_2 - 1) != '\"') ** GOTO lbl-1000
                    var10_5 = var1_1.subSequence(1, var1_1.length() - 1).toString();
                    var11_6 /* !! */  = com.github.catvod.spider.merge.ev$SN.N;
                    if (!YG.N(var10_5)) {
                        var2_2 = var11_6 /* !! */  == null ? 0 : Array.getLength(var11_6 /* !! */ );
                        if ((var2_2 = var2_2 == 0 ? 1 : 0) == 0) {
                            var9_7 = var10_5.length();
                            var8_8 = var11_6 /* !! */ .length;
                            for (var2_2 = 0; var2_2 < var9_7; ++var2_2) {
                                var4_9 = var10_5.charAt(var2_2);
                                for (var5_10 = 0; var5_10 < var8_8; ++var5_10) {
                                    if (var11_6 /* !! */ [var5_10] != var4_9) continue;
                                    var6_11 = var7_4;
                                    if (Character.isHighSurrogate(var4_9)) {
                                        if (var5_10 == var8_8 - 1) {
                                            var6_11 = var7_4;
                                        } else {
                                            if (var2_2 >= var9_7 - 1 || var11_6 /* !! */ [var5_10 + 1] != var10_5.charAt(var2_2 + 1)) continue;
                                            var6_11 = var7_4;
                                        }
                                    }
                                    break block9;
                                }
                            }
                        }
                    }
                    var6_11 = false;
                }
                if (var6_11) {
                    var12_12 = new StringBuilder();
                    var11_6 /* !! */  = (char[])com.github.catvod.spider.merge.ev$SN.SN;
                    var12_12.append((String)var11_6 /* !! */ );
                    var12_12.append((String)var11_6 /* !! */ );
                    var10_5 = YG.Gc(var10_5, var12_12.toString(), (String)var11_6 /* !! */ );
                } else lbl-1000:
                // 3 sources

                {
                    var10_5 = var1_1.toString();
                }
                var3_3.write(var10_5);
                return Character.codePointCount((CharSequence)var1_1, 0, var1_1.length());
            }
            var1_1 = new IllegalStateException("CsvUnescaper should never reach the [1] index");
            throw var1_1;
        }
    }

    static final class yq
    extends qk {
        private static final char[] N;
        private static final String SN;

        static {
            SN = String.valueOf('\"');
            N = new char[]{',', '\"', '\r', '\n'};
        }

        @Override
        public final int yq(CharSequence object, int n2, Writer writer) {
            if (n2 == 0) {
                Object object2;
                CharSequence charSequence;
                block6: {
                    charSequence = object.toString();
                    object2 = N;
                    n2 = YG.yq;
                    if (charSequence != null && object2 != null) {
                        int n3 = ((String)charSequence).length();
                        int n4 = ((char[])object2).length;
                        for (n2 = 0; n2 < n3; ++n2) {
                            char c = ((String)charSequence).charAt(n2);
                            for (int i2 = 0; i2 < n4; ++i2) {
                                if (object2[i2] != c || Character.isHighSurrogate(c) && i2 != n4 - 1 && (n2 >= n3 - 1 || object2[i2 + 1] != ((String)charSequence).charAt(n2 + 1))) continue;
                                n2 = 0;
                                break block6;
                            }
                        }
                    }
                    n2 = 1;
                }
                if (n2 != 0) {
                    writer.write(object.toString());
                } else {
                    writer.write(34);
                    object2 = object.toString();
                    String string = SN;
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(string);
                    ((StringBuilder)charSequence).append(string);
                    writer.write(YG.Gc((String)object2, string, ((StringBuilder)charSequence).toString()));
                    writer.write(34);
                }
                return Character.codePointCount((CharSequence)object, 0, object.length());
            }
            object = new IllegalStateException("CsvEscaper should never reach the [1] index");
            throw object;
        }
    }
}

