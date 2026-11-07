/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.github.catvod.spider.merge;

import android.util.Base64;
import com.github.catvod.spider.merge.ZV;

public final class RK {
    private static boolean N(byte[] byArray, String string, int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            int n4 = i2 < byArray.length ? byArray[i2] & 0xFF : 0;
            if (n4 != (n3 = i2 < string.length() ? string.charAt(i2) & 0xFF : 0)) {
                return false;
            }
            if (n4 != 0) continue;
            return true;
        }
        return true;
    }

    public static yq SN(String object) {
        String string = object;
        if (object == null) {
            string = "";
        }
        try {
            int n2 = ZV.SN;
            object = Base64.decode((String)string.trim(), (int)0);
        }
        catch (Exception exception) {
            return new yq(null);
        }
        if (object != null && ((Object)object).length != 0) {
            string = RK.tF((byte[])object, 0);
            if (RK.yq(string)) {
                return new yq(string);
            }
            if (RK.yq((String)(object = RK.tF((byte[])object, 1)))) {
                return new yq((String)object);
            }
            return new yq(null);
        }
        return new yq(null);
    }

    public static String tF(byte[] object, int n2) {
        block12: {
            byte[] byArray;
            int n3;
            int n4;
            block14: {
                block13: {
                    if (object == null) {
                        return null;
                    }
                    n4 = ((byte[])object).length;
                    if (n4 < 3) {
                        return null;
                    }
                    int n5 = object[0];
                    int n7 = 1;
                    int n8 = (n5 ^ object[1] ^ object[2]) & 0xFF;
                    if ((n5 = n8 - 48) < 1) {
                        return null;
                    }
                    n3 = n4 - n8 + 47;
                    if (n3 < 1 || n3 + 1 > n4) break block12;
                    byArray = new byte[n3];
                    System.arraycopy(object, 1, byArray, 0, n3);
                    byte[] byArray2 = new byte[n5];
                    int n9 = n4 - n5;
                    int n10 = object[n9 - 2];
                    n8 = object[n9 - 1];
                    for (n4 = 0; n4 < n5; ++n4) {
                        byArray2[n4] = (byte)(n8 & 0xFF ^ n10 & 0xFF ^ object[n4 + n9] & 0xFF);
                    }
                    if (RK.N(byArray2, "app_v2", n5) || RK.N(byArray2, "web_v2", n5)) break block12;
                    n4 = 85;
                    n5 = 250;
                    n8 = 0;
                    while (n8 < n3) {
                        int n11;
                        n9 = byArray[n8] & 0xFF;
                        n10 = ZV.SN;
                        n10 = n8 - (n8 >>> 1 & 0x55555555);
                        n10 = (n10 & 0x33333333) + (n10 >>> 2 & 0x33333333);
                        int n12 = (0xF0F0F0F & n10 + (n10 >>> 4)) * 0x1010101 >>> 24;
                        if ((n8 & 1) != 0) {
                            n11 = n5;
                            n5 = n9;
                            n10 = n4;
                            n4 = n11;
                        } else {
                            int n13 = n9;
                            n10 = n4;
                            n11 = n5;
                            n4 = n13;
                            n5 = n10;
                            n10 = n11;
                        }
                        n11 = n2 != 0 ? n12 + 21 : -21 - n12;
                        byArray[n8] = (byte)(n11 + (n10 ^ n9) & 0xFF);
                        n9 = n8 + 1;
                        n8 = n4;
                        n4 = n5;
                        n5 = n8;
                        n8 = n9;
                    }
                    n2 = byArray[0] & 0xFF;
                    if (n2 < 48 || n2 > 57) break block13;
                    n2 -= 48;
                    break block14;
                }
                if (n2 < 97 || n2 > 122) break block12;
                n2 -= 87;
            }
            n4 = n3 - (n2 & 0xFF);
            if (n4 < 2) {
                return null;
            }
            object = new StringBuilder(n4 - 1);
            for (n2 = n7; n2 < n4; ++n2) {
                ((StringBuilder)object).append((char)(byArray[n2] & 0xFF));
            }
            return ((StringBuilder)object).toString();
        }
        return null;
    }

    public static boolean yq(String string) {
        block5: {
            if (string == null || string.length() != 32) break block5;
            int n2 = 0;
            while (true) {
                boolean bl;
                block7: {
                    char c;
                    boolean bl2;
                    block6: {
                        bl2 = true;
                        if (n2 >= 32) break;
                        c = string.charAt(n2);
                        if (c < '0') break block6;
                        bl = bl2;
                        if (c <= '9') break block7;
                    }
                    bl = c >= 'a' && c <= 'f' ? bl2 : false;
                }
                if (!bl) {
                    return false;
                }
                ++n2;
            }
            return true;
        }
        return false;
    }

    public static final class yq {
        public final String yq;

        yq(String string) {
            this.yq = string;
        }
    }
}

