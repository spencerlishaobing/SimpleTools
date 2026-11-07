/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  com.github.catvod.crawler.SpiderDebug
 *  okhttp3.MediaType
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.RequestBody
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.util.Base64;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.w2;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

public final class J7 {
    public static String N(String object, String string, int n2) {
        block8: {
            String string2;
            block7: {
                string2 = "";
                if (string == null) {
                    return "";
                }
                if (!((String)object).isEmpty()) break block7;
                return "";
            }
            object = Pattern.compile((String)object).matcher(string);
            if (!((Matcher)object).find() || n2 < 0) break block8;
            try {
                if (n2 <= ((Matcher)object).groupCount()) {
                    if ((object = ((Matcher)object).group(n2)) == null) {
                        object = string2;
                    }
                    return object;
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return "";
    }

    public static String SN(String string) {
        return J7.N("\\d+", string, 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static JSONObject yq() {
        try {
            Object object = new Request.Builder();
            object = object.url("https://45.150.165.226/include/vdimgck.php").addHeader("User-Agent", "Mozilla/5.0 (X11; Linux aarch64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36").build();
            Object object2 = w2.yq(0).newCall((Request)object).execute();
            object = object2.headers().get("set-cookie");
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append("set-cookie--");
            ((StringBuilder)object3).append((String)object);
            SpiderDebug.log((String)((StringBuilder)object3).toString());
            object3 = object2.body().byteStream();
            object2 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int n2;
                if ((n2 = ((InputStream)object3).read((byte[])object2)) == -1) {
                    object3 = Base64.encodeToString((byte[])byteArrayOutputStream.toByteArray(), (int)0);
                    object2 = RequestBody.create((MediaType)MediaType.parse((String)"text/plain; charset=utf-8"), (String)object3);
                    object3 = new Request.Builder();
                    object3 = object3.url("https://api.nn.ci/ocr/b64/text").post((RequestBody)object2).addHeader("User-Agent", "Mozilla/5.0 (X11; Linux aarch64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36").build();
                    object3 = w2.yq(0).newCall((Request)object3).execute().body().string();
                    object2 = new JSONObject();
                    object2.put("cookie", object);
                    object2.put("code", object3);
                    return object2;
                }
                byteArrayOutputStream.write((byte[])object2, 0, n2);
            }
        }
        catch (Exception exception) {
            return null;
        }
    }
}

