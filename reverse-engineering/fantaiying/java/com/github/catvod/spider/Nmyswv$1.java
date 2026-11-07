/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.os.Build$VERSION
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package com.github.catvod.spider;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.PrintStream;

class Nmyswv$1
extends WebViewClient {
    @TargetApi(value=19)
    public void onPageFinished(WebView webView, String string) {
        throw null;
    }

    public WebResourceResponse shouldInterceptRequest(WebView object, WebResourceRequest webResourceRequest) {
        int n = Build.VERSION.SDK_INT;
        object = n >= 21 ? webResourceRequest.getUrl().toString() : null;
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SIRequest URL: ");
        stringBuilder.append((String)object);
        printStream.println(stringBuilder.toString());
        object = n >= 21 ? webResourceRequest.getRequestHeaders() : null;
        object = (String)object.get("Referer");
        throw null;
    }
}

