/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Bj;
import com.github.catvod.spider.merge.Cw;
import com.github.catvod.spider.merge.E0;
import com.github.catvod.spider.merge.Gk;
import com.github.catvod.spider.merge.MT;
import com.github.catvod.spider.merge.Os;
import com.github.catvod.spider.merge.P1;
import com.github.catvod.spider.merge.Pt;
import com.github.catvod.spider.merge.Q6;
import com.github.catvod.spider.merge.RM;
import com.github.catvod.spider.merge.S5;
import com.github.catvod.spider.merge.TK;
import com.github.catvod.spider.merge.TL;
import com.github.catvod.spider.merge.Uz;
import com.github.catvod.spider.merge.V2;
import com.github.catvod.spider.merge.W3;
import com.github.catvod.spider.merge.Wo;
import com.github.catvod.spider.merge.Wt;
import com.github.catvod.spider.merge.Yv;
import com.github.catvod.spider.merge.aq;
import com.github.catvod.spider.merge.cp;
import com.github.catvod.spider.merge.d7;
import com.github.catvod.spider.merge.e_0;
import com.github.catvod.spider.merge.fx;
import com.github.catvod.spider.merge.fy_1;
import com.github.catvod.spider.merge.gQ;
import com.github.catvod.spider.merge.il_0;
import com.github.catvod.spider.merge.j;
import com.github.catvod.spider.merge.j2;
import com.github.catvod.spider.merge.lF;
import com.github.catvod.spider.merge.lx_0;
import com.github.catvod.spider.merge.mZ;
import com.github.catvod.spider.merge.mg_0;
import com.github.catvod.spider.merge.mg_1;
import com.github.catvod.spider.merge.p_0;
import com.github.catvod.spider.merge.qh;
import com.github.catvod.spider.merge.ru;
import com.github.catvod.spider.merge.si_0;
import com.github.catvod.spider.merge.ue;
import com.github.catvod.spider.merge.ur;
import com.github.catvod.spider.merge.w_0;
import com.github.catvod.spider.merge.wd_0;
import com.github.catvod.spider.merge.zn_0;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public final class Hj {
    private static final UUID N;
    private static final UUID SN;
    public static final UUID i;
    private static final UUID tF;
    private static final List<UUID> zH;
    private final p_0 yq;

    static {
        UUID uUID;
        UUID uUID2;
        UUID uUID3;
        UUID uUID4 = UUID.fromString("33761B2D-78BB-4A43-8B0B-4F5BEE8AACF3");
        SN = uUID3 = UUID.fromString("1DA0C57D-6C06-438A-9B27-10BCB3CE0F61");
        N = uUID2 = UUID.fromString("AADB8D7E-AEEF-4415-AD2B-8204D6CF042E");
        tF = uUID = UUID.fromString("59627784-3BE5-417A-B9EB-8131A7286089");
        ArrayList<UUID> arrayList = new ArrayList<UUID>();
        zH = arrayList;
        arrayList.add(uUID4);
        arrayList.add(uUID3);
        arrayList.add(uUID2);
        arrayList.add(uUID);
        i = uUID;
    }

    public Hj() {
        p_0 p_02 = p_0.yq();
        this.yq = p_02;
    }

    private int N(char[] cArray, int n2, List<aq> list, yq yq2) {
        int n3 = n2 + 1;
        int n4 = cArray[n2];
        n2 = n3;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = cArray[n2];
            n3 = n2 + 1;
            aq aq2 = new aq(new int[0]);
            list.add(aq2);
            n2 = cArray[n3] != '\u0000' ? 1 : 0;
            if (n2 != 0) {
                aq2.yq(-1);
            }
            n2 = n3 + 1;
            for (n3 = 0; n3 < n5; ++n3) {
                int n7 = yq2.yq(cArray, n2);
                int n8 = yq2.yq(cArray, n2 += yq2.size());
                n2 += yq2.size();
                aq2.SN(n7, n8);
            }
        }
        return n2;
    }

    protected static boolean tF(UUID uUID, UUID uUID2) {
        List<UUID> list = zH;
        int n2 = ((ArrayList)list).indexOf(uUID);
        boolean bl = false;
        if (n2 < 0) {
            return false;
        }
        if (((ArrayList)list).indexOf(uUID2) >= n2) {
            bl = true;
        }
        return bl;
    }

    protected static long zH(char[] cArray, int n2) {
        long l = cArray[n2] | cArray[n2 + 1] << 16;
        char c = cArray[n2 += 2];
        return (long)(cArray[n2 + 1] << 16 | c) << 32 | l & 0xFFFFFFFFL;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public final lF SN(char[] var1_1) {
        block77: {
            block78: {
                var16_2 = (char[])var1_1.clone();
                for (var2_3 = 1; var2_3 < ((char[])var16_2).length; ++var2_3) {
                    var16_2[var2_3] = (char)(var16_2[var2_3] - 2);
                }
                var2_3 = var16_2[0];
                if (var2_3 != 3) break block77;
                var13_4 = Hj.zH((char[])var16_2, 1);
                var17_5 = new UUID(Hj.zH((char[])var16_2, 5), var13_4);
                if (!Hj.zH.contains(var17_5)) break block78;
                var11_6 = Hj.tF(Hj.SN, (UUID)var17_5);
                var12_7 = Hj.tF(Hj.N, (UUID)var17_5);
                var15_8 = new lF(cp.N(2)[var16_2[9]], var16_2[10]);
                var19_9 /* !! */  = new ArrayList<E>();
                var18_10 = new ArrayList<E>();
                var6_11 = var16_2[11];
                var2_3 = 12;
                for (var3_12 = 0; var3_12 < var6_11; ++var3_12) {
                    block79: {
                        var5_14 /* !! */  = var2_3 + 1;
                        var7_15 = var16_2[var2_3];
                        if (var7_15 == '\u0000') {
                            var15_8.yq(null);
                            var2_3 = var5_14 /* !! */ ;
                            continue;
                        }
                        var4_13 /* !! */  = var5_14 /* !! */  + 1;
                        var2_3 = var5_14 /* !! */  = var16_2[var5_14 /* !! */ ];
                        if (var5_14 /* !! */  == 65535) {
                            var2_3 = -1;
                        }
                        switch (var7_15) {
                            default: {
                                throw new IllegalArgumentException(String.format(Locale.getDefault(), "The specified state type %d is not valid.", new Object[]{(int)var7_15}));
                            }
                            case '\f': {
                                var1_1 = new RM();
                                ** GOTO lbl66
                            }
                            case '\u000b': {
                                var1_1 = new E0();
                                ** GOTO lbl66
                            }
                            case '\n': {
                                var1_1 = new si_0();
                                ** GOTO lbl66
                            }
                            case '\t': {
                                var1_1 = new P1();
                                ** GOTO lbl66
                            }
                            case '\b': {
                                var1_1 = new e_0();
                                ** GOTO lbl66
                            }
                            case '\u0007': {
                                var1_1 = new Wo();
                                ** GOTO lbl66
                            }
                            case '\u0006': {
                                var1_1 = new Q6();
                                ** GOTO lbl66
                            }
                            case '\u0005': {
                                var1_1 = new wd_0();
                                ** GOTO lbl66
                            }
                            case '\u0004': {
                                var1_1 = new Cw();
                                ** GOTO lbl66
                            }
                            case '\u0003': {
                                var1_1 = new fy_1();
                                ** GOTO lbl66
                            }
                            case '\u0002': {
                                var1_1 = new Bj();
                                ** GOTO lbl66
                            }
                            case '\u0001': {
                                var1_1 = new TK();
lbl66:
                                // 12 sources

                                var1_1.N = var2_3;
                                break block79;
                            }
                            case '\u0000': 
                        }
                        var1_1 = null;
                    }
                    if (var7_15 == '\f') {
                        var2_3 = var16_2[var4_13 /* !! */ ];
                        var19_9 /* !! */ .add(new mg_1<RM, Integer>((RM)var1_1, var2_3));
                        var2_3 = var4_13 /* !! */  + 1;
                    } else {
                        var2_3 = var4_13 /* !! */ ;
                        if (var1_1 instanceof j2) {
                            var2_3 = var16_2[var4_13 /* !! */ ];
                            var18_10.add(new mg_1<j2, Integer>((j2)var1_1, var2_3));
                            var2_3 = var4_13 /* !! */  + 1;
                        }
                    }
                    var15_8.yq((j)var1_1);
                }
                var1_1 = var19_9 /* !! */ .iterator();
                while (var1_1.hasNext()) {
                    var19_9 /* !! */  = (mg_1)var1_1.next();
                    ((RM)var19_9 /* !! */ .yq).t0 = (j)var15_8.yq.get((Integer)var19_9 /* !! */ .SN);
                }
                var18_10 = var18_10.iterator();
                while (var18_10.hasNext()) {
                    var1_1 = (mg_1)var18_10.next();
                    ((j2)var1_1.yq).M = (e_0)var15_8.yq.get((Integer)var1_1.SN);
                }
                var4_13 /* !! */  = var2_3 + 1;
                var5_14 /* !! */  = var16_2[var2_3];
                var3_12 = 0;
                var2_3 = var4_13 /* !! */ ;
                while (var3_12 < var5_14 /* !! */ ) {
                    var4_13 /* !! */  = var16_2[var2_3];
                    ((V2)var15_8.yq.get((int)var4_13 /* !! */ )).Gc = true;
                    ++var3_12;
                    ++var2_3;
                }
                var3_12 = var2_3;
                if (var11_6) {
                    var4_13 /* !! */  = var2_3 + 1;
                    var5_14 /* !! */  = var16_2[var2_3];
                    var3_12 = 0;
                    var2_3 = var4_13 /* !! */ ;
                    while (var3_12 < var5_14 /* !! */ ) {
                        var4_13 /* !! */  = var16_2[var2_3];
                        ((Bj)var15_8.yq.get((int)var4_13 /* !! */ )).Gc = true;
                        ++var3_12;
                        ++var2_3;
                    }
                    var3_12 = var2_3;
                }
                var2_3 = var3_12 + 1;
                var6_11 = var16_2[var3_12];
                if (var15_8.zH == 1) {
                    var15_8.t0 = new int[var6_11];
                }
                var15_8.N = new Bj[var6_11];
                for (var3_12 = 0; var3_12 < var6_11; ++var3_12) {
                    var5_14 /* !! */  = var2_3 + 1;
                    var2_3 = var16_2[var2_3];
                    var15_8.N[var3_12] = var1_1 = (Bj)var15_8.yq.get(var2_3);
                    var2_3 = var5_14 /* !! */ ;
                    if (var15_8.zH != 1) continue;
                    var4_13 /* !! */  = var5_14 /* !! */  + 1;
                    var2_3 = var5_14 /* !! */  = var16_2[var5_14 /* !! */ ];
                    if (var5_14 /* !! */  == 65535) {
                        var2_3 = -1;
                    }
                    var15_8.t0[var3_12] = var2_3;
                    var2_3 = var4_13 /* !! */ ;
                    if (Hj.tF(Hj.N, (UUID)var17_5)) continue;
                    var2_3 = var4_13 /* !! */  + 1;
                    var4_13 /* !! */  = var16_2[var4_13 /* !! */ ];
                }
                var15_8.tF = new Wo[var6_11];
                for (j var20_16 : var15_8.yq) {
                    if (!(var20_16 instanceof Wo)) continue;
                    var19_9 /* !! */  = (Wo)var20_16;
                    var1_1 = var15_8.tF;
                    var3_12 = var20_16.N;
                    var1_1[var3_12] = var19_9 /* !! */ ;
                    var15_8.N[var3_12].t0 = var19_9 /* !! */ ;
                }
                var4_13 /* !! */  = var2_3 + 1;
                var5_14 /* !! */  = var16_2[var2_3];
                var3_12 = 0;
                var2_3 = var4_13 /* !! */ ;
                while (var3_12 < var5_14 /* !! */ ) {
                    var4_13 /* !! */  = var16_2[var2_3];
                    var15_8.M.add((Q6)var15_8.yq.get(var4_13 /* !! */ ));
                    ++var3_12;
                    ++var2_3;
                }
                var18_10 = new ArrayList<E>();
                var2_3 = var3_12 = this.N((char[])var16_2, var2_3, (List<aq>)var18_10, new w_0());
                if (Hj.tF(Hj.tF, (UUID)var17_5)) {
                    var2_3 = this.N((char[])var16_2, var3_12, (List<aq>)var18_10, new mg_0());
                }
                var4_13 /* !! */  = var2_3 + 1;
                var5_14 /* !! */  = var16_2[var2_3];
                var2_3 = var4_13 /* !! */ ;
                for (var3_12 = 0; var3_12 < var5_14 /* !! */ ; ++var3_12) {
                    var10_19 = var16_2[var2_3];
                    var7_15 = var16_2[var2_3 + 1];
                    var6_11 = var16_2[var2_3 + 2];
                    var4_13 /* !! */  = var16_2[var2_3 + 3];
                    var9_18 = var16_2[var2_3 + 4];
                    var8_17 = var16_2[var2_3 + 5];
                    var17_5 = (j)var15_8.yq.get(var7_15);
                    switch (var6_11) {
                        default: {
                            throw new IllegalArgumentException("The specified transition type is not valid.");
                        }
                        case 10: {
                            var1_1 = new mZ((j)var17_5, var4_13 /* !! */ );
                            break;
                        }
                        case 9: {
                            var1_1 = new il_0((j)var17_5);
                            break;
                        }
                        case 8: {
                            var1_1 = new W3((j)var17_5, (aq)var18_10.get(var4_13 /* !! */ ));
                            break;
                        }
                        case 7: {
                            var1_1 = new TL((j)var17_5, (aq)var18_10.get(var4_13 /* !! */ ));
                            break;
                        }
                        case 6: {
                            var1_1 = new ue((j)var17_5, var4_13 /* !! */ , var9_18);
                            break;
                        }
                        case 5: {
                            if (var8_17 != '\u0000') {
                                var1_1 = new fx((j)var17_5, -1);
                                break;
                            }
                            var1_1 = new fx((j)var17_5, var4_13 /* !! */ );
                            break;
                        }
                        case 4: {
                            var11_6 = var8_17 != '\u0000';
                            var1_1 = new Wt((j)var17_5, var4_13 /* !! */ , var9_18, var11_6);
                            break;
                        }
                        case 3: {
                            var1_1 = new Os((Bj)var15_8.yq.get(var4_13 /* !! */ ), var8_17, (j)var17_5);
                            break;
                        }
                        case 2: {
                            if (var8_17 != '\u0000') {
                                var1_1 = new qh((j)var17_5, -1, var9_18);
                                break;
                            }
                            var1_1 = new qh((j)var17_5, var4_13 /* !! */ , var9_18);
                            break;
                        }
                        case 1: {
                            var1_1 = new zn_0((j)var17_5);
                        }
                    }
                    ((j)var15_8.yq.get(var10_19)).yq((Yv)var1_1);
                    var2_3 += 6;
                }
                for (Object var17_5 : var15_8.yq) {
                    for (var3_12 = 0; var3_12 < var17_5.SN(); ++var3_12) {
                        var18_10 = var17_5.tF(var3_12);
                        if (!(var18_10 instanceof Os)) continue;
                        var18_10 = (Os)var18_10;
                        var19_9 /* !! */  = var15_8.N;
                        var4_13 /* !! */  = var18_10.yq.N;
                        if (!var19_9 /* !! */ [var4_13 /* !! */ ].Gc || var18_10.SN != 0) {
                            var4_13 /* !! */  = -1;
                        }
                        var19_9 /* !! */  = new zn_0(var18_10.N, var4_13 /* !! */ );
                        var15_8.tF[var18_10.yq.N].yq((Yv)var19_9 /* !! */ );
                    }
                }
                for (Object var17_5 : var15_8.yq) {
                    block80: {
                        if (!(var17_5 instanceof j2)) break block80;
                        var19_9 /* !! */  = (j2)var17_5;
                        var18_10 = var19_9 /* !! */ .M;
                        if (var18_10 == null) ** GOTO lbl238
                        if (var18_10.t0 == null) {
                            var18_10.t0 = var19_9 /* !! */ ;
                        } else {
                            throw new IllegalStateException();
lbl238:
                            // 1 sources

                            throw new IllegalStateException();
                        }
                    }
                    if (var17_5 instanceof E0) {
                        var17_5 = (E0)var17_5;
                        for (var3_12 = 0; var3_12 < var17_5.SN(); ++var3_12) {
                            var18_10 = var17_5.tF((int)var3_12).yq;
                            if (!(var18_10 instanceof Cw)) continue;
                            ((Cw)var18_10).KJ = var17_5;
                        }
                        continue;
                    }
                    if (!(var17_5 instanceof P1)) continue;
                    var17_5 = (P1)var17_5;
                    for (var3_12 = 0; var3_12 < var17_5.SN(); ++var3_12) {
                        var18_10 = var17_5.tF((int)var3_12).yq;
                        if (!(var18_10 instanceof si_0)) continue;
                        ((si_0)var18_10).M = var17_5;
                    }
                }
                var4_13 /* !! */  = var2_3 + 1;
                var5_14 /* !! */  = var16_2[var2_3];
                var3_12 = 1;
                var2_3 = var4_13 /* !! */ ;
                while (var3_12 <= var5_14 /* !! */ ) {
                    var4_13 /* !! */  = var16_2[var2_3];
                    var1_1 = (V2)var15_8.yq.get(var4_13 /* !! */ );
                    var15_8.SN.add((V2)var1_1);
                    var1_1.t0 = var3_12 - 1;
                    ++var3_12;
                    ++var2_3;
                }
                if (var15_8.zH == 1) {
                    if (var12_7) {
                        var3_12 = var2_3 + 1;
                        var15_8.Gc = new Uz[var16_2[var2_3]];
                        for (var2_3 = 0; var2_3 < var15_8.Gc.length; ++var2_3) {
                            var1_1 = ur.values();
                            var4_13 /* !! */  = var3_12 + 1;
                            var1_1 = var1_1[var16_2[var3_12]];
                            var6_11 = var4_13 /* !! */  + 1;
                            var3_12 = var4_13 /* !! */  = (int)var16_2[var4_13 /* !! */ ];
                            if (var4_13 /* !! */  == 65535) {
                                var3_12 = -1;
                            }
                            var4_13 /* !! */  = var5_14 /* !! */  = (int)var16_2[var6_11];
                            if (var5_14 /* !! */  == 65535) {
                                var4_13 /* !! */  = -1;
                            }
                            switch (var1_1.ordinal()) {
                                default: {
                                    throw new IllegalArgumentException(String.format(Locale.getDefault(), "The specified lexer action type %d is not valid.", new Object[]{var1_1}));
                                }
                                case 7: {
                                    var1_1 = new d7(var3_12);
                                    break;
                                }
                                case 6: {
                                    var1_1 = S5.yq;
                                    break;
                                }
                                case 5: {
                                    var1_1 = new Gk(var3_12);
                                    break;
                                }
                                case 4: {
                                    var1_1 = lx_0.yq;
                                    break;
                                }
                                case 3: {
                                    var1_1 = MT.yq;
                                    break;
                                }
                                case 2: {
                                    var1_1 = new gQ(var3_12);
                                    break;
                                }
                                case 1: {
                                    var1_1 = new ru(var3_12, var4_13 /* !! */ );
                                    break;
                                }
                                case 0: {
                                    var1_1 = new Pt(var3_12);
                                }
                            }
                            var15_8.Gc[var2_3] = var1_1;
                            var3_12 = var6_11 + 1;
                        }
                    } else {
                        var16_2 = new ArrayList<E>();
                        for (Object var17_5 : var15_8.yq) {
                            for (var2_3 = 0; var2_3 < var17_5.SN(); ++var2_3) {
                                var18_10 = var17_5.tF(var2_3);
                                if (!(var18_10 instanceof ue)) continue;
                                var19_9 /* !! */  = (ue)var18_10;
                                var3_12 = var19_9 /* !! */ .SN;
                                var19_9 /* !! */  = new ru(var3_12, var19_9 /* !! */ .N);
                                var18_10 = new ue(var18_10.yq, var3_12, var16_2.size());
                                var17_5.zH.set(var2_3, (Yv)var18_10);
                                var16_2.add(var19_9 /* !! */ );
                            }
                        }
                        var15_8.Gc = var16_2.toArray(new Uz[var16_2.size()]);
                    }
                }
                var16_2 = var15_8.yq.iterator();
                while (var16_2.hasNext()) {
                    var1_1 = (j)var16_2.next();
                    if (!(var1_1 instanceof si_0) || !var15_8.N[var1_1.N].Gc || !((var17_5 = var1_1.tF((int)(var1_1.SN() - 1)).yq) instanceof RM) || !var17_5.tF || !(var17_5.tF((int)0).yq instanceof Wo)) continue;
                    ((si_0)var1_1).KJ = true;
                }
                Objects.requireNonNull(this.yq);
                this.i(var15_8);
                Objects.requireNonNull(this.yq);
                return var15_8;
            }
            var1_1 = String.format(Locale.getDefault(), "Could not deserialize ATN with UUID %s (expected %s or a legacy UUID).", new Object[]{var17_5, Hj.i});
            throw new UnsupportedOperationException(new InvalidClassException(lF.class.getName(), (String)var1_1));
        }
        var1_1 = String.format(Locale.getDefault(), "Could not deserialize ATN with version %d (expected %d).", new Object[]{var2_3, 3});
        var1_1 = new UnsupportedOperationException(new InvalidClassException(lF.class.getName(), (String)var1_1));
        throw var1_1;
    }

    protected final void i(lF object) {
        for (j j3 : ((lF)object).yq) {
            boolean bl;
            block18: {
                block17: {
                    boolean bl2;
                    block16: {
                        if (j3 == null) continue;
                        bl = j3.tF;
                        bl2 = false;
                        bl = bl || j3.SN() <= 1;
                        this.yq(bl);
                        if (j3 instanceof Cw) {
                            bl = ((Cw)j3).KJ != null;
                            this.yq(bl);
                        }
                        if (j3 instanceof si_0) {
                            si_0 si_02 = (si_0)j3;
                            bl = si_02.M != null;
                            this.yq(bl);
                            bl = si_02.SN() == 2;
                            this.yq(bl);
                            if (si_02.tF((int)0).yq instanceof wd_0) {
                                this.yq(si_02.tF((int)1).yq instanceof RM);
                                bl = si_02.Gc ^ true;
                            } else {
                                if (!(si_02.tF((int)0).yq instanceof RM)) {
                                    throw new IllegalStateException();
                                }
                                this.yq(si_02.tF((int)1).yq instanceof wd_0);
                                bl = si_02.Gc;
                            }
                            this.yq(bl);
                        }
                        if (j3 instanceof P1) {
                            bl = j3.SN() == 1;
                            this.yq(bl);
                            this.yq(j3.tF((int)0).yq instanceof si_0);
                        }
                        if (j3 instanceof RM) {
                            bl = ((RM)j3).t0 != null;
                            this.yq(bl);
                        }
                        if (j3 instanceof Bj) {
                            bl = ((Bj)j3).t0 != null;
                            this.yq(bl);
                        }
                        if (j3 instanceof j2) {
                            bl = ((j2)j3).M != null;
                            this.yq(bl);
                        }
                        if (j3 instanceof e_0) {
                            bl = ((e_0)j3).t0 != null;
                            this.yq(bl);
                        }
                        if (!(j3 instanceof V2)) break block16;
                        if ((j3 = (V2)j3).SN() <= 1) break block17;
                        bl = bl2;
                        if (((V2)j3).t0 < 0) break block18;
                        break block17;
                    }
                    if (j3.SN() <= 1) break block17;
                    bl = bl2;
                    if (!(j3 instanceof Wo)) break block18;
                }
                bl = true;
            }
            this.yq(bl);
        }
    }

    protected final void yq(boolean bl) {
        if (bl) {
            return;
        }
        throw new IllegalStateException(null);
    }

    static interface yq {
        public int size();

        public int yq(char[] var1, int var2);
    }
}

