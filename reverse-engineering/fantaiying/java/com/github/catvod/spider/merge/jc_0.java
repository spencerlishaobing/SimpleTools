/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.ZV;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * Renamed from com.github.catvod.spider.merge.Jc
 */
public final class jc_0 {
    private static final Set<String> yq = new HashSet<String>(Arrays.asList("moov", "trak", "mdia", "minf", "stbl", "edts", "dinf", "udta", "mvex", "moof", "traf"));

    public static List<String> Gc(Gc stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        yq yq2 = new yq(arrayList);
        yq2.yq(stringArray.zH);
        stringArray = stringArray.tF;
        if (stringArray != null) {
            int n2 = stringArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                yq2.yq(stringArray[i2]);
                if (arrayList.size() >= 4) break;
            }
        }
        return arrayList;
    }

    private static long KJ(tF tF2, long l) {
        long l2 = 0L;
        for (int i2 = 0; i2 < 8; ++i2) {
            l2 = l2 << 8 | (long)(tF2.yq((long)i2 + l) & 0xFF);
        }
        return l2;
    }

    private static long M(tF tF2, long l) {
        long l2 = tF2.yq(l) & 0xFF;
        long l5 = tF2.yq(1L + l) & 0xFF;
        long l6 = tF2.yq(2L + l) & 0xFF;
        return (long)(tF2.yq(l + 3L) & 0xFF) | (l2 << 24 | l5 << 16 | l6 << 8);
    }

    public static N N(N object, String string) {
        for (N n2 : ((N)object).zH) {
            if (n2.yq.equals(string)) {
                return n2;
            }
            if ((n2 = jc_0.N(n2, string)) == null) continue;
            return n2;
        }
        return null;
    }

    public static byte[] SN(Gc object, String charSequence, int n2) {
        int n3;
        String[] stringArray = ((Gc)object).tF;
        object = "";
        if (stringArray != null && n2 >= 0 && n2 < stringArray.length && stringArray[n2] != null) {
            charSequence = stringArray[n2];
            if (charSequence != null) {
                object = ((String)charSequence).trim();
            }
            if (((String)object).length() >= 32) {
                if (((String)object).substring(0, 32).length() % 2 == 0) {
                    object = ((String)object).substring(0, 32);
                } else {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(((String)object).substring(0, 31));
                    ((StringBuilder)charSequence).append("0");
                    object = ((StringBuilder)charSequence).toString();
                }
            } else {
                object = new StringBuilder((String)object);
                while (((StringBuilder)object).length() < 32) {
                    ((StringBuilder)object).append('0');
                }
                object = ((StringBuilder)object).substring(0, 32);
            }
            return ZV.SN((String)object);
        }
        if (charSequence != null) {
            object = ((String)charSequence).trim();
        }
        int n4 = Math.min(((String)object).length(), 16);
        long l = 0L;
        for (int i2 = 0; i2 < n4 && (n3 = Character.digit(((String)object).charAt(i2), 16)) >= 0; ++i2) {
            l = l << 4 | (long)n3;
        }
        long l2 = n2;
        object = new byte[16];
        for (n2 = 0; n2 < 8; ++n2) {
            object[n2] = (byte)(l + l2 >>> 56 - n2 * 8);
            object[n2 + 8] = false;
        }
        return object;
    }

    private static String i(tF tF2, long l, long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        long l5 = tF2.SN;
        long l6 = l - l5;
        l5 = l2 - l5;
        l = l6;
        if (l6 < 0L) {
            l = 0L;
        }
        byte[] byArray = tF2.yq;
        l6 = l;
        l2 = l5;
        if (l5 > (long)byArray.length) {
            l2 = byArray.length;
            l6 = l;
        }
        while (l6 < l2) {
            stringBuilder.append((char)(tF2.yq[(int)l6] & 0xFF));
            ++l6;
        }
        return stringBuilder.toString();
    }

    public static List<N> t0(tF tF2, long l, long l2) {
        ArrayList<N> arrayList = new ArrayList<N>();
        long l5 = l;
        while ((l = l5 + 8L) <= l2) {
            N n2;
            long l6;
            block9: {
                List<N> list;
                block8: {
                    block7: {
                        int n3;
                        l6 = jc_0.M(tF2, l5);
                        list = jc_0.i(tF2, 4L + l5, l);
                        if (l6 == 1L) {
                            if (16L + l5 > l2) break;
                            l = jc_0.KJ(tF2, l);
                            n3 = 16;
                        } else {
                            l = l6;
                            if (l6 == 0L) {
                                l = l2 - l5;
                            }
                            n3 = 8;
                        }
                        if (l < (long)n3 || (l6 = l5 + l) > l2 || l < 0L) break;
                        n2 = new N((String)((Object)list), l5, n3, l);
                        if (!((HashSet)yq).contains(list)) break block7;
                        list = n2.zH;
                        l = n2.SN();
                        break block8;
                    }
                    if (!((String)((Object)list)).equals("stsd")) break block9;
                    list = n2.zH;
                    l = n2.SN() + 8L;
                }
                ((ArrayList)list).addAll(jc_0.t0(tF2, l, n2.SN + n2.tF));
            }
            arrayList.add(n2);
            l5 = l6;
        }
        return arrayList;
    }

    public static i tF(zH zH2, long l) {
        long l2 = 0L;
        while (8L + l2 <= l) {
            int n2;
            long l5;
            int n3 = 8;
            byte[] byArray = zH2.head(l2, 8);
            if (byArray == null) {
                return null;
            }
            long l6 = (long)((byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF) & 0xFFFFFFFFL;
            String string = new String(byArray, 4, 4, StandardCharsets.ISO_8859_1);
            if (l6 == 1L) {
                byArray = zH2.head(l2, 16);
                if (byArray == null) {
                    return null;
                }
                l5 = 0L;
                for (n2 = 0; n2 < 8; ++n2) {
                    l5 = l5 << 8 | (long)(byArray[8 + n2] & 0xFF);
                }
                n2 = 16;
            } else {
                n2 = n3;
                l5 = l6;
                if (l6 == 0L) {
                    l5 = l - l2;
                    n2 = n3;
                }
            }
            if (l5 < (long)n2 || (l6 = l2 + l5) > l || l5 < 0L) break;
            if (string.equals("moov")) {
                return new i(l2, l5);
            }
            l2 = l6;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public static SN yq(tF object) {
        Object object2;
        long l = ((tF)object).SN;
        Iterator object32 = ((ArrayList)jc_0.t0((tF)object, l, (long)((tF)object).yq.length + l)).iterator();
        Object object3 = null;
        while (object32.hasNext()) {
            object2 = (N)object32.next();
            if (!((N)object2).yq.equals("moov")) continue;
            object3 = object2;
        }
        if (object3 != null) {
            long l2;
            SN sN = new SN();
            object2 = ((N)object3).yq("mvhd");
            if (object2 != null) {
                l2 = ((N)object2).SN();
                l = ((tF)object).yq(l2) == 1 ? 20L : 12L;
                jc_0.M((tF)object, l2 + l);
            }
            object2 = new ArrayList();
            for (N n2 : ((N)object3).zH) {
                if (!n2.yq.equals("trak")) continue;
                ((ArrayList)object2).add((N)n2);
            }
            object2 = ((ArrayList)object2).iterator();
            while (object2.hasNext()) {
                void var18_17;
                void var18_14;
                void var18_11;
                int n3;
                int n4;
                int n5;
                long l5;
                long l6;
                void var18_8;
                Object object4 = (N)object2.next();
                object3 = ((N)object4).yq("mdia");
                object3 = object3 == null ? null : ((N)object3).yq("minf");
                if (object3 == null) {
                    Object var18_6 = null;
                } else {
                    N n7 = ((N)object3).yq("stbl");
                }
                if (var18_8 == null) continue;
                object3 = new Gc();
                Object object5 = ((N)object4).yq("mdia");
                object5 = object5 == null ? null : ((N)object5).yq("hdlr");
                if (object5 != null) {
                    jc_0.i((tF)object, ((N)object5).SN() + 8L, ((N)object5).SN() + 12L);
                }
                object5 = ((N)object4).yq("tkhd");
                if (object5 != null) {
                    l2 = ((N)object5).SN();
                    if (((tF)object).yq(l2) == 1) {
                        jc_0.M((tF)object, l2 + 20L);
                        l = jc_0.M((tF)object, 88L + l2) / 65536L;
                        l = 92L;
                    } else {
                        jc_0.M((tF)object, l2 + 12L);
                        l = jc_0.M((tF)object, 76L + l2) / 65536L;
                        l = 80L;
                    }
                    l = jc_0.M((tF)object, l2 + l) / 65536L;
                }
                ArrayList<Long> arrayList = new ArrayList<Long>();
                ArrayList<Long> arrayList2 = new ArrayList<Long>();
                object5 = var18_8.yq("stsz");
                if (object5 != null) {
                    l6 = ((N)object5).SN() + 4L;
                    l5 = jc_0.M((tF)object, l6);
                    l2 = jc_0.M((tF)object, l6 + 4L);
                    if (l5 > 0L) {
                        for (l = 0L; l < l2; ++l) {
                            arrayList.add(l5);
                        }
                    } else {
                        for (l = 0L; l < l2; ++l) {
                            arrayList.add(jc_0.M((tF)object, l * 4L + (l6 + 8L)));
                        }
                    }
                }
                ArrayList<long[]> arrayList3 = new ArrayList<long[]>();
                object5 = var18_8.yq("stsc");
                if (object5 != null) {
                    l = ((N)object5).SN() + 4L;
                    l6 = jc_0.M((tF)object, l);
                    for (l2 = 0L; l2 < l6; ++l2) {
                        l5 = l2 * 12L + (l + 4L);
                        arrayList3.add(new long[]{jc_0.M((tF)object, l5), jc_0.M((tF)object, l5 + 4L), jc_0.M((tF)object, l5 + 8L)});
                    }
                }
                ArrayList<Long> arrayList4 = new ArrayList<Long>();
                object5 = var18_8.yq("stco");
                if (object5 != null) {
                    l2 = ((N)object5).SN() + 4L;
                    l6 = jc_0.M((tF)object, l2);
                    for (l = 0L; l < l6; ++l) {
                        arrayList4.add(jc_0.M((tF)object, l * 4L + (l2 + 4L)));
                    }
                } else {
                    object5 = var18_8.yq("co64");
                    if (object5 != null) {
                        l2 = ((N)object5).SN() + 4L;
                        l6 = jc_0.M((tF)object, l2);
                        for (l = 0L; l < l6; ++l) {
                            arrayList4.add(jc_0.KJ((tF)object, l * 8L + (l2 + 4L)));
                        }
                    }
                }
                int n8 = 0;
                while (n8 < arrayList3.size()) {
                    long[] lArray = (long[])arrayList3.get(n8);
                    object5 = ++n8 < arrayList3.size() ? (Object)((long[])arrayList3.get(n8)) : null;
                    l = object5 != null ? (long)(object5[0] - 1L) : (long)arrayList4.size();
                    for (l2 = lArray[0]; l2 <= l && (n5 = (int)(l2 - 1L)) >= 0 && n5 < arrayList4.size(); ++l2) {
                        l5 = (Long)arrayList4.get(n5);
                        for (l6 = 0L; l6 < lArray[1] && (n5 = arrayList2.size()) < arrayList.size(); ++l6) {
                            arrayList2.add(l5);
                            l5 = (Long)arrayList.get(n5) + l5;
                        }
                    }
                }
                ((Gc)object3).SN = new long[arrayList.size()];
                for (n8 = 0; n8 < arrayList.size(); ++n8) {
                    ((Gc)object3).SN[n8] = (Long)arrayList.get(n8);
                }
                ((Gc)object3).N = new long[arrayList2.size()];
                for (n8 = 0; n8 < arrayList2.size(); ++n8) {
                    ((Gc)object3).N[n8] = (Long)arrayList2.get(n8);
                }
                ((Gc)object3).yq = n8 = arrayList.size();
                if (n8 == 0) continue;
                Object object6 = object5 = var18_8.yq("senc");
                if (object5 == null) {
                    N n9 = jc_0.N((N)object4, "senc");
                }
                if ((object5 = (object4 = jc_0.N((N)object4, "sinf")) == null ? null : ((N)object4).yq("schm")) != null && !jc_0.i((tF)object, l = ((N)object5).SN() + 4L, l + 4L).equals("cenc") || (object5 = object4 == null ? null : ((N)object4).yq("tenc")) == null) {
                    object5 = null;
                } else {
                    object4 = new t0();
                    l2 = ((N)object5).SN();
                    n4 = ((tF)object).yq(l2);
                    n8 = ((tF)object).yq(l2 + 1L);
                    n3 = ((tF)object).yq(l2 + 2L);
                    n5 = ((tF)object).yq(l2 + 3L);
                    if (n4 == 0) {
                        ((t0)object4).SN = ((tF)object).yq(l2 + 4L);
                        l = 5L;
                    } else {
                        ((t0)object4).SN = ((tF)object).yq(9L + l2);
                        l = 10L;
                    }
                    l2 += l;
                    l = l2 + 16L;
                    jc_0.zH((tF)object, l2, l);
                    object5 = object4;
                    if ((((n8 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n5 & 0xFF) & 1) != 0) {
                        ((t0)object4).yq = jc_0.zH((tF)object, l, (long)((t0)object4).SN + l);
                        object5 = object4;
                    }
                }
                if (var18_11 != null) {
                    n5 = object5 != null ? ((t0)object5).SN : 0;
                    l = var18_11.SN();
                    n4 = ((tF)object).yq(l + 1L);
                    n3 = ((tF)object).yq(l + 2L);
                    n8 = ((tF)object).yq(3L + l);
                    int n10 = (int)jc_0.M((tF)object, 4L + l);
                    n4 = (((n4 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n8 & 0xFF) & 2) != 0 ? 1 : 0;
                    l5 = var18_11.SN + var18_11.tF;
                    l2 = l + 8L;
                    l = l5 - l2;
                    if (n4 != 0) {
                        l6 = l2;
                        for (n8 = 0; l6 + 18L <= l5 && n8 < n10; ++n8) {
                            long l7 = l6 + 16L;
                            n3 = ((tF)object).yq(l7);
                            l6 = (long)(((tF)object).yq(l7 + 1L) & 0xFF | (n3 & 0xFF) << 8) * 6L + 18L + l6;
                        }
                        if (l6 <= l5) {
                            l = l6 - l2;
                        }
                    }
                    if ((n8 = n10 > 0 ? (int)(l / (long)n10) : 16) != 8 && n8 != 16) {
                        n8 = n5 == 8 ? 8 : 16;
                    }
                    n3 = n5;
                    if (n5 != 8) {
                        n3 = n5 == 16 ? n5 : n8;
                    }
                    object4 = new ArrayList<String>();
                    n8 = n10;
                    for (n5 = 0; n5 < n8 && (l = (long)n3 + l2) <= var18_11.SN + var18_11.tF; ++n5) {
                        ((ArrayList)object4).add(jc_0.zH((tF)object, l2, l));
                        if (n4 != 0) {
                            if (l + 2L > var18_11.SN + var18_11.tF) break;
                            l = (long)((((tF)object).yq(l) & 0xFF) << 8 | ((tF)object).yq(l + 1L) & 0xFF) * 6L + 2L + l;
                        }
                        l2 = l;
                    }
                    String[] stringArray = ((ArrayList)object4).toArray(new String[0]);
                } else {
                    Object var18_13 = null;
                }
                ((Gc)object3).tF = var18_14;
                if (object5 != null) {
                    String string = ((t0)object5).yq;
                } else {
                    Object var18_16 = null;
                }
                ((Gc)object3).zH = var18_17;
                ((ArrayList)sN.yq).add((Gc)object3);
            }
            return sN;
        }
        object = new IllegalArgumentException("\u4e0d\u662f\u6709\u6548\u7684 MP4\uff1a\u7f3a\u5c11 moov \u76d2");
        throw object;
    }

    private static String zH(tF tF2, long l, long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        while (l < l2) {
            stringBuilder.append(String.format("%02x", tF2.yq(l) & 0xFF));
            ++l;
        }
        return stringBuilder.toString();
    }

    public static final class Gc {
        public long[] N;
        public long[] SN = new long[0];
        public String[] tF;
        public int yq;
        public String zH;

        public Gc() {
            this.N = new long[0];
        }
    }

    public static final class N {
        public final int N;
        public final long SN;
        public final long tF;
        public final String yq;
        public final List<N> zH = new ArrayList<N>();

        N(String string, long l, int n2, long l2) {
            this.yq = string;
            this.SN = l;
            this.N = n2;
            this.tF = l2;
        }

        public final long SN() {
            return this.SN + (long)this.N;
        }

        public final N yq(String string) {
            for (N n2 : this.zH) {
                if (!n2.yq.equals(string)) continue;
                return n2;
            }
            return null;
        }
    }

    public static final class SN {
        public final List<Gc> yq = new ArrayList<Gc>();
    }

    public static final class i {
        public final long SN;
        public final long yq;

        public i(long l, long l2) {
            this.yq = l;
            this.SN = l2;
        }
    }

    private static final class t0 {
        int SN;
        String yq;

        t0() {
        }
    }

    public static final class tF {
        public final long SN;
        public final byte[] yq;

        public tF(byte[] byArray, long l) {
            this.yq = byArray;
            this.SN = l;
        }

        final int yq(long l) {
            byte[] byArray;
            int n2 = (l -= this.SN) >= 0L && l < (long)(byArray = this.yq).length ? byArray[(int)l] & 0xFF : 0;
            return n2;
        }
    }

    final class yq {
        final List yq;

        yq(List list) {
            this.yq = list;
        }

        final void yq(String string) {
            if (string != null && !string.isEmpty()) {
                String string2 = string;
                if (string.length() >= 16) {
                    string2 = string.substring(0, 16);
                }
                if (string2.length() == 16 && !this.yq.contains(string2)) {
                    this.yq.add(string2);
                }
            }
        }
    }

    public static interface zH {
        public byte[] head(long var1, int var3);
    }
}

