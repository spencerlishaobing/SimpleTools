/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.util.Base64
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.os.Build;
import android.util.Base64;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Jpys;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.H7;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.RT;
import com.github.catvod.spider.merge.Yx;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.i8_0;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.ts_0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

public class \ufec1\u0636\u062d\u0638 {
    public static int \ufe8f\ufea1\ufea9\u062a = 591;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0628\u0637\u063a\u062c() {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() < 0) return null;
        return "https://drive.uc.cn/s/";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Iterator \u062a\ufee1\ufe8e\ufecd(Object iterator) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() < 0) return null;
        return ((List)((Object)iterator)).iterator();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062f\u0627\u062b\u0628(Object object, Object object2, Object object3) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() >= 0) return null;
        return k_0.i((StringBuilder)object, (String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0630\u0643\ufe9d\u0632(Object object, Object object2) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return false;
        return object.equals(object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \u0630\ufee9\u0647\u062e(Object object, int n) {
        if (\ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631() > 0) return null;
        return ((ArrayList)object).remove(n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long \u0633\u062d\u062b\u0637(Object object) {
        if (\u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5() >= 0) return 0L;
        return Long.parseLong((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0633\u0643\u0630\ufebd() {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() <= 0) return null;
        return Jpys.getUUID();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0633\ufedd\u0644\ufee9() {
        if (\u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628() > 0) return null;
        return Build.MODEL;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0634\ufeb9\u0639\u0643(Object object, Object object2) {
        if (\ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632() <= 0) return false;
        return ((String)object).endsWith((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] \u0636\ufe99\u0628\ufe8f(Object object, int n) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() >= 0) return null;
        return Base64.decode((String)((String)object), (int)n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0636\ufeab\u0644\ufed9() {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return "{\"hot_gaia\": [{\"key\": \"sort\", \"name\": \"\u6392\u5e8f\", \"value\": [{\"n\": \"\u70ed\u5ea6\", \"v\": \"recommend\"}, {\"n\": \"\u6700\u65b0\", \"v\": \"time\"}, {\"n\": \"\u8bc4\u5206\", \"v\": \"rank\"}]}, {\"key\": \"area\", \"name\": \"\u5730\u533a\", \"value\": [{\"n\": \"\u5168\u90e8\", \"v\": \"\u5168\u90e8\"}, {\"n\": \"\u534e\u8bed\", \"v\": \"\u534e\u8bed\"}, {\"n\": \"\u6b27\u7f8e\", \"v\": \"\u6b27\u7f8e\"}, {\"n\": \"\u97e9\u56fd\", \"v\": \"\u97e9\u56fd\"}, {\"n\": \"\u65e5\u672c\", \"v\": \"\u65e5\u672c\"}]}], \"tv_hot\": [{\"key\": \"type\", \"name\": \"\u5206\u7c7b\", \"value\": [{\"n\": \"\u7efc\u5408\", \"v\": \"tv_hot\"}, {\"n\": \"\u56fd\u4ea7\u5267\", \"v\": \"tv_domestic\"}, {\"n\": \"\u6b27\u7f8e\u5267\", \"v\": \"tv_american\"}, {\"n\": \"\u65e5\u5267\", \"v\": \"tv_japanese\"}, {\"n\": \"\u97e9\u5267\", \"v\": \"tv_korean\"}, {\"n\": \"\u52a8\u753b\", \"v\": \"tv_animation\"}]}], \"show_hot\": [{\"key\": \"type\", \"name\": \"\u5206\u7c7b\", \"value\": [{\"n\": \"\u7efc\u5408\", \"v\": \"show_hot\"}, {\"n\": \"\u56fd\u5185\", \"v\": \"show_domestic\"}, {\"n\": \"\u56fd\u5916\", \"v\": \"show_foreign\"}]}], \"movie\": [{\"key\": \"\u7c7b\u578b\", \"name\": \"\u7c7b\u578b\", \"value\": [{\"n\": \"\u5168\u90e8\u7c7b\u578b\", \"v\": \"\"}, {\"n\": \"\u559c\u5267\", \"v\": \"\u559c\u5267\"}, {\"n\": \"\u7231\u60c5\", \"v\": \"\u7231\u60c5\"}, {\"n\": \"\u52a8\u4f5c\", \"v\": \"\u52a8\u4f5c\"}, {\"n\": \"\u79d1\u5e7b\", \"v\": \"\u79d1\u5e7b\"}, {\"n\": \"\u52a8\u753b\", \"v\": \"\u52a8\u753b\"}, {\"n\": \"\u60ac\u7591\", \"v\": \"\u60ac\u7591\"}, {\"n\": \"\u72af\u7f6a\", \"v\": \"\u72af\u7f6a\"}, {\"n\": \"\u60ca\u609a\", \"v\": \"\u60ca\u609a\"}, {\"n\": \"\u5192\u9669\", \"v\": \"\u5192\u9669\"}, {\"n\": \"\u97f3\u4e50\", \"v\": \"\u97f3\u4e50\"}, {\"n\": \"\u5386\u53f2\", \"v\": \"\u5386\u53f2\"}, {\"n\": \"\u5947\u5e7b\", \"v\": \"\u5947\u5e7b\"}, {\"n\": \"\u6050\u6016\", \"v\": \"\u6050\u6016\"}, {\"n\": \"\u6218\u4e89\", \"v\": \"\u6218\u4e89\"}, {\"n\": \"\u4f20\u8bb0\", \"v\": \"\u4f20\u8bb0\"}, {\"n\": \"\u6b4c\u821e\", \"v\": \"\u6b4c\u821e\"}, {\"n\": \"\u6b66\u4fa0\", \"v\": \"\u6b66\u4fa0\"}, {\"n\": \"\u707e\u96be\", \"v\": \"\u707e\u96be\"}, {\"n\": \"\u897f\u90e8\", \"v\": \"\u897f\u90e8\"}, {\"n\": \"\u7eaa\u5f55\u7247\", \"v\": \"\u7eaa\u5f55\u7247\"}, {\"n\": \"\u77ed\u7247\", \"v\": \"\u77ed\u7247\"}]}, {\"key\": \"\u5730\u533a\", \"name\": \"\u5730\u533a\", \"value\": [{\"n\": \"\u5168\u90e8\u5730\u533a\", \"v\": \"\"}, {\"n\": \"\u534e\u8bed\", \"v\": \"\u534e\u8bed\"}, {\"n\": \"\u6b27\u7f8e\", \"v\": \"\u6b27\u7f8e\"}, {\"n\": \"\u97e9\u56fd\", \"v\": \"\u97e9\u56fd\"}, {\"n\": \"\u65e5\u672c\", \"v\": \"\u65e5\u672c\"}, {\"n\": \"\u4e2d\u56fd\u5927\u9646\", \"v\": \"\u4e2d\u56fd\u5927\u9646\"}, {\"n\": \"\u7f8e\u56fd\", \"v\": \"\u7f8e\u56fd\"}, {\"n\": \"\u4e2d\u56fd\u9999\u6e2f\", \"v\": \"\u4e2d\u56fd\u9999\u6e2f\"}, {\"n\": \"\u4e2d\u56fd\u53f0\u6e7e\", \"v\": \"\u4e2d\u56fd\u53f0\u6e7e\"}, {\"n\": \"\u82f1\u56fd\", \"v\": \"\u82f1\u56fd\"}, {\"n\": \"\u6cd5\u56fd\", \"v\": \"\u6cd5\u56fd\"}, {\"n\": \"\u5fb7\u56fd\", \"v\": \"\u5fb7\u56fd\"}, {\"n\": \"\u610f\u5927\u5229\", \"v\": \"\u610f\u5927\u5229\"}, {\"n\": \"\u897f\u73ed\u7259\", \"v\": \"\u897f\u73ed\u7259\"}, {\"n\": \"\u5370\u5ea6\", \"v\": \"\u5370\u5ea6\"}, {\"n\": \"\u6cf0\u56fd\", \"v\": \"\u6cf0\u56fd\"}, {\"n\": \"\u4fc4\u7f57\u65af\", \"v\": \"\u4fc4\u7f57\u65af\"}, {\"n\": \"\u52a0\u62ff\u5927\", \"v\": \"\u52a0\u62ff\u5927\"}, {\"n\": \"\u6fb3\u5927\u5229\u4e9a\", \"v\": \"\u6fb3\u5927\u5229\u4e9a\"}, {\"n\": \"\u7231\u5c14\u5170\", \"v\": \"\u7231\u5c14\u5170\"}, {\"n\": \"\u745e\u5178\", \"v\": \"\u745e\u5178\"}, {\"n\": \"\u5df4\u897f\", \"v\": \"\u5df4\u897f\"}, {\"n\": \"\u4e39\u9ea6\", \"v\": \"\u4e39\u9ea6\"}]}, {\"key\": \"sort\", \"name\": \"\u6392\u5e8f\", \"value\": [{\"n\": \"\u8fd1\u671f\u70ed\u5ea6\", \"v\": \"T\"}, {\"n\": \"\u9996\u6620\u65f6\u95f4\", \"v\": \"R\"}, {\"n\": \"\u9ad8\u5206\u4f18\u5148\", \"v\": \"S\"}]}, {\"key\": \"\u5e74\u4ee3\", \"name\": \"\u5e74\u4ee3\", \"value\": [{\"n\": \"\u5168\u90e8\u5e74\u4ee3\", \"v\": \"\"}, {\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\": \"2024\", \"v\": \"2024\"},{\"n\": \"2023\", \"v\": \"2023\"}, {\"n\": \"2022\", \"v\": \"2022\"}, {\"n\": \"2021\", \"v\": \"2021\"}, {\"n\": \"2020\", \"v\": \"2020\"}, {\"n\": \"2019\", \"v\": \"2019\"}, {\"n\": \"2010\u5e74\u4ee3\", \"v\": \"2010\u5e74\u4ee3\"}, {\"n\": \"2000\u5e74\u4ee3\", \"v\": \"2000\u5e74\u4ee3\"}, {\"n\": \"90\u5e74\u4ee3\", \"v\": \"90\u5e74\u4ee3\"}, {\"n\": \"80\u5e74\u4ee3\", \"v\": \"80\u5e74\u4ee3\"}, {\"n\": \"70\u5e74\u4ee3\", \"v\": \"70\u5e74\u4ee3\"}, {\"n\": \"60\u5e74\u4ee3\", \"v\": \"60\u5e74\u4ee3\"}, {\"n\": \"\u66f4\u65e9\", \"v\": \"\u66f4\u65e9\"}]}], \"tv\": [{\"key\": \"\u7c7b\u578b\", \"name\": \"\u7c7b\u578b\", \"value\": [{\"n\": \"\u4e0d\u9650\", \"v\": \"\"}, {\"n\": \"\u7535\u89c6\u5267\", \"v\": \"\u7535\u89c6\u5267\"}, {\"n\": \"\u7efc\u827a\", \"v\": \"\u7efc\u827a\"}]}, {\"key\": \"\u7535\u89c6\u5267\u5f62\u5f0f\", \"name\": \"\u7535\u89c6\u5267\u5f62\u5f0f\", \"value\": [{\"n\": \"\u4e0d\u9650\", \"v\": \"\"}, {\"n\": \"\u559c\u5267\", \"v\": \"\u559c\u5267\"}, {\"n\": \"\u7231\u60c5\", \"v\": \"\u7231\u60c5\"}, {\"n\": \"\u60ac\u7591\", \"v\": \"\u60ac\u7591\"}, {\"n\": \"\u52a8\u753b\", \"v\": \"\u52a8\u753b\"}, {\"n\": \"\u6b66\u4fa0\", \"v\": \"\u6b66\u4fa0\"}, {\"n\": \"\u53e4\u88c5\", \"v\": \"\u53e4\u88c5\"}, {\"n\": \"\u5bb6\u5ead\", \"v\": \"\u5bb6\u5ead\"}, {\"n\": \"\u72af\u7f6a\", \"v\": \"\u72af\u7f6a\"}, {\"n\": \"\u79d1\u5e7b\", \"v\": \"\u79d1\u5e7b\"}, {\"n\": \"\u6050\u6016\", \"v\": \"\u6050\u6016\"}, {\"n\": \"\u5386\u53f2\", \"v\": \"\u5386\u53f2\"}, {\"n\": \"\u6218\u4e89\", \"v\": \"\u6218\u4e89\"}, {\"n\": \"\u52a8\u4f5c\", \"v\": \"\u52a8\u4f5c\"}, {\"n\": \"\u5192\u9669\", \"v\": \"\u5192\u9669\"}, {\"n\": \"\u4f20\u8bb0\", \"v\": \"\u4f20\u8bb0\"}, {\"n\": \"\u5267\u60c5\", \"v\": \"\u5267\u60c5\"}, {\"n\": \"\u5947\u5e7b\", \"v\": \"\u5947\u5e7b\"}, {\"n\": \"\u60ca\u609a\", \"v\": \"\u60ca\u609a\"}, {\"n\": \"\u707e\u96be\", \"v\": \"\u707e\u96be\"}, {\"n\": \"\u6b4c\u821e\", \"v\": \"\u6b4c\u821e\"}, {\"n\": \"\u97f3\u4e50\", \"v\": \"\u97f3\u4e50\"}]}, {\"key\": \"\u7efc\u827a\u5f62\u5f0f\", \"name\": \"\u7efc\u827a\u5f62\u5f0f\", \"value\": [{\"n\": \"\u4e0d\u9650\", \"v\": \"\"}, {\"n\": \"\u771f\u4eba\u79c0\", \"v\": \"\u771f\u4eba\u79c0\"}, {\"n\": \"\u8131\u53e3\u79c0\", \"v\": \"\u8131\u53e3\u79c0\"}, {\"n\": \"\u97f3\u4e50\", \"v\": \"\u97f3\u4e50\"}, {\"n\": \"\u6b4c\u821e\", \"v\": \"\u6b4c\u821e\"}]}, {\"key\": \"\u5730\u533a\", \"name\": \"\u5730\u533a\", \"value\": [{\"n\": \"\u5168\u90e8\u5730\u533a\", \"v\": \"\"}, {\"n\": \"\u534e\u8bed\", \"v\": \"\u534e\u8bed\"}, {\"n\": \"\u6b27\u7f8e\", \"v\": \"\u6b27\u7f8e\"}, {\"n\": \"\u56fd\u5916\", \"v\": \"\u56fd\u5916\"}, {\"n\": \"\u97e9\u56fd\", \"v\": \"\u97e9\u56fd\"}, {\"n\": \"\u65e5\u672c\", \"v\": \"\u65e5\u672c\"}, {\"n\": \"\u4e2d\u56fd\u5927\u9646\", \"v\": \"\u4e2d\u56fd\u5927\u9646\"}, {\"n\": \"\u4e2d\u56fd\u9999\u6e2f\", \"v\": \"\u4e2d\u56fd\u9999\u6e2f\"}, {\"n\": \"\u7f8e\u56fd\", \"v\": \"\u7f8e\u56fd\"}, {\"n\": \"\u82f1\u56fd\", \"v\": \"\u82f1\u56fd\"}, {\"n\": \"\u6cf0\u56fd\", \"v\": \"\u6cf0\u56fd\"}, {\"n\": \"\u4e2d\u56fd\u53f0\u6e7e\", \"v\": \"\u4e2d\u56fd\u53f0\u6e7e\"}, {\"n\": \"\u610f\u5927\u5229\", \"v\": \"\u610f\u5927\u5229\"}, {\"n\": \"\u6cd5\u56fd\", \"v\": \"\u6cd5\u56fd\"}, {\"n\": \"\u5fb7\u56fd\", \"v\": \"\u5fb7\u56fd\"}, {\"n\": \"\u897f\u73ed\u7259\", \"v\": \"\u897f\u73ed\u7259\"}, {\"n\": \"\u4fc4\u7f57\u65af\", \"v\": \"\u4fc4\u7f57\u65af\"}, {\"n\": \"\u745e\u5178\", \"v\": \"\u745e\u5178\"}, {\"n\": \"\u5df4\u897f\", \"v\": \"\u5df4\u897f\"}, {\"n\": \"\u4e39\u9ea6\", \"v\": \"\u4e39\u9ea6\"}, {\"n\": \"\u5370\u5ea6\", \"v\": \"\u5370\u5ea6\"}, {\"n\": \"\u52a0\u62ff\u5927\", \"v\": \"\u52a0\u62ff\u5927\"}, {\"n\": \"\u7231\u5c14\u5170\", \"v\": \"\u7231\u5c14\u5170\"}, {\"n\": \"\u6fb3\u5927\u5229\u4e9a\", \"v\": \"\u6fb3\u5927\u5229\u4e9a\"}]}, {\"key\": \"sort\", \"name\": \"\u6392\u5e8f\", \"value\": [{\"n\": \"\u8fd1\u671f\u70ed\u5ea6\", \"v\": \"T\"}, {\"n\": \"\u9996\u64ad\u65f6\u95f4\", \"v\": \"R\"}, {\"n\": \"\u9ad8\u5206\u4f18\u5148\", \"v\": \"S\"}]}, {\"key\": \"\u5e74\u4ee3\", \"name\": \"\u5e74\u4ee3\", \"value\": [{\"n\": \"\u5168\u90e8\", \"v\": \"\"}, {\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\": \"2024\", \"v\": \"2024\"},{\"n\": \"2023\", \"v\": \"2023\"}, {\"n\": \"2022\", \"v\": \"2022\"}, {\"n\": \"2021\", \"v\": \"2021\"}, {\"n\": \"2020\", \"v\": \"2020\"}, {\"n\": \"2019\", \"v\": \"2019\"}, {\"n\": \"2010\u5e74\u4ee3\", \"v\": \"2010\u5e74\u4ee3\"}, {\"n\": \"2000\u5e74\u4ee3\", \"v\": \"2000\u5e74\u4ee3\"}, {\"n\": \"90\u5e74\u4ee3\", \"v\": \"90\u5e74\u4ee3\"}, {\"n\": \"80\u5e74\u4ee3\", \"v\": \"80\u5e74\u4ee3\"}, {\"n\": \"70\u5e74\u4ee3\", \"v\": \"70\u5e74\u4ee3\"}, {\"n\": \"60\u5e74\u4ee3\", \"v\": \"60\u5e74\u4ee3\"}, {\"n\": \"\u66f4\u65e9\", \"v\": \"\u66f4\u65e9\"}]}, {\"key\": \"\u5e73\u53f0\", \"name\": \"\u5e73\u53f0\", \"value\": [{\"n\": \"\u5168\u90e8\", \"v\": \"\"}, {\"n\": \"\u817e\u8baf\u89c6\u9891\", \"v\": \"\u817e\u8baf\u89c6\u9891\"}, {\"n\": \"\u7231\u5947\u827a\", \"v\": \"\u7231\u5947\u827a\"}, {\"n\": \"\u4f18\u9177\", \"v\": \"\u4f18\u9177\"}, {\"n\": \"\u6e56\u5357\u536b\u89c6\", \"v\": \"\u6e56\u5357\u536b\u89c6\"}, {\"n\": \"Netflix\", \"v\": \"Netflix\"}, {\"n\": \"HBO\", \"v\": \"HBO\"}, {\"n\": \"BBC\", \"v\": \"BBC\"}, {\"n\": \"NHK\", \"v\": \"NHK\"}, {\"n\": \"CBS\", \"v\": \"CBS\"}, {\"n\": \"NBC\", \"v\": \"NBC\"}, {\"n\": \"tvN\", \"v\": \"tvN\"}]}], \"rank_list_movie\": [{\"key\": \"\u699c\u5355\", \"name\": \"\u699c\u5355\", \"value\": [{\"n\": \"\u5b9e\u65f6\u70ed\u95e8\u7535\u5f71\", \"v\": \"movie_real_time_hotest\"}, {\"n\": \"\u4e00\u5468\u53e3\u7891\u7535\u5f71\u699c\", \"v\": \"movie_weekly_best\"}, {\"n\": \"\u8c46\u74e3\u7535\u5f71Top250\", \"v\": \"movie_top250\"}]}], \"rank_list_tv\": [{\"key\": \"\u699c\u5355\", \"name\": \"\u699c\u5355\", \"value\": [{\"n\": \"\u5b9e\u65f6\u70ed\u95e8\u7535\u89c6\", \"v\": \"tv_real_time_hotest\"}, {\"n\": \"\u534e\u8bed\u53e3\u7891\u5267\u96c6\u699c\", \"v\": \"tv_chinese_best_weekly\"}, {\"n\": \"\u5168\u7403\u53e3\u7891\u5267\u96c6\u699c\", \"v\": \"tv_global_best_weekly\"}, {\"n\": \"\u56fd\u5185\u53e3\u7891\u7efc\u827a\u699c\", \"v\": \"show_chinese_best_weekly\"}, {\"n\": \"\u56fd\u5916\u53e3\u7891\u7efc\u827a\u699c\", \"v\": \"show_global_best_weekly\"}]}]}";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static H7 \u0639\u062a\u0633\ufef1(Object object) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() > 0) return null;
        return H7.g1((String)object);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u063a\u0627\ufee9\u0637(String object) {
        int n = 0;
        String string = "";
        String string2 = "";
        int n2 = 0;
        while (true) {
            if (n2 >= 15) break;
            string = new StringBuffer().append(string).append(Integer.toHexString(n2)).toString();
            string2 = new StringBuffer().append(string2).append((int)(Math.random() * (double)10) ^ n2).toString();
            ++n2;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((String)object).length() / 2);
        n2 = 0;
        while (true) {
            if (n2 >= ((String)object).length()) break;
            byteArrayOutputStream.write(string.indexOf(((String)object).charAt(n2)) << 4 | string.indexOf(((String)object).charAt(n2 + 1)));
            n2 += 2;
        }
        object = byteArrayOutputStream.toByteArray();
        int n3 = ((Object)object).length;
        n2 = string2.length();
        while (true) {
            if (n3 <= 0) break;
            object[-1] = (byte)(object[-1] ^ string2.charAt(-1 % n2));
        }
        n2 = n;
        while (n2 < ((Object)object).length) {
            n2 = "".length() + 1;
        }
        return new String((byte[])object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \u063a\u0644\u0637\ufea5(Object object, Object object2) {
        if (\ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95() > 0) return null;
        return ((xu_0)object).E1((String)object2);
    }

    public static String \u0642\u0639\u0630\ufe9d(short[] sArray, int n, int n2, int n3) {
        char[] cArray = new char[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            cArray[i2] = (char)(sArray[n + i2] ^ n3);
        }
        return new String(cArray);
    }

    public static int \u0643\u0638\u062a\ufec5() {
        return 0x27D ^ \u062a\u0635\ufeb1\u0642.\ufebd\ufea1\u0631\ufea5;
    }

    public static void \ufe8f\u0633\ufebd\ufecd(Object object, Object object2) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() < 0) {
            ((Ef)object).ee((String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static double \ufe8f\ufe9d\u062e\u063a(Object object) {
        if (\ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd() < 0) return 0.0;
        return ((Random)object).nextDouble();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Ef \ufea1\u062b\u0646\u0632(Object object, Object object2, Object object3, Object object4) {
        if (\u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d() <= 0) return null;
        return ((n6)object).xa((String)object2, (String)object3, (String)object4);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufea1\ufec9\u0639\u0641(Object object) {
        if (\ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9() <= 0) return 0;
        return ((i8_0)object).yq;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufea5\ufee9\ufec1\u0641(Object object) {
        if (\u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a() <= 0) return null;
        return ((ts_0)object).B();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Yx \ufeab\u0635\u062e\u0638(Object object) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() < 0) return null;
        return Yx.i((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufeab\ufea5\ufecd\ufe95(Object object) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return false;
        return ((RT)object).i;
    }

    public static int \ufec9\ufee9\u0635\u062a(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \ufed5\ufea1\u0648\ufeab(Object object) {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() > 0) return false;
        return ((N0)object).H();
    }

    public static void \ufee9\ufe9d\u0642\ufebd(Object object, Object object2) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() >= 0) {
            ((dl_0)object).Dr((String)object2);
        }
    }
}

