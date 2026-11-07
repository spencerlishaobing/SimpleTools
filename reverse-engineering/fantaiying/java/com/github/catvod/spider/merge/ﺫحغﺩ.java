/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences$Editor
 *  android.text.Editable
 *  android.widget.EditText
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.content.SharedPreferences;
import android.text.Editable;
import android.widget.EditText;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.spider.AppSx;
import com.github.catvod.spider.Kanqiu;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.DC;
import com.github.catvod.spider.merge.Jr;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.dl_0;
import com.github.catvod.spider.merge.f_0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.n6;
import com.github.catvod.spider.merge.tX;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.MessageDigest;
import java.util.AbstractCollection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class \ufeab\u062d\u063a\ufea9 {
    public static int \ufee1\u0640\ufedd\u0639 = 629;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0628\u0635\ufead\u064a() {
        if (\ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a() <= 0) return null;
        return ProxyOrigin.getInternalIP();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u062b\ufeab\ufeed\ufe99(Object object) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() <= 0) return false;
        return ((SharedPreferences.Editor)object).commit();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062c\u0636\ufeb1\ufeaf() {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() <= 0) return null;
        return "client_key=NqOMXF6XGhGRIGemsQ9nG0Na; secret_key=SVT6xpMdLcx6v4aCR4wT8BBOTbzFO8LM; driver_txt=baiduyun_ob; server_use=false";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ScheduledFuture \u062c\ufe95\ufeb5\u0643(Object scheduledFuture, Object object, long l, long l2, Object object2) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() > 0) return null;
        return ((ScheduledExecutorService)((Object)scheduledFuture)).scheduleWithFixedDelay((Runnable)object, l, l2, (TimeUnit)((Object)object2));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u062d\ufea1\ufeab\u0646(Object object, Object object2, Object object3, boolean bl, Object object4, Object object5) {
        if (\ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1() <= 0) return null;
        return ((xu_0)object).v3((dl_0)object2, (String)object3, bl, (String)object4, (File)object5);
    }

    public static String \u062f\u0642\ufebd\u064a(short[] sArray, int n2, int n3, int n4) {
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
    public static boolean \u0630\u0628\u063a\u062b(Object object) {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() <= 0) return false;
        return ((n6)object).O();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0631\u0637\ufe8f\ufec5(Object object, Object object2) {
        if (\u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a() <= 0) return null;
        return ((AppSx)((Object)object)).getOcrCode((String)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object \u0634\u0645\ufe8e\u062e(Object object, Object object2, Object object3) {
        if (\u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd() >= 0) return null;
        return ((TreeMap)object).put(object2, object3);
    }

    public static void \u0635\u0631\u064a\u0646(Object object) {
        if (\ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5() > 0) {
            ((tX)object).Dr();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0638\ufee9\ufed9\ufe99(Object object) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() > 0) return false;
        return ME.xa((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \u063a\ufeb1\u0637\ufeab(Object object) {
        if (\ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5() <= 0) return 0;
        return ((f_0)object).i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ScheduledFuture \u0641\u062b\ufe95\u0644(Object scheduledFuture, Object object, long l, long l2, Object object2) {
        if (\ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646() <= 0) return null;
        return ((ScheduledExecutorService)((Object)scheduledFuture)).scheduleAtFixedRate((Runnable)object, l, l2, (TimeUnit)((Object)object2));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0642\u0627\u0648\ufeb1() {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() >= 0) return null;
        return "{ //\u7535\u5f71\n    \"1\": [{\n            \"key\": \"type\",\n            \"name\": \"\u7c7b\u578b\",\n            \"value\": [{\n                    \"n\": \"\u7c7b\u578b\",\n                    \"v\": \"\"\n                }, {\n                    \"n\": \"\u5267\u60c5\",\n                    \"v\": \"7\"\n                }, {\n                    \"n\": \"\u559c\u5267\",\n                    \"v\": \"8\"\n                }, {\n                    \"n\": \"\u707e\u96be\",\n                    \"v\": \"17\"\n                },{\n                    \"n\": \"\u60ca\u609a\",\n                    \"v\": \"4\"\n                }, {\n                    \"n\": \"\u52a8\u4f5c\",\n                    \"v\": \"1\"\n                }, {\n                    \"n\": \"\u7231\u60c5\",\n                    \"v\": \"10\"\n                }, {\n                    \"n\": \"\u72af\u7f6a\",\n                    \"v\": \"12\"\n                }, {\n                    \"n\": \"\u6050\u6016\",\n                    \"v\": \"3\"\n                }, {\n                    \"n\": \"\u60ac\u7591\",\n                    \"v\": \"13\"\n                }, {\n                    \"n\": \"\u5192\u9669\",\n                    \"v\": \"6\"\n                },{\n                    \"n\": \"\u79d1\u5e7b\",\n                    \"v\": \"2\"\n                },{\n                    \"n\": \"\u5947\u5e7b\",\n                    \"v\": \"5\"\n                },{\n                    \"n\": \"\u7eaa\u5f55\u7247\",\n                    \"v\": \"43\"\n                },{\n                    \"n\": \"\u4f20\u8bb0\",\n                    \"v\": \"14\"\n                },{\n                    \"n\": \"\u5bb6\u5ead\",\n                    \"v\": \"9\"\n                },{\n                    \"n\": \"\u6218\u4e89\",\n                    \"v\": \"16\"\n                },{\n                    \"n\": \"\u5386\u53f2\",\n                    \"v\": \"15\"\n                },{\n                    \"n\": \"\u97f3\u4e50\",\n                    \"v\": \"19\"\n                },{\n                    \"n\": \"\u540c\u6027\",\n                    \"v\": \"11\"\n                },{\n                    \"n\": \"\u8fd0\u52a8\",\n                    \"v\": \"23\"\n                },{\n                    \"n\": \"\u6b4c\u821e\",\n                    \"v\": \"28\"\n                },{\n                    \"n\": \"\u897f\u90e8\",\n                    \"v\": \"24\"\n                },{\n                    \"n\": \"\u53e4\u88c5\",\n                    \"v\": \"22\"\n                },{\n                    \"n\": \"\u77ed\u7247\",\n                    \"v\": \"35\"\n                },{\n                    \"n\": \"\u9ed1\u8272\u7535\u5f71\",\n                    \"v\": \"52\"\n                }\n\t\t\t\t\n            ]\n        },{\n            \"key\": \"area\",\n            \"name\": \"\u5730\u533a\",\n            \"value\": [{\n                    \"n\": \"\u5730\u533a\",\n                    \"v\": \"\"\n                }, {\n                    \"n\": \"\u5927\u9646\u53f0\u6e7e\",\n                    \"v\": \"64347\"\n                }, {\n                    \"n\": \"\u9999\u6e2f\",\n                    \"v\": \"3194\"\n                }, {\n                    \"n\": \"\u5fb7\u56fd\",\n                    \"v\": \"2722\"\n                }, {\n                    \"n\": \"\u65e5\u672c\",\n                    \"v\": \"11358\"\n                }, {\n                    \"n\": \"\u97e9\u56fd\",\n                    \"v\": \"11871\"\n                }, {\n                    \"n\": \"\u7f8e\u56fd\u82f1\u56fd\",\n                    \"v\": \"9937\"\n                },{\n                    \"n\": \"\u4fc4\u56fd\",\n                    \"v\": \"8938\"\n                }, {\n                    \"n\": \"\u897f\u73ed\u7259\",\n                    \"v\": \"3222\"\n                }, {\n                    \"n\": \"\u6cd5\u56fd\",\n                    \"v\": \"838\"\n                }, {\n                    \"n\": \"\u610f\u5927\u5229\",\n                    \"v\": \"41930\"\n                }\n            ]\n        }, {\n            \"key\": \"year\",\n            \"name\": \"\u5e74\u4efd\",\n            \"value\": [{\n                    \"n\": \"\u5e74\u4efd\",\n                    \"v\": \"\"\n                }, {\n                    \"n\": \"2026\",\n                    \"v\": \"65072\"\n                },{\n                    \"n\": \"2025\",\n                    \"v\": \"64935\"\n                },  {\n                    \"n\": \"2024\",\n                    \"v\": \"64427\"\n                }, {\n                    \"n\": \"2023\",\n                    \"v\": \"64344\"\n                }, {\n                    \"n\": \"2022\",\n                    \"v\": \"63723\"\n                }, {\n                    \"n\": \"2021\",\n                    \"v\": \"47104\"\n                }, {\n                    \"n\": \"2020\",\n                    \"v\": \"2708\"\n                }, {\n                    \"n\": \"2019\",\n                    \"v\": \"247\"\n                }, {\n                    \"n\": \"2018\",\n                    \"v\": \"232\"\n                }, {\n                    \"n\": \"2017\",\n                    \"v\": \"113\"\n                }, {\n                    \"n\": \"2016\",\n                    \"v\": \"387\"\n                }, {\n                    \"n\": \"2015\",\n                    \"v\": \"120\"\n                }, {\n                    \"n\": \"2014\",\n                    \"v\": \"87\"\n                }, {\n                    \"n\": \"2013\",\n                    \"v\": \"29\"\n                }, {\n                    \"n\": \"2012\",\n                    \"v\": \"61\"\n                }, {\n                    \"n\": \"2011\",\n                    \"v\": \"24\"\n                }, {\n                    \"n\": \"2010\",\n                    \"v\": \"62\"\n                }\n            ]\n        }, {\n            \"key\": \"by\",\n            \"name\": \"\u6392\u5e8f\",\n            \"value\": [{\n                    \"n\": \"\u6392\u5e8f\",\n                    \"v\": \"\"\n                }, {\n                    \"n\": \"\u6700\u65b0\",\n                    \"v\": \"update\"\n                }, {\n                    \"n\": \"\u4eba\u6c14\",\n                    \"v\": \"view\"\n                }, {\n                    \"n\": \"\u8bc4\u5206\",\n                    \"v\": \"score\"\n                }\n            ]\n        }\n    ],\n\t//\u5267\u96c6\n    \"3\": [{\n            \"key\": \"type\",\n            \"name\": \"\u7c7b\u578b\",\n            \"value\": [{\n                    \"n\": \"\u7c7b\u578b\",\n                    \"v\": \"\"\n                }, {\n                    \"n\": \"\u5267\u60c5\",\n                    \"v\": \"33\"\n                }, {\n                    \"n\": \"\u559c\u5267\",\n                    \"v\": \"39\"\n                }, {\n                    \"n\": \"\u6b66\u4fa0\",\n                    \"v\": \"99\"\n                },{\n                    \"n\": \"\u60ca\u609a\",\n                    \"v\": \"37\"\n                }, {\n                    \"n\": \"\u52a8\u4f5c\",\n                    \"v\": \"36\"\n                }, {\n                    \"n\": \"\u7231\u60c5\",\n                    \"v\": \"58\"\n                }, {\n                    \"n\": \"\u72af\u7f6a\",\n                    \"v\": \"34\"\n                }, {\n                    \"n\": \"\u6050\u6016\",\n                    \"v\": \"56\"\n                }, {\n                    \"n\": \"\u60ac\u7591\",\n                    \"v\": \"38\"\n                }, {\n                    \"n\": \"\u5192\u9669\",\n                    \"v\": \"42\"\n                },{\n                    \"n\": \"\u79d1\u5e7b\",\n                    \"v\": \"55\"\n                },{\n                    \"n\": \"\u5947\u5e7b\",\n                    \"v\": \"41\"\n                },{\n                    \"n\": \"\u7eaa\u5f55\u7247\",\n                    \"v\": \"63\"\n                },{\n                    \"n\": \"\u4f20\u8bb0\",\n                    \"v\": \"40\"\n                },{\n                    \"n\": \"\u5bb6\u5ead\",\n                    \"v\": \"57\"\n                },{\n                    \"n\": \"\u6218\u4e89\",\n                    \"v\": \"61\"\n                },{\n                    \"n\": \"\u5386\u53f2\",\n                    \"v\": \"60\"\n                },{\n                    \"n\": \"\u97f3\u4e50\",\n                    \"v\": \"65\"\n                },{\n                    \"n\": \"\u540c\u6027\",\n                    \"v\": \"75\"\n                },{\n                    \"n\": \"\u8fd0\u52a8\",\n                    \"v\": \"87\"\n                },{\n                    \"n\": \"\u6b4c\u821e\",\n                    \"v\": \"79\"\n                },{\n                    \"n\": \"\u897f\u90e8\",\n                    \"v\": \"76\"\n                },{\n                    \"n\": \"\u53e4\u88c5\",\n                    \"v\": \"88\"\n                },{\n                    \"n\": \"\u77ed\u7247\",\n                    \"v\": \"64\"\n                },{\n                    \"n\": \"\u771f\u4eba\u79c0\",\n                    \"v\": \"66\"\n                }\n\t\t\t\t\n            ]\n        },{\n            \"key\": \"area\",\n            \"name\": \"\u5730\u533a\",\n            \"value\": [{\n                    \"n\": \"\u5730\u533a\",\n                    \"v\": \"\"\n                }, {\n                    \"n\": \"\u5927\u9646\u53f0\u6e7e\",\n                    \"v\": \"64362\"\n                }, {\n                    \"n\": \"\u9999\u6e2f\",\n                    \"v\": \"13567\"\n                }, {\n                    \"n\": \"\u5fb7\u56fd\",\n                    \"v\": \"18156\"\n                }, {\n                    \"n\": \"\u65e5\u672c\",\n                    \"v\": \"26544\"\n                }, {\n                    \"n\": \"\u97e9\u56fd\",\n                    \"v\": \"22290\"\n                }, {\n                    \"n\": \"\u7f8e\u56fd\u82f1\u56fd\",\n                    \"v\": \"8783\"\n                },{\n                    \"n\": \"\u6cf0\u56fd\",\n                    \"v\": \"45186\"\n                }, {\n                    \"n\": \"\u897f\u73ed\u7259\",\n                    \"v\": \"4962\"\n                }, {\n                    \"n\": \"\u6cd5\u56fd\",\n                    \"v\": \"25453\"\n                }, {\n                    \"n\": \"\u610f\u5927\u5229\",\n                    \"v\": \"64464\"\n                }\n            ]\n        }, {\n            \"key\": \"year\",\n            \"name\": \"\u5e74\u4efd\",\n            \"value\": [{\n                    \"n\": \"\u5e74\u4efd\",\n                    \"v\": \"\"\n                }, {\n                    \"n\": \"2026\",\n                    \"v\": \"65072\"\n                },{\n                    \"n\": \"2025\",\n                    \"v\": \"64938\"\n                },  {\n                    \"n\": \"2024\",\n                    \"v\": \"64343\"\n                }, {\n                    \"n\": \"2023\",\n                    \"v\": \"64419\"\n                }, {\n                    \"n\": \"2022\",\n                    \"v\": \"64257\"\n                }, {\n                    \"n\": \"2021\",\n                    \"v\": \"86828\"\n                }, {\n                    \"n\": \"2020\",\n                    \"v\": \"7176\"\n                }, {\n                    \"n\": \"2019\",\n                    \"v\": \"3289\"\n                }, {\n                    \"n\": \"2018\",\n                    \"v\": \"3059\"\n                }, {\n                    \"n\": \"2017\",\n                    \"v\": \"3364\"\n                }, {\n                    \"n\": \"2016\",\n                    \"v\": \"2891\"\n                }, {\n                    \"n\": \"2015\",\n                    \"v\": \"1676\"\n                }, {\n                    \"n\": \"2014\",\n                    \"v\": \"1673\"\n                }, {\n                    \"n\": \"2013\",\n                    \"v\": \"1670\"\n                }, {\n                    \"n\": \"2012\",\n                    \"v\": \"1687\"\n                }, {\n                    \"n\": \"2011\",\n                    \"v\": \"3182\"\n                }, {\n                    \"n\": \"2010\",\n                    \"v\": \"3185\"\n                }\n            ]\n        }, {\n            \"key\": \"by\",\n            \"name\": \"\u6392\u5e8f\",\n            \"value\": [{\n                    \"n\": \"\u6392\u5e8f\",\n                    \"v\": \"\"\n                }, {\n                    \"n\": \"\u6700\u65b0\",\n                    \"v\": \"update\"\n                }, {\n                    \"n\": \"\u4eba\u6c14\",\n                    \"v\": \"view\"\n                }, {\n                    \"n\": \"\u8bc4\u5206\",\n                    \"v\": \"score\"\n                }\n            ]\n        }\n    ],\n    \"2\": [{\n            \"key\": \"type\",\n            \"name\": \"\u7c7b\u578b\",\n            \"value\": [{\n                    \"n\": \"\u7c7b\u578b\",\n                    \"v\": \"\"\n                }, {\n                    \"n\": \"\u52a8\u753b\",\n                    \"v\": \"25\"\n                },{\n                    \"n\": \"\u5267\u60c5\",\n                    \"v\": \"30\"\n                }, {\n                    \"n\": \"\u559c\u5267\",\n                    \"v\": \"29\"\n                }, {\n                    \"n\": \"\u60ca\u609a\",\n                    \"v\": \"59\"\n                }, {\n                    \"n\": \"\u52a8\u4f5c\",\n                    \"v\": \"50\"\n                }, {\n                    \"n\": \"\u7231\u60c5\",\n                    \"v\": \"48\"\n                }, {\n                    \"n\": \"\u72af\u7f6a\",\n                    \"v\": \"69\"\n                }, {\n                    \"n\": \"\u6050\u6016\",\n                    \"v\": \"67\"\n                }, {\n                    \"n\": \"\u60ac\u7591\",\n                    \"v\": \"54\"\n                }, {\n                    \"n\": \"\u5192\u9669\",\n                    \"v\": \"27\"\n                },{\n                    \"n\": \"\u79d1\u5e7b\",\n                    \"v\": \"53\"\n                },{\n                    \"n\": \"\u5947\u5e7b\",\n                    \"v\": \"26\"\n                },{\n                    \"n\": \"\u513f\u7ae5\",\n                    \"v\": \"32\"\n                },{\n                    \"n\": \"\u4f20\u8bb0\",\n                    \"v\": \"80\"\n                },{\n                    \"n\": \"\u5bb6\u5ead\",\n                    \"v\": \"31\"\n                },{\n                    \"n\": \"\u6218\u4e89\",\n                    \"v\": \"70\"\n                },{\n                    \"n\": \"\u5386\u53f2\",\n                    \"v\": \"68\"\n                },{\n                    \"n\": \"\u97f3\u4e50\",\n                    \"v\": \"47\"\n                },{\n                    \"n\": \"\u540c\u6027\",\n                    \"v\": \"90\"\n                },{\n                    \"n\": \"\u8fd0\u52a8\",\n                    \"v\": \"62\"\n                },{\n                    \"n\": \"\u6b4c\u821e\",\n                    \"v\": \"49\"\n                },{\n                    \"n\": \"\u53e4\u88c5\",\n                    \"v\": \"94\"\n                },{\n                    \"n\": \"\u77ed\u7247\",\n                    \"v\": \"51\"\n                }\t\t\t\t\n            ]\n        },{\n            \"key\": \"area\",\n            \"name\": \"\u5730\u533a\",\n            \"value\": [{\n                    \"n\": \"\u5168\u90e8\",\n                    \"v\": \"\"\n                }, {\n                    \"n\": \"\u5927\u9646\u53f0\u6e7e\",\n                    \"v\": \"64433\"\n                }, {\n                    \"n\": \"\u9999\u6e2f\",\n                    \"v\": \"26475\"\n                }, {\n                    \"n\": \"\u6cd5\u56fd\",\n                    \"v\": \"22281\"\n                }, {\n                    \"n\": \"\u65e5\u672c\",\n                    \"v\": \"24476\"\n                }, {\n                    \"n\": \"\u8461\u8404\u7259\",\n                    \"v\": \"64474\"\n                }, {\n                    \"n\": \"\u7f8e\u56fd\u82f1\u56fd\",\n                    \"v\": \"64425\"\n                }, {\n                    \"n\": \"\u5fb7\u56fd\",\n                    \"v\": \"50478\"\n                }, {\n                    \"n\": \"\u897f\u73ed\u7259\",\n                    \"v\": \"64470\"\n                }, {\n                    \"n\": \"\u610f\u5927\u5229\",\n                    \"v\": \"64473\"\n                }\n            ]\n        }, {\n            \"key\": \"year\",\n            \"name\": \"\u5e74\u4efd\",\n            \"value\": [{\n                    \"n\": \"\u5e74\u4efd\",\n                    \"v\": \"\"\n                }, {\n                    \"n\": \"2026\",\n                    \"v\": \"65072\"\n                },{\n                    \"n\": \"2025\",\n                    \"v\": \"64919\"\n                },  {\n                    \"n\": \"2024\",\n                    \"v\": \"64424\"\n                }, {\n                    \"n\": \"2023\",\n                    \"v\": \"64422\"\n                }, {\n                    \"n\": \"2022\",\n                    \"v\": \"64471\"\n                }, {\n                    \"n\": \"2021\",\n                    \"v\": \"48778\"\n                }, {\n                    \"n\": \"2020\",\n                    \"v\": \"12981\"\n                }, {\n                    \"n\": \"2019\",\n                    \"v\": \"2683\"\n                }, {\n                    \"n\": \"2018\",\n                    \"v\": \"3071\"\n                }, {\n                    \"n\": \"2017\",\n                    \"v\": \"4812\"\n                }, {\n                    \"n\": \"2016\",\n                    \"v\": \"2632\"\n                }, {\n                    \"n\": \"2015\",\n                    \"v\": \"740\"\n                }, {\n                    \"n\": \"2014\",\n                    \"v\": \"1482\"\n                }, {\n                    \"n\": \"2013\",\n                    \"v\": \"2620\"\n                }, {\n                    \"n\": \"2012\",\n                    \"v\": \"2662\"\n                }, {\n                    \"n\": \"2011\",\n                    \"v\": \"2676\"\n                }, {\n                    \"n\": \"2010\",\n                    \"v\": \"5603\"\n                }\n            ]\n        }, {\n            \"key\": \"by\",\n            \"name\": \"\u6392\u5e8f\",\n            \"value\": [{\n                    \"n\": \"\u6392\u5e8f\",\n                    \"v\": \"\"\n                }, {\n                    \"n\": \"\u6700\u65b0\",\n                    \"v\": \"update\"\n                }, {\n                    \"n\": \"\u4eba\u6c14\",\n                    \"v\": \"view\"\n                }, {\n                    \"n\": \"\u8bc4\u5206\",\n                    \"v\": \"score\"\n                }\n            ]\n        }\n    ]\n}\n";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0645\u0646\u0637\ufeb9(Object object) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() < 0) return null;
        return DC.q((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File \u0647\ufea9\u0643\ufeed() {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() >= 0) return null;
        return Pan.getPlayModeFilesDir();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u064a\u0644\u0639\ufe99(String object) {
        int n2 = 0;
        String string = "";
        String string2 = "";
        int n3 = 0;
        while (true) {
            if (n3 >= 15) break;
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
        n3 = 0;
        while (true) {
            if (n3 >= n4) break;
            object[n3] = (byte)(object[n3] ^ string2.charAt(n3 % n5));
            ++n3;
        }
        n3 = n2;
        while (n3 < ((Object)object).length) {
            n3 = "".length() + 1;
        }
        return new String((byte[])object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufe8f\ufee9\u062a\ufeb5(Object object, Object object2, Object object3) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() <= 0) return null;
        return ((Kanqiu)((Object)object)).matcher((String)object2, (String)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Set \ufe9d\u062f\ufed5\ufed9(Object set) {
        if (\u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634() >= 0) return null;
        return ((Map)((Object)set)).keySet();
    }

    public static int \ufea1\u0633\u0646\u0627(Object object) {
        return object.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufebd\u0630\ufeed\u063a(Object list) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() > 0) return null;
        return Collections.singletonList(list);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \ufebd\u0633\u0635\ufead(Object object) {
        if (\ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640() >= 0) return null;
        return ((i3)object).G;
    }

    public static int \ufebd\ufe8f\u0635\u0647() {
        return 0x22C ^ \u0641\ufeb5\ufeb1\ufee1.\u0646\u0633\u0647\u062b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] \ufec1\ufeb9\u0644\u064a(Object object, Object object2) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() > 0) return null;
        return ((MessageDigest)object).digest((byte[])object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Jr \ufec1\ufed5\ufebd\ufea9(Object object, Object object2, Object object3) {
        if (\ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f() <= 0) return null;
        return Bo.Gc((String)object, (Map)object2, (Map)object3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ScheduledExecutorService \ufecd\u064a\ufec5\u0638(int n2) {
        if (\ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646() >= 0) return null;
        return Executors.newScheduledThreadPool(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static List \ufed5\ufeb9\u0627\ufea9(Object list) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() <= 0) return null;
        return ((tX)((Object)list)).M();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \ufedd\ufec1\ufea5\u0637() {
        if (\ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9() >= 0) return null;
        return "\u8bbe\u7f6eCK\u6210\u529f";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int \ufee9\ufe8e\ufe99\u0631(Object object) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() <= 0) return 0;
        return ((AbstractCollection)object).size();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Editable \ufeed\u0638\u0641\u0636(Object object) {
        if (\u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d() > 0) return null;
        return ((EditText)object).getText();
    }
}

