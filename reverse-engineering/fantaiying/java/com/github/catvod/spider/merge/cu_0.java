/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.rz;
import java.util.List;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Renamed from com.github.catvod.spider.merge.cU
 */
public final class cu_0 {
    public final String yq(List<String> list) {
        ExecutorService executorService = Executors.newFixedThreadPool(list.size());
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executorService);
        Object object = list.iterator();
        while (object.hasNext()) {
            executorCompletionService.submit(new rz(this, object.next()));
        }
        for (int i2 = 0; i2 < list.size(); ++i2) {
            try {
                yq yq2 = (yq)executorCompletionService.take().get();
                if (yq2.yq().contains("\u73a9\u5076")) {
                    return yq2.SN();
                }
                object = yq2.yq();
                if (((String)object).isEmpty() || ((String)object).contains("404 Not Found") || ((String)object).contains("400 Bad Request")) continue;
                object = yq2.SN();
                return object;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        executorService.shutdown();
        return "";
    }

    private static final class yq {
        private String SN;
        private String yq;

        public yq(String string, String string2) {
            this.yq = string;
            this.SN = string2;
        }

        public final String SN() {
            return this.yq;
        }

        public final String yq() {
            return this.SN;
        }
    }
}

