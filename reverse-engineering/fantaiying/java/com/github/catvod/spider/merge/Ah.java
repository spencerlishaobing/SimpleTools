/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Call
 *  okhttp3.Response
 */
package com.github.catvod.spider.merge;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Response;

public abstract class Ah<T> {
    private T yq = null;

    protected final void SN(T t) {
        this.yq = t;
    }

    public T getResult() {
        return this.yq;
    }

    protected void onError(Call call, Exception exception) {
        this.onFailure(call, exception);
    }

    protected abstract void onFailure(Call var1, Exception var2);

    protected abstract T onParseResponse(Call var1, Response var2);

    protected abstract void onResponse(T var1);

    protected final void yq(Call object, Response response) {
        object = this.onParseResponse((Call)object, response);
        this.yq = object;
        this.onResponse(object);
    }

    public static abstract class SN
    extends Ah<String> {
        @Override
        public void onError(Call call, Exception exception) {
            this.SN("");
            this.onFailure(call, exception);
        }

        @Override
        public String onParseResponse(Call object, Response response) {
            try {
                object = response.body().string();
                return object;
            }
            catch (IOException iOException) {
                return "";
            }
        }
    }

    public static abstract class yq
    extends Ah<Response> {
        @Override
        public Response onParseResponse(Call call, Response response) {
            return response;
        }
    }
}

