/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.SpiderDebug
 *  okhttp3.Call
 *  okhttp3.Response
 */
package com.github.catvod.spider.merge;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.Ah;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Response;

final class RS
extends Ah<Response> {
    final Map SN;

    RS(Map map) {
        this.SN = map;
    }

    @Override
    public final void onFailure(Call call, Exception exception) {
        this.SN(null);
        SpiderDebug.log((Throwable)exception);
    }

    @Override
    public final Object onParseResponse(Call call, Response response) {
        block3: {
            Map map = this.SN;
            call = response;
            if (map == null) break block3;
            try {
                map.clear();
                this.SN.putAll(response.headers().toMultimap());
                call = response;
            }
            catch (Exception exception) {
                call = null;
            }
        }
        return call;
    }
}

