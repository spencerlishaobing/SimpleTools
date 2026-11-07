/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.rN;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONObject;

public class JsonParallel {
    /*
     * Unable to fully structure code
     */
    public static JSONObject parse(LinkedHashMap<String, String> var0, String var1_3) {
        if (var0.isEmpty()) {
            return new JSONObject();
        }
        var5_5 = Executors.newFixedThreadPool(3);
        var6_6 = new ExecutorCompletionService<V>(var5_5);
        var7_7 = new ArrayList<Future<V>>();
        for (String var9_9 : var0.keySet()) {
            var7_7.add(var6_6.submit(new rN(var0.get(var9_9), (String)var1_3, var9_9)));
        }
        var0 = null;
        var2_10 = 0;
        block10: while (true) {
            block16: {
                var1_3 = var0;
                if (var2_10 >= var7_7.size()) break;
                var1_3 = (JSONObject)var6_6.take().get();
                if (var1_3 == null) break block16;
                Bo.yq();
                var3_11 = 0;
                while (true) {
                    var4_12 = var7_7.size();
                    if (var3_11 >= var4_12) break;
                    try {
                        ((Future)var7_7.get(var3_11)).cancel(true);
                    }
                    catch (Exception var0_1) {
                        SpiderDebug.log((Throwable)var0_1);
                    }
                    ++var3_11;
                }
                var7_7.clear();
                break;
            }
lbl38:
            // 2 sources

            while (true) {
                var0 = var1_3;
lbl40:
                // 2 sources

                while (true) {
                    ++var2_10;
                    continue block10;
                    break;
                }
                break;
            }
            break;
        }
        var5_5.shutdownNow();
        if (var1_3 == null) {
            var1_3 = new JSONObject();
        }
        return var1_3;
        catch (Exception var1_4) {
            ** continue;
        }
        {
            catch (Exception var0_2) {
                ** continue;
            }
        }
    }
}

