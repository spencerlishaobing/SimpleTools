/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.github.catvod.spider;

import android.content.Intent;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.LP;
import com.github.catvod.spider.merge.QB;
import com.github.catvod.spider.merge.RT;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.WN;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.e2;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.le_0;
import com.github.catvod.spider.merge.lm;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.uA;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URI;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class \ufea9\ufec5\u0647\u0641 {
    public static int \u0636\ufe99\u0628\ufe8f = -394;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0628\u0635\u062f\ufeab(Object object) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() <= 0) return null;
        return ((URI)object).getPath();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \u062a\ufe8f\ufeed\ufee1(Object hashMap, Object object) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() > 0) return null;
        return ((i3)((Object)hashMap)).H((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \u062a\ufead\u0641\ufebd(Object list) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() <= 0) return null;
        return n6.yq((String)((Object)list));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062b\u0633\u0640\u0647(Object object) {
        if (\ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633() < 0) return null;
        return ((WN)object).i();
    }

    public static int \u062d\u062a\u0645\u0637() {
        return 0x1D4 ^ \ufeb9\ufec9\u0648\u062d.\ufeaf\ufe95\ufecd\ufee1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File \u0630\u0638\u0634\ufe95(Object object) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() >= 0) return null;
        return ((j_0)object).g1();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0630\ufeab\u062f\ufe95(String object) {
        int n2 = 0;
        String string = "";
        String string2 = "";
        int n3 = 0;
        while (true) {
            if (n3 >= 15) {
                while (string.length() > 0) {
                }
                break;
            }
            string = new StringBuffer().append(string).append(Integer.toHexString(n3)).toString();
            string2 = new StringBuffer().append(string2).append((int)(Math.random() * (double)10) ^ n3).toString();
            ++n3;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((String)object).length() / 2);
        n3 = 0;
        while (true) {
            if (n3 >= ((String)object).length()) break;
            byteArrayOutputStream.write(string.indexOf(((String)object).charAt(n3)) << 4 | string.indexOf(((String)object).charAt(n3 + 1)));
            n3 += 2;
        }
        object = byteArrayOutputStream.toByteArray();
        int n4 = ((Object)object).length;
        int n5 = string2.length();
        n3 = n2;
        while (n3 < n4) {
            object[n3] = (byte)(object[n3] ^ string2.charAt(n3 % n5));
            ++n3;
        }
        return new String((byte[])object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0632\ufe8f\ufeab\u0628(Object object) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() > 0) return null;
        return ((RT)object).SN;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0635\u0633\u0640\ufee1() {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() <= 0) return null;
        return "uc_ut";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0635\ufe99\u0647\ufeb5() {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() < 0) return null;
        return "Mozilla/5.0 (X11; Linux aarch64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36";
    }

    public static void \u0636\u0633\u0645\ufe9d(boolean bl) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() < 0) {
            uA.dT(bl);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0638\u062e\u0646\u0641(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() >= 0) return null;
        return ((dl_0)object).v();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Intent \u0642\u0632\ufee1\ufeed(Object object, Object object2) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() > 0) return null;
        return ((Intent)object).setPackage((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static le_0 \u0644\u0646\ufea5\u0642(Object object) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() > 0) return null;
        return ((LP)object).G4();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0646\u062c\ufea1\ufeab(Object object) {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() > 0) return null;
        return ((n6)object).dT();
    }

    public static int \u0647\u064a\ufec9\u062f(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0648\ufec9\u0642\ufeb9(Object object, Object object2) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return null;
        return ((DateFormat)object).format((Date)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u064a\ufecd\ufeed\ufeaf(Object object) {
        if (\ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c() < 0) return null;
        return ((lm)object).Gc();
    }

    public static String \ufe8f\ufee9\u062a\ufeb5(short[] sArray, int n2, int n3, int n4) {
        char[] cArray = new char[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            cArray[i2] = (char)(sArray[n2 + i2] ^ n4);
        }
        return new String(cArray);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \ufe95\u0627\ufea1\u0647(Object object, Object object2) {
        if (\ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab() < 0) return null;
        return ((Map)object).get(object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufe9d\ufee1\ufeab\ufe8e(Object object, Object object2) {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() < 0) return false;
        return ((Pan)((Object)object)).isUc((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea9\u0643\ufedd\ufeed(Object object, Object object2, Object object3) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() >= 0) return null;
        return ((i3)object).V((String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufeb1\u0646\u063a\ufed5() {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() < 0) return null;
        return "&&&";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufebd\ufeaf\ufee1\ufed5(Object object) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() < 0) return null;
        return Tq.v((Ef)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufec5\ufeed\u062f\u0637() {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() < 0) return null;
        return QB.G4;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static e2 \ufec9\u0630\u063a\ufea1(Object object) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() < 0) return null;
        return e2.SN((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Collection \ufecd\ufec5\ufec9\ufeb1(Object collection) {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() <= 0) return null;
        return ((HashMap)((Object)collection)).values();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufed5\u0631\u064a\u0639() {
        if (\ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed() < 0) return null;
        return "{\"0\":[{\"key\":\"s\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"all\"},{\"n\":\"\u52a8\u4f5c\",\"v\":\"dongzuo\"},{\"n\":\"\u7231\u60c5\",\"v\":\"aiqing\"},{\"n\":\"\u559c\u5267\",\"v\":\"xiju\"},{\"n\":\"\u79d1\u5e7b\",\"v\":\"kehuan\"},{\"n\":\"\u6050\u6016\",\"v\":\"kongbu\"},{\"n\":\"\u6218\u4e89\",\"v\":\"zhanzheng\"},{\"n\":\"\u6b66\u4fa0\",\"v\":\"wuxia\"},{\"n\":\"\u9b54\u5e7b\",\"v\":\"mohuan\"},{\"n\":\"\u5267\u60c5\",\"v\":\"juqing\"},{\"n\":\"\u52a8\u753b\",\"v\":\"donghua\"},{\"n\":\"\u60ca\u609a\",\"v\":\"jingsong\"},{\"n\":\"3D\",\"v\":\"3D\"},{\"n\":\"\u707e\u96be\",\"v\":\"zainan\"},{\"n\":\"\u60ac\u7591\",\"v\":\"xuanyi\"},{\"n\":\"\u8b66\u532a\",\"v\":\"jingfei\"},{\"n\":\"\u6587\u827a\",\"v\":\"wenyi\"},{\"n\":\"\u9752\u6625\",\"v\":\"qingchun\"},{\"n\":\"\u5192\u9669\",\"v\":\"maoxian\"},{\"n\":\"\u72af\u7f6a\",\"v\":\"fanzui\"},{\"n\":\"\u7eaa\u5f55\",\"v\":\"jilu\"},{\"n\":\"\u53e4\u88c5\",\"v\":\"guzhuang\"},{\"n\":\"\u5947\u5e7b\",\"v\":\"qihuan\"},{\"n\":\"\u56fd\u8bed\",\"v\":\"guoyu\"},{\"n\":\"\u7efc\u827a\",\"v\":\"zongyi\"},{\"n\":\"\u5386\u53f2\",\"v\":\"lishi\"},{\"n\":\"\u8fd0\u52a8\",\"v\":\"yundong\"},{\"n\":\"\u539f\u521b\u538b\u5236\",\"v\":\"yuanchuang\"},{\"n\":\"\u7f8e\u5267\",\"v\":\"meiju\"},{\"n\":\"\u97e9\u5267\",\"v\":\"hanju\"},{\"n\":\"\u56fd\u4ea7\u7535\u89c6\u5267\",\"v\":\"guoju\"},{\"n\":\"\u65e5\u5267\",\"v\":\"riju\"},{\"n\":\"\u82f1\u5267\",\"v\":\"yingju\"},{\"n\":\"\u5fb7\u5267\",\"v\":\"deju\"},{\"n\":\"\u4fc4\u5267\",\"v\":\"eju\"},{\"n\":\"\u5df4\u5267\",\"v\":\"baju\"},{\"n\":\"\u52a0\u5267\",\"v\":\"jiaju\"},{\"n\":\"\u897f\u5267\",\"v\":\"anish\"},{\"n\":\"\u610f\u5927\u5229\u5267\",\"v\":\"yidaliju\"},{\"n\":\"\u6cf0\u5267\",\"v\":\"taiju\"},{\"n\":\"\u6e2f\u53f0\u5267\",\"v\":\"gangtaiju\"},{\"n\":\"\u6cd5\u5267\",\"v\":\"faju\"},{\"n\":\"\u6fb3\u5267\",\"v\":\"aoju\"}]},{\"key\":\"area\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u4e0d\u9650\",\"v\":\"\"},{\"n\":\"\u4e2d\u56fd\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u4e2d\u56fd\u9999\u6e2f\",\"v\":\"\u4e2d\u56fd\u9999\u6e2f\"},{\"n\":\"\u4e2d\u56fd\u53f0\u6e7e\",\"v\":\"\u4e2d\u56fd\u53f0\u6e7e\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u5fb7\u56fd\",\"v\":\"\u5fb7\u56fd\"},{\"n\":\"\u897f\u73ed\u7259\",\"v\":\"\u897f\u73ed\u7259\"},{\"n\":\"\u610f\u5927\u5229\",\"v\":\"\u610f\u5927\u5229\"},{\"n\":\"\u6fb3\u5927\u5229\u4e9a\",\"v\":\"\u6fb3\u5927\u5229\u4e9a\"},{\"n\":\"\u6bd4\u5229\u65f6\",\"v\":\"\u6bd4\u5229\u65f6\"},{\"n\":\"\u745e\u5178\",\"v\":\"\u745e\u5178\"},{\"n\":\"\u8377\u5170\",\"v\":\"\u8377\u5170\"},{\"n\":\"\u4e39\u9ea6\",\"v\":\"\u4e39\u9ea6\"},{\"n\":\"\u52a0\u62ff\u5927\",\"v\":\"\u52a0\u62ff\u5927\"},{\"n\":\"\u4fc4\u7f57\u65af\",\"v\":\"\u4fc4\u7f57\u65af\"}]},{\"key\":\"year\",\"name\":\"\u5e74\u4efd\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2026\",\"v\":\"2026\"},{\"n\":\"2025\",\"v\":\"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"},{\"n\":\"2009\",\"v\":\"2009\"},{\"n\":\"2008\",\"v\":\"2008\"},{\"n\":\"2007\",\"v\":\"2007\"},{\"n\":\"2006\",\"v\":\"2006\"},{\"n\":\"2005\",\"v\":\"2005\"},{\"n\":\"2004\",\"v\":\"2004\"},{\"n\":\"2003\",\"v\":\"2003\"},{\"n\":\"2002\",\"v\":\"2002\"},{\"n\":\"2001\",\"v\":\"2001\"},{\"n\":\"2000\",\"v\":\"2000\"}]},{\"key\":\"order\",\"name\":\"\u6392\u5e8f\",\"value\":[{\"n\":\"\u66f4\u65b0\u65f6\u95f4\",\"v\":\"0\"},{\"n\":\"\u8c46\u74e3\u8bc4\u5206\",\"v\":\"1\"}]}],\"1\":[{\"key\":\"s\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"all\"},{\"n\":\"\u52a8\u4f5c\",\"v\":\"dongzuo\"},{\"n\":\"\u7231\u60c5\",\"v\":\"aiqing\"},{\"n\":\"\u559c\u5267\",\"v\":\"xiju\"},{\"n\":\"\u79d1\u5e7b\",\"v\":\"kehuan\"},{\"n\":\"\u6050\u6016\",\"v\":\"kongbu\"},{\"n\":\"\u6218\u4e89\",\"v\":\"zhanzheng\"},{\"n\":\"\u6b66\u4fa0\",\"v\":\"wuxia\"},{\"n\":\"\u9b54\u5e7b\",\"v\":\"mohuan\"},{\"n\":\"\u5267\u60c5\",\"v\":\"juqing\"},{\"n\":\"\u52a8\u753b\",\"v\":\"donghua\"},{\"n\":\"\u60ca\u609a\",\"v\":\"jingsong\"},{\"n\":\"3D\",\"v\":\"3D\"},{\"n\":\"\u707e\u96be\",\"v\":\"zainan\"},{\"n\":\"\u60ac\u7591\",\"v\":\"xuanyi\"},{\"n\":\"\u8b66\u532a\",\"v\":\"jingfei\"},{\"n\":\"\u6587\u827a\",\"v\":\"wenyi\"},{\"n\":\"\u9752\u6625\",\"v\":\"qingchun\"},{\"n\":\"\u5192\u9669\",\"v\":\"maoxian\"},{\"n\":\"\u72af\u7f6a\",\"v\":\"fanzui\"},{\"n\":\"\u7eaa\u5f55\",\"v\":\"jilu\"},{\"n\":\"\u53e4\u88c5\",\"v\":\"guzhuang\"},{\"n\":\"\u5947\u5e7b\",\"v\":\"qihuan\"},{\"n\":\"\u56fd\u8bed\",\"v\":\"guoyu\"},{\"n\":\"\u7efc\u827a\",\"v\":\"zongyi\"},{\"n\":\"\u5386\u53f2\",\"v\":\"lishi\"},{\"n\":\"\u8fd0\u52a8\",\"v\":\"yundong\"},{\"n\":\"\u539f\u521b\u538b\u5236\",\"v\":\"yuanchuang\"},{\"n\":\"\u7f8e\u5267\",\"v\":\"meiju\"},{\"n\":\"\u97e9\u5267\",\"v\":\"hanju\"},{\"n\":\"\u56fd\u4ea7\u7535\u89c6\u5267\",\"v\":\"guoju\"},{\"n\":\"\u65e5\u5267\",\"v\":\"riju\"},{\"n\":\"\u82f1\u5267\",\"v\":\"yingju\"},{\"n\":\"\u5fb7\u5267\",\"v\":\"deju\"},{\"n\":\"\u4fc4\u5267\",\"v\":\"eju\"},{\"n\":\"\u5df4\u5267\",\"v\":\"baju\"},{\"n\":\"\u52a0\u5267\",\"v\":\"jiaju\"},{\"n\":\"\u897f\u5267\",\"v\":\"anish\"},{\"n\":\"\u610f\u5927\u5229\u5267\",\"v\":\"yidaliju\"},{\"n\":\"\u6cf0\u5267\",\"v\":\"taiju\"},{\"n\":\"\u6e2f\u53f0\u5267\",\"v\":\"gangtaiju\"},{\"n\":\"\u6cd5\u5267\",\"v\":\"faju\"},{\"n\":\"\u6fb3\u5267\",\"v\":\"aoju\"}]},{\"key\":\"area\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u4e0d\u9650\",\"v\":\"\"},{\"n\":\"\u4e2d\u56fd\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u4e2d\u56fd\u9999\u6e2f\",\"v\":\"\u4e2d\u56fd\u9999\u6e2f\"},{\"n\":\"\u4e2d\u56fd\u53f0\u6e7e\",\"v\":\"\u4e2d\u56fd\u53f0\u6e7e\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u5fb7\u56fd\",\"v\":\"\u5fb7\u56fd\"},{\"n\":\"\u897f\u73ed\u7259\",\"v\":\"\u897f\u73ed\u7259\"},{\"n\":\"\u610f\u5927\u5229\",\"v\":\"\u610f\u5927\u5229\"},{\"n\":\"\u6fb3\u5927\u5229\u4e9a\",\"v\":\"\u6fb3\u5927\u5229\u4e9a\"},{\"n\":\"\u6bd4\u5229\u65f6\",\"v\":\"\u6bd4\u5229\u65f6\"},{\"n\":\"\u745e\u5178\",\"v\":\"\u745e\u5178\"},{\"n\":\"\u8377\u5170\",\"v\":\"\u8377\u5170\"},{\"n\":\"\u4e39\u9ea6\",\"v\":\"\u4e39\u9ea6\"},{\"n\":\"\u52a0\u62ff\u5927\",\"v\":\"\u52a0\u62ff\u5927\"},{\"n\":\"\u4fc4\u7f57\u65af\",\"v\":\"\u4fc4\u7f57\u65af\"}]},{\"key\":\"year\",\"name\":\"\u5e74\u4efd\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2026\",\"v\":\"2026\"},{\"n\":\"2025\",\"v\":\"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"},{\"n\":\"2009\",\"v\":\"2009\"},{\"n\":\"2008\",\"v\":\"2008\"},{\"n\":\"2007\",\"v\":\"2007\"},{\"n\":\"2006\",\"v\":\"2006\"},{\"n\":\"2005\",\"v\":\"2005\"},{\"n\":\"2004\",\"v\":\"2004\"},{\"n\":\"2003\",\"v\":\"2003\"},{\"n\":\"2002\",\"v\":\"2002\"},{\"n\":\"2001\",\"v\":\"2001\"},{\"n\":\"2000\",\"v\":\"2000\"}]},{\"key\":\"order\",\"name\":\"\u6392\u5e8f\",\"value\":[{\"n\":\"\u66f4\u65b0\u65f6\u95f4\",\"v\":\"0\"},{\"n\":\"\u8c46\u74e3\u8bc4\u5206\",\"v\":\"1\"}]}],\"a\":[{\"key\":\"s\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"all\"},{\"n\":\"\u52a8\u4f5c\",\"v\":\"dongzuo\"},{\"n\":\"\u7231\u60c5\",\"v\":\"aiqing\"},{\"n\":\"\u559c\u5267\",\"v\":\"xiju\"},{\"n\":\"\u79d1\u5e7b\",\"v\":\"kehuan\"},{\"n\":\"\u6050\u6016\",\"v\":\"kongbu\"},{\"n\":\"\u6218\u4e89\",\"v\":\"zhanzheng\"},{\"n\":\"\u6b66\u4fa0\",\"v\":\"wuxia\"},{\"n\":\"\u9b54\u5e7b\",\"v\":\"mohuan\"},{\"n\":\"\u5267\u60c5\",\"v\":\"juqing\"},{\"n\":\"\u52a8\u753b\",\"v\":\"donghua\"},{\"n\":\"\u60ca\u609a\",\"v\":\"jingsong\"},{\"n\":\"3D\",\"v\":\"3D\"},{\"n\":\"\u707e\u96be\",\"v\":\"zainan\"},{\"n\":\"\u60ac\u7591\",\"v\":\"xuanyi\"},{\"n\":\"\u8b66\u532a\",\"v\":\"jingfei\"},{\"n\":\"\u6587\u827a\",\"v\":\"wenyi\"},{\"n\":\"\u9752\u6625\",\"v\":\"qingchun\"},{\"n\":\"\u5192\u9669\",\"v\":\"maoxian\"},{\"n\":\"\u72af\u7f6a\",\"v\":\"fanzui\"},{\"n\":\"\u7eaa\u5f55\",\"v\":\"jilu\"},{\"n\":\"\u53e4\u88c5\",\"v\":\"guzhuang\"},{\"n\":\"\u5947\u5e7b\",\"v\":\"qihuan\"},{\"n\":\"\u56fd\u8bed\",\"v\":\"guoyu\"},{\"n\":\"\u7efc\u827a\",\"v\":\"zongyi\"},{\"n\":\"\u5386\u53f2\",\"v\":\"lishi\"},{\"n\":\"\u8fd0\u52a8\",\"v\":\"yundong\"},{\"n\":\"\u539f\u521b\u538b\u5236\",\"v\":\"yuanchuang\"},{\"n\":\"\u7f8e\u5267\",\"v\":\"meiju\"},{\"n\":\"\u97e9\u5267\",\"v\":\"hanju\"},{\"n\":\"\u56fd\u4ea7\u7535\u89c6\u5267\",\"v\":\"guoju\"},{\"n\":\"\u65e5\u5267\",\"v\":\"riju\"},{\"n\":\"\u82f1\u5267\",\"v\":\"yingju\"},{\"n\":\"\u5fb7\u5267\",\"v\":\"deju\"},{\"n\":\"\u4fc4\u5267\",\"v\":\"eju\"},{\"n\":\"\u5df4\u5267\",\"v\":\"baju\"},{\"n\":\"\u52a0\u5267\",\"v\":\"jiaju\"},{\"n\":\"\u897f\u5267\",\"v\":\"anish\"},{\"n\":\"\u610f\u5927\u5229\u5267\",\"v\":\"yidaliju\"},{\"n\":\"\u6cf0\u5267\",\"v\":\"taiju\"},{\"n\":\"\u6e2f\u53f0\u5267\",\"v\":\"gangtaiju\"},{\"n\":\"\u6cd5\u5267\",\"v\":\"faju\"},{\"n\":\"\u6fb3\u5267\",\"v\":\"aoju\"}]},{\"key\":\"area\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u4e0d\u9650\",\"v\":\"\"},{\"n\":\"\u4e2d\u56fd\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u4e2d\u56fd\u9999\u6e2f\",\"v\":\"\u4e2d\u56fd\u9999\u6e2f\"},{\"n\":\"\u4e2d\u56fd\u53f0\u6e7e\",\"v\":\"\u4e2d\u56fd\u53f0\u6e7e\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u5fb7\u56fd\",\"v\":\"\u5fb7\u56fd\"},{\"n\":\"\u897f\u73ed\u7259\",\"v\":\"\u897f\u73ed\u7259\"},{\"n\":\"\u610f\u5927\u5229\",\"v\":\"\u610f\u5927\u5229\"},{\"n\":\"\u6fb3\u5927\u5229\u4e9a\",\"v\":\"\u6fb3\u5927\u5229\u4e9a\"},{\"n\":\"\u6bd4\u5229\u65f6\",\"v\":\"\u6bd4\u5229\u65f6\"},{\"n\":\"\u745e\u5178\",\"v\":\"\u745e\u5178\"},{\"n\":\"\u8377\u5170\",\"v\":\"\u8377\u5170\"},{\"n\":\"\u4e39\u9ea6\",\"v\":\"\u4e39\u9ea6\"},{\"n\":\"\u52a0\u62ff\u5927\",\"v\":\"\u52a0\u62ff\u5927\"},{\"n\":\"\u4fc4\u7f57\u65af\",\"v\":\"\u4fc4\u7f57\u65af\"}]},{\"key\":\"year\",\"name\":\"\u5e74\u4efd\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2026\",\"v\":\"2026\"},{\"n\":\"2025\",\"v\":\"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"},{\"n\":\"2009\",\"v\":\"2009\"},{\"n\":\"2008\",\"v\":\"2008\"},{\"n\":\"2007\",\"v\":\"2007\"},{\"n\":\"2006\",\"v\":\"2006\"},{\"n\":\"2005\",\"v\":\"2005\"},{\"n\":\"2004\",\"v\":\"2004\"},{\"n\":\"2003\",\"v\":\"2003\"},{\"n\":\"2002\",\"v\":\"2002\"},{\"n\":\"2001\",\"v\":\"2001\"},{\"n\":\"2000\",\"v\":\"2000\"}]},{\"key\":\"order\",\"name\":\"\u6392\u5e8f\",\"value\":[{\"n\":\"\u66f4\u65b0\u65f6\u95f4\",\"v\":\"0\"},{\"n\":\"\u8c46\u74e3\u8bc4\u5206\",\"v\":\"1\"}]}]}";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufed5\u0636\u064a\ufeab(long l) {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() <= 0) return null;
        return Long.toString(l);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufee1\ufe9d\u0643\u062c(Object object, Object object2, Object object3) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return null;
        return ((j_0)object).g9((String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static StringBuilder \ufeed\ufe8e\ufec5\ufea9(Object object) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() <= 0) return null;
        return oi_0.yq((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufef1\ufedd\u062c\ufea5(Object object, Object object2) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() <= 0) return false;
        return ((String)object).contains((CharSequence)object2);
    }
}

